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
import com.baidu.tbadk.TbConfig;
import com.baidu.tbadk.TbPageContext;
import com.baidu.tbadk.core.TbadkCoreApplication;
import com.baidu.tbadk.core.frameworkData.CmdConfigHttp;
import com.baidu.tbadk.message.http.JsonHttpResponsedMessage;
import com.baidu.tbadk.task.TbHttpMessageTask;
import com.baidu.tieba.R;
import com.baidu.tieba.video.editvideo.data.PendantData;
import d.a.c.e.p.j;
import d.a.n0.u1.g;
import java.io.BufferedOutputStream;
import java.io.ByteArrayOutputStream;
import java.io.File;
import java.io.FileOutputStream;
import java.util.ArrayList;
import java.util.List;
import org.json.JSONArray;
import org.json.JSONObject;
/* loaded from: classes5.dex */
public class SelectCoverModel extends BdBaseModel {

    /* renamed from: e  reason: collision with root package name */
    public d.a.n0.r3.i.a f21308e;

    /* renamed from: f  reason: collision with root package name */
    public d f21309f;

    /* renamed from: g  reason: collision with root package name */
    public TbPageContext f21310g;

    /* renamed from: h  reason: collision with root package name */
    public g f21311h;

    /* renamed from: i  reason: collision with root package name */
    public final HttpMessageListener f21312i;
    public final HttpMessageListener j;

    /* loaded from: classes5.dex */
    public static class VideoCheckUegResponseMessage extends JsonHttpResponsedMessage {
        public static String STATUS_FAIL = "2";
        public static String STATUS_OK = "1";
        public String msg;
        public String status;

        public VideoCheckUegResponseMessage(int i2) {
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
                JSONObject jSONObject2 = new JSONObject(optString);
                this.status = jSONObject2.optString("status");
                this.msg = jSONObject2.optString("words");
            }
        }

        public String getMsg() {
            return this.msg;
        }

