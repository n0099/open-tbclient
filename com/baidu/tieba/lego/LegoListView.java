package com.baidu.tieba.lego;

import android.annotation.SuppressLint;
import android.content.Context;
import android.text.TextUtils;
import android.view.MotionEvent;
import android.view.View;
import android.widget.AbsListView;
import android.widget.FrameLayout;
import android.widget.ListAdapter;
import com.baidu.adp.BdUniqueId;
import com.baidu.adp.framework.MessageManager;
import com.baidu.adp.framework.listener.CustomMessageListener;
import com.baidu.adp.framework.message.CustomResponsedMessage;
import com.baidu.adp.widget.ListView.BdListView;
import com.baidu.live.tbadk.core.frameworkdata.CmdConfigCustom;
import com.baidu.tbadk.TbPageContext;
import com.baidu.tbadk.core.TbadkCoreApplication;
import com.baidu.tbadk.core.util.ao;
import com.baidu.tbadk.core.view.NoDataViewFactory;
import com.baidu.tbadk.core.view.PbListView;
import com.baidu.tbadk.core.view.f;
import com.baidu.tbadk.coreExtra.message.UpdateAttentionMessage;
import com.baidu.tieba.R;
import com.baidu.tieba.f.a;
import com.baidu.tieba.lego.card.model.ICardInfo;
import com.baidu.tieba.lego.card.model.WebViewCard;
import com.baidu.tieba.lego.card.view.n;
import java.util.ArrayList;
import java.util.Iterator;
import java.util.List;
/* loaded from: classes9.dex */
public class LegoListView extends FrameLayout implements AbsListView.OnScrollListener, BdListView.e {
    private BdListView WV;
    private int Yn;
    private View.OnTouchListener bTP;
    private CustomMessageListener fdd;
    private int gAO;
    private PbListView gCf;
    private boolean hvQ;
    private a.InterfaceC0727a iEb;
    private com.baidu.tieba.f.a jJI;
    private int jhq;
    private boolean jia;
    public com.baidu.tieba.lego.b.a kVW;
    private boolean kWi;
    private boolean kWj;
    private boolean kWk;
    private boolean kWl;
    private d kWm;
    private com.baidu.tbadk.l.g kWn;
    private g kWo;
    private com.baidu.tieba.lego.c.e kWp;
    private com.baidu.tieba.lego.c.c kWq;
    private n kWr;
    private boolean kWs;
    private CustomMessageListener kWt;
    private boolean mHasMore;
    private CustomMessageListener mLikeForumListener;
    private com.baidu.tbadk.core.view.g mPullView;
    private CustomMessageListener mUnlikeForumListener;
    private TbPageContext<?> pageContext;

    public LegoListView(Context context) {
        this(context, false);
    }

