package com.baidu.tieba.pb.pb.main;

import android.text.TextUtils;
import com.baidu.adp.framework.MessageManager;
import com.baidu.adp.framework.listener.HttpMessageListener;
import com.baidu.adp.framework.message.HttpMessage;
import com.baidu.adp.framework.message.HttpResponsedMessage;
import com.baidu.tbadk.TbConfig;
import com.baidu.tbadk.core.frameworkData.CmdConfigHttp;
import com.baidu.tbadk.message.http.JsonHttpResponsedMessage;
import com.baidu.tbadk.task.TbHttpMessageTask;
import org.json.JSONObject;
/* loaded from: classes.dex */
public class PbFloorAgreeModel {
    private PbModel eue;
    private final HttpMessageListener eyf = new eg(this, CmdConfigHttp.CMD_PB_FLOOR_AGREE);
    private final HttpMessageListener eyg = new eh(this, CmdConfigHttp.CMD_CHANGE_FLOOR_AGREE);

    /* JADX INFO: Access modifiers changed from: package-private */
    /* loaded from: classes.dex */
    public interface a {
        void oK(int i);

        void oN(String str);
    }

    public PbFloorAgreeModel(PbModel pbModel) {
        this.eue = pbModel;
        DU();
        MessageManager.getInstance().registerListener(this.eyf);
        MessageManager.getInstance().registerListener(this.eyg);
    }

    private void DU() {
        TbHttpMessageTask tbHttpMessageTask = new TbHttpMessageTask(CmdConfigHttp.CMD_PB_FLOOR_AGREE, String.valueOf(TbConfig.SERVER_ADDRESS) + TbConfig.PB_FLOOR_AGREE_URL);
        tbHttpMessageTask.setResponsedClass(PbFloorAgreeResponseMessage.class);
        tbHttpMessageTask.setIsNeedTbs(true);
        MessageManager.getInstance().registerTask(tbHttpMessageTask);
        TbHttpMessageTask tbHttpMessageTask2 = new TbHttpMessageTask(CmdConfigHttp.CMD_CHANGE_FLOOR_AGREE, String.valueOf(TbConfig.SERVER_ADDRESS) + TbConfig.PB_CHANGE_FLOOR_AGREE_URL);
        tbHttpMessageTask2.setResponsedClass(JsonHttpResponsedMessage.class);
        tbHttpMessageTask2.setIsNeedTbs(true);
        MessageManager.getInstance().registerTask(tbHttpMessageTask2);
    }

    public void a(String str, int i, a aVar) {
        if (this.eue != null && this.eue.getPbData() != null) {
            a(str, i, 1, 2, "", aVar);
        }
    }

    public void a(String str, int i, int i2, int i3, String str2, a aVar) {
        if (this.eue != null && this.eue.getPbData() != null) {
            HttpMessage httpMessage = new HttpMessage(CmdConfigHttp.CMD_PB_FLOOR_AGREE);
            httpMessage.addParam("post_id", str);
            httpMessage.addParam("thread_id", this.eue.getPbData().getThreadId());
            httpMessage.addParam("op_type", i);
            httpMessage.addParam("obj_type", i2);
            httpMessage.addParam("agree_type", i3);
            httpMessage.addParam("forum_id", str2);
            httpMessage.setExtra(aVar);
            MessageManager.getInstance().sendMessage(httpMessage);
        }
    }

    public void a(String str, int i, int i2, String str2, a aVar) {
        if (this.eue != null && this.eue.getPbData() != null) {
            HttpMessage httpMessage = new HttpMessage(CmdConfigHttp.CMD_CHANGE_FLOOR_AGREE);
            httpMessage.addParam("thread_id", this.eue.getPbData().getThreadId());
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
                    aVar.oK(pbFloorAgreeResponseMessage.getScore());
                    if (TextUtils.isEmpty(pbFloorAgreeResponseMessage.getNickNameActivityMoney())) {
                        return;
                    }
                    aVar.oN(pbFloorAgreeResponseMessage.mNickNameActivityMoney);
                }
            }
        }
    }

    /* loaded from: classes.dex */
    public static class PbFloorAgreeResponseMessage extends JsonHttpResponsedMessage {
        private String mNickNameActivityMoney;
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
                this.mNickNameActivityMoney = com.baidu.tieba.pb.d.G(optJSONObject);
            }
        }

        public int getScore() {
            return this.mScore;
        }

        public String getNickNameActivityMoney() {
            return this.mNickNameActivityMoney;
        }
    }

    public boolean cancelLoadData() {
        MessageManager.getInstance().unRegisterListener(this.eyf);
        MessageManager.getInstance().unRegisterListener(this.eyg);
        return true;
    }
}
