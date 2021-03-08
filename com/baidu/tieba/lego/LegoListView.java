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
/* loaded from: classes8.dex */
public class LegoListView extends FrameLayout implements AbsListView.OnScrollListener, BdListView.e {
    private BdListView Yj;
    private int ZA;
    private View.OnTouchListener bUt;
    private CustomMessageListener fci;
    private int gAO;
    private PbListView gCf;
    private boolean hxr;
    private a.InterfaceC0717a iHb;
    private com.baidu.tieba.f.a jMD;
    private boolean jkX;
    private int jkn;
    public com.baidu.tieba.lego.b.a lbK;
    private boolean lbW;
    private boolean lbX;
    private boolean lbY;
    private boolean lbZ;
    private d lca;
    private com.baidu.tbadk.l.g lcb;
    private g lcc;
    private com.baidu.tieba.lego.c.e lcd;
    private com.baidu.tieba.lego.c.c lce;
    private n lcf;
    private boolean lcg;
    private CustomMessageListener lch;
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
        this.lbW = false;
        this.jkn = 0;
        this.gAO = 0;
        this.lcg = false;
        this.fci = new CustomMessageListener(CmdConfigCustom.CMD_UPDATE_ATTENTION) { // from class: com.baidu.tieba.lego.LegoListView.1
            /* JADX DEBUG: Method merged with bridge method */
            @Override // com.baidu.adp.framework.listener.MessageListener
            public void onMessage(CustomResponsedMessage<?> customResponsedMessage) {
                UpdateAttentionMessage updateAttentionMessage = (UpdateAttentionMessage) customResponsedMessage;
                if (updateAttentionMessage != null && updateAttentionMessage.getData() != null && updateAttentionMessage.getData().isSucc) {
                    LegoListView.this.aO(updateAttentionMessage.getData());
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
                    bVar.eRl = true;
                    LegoListView.this.aO(bVar);
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
                    bVar.eRl = false;
                    LegoListView.this.aO(bVar);
                }
            }
        };
        this.lch = new CustomMessageListener(CmdConfigCustom.CMD_LEGO_SWITCH_TAB_FROM_POP_WINDOW) { // from class: com.baidu.tieba.lego.LegoListView.4
            /* JADX DEBUG: Method merged with bridge method */
            @Override // com.baidu.adp.framework.listener.MessageListener
            public void onMessage(CustomResponsedMessage<?> customResponsedMessage) {
                if (customResponsedMessage != null) {
                    LegoListView.this.lcg = true;
                }
            }
        };
        this.iHb = new a.InterfaceC0717a() { // from class: com.baidu.tieba.lego.LegoListView.6
            @Override // com.baidu.tieba.f.a.InterfaceC0717a
            public void G(int i, int i2) {
                LegoListView.this.jkX = false;
                LegoListView.this.lbK.tF(LegoListView.this.jkX);
            }

            @Override // com.baidu.tieba.f.a.InterfaceC0717a
            public void H(int i, int i2) {
                LegoListView.this.jkX = true;
                LegoListView.this.lbK.tF(LegoListView.this.jkX);
            }

            @Override // com.baidu.tieba.f.a.InterfaceC0717a
            public void ch(int i, int i2) {
            }

            @Override // com.baidu.tieba.f.a.InterfaceC0717a
            public void I(int i, int i2) {
            }
        };
        this.bUt = new View.OnTouchListener() { // from class: com.baidu.tieba.lego.LegoListView.7
            @Override // android.view.View.OnTouchListener
            public boolean onTouch(View view, MotionEvent motionEvent) {
                if (view == LegoListView.this.Yj && LegoListView.this.jMD != null) {
                    LegoListView.this.jMD.onTouchEvent(motionEvent);
                    return false;
                }
                return false;
            }
        };
        init(context, z);
    }

    public void setImmersive(boolean z) {
        this.lbW = z;
    }

    /* JADX INFO: Access modifiers changed from: private */
    public void aO(Object obj) {
        boolean z;
        if (this.lbK != null && this.lce != null && this.lce.dcW() != null) {
            boolean z2 = false;
            Iterator<ICardInfo> it = this.lce.dcW().iterator();
            while (true) {
                z = z2;
                if (!it.hasNext()) {
                    break;
                }
                z2 = it.next().responseAttention(obj) ? true : z;
            }
            if (z) {
                this.lbK.notifyDataSetChanged();
            }
        }
    }

    private void init(Context context, boolean z) {
        com.baidu.adp.base.f<?> J = com.baidu.adp.base.j.J(context);
        J.registerListener(this.fci);
        J.registerListener(this.mLikeForumListener);
        J.registerListener(this.mUnlikeForumListener);
        if (J instanceof TbPageContext) {
            this.pageContext = (TbPageContext) J;
        }
        this.Yj = new BdListView(context);
        this.Yj.setDividerHeight(0);
        this.Yj.setSelector(17170445);
        addView(this.Yj);
        if (!z) {
            this.Yj.setVerticalScrollBarEnabled(true);
            initUI(context);
        } else {
            this.Yj.setTranscriptMode(1);
            this.Yj.setVerticalScrollBarEnabled(false);
        }
        this.Yj.setOnSrollToBottomListener(this);
        this.Yj.setOnScrollListener(this);
        dbx();
        this.lbK = new com.baidu.tieba.lego.b.a(this.pageContext);
        this.Yj.setAdapter((ListAdapter) this.lbK);
        this.ZA = TbadkCoreApplication.getInst().getResources().getDimensionPixelSize(R.dimen.ds120);
        onChangeSkinType(TbadkCoreApplication.getInst().getSkinType());
    }

    public BdListView getListView() {
        return this.Yj;
    }

    public void l(BdUniqueId bdUniqueId) {
        if (bdUniqueId != null) {
            if (this.mPullView != null) {
                this.mPullView.setTag(bdUniqueId);
            }
            this.lch.setTag(bdUniqueId);
            MessageManager.getInstance().registerListener(this.lch);
        }
    }

    public void setCallback(d dVar) {
        this.lca = dVar;
    }

    public void setScrollCallback(g gVar) {
        this.lcc = gVar;
    }

    public void setViewBackGround() {
        qJ(true);
    }

    public n getPlaySwitchController() {
        return this.lcf;
    }

    public void setViewForeground() {
        qJ(false);
        if (this.lcf != null) {
            this.lcf.tN(true);
            this.lcf.b(this.jkn, this.gAO, this.jkX, true);
        }
        if (!this.lbZ && !this.lbY) {
            if (this.lbX && !com.baidu.adp.lib.util.l.isNetOk()) {
                if (this.lbK.isEmpty()) {
                    this.lbK.a(NoDataViewFactory.c.a(NoDataViewFactory.ImgType.NODATA, this.ZA), NoDataViewFactory.d.pA(R.string.neterror), null, null);
                    this.lbK.notifyDataSetChanged();
                }
            } else if (this.lcg) {
                this.lcg = false;
                com.baidu.adp.lib.f.e.mA().postDelayed(new Runnable() { // from class: com.baidu.tieba.lego.LegoListView.5
                    @Override // java.lang.Runnable
                    public void run() {
                        LegoListView.this.dbw();
                    }
                }, 200L);
            } else {
                dbw();
            }
        }
    }

    public void onDestory() {
        if (this.lcf != null) {
            this.lcf.destroy();
        }
    }

    /* JADX INFO: Access modifiers changed from: private */
    public void dbw() {
        b(this, false, getResources().getDimensionPixelSize(R.dimen.ds300));
        startLoad();
    }

    private void initUI(Context context) {
        this.mPullView = new com.baidu.tbadk.core.view.g(this.pageContext);
        this.Yj.setPullRefresh(this.mPullView);
        this.gCf = new PbListView(context);
        this.gCf.createView();
        this.gCf.setContainerBackgroundColorResId(R.color.CAM_X0204);
        this.gCf.setTextColor(ap.getColor(R.color.CAM_X0109));
        this.gCf.changeSkin(TbadkCoreApplication.getInst().getSkinType());
        this.mPullView.setListPullRefreshListener(new a());
    }

    private void dbx() {
        this.lcf = new n(this.pageContext, this.Yj);
        this.jMD = new com.baidu.tieba.f.a();
        this.jMD.a(this.iHb);
        this.Yj.setOnTouchListener(this.bUt);
        this.Yj.setRecyclerListener(new AbsListView.RecyclerListener() { // from class: com.baidu.tieba.lego.LegoListView.8
            @Override // android.widget.AbsListView.RecyclerListener
            public void onMovedToScrapHeap(View view) {
                if (LegoListView.this.lcf != null) {
                    LegoListView.this.lcf.dt(view);
                }
            }
        });
    }

    public void a(com.baidu.tieba.lego.c.c cVar, boolean z) {
        if (this.Yj != null) {
            this.Yj.completePullRefresh();
        }
        if (this.gCf != null) {
            this.gCf.endLoadData();
        }
        if (cVar == null) {
            setHasMore(false);
            dq(this);
            this.lbK.a(NoDataViewFactory.c.a(NoDataViewFactory.ImgType.NODATA, this.ZA), NoDataViewFactory.d.pA(R.string.invite_friend_no_data_now), null, null);
            this.lbK.notifyDataSetChanged();
            return;
        }
        this.lce = cVar;
        this.hxr = false;
        this.lbY = cVar.dcZ();
        this.lbX = cVar.dcY();
        this.lbZ = cVar.ddf();
        this.lcd = cVar.dda();
        setHasMore(cVar.hasMore());
        List<ICardInfo> dcW = cVar.dcW();
        if (this.lbK != null) {
            if (dcW == null || dcW.size() <= 0) {
                if (this.lbX && this.lbY) {
                    this.lbK.a(NoDataViewFactory.c.a(NoDataViewFactory.ImgType.NODATA, this.ZA), NoDataViewFactory.d.pA(R.string.invite_friend_no_data_now), null, null);
                } else {
                    this.lbK.a(null, null, null, null);
                }
                setHasMore(false);
            } else if (this.gCf != null) {
                if (this.gCf.getView().getParent() == null) {
                    this.Yj.setNextPage(this.gCf);
                }
                if (this.mHasMore) {
                    this.gCf.setText(getContext().getString(R.string.pb_load_more));
                } else if (dcW.get(dcW.size() - 1) instanceof WebViewCard) {
                    this.gCf.setText("");
                } else {
                    this.gCf.setText(getContext().getString(R.string.list_no_more));
                }
            }
            this.lbK.eK(dcW);
        }
        if (z) {
            this.Yj.setSelection(cVar.dcX());
        }
        if (this.lbY || (dcW != null && !dcW.isEmpty())) {
            dq(this);
        }
    }

    private void setHasMore(boolean z) {
        this.mHasMore = z;
        if (this.Yj != null && this.gCf != null) {
            if (!this.lbX) {
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
        if (this.lbX) {
            this.lca.c(1, this.lcd.lhU, this.lcd.itemId, "");
        } else {
            this.lca.p(this.lcd.lhU, this.lcd.itemId);
        }
    }

    public void NF(String str) {
        if (this.Yj != null) {
            this.Yj.completePullRefresh();
        }
        this.hxr = false;
        if (this.gCf != null) {
            this.gCf.endLoadData();
        }
        if (this.lbK.getCount() <= 0 && this.lbX) {
            this.lbK.a(NoDataViewFactory.c.a(NoDataViewFactory.ImgType.NODATA, this.ZA), NoDataViewFactory.d.BI(str), null, null);
            this.lbK.eK(new ArrayList());
        }
        dq(this);
    }

    @Override // android.widget.AbsListView.OnScrollListener
    public void onScroll(AbsListView absListView, int i, int i2, int i3) {
        this.jkn = i;
        this.gAO = (i + i2) - 1;
    }

    @Override // com.baidu.adp.widget.ListView.BdListView.e
    public void onScrollToBottom() {
        if (this.mHasMore && com.baidu.adp.lib.util.l.isNetOk() && !this.hxr) {
            this.hxr = true;
            if (this.gCf != null) {
                this.gCf.startLoadData();
            }
            if (this.lca != null) {
                if (this.lbK == null) {
                    this.lca.c(1, this.lcd.lhU, this.lcd.itemId, "");
                } else if (this.lce != null) {
                    this.lca.c(this.lce.getPn() + 1, this.lcd.lhU, this.lcd.itemId, this.lce.ddb());
                }
            }
        }
    }

    @SuppressLint({"ResourceAsColor"})
    public void onChangeSkinType(int i) {
        com.baidu.tbadk.r.a.a(this.pageContext, this);
        ap.setBackgroundColor(this.Yj, R.color.CAM_X0204, i);
        if (this.lbK != null) {
            this.lbK.notifyDataSetChanged();
        }
        if (this.mPullView != null) {
            this.mPullView.changeSkin(i);
        }
        if (this.gCf != null) {
            this.gCf.changeSkin(i);
        }
    }

    public boolean u(long j, String str) {
        return this.lcd != null && j == this.lcd.lhU && TextUtils.equals(str, this.lcd.itemId);
    }

    @Override // android.widget.AbsListView.OnScrollListener
    public void onScrollStateChanged(AbsListView absListView, int i) {
        if (i == 0) {
            MessageManager.getInstance().dispatchResponsedMessage(new CustomResponsedMessage(CmdConfigCustom.CMD_LEGO_SWITCH_TAB, -1));
            if (this.lcc != null && this.lcd != null) {
                this.lcc.a(this.lcd, this.Yj.getFirstVisiblePosition());
            }
            dbu();
        }
    }

    private void qJ(boolean z) {
        if (this.Yj != null) {
            int i = 0;
            while (true) {
                int i2 = i;
                if (i2 < this.Yj.getChildCount()) {
                    View childAt = this.Yj.getChildAt(i2);
                    if (childAt instanceof com.baidu.tieba.lego.card.view.e) {
                        if (z) {
                            ((com.baidu.tieba.lego.card.view.e) childAt).aSZ();
                        } else {
                            ((com.baidu.tieba.lego.card.view.e) childAt).cSL();
                        }
                    }
                    i = i2 + 1;
                } else {
                    return;
                }
            }
        }
    }

    private void dbu() {
        if (this.Yj != null) {
            int i = 0;
            while (true) {
                int i2 = i;
                if (i2 >= this.Yj.getChildCount()) {
                    break;
                }
                View childAt = this.Yj.getChildAt(i2);
                if (childAt instanceof com.baidu.tieba.lego.card.view.e) {
                    ((com.baidu.tieba.lego.card.view.e) childAt).dcj();
                }
                i = i2 + 1;
            }
            if (this.lcf != null) {
                this.lcf.a(this.jkn, this.gAO, this.jkX, 1);
            }
        }
    }

    /* JADX INFO: Access modifiers changed from: private */
    /* loaded from: classes8.dex */
    public class a implements f.c {
        private a() {
        }

        @Override // com.baidu.tbadk.core.view.f.c
        public void onListPullRefresh(boolean z) {
            if (LegoListView.this.lca != null) {
                LegoListView.this.startLoad();
            }
        }
    }

    private void b(View view, boolean z, int i) {
        if (this.lcb == null) {
            if (i < 0) {
                this.lcb = new com.baidu.tbadk.l.g(getContext());
            } else {
                this.lcb = new com.baidu.tbadk.l.g(getContext(), i);
            }
            this.lcb.onChangeSkinType();
        }
        this.lcb.attachView(view, z);
        if (this.mPullView != null) {
            this.mPullView.setEnable(false);
        }
        if (this.lbK != null) {
            this.lbK.tE(false);
            this.lbK.notifyDataSetChanged();
        }
    }

    private void dq(View view) {
        if (this.lcb != null) {
            this.lcb.dettachView(view);
            this.lcb = null;
        }
        if (this.mPullView != null) {
            this.mPullView.setEnable(true);
        }
        if (this.lbK != null) {
            this.lbK.tE(true);
            this.lbK.notifyDataSetChanged();
        }
    }

    public void setFriction(float f) {
        if (this.Yj != null) {
            this.Yj.setFriction(f);
        }
    }
}
