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
import com.baidu.tbadk.core.util.ap;
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
    private BdListView WO;
    private int Yh;
    private View.OnTouchListener bST;
    private CustomMessageListener faJ;
    private PbListView gAw;
    private int gzf;
    private boolean hvI;
    private a.InterfaceC0711a iFs;
    private com.baidu.tieba.f.a jKU;
    private int jiE;
    private boolean jjo;
    public com.baidu.tieba.lego.b.a kZH;
    private boolean kZT;
    private boolean kZU;
    private boolean kZV;
    private boolean kZW;
    private d kZX;
    private com.baidu.tbadk.l.g kZY;
    private g kZZ;
    private com.baidu.tieba.lego.c.e laa;
    private com.baidu.tieba.lego.c.c lab;
    private n lac;
    private boolean lad;
    private CustomMessageListener lae;
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
        this.kZT = false;
        this.jiE = 0;
        this.gzf = 0;
        this.lad = false;
        this.faJ = new CustomMessageListener(CmdConfigCustom.CMD_UPDATE_ATTENTION) { // from class: com.baidu.tieba.lego.LegoListView.1
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
                    bVar.ePK = true;
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
                    bVar.ePK = false;
                    LegoListView.this.aM(bVar);
                }
            }
        };
        this.lae = new CustomMessageListener(CmdConfigCustom.CMD_LEGO_SWITCH_TAB_FROM_POP_WINDOW) { // from class: com.baidu.tieba.lego.LegoListView.4
            /* JADX DEBUG: Method merged with bridge method */
            @Override // com.baidu.adp.framework.listener.MessageListener
            public void onMessage(CustomResponsedMessage<?> customResponsedMessage) {
                if (customResponsedMessage != null) {
                    LegoListView.this.lad = true;
                }
            }
        };
        this.iFs = new a.InterfaceC0711a() { // from class: com.baidu.tieba.lego.LegoListView.6
            @Override // com.baidu.tieba.f.a.InterfaceC0711a
            public void G(int i, int i2) {
                LegoListView.this.jjo = false;
                LegoListView.this.kZH.tF(LegoListView.this.jjo);
            }

            @Override // com.baidu.tieba.f.a.InterfaceC0711a
            public void H(int i, int i2) {
                LegoListView.this.jjo = true;
                LegoListView.this.kZH.tF(LegoListView.this.jjo);
            }

            @Override // com.baidu.tieba.f.a.InterfaceC0711a
            public void ch(int i, int i2) {
            }

            @Override // com.baidu.tieba.f.a.InterfaceC0711a
            public void I(int i, int i2) {
            }
        };
        this.bST = new View.OnTouchListener() { // from class: com.baidu.tieba.lego.LegoListView.7
            @Override // android.view.View.OnTouchListener
            public boolean onTouch(View view, MotionEvent motionEvent) {
                if (view == LegoListView.this.WO && LegoListView.this.jKU != null) {
                    LegoListView.this.jKU.onTouchEvent(motionEvent);
                    return false;
                }
                return false;
            }
        };
        init(context, z);
    }

    public void setImmersive(boolean z) {
        this.kZT = z;
    }

    /* JADX INFO: Access modifiers changed from: private */
    public void aM(Object obj) {
        boolean z;
        if (this.kZH != null && this.lab != null && this.lab.dcN() != null) {
            boolean z2 = false;
            Iterator<ICardInfo> it = this.lab.dcN().iterator();
            while (true) {
                z = z2;
                if (!it.hasNext()) {
                    break;
                }
                z2 = it.next().responseAttention(obj) ? true : z;
            }
            if (z) {
                this.kZH.notifyDataSetChanged();
            }
        }
    }

    private void init(Context context, boolean z) {
        com.baidu.adp.base.f<?> K = com.baidu.adp.base.j.K(context);
        K.registerListener(this.faJ);
        K.registerListener(this.mLikeForumListener);
        K.registerListener(this.mUnlikeForumListener);
        if (K instanceof TbPageContext) {
            this.pageContext = (TbPageContext) K;
        }
        this.WO = new BdListView(context);
        this.WO.setDividerHeight(0);
        this.WO.setSelector(17170445);
        addView(this.WO);
        if (!z) {
            this.WO.setVerticalScrollBarEnabled(true);
            initUI(context);
        } else {
            this.WO.setTranscriptMode(1);
            this.WO.setVerticalScrollBarEnabled(false);
        }
        this.WO.setOnSrollToBottomListener(this);
        this.WO.setOnScrollListener(this);
        dbo();
        this.kZH = new com.baidu.tieba.lego.b.a(this.pageContext);
        this.WO.setAdapter((ListAdapter) this.kZH);
        this.Yh = TbadkCoreApplication.getInst().getResources().getDimensionPixelSize(R.dimen.ds120);
        onChangeSkinType(TbadkCoreApplication.getInst().getSkinType());
    }

    public BdListView getListView() {
        return this.WO;
    }

    public void l(BdUniqueId bdUniqueId) {
        if (bdUniqueId != null) {
            if (this.mPullView != null) {
                this.mPullView.setTag(bdUniqueId);
            }
            this.lae.setTag(bdUniqueId);
            MessageManager.getInstance().registerListener(this.lae);
        }
    }

    public void setCallback(d dVar) {
        this.kZX = dVar;
    }

    public void setScrollCallback(g gVar) {
        this.kZZ = gVar;
    }

    public void setViewBackGround() {
        qJ(true);
    }

    public n getPlaySwitchController() {
        return this.lac;
    }

    public void setViewForeground() {
        qJ(false);
        if (this.lac != null) {
            this.lac.tN(true);
            this.lac.b(this.jiE, this.gzf, this.jjo, true);
        }
        if (!this.kZW && !this.kZV) {
            if (this.kZU && !com.baidu.adp.lib.util.l.isNetOk()) {
                if (this.kZH.isEmpty()) {
                    this.kZH.a(NoDataViewFactory.c.a(NoDataViewFactory.ImgType.NODATA, this.Yh), NoDataViewFactory.d.pz(R.string.neterror), null, null);
                    this.kZH.notifyDataSetChanged();
                }
            } else if (this.lad) {
                this.lad = false;
                com.baidu.adp.lib.f.e.mA().postDelayed(new Runnable() { // from class: com.baidu.tieba.lego.LegoListView.5
                    @Override // java.lang.Runnable
                    public void run() {
                        LegoListView.this.dbn();
                    }
                }, 200L);
            } else {
                dbn();
            }
        }
    }

    public void onDestory() {
        if (this.lac != null) {
            this.lac.destroy();
        }
    }

    /* JADX INFO: Access modifiers changed from: private */
    public void dbn() {
        b(this, false, getResources().getDimensionPixelSize(R.dimen.ds300));
        startLoad();
    }

    private void initUI(Context context) {
        this.mPullView = new com.baidu.tbadk.core.view.g(this.pageContext);
        this.WO.setPullRefresh(this.mPullView);
        this.gAw = new PbListView(context);
        this.gAw.createView();
        this.gAw.setContainerBackgroundColorResId(R.color.CAM_X0204);
        this.gAw.setTextColor(ap.getColor(R.color.CAM_X0109));
        this.gAw.changeSkin(TbadkCoreApplication.getInst().getSkinType());
        this.mPullView.setListPullRefreshListener(new a());
    }

    private void dbo() {
        this.lac = new n(this.pageContext, this.WO);
        this.jKU = new com.baidu.tieba.f.a();
        this.jKU.a(this.iFs);
        this.WO.setOnTouchListener(this.bST);
        this.WO.setRecyclerListener(new AbsListView.RecyclerListener() { // from class: com.baidu.tieba.lego.LegoListView.8
            @Override // android.widget.AbsListView.RecyclerListener
            public void onMovedToScrapHeap(View view) {
                if (LegoListView.this.lac != null) {
                    LegoListView.this.lac.dt(view);
                }
            }
        });
    }

    public void a(com.baidu.tieba.lego.c.c cVar, boolean z) {
        if (this.WO != null) {
            this.WO.completePullRefresh();
        }
        if (this.gAw != null) {
            this.gAw.endLoadData();
        }
        if (cVar == null) {
            setHasMore(false);
            dq(this);
            this.kZH.a(NoDataViewFactory.c.a(NoDataViewFactory.ImgType.NODATA, this.Yh), NoDataViewFactory.d.pz(R.string.invite_friend_no_data_now), null, null);
            this.kZH.notifyDataSetChanged();
            return;
        }
        this.lab = cVar;
        this.hvI = false;
        this.kZV = cVar.dcQ();
        this.kZU = cVar.dcP();
        this.kZW = cVar.dcW();
        this.laa = cVar.dcR();
        setHasMore(cVar.hasMore());
        List<ICardInfo> dcN = cVar.dcN();
        if (this.kZH != null) {
            if (dcN == null || dcN.size() <= 0) {
                if (this.kZU && this.kZV) {
                    this.kZH.a(NoDataViewFactory.c.a(NoDataViewFactory.ImgType.NODATA, this.Yh), NoDataViewFactory.d.pz(R.string.invite_friend_no_data_now), null, null);
                } else {
                    this.kZH.a(null, null, null, null);
                }
                setHasMore(false);
            } else if (this.gAw != null) {
                if (this.gAw.getView().getParent() == null) {
                    this.WO.setNextPage(this.gAw);
                }
                if (this.mHasMore) {
                    this.gAw.setText(getContext().getString(R.string.pb_load_more));
                } else if (dcN.get(dcN.size() - 1) instanceof WebViewCard) {
                    this.gAw.setText("");
                } else {
                    this.gAw.setText(getContext().getString(R.string.list_no_more));
                }
            }
            this.kZH.eK(dcN);
        }
        if (z) {
            this.WO.setSelection(cVar.dcO());
        }
        if (this.kZV || (dcN != null && !dcN.isEmpty())) {
            dq(this);
        }
    }

    private void setHasMore(boolean z) {
        this.mHasMore = z;
        if (this.WO != null && this.gAw != null) {
            if (!this.kZU) {
                this.gAw.setText("");
            } else if (this.mHasMore) {
                this.gAw.setText(getContext().getString(R.string.pb_load_more));
            } else {
                this.gAw.setText("");
            }
        }
    }

    /* JADX INFO: Access modifiers changed from: private */
    public void startLoad() {
        if (this.kZU) {
            this.kZX.c(1, this.laa.lfS, this.laa.itemId, "");
        } else {
            this.kZX.p(this.laa.lfS, this.laa.itemId);
        }
    }

    public void Nz(String str) {
        if (this.WO != null) {
            this.WO.completePullRefresh();
        }
        this.hvI = false;
        if (this.gAw != null) {
            this.gAw.endLoadData();
        }
        if (this.kZH.getCount() <= 0 && this.kZU) {
            this.kZH.a(NoDataViewFactory.c.a(NoDataViewFactory.ImgType.NODATA, this.Yh), NoDataViewFactory.d.BB(str), null, null);
            this.kZH.eK(new ArrayList());
        }
        dq(this);
    }

    @Override // android.widget.AbsListView.OnScrollListener
    public void onScroll(AbsListView absListView, int i, int i2, int i3) {
        this.jiE = i;
        this.gzf = (i + i2) - 1;
    }

    @Override // com.baidu.adp.widget.ListView.BdListView.e
    public void onScrollToBottom() {
        if (this.mHasMore && com.baidu.adp.lib.util.l.isNetOk() && !this.hvI) {
            this.hvI = true;
            if (this.gAw != null) {
                this.gAw.startLoadData();
            }
            if (this.kZX != null) {
                if (this.kZH == null) {
                    this.kZX.c(1, this.laa.lfS, this.laa.itemId, "");
                } else if (this.lab != null) {
                    this.kZX.c(this.lab.getPn() + 1, this.laa.lfS, this.laa.itemId, this.lab.dcS());
                }
            }
        }
    }

    @SuppressLint({"ResourceAsColor"})
    public void onChangeSkinType(int i) {
        com.baidu.tbadk.r.a.a(this.pageContext, this);
        ap.setBackgroundColor(this.WO, R.color.CAM_X0204, i);
        if (this.kZH != null) {
            this.kZH.notifyDataSetChanged();
        }
        if (this.mPullView != null) {
            this.mPullView.changeSkin(i);
        }
        if (this.gAw != null) {
            this.gAw.changeSkin(i);
        }
    }

    public boolean u(long j, String str) {
        return this.laa != null && j == this.laa.lfS && TextUtils.equals(str, this.laa.itemId);
    }

    @Override // android.widget.AbsListView.OnScrollListener
    public void onScrollStateChanged(AbsListView absListView, int i) {
        if (i == 0) {
            MessageManager.getInstance().dispatchResponsedMessage(new CustomResponsedMessage(CmdConfigCustom.CMD_LEGO_SWITCH_TAB, -1));
            if (this.kZZ != null && this.laa != null) {
                this.kZZ.a(this.laa, this.WO.getFirstVisiblePosition());
            }
            dbl();
        }
    }

    private void qJ(boolean z) {
        if (this.WO != null) {
            int i = 0;
            while (true) {
                int i2 = i;
                if (i2 < this.WO.getChildCount()) {
                    View childAt = this.WO.getChildAt(i2);
                    if (childAt instanceof com.baidu.tieba.lego.card.view.e) {
                        if (z) {
                            ((com.baidu.tieba.lego.card.view.e) childAt).aSW();
                        } else {
                            ((com.baidu.tieba.lego.card.view.e) childAt).cSE();
                        }
                    }
                    i = i2 + 1;
                } else {
                    return;
                }
            }
        }
    }

    private void dbl() {
        if (this.WO != null) {
            int i = 0;
            while (true) {
                int i2 = i;
                if (i2 >= this.WO.getChildCount()) {
                    break;
                }
                View childAt = this.WO.getChildAt(i2);
                if (childAt instanceof com.baidu.tieba.lego.card.view.e) {
                    ((com.baidu.tieba.lego.card.view.e) childAt).dca();
                }
                i = i2 + 1;
            }
            if (this.lac != null) {
                this.lac.a(this.jiE, this.gzf, this.jjo, 1);
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
            if (LegoListView.this.kZX != null) {
                LegoListView.this.startLoad();
            }
        }
    }

    private void b(View view, boolean z, int i) {
        if (this.kZY == null) {
            if (i < 0) {
                this.kZY = new com.baidu.tbadk.l.g(getContext());
            } else {
                this.kZY = new com.baidu.tbadk.l.g(getContext(), i);
            }
            this.kZY.onChangeSkinType();
        }
        this.kZY.attachView(view, z);
        if (this.mPullView != null) {
            this.mPullView.setEnable(false);
        }
        if (this.kZH != null) {
            this.kZH.tE(false);
            this.kZH.notifyDataSetChanged();
        }
    }

    private void dq(View view) {
        if (this.kZY != null) {
            this.kZY.dettachView(view);
            this.kZY = null;
        }
        if (this.mPullView != null) {
            this.mPullView.setEnable(true);
        }
        if (this.kZH != null) {
            this.kZH.tE(true);
            this.kZH.notifyDataSetChanged();
        }
    }

    public void setFriction(float f) {
        if (this.WO != null) {
            this.WO.setFriction(f);
        }
    }
}