    public LegoListView(Context context, boolean z) {
        super(context);
        this.kWi = false;
        this.jhq = 0;
        this.gAO = 0;
        this.kWs = false;
        this.fdd = new CustomMessageListener(CmdConfigCustom.CMD_UPDATE_ATTENTION) { // from class: com.baidu.tieba.lego.LegoListView.1
            /* JADX DEBUG: Method merged with bridge method */
            @Override // com.baidu.adp.framework.listener.MessageListener
            public void onMessage(CustomResponsedMessage<?> customResponsedMessage) {
                UpdateAttentionMessage updateAttentionMessage = (UpdateAttentionMessage) customResponsedMessage;
                if (updateAttentionMessage != null && updateAttentionMessage.getData() != null && updateAttentionMessage.getData().isSucc) {
                    LegoListView.this.aM(updateAttentionMessage.getData());
                }
            }
        };
        this.mLikeForumListener = new CustomMessageListener(CmdConfigCustom.CMD_LIKE_FORUM) { // from class: com.baidu.tieba.lego.LegoListView.2
            /* JADX DEBUG: Method merged with bridge method */
            @Override // com.baidu.adp.framework.listener.MessageListener
            public void onMessage(CustomResponsedMessage<?> customResponsedMessage) {
                if (customResponsedMessage != null && (customResponsedMessage.getData() instanceof Long)) {
                    com.baidu.tieba.lego.c.b bVar = new com.baidu.tieba.lego.c.b();
                    bVar.fid = String.valueOf(customResponsedMessage.getData());
                    bVar.eSj = true;
                    LegoListView.this.aM(bVar);
                }
            }
        };
        this.mUnlikeForumListener = new CustomMessageListener(CmdConfigCustom.CMD_UNLIKE_FORUM) { // from class: com.baidu.tieba.lego.LegoListView.3
            /* JADX DEBUG: Method merged with bridge method */
            @Override // com.baidu.adp.framework.listener.MessageListener
            public void onMessage(CustomResponsedMessage<?> customResponsedMessage) {
                if (customResponsedMessage != null && (customResponsedMessage.getData() instanceof Long)) {
                    com.baidu.tieba.lego.c.b bVar = new com.baidu.tieba.lego.c.b();
                    bVar.fid = String.valueOf(customResponsedMessage.getData());
                    bVar.eSj = false;
                    LegoListView.this.aM(bVar);
                }
            }
        };
        this.kWt = new CustomMessageListener(CmdConfigCustom.CMD_LEGO_SWITCH_TAB_FROM_POP_WINDOW) { // from class: com.baidu.tieba.lego.LegoListView.4
            /* JADX DEBUG: Method merged with bridge method */
            @Override // com.baidu.adp.framework.listener.MessageListener
            public void onMessage(CustomResponsedMessage<?> customResponsedMessage) {
                if (customResponsedMessage != null) {
                    LegoListView.this.kWs = true;
                }
            }
        };
        this.iEb = new a.InterfaceC0727a() { // from class: com.baidu.tieba.lego.LegoListView.6
            @Override // com.baidu.tieba.f.a.InterfaceC0727a
            public void G(int i, int i2) {
                LegoListView.this.jia = false;
                LegoListView.this.kVW.tw(LegoListView.this.jia);
            }

            @Override // com.baidu.tieba.f.a.InterfaceC0727a
            public void H(int i, int i2) {
                LegoListView.this.jia = true;
                LegoListView.this.kVW.tw(LegoListView.this.jia);
            }

            @Override // com.baidu.tieba.f.a.InterfaceC0727a
            public void cj(int i, int i2) {
            }

            @Override // com.baidu.tieba.f.a.InterfaceC0727a
            public void I(int i, int i2) {
            }
        };
        this.bTP = new View.OnTouchListener() { // from class: com.baidu.tieba.lego.LegoListView.7
            @Override // android.view.View.OnTouchListener
            public boolean onTouch(View view, MotionEvent motionEvent) {
                if (view == LegoListView.this.WV && LegoListView.this.jJI != null) {
                    LegoListView.this.jJI.onTouchEvent(motionEvent);
                    return false;
                }
                return false;
            }
        };
        init(context, z);
    }

    public void setImmersive(boolean z) {
        this.kWi = z;
    }

    /* JADX INFO: Access modifiers changed from: private */
    public void aM(Object obj) {
        boolean z;
        if (this.kVW != null && this.kWq != null && this.kWq.deA() != null) {
            boolean z2 = false;
            Iterator<ICardInfo> it = this.kWq.deA().iterator();
            while (true) {
                z = z2;
                if (!it.hasNext()) {
                    break;
                }
                z2 = it.next().responseAttention(obj) ? true : z;
            }
            if (z) {
                this.kVW.notifyDataSetChanged();
            }
        }
    }

