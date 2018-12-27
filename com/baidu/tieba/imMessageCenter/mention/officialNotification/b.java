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
import com.baidu.tbadk.core.util.al;
import com.baidu.tbadk.core.view.NoDataView;
import com.baidu.tbadk.core.view.NoDataViewFactory;
import com.baidu.tieba.e;
import com.baidu.tieba.im.data.MsgCacheData;
import com.baidu.tieba.im.data.MsgPageData;
import com.baidu.tieba.im.message.chat.ChatMessage;
import com.baidu.tieba.imMessageCenter.mention.OfficialNotificationFragment;
import java.util.ArrayList;
import java.util.List;
/* loaded from: classes4.dex */
public class b {
    private BaseFragmentActivity bLT;
    private boolean bNS;
    private BdTypeRecyclerView bRn;
    private com.baidu.tbadk.mvc.g.a cJf;
    private boolean fhS;
    private OfficialNotificationFragment fjn;
    private OfficialNotificationTextItemAdapter fjo;
    private NoDataView mNoDataView;
    private TbPageContext mPageContext;
    private ViewGroup mRootView;
    private List<ChatMessage> mData = null;
    private List<com.baidu.adp.widget.ListView.a> mAdapters = new ArrayList();

    public b(TbPageContext tbPageContext, OfficialNotificationFragment officialNotificationFragment, ViewGroup viewGroup) {
        if (tbPageContext != null) {
            this.mPageContext = tbPageContext;
            this.bLT = (BaseFragmentActivity) this.mPageContext.getPageActivity();
            this.fjn = officialNotificationFragment;
            this.mRootView = (ViewGroup) LayoutInflater.from(this.bLT).inflate(e.h.fragment_official_notification, viewGroup, false);
            this.bRn = (BdTypeRecyclerView) this.mRootView.findViewById(e.g.rv_official_notification);
            this.bRn.setLayoutManager(new LinearLayoutManager(this.bLT));
            this.bRn.setFadingEdgeLength(0);
            this.bRn.setOverScrollMode(2);
            this.fjo = new OfficialNotificationTextItemAdapter(this.mPageContext, ChatMessage.TYPE_MSG_TEXT_OFFICAL_NOTIFICATION);
            this.fjo.setOnClickListener(officialNotificationFragment);
            this.mAdapters.add(this.fjo);
            this.bRn.addAdapters(this.mAdapters);
            this.cJf = new com.baidu.tbadk.mvc.g.a(this.bLT, this.bRn);
            this.cJf.setHeight(l.h(this.bLT, e.C0210e.tbds182));
            this.cJf.oD();
            this.bRn.setNextPage(this.cJf);
            this.bRn.setOnSrollToBottomListener(new BdListView.e() { // from class: com.baidu.tieba.imMessageCenter.mention.officialNotification.b.1
                @Override // com.baidu.adp.widget.ListView.BdListView.e
                public void onScrollToBottom() {
                    b.this.cJf.pN();
                    if (!b.this.fjn.getHasMore() || b.this.bNS) {
                        b.this.cJf.gh(e.j.no_more_msg);
                        return;
                    }
                    b.this.cJf.gg(e.j.loading);
                    if (b.this.fjn != null) {
                        b.this.fjn.anD();
                        b.this.bNS = true;
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
        if (this.fjo != null) {
            this.fjo.notifyDataSetChanged();
        }
        al.j(this.bRn, e.d.cp_bg_line_d);
        if (this.mNoDataView != null) {
            this.mNoDataView.onChangeSkinType(this.mPageContext, TbadkCoreApplication.getInst().getSkinType());
            al.j(this.mNoDataView, e.d.cp_bg_line_d);
        }
        if (this.cJf != null) {
            this.cJf.b(this.mPageContext, TbadkCoreApplication.getInst().getSkinType());
        }
    }

    public void a(MsgPageData msgPageData) {
        if (this.bRn != null && msgPageData != null) {
            setData(msgPageData.getChatMessages());
            this.bRn.getAdapter().notifyDataSetChanged();
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
        if (this.bRn != null) {
            this.bNS = false;
            if (msgPageData != null) {
                try {
                    setData(msgPageData.getChatMessages());
                    this.bRn.getAdapter().notifyDataSetChanged();
                    if (i >= 0) {
                        this.bRn.setSelection(i);
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
        return (this.bRn == null || this.mData == null || this.bRn.getFirstVisiblePosition() != 0) ? false : true;
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
        if (this.bRn != null) {
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
                    this.mNoDataView = NoDataViewFactory.a(this.bLT, null, NoDataViewFactory.c.a(NoDataViewFactory.ImgType.NODATA, (int) this.mPageContext.getResources().getDimension(e.C0210e.ds80)), NoDataViewFactory.d.eq(e.j.official_notification_no_data), null);
                    this.mNoDataView.setLayoutParams(new ViewGroup.LayoutParams(-1, -1));
                    al.j(this.mNoDataView, e.d.cp_bg_line_d);
                    this.mRootView.addView(this.mNoDataView);
                }
                if (!this.fhS) {
                    this.fhS = true;
                    this.bRn.setVisibility(8);
                    this.mNoDataView.setVisibility(0);
                    this.mNoDataView.onChangeSkinType(this.mPageContext, TbadkCoreApplication.getInst().getSkinType());
                    return;
                }
                return;
            }
            if (this.mNoDataView != null) {
                this.mNoDataView.setVisibility(8);
            }
            this.fhS = false;
            this.bRn.setData(arrayList2);
            this.bRn.setVisibility(0);
        }
    }
}
