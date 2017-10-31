package com.baidu.tieba.video.editvideo.model;

import android.text.TextUtils;
import com.baidu.adp.base.BdBaseModel;
import com.baidu.adp.framework.MessageManager;
import com.baidu.adp.framework.listener.HttpMessageListener;
import com.baidu.adp.framework.message.HttpMessage;
import com.baidu.adp.framework.message.HttpResponsedMessage;
import com.baidu.adp.lib.OrmObject.toolsystem.orm.object.OrmObject;
import com.baidu.adp.lib.asyncTask.BdAsyncTask;
import com.baidu.adp.lib.util.j;
import com.baidu.tbadk.TbConfig;
import com.baidu.tbadk.TbPageContext;
import com.baidu.tbadk.core.frameworkData.CmdConfigHttp;
import com.baidu.tbadk.message.http.JsonHttpResponsedMessage;
import com.baidu.tbadk.task.TbHttpMessageTask;
import com.baidu.tieba.d;
import com.baidu.tieba.video.editvideo.data.MusicData;
import com.baidu.tieba.video.meida.g;
import java.util.ArrayList;
import java.util.List;
import org.json.JSONArray;
import org.json.JSONObject;
/* loaded from: classes2.dex */
public class SelectMusicModel extends BdBaseModel {
    private com.baidu.tieba.video.editvideo.b gEr;
    private final HttpMessageListener gEs;
    private TbPageContext mPageContext;

    public SelectMusicModel(TbPageContext tbPageContext, com.baidu.tieba.video.editvideo.b bVar) {
        super(tbPageContext);
        this.gEs = new HttpMessageListener(CmdConfigHttp.CMD_VIDEO_SUG_MUSIC) { // from class: com.baidu.tieba.video.editvideo.model.SelectMusicModel.2
            /* JADX DEBUG: Method merged with bridge method */
            @Override // com.baidu.adp.framework.listener.MessageListener
            public void onMessage(HttpResponsedMessage httpResponsedMessage) {
                if (httpResponsedMessage != null && httpResponsedMessage.getCmd() == 1003366 && (httpResponsedMessage instanceof VideoSugMusicResponseMessage) && ((VideoSugMusicResponseMessage) httpResponsedMessage).musicDatas != null) {
                    SelectMusicModel.this.gEr.setMusicData(((VideoSugMusicResponseMessage) httpResponsedMessage).musicDatas);
                }
            }
        };
        this.mPageContext = tbPageContext;
        this.gEr = bVar;
        byX();
        this.gEs.setTag(getUniqueId());
        this.gEs.setSelfListener(true);
        registerListener(this.gEs);
    }

    public void c(final String str, final String str2, final String str3, final boolean z) {
        if ((!z || !TextUtils.isEmpty(str2)) && !TextUtils.isEmpty(str) && !TextUtils.isEmpty(str3)) {
            new BdAsyncTask<Void, Integer, String>() { // from class: com.baidu.tieba.video.editvideo.model.SelectMusicModel.1
                /* JADX DEBUG: Method merged with bridge method */
                /* JADX INFO: Access modifiers changed from: protected */
                @Override // com.baidu.adp.lib.asyncTask.BdAsyncTask
                /* renamed from: g */
                public String doInBackground(Void... voidArr) {
                    boolean d;
                    if (TextUtils.isEmpty(str2) && !z) {
                        d = g.bzM().ci(str, str3);
                    } else {
                        d = g.bzM().d(str, str2, str3, z);
                    }
                    if (d) {
                        return str3;
                    }
                    return null;
                }

                /* JADX DEBUG: Method merged with bridge method */
                /* JADX INFO: Access modifiers changed from: protected */
                @Override // com.baidu.adp.lib.asyncTask.BdAsyncTask
                public void onPostExecute(String str4) {
                    super.onPostExecute((AnonymousClass1) str4);
                    SelectMusicModel.this.gEr.th(str4);
                }
            }.execute(new Void[0]);
        }
    }

    public void byW() {
        if (!j.hh()) {
            this.mPageContext.showToast(d.j.no_network);
        } else {
            sendMessage(new HttpMessage(CmdConfigHttp.CMD_VIDEO_SUG_MUSIC));
        }
    }

    private void byX() {
        TbHttpMessageTask tbHttpMessageTask = new TbHttpMessageTask(CmdConfigHttp.CMD_VIDEO_SUG_MUSIC, TbConfig.SERVER_ADDRESS + "c/f/video/music");
        tbHttpMessageTask.setResponsedClass(VideoSugMusicResponseMessage.class);
        MessageManager.getInstance().registerTask(tbHttpMessageTask);
    }

    /* loaded from: classes2.dex */
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
                if (!TextUtils.isEmpty(optString)) {
                    String optString2 = new JSONObject(optString).optString("music_list");
                    if (!TextUtils.isEmpty(optString2)) {
                        JSONArray jSONArray = new JSONArray(optString2);
                        this.musicDatas = new ArrayList();
                        int i2 = 0;
                        while (true) {
                            int i3 = i2;
                            if (i3 < jSONArray.length()) {
                                MusicData musicData = (MusicData) OrmObject.objectWithJsonStr(jSONArray.optString(i3), MusicData.class);
                                if (musicData != null) {
                                    this.musicDatas.add(musicData);
                                }
                                i2 = i3 + 1;
                            } else {
                                return;
                            }
                        }
                    }
                }
            }
        }
    }

    @Override // com.baidu.adp.base.BdBaseModel
    protected boolean LoadData() {
        return false;
    }

    @Override // com.baidu.adp.base.BdBaseModel
    public boolean cancelLoadData() {
        MessageManager.getInstance().unRegisterTask(CmdConfigHttp.CMD_VIDEO_SUG_MUSIC);
        return false;
    }
}
