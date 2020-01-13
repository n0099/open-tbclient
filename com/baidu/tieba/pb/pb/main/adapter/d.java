package com.baidu.tieba.pb.pb.main.adapter;

import com.baidu.adp.framework.MessageManager;
import com.baidu.adp.framework.listener.HttpMessageListener;
import com.baidu.adp.framework.message.HttpResponsedMessage;
import com.baidu.tieba.pb.data.PbFloorAgreeResponseMessage;
import com.baidu.tieba.pb.interactionpopupwindow.CustomDialogData;
/* loaded from: classes7.dex */
public class d {
    private final com.baidu.tieba.pb.videopb.b iOY;
    private final HttpMessageListener iOZ = new HttpMessageListener(1001601, true) { // from class: com.baidu.tieba.pb.pb.main.adapter.d.1
        /* JADX DEBUG: Method merged with bridge method */
        @Override // com.baidu.adp.framework.listener.MessageListener
        public void onMessage(HttpResponsedMessage httpResponsedMessage) {
            d.this.a(httpResponsedMessage, 1001601);
        }
    };
    private final HttpMessageListener iPa = new HttpMessageListener(1001604) { // from class: com.baidu.tieba.pb.pb.main.adapter.d.2
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
        this.iOY = bVar;
        cpm();
    }

    public void onDestroy() {
        cpl();
    }

    private boolean cpl() {
        MessageManager.getInstance().unRegisterListener(this.iOZ);
        MessageManager.getInstance().unRegisterListener(this.iPa);
        return true;
    }

    public boolean cpm() {
        if (this.iOY != null) {
            this.iOY.registerListener(this.iOZ);
            this.iOY.registerListener(this.iPa);
            return true;
        }
        return true;
    }

    /* JADX INFO: Access modifiers changed from: private */
    public void a(HttpResponsedMessage httpResponsedMessage, int i) {
        PbFloorAgreeResponseMessage pbFloorAgreeResponseMessage;
        if (httpResponsedMessage != null && httpResponsedMessage.getCmd() == i && (httpResponsedMessage instanceof PbFloorAgreeResponseMessage) && (pbFloorAgreeResponseMessage = (PbFloorAgreeResponseMessage) httpResponsedMessage) != null && !pbFloorAgreeResponseMessage.hasError() && this.iOY != null && pbFloorAgreeResponseMessage.getActivityDialogData() != null) {
            CustomDialogData activityDialogData = pbFloorAgreeResponseMessage.getActivityDialogData();
            activityDialogData.type = 0;
            com.baidu.tieba.pb.interactionpopupwindow.c.a(this.iOY.getPageContext(), activityDialogData).show();
        }
    }
}
