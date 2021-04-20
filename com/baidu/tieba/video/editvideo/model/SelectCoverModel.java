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
import d.b.c.e.p.j;
import d.b.i0.t1.g;
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
    public d.b.i0.q3.j.a f21427e;

    /* renamed from: f  reason: collision with root package name */
    public d f21428f;

    /* renamed from: g  reason: collision with root package name */
    public TbPageContext f21429g;

    /* renamed from: h  reason: collision with root package name */
    public g f21430h;
    public final HttpMessageListener i;
    public final HttpMessageListener j;

    /* loaded from: classes5.dex */
    public static class VideoCheckUegResponseMessage extends JsonHttpResponsedMessage {
        public static String STATUS_FAIL = "2";
        public static String STATUS_OK = "1";
        public String msg;
        public String status;

        public VideoCheckUegResponseMessage(int i) {
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

        public VideoPendantResponseMessage(int i) {
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
                String optString2 = new JSONObject(optString).optString("list");
                if (TextUtils.isEmpty(optString2)) {
                    return;
                }
                JSONArray jSONArray = new JSONArray(optString2);
                this.pendantDatas = new ArrayList();
                for (int i2 = 0; i2 < jSONArray.length(); i2++) {
                    PendantData pendantData = (PendantData) OrmObject.objectWithJsonStr(jSONArray.optString(i2), PendantData.class);
                    if (pendantData != null) {
                        pendantData.s();
                        this.pendantDatas.add(pendantData);
                    }
                }
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
            if (httpResponsedMessage != null && httpResponsedMessage.getCmd() == 1003356 && (httpResponsedMessage instanceof VideoCheckUegResponseMessage)) {
                VideoCheckUegResponseMessage videoCheckUegResponseMessage = (VideoCheckUegResponseMessage) httpResponsedMessage;
                String status = videoCheckUegResponseMessage.getStatus();
                if (VideoCheckUegResponseMessage.STATUS_OK.equals(status)) {
                    SelectCoverModel.this.f21427e.onCheckUegSuccess();
                } else if (VideoCheckUegResponseMessage.STATUS_FAIL.equals(status)) {
                    String msg = videoCheckUegResponseMessage.getMsg();
                    if (TextUtils.isEmpty(msg)) {
                        msg = TbadkCoreApplication.getInst().getResources().getString(R.string.video_ueg_fail);
                    }
                    SelectCoverModel.this.f21427e.onCheckUegFail(msg);
                } else {
                    String errorString = httpResponsedMessage.getErrorString();
                    if (TextUtils.isEmpty(errorString)) {
                        errorString = TbadkCoreApplication.getInst().getResources().getString(R.string.video_fail);
                    }
                    SelectCoverModel.this.f21427e.onCheckUegFail(errorString);
                    if (SelectCoverModel.this.f21430h != null) {
                        SelectCoverModel.this.f21430h.a(201, errorString);
                    }
                }
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
            if (httpResponsedMessage != null && httpResponsedMessage.getCmd() == 1003377 && (httpResponsedMessage instanceof VideoPendantResponseMessage)) {
                VideoPendantResponseMessage videoPendantResponseMessage = (VideoPendantResponseMessage) httpResponsedMessage;
                if (videoPendantResponseMessage.pendantDatas == null) {
                    return;
                }
                SelectCoverModel.this.f21427e.setPendantData(videoPendantResponseMessage.pendantDatas);
            }
        }
    }

    /* loaded from: classes5.dex */
    public class c extends BdAsyncTask<Void, Integer, String> {

        /* renamed from: a  reason: collision with root package name */
        public final /* synthetic */ Bitmap f21433a;

        /* renamed from: b  reason: collision with root package name */
        public final /* synthetic */ String f21434b;

        public c(Bitmap bitmap, String str) {
            this.f21433a = bitmap;
            this.f21434b = str;
        }

        /* JADX DEBUG: Method merged with bridge method */
        @Override // com.baidu.adp.lib.asyncTask.BdAsyncTask
        /* renamed from: b */
        public String doInBackground(Void[] voidArr) {
            File x = SelectCoverModel.this.x(this.f21433a, this.f21434b);
            this.f21433a.recycle();
            return x.getAbsolutePath();
        }

        /* JADX DEBUG: Method merged with bridge method */
        @Override // com.baidu.adp.lib.asyncTask.BdAsyncTask
        public void onPostExecute(String str) {
            super.onPostExecute((c) str);
            SelectCoverModel.this.f21427e.onSaveCover(str);
        }
    }

    /* loaded from: classes5.dex */
    public class d extends BdAsyncTask<Void, Integer, Bitmap> {

        /* renamed from: a  reason: collision with root package name */
        public String f21436a;

        /* renamed from: b  reason: collision with root package name */
        public int f21437b;

        public d(String str, int i) {
            this.f21436a = str;
            this.f21437b = i;
        }

        /* JADX DEBUG: Method merged with bridge method */
        @Override // com.baidu.adp.lib.asyncTask.BdAsyncTask
        public Bitmap doInBackground(Void... voidArr) {
            Bitmap bitmap = null;
            if (TextUtils.isEmpty(this.f21436a)) {
                return null;
            }
            try {
                MediaMetadataRetriever mediaMetadataRetriever = new MediaMetadataRetriever();
                mediaMetadataRetriever.setDataSource(this.f21436a);
                bitmap = mediaMetadataRetriever.getFrameAtTime(this.f21437b * 1000);
                mediaMetadataRetriever.release();
                return bitmap;
            } catch (Exception e2) {
                e2.printStackTrace();
                if (SelectCoverModel.this.f21430h != null) {
                    SelectCoverModel.this.f21430h.a(203, d.b.i0.t1.a.a(e2));
                    return bitmap;
                }
                return bitmap;
            }
        }

        /* JADX DEBUG: Method merged with bridge method */
        @Override // com.baidu.adp.lib.asyncTask.BdAsyncTask
        public void onPostExecute(Bitmap bitmap) {
            super.onPostExecute((d) bitmap);
            SelectCoverModel.this.f21427e.onGetCoverBitmap(bitmap);
        }
    }

    public SelectCoverModel(TbPageContext tbPageContext, d.b.i0.q3.j.a aVar, g gVar) {
        super(tbPageContext);
        this.i = new a(CmdConfigHttp.CMD_VIDEO_TEXT_UEG);
        this.j = new b(CmdConfigHttp.CMD_VIDEO_COVER_PENDANT);
        this.f21429g = tbPageContext;
        this.f21427e = aVar;
        this.f21430h = gVar;
        registerTask();
        this.i.setTag(getUniqueId());
        this.i.setSelfListener(true);
        registerListener(this.i);
        this.j.setTag(getUniqueId());
        this.j.setSelfListener(true);
        registerListener(this.j);
    }

    @Override // com.baidu.adp.base.BdBaseModel
    public boolean LoadData() {
        return false;
    }

    @Override // com.baidu.adp.base.BdBaseModel
    public boolean cancelLoadData() {
        MessageManager.getInstance().unRegisterListener(this.i);
        MessageManager.getInstance().unRegisterTask(CmdConfigHttp.CMD_VIDEO_TEXT_UEG);
        d dVar = this.f21428f;
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

    public void u(String str) {
        HttpMessage httpMessage = new HttpMessage(CmdConfigHttp.CMD_VIDEO_TEXT_UEG);
        httpMessage.addParam("text", str);
        sendMessage(httpMessage);
    }

    public void v() {
        if (!j.z()) {
            this.f21429g.showToast(R.string.no_network);
        } else {
            sendMessage(new HttpMessage(CmdConfigHttp.CMD_VIDEO_COVER_PENDANT));
        }
    }

    public void w(Bitmap bitmap, String str) {
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
    public File x(Bitmap bitmap, String str) {
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
                    d.b.c.e.m.a.d(r2);
                    d.b.c.e.m.a.d(bufferedOutputStream);
                } catch (Exception e2) {
                    e = e2;
                    bufferedOutputStream2 = bufferedOutputStream;
                    r2 = r2;
                    try {
                        e.printStackTrace();
                        if (this.f21430h != null) {
                            this.f21430h.a(202, d.b.i0.t1.a.a(e));
                        }
                        d.b.c.e.m.a.d(r2);
                        d.b.c.e.m.a.d(bufferedOutputStream2);
                        return file;
                    } catch (Throwable th) {
                        th = th;
                        bufferedOutputStream = bufferedOutputStream2;
                        bufferedOutputStream2 = r2;
                        d.b.c.e.m.a.d(bufferedOutputStream2);
                        d.b.c.e.m.a.d(bufferedOutputStream);
                        throw th;
                    }
                } catch (Throwable th2) {
                    th = th2;
                    bufferedOutputStream2 = r2;
                    d.b.c.e.m.a.d(bufferedOutputStream2);
                    d.b.c.e.m.a.d(bufferedOutputStream);
                    throw th;
                }
            } catch (Exception e3) {
                e = e3;
                r2 = 0;
            } catch (Throwable th3) {
                th = th3;
                d.b.c.e.m.a.d(bufferedOutputStream2);
                d.b.c.e.m.a.d(bufferedOutputStream);
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

    public void y(String str, int i) {
        d dVar = new d(str, i);
        this.f21428f = dVar;
        dVar.execute(new Void[0]);
    }
}
