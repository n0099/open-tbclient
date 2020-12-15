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
/* loaded from: classes22.dex */
public class EmotionEditModel extends BdBaseModel {
    private boolean iHO;
    private a mgs;
    private f mgt;
    private b mgu;
    private EmotionEditActivity mgv;
    private Thread mgw;
    private Handler mgx = new Handler(Looper.getMainLooper()) { // from class: com.baidu.tieba.pbextra.emotion.model.EmotionEditModel.3
        @Override // android.os.Handler
        public void handleMessage(Message message) {
            super.handleMessage(message);
            if (message != null) {
                try {
                    EmotionEditModel.this.mgs.QQ((String) message.obj);
                } catch (Exception e) {
                    e.printStackTrace();
                }
            }
        }
    };
    private final HttpMessageListener mgy = new HttpMessageListener(1003348) { // from class: com.baidu.tieba.pbextra.emotion.model.EmotionEditModel.4
        /* JADX DEBUG: Method merged with bridge method */
        @Override // com.baidu.adp.framework.listener.MessageListener
        public void onMessage(HttpResponsedMessage httpResponsedMessage) {
            if (httpResponsedMessage != null && httpResponsedMessage.getCmd() == 1003348 && (httpResponsedMessage instanceof EmotionCheckUegResponseMessage)) {
                String status = ((EmotionCheckUegResponseMessage) httpResponsedMessage).getStatus();
                if (EmotionCheckUegResponseMessage.STATUS_OK.equals(status)) {
                    EmotionEditModel.this.mgs.dxA();
                } else if (EmotionCheckUegResponseMessage.STATUS_FAIL.equals(status)) {
                    String msg = ((EmotionCheckUegResponseMessage) httpResponsedMessage).getMsg();
                    if (TextUtils.isEmpty(msg)) {
                        msg = EmotionEditModel.this.mgv.getPageContext().getPageActivity().getResources().getString(R.string.emotion_edit_ueg_fail);
                    }
                    EmotionEditModel.this.mgs.QP(msg);
                } else {
                    String errorString = httpResponsedMessage.getErrorString();
                    if (TextUtils.isEmpty(errorString)) {
                        errorString = EmotionEditModel.this.mgv.getPageContext().getPageActivity().getResources().getString(R.string.emotion_edit_fail);
                    }
                    EmotionEditModel.this.mgs.QP(errorString);
                }
            }
        }
    };

    /* loaded from: classes22.dex */
    public interface a {
        void QP(String str);

        void QQ(String str);

        void c(ImageUploadResult imageUploadResult);

        void dxA();
    }

    public EmotionEditModel(EmotionEditActivity emotionEditActivity, a aVar) {
        this.mgv = emotionEditActivity;
        this.mgs = aVar;
        registerTask();
        this.mgy.setTag(getUniqueId());
        this.mgy.setSelfListener(true);
        registerListener(this.mgy);
    }

    public void wn(boolean z) {
        this.iHO = z;
        if (this.iHO) {
            dxK();
        }
    }

    public boolean isCancel() {
        return this.iHO;
    }

