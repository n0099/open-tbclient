package com.baidu.tieba.video.cloudmusic.model;

import com.baidu.adp.base.BdBaseModel;
import com.baidu.adp.framework.MessageManager;
import com.baidu.adp.framework.listener.HttpMessageListener;
import com.baidu.adp.framework.message.HttpMessage;
import com.baidu.adp.framework.message.HttpResponsedMessage;
import com.baidu.adp.lib.OrmObject.toolsystem.orm.object.OrmObject;
import com.baidu.mobstat.Config;
import com.baidu.tbadk.TbConfig;
import com.baidu.tbadk.core.frameworkData.CmdConfigHttp;
import com.baidu.tbadk.core.util.TiebaStatic;
import com.baidu.tbadk.message.http.JsonHttpResponsedMessage;
import com.baidu.tbadk.task.TbHttpMessageTask;
import com.baidu.tieba.video.cloudmusic.data.CloudMusicData;
import d.a.c.a.f;
import org.json.JSONObject;
/* loaded from: classes5.dex */
public class CloudMusicListModel extends BdBaseModel {

    /* renamed from: e  reason: collision with root package name */
    public d.a.j0.q3.i.i.a<CloudMusicData.MusicTagList> f22033e;

    /* renamed from: f  reason: collision with root package name */
    public int f22034f;

    /* renamed from: g  reason: collision with root package name */
    public final HttpMessageListener f22035g;

    /* loaded from: classes5.dex */
    public static class VideoCloudMusicListResponseMessage extends JsonHttpResponsedMessage {
        public CloudMusicData.MusicTagList mCloudMusicWithTagData;

        public VideoCloudMusicListResponseMessage(int i2) {
            super(i2);
        }

        @Override // com.baidu.tbadk.message.http.JsonHttpResponsedMessage
        public void decodeLogicInBackGround(int i2, JSONObject jSONObject) throws Exception {
            int statusCode = getStatusCode();
            int error = getError();
            if (statusCode == 200 && error == 0 && jSONObject != null) {
                this.mCloudMusicWithTagData = (CloudMusicData.MusicTagList) OrmObject.objectWithJson(jSONObject.optJSONObject("data"), CloudMusicData.MusicTagList.class);
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
            if (httpResponsedMessage == null || httpResponsedMessage.getCmd() != 1003367 || !(httpResponsedMessage instanceof VideoCloudMusicListResponseMessage) || CloudMusicListModel.this.f22033e == null) {
                return;
            }
            if (httpResponsedMessage.hasError() && httpResponsedMessage.getError() != 0) {
                CloudMusicListModel.t(CloudMusicListModel.this);
            }
            CloudMusicListModel.this.f22033e.a(((VideoCloudMusicListResponseMessage) httpResponsedMessage).mCloudMusicWithTagData);
        }
    }

    public CloudMusicListModel(f fVar) {
        super(fVar);
        this.f22034f = 1;
        this.f22035g = new a(CmdConfigHttp.CMD_VIDEO_CLOUD_MUSIC_LIST);
        v();
        this.f22035g.setTag(getUniqueId());
        this.f22035g.setSelfListener(true);
        registerListener(this.f22035g);
    }

    public static /* synthetic */ int t(CloudMusicListModel cloudMusicListModel) {
        int i2 = cloudMusicListModel.f22034f;
        cloudMusicListModel.f22034f = i2 - 1;
        return i2;
    }

    @Override // com.baidu.adp.base.BdBaseModel
    public boolean LoadData() {
        return false;
    }

    @Override // com.baidu.adp.base.BdBaseModel
    public boolean cancelLoadData() {
        MessageManager.getInstance().unRegisterTask(CmdConfigHttp.CMD_VIDEO_CLOUD_MUSIC_LIST);
        return false;
    }

    public void u(int i2, d.a.j0.q3.i.i.a<CloudMusicData.MusicTagList> aVar) {
        if (aVar == null || i2 < 0) {
            return;
        }
        HttpMessage httpMessage = new HttpMessage(CmdConfigHttp.CMD_VIDEO_CLOUD_MUSIC_LIST);
        int i3 = this.f22034f + 1;
        this.f22034f = i3;
        httpMessage.addParam(Config.PACKAGE_NAME, i3);
        httpMessage.addParam("rn", 10);
        httpMessage.addParam(TiebaStatic.Params.TAG_ID, i2);
        sendMessage(httpMessage);
        this.f22033e = aVar;
    }

    public final void v() {
        TbHttpMessageTask tbHttpMessageTask = new TbHttpMessageTask(CmdConfigHttp.CMD_VIDEO_CLOUD_MUSIC_LIST, TbConfig.SERVER_ADDRESS + "c/f/video/getMusicTagList");
        tbHttpMessageTask.setResponsedClass(VideoCloudMusicListResponseMessage.class);
        MessageManager.getInstance().registerTask(tbHttpMessageTask);
    }

    public void w() {
        this.f22034f = 1;
    }
}
