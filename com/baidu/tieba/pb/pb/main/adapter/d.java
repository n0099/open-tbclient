package com.baidu.tieba.pb.pb.main.adapter;

import com.baidu.adp.framework.MessageManager;
import com.baidu.adp.framework.listener.HttpMessageListener;
import com.baidu.adp.framework.message.HttpResponsedMessage;
import com.baidu.tieba.pb.data.PbFloorAgreeResponseMessage;
import com.baidu.tieba.pb.interactionpopupwindow.CustomDialogData;
/* loaded from: classes9.dex */
public class d {
    private final com.baidu.tieba.pb.videopb.b iQt;
    private final HttpMessageListener iQu = new HttpMessageListener(1001601, true) { // from class: com.baidu.tieba.pb.pb.main.adapter.d.1
        /* JADX DEBUG: Method merged with bridge method */
        @Override // com.baidu.adp.framework.listener.MessageListener
        public void onMessage(HttpResponsedMessage httpResponsedMessage) {
            d.this.a(httpResponsedMessage, 1001601);
        }
    };
    private final HttpMessageListener iQv = new HttpMessageListener(1001604) { // from class: com.baidu.tieba.pb.pb.main.adapter.d.2
        /* JADX DEBUG: Method merged with bridge method */
        @Override // com.baidu.adp.framework.listener.MessageListener
        public void onMessage(HttpResponsedMessage httpResponsedMessage) {
            d.this.a(httpResponsedMessage, 1001604);
        }
    };

    public d(com.baidu.tieba.pb.videopb.b bVar) {
        if (bVar == null) {
            throw new NullPointerException("PbActivity is NullPointerException");
        }
        this.iQt = bVar;
        cqE();
    }

    public void onDestroy() {
        cqD();
    }

    private boolean cqD() {
        MessageManager.getInstance().unRegisterListener(this.iQu);
        MessageManager.getInstance().unRegisterListener(this.iQv);
        return true;
    }

    public boolean cqE() {
        if (this.iQt != null) {
            this.iQt.registerListener(this.iQu);
            this.iQt.registerListener(this.iQv);
            return true;
        }
        return true;
    }

    /* JADX INFO: Access modifiers changed from: private */
    public void a(HttpResponsedMessage httpResponsedMessage, int i) {
        PbFloorAgreeResponseMessage pbFloorAgreeResponseMessage;
        if (httpResponsedMessage != null && httpResponsedMessage.getCmd() == i && (httpResponsedMessage instanceof PbFloorAgreeResponseMessage) && (pbFloorAgreeResponseMessage = (PbFloorAgreeResponseMessage) httpResponsedMessage) != null && !pbFloorAgreeResponseMessage.hasError() && this.iQt != null && pbFloorAgreeResponseMessage.getActivityDialogData() != null) {
            CustomDialogData activityDialogData = pbFloorAgreeResponseMessage.getActivityDialogData();
            activityDialogData.type = 0;
            com.baidu.tieba.pb.interactionpopupwindow.c.a(this.iQt.getPageContext(), activityDialogData).show();
        }
    }
}
