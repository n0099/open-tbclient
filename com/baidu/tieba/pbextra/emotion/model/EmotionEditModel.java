package com.baidu.tieba.pbextra.emotion.model;

import android.graphics.Bitmap;
import android.os.Handler;
import android.os.Looper;
import android.os.Message;
import android.text.TextUtils;
import androidx.core.view.InputDeviceCompat;
import com.baidu.adp.base.BdBaseModel;
import com.baidu.adp.framework.MessageManager;
import com.baidu.adp.framework.listener.HttpMessageListener;
import com.baidu.adp.framework.message.HttpMessage;
import com.baidu.adp.framework.message.HttpResponsedMessage;
import com.baidu.adp.lib.asyncTask.BdAsyncTask;
import com.baidu.android.imsdk.internal.Constants;
import com.baidu.tbadk.TbConfig;
import com.baidu.tbadk.core.frameworkData.CmdConfigHttp;
import com.baidu.tbadk.img.ImageFileInfo;
import com.baidu.tbadk.img.ImageUploadResult;
import com.baidu.tbadk.task.TbHttpMessageTask;
import com.baidu.tieba.R;
import com.baidu.tieba.pbextra.emotion.EmotionEditActivity;
import com.baidu.titan.sdk.runtime.FieldHolder;
import com.baidu.titan.sdk.runtime.InitContext;
import com.baidu.titan.sdk.runtime.InterceptResult;
import com.baidu.titan.sdk.runtime.Interceptable;
import com.baidu.titan.sdk.runtime.TitanRuntime;
import java.io.BufferedOutputStream;
import java.io.ByteArrayOutputStream;
import java.io.File;
import java.io.FileOutputStream;
import java.io.IOException;
/* loaded from: classes11.dex */
public class EmotionEditModel extends BdBaseModel {
    public static /* synthetic */ Interceptable $ic;
    public transient /* synthetic */ FieldHolder $fh;

    /* renamed from: e  reason: collision with root package name */
    public e f48121e;

    /* renamed from: f  reason: collision with root package name */
    public c.a.q0.d0.f f48122f;

    /* renamed from: g  reason: collision with root package name */
    public f f48123g;

    /* renamed from: h  reason: collision with root package name */
    public EmotionEditActivity f48124h;

    /* renamed from: i  reason: collision with root package name */
    public boolean f48125i;

    /* renamed from: j  reason: collision with root package name */
    public Thread f48126j;

    /* renamed from: k  reason: collision with root package name */
    public Handler f48127k;
    public final HttpMessageListener l;

    /* loaded from: classes11.dex */
    public class a extends BdAsyncTask<Void, Integer, String> {
        public static /* synthetic */ Interceptable $ic;
        public transient /* synthetic */ FieldHolder $fh;
        public final /* synthetic */ Bitmap a;

        /* renamed from: b  reason: collision with root package name */
        public final /* synthetic */ String f48128b;

        /* renamed from: c  reason: collision with root package name */
        public final /* synthetic */ EmotionEditModel f48129c;

        public a(EmotionEditModel emotionEditModel, Bitmap bitmap, String str) {
            Interceptable interceptable = $ic;
            if (interceptable != null) {
                InitContext newInitContext = TitanRuntime.newInitContext();
                newInitContext.initArgs = r2;
                Object[] objArr = {emotionEditModel, bitmap, str};
                interceptable.invokeUnInit(65536, newInitContext);
                int i2 = newInitContext.flag;
                if ((i2 & 1) != 0) {
                    int i3 = i2 & 2;
                    newInitContext.thisArg = this;
                    interceptable.invokeInitBody(65536, newInitContext);
                    return;
                }
            }
            this.f48129c = emotionEditModel;
            this.a = bitmap;
            this.f48128b = str;
        }

        /* JADX DEBUG: Method merged with bridge method */
        @Override // com.baidu.adp.lib.asyncTask.BdAsyncTask
        /* renamed from: b */
        public String doInBackground(Void[] voidArr) {
            InterceptResult invokeL;
            Interceptable interceptable = $ic;
            if (interceptable == null || (invokeL = interceptable.invokeL(1048576, this, voidArr)) == null) {
                if (this.f48129c.f48125i) {
                    return null;
                }
                File J = this.f48129c.J(this.a, this.f48128b);
                this.a.recycle();
                return J.getAbsolutePath();
            }
            return (String) invokeL.objValue;
        }

