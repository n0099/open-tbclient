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
import c.a.p0.l2.k;
import c.a.p0.n4.i.d.c;
import c.a.p0.n4.l.f;
import c.a.p0.n4.l.g;
import com.baidu.adp.framework.MessageManager;
import com.baidu.adp.framework.message.CustomResponsedMessage;
import com.baidu.adp.lib.asyncTask.BdAsyncTask;
import com.baidu.android.imsdk.internal.Constants;
import com.baidu.tbadk.core.util.FileHelper;
import com.baidu.titan.sdk.runtime.FieldHolder;
import com.baidu.titan.sdk.runtime.InitContext;
import com.baidu.titan.sdk.runtime.InterceptResult;
import com.baidu.titan.sdk.runtime.Interceptable;
import com.baidu.titan.sdk.runtime.TitanRuntime;
import com.faceunity.encoder.TextureMovieEncoder;
import java.io.File;
import java.io.IOException;
/* loaded from: classes6.dex */
public class VideoPreviewView extends SurfaceView implements SurfaceHolder.Callback, f, Camera.PreviewCallback {
    public static /* synthetic */ Interceptable $ic;
    public transient /* synthetic */ FieldHolder $fh;
    public g a;

    /* renamed from: b  reason: collision with root package name */
    public SurfaceHolder f36546b;

    /* renamed from: c  reason: collision with root package name */
    public MediaRecorder f36547c;

    /* renamed from: d  reason: collision with root package name */
    public boolean f36548d;

    /* renamed from: e  reason: collision with root package name */
    public boolean f36549e;

    /* renamed from: f  reason: collision with root package name */
    public boolean f36550f;

    /* renamed from: g  reason: collision with root package name */
    public f.a f36551g;

