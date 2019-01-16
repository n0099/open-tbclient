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
    private final PbActivity fYJ;
    private final HttpMessageListener giS = new HttpMessageListener(CmdConfigHttp.CMD_PB_FLOOR_AGREE, true) { // from class: com.baidu.tieba.pb.pb.main.a.b.1
        /* JADX DEBUG: Method merged with bridge method */
        @Override // com.baidu.adp.framework.listener.MessageListener
        public void onMessage(HttpResponsedMessage httpResponsedMessage) {
            b.this.a(httpResponsedMessage, CmdConfigHttp.CMD_PB_FLOOR_AGREE);
        }
    };
    private final HttpMessageListener giT = new HttpMessageListener(CmdConfigHttp.CMD_CHANGE_FLOOR_AGREE) { // from class: com.baidu.tieba.pb.pb.main.a.b.2
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
        this.fYJ = pbActivity;
        bno();
    }

    public void onDestroy() {
        bnn();
    }

    private boolean bnn() {
        MessageManager.getInstance().unRegisterListener(this.giS);
        MessageManager.getInstance().unRegisterListener(this.giT);
        return true;
    }

    public boolean bno() {
        if (this.fYJ != null) {
            this.fYJ.registerListener(this.giS);
            this.fYJ.registerListener(this.giT);
            return true;
        }
        return true;
    }

    /* JADX INFO: Access modifiers changed from: private */
    public void a(HttpResponsedMessage httpResponsedMessage, int i) {
        PbFloorAgreeResponseMessage pbFloorAgreeResponseMessage;
        if (httpResponsedMessage != null && httpResponsedMessage.getCmd() == i && (httpResponsedMessage instanceof PbFloorAgreeResponseMessage) && (pbFloorAgreeResponseMessage = (PbFloorAgreeResponseMessage) httpResponsedMessage) != null && !pbFloorAgreeResponseMessage.hasError()) {
            if (pbFloorAgreeResponseMessage.getContriInfo() != null && pbFloorAgreeResponseMessage.getContriInfo().isShowToast()) {
                if (this.fYJ != null) {
                    this.fYJ.a(pbFloorAgreeResponseMessage.getContriInfo());
                }
            } else if (pbFloorAgreeResponseMessage.getActivityDialogData() != null && this.fYJ != null && pbFloorAgreeResponseMessage.getActivityDialogData() != null) {
                CustomDialogData activityDialogData = pbFloorAgreeResponseMessage.getActivityDialogData();
                activityDialogData.type = 0;
                c.a(this.fYJ.getPageContext(), activityDialogData).show();
            }
        }
    }
}
