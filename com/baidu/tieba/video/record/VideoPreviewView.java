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
import com.baidu.rtc.record.MediaEncodeParams;
import com.baidu.tbadk.core.util.FileHelper;
import com.baidu.titan.sdk.runtime.FieldHolder;
import com.baidu.titan.sdk.runtime.InitContext;
import com.baidu.titan.sdk.runtime.InterceptResult;
import com.baidu.titan.sdk.runtime.Interceptable;
import com.baidu.titan.sdk.runtime.TitanRuntime;
import com.faceunity.encoder.TextureMovieEncoder;
import d.a.q0.v3.i.d.c;
import d.a.q0.v3.l.g;
import d.a.q0.v3.l.h;
import d.a.q0.x1.k;
import java.io.File;
import java.io.IOException;
/* loaded from: classes4.dex */
public class VideoPreviewView extends SurfaceView implements SurfaceHolder.Callback, g, Camera.PreviewCallback {
    public static /* synthetic */ Interceptable $ic;
    public transient /* synthetic */ FieldHolder $fh;

    /* renamed from: e  reason: collision with root package name */
    public h f21851e;

    /* renamed from: f  reason: collision with root package name */
    public SurfaceHolder f21852f;

    /* renamed from: g  reason: collision with root package name */
    public MediaRecorder f21853g;

    /* renamed from: h  reason: collision with root package name */
    public boolean f21854h;

    /* renamed from: i  reason: collision with root package name */
    public boolean f21855i;
    public boolean j;
    public g.a k;
    public d.a.q0.x1.g l;

    /* loaded from: classes4.dex */
    public class a implements MediaRecorder.OnErrorListener {
        public static /* synthetic */ Interceptable $ic;
        public transient /* synthetic */ FieldHolder $fh;

        /* renamed from: a  reason: collision with root package name */
        public final /* synthetic */ VideoPreviewView f21856a;

        public a(VideoPreviewView videoPreviewView) {
            Interceptable interceptable = $ic;
            if (interceptable != null) {
                InitContext newInitContext = TitanRuntime.newInitContext();
                newInitContext.initArgs = r2;
                Object[] objArr = {videoPreviewView};
                interceptable.invokeUnInit(65536, newInitContext);
                int i2 = newInitContext.flag;
                if ((i2 & 1) != 0) {
                    int i3 = i2 & 2;
                    newInitContext.thisArg = this;
                    interceptable.invokeInitBody(65536, newInitContext);
                    return;
                }
            }
            this.f21856a = videoPreviewView;
        }

        @Override // android.media.MediaRecorder.OnErrorListener
        public void onError(MediaRecorder mediaRecorder, int i2, int i3) {
            Interceptable interceptable = $ic;
            if (interceptable == null || interceptable.invokeLII(1048576, this, mediaRecorder, i2, i3) == null) {
                if (mediaRecorder != null) {
                    try {
                        mediaRecorder.reset();
                    } catch (IllegalStateException e2) {
                        e2.printStackTrace();
                    } catch (Exception e3) {
                        e3.printStackTrace();
                    }
                }
                if (this.f21856a.l != null) {
                    d.a.q0.x1.g gVar = this.f21856a.l;
                    gVar.b(28, "what-->" + i2 + "  extra-->" + i3);
                }
            }
        }
    }

    /* loaded from: classes4.dex */
    public class b extends BdAsyncTask<Void, Void, String> {
        public static /* synthetic */ Interceptable $ic;
        public transient /* synthetic */ FieldHolder $fh;

        /* renamed from: a  reason: collision with root package name */
        public final /* synthetic */ byte[] f21857a;

        /* renamed from: b  reason: collision with root package name */
        public final /* synthetic */ int f21858b;

        /* renamed from: c  reason: collision with root package name */
        public final /* synthetic */ int f21859c;

        /* renamed from: d  reason: collision with root package name */
        public final /* synthetic */ VideoPreviewView f21860d;