    private void init(Context context, boolean z) {
        com.baidu.adp.base.f<?> K = com.baidu.adp.base.j.K(context);
        K.registerListener(this.fdd);
        K.registerListener(this.mLikeForumListener);
        K.registerListener(this.mUnlikeForumListener);
        if (K instanceof TbPageContext) {
            this.pageContext = (TbPageContext) K;
        }
        this.WV = new BdListView(context);
        this.WV.setDividerHeight(0);
        this.WV.setSelector(17170445);
        addView(this.WV);
        if (!z) {
            this.WV.setVerticalScrollBarEnabled(true);
            initUI(context);
        } else {
            this.WV.setTranscriptMode(1);
            this.WV.setVerticalScrollBarEnabled(false);
        }
        this.WV.setOnSrollToBottomListener(this);
        this.WV.setOnScrollListener(this);
        ddb();
        this.kVW = new com.baidu.tieba.lego.b.a(this.pageContext);
        this.WV.setAdapter((ListAdapter) this.kVW);
        this.Yn = TbadkCoreApplication.getInst().getResources().getDimensionPixelSize(R.dimen.ds120);
        onChangeSkinType(TbadkCoreApplication.getInst().getSkinType());
    }

    public BdListView getListView() {
        return this.WV;
    }

    public void l(BdUniqueId bdUniqueId) {
        if (bdUniqueId != null) {
            if (this.mPullView != null) {
                this.mPullView.setTag(bdUniqueId);
            }
            this.kWt.setTag(bdUniqueId);
            MessageManager.getInstance().registerListener(this.kWt);
        }
    }

    public void setCallback(d dVar) {
        this.kWm = dVar;
    }

    public void setScrollCallback(g gVar) {
        this.kWo = gVar;
    }

    public void setViewBackGround() {
        qD(true);
    }

    public n getPlaySwitchController() {
        return this.kWr;
    }

    public void setViewForeground() {
        qD(false);
        if (this.kWr != null) {
            this.kWr.tE(true);
            this.kWr.b(this.jhq, this.gAO, this.jia, true);
        }
        if (!this.kWl && !this.kWk) {
            if (this.kWj && !com.baidu.adp.lib.util.l.isNetOk()) {
                if (this.kVW.isEmpty()) {
                    this.kVW.a(NoDataViewFactory.c.a(NoDataViewFactory.ImgType.NODATA, this.Yn), NoDataViewFactory.d.ra(R.string.neterror), null, null);
                    this.kVW.notifyDataSetChanged();
                }
            } else if (this.kWs) {
                this.kWs = false;
                com.baidu.adp.lib.f.e.mB().postDelayed(new Runnable() { // from class: com.baidu.tieba.lego.LegoListView.5
                    @Override // java.lang.Runnable
                    public void run() {
                        LegoListView.this.dda();
                    }
                }, 200L);
            } else {
                dda();
            }
        }
    }

    public void onDestory() {
        if (this.kWr != null) {
            this.kWr.destroy();
        }
    }

    /* JADX INFO: Access modifiers changed from: private */
    public void dda() {
        b(this, false, getResources().getDimensionPixelSize(R.dimen.ds300));
        startLoad();
    }

    private void initUI(Context context) {
        this.mPullView = new com.baidu.tbadk.core.view.g(this.pageContext);
        this.WV.setPullRefresh(this.mPullView);
        this.gCf = new PbListView(context);
        this.gCf.createView();
        this.gCf.setContainerBackgroundColorResId(R.color.CAM_X0204);
        this.gCf.setTextColor(ao.getColor(R.color.CAM_X0109));
        this.gCf.changeSkin(TbadkCoreApplication.getInst().getSkinType());
        this.mPullView.setListPullRefreshListener(new a());
    }

    private void ddb() {
        this.kWr = new n(this.pageContext, this.WV);
        this.jJI = new com.baidu.tieba.f.a();
        this.jJI.a(this.iEb);
        this.WV.setOnTouchListener(this.bTP);
        this.WV.setRecyclerListener(new AbsListView.RecyclerListener() { // from class: com.baidu.tieba.lego.LegoListView.8
            @Override // android.widget.AbsListView.RecyclerListener
            public void onMovedToScrapHeap(View view) {
                if (LegoListView.this.kWr != null) {
                    LegoListView.this.kWr.dv(view);
                }
            }
        });
    }

