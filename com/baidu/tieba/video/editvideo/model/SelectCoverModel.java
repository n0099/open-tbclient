package com.baidu.tieba.video.editvideo.model;

import android.graphics.Bitmap;
import android.media.MediaMetadataRetriever;
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
import com.baidu.tbadk.core.TbadkCoreApplication;
import com.baidu.tbadk.core.frameworkData.CmdConfigHttp;
import com.baidu.tbadk.core.frameworkData.IntentConfig;
import com.baidu.tbadk.message.http.JsonHttpResponsedMessage;
import com.baidu.tbadk.task.TbHttpMessageTask;
import com.baidu.tieba.d;
import com.baidu.tieba.j.h;
import com.baidu.tieba.video.editvideo.data.PendantData;
import java.io.BufferedOutputStream;
import java.io.ByteArrayOutputStream;
import java.io.File;
import java.io.FileOutputStream;
import java.io.OutputStream;
import java.util.ArrayList;
import java.util.List;
import org.json.JSONArray;
import org.json.JSONObject;
/* loaded from: classes5.dex */
public class SelectCoverModel extends BdBaseModel {
    private final HttpMessageListener hHZ;
    private h iGX;
    private com.baidu.tieba.video.editvideo.a iXa;
    private a iXb;
    private final HttpMessageListener iXc;
    private TbPageContext mPageContext;

    public SelectCoverModel(TbPageContext tbPageContext, com.baidu.tieba.video.editvideo.a aVar, h hVar) {
        super(tbPageContext);
        this.hHZ = new HttpMessageListener(CmdConfigHttp.CMD_VIDEO_TEXT_UEG) { // from class: com.baidu.tieba.video.editvideo.model.SelectCoverModel.1
            /* JADX DEBUG: Method merged with bridge method */
            @Override // com.baidu.adp.framework.listener.MessageListener
            public void onMessage(HttpResponsedMessage httpResponsedMessage) {
                if (httpResponsedMessage != null && httpResponsedMessage.getCmd() == 1003356 && (httpResponsedMessage instanceof VideoCheckUegResponseMessage)) {
                    String status = ((VideoCheckUegResponseMessage) httpResponsedMessage).getStatus();
                    if (VideoCheckUegResponseMessage.STATUS_OK.equals(status)) {
                        SelectCoverModel.this.iXa.bPD();
                    } else if (VideoCheckUegResponseMessage.STATUS_FAIL.equals(status)) {
                        String msg = ((VideoCheckUegResponseMessage) httpResponsedMessage).getMsg();
                        if (TextUtils.isEmpty(msg)) {
                            msg = TbadkCoreApplication.getInst().getResources().getString(d.j.video_ueg_fail);
                        }
                        SelectCoverModel.this.iXa.Ar(msg);
                    } else {
                        String errorString = httpResponsedMessage.getErrorString();
                        if (TextUtils.isEmpty(errorString)) {
                            errorString = TbadkCoreApplication.getInst().getResources().getString(d.j.video_fail);
                        }
                        SelectCoverModel.this.iXa.Ar(errorString);
                        if (SelectCoverModel.this.iGX != null) {
                            SelectCoverModel.this.iGX.au(201, errorString);
                        }
                    }
                }
            }
        };
        this.iXc = new HttpMessageListener(CmdConfigHttp.CMD_VIDEO_COVER_PENDANT) { // from class: com.baidu.tieba.video.editvideo.model.SelectCoverModel.2
            /* JADX DEBUG: Method merged with bridge method */
            @Override // com.baidu.adp.framework.listener.MessageListener
            public void onMessage(HttpResponsedMessage httpResponsedMessage) {
                if (httpResponsedMessage != null && httpResponsedMessage.getCmd() == 1003377 && (httpResponsedMessage instanceof VideoPendantResponseMessage) && ((VideoPendantResponseMessage) httpResponsedMessage).pendantDatas != null) {
                    SelectCoverModel.this.iXa.ec(((VideoPendantResponseMessage) httpResponsedMessage).pendantDatas);
                }
            }
        };
        this.mPageContext = tbPageContext;
        this.iXa = aVar;
        this.iGX = hVar;
        registerTask();
        this.hHZ.setTag(getUniqueId());
        this.hHZ.setSelfListener(true);
        registerListener(this.hHZ);
        this.iXc.setTag(getUniqueId());
        this.iXc.setSelfListener(true);
        registerListener(this.iXc);
    }

