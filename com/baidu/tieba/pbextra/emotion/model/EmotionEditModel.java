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
import com.baidu.live.tbadk.data.Config;
import com.baidu.tbadk.TbConfig;
import com.baidu.tbadk.img.ImageFileInfo;
import com.baidu.tbadk.img.ImageUploadResult;
import com.baidu.tbadk.img.f;
import com.baidu.tbadk.task.TbHttpMessageTask;
import com.baidu.tieba.R;
import com.baidu.tieba.pbextra.emotion.EmotionEditActivity;
import java.io.BufferedOutputStream;
import java.io.ByteArrayOutputStream;
import java.io.File;
import java.io.FileOutputStream;
import java.io.IOException;
/* loaded from: classes2.dex */
public class EmotionEditModel extends BdBaseModel {
    private boolean iTZ;
    private a mlC;
    private f mlD;
    private b mlE;
    private EmotionEditActivity mlF;
    private Thread mlG;
    private Handler mlH = new Handler(Looper.getMainLooper()) { // from class: com.baidu.tieba.pbextra.emotion.model.EmotionEditModel.3
        @Override // android.os.Handler
        public void handleMessage(Message message) {
            super.handleMessage(message);
            if (message != null) {
                try {
                    EmotionEditModel.this.mlC.Qw((String) message.obj);
                } catch (Exception e) {
                    e.printStackTrace();
                }
            }
        }
    };
    private final HttpMessageListener mlI = new HttpMessageListener(1003348) { // from class: com.baidu.tieba.pbextra.emotion.model.EmotionEditModel.4
        /* JADX DEBUG: Method merged with bridge method */
        @Override // com.baidu.adp.framework.listener.MessageListener
        public void onMessage(HttpResponsedMessage httpResponsedMessage) {
            if (httpResponsedMessage != null && httpResponsedMessage.getCmd() == 1003348 && (httpResponsedMessage instanceof EmotionCheckUegResponseMessage)) {
                String status = ((EmotionCheckUegResponseMessage) httpResponsedMessage).getStatus();
                if (EmotionCheckUegResponseMessage.STATUS_OK.equals(status)) {
                    EmotionEditModel.this.mlC.dxp();
                } else if (EmotionCheckUegResponseMessage.STATUS_FAIL.equals(status)) {
                    String msg = ((EmotionCheckUegResponseMessage) httpResponsedMessage).getMsg();
                    if (TextUtils.isEmpty(msg)) {
                        msg = EmotionEditModel.this.mlF.getPageContext().getPageActivity().getResources().getString(R.string.emotion_edit_ueg_fail);
                    }
                    EmotionEditModel.this.mlC.Qv(msg);
                } else {
                    String errorString = httpResponsedMessage.getErrorString();
                    if (TextUtils.isEmpty(errorString)) {
                        errorString = EmotionEditModel.this.mlF.getPageContext().getPageActivity().getResources().getString(R.string.emotion_edit_fail);
                    }
                    EmotionEditModel.this.mlC.Qv(errorString);
                }
            }
        }
    };

    /* loaded from: classes2.dex */
    public interface a {
        void Qv(String str);

        void Qw(String str);

        void c(ImageUploadResult imageUploadResult);

        void dxp();
    }

    public EmotionEditModel(EmotionEditActivity emotionEditActivity, a aVar) {
        this.mlF = emotionEditActivity;
        this.mlC = aVar;
        registerTask();
        this.mlI.setTag(getUniqueId());
        this.mlI.setSelfListener(true);
        registerListener(this.mlI);
    }

    public void wo(boolean z) {
        this.iTZ = z;
        if (this.iTZ) {
            dxz();
        }
    }

    public boolean isCancel() {
        return this.iTZ;
    }

    public void Qx(String str) {
        HttpMessage httpMessage = new HttpMessage(1003348);
        httpMessage.addParam("text", str);
        sendMessage(httpMessage);
    }

    public void b(final Bitmap bitmap, final String str) {
        if (bitmap != null && !TextUtils.isEmpty(str)) {
            new BdAsyncTask<Void, Integer, String>() { // from class: com.baidu.tieba.pbextra.emotion.model.EmotionEditModel.1
                /* JADX DEBUG: Method merged with bridge method */
                /* JADX INFO: Access modifiers changed from: protected */
                @Override // com.baidu.adp.lib.asyncTask.BdAsyncTask
                public String doInBackground(Void[] voidArr) {
                    if (EmotionEditModel.this.iTZ) {
                        return null;
                    }
                    File c = EmotionEditModel.this.c(bitmap, str);
                    bitmap.recycle();
                    return c.getAbsolutePath();
                }

                /* JADX DEBUG: Method merged with bridge method */
                /* JADX INFO: Access modifiers changed from: protected */
                @Override // com.baidu.adp.lib.asyncTask.BdAsyncTask
                public void onPostExecute(String str2) {
                    super.onPostExecute((AnonymousClass1) str2);
                    EmotionEditModel.this.mlC.Qw(str2);
                }
            }.execute(new Void[0]);
        }
    }

