package com.baidu.tieba.video.cloudmusic.model;

import com.baidu.adp.base.BdBaseModel;
import com.baidu.adp.base.e;
import com.baidu.adp.framework.MessageManager;
import com.baidu.adp.framework.listener.HttpMessageListener;
import com.baidu.adp.framework.message.HttpMessage;
import com.baidu.adp.framework.message.HttpResponsedMessage;
import com.baidu.adp.lib.OrmObject.toolsystem.orm.object.OrmObject;
import com.baidu.tbadk.TbConfig;
import com.baidu.tbadk.core.atomData.LegoListActivityConfig;
import com.baidu.tbadk.core.frameworkData.CmdConfigHttp;
import com.baidu.tbadk.message.http.JsonHttpResponsedMessage;
import com.baidu.tbadk.task.TbHttpMessageTask;
import com.baidu.tieba.video.cloudmusic.data.CloudMusicData;
import org.json.JSONObject;
/* loaded from: classes2.dex */
public class CloudMusicListModel extends BdBaseModel {
    private a<CloudMusicData.MusicTagList> gQS;
    private final HttpMessageListener gQT;
    private int pn;

    static /* synthetic */ int b(CloudMusicListModel cloudMusicListModel) {
        int i = cloudMusicListModel.pn;
        cloudMusicListModel.pn = i - 1;
        return i;
    }

    public CloudMusicListModel(e eVar) {
        super(eVar);
        this.pn = 1;
        this.gQT = new HttpMessageListener(CmdConfigHttp.CMD_VIDEO_CLOUD_MUSIC_LIST) { // from class: com.baidu.tieba.video.cloudmusic.model.CloudMusicListModel.1
            /* JADX DEBUG: Method merged with bridge method */
            @Override // com.baidu.adp.framework.listener.MessageListener
            public void onMessage(HttpResponsedMessage httpResponsedMessage) {
                if (httpResponsedMessage != null && httpResponsedMessage.getCmd() == 1003367 && (httpResponsedMessage instanceof VideoCloudMusicListResponseMessage) && CloudMusicListModel.this.gQS != null) {
                    if (httpResponsedMessage.hasError() && httpResponsedMessage.getError() != 0) {
                        CloudMusicListModel.b(CloudMusicListModel.this);
                    }
                    CloudMusicListModel.this.gQS.ad(((VideoCloudMusicListResponseMessage) httpResponsedMessage).mCloudMusicWithTagData);
                }
            }
        };
        bBu();
        this.gQT.setTag(getUniqueId());
        this.gQT.setSelfListener(true);
        registerListener(this.gQT);
    }

    private void bBu() {
        TbHttpMessageTask tbHttpMessageTask = new TbHttpMessageTask(CmdConfigHttp.CMD_VIDEO_CLOUD_MUSIC_LIST, TbConfig.SERVER_ADDRESS + "c/f/video/getMusicTagList");
        tbHttpMessageTask.setResponsedClass(VideoCloudMusicListResponseMessage.class);
        MessageManager.getInstance().registerTask(tbHttpMessageTask);
    }

    /* loaded from: classes2.dex */
    public static class VideoCloudMusicListResponseMessage extends JsonHttpResponsedMessage {
        public CloudMusicData.MusicTagList mCloudMusicWithTagData;

        public VideoCloudMusicListResponseMessage(int i) {
            super(i);
        }

        @Override // com.baidu.tbadk.message.http.JsonHttpResponsedMessage
        public void decodeLogicInBackGround(int i, JSONObject jSONObject) throws Exception {
            int statusCode = getStatusCode();
            int error = getError();
            if (statusCode == 200 && error == 0 && jSONObject != null) {
                this.mCloudMusicWithTagData = (CloudMusicData.MusicTagList) OrmObject.objectWithJson(jSONObject.optJSONObject("data"), CloudMusicData.MusicTagList.class);
            }
        }
    }

    public void a(int i, a<CloudMusicData.MusicTagList> aVar) {
        if (aVar != null && i >= 0) {
            HttpMessage httpMessage = new HttpMessage(CmdConfigHttp.CMD_VIDEO_CLOUD_MUSIC_LIST);
            int i2 = this.pn + 1;
            this.pn = i2;
            httpMessage.addParam("pn", i2);
            httpMessage.addParam(LegoListActivityConfig.RN, 10);
            httpMessage.addParam("tag_id", i);
            sendMessage(httpMessage);
            this.gQS = aVar;
        }
    }

    public void bBv() {
        this.pn = 1;
    }

    @Override // com.baidu.adp.base.BdBaseModel
    protected boolean LoadData() {
        return false;
    }

    @Override // com.baidu.adp.base.BdBaseModel
    public boolean cancelLoadData() {
        MessageManager.getInstance().unRegisterTask(CmdConfigHttp.CMD_VIDEO_CLOUD_MUSIC_LIST);
        return false;
    }
}
