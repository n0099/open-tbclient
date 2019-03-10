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
import com.baidu.tbadk.TbPageContext;
import com.baidu.tbadk.core.TbadkCoreApplication;
import com.baidu.tbadk.core.util.al;
import com.baidu.tbadk.core.view.NoDataViewFactory;
import com.baidu.tbadk.core.view.PbListView;
import com.baidu.tbadk.core.view.h;
import com.baidu.tbadk.coreExtra.message.UpdateAttentionMessage;
import com.baidu.tieba.d;
import com.baidu.tieba.f.a;
import com.baidu.tieba.lego.card.model.ICardInfo;
import com.baidu.tieba.lego.card.model.WebViewCard;
import java.util.ArrayList;
import java.util.Iterator;
import java.util.List;
/* loaded from: classes2.dex */
public class LegoListView extends FrameLayout implements AbsListView.OnScrollListener, BdListView.e {
    private BdListView Pi;
    private int cZV;
    private View.OnTouchListener ccU;
    private int ccb;
    private a.InterfaceC0243a dMw;
    private PbListView dbr;
    private boolean eoH;
    private int fay;
    private boolean fbe;
    private com.baidu.tieba.f.a fvR;
    public com.baidu.tieba.lego.b.a gED;
    private boolean gEP;
    private boolean gEQ;
    private boolean gER;
    private boolean gES;
    private d gET;
    private com.baidu.tbadk.m.g gEU;
    private g gEV;
    private com.baidu.tieba.lego.c.e gEW;
    private com.baidu.tieba.lego.c.c gEX;
    private com.baidu.tieba.lego.card.view.l gEY;
    private boolean gEZ;
    private CustomMessageListener gFa;
    private CustomMessageListener mAttentionListener;
    private boolean mHasMore;
    private CustomMessageListener mLikeForumListener;
    private com.baidu.tbadk.core.view.i mPullView;
    private CustomMessageListener mUnlikeForumListener;
    private TbPageContext<?> pageContext;

    public LegoListView(Context context) {
        this(context, false);
    }

    public LegoListView(Context context, boolean z) {
        super(context);
        this.gEP = false;
        this.fay = 0;
        this.cZV = 0;
        this.gEZ = false;
        this.mAttentionListener = new CustomMessageListener(2001115) { // from class: com.baidu.tieba.lego.LegoListView.1
            /* JADX DEBUG: Method merged with bridge method */
            @Override // com.baidu.adp.framework.listener.MessageListener
            public void onMessage(CustomResponsedMessage<?> customResponsedMessage) {
                UpdateAttentionMessage updateAttentionMessage = (UpdateAttentionMessage) customResponsedMessage;
                if (updateAttentionMessage != null && updateAttentionMessage.getData() != null && updateAttentionMessage.getData().Jy) {
                    LegoListView.this.av(updateAttentionMessage.getData());
                }
            }
        };
        this.mLikeForumListener = new CustomMessageListener(2001335) { // from class: com.baidu.tieba.lego.LegoListView.2
            /* JADX DEBUG: Method merged with bridge method */
            @Override // com.baidu.adp.framework.listener.MessageListener
            public void onMessage(CustomResponsedMessage<?> customResponsedMessage) {
                if (customResponsedMessage != null && (customResponsedMessage.getData() instanceof Long)) {
                    com.baidu.tieba.lego.c.b bVar = new com.baidu.tieba.lego.c.b();
                    bVar.fid = String.valueOf(customResponsedMessage.getData());
                    bVar.bAw = true;
                    LegoListView.this.av(bVar);
                }
            }
        };
        this.mUnlikeForumListener = new CustomMessageListener(2001336) { // from class: com.baidu.tieba.lego.LegoListView.3
            /* JADX DEBUG: Method merged with bridge method */
            @Override // com.baidu.adp.framework.listener.MessageListener
            public void onMessage(CustomResponsedMessage<?> customResponsedMessage) {
                if (customResponsedMessage != null && (customResponsedMessage.getData() instanceof Long)) {
                    com.baidu.tieba.lego.c.b bVar = new com.baidu.tieba.lego.c.b();
                    bVar.fid = String.valueOf(customResponsedMessage.getData());
                    bVar.bAw = false;
                    LegoListView.this.av(bVar);
                }
            }
        };
        this.gFa = new CustomMessageListener(2016448) { // from class: com.baidu.tieba.lego.LegoListView.4
            /* JADX DEBUG: Method merged with bridge method */
            @Override // com.baidu.adp.framework.listener.MessageListener
            public void onMessage(CustomResponsedMessage<?> customResponsedMessage) {
                if (customResponsedMessage != null) {
                    LegoListView.this.gEZ = true;
                }
            }
        };
        this.dMw = new a.InterfaceC0243a() { // from class: com.baidu.tieba.lego.LegoListView.6
            @Override // com.baidu.tieba.f.a.InterfaceC0243a
            public void aR(int i, int i2) {
                LegoListView.this.fbe = true;
                LegoListView.this.gED.lW(LegoListView.this.fbe);
            }

            @Override // com.baidu.tieba.f.a.InterfaceC0243a
            public void aS(int i, int i2) {
                LegoListView.this.fbe = false;
                LegoListView.this.gED.lW(LegoListView.this.fbe);
            }

            @Override // com.baidu.tieba.f.a.InterfaceC0243a
            public void aT(int i, int i2) {
            }
        };
        this.ccU = new View.OnTouchListener() { // from class: com.baidu.tieba.lego.LegoListView.7
            @Override // android.view.View.OnTouchListener
            public boolean onTouch(View view, MotionEvent motionEvent) {
                if (view == LegoListView.this.Pi && LegoListView.this.fvR != null) {
                    LegoListView.this.fvR.onTouchEvent(motionEvent);
                    return false;
                }
                return false;
            }
        };
        init(context, z);
    }

