package com.baidu.tieba.video.record;

import android.content.Context;
import android.graphics.Bitmap;
import android.hardware.Camera;
import android.media.MediaRecorder;
import android.os.Handler;
import android.text.TextUtils;
import android.view.MotionEvent;
import android.view.SurfaceHolder;
import android.view.SurfaceView;
import androidx.core.view.InputDeviceCompat;
import com.baidu.adp.framework.MessageManager;
import com.baidu.adp.framework.message.CustomResponsedMessage;
import com.baidu.adp.lib.asyncTask.BdAsyncTask;
import com.baidu.android.imsdk.internal.Constants;
import com.baidu.tbadk.core.util.FileHelper;
import com.baidu.tieba.ix8;
import com.baidu.tieba.jx8;
import com.baidu.tieba.mv8;
import com.baidu.tieba.np7;
import com.baidu.tieba.tp7;
import com.baidu.tieba.xp7;
import com.baidu.tieba.zv8;
import com.baidu.titan.sdk.runtime.FieldHolder;
import com.baidu.titan.sdk.runtime.InitContext;
import com.baidu.titan.sdk.runtime.InterceptResult;
import com.baidu.titan.sdk.runtime.Interceptable;
import com.baidu.titan.sdk.runtime.TitanRuntime;
import com.faceunity.encoder.TextureMovieEncoder;
import java.io.File;
import java.io.IOException;
/* loaded from: classes6.dex */
public class VideoPreviewView extends SurfaceView implements SurfaceHolder.Callback, ix8, Camera.PreviewCallback {
    public static /* synthetic */ Interceptable $ic;
    public transient /* synthetic */ FieldHolder $fh;
    public jx8 a;
    public SurfaceHolder b;
    public MediaRecorder c;
    public boolean d;
    public boolean e;
    public boolean f;
    public ix8.a g;
    public tp7 h;

