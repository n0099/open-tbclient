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
/* loaded from: classes9.dex */
public class LegoHotPageView extends FrameLayout implements AbsListView.OnScrollListener {
    private CustomMessageListener fdd;
    private PbListView gCf;
    private com.baidu.tbadk.l.g gLj;
    private BdListView iBc;
    private String itemId;
    private com.baidu.tieba.lego.c.e kVV;
    com.baidu.tieba.lego.b.a kVW;
    private c kVX;
    private h kVY;
    private long kVZ;
    private h.a kWa;
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
        if (this.kVW != null && this.kVY != null && this.kVY.getDataList() != null) {
            boolean z2 = false;
            Iterator<ICardInfo> it = this.kVY.getDataList().iterator();
            while (true) {
                z = z2;
                if (!it.hasNext()) {
                    break;
                }
                z2 = it.next().responseAttention(obj) ? true : z;
            }
            if (z) {
                this.kVW.notifyDataSetChanged();
            }
        }
    }

    public LegoHotPageView(Context context) {
        super(context);
        this.fdd = new CustomMessageListener(CmdConfigCustom.CMD_UPDATE_ATTENTION) { // from class: com.baidu.tieba.lego.LegoHotPageView.1
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
                    bVar.eSj = true;
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
                    bVar.eSj = false;
                    LegoHotPageView.this.aM(bVar);
                }
            }
        };
        this.kWa = new h.a() { // from class: com.baidu.tieba.lego.LegoHotPageView.4
            @Override // com.baidu.tieba.lego.h.a
            public void q(long j, String str) {
                boolean ctu = LegoHotPageView.this.ctu();
                LegoHotPageView.this.Zj();
                if (ctu) {
                    LegoHotPageView.this.C(true, LegoHotPageView.this.getResources().getDimensionPixelSize(R.dimen.ds360));
                }
                if (LegoHotPageView.this.kVX != null) {
                    LegoHotPageView.this.kVX.n(j, str);
                }
            }

            @Override // com.baidu.tieba.lego.h.a
            public void bB(int i, String str) {
                if (LegoHotPageView.this.kVX != null && LegoHotPageView.this.kVV != null) {
                    LegoHotPageView.this.kVX.a(LegoHotPageView.this.kVV.lcg, LegoHotPageView.this.kVV.itemId, i, str);
                }
            }

            @Override // com.baidu.tieba.lego.h.a
            public void onError(int i, String str) {
                LegoHotPageView.this.hideLoadingView();
                if (i != 1) {
                    LegoHotPageView.this.iBc.setVisibility(8);
                    LegoHotPageView.this.showNetRefreshView(LegoHotPageView.this, str, true);
                } else if (com.baidu.adp.lib.util.j.isNetWorkAvailable()) {
                    LegoHotPageView.this.pageContext.showToast(str);
                }
            }

            @Override // com.baidu.tieba.lego.h.a
            public void onSuccess() {
                LegoHotPageView.this.hideLoadingView();
                LegoHotPageView.this.Zj();
                LegoHotPageView.this.iBc.setVisibility(0);
            }

            @Override // com.baidu.tieba.lego.h.a
            public void c(String str, String str2, String str3, List<com.baidu.tieba.lego.c.e> list) {
                if (LegoHotPageView.this.kVX != null) {
                    LegoHotPageView.this.kVX.b(str, str2, str3, list);
                }
            }

            @Override // com.baidu.tieba.lego.h.a
            public void eH(List<com.baidu.tieba.lego.c.d> list) {
                if (LegoHotPageView.this.kVX != null) {
                    LegoHotPageView.this.kVX.eH(list);
                }
            }
        };
        init(context);
    }

    public LegoHotPageView(Context context, AttributeSet attributeSet) {
        super(context, attributeSet);
        this.fdd = new CustomMessageListener(CmdConfigCustom.CMD_UPDATE_ATTENTION) { // from class: com.baidu.tieba.lego.LegoHotPageView.1
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
                    bVar.eSj = true;
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
                    bVar.eSj = false;
                    LegoHotPageView.this.aM(bVar);
                }
            }
        };
        this.kWa = new h.a() { // from class: com.baidu.tieba.lego.LegoHotPageView.4
            @Override // com.baidu.tieba.lego.h.a
            public void q(long j, String str) {
                boolean ctu = LegoHotPageView.this.ctu();
                LegoHotPageView.this.Zj();
                if (ctu) {
                    LegoHotPageView.this.C(true, LegoHotPageView.this.getResources().getDimensionPixelSize(R.dimen.ds360));
                }
                if (LegoHotPageView.this.kVX != null) {
                    LegoHotPageView.this.kVX.n(j, str);
                }
            }

            @Override // com.baidu.tieba.lego.h.a
            public void bB(int i, String str) {
                if (LegoHotPageView.this.kVX != null && LegoHotPageView.this.kVV != null) {
                    LegoHotPageView.this.kVX.a(LegoHotPageView.this.kVV.lcg, LegoHotPageView.this.kVV.itemId, i, str);
                }
            }

            @Override // com.baidu.tieba.lego.h.a
            public void onError(int i, String str) {
                LegoHotPageView.this.hideLoadingView();
                if (i != 1) {
                    LegoHotPageView.this.iBc.setVisibility(8);
                    LegoHotPageView.this.showNetRefreshView(LegoHotPageView.this, str, true);
                } else if (com.baidu.adp.lib.util.j.isNetWorkAvailable()) {
                    LegoHotPageView.this.pageContext.showToast(str);
                }
            }

            @Override // com.baidu.tieba.lego.h.a
            public void onSuccess() {
                LegoHotPageView.this.hideLoadingView();
                LegoHotPageView.this.Zj();
                LegoHotPageView.this.iBc.setVisibility(0);
            }

            @Override // com.baidu.tieba.lego.h.a
            public void c(String str, String str2, String str3, List<com.baidu.tieba.lego.c.e> list) {
                if (LegoHotPageView.this.kVX != null) {
                    LegoHotPageView.this.kVX.b(str, str2, str3, list);
                }
            }

            @Override // com.baidu.tieba.lego.h.a
            public void eH(List<com.baidu.tieba.lego.c.d> list) {
                if (LegoHotPageView.this.kVX != null) {
                    LegoHotPageView.this.kVX.eH(list);
                }
            }
        };
        init(context);
    }

    public LegoHotPageView(Context context, AttributeSet attributeSet, int i) {
        super(context, attributeSet, i);
        this.fdd = new CustomMessageListener(CmdConfigCustom.CMD_UPDATE_ATTENTION) { // from class: com.baidu.tieba.lego.LegoHotPageView.1
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
                    bVar.eSj = true;
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
                    bVar.eSj = false;
                    LegoHotPageView.this.aM(bVar);
                }
            }
        };
        this.kWa = new h.a() { // from class: com.baidu.tieba.lego.LegoHotPageView.4
            @Override // com.baidu.tieba.lego.h.a
            public void q(long j, String str) {
                boolean ctu = LegoHotPageView.this.ctu();
                LegoHotPageView.this.Zj();
                if (ctu) {
                    LegoHotPageView.this.C(true, LegoHotPageView.this.getResources().getDimensionPixelSize(R.dimen.ds360));
                }
                if (LegoHotPageView.this.kVX != null) {
                    LegoHotPageView.this.kVX.n(j, str);
                }
            }

            @Override // com.baidu.tieba.lego.h.a
            public void bB(int i2, String str) {
                if (LegoHotPageView.this.kVX != null && LegoHotPageView.this.kVV != null) {
                    LegoHotPageView.this.kVX.a(LegoHotPageView.this.kVV.lcg, LegoHotPageView.this.kVV.itemId, i2, str);
                }
            }

            @Override // com.baidu.tieba.lego.h.a
            public void onError(int i2, String str) {
                LegoHotPageView.this.hideLoadingView();
                if (i2 != 1) {
                    LegoHotPageView.this.iBc.setVisibility(8);
                    LegoHotPageView.this.showNetRefreshView(LegoHotPageView.this, str, true);
                } else if (com.baidu.adp.lib.util.j.isNetWorkAvailable()) {
                    LegoHotPageView.this.pageContext.showToast(str);
                }
            }

            @Override // com.baidu.tieba.lego.h.a
            public void onSuccess() {
                LegoHotPageView.this.hideLoadingView();
                LegoHotPageView.this.Zj();
                LegoHotPageView.this.iBc.setVisibility(0);
            }

            @Override // com.baidu.tieba.lego.h.a
            public void c(String str, String str2, String str3, List<com.baidu.tieba.lego.c.e> list) {
                if (LegoHotPageView.this.kVX != null) {
                    LegoHotPageView.this.kVX.b(str, str2, str3, list);
                }
            }

            @Override // com.baidu.tieba.lego.h.a
            public void eH(List<com.baidu.tieba.lego.c.d> list) {
                if (LegoHotPageView.this.kVX != null) {
                    LegoHotPageView.this.kVX.eH(list);
                }
            }
        };
        init(context);
    }

    private void init(Context context) {
        com.baidu.adp.base.f<?> K = com.baidu.adp.base.j.K(context);
        K.registerListener(this.fdd);
        K.registerListener(this.mLikeForumListener);
        K.registerListener(this.mUnlikeForumListener);
        if (K instanceof TbPageContext) {
            this.pageContext = (TbPageContext) K;
        }
        this.iBc = new BdListView(context);
        this.iBc.setDividerHeight(0);
        this.iBc.setSelector(17170445);
        this.kVW = new com.baidu.tieba.lego.b.a(this.pageContext);
        this.iBc.setAdapter((ListAdapter) this.kVW);
        this.gCf = new PbListView(context);
        this.gCf.createView();
        this.gCf.setContainerBackgroundColorResId(R.color.CAM_X0204);
        this.gCf.setTextColor(ao.getColor(R.color.CAM_X0109));
        this.gCf.changeSkin(TbadkCoreApplication.getInst().getSkinType());
        this.mPullView = new com.baidu.tbadk.core.view.g(this.pageContext);
        this.iBc.setPullRefresh(this.mPullView);
        this.mPullView.setEnable(true);
        this.mPullView.setListPullRefreshListener(new f.c() { // from class: com.baidu.tieba.lego.LegoHotPageView.5
            @Override // com.baidu.tbadk.core.view.f.c
            public void onListPullRefresh(boolean z) {
                LegoHotPageView.this.kVY.r(LegoHotPageView.this.kVZ, LegoHotPageView.this.itemId);
            }
        });
        this.iBc.setOnSrollToBottomListener(new BdListView.e() { // from class: com.baidu.tieba.lego.LegoHotPageView.6
            @Override // com.baidu.adp.widget.ListView.BdListView.e
            public void onScrollToBottom() {
                if (LegoHotPageView.this.mHasMore) {
                    if (LegoHotPageView.this.gCf != null) {
                        LegoHotPageView.this.gCf.startLoadData();
                    }
                    LegoHotPageView.this.kVY.bUq();
                }
            }
        });
        this.iBc.setOnScrollListener(this);
        this.kVY = new h(this.iBc, this.kVW);
        this.kVY.a(this.kWa);
        addView(this.iBc);
    }

    public void setViewBackGround() {
        qD(true);
    }

    public void setViewForeground() {
        qD(false);
    }

    public void qD(boolean z) {
        if (this.iBc != null) {
            int i = 0;
            while (true) {
                int i2 = i;
                if (i2 < this.iBc.getChildCount()) {
                    View childAt = this.iBc.getChildAt(i2);
                    if (childAt instanceof com.baidu.tieba.lego.card.view.e) {
                        if (z) {
                            ((com.baidu.tieba.lego.card.view.e) childAt).aWE();
                        } else {
                            ((com.baidu.tieba.lego.card.view.e) childAt).cUq();
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
        this.kVX = cVar;
    }

    public void setTagInfo(com.baidu.tieba.lego.c.e eVar) {
        this.kVV = eVar;
    }

    public void a(DataRes dataRes, boolean z) {
        if (this.gCf != null) {
            this.gCf.endLoadData();
        }
        this.kVY.a(z, dataRes, 0, null);
        setHasMore(this.kVY.isHasMore());
    }

    private void setHasMore(boolean z) {
        this.mHasMore = z;
        if (this.iBc != null) {
            if (this.gCf.getView().getParent() == null) {
                this.iBc.setNextPage(this.gCf);
            }
            if (this.mHasMore) {
                this.gCf.setText(getContext().getString(R.string.pb_load_more));
            } else {
                this.gCf.setText("");
            }
        }
    }

    public void onChangeSkinType(int i) {
        if (this.gLj != null) {
            this.gLj.onChangeSkinType();
        }
        if (this.refreshView != null) {
            this.refreshView.onChangeSkinType();
        }
        if (this.mPullView != null) {
            this.mPullView.changeSkin(i);
        }
        if (this.iBc != null) {
            ao.setBackgroundColor(this.iBc, R.color.CAM_X0204, i);
        }
        if (this.gCf != null) {
            this.gCf.setTextColor(ao.getColor(R.color.CAM_X0109));
            this.gCf.changeSkin(i);
        }
    }

    public long getTagCode() {
        if (this.kVV == null) {
            return 0L;
        }
        return this.kVV.lcg;
    }

    public void bc(String str, int i) {
        if (this.gCf != null) {
            this.gCf.endLoadData();
        }
        this.kVY.a(true, null, i, str);
    }

    /* JADX INFO: Access modifiers changed from: private */
    public void showNetRefreshView(View view, String str, boolean z) {
        if (this.refreshView == null) {
            this.refreshView = new com.baidu.tbadk.l.h(getContext(), new View.OnClickListener() { // from class: com.baidu.tieba.lego.LegoHotPageView.7
                @Override // android.view.View.OnClickListener
                public void onClick(View view2) {
                    if (LegoHotPageView.this.kVY != null) {
                        if (LegoHotPageView.this.kVV != null) {
                            LegoHotPageView.this.kVY.r(LegoHotPageView.this.kVV.lcg, LegoHotPageView.this.kVV.itemId);
                        } else {
                            LegoHotPageView.this.kVY.r(LegoHotPageView.this.kVZ, LegoHotPageView.this.itemId);
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
    public void Zj() {
        if (this.refreshView != null) {
            this.refreshView.dettachView(this);
            this.refreshView = null;
        }
    }

    /* JADX INFO: Access modifiers changed from: private */
    public void hideLoadingView() {
        if (this.gLj != null) {
            this.gLj.dettachView(this);
            this.gLj = null;
        }
        if (this.kVX != null) {
            this.kVX.cRk();
        }
    }

    /* JADX INFO: Access modifiers changed from: private */
    public boolean ctu() {
        return this.refreshView != null && this.refreshView.isViewAttached();
    }

    /* JADX INFO: Access modifiers changed from: private */
    public void C(boolean z, int i) {
        if (this.gLj == null) {
            if (i < 0) {
                this.gLj = new com.baidu.tbadk.l.g(getContext());
            } else {
                this.gLj = new com.baidu.tbadk.l.g(getContext(), i);
            }
            this.gLj.onChangeSkinType();
        }
        this.gLj.attachView(this, z);
    }

    public void p(long j, String str) {
        this.kVZ = j;
        this.itemId = str;
        if (this.kVY != null) {
            this.kVY.r(j, str);
        }
    }

    @Override // android.widget.AbsListView.OnScrollListener
    public void onScrollStateChanged(AbsListView absListView, int i) {
        if (i == 0) {
            MessageManager.getInstance().dispatchResponsedMessage(new CustomResponsedMessage(CmdConfigCustom.CMD_LEGO_SWITCH_TAB, -1));
            dcY();
        }
    }

    private void dcY() {
        if (this.iBc != null) {
            int i = 0;
            while (true) {
                int i2 = i;
                if (i2 < this.iBc.getChildCount()) {
                    View childAt = this.iBc.getChildAt(i2);
                    if (childAt instanceof com.baidu.tieba.lego.card.view.e) {
                        ((com.baidu.tieba.lego.card.view.e) childAt).ddN();
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
