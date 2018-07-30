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
import com.baidu.tieba.d;
import com.baidu.tieba.im.data.MsgCacheData;
import com.baidu.tieba.im.data.MsgPageData;
import com.baidu.tieba.im.message.chat.ChatMessage;
import com.baidu.tieba.imMessageCenter.mention.OfficialNotificationFragment;
import java.util.ArrayList;
import java.util.List;
/* loaded from: classes2.dex */
public class b {
    private BaseFragmentActivity bsO;
    private boolean buQ;
    private BdTypeRecyclerView bym;
    private com.baidu.tbadk.mvc.g.a coH;
    private boolean eIa;
    private OfficialNotificationFragment eJu;
    private OfficialNotificationTextItemAdapter eJv;
    private NoDataView mNoDataView;
    private TbPageContext mPageContext;
    private ViewGroup mRootView;
    private List<ChatMessage> mData = null;
    private List<com.baidu.adp.widget.ListView.a> mAdapters = new ArrayList();

    public b(TbPageContext tbPageContext, OfficialNotificationFragment officialNotificationFragment, ViewGroup viewGroup) {
        if (tbPageContext != null) {
            this.mPageContext = tbPageContext;
            this.bsO = (BaseFragmentActivity) this.mPageContext.getPageActivity();
            this.eJu = officialNotificationFragment;
            this.mRootView = (ViewGroup) LayoutInflater.from(this.bsO).inflate(d.h.fragment_official_notification, viewGroup, false);
            this.bym = (BdTypeRecyclerView) this.mRootView.findViewById(d.g.rv_official_notification);
            this.bym.setLayoutManager(new LinearLayoutManager(this.bsO));
            this.bym.setFadingEdgeLength(0);
            this.bym.setOverScrollMode(2);
            this.eJv = new OfficialNotificationTextItemAdapter(this.mPageContext, ChatMessage.TYPE_MSG_TEXT_OFFICAL_NOTIFICATION);
            this.eJv.setOnClickListener(officialNotificationFragment);
            this.mAdapters.add(this.eJv);
            this.bym.addAdapters(this.mAdapters);
            this.coH = new com.baidu.tbadk.mvc.g.a(this.bsO, this.bym);
            this.coH.setHeight(l.f(this.bsO, d.e.tbds182));
            this.coH.np();
            this.bym.setNextPage(this.coH);
            this.bym.setOnSrollToBottomListener(new BdListView.e() { // from class: com.baidu.tieba.imMessageCenter.mention.officialNotification.b.1
                @Override // com.baidu.adp.widget.ListView.BdListView.e
                public void onScrollToBottom() {
                    b.this.coH.oF();
                    if (!b.this.eJu.getHasMore() || b.this.buQ) {
                        b.this.coH.fk(d.j.no_more_msg);
                        return;
                    }
                    b.this.coH.fj(d.j.loading);
                    if (b.this.eJu != null) {
                        b.this.eJu.ahc();
                        b.this.buQ = true;
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
        if (this.eJv != null) {
            this.eJv.notifyDataSetChanged();
        }
        am.j(this.bym, d.C0140d.cp_bg_line_d);
        if (this.mNoDataView != null) {
            this.mNoDataView.onChangeSkinType(this.mPageContext, TbadkCoreApplication.getInst().getSkinType());
            am.j(this.mNoDataView, d.C0140d.cp_bg_line_d);
        }
        if (this.coH != null) {
            this.coH.b(this.mPageContext, TbadkCoreApplication.getInst().getSkinType());
        }
    }

    public void a(MsgPageData msgPageData) {
        if (this.bym != null && msgPageData != null) {
            setData(msgPageData.getChatMessages());
            this.bym.getAdapter().notifyDataSetChanged();
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
        if (this.bym != null) {
            this.buQ = false;
            if (msgPageData != null) {
                try {
                    setData(msgPageData.getChatMessages());
                    this.bym.getAdapter().notifyDataSetChanged();
                    if (i >= 0) {
                        this.bym.setSelection(i);
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
        return (this.bym == null || this.mData == null || this.bym.getFirstVisiblePosition() != 0) ? false : true;
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
        if (this.bym != null) {
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
                    this.mNoDataView = NoDataViewFactory.a(this.bsO, null, NoDataViewFactory.c.a(NoDataViewFactory.ImgType.NODATA, (int) this.mPageContext.getResources().getDimension(d.e.ds80)), NoDataViewFactory.d.du(d.j.official_notification_no_data), null);
                    this.mNoDataView.setLayoutParams(new ViewGroup.LayoutParams(-1, -1));
                    am.j(this.mNoDataView, d.C0140d.cp_bg_line_d);
                    this.mRootView.addView(this.mNoDataView);
                }
                if (!this.eIa) {
                    this.eIa = true;
                    this.bym.setVisibility(8);
                    this.mNoDataView.setVisibility(0);
                    this.mNoDataView.onChangeSkinType(this.mPageContext, TbadkCoreApplication.getInst().getSkinType());
                    return;
                }
                return;
            }
            if (this.mNoDataView != null) {
                this.mNoDataView.setVisibility(8);
            }
            this.eIa = false;
            this.bym.setData(arrayList2);
            this.bym.setVisibility(0);
        }
    }
}
