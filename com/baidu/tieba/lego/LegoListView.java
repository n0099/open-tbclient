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
/* loaded from: classes8.dex */
public class LegoListView extends FrameLayout implements AbsListView.OnScrollListener, BdListView.e {
    private BdListView WT;
    private int Yl;
    private View.OnTouchListener bPd;
    private CustomMessageListener eYu;
    private int gwh;
    private PbListView gxy;
    private boolean hrk;
    private a.InterfaceC0710a izu;
    private com.baidu.tieba.f.a jFc;
    private int jcJ;
    private boolean jdt;
    private boolean kRD;
    private boolean kRE;
    private boolean kRF;
    private boolean kRG;
    private d kRH;
    private com.baidu.tbadk.l.g kRI;
    private g kRJ;
    private com.baidu.tieba.lego.c.e kRK;
    private com.baidu.tieba.lego.c.c kRL;
    private n kRM;
    private boolean kRN;
    private CustomMessageListener kRO;
    public com.baidu.tieba.lego.b.a kRr;
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
        this.kRD = false;
        this.jcJ = 0;
        this.gwh = 0;
        this.kRN = false;
        this.eYu = new CustomMessageListener(CmdConfigCustom.CMD_UPDATE_ATTENTION) { // from class: com.baidu.tieba.lego.LegoListView.1
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
                    bVar.eNy = true;
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
                    bVar.eNy = false;
                    LegoListView.this.aM(bVar);
                }
            }
        };
        this.kRO = new CustomMessageListener(CmdConfigCustom.CMD_LEGO_SWITCH_TAB_FROM_POP_WINDOW) { // from class: com.baidu.tieba.lego.LegoListView.4
            /* JADX DEBUG: Method merged with bridge method */
            @Override // com.baidu.adp.framework.listener.MessageListener
            public void onMessage(CustomResponsedMessage<?> customResponsedMessage) {
                if (customResponsedMessage != null) {
                    LegoListView.this.kRN = true;
                }
            }
        };
        this.izu = new a.InterfaceC0710a() { // from class: com.baidu.tieba.lego.LegoListView.6
            @Override // com.baidu.tieba.f.a.InterfaceC0710a
            public void G(int i, int i2) {
                LegoListView.this.jdt = false;
                LegoListView.this.kRr.ts(LegoListView.this.jdt);
            }

            @Override // com.baidu.tieba.f.a.InterfaceC0710a
            public void H(int i, int i2) {
                LegoListView.this.jdt = true;
                LegoListView.this.kRr.ts(LegoListView.this.jdt);
            }

            @Override // com.baidu.tieba.f.a.InterfaceC0710a
            public void cj(int i, int i2) {
            }

            @Override // com.baidu.tieba.f.a.InterfaceC0710a
            public void I(int i, int i2) {
            }
        };
        this.bPd = new View.OnTouchListener() { // from class: com.baidu.tieba.lego.LegoListView.7
            @Override // android.view.View.OnTouchListener
            public boolean onTouch(View view, MotionEvent motionEvent) {
                if (view == LegoListView.this.WT && LegoListView.this.jFc != null) {
                    LegoListView.this.jFc.onTouchEvent(motionEvent);
                    return false;
                }
                return false;
            }
        };
        init(context, z);
    }

    public void setImmersive(boolean z) {
        this.kRD = z;
    }

    /* JADX INFO: Access modifiers changed from: private */
    public void aM(Object obj) {
        boolean z;
        if (this.kRr != null && this.kRL != null && this.kRL.daI() != null) {
            boolean z2 = false;
            Iterator<ICardInfo> it = this.kRL.daI().iterator();
            while (true) {
                z = z2;
                if (!it.hasNext()) {
                    break;
                }
                z2 = it.next().responseAttention(obj) ? true : z;
            }
            if (z) {
                this.kRr.notifyDataSetChanged();
            }
        }
    }

    private void init(Context context, boolean z) {
        com.baidu.adp.base.f<?> K = com.baidu.adp.base.j.K(context);
        K.registerListener(this.eYu);
        K.registerListener(this.mLikeForumListener);
        K.registerListener(this.mUnlikeForumListener);
        if (K instanceof TbPageContext) {
            this.pageContext = (TbPageContext) K;
        }
        this.WT = new BdListView(context);
        this.WT.setDividerHeight(0);
        this.WT.setSelector(17170445);
        addView(this.WT);
        if (!z) {
            this.WT.setVerticalScrollBarEnabled(true);
            initUI(context);
        } else {
            this.WT.setTranscriptMode(1);
            this.WT.setVerticalScrollBarEnabled(false);
        }
        this.WT.setOnSrollToBottomListener(this);
        this.WT.setOnScrollListener(this);
        cZj();
        this.kRr = new com.baidu.tieba.lego.b.a(this.pageContext);
        this.WT.setAdapter((ListAdapter) this.kRr);
        this.Yl = TbadkCoreApplication.getInst().getResources().getDimensionPixelSize(R.dimen.ds120);
        onChangeSkinType(TbadkCoreApplication.getInst().getSkinType());
    }

    public BdListView getListView() {
        return this.WT;
    }

    public void l(BdUniqueId bdUniqueId) {
        if (bdUniqueId != null) {
            if (this.mPullView != null) {
                this.mPullView.setTag(bdUniqueId);
            }
            this.kRO.setTag(bdUniqueId);
            MessageManager.getInstance().registerListener(this.kRO);
        }
    }

    public void setCallback(d dVar) {
        this.kRH = dVar;
    }

    public void setScrollCallback(g gVar) {
        this.kRJ = gVar;
    }

    public void setViewBackGround() {
        qz(true);
    }

    public n getPlaySwitchController() {
        return this.kRM;
    }

    public void setViewForeground() {
        qz(false);
        if (this.kRM != null) {
            this.kRM.tA(true);
            this.kRM.b(this.jcJ, this.gwh, this.jdt, true);
        }
        if (!this.kRG && !this.kRF) {
            if (this.kRE && !com.baidu.adp.lib.util.l.isNetOk()) {
                if (this.kRr.isEmpty()) {
                    this.kRr.a(NoDataViewFactory.c.a(NoDataViewFactory.ImgType.NODATA, this.Yl), NoDataViewFactory.d.pu(R.string.neterror), null, null);
                    this.kRr.notifyDataSetChanged();
                }
            } else if (this.kRN) {
                this.kRN = false;
                com.baidu.adp.lib.f.e.mB().postDelayed(new Runnable() { // from class: com.baidu.tieba.lego.LegoListView.5
                    @Override // java.lang.Runnable
                    public void run() {
                        LegoListView.this.cZi();
                    }
                }, 200L);
            } else {
                cZi();
            }
        }
    }

    public void onDestory() {
        if (this.kRM != null) {
            this.kRM.destroy();
        }
    }

    /* JADX INFO: Access modifiers changed from: private */
    public void cZi() {
        b(this, false, getResources().getDimensionPixelSize(R.dimen.ds300));
        startLoad();
    }

    private void initUI(Context context) {
        this.mPullView = new com.baidu.tbadk.core.view.g(this.pageContext);
        this.WT.setPullRefresh(this.mPullView);
        this.gxy = new PbListView(context);
        this.gxy.createView();
        this.gxy.setContainerBackgroundColorResId(R.color.CAM_X0204);
        this.gxy.setTextColor(ao.getColor(R.color.CAM_X0109));
        this.gxy.changeSkin(TbadkCoreApplication.getInst().getSkinType());
        this.mPullView.setListPullRefreshListener(new a());
    }

    private void cZj() {
        this.kRM = new n(this.pageContext, this.WT);
        this.jFc = new com.baidu.tieba.f.a();
        this.jFc.a(this.izu);
        this.WT.setOnTouchListener(this.bPd);
        this.WT.setRecyclerListener(new AbsListView.RecyclerListener() { // from class: com.baidu.tieba.lego.LegoListView.8
            @Override // android.widget.AbsListView.RecyclerListener
            public void onMovedToScrapHeap(View view) {
                if (LegoListView.this.kRM != null) {
                    LegoListView.this.kRM.dv(view);
                }
            }
        });
    }

    public void a(com.baidu.tieba.lego.c.c cVar, boolean z) {
        if (this.WT != null) {
            this.WT.completePullRefresh();
        }
        if (this.gxy != null) {
            this.gxy.endLoadData();
        }
        if (cVar == null) {
            setHasMore(false);
            ds(this);
            this.kRr.a(NoDataViewFactory.c.a(NoDataViewFactory.ImgType.NODATA, this.Yl), NoDataViewFactory.d.pu(R.string.invite_friend_no_data_now), null, null);
            this.kRr.notifyDataSetChanged();
            return;
        }
        this.kRL = cVar;
        this.hrk = false;
        this.kRF = cVar.daL();
        this.kRE = cVar.daK();
        this.kRG = cVar.daR();
        this.kRK = cVar.daM();
        setHasMore(cVar.hasMore());
        List<ICardInfo> daI = cVar.daI();
        if (this.kRr != null) {
            if (daI == null || daI.size() <= 0) {
                if (this.kRE && this.kRF) {
                    this.kRr.a(NoDataViewFactory.c.a(NoDataViewFactory.ImgType.NODATA, this.Yl), NoDataViewFactory.d.pu(R.string.invite_friend_no_data_now), null, null);
                } else {
                    this.kRr.a(null, null, null, null);
                }
                setHasMore(false);
            } else if (this.gxy != null) {
                if (this.gxy.getView().getParent() == null) {
                    this.WT.setNextPage(this.gxy);
                }
                if (this.mHasMore) {
                    this.gxy.setText(getContext().getString(R.string.pb_load_more));
                } else if (daI.get(daI.size() - 1) instanceof WebViewCard) {
                    this.gxy.setText("");
                } else {
                    this.gxy.setText(getContext().getString(R.string.list_no_more));
                }
            }
            this.kRr.eM(daI);
        }
        if (z) {
            this.WT.setSelection(cVar.daJ());
        }
        if (this.kRF || (daI != null && !daI.isEmpty())) {
            ds(this);
        }
    }

    private void setHasMore(boolean z) {
        this.mHasMore = z;
        if (this.WT != null && this.gxy != null) {
            if (!this.kRE) {
                this.gxy.setText("");
            } else if (this.mHasMore) {
                this.gxy.setText(getContext().getString(R.string.pb_load_more));
            } else {
                this.gxy.setText("");
            }
        }
    }

    /* JADX INFO: Access modifiers changed from: private */
    public void startLoad() {
        if (this.kRE) {
            this.kRH.c(1, this.kRK.kXA, this.kRK.itemId, "");
        } else {
            this.kRH.o(this.kRK.kXA, this.kRK.itemId);
        }
    }

    public void MJ(String str) {
        if (this.WT != null) {
            this.WT.completePullRefresh();
        }
        this.hrk = false;
        if (this.gxy != null) {
            this.gxy.endLoadData();
        }
        if (this.kRr.getCount() <= 0 && this.kRE) {
            this.kRr.a(NoDataViewFactory.c.a(NoDataViewFactory.ImgType.NODATA, this.Yl), NoDataViewFactory.d.Bk(str), null, null);
            this.kRr.eM(new ArrayList());
        }
        ds(this);
    }

    @Override // android.widget.AbsListView.OnScrollListener
    public void onScroll(AbsListView absListView, int i, int i2, int i3) {
        this.jcJ = i;
        this.gwh = (i + i2) - 1;
    }

    @Override // com.baidu.adp.widget.ListView.BdListView.e
    public void onScrollToBottom() {
        if (this.mHasMore && com.baidu.adp.lib.util.l.isNetOk() && !this.hrk) {
            this.hrk = true;
            if (this.gxy != null) {
                this.gxy.startLoadData();
            }
            if (this.kRH != null) {
                if (this.kRr == null) {
                    this.kRH.c(1, this.kRK.kXA, this.kRK.itemId, "");
                } else if (this.kRL != null) {
                    this.kRH.c(this.kRL.getPn() + 1, this.kRK.kXA, this.kRK.itemId, this.kRL.daN());
                }
            }
        }
    }

    @SuppressLint({"ResourceAsColor"})
    public void onChangeSkinType(int i) {
        com.baidu.tbadk.r.a.a(this.pageContext, this);
        ao.setBackgroundColor(this.WT, R.color.CAM_X0204, i);
        if (this.kRr != null) {
            this.kRr.notifyDataSetChanged();
        }
        if (this.mPullView != null) {
            this.mPullView.changeSkin(i);
        }
        if (this.gxy != null) {
            this.gxy.changeSkin(i);
        }
    }

    public boolean t(long j, String str) {
        return this.kRK != null && j == this.kRK.kXA && TextUtils.equals(str, this.kRK.itemId);
    }

    @Override // android.widget.AbsListView.OnScrollListener
    public void onScrollStateChanged(AbsListView absListView, int i) {
        if (i == 0) {
            MessageManager.getInstance().dispatchResponsedMessage(new CustomResponsedMessage(CmdConfigCustom.CMD_LEGO_SWITCH_TAB, -1));
            if (this.kRJ != null && this.kRK != null) {
                this.kRJ.a(this.kRK, this.WT.getFirstVisiblePosition());
            }
            cZg();
        }
    }

    private void qz(boolean z) {
        if (this.WT != null) {
            int i = 0;
            while (true) {
                int i2 = i;
                if (i2 < this.WT.getChildCount()) {
                    View childAt = this.WT.getChildAt(i2);
                    if (childAt instanceof com.baidu.tieba.lego.card.view.e) {
                        if (z) {
                            ((com.baidu.tieba.lego.card.view.e) childAt).aSK();
                        } else {
                            ((com.baidu.tieba.lego.card.view.e) childAt).cQy();
                        }
                    }
                    i = i2 + 1;
                } else {
                    return;
                }
            }
        }
    }

    private void cZg() {
        if (this.WT != null) {
            int i = 0;
            while (true) {
                int i2 = i;
                if (i2 >= this.WT.getChildCount()) {
                    break;
                }
                View childAt = this.WT.getChildAt(i2);
                if (childAt instanceof com.baidu.tieba.lego.card.view.e) {
                    ((com.baidu.tieba.lego.card.view.e) childAt).cZV();
                }
                i = i2 + 1;
            }
            if (this.kRM != null) {
                this.kRM.a(this.jcJ, this.gwh, this.jdt, 1);
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
            if (LegoListView.this.kRH != null) {
                LegoListView.this.startLoad();
            }
        }
    }

    private void b(View view, boolean z, int i) {
        if (this.kRI == null) {
            if (i < 0) {
                this.kRI = new com.baidu.tbadk.l.g(getContext());
            } else {
                this.kRI = new com.baidu.tbadk.l.g(getContext(), i);
            }
            this.kRI.onChangeSkinType();
        }
        this.kRI.attachView(view, z);
        if (this.mPullView != null) {
            this.mPullView.setEnable(false);
        }
        if (this.kRr != null) {
            this.kRr.tr(false);
            this.kRr.notifyDataSetChanged();
        }
    }

    private void ds(View view) {
        if (this.kRI != null) {
            this.kRI.dettachView(view);
            this.kRI = null;
        }
        if (this.mPullView != null) {
            this.mPullView.setEnable(true);
        }
        if (this.kRr != null) {
            this.kRr.tr(true);
            this.kRr.notifyDataSetChanged();
        }
    }

    public void setFriction(float f) {
        if (this.WT != null) {
            this.WT.setFriction(f);
        }
    }
}
