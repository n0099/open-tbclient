package com.baidu.tieba.pbextra.emotion.model;

import android.graphics.Bitmap;
import android.os.Handler;
import android.os.Looper;
import android.os.Message;
import android.text.TextUtils;
import com.baidu.adp.base.BdBaseModel;
import com.baidu.adp.framework.MessageManager;
import com.baidu.adp.framework.listener.HttpMessageListener;
import com.baidu.adp.framework.message.HttpMessage;
import com.baidu.adp.framework.message.HttpResponsedMessage;
import com.baidu.adp.lib.asyncTask.BdAsyncTask;
import com.baidu.tbadk.TbConfig;
import com.baidu.tbadk.core.frameworkData.CmdConfigHttp;
import com.baidu.tbadk.img.ImageFileInfo;
import com.baidu.tbadk.img.ImageUploadResult;
import com.baidu.tbadk.task.TbHttpMessageTask;
import com.baidu.tieba.R;
import com.baidu.tieba.pbextra.emotion.EmotionEditActivity;
import java.io.BufferedOutputStream;
import java.io.ByteArrayOutputStream;
import java.io.File;
import java.io.FileOutputStream;
import java.io.IOException;
/* loaded from: classes3.dex */
public class EmotionEditModel extends BdBaseModel {

    /* renamed from: e  reason: collision with root package name */
    public e f20377e;

    /* renamed from: f  reason: collision with root package name */
    public d.a.i0.b0.f f20378f;

    /* renamed from: g  reason: collision with root package name */
    public f f20379g;

    /* renamed from: h  reason: collision with root package name */
    public EmotionEditActivity f20380h;

    /* renamed from: i  reason: collision with root package name */
    public boolean f20381i;
    public Thread j;
    public Handler k = new c(Looper.getMainLooper());
    public final HttpMessageListener l = new d(CmdConfigHttp.CMD_EMOTION_EDIT_TEXT_UEG);

    /* loaded from: classes3.dex */
    public class a extends BdAsyncTask<Void, Integer, String> {

        /* renamed from: a  reason: collision with root package name */
        public final /* synthetic */ Bitmap f20382a;

        /* renamed from: b  reason: collision with root package name */
        public final /* synthetic */ String f20383b;

        public a(Bitmap bitmap, String str) {
            this.f20382a = bitmap;
            this.f20383b = str;
        }

        /* JADX DEBUG: Method merged with bridge method */
        @Override // com.baidu.adp.lib.asyncTask.BdAsyncTask
        /* renamed from: b */
        public String doInBackground(Void[] voidArr) {
            if (EmotionEditModel.this.f20381i) {
                return null;
            }
            File F = EmotionEditModel.this.F(this.f20382a, this.f20383b);
            this.f20382a.recycle();
            return F.getAbsolutePath();
        }

        /* JADX DEBUG: Method merged with bridge method */
        @Override // com.baidu.adp.lib.asyncTask.BdAsyncTask
        public void onPostExecute(String str) {
            super.onPostExecute((a) str);
            EmotionEditModel.this.f20377e.onSaveImageSuccess(str);
        }
    }

    /* loaded from: classes3.dex */
    public class b implements Runnable {

        /* renamed from: e  reason: collision with root package name */
        public final /* synthetic */ d.a.c.d.b f20385e;

        public b(d.a.c.d.b bVar) {
            this.f20385e = bVar;
        }

