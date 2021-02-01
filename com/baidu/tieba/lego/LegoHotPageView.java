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
import com.baidu.tbadk.core.util.ap;
import com.baidu.tbadk.core.view.PbListView;
import com.baidu.tbadk.core.view.f;
import com.baidu.tbadk.coreExtra.message.UpdateAttentionMessage;
import com.baidu.tieba.R;
import com.baidu.tieba.lego.card.model.ICardInfo;
import com.baidu.tieba.lego.h;
import java.util.Iterator;
import java.util.List;
import tbclient.Lego.DataRes;
/* loaded from: classes9.dex */
public class LegoHotPageView extends FrameLayout implements AbsListView.OnScrollListener {
    private CustomMessageListener faJ;
    private PbListView gAi;
    private com.baidu.tbadk.l.g gJn;
    private BdListView iCf;
    private String itemId;
    private com.baidu.tieba.lego.c.e kZs;
    com.baidu.tieba.lego.b.a kZt;
    private c kZu;
    private h kZv;
    private long kZw;
    private h.a kZx;
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
        if (this.kZt != null && this.kZv != null && this.kZv.getDataList() != null) {
            boolean z2 = false;
            Iterator<ICardInfo> it = this.kZv.getDataList().iterator();
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

    public LegoHotPageView(Context context) {
        super(context);
        this.faJ = new CustomMessageListener(CmdConfigCustom.CMD_UPDATE_ATTENTION) { // from class: com.baidu.tieba.lego.LegoHotPageView.1
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
                    bVar.ePK = true;
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
                    bVar.ePK = false;
                    LegoHotPageView.this.aM(bVar);
                }
            }
        };
        this.kZx = new h.a() { // from class: com.baidu.tieba.lego.LegoHotPageView.4
            @Override // com.baidu.tieba.lego.h.a
            public void r(long j, String str) {
                boolean cqM = LegoHotPageView.this.cqM();
                LegoHotPageView.this.WZ();
                if (cqM) {
                    LegoHotPageView.this.C(true, LegoHotPageView.this.getResources().getDimensionPixelSize(R.dimen.ds360));
                }
                if (LegoHotPageView.this.kZu != null) {
                    LegoHotPageView.this.kZu.o(j, str);
                }
            }

            @Override // com.baidu.tieba.lego.h.a
            public void bI(int i, String str) {
                if (LegoHotPageView.this.kZu != null && LegoHotPageView.this.kZs != null) {
                    LegoHotPageView.this.kZu.a(LegoHotPageView.this.kZs.lfE, LegoHotPageView.this.kZs.itemId, i, str);
                }
            }

            @Override // com.baidu.tieba.lego.h.a
            public void onError(int i, String str) {
                LegoHotPageView.this.hideLoadingView();
                if (i != 1) {
                    LegoHotPageView.this.iCf.setVisibility(8);
                    LegoHotPageView.this.showNetRefreshView(LegoHotPageView.this, str, true);
                } else if (com.baidu.adp.lib.util.j.isNetWorkAvailable()) {
                    LegoHotPageView.this.pageContext.showToast(str);
                }
            }

            @Override // com.baidu.tieba.lego.h.a
            public void onSuccess() {
                LegoHotPageView.this.hideLoadingView();
                LegoHotPageView.this.WZ();
                LegoHotPageView.this.iCf.setVisibility(0);
            }

            @Override // com.baidu.tieba.lego.h.a
            public void c(String str, String str2, String str3, List<com.baidu.tieba.lego.c.e> list) {
                if (LegoHotPageView.this.kZu != null) {
                    LegoHotPageView.this.kZu.b(str, str2, str3, list);
                }
            }

            @Override // com.baidu.tieba.lego.h.a
            public void eF(List<com.baidu.tieba.lego.c.d> list) {
                if (LegoHotPageView.this.kZu != null) {
                    LegoHotPageView.this.kZu.eF(list);
                }
            }
        };
        init(context);
    }

    public LegoHotPageView(Context context, AttributeSet attributeSet) {
        super(context, attributeSet);
        this.faJ = new CustomMessageListener(CmdConfigCustom.CMD_UPDATE_ATTENTION) { // from class: com.baidu.tieba.lego.LegoHotPageView.1
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
                    bVar.ePK = true;
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
                    bVar.ePK = false;
                    LegoHotPageView.this.aM(bVar);
                }
            }
        };
        this.kZx = new h.a() { // from class: com.baidu.tieba.lego.LegoHotPageView.4
            @Override // com.baidu.tieba.lego.h.a
            public void r(long j, String str) {
                boolean cqM = LegoHotPageView.this.cqM();
                LegoHotPageView.this.WZ();
                if (cqM) {
                    LegoHotPageView.this.C(true, LegoHotPageView.this.getResources().getDimensionPixelSize(R.dimen.ds360));
                }
                if (LegoHotPageView.this.kZu != null) {
                    LegoHotPageView.this.kZu.o(j, str);
                }
            }

            @Override // com.baidu.tieba.lego.h.a
            public void bI(int i, String str) {
                if (LegoHotPageView.this.kZu != null && LegoHotPageView.this.kZs != null) {
                    LegoHotPageView.this.kZu.a(LegoHotPageView.this.kZs.lfE, LegoHotPageView.this.kZs.itemId, i, str);
                }
            }

            @Override // com.baidu.tieba.lego.h.a
            public void onError(int i, String str) {
                LegoHotPageView.this.hideLoadingView();
                if (i != 1) {
                    LegoHotPageView.this.iCf.setVisibility(8);
                    LegoHotPageView.this.showNetRefreshView(LegoHotPageView.this, str, true);
                } else if (com.baidu.adp.lib.util.j.isNetWorkAvailable()) {
                    LegoHotPageView.this.pageContext.showToast(str);
                }
            }

            @Override // com.baidu.tieba.lego.h.a
            public void onSuccess() {
                LegoHotPageView.this.hideLoadingView();
                LegoHotPageView.this.WZ();
                LegoHotPageView.this.iCf.setVisibility(0);
            }

            @Override // com.baidu.tieba.lego.h.a
            public void c(String str, String str2, String str3, List<com.baidu.tieba.lego.c.e> list) {
                if (LegoHotPageView.this.kZu != null) {
                    LegoHotPageView.this.kZu.b(str, str2, str3, list);
                }
            }

            @Override // com.baidu.tieba.lego.h.a
            public void eF(List<com.baidu.tieba.lego.c.d> list) {
                if (LegoHotPageView.this.kZu != null) {
                    LegoHotPageView.this.kZu.eF(list);
                }
            }
        };
        init(context);
    }

    public LegoHotPageView(Context context, AttributeSet attributeSet, int i) {
        super(context, attributeSet, i);
        this.faJ = new CustomMessageListener(CmdConfigCustom.CMD_UPDATE_ATTENTION) { // from class: com.baidu.tieba.lego.LegoHotPageView.1
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
                    bVar.ePK = true;
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
                    bVar.ePK = false;
                    LegoHotPageView.this.aM(bVar);
                }
            }
        };
        this.kZx = new h.a() { // from class: com.baidu.tieba.lego.LegoHotPageView.4
            @Override // com.baidu.tieba.lego.h.a
            public void r(long j, String str) {
                boolean cqM = LegoHotPageView.this.cqM();
                LegoHotPageView.this.WZ();
                if (cqM) {
                    LegoHotPageView.this.C(true, LegoHotPageView.this.getResources().getDimensionPixelSize(R.dimen.ds360));
                }
                if (LegoHotPageView.this.kZu != null) {
                    LegoHotPageView.this.kZu.o(j, str);
                }
            }

            @Override // com.baidu.tieba.lego.h.a
            public void bI(int i2, String str) {
                if (LegoHotPageView.this.kZu != null && LegoHotPageView.this.kZs != null) {
                    LegoHotPageView.this.kZu.a(LegoHotPageView.this.kZs.lfE, LegoHotPageView.this.kZs.itemId, i2, str);
                }
            }

            @Override // com.baidu.tieba.lego.h.a
            public void onError(int i2, String str) {
                LegoHotPageView.this.hideLoadingView();
                if (i2 != 1) {
                    LegoHotPageView.this.iCf.setVisibility(8);
                    LegoHotPageView.this.showNetRefreshView(LegoHotPageView.this, str, true);
                } else if (com.baidu.adp.lib.util.j.isNetWorkAvailable()) {
                    LegoHotPageView.this.pageContext.showToast(str);
                }
            }

            @Override // com.baidu.tieba.lego.h.a
            public void onSuccess() {
                LegoHotPageView.this.hideLoadingView();
                LegoHotPageView.this.WZ();
                LegoHotPageView.this.iCf.setVisibility(0);
            }

            @Override // com.baidu.tieba.lego.h.a
            public void c(String str, String str2, String str3, List<com.baidu.tieba.lego.c.e> list) {
                if (LegoHotPageView.this.kZu != null) {
                    LegoHotPageView.this.kZu.b(str, str2, str3, list);
                }
            }

            @Override // com.baidu.tieba.lego.h.a
            public void eF(List<com.baidu.tieba.lego.c.d> list) {
                if (LegoHotPageView.this.kZu != null) {
                    LegoHotPageView.this.kZu.eF(list);
                }
            }
        };
        init(context);
    }

    private void init(Context context) {
        com.baidu.adp.base.f<?> K = com.baidu.adp.base.j.K(context);
        K.registerListener(this.faJ);
        K.registerListener(this.mLikeForumListener);
        K.registerListener(this.mUnlikeForumListener);
        if (K instanceof TbPageContext) {
            this.pageContext = (TbPageContext) K;
        }
        this.iCf = new BdListView(context);
        this.iCf.setDividerHeight(0);
        this.iCf.setSelector(17170445);
        this.kZt = new com.baidu.tieba.lego.b.a(this.pageContext);
        this.iCf.setAdapter((ListAdapter) this.kZt);
        this.gAi = new PbListView(context);
        this.gAi.createView();
        this.gAi.setContainerBackgroundColorResId(R.color.CAM_X0204);
        this.gAi.setTextColor(ap.getColor(R.color.CAM_X0109));
        this.gAi.changeSkin(TbadkCoreApplication.getInst().getSkinType());
        this.mPullView = new com.baidu.tbadk.core.view.g(this.pageContext);
        this.iCf.setPullRefresh(this.mPullView);
        this.mPullView.setEnable(true);
        this.mPullView.setListPullRefreshListener(new f.c() { // from class: com.baidu.tieba.lego.LegoHotPageView.5
            @Override // com.baidu.tbadk.core.view.f.c
            public void onListPullRefresh(boolean z) {
                LegoHotPageView.this.kZv.s(LegoHotPageView.this.kZw, LegoHotPageView.this.itemId);
            }
        });
        this.iCf.setOnSrollToBottomListener(new BdListView.e() { // from class: com.baidu.tieba.lego.LegoHotPageView.6
            @Override // com.baidu.adp.widget.ListView.BdListView.e
            public void onScrollToBottom() {
                if (LegoHotPageView.this.mHasMore) {
                    if (LegoHotPageView.this.gAi != null) {
                        LegoHotPageView.this.gAi.startLoadData();
                    }
                    LegoHotPageView.this.kZv.bRc();
                }
            }
        });
        this.iCf.setOnScrollListener(this);
        this.kZv = new h(this.iCf, this.kZt);
        this.kZv.a(this.kZx);
        addView(this.iCf);
    }

    public void setViewBackGround() {
        qJ(true);
    }

    public void setViewForeground() {
        qJ(false);
    }

    public void qJ(boolean z) {
        if (this.iCf != null) {
            int i = 0;
            while (true) {
                int i2 = i;
                if (i2 < this.iCf.getChildCount()) {
                    View childAt = this.iCf.getChildAt(i2);
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

    public void setCallback(c cVar) {
        this.kZu = cVar;
    }

    public void setTagInfo(com.baidu.tieba.lego.c.e eVar) {
        this.kZs = eVar;
    }

    public void a(DataRes dataRes, boolean z) {
        if (this.gAi != null) {
            this.gAi.endLoadData();
        }
        this.kZv.a(z, dataRes, 0, null);
        setHasMore(this.kZv.isHasMore());
    }

    private void setHasMore(boolean z) {
        this.mHasMore = z;
        if (this.iCf != null) {
            if (this.gAi.getView().getParent() == null) {
                this.iCf.setNextPage(this.gAi);
            }
            if (this.mHasMore) {
                this.gAi.setText(getContext().getString(R.string.pb_load_more));
            } else {
                this.gAi.setText("");
            }
        }
    }

    public void onChangeSkinType(int i) {
        if (this.gJn != null) {
            this.gJn.onChangeSkinType();
        }
        if (this.refreshView != null) {
            this.refreshView.onChangeSkinType();
        }
        if (this.mPullView != null) {
            this.mPullView.changeSkin(i);
        }
        if (this.iCf != null) {
            ap.setBackgroundColor(this.iCf, R.color.CAM_X0204, i);
        }
        if (this.gAi != null) {
            this.gAi.setTextColor(ap.getColor(R.color.CAM_X0109));
            this.gAi.changeSkin(i);
        }
    }

    public long getTagCode() {
        if (this.kZs == null) {
            return 0L;
        }
        return this.kZs.lfE;
    }

    public void bd(String str, int i) {
        if (this.gAi != null) {
            this.gAi.endLoadData();
        }
        this.kZv.a(true, null, i, str);
    }

    /* JADX INFO: Access modifiers changed from: private */
    public void showNetRefreshView(View view, String str, boolean z) {
        if (this.refreshView == null) {
            this.refreshView = new com.baidu.tbadk.l.h(getContext(), new View.OnClickListener() { // from class: com.baidu.tieba.lego.LegoHotPageView.7
                @Override // android.view.View.OnClickListener
                public void onClick(View view2) {
                    if (LegoHotPageView.this.kZv != null) {
                        if (LegoHotPageView.this.kZs != null) {
                            LegoHotPageView.this.kZv.s(LegoHotPageView.this.kZs.lfE, LegoHotPageView.this.kZs.itemId);
                        } else {
                            LegoHotPageView.this.kZv.s(LegoHotPageView.this.kZw, LegoHotPageView.this.itemId);
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
    public void WZ() {
        if (this.refreshView != null) {
            this.refreshView.dettachView(this);
            this.refreshView = null;
        }
    }

    /* JADX INFO: Access modifiers changed from: private */
    public void hideLoadingView() {
        if (this.gJn != null) {
            this.gJn.dettachView(this);
            this.gJn = null;
        }
        if (this.kZu != null) {
            this.kZu.cPo();
        }
    }

    /* JADX INFO: Access modifiers changed from: private */
    public boolean cqM() {
        return this.refreshView != null && this.refreshView.isViewAttached();
    }

    /* JADX INFO: Access modifiers changed from: private */
    public void C(boolean z, int i) {
        if (this.gJn == null) {
            if (i < 0) {
                this.gJn = new com.baidu.tbadk.l.g(getContext());
            } else {
                this.gJn = new com.baidu.tbadk.l.g(getContext(), i);
            }
            this.gJn.onChangeSkinType();
        }
        this.gJn.attachView(this, z);
    }

    public void q(long j, String str) {
        this.kZw = j;
        this.itemId = str;
        if (this.kZv != null) {
            this.kZv.s(j, str);
        }
    }

    @Override // android.widget.AbsListView.OnScrollListener
    public void onScrollStateChanged(AbsListView absListView, int i) {
        if (i == 0) {
            MessageManager.getInstance().dispatchResponsedMessage(new CustomResponsedMessage(CmdConfigCustom.CMD_LEGO_SWITCH_TAB, -1));
            dbe();
        }
    }

    private void dbe() {
        if (this.iCf != null) {
            int i = 0;
            while (true) {
                int i2 = i;
                if (i2 < this.iCf.getChildCount()) {
                    View childAt = this.iCf.getChildAt(i2);
                    if (childAt instanceof com.baidu.tieba.lego.card.view.e) {
                        ((com.baidu.tieba.lego.card.view.e) childAt).dbT();
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
