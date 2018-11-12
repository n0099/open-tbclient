package com.baidu.tieba.pb.pb.main.a;

import com.baidu.adp.framework.MessageManager;
import com.baidu.adp.framework.listener.HttpMessageListener;
import com.baidu.adp.framework.message.HttpResponsedMessage;
import com.baidu.tbadk.core.frameworkData.CmdConfigHttp;
import com.baidu.tieba.pb.data.PbFloorAgreeResponseMessage;
import com.baidu.tieba.pb.interactionpopupwindow.CustomDialogData;
import com.baidu.tieba.pb.interactionpopupwindow.c;
import com.baidu.tieba.pb.pb.main.PbActivity;
/* loaded from: classes6.dex */
public class b {
    private final PbActivity fOe;
    private final HttpMessageListener fYf = new HttpMessageListener(CmdConfigHttp.CMD_PB_FLOOR_AGREE, true) { // from class: com.baidu.tieba.pb.pb.main.a.b.1
        /* JADX DEBUG: Method merged with bridge method */
        @Override // com.baidu.adp.framework.listener.MessageListener
        public void onMessage(HttpResponsedMessage httpResponsedMessage) {
            b.this.a(httpResponsedMessage, CmdConfigHttp.CMD_PB_FLOOR_AGREE);
        }
    };
    private final HttpMessageListener fYg = new HttpMessageListener(CmdConfigHttp.CMD_CHANGE_FLOOR_AGREE) { // from class: com.baidu.tieba.pb.pb.main.a.b.2
        /* JADX DEBUG: Method merged with bridge method */
        @Override // com.baidu.adp.framework.listener.MessageListener
        public void onMessage(HttpResponsedMessage httpResponsedMessage) {
            b.this.a(httpResponsedMessage, CmdConfigHttp.CMD_CHANGE_FLOOR_AGREE);
        }
    };

    public b(PbActivity pbActivity) {
        if (pbActivity == null) {
            throw new NullPointerException("PbActivity is NullPointerException");
        }
        this.fOe = pbActivity;
        bkc();
    }

    public void onDestroy() {
        bkb();
    }

    private boolean bkb() {
        MessageManager.getInstance().unRegisterListener(this.fYf);
        MessageManager.getInstance().unRegisterListener(this.fYg);
        return true;
    }

    public boolean bkc() {
        if (this.fOe != null) {
            this.fOe.registerListener(this.fYf);
            this.fOe.registerListener(this.fYg);
            return true;
        }
        return true;
    }

    /* JADX INFO: Access modifiers changed from: private */
    public void a(HttpResponsedMessage httpResponsedMessage, int i) {
        PbFloorAgreeResponseMessage pbFloorAgreeResponseMessage;
        if (httpResponsedMessage != null && httpResponsedMessage.getCmd() == i && (httpResponsedMessage instanceof PbFloorAgreeResponseMessage) && (pbFloorAgreeResponseMessage = (PbFloorAgreeResponseMessage) httpResponsedMessage) != null && !pbFloorAgreeResponseMessage.hasError()) {
            if (pbFloorAgreeResponseMessage.getContriInfo() != null && pbFloorAgreeResponseMessage.getContriInfo().isShowToast()) {
                if (this.fOe != null) {
                    this.fOe.a(pbFloorAgreeResponseMessage.getContriInfo());
                }
            } else if (pbFloorAgreeResponseMessage.getActivityDialogData() != null && this.fOe != null && pbFloorAgreeResponseMessage.getActivityDialogData() != null) {
                CustomDialogData activityDialogData = pbFloorAgreeResponseMessage.getActivityDialogData();
                activityDialogData.type = 0;
                c.a(this.fOe.getPageContext(), activityDialogData).show();
            }
        }
    }
}
