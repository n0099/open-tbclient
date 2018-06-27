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
import com.baidu.tieba.video.meida.h;
import com.baidu.tieba.video.meida.i;
import java.util.ArrayList;
import java.util.List;
import org.json.JSONArray;
import org.json.JSONObject;
/* loaded from: classes2.dex */
public class SelectMusicModel extends BdBaseModel {
    private com.baidu.tieba.video.editvideo.b hdg;
    private final HttpMessageListener hdh;
    private TbPageContext mPageContext;

    public SelectMusicModel(TbPageContext tbPageContext, com.baidu.tieba.video.editvideo.b bVar) {
        super(tbPageContext);
        this.hdh = new HttpMessageListener(CmdConfigHttp.CMD_VIDEO_SUG_MUSIC) { // from class: com.baidu.tieba.video.editvideo.model.SelectMusicModel.2
            /* JADX DEBUG: Method merged with bridge method */
            @Override // com.baidu.adp.framework.listener.MessageListener
            public void onMessage(HttpResponsedMessage httpResponsedMessage) {
                if (httpResponsedMessage != null && httpResponsedMessage.getCmd() == 1003366 && (httpResponsedMessage instanceof VideoSugMusicResponseMessage) && ((VideoSugMusicResponseMessage) httpResponsedMessage).musicDatas != null) {
                    SelectMusicModel.this.hdg.setMusicData(((VideoSugMusicResponseMessage) httpResponsedMessage).musicDatas);
                }
            }
        };
        this.mPageContext = tbPageContext;
        this.hdg = bVar;
        bCz();
        this.hdh.setTag(getUniqueId());
        this.hdh.setSelfListener(true);
        registerListener(this.hdh);
    }

    public void c(final String str, final String str2, final String str3, final boolean z) {
        if ((!z || !TextUtils.isEmpty(str2)) && !TextUtils.isEmpty(str) && !TextUtils.isEmpty(str3)) {
            new BdAsyncTask<Void, Integer, i>() { // from class: com.baidu.tieba.video.editvideo.model.SelectMusicModel.1
                /* JADX DEBUG: Method merged with bridge method */
                /* JADX INFO: Access modifiers changed from: protected */
                @Override // com.baidu.adp.lib.asyncTask.BdAsyncTask
                /* renamed from: o */
                public i doInBackground(Void... voidArr) {
                    if (TextUtils.isEmpty(str2) && !z) {
                        return h.bDt().cw(str, str3);
                    }
                    return h.bDt().d(str, str2, str3, z);
                }

                /* JADX DEBUG: Method merged with bridge method */
                /* JADX INFO: Access modifiers changed from: protected */
                @Override // com.baidu.adp.lib.asyncTask.BdAsyncTask
                /* renamed from: a */
                public void onPostExecute(i iVar) {
                    super.onPostExecute(iVar);
                    if (iVar == null || iVar.result != 0) {
                        SelectMusicModel.this.hdg.n(null, iVar.result, iVar.msg);
                    } else {
                        SelectMusicModel.this.hdg.n(str3, -4399, "");
                    }
                }
            }.execute(new Void[0]);
        }
    }

    public void bCy() {
        if (!j.jD()) {
            this.mPageContext.showToast(d.k.no_network);
        } else {
            sendMessage(new HttpMessage(CmdConfigHttp.CMD_VIDEO_SUG_MUSIC));
        }
    }

    private void bCz() {
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