        @Override // java.lang.Runnable
        public void run() {
            try {
                if (EmotionEditModel.this.f20381i) {
                    return;
                }
                ByteArrayOutputStream byteArrayOutputStream = new ByteArrayOutputStream();
                d.a.j0.e2.b.a.a aVar = new d.a.j0.e2.b.a.a();
                aVar.i(byteArrayOutputStream);
                aVar.g(0);
                Bitmap createBitmap = Bitmap.createBitmap(this.f20385e.getWidth(), this.f20385e.getHeight(), Bitmap.Config.ARGB_8888);
                String str = d.a.c.e.p.f.f39949b + "/" + TbConfig.getTempDirName() + "/emotion.gif";
                Bitmap bitmap = null;
                int i2 = 0;
                while (true) {
                    if (i2 >= this.f20385e.getFrameCount()) {
                        break;
                    } else if (EmotionEditModel.this.f20381i) {
                        EmotionEditModel.this.C(createBitmap, bitmap);
                        break;
                    } else {
                        this.f20385e.c(i2);
                        this.f20385e.a(createBitmap, null);
                        bitmap = EmotionEditModel.this.f20380h.addTextToImage(createBitmap);
                        aVar.a(bitmap);
                        int b2 = this.f20385e.b(i2);
                        if (b2 == 100) {
                            b2 = 0;
                        }
                        if (b2 > 0) {
                            Thread.sleep(b2 / 10);
                        }
                        i2++;
                    }
                }
                if (EmotionEditModel.this.f20381i) {
                    EmotionEditModel.this.C(createBitmap, bitmap);
                    return;
                }
                aVar.d();
                File G = EmotionEditModel.this.G(byteArrayOutputStream, str);
                EmotionEditModel.this.C(createBitmap, bitmap);
                Message obtain = Message.obtain();
                obtain.what = 0;
                obtain.obj = G.getAbsolutePath();
                EmotionEditModel.this.k.sendMessage(obtain);
            } catch (InterruptedException e2) {
                e2.printStackTrace();
            }
        }
    }

    /* loaded from: classes3.dex */
    public class c extends Handler {
        public c(Looper looper) {
            super(looper);
        }

        @Override // android.os.Handler
        public void handleMessage(Message message) {
            super.handleMessage(message);
            if (message != null) {
                try {
                    EmotionEditModel.this.f20377e.onSaveImageSuccess((String) message.obj);
                } catch (Exception e2) {
                    e2.printStackTrace();
                }
            }
        }
    }

    /* loaded from: classes3.dex */
    public class d extends HttpMessageListener {
        public d(int i2) {
            super(i2);
        }

        /* JADX DEBUG: Method merged with bridge method */
        @Override // com.baidu.adp.framework.listener.MessageListener
        public void onMessage(HttpResponsedMessage httpResponsedMessage) {
            if (httpResponsedMessage != null && httpResponsedMessage.getCmd() == 1003348 && (httpResponsedMessage instanceof EmotionCheckUegResponseMessage)) {
                EmotionCheckUegResponseMessage emotionCheckUegResponseMessage = (EmotionCheckUegResponseMessage) httpResponsedMessage;
                String status = emotionCheckUegResponseMessage.getStatus();
                if (EmotionCheckUegResponseMessage.STATUS_OK.equals(status)) {
                    EmotionEditModel.this.f20377e.onCheckUegSuccess();
                } else if (EmotionCheckUegResponseMessage.STATUS_FAIL.equals(status)) {
                    String msg = emotionCheckUegResponseMessage.getMsg();
                    if (TextUtils.isEmpty(msg)) {
                        msg = EmotionEditModel.this.f20380h.getPageContext().getPageActivity().getResources().getString(R.string.emotion_edit_ueg_fail);
                    }
                    EmotionEditModel.this.f20377e.onCheckUegFail(msg);
                } else {
                    String errorString = httpResponsedMessage.getErrorString();
                    if (TextUtils.isEmpty(errorString)) {
                        errorString = EmotionEditModel.this.f20380h.getPageContext().getPageActivity().getResources().getString(R.string.emotion_edit_fail);
                    }
                    EmotionEditModel.this.f20377e.onCheckUegFail(errorString);
                }
            }
        }
    }

    /* loaded from: classes3.dex */
    public interface e {
        void onCheckUegFail(String str);

        void onCheckUegSuccess();

        void onSaveImageSuccess(String str);

        void onUploadImageSuccess(ImageUploadResult imageUploadResult);
    }

    /* loaded from: classes3.dex */
    public class f extends BdAsyncTask<String, Integer, ImageUploadResult> {

        /* renamed from: a  reason: collision with root package name */
        public ImageFileInfo f20389a;

        /* renamed from: b  reason: collision with root package name */
        public boolean f20390b;

        public f(ImageFileInfo imageFileInfo, boolean z) {
            this.f20389a = imageFileInfo;
            this.f20390b = z;
        }

        /* JADX DEBUG: Method merged with bridge method */
        @Override // com.baidu.adp.lib.asyncTask.BdAsyncTask
        /* renamed from: b */
        public ImageUploadResult doInBackground(String... strArr) {
            EmotionEditModel.this.f20378f = new d.a.i0.b0.f(null);
            return EmotionEditModel.this.f20378f.h(this.f20389a, this.f20390b, false);
        }

