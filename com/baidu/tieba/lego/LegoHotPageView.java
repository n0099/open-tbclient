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
import com.baidu.live.tbadk.core.frameworkdata.CmdConfigCustom;
import com.baidu.tbadk.TbPageContext;
import com.baidu.tbadk.core.TbadkCoreApplication;
import com.baidu.tbadk.core.util.ao;
import com.baidu.tbadk.core.view.PbListView;
import com.baidu.tbadk.core.view.f;
import com.baidu.tbadk.coreExtra.message.UpdateAttentionMessage;
import com.baidu.tieba.R;
import com.baidu.tieba.lego.card.model.ICardInfo;
import com.baidu.tieba.lego.h;
import java.util.Iterator;
import java.util.List;
import tbclient.Lego.DataRes;
/* loaded from: classes8.dex */
public class LegoHotPageView extends FrameLayout implements AbsListView.OnScrollListener {
    private CustomMessageListener eYu;
    private com.baidu.tbadk.l.g gGD;
    private PbListView gxy;
    private String itemId;
    private BdListView iwv;
    private com.baidu.tieba.lego.c.e kRq;
    com.baidu.tieba.lego.b.a kRr;
    private c kRs;
    private h kRt;
    private long kRu;
    private h.a kRv;
    private boolean mHasMore;
    private CustomMessageListener mLikeForumListener;
    private com.baidu.tbadk.core.view.g mPullView;
    private CustomMessageListener mUnlikeForumListener;
    private TbPageContext<?> pageContext;
    private com.baidu.tbadk.l.h refreshView;

    public void setPageUniqueId(BdUniqueId bdUniqueId) {
        if (this.mPullView != null) {
            this.mPullView.setTag(bdUniqueId);
        }
    }