        /* JADX DEBUG: Method merged with bridge method */
        @Override // com.baidu.adp.lib.asyncTask.BdAsyncTask
        public void onPostExecute(String str) {
            Interceptable interceptable = $ic;
            if (interceptable == null || interceptable.invokeL(1048579, this, str) == null) {
                super.onPostExecute((a) str);
                this.f48129c.f48121e.onSaveImageSuccess(str);
            }
        }
    }

    /* loaded from: classes11.dex */
    public class b implements Runnable {
        public static /* synthetic */ Interceptable $ic;
        public transient /* synthetic */ FieldHolder $fh;

        /* renamed from: e  reason: collision with root package name */
        public final /* synthetic */ c.a.d.d.b f48130e;

        /* renamed from: f  reason: collision with root package name */
        public final /* synthetic */ EmotionEditModel f48131f;

        public b(EmotionEditModel emotionEditModel, c.a.d.d.b bVar) {
            Interceptable interceptable = $ic;
            if (interceptable != null) {
                InitContext newInitContext = TitanRuntime.newInitContext();
                newInitContext.initArgs = r2;
                Object[] objArr = {emotionEditModel, bVar};
                interceptable.invokeUnInit(65536, newInitContext);
                int i2 = newInitContext.flag;
                if ((i2 & 1) != 0) {
                    int i3 = i2 & 2;
                    newInitContext.thisArg = this;
                    interceptable.invokeInitBody(65536, newInitContext);
                    return;
                }
            }
            this.f48131f = emotionEditModel;
            this.f48130e = bVar;
        }

        @Override // java.lang.Runnable
        public void run() {
            Interceptable interceptable = $ic;
            if (interceptable == null || interceptable.invokeV(1048576, this) == null) {
                try {
                    if (this.f48131f.f48125i) {
                        return;
                    }
                    ByteArrayOutputStream byteArrayOutputStream = new ByteArrayOutputStream();
                    c.a.r0.r2.b.a.a aVar = new c.a.r0.r2.b.a.a();
                    aVar.i(byteArrayOutputStream);
                    aVar.g(0);
                    Bitmap createBitmap = Bitmap.createBitmap(this.f48130e.getWidth(), this.f48130e.getHeight(), Bitmap.Config.ARGB_8888);
                    String str = c.a.d.f.p.f.f2628b + "/" + TbConfig.getTempDirName() + "/emotion.gif";
                    Bitmap bitmap = null;
                    int i2 = 0;
                    while (true) {
                        if (i2 >= this.f48130e.getFrameCount()) {
                            break;
                        } else if (this.f48131f.f48125i) {
                            this.f48131f.G(createBitmap, bitmap);
                            break;
                        } else {
                            this.f48130e.c(i2);
                            this.f48130e.a(createBitmap, null);
                            bitmap = this.f48131f.f48124h.addTextToImage(createBitmap);
                            aVar.a(bitmap);
                            int b2 = this.f48130e.b(i2);
                            if (b2 == 100) {
                                b2 = 0;
                            }
                            if (b2 > 0) {
                                Thread.sleep(b2 / 10);
                            }
                            i2++;
                        }
                    }
                    if (this.f48131f.f48125i) {
                        this.f48131f.G(createBitmap, bitmap);
                        return;
                    }
                    aVar.d();
                    File K = this.f48131f.K(byteArrayOutputStream, str);
                    this.f48131f.G(createBitmap, bitmap);
                    Message obtain = Message.obtain();
                    obtain.what = 0;
                    obtain.obj = K.getAbsolutePath();
                    this.f48131f.f48127k.sendMessage(obtain);
                } catch (InterruptedException e2) {
                    e2.printStackTrace();
                }
            }
        }
    }

    /* loaded from: classes11.dex */
    public class c extends Handler {
        public static /* synthetic */ Interceptable $ic;
        public transient /* synthetic */ FieldHolder $fh;
        public final /* synthetic */ EmotionEditModel a;

        /* JADX WARN: 'super' call moved to the top of the method (can break code semantics) */
        public c(EmotionEditModel emotionEditModel, Looper looper) {
            super(looper);
            Interceptable interceptable = $ic;
            if (interceptable != null) {
                InitContext newInitContext = TitanRuntime.newInitContext();
                newInitContext.initArgs = r2;
                Object[] objArr = {emotionEditModel, looper};
                interceptable.invokeUnInit(65536, newInitContext);
                int i2 = newInitContext.flag;
                if ((i2 & 1) != 0) {
                    int i3 = i2 & 2;
                    super((Looper) newInitContext.callArgs[0]);
                    newInitContext.thisArg = this;
                    interceptable.invokeInitBody(65536, newInitContext);
                    return;
                }
            }
            this.a = emotionEditModel;
        }

