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
    private PbListView gAi;
    private int gyR;
    private boolean hvu;
    private a.InterfaceC0710a iFe;
    private com.baidu.tieba.f.a jKG;
    private int jiq;
    private boolean jja;
    private boolean kZF;
    private boolean kZG;
    private boolean kZH;
    private boolean kZI;
    private d kZJ;
    private com.baidu.tbadk.l.g kZK;
    private g kZL;
    private com.baidu.tieba.lego.c.e kZM;
    private com.baidu.tieba.lego.c.c kZN;
    private n kZO;
    private boolean kZP;
    private CustomMessageListener kZQ;
    public com.baidu.tieba.lego.b.a kZt;
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
        this.kZF = false;
        this.jiq = 0;
        this.gyR = 0;
        this.kZP = false;
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
        this.kZQ = new CustomMessageListener(CmdConfigCustom.CMD_LEGO_SWITCH_TAB_FROM_POP_WINDOW) { // from class: com.baidu.tieba.lego.LegoListView.4
            /* JADX DEBUG: Method merged with bridge method */
            @Override // com.baidu.adp.framework.listener.MessageListener
            public void onMessage(CustomResponsedMessage<?> customResponsedMessage) {
                if (customResponsedMessage != null) {
                    LegoListView.this.kZP = true;
                }
            }
        };
        this.iFe = new a.InterfaceC0710a() { // from class: com.baidu.tieba.lego.LegoListView.6
            @Override // com.baidu.tieba.f.a.InterfaceC0710a
            public void G(int i, int i2) {
                LegoListView.this.jja = false;
                LegoListView.this.kZt.tF(LegoListView.this.jja);
            }

            @Override // com.baidu.tieba.f.a.InterfaceC0710a
            public void H(int i, int i2) {
                LegoListView.this.jja = true;
                LegoListView.this.kZt.tF(LegoListView.this.jja);
            }

            @Override // com.baidu.tieba.f.a.InterfaceC0710a
            public void cg(int i, int i2) {
            }

            @Override // com.baidu.tieba.f.a.InterfaceC0710a
            public void I(int i, int i2) {
            }
        };
        this.bST = new View.OnTouchListener() { // from class: com.baidu.tieba.lego.LegoListView.7
            @Override // android.view.View.OnTouchListener
            public boolean onTouch(View view, MotionEvent motionEvent) {
                if (view == LegoListView.this.WO && LegoListView.this.jKG != null) {
                    LegoListView.this.jKG.onTouchEvent(motionEvent);
                    return false;
                }
                return false;
            }
        };
        init(context, z);
    }

    public void setImmersive(boolean z) {
        this.kZF = z;
    }

    /* JADX INFO: Access modifiers changed from: private */
    public void aM(Object obj) {
        boolean z;
        if (this.kZt != null && this.kZN != null && this.kZN.dcG() != null) {
            boolean z2 = false;
            Iterator<ICardInfo> it = this.kZN.dcG().iterator();
            while (true) {
                z = z2;
                if (!it.hasNext()) {
                    break;
                }
                z2 = it.next().responseAttention(obj) ? true : z;
            }
            if (z) {
                this.kZt.notifyDataSetChanged();
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
        dbh();
        this.kZt = new com.baidu.tieba.lego.b.a(this.pageContext);
        this.WO.setAdapter((ListAdapter) this.kZt);
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
            this.kZQ.setTag(bdUniqueId);
            MessageManager.getInstance().registerListener(this.kZQ);
        }
    }

    public void setCallback(d dVar) {
        this.kZJ = dVar;
    }

    public void setScrollCallback(g gVar) {
        this.kZL = gVar;
    }

    public void setViewBackGround() {
        qJ(true);
    }

    public n getPlaySwitchController() {
        return this.kZO;
    }

    public void setViewForeground() {
        qJ(false);
        if (this.kZO != null) {
            this.kZO.tN(true);
            this.kZO.b(this.jiq, this.gyR, this.jja, true);
        }
        if (!this.kZI && !this.kZH) {
            if (this.kZG && !com.baidu.adp.lib.util.l.isNetOk()) {
                if (this.kZt.isEmpty()) {
                    this.kZt.a(NoDataViewFactory.c.a(NoDataViewFactory.ImgType.NODATA, this.Yh), NoDataViewFactory.d.pz(R.string.neterror), null, null);
                    this.kZt.notifyDataSetChanged();
                }
            } else if (this.kZP) {
                this.kZP = false;
                com.baidu.adp.lib.f.e.mA().postDelayed(new Runnable() { // from class: com.baidu.tieba.lego.LegoListView.5
                    @Override // java.lang.Runnable
                    public void run() {
                        LegoListView.this.dbg();
                    }
                }, 200L);
            } else {
                dbg();
            }
        }
    }

    public void onDestory() {
        if (this.kZO != null) {
            this.kZO.destroy();
        }
    }

    /* JADX INFO: Access modifiers changed from: private */
    public void dbg() {
        b(this, false, getResources().getDimensionPixelSize(R.dimen.ds300));
        startLoad();
    }

    private void initUI(Context context) {
        this.mPullView = new com.baidu.tbadk.core.view.g(this.pageContext);
        this.WO.setPullRefresh(this.mPullView);
        this.gAi = new PbListView(context);
        this.gAi.createView();
        this.gAi.setContainerBackgroundColorResId(R.color.CAM_X0204);
        this.gAi.setTextColor(ap.getColor(R.color.CAM_X0109));
        this.gAi.changeSkin(TbadkCoreApplication.getInst().getSkinType());
        this.mPullView.setListPullRefreshListener(new a());
    }

    private void dbh() {
        this.kZO = new n(this.pageContext, this.WO);
        this.jKG = new com.baidu.tieba.f.a();
        this.jKG.a(this.iFe);
        this.WO.setOnTouchListener(this.bST);
        this.WO.setRecyclerListener(new AbsListView.RecyclerListener() { // from class: com.baidu.tieba.lego.LegoListView.8
            @Override // android.widget.AbsListView.RecyclerListener
            public void onMovedToScrapHeap(View view) {
                if (LegoListView.this.kZO != null) {
                    LegoListView.this.kZO.dt(view);
                }
            }
        });
    }

    public void a(com.baidu.tieba.lego.c.c cVar, boolean z) {
        if (this.WO != null) {
            this.WO.completePullRefresh();
        }
        if (this.gAi != null) {
            this.gAi.endLoadData();
        }
        if (cVar == null) {
            setHasMore(false);
            dq(this);
            this.kZt.a(NoDataViewFactory.c.a(NoDataViewFactory.ImgType.NODATA, this.Yh), NoDataViewFactory.d.pz(R.string.invite_friend_no_data_now), null, null);
            this.kZt.notifyDataSetChanged();
            return;
        }
        this.kZN = cVar;
        this.hvu = false;
        this.kZH = cVar.dcJ();
        this.kZG = cVar.dcI();
        this.kZI = cVar.dcP();
        this.kZM = cVar.dcK();
        setHasMore(cVar.hasMore());
        List<ICardInfo> dcG = cVar.dcG();
        if (this.kZt != null) {
            if (dcG == null || dcG.size() <= 0) {
                if (this.kZG && this.kZH) {
                    this.kZt.a(NoDataViewFactory.c.a(NoDataViewFactory.ImgType.NODATA, this.Yh), NoDataViewFactory.d.pz(R.string.invite_friend_no_data_now), null, null);
                } else {
                    this.kZt.a(null, null, null, null);
                }
                setHasMore(false);
            } else if (this.gAi != null) {
                if (this.gAi.getView().getParent() == null) {
                    this.WO.setNextPage(this.gAi);
                }
                if (this.mHasMore) {
                    this.gAi.setText(getContext().getString(R.string.pb_load_more));
                } else if (dcG.get(dcG.size() - 1) instanceof WebViewCard) {
                    this.gAi.setText("");
                } else {
                    this.gAi.setText(getContext().getString(R.string.list_no_more));
                }
            }
            this.kZt.eK(dcG);
        }
        if (z) {
            this.WO.setSelection(cVar.dcH());
        }
        if (this.kZH || (dcG != null && !dcG.isEmpty())) {
            dq(this);
        }
    }

    private void setHasMore(boolean z) {
        this.mHasMore = z;
        if (this.WO != null && this.gAi != null) {
            if (!this.kZG) {
                this.gAi.setText("");
            } else if (this.mHasMore) {
                this.gAi.setText(getContext().getString(R.string.pb_load_more));
            } else {
                this.gAi.setText("");
            }
        }
    }

    /* JADX INFO: Access modifiers changed from: private */
    public void startLoad() {
        if (this.kZG) {
            this.kZJ.c(1, this.kZM.lfE, this.kZM.itemId, "");
        } else {
            this.kZJ.p(this.kZM.lfE, this.kZM.itemId);
        }
    }

    public void Ny(String str) {
        if (this.WO != null) {
            this.WO.completePullRefresh();
        }
        this.hvu = false;
        if (this.gAi != null) {
            this.gAi.endLoadData();
        }
        if (this.kZt.getCount() <= 0 && this.kZG) {
            this.kZt.a(NoDataViewFactory.c.a(NoDataViewFactory.ImgType.NODATA, this.Yh), NoDataViewFactory.d.BB(str), null, null);
            this.kZt.eK(new ArrayList());
        }
        dq(this);
    }

    @Override // android.widget.AbsListView.OnScrollListener
    public void onScroll(AbsListView absListView, int i, int i2, int i3) {
        this.jiq = i;
        this.gyR = (i + i2) - 1;
    }

    @Override // com.baidu.adp.widget.ListView.BdListView.e
    public void onScrollToBottom() {
        if (this.mHasMore && com.baidu.adp.lib.util.l.isNetOk() && !this.hvu) {
            this.hvu = true;
            if (this.gAi != null) {
                this.gAi.startLoadData();
            }
            if (this.kZJ != null) {
                if (this.kZt == null) {
                    this.kZJ.c(1, this.kZM.lfE, this.kZM.itemId, "");
                } else if (this.kZN != null) {
                    this.kZJ.c(this.kZN.getPn() + 1, this.kZM.lfE, this.kZM.itemId, this.kZN.dcL());
                }
            }
        }
    }

    @SuppressLint({"ResourceAsColor"})
    public void onChangeSkinType(int i) {
        com.baidu.tbadk.r.a.a(this.pageContext, this);
        ap.setBackgroundColor(this.WO, R.color.CAM_X0204, i);
        if (this.kZt != null) {
            this.kZt.notifyDataSetChanged();
        }
        if (this.mPullView != null) {
            this.mPullView.changeSkin(i);
        }
        if (this.gAi != null) {
            this.gAi.changeSkin(i);
        }
    }

    public boolean u(long j, String str) {
        return this.kZM != null && j == this.kZM.lfE && TextUtils.equals(str, this.kZM.itemId);
    }

    @Override // android.widget.AbsListView.OnScrollListener
    public void onScrollStateChanged(AbsListView absListView, int i) {
        if (i == 0) {
            MessageManager.getInstance().dispatchResponsedMessage(new CustomResponsedMessage(CmdConfigCustom.CMD_LEGO_SWITCH_TAB, -1));
            if (this.kZL != null && this.kZM != null) {
                this.kZL.a(this.kZM, this.WO.getFirstVisiblePosition());
            }
            dbe();
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
                            ((com.baidu.tieba.lego.card.view.e) childAt).cSx();
                        }
                    }
                    i = i2 + 1;
                } else {
                    return;
                }
            }
        }
    }

    private void dbe() {
        if (this.WO != null) {
            int i = 0;
            while (true) {
                int i2 = i;
                if (i2 >= this.WO.getChildCount()) {
                    break;
                }
                View childAt = this.WO.getChildAt(i2);
                if (childAt instanceof com.baidu.tieba.lego.card.view.e) {
                    ((com.baidu.tieba.lego.card.view.e) childAt).dbT();
                }
                i = i2 + 1;
            }
            if (this.kZO != null) {
                this.kZO.a(this.jiq, this.gyR, this.jja, 1);
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
            if (LegoListView.this.kZJ != null) {
                LegoListView.this.startLoad();
            }
        }
    }

    private void b(View view, boolean z, int i) {
        if (this.kZK == null) {
            if (i < 0) {
                this.kZK = new com.baidu.tbadk.l.g(getContext());
            } else {
                this.kZK = new com.baidu.tbadk.l.g(getContext(), i);
            }
            this.kZK.onChangeSkinType();
        }
        this.kZK.attachView(view, z);
        if (this.mPullView != null) {
            this.mPullView.setEnable(false);
        }
        if (this.kZt != null) {
            this.kZt.tE(false);
            this.kZt.notifyDataSetChanged();
        }
    }

    private void dq(View view) {
        if (this.kZK != null) {
            this.kZK.dettachView(view);
            this.kZK = null;
        }
        if (this.mPullView != null) {
            this.mPullView.setEnable(true);
        }
        if (this.kZt != null) {
            this.kZt.tE(true);
            this.kZt.notifyDataSetChanged();
        }
    }

    public void setFriction(float f) {
        if (this.WO != null) {
            this.WO.setFriction(f);
        }
    }
}