    public void a(com.baidu.tieba.lego.c.c cVar, boolean z) {
        if (this.WV != null) {
            this.WV.completePullRefresh();
        }
        if (this.gCf != null) {
            this.gCf.endLoadData();
        }
        if (cVar == null) {
            setHasMore(false);
            ds(this);
            this.kVW.a(NoDataViewFactory.c.a(NoDataViewFactory.ImgType.NODATA, this.Yn), NoDataViewFactory.d.ra(R.string.invite_friend_no_data_now), null, null);
            this.kVW.notifyDataSetChanged();
            return;
        }
        this.kWq = cVar;
        this.hvQ = false;
        this.kWk = cVar.deD();
        this.kWj = cVar.deC();
        this.kWl = cVar.deJ();
        this.kWp = cVar.deE();
        setHasMore(cVar.hasMore());
        List<ICardInfo> deA = cVar.deA();
        if (this.kVW != null) {
            if (deA == null || deA.size() <= 0) {
                if (this.kWj && this.kWk) {
                    this.kVW.a(NoDataViewFactory.c.a(NoDataViewFactory.ImgType.NODATA, this.Yn), NoDataViewFactory.d.ra(R.string.invite_friend_no_data_now), null, null);
                } else {
                    this.kVW.a(null, null, null, null);
                }
                setHasMore(false);
            } else if (this.gCf != null) {
                if (this.gCf.getView().getParent() == null) {
                    this.WV.setNextPage(this.gCf);
                }
                if (this.mHasMore) {
                    this.gCf.setText(getContext().getString(R.string.pb_load_more));
                } else if (deA.get(deA.size() - 1) instanceof WebViewCard) {
                    this.gCf.setText("");
                } else {
                    this.gCf.setText(getContext().getString(R.string.list_no_more));
                }
            }
            this.kVW.eM(deA);
        }
        if (z) {
            this.WV.setSelection(cVar.deB());
        }
        if (this.kWk || (deA != null && !deA.isEmpty())) {
            ds(this);
        }
    }

    private void setHasMore(boolean z) {
        this.mHasMore = z;
        if (this.WV != null && this.gCf != null) {
            if (!this.kWj) {
                this.gCf.setText("");
            } else if (this.mHasMore) {
                this.gCf.setText(getContext().getString(R.string.pb_load_more));
            } else {
                this.gCf.setText("");
            }
        }
    }

    /* JADX INFO: Access modifiers changed from: private */
    public void startLoad() {
        if (this.kWj) {
            this.kWm.c(1, this.kWp.lcg, this.kWp.itemId, "");
        } else {
            this.kWm.o(this.kWp.lcg, this.kWp.itemId);
        }
    }

    public void NR(String str) {
        if (this.WV != null) {
            this.WV.completePullRefresh();
        }
        this.hvQ = false;
        if (this.gCf != null) {
            this.gCf.endLoadData();
        }
        if (this.kVW.getCount() <= 0 && this.kWj) {
            this.kVW.a(NoDataViewFactory.c.a(NoDataViewFactory.ImgType.NODATA, this.Yn), NoDataViewFactory.d.Cv(str), null, null);
            this.kVW.eM(new ArrayList());
        }
        ds(this);
    }

    @Override // android.widget.AbsListView.OnScrollListener
    public void onScroll(AbsListView absListView, int i, int i2, int i3) {
        this.jhq = i;
        this.gAO = (i + i2) - 1;
    }

    @Override // com.baidu.adp.widget.ListView.BdListView.e
    public void onScrollToBottom() {
        if (this.mHasMore && com.baidu.adp.lib.util.l.isNetOk() && !this.hvQ) {
            this.hvQ = true;
            if (this.gCf != null) {
                this.gCf.startLoadData();
            }
            if (this.kWm != null) {
                if (this.kVW == null) {
                    this.kWm.c(1, this.kWp.lcg, this.kWp.itemId, "");
                } else if (this.kWq != null) {
                    this.kWm.c(this.kWq.getPn() + 1, this.kWp.lcg, this.kWp.itemId, this.kWq.deF());
                }
            }
        }
    }

