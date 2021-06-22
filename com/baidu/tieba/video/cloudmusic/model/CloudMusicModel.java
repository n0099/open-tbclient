package com.baidu.tieba.video.cloudmusic.model;

import com.baidu.adp.base.BdBaseModel;
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
import d.a.c.a.f;
import org.json.JSONObject;
/* loaded from: classes5.dex */
public class CloudMusicModel extends BdBaseModel {

    /* renamed from: e  reason: collision with root package name */
    public d.a.o0.r3.h.i.a<CloudMusicData> f21370e;

    /* renamed from: f  reason: collision with root package name */
    public final HttpMessageListener f21371f;

    /* loaded from: classes5.dex */
    public static class VideoCloudMusicWithTagResponseMessage extends JsonHttpResponsedMessage {
        public CloudMusicData mCloudMusicData;

        public VideoCloudMusicWithTagResponseMessage(int i2) {
            super(i2);
        }

        @Override // com.baidu.tbadk.message.http.JsonHttpResponsedMessage
        public void decodeLogicInBackGround(int i2, JSONObject jSONObject) throws Exception {
            int statusCode = getStatusCode();
            int error = getError();
            if (statusCode == 200 && error == 0 && jSONObject != null) {
                this.mCloudMusicData = (CloudMusicData) OrmObject.objectWithJson(jSONObject.optJSONObject("data"), CloudMusicData.class);
            }
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
            if (httpResponsedMessage == null || httpResponsedMessage.getCmd() != 1003371 || !(httpResponsedMessage instanceof VideoCloudMusicWithTagResponseMessage) || CloudMusicModel.this.f21370e == null) {
                return;
            }
            CloudMusicModel.this.f21370e.a(((VideoCloudMusicWithTagResponseMessage) httpResponsedMessage).mCloudMusicData);
        }
    }

    public CloudMusicModel(f fVar) {
        super(fVar);
        this.f21371f = new a(CmdConfigHttp.CMD_VIDEO_CLOUD_MUSIC_WITH_TAGS);
        y();
        this.f21371f.setTag(getUniqueId());
        this.f21371f.setSelfListener(true);
        registerListener(this.f21371f);
    }

    @Override // com.baidu.adp.base.BdBaseModel
    public boolean LoadData() {
        return false;
    }

    @Override // com.baidu.adp.base.BdBaseModel
    public boolean cancelLoadData() {
        MessageManager.getInstance().unRegisterTask(CmdConfigHttp.CMD_VIDEO_CLOUD_MUSIC_WITH_TAGS);
        return false;
    }

    public void x(d.a.o0.r3.h.i.a<CloudMusicData> aVar) {
        if (aVar == null) {
            return;
        }
        sendMessage(new HttpMessage(CmdConfigHttp.CMD_VIDEO_CLOUD_MUSIC_WITH_TAGS));
        this.f21370e = aVar;
    }

    public final void y() {
        TbHttpMessageTask tbHttpMessageTask = new TbHttpMessageTask(CmdConfigHttp.CMD_VIDEO_CLOUD_MUSIC_WITH_TAGS, TbConfig.SERVER_ADDRESS + "c/f/video/getMusicList");
        tbHttpMessageTask.setResponsedClass(VideoCloudMusicWithTagResponseMessage.class);
        MessageManager.getInstance().registerTask(tbHttpMessageTask);
    }
}
