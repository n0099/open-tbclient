package com.baidu.tieba.video.cloudmusic.model;

import com.baidu.adp.base.BdBaseModel;
import com.baidu.adp.base.f;
import com.baidu.adp.framework.MessageManager;
import com.baidu.adp.framework.listener.HttpMessageListener;
import com.baidu.adp.framework.message.HttpMessage;
import com.baidu.adp.framework.message.HttpResponsedMessage;
import com.baidu.adp.lib.OrmObject.toolsystem.orm.object.OrmObject;
import com.baidu.live.tbadk.core.util.TiebaInitialize;
import com.baidu.live.tbadk.data.Config;
import com.baidu.tbadk.TbConfig;
import com.baidu.tbadk.message.http.JsonHttpResponsedMessage;
import com.baidu.tbadk.task.TbHttpMessageTask;
import com.baidu.tieba.video.cloudmusic.data.CloudMusicData;
import org.json.JSONObject;
/* loaded from: classes7.dex */
public class CloudMusicListModel extends BdBaseModel {
    private a<CloudMusicData.MusicTagList> nBO;
    private final HttpMessageListener nBP;
    private int pn;

    static /* synthetic */ int b(CloudMusicListModel cloudMusicListModel) {
        int i = cloudMusicListModel.pn;
        cloudMusicListModel.pn = i - 1;
        return i;
    }

    public CloudMusicListModel(f fVar) {
        super(fVar);
        this.pn = 1;
        this.nBP = new HttpMessageListener(1003367) { // from class: com.baidu.tieba.video.cloudmusic.model.CloudMusicListModel.1
            /* JADX DEBUG: Method merged with bridge method */
            @Override // com.baidu.adp.framework.listener.MessageListener
            public void onMessage(HttpResponsedMessage httpResponsedMessage) {
                if (httpResponsedMessage != null && httpResponsedMessage.getCmd() == 1003367 && (httpResponsedMessage instanceof VideoCloudMusicListResponseMessage) && CloudMusicListModel.this.nBO != null) {
                    if (httpResponsedMessage.hasError() && httpResponsedMessage.getError() != 0) {
                        CloudMusicListModel.b(CloudMusicListModel.this);
                    }
                    CloudMusicListModel.this.nBO.aT(((VideoCloudMusicListResponseMessage) httpResponsedMessage).mCloudMusicWithTagData);
                }
            }
        };
        dQd();
        this.nBP.setTag(getUniqueId());
        this.nBP.setSelfListener(true);
        registerListener(this.nBP);
    }

    private void dQd() {
        TbHttpMessageTask tbHttpMessageTask = new TbHttpMessageTask(1003367, TbConfig.SERVER_ADDRESS + Config.VIDEO_CLOUD_MUSIC_LIST);
        tbHttpMessageTask.setResponsedClass(VideoCloudMusicListResponseMessage.class);
        MessageManager.getInstance().registerTask(tbHttpMessageTask);
    }

    /* loaded from: classes7.dex */
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
            HttpMessage httpMessage = new HttpMessage(1003367);
            int i2 = this.pn + 1;
            this.pn = i2;
            httpMessage.addParam(com.baidu.mobstat.Config.PACKAGE_NAME, i2);
            httpMessage.addParam("rn", 10);
            httpMessage.addParam(TiebaInitialize.Params.TAG_ID, i);
            sendMessage(httpMessage);
            this.nBO = aVar;
        }
    }

    public void dQe() {
        this.pn = 1;
    }

    @Override // com.baidu.adp.base.BdBaseModel
    protected boolean LoadData() {
        return false;
    }

    @Override // com.baidu.adp.base.BdBaseModel
    public boolean cancelLoadData() {
        MessageManager.getInstance().unRegisterTask(1003367);
        return false;
    }
}
