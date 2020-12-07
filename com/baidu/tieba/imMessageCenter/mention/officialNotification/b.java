package com.baidu.tieba.imMessageCenter.mention.officialNotification;

import android.support.v7.widget.LinearLayoutManager;
import android.support.v7.widget.RecyclerView;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import com.baidu.adp.lib.util.l;
import com.baidu.adp.widget.ListView.BdListView;
import com.baidu.adp.widget.ListView.BdTypeRecyclerView;
import com.baidu.tbadk.TbPageContext;
import com.baidu.tbadk.core.BaseFragmentActivity;
import com.baidu.tbadk.core.TbadkCoreApplication;
import com.baidu.tbadk.core.util.ap;
import com.baidu.tbadk.core.view.NavigationBarShadowView;
import com.baidu.tbadk.core.view.NoDataView;
import com.baidu.tbadk.core.view.NoDataViewFactory;
import com.baidu.tieba.R;
import com.baidu.tieba.im.data.MsgCacheData;
import com.baidu.tieba.im.data.MsgPageData;
import com.baidu.tieba.im.message.chat.ChatMessage;
import com.baidu.tieba.imMessageCenter.mention.OfficialNotificationFragment;
import java.util.ArrayList;
import java.util.List;
/* loaded from: classes22.dex */
public class b {
    private BdTypeRecyclerView Yf;
    private boolean isLoadMore;
    private BaseFragmentActivity ixc;
    private NavigationBarShadowView kIh;
    private boolean kJB;
    private com.baidu.tbadk.mvc.g.a kKS;
    private OfficialNotificationFragment kKT;
    private OfficialNotificationTextItemAdapter kKU;
    private NoDataView mNoDataView;
    private TbPageContext mPageContext;
    private ViewGroup mRootView;
    private List<ChatMessage> mData = null;
    private List<com.baidu.adp.widget.ListView.a> bnf = new ArrayList();
    private RecyclerView.OnScrollListener kJG = new RecyclerView.OnScrollListener() { // from class: com.baidu.tieba.imMessageCenter.mention.officialNotification.b.1
        @Override // android.support.v7.widget.RecyclerView.OnScrollListener
        public void onScrollStateChanged(RecyclerView recyclerView, int i) {
            super.onScrollStateChanged(recyclerView, i);
            switch (i) {
                case 0:
                    if (recyclerView.canScrollVertically(-1)) {
                        b.this.kIh.show();
                        return;
                    } else {
                        b.this.kIh.hide();
                        return;
                    }
                case 1:
                case 2:
                    b.this.kIh.show();
                    return;
                default:
                    return;
            }
        }
    };

    public b(TbPageContext tbPageContext, OfficialNotificationFragment officialNotificationFragment, ViewGroup viewGroup) {
        if (tbPageContext != null) {
            this.mPageContext = tbPageContext;
            this.ixc = (BaseFragmentActivity) this.mPageContext.getPageActivity();
            this.kKT = officialNotificationFragment;
            this.mRootView = (ViewGroup) LayoutInflater.from(this.ixc).inflate(R.layout.fragment_official_notification, viewGroup, false);
            this.kIh = (NavigationBarShadowView) this.mRootView.findViewById(R.id.navi_shadow_view_official_notification);
            this.Yf = (BdTypeRecyclerView) this.mRootView.findViewById(R.id.rv_official_notification);
            this.Yf.setLayoutManager(new LinearLayoutManager(this.ixc));
            this.Yf.setFadingEdgeLength(0);
            this.Yf.setOverScrollMode(2);
            this.Yf.addOnScrollListener(this.kJG);
            this.kKU = new OfficialNotificationTextItemAdapter(this.mPageContext, ChatMessage.TYPE_MSG_LEFT);
            this.kKU.setOnClickListener(officialNotificationFragment);
            this.bnf.add(this.kKU);
            this.Yf.addAdapters(this.bnf);
            this.kKS = new com.baidu.tbadk.mvc.g.a(this.ixc, this.Yf);
            this.kKS.setHeight(l.getDimens(this.ixc, R.dimen.tbds182));
            this.kKS.createView();
            this.Yf.setNextPage(this.kKS);
            this.Yf.setOnSrollToBottomListener(new BdListView.e() { // from class: com.baidu.tieba.imMessageCenter.mention.officialNotification.b.2
                @Override // com.baidu.adp.widget.ListView.BdListView.e
                public void onScrollToBottom() {
                    b.this.kKS.su();
                    if (!b.this.kKT.getHasMore() || b.this.isLoadMore) {
                        b.this.kKS.sH(R.string.no_more_msg);
                        return;
                    }
                    b.this.kKS.sG(R.string.loading);
                    if (b.this.kKT != null) {
                        b.this.kKT.bWp();
                        b.this.isLoadMore = true;
                    }
                }
            });
            onChangeSkinType();
        }
    }