    public void setImmersive(boolean z) {
        this.gEP = z;
    }

    /* JADX INFO: Access modifiers changed from: private */
    public void av(Object obj) {
        boolean z;
        if (this.gED != null && this.gEX != null && this.gEX.bAZ() != null) {
            boolean z2 = false;
            Iterator<ICardInfo> it = this.gEX.bAZ().iterator();
            while (true) {
                z = z2;
                if (!it.hasNext()) {
                    break;
                }
                z2 = it.next().responseAttention(obj) ? true : z;
            }
            if (z) {
                this.gED.notifyDataSetChanged();
            }
        }
    }

    private void init(Context context, boolean z) {
        com.baidu.adp.base.e<?> aK = com.baidu.adp.base.i.aK(context);
        aK.registerListener(this.mAttentionListener);
        aK.registerListener(this.mLikeForumListener);
        aK.registerListener(this.mUnlikeForumListener);
        if (aK instanceof TbPageContext) {
            this.pageContext = (TbPageContext) aK;
        }
        this.Pi = new BdListView(context);
        this.Pi.setDividerHeight(0);
        this.Pi.setSelector(17170445);
        addView(this.Pi);
        if (!z) {
            this.Pi.setVerticalScrollBarEnabled(true);
            aX(context);
        } else {
            this.Pi.setTranscriptMode(1);
            this.Pi.setVerticalScrollBarEnabled(false);
        }
        this.Pi.setOnSrollToBottomListener(this);
        this.Pi.setOnScrollListener(this);
        bzx();
        this.gED = new com.baidu.tieba.lego.b.a(this.pageContext);
        this.Pi.setAdapter((ListAdapter) this.gED);
        this.ccb = TbadkCoreApplication.getInst().getResources().getDimensionPixelSize(d.e.ds120);
        onChangeSkinType(TbadkCoreApplication.getInst().getSkinType());
    }

    public BdListView getListView() {
        return this.Pi;
    }

    public void i(BdUniqueId bdUniqueId) {
        if (bdUniqueId != null) {
            if (this.mPullView != null) {
                this.mPullView.setTag(bdUniqueId);
            }
            this.gFa.setTag(bdUniqueId);
            MessageManager.getInstance().registerListener(this.gFa);
        }
    }

    public void setCallback(d dVar) {
        this.gET = dVar;
    }

    public void setScrollCallback(g gVar) {
        this.gEV = gVar;
    }

    public void setViewBackGround() {
        ji(true);
    }

    public com.baidu.tieba.lego.card.view.l getPlaySwitchController() {
        return this.gEY;
    }

    public void setViewForeground() {
        ji(false);
        if (this.gEY != null) {
            this.gEY.md(true);
            this.gEY.c(this.fay, this.cZV, this.fbe, true);
        }
        if (!this.gES && !this.gER) {
            if (this.gEQ && !com.baidu.adp.lib.util.l.lo()) {
                if (this.gED.isEmpty()) {
                    this.gED.a(NoDataViewFactory.c.a(NoDataViewFactory.ImgType.NODATA, this.ccb), NoDataViewFactory.d.hU(d.j.neterror), null, null);
                    this.gED.notifyDataSetChanged();
                }
            } else if (this.gEZ) {
                this.gEZ = false;
                com.baidu.adp.lib.g.e.jH().postDelayed(new Runnable() { // from class: com.baidu.tieba.lego.LegoListView.5
                    @Override // java.lang.Runnable
                    public void run() {
                        LegoListView.this.bzw();
                    }
                }, 200L);
            } else {
                bzw();
            }
        }
    }