    public void a(final com.baidu.adp.gif.b bVar) {
        if (bVar != null) {
            if (this.mlG == null || !this.mlG.isAlive()) {
                this.mlG = new Thread(new Runnable() { // from class: com.baidu.tieba.pbextra.emotion.model.EmotionEditModel.2
                    @Override // java.lang.Runnable
                    public void run() {
                        Bitmap bitmap = null;
                        try {
                            if (!EmotionEditModel.this.iTZ) {
                                ByteArrayOutputStream byteArrayOutputStream = new ByteArrayOutputStream();
                                com.baidu.tieba.pbextra.emotion.model.a aVar = new com.baidu.tieba.pbextra.emotion.model.a();
                                aVar.b(byteArrayOutputStream);
                                aVar.HR(0);
                                Bitmap createBitmap = Bitmap.createBitmap(bVar.getWidth(), bVar.getHeight(), Bitmap.Config.ARGB_8888);
                                String str = com.baidu.adp.lib.util.f.EXTERNAL_STORAGE_DIRECTORY + "/" + TbConfig.getTempDirName() + "/emotion.gif";
                                int i = 0;
                                while (true) {
                                    if (i >= bVar.getFrameCount()) {
                                        break;
                                    } else if (EmotionEditModel.this.iTZ) {
                                        EmotionEditModel.this.b(createBitmap, bitmap);
                                        break;
                                    } else {
                                        bVar.af(i);
                                        bVar.a(createBitmap, null);
                                        bitmap = EmotionEditModel.this.mlF.G(createBitmap);
                                        aVar.H(bitmap);
                                        int ag = bVar.ag(i);
                                        if (ag == 100) {
                                            ag = 0;
                                        }
                                        if (ag > 0) {
                                            Thread.sleep(ag / 10);
                                        }
                                        i++;
                                    }
                                }
                                if (EmotionEditModel.this.iTZ) {
                                    EmotionEditModel.this.b(createBitmap, bitmap);
                                    return;
                                }
                                aVar.dxq();
                                File a2 = EmotionEditModel.this.a(byteArrayOutputStream, str);
                                EmotionEditModel.this.b(createBitmap, bitmap);
                                Message obtain = Message.obtain();
                                obtain.what = 0;
                                obtain.obj = a2.getAbsolutePath();
                                EmotionEditModel.this.mlH.sendMessage(obtain);
                            }
                        } catch (InterruptedException e) {
                            e.printStackTrace();
                        }
                    }
                });
                this.mlG.start();
            }
        }
    }

    /* JADX INFO: Access modifiers changed from: private */
    public void b(Bitmap bitmap, Bitmap bitmap2) {
        if (bitmap != null && !bitmap.isRecycled()) {
            bitmap.recycle();
        }
        if (bitmap2 != null && !bitmap2.isRecycled()) {
            bitmap2.recycle();
        }
    }

    @Override // com.baidu.adp.base.BdBaseModel
    protected boolean LoadData() {
        return false;
    }

    @Override // com.baidu.adp.base.BdBaseModel
    public boolean cancelLoadData() {
        MessageManager.getInstance().unRegisterListener(this.mlI);
        MessageManager.getInstance().unRegisterTask(1003348);
        dxz();
        return false;
    }

    private void dxz() {
        if (this.mlD != null) {
            this.mlD.cancel();
        }
        if (this.mlE != null) {
            this.mlE.cancel();
        }
        if (this.mlG != null) {
            this.mlG.interrupt();
        }
        this.iTZ = true;
    }

    private void registerTask() {
        TbHttpMessageTask tbHttpMessageTask = new TbHttpMessageTask(1003348, TbConfig.SERVER_ADDRESS + Config.EMOTION_TEXT_CHECKUEG);
        tbHttpMessageTask.setResponsedClass(EmotionCheckUegResponseMessage.class);
        MessageManager.getInstance().registerTask(tbHttpMessageTask);
    }

