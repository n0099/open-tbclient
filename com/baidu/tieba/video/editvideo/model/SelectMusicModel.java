package com.baidu.tieba.video.editvideo.model;

import android.text.TextUtils;
import com.baidu.adp.base.BdBaseModel;
import com.baidu.adp.framework.MessageManager;
import com.baidu.adp.framework.listener.HttpMessageListener;
import com.baidu.adp.framework.message.HttpMessage;
import com.baidu.adp.framework.message.HttpResponsedMessage;
import com.baidu.adp.lib.OrmObject.toolsystem.orm.object.OrmObject;
import com.baidu.adp.lib.asyncTask.BdAsyncTask;
import com.baidu.tbadk.TbConfig;
import com.baidu.tbadk.TbPageContext;
import com.baidu.tbadk.core.frameworkData.CmdConfigHttp;
import com.baidu.tbadk.message.http.JsonHttpResponsedMessage;
import com.baidu.tbadk.task.TbHttpMessageTask;
import com.baidu.tieba.R;
import com.baidu.tieba.video.editvideo.data.MusicData;
import d.b.b.e.p.j;
import d.b.i0.p3.l.h;
import d.b.i0.p3.l.i;
import java.util.ArrayList;
import java.util.List;
import org.json.JSONArray;
import org.json.JSONObject;
/* loaded from: classes5.dex */
public class SelectMusicModel extends BdBaseModel {

    /* renamed from: e  reason: collision with root package name */
    public d.b.i0.p3.j.b f21753e;

    /* renamed from: f  reason: collision with root package name */
    public TbPageContext f21754f;

    /* renamed from: g  reason: collision with root package name */
    public final HttpMessageListener f21755g;

    /* loaded from: classes5.dex */
    public static class VideoSugMusicResponseMessage extends JsonHttpResponsedMessage {
        public List<MusicData> musicDatas;

        public VideoSugMusicResponseMessage(int i) {
            super(i);
        }

        @Override // com.baidu.tbadk.message.http.JsonHttpResponsedMessage
        public void decodeLogicInBackGround(int i, JSONObject jSONObject) throws Exception {
            int statusCode = getStatusCode();
            int error = getError();
            if (statusCode == 200 && error == 0 && jSONObject != null) {
                String optString = jSONObject.optString("data");
                if (TextUtils.isEmpty(optString)) {
                    return;
                }
                String optString2 = new JSONObject(optString).optString("music_list");
                if (TextUtils.isEmpty(optString2)) {
                    return;
                }
                JSONArray jSONArray = new JSONArray(optString2);
                this.musicDatas = new ArrayList();
                for (int i2 = 0; i2 < jSONArray.length(); i2++) {
                    MusicData musicData = (MusicData) OrmObject.objectWithJsonStr(jSONArray.optString(i2), MusicData.class);
                    if (musicData != null) {
                        this.musicDatas.add(musicData);
                    }
                }
            }
        }
    }

    /* loaded from: classes5.dex */
    public class a extends BdAsyncTask<Void, Integer, i> {

        /* renamed from: a  reason: collision with root package name */
        public final /* synthetic */ String f21756a;

        /* renamed from: b  reason: collision with root package name */
        public final /* synthetic */ boolean f21757b;

        /* renamed from: c  reason: collision with root package name */
        public final /* synthetic */ String f21758c;

        /* renamed from: d  reason: collision with root package name */
        public final /* synthetic */ String f21759d;

        public a(String str, boolean z, String str2, String str3) {
            this.f21756a = str;
            this.f21757b = z;
            this.f21758c = str2;
            this.f21759d = str3;
        }

        /* JADX DEBUG: Method merged with bridge method */
        @Override // com.baidu.adp.lib.asyncTask.BdAsyncTask
        /* renamed from: b */
        public i doInBackground(Void... voidArr) {
            if (TextUtils.isEmpty(this.f21756a) && !this.f21757b) {
                return h.e().g(this.f21758c, this.f21759d);
            }
            return h.e().h(this.f21758c, this.f21756a, this.f21759d, this.f21757b);
        }

        /* JADX DEBUG: Method merged with bridge method */
        @Override // com.baidu.adp.lib.asyncTask.BdAsyncTask
        /* renamed from: c */
        public void onPostExecute(i iVar) {
            super.onPostExecute(iVar);
            if (iVar == null || iVar.f59112a != 0) {
                SelectMusicModel.this.f21753e.onSaveMusicVideo(null, iVar.f59112a, iVar.f59113b);
            } else {
                SelectMusicModel.this.f21753e.onSaveMusicVideo(this.f21759d, -4399, "");
            }
        }
    }

    /* loaded from: classes5.dex */
    public class b extends HttpMessageListener {
        public b(int i) {
            super(i);
        }

        /* JADX DEBUG: Method merged with bridge method */
        @Override // com.baidu.adp.framework.listener.MessageListener
        public void onMessage(HttpResponsedMessage httpResponsedMessage) {
            if (httpResponsedMessage != null && httpResponsedMessage.getCmd() == 1003366 && (httpResponsedMessage instanceof VideoSugMusicResponseMessage)) {
                VideoSugMusicResponseMessage videoSugMusicResponseMessage = (VideoSugMusicResponseMessage) httpResponsedMessage;
                if (videoSugMusicResponseMessage.musicDatas == null) {
                    return;
                }
                SelectMusicModel.this.f21753e.setMusicData(videoSugMusicResponseMessage.musicDatas);
            }
        }
    }

    public SelectMusicModel(TbPageContext tbPageContext, d.b.i0.p3.j.b bVar) {
        super(tbPageContext);
        this.f21755g = new b(CmdConfigHttp.CMD_VIDEO_SUG_MUSIC);
        this.f21754f = tbPageContext;
        this.f21753e = bVar;
        u();
        this.f21755g.setTag(getUniqueId());
        this.f21755g.setSelfListener(true);
        registerListener(this.f21755g);
    }

    @Override // com.baidu.adp.base.BdBaseModel
    public boolean LoadData() {
        return false;
    }

    @Override // com.baidu.adp.base.BdBaseModel
    public boolean cancelLoadData() {
        MessageManager.getInstance().unRegisterTask(CmdConfigHttp.CMD_VIDEO_SUG_MUSIC);
        return false;
    }

    public void t() {
        if (!j.z()) {
            this.f21754f.showToast(R.string.no_network);
        } else {
            sendMessage(new HttpMessage(CmdConfigHttp.CMD_VIDEO_SUG_MUSIC));
        }
    }

    public final void u() {
        TbHttpMessageTask tbHttpMessageTask = new TbHttpMessageTask(CmdConfigHttp.CMD_VIDEO_SUG_MUSIC, TbConfig.SERVER_ADDRESS + "c/f/video/music");
        tbHttpMessageTask.setResponsedClass(VideoSugMusicResponseMessage.class);
        MessageManager.getInstance().registerTask(tbHttpMessageTask);
    }

    public void v(String str, String str2, String str3, boolean z) {
        if ((z && TextUtils.isEmpty(str2)) || TextUtils.isEmpty(str) || TextUtils.isEmpty(str3)) {
            return;
        }
        new a(str2, z, str, str3).execute(new Void[0]);
    }
}