    public void onDestory() {
        if (this.gEY != null) {
            this.gEY.destroy();
        }
    }

    /* JADX INFO: Access modifiers changed from: private */
    public void bzw() {
        a(this, false, getResources().getDimensionPixelSize(d.e.ds300));
        arL();
    }

    private void aX(Context context) {
        this.mPullView = new com.baidu.tbadk.core.view.i(this.pageContext);
        this.Pi.setPullRefresh(this.mPullView);
        this.dbr = new PbListView(context);
        this.dbr.oM();
        this.dbr.ib(d.C0236d.cp_bg_line_c);
        this.dbr.setTextColor(al.getColor(d.C0236d.cp_cont_d));
        this.dbr.ic(TbadkCoreApplication.getInst().getSkinType());
        this.mPullView.setListPullRefreshListener(new a());
    }

    private void bzx() {
        this.gEY = new com.baidu.tieba.lego.card.view.l(this.pageContext, this.Pi);
        this.fvR = new com.baidu.tieba.f.a();
        this.fvR.a(this.dMw);
        this.Pi.setOnTouchListener(this.ccU);
        this.Pi.setRecyclerListener(new AbsListView.RecyclerListener() { // from class: com.baidu.tieba.lego.LegoListView.8
            @Override // android.widget.AbsListView.RecyclerListener
            public void onMovedToScrapHeap(View view) {
                if (LegoListView.this.gEY != null) {
                    LegoListView.this.gEY.cb(view);
                }
            }
        });
    }

    public void a(com.baidu.tieba.lego.c.c cVar, boolean z) {
        if (this.Pi != null) {
            this.Pi.completePullRefresh();
        }
        if (this.dbr != null) {
            this.dbr.aeD();
        }
        if (cVar == null) {
            setHasMore(false);
            bY(this);
            this.gED.a(NoDataViewFactory.c.a(NoDataViewFactory.ImgType.NODATA, this.ccb), NoDataViewFactory.d.hU(d.j.invite_friend_no_data_now), null, null);
            this.gED.notifyDataSetChanged();
            return;
        }
        this.gEX = cVar;
        this.eoH = false;
        this.gER = cVar.bBc();
        this.gEQ = cVar.bBb();
        this.gES = cVar.bBi();
        this.gEW = cVar.bBd();
        setHasMore(cVar.hasMore());
        List<ICardInfo> bAZ = cVar.bAZ();
        if (this.gED != null) {
            if (bAZ == null || bAZ.size() <= 0) {
                if (this.gEQ && this.gER) {
                    this.gED.a(NoDataViewFactory.c.a(NoDataViewFactory.ImgType.NODATA, this.ccb), NoDataViewFactory.d.hU(d.j.invite_friend_no_data_now), null, null);
                } else {
                    this.gED.a(null, null, null, null);
                }
                setHasMore(false);
            } else if (this.dbr != null) {
                if (this.dbr.getView().getParent() == null) {
                    this.Pi.setNextPage(this.dbr);
                }
                if (this.mHasMore) {
                    this.dbr.setText(getContext().getString(d.j.pb_load_more));
                } else if (bAZ.get(bAZ.size() - 1) instanceof WebViewCard) {
                    this.dbr.setText("");
                } else {
                    this.dbr.setText(getContext().getString(d.j.list_no_more));
                }
            }
            this.gED.dj(bAZ);
        }
        if (z) {
            this.Pi.setSelection(cVar.bBa());
        }
        if (this.gER || (bAZ != null && !bAZ.isEmpty())) {
            bY(this);
        }
    }

    private void setHasMore(boolean z) {
        this.mHasMore = z;
        if (this.Pi != null && this.dbr != null) {
            if (!this.gEQ) {
                this.dbr.setText("");
            } else if (this.mHasMore) {
                this.dbr.setText(getContext().getString(d.j.pb_load_more));
            } else {
                this.dbr.setText("");
            }
        }
    }

    /* JADX INFO: Access modifiers changed from: private */
    public void arL() {
        if (this.gEQ) {
            this.gET.a(1, this.gEW.gKW, this.gEW.itemId, "");
        } else {
            this.gET.i(this.gEW.gKW, this.gEW.itemId);
        }
    }

    public void xR(String str) {
        if (this.Pi != null) {
            this.Pi.completePullRefresh();
        }
        this.eoH = false;
        if (this.dbr != null) {
            this.dbr.aeD();
        }
        if (this.gED.getCount() <= 0 && this.gEQ) {
            this.gED.a(NoDataViewFactory.c.a(NoDataViewFactory.ImgType.NODATA, this.ccb), NoDataViewFactory.d.no(str), null, null);
            this.gED.dj(new ArrayList());
        }
        bY(this);
    }

