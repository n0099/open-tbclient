package com.baidu.tieba.pb.pb.main.emotion.model;

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
import com.baidu.adp.lib.util.e;
import com.baidu.tbadk.TbConfig;
import com.baidu.tbadk.core.frameworkData.CmdConfigHttp;
import com.baidu.tbadk.img.ImageFileInfo;
import com.baidu.tbadk.img.ImageUploadResult;
import com.baidu.tbadk.task.TbHttpMessageTask;
import com.baidu.tieba.d;
import com.baidu.tieba.pb.pb.main.emotion.EmotionEditActivity;
import com.baidu.tieba.pb.pb.main.emotion.message.EmotionCheckUegResponseMessage;
import java.io.BufferedOutputStream;
import java.io.ByteArrayOutputStream;
import java.io.File;
import java.io.FileOutputStream;
import java.io.IOException;
/* loaded from: classes.dex */
public class EmotionEditModel extends BdBaseModel {
    private boolean cca;
    private b eQA;
    private EmotionEditActivity eQB;
    private Thread eQC;
    private Handler eQD = new Handler(Looper.getMainLooper()) { // from class: com.baidu.tieba.pb.pb.main.emotion.model.EmotionEditModel.3
        @Override // android.os.Handler
        public void handleMessage(Message message) {
            super.handleMessage(message);
            if (message != null) {
                try {
                    EmotionEditModel.this.eQy.py((String) message.obj);
                } catch (Exception e) {
                    e.printStackTrace();
                }
            }
        }
    };
    private final HttpMessageListener eQE = new HttpMessageListener(CmdConfigHttp.CMD_EMOTION_EDIT_TEXT_UEG) { // from class: com.baidu.tieba.pb.pb.main.emotion.model.EmotionEditModel.4
        /* JADX DEBUG: Method merged with bridge method */
        @Override // com.baidu.adp.framework.listener.MessageListener
        public void onMessage(HttpResponsedMessage httpResponsedMessage) {
            if (httpResponsedMessage != null && httpResponsedMessage.getCmd() == 1003348 && (httpResponsedMessage instanceof EmotionCheckUegResponseMessage)) {
                String status = ((EmotionCheckUegResponseMessage) httpResponsedMessage).getStatus();
                if (EmotionCheckUegResponseMessage.STATUS_OK.equals(status)) {
                    EmotionEditModel.this.eQy.aTP();
                } else if (EmotionCheckUegResponseMessage.STATUS_FAIL.equals(status)) {
                    String msg = ((EmotionCheckUegResponseMessage) httpResponsedMessage).getMsg();
                    if (TextUtils.isEmpty(msg)) {
                        msg = EmotionEditModel.this.eQB.getPageContext().getPageActivity().getResources().getString(d.l.emotion_edit_ueg_fail);
                    }
                    EmotionEditModel.this.eQy.px(msg);
                } else {
                    String errorString = httpResponsedMessage.getErrorString();
                    if (TextUtils.isEmpty(errorString)) {
                        errorString = EmotionEditModel.this.eQB.getPageContext().getPageActivity().getResources().getString(d.l.emotion_edit_fail);
                    }
                    EmotionEditModel.this.eQy.px(errorString);
                }
            }
        }
    };
    private a eQy;
    private com.baidu.tbadk.img.d eQz;

    /* loaded from: classes.dex */
    public interface a {
        void aTP();

        void d(ImageUploadResult imageUploadResult);

        void px(String str);

        void py(String str);
    }

    public EmotionEditModel(EmotionEditActivity emotionEditActivity, a aVar) {
        this.eQB = emotionEditActivity;
        this.eQy = aVar;
        Eg();
        this.eQE.setTag(getUniqueId());
        this.eQE.setSelfListener(true);
        registerListener(this.eQE);
    }

    public void jN(boolean z) {
        this.cca = z;
        if (this.cca) {
            aUb();
        }
    }

    public boolean fr() {
        return this.cca;
    }

    public void pz(String str) {
        HttpMessage httpMessage = new HttpMessage(CmdConfigHttp.CMD_EMOTION_EDIT_TEXT_UEG);
        httpMessage.addParam("text", str);
        sendMessage(httpMessage);
    }

    public void a(final Bitmap bitmap, final String str) {
        if (bitmap != null && !TextUtils.isEmpty(str)) {
            new BdAsyncTask<Void, Integer, String>() { // from class: com.baidu.tieba.pb.pb.main.emotion.model.EmotionEditModel.1
                /* JADX DEBUG: Method merged with bridge method */
                /* JADX INFO: Access modifiers changed from: protected */
                @Override // com.baidu.adp.lib.asyncTask.BdAsyncTask
                /* renamed from: g */
                public String doInBackground(Void[] voidArr) {
                    if (EmotionEditModel.this.cca) {
                        return null;
                    }
                    File b2 = EmotionEditModel.this.b(bitmap, str);
                    bitmap.recycle();
                    return b2.getAbsolutePath();
                }

                /* JADX DEBUG: Method merged with bridge method */
                /* JADX INFO: Access modifiers changed from: protected */
                @Override // com.baidu.adp.lib.asyncTask.BdAsyncTask
                public void onPostExecute(String str2) {
                    super.onPostExecute((AnonymousClass1) str2);
                    EmotionEditModel.this.eQy.py(str2);
                }
            }.execute(new Void[0]);
        }
    }

