package com.baidu.tieba.imMessageCenter.mention;

import com.baidu.adp.widget.ListView.BdListView;
import com.baidu.tieba.imMessageCenter.im.chat.notify.MessageAggregationListAdapter;
import com.baidu.tieba.imMessageCenter.im.model.ImMessageCenterModel;
/* JADX INFO: Access modifiers changed from: package-private */
/* loaded from: classes.dex */
public class ab implements com.baidu.tieba.im.chat.a.a {
    final /* synthetic */ o dcz;

    /* JADX INFO: Access modifiers changed from: package-private */
    public ab(o oVar) {
        this.dcz = oVar;
    }

    @Override // com.baidu.tieba.im.chat.a.a
    public void onComplete() {
        BdListView bdListView;
        ImMessageCenterModel imMessageCenterModel;
        BdListView bdListView2;
        ImMessageCenterModel imMessageCenterModel2;
        boolean isLogin;
        MessageAggregationListAdapter messageAggregationListAdapter;
        ImMessageCenterModel imMessageCenterModel3;
        bdListView = this.dcz.cZz;
        if (bdListView != null) {
            imMessageCenterModel = this.dcz.cZw;
            if (imMessageCenterModel != null) {
                bdListView2 = this.dcz.cZz;
                bdListView2.l(2000L);
                imMessageCenterModel2 = this.dcz.cZw;
                if (imMessageCenterModel2.getData() != null) {
                    messageAggregationListAdapter = this.dcz.dcr;
                    imMessageCenterModel3 = this.dcz.cZw;
                    messageAggregationListAdapter.setData(imMessageCenterModel3.getData());
                    return;
                }
                o oVar = this.dcz;
                isLogin = this.dcz.isLogin();
                oVar.u(isLogin, true);
            }
        }
    }
}
