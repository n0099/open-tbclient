package com.baidu.tieba.video.cloudmusic.model;

import com.baidu.adp.base.BdBaseModel;
import com.baidu.adp.base.f;
import com.baidu.adp.framework.MessageManager;
import com.baidu.adp.framework.listener.HttpMessageListener;
import com.baidu.adp.framework.message.HttpMessage;
import com.baidu.adp.framework.message.HttpResponsedMessage;
import com.baidu.adp.lib.OrmObject.toolsystem.orm.object.OrmObject;
import com.baidu.live.tbadk.data.Config;
import com.baidu.tbadk.TbConfig;
import com.baidu.tbadk.message.http.JsonHttpResponsedMessage;
import com.baidu.tbadk.task.TbHttpMessageTask;
import com.baidu.tieba.video.cloudmusic.data.CloudMusicData;
import org.json.JSONObject;
/* loaded from: classes7.dex */
public class CloudMusicModel extends BdBaseModel {
    private a<CloudMusicData> nOe;
    private final HttpMessageListener nOh;

    public CloudMusicModel(f fVar) {
        super(fVar);
        this.nOh = new HttpMessageListener(1003371) { // from class: com.baidu.tieba.video.cloudmusic.model.CloudMusicModel.1
            /* JADX DEBUG: Method merged with bridge method */
            @Override // com.baidu.adp.framework.listener.MessageListener
            public void onMessage(HttpResponsedMessage httpResponsedMessage) {
                if (httpResponsedMessage != null && httpResponsedMessage.getCmd() == 1003371 && (httpResponsedMessage instanceof VideoCloudMusicWithTagResponseMessage) && CloudMusicModel.this.nOe != null) {
                    CloudMusicModel.this.nOe.aV(((VideoCloudMusicWithTagResponseMessage) httpResponsedMessage).mCloudMusicData);
                }
            }
        };
        dSE();
        this.nOh.setTag(getUniqueId());
        this.nOh.setSelfListener(true);
        registerListener(this.nOh);
    }

    private void dSE() {
        TbHttpMessageTask tbHttpMessageTask = new TbHttpMessageTask(1003371, TbConfig.SERVER_ADDRESS + Config.VIDEO_CLOUD_MUSIC_LIST_WITH_TAGS);
        tbHttpMessageTask.setResponsedClass(VideoCloudMusicWithTagResponseMessage.class);
        MessageManager.getInstance().registerTask(tbHttpMessageTask);
    }

    /* loaded from: classes7.dex */
    public static class VideoCloudMusicWithTagResponseMessage extends JsonHttpResponsedMessage {
        public CloudMusicData mCloudMusicData;

        public VideoCloudMusicWithTagResponseMessage(int i) {
            super(i);
        }

        @Override // com.baidu.tbadk.message.http.JsonHttpResponsedMessage
        public void decodeLogicInBackGround(int i, JSONObject jSONObject) throws Exception {
            int statusCode = getStatusCode();
            int error = getError();
            if (statusCode == 200 && error == 0 && jSONObject != null) {
                this.mCloudMusicData = (CloudMusicData) OrmObject.objectWithJson(jSONObject.optJSONObject("data"), CloudMusicData.class);
            }
        }
    }

    public void a(a<CloudMusicData> aVar) {
        if (aVar != null) {
            sendMessage(new HttpMessage(1003371));
            this.nOe = aVar;
        }
    }

    @Override // com.baidu.adp.base.BdBaseModel
    protected boolean LoadData() {
        return false;
    }

    @Override // com.baidu.adp.base.BdBaseModel
    public boolean cancelLoadData() {
        MessageManager.getInstance().unRegisterTask(1003371);
        return false;
    }
}
