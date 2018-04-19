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
import com.baidu.tbadk.core.util.ak;
import com.baidu.tbadk.core.view.NoDataView;
import com.baidu.tbadk.core.view.NoDataViewFactory;
import com.baidu.tieba.d;
import com.baidu.tieba.im.data.MsgCacheData;
import com.baidu.tieba.im.data.MsgPageData;
import com.baidu.tieba.im.message.chat.ChatMessage;
import com.baidu.tieba.imMessageCenter.mention.OfficialNotificationFragment;
import java.util.ArrayList;
import java.util.List;
/* loaded from: classes2.dex */
public class b {
    private boolean bkp;
    private BdTypeRecyclerView bnQ;
    private com.baidu.tbadk.mvc.g.a cbq;
    private boolean enT;
    private BaseFragmentActivity epn;
    private OfficialNotificationFragment epo;
    private OfficialNotificationTextItemAdapter epp;
    private NoDataView mNoDataView;
    private TbPageContext mPageContext;
    private ViewGroup mRootView;
    private List<ChatMessage> mData = null;
    private List<com.baidu.adp.widget.ListView.a> mAdapters = new ArrayList();

    public b(TbPageContext tbPageContext, OfficialNotificationFragment officialNotificationFragment, ViewGroup viewGroup) {
        if (tbPageContext != null) {
            this.mPageContext = tbPageContext;
            this.epn = (BaseFragmentActivity) this.mPageContext.getPageActivity();
            this.epo = officialNotificationFragment;
            this.mRootView = (ViewGroup) LayoutInflater.from(this.epn).inflate(d.i.fragment_official_notification, viewGroup, false);
            this.bnQ = (BdTypeRecyclerView) this.mRootView.findViewById(d.g.rv_official_notification);
            this.bnQ.setLayoutManager(new LinearLayoutManager(this.epn));
            this.bnQ.setFadingEdgeLength(0);
            this.bnQ.setOverScrollMode(2);
            this.epp = new OfficialNotificationTextItemAdapter(this.mPageContext, ChatMessage.TYPE_MSG_TEXT_OFFICAL_NOTIFICATION);
            this.epp.setOnClickListener(officialNotificationFragment);
            this.mAdapters.add(this.epp);
            this.bnQ.addAdapters(this.mAdapters);
            this.cbq = new com.baidu.tbadk.mvc.g.a(this.epn, this.bnQ);
            this.cbq.setHeight(l.e(this.epn, d.e.tbds182));
            this.cbq.kA();
            this.bnQ.setNextPage(this.cbq);
            this.bnQ.setOnSrollToBottomListener(new BdListView.e() { // from class: com.baidu.tieba.imMessageCenter.mention.officialNotification.b.1
                @Override // com.baidu.adp.widget.ListView.BdListView.e
                public void onScrollToBottom() {
                    b.this.cbq.lN();
                    if (!b.this.epo.getHasMore() || b.this.bkp) {
                        b.this.cbq.fd(d.k.no_more_msg);
                        return;
                    }
                    b.this.cbq.fc(d.k.loading);
                    if (b.this.epo != null) {
                        b.this.epo.acE();
                        b.this.bkp = true;
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
        if (this.epp != null) {
            this.epp.notifyDataSetChanged();
        }
        ak.j(this.bnQ, d.C0126d.cp_bg_line_d);
        if (this.mNoDataView != null) {
            this.mNoDataView.onChangeSkinType(this.mPageContext, TbadkCoreApplication.getInst().getSkinType());
            ak.j(this.mNoDataView, d.C0126d.cp_bg_line_d);
        }
        if (this.cbq != null) {
            this.cbq.b(this.mPageContext, TbadkCoreApplication.getInst().getSkinType());
        }
    }

    public void a(MsgPageData msgPageData) {
        if (this.bnQ != null && msgPageData != null) {
            setData(msgPageData.getChatMessages());
            this.bnQ.getAdapter().notifyDataSetChanged();
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
        if (this.bnQ != null) {
            this.bkp = false;
            if (msgPageData != null) {
                try {
                    setData(msgPageData.getChatMessages());
                    this.bnQ.getAdapter().notifyDataSetChanged();
                    if (i >= 0) {
                        this.bnQ.setSelection(i);
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
        return (this.bnQ == null || this.mData == null || this.bnQ.getFirstVisiblePosition() != 0) ? false : true;
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
        if (this.bnQ != null) {
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
                    this.mNoDataView = NoDataViewFactory.a(this.epn, null, NoDataViewFactory.c.a(NoDataViewFactory.ImgType.NODATA, (int) this.mPageContext.getResources().getDimension(d.e.ds80)), NoDataViewFactory.d.m16do(d.k.official_notification_no_data), null);
                    this.mNoDataView.setLayoutParams(new ViewGroup.LayoutParams(-1, -1));
                    ak.j(this.mNoDataView, d.C0126d.cp_bg_line_d);
                    this.mRootView.addView(this.mNoDataView);
                }
                if (!this.enT) {
                    this.enT = true;
                    this.bnQ.setVisibility(8);
                    this.mNoDataView.setVisibility(0);
                    this.mNoDataView.onChangeSkinType(this.mPageContext, TbadkCoreApplication.getInst().getSkinType());
                    return;
                }
                return;
            }
            if (this.mNoDataView != null) {
                this.mNoDataView.setVisibility(8);
            }
            this.enT = false;
            this.bnQ.setData(arrayList2);
            this.bnQ.setVisibility(0);
        }
    }
}