        /* JADX DEBUG: Method merged with bridge method */
        @Override // com.baidu.adp.lib.asyncTask.BdAsyncTask
        /* renamed from: c */
        public void onPostExecute(ImageUploadResult imageUploadResult) {
            EmotionEditModel.this.f20377e.onUploadImageSuccess(imageUploadResult);
        }
    }

    public EmotionEditModel(EmotionEditActivity emotionEditActivity, e eVar) {
        this.f20380h = emotionEditActivity;
        this.f20377e = eVar;
        registerTask();
        this.l.setTag(getUniqueId());
        this.l.setSelfListener(true);
        registerListener(this.l);
    }

    public void A(String str) {
        HttpMessage httpMessage = new HttpMessage(CmdConfigHttp.CMD_EMOTION_EDIT_TEXT_UEG);
        httpMessage.addParam("text", str);
        sendMessage(httpMessage);
    }

    public boolean B() {
        return this.f20381i;
    }

    public final void C(Bitmap bitmap, Bitmap bitmap2) {
        if (bitmap != null && !bitmap.isRecycled()) {
            bitmap.recycle();
        }
        if (bitmap2 == null || bitmap2.isRecycled()) {
            return;
        }
        bitmap2.recycle();
    }

    public void D(d.a.c.d.b bVar) {
        if (bVar == null) {
            return;
        }
        Thread thread = this.j;
        if (thread == null || !thread.isAlive()) {
            Thread thread2 = new Thread(new b(bVar));
            this.j = thread2;
            thread2.start();
        }
    }

    public void E(Bitmap bitmap, String str) {
        if (bitmap == null || TextUtils.isEmpty(str)) {
            return;
        }
        new a(bitmap, str).execute(new Void[0]);
    }

    /* JADX DEBUG: Failed to insert an additional move for type inference into block B:19:0x0042 */
    /* JADX DEBUG: Failed to insert an additional move for type inference into block B:31:0x0058 */
    /* JADX DEBUG: Failed to insert an additional move for type inference into block B:41:? */
    /* JADX DEBUG: Failed to insert an additional move for type inference into block B:42:0x0057 */
    /* JADX DEBUG: Failed to insert an additional move for type inference into block B:43:0x0018 */
    /* JADX DEBUG: Multi-variable search result rejected for r0v9, resolved type: android.graphics.Bitmap$CompressFormat */
    /* JADX DEBUG: Multi-variable search result rejected for r6v11, resolved type: java.io.BufferedOutputStream */
    /* JADX DEBUG: Multi-variable search result rejected for r6v2, resolved type: java.io.BufferedOutputStream */
    /* JADX DEBUG: Multi-variable search result rejected for r6v3, resolved type: java.io.BufferedOutputStream */
    /* JADX DEBUG: Multi-variable search result rejected for r6v5, resolved type: java.io.BufferedOutputStream */
    /* JADX DEBUG: Multi-variable search result rejected for r6v6, resolved type: java.io.BufferedOutputStream */
    /* JADX DEBUG: Multi-variable search result rejected for r6v8, resolved type: java.io.BufferedOutputStream */
    /* JADX DEBUG: Multi-variable search result rejected for r6v9, resolved type: java.io.BufferedOutputStream */
    /* JADX WARN: Multi-variable type inference failed */
    /* JADX WARN: Type inference failed for: r6v10 */
    /* JADX WARN: Type inference failed for: r6v12 */
    /* JADX WARN: Type inference failed for: r6v13 */
    /* JADX WARN: Type inference failed for: r6v4 */
    public File F(Bitmap bitmap, String str) {
        ByteArrayOutputStream byteArrayOutputStream;
        ByteArrayOutputStream byteArrayOutputStream2 = null;
        if (bitmap == null || TextUtils.isEmpty(str)) {
            return null;
        }
        File file = new File(str);
        BufferedOutputStream exists = file.exists();
        if (exists) {
            file.delete();
        }
        try {
            try {
                exists = new BufferedOutputStream(new FileOutputStream(file));
                try {
                    try {
                        byteArrayOutputStream = new ByteArrayOutputStream();
                    } catch (Throwable th) {
                        th = th;
                    }
                } catch (Exception e2) {
                    e = e2;
                }
            } catch (Exception e3) {
                e3.printStackTrace();
            }
            try {
                Bitmap.CompressFormat compressFormat = Bitmap.CompressFormat.PNG;
                bitmap.compress(compressFormat, 100, byteArrayOutputStream);
                exists.write(byteArrayOutputStream.toByteArray());
                byteArrayOutputStream.close();
                exists.close();
                byteArrayOutputStream2 = compressFormat;
                exists = exists;
            } catch (Exception e4) {
                e = e4;
                byteArrayOutputStream2 = byteArrayOutputStream;
                e.printStackTrace();
                byteArrayOutputStream2.close();
                exists.close();
                byteArrayOutputStream2 = byteArrayOutputStream2;
                exists = exists;
                return file;
            } catch (Throwable th2) {
                th = th2;
                byteArrayOutputStream2 = byteArrayOutputStream;
                try {
                    byteArrayOutputStream2.close();
                    exists.close();
                } catch (Exception e5) {
                    e5.printStackTrace();
                }
                throw th;
            }
        } catch (Exception e6) {
            e = e6;
            exists = 0;
        } catch (Throwable th3) {
            th = th3;
            exists = 0;
        }
        return file;
    }

