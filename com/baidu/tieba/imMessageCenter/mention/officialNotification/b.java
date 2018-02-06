package com.baidu.tieba.imMessageCenter.mention.officialNotification;

import android.support.v7.widget.LinearLayoutManager;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import com.baidu.adp.widget.ListView.BdListView;
import com.baidu.adp.widget.ListView.BdTypeRecyclerView;
import com.baidu.tbadk.TbPageContext;
import com.baidu.tbadk.core.TbadkCoreApplication;
import com.baidu.tbadk.core.util.aj;
import com.baidu.tbadk.core.view.NoDataViewFactory;
import com.baidu.tbadk.core.view.h;
import com.baidu.tieba.d;
import com.baidu.tieba.im.data.MsgCacheData;
import com.baidu.tieba.im.data.MsgPageData;
import com.baidu.tieba.im.message.chat.ChatMessage;
import com.baidu.tieba.imMessageCenter.mention.MessageCenterActivity;
import com.baidu.tieba.imMessageCenter.mention.l;
import java.util.ArrayList;
import java.util.List;
/* loaded from: classes2.dex */
public class b {
    private com.baidu.tbadk.mvc.g.a cLp;
    private boolean cay;
    private BdTypeRecyclerView cea;
    private boolean eTn;
    private MessageCenterActivity eUF;
    private l eUG;
    private OfficialNotificationTextItemAdapter eUH;
    private h mNoDataView;
    private TbPageContext mPageContext;
    private ViewGroup mRootView;
    private List<ChatMessage> mData = null;
    private List<com.baidu.adp.widget.ListView.a> mAdapters = new ArrayList();

    public b(TbPageContext tbPageContext, l lVar, ViewGroup viewGroup) {
        if (tbPageContext != null) {
            this.mPageContext = tbPageContext;
            this.eUF = (MessageCenterActivity) this.mPageContext.getPageActivity();
            this.eUG = lVar;
            this.mRootView = (ViewGroup) LayoutInflater.from(this.eUF).inflate(d.h.fragment_official_notification, viewGroup, false);
            this.cea = (BdTypeRecyclerView) this.mRootView.findViewById(d.g.rv_official_notification);
            this.cea.setLayoutManager(new LinearLayoutManager(this.eUF));
            this.cea.setFadingEdgeLength(0);
            this.cea.setOverScrollMode(2);
            this.eUH = new OfficialNotificationTextItemAdapter(this.mPageContext, ChatMessage.TYPE_MSG_TEXT_OFFICAL_NOTIFICATION);
            this.eUH.setOnClickListener(lVar);
            this.mAdapters.add(this.eUH);
            this.cea.addAdapters(this.mAdapters);
            this.cLp = new com.baidu.tbadk.mvc.g.a(this.eUF, this.cea);
            this.cLp.setHeight(com.baidu.adp.lib.util.l.t(this.eUF, d.e.tbds182));
            this.cLp.st();
            this.cea.setNextPage(this.cLp);
            this.cea.setOnSrollToBottomListener(new BdListView.e() { // from class: com.baidu.tieba.imMessageCenter.mention.officialNotification.b.1
                @Override // com.baidu.adp.widget.ListView.BdListView.e
                public void onScrollToBottom() {
                    b.this.cLp.th();
                    if (!b.this.eUG.getHasMore() || b.this.cay) {
                        b.this.cLp.ie(d.j.no_more_msg);
                        return;
                    }
                    b.this.cLp.id(d.j.loading);
                    if (b.this.eUG != null) {
                        b.this.eUG.aiy();
                        b.this.cay = true;
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
        if (this.eUH != null) {
            this.eUH.notifyDataSetChanged();
        }
        aj.t(this.cea, d.C0140d.cp_bg_line_d);
        if (this.mNoDataView != null) {
            this.mNoDataView.onChangeSkinType(this.mPageContext, TbadkCoreApplication.getInst().getSkinType());
            aj.t(this.mNoDataView, d.C0140d.cp_bg_line_d);
        }
        if (this.cLp != null) {
            this.cLp.b(this.mPageContext, TbadkCoreApplication.getInst().getSkinType());
        }
    }

    public void a(MsgPageData msgPageData) {
        if (this.cea != null && msgPageData != null) {
            setData(msgPageData.getChatMessages());
            this.cea.getAdapter().notifyDataSetChanged();
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
        if (this.cea != null) {
            this.cay = false;
            if (msgPageData != null) {
                try {
                    setData(msgPageData.getChatMessages());
                    this.cea.getAdapter().notifyDataSetChanged();
                    if (i >= 0) {
                        this.cea.setSelection(i);
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
        return (this.cea == null || this.mData == null || this.cea.getFirstVisiblePosition() != 0) ? false : true;
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
        if (this.cea != null) {
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
                    this.mNoDataView = NoDataViewFactory.a(this.eUF, null, NoDataViewFactory.c.a(NoDataViewFactory.ImgType.NODATA, (int) this.mPageContext.getResources().getDimension(d.e.ds80)), NoDataViewFactory.d.gp(d.j.official_notification_no_data), null);
                    this.mNoDataView.setLayoutParams(new ViewGroup.LayoutParams(-1, -1));
                    aj.t(this.mNoDataView, d.C0140d.cp_bg_line_d);
                    this.mRootView.addView(this.mNoDataView);
                }
                if (!this.eTn) {
                    this.eTn = true;
                    this.cea.setVisibility(8);
                    this.mNoDataView.setVisibility(0);
                    this.mNoDataView.onChangeSkinType(this.mPageContext, TbadkCoreApplication.getInst().getSkinType());
                    return;
                }
                return;
            }
            if (this.mNoDataView != null) {
                this.mNoDataView.setVisibility(8);
            }
            this.eTn = false;
            this.cea.setData(arrayList2);
            this.cea.setVisibility(0);
        }
    }
}