        @Override // android.os.Handler
        public void handleMessage(Message message) {
            Interceptable interceptable = $ic;
            if (interceptable == null || interceptable.invokeL(1048576, this, message) == null) {
                super.handleMessage(message);
                if (message != null) {
                    try {
                        this.a.f48121e.onSaveImageSuccess((String) message.obj);
                    } catch (Exception e2) {
                        e2.printStackTrace();
                    }
                }
            }
        }
    }

    /* loaded from: classes11.dex */
    public class d extends HttpMessageListener {
        public static /* synthetic */ Interceptable $ic;
        public transient /* synthetic */ FieldHolder $fh;
        public final /* synthetic */ EmotionEditModel a;

        /* JADX WARN: 'super' call moved to the top of the method (can break code semantics) */
        public d(EmotionEditModel emotionEditModel, int i2) {
            super(i2);
            Interceptable interceptable = $ic;
            if (interceptable != null) {
                InitContext newInitContext = TitanRuntime.newInitContext();
                newInitContext.initArgs = r2;
                Object[] objArr = {emotionEditModel, Integer.valueOf(i2)};
                interceptable.invokeUnInit(65536, newInitContext);
                int i3 = newInitContext.flag;
                if ((i3 & 1) != 0) {
                    int i4 = i3 & 2;
                    super(((Integer) newInitContext.callArgs[0]).intValue());
                    newInitContext.thisArg = this;
                    interceptable.invokeInitBody(65536, newInitContext);
                    return;
                }
            }
            this.a = emotionEditModel;
        }

        /* JADX DEBUG: Method merged with bridge method */
        @Override // com.baidu.adp.framework.listener.MessageListener
        public void onMessage(HttpResponsedMessage httpResponsedMessage) {
            Interceptable interceptable = $ic;
            if ((interceptable == null || interceptable.invokeL(1048576, this, httpResponsedMessage) == null) && httpResponsedMessage != null && httpResponsedMessage.getCmd() == 1003348 && (httpResponsedMessage instanceof EmotionCheckUegResponseMessage)) {
                EmotionCheckUegResponseMessage emotionCheckUegResponseMessage = (EmotionCheckUegResponseMessage) httpResponsedMessage;
                String status = emotionCheckUegResponseMessage.getStatus();
                if (EmotionCheckUegResponseMessage.STATUS_OK.equals(status)) {
                    this.a.f48121e.onCheckUegSuccess();
                } else if (EmotionCheckUegResponseMessage.STATUS_FAIL.equals(status)) {
                    String msg = emotionCheckUegResponseMessage.getMsg();
                    if (TextUtils.isEmpty(msg)) {
                        msg = this.a.f48124h.getPageContext().getPageActivity().getResources().getString(R.string.emotion_edit_ueg_fail);
                    }
                    this.a.f48121e.onCheckUegFail(msg);
                } else {
                    String errorString = httpResponsedMessage.getErrorString();
                    if (TextUtils.isEmpty(errorString)) {
                        errorString = this.a.f48124h.getPageContext().getPageActivity().getResources().getString(R.string.emotion_edit_fail);
                    }
                    this.a.f48121e.onCheckUegFail(errorString);
                }
            }
        }
    }

    /* loaded from: classes11.dex */
    public interface e {
        void onCheckUegFail(String str);

        void onCheckUegSuccess();

        void onSaveImageSuccess(String str);

        void onUploadImageSuccess(ImageUploadResult imageUploadResult);
    }

    /* loaded from: classes11.dex */
    public class f extends BdAsyncTask<String, Integer, ImageUploadResult> {
        public static /* synthetic */ Interceptable $ic;
        public transient /* synthetic */ FieldHolder $fh;
        public ImageFileInfo a;

        /* renamed from: b  reason: collision with root package name */
        public boolean f48132b;

        /* renamed from: c  reason: collision with root package name */
        public final /* synthetic */ EmotionEditModel f48133c;

        public f(EmotionEditModel emotionEditModel, ImageFileInfo imageFileInfo, boolean z) {
            Interceptable interceptable = $ic;
            if (interceptable != null) {
                InitContext newInitContext = TitanRuntime.newInitContext();
                newInitContext.initArgs = r2;
                Object[] objArr = {emotionEditModel, imageFileInfo, Boolean.valueOf(z)};
                interceptable.invokeUnInit(65536, newInitContext);
                int i2 = newInitContext.flag;
                if ((i2 & 1) != 0) {
                    int i3 = i2 & 2;
                    newInitContext.thisArg = this;
                    interceptable.invokeInitBody(65536, newInitContext);
                    return;
                }
            }
            this.f48133c = emotionEditModel;
            this.a = imageFileInfo;
            this.f48132b = z;
        }

