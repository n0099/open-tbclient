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
import d.a.c.e.p.j;
import d.a.n0.r3.k.h;
import d.a.n0.r3.k.i;
import java.util.ArrayList;
import java.util.List;
import org.json.JSONArray;
import org.json.JSONObject;
/* loaded from: classes5.dex */
public class SelectMusicModel extends BdBaseModel {

    /* renamed from: e  reason: collision with root package name */
    public d.a.n0.r3.i.b f21321e;

    /* renamed from: f  reason: collision with root package name */
    public TbPageContext f21322f;

    /* renamed from: g  reason: collision with root package name */
    public final HttpMessageListener f21323g;

    /* loaded from: classes5.dex */
    public static class VideoSugMusicResponseMessage extends JsonHttpResponsedMessage {
        public List<MusicData> musicDatas;

        public VideoSugMusicResponseMessage(int i2) {
            super(i2);
        }

        @Override // com.baidu.tbadk.message.http.JsonHttpResponsedMessage
        public void decodeLogicInBackGround(int i2, JSONObject jSONObject) throws Exception {
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
                for (int i3 = 0; i3 < jSONArray.length(); i3++) {
                    MusicData musicData = (MusicData) OrmObject.objectWithJsonStr(jSONArray.optString(i3), MusicData.class);
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
        public final /* synthetic */ String f21324a;

        /* renamed from: b  reason: collision with root package name */
        public final /* synthetic */ boolean f21325b;

        /* renamed from: c  reason: collision with root package name */
        public final /* synthetic */ String f21326c;

        /* renamed from: d  reason: collision with root package name */
        public final /* synthetic */ String f21327d;

        public a(String str, boolean z, String str2, String str3) {
            this.f21324a = str;
            this.f21325b = z;
            this.f21326c = str2;
            this.f21327d = str3;
        }

        /* JADX DEBUG: Method merged with bridge method */
        @Override // com.baidu.adp.lib.asyncTask.BdAsyncTask
        /* renamed from: b */
        public i doInBackground(Void... voidArr) {
            if (TextUtils.isEmpty(this.f21324a) && !this.f21325b) {
                return h.e().g(this.f21326c, this.f21327d);
            }
            return h.e().h(this.f21326c, this.f21324a, this.f21327d, this.f21325b);
        }

        /* JADX DEBUG: Method merged with bridge method */
        @Override // com.baidu.adp.lib.asyncTask.BdAsyncTask
        /* renamed from: c */
        public void onPostExecute(i iVar) {
            super.onPostExecute(iVar);
            if (iVar == null || iVar.f63915a != 0) {
                SelectMusicModel.this.f21321e.onSaveMusicVideo(null, iVar.f63915a, iVar.f63916b);
            } else {
                SelectMusicModel.this.f21321e.onSaveMusicVideo(this.f21327d, -4399, "");
            }
        }
    }

    /* loaded from: classes5.dex */
    public class b extends HttpMessageListener {
        public b(int i2) {
            super(i2);
        }

        /* JADX DEBUG: Method merged with bridge method */
        @Override // com.baidu.adp.framework.listener.MessageListener
        public void onMessage(HttpResponsedMessage httpResponsedMessage) {
            if (httpResponsedMessage != null && httpResponsedMessage.getCmd() == 1003366 && (httpResponsedMessage instanceof VideoSugMusicResponseMessage)) {
                VideoSugMusicResponseMessage videoSugMusicResponseMessage = (VideoSugMusicResponseMessage) httpResponsedMessage;
                if (videoSugMusicResponseMessage.musicDatas == null) {
                    return;
                }
                SelectMusicModel.this.f21321e.setMusicData(videoSugMusicResponseMessage.musicDatas);
            }
        }
    }

    public SelectMusicModel(TbPageContext tbPageContext, d.a.n0.r3.i.b bVar) {
        super(tbPageContext);
        this.f21323g = new b(CmdConfigHttp.CMD_VIDEO_SUG_MUSIC);
        this.f21322f = tbPageContext;
        this.f21321e = bVar;
        y();
        this.f21323g.setTag(getUniqueId());
        this.f21323g.setSelfListener(true);
        registerListener(this.f21323g);
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

    public void x() {
        if (!j.z()) {
            this.f21322f.showToast(R.string.no_network);
        } else {
            sendMessage(new HttpMessage(CmdConfigHttp.CMD_VIDEO_SUG_MUSIC));
        }
    }

    public final void y() {
        TbHttpMessageTask tbHttpMessageTask = new TbHttpMessageTask(CmdConfigHttp.CMD_VIDEO_SUG_MUSIC, TbConfig.SERVER_ADDRESS + "c/f/video/music");
        tbHttpMessageTask.setResponsedClass(VideoSugMusicResponseMessage.class);
        MessageManager.getInstance().registerTask(tbHttpMessageTask);
    }

    public void z(String str, String str2, String str3, boolean z) {
        if ((z && TextUtils.isEmpty(str2)) || TextUtils.isEmpty(str) || TextUtils.isEmpty(str3)) {
            return;
        }
        new a(str2, z, str, str3).execute(new Void[0]);
    }
}