    public File a(ByteArrayOutputStream byteArrayOutputStream, String str) {
        FileOutputStream fileOutputStream;
        if (byteArrayOutputStream == null || TextUtils.isEmpty(str)) {
            return null;
        }
        File file = new File(str);
        if (file.exists()) {
            file.delete();
        }
        try {
            fileOutputStream = new FileOutputStream(str);
            try {
                try {
                    byteArrayOutputStream.writeTo(fileOutputStream);
                    byteArrayOutputStream.flush();
                    fileOutputStream.flush();
                    try {
                        byteArrayOutputStream.close();
                        fileOutputStream.close();
                    } catch (Exception e) {
                        e.printStackTrace();
                    }
                } catch (Throwable th) {
                    th = th;
                    try {
                        byteArrayOutputStream.close();
                        fileOutputStream.close();
                    } catch (Exception e2) {
                        e2.printStackTrace();
                    }
                    throw th;
                }
            } catch (IOException e3) {
                e = e3;
                e.printStackTrace();
                try {
                    byteArrayOutputStream.close();
                    fileOutputStream.close();
                } catch (Exception e4) {
                    e4.printStackTrace();
                }
                return file;
            }
        } catch (IOException e5) {
            e = e5;
            fileOutputStream = null;
        } catch (Throwable th2) {
            th = th2;
            fileOutputStream = null;
            byteArrayOutputStream.close();
            fileOutputStream.close();
            throw th;
        }
        return file;
    }

    public File c(Bitmap bitmap, String str) {
        ByteArrayOutputStream byteArrayOutputStream;
        BufferedOutputStream bufferedOutputStream;
        if (bitmap == null || TextUtils.isEmpty(str)) {
            return null;
        }
        File file = new File(str);
        if (file.exists()) {
            file.delete();
        }
        try {
            bufferedOutputStream = new BufferedOutputStream(new FileOutputStream(file));
            try {
                byteArrayOutputStream = new ByteArrayOutputStream();
                try {
                    try {
                        bitmap.compress(Bitmap.CompressFormat.PNG, 100, byteArrayOutputStream);
                        bufferedOutputStream.write(byteArrayOutputStream.toByteArray());
                        try {
                            byteArrayOutputStream.close();
                            bufferedOutputStream.close();
                            return file;
                        } catch (Exception e) {
                            e.printStackTrace();
                            return file;
                        }
                    } catch (Exception e2) {
                        e = e2;
                        e.printStackTrace();
                        try {
                            byteArrayOutputStream.close();
                            bufferedOutputStream.close();
                            return file;
                        } catch (Exception e3) {
                            e3.printStackTrace();
                            return file;
                        }
                    }
                } catch (Throwable th) {
                    th = th;
                    try {
                        byteArrayOutputStream.close();
                        bufferedOutputStream.close();
                    } catch (Exception e4) {
                        e4.printStackTrace();
                    }
                    throw th;
                }
            } catch (Exception e5) {
                e = e5;
                byteArrayOutputStream = null;
            } catch (Throwable th2) {
                th = th2;
                byteArrayOutputStream = null;
                byteArrayOutputStream.close();
                bufferedOutputStream.close();
                throw th;
            }
        } catch (Exception e6) {
            e = e6;
            byteArrayOutputStream = null;
            bufferedOutputStream = null;
        } catch (Throwable th3) {
            th = th3;
            byteArrayOutputStream = null;
            bufferedOutputStream = null;
        }
    }

    public void aZ(String str, boolean z) {
        if (!TextUtils.isEmpty(str)) {
            ImageFileInfo imageFileInfo = new ImageFileInfo();
            imageFileInfo.setFilePath(str);
            this.mlE = new b(imageFileInfo, z);
            this.mlE.execute(new String[0]);
        }
    }

    /* JADX INFO: Access modifiers changed from: private */
    /* loaded from: classes2.dex */
    public class b extends BdAsyncTask<String, Integer, ImageUploadResult> {
        private ImageFileInfo mlL;
        private boolean mlM;

        public b(ImageFileInfo imageFileInfo, boolean z) {
            this.mlL = imageFileInfo;
            this.mlM = z;
        }

        /* JADX DEBUG: Method merged with bridge method */
        /* JADX INFO: Access modifiers changed from: protected */
        @Override // com.baidu.adp.lib.asyncTask.BdAsyncTask
        /* renamed from: P */
        public ImageUploadResult doInBackground(String... strArr) {
            EmotionEditModel.this.mlD = new f(null);
            return EmotionEditModel.this.mlD.a(this.mlL, this.mlM, false);
        }

        /* JADX DEBUG: Method merged with bridge method */
        /* JADX INFO: Access modifiers changed from: protected */
        @Override // com.baidu.adp.lib.asyncTask.BdAsyncTask
        /* renamed from: a */
        public void onPostExecute(ImageUploadResult imageUploadResult) {
            EmotionEditModel.this.mlC.c(imageUploadResult);
        }
    }
}