    private void registerTask() {
        TbHttpMessageTask tbHttpMessageTask = new TbHttpMessageTask(CmdConfigHttp.CMD_VIDEO_TEXT_UEG, TbConfig.SERVER_ADDRESS + "c/f/video/next");
        tbHttpMessageTask.setResponsedClass(VideoCheckUegResponseMessage.class);
        MessageManager.getInstance().registerTask(tbHttpMessageTask);
        TbHttpMessageTask tbHttpMessageTask2 = new TbHttpMessageTask(CmdConfigHttp.CMD_VIDEO_COVER_PENDANT, TbConfig.SERVER_ADDRESS + "c/f/video/pendant");
        tbHttpMessageTask2.setResponsedClass(VideoPendantResponseMessage.class);
        MessageManager.getInstance().registerTask(tbHttpMessageTask2);
    }

    public void cjN() {
        if (!j.kY()) {
            this.mPageContext.showToast(d.j.no_network);
        } else {
            sendMessage(new HttpMessage(CmdConfigHttp.CMD_VIDEO_COVER_PENDANT));
        }
    }

    public void At(String str) {
        HttpMessage httpMessage = new HttpMessage(CmdConfigHttp.CMD_VIDEO_TEXT_UEG);
        httpMessage.addParam("text", str);
        sendMessage(httpMessage);
    }

    public void bt(String str, int i) {
        this.iXb = new a(str, i);
        this.iXb.execute(new Void[0]);
    }

    public void b(final Bitmap bitmap, final String str) {
        if (bitmap != null && !TextUtils.isEmpty(str)) {
            new BdAsyncTask<Void, Integer, String>() { // from class: com.baidu.tieba.video.editvideo.model.SelectCoverModel.3
                /* JADX DEBUG: Method merged with bridge method */
                /* JADX INFO: Access modifiers changed from: protected */
                @Override // com.baidu.adp.lib.asyncTask.BdAsyncTask
                public String doInBackground(Void[] voidArr) {
                    File c = SelectCoverModel.this.c(bitmap, str);
                    bitmap.recycle();
                    return c.getAbsolutePath();
                }

                /* JADX DEBUG: Method merged with bridge method */
                /* JADX INFO: Access modifiers changed from: protected */
                @Override // com.baidu.adp.lib.asyncTask.BdAsyncTask
                public void onPostExecute(String str2) {
                    super.onPostExecute((AnonymousClass3) str2);
                    SelectCoverModel.this.iXa.Dt(str2);
                }
            }.execute(new Void[0]);
        }
    }

    /* loaded from: classes5.dex */
    private class a extends BdAsyncTask<Void, Integer, Bitmap> {
        private int Us;
        private String videoPath;

        public a(String str, int i) {
            this.videoPath = str;
            this.Us = i;
        }

        /* JADX DEBUG: Method merged with bridge method */
        /* JADX INFO: Access modifiers changed from: protected */
        @Override // com.baidu.adp.lib.asyncTask.BdAsyncTask
        public Bitmap doInBackground(Void... voidArr) {
            Bitmap bitmap = null;
            if (TextUtils.isEmpty(this.videoPath)) {
                return null;
            }
            try {
                MediaMetadataRetriever mediaMetadataRetriever = new MediaMetadataRetriever();
                mediaMetadataRetriever.setDataSource(this.videoPath);
                bitmap = mediaMetadataRetriever.getFrameAtTime(this.Us * 1000);
                mediaMetadataRetriever.release();
                return bitmap;
            } catch (Exception e) {
                e.printStackTrace();
                if (SelectCoverModel.this.iGX != null) {
                    SelectCoverModel.this.iGX.au(203, com.baidu.tieba.j.a.p(e));
                    return bitmap;
                }
                return bitmap;
            }
        }

        /* JADX DEBUG: Method merged with bridge method */
        /* JADX INFO: Access modifiers changed from: protected */
        @Override // com.baidu.adp.lib.asyncTask.BdAsyncTask
        public void onPostExecute(Bitmap bitmap) {
            super.onPostExecute((a) bitmap);
            SelectCoverModel.this.iXa.G(bitmap);
        }
    }

