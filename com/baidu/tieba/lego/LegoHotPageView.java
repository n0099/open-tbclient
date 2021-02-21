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
    private PbListView gAw;
    private com.baidu.tbadk.l.g gJB;
    private BdListView iCt;
    private String itemId;
    private com.baidu.tieba.lego.c.e kZG;
    com.baidu.tieba.lego.b.a kZH;
    private c kZI;
    private h kZJ;
    private long kZK;
    private h.a kZL;
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
        if (this.kZH != null && this.kZJ != null && this.kZJ.getDataList() != null) {
            boolean z2 = false;
            Iterator<ICardInfo> it = this.kZJ.getDataList().iterator();
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
        this.kZL = new h.a() { // from class: com.baidu.tieba.lego.LegoHotPageView.4
            @Override // com.baidu.tieba.lego.h.a
            public void r(long j, String str) {
                boolean cqT = LegoHotPageView.this.cqT();
                LegoHotPageView.this.WZ();
                if (cqT) {
                    LegoHotPageView.this.C(true, LegoHotPageView.this.getResources().getDimensionPixelSize(R.dimen.ds360));
                }
                if (LegoHotPageView.this.kZI != null) {
                    LegoHotPageView.this.kZI.o(j, str);
                }
            }

            @Override // com.baidu.tieba.lego.h.a
            public void bI(int i, String str) {
                if (LegoHotPageView.this.kZI != null && LegoHotPageView.this.kZG != null) {
                    LegoHotPageView.this.kZI.a(LegoHotPageView.this.kZG.lfS, LegoHotPageView.this.kZG.itemId, i, str);
                }
            }

            @Override // com.baidu.tieba.lego.h.a
            public void onError(int i, String str) {
                LegoHotPageView.this.hideLoadingView();
                if (i != 1) {
                    LegoHotPageView.this.iCt.setVisibility(8);
                    LegoHotPageView.this.showNetRefreshView(LegoHotPageView.this, str, true);
                } else if (com.baidu.adp.lib.util.j.isNetWorkAvailable()) {
                    LegoHotPageView.this.pageContext.showToast(str);
                }
            }

            @Override // com.baidu.tieba.lego.h.a
            public void onSuccess() {
                LegoHotPageView.this.hideLoadingView();
                LegoHotPageView.this.WZ();
                LegoHotPageView.this.iCt.setVisibility(0);
            }

            @Override // com.baidu.tieba.lego.h.a
            public void c(String str, String str2, String str3, List<com.baidu.tieba.lego.c.e> list) {
                if (LegoHotPageView.this.kZI != null) {
                    LegoHotPageView.this.kZI.b(str, str2, str3, list);
                }
            }

            @Override // com.baidu.tieba.lego.h.a
            public void eF(List<com.baidu.tieba.lego.c.d> list) {
                if (LegoHotPageView.this.kZI != null) {
                    LegoHotPageView.this.kZI.eF(list);
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
        this.kZL = new h.a() { // from class: com.baidu.tieba.lego.LegoHotPageView.4
            @Override // com.baidu.tieba.lego.h.a
            public void r(long j, String str) {
                boolean cqT = LegoHotPageView.this.cqT();
                LegoHotPageView.this.WZ();
                if (cqT) {
                    LegoHotPageView.this.C(true, LegoHotPageView.this.getResources().getDimensionPixelSize(R.dimen.ds360));
                }
                if (LegoHotPageView.this.kZI != null) {
                    LegoHotPageView.this.kZI.o(j, str);
                }
            }

            @Override // com.baidu.tieba.lego.h.a
            public void bI(int i, String str) {
                if (LegoHotPageView.this.kZI != null && LegoHotPageView.this.kZG != null) {
                    LegoHotPageView.this.kZI.a(LegoHotPageView.this.kZG.lfS, LegoHotPageView.this.kZG.itemId, i, str);
                }
            }

            @Override // com.baidu.tieba.lego.h.a
            public void onError(int i, String str) {
                LegoHotPageView.this.hideLoadingView();
                if (i != 1) {
                    LegoHotPageView.this.iCt.setVisibility(8);
                    LegoHotPageView.this.showNetRefreshView(LegoHotPageView.this, str, true);
                } else if (com.baidu.adp.lib.util.j.isNetWorkAvailable()) {
                    LegoHotPageView.this.pageContext.showToast(str);
                }
            }

            @Override // com.baidu.tieba.lego.h.a
            public void onSuccess() {
                LegoHotPageView.this.hideLoadingView();
                LegoHotPageView.this.WZ();
                LegoHotPageView.this.iCt.setVisibility(0);
            }

            @Override // com.baidu.tieba.lego.h.a
            public void c(String str, String str2, String str3, List<com.baidu.tieba.lego.c.e> list) {
                if (LegoHotPageView.this.kZI != null) {
                    LegoHotPageView.this.kZI.b(str, str2, str3, list);
                }
            }

            @Override // com.baidu.tieba.lego.h.a
            public void eF(List<com.baidu.tieba.lego.c.d> list) {
                if (LegoHotPageView.this.kZI != null) {
                    LegoHotPageView.this.kZI.eF(list);
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
        this.kZL = new h.a() { // from class: com.baidu.tieba.lego.LegoHotPageView.4
            @Override // com.baidu.tieba.lego.h.a
            public void r(long j, String str) {
                boolean cqT = LegoHotPageView.this.cqT();
                LegoHotPageView.this.WZ();
                if (cqT) {
                    LegoHotPageView.this.C(true, LegoHotPageView.this.getResources().getDimensionPixelSize(R.dimen.ds360));
                }
                if (LegoHotPageView.this.kZI != null) {
                    LegoHotPageView.this.kZI.o(j, str);
                }
            }

            @Override // com.baidu.tieba.lego.h.a
            public void bI(int i2, String str) {
                if (LegoHotPageView.this.kZI != null && LegoHotPageView.this.kZG != null) {
                    LegoHotPageView.this.kZI.a(LegoHotPageView.this.kZG.lfS, LegoHotPageView.this.kZG.itemId, i2, str);
                }
            }

            @Override // com.baidu.tieba.lego.h.a
            public void onError(int i2, String str) {
                LegoHotPageView.this.hideLoadingView();
                if (i2 != 1) {
                    LegoHotPageView.this.iCt.setVisibility(8);
                    LegoHotPageView.this.showNetRefreshView(LegoHotPageView.this, str, true);
                } else if (com.baidu.adp.lib.util.j.isNetWorkAvailable()) {
                    LegoHotPageView.this.pageContext.showToast(str);
                }
            }

            @Override // com.baidu.tieba.lego.h.a
            public void onSuccess() {
                LegoHotPageView.this.hideLoadingView();
                LegoHotPageView.this.WZ();
                LegoHotPageView.this.iCt.setVisibility(0);
            }

            @Override // com.baidu.tieba.lego.h.a
            public void c(String str, String str2, String str3, List<com.baidu.tieba.lego.c.e> list) {
                if (LegoHotPageView.this.kZI != null) {
                    LegoHotPageView.this.kZI.b(str, str2, str3, list);
                }
            }

            @Override // com.baidu.tieba.lego.h.a
            public void eF(List<com.baidu.tieba.lego.c.d> list) {
                if (LegoHotPageView.this.kZI != null) {
                    LegoHotPageView.this.kZI.eF(list);
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
        this.iCt = new BdListView(context);
        this.iCt.setDividerHeight(0);
        this.iCt.setSelector(17170445);
        this.kZH = new com.baidu.tieba.lego.b.a(this.pageContext);
        this.iCt.setAdapter((ListAdapter) this.kZH);
        this.gAw = new PbListView(context);
        this.gAw.createView();
        this.gAw.setContainerBackgroundColorResId(R.color.CAM_X0204);
        this.gAw.setTextColor(ap.getColor(R.color.CAM_X0109));
        this.gAw.changeSkin(TbadkCoreApplication.getInst().getSkinType());
        this.mPullView = new com.baidu.tbadk.core.view.g(this.pageContext);
        this.iCt.setPullRefresh(this.mPullView);
        this.mPullView.setEnable(true);
        this.mPullView.setListPullRefreshListener(new f.c() { // from class: com.baidu.tieba.lego.LegoHotPageView.5
            @Override // com.baidu.tbadk.core.view.f.c
            public void onListPullRefresh(boolean z) {
                LegoHotPageView.this.kZJ.s(LegoHotPageView.this.kZK, LegoHotPageView.this.itemId);
            }
        });
        this.iCt.setOnSrollToBottomListener(new BdListView.e() { // from class: com.baidu.tieba.lego.LegoHotPageView.6
            @Override // com.baidu.adp.widget.ListView.BdListView.e
            public void onScrollToBottom() {
                if (LegoHotPageView.this.mHasMore) {
                    if (LegoHotPageView.this.gAw != null) {
                        LegoHotPageView.this.gAw.startLoadData();
                    }
                    LegoHotPageView.this.kZJ.bRj();
                }
            }
        });
        this.iCt.setOnScrollListener(this);
        this.kZJ = new h(this.iCt, this.kZH);
        this.kZJ.a(this.kZL);
        addView(this.iCt);
    }

    public void setViewBackGround() {
        qJ(true);
    }

    public void setViewForeground() {
        qJ(false);
    }

    public void qJ(boolean z) {
        if (this.iCt != null) {
            int i = 0;
            while (true) {
                int i2 = i;
                if (i2 < this.iCt.getChildCount()) {
                    View childAt = this.iCt.getChildAt(i2);
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

    public void setCallback(c cVar) {
        this.kZI = cVar;
    }

    public void setTagInfo(com.baidu.tieba.lego.c.e eVar) {
        this.kZG = eVar;
    }

    public void a(DataRes dataRes, boolean z) {
        if (this.gAw != null) {
            this.gAw.endLoadData();
        }
        this.kZJ.a(z, dataRes, 0, null);
        setHasMore(this.kZJ.isHasMore());
    }

    private void setHasMore(boolean z) {
        this.mHasMore = z;
        if (this.iCt != null) {
            if (this.gAw.getView().getParent() == null) {
                this.iCt.setNextPage(this.gAw);
            }
            if (this.mHasMore) {
                this.gAw.setText(getContext().getString(R.string.pb_load_more));
            } else {
                this.gAw.setText("");
            }
        }
    }

    public void onChangeSkinType(int i) {
        if (this.gJB != null) {
            this.gJB.onChangeSkinType();
        }
        if (this.refreshView != null) {
            this.refreshView.onChangeSkinType();
        }
        if (this.mPullView != null) {
            this.mPullView.changeSkin(i);
        }
        if (this.iCt != null) {
            ap.setBackgroundColor(this.iCt, R.color.CAM_X0204, i);
        }
        if (this.gAw != null) {
            this.gAw.setTextColor(ap.getColor(R.color.CAM_X0109));
            this.gAw.changeSkin(i);
        }
    }

    public long getTagCode() {
        if (this.kZG == null) {
            return 0L;
        }
        return this.kZG.lfS;
    }

    public void bd(String str, int i) {
        if (this.gAw != null) {
            this.gAw.endLoadData();
        }
        this.kZJ.a(true, null, i, str);
    }

    /* JADX INFO: Access modifiers changed from: private */
    public void showNetRefreshView(View view, String str, boolean z) {
        if (this.refreshView == null) {
            this.refreshView = new com.baidu.tbadk.l.h(getContext(), new View.OnClickListener() { // from class: com.baidu.tieba.lego.LegoHotPageView.7
                @Override // android.view.View.OnClickListener
                public void onClick(View view2) {
                    if (LegoHotPageView.this.kZJ != null) {
                        if (LegoHotPageView.this.kZG != null) {
                            LegoHotPageView.this.kZJ.s(LegoHotPageView.this.kZG.lfS, LegoHotPageView.this.kZG.itemId);
                        } else {
                            LegoHotPageView.this.kZJ.s(LegoHotPageView.this.kZK, LegoHotPageView.this.itemId);
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
        if (this.gJB != null) {
            this.gJB.dettachView(this);
            this.gJB = null;
        }
        if (this.kZI != null) {
            this.kZI.cPv();
        }
    }

    /* JADX INFO: Access modifiers changed from: private */
    public boolean cqT() {
        return this.refreshView != null && this.refreshView.isViewAttached();
    }

    /* JADX INFO: Access modifiers changed from: private */
    public void C(boolean z, int i) {
        if (this.gJB == null) {
            if (i < 0) {
                this.gJB = new com.baidu.tbadk.l.g(getContext());
            } else {
                this.gJB = new com.baidu.tbadk.l.g(getContext(), i);
            }
            this.gJB.onChangeSkinType();
        }
        this.gJB.attachView(this, z);
    }

    public void q(long j, String str) {
        this.kZK = j;
        this.itemId = str;
        if (this.kZJ != null) {
            this.kZJ.s(j, str);
        }
    }

    @Override // android.widget.AbsListView.OnScrollListener
    public void onScrollStateChanged(AbsListView absListView, int i) {
        if (i == 0) {
            MessageManager.getInstance().dispatchResponsedMessage(new CustomResponsedMessage(CmdConfigCustom.CMD_LEGO_SWITCH_TAB, -1));
            dbl();
        }
    }

    private void dbl() {
        if (this.iCt != null) {
            int i = 0;
            while (true) {
                int i2 = i;
                if (i2 < this.iCt.getChildCount()) {
                    View childAt = this.iCt.getChildAt(i2);
                    if (childAt instanceof com.baidu.tieba.lego.card.view.e) {
                        ((com.baidu.tieba.lego.card.view.e) childAt).dca();
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