    @Override // android.widget.AbsListView.OnScrollListener
    public void onScroll(AbsListView absListView, int i, int i2, int i3) {
        this.fay = i;
        this.cZV = (i + i2) - 1;
    }

    @Override // com.baidu.adp.widget.ListView.BdListView.e
    public void onScrollToBottom() {
        if (this.mHasMore && com.baidu.adp.lib.util.l.lo() && !this.eoH) {
            this.eoH = true;
            if (this.dbr != null) {
                this.dbr.aeC();
            }
            if (this.gET != null) {
                if (this.gED == null) {
                    this.gET.a(1, this.gEW.gKW, this.gEW.itemId, "");
                } else if (this.gEX != null) {
                    this.gET.a(this.gEX.getPn() + 1, this.gEW.gKW, this.gEW.itemId, this.gEX.bBe());
                }
            }
        }
    }

    @SuppressLint({"ResourceAsColor"})
    public void onChangeSkinType(int i) {
        com.baidu.tbadk.r.a.a(this.pageContext, this);
        al.f(this.Pi, d.C0236d.cp_bg_line_c, i);
        if (this.gED != null) {
            this.gED.notifyDataSetChanged();
        }
        if (this.mPullView != null) {
            this.mPullView.ic(i);
        }
        if (this.dbr != null) {
            this.dbr.ic(i);
        }
    }

    public boolean n(long j, String str) {
        return this.gEW != null && j == this.gEW.gKW && TextUtils.equals(str, this.gEW.itemId);
    }

    @Override // android.widget.AbsListView.OnScrollListener
    public void onScrollStateChanged(AbsListView absListView, int i) {
        if (i == 0) {
            MessageManager.getInstance().dispatchResponsedMessage(new CustomResponsedMessage(2016449, -1));
            if (this.gEV != null && this.gEW != null) {
                this.gEV.a(this.gEW, this.Pi.getFirstVisiblePosition());
            }
            bzu();
        }
    }

    private void ji(boolean z) {
        if (this.Pi != null) {
            int i = 0;
            while (true) {
                int i2 = i;
                if (i2 < this.Pi.getChildCount()) {
                    View childAt = this.Pi.getChildAt(i2);
                    if (childAt instanceof com.baidu.tieba.lego.card.view.e) {
                        if (z) {
                            ((com.baidu.tieba.lego.card.view.e) childAt).Pq();
                        } else {
                            ((com.baidu.tieba.lego.card.view.e) childAt).bAk();
                        }
                    }
                    i = i2 + 1;
                } else {
                    return;
                }
            }
        }
    }

    private void bzu() {
        if (this.Pi != null) {
            int i = 0;
            while (true) {
                int i2 = i;
                if (i2 >= this.Pi.getChildCount()) {
                    break;
                }
                View childAt = this.Pi.getChildAt(i2);
                if (childAt instanceof com.baidu.tieba.lego.card.view.e) {
                    ((com.baidu.tieba.lego.card.view.e) childAt).bAj();
                }
                i = i2 + 1;
            }
            if (this.gEY != null) {
                this.gEY.a(this.fay, this.cZV, this.fbe, 1);
            }
        }
    }

    /* JADX INFO: Access modifiers changed from: private */
    /* loaded from: classes2.dex */
    public class a implements h.c {
        private a() {
        }

        @Override // com.baidu.tbadk.core.view.h.c
        public void dR(boolean z) {
            if (LegoListView.this.gET != null) {
                LegoListView.this.arL();
            }
        }
    }

    private void a(View view, boolean z, int i) {
        if (this.gEU == null) {
            if (i < 0) {
                this.gEU = new com.baidu.tbadk.m.g(getContext());
            } else {
                this.gEU = new com.baidu.tbadk.m.g(getContext(), i);
            }
            this.gEU.onChangeSkinType();
        }
        this.gEU.attachView(view, z);
        if (this.mPullView != null) {
            this.mPullView.setEnable(false);
        }
        if (this.gED != null) {
            this.gED.lV(false);
            this.gED.notifyDataSetChanged();
        }
    }

    private void bY(View view) {
        if (this.gEU != null) {
            this.gEU.dettachView(view);
            this.gEU = null;
        }
        if (this.mPullView != null) {
            this.mPullView.setEnable(true);
        }
        if (this.gED != null) {
            this.gED.lV(true);
            this.gED.notifyDataSetChanged();
        }
    }

    public void setFriction(float f) {
        if (this.Pi != null) {
            this.Pi.setFriction(f);
        }
    }
}
