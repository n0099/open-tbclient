package com.baidu.tieba.pb.pb.main.adapter;

import com.baidu.adp.framework.MessageManager;
import com.baidu.adp.framework.listener.HttpMessageListener;
import com.baidu.adp.framework.message.HttpResponsedMessage;
import com.baidu.tieba.pb.data.PbFloorAgreeResponseMessage;
import com.baidu.tieba.pb.interactionpopupwindow.CustomDialogData;
/* loaded from: classes9.dex */
public class d {
    private final com.baidu.tieba.pb.videopb.b iSi;
    private final HttpMessageListener iSj = new HttpMessageListener(1001601, true) { // from class: com.baidu.tieba.pb.pb.main.adapter.d.1
        /* JADX DEBUG: Method merged with bridge method */
        @Override // com.baidu.adp.framework.listener.MessageListener
        public void onMessage(HttpResponsedMessage httpResponsedMessage) {
            d.this.a(httpResponsedMessage, 1001601);
        }
    };
    private final HttpMessageListener iSk = new HttpMessageListener(1001604) { // from class: com.baidu.tieba.pb.pb.main.adapter.d.2
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
        this.iSi = bVar;
        crc();
    }

    public void onDestroy() {
        crb();
    }

    private boolean crb() {
        MessageManager.getInstance().unRegisterListener(this.iSj);
        MessageManager.getInstance().unRegisterListener(this.iSk);
        return true;
    }

    public boolean crc() {
        if (this.iSi != null) {
            this.iSi.registerListener(this.iSj);
            this.iSi.registerListener(this.iSk);
            return true;
        }
        return true;
    }

    /* JADX INFO: Access modifiers changed from: private */
    public void a(HttpResponsedMessage httpResponsedMessage, int i) {
        PbFloorAgreeResponseMessage pbFloorAgreeResponseMessage;
        if (httpResponsedMessage != null && httpResponsedMessage.getCmd() == i && (httpResponsedMessage instanceof PbFloorAgreeResponseMessage) && (pbFloorAgreeResponseMessage = (PbFloorAgreeResponseMessage) httpResponsedMessage) != null && !pbFloorAgreeResponseMessage.hasError() && this.iSi != null && pbFloorAgreeResponseMessage.getActivityDialogData() != null) {
            CustomDialogData activityDialogData = pbFloorAgreeResponseMessage.getActivityDialogData();
            activityDialogData.type = 0;
            com.baidu.tieba.pb.interactionpopupwindow.c.a(this.iSi.getPageContext(), activityDialogData).show();
        }
    }
}
