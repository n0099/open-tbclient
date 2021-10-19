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
import c.a.r0.a2.k;
import c.a.r0.y3.i.d.c;
import c.a.r0.y3.l.f;
import c.a.r0.y3.l.g;
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
import java.io.File;
import java.io.IOException;
/* loaded from: classes7.dex */
public class VideoPreviewView extends SurfaceView implements SurfaceHolder.Callback, f, Camera.PreviewCallback {
    public static /* synthetic */ Interceptable $ic;
    public transient /* synthetic */ FieldHolder $fh;

    /* renamed from: e  reason: collision with root package name */
    public g f57807e;

    /* renamed from: f  reason: collision with root package name */
    public SurfaceHolder f57808f;

    /* renamed from: g  reason: collision with root package name */
    public MediaRecorder f57809g;

    /* renamed from: h  reason: collision with root package name */
    public boolean f57810h;

    /* renamed from: i  reason: collision with root package name */
    public boolean f57811i;

    /* renamed from: j  reason: collision with root package name */
    public boolean f57812j;
    public f.a k;
    public c.a.r0.a2.g l;

    /* loaded from: classes7.dex */
    public class a implements MediaRecorder.OnErrorListener {
        public static /* synthetic */ Interceptable $ic;
        public transient /* synthetic */ FieldHolder $fh;