    public View getView() {
        return this.mRootView;
    }

    public void onChangeSkinType() {
        if (this.kKU != null) {
            this.kKU.notifyDataSetChanged();
        }
        ap.setBackgroundColor(this.Yf, R.color.CAM_X0201);
        if (this.mNoDataView != null) {
            this.mNoDataView.onChangeSkinType(this.mPageContext, TbadkCoreApplication.getInst().getSkinType());
            ap.setBackgroundColor(this.mNoDataView, R.color.CAM_X0201);
        }
        if (this.kKS != null) {
            this.kKS.b(this.mPageContext, TbadkCoreApplication.getInst().getSkinType());
        }
    }

    public void a(MsgPageData msgPageData) {
        if (this.Yf != null && msgPageData != null) {
            setData(msgPageData.getChatMessages());
            this.Yf.getAdapter().notifyDataSetChanged();
        }
    }

    public void refreshGo2New(MsgPageData msgPageData) {
        if (msgPageData != null) {
            try {
                removeMoreData(msgPageData);
                doRefresh(msgPageData, 0);
            } catch (Exception e) {
                doRefresh(msgPageData, -1);
            }
        }
    }

    public void refreshPrepage(MsgPageData msgPageData) {
        try {
            doRefresh(msgPageData, -1);
        } catch (Exception e) {
            doRefresh(msgPageData, -1);
        }
    }

    private void doRefresh(MsgPageData msgPageData, int i) {
        if (this.Yf != null) {
            this.isLoadMore = false;
            if (msgPageData != null) {
                try {
                    setData(msgPageData.getChatMessages());
                    this.Yf.getAdapter().notifyDataSetChanged();
                    if (i >= 0) {
                        this.Yf.setSelection(i);
                    }
                } catch (Exception e) {
                }
            }
        }
    }

    public void refreshCheckNew(MsgPageData msgPageData) {
        if (msgPageData != null) {
            boolean z = false;
            try {
                if (msgPageData.getIsNewAdd()) {
                    z = checkListAtNew(msgPageData.getNewAddNum());
                }
                if (z) {
                    refreshGo2New(msgPageData);
                } else {
                    refreshNormal(msgPageData);
                }
            } catch (Exception e) {
                doRefresh(msgPageData, -1);
            }
        }
    }

    public void refreshNormal(MsgPageData msgPageData) {
        doRefresh(msgPageData, -1);
    }

    private boolean checkListAtNew(int i) {
        return (this.Yf == null || this.mData == null || this.Yf.getFirstVisiblePosition() != 0) ? false : true;
    }

    private void removeMoreData(MsgPageData msgPageData) {
        int size;
        if (msgPageData != null && msgPageData.getChatMessages() != null && msgPageData.getChatMessages().size() != 0 && (size = msgPageData.getChatMessages().size()) > 100) {
            int i = size - 100;
            for (int i2 = 0; i2 < i; i2++) {
                msgPageData.getChatMessages().remove(0);
            }
        }
    }

    public void setData(List<ChatMessage> list) {
        if (this.Yf != null) {
            this.mData = list;
            ArrayList arrayList = new ArrayList();
            for (int size = list.size() - 1; size >= 0; size--) {
                arrayList.add(list.get(size));
            }
            ArrayList arrayList2 = new ArrayList();
            if (arrayList != null) {
                int size2 = arrayList.size();
                for (int i = 0; i < size2; i++) {
                    if (i > 0) {
                        if (list.get(i).getCacheData() == null) {
                            list.get(i).setCacheData(new MsgCacheData());
                        }
                        list.get(i).getCacheData().setLastMsgTime(list.get(i - 1).getTime());
                    }
                }
                arrayList2.addAll(arrayList);
            }
            if (arrayList2.isEmpty()) {
                if (this.mNoDataView == null) {
                    this.mNoDataView = NoDataViewFactory.a(this.ixc, null, NoDataViewFactory.c.a(NoDataViewFactory.ImgType.CREATE), NoDataViewFactory.d.dZ(null, this.ixc.getResources().getString(R.string.official_notification_no_data)), null);
                    this.mNoDataView.setLayoutParams(new ViewGroup.LayoutParams(-1, -1));
                    ap.setBackgroundColor(this.mNoDataView, R.color.CAM_X0201);
                    this.mRootView.addView(this.mNoDataView);
                }
                if (!this.kJB) {
                    this.kJB = true;
                    this.Yf.setVisibility(8);
                    this.mNoDataView.setVisibility(0);
                    this.mNoDataView.onChangeSkinType(this.mPageContext, TbadkCoreApplication.getInst().getSkinType());
                    return;
                }
                return;
            }
            if (this.mNoDataView != null) {
                this.mNoDataView.setVisibility(8);
            }
            this.kJB = false;
            this.Yf.setData(arrayList2);
            this.Yf.setVisibility(0);
        }
    }
}