    public File G(ByteArrayOutputStream byteArrayOutputStream, String str) {
        FileOutputStream fileOutputStream;
        FileOutputStream fileOutputStream2 = null;
        if (byteArrayOutputStream == null || TextUtils.isEmpty(str)) {
            return null;
        }
        File file = new File(str);
        if (file.exists()) {
            file.delete();
        }
        try {
            try {
                try {
                    fileOutputStream = new FileOutputStream(str);
                } catch (Exception e2) {
                    e2.printStackTrace();
                }
            } catch (Throwable th) {
                th = th;
            }
        } catch (IOException e3) {
            e = e3;
        }
        try {
            byteArrayOutputStream.writeTo(fileOutputStream);
            byteArrayOutputStream.flush();
            fileOutputStream.flush();
            byteArrayOutputStream.close();
            fileOutputStream.close();
        } catch (IOException e4) {
            e = e4;
            fileOutputStream2 = fileOutputStream;
            e.printStackTrace();
            byteArrayOutputStream.close();
            fileOutputStream2.close();
            return file;
        } catch (Throwable th2) {
            th = th2;
            fileOutputStream2 = fileOutputStream;
            try {
                byteArrayOutputStream.close();
                fileOutputStream2.close();
            } catch (Exception e5) {
                e5.printStackTrace();
            }
            throw th;
        }
        return file;
    }

    public void H(boolean z) {
        this.f20381i = z;
        if (z) {
            z();
        }
    }

    public void I(String str, boolean z) {
        if (TextUtils.isEmpty(str)) {
            return;
        }
        ImageFileInfo imageFileInfo = new ImageFileInfo();
        imageFileInfo.setFilePath(str);
        f fVar = new f(imageFileInfo, z);
        this.f20379g = fVar;
        fVar.execute(new String[0]);
    }

    @Override // com.baidu.adp.base.BdBaseModel
    public boolean LoadData() {
        return false;
    }

    @Override // com.baidu.adp.base.BdBaseModel
    public boolean cancelLoadData() {
        MessageManager.getInstance().unRegisterListener(this.l);
        MessageManager.getInstance().unRegisterTask(CmdConfigHttp.CMD_EMOTION_EDIT_TEXT_UEG);
        z();
        return false;
    }

    public final void registerTask() {
        TbHttpMessageTask tbHttpMessageTask = new TbHttpMessageTask(CmdConfigHttp.CMD_EMOTION_EDIT_TEXT_UEG, TbConfig.SERVER_ADDRESS + "c/e/meme/checkUegStatus");
        tbHttpMessageTask.setResponsedClass(EmotionCheckUegResponseMessage.class);
        MessageManager.getInstance().registerTask(tbHttpMessageTask);
    }

    public final void z() {
        d.a.i0.b0.f fVar = this.f20378f;
        if (fVar != null) {
            fVar.a();
        }
        f fVar2 = this.f20379g;
        if (fVar2 != null) {
            fVar2.cancel();
        }
        Thread thread = this.j;
        if (thread != null) {
            thread.interrupt();
        }
        this.f20381i = true;
    }
}