        /* renamed from: a  reason: collision with root package name */
        public final /* synthetic */ VideoPreviewView f57813a;

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
            this.f57813a = videoPreviewView;
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
                if (this.f57813a.l != null) {
                    c.a.r0.a2.g gVar = this.f57813a.l;
                    gVar.b(28, "what-->" + i2 + "  extra-->" + i3);
                }
            }
        }
    }

    /* loaded from: classes7.dex */
    public class b extends BdAsyncTask<Void, Void, String> {
        public static /* synthetic */ Interceptable $ic;
        public transient /* synthetic */ FieldHolder $fh;

        /* renamed from: a  reason: collision with root package name */
        public final /* synthetic */ byte[] f57814a;

        /* renamed from: b  reason: collision with root package name */
        public final /* synthetic */ int f57815b;

        /* renamed from: c  reason: collision with root package name */
        public final /* synthetic */ int f57816c;

        /* renamed from: d  reason: collision with root package name */
        public final /* synthetic */ VideoPreviewView f57817d;

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
            this.f57817d = videoPreviewView;
            this.f57814a = bArr;
            this.f57815b = i2;
            this.f57816c = i3;
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
                    bitmap = c.b(this.f57814a, this.f57815b, this.f57816c);
                    if (this.f57815b > this.f57816c) {
                        Bitmap h2 = c.h(bitmap, 90.0f);
                        if (bitmap != null && !bitmap.isRecycled() && h2 != null) {
                            bitmap.recycle();
                            bitmap = h2;
                        }
                    }
                    return FileHelper.saveFileAsPic(c.a.r0.y3.c.f29084i, "pic_" + System.currentTimeMillis(), bitmap, 80, Bitmap.CompressFormat.JPEG);
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
            if (!(interceptable == null || interceptable.invokeL(1048579, this, str) == null) || this.f57817d.k == null) {
                return;
            }
            this.f57817d.k.a(!TextUtils.isEmpty(str), str);
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
        this.f57807e = gVar;
        getHolder().addCallback(this);
    }

    public final void c(byte[] bArr, int i2, int i3) {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeLII(1048576, this, bArr, i2, i3) == null) {
            new b(this, bArr, i2, i3).execute(new Void[0]);
        }
    }

    public final void d() {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeV(Constants.METHOD_GET_CONTACTER_INFO_FOR_SESSION, this) == null) {
            Handler n = this.f57807e.n();
            n.sendMessage(n.obtainMessage(1));
        }
    }

    @Override // android.hardware.Camera.PreviewCallback
    public void onPreviewFrame(byte[] bArr, Camera camera) {
        Interceptable interceptable = $ic;
        if ((interceptable == null || interceptable.invokeLL(Constants.METHOD_SEND_USER_MSG, this, bArr, camera) == null) && this.f57812j) {
            if (bArr != null) {
                Camera.Size previewSize = camera.getParameters().getPreviewSize();
                c(bArr, previewSize.width, previewSize.height);
            }
            this.f57812j = false;
        }
    }

    public void onResume() {
        Interceptable interceptable = $ic;
        if ((interceptable == null || interceptable.invokeV(1048579, this) == null) && this.f57811i) {
            d();
        }
    }

    @Override // android.view.View
    public boolean onTouchEvent(MotionEvent motionEvent) {
        InterceptResult invokeL;
        Interceptable interceptable = $ic;
        return (interceptable == null || (invokeL = interceptable.invokeL(1048580, this, motionEvent)) == null) ? this.f57807e.r(motionEvent, getParent()) : invokeL.booleanValue;
    }

    @Override // c.a.r0.y3.l.f
    public void setOnEncoderStatusUpdateListener(TextureMovieEncoder.OnEncoderStatusUpdateListener onEncoderStatusUpdateListener) {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeL(1048581, this, onEncoderStatusUpdateListener) == null) {
        }
    }

    @Override // c.a.r0.y3.l.f
    public void setPreviewSize(int i2, int i3) {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeII(1048582, this, i2, i3) == null) {
        }
    }

    @Override // c.a.r0.y3.l.f
    public void startPreview(Camera camera) {
        Interceptable interceptable = $ic;
        if (!(interceptable == null || interceptable.invokeL(1048583, this, camera) == null) || this.f57810h || camera == null) {
            return;
        }
        this.f57810h = true;
        try {
            camera.setPreviewDisplay(this.f57808f);
            camera.setPreviewCallback(this);
        } catch (IOException e2) {
            e2.printStackTrace();
            c.a.r0.a2.g gVar = this.l;
            if (gVar != null) {
                gVar.b(27, c.a.r0.a2.a.a(e2));
            }
        }
        camera.startPreview();
    }

    @Override // c.a.r0.y3.l.f
    public void startRecord(Camera camera) {
        Interceptable interceptable = $ic;
        if (!(interceptable == null || interceptable.invokeL(InputDeviceCompat.SOURCE_TOUCHPAD, this, camera) == null) || camera == null) {
            return;
        }
        MediaRecorder mediaRecorder = new MediaRecorder();
        this.f57809g = mediaRecorder;
        mediaRecorder.reset();
        try {
            camera.unlock();
        } catch (Throwable th) {
            th.printStackTrace();
        }
        this.f57809g.setCamera(camera);
        this.f57809g.setOnErrorListener(new a(this));
        SurfaceHolder surfaceHolder = this.f57808f;
        if (surfaceHolder != null) {
            this.f57809g.setPreviewDisplay(surfaceHolder.getSurface());
        }
        this.f57809g.setVideoSource(1);
        this.f57809g.setAudioSource(1);
        this.f57809g.setOutputFormat(2);
        this.f57809g.setVideoEncoder(2);
        this.f57809g.setAudioEncoder(3);
        this.f57809g.setAudioSamplingRate(MediaEncodeParams.AUDIO_SAMPLE_RATE);
        this.f57809g.setAudioChannels(1);
        this.f57809g.setVideoEncodingBitRate(2097152);
        this.f57809g.setVideoFrameRate(20);
        if (this.f57807e.k) {
            this.f57809g.setOrientationHint(270);
        } else {
            this.f57809g.setOrientationHint(90);
        }
        this.f57809g.setVideoSize(1280, 720);
        File file = new File(c.a.r0.y3.c.f29081f);
        if (!FileHelper.CheckTempDir(file.getAbsolutePath())) {
            file.mkdirs();
        }
        this.f57809g.setOutputFile(this.f57807e.o());
        try {
            this.f57809g.prepare();
            this.f57809g.start();
        } catch (Throwable th2) {
            th2.printStackTrace();
            c.a.r0.a2.g gVar = this.l;
            if (gVar != null) {
                gVar.b(28, c.a.r0.a2.a.a(th2));
            }
        }
    }

    @Override // c.a.r0.y3.l.f
    public void stopPreview(Camera camera) {
        Interceptable interceptable = $ic;
        if ((interceptable == null || interceptable.invokeL(1048585, this, camera) == null) && this.f57810h) {
            this.f57810h = false;
        }
    }

    @Override // c.a.r0.y3.l.f
    public void stopRecord(Camera camera) {
        MediaRecorder mediaRecorder;
        Interceptable interceptable = $ic;
        if (!(interceptable == null || interceptable.invokeL(1048586, this, camera) == null) || (mediaRecorder = this.f57809g) == null) {
            return;
        }
        try {
            mediaRecorder.stop();
            this.f57809g.release();
        } catch (Exception e2) {
            e2.printStackTrace();
            c.a.r0.a2.g gVar = this.l;
            if (gVar != null) {
                gVar.b(29, c.a.r0.a2.a.a(e2));
            }
        }
    }

    @Override // android.view.SurfaceHolder.Callback
    public void surfaceChanged(SurfaceHolder surfaceHolder, int i2, int i3, int i4) {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeLIII(1048587, this, surfaceHolder, i2, i3, i4) == null) {
        }
    }

    @Override // android.view.SurfaceHolder.Callback
    public void surfaceCreated(SurfaceHolder surfaceHolder) {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeL(1048588, this, surfaceHolder) == null) {
            this.f57808f = surfaceHolder;
            d();
            this.f57811i = true;
        }
    }

    @Override // android.view.SurfaceHolder.Callback
    public void surfaceDestroyed(SurfaceHolder surfaceHolder) {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeL(1048589, this, surfaceHolder) == null) {
        }
    }

    @Override // c.a.r0.y3.l.f
    public void takePicture(f.a aVar) {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeL(1048590, this, aVar) == null) {
            this.k = aVar;
            this.f57812j = true;
        }
    }
}