        public b(VideoPreviewView videoPreviewView, byte[] bArr, int i2, int i3) {
            Interceptable interceptable = $ic;
            if (interceptable != null) {
                InitContext newInitContext = TitanRuntime.newInitContext();
                newInitContext.initArgs = r2;
                Object[] objArr = {videoPreviewView, bArr, Integer.valueOf(i2), Integer.valueOf(i3)};
                interceptable.invokeUnInit(65536, newInitContext);
                int i4 = newInitContext.flag;
                if ((i4 & 1) != 0) {
                    int i5 = i4 & 2;
                    newInitContext.thisArg = this;
                    interceptable.invokeInitBody(65536, newInitContext);
                    return;
                }
            }
            this.f21860d = videoPreviewView;
            this.f21857a = bArr;
            this.f21858b = i2;
            this.f21859c = i3;
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
                    bitmap = c.b(this.f21857a, this.f21858b, this.f21859c);
                    if (this.f21858b > this.f21859c) {
                        Bitmap h2 = c.h(bitmap, 90.0f);
                        if (bitmap != null && !bitmap.isRecycled() && h2 != null) {
                            bitmap.recycle();
                            bitmap = h2;
                        }
                    }
                    return FileHelper.saveFileAsPic(d.a.q0.v3.c.f66026i, "pic_" + System.currentTimeMillis(), bitmap, 80, Bitmap.CompressFormat.JPEG);
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
            if (!(interceptable == null || interceptable.invokeL(1048579, this, str) == null) || this.f21860d.k == null) {
                return;
            }
            this.f21860d.k.a(!TextUtils.isEmpty(str), str);
        }
    }

    /* JADX WARN: 'super' call moved to the top of the method (can break code semantics) */
    public VideoPreviewView(Context context, h hVar) {
        super(context);
        Interceptable interceptable = $ic;
        if (interceptable != null) {
            InitContext newInitContext = TitanRuntime.newInitContext();
            newInitContext.initArgs = r2;
            Object[] objArr = {context, hVar};
            interceptable.invokeUnInit(65536, newInitContext);
            int i2 = newInitContext.flag;
            if ((i2 & 1) != 0) {
                int i3 = i2 & 2;
                super((Context) newInitContext.callArgs[0]);
                newInitContext.thisArg = this;
                interceptable.invokeInitBody(65536, newInitContext);
                return;
            }
        }
        CustomResponsedMessage runTask = MessageManager.getInstance().runTask(2921309, k.class);
        k kVar = runTask != null ? (k) runTask.getData() : null;
        if (kVar != null) {
            this.l = kVar.get();
        }
        this.f21851e = hVar;
        getHolder().addCallback(this);
    }

    @Override // d.a.q0.v3.l.g
    public void a(Camera camera) {
        Interceptable interceptable = $ic;
        if (!(interceptable == null || interceptable.invokeL(1048576, this, camera) == null) || this.f21854h || camera == null) {
            return;
        }
        this.f21854h = true;
        try {
            camera.setPreviewDisplay(this.f21852f);
            camera.setPreviewCallback(this);
        } catch (IOException e2) {
            e2.printStackTrace();
            d.a.q0.x1.g gVar = this.l;
            if (gVar != null) {
                gVar.b(27, d.a.q0.x1.a.a(e2));
            }
        }
        camera.startPreview();
    }

    @Override // d.a.q0.v3.l.g
    public void b(Camera camera) {
        Interceptable interceptable = $ic;
        if ((interceptable == null || interceptable.invokeL(Constants.METHOD_GET_CONTACTER_INFO_FOR_SESSION, this, camera) == null) && this.f21854h) {
            this.f21854h = false;
        }
    }

