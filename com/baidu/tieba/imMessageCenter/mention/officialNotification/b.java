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
    private BaseFragmentActivity bHp;
    private boolean bJp;
    private BdTypeRecyclerView bMI;
    private com.baidu.tbadk.mvc.g.a cCY;
    private boolean eWT;
    private OfficialNotificationFragment eYm;
    private OfficialNotificationTextItemAdapter eYn;
    private NoDataView mNoDataView;
    private TbPageContext mPageContext;
    private ViewGroup mRootView;
    private List<ChatMessage> mData = null;
    private List<com.baidu.adp.widget.ListView.a> mAdapters = new ArrayList();

    public b(TbPageContext tbPageContext, OfficialNotificationFragment officialNotificationFragment, ViewGroup viewGroup) {
        if (tbPageContext != null) {
            this.mPageContext = tbPageContext;
            this.bHp = (BaseFragmentActivity) this.mPageContext.getPageActivity();
            this.eYm = officialNotificationFragment;
            this.mRootView = (ViewGroup) LayoutInflater.from(this.bHp).inflate(e.h.fragment_official_notification, viewGroup, false);
            this.bMI = (BdTypeRecyclerView) this.mRootView.findViewById(e.g.rv_official_notification);
            this.bMI.setLayoutManager(new LinearLayoutManager(this.bHp));
            this.bMI.setFadingEdgeLength(0);
            this.bMI.setOverScrollMode(2);
            this.eYn = new OfficialNotificationTextItemAdapter(this.mPageContext, ChatMessage.TYPE_MSG_TEXT_OFFICAL_NOTIFICATION);
            this.eYn.setOnClickListener(officialNotificationFragment);
            this.mAdapters.add(this.eYn);
            this.bMI.addAdapters(this.mAdapters);
            this.cCY = new com.baidu.tbadk.mvc.g.a(this.bHp, this.bMI);
            this.cCY.setHeight(l.h(this.bHp, e.C0175e.tbds182));
            this.cCY.oG();
            this.bMI.setNextPage(this.cCY);
            this.bMI.setOnSrollToBottomListener(new BdListView.e() { // from class: com.baidu.tieba.imMessageCenter.mention.officialNotification.b.1
                @Override // com.baidu.adp.widget.ListView.BdListView.e
                public void onScrollToBottom() {
                    b.this.cCY.pQ();
                    if (!b.this.eYm.getHasMore() || b.this.bJp) {
                        b.this.cCY.fE(e.j.no_more_msg);
                        return;
                    }
                    b.this.cCY.fD(e.j.loading);
                    if (b.this.eYm != null) {
                        b.this.eYm.amu();
                        b.this.bJp = true;
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
        if (this.eYn != null) {
            this.eYn.notifyDataSetChanged();
        }
        al.j(this.bMI, e.d.cp_bg_line_d);
        if (this.mNoDataView != null) {
            this.mNoDataView.onChangeSkinType(this.mPageContext, TbadkCoreApplication.getInst().getSkinType());
            al.j(this.mNoDataView, e.d.cp_bg_line_d);
        }
        if (this.cCY != null) {
            this.cCY.b(this.mPageContext, TbadkCoreApplication.getInst().getSkinType());
        }
    }

    public void a(MsgPageData msgPageData) {
        if (this.bMI != null && msgPageData != null) {
            setData(msgPageData.getChatMessages());
            this.bMI.getAdapter().notifyDataSetChanged();
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
        if (this.bMI != null) {
            this.bJp = false;
            if (msgPageData != null) {
                try {
                    setData(msgPageData.getChatMessages());
                    this.bMI.getAdapter().notifyDataSetChanged();
                    if (i >= 0) {
                        this.bMI.setSelection(i);
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
        return (this.bMI == null || this.mData == null || this.bMI.getFirstVisiblePosition() != 0) ? false : true;
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
        if (this.bMI != null) {
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
                    this.mNoDataView = NoDataViewFactory.a(this.bHp, null, NoDataViewFactory.c.a(NoDataViewFactory.ImgType.NODATA, (int) this.mPageContext.getResources().getDimension(e.C0175e.ds80)), NoDataViewFactory.d.dO(e.j.official_notification_no_data), null);
                    this.mNoDataView.setLayoutParams(new ViewGroup.LayoutParams(-1, -1));
                    al.j(this.mNoDataView, e.d.cp_bg_line_d);
                    this.mRootView.addView(this.mNoDataView);
                }
                if (!this.eWT) {
                    this.eWT = true;
                    this.bMI.setVisibility(8);
                    this.mNoDataView.setVisibility(0);
                    this.mNoDataView.onChangeSkinType(this.mPageContext, TbadkCoreApplication.getInst().getSkinType());
                    return;
                }
                return;
            }
            if (this.mNoDataView != null) {
                this.mNoDataView.setVisibility(8);
            }
            this.eWT = false;
            this.bMI.setData(arrayList2);
            this.bMI.setVisibility(0);
        }
    }
}
