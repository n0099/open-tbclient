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
/* loaded from: classes8.dex */
public class LegoHotPageView extends FrameLayout implements AbsListView.OnScrollListener {
    private CustomMessageListener fci;
    private PbListView gCf;
    private com.baidu.tbadk.l.g gLk;
    private BdListView iEc;
    private String itemId;
    private com.baidu.tieba.lego.c.e lbJ;
    com.baidu.tieba.lego.b.a lbK;
    private c lbL;
    private h lbM;
    private long lbN;
    private h.a lbO;
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
    public void aO(Object obj) {
        boolean z;
        if (this.lbK != null && this.lbM != null && this.lbM.getDataList() != null) {
            boolean z2 = false;
            Iterator<ICardInfo> it = this.lbM.getDataList().iterator();
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

    public LegoHotPageView(Context context) {
        super(context);
        this.fci = new CustomMessageListener(CmdConfigCustom.CMD_UPDATE_ATTENTION) { // from class: com.baidu.tieba.lego.LegoHotPageView.1
            /* JADX DEBUG: Method merged with bridge method */
            @Override // com.baidu.adp.framework.listener.MessageListener
            public void onMessage(CustomResponsedMessage<?> customResponsedMessage) {
                UpdateAttentionMessage updateAttentionMessage = (UpdateAttentionMessage) customResponsedMessage;
                if (updateAttentionMessage != null && updateAttentionMessage.getData() != null && updateAttentionMessage.getData().isSucc) {
                    LegoHotPageView.this.aO(updateAttentionMessage.getData());
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
                    bVar.eRl = true;
                    LegoHotPageView.this.aO(bVar);
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
                    bVar.eRl = false;
                    LegoHotPageView.this.aO(bVar);
                }
            }
        };
        this.lbO = new h.a() { // from class: com.baidu.tieba.lego.LegoHotPageView.4
            @Override // com.baidu.tieba.lego.h.a
            public void r(long j, String str) {
                boolean cqZ = LegoHotPageView.this.cqZ();
                LegoHotPageView.this.Xc();
                if (cqZ) {
                    LegoHotPageView.this.C(true, LegoHotPageView.this.getResources().getDimensionPixelSize(R.dimen.ds360));
                }
                if (LegoHotPageView.this.lbL != null) {
                    LegoHotPageView.this.lbL.o(j, str);
                }
            }

            @Override // com.baidu.tieba.lego.h.a
            public void bI(int i, String str) {
                if (LegoHotPageView.this.lbL != null && LegoHotPageView.this.lbJ != null) {
                    LegoHotPageView.this.lbL.a(LegoHotPageView.this.lbJ.lhU, LegoHotPageView.this.lbJ.itemId, i, str);
                }
            }

            @Override // com.baidu.tieba.lego.h.a
            public void onError(int i, String str) {
                LegoHotPageView.this.hideLoadingView();
                if (i != 1) {
                    LegoHotPageView.this.iEc.setVisibility(8);
                    LegoHotPageView.this.showNetRefreshView(LegoHotPageView.this, str, true);
                } else if (com.baidu.adp.lib.util.j.isNetWorkAvailable()) {
                    LegoHotPageView.this.pageContext.showToast(str);
                }
            }

            @Override // com.baidu.tieba.lego.h.a
            public void onSuccess() {
                LegoHotPageView.this.hideLoadingView();
                LegoHotPageView.this.Xc();
                LegoHotPageView.this.iEc.setVisibility(0);
            }

            @Override // com.baidu.tieba.lego.h.a
            public void c(String str, String str2, String str3, List<com.baidu.tieba.lego.c.e> list) {
                if (LegoHotPageView.this.lbL != null) {
                    LegoHotPageView.this.lbL.b(str, str2, str3, list);
                }
            }

            @Override // com.baidu.tieba.lego.h.a
            public void eF(List<com.baidu.tieba.lego.c.d> list) {
                if (LegoHotPageView.this.lbL != null) {
                    LegoHotPageView.this.lbL.eF(list);
                }
            }
        };
        init(context);
    }

    public LegoHotPageView(Context context, AttributeSet attributeSet) {
        super(context, attributeSet);
        this.fci = new CustomMessageListener(CmdConfigCustom.CMD_UPDATE_ATTENTION) { // from class: com.baidu.tieba.lego.LegoHotPageView.1
            /* JADX DEBUG: Method merged with bridge method */
            @Override // com.baidu.adp.framework.listener.MessageListener
            public void onMessage(CustomResponsedMessage<?> customResponsedMessage) {
                UpdateAttentionMessage updateAttentionMessage = (UpdateAttentionMessage) customResponsedMessage;
                if (updateAttentionMessage != null && updateAttentionMessage.getData() != null && updateAttentionMessage.getData().isSucc) {
                    LegoHotPageView.this.aO(updateAttentionMessage.getData());
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
                    bVar.eRl = true;
                    LegoHotPageView.this.aO(bVar);
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
                    bVar.eRl = false;
                    LegoHotPageView.this.aO(bVar);
                }
            }
        };
        this.lbO = new h.a() { // from class: com.baidu.tieba.lego.LegoHotPageView.4
            @Override // com.baidu.tieba.lego.h.a
            public void r(long j, String str) {
                boolean cqZ = LegoHotPageView.this.cqZ();
                LegoHotPageView.this.Xc();
                if (cqZ) {
                    LegoHotPageView.this.C(true, LegoHotPageView.this.getResources().getDimensionPixelSize(R.dimen.ds360));
                }
                if (LegoHotPageView.this.lbL != null) {
                    LegoHotPageView.this.lbL.o(j, str);
                }
            }

            @Override // com.baidu.tieba.lego.h.a
            public void bI(int i, String str) {
                if (LegoHotPageView.this.lbL != null && LegoHotPageView.this.lbJ != null) {
                    LegoHotPageView.this.lbL.a(LegoHotPageView.this.lbJ.lhU, LegoHotPageView.this.lbJ.itemId, i, str);
                }
            }

            @Override // com.baidu.tieba.lego.h.a
            public void onError(int i, String str) {
                LegoHotPageView.this.hideLoadingView();
                if (i != 1) {
                    LegoHotPageView.this.iEc.setVisibility(8);
                    LegoHotPageView.this.showNetRefreshView(LegoHotPageView.this, str, true);
                } else if (com.baidu.adp.lib.util.j.isNetWorkAvailable()) {
                    LegoHotPageView.this.pageContext.showToast(str);
                }
            }

            @Override // com.baidu.tieba.lego.h.a
            public void onSuccess() {
                LegoHotPageView.this.hideLoadingView();
                LegoHotPageView.this.Xc();
                LegoHotPageView.this.iEc.setVisibility(0);
            }

            @Override // com.baidu.tieba.lego.h.a
            public void c(String str, String str2, String str3, List<com.baidu.tieba.lego.c.e> list) {
                if (LegoHotPageView.this.lbL != null) {
                    LegoHotPageView.this.lbL.b(str, str2, str3, list);
                }
            }

            @Override // com.baidu.tieba.lego.h.a
            public void eF(List<com.baidu.tieba.lego.c.d> list) {
                if (LegoHotPageView.this.lbL != null) {
                    LegoHotPageView.this.lbL.eF(list);
                }
            }
        };
        init(context);
    }

    public LegoHotPageView(Context context, AttributeSet attributeSet, int i) {
        super(context, attributeSet, i);
        this.fci = new CustomMessageListener(CmdConfigCustom.CMD_UPDATE_ATTENTION) { // from class: com.baidu.tieba.lego.LegoHotPageView.1
            /* JADX DEBUG: Method merged with bridge method */
            @Override // com.baidu.adp.framework.listener.MessageListener
            public void onMessage(CustomResponsedMessage<?> customResponsedMessage) {
                UpdateAttentionMessage updateAttentionMessage = (UpdateAttentionMessage) customResponsedMessage;
                if (updateAttentionMessage != null && updateAttentionMessage.getData() != null && updateAttentionMessage.getData().isSucc) {
                    LegoHotPageView.this.aO(updateAttentionMessage.getData());
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
                    bVar.eRl = true;
                    LegoHotPageView.this.aO(bVar);
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
                    bVar.eRl = false;
                    LegoHotPageView.this.aO(bVar);
                }
            }
        };
        this.lbO = new h.a() { // from class: com.baidu.tieba.lego.LegoHotPageView.4
            @Override // com.baidu.tieba.lego.h.a
            public void r(long j, String str) {
                boolean cqZ = LegoHotPageView.this.cqZ();
                LegoHotPageView.this.Xc();
                if (cqZ) {
                    LegoHotPageView.this.C(true, LegoHotPageView.this.getResources().getDimensionPixelSize(R.dimen.ds360));
                }
                if (LegoHotPageView.this.lbL != null) {
                    LegoHotPageView.this.lbL.o(j, str);
                }
            }

            @Override // com.baidu.tieba.lego.h.a
            public void bI(int i2, String str) {
                if (LegoHotPageView.this.lbL != null && LegoHotPageView.this.lbJ != null) {
                    LegoHotPageView.this.lbL.a(LegoHotPageView.this.lbJ.lhU, LegoHotPageView.this.lbJ.itemId, i2, str);
                }
            }

            @Override // com.baidu.tieba.lego.h.a
            public void onError(int i2, String str) {
                LegoHotPageView.this.hideLoadingView();
                if (i2 != 1) {
                    LegoHotPageView.this.iEc.setVisibility(8);
                    LegoHotPageView.this.showNetRefreshView(LegoHotPageView.this, str, true);
                } else if (com.baidu.adp.lib.util.j.isNetWorkAvailable()) {
                    LegoHotPageView.this.pageContext.showToast(str);
                }
            }

            @Override // com.baidu.tieba.lego.h.a
            public void onSuccess() {
                LegoHotPageView.this.hideLoadingView();
                LegoHotPageView.this.Xc();
                LegoHotPageView.this.iEc.setVisibility(0);
            }

            @Override // com.baidu.tieba.lego.h.a
            public void c(String str, String str2, String str3, List<com.baidu.tieba.lego.c.e> list) {
                if (LegoHotPageView.this.lbL != null) {
                    LegoHotPageView.this.lbL.b(str, str2, str3, list);
                }
            }

            @Override // com.baidu.tieba.lego.h.a
            public void eF(List<com.baidu.tieba.lego.c.d> list) {
                if (LegoHotPageView.this.lbL != null) {
                    LegoHotPageView.this.lbL.eF(list);
                }
            }
        };
        init(context);
    }

    private void init(Context context) {
        com.baidu.adp.base.f<?> J = com.baidu.adp.base.j.J(context);
        J.registerListener(this.fci);
        J.registerListener(this.mLikeForumListener);
        J.registerListener(this.mUnlikeForumListener);
        if (J instanceof TbPageContext) {
            this.pageContext = (TbPageContext) J;
        }
        this.iEc = new BdListView(context);
        this.iEc.setDividerHeight(0);
        this.iEc.setSelector(17170445);
        this.lbK = new com.baidu.tieba.lego.b.a(this.pageContext);
        this.iEc.setAdapter((ListAdapter) this.lbK);
        this.gCf = new PbListView(context);
        this.gCf.createView();
        this.gCf.setContainerBackgroundColorResId(R.color.CAM_X0204);
        this.gCf.setTextColor(ap.getColor(R.color.CAM_X0109));
        this.gCf.changeSkin(TbadkCoreApplication.getInst().getSkinType());
        this.mPullView = new com.baidu.tbadk.core.view.g(this.pageContext);
        this.iEc.setPullRefresh(this.mPullView);
        this.mPullView.setEnable(true);
        this.mPullView.setListPullRefreshListener(new f.c() { // from class: com.baidu.tieba.lego.LegoHotPageView.5
            @Override // com.baidu.tbadk.core.view.f.c
            public void onListPullRefresh(boolean z) {
                LegoHotPageView.this.lbM.s(LegoHotPageView.this.lbN, LegoHotPageView.this.itemId);
            }
        });
        this.iEc.setOnSrollToBottomListener(new BdListView.e() { // from class: com.baidu.tieba.lego.LegoHotPageView.6
            @Override // com.baidu.adp.widget.ListView.BdListView.e
            public void onScrollToBottom() {
                if (LegoHotPageView.this.mHasMore) {
                    if (LegoHotPageView.this.gCf != null) {
                        LegoHotPageView.this.gCf.startLoadData();
                    }
                    LegoHotPageView.this.lbM.bRp();
                }
            }
        });
        this.iEc.setOnScrollListener(this);
        this.lbM = new h(this.iEc, this.lbK);
        this.lbM.a(this.lbO);
        addView(this.iEc);
    }

    public void setViewBackGround() {
        qJ(true);
    }

    public void setViewForeground() {
        qJ(false);
    }

    public void qJ(boolean z) {
        if (this.iEc != null) {
            int i = 0;
            while (true) {
                int i2 = i;
                if (i2 < this.iEc.getChildCount()) {
                    View childAt = this.iEc.getChildAt(i2);
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

    public void setCallback(c cVar) {
        this.lbL = cVar;
    }

    public void setTagInfo(com.baidu.tieba.lego.c.e eVar) {
        this.lbJ = eVar;
    }

    public void a(DataRes dataRes, boolean z) {
        if (this.gCf != null) {
            this.gCf.endLoadData();
        }
        this.lbM.a(z, dataRes, 0, null);
        setHasMore(this.lbM.isHasMore());
    }

    private void setHasMore(boolean z) {
        this.mHasMore = z;
        if (this.iEc != null) {
            if (this.gCf.getView().getParent() == null) {
                this.iEc.setNextPage(this.gCf);
            }
            if (this.mHasMore) {
                this.gCf.setText(getContext().getString(R.string.pb_load_more));
            } else {
                this.gCf.setText("");
            }
        }
    }

    public void onChangeSkinType(int i) {
        if (this.gLk != null) {
            this.gLk.onChangeSkinType();
        }
        if (this.refreshView != null) {
            this.refreshView.onChangeSkinType();
        }
        if (this.mPullView != null) {
            this.mPullView.changeSkin(i);
        }
        if (this.iEc != null) {
            ap.setBackgroundColor(this.iEc, R.color.CAM_X0204, i);
        }
        if (this.gCf != null) {
            this.gCf.setTextColor(ap.getColor(R.color.CAM_X0109));
            this.gCf.changeSkin(i);
        }
    }

    public long getTagCode() {
        if (this.lbJ == null) {
            return 0L;
        }
        return this.lbJ.lhU;
    }

    public void bd(String str, int i) {
        if (this.gCf != null) {
            this.gCf.endLoadData();
        }
        this.lbM.a(true, null, i, str);
    }

    /* JADX INFO: Access modifiers changed from: private */
    public void showNetRefreshView(View view, String str, boolean z) {
        if (this.refreshView == null) {
            this.refreshView = new com.baidu.tbadk.l.h(getContext(), new View.OnClickListener() { // from class: com.baidu.tieba.lego.LegoHotPageView.7
                @Override // android.view.View.OnClickListener
                public void onClick(View view2) {
                    if (LegoHotPageView.this.lbM != null) {
                        if (LegoHotPageView.this.lbJ != null) {
                            LegoHotPageView.this.lbM.s(LegoHotPageView.this.lbJ.lhU, LegoHotPageView.this.lbJ.itemId);
                        } else {
                            LegoHotPageView.this.lbM.s(LegoHotPageView.this.lbN, LegoHotPageView.this.itemId);
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
    public void Xc() {
        if (this.refreshView != null) {
            this.refreshView.dettachView(this);
            this.refreshView = null;
        }
    }

    /* JADX INFO: Access modifiers changed from: private */
    public void hideLoadingView() {
        if (this.gLk != null) {
            this.gLk.dettachView(this);
            this.gLk = null;
        }
        if (this.lbL != null) {
            this.lbL.cPC();
        }
    }

    /* JADX INFO: Access modifiers changed from: private */
    public boolean cqZ() {
        return this.refreshView != null && this.refreshView.isViewAttached();
    }

    /* JADX INFO: Access modifiers changed from: private */
    public void C(boolean z, int i) {
        if (this.gLk == null) {
            if (i < 0) {
                this.gLk = new com.baidu.tbadk.l.g(getContext());
            } else {
                this.gLk = new com.baidu.tbadk.l.g(getContext(), i);
            }
            this.gLk.onChangeSkinType();
        }
        this.gLk.attachView(this, z);
    }

    public void q(long j, String str) {
        this.lbN = j;
        this.itemId = str;
        if (this.lbM != null) {
            this.lbM.s(j, str);
        }
    }

    @Override // android.widget.AbsListView.OnScrollListener
    public void onScrollStateChanged(AbsListView absListView, int i) {
        if (i == 0) {
            MessageManager.getInstance().dispatchResponsedMessage(new CustomResponsedMessage(CmdConfigCustom.CMD_LEGO_SWITCH_TAB, -1));
            dbu();
        }
    }

    private void dbu() {
        if (this.iEc != null) {
            int i = 0;
            while (true) {
                int i2 = i;
                if (i2 < this.iEc.getChildCount()) {
                    View childAt = this.iEc.getChildAt(i2);
                    if (childAt instanceof com.baidu.tieba.lego.card.view.e) {
                        ((com.baidu.tieba.lego.card.view.e) childAt).dcj();
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