    public void a(final com.baidu.adp.gif.b bVar) {
        if (bVar != null) {
            if (this.eQC == null || !this.eQC.isAlive()) {
                this.eQC = new Thread(new Runnable() { // from class: com.baidu.tieba.pb.pb.main.emotion.model.EmotionEditModel.2
                    @Override // java.lang.Runnable
                    public void run() {
                        try {
                            if (!EmotionEditModel.this.cca) {
                                ByteArrayOutputStream byteArrayOutputStream = new ByteArrayOutputStream();
                                com.baidu.tieba.pb.pb.main.emotion.model.a aVar = new com.baidu.tieba.pb.pb.main.emotion.model.a();
                                aVar.g(byteArrayOutputStream);
                                aVar.pm(0);
                                Bitmap createBitmap = Bitmap.createBitmap(bVar.getWidth(), bVar.getHeight(), Bitmap.Config.ARGB_8888);
                                String str = e.yu + "/" + TbConfig.getTempDirName() + "/emotion.gif";
                                Bitmap bitmap = null;
                                int i = 0;
                                while (true) {
                                    if (i >= bVar.dD()) {
                                        break;
                                    } else if (EmotionEditModel.this.cca) {
                                        EmotionEditModel.this.b(createBitmap, bitmap);
                                        break;
                                    } else {
                                        bVar.T(i);
                                        bVar.a(createBitmap, null);
                                        bitmap = EmotionEditModel.this.eQB.l(createBitmap);
                                        aVar.m(bitmap);
                                        int U = bVar.U(i);
                                        if (U == 100) {
                                            U = 0;
                                        }
                                        if (U > 0) {
                                            Thread.sleep(U / 10);
                                        }
                                        i++;
                                    }
                                }
                                if (EmotionEditModel.this.cca) {
                                    EmotionEditModel.this.b(createBitmap, bitmap);
                                    return;
                                }
                                aVar.aTS();
                                File a2 = EmotionEditModel.this.a(byteArrayOutputStream, str);
                                EmotionEditModel.this.b(createBitmap, bitmap);
                                Message obtain = Message.obtain();
                                obtain.what = 0;
                                obtain.obj = a2.getAbsolutePath();
                                EmotionEditModel.this.eQD.sendMessage(obtain);
                            }
                        } catch (InterruptedException e) {
                            e.printStackTrace();
                        }
                    }
                });
                this.eQC.start();
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
        MessageManager.getInstance().unRegisterListener(this.eQE);
        MessageManager.getInstance().unRegisterTask(CmdConfigHttp.CMD_EMOTION_EDIT_TEXT_UEG);
        aUb();
        return false;
    }

    private void aUb() {
        if (this.eQz != null) {
            this.eQz.cancel();
        }
        if (this.eQA != null) {
            this.eQA.cancel();
        }
        if (this.eQC != null) {
            this.eQC.interrupt();
        }
        this.cca = true;
    }

    private void Eg() {
        TbHttpMessageTask tbHttpMessageTask = new TbHttpMessageTask(CmdConfigHttp.CMD_EMOTION_EDIT_TEXT_UEG, TbConfig.SERVER_ADDRESS + "c/e/meme/checkUegStatus");
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

    public File b(Bitmap bitmap, String str) {
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

    public void U(String str, boolean z) {
        if (!TextUtils.isEmpty(str)) {
            ImageFileInfo imageFileInfo = new ImageFileInfo();
            imageFileInfo.setFilePath(str);
            this.eQA = new b(imageFileInfo, z);
            this.eQA.execute(new String[0]);
        }
    }

    /* JADX INFO: Access modifiers changed from: private */
    /* loaded from: classes.dex */
    public class b extends BdAsyncTask<String, Integer, ImageUploadResult> {
        private ImageFileInfo eQI;
        private boolean eQJ;

        public b(ImageFileInfo imageFileInfo, boolean z) {
            this.eQI = imageFileInfo;
            this.eQJ = z;
        }

        /* JADX DEBUG: Method merged with bridge method */
        /* JADX INFO: Access modifiers changed from: protected */
        @Override // com.baidu.adp.lib.asyncTask.BdAsyncTask
        /* renamed from: p */
        public ImageUploadResult doInBackground(String... strArr) {
            EmotionEditModel.this.eQz = new com.baidu.tbadk.img.d(null);
            return EmotionEditModel.this.eQz.a(this.eQI, this.eQJ, false);
        }

        /* JADX DEBUG: Method merged with bridge method */
        /* JADX INFO: Access modifiers changed from: protected */
        @Override // com.baidu.adp.lib.asyncTask.BdAsyncTask
        /* renamed from: a */
        public void onPostExecute(ImageUploadResult imageUploadResult) {
            EmotionEditModel.this.eQy.d(imageUploadResult);
        }
    }
}