    /* JADX INFO: Access modifiers changed from: private */
    public void aM(Object obj) {
        boolean z;
        if (this.kRr != null && this.kRt != null && this.kRt.getDataList() != null) {
            boolean z2 = false;
            Iterator<ICardInfo> it = this.kRt.getDataList().iterator();
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

    public LegoHotPageView(Context context) {
        super(context);
        this.eYu = new CustomMessageListener(CmdConfigCustom.CMD_UPDATE_ATTENTION) { // from class: com.baidu.tieba.lego.LegoHotPageView.1
            /* JADX DEBUG: Method merged with bridge method */
            @Override // com.baidu.adp.framework.listener.MessageListener
            public void onMessage(CustomResponsedMessage<?> customResponsedMessage) {
                UpdateAttentionMessage updateAttentionMessage = (UpdateAttentionMessage) customResponsedMessage;
                if (updateAttentionMessage != null && updateAttentionMessage.getData() != null && updateAttentionMessage.getData().isSucc) {
                    LegoHotPageView.this.aM(updateAttentionMessage.getData());
                }
            }
        };
        this.mLikeForumListener = new CustomMessageListener(CmdConfigCustom.CMD_LIKE_FORUM) { // from class: com.baidu.tieba.lego.LegoHotPageView.2
            /* JADX DEBUG: Method merged with bridge method */
            @Override // com.baidu.adp.framework.listener.MessageListener
            public void onMessage(CustomResponsedMessage<?> customResponsedMessage) {
                if (customResponsedMessage != null && (customResponsedMessage.getData() instanceof Long)) {
                    com.baidu.tieba.lego.c.b bVar = new com.baidu.tieba.lego.c.b();
                    bVar.fid = String.valueOf(customResponsedMessage.getData());
                    bVar.eNy = true;
                    LegoHotPageView.this.aM(bVar);
                }
            }
        };
        this.mUnlikeForumListener = new CustomMessageListener(CmdConfigCustom.CMD_UNLIKE_FORUM) { // from class: com.baidu.tieba.lego.LegoHotPageView.3
            /* JADX DEBUG: Method merged with bridge method */
            @Override // com.baidu.adp.framework.listener.MessageListener
            public void onMessage(CustomResponsedMessage<?> customResponsedMessage) {
                if (customResponsedMessage != null && (customResponsedMessage.getData() instanceof Long)) {
                    com.baidu.tieba.lego.c.b bVar = new com.baidu.tieba.lego.c.b();
                    bVar.fid = String.valueOf(customResponsedMessage.getData());
                    bVar.eNy = false;
                    LegoHotPageView.this.aM(bVar);
                }
            }
        };
        this.kRv = new h.a() { // from class: com.baidu.tieba.lego.LegoHotPageView.4
            @Override // com.baidu.tieba.lego.h.a
            public void q(long j, String str) {
                boolean cpC = LegoHotPageView.this.cpC();
                LegoHotPageView.this.Vq();
                if (cpC) {
                    LegoHotPageView.this.C(true, LegoHotPageView.this.getResources().getDimensionPixelSize(R.dimen.ds360));
                }
                if (LegoHotPageView.this.kRs != null) {
                    LegoHotPageView.this.kRs.n(j, str);
                }
            }

            @Override // com.baidu.tieba.lego.h.a
            public void bC(int i, String str) {
                if (LegoHotPageView.this.kRs != null && LegoHotPageView.this.kRq != null) {
                    LegoHotPageView.this.kRs.a(LegoHotPageView.this.kRq.kXA, LegoHotPageView.this.kRq.itemId, i, str);
                }
            }

            @Override // com.baidu.tieba.lego.h.a
            public void onError(int i, String str) {
                LegoHotPageView.this.hideLoadingView();
                if (i != 1) {
                    LegoHotPageView.this.iwv.setVisibility(8);
                    LegoHotPageView.this.showNetRefreshView(LegoHotPageView.this, str, true);
                } else if (com.baidu.adp.lib.util.j.isNetWorkAvailable()) {
                    LegoHotPageView.this.pageContext.showToast(str);
                }
            }

            @Override // com.baidu.tieba.lego.h.a
            public void onSuccess() {
                LegoHotPageView.this.hideLoadingView();
                LegoHotPageView.this.Vq();
                LegoHotPageView.this.iwv.setVisibility(0);
            }

            @Override // com.baidu.tieba.lego.h.a
            public void c(String str, String str2, String str3, List<com.baidu.tieba.lego.c.e> list) {
                if (LegoHotPageView.this.kRs != null) {
                    LegoHotPageView.this.kRs.b(str, str2, str3, list);
                }
            }

            @Override // com.baidu.tieba.lego.h.a
            public void eH(List<com.baidu.tieba.lego.c.d> list) {
                if (LegoHotPageView.this.kRs != null) {
                    LegoHotPageView.this.kRs.eH(list);
                }
            }
        };
        init(context);
    }

    public LegoHotPageView(Context context, AttributeSet attributeSet) {
        super(context, attributeSet);
        this.eYu = new CustomMessageListener(CmdConfigCustom.CMD_UPDATE_ATTENTION) { // from class: com.baidu.tieba.lego.LegoHotPageView.1
            /* JADX DEBUG: Method merged with bridge method */
            @Override // com.baidu.adp.framework.listener.MessageListener
            public void onMessage(CustomResponsedMessage<?> customResponsedMessage) {
                UpdateAttentionMessage updateAttentionMessage = (UpdateAttentionMessage) customResponsedMessage;
                if (updateAttentionMessage != null && updateAttentionMessage.getData() != null && updateAttentionMessage.getData().isSucc) {
                    LegoHotPageView.this.aM(updateAttentionMessage.getData());
                }
            }
        };
        this.mLikeForumListener = new CustomMessageListener(CmdConfigCustom.CMD_LIKE_FORUM) { // from class: com.baidu.tieba.lego.LegoHotPageView.2
            /* JADX DEBUG: Method merged with bridge method */
            @Override // com.baidu.adp.framework.listener.MessageListener
            public void onMessage(CustomResponsedMessage<?> customResponsedMessage) {
                if (customResponsedMessage != null && (customResponsedMessage.getData() instanceof Long)) {
                    com.baidu.tieba.lego.c.b bVar = new com.baidu.tieba.lego.c.b();
                    bVar.fid = String.valueOf(customResponsedMessage.getData());
                    bVar.eNy = true;
                    LegoHotPageView.this.aM(bVar);
                }
            }
        };
        this.mUnlikeForumListener = new CustomMessageListener(CmdConfigCustom.CMD_UNLIKE_FORUM) { // from class: com.baidu.tieba.lego.LegoHotPageView.3
            /* JADX DEBUG: Method merged with bridge method */
            @Override // com.baidu.adp.framework.listener.MessageListener
            public void onMessage(CustomResponsedMessage<?> customResponsedMessage) {
                if (customResponsedMessage != null && (customResponsedMessage.getData() instanceof Long)) {
                    com.baidu.tieba.lego.c.b bVar = new com.baidu.tieba.lego.c.b();
                    bVar.fid = String.valueOf(customResponsedMessage.getData());
                    bVar.eNy = false;
                    LegoHotPageView.this.aM(bVar);
                }
            }
        };
        this.kRv = new h.a() { // from class: com.baidu.tieba.lego.LegoHotPageView.4
            @Override // com.baidu.tieba.lego.h.a
            public void q(long j, String str) {
                boolean cpC = LegoHotPageView.this.cpC();
                LegoHotPageView.this.Vq();
                if (cpC) {
                    LegoHotPageView.this.C(true, LegoHotPageView.this.getResources().getDimensionPixelSize(R.dimen.ds360));
                }
                if (LegoHotPageView.this.kRs != null) {
                    LegoHotPageView.this.kRs.n(j, str);
                }
            }

            @Override // com.baidu.tieba.lego.h.a
            public void bC(int i, String str) {
                if (LegoHotPageView.this.kRs != null && LegoHotPageView.this.kRq != null) {
                    LegoHotPageView.this.kRs.a(LegoHotPageView.this.kRq.kXA, LegoHotPageView.this.kRq.itemId, i, str);
                }
            }

            @Override // com.baidu.tieba.lego.h.a
            public void onError(int i, String str) {
                LegoHotPageView.this.hideLoadingView();
                if (i != 1) {
                    LegoHotPageView.this.iwv.setVisibility(8);
                    LegoHotPageView.this.showNetRefreshView(LegoHotPageView.this, str, true);
                } else if (com.baidu.adp.lib.util.j.isNetWorkAvailable()) {
                    LegoHotPageView.this.pageContext.showToast(str);
                }
            }

            @Override // com.baidu.tieba.lego.h.a
            public void onSuccess() {
                LegoHotPageView.this.hideLoadingView();
                LegoHotPageView.this.Vq();
                LegoHotPageView.this.iwv.setVisibility(0);
            }

            @Override // com.baidu.tieba.lego.h.a
            public void c(String str, String str2, String str3, List<com.baidu.tieba.lego.c.e> list) {
                if (LegoHotPageView.this.kRs != null) {
                    LegoHotPageView.this.kRs.b(str, str2, str3, list);
                }
            }

            @Override // com.baidu.tieba.lego.h.a
            public void eH(List<com.baidu.tieba.lego.c.d> list) {
                if (LegoHotPageView.this.kRs != null) {
                    LegoHotPageView.this.kRs.eH(list);
                }
            }
        };
        init(context);
    }

    public LegoHotPageView(Context context, AttributeSet attributeSet, int i) {
        super(context, attributeSet, i);
        this.eYu = new CustomMessageListener(CmdConfigCustom.CMD_UPDATE_ATTENTION) { // from class: com.baidu.tieba.lego.LegoHotPageView.1
            /* JADX DEBUG: Method merged with bridge method */
            @Override // com.baidu.adp.framework.listener.MessageListener
            public void onMessage(CustomResponsedMessage<?> customResponsedMessage) {
                UpdateAttentionMessage updateAttentionMessage = (UpdateAttentionMessage) customResponsedMessage;
                if (updateAttentionMessage != null && updateAttentionMessage.getData() != null && updateAttentionMessage.getData().isSucc) {
                    LegoHotPageView.this.aM(updateAttentionMessage.getData());
                }
            }
        };
        this.mLikeForumListener = new CustomMessageListener(CmdConfigCustom.CMD_LIKE_FORUM) { // from class: com.baidu.tieba.lego.LegoHotPageView.2
            /* JADX DEBUG: Method merged with bridge method */
            @Override // com.baidu.adp.framework.listener.MessageListener
            public void onMessage(CustomResponsedMessage<?> customResponsedMessage) {
                if (customResponsedMessage != null && (customResponsedMessage.getData() instanceof Long)) {
                    com.baidu.tieba.lego.c.b bVar = new com.baidu.tieba.lego.c.b();
                    bVar.fid = String.valueOf(customResponsedMessage.getData());
                    bVar.eNy = true;
                    LegoHotPageView.this.aM(bVar);
                }
            }
        };
        this.mUnlikeForumListener = new CustomMessageListener(CmdConfigCustom.CMD_UNLIKE_FORUM) { // from class: com.baidu.tieba.lego.LegoHotPageView.3
            /* JADX DEBUG: Method merged with bridge method */
            @Override // com.baidu.adp.framework.listener.MessageListener
            public void onMessage(CustomResponsedMessage<?> customResponsedMessage) {
                if (customResponsedMessage != null && (customResponsedMessage.getData() instanceof Long)) {
                    com.baidu.tieba.lego.c.b bVar = new com.baidu.tieba.lego.c.b();
                    bVar.fid = String.valueOf(customResponsedMessage.getData());
                    bVar.eNy = false;
                    LegoHotPageView.this.aM(bVar);
                }
            }
        };
        this.kRv = new h.a() { // from class: com.baidu.tieba.lego.LegoHotPageView.4
            @Override // com.baidu.tieba.lego.h.a
            public void q(long j, String str) {
                boolean cpC = LegoHotPageView.this.cpC();
                LegoHotPageView.this.Vq();
                if (cpC) {
                    LegoHotPageView.this.C(true, LegoHotPageView.this.getResources().getDimensionPixelSize(R.dimen.ds360));
                }
                if (LegoHotPageView.this.kRs != null) {
                    LegoHotPageView.this.kRs.n(j, str);
                }
            }

            @Override // com.baidu.tieba.lego.h.a
            public void bC(int i2, String str) {
                if (LegoHotPageView.this.kRs != null && LegoHotPageView.this.kRq != null) {
                    LegoHotPageView.this.kRs.a(LegoHotPageView.this.kRq.kXA, LegoHotPageView.this.kRq.itemId, i2, str);
                }
            }

            @Override // com.baidu.tieba.lego.h.a
            public void onError(int i2, String str) {
                LegoHotPageView.this.hideLoadingView();
                if (i2 != 1) {
                    LegoHotPageView.this.iwv.setVisibility(8);
                    LegoHotPageView.this.showNetRefreshView(LegoHotPageView.this, str, true);
                } else if (com.baidu.adp.lib.util.j.isNetWorkAvailable()) {
                    LegoHotPageView.this.pageContext.showToast(str);
                }
            }

            @Override // com.baidu.tieba.lego.h.a
            public void onSuccess() {
                LegoHotPageView.this.hideLoadingView();
                LegoHotPageView.this.Vq();
                LegoHotPageView.this.iwv.setVisibility(0);
            }

            @Override // com.baidu.tieba.lego.h.a
            public void c(String str, String str2, String str3, List<com.baidu.tieba.lego.c.e> list) {
                if (LegoHotPageView.this.kRs != null) {
                    LegoHotPageView.this.kRs.b(str, str2, str3, list);
                }
            }

            @Override // com.baidu.tieba.lego.h.a
            public void eH(List<com.baidu.tieba.lego.c.d> list) {
                if (LegoHotPageView.this.kRs != null) {
                    LegoHotPageView.this.kRs.eH(list);
                }
            }
        };
        init(context);
    }

    private void init(Context context) {
        com.baidu.adp.base.f<?> K = com.baidu.adp.base.j.K(context);
        K.registerListener(this.eYu);
        K.registerListener(this.mLikeForumListener);
        K.registerListener(this.mUnlikeForumListener);
        if (K instanceof TbPageContext) {
            this.pageContext = (TbPageContext) K;
        }
        this.iwv = new BdListView(context);
        this.iwv.setDividerHeight(0);
        this.iwv.setSelector(17170445);
        this.kRr = new com.baidu.tieba.lego.b.a(this.pageContext);
        this.iwv.setAdapter((ListAdapter) this.kRr);
        this.gxy = new PbListView(context);
        this.gxy.createView();
        this.gxy.setContainerBackgroundColorResId(R.color.CAM_X0204);
        this.gxy.setTextColor(ao.getColor(R.color.CAM_X0109));
        this.gxy.changeSkin(TbadkCoreApplication.getInst().getSkinType());
        this.mPullView = new com.baidu.tbadk.core.view.g(this.pageContext);
        this.iwv.setPullRefresh(this.mPullView);
        this.mPullView.setEnable(true);
        this.mPullView.setListPullRefreshListener(new f.c() { // from class: com.baidu.tieba.lego.LegoHotPageView.5
            @Override // com.baidu.tbadk.core.view.f.c
            public void onListPullRefresh(boolean z) {
                LegoHotPageView.this.kRt.r(LegoHotPageView.this.kRu, LegoHotPageView.this.itemId);
            }
        });
        this.iwv.setOnSrollToBottomListener(new BdListView.e() { // from class: com.baidu.tieba.lego.LegoHotPageView.6
            @Override // com.baidu.adp.widget.ListView.BdListView.e
            public void onScrollToBottom() {
                if (LegoHotPageView.this.mHasMore) {
                    if (LegoHotPageView.this.gxy != null) {
                        LegoHotPageView.this.gxy.startLoadData();
                    }
                    LegoHotPageView.this.kRt.bQy();
                }
            }
        });
        this.iwv.setOnScrollListener(this);
        this.kRt = new h(this.iwv, this.kRr);
        this.kRt.a(this.kRv);
        addView(this.iwv);
    }

    public void setViewBackGround() {
        qz(true);
    }

    public void setViewForeground() {
        qz(false);
    }

    public void qz(boolean z) {
        if (this.iwv != null) {
            int i = 0;
            while (true) {
                int i2 = i;
                if (i2 < this.iwv.getChildCount()) {
                    View childAt = this.iwv.getChildAt(i2);
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

    public void setCallback(c cVar) {
        this.kRs = cVar;
    }

    public void setTagInfo(com.baidu.tieba.lego.c.e eVar) {
        this.kRq = eVar;
    }

    public void a(DataRes dataRes, boolean z) {
        if (this.gxy != null) {
            this.gxy.endLoadData();
        }
        this.kRt.a(z, dataRes, 0, null);
        setHasMore(this.kRt.isHasMore());
    }

    private void setHasMore(boolean z) {
        this.mHasMore = z;
        if (this.iwv != null) {
            if (this.gxy.getView().getParent() == null) {
                this.iwv.setNextPage(this.gxy);
            }
            if (this.mHasMore) {
                this.gxy.setText(getContext().getString(R.string.pb_load_more));
            } else {
                this.gxy.setText("");
            }
        }
    }

    public void onChangeSkinType(int i) {
        if (this.gGD != null) {
            this.gGD.onChangeSkinType();
        }
        if (this.refreshView != null) {
            this.refreshView.onChangeSkinType();
        }
        if (this.mPullView != null) {
            this.mPullView.changeSkin(i);
        }
        if (this.iwv != null) {
            ao.setBackgroundColor(this.iwv, R.color.CAM_X0204, i);
        }
        if (this.gxy != null) {
            this.gxy.setTextColor(ao.getColor(R.color.CAM_X0109));
            this.gxy.changeSkin(i);
        }
    }

    public long getTagCode() {
        if (this.kRq == null) {
            return 0L;
        }
        return this.kRq.kXA;
    }

    public void bd(String str, int i) {
        if (this.gxy != null) {
            this.gxy.endLoadData();
        }
        this.kRt.a(true, null, i, str);
    }

    /* JADX INFO: Access modifiers changed from: private */
    public void showNetRefreshView(View view, String str, boolean z) {
        if (this.refreshView == null) {
            this.refreshView = new com.baidu.tbadk.l.h(getContext(), new View.OnClickListener() { // from class: com.baidu.tieba.lego.LegoHotPageView.7
                @Override // android.view.View.OnClickListener
                public void onClick(View view2) {
                    if (LegoHotPageView.this.kRt != null) {
                        if (LegoHotPageView.this.kRq != null) {
                            LegoHotPageView.this.kRt.r(LegoHotPageView.this.kRq.kXA, LegoHotPageView.this.kRq.itemId);
                        } else {
                            LegoHotPageView.this.kRt.r(LegoHotPageView.this.kRu, LegoHotPageView.this.itemId);
                        }
                    }
                }
            });
        }
        this.refreshView.setLayoutMargin(getResources().getDimensionPixelSize(R.dimen.ds160));
        this.refreshView.setSubText(str);
        this.refreshView.attachView(view, z);
        this.refreshView.showRefreshButton();
    }

    /* JADX INFO: Access modifiers changed from: private */
    public void Vq() {
        if (this.refreshView != null) {
            this.refreshView.dettachView(this);
            this.refreshView = null;
        }
    }

    /* JADX INFO: Access modifiers changed from: private */
    public void hideLoadingView() {
        if (this.gGD != null) {
            this.gGD.dettachView(this);
            this.gGD = null;
        }
        if (this.kRs != null) {
            this.kRs.cNs();
        }
    }

    /* JADX INFO: Access modifiers changed from: private */
    public boolean cpC() {
        return this.refreshView != null && this.refreshView.isViewAttached();
    }

    /* JADX INFO: Access modifiers changed from: private */
    public void C(boolean z, int i) {
        if (this.gGD == null) {
            if (i < 0) {
                this.gGD = new com.baidu.tbadk.l.g(getContext());
            } else {
                this.gGD = new com.baidu.tbadk.l.g(getContext(), i);
            }
            this.gGD.onChangeSkinType();
        }
        this.gGD.attachView(this, z);
    }

    public void p(long j, String str) {
        this.kRu = j;
        this.itemId = str;
        if (this.kRt != null) {
            this.kRt.r(j, str);
        }
    }

    @Override // android.widget.AbsListView.OnScrollListener
    public void onScrollStateChanged(AbsListView absListView, int i) {
        if (i == 0) {
            MessageManager.getInstance().dispatchResponsedMessage(new CustomResponsedMessage(CmdConfigCustom.CMD_LEGO_SWITCH_TAB, -1));
            cZg();
        }
    }

    private void cZg() {
        if (this.iwv != null) {
            int i = 0;
            while (true) {
                int i2 = i;
                if (i2 < this.iwv.getChildCount()) {
                    View childAt = this.iwv.getChildAt(i2);
                    if (childAt instanceof com.baidu.tieba.lego.card.view.e) {
                        ((com.baidu.tieba.lego.card.view.e) childAt).cZV();
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