    @SuppressLint({"ResourceAsColor"})
    public void onChangeSkinType(int i) {
        com.baidu.tbadk.r.a.a(this.pageContext, this);
        ao.setBackgroundColor(this.WV, R.color.CAM_X0204, i);
        if (this.kVW != null) {
            this.kVW.notifyDataSetChanged();
        }
        if (this.mPullView != null) {
            this.mPullView.changeSkin(i);
        }
        if (this.gCf != null) {
            this.gCf.changeSkin(i);
        }
    }

    public boolean t(long j, String str) {
        return this.kWp != null && j == this.kWp.lcg && TextUtils.equals(str, this.kWp.itemId);
    }

    @Override // android.widget.AbsListView.OnScrollListener
    public void onScrollStateChanged(AbsListView absListView, int i) {
        if (i == 0) {
            MessageManager.getInstance().dispatchResponsedMessage(new CustomResponsedMessage(CmdConfigCustom.CMD_LEGO_SWITCH_TAB, -1));
            if (this.kWo != null && this.kWp != null) {
                this.kWo.a(this.kWp, this.WV.getFirstVisiblePosition());
            }
            dcY();
        }
    }

    private void qD(boolean z) {
        if (this.WV != null) {
            int i = 0;
            while (true) {
                int i2 = i;
                if (i2 < this.WV.getChildCount()) {
                    View childAt = this.WV.getChildAt(i2);
                    if (childAt instanceof com.baidu.tieba.lego.card.view.e) {
                        if (z) {
                            ((com.baidu.tieba.lego.card.view.e) childAt).aWE();
                        } else {
                            ((com.baidu.tieba.lego.card.view.e) childAt).cUq();
                        }
                    }
                    i = i2 + 1;
                } else {
                    return;
                }
            }
        }
    }

    private void dcY() {
        if (this.WV != null) {
            int i = 0;
            while (true) {
                int i2 = i;
                if (i2 >= this.WV.getChildCount()) {
                    break;
                }
                View childAt = this.WV.getChildAt(i2);
                if (childAt instanceof com.baidu.tieba.lego.card.view.e) {
                    ((com.baidu.tieba.lego.card.view.e) childAt).ddN();
                }
                i = i2 + 1;
            }
            if (this.kWr != null) {
                this.kWr.a(this.jhq, this.gAO, this.jia, 1);
            }
        }
    }

    /* JADX INFO: Access modifiers changed from: private */
    /* loaded from: classes9.dex */
    public class a implements f.c {
        private a() {
        }

        @Override // com.baidu.tbadk.core.view.f.c
        public void onListPullRefresh(boolean z) {
            if (LegoListView.this.kWm != null) {
                LegoListView.this.startLoad();
            }
        }
    }

    private void b(View view, boolean z, int i) {
        if (this.kWn == null) {
            if (i < 0) {
                this.kWn = new com.baidu.tbadk.l.g(getContext());
            } else {
                this.kWn = new com.baidu.tbadk.l.g(getContext(), i);
            }
            this.kWn.onChangeSkinType();
        }
        this.kWn.attachView(view, z);
        if (this.mPullView != null) {
            this.mPullView.setEnable(false);
        }
        if (this.kVW != null) {
            this.kVW.tv(false);
            this.kVW.notifyDataSetChanged();
        }
    }

    private void ds(View view) {
        if (this.kWn != null) {
            this.kWn.dettachView(view);
            this.kWn = null;
        }
        if (this.mPullView != null) {
            this.mPullView.setEnable(true);
        }
        if (this.kVW != null) {
            this.kVW.tv(true);
            this.kVW.notifyDataSetChanged();
        }
    }

    public void setFriction(float f) {
        if (this.WV != null) {
            this.WV.setFriction(f);
        }
    }
}