    public void QR(String str) {
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
                    if (EmotionEditModel.this.iHO) {
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
                    EmotionEditModel.this.mgs.QQ(str2);
                }
            }.execute(new Void[0]);
        }
    }

    public void a(final com.baidu.adp.gif.b bVar) {
        if (bVar != null) {
            if (this.mgw == null || !this.mgw.isAlive()) {
                this.mgw = new Thread(new Runnable() { // from class: com.baidu.tieba.pbextra.emotion.model.EmotionEditModel.2
                    @Override // java.lang.Runnable
                    public void run() {
                        try {
                            if (!EmotionEditModel.this.iHO) {
                                ByteArrayOutputStream byteArrayOutputStream = new ByteArrayOutputStream();
                                com.baidu.tieba.pbextra.emotion.model.a aVar = new com.baidu.tieba.pbextra.emotion.model.a();
                                aVar.b(byteArrayOutputStream);
                                aVar.HY(0);
                                Bitmap createBitmap = Bitmap.createBitmap(bVar.getWidth(), bVar.getHeight(), Bitmap.Config.ARGB_8888);
                                String str = com.baidu.adp.lib.util.f.EXTERNAL_STORAGE_DIRECTORY + "/" + TbConfig.getTempDirName() + "/emotion.gif";
                                Bitmap bitmap = null;
                                int i = 0;
                                while (true) {
                                    if (i >= bVar.getFrameCount()) {
                                        break;
                                    } else if (EmotionEditModel.this.iHO) {
                                        EmotionEditModel.this.a(createBitmap, bitmap);
                                        break;
                                    } else {
                                        bVar.af(i);
                                        bVar.a(createBitmap, null);
                                        bitmap = EmotionEditModel.this.mgv.F(createBitmap);
                                        aVar.G(bitmap);
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
                                if (EmotionEditModel.this.iHO) {
                                    EmotionEditModel.this.a(createBitmap, bitmap);
                                    return;
                                }
                                aVar.dxB();
                                File a2 = EmotionEditModel.this.a(byteArrayOutputStream, str);
                                EmotionEditModel.this.a(createBitmap, bitmap);
                                Message obtain = Message.obtain();
                                obtain.what = 0;
                                obtain.obj = a2.getAbsolutePath();
                                EmotionEditModel.this.mgx.sendMessage(obtain);
                            }
                        } catch (InterruptedException e) {
                            e.printStackTrace();
                        }
                    }
                });
                this.mgw.start();
            }
        }
    }

    /* JADX INFO: Access modifiers changed from: private */
    public void a(Bitmap bitmap, Bitmap bitmap2) {
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
        MessageManager.getInstance().unRegisterListener(this.mgy);
        MessageManager.getInstance().unRegisterTask(1003348);
        dxK();
        return false;
    }

    private void dxK() {
        if (this.mgt != null) {
            this.mgt.cancel();
        }
        if (this.mgu != null) {
            this.mgu.cancel();
        }
        if (this.mgw != null) {
            this.mgw.interrupt();
        }
        this.iHO = true;
    }

    private void registerTask() {
        TbHttpMessageTask tbHttpMessageTask = new TbHttpMessageTask(1003348, TbConfig.SERVER_ADDRESS + Config.EMOTION_TEXT_CHECKUEG);
        tbHttpMessageTask.setResponsedClass(EmotionCheckUegResponseMessage.class);
        MessageManager.getInstance().registerTask(tbHttpMessageTask);
    }

    public File a(ByteArrayOutputStream byteArrayOutputStream, String str) {
        FileOutputStream fileOutputStream;
        IOException e;
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
                    } catch (Exception e2) {
                        e2.printStackTrace();
                    }
                } catch (Throwable th) {
                    th = th;
                    try {
                        byteArrayOutputStream.close();
                        fileOutputStream.close();
                    } catch (Exception e3) {
                        e3.printStackTrace();
                    }
                    throw th;
                }
            } catch (IOException e4) {
                e = e4;
                e.printStackTrace();
                try {
                    byteArrayOutputStream.close();
                    fileOutputStream.close();
                } catch (Exception e5) {
                    e5.printStackTrace();
                }
                return file;
            }
        } catch (IOException e6) {
            fileOutputStream = null;
            e = e6;
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
        BufferedOutputStream bufferedOutputStream;
        Exception e;
        ByteArrayOutputStream byteArrayOutputStream;
        ByteArrayOutputStream byteArrayOutputStream2 = null;
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
                        } catch (Exception e2) {
                            e2.printStackTrace();
                            return file;
                        }
                    } catch (Exception e3) {
                        e = e3;
                        e.printStackTrace();
                        try {
                            byteArrayOutputStream.close();
                            bufferedOutputStream.close();
                            return file;
                        } catch (Exception e4) {
                            e4.printStackTrace();
                            return file;
                        }
                    }
                } catch (Throwable th) {
                    th = th;
                    byteArrayOutputStream2 = byteArrayOutputStream;
                    try {
                        byteArrayOutputStream2.close();
                        bufferedOutputStream.close();
                    } catch (Exception e5) {
                        e5.printStackTrace();
                    }
                    throw th;
                }
            } catch (Exception e6) {
                byteArrayOutputStream = null;
                e = e6;
            } catch (Throwable th2) {
                th = th2;
                byteArrayOutputStream2.close();
                bufferedOutputStream.close();
                throw th;
            }
        } catch (Exception e7) {
            bufferedOutputStream = null;
            e = e7;
            byteArrayOutputStream = null;
        } catch (Throwable th3) {
            th = th3;
            bufferedOutputStream = null;
        }
    }

    public void aZ(String str, boolean z) {
        if (!TextUtils.isEmpty(str)) {
            ImageFileInfo imageFileInfo = new ImageFileInfo();
            imageFileInfo.setFilePath(str);
            this.mgu = new b(imageFileInfo, z);
            this.mgu.execute(new String[0]);
        }
    }

    /* JADX INFO: Access modifiers changed from: private */
    /* loaded from: classes22.dex */
    public class b extends BdAsyncTask<String, Integer, ImageUploadResult> {
        private ImageFileInfo mgB;
        private boolean mgC;

        public b(ImageFileInfo imageFileInfo, boolean z) {
            this.mgB = imageFileInfo;
            this.mgC = z;
        }

        /* JADX DEBUG: Method merged with bridge method */
        /* JADX INFO: Access modifiers changed from: protected */
        @Override // com.baidu.adp.lib.asyncTask.BdAsyncTask
        /* renamed from: I */
        public ImageUploadResult doInBackground(String... strArr) {
            EmotionEditModel.this.mgt = new f(null);
            return EmotionEditModel.this.mgt.a(this.mgB, this.mgC, false);
        }

        /* JADX DEBUG: Method merged with bridge method */
        /* JADX INFO: Access modifiers changed from: protected */
        @Override // com.baidu.adp.lib.asyncTask.BdAsyncTask
        /* renamed from: a */
        public void onPostExecute(ImageUploadResult imageUploadResult) {
            EmotionEditModel.this.mgs.c(imageUploadResult);
        }
    }
}
