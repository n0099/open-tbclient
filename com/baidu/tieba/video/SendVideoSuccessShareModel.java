package com.baidu.tieba.video;

import com.baidu.adp.BdUniqueId;
import com.baidu.adp.base.BdBaseModel;
import com.baidu.adp.framework.MessageManager;
import com.baidu.adp.framework.listener.HttpMessageListener;
import com.baidu.adp.framework.message.HttpMessage;
import com.baidu.adp.framework.message.HttpResponsedMessage;
import com.baidu.tbadk.TbConfig;
import com.baidu.tbadk.core.atomData.AlaLiveRoomActivityConfig;
import com.baidu.tbadk.core.data.OriginalThreadInfo;
import com.baidu.tbadk.core.frameworkData.CmdConfigHttp;
import com.baidu.tbadk.message.http.JsonHttpResponsedMessage;
import com.baidu.tbadk.task.TbHttpMessageTask;
import org.json.JSONObject;
/* loaded from: classes5.dex */
public class SendVideoSuccessShareModel extends BdBaseModel {

    /* renamed from: e  reason: collision with root package name */
    public HttpMessageListener f21251e = new a(CmdConfigHttp.CMD_GET_VIDEO_INFO_BY_LOGVID);

    /* loaded from: classes5.dex */
    public static class SendVideoSuccessShareOriginalThreadInfoResponse extends JsonHttpResponsedMessage {
        public OriginalThreadInfo threadInfo;

        public SendVideoSuccessShareOriginalThreadInfoResponse(int i2) {
            super(i2);
        }

        @Override // com.baidu.tbadk.message.http.JsonHttpResponsedMessage
        public void decodeLogicInBackGround(int i2, JSONObject jSONObject) throws Exception {
            super.decodeLogicInBackGround(i2, jSONObject);
            int statusCode = getStatusCode();
            int error = getError();
            if (statusCode != 200 || error < 0 || jSONObject == null) {
                return;
            }
            this.threadInfo = new OriginalThreadInfo();
            String optString = jSONObject.optString("title");
            String optString2 = jSONObject.optString(AlaLiveRoomActivityConfig.SDK_LIVE_COVER_KEY);
            String optString3 = jSONObject.optString("video_id");
            OriginalThreadInfo originalThreadInfo = this.threadInfo;
            originalThreadInfo.f12134c = optString2;
            originalThreadInfo.f12132a = 3;
            originalThreadInfo.f12133b = optString;
            originalThreadInfo.l = optString3;
        }

        public OriginalThreadInfo getThreadInfo() {
            return this.threadInfo;
        }
    }

    /* loaded from: classes5.dex */
    public class a extends HttpMessageListener {
        public a(int i2) {
            super(i2);
        }

        /* JADX DEBUG: Method merged with bridge method */
        @Override // com.baidu.adp.framework.listener.MessageListener
        public void onMessage(HttpResponsedMessage httpResponsedMessage) {
            if (httpResponsedMessage != null && httpResponsedMessage.getCmd() == 1003384 && (httpResponsedMessage instanceof SendVideoSuccessShareOriginalThreadInfoResponse)) {
                SendVideoSuccessShareOriginalThreadInfoResponse sendVideoSuccessShareOriginalThreadInfoResponse = (SendVideoSuccessShareOriginalThreadInfoResponse) httpResponsedMessage;
                if (sendVideoSuccessShareOriginalThreadInfoResponse.threadInfo == null || SendVideoSuccessShareModel.this.mLoadDataCallBack == null) {
                    return;
                }
                SendVideoSuccessShareModel.this.mLoadDataCallBack.c(sendVideoSuccessShareOriginalThreadInfoResponse.getThreadInfo());
            }
        }
    }

    public SendVideoSuccessShareModel() {
        setUniqueId(BdUniqueId.gen());
        registerTask();
        this.f21251e.setTag(getUniqueId());
        this.f21251e.setSelfListener(true);
        registerListener(this.f21251e);
    }

    @Override // com.baidu.adp.base.BdBaseModel
    public boolean LoadData() {
        return false;
    }

    @Override // com.baidu.adp.base.BdBaseModel
    public boolean cancelLoadData() {
        MessageManager.getInstance().unRegisterListener(this.f21251e);
        return false;
    }

    public final void registerTask() {
        TbHttpMessageTask tbHttpMessageTask = new TbHttpMessageTask(CmdConfigHttp.CMD_GET_VIDEO_INFO_BY_LOGVID, TbConfig.SERVER_ADDRESS + TbConfig.URL_GET_VIDEO_INFO_BY_VLOGID);
        tbHttpMessageTask.setResponsedClass(SendVideoSuccessShareOriginalThreadInfoResponse.class);
        MessageManager.getInstance().registerTask(tbHttpMessageTask);
    }

    public void u(String str) {
        HttpMessage httpMessage = new HttpMessage(CmdConfigHttp.CMD_GET_VIDEO_INFO_BY_LOGVID);
        httpMessage.addParam("video_id", str);
        sendMessage(httpMessage);
    }
}