    @Override // com.baidu.tieba.ix8
    public void setOnEncoderStatusUpdateListener(TextureMovieEncoder.OnEncoderStatusUpdateListener onEncoderStatusUpdateListener) {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeL(1048586, this, onEncoderStatusUpdateListener) == null) {
        }
    }

    @Override // com.baidu.tieba.ix8
    public void setPreviewSize(int i, int i2) {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeII(1048587, this, i, i2) == null) {
        }
    }

    @Override // android.view.SurfaceHolder.Callback
    public void surfaceChanged(SurfaceHolder surfaceHolder, int i, int i2, int i3) {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeLIII(1048588, this, surfaceHolder, i, i2, i3) == null) {
        }
    }

    @Override // android.view.SurfaceHolder.Callback
    public void surfaceDestroyed(SurfaceHolder surfaceHolder) {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeL(1048590, this, surfaceHolder) == null) {
        }
    }

    /* loaded from: classes6.dex */
    public class a implements MediaRecorder.OnErrorListener {
        public static /* synthetic */ Interceptable $ic;
        public transient /* synthetic */ FieldHolder $fh;
        public final /* synthetic */ VideoPreviewView a;

        public a(VideoPreviewView videoPreviewView) {
            Interceptable interceptable = $ic;
            if (interceptable != null) {
                InitContext newInitContext = TitanRuntime.newInitContext();
                newInitContext.initArgs = r2;
                Object[] objArr = {videoPreviewView};
                interceptable.invokeUnInit(65536, newInitContext);
                int i = newInitContext.flag;
                if ((i & 1) != 0) {
                    int i2 = i & 2;
                    newInitContext.thisArg = this;
                    interceptable.invokeInitBody(65536, newInitContext);
                    return;
                }
            }
            this.a = videoPreviewView;
        }

        @Override // android.media.MediaRecorder.OnErrorListener
        public void onError(MediaRecorder mediaRecorder, int i, int i2) {
            Interceptable interceptable = $ic;
            if (interceptable == null || interceptable.invokeLII(1048576, this, mediaRecorder, i, i2) == null) {
                if (mediaRecorder != null) {
                    try {
                        mediaRecorder.reset();
                    } catch (IllegalStateException e) {
                        e.printStackTrace();
                    } catch (Exception e2) {
                        e2.printStackTrace();
                    }
                }
                if (this.a.h != null) {
                    tp7 tp7Var = this.a.h;
                    tp7Var.b(28, "what-->" + i + "  extra-->" + i2);
                }
            }
        }
    }

    /* loaded from: classes6.dex */
    public class b extends BdAsyncTask {
        public static /* synthetic */ Interceptable $ic;
        public transient /* synthetic */ FieldHolder $fh;
        public final /* synthetic */ byte[] a;
        public final /* synthetic */ int b;
        public final /* synthetic */ int c;
        public final /* synthetic */ VideoPreviewView d;

        public b(VideoPreviewView videoPreviewView, byte[] bArr, int i, int i2) {
            Interceptable interceptable = $ic;
            if (interceptable != null) {
                InitContext newInitContext = TitanRuntime.newInitContext();
                newInitContext.initArgs = r2;
                Object[] objArr = {videoPreviewView, bArr, Integer.valueOf(i), Integer.valueOf(i2)};
                interceptable.invokeUnInit(65536, newInitContext);
                int i3 = newInitContext.flag;
                if ((i3 & 1) != 0) {
                    int i4 = i3 & 2;
                    newInitContext.thisArg = this;
                    interceptable.invokeInitBody(65536, newInitContext);
                    return;
                }
            }
            this.d = videoPreviewView;
            this.a = bArr;
            this.b = i;
            this.c = i2;
        }

        /* JADX DEBUG: Method merged with bridge method */
        @Override // com.baidu.adp.lib.asyncTask.BdAsyncTask
        /* renamed from: b */
        public String doInBackground(Void... voidArr) {
            InterceptResult invokeL;
            Interceptable interceptable = $ic;
            if (interceptable == null || (invokeL = interceptable.invokeL(1048576, this, voidArr)) == null) {
                Bitmap bitmap = null;
                try {
                    bitmap = zv8.b(this.a, this.b, this.c);
                    if (this.b > this.c) {
                        Bitmap h = zv8.h(bitmap, 90.0f);
                        if (bitmap != null && !bitmap.isRecycled() && h != null) {
                            bitmap.recycle();
                            bitmap = h;
                        }
                    }
                    return FileHelper.saveFileAsPic(mv8.i, "pic_" + System.currentTimeMillis(), bitmap, 80, Bitmap.CompressFormat.JPEG);
                } finally {
                    if (bitmap != null && !bitmap.isRecycled()) {
                        bitmap.recycle();
                    }
                }
            }
            return (String) invokeL.objValue;
        }

        /* JADX DEBUG: Method merged with bridge method */
        @Override // com.baidu.adp.lib.asyncTask.BdAsyncTask
        public void onPostExecute(String str) {
            Interceptable interceptable = $ic;
            if ((interceptable == null || interceptable.invokeL(1048579, this, str) == null) && this.d.g != null) {
                this.d.g.a(!TextUtils.isEmpty(str), str);
            }
        }
    }

    /* JADX WARN: 'super' call moved to the top of the method (can break code semantics) */
    public VideoPreviewView(Context context, jx8 jx8Var) {
        super(context);
        xp7 xp7Var;
        Interceptable interceptable = $ic;
        if (interceptable != null) {
            InitContext newInitContext = TitanRuntime.newInitContext();
            newInitContext.initArgs = r2;
            Object[] objArr = {context, jx8Var};
            interceptable.invokeUnInit(65536, newInitContext);
            int i = newInitContext.flag;
            if ((i & 1) != 0) {
                int i2 = i & 2;
                super((Context) newInitContext.callArgs[0]);
                newInitContext.thisArg = this;
                interceptable.invokeInitBody(65536, newInitContext);
                return;
            }
        }
        CustomResponsedMessage runTask = MessageManager.getInstance().runTask(2921309, xp7.class);
        if (runTask != null) {
            xp7Var = (xp7) runTask.getData();
        } else {
            xp7Var = null;
        }
        if (xp7Var != null) {
            this.h = xp7Var.get();
        }
        this.a = jx8Var;
        getHolder().addCallback(this);
    }

    @Override // com.baidu.tieba.ix8
    public void b(Camera camera) {
        Interceptable interceptable = $ic;
        if ((interceptable == null || interceptable.invokeL(Constants.METHOD_GET_CONTACTER_INFO_FOR_SESSION, this, camera) == null) && this.d) {
            this.d = false;
        }
    }

    @Override // com.baidu.tieba.ix8
    public void c(ix8.a aVar) {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeL(Constants.METHOD_SEND_USER_MSG, this, aVar) == null) {
            this.g = aVar;
            this.f = true;
        }
    }

    @Override // com.baidu.tieba.ix8
    public void e(Camera camera) {
        MediaRecorder mediaRecorder;
        Interceptable interceptable = $ic;
        if ((interceptable == null || interceptable.invokeL(1048580, this, camera) == null) && (mediaRecorder = this.c) != null) {
            try {
                mediaRecorder.stop();
                this.c.release();
            } catch (Exception e) {
                e.printStackTrace();
                tp7 tp7Var = this.h;
                if (tp7Var != null) {
                    tp7Var.b(29, np7.a(e));
                }
            }
        }
    }

    @Override // android.view.View
    public boolean onTouchEvent(MotionEvent motionEvent) {
        InterceptResult invokeL;
        Interceptable interceptable = $ic;
        if (interceptable == null || (invokeL = interceptable.invokeL(1048585, this, motionEvent)) == null) {
            return this.a.r(motionEvent, getParent());
        }
        return invokeL.booleanValue;
    }

    @Override // android.view.SurfaceHolder.Callback
    public void surfaceCreated(SurfaceHolder surfaceHolder) {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeL(1048589, this, surfaceHolder) == null) {
            this.b = surfaceHolder;
            j();
            this.e = true;
        }
    }

    @Override // com.baidu.tieba.ix8
    public void a(Camera camera) {
        Interceptable interceptable = $ic;
        if ((interceptable == null || interceptable.invokeL(1048576, this, camera) == null) && !this.d && camera != null) {
            this.d = true;
            try {
                camera.setPreviewDisplay(this.b);
                camera.setPreviewCallback(this);
            } catch (IOException e) {
                e.printStackTrace();
                tp7 tp7Var = this.h;
                if (tp7Var != null) {
                    tp7Var.b(27, np7.a(e));
                }
            }
            camera.startPreview();
        }
    }

    @Override // com.baidu.tieba.ix8
    public void d(Camera camera) {
        Interceptable interceptable = $ic;
        if ((interceptable != null && interceptable.invokeL(1048579, this, camera) != null) || camera == null) {
            return;
        }
        MediaRecorder mediaRecorder = new MediaRecorder();
        this.c = mediaRecorder;
        mediaRecorder.reset();
        try {
            camera.unlock();
        } catch (Throwable th) {
            th.printStackTrace();
        }
        this.c.setCamera(camera);
        this.c.setOnErrorListener(new a(this));
        SurfaceHolder surfaceHolder = this.b;
        if (surfaceHolder != null) {
            this.c.setPreviewDisplay(surfaceHolder.getSurface());
        }
        this.c.setVideoSource(1);
        this.c.setAudioSource(1);
        this.c.setOutputFormat(2);
        this.c.setVideoEncoder(2);
        this.c.setAudioEncoder(3);
        this.c.setAudioSamplingRate(48000);
        this.c.setAudioChannels(1);
        this.c.setVideoEncodingBitRate(2097152);
        this.c.setVideoFrameRate(20);
        if (this.a.k) {
            this.c.setOrientationHint(270);
        } else {
            this.c.setOrientationHint(90);
        }
        this.c.setVideoSize(1280, 720);
        File file = new File(mv8.f);
        if (!FileHelper.CheckTempDir(file.getAbsolutePath())) {
            file.mkdirs();
        }
        this.c.setOutputFile(this.a.o());
        try {
            this.c.prepare();
            this.c.start();
        } catch (Throwable th2) {
            th2.printStackTrace();
            tp7 tp7Var = this.h;
            if (tp7Var != null) {
                tp7Var.b(28, np7.a(th2));
            }
        }
    }

    public void h() {
        Interceptable interceptable = $ic;
        if ((interceptable == null || interceptable.invokeV(1048581, this) == null) && this.e) {
            j();
        }
    }

    public final void j() {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeV(1048583, this) == null) {
            Handler n = this.a.n();
            n.sendMessage(n.obtainMessage(1));
        }
    }

    public final void i(byte[] bArr, int i, int i2) {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeLII(1048582, this, bArr, i, i2) == null) {
            new b(this, bArr, i, i2).execute(new Void[0]);
        }
    }

    @Override // android.hardware.Camera.PreviewCallback
    public void onPreviewFrame(byte[] bArr, Camera camera) {
        Interceptable interceptable = $ic;
        if ((interceptable == null || interceptable.invokeLL(InputDeviceCompat.SOURCE_TOUCHPAD, this, bArr, camera) == null) && this.f) {
            if (bArr != null) {
                Camera.Size previewSize = camera.getParameters().getPreviewSize();
                i(bArr, previewSize.width, previewSize.height);
            }
            this.f = false;
        }
    }
}