    /* renamed from: h  reason: collision with root package name */
    public c.a.p0.l2.g f36552h;

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
                    } catch (IllegalStateException e2) {
                        e2.printStackTrace();
                    } catch (Exception e3) {
                        e3.printStackTrace();
                    }
                }
                if (this.a.f36552h != null) {
                    c.a.p0.l2.g gVar = this.a.f36552h;
                    gVar.b(28, "what-->" + i + "  extra-->" + i2);
                }
            }
        }
    }

    /* loaded from: classes6.dex */
    public class b extends BdAsyncTask<Void, Void, String> {
        public static /* synthetic */ Interceptable $ic;
        public transient /* synthetic */ FieldHolder $fh;
        public final /* synthetic */ byte[] a;

        /* renamed from: b  reason: collision with root package name */
        public final /* synthetic */ int f36553b;

        /* renamed from: c  reason: collision with root package name */
        public final /* synthetic */ int f36554c;

        /* renamed from: d  reason: collision with root package name */
        public final /* synthetic */ VideoPreviewView f36555d;

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
            this.f36555d = videoPreviewView;
            this.a = bArr;
            this.f36553b = i;
            this.f36554c = i2;
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
                    bitmap = c.b(this.a, this.f36553b, this.f36554c);
                    if (this.f36553b > this.f36554c) {
                        Bitmap h2 = c.h(bitmap, 90.0f);
                        if (bitmap != null && !bitmap.isRecycled() && h2 != null) {
                            bitmap.recycle();
                            bitmap = h2;
                        }
                    }
                    return FileHelper.saveFileAsPic(c.a.p0.n4.c.i, "pic_" + System.currentTimeMillis(), bitmap, 80, Bitmap.CompressFormat.JPEG);
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
            if (!(interceptable == null || interceptable.invokeL(1048579, this, str) == null) || this.f36555d.f36551g == null) {
                return;
            }
            this.f36555d.f36551g.a(!TextUtils.isEmpty(str), str);
        }
    }

    /* JADX WARN: 'super' call moved to the top of the method (can break code semantics) */
    public VideoPreviewView(Context context, g gVar) {
        super(context);
        Interceptable interceptable = $ic;
        if (interceptable != null) {
            InitContext newInitContext = TitanRuntime.newInitContext();
            newInitContext.initArgs = r2;
            Object[] objArr = {context, gVar};
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
        CustomResponsedMessage runTask = MessageManager.getInstance().runTask(2921309, k.class);
        k kVar = runTask != null ? (k) runTask.getData() : null;
        if (kVar != null) {
            this.f36552h = kVar.get();
        }
        this.a = gVar;
        getHolder().addCallback(this);
    }

    @Override // c.a.p0.n4.l.f
    public void a(Camera camera) {
        Interceptable interceptable = $ic;
        if (!(interceptable == null || interceptable.invokeL(1048576, this, camera) == null) || this.f36548d || camera == null) {
            return;
        }
        this.f36548d = true;
        try {
            camera.setPreviewDisplay(this.f36546b);
            camera.setPreviewCallback(this);
        } catch (IOException e2) {
            e2.printStackTrace();
            c.a.p0.l2.g gVar = this.f36552h;
            if (gVar != null) {
                gVar.b(27, c.a.p0.l2.a.a(e2));
            }
        }
        camera.startPreview();
    }

    @Override // c.a.p0.n4.l.f
    public void b(Camera camera) {
        Interceptable interceptable = $ic;
        if ((interceptable == null || interceptable.invokeL(Constants.METHOD_GET_CONTACTER_INFO_FOR_SESSION, this, camera) == null) && this.f36548d) {
            this.f36548d = false;
        }
    }

    @Override // c.a.p0.n4.l.f
    public void c(f.a aVar) {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeL(Constants.METHOD_SEND_USER_MSG, this, aVar) == null) {
            this.f36551g = aVar;
            this.f36550f = true;
        }
    }

    @Override // c.a.p0.n4.l.f
    public void d(Camera camera) {
        Interceptable interceptable = $ic;
        if (!(interceptable == null || interceptable.invokeL(1048579, this, camera) == null) || camera == null) {
            return;
        }
        MediaRecorder mediaRecorder = new MediaRecorder();
        this.f36547c = mediaRecorder;
        mediaRecorder.reset();
        try {
            camera.unlock();
        } catch (Throwable th) {
            th.printStackTrace();
        }
        this.f36547c.setCamera(camera);
        this.f36547c.setOnErrorListener(new a(this));
        SurfaceHolder surfaceHolder = this.f36546b;
        if (surfaceHolder != null) {
            this.f36547c.setPreviewDisplay(surfaceHolder.getSurface());
        }
        this.f36547c.setVideoSource(1);
        this.f36547c.setAudioSource(1);
        this.f36547c.setOutputFormat(2);
        this.f36547c.setVideoEncoder(2);
        this.f36547c.setAudioEncoder(3);
        this.f36547c.setAudioSamplingRate(48000);
        this.f36547c.setAudioChannels(1);
        this.f36547c.setVideoEncodingBitRate(2097152);
        this.f36547c.setVideoFrameRate(20);
        if (this.a.k) {
            this.f36547c.setOrientationHint(270);
        } else {
            this.f36547c.setOrientationHint(90);
        }
        this.f36547c.setVideoSize(1280, 720);
        File file = new File(c.a.p0.n4.c.f16597f);
        if (!FileHelper.CheckTempDir(file.getAbsolutePath())) {
            file.mkdirs();
        }
        this.f36547c.setOutputFile(this.a.o());
        try {
            this.f36547c.prepare();
            this.f36547c.start();
        } catch (Throwable th2) {
            th2.printStackTrace();
            c.a.p0.l2.g gVar = this.f36552h;
            if (gVar != null) {
                gVar.b(28, c.a.p0.l2.a.a(th2));
            }
        }
    }

    @Override // c.a.p0.n4.l.f
    public void e(Camera camera) {
        MediaRecorder mediaRecorder;
        Interceptable interceptable = $ic;
        if (!(interceptable == null || interceptable.invokeL(1048580, this, camera) == null) || (mediaRecorder = this.f36547c) == null) {
            return;
        }
        try {
            mediaRecorder.stop();
            this.f36547c.release();
        } catch (Exception e2) {
            e2.printStackTrace();
            c.a.p0.l2.g gVar = this.f36552h;
            if (gVar != null) {
                gVar.b(29, c.a.p0.l2.a.a(e2));
            }
        }
    }

    public void h() {
        Interceptable interceptable = $ic;
        if ((interceptable == null || interceptable.invokeV(1048581, this) == null) && this.f36549e) {
            j();
        }
    }

    public final void i(byte[] bArr, int i, int i2) {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeLII(1048582, this, bArr, i, i2) == null) {
            new b(this, bArr, i, i2).execute(new Void[0]);
        }
    }

    public final void j() {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeV(1048583, this) == null) {
            Handler n = this.a.n();
            n.sendMessage(n.obtainMessage(1));
        }
    }

    @Override // android.hardware.Camera.PreviewCallback
    public void onPreviewFrame(byte[] bArr, Camera camera) {
        Interceptable interceptable = $ic;
        if ((interceptable == null || interceptable.invokeLL(InputDeviceCompat.SOURCE_TOUCHPAD, this, bArr, camera) == null) && this.f36550f) {
            if (bArr != null) {
                Camera.Size previewSize = camera.getParameters().getPreviewSize();
                i(bArr, previewSize.width, previewSize.height);
            }
            this.f36550f = false;
        }
    }

    @Override // android.view.View
    public boolean onTouchEvent(MotionEvent motionEvent) {
        InterceptResult invokeL;
        Interceptable interceptable = $ic;
        return (interceptable == null || (invokeL = interceptable.invokeL(1048585, this, motionEvent)) == null) ? this.a.r(motionEvent, getParent()) : invokeL.booleanValue;
    }

    @Override // c.a.p0.n4.l.f
    public void setOnEncoderStatusUpdateListener(TextureMovieEncoder.OnEncoderStatusUpdateListener onEncoderStatusUpdateListener) {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeL(1048586, this, onEncoderStatusUpdateListener) == null) {
        }
    }

    @Override // c.a.p0.n4.l.f
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
    public void surfaceCreated(SurfaceHolder surfaceHolder) {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeL(1048589, this, surfaceHolder) == null) {
            this.f36546b = surfaceHolder;
            j();
            this.f36549e = true;
        }
    }

    @Override // android.view.SurfaceHolder.Callback
    public void surfaceDestroyed(SurfaceHolder surfaceHolder) {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeL(1048590, this, surfaceHolder) == null) {
        }
    }
}