        public String getStatus() {
            return this.status;
        }
    }

    /* loaded from: classes5.dex */
    public static class VideoPendantResponseMessage extends JsonHttpResponsedMessage {
        public List<PendantData> pendantDatas;

        public VideoPendantResponseMessage(int i2) {
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
                String optString2 = new JSONObject(optString).optString("list");
                if (TextUtils.isEmpty(optString2)) {
                    return;
                }
                JSONArray jSONArray = new JSONArray(optString2);
                this.pendantDatas = new ArrayList();
                for (int i3 = 0; i3 < jSONArray.length(); i3++) {
                    PendantData pendantData = (PendantData) OrmObject.objectWithJsonStr(jSONArray.optString(i3), PendantData.class);
                    if (pendantData != null) {
                        pendantData.w();
                        this.pendantDatas.add(pendantData);
                    }
                }
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
            if (httpResponsedMessage != null && httpResponsedMessage.getCmd() == 1003356 && (httpResponsedMessage instanceof VideoCheckUegResponseMessage)) {
                VideoCheckUegResponseMessage videoCheckUegResponseMessage = (VideoCheckUegResponseMessage) httpResponsedMessage;
                String status = videoCheckUegResponseMessage.getStatus();
                if (VideoCheckUegResponseMessage.STATUS_OK.equals(status)) {
                    SelectCoverModel.this.f21308e.onCheckUegSuccess();
                } else if (VideoCheckUegResponseMessage.STATUS_FAIL.equals(status)) {
                    String msg = videoCheckUegResponseMessage.getMsg();
                    if (TextUtils.isEmpty(msg)) {
                        msg = TbadkCoreApplication.getInst().getResources().getString(R.string.video_ueg_fail);
                    }
                    SelectCoverModel.this.f21308e.onCheckUegFail(msg);
                } else {
                    String errorString = httpResponsedMessage.getErrorString();
                    if (TextUtils.isEmpty(errorString)) {
                        errorString = TbadkCoreApplication.getInst().getResources().getString(R.string.video_fail);
                    }
                    SelectCoverModel.this.f21308e.onCheckUegFail(errorString);
                    if (SelectCoverModel.this.f21311h != null) {
                        SelectCoverModel.this.f21311h.a(201, errorString);
                    }
                }
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
            if (httpResponsedMessage != null && httpResponsedMessage.getCmd() == 1003377 && (httpResponsedMessage instanceof VideoPendantResponseMessage)) {
                VideoPendantResponseMessage videoPendantResponseMessage = (VideoPendantResponseMessage) httpResponsedMessage;
                if (videoPendantResponseMessage.pendantDatas == null) {
                    return;
                }
                SelectCoverModel.this.f21308e.setPendantData(videoPendantResponseMessage.pendantDatas);
            }
        }
    }

    /* loaded from: classes5.dex */
    public class c extends BdAsyncTask<Void, Integer, String> {

        /* renamed from: a  reason: collision with root package name */
        public final /* synthetic */ Bitmap f21315a;

        /* renamed from: b  reason: collision with root package name */
        public final /* synthetic */ String f21316b;

        public c(Bitmap bitmap, String str) {
            this.f21315a = bitmap;
            this.f21316b = str;
        }

        /* JADX DEBUG: Method merged with bridge method */
        @Override // com.baidu.adp.lib.asyncTask.BdAsyncTask
        /* renamed from: b */
        public String doInBackground(Void[] voidArr) {
            File B = SelectCoverModel.this.B(this.f21315a, this.f21316b);
            this.f21315a.recycle();
            return B.getAbsolutePath();
        }

        /* JADX DEBUG: Method merged with bridge method */
        @Override // com.baidu.adp.lib.asyncTask.BdAsyncTask
        public void onPostExecute(String str) {
            super.onPostExecute((c) str);
            SelectCoverModel.this.f21308e.onSaveCover(str);
        }
    }

    /* loaded from: classes5.dex */
    public class d extends BdAsyncTask<Void, Integer, Bitmap> {

        /* renamed from: a  reason: collision with root package name */
        public String f21318a;

        /* renamed from: b  reason: collision with root package name */
        public int f21319b;

        public d(String str, int i2) {
            this.f21318a = str;
            this.f21319b = i2;
        }

        /* JADX DEBUG: Method merged with bridge method */
        @Override // com.baidu.adp.lib.asyncTask.BdAsyncTask
        public Bitmap doInBackground(Void... voidArr) {
            Bitmap bitmap = null;
            if (TextUtils.isEmpty(this.f21318a)) {
                return null;
            }
            try {
                MediaMetadataRetriever mediaMetadataRetriever = new MediaMetadataRetriever();
                mediaMetadataRetriever.setDataSource(this.f21318a);
                bitmap = mediaMetadataRetriever.getFrameAtTime(this.f21319b * 1000);
                mediaMetadataRetriever.release();
                return bitmap;
            } catch (Exception e2) {
                e2.printStackTrace();
                if (SelectCoverModel.this.f21311h != null) {
                    SelectCoverModel.this.f21311h.a(203, d.a.n0.u1.a.a(e2));
                    return bitmap;
                }
                return bitmap;
            }
        }

        /* JADX DEBUG: Method merged with bridge method */
        @Override // com.baidu.adp.lib.asyncTask.BdAsyncTask
        public void onPostExecute(Bitmap bitmap) {
            super.onPostExecute((d) bitmap);
            SelectCoverModel.this.f21308e.onGetCoverBitmap(bitmap);
        }
    }

    public SelectCoverModel(TbPageContext tbPageContext, d.a.n0.r3.i.a aVar, g gVar) {
        super(tbPageContext);
        this.f21312i = new a(CmdConfigHttp.CMD_VIDEO_TEXT_UEG);
        this.j = new b(CmdConfigHttp.CMD_VIDEO_COVER_PENDANT);
        this.f21310g = tbPageContext;
        this.f21308e = aVar;
        this.f21311h = gVar;
        registerTask();
        this.f21312i.setTag(getUniqueId());
        this.f21312i.setSelfListener(true);
        registerListener(this.f21312i);
        this.j.setTag(getUniqueId());
        this.j.setSelfListener(true);
        registerListener(this.j);
    }

    public void A(Bitmap bitmap, String str) {
        if (bitmap == null || TextUtils.isEmpty(str)) {
            return;
        }
        new c(bitmap, str).execute(new Void[0]);
    }

    /* JADX DEBUG: Failed to insert an additional move for type inference into block B:14:0x003d */
    /* JADX DEBUG: Failed to insert an additional move for type inference into block B:16:0x003f */
    /* JADX WARN: Multi-variable type inference failed */
    /* JADX WARN: Type inference failed for: r2v0 */
    /* JADX WARN: Type inference failed for: r2v1 */
    /* JADX WARN: Type inference failed for: r2v2, types: [java.io.OutputStream] */
    /* JADX WARN: Type inference failed for: r2v4 */
    /* JADX WARN: Type inference failed for: r2v5 */
    /* JADX WARN: Type inference failed for: r2v6, types: [java.io.OutputStream, java.io.ByteArrayOutputStream] */
    /* JADX WARN: Type inference failed for: r2v7 */
    /* JADX WARN: Type inference failed for: r5v0, types: [android.graphics.Bitmap] */
    public File B(Bitmap bitmap, String str) {
        BufferedOutputStream bufferedOutputStream;
        ?? r2;
        BufferedOutputStream bufferedOutputStream2 = null;
        if (bitmap == 0 || TextUtils.isEmpty(str)) {
            return null;
        }
        File file = new File(str);
        if (file.exists()) {
            file.delete();
        }
        try {
            bufferedOutputStream = new BufferedOutputStream(new FileOutputStream(file));
            try {
                r2 = new ByteArrayOutputStream();
                try {
                    bitmap.compress(Bitmap.CompressFormat.JPEG, 100, r2);
                    bufferedOutputStream.write(r2.toByteArray());
                    d.a.c.e.m.a.d(r2);
                    d.a.c.e.m.a.d(bufferedOutputStream);
                } catch (Exception e2) {
                    e = e2;
                    bufferedOutputStream2 = bufferedOutputStream;
                    r2 = r2;
                    try {
                        e.printStackTrace();
                        if (this.f21311h != null) {
                            this.f21311h.a(202, d.a.n0.u1.a.a(e));
                        }
                        d.a.c.e.m.a.d(r2);
                        d.a.c.e.m.a.d(bufferedOutputStream2);
                        return file;
                    } catch (Throwable th) {
                        th = th;
                        bufferedOutputStream = bufferedOutputStream2;
                        bufferedOutputStream2 = r2;
                        d.a.c.e.m.a.d(bufferedOutputStream2);
                        d.a.c.e.m.a.d(bufferedOutputStream);
                        throw th;
                    }
                } catch (Throwable th2) {
                    th = th2;
                    bufferedOutputStream2 = r2;
                    d.a.c.e.m.a.d(bufferedOutputStream2);
                    d.a.c.e.m.a.d(bufferedOutputStream);
                    throw th;
                }
            } catch (Exception e3) {
                e = e3;
                r2 = 0;
            } catch (Throwable th3) {
                th = th3;
                d.a.c.e.m.a.d(bufferedOutputStream2);
                d.a.c.e.m.a.d(bufferedOutputStream);
                throw th;
            }
        } catch (Exception e4) {
            e = e4;
            r2 = 0;
        } catch (Throwable th4) {
            th = th4;
            bufferedOutputStream = null;
        }
        return file;
    }

    public void C(String str, int i2) {
        d dVar = new d(str, i2);
        this.f21309f = dVar;
        dVar.execute(new Void[0]);
    }

    @Override // com.baidu.adp.base.BdBaseModel
    public boolean LoadData() {
        return false;
    }

    @Override // com.baidu.adp.base.BdBaseModel
    public boolean cancelLoadData() {
        MessageManager.getInstance().unRegisterListener(this.f21312i);
        MessageManager.getInstance().unRegisterTask(CmdConfigHttp.CMD_VIDEO_TEXT_UEG);
        d dVar = this.f21309f;
        if (dVar != null) {
            dVar.cancel();
            return false;
        }
        return false;
    }

    public final void registerTask() {
        TbHttpMessageTask tbHttpMessageTask = new TbHttpMessageTask(CmdConfigHttp.CMD_VIDEO_TEXT_UEG, TbConfig.SERVER_ADDRESS + "c/f/video/next");
        tbHttpMessageTask.setResponsedClass(VideoCheckUegResponseMessage.class);
        MessageManager.getInstance().registerTask(tbHttpMessageTask);
        TbHttpMessageTask tbHttpMessageTask2 = new TbHttpMessageTask(CmdConfigHttp.CMD_VIDEO_COVER_PENDANT, TbConfig.SERVER_ADDRESS + "c/f/video/pendant");
        tbHttpMessageTask2.setResponsedClass(VideoPendantResponseMessage.class);
        MessageManager.getInstance().registerTask(tbHttpMessageTask2);
    }

    public void y(String str) {
        HttpMessage httpMessage = new HttpMessage(CmdConfigHttp.CMD_VIDEO_TEXT_UEG);
        httpMessage.addParam("text", str);
        sendMessage(httpMessage);
    }

    public void z() {
        if (!j.z()) {
            this.f21310g.showToast(R.string.no_network);
        } else {
            sendMessage(new HttpMessage(CmdConfigHttp.CMD_VIDEO_COVER_PENDANT));
        }
    }
}
