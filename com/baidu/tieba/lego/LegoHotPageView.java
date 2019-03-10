package com.baidu.tieba.lego;

import android.content.Context;
import android.util.AttributeSet;
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
import com.baidu.tbadk.core.view.PbListView;
import com.baidu.tbadk.core.view.h;
import com.baidu.tbadk.coreExtra.message.UpdateAttentionMessage;
import com.baidu.tieba.d;
import com.baidu.tieba.lego.card.model.ICardInfo;
import com.baidu.tieba.lego.h;
import java.util.Iterator;
import java.util.List;
import tbclient.Lego.DataRes;
/* loaded from: classes2.dex */
public class LegoHotPageView extends FrameLayout implements AbsListView.OnScrollListener {
    private com.baidu.tbadk.m.g cXq;
    private PbListView dbr;
    private BdListView eqp;
    private com.baidu.tieba.lego.c.e gEC;
    com.baidu.tieba.lego.b.a gED;
    private c gEE;
    private h gEF;
    private long gEG;
    private h.a gEH;
    private String itemId;
    private CustomMessageListener mAttentionListener;
    private boolean mHasMore;
    private CustomMessageListener mLikeForumListener;
    private com.baidu.tbadk.core.view.i mPullView;
    private CustomMessageListener mUnlikeForumListener;
    private TbPageContext<?> pageContext;
    private com.baidu.tbadk.m.h refreshView;

    public void setPageUniqueId(BdUniqueId bdUniqueId) {
        if (this.mPullView != null) {
            this.mPullView.setTag(bdUniqueId);
        }
    }

