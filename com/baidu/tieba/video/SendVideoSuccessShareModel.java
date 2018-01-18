package com.baidu.tieba.video;

import com.baidu.adp.BdUniqueId;
import com.baidu.adp.base.BdBaseModel;
import com.baidu.adp.framework.MessageManager;
import com.baidu.adp.framework.listener.HttpMessageListener;
import com.baidu.adp.framework.message.HttpMessage;
import com.baidu.adp.framework.message.HttpResponsedMessage;
import com.baidu.tbadk.TbConfig;
import com.baidu.tbadk.core.data.OriginalThreadInfo;
import com.baidu.tbadk.core.frameworkData.CmdConfigHttp;
import com.baidu.tbadk.message.http.JsonHttpResponsedMessage;
import com.baidu.tbadk.task.TbHttpMessageTask;
import org.json.JSONObject;
/* loaded from: classes.dex */
public class SendVideoSuccessShareModel extends BdBaseModel {
    private HttpMessageListener bhv = new HttpMessageListener(CmdConfigHttp.CMD_GET_VIDEO_INFO_BY_LOGVID) { // from class: com.baidu.tieba.video.SendVideoSuccessShareModel.1
        /* JADX DEBUG: Method merged with bridge method */
        @Override // com.baidu.adp.framework.listener.MessageListener
        public void onMessage(HttpResponsedMessage httpResponsedMessage) {
            if (httpResponsedMessage != null && httpResponsedMessage.getCmd() == 1003384 && (httpResponsedMessage instanceof SendVideoSuccessShareOriginalThreadInfoResponse) && ((SendVideoSuccessShareOriginalThreadInfoResponse) httpResponsedMessage).threadInfo != null && SendVideoSuccessShareModel.this.mLoadDataCallBack != null) {
                SendVideoSuccessShareModel.this.mLoadDataCallBack.ak(((SendVideoSuccessShareOriginalThreadInfoResponse) httpResponsedMessage).getThreadInfo());
            }
        }
    };

    public SendVideoSuccessShareModel() {
        setUniqueId(BdUniqueId.gen());
        Hd();
        this.bhv.setTag(getUniqueId());
        this.bhv.setSelfListener(true);
        registerListener(this.bhv);
    }

    private void Hd() {
        TbHttpMessageTask tbHttpMessageTask = new TbHttpMessageTask(CmdConfigHttp.CMD_GET_VIDEO_INFO_BY_LOGVID, TbConfig.SERVER_ADDRESS + TbConfig.URL_GET_VIDEO_INFO_BY_VLOGID);
        tbHttpMessageTask.setResponsedClass(SendVideoSuccessShareOriginalThreadInfoResponse.class);
        MessageManager.getInstance().registerTask(tbHttpMessageTask);
    }

    @Override // com.baidu.adp.base.BdBaseModel
    protected boolean LoadData() {
        return false;
    }

    @Override // com.baidu.adp.base.BdBaseModel
    public boolean cancelLoadData() {
        MessageManager.getInstance().unRegisterListener(this.bhv);
        return false;
    }

    public void tp(String str) {
        HttpMessage httpMessage = new HttpMessage(CmdConfigHttp.CMD_GET_VIDEO_INFO_BY_LOGVID);
        httpMessage.addParam("video_id", str);
        sendMessage(httpMessage);
    }

    /* loaded from: classes.dex */
    public static class SendVideoSuccessShareOriginalThreadInfoResponse extends JsonHttpResponsedMessage {
        private OriginalThreadInfo threadInfo;

        public SendVideoSuccessShareOriginalThreadInfoResponse(int i) {
            super(i);
        }

        @Override // com.baidu.tbadk.message.http.JsonHttpResponsedMessage
        public void decodeLogicInBackGround(int i, JSONObject jSONObject) throws Exception {
            super.decodeLogicInBackGround(i, jSONObject);
            int statusCode = getStatusCode();
            int error = getError();
            if (statusCode == 200 && error >= 0 && jSONObject != null) {
                this.threadInfo = new OriginalThreadInfo();
                String optString = jSONObject.optString("title");
                String optString2 = jSONObject.optString("cover");
                String optString3 = jSONObject.optString("video_id");
                this.threadInfo.showPicUrl = optString2;
                this.threadInfo.showType = 3;
                this.threadInfo.showText = optString;
                this.threadInfo.videoId = optString3;
            }
        }

        public OriginalThreadInfo getThreadInfo() {
            return this.threadInfo;
        }
    }
}
