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
import com.baidu.tieba.d;
import com.baidu.tieba.im.data.MsgCacheData;
import com.baidu.tieba.im.data.MsgPageData;
import com.baidu.tieba.im.message.chat.ChatMessage;
import com.baidu.tieba.imMessageCenter.mention.OfficialNotificationFragment;
import java.util.ArrayList;
import java.util.List;
/* loaded from: classes2.dex */
public class b {
    private BaseFragmentActivity bqF;
    private boolean bsI;
    private BdTypeRecyclerView bwl;
    private com.baidu.tbadk.mvc.g.a ckn;
    private boolean eAq;
    private OfficialNotificationFragment eBK;
    private OfficialNotificationTextItemAdapter eBL;
    private NoDataView mNoDataView;
    private TbPageContext mPageContext;
    private ViewGroup mRootView;
    private List<ChatMessage> mData = null;
    private List<com.baidu.adp.widget.ListView.a> mAdapters = new ArrayList();

    public b(TbPageContext tbPageContext, OfficialNotificationFragment officialNotificationFragment, ViewGroup viewGroup) {
        if (tbPageContext != null) {
            this.mPageContext = tbPageContext;
            this.bqF = (BaseFragmentActivity) this.mPageContext.getPageActivity();
            this.eBK = officialNotificationFragment;
            this.mRootView = (ViewGroup) LayoutInflater.from(this.bqF).inflate(d.i.fragment_official_notification, viewGroup, false);
            this.bwl = (BdTypeRecyclerView) this.mRootView.findViewById(d.g.rv_official_notification);
            this.bwl.setLayoutManager(new LinearLayoutManager(this.bqF));
            this.bwl.setFadingEdgeLength(0);
            this.bwl.setOverScrollMode(2);
            this.eBL = new OfficialNotificationTextItemAdapter(this.mPageContext, ChatMessage.TYPE_MSG_TEXT_OFFICAL_NOTIFICATION);
            this.eBL.setOnClickListener(officialNotificationFragment);
            this.mAdapters.add(this.eBL);
            this.bwl.addAdapters(this.mAdapters);
            this.ckn = new com.baidu.tbadk.mvc.g.a(this.bqF, this.bwl);
            this.ckn.setHeight(l.e(this.bqF, d.e.tbds182));
            this.ckn.nn();
            this.bwl.setNextPage(this.ckn);
            this.bwl.setOnSrollToBottomListener(new BdListView.e() { // from class: com.baidu.tieba.imMessageCenter.mention.officialNotification.b.1
                @Override // com.baidu.adp.widget.ListView.BdListView.e
                public void onScrollToBottom() {
                    b.this.ckn.oD();
                    if (!b.this.eBK.getHasMore() || b.this.bsI) {
                        b.this.ckn.fi(d.k.no_more_msg);
                        return;
                    }
                    b.this.ckn.fh(d.k.loading);
                    if (b.this.eBK != null) {
                        b.this.eBK.agb();
                        b.this.bsI = true;
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
        if (this.eBL != null) {
            this.eBL.notifyDataSetChanged();
        }
        al.j(this.bwl, d.C0141d.cp_bg_line_d);
        if (this.mNoDataView != null) {
            this.mNoDataView.onChangeSkinType(this.mPageContext, TbadkCoreApplication.getInst().getSkinType());
            al.j(this.mNoDataView, d.C0141d.cp_bg_line_d);
        }
        if (this.ckn != null) {
            this.ckn.b(this.mPageContext, TbadkCoreApplication.getInst().getSkinType());
        }
    }

    public void a(MsgPageData msgPageData) {
        if (this.bwl != null && msgPageData != null) {
            setData(msgPageData.getChatMessages());
            this.bwl.getAdapter().notifyDataSetChanged();
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
        if (this.bwl != null) {
            this.bsI = false;
            if (msgPageData != null) {
                try {
                    setData(msgPageData.getChatMessages());
                    this.bwl.getAdapter().notifyDataSetChanged();
                    if (i >= 0) {
                        this.bwl.setSelection(i);
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
        return (this.bwl == null || this.mData == null || this.bwl.getFirstVisiblePosition() != 0) ? false : true;
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
        if (this.bwl != null) {
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
                    this.mNoDataView = NoDataViewFactory.a(this.bqF, null, NoDataViewFactory.c.a(NoDataViewFactory.ImgType.NODATA, (int) this.mPageContext.getResources().getDimension(d.e.ds80)), NoDataViewFactory.d.dr(d.k.official_notification_no_data), null);
                    this.mNoDataView.setLayoutParams(new ViewGroup.LayoutParams(-1, -1));
                    al.j(this.mNoDataView, d.C0141d.cp_bg_line_d);
                    this.mRootView.addView(this.mNoDataView);
                }
                if (!this.eAq) {
                    this.eAq = true;
                    this.bwl.setVisibility(8);
                    this.mNoDataView.setVisibility(0);
                    this.mNoDataView.onChangeSkinType(this.mPageContext, TbadkCoreApplication.getInst().getSkinType());
                    return;
                }
                return;
            }
            if (this.mNoDataView != null) {
                this.mNoDataView.setVisibility(8);
            }
            this.eAq = false;
            this.bwl.setData(arrayList2);
            this.bwl.setVisibility(0);
        }
    }
}