        /* JADX DEBUG: Method merged with bridge method */
        @Override // com.baidu.adp.lib.asyncTask.BdAsyncTask
        /* renamed from: b */
        public ImageUploadResult doInBackground(String... strArr) {
            InterceptResult invokeL;
            Interceptable interceptable = $ic;
            if (interceptable == null || (invokeL = interceptable.invokeL(1048576, this, strArr)) == null) {
                this.f48133c.f48122f = new c.a.q0.d0.f(null);
                return this.f48133c.f48122f.j(this.a, this.f48132b, false);
            }
            return (ImageUploadResult) invokeL.objValue;
        }

        /* JADX DEBUG: Method merged with bridge method */
        @Override // com.baidu.adp.lib.asyncTask.BdAsyncTask
        /* renamed from: c */
        public void onPostExecute(ImageUploadResult imageUploadResult) {
            Interceptable interceptable = $ic;
            if (interceptable == null || interceptable.invokeL(Constants.METHOD_GET_CONTACTER_INFO_FOR_SESSION, this, imageUploadResult) == null) {
                this.f48133c.f48121e.onUploadImageSuccess(imageUploadResult);
            }
        }
    }

    public EmotionEditModel(EmotionEditActivity emotionEditActivity, e eVar) {
        Interceptable interceptable = $ic;
        if (interceptable != null) {
            InitContext newInitContext = TitanRuntime.newInitContext();
            newInitContext.initArgs = r2;
            Object[] objArr = {emotionEditActivity, eVar};
            interceptable.invokeUnInit(65536, newInitContext);
            int i2 = newInitContext.flag;
            if ((i2 & 1) != 0) {
                int i3 = i2 & 2;
                newInitContext.thisArg = this;
                interceptable.invokeInitBody(65536, newInitContext);
                return;
            }
        }
        this.f48127k = new c(this, Looper.getMainLooper());
        this.l = new d(this, CmdConfigHttp.CMD_EMOTION_EDIT_TEXT_UEG);
        this.f48124h = emotionEditActivity;
        this.f48121e = eVar;
        registerTask();
        this.l.setTag(getUniqueId());
        this.l.setSelfListener(true);
        registerListener(this.l);
    }

