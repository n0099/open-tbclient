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
import d.b.b.a.f;
import org.json.JSONObject;
/* loaded from: classes5.dex */
public class CloudMusicListModel extends BdBaseModel {

    /* renamed from: e  reason: collision with root package name */
    public d.b.i0.p3.i.i.a<CloudMusicData.MusicTagList> f21720e;

    /* renamed from: f  reason: collision with root package name */
    public int f21721f;

    /* renamed from: g  reason: collision with root package name */
    public final HttpMessageListener f21722g;

    /* loaded from: classes5.dex */
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

    /* loaded from: classes5.dex */
    public class a extends HttpMessageListener {
        public a(int i) {
            super(i);
        }

        /* JADX DEBUG: Method merged with bridge method */
        @Override // com.baidu.adp.framework.listener.MessageListener
        public void onMessage(HttpResponsedMessage httpResponsedMessage) {
            if (httpResponsedMessage == null || httpResponsedMessage.getCmd() != 1003367 || !(httpResponsedMessage instanceof VideoCloudMusicListResponseMessage) || CloudMusicListModel.this.f21720e == null) {
                return;
            }
            if (httpResponsedMessage.hasError() && httpResponsedMessage.getError() != 0) {
                CloudMusicListModel.t(CloudMusicListModel.this);
            }
            CloudMusicListModel.this.f21720e.a(((VideoCloudMusicListResponseMessage) httpResponsedMessage).mCloudMusicWithTagData);
        }
    }

    public CloudMusicListModel(f fVar) {
        super(fVar);
        this.f21721f = 1;
        this.f21722g = new a(CmdConfigHttp.CMD_VIDEO_CLOUD_MUSIC_LIST);
        v();
        this.f21722g.setTag(getUniqueId());
        this.f21722g.setSelfListener(true);
        registerListener(this.f21722g);
    }

    public static /* synthetic */ int t(CloudMusicListModel cloudMusicListModel) {
        int i = cloudMusicListModel.f21721f;
        cloudMusicListModel.f21721f = i - 1;
        return i;
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

    public void u(int i, d.b.i0.p3.i.i.a<CloudMusicData.MusicTagList> aVar) {
        if (aVar == null || i < 0) {
            return;
        }
        HttpMessage httpMessage = new HttpMessage(CmdConfigHttp.CMD_VIDEO_CLOUD_MUSIC_LIST);
        int i2 = this.f21721f + 1;
        this.f21721f = i2;
        httpMessage.addParam(Config.PACKAGE_NAME, i2);
        httpMessage.addParam("rn", 10);
        httpMessage.addParam(TiebaStatic.Params.TAG_ID, i);
        sendMessage(httpMessage);
        this.f21720e = aVar;
    }

    public final void v() {
        TbHttpMessageTask tbHttpMessageTask = new TbHttpMessageTask(CmdConfigHttp.CMD_VIDEO_CLOUD_MUSIC_LIST, TbConfig.SERVER_ADDRESS + "c/f/video/getMusicTagList");
        tbHttpMessageTask.setResponsedClass(VideoCloudMusicListResponseMessage.class);
        MessageManager.getInstance().registerTask(tbHttpMessageTask);
    }

    public void w() {
        this.f21721f = 1;
    }
}
