package com.baidu.tieba.pb.pb.main.adapter;

import com.baidu.adp.framework.MessageManager;
import com.baidu.adp.framework.listener.HttpMessageListener;
import com.baidu.adp.framework.message.HttpResponsedMessage;
import com.baidu.tieba.pb.data.PbFloorAgreeResponseMessage;
import com.baidu.tieba.pb.interactionpopupwindow.CustomDialogData;
/* loaded from: classes6.dex */
public class d {
    private final com.baidu.tieba.pb.videopb.b iLu;
    private final HttpMessageListener iLv = new HttpMessageListener(1001601, true) { // from class: com.baidu.tieba.pb.pb.main.adapter.d.1
        /* JADX DEBUG: Method merged with bridge method */
        @Override // com.baidu.adp.framework.listener.MessageListener
        public void onMessage(HttpResponsedMessage httpResponsedMessage) {
            d.this.a(httpResponsedMessage, 1001601);
        }
    };
    private final HttpMessageListener iLw = new HttpMessageListener(1001604) { // from class: com.baidu.tieba.pb.pb.main.adapter.d.2
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
        this.iLu = bVar;
        cof();
    }

    public void onDestroy() {
        coe();
    }

    private boolean coe() {
        MessageManager.getInstance().unRegisterListener(this.iLv);
        MessageManager.getInstance().unRegisterListener(this.iLw);
        return true;
    }

    public boolean cof() {
        if (this.iLu != null) {
            this.iLu.registerListener(this.iLv);
            this.iLu.registerListener(this.iLw);
            return true;
        }
        return true;
    }

    /* JADX INFO: Access modifiers changed from: private */
    public void a(HttpResponsedMessage httpResponsedMessage, int i) {
        PbFloorAgreeResponseMessage pbFloorAgreeResponseMessage;
        if (httpResponsedMessage != null && httpResponsedMessage.getCmd() == i && (httpResponsedMessage instanceof PbFloorAgreeResponseMessage) && (pbFloorAgreeResponseMessage = (PbFloorAgreeResponseMessage) httpResponsedMessage) != null && !pbFloorAgreeResponseMessage.hasError() && this.iLu != null && pbFloorAgreeResponseMessage.getActivityDialogData() != null) {
            CustomDialogData activityDialogData = pbFloorAgreeResponseMessage.getActivityDialogData();
            activityDialogData.type = 0;
            com.baidu.tieba.pb.interactionpopupwindow.c.a(this.iLu.getPageContext(), activityDialogData).show();
        }
    }
}
