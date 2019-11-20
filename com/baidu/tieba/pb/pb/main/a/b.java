package com.baidu.tieba.pb.pb.main.a;

import com.baidu.adp.framework.MessageManager;
import com.baidu.adp.framework.listener.HttpMessageListener;
import com.baidu.adp.framework.message.HttpResponsedMessage;
import com.baidu.tieba.pb.data.PbFloorAgreeResponseMessage;
import com.baidu.tieba.pb.interactionpopupwindow.CustomDialogData;
import com.baidu.tieba.pb.interactionpopupwindow.c;
import com.baidu.tieba.pb.pb.main.PbActivity;
/* loaded from: classes4.dex */
public class b {
    private final PbActivity hNh;
    private final HttpMessageListener hXn = new HttpMessageListener(1001601, true) { // from class: com.baidu.tieba.pb.pb.main.a.b.1
        /* JADX DEBUG: Method merged with bridge method */
        @Override // com.baidu.adp.framework.listener.MessageListener
        public void onMessage(HttpResponsedMessage httpResponsedMessage) {
            b.this.a(httpResponsedMessage, 1001601);
        }
    };
    private final HttpMessageListener hXo = new HttpMessageListener(1001604) { // from class: com.baidu.tieba.pb.pb.main.a.b.2
        /* JADX DEBUG: Method merged with bridge method */
        @Override // com.baidu.adp.framework.listener.MessageListener
        public void onMessage(HttpResponsedMessage httpResponsedMessage) {
            b.this.a(httpResponsedMessage, 1001604);
        }
    };

    public b(PbActivity pbActivity) {
        if (pbActivity == null) {
            throw new NullPointerException("PbActivity is NullPointerException");
        }
        this.hNh = pbActivity;
        bWt();
    }

    public void onDestroy() {
        bWs();
    }

    private boolean bWs() {
        MessageManager.getInstance().unRegisterListener(this.hXn);
        MessageManager.getInstance().unRegisterListener(this.hXo);
        return true;
    }

    public boolean bWt() {
        if (this.hNh != null) {
            this.hNh.registerListener(this.hXn);
            this.hNh.registerListener(this.hXo);
            return true;
        }
        return true;
    }

    /* JADX INFO: Access modifiers changed from: private */
    public void a(HttpResponsedMessage httpResponsedMessage, int i) {
        PbFloorAgreeResponseMessage pbFloorAgreeResponseMessage;
        if (httpResponsedMessage != null && httpResponsedMessage.getCmd() == i && (httpResponsedMessage instanceof PbFloorAgreeResponseMessage) && (pbFloorAgreeResponseMessage = (PbFloorAgreeResponseMessage) httpResponsedMessage) != null && !pbFloorAgreeResponseMessage.hasError() && this.hNh != null && pbFloorAgreeResponseMessage.getActivityDialogData() != null) {
            CustomDialogData activityDialogData = pbFloorAgreeResponseMessage.getActivityDialogData();
            activityDialogData.type = 0;
            c.a(this.hNh.getPageContext(), activityDialogData).show();
        }
    }
}