    /* JADX INFO: Access modifiers changed from: private */
    public void av(Object obj) {
        boolean z;
        if (this.gED != null && this.gEF != null && this.gEF.getDataList() != null) {
            boolean z2 = false;
            Iterator<ICardInfo> it = this.gEF.getDataList().iterator();
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

    public LegoHotPageView(Context context) {
        super(context);
        this.mAttentionListener = new CustomMessageListener(2001115) { // from class: com.baidu.tieba.lego.LegoHotPageView.1
            /* JADX DEBUG: Method merged with bridge method */
            @Override // com.baidu.adp.framework.listener.MessageListener
            public void onMessage(CustomResponsedMessage<?> customResponsedMessage) {
                UpdateAttentionMessage updateAttentionMessage = (UpdateAttentionMessage) customResponsedMessage;
                if (updateAttentionMessage != null && updateAttentionMessage.getData() != null && updateAttentionMessage.getData().Jy) {
                    LegoHotPageView.this.av(updateAttentionMessage.getData());
                }
            }
        };
        this.mLikeForumListener = new CustomMessageListener(2001335) { // from class: com.baidu.tieba.lego.LegoHotPageView.2
            /* JADX DEBUG: Method merged with bridge method */
            @Override // com.baidu.adp.framework.listener.MessageListener
            public void onMessage(CustomResponsedMessage<?> customResponsedMessage) {
                if (customResponsedMessage != null && (customResponsedMessage.getData() instanceof Long)) {
                    com.baidu.tieba.lego.c.b bVar = new com.baidu.tieba.lego.c.b();
                    bVar.fid = String.valueOf(customResponsedMessage.getData());
                    bVar.bAw = true;
                    LegoHotPageView.this.av(bVar);
                }
            }
        };
        this.mUnlikeForumListener = new CustomMessageListener(2001336) { // from class: com.baidu.tieba.lego.LegoHotPageView.3
            /* JADX DEBUG: Method merged with bridge method */
            @Override // com.baidu.adp.framework.listener.MessageListener
            public void onMessage(CustomResponsedMessage<?> customResponsedMessage) {
                if (customResponsedMessage != null && (customResponsedMessage.getData() instanceof Long)) {
                    com.baidu.tieba.lego.c.b bVar = new com.baidu.tieba.lego.c.b();
                    bVar.fid = String.valueOf(customResponsedMessage.getData());
                    bVar.bAw = false;
                    LegoHotPageView.this.av(bVar);
                }
            }
        };
        this.gEH = new h.a() { // from class: com.baidu.tieba.lego.LegoHotPageView.4
            @Override // com.baidu.tieba.lego.h.a
            public void k(long j, String str) {
                boolean aXs = LegoHotPageView.this.aXs();
                LegoHotPageView.this.aBu();
                if (aXs) {
                    LegoHotPageView.this.o(true, LegoHotPageView.this.getResources().getDimensionPixelSize(d.e.ds360));
                }
                if (LegoHotPageView.this.gEE != null) {
                    LegoHotPageView.this.gEE.h(j, str);
                }
            }

            @Override // com.baidu.tieba.lego.h.a
            public void ao(int i, String str) {
                if (LegoHotPageView.this.gEE != null && LegoHotPageView.this.gEC != null) {
                    LegoHotPageView.this.gEE.a(LegoHotPageView.this.gEC.gKW, LegoHotPageView.this.gEC.itemId, i, str);
                }
            }

            @Override // com.baidu.tieba.lego.h.a
            public void onError(int i, String str) {
                LegoHotPageView.this.hideLoadingView();
                if (i != 1) {
                    LegoHotPageView.this.eqp.setVisibility(8);
                    LegoHotPageView.this.showNetRefreshView(LegoHotPageView.this, str, true);
                } else if (com.baidu.adp.lib.util.j.kY()) {
                    LegoHotPageView.this.pageContext.showToast(str);
                }
            }

            @Override // com.baidu.tieba.lego.h.a
            public void onSuccess() {
                LegoHotPageView.this.hideLoadingView();
                LegoHotPageView.this.aBu();
                LegoHotPageView.this.eqp.setVisibility(0);
            }

            @Override // com.baidu.tieba.lego.h.a
            public void c(String str, String str2, String str3, List<com.baidu.tieba.lego.c.e> list) {
                if (LegoHotPageView.this.gEE != null) {
                    LegoHotPageView.this.gEE.b(str, str2, str3, list);
                }
            }

            @Override // com.baidu.tieba.lego.h.a
            public void de(List<com.baidu.tieba.lego.c.d> list) {
                if (LegoHotPageView.this.gEE != null) {
                    LegoHotPageView.this.gEE.de(list);
                }
            }
        };
        init(context);
    }

    public LegoHotPageView(Context context, AttributeSet attributeSet) {
        super(context, attributeSet);
        this.mAttentionListener = new CustomMessageListener(2001115) { // from class: com.baidu.tieba.lego.LegoHotPageView.1
            /* JADX DEBUG: Method merged with bridge method */
            @Override // com.baidu.adp.framework.listener.MessageListener
            public void onMessage(CustomResponsedMessage<?> customResponsedMessage) {
                UpdateAttentionMessage updateAttentionMessage = (UpdateAttentionMessage) customResponsedMessage;
                if (updateAttentionMessage != null && updateAttentionMessage.getData() != null && updateAttentionMessage.getData().Jy) {
                    LegoHotPageView.this.av(updateAttentionMessage.getData());
                }
            }
        };
        this.mLikeForumListener = new CustomMessageListener(2001335) { // from class: com.baidu.tieba.lego.LegoHotPageView.2
            /* JADX DEBUG: Method merged with bridge method */
            @Override // com.baidu.adp.framework.listener.MessageListener
            public void onMessage(CustomResponsedMessage<?> customResponsedMessage) {
                if (customResponsedMessage != null && (customResponsedMessage.getData() instanceof Long)) {
                    com.baidu.tieba.lego.c.b bVar = new com.baidu.tieba.lego.c.b();
                    bVar.fid = String.valueOf(customResponsedMessage.getData());
                    bVar.bAw = true;
                    LegoHotPageView.this.av(bVar);
                }
            }
        };
        this.mUnlikeForumListener = new CustomMessageListener(2001336) { // from class: com.baidu.tieba.lego.LegoHotPageView.3
            /* JADX DEBUG: Method merged with bridge method */
            @Override // com.baidu.adp.framework.listener.MessageListener
            public void onMessage(CustomResponsedMessage<?> customResponsedMessage) {
                if (customResponsedMessage != null && (customResponsedMessage.getData() instanceof Long)) {
                    com.baidu.tieba.lego.c.b bVar = new com.baidu.tieba.lego.c.b();
                    bVar.fid = String.valueOf(customResponsedMessage.getData());
                    bVar.bAw = false;
                    LegoHotPageView.this.av(bVar);
                }
            }
        };
        this.gEH = new h.a() { // from class: com.baidu.tieba.lego.LegoHotPageView.4
            @Override // com.baidu.tieba.lego.h.a
            public void k(long j, String str) {
                boolean aXs = LegoHotPageView.this.aXs();
                LegoHotPageView.this.aBu();
                if (aXs) {
                    LegoHotPageView.this.o(true, LegoHotPageView.this.getResources().getDimensionPixelSize(d.e.ds360));
                }
                if (LegoHotPageView.this.gEE != null) {
                    LegoHotPageView.this.gEE.h(j, str);
                }
            }

            @Override // com.baidu.tieba.lego.h.a
            public void ao(int i, String str) {
                if (LegoHotPageView.this.gEE != null && LegoHotPageView.this.gEC != null) {
                    LegoHotPageView.this.gEE.a(LegoHotPageView.this.gEC.gKW, LegoHotPageView.this.gEC.itemId, i, str);
                }
            }

            @Override // com.baidu.tieba.lego.h.a
            public void onError(int i, String str) {
                LegoHotPageView.this.hideLoadingView();
                if (i != 1) {
                    LegoHotPageView.this.eqp.setVisibility(8);
                    LegoHotPageView.this.showNetRefreshView(LegoHotPageView.this, str, true);
                } else if (com.baidu.adp.lib.util.j.kY()) {
                    LegoHotPageView.this.pageContext.showToast(str);
                }
            }

            @Override // com.baidu.tieba.lego.h.a
            public void onSuccess() {
                LegoHotPageView.this.hideLoadingView();
                LegoHotPageView.this.aBu();
                LegoHotPageView.this.eqp.setVisibility(0);
            }

            @Override // com.baidu.tieba.lego.h.a
            public void c(String str, String str2, String str3, List<com.baidu.tieba.lego.c.e> list) {
                if (LegoHotPageView.this.gEE != null) {
                    LegoHotPageView.this.gEE.b(str, str2, str3, list);
                }
            }

            @Override // com.baidu.tieba.lego.h.a
            public void de(List<com.baidu.tieba.lego.c.d> list) {
                if (LegoHotPageView.this.gEE != null) {
                    LegoHotPageView.this.gEE.de(list);
                }
            }
        };
        init(context);
    }

    public LegoHotPageView(Context context, AttributeSet attributeSet, int i) {
        super(context, attributeSet, i);
        this.mAttentionListener = new CustomMessageListener(2001115) { // from class: com.baidu.tieba.lego.LegoHotPageView.1
            /* JADX DEBUG: Method merged with bridge method */
            @Override // com.baidu.adp.framework.listener.MessageListener
            public void onMessage(CustomResponsedMessage<?> customResponsedMessage) {
                UpdateAttentionMessage updateAttentionMessage = (UpdateAttentionMessage) customResponsedMessage;
                if (updateAttentionMessage != null && updateAttentionMessage.getData() != null && updateAttentionMessage.getData().Jy) {
                    LegoHotPageView.this.av(updateAttentionMessage.getData());
                }
            }
        };
        this.mLikeForumListener = new CustomMessageListener(2001335) { // from class: com.baidu.tieba.lego.LegoHotPageView.2
            /* JADX DEBUG: Method merged with bridge method */
            @Override // com.baidu.adp.framework.listener.MessageListener
            public void onMessage(CustomResponsedMessage<?> customResponsedMessage) {
                if (customResponsedMessage != null && (customResponsedMessage.getData() instanceof Long)) {
                    com.baidu.tieba.lego.c.b bVar = new com.baidu.tieba.lego.c.b();
                    bVar.fid = String.valueOf(customResponsedMessage.getData());
                    bVar.bAw = true;
                    LegoHotPageView.this.av(bVar);
                }
            }
        };
        this.mUnlikeForumListener = new CustomMessageListener(2001336) { // from class: com.baidu.tieba.lego.LegoHotPageView.3
            /* JADX DEBUG: Method merged with bridge method */
            @Override // com.baidu.adp.framework.listener.MessageListener
            public void onMessage(CustomResponsedMessage<?> customResponsedMessage) {
                if (customResponsedMessage != null && (customResponsedMessage.getData() instanceof Long)) {
                    com.baidu.tieba.lego.c.b bVar = new com.baidu.tieba.lego.c.b();
                    bVar.fid = String.valueOf(customResponsedMessage.getData());
                    bVar.bAw = false;
                    LegoHotPageView.this.av(bVar);
                }
            }
        };
        this.gEH = new h.a() { // from class: com.baidu.tieba.lego.LegoHotPageView.4
            @Override // com.baidu.tieba.lego.h.a
            public void k(long j, String str) {
                boolean aXs = LegoHotPageView.this.aXs();
                LegoHotPageView.this.aBu();
                if (aXs) {
                    LegoHotPageView.this.o(true, LegoHotPageView.this.getResources().getDimensionPixelSize(d.e.ds360));
                }
                if (LegoHotPageView.this.gEE != null) {
                    LegoHotPageView.this.gEE.h(j, str);
                }
            }

            @Override // com.baidu.tieba.lego.h.a
            public void ao(int i2, String str) {
                if (LegoHotPageView.this.gEE != null && LegoHotPageView.this.gEC != null) {
                    LegoHotPageView.this.gEE.a(LegoHotPageView.this.gEC.gKW, LegoHotPageView.this.gEC.itemId, i2, str);
                }
            }

            @Override // com.baidu.tieba.lego.h.a
            public void onError(int i2, String str) {
                LegoHotPageView.this.hideLoadingView();
                if (i2 != 1) {
                    LegoHotPageView.this.eqp.setVisibility(8);
                    LegoHotPageView.this.showNetRefreshView(LegoHotPageView.this, str, true);
                } else if (com.baidu.adp.lib.util.j.kY()) {
                    LegoHotPageView.this.pageContext.showToast(str);
                }
            }

            @Override // com.baidu.tieba.lego.h.a
            public void onSuccess() {
                LegoHotPageView.this.hideLoadingView();
                LegoHotPageView.this.aBu();
                LegoHotPageView.this.eqp.setVisibility(0);
            }

            @Override // com.baidu.tieba.lego.h.a
            public void c(String str, String str2, String str3, List<com.baidu.tieba.lego.c.e> list) {
                if (LegoHotPageView.this.gEE != null) {
                    LegoHotPageView.this.gEE.b(str, str2, str3, list);
                }
            }

            @Override // com.baidu.tieba.lego.h.a
            public void de(List<com.baidu.tieba.lego.c.d> list) {
                if (LegoHotPageView.this.gEE != null) {
                    LegoHotPageView.this.gEE.de(list);
                }
            }
        };
        init(context);
    }

    private void init(Context context) {
        com.baidu.adp.base.e<?> aK = com.baidu.adp.base.i.aK(context);
        aK.registerListener(this.mAttentionListener);
        aK.registerListener(this.mLikeForumListener);
        aK.registerListener(this.mUnlikeForumListener);
        if (aK instanceof TbPageContext) {
            this.pageContext = (TbPageContext) aK;
        }
        this.eqp = new BdListView(context);
        this.eqp.setDividerHeight(0);
        this.eqp.setSelector(17170445);
        this.gED = new com.baidu.tieba.lego.b.a(this.pageContext);
        this.eqp.setAdapter((ListAdapter) this.gED);
        this.dbr = new PbListView(context);
        this.dbr.oM();
        this.dbr.ib(d.C0236d.cp_bg_line_c);
        this.dbr.setTextColor(al.getColor(d.C0236d.cp_cont_d));
        this.dbr.ic(TbadkCoreApplication.getInst().getSkinType());
        this.mPullView = new com.baidu.tbadk.core.view.i(this.pageContext);
        this.eqp.setPullRefresh(this.mPullView);
        this.mPullView.setEnable(true);
        this.mPullView.setListPullRefreshListener(new h.c() { // from class: com.baidu.tieba.lego.LegoHotPageView.5
            @Override // com.baidu.tbadk.core.view.h.c
            public void dR(boolean z) {
                LegoHotPageView.this.gEF.l(LegoHotPageView.this.gEG, LegoHotPageView.this.itemId);
            }
        });
        this.eqp.setOnSrollToBottomListener(new BdListView.e() { // from class: com.baidu.tieba.lego.LegoHotPageView.6
            @Override // com.baidu.adp.widget.ListView.BdListView.e
            public void onScrollToBottom() {
                if (LegoHotPageView.this.mHasMore) {
                    if (LegoHotPageView.this.dbr != null) {
                        LegoHotPageView.this.dbr.aeC();
                    }
                    LegoHotPageView.this.gEF.aBd();
                }
            }
        });
        this.eqp.setOnScrollListener(this);
        this.gEF = new h(this.eqp, this.gED);
        this.gEF.a(this.gEH);
        addView(this.eqp);
    }

    public void setViewBackGround() {
        ji(true);
    }

    public void setViewForeground() {
        ji(false);
    }

    public void ji(boolean z) {
        if (this.eqp != null) {
            int i = 0;
            while (true) {
                int i2 = i;
                if (i2 < this.eqp.getChildCount()) {
                    View childAt = this.eqp.getChildAt(i2);
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

    public void setCallback(c cVar) {
        this.gEE = cVar;
    }

    public void setTagInfo(com.baidu.tieba.lego.c.e eVar) {
        this.gEC = eVar;
    }

    public void a(DataRes dataRes, boolean z) {
        if (this.dbr != null) {
            this.dbr.aeD();
        }
        this.gEF.a(z, dataRes, 0, null);
        setHasMore(this.gEF.isHasMore());
    }

    private void setHasMore(boolean z) {
        this.mHasMore = z;
        if (this.eqp != null) {
            if (this.dbr.getView().getParent() == null) {
                this.eqp.setNextPage(this.dbr);
            }
            if (this.mHasMore) {
                this.dbr.setText(getContext().getString(d.j.pb_load_more));
            } else {
                this.dbr.setText("");
            }
        }
    }

    public void onChangeSkinType(int i) {
        if (this.cXq != null) {
            this.cXq.onChangeSkinType();
        }
        if (this.refreshView != null) {
            this.refreshView.onChangeSkinType();
        }
        if (this.mPullView != null) {
            this.mPullView.ic(i);
        }
        if (this.eqp != null) {
            al.f(this.eqp, d.C0236d.cp_bg_line_c, i);
        }
        if (this.dbr != null) {
            this.dbr.setTextColor(al.getColor(d.C0236d.cp_cont_d));
            this.dbr.ic(i);
        }
    }

    public long getTagCode() {
        if (this.gEC == null) {
            return 0L;
        }
        return this.gEC.gKW;
    }

    public void aC(String str, int i) {
        if (this.dbr != null) {
            this.dbr.aeD();
        }
        this.gEF.a(true, null, i, str);
    }

    /* JADX INFO: Access modifiers changed from: private */
    public void showNetRefreshView(View view, String str, boolean z) {
        if (this.refreshView == null) {
            this.refreshView = new com.baidu.tbadk.m.h(getContext(), new View.OnClickListener() { // from class: com.baidu.tieba.lego.LegoHotPageView.7
                @Override // android.view.View.OnClickListener
                public void onClick(View view2) {
                    if (LegoHotPageView.this.gEF != null) {
                        if (LegoHotPageView.this.gEC != null) {
                            LegoHotPageView.this.gEF.l(LegoHotPageView.this.gEC.gKW, LegoHotPageView.this.gEC.itemId);
                        } else {
                            LegoHotPageView.this.gEF.l(LegoHotPageView.this.gEG, LegoHotPageView.this.itemId);
                        }
                    }
                }
            });
        }
        this.refreshView.jR(getResources().getDimensionPixelSize(d.e.ds160));
        this.refreshView.po(str);
        this.refreshView.attachView(view, z);
        this.refreshView.anC();
    }

    /* JADX INFO: Access modifiers changed from: private */
    public void aBu() {
        if (this.refreshView != null) {
            this.refreshView.dettachView(this);
            this.refreshView = null;
        }
    }

    /* JADX INFO: Access modifiers changed from: private */
    public void hideLoadingView() {
        if (this.cXq != null) {
            this.cXq.dettachView(this);
            this.cXq = null;
        }
        if (this.gEE != null) {
            this.gEE.blS();
        }
    }

    /* JADX INFO: Access modifiers changed from: private */
    public boolean aXs() {
        return this.refreshView != null && this.refreshView.isViewAttached();
    }

    /* JADX INFO: Access modifiers changed from: private */
    public void o(boolean z, int i) {
        if (this.cXq == null) {
            if (i < 0) {
                this.cXq = new com.baidu.tbadk.m.g(getContext());
            } else {
                this.cXq = new com.baidu.tbadk.m.g(getContext(), i);
            }
            this.cXq.onChangeSkinType();
        }
        this.cXq.attachView(this, z);
    }

    public void j(long j, String str) {
        this.gEG = j;
        this.itemId = str;
        if (this.gEF != null) {
            this.gEF.l(j, str);
        }
    }

    @Override // android.widget.AbsListView.OnScrollListener
    public void onScrollStateChanged(AbsListView absListView, int i) {
        if (i == 0) {
            MessageManager.getInstance().dispatchResponsedMessage(new CustomResponsedMessage(2016449, -1));
            bzu();
        }
    }

    private void bzu() {
        if (this.eqp != null) {
            int i = 0;
            while (true) {
                int i2 = i;
                if (i2 < this.eqp.getChildCount()) {
                    View childAt = this.eqp.getChildAt(i2);
                    if (childAt instanceof com.baidu.tieba.lego.card.view.e) {
                        ((com.baidu.tieba.lego.card.view.e) childAt).bAj();
                    }
                    i = i2 + 1;
                } else {
                    return;
                }
            }
        }
    }

    @Override // android.widget.AbsListView.OnScrollListener
    public void onScroll(AbsListView absListView, int i, int i2, int i3) {
    }
}
