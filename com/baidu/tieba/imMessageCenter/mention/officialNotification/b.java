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
/* loaded from: classes16.dex */
public class b {
    private BdTypeRecyclerView VT;
    private BaseFragmentActivity hjZ;
    private boolean isLoadMore;
    private NavigationBarShadowView jpe;
    private boolean jqy;
    private com.baidu.tbadk.mvc.g.a jrR;
    private OfficialNotificationFragment jrS;
    private OfficialNotificationTextItemAdapter jrT;
    private NoDataView mNoDataView;
    private TbPageContext mPageContext;
    private ViewGroup mRootView;
    private List<ChatMessage> mData = null;
    private List<com.baidu.adp.widget.ListView.a> aWf = new ArrayList();
    private RecyclerView.OnScrollListener jqD = new RecyclerView.OnScrollListener() { // from class: com.baidu.tieba.imMessageCenter.mention.officialNotification.b.1
        @Override // android.support.v7.widget.RecyclerView.OnScrollListener
        public void onScrollStateChanged(RecyclerView recyclerView, int i) {
            super.onScrollStateChanged(recyclerView, i);
            switch (i) {
                case 0:
                    if (recyclerView.canScrollVertically(-1)) {
                        b.this.jpe.show();
                        return;
                    } else {
                        b.this.jpe.hide();
                        return;
                    }
                case 1:
                case 2:
                    b.this.jpe.show();
                    return;
                default:
                    return;
            }
        }
    };

    public b(TbPageContext tbPageContext, OfficialNotificationFragment officialNotificationFragment, ViewGroup viewGroup) {
        if (tbPageContext != null) {
            this.mPageContext = tbPageContext;
            this.hjZ = (BaseFragmentActivity) this.mPageContext.getPageActivity();
            this.jrS = officialNotificationFragment;
            this.mRootView = (ViewGroup) LayoutInflater.from(this.hjZ).inflate(R.layout.fragment_official_notification, viewGroup, false);
            this.jpe = (NavigationBarShadowView) this.mRootView.findViewById(R.id.navi_shadow_view_official_notification);
            this.VT = (BdTypeRecyclerView) this.mRootView.findViewById(R.id.rv_official_notification);
            this.VT.setLayoutManager(new LinearLayoutManager(this.hjZ));
            this.VT.setFadingEdgeLength(0);
            this.VT.setOverScrollMode(2);
            this.VT.addOnScrollListener(this.jqD);
            this.jrT = new OfficialNotificationTextItemAdapter(this.mPageContext, ChatMessage.TYPE_MSG_LEFT);
            this.jrT.setOnClickListener(officialNotificationFragment);
            this.aWf.add(this.jrT);
            this.VT.addAdapters(this.aWf);
            this.jrR = new com.baidu.tbadk.mvc.g.a(this.hjZ, this.VT);
            this.jrR.setHeight(l.getDimens(this.hjZ, R.dimen.tbds182));
            this.jrR.createView();
            this.VT.setNextPage(this.jrR);
            this.VT.setOnSrollToBottomListener(new BdListView.e() { // from class: com.baidu.tieba.imMessageCenter.mention.officialNotification.b.2
                @Override // com.baidu.adp.widget.ListView.BdListView.e
                public void onScrollToBottom() {
                    b.this.jrR.display();
                    if (!b.this.jrS.getHasMore() || b.this.isLoadMore) {
                        b.this.jrR.on(R.string.no_more_msg);
                        return;
                    }
                    b.this.jrR.om(R.string.loading);
                    if (b.this.jrS != null) {
                        b.this.jrS.bAT();
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
        if (this.jrT != null) {
            this.jrT.notifyDataSetChanged();
        }
        ao.setBackgroundColor(this.VT, R.color.cp_bg_line_d);
        if (this.mNoDataView != null) {
            this.mNoDataView.onChangeSkinType(this.mPageContext, TbadkCoreApplication.getInst().getSkinType());
            ao.setBackgroundColor(this.mNoDataView, R.color.cp_bg_line_d);
        }
        if (this.jrR != null) {
            this.jrR.b(this.mPageContext, TbadkCoreApplication.getInst().getSkinType());
        }
    }

    public void a(MsgPageData msgPageData) {
        if (this.VT != null && msgPageData != null) {
            setData(msgPageData.getChatMessages());
            this.VT.getAdapter().notifyDataSetChanged();
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
        if (this.VT != null) {
            this.isLoadMore = false;
            if (msgPageData != null) {
                try {
                    setData(msgPageData.getChatMessages());
                    this.VT.getAdapter().notifyDataSetChanged();
                    if (i >= 0) {
                        this.VT.setSelection(i);
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
        return (this.VT == null || this.mData == null || this.VT.getFirstVisiblePosition() != 0) ? false : true;
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
        if (this.VT != null) {
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
                    this.mNoDataView = NoDataViewFactory.a(this.hjZ, null, NoDataViewFactory.c.a(NoDataViewFactory.ImgType.CREATE), NoDataViewFactory.d.m31do(null, this.hjZ.getResources().getString(R.string.official_notification_no_data)), null);
                    this.mNoDataView.setLayoutParams(new ViewGroup.LayoutParams(-1, -1));
                    ao.setBackgroundColor(this.mNoDataView, R.color.cp_bg_line_d);
                    this.mRootView.addView(this.mNoDataView);
                }
                if (!this.jqy) {
                    this.jqy = true;
                    this.VT.setVisibility(8);
                    this.mNoDataView.setVisibility(0);
                    this.mNoDataView.onChangeSkinType(this.mPageContext, TbadkCoreApplication.getInst().getSkinType());
                    return;
                }
                return;
            }
            if (this.mNoDataView != null) {
                this.mNoDataView.setVisibility(8);
            }
            this.jqy = false;
            this.VT.setData(arrayList2);
            this.VT.setVisibility(0);
        }
    }
}