    /* JADX DEBUG: Don't trust debug lines info. Repeating lines: [240=4] */
    public File c(Bitmap bitmap, String str) {
        ByteArrayOutputStream byteArrayOutputStream;
        BufferedOutputStream bufferedOutputStream;
        Exception e;
        if (bitmap == null || TextUtils.isEmpty(str)) {
            return null;
        }
        File file = new File(str);
        if (file.exists()) {
            file.delete();
        }
        try {
            bufferedOutputStream = new BufferedOutputStream(new FileOutputStream(file));
        } catch (Exception e2) {
            bufferedOutputStream = null;
            e = e2;
            byteArrayOutputStream = null;
        } catch (Throwable th) {
            th = th;
            byteArrayOutputStream = null;
            bufferedOutputStream = null;
        }
        try {
            byteArrayOutputStream = new ByteArrayOutputStream();
            try {
                try {
                    bitmap.compress(Bitmap.CompressFormat.JPEG, 100, byteArrayOutputStream);
                    bufferedOutputStream.write(byteArrayOutputStream.toByteArray());
                    com.baidu.adp.lib.g.a.b((OutputStream) byteArrayOutputStream);
                    com.baidu.adp.lib.g.a.b((OutputStream) bufferedOutputStream);
                    return file;
                } catch (Exception e3) {
                    e = e3;
                    e.printStackTrace();
                    if (this.iGX != null) {
                        this.iGX.au(202, com.baidu.tieba.j.a.p(e));
                    }
                    com.baidu.adp.lib.g.a.b((OutputStream) byteArrayOutputStream);
                    com.baidu.adp.lib.g.a.b((OutputStream) bufferedOutputStream);
                    return file;
                }
            } catch (Throwable th2) {
                th = th2;
                com.baidu.adp.lib.g.a.b((OutputStream) byteArrayOutputStream);
                com.baidu.adp.lib.g.a.b((OutputStream) bufferedOutputStream);
                throw th;
            }
        } catch (Exception e4) {
            byteArrayOutputStream = null;
            e = e4;
        } catch (Throwable th3) {
            th = th3;
            byteArrayOutputStream = null;
            com.baidu.adp.lib.g.a.b((OutputStream) byteArrayOutputStream);
            com.baidu.adp.lib.g.a.b((OutputStream) bufferedOutputStream);
            throw th;
        }
    }

    /* loaded from: classes5.dex */
    public static class VideoPendantResponseMessage extends JsonHttpResponsedMessage {
        public List<PendantData> pendantDatas;

        public VideoPendantResponseMessage(int i) {
            super(i);
        }

        @Override // com.baidu.tbadk.message.http.JsonHttpResponsedMessage
        public void decodeLogicInBackGround(int i, JSONObject jSONObject) throws Exception {
            int statusCode = getStatusCode();
            int error = getError();
            if (statusCode == 200 && error == 0 && jSONObject != null) {
                String optString = jSONObject.optString("data");
                if (!TextUtils.isEmpty(optString)) {
                    String optString2 = new JSONObject(optString).optString(IntentConfig.LIST);
                    if (!TextUtils.isEmpty(optString2)) {
                        JSONArray jSONArray = new JSONArray(optString2);
                        this.pendantDatas = new ArrayList();
                        int i2 = 0;
                        while (true) {
                            int i3 = i2;
                            if (i3 < jSONArray.length()) {
                                PendantData pendantData = (PendantData) OrmObject.objectWithJsonStr(jSONArray.optString(i3), PendantData.class);
                                if (pendantData != null) {
                                    pendantData.cjH();
                                    this.pendantDatas.add(pendantData);
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

    /* loaded from: classes5.dex */
    public static class VideoCheckUegResponseMessage extends JsonHttpResponsedMessage {
        private String msg;
        private String status;
        public static String STATUS_OK = "1";
        public static String STATUS_FAIL = "2";

        public VideoCheckUegResponseMessage(int i) {
            super(i);
        }

        @Override // com.baidu.tbadk.message.http.JsonHttpResponsedMessage
        public void decodeLogicInBackGround(int i, JSONObject jSONObject) throws Exception {
            int statusCode = getStatusCode();
            int error = getError();
            if (statusCode == 200 && error == 0 && jSONObject != null) {
                String optString = jSONObject.optString("data");
                if (!TextUtils.isEmpty(optString)) {
                    JSONObject jSONObject2 = new JSONObject(optString);
                    this.status = jSONObject2.optString("status");
                    this.msg = jSONObject2.optString("words");
                }
            }
        }

        public String getStatus() {
            return this.status;
        }

        public String getMsg() {
            return this.msg;
        }
    }

    @Override // com.baidu.adp.base.BdBaseModel
    protected boolean LoadData() {
        return false;
    }

    @Override // com.baidu.adp.base.BdBaseModel
    public boolean cancelLoadData() {
        MessageManager.getInstance().unRegisterListener(this.hHZ);
        MessageManager.getInstance().unRegisterTask(CmdConfigHttp.CMD_VIDEO_TEXT_UEG);
        if (this.iXb != null) {
            this.iXb.cancel();
            return false;
        }
        return false;
    }
}
