package com.baidu.tieba.imMessageCenter.mention.officialNotification;

import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import androidx.recyclerview.widget.LinearLayoutManager;
import androidx.recyclerview.widget.RecyclerView;
import com.baidu.adp.lib.util.l;
import com.baidu.adp.widget.ListView.BdListView;
import com.baidu.adp.widget.ListView.BdTypeRecyclerView;
import com.baidu.tbadk.TbPageContext;
import com.baidu.tbadk.core.BaseFragmentActivity;
import com.baidu.tbadk.core.TbadkCoreApplication;
import com.baidu.tbadk.core.util.ao;
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
/* loaded from: classes2.dex */
public class b {
    private BdTypeRecyclerView Ya;
    private BaseFragmentActivity iEK;
    private boolean isLoadMore;
    private NavigationBarShadowView kIN;
    private boolean kKh;
    private OfficialNotificationTextItemAdapter kLA;
    private com.baidu.tbadk.mvc.g.a kLy;
    private OfficialNotificationFragment kLz;
    private NoDataView mNoDataView;
    private TbPageContext mPageContext;
    private ViewGroup mRootView;
    private List<ChatMessage> mData = null;
    private List<com.baidu.adp.widget.ListView.a> bjZ = new ArrayList();
    private RecyclerView.OnScrollListener kKm = new RecyclerView.OnScrollListener() { // from class: com.baidu.tieba.imMessageCenter.mention.officialNotification.b.1
        @Override // androidx.recyclerview.widget.RecyclerView.OnScrollListener
        public void onScrollStateChanged(RecyclerView recyclerView, int i) {
            super.onScrollStateChanged(recyclerView, i);
            switch (i) {
                case 0:
                    if (recyclerView.canScrollVertically(-1)) {
                        b.this.kIN.show();
                        return;
                    } else {
                        b.this.kIN.hide();
                        return;
                    }
                case 1:
                case 2:
                    b.this.kIN.show();
                    return;
                default:
                    return;
            }
        }
    };

    public b(TbPageContext tbPageContext, OfficialNotificationFragment officialNotificationFragment, ViewGroup viewGroup) {
        if (tbPageContext != null) {
            this.mPageContext = tbPageContext;
            this.iEK = (BaseFragmentActivity) this.mPageContext.getPageActivity();
            this.kLz = officialNotificationFragment;
            this.mRootView = (ViewGroup) LayoutInflater.from(this.iEK).inflate(R.layout.fragment_official_notification, viewGroup, false);
            this.kIN = (NavigationBarShadowView) this.mRootView.findViewById(R.id.navi_shadow_view_official_notification);
            this.Ya = (BdTypeRecyclerView) this.mRootView.findViewById(R.id.rv_official_notification);
            this.Ya.setLayoutManager(new LinearLayoutManager(this.iEK));
            this.Ya.setFadingEdgeLength(0);
            this.Ya.setOverScrollMode(2);
            this.Ya.addOnScrollListener(this.kKm);
            this.kLA = new OfficialNotificationTextItemAdapter(this.mPageContext, ChatMessage.TYPE_MSG_LEFT);
            this.kLA.setOnClickListener(officialNotificationFragment);
            this.bjZ.add(this.kLA);
            this.Ya.addAdapters(this.bjZ);
            this.kLy = new com.baidu.tbadk.mvc.g.a(this.iEK, this.Ya);
            this.kLy.setHeight(l.getDimens(this.iEK, R.dimen.tbds182));
            this.kLy.createView();
            this.Ya.setNextPage(this.kLy);
            this.Ya.setOnSrollToBottomListener(new BdListView.e() { // from class: com.baidu.tieba.imMessageCenter.mention.officialNotification.b.2
                @Override // com.baidu.adp.widget.ListView.BdListView.e
                public void onScrollToBottom() {
                    b.this.kLy.rV();
                    if (!b.this.kLz.getHasMore() || b.this.isLoadMore) {
                        b.this.kLy.rn(R.string.no_more_msg);
                        return;
                    }
                    b.this.kLy.rm(R.string.loading);
                    if (b.this.kLz != null) {
                        b.this.kLz.bVe();
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
        if (this.kLA != null) {
            this.kLA.notifyDataSetChanged();
        }
        ao.setBackgroundColor(this.Ya, R.color.CAM_X0201);
        if (this.mNoDataView != null) {
            this.mNoDataView.onChangeSkinType(this.mPageContext, TbadkCoreApplication.getInst().getSkinType());
            ao.setBackgroundColor(this.mNoDataView, R.color.CAM_X0201);
        }
        if (this.kLy != null) {
            this.kLy.b(this.mPageContext, TbadkCoreApplication.getInst().getSkinType());
        }
    }

    public void a(MsgPageData msgPageData) {
        if (this.Ya != null && msgPageData != null) {
            setData(msgPageData.getChatMessages());
            this.Ya.getAdapter().notifyDataSetChanged();
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
        if (this.Ya != null) {
            this.isLoadMore = false;
            if (msgPageData != null) {
                try {
                    setData(msgPageData.getChatMessages());
                    this.Ya.getAdapter().notifyDataSetChanged();
                    if (i >= 0) {
                        this.Ya.setSelection(i);
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
        return (this.Ya == null || this.mData == null || this.Ya.getFirstVisiblePosition() != 0) ? false : true;
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
        if (this.Ya != null) {
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
                    this.mNoDataView = NoDataViewFactory.a(this.iEK, null, NoDataViewFactory.c.a(NoDataViewFactory.ImgType.CREATE), NoDataViewFactory.d.dX(null, this.iEK.getResources().getString(R.string.official_notification_no_data)), null);
                    this.mNoDataView.setLayoutParams(new ViewGroup.LayoutParams(-1, -1));
                    ao.setBackgroundColor(this.mNoDataView, R.color.CAM_X0201);
                    this.mRootView.addView(this.mNoDataView);
                }
                if (!this.kKh) {
                    this.kKh = true;
                    this.Ya.setVisibility(8);
                    this.mNoDataView.setVisibility(0);
                    this.mNoDataView.onChangeSkinType(this.mPageContext, TbadkCoreApplication.getInst().getSkinType());
                    return;
                }
                return;
            }
            if (this.mNoDataView != null) {
                this.mNoDataView.setVisibility(8);
            }
            this.kKh = false;
            this.Ya.setData(arrayList2);
            this.Ya.setVisibility(0);
        }
    }
}
