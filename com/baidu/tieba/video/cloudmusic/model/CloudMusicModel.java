package com.baidu.tieba.video.cloudmusic.model;

import com.baidu.adp.base.BdBaseModel;
import com.baidu.adp.base.e;
import com.baidu.adp.framework.MessageManager;
import com.baidu.adp.framework.listener.HttpMessageListener;
import com.baidu.adp.framework.message.HttpMessage;
import com.baidu.adp.framework.message.HttpResponsedMessage;
import com.baidu.adp.lib.OrmObject.toolsystem.orm.object.OrmObject;
import com.baidu.tbadk.TbConfig;
import com.baidu.tbadk.core.frameworkData.CmdConfigHttp;
import com.baidu.tbadk.message.http.JsonHttpResponsedMessage;
import com.baidu.tbadk.task.TbHttpMessageTask;
import com.baidu.tieba.video.cloudmusic.data.CloudMusicData;
import org.json.JSONObject;
/* loaded from: classes2.dex */
public class CloudMusicModel extends BdBaseModel {
    private a<CloudMusicData> gXD;
    private final HttpMessageListener gXG;

    public CloudMusicModel(e eVar) {
        super(eVar);
        this.gXG = new HttpMessageListener(CmdConfigHttp.CMD_VIDEO_CLOUD_MUSIC_WITH_TAGS) { // from class: com.baidu.tieba.video.cloudmusic.model.CloudMusicModel.1
            /* JADX DEBUG: Method merged with bridge method */
            @Override // com.baidu.adp.framework.listener.MessageListener
            public void onMessage(HttpResponsedMessage httpResponsedMessage) {
                if (httpResponsedMessage != null && httpResponsedMessage.getCmd() == 1003371 && (httpResponsedMessage instanceof VideoCloudMusicWithTagResponseMessage) && CloudMusicModel.this.gXD != null) {
                    CloudMusicModel.this.gXD.ae(((VideoCloudMusicWithTagResponseMessage) httpResponsedMessage).mCloudMusicData);
                }
            }
        };
        bBo();
        this.gXG.setTag(getUniqueId());
        this.gXG.setSelfListener(true);
        registerListener(this.gXG);
    }

    private void bBo() {
        TbHttpMessageTask tbHttpMessageTask = new TbHttpMessageTask(CmdConfigHttp.CMD_VIDEO_CLOUD_MUSIC_WITH_TAGS, TbConfig.SERVER_ADDRESS + "c/f/video/getMusicList");
        tbHttpMessageTask.setResponsedClass(VideoCloudMusicWithTagResponseMessage.class);
        MessageManager.getInstance().registerTask(tbHttpMessageTask);
    }

    /* loaded from: classes2.dex */
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
            sendMessage(new HttpMessage(CmdConfigHttp.CMD_VIDEO_CLOUD_MUSIC_WITH_TAGS));
            this.gXD = aVar;
        }
    }

    @Override // com.baidu.adp.base.BdBaseModel
    protected boolean LoadData() {
        return false;
    }

    @Override // com.baidu.adp.base.BdBaseModel
    public boolean cancelLoadData() {
        MessageManager.getInstance().unRegisterTask(CmdConfigHttp.CMD_VIDEO_CLOUD_MUSIC_WITH_TAGS);
        return false;
    }
}