    @Override // d.a.q0.v3.l.g
    public void c(g.a aVar) {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeL(Constants.METHOD_SEND_USER_MSG, this, aVar) == null) {
            this.k = aVar;
            this.j = true;
        }
    }

    @Override // d.a.q0.v3.l.g
    public void d(Camera camera) {
        Interceptable interceptable = $ic;
        if (!(interceptable == null || interceptable.invokeL(1048579, this, camera) == null) || camera == null) {
            return;
        }
        MediaRecorder mediaRecorder = new MediaRecorder();
        this.f21853g = mediaRecorder;
        mediaRecorder.reset();
        try {
            camera.unlock();
        } catch (Throwable th) {
            th.printStackTrace();
        }
        this.f21853g.setCamera(camera);
        this.f21853g.setOnErrorListener(new a(this));
        SurfaceHolder surfaceHolder = this.f21852f;
        if (surfaceHolder != null) {
            this.f21853g.setPreviewDisplay(surfaceHolder.getSurface());
        }
        this.f21853g.setVideoSource(1);
        this.f21853g.setAudioSource(1);
        this.f21853g.setOutputFormat(2);
        this.f21853g.setVideoEncoder(2);
        this.f21853g.setAudioEncoder(3);
        this.f21853g.setAudioSamplingRate(MediaEncodeParams.AUDIO_SAMPLE_RATE);
        this.f21853g.setAudioChannels(1);
        this.f21853g.setVideoEncodingBitRate(2097152);
        this.f21853g.setVideoFrameRate(20);
        if (this.f21851e.k) {
            this.f21853g.setOrientationHint(270);
        } else {
            this.f21853g.setOrientationHint(90);
        }
        this.f21853g.setVideoSize(1280, 720);
        File file = new File(d.a.q0.v3.c.f66023f);
        if (!FileHelper.CheckTempDir(file.getAbsolutePath())) {
            file.mkdirs();
        }
        this.f21853g.setOutputFile(this.f21851e.o());
        try {
            this.f21853g.prepare();
            this.f21853g.start();
        } catch (Throwable th2) {
            th2.printStackTrace();
            d.a.q0.x1.g gVar = this.l;
            if (gVar != null) {
                gVar.b(28, d.a.q0.x1.a.a(th2));
            }
        }
    }

    @Override // d.a.q0.v3.l.g
    public void e(Camera camera) {
        MediaRecorder mediaRecorder;
        Interceptable interceptable = $ic;
        if (!(interceptable == null || interceptable.invokeL(1048580, this, camera) == null) || (mediaRecorder = this.f21853g) == null) {
            return;
        }
        try {
            mediaRecorder.stop();
            this.f21853g.release();
        } catch (Exception e2) {
            e2.printStackTrace();
            d.a.q0.x1.g gVar = this.l;
            if (gVar != null) {
                gVar.b(29, d.a.q0.x1.a.a(e2));
            }
        }
    }

    public void h() {
        Interceptable interceptable = $ic;
        if ((interceptable == null || interceptable.invokeV(1048581, this) == null) && this.f21855i) {
            j();
        }
    }

    public final void i(byte[] bArr, int i2, int i3) {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeLII(1048582, this, bArr, i2, i3) == null) {
            new b(this, bArr, i2, i3).execute(new Void[0]);
        }
    }

    public final void j() {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeV(1048583, this) == null) {
            Handler n = this.f21851e.n();
            n.sendMessage(n.obtainMessage(1));
        }
    }

    @Override // android.hardware.Camera.PreviewCallback
    public void onPreviewFrame(byte[] bArr, Camera camera) {
        Interceptable interceptable = $ic;
        if ((interceptable == null || interceptable.invokeLL(InputDeviceCompat.SOURCE_TOUCHPAD, this, bArr, camera) == null) && this.j) {
            if (bArr != null) {
                Camera.Size previewSize = camera.getParameters().getPreviewSize();
                i(bArr, previewSize.width, previewSize.height);
            }
            this.j = false;
        }
    }

    @Override // android.view.View
    public boolean onTouchEvent(MotionEvent motionEvent) {
        InterceptResult invokeL;
        Interceptable interceptable = $ic;
        return (interceptable == null || (invokeL = interceptable.invokeL(1048585, this, motionEvent)) == null) ? this.f21851e.r(motionEvent, getParent()) : invokeL.booleanValue;
    }

    @Override // d.a.q0.v3.l.g
    public void setOnEncoderStatusUpdateListener(TextureMovieEncoder.OnEncoderStatusUpdateListener onEncoderStatusUpdateListener) {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeL(1048586, this, onEncoderStatusUpdateListener) == null) {
        }
    }

    @Override // d.a.q0.v3.l.g
    public void setPreviewSize(int i2, int i3) {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeII(1048587, this, i2, i3) == null) {
        }
    }

    @Override // android.view.SurfaceHolder.Callback
    public void surfaceChanged(SurfaceHolder surfaceHolder, int i2, int i3, int i4) {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeLIII(1048588, this, surfaceHolder, i2, i3, i4) == null) {
        }
    }

    @Override // android.view.SurfaceHolder.Callback
    public void surfaceCreated(SurfaceHolder surfaceHolder) {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeL(1048589, this, surfaceHolder) == null) {
            this.f21852f = surfaceHolder;
            j();
            this.f21855i = true;
        }
    }

    @Override // android.view.SurfaceHolder.Callback
    public void surfaceDestroyed(SurfaceHolder surfaceHolder) {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeL(1048590, this, surfaceHolder) == null) {
        }
    }
}
