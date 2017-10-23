package com.baidu.tieba.pb.pb.main;

import com.baidu.adp.framework.MessageManager;
import com.baidu.adp.framework.listener.HttpMessageListener;
import com.baidu.adp.framework.message.HttpMessage;
import com.baidu.adp.framework.message.HttpResponsedMessage;
import com.baidu.tbadk.TbConfig;
import com.baidu.tbadk.core.frameworkData.CmdConfigHttp;
import com.baidu.tbadk.message.http.JsonHttpResponsedMessage;
import com.baidu.tbadk.task.TbHttpMessageTask;
import com.baidu.tieba.pb.CustomDialogData;
import org.json.JSONObject;
/* loaded from: classes.dex */
public class PbFloorAgreeModel {
    private PbModel eBC;
    private final HttpMessageListener eEV = new HttpMessageListener(CmdConfigHttp.CMD_PB_FLOOR_AGREE) { // from class: com.baidu.tieba.pb.pb.main.PbFloorAgreeModel.1
        /* JADX DEBUG: Method merged with bridge method */
        @Override // com.baidu.adp.framework.listener.MessageListener
        public void onMessage(HttpResponsedMessage httpResponsedMessage) {
            PbFloorAgreeModel.this.a(httpResponsedMessage, CmdConfigHttp.CMD_PB_FLOOR_AGREE);
        }
    };
    private final HttpMessageListener eEW = new HttpMessageListener(CmdConfigHttp.CMD_CHANGE_FLOOR_AGREE) { // from class: com.baidu.tieba.pb.pb.main.PbFloorAgreeModel.2
        /* JADX DEBUG: Method merged with bridge method */
        @Override // com.baidu.adp.framework.listener.MessageListener
        public void onMessage(HttpResponsedMessage httpResponsedMessage) {
            PbFloorAgreeModel.this.a(httpResponsedMessage, CmdConfigHttp.CMD_CHANGE_FLOOR_AGREE);
        }
    };

    /* JADX INFO: Access modifiers changed from: package-private */
    /* loaded from: classes.dex */
    public interface a {
        void a(CustomDialogData customDialogData);

        void pe(int i);
    }

    public PbFloorAgreeModel(PbModel pbModel) {
        this.eBC = pbModel;
        DJ();
        MessageManager.getInstance().registerListener(this.eEV);
        MessageManager.getInstance().registerListener(this.eEW);
    }

    private void DJ() {
        TbHttpMessageTask tbHttpMessageTask = new TbHttpMessageTask(CmdConfigHttp.CMD_PB_FLOOR_AGREE, TbConfig.SERVER_ADDRESS + TbConfig.PB_FLOOR_AGREE_URL);
        tbHttpMessageTask.setResponsedClass(PbFloorAgreeResponseMessage.class);
        tbHttpMessageTask.setIsNeedTbs(true);
        MessageManager.getInstance().registerTask(tbHttpMessageTask);
        TbHttpMessageTask tbHttpMessageTask2 = new TbHttpMessageTask(CmdConfigHttp.CMD_CHANGE_FLOOR_AGREE, TbConfig.SERVER_ADDRESS + TbConfig.PB_CHANGE_FLOOR_AGREE_URL);
        tbHttpMessageTask2.setResponsedClass(JsonHttpResponsedMessage.class);
        tbHttpMessageTask2.setIsNeedTbs(true);
        MessageManager.getInstance().registerTask(tbHttpMessageTask2);
    }

    public void a(String str, int i, a aVar) {
        if (this.eBC != null && this.eBC.getPbData() != null) {
            a(str, i, 1, 2, "", aVar);
        }
    }

    public void a(String str, int i, int i2, int i3, String str2, a aVar) {
        if (this.eBC != null && this.eBC.getPbData() != null) {
            HttpMessage httpMessage = new HttpMessage(CmdConfigHttp.CMD_PB_FLOOR_AGREE);
            httpMessage.addParam("post_id", str);
            httpMessage.addParam("thread_id", this.eBC.getPbData().getThreadId());
            httpMessage.addParam("op_type", i);
            httpMessage.addParam("obj_type", i2);
            httpMessage.addParam("agree_type", i3);
            httpMessage.addParam("forum_id", str2);
            httpMessage.setExtra(aVar);
            MessageManager.getInstance().sendMessage(httpMessage);
        }
    }

    public void a(String str, int i, int i2, String str2, a aVar) {
        if (this.eBC != null && this.eBC.getPbData() != null) {
            HttpMessage httpMessage = new HttpMessage(CmdConfigHttp.CMD_CHANGE_FLOOR_AGREE);
            httpMessage.addParam("thread_id", this.eBC.getPbData().getThreadId());
            httpMessage.addParam("post_id", str);
            httpMessage.addParam("obj_type", i);
            httpMessage.addParam("agree_type", i2);
            httpMessage.addParam("forum_id", str2);
            httpMessage.setExtra(aVar);
            MessageManager.getInstance().sendMessage(httpMessage);
        }
    }

    /* JADX INFO: Access modifiers changed from: private */
    public void a(HttpResponsedMessage httpResponsedMessage, int i) {
        a aVar;
        Object extra;
        if (httpResponsedMessage != null && httpResponsedMessage.getCmd() == i && (httpResponsedMessage instanceof PbFloorAgreeResponseMessage)) {
            if (httpResponsedMessage.getOrginalMessage() == null || (extra = httpResponsedMessage.getOrginalMessage().getExtra()) == null || !(extra instanceof a)) {
                aVar = null;
            } else {
                aVar = (a) extra;
            }
            if (aVar != null) {
                PbFloorAgreeResponseMessage pbFloorAgreeResponseMessage = (PbFloorAgreeResponseMessage) httpResponsedMessage;
                if (!pbFloorAgreeResponseMessage.hasError()) {
                    aVar.pe(pbFloorAgreeResponseMessage.getScore());
                    if (pbFloorAgreeResponseMessage.getActivityDialogData() == null) {
                        return;
                    }
                    aVar.a(pbFloorAgreeResponseMessage.mActDialogData);
                }
            }
        }
    }

    /* loaded from: classes.dex */
    public static class PbFloorAgreeResponseMessage extends JsonHttpResponsedMessage {
        private CustomDialogData mActDialogData;
        private int mScore;

        public PbFloorAgreeResponseMessage(int i) {
            super(i);
        }

        @Override // com.baidu.tbadk.message.http.JsonHttpResponsedMessage
        public void decodeLogicInBackGround(int i, JSONObject jSONObject) throws Exception {
            JSONObject optJSONObject;
            super.decodeLogicInBackGround(i, jSONObject);
            int statusCode = getStatusCode();
            int error = getError();
            if (statusCode == 200 && error >= 0 && jSONObject != null && jSONObject != null && (optJSONObject = jSONObject.optJSONObject("data")) != null) {
                JSONObject optJSONObject2 = optJSONObject.optJSONObject("agree");
                if (optJSONObject2 != null) {
                    this.mScore = optJSONObject2.optInt("score");
                }
                this.mActDialogData = com.baidu.tieba.pb.b.H(optJSONObject);
            }
        }

        public int getScore() {
            return this.mScore;
        }

        public CustomDialogData getActivityDialogData() {
            return this.mActDialogData;
        }
    }

    public boolean cancelLoadData() {
        MessageManager.getInstance().unRegisterListener(this.eEV);
        MessageManager.getInstance().unRegisterListener(this.eEW);
        return true;
    }
}
