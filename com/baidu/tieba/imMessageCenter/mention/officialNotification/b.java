package com.baidu.tieba.imMessageCenter.mention.officialNotification;

import android.support.v7.widget.LinearLayoutManager;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import com.baidu.adp.lib.util.l;
import com.baidu.adp.widget.ListView.BdListView;
import com.baidu.adp.widget.ListView.BdTypeRecyclerView;
import com.baidu.tbadk.TbPageContext;
import com.baidu.tbadk.core.BaseFragmentActivity;
import com.baidu.tbadk.core.TbadkCoreApplication;
import com.baidu.tbadk.core.util.am;
import com.baidu.tbadk.core.view.NoDataView;
import com.baidu.tbadk.core.view.NoDataViewFactory;
import com.baidu.tieba.R;
import com.baidu.tieba.im.data.MsgCacheData;
import com.baidu.tieba.im.data.MsgPageData;
import com.baidu.tieba.im.message.chat.ChatMessage;
import com.baidu.tieba.imMessageCenter.mention.OfficialNotificationFragment;
import java.util.ArrayList;
import java.util.List;
/* loaded from: classes4.dex */
public class b {
    private BaseFragmentActivity fyM;
    private boolean gWJ;
    private com.baidu.tbadk.mvc.g.a gYc;
    private OfficialNotificationFragment gYd;
    private OfficialNotificationTextItemAdapter gYe;
    private boolean isLoadMore;
    private NoDataView mNoDataView;
    private TbPageContext mPageContext;
    private ViewGroup mRootView;
    private BdTypeRecyclerView zj;
    private List<ChatMessage> mData = null;
    private List<com.baidu.adp.widget.ListView.a> agQ = new ArrayList();

    public b(TbPageContext tbPageContext, OfficialNotificationFragment officialNotificationFragment, ViewGroup viewGroup) {
        if (tbPageContext != null) {
            this.mPageContext = tbPageContext;
            this.fyM = (BaseFragmentActivity) this.mPageContext.getPageActivity();
            this.gYd = officialNotificationFragment;
            this.mRootView = (ViewGroup) LayoutInflater.from(this.fyM).inflate(R.layout.fragment_official_notification, viewGroup, false);
            this.zj = (BdTypeRecyclerView) this.mRootView.findViewById(R.id.rv_official_notification);
            this.zj.setLayoutManager(new LinearLayoutManager(this.fyM));
            this.zj.setFadingEdgeLength(0);
            this.zj.setOverScrollMode(2);
            this.gYe = new OfficialNotificationTextItemAdapter(this.mPageContext, ChatMessage.TYPE_MSG_TEXT_OFFICAL_NOTIFICATION);
            this.gYe.setOnClickListener(officialNotificationFragment);
            this.agQ.add(this.gYe);
            this.zj.addAdapters(this.agQ);
            this.gYc = new com.baidu.tbadk.mvc.g.a(this.fyM, this.zj);
            this.gYc.setHeight(l.getDimens(this.fyM, R.dimen.tbds182));
            this.gYc.createView();
            this.zj.setNextPage(this.gYc);
            this.zj.setOnSrollToBottomListener(new BdListView.e() { // from class: com.baidu.tieba.imMessageCenter.mention.officialNotification.b.1
                @Override // com.baidu.adp.widget.ListView.BdListView.e
                public void onScrollToBottom() {
                    b.this.gYc.le();
                    if (!b.this.gYd.getHasMore() || b.this.isLoadMore) {
                        b.this.gYc.kf(R.string.no_more_msg);
                        return;
                    }
                    b.this.gYc.ke(R.string.loading);
                    if (b.this.gYd != null) {
                        b.this.gYd.aLG();
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
        if (this.gYe != null) {
            this.gYe.notifyDataSetChanged();
        }
        am.setBackgroundColor(this.zj, R.color.cp_bg_line_d);
        if (this.mNoDataView != null) {
            this.mNoDataView.onChangeSkinType(this.mPageContext, TbadkCoreApplication.getInst().getSkinType());
            am.setBackgroundColor(this.mNoDataView, R.color.cp_bg_line_d);
        }
        if (this.gYc != null) {
            this.gYc.b(this.mPageContext, TbadkCoreApplication.getInst().getSkinType());
        }
    }

    public void a(MsgPageData msgPageData) {
        if (this.zj != null && msgPageData != null) {
            setData(msgPageData.getChatMessages());
            this.zj.getAdapter().notifyDataSetChanged();
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
        if (this.zj != null) {
            this.isLoadMore = false;
            if (msgPageData != null) {
                try {
                    setData(msgPageData.getChatMessages());
                    this.zj.getAdapter().notifyDataSetChanged();
                    if (i >= 0) {
                        this.zj.setSelection(i);
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
        return (this.zj == null || this.mData == null || this.zj.getFirstVisiblePosition() != 0) ? false : true;
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
        if (this.zj != null) {
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
                    this.mNoDataView = NoDataViewFactory.a(this.fyM, null, NoDataViewFactory.c.a(NoDataViewFactory.ImgType.NODATA), NoDataViewFactory.d.iL(R.string.official_notification_no_data), null);
                    this.mNoDataView.setLayoutParams(new ViewGroup.LayoutParams(-1, -1));
                    am.setBackgroundColor(this.mNoDataView, R.color.cp_bg_line_d);
                    this.mRootView.addView(this.mNoDataView);
                }
                if (!this.gWJ) {
                    this.gWJ = true;
                    this.zj.setVisibility(8);
                    this.mNoDataView.setVisibility(0);
                    this.mNoDataView.onChangeSkinType(this.mPageContext, TbadkCoreApplication.getInst().getSkinType());
                    return;
                }
                return;
            }
            if (this.mNoDataView != null) {
                this.mNoDataView.setVisibility(8);
            }
            this.gWJ = false;
            this.zj.setData(arrayList2);
            this.zj.setVisibility(0);
        }
    }
}