    public final void D() {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeV(1048576, this) == null) {
            c.a.q0.d0.f fVar = this.f48122f;
            if (fVar != null) {
                fVar.a();
            }
            f fVar2 = this.f48123g;
            if (fVar2 != null) {
                fVar2.cancel();
            }
            Thread thread = this.f48126j;
            if (thread != null) {
                thread.interrupt();
            }
            this.f48125i = true;
        }
    }

    public void E(String str) {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeL(Constants.METHOD_GET_CONTACTER_INFO_FOR_SESSION, this, str) == null) {
            HttpMessage httpMessage = new HttpMessage(CmdConfigHttp.CMD_EMOTION_EDIT_TEXT_UEG);
            httpMessage.addParam("text", str);
            sendMessage(httpMessage);
        }
    }

    public boolean F() {
        InterceptResult invokeV;
        Interceptable interceptable = $ic;
        return (interceptable == null || (invokeV = interceptable.invokeV(Constants.METHOD_SEND_USER_MSG, this)) == null) ? this.f48125i : invokeV.booleanValue;
    }

    public final void G(Bitmap bitmap, Bitmap bitmap2) {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeLL(1048579, this, bitmap, bitmap2) == null) {
            if (bitmap != null && !bitmap.isRecycled()) {
                bitmap.recycle();
            }
            if (bitmap2 == null || bitmap2.isRecycled()) {
                return;
            }
            bitmap2.recycle();
        }
    }

    public void H(c.a.d.d.b bVar) {
        Interceptable interceptable = $ic;
        if (!(interceptable == null || interceptable.invokeL(1048580, this, bVar) == null) || bVar == null) {
            return;
        }
        Thread thread = this.f48126j;
        if (thread == null || !thread.isAlive()) {
            Thread thread2 = new Thread(new b(this, bVar));
            this.f48126j = thread2;
            thread2.start();
        }
    }

    public void I(Bitmap bitmap, String str) {
        Interceptable interceptable = $ic;
        if (!(interceptable == null || interceptable.invokeLL(1048581, this, bitmap, str) == null) || bitmap == null || TextUtils.isEmpty(str)) {
            return;
        }
        new a(this, bitmap, str).execute(new Void[0]);
    }

    public File J(Bitmap bitmap, String str) {
        InterceptResult invokeLL;
        BufferedOutputStream bufferedOutputStream;
        ByteArrayOutputStream byteArrayOutputStream;
        Interceptable interceptable = $ic;
        if (interceptable == null || (invokeLL = interceptable.invokeLL(1048582, this, bitmap, str)) == null) {
            ByteArrayOutputStream byteArrayOutputStream2 = null;
            if (bitmap == null || TextUtils.isEmpty(str)) {
                return null;
            }
            File file = new File(str);
            if (file.exists()) {
                file.delete();
            }
            try {
                try {
                    bufferedOutputStream = new BufferedOutputStream(new FileOutputStream(file));
                    try {
                        try {
                            byteArrayOutputStream = new ByteArrayOutputStream();
                        } catch (Exception e2) {
                            e = e2;
                        }
                    } catch (Throwable th) {
                        th = th;
                    }
                } catch (Exception e3) {
                    e3.printStackTrace();
                }
                try {
                    bitmap.compress(Bitmap.CompressFormat.PNG, 100, byteArrayOutputStream);
                    bufferedOutputStream.write(byteArrayOutputStream.toByteArray());
                    byteArrayOutputStream.close();
                    bufferedOutputStream.close();
                } catch (Exception e4) {
                    e = e4;
                    byteArrayOutputStream2 = byteArrayOutputStream;
                    e.printStackTrace();
                    byteArrayOutputStream2.close();
                    bufferedOutputStream.close();
                    return file;
                } catch (Throwable th2) {
                    th = th2;
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
                e = e6;
                bufferedOutputStream = null;
            } catch (Throwable th3) {
                th = th3;
                bufferedOutputStream = null;
            }
            return file;
        }
        return (File) invokeLL.objValue;
    }

    public File K(ByteArrayOutputStream byteArrayOutputStream, String str) {
        InterceptResult invokeLL;
        FileOutputStream fileOutputStream;
        Interceptable interceptable = $ic;
        if (interceptable == null || (invokeLL = interceptable.invokeLL(1048583, this, byteArrayOutputStream, str)) == null) {
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
                    } catch (IOException e2) {
                        e = e2;
                    }
                } catch (Throwable th) {
                    th = th;
                }
            } catch (Exception e3) {
                e3.printStackTrace();
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
        return (File) invokeLL.objValue;
    }

    public void L(boolean z) {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeZ(InputDeviceCompat.SOURCE_TOUCHPAD, this, z) == null) {
            this.f48125i = z;
            if (z) {
                D();
            }
        }
    }

    public void M(String str, boolean z) {
        Interceptable interceptable = $ic;
        if (!(interceptable == null || interceptable.invokeLZ(1048585, this, str, z) == null) || TextUtils.isEmpty(str)) {
            return;
        }
        ImageFileInfo imageFileInfo = new ImageFileInfo();
        imageFileInfo.setFilePath(str);
        f fVar = new f(this, imageFileInfo, z);
        this.f48123g = fVar;
        fVar.execute(new String[0]);
    }

    @Override // com.baidu.adp.base.BdBaseModel
    public boolean cancelLoadData() {
        InterceptResult invokeV;
        Interceptable interceptable = $ic;
        if (interceptable == null || (invokeV = interceptable.invokeV(1048586, this)) == null) {
            MessageManager.getInstance().unRegisterListener(this.l);
            MessageManager.getInstance().unRegisterTask(CmdConfigHttp.CMD_EMOTION_EDIT_TEXT_UEG);
            D();
            return false;
        }
        return invokeV.booleanValue;
    }

    @Override // com.baidu.adp.base.BdBaseModel
    public boolean loadData() {
        InterceptResult invokeV;
        Interceptable interceptable = $ic;
        if (interceptable == null || (invokeV = interceptable.invokeV(1048587, this)) == null) {
            return false;
        }
        return invokeV.booleanValue;
    }

    public final void registerTask() {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeV(1048588, this) == null) {
            TbHttpMessageTask tbHttpMessageTask = new TbHttpMessageTask(CmdConfigHttp.CMD_EMOTION_EDIT_TEXT_UEG, TbConfig.SERVER_ADDRESS + "c/e/meme/checkUegStatus");
            tbHttpMessageTask.setResponsedClass(EmotionCheckUegResponseMessage.class);
            MessageManager.getInstance().registerTask(tbHttpMessageTask);
        }
    }
}
