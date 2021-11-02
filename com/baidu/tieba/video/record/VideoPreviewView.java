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
import b.a.r0.a2.k;
import b.a.r0.z3.i.d.c;
import b.a.r0.z3.l.f;
import b.a.r0.z3.l.g;
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
/* loaded from: classes9.dex */
public class VideoPreviewView extends SurfaceView implements SurfaceHolder.Callback, f, Camera.PreviewCallback {
    public static /* synthetic */ Interceptable $ic;
    public transient /* synthetic */ FieldHolder $fh;

    /* renamed from: e  reason: collision with root package name */
    public g f54840e;

    /* renamed from: f  reason: collision with root package name */
    public SurfaceHolder f54841f;

    /* renamed from: g  reason: collision with root package name */
    public MediaRecorder f54842g;

    /* renamed from: h  reason: collision with root package name */
    public boolean f54843h;

    /* renamed from: i  reason: collision with root package name */
    public boolean f54844i;
    public boolean j;
    public f.a k;
    public b.a.r0.a2.g l;

    /* loaded from: classes9.dex */
    public class a implements MediaRecorder.OnErrorListener {
        public static /* synthetic */ Interceptable $ic;
        public transient /* synthetic */ FieldHolder $fh;

        /* renamed from: a  reason: collision with root package name */
        public final /* synthetic */ VideoPreviewView f54845a;

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
            this.f54845a = videoPreviewView;
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
                if (this.f54845a.l != null) {
                    b.a.r0.a2.g gVar = this.f54845a.l;
                    gVar.b(28, "what-->" + i2 + "  extra-->" + i3);
                }
            }
        }
    }

    /* loaded from: classes9.dex */
    public class b extends BdAsyncTask<Void, Void, String> {
        public static /* synthetic */ Interceptable $ic;
        public transient /* synthetic */ FieldHolder $fh;

        /* renamed from: a  reason: collision with root package name */
        public final /* synthetic */ byte[] f54846a;

        /* renamed from: b  reason: collision with root package name */
        public final /* synthetic */ int f54847b;

        /* renamed from: c  reason: collision with root package name */
        public final /* synthetic */ int f54848c;

        /* renamed from: d  reason: collision with root package name */
        public final /* synthetic */ VideoPreviewView f54849d;

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
            this.f54849d = videoPreviewView;
            this.f54846a = bArr;
            this.f54847b = i2;
            this.f54848c = i3;
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
                    bitmap = c.b(this.f54846a, this.f54847b, this.f54848c);
                    if (this.f54847b > this.f54848c) {
                        Bitmap h2 = c.h(bitmap, 90.0f);
                        if (bitmap != null && !bitmap.isRecycled() && h2 != null) {
                            bitmap.recycle();
                            bitmap = h2;
                        }
                    }
                    return FileHelper.saveFileAsPic(b.a.r0.z3.c.f28289i, "pic_" + System.currentTimeMillis(), bitmap, 80, Bitmap.CompressFormat.JPEG);
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
            if (!(interceptable == null || interceptable.invokeL(1048579, this, str) == null) || this.f54849d.k == null) {
                return;
            }
            this.f54849d.k.a(!TextUtils.isEmpty(str), str);
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
        this.f54840e = gVar;
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
            Handler n = this.f54840e.n();
            n.sendMessage(n.obtainMessage(1));
        }
    }

    @Override // android.hardware.Camera.PreviewCallback
    public void onPreviewFrame(byte[] bArr, Camera camera) {
        Interceptable interceptable = $ic;
        if ((interceptable == null || interceptable.invokeLL(Constants.METHOD_SEND_USER_MSG, this, bArr, camera) == null) && this.j) {
            if (bArr != null) {
                Camera.Size previewSize = camera.getParameters().getPreviewSize();
                c(bArr, previewSize.width, previewSize.height);
            }
            this.j = false;
        }
    }

    public void onResume() {
        Interceptable interceptable = $ic;
        if ((interceptable == null || interceptable.invokeV(1048579, this) == null) && this.f54844i) {
            d();
        }
    }

    @Override // android.view.View
    public boolean onTouchEvent(MotionEvent motionEvent) {
        InterceptResult invokeL;
        Interceptable interceptable = $ic;
        return (interceptable == null || (invokeL = interceptable.invokeL(1048580, this, motionEvent)) == null) ? this.f54840e.r(motionEvent, getParent()) : invokeL.booleanValue;
    }

    @Override // b.a.r0.z3.l.f
    public void setOnEncoderStatusUpdateListener(TextureMovieEncoder.OnEncoderStatusUpdateListener onEncoderStatusUpdateListener) {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeL(1048581, this, onEncoderStatusUpdateListener) == null) {
        }
    }

    @Override // b.a.r0.z3.l.f
    public void setPreviewSize(int i2, int i3) {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeII(1048582, this, i2, i3) == null) {
        }
    }

    @Override // b.a.r0.z3.l.f
    public void startPreview(Camera camera) {
        Interceptable interceptable = $ic;
        if (!(interceptable == null || interceptable.invokeL(1048583, this, camera) == null) || this.f54843h || camera == null) {
            return;
        }
        this.f54843h = true;
        try {
            camera.setPreviewDisplay(this.f54841f);
            camera.setPreviewCallback(this);
        } catch (IOException e2) {
            e2.printStackTrace();
            b.a.r0.a2.g gVar = this.l;
            if (gVar != null) {
                gVar.b(27, b.a.r0.a2.a.a(e2));
            }
        }
        camera.startPreview();
    }

    @Override // b.a.r0.z3.l.f
    public void startRecord(Camera camera) {
        Interceptable interceptable = $ic;
        if (!(interceptable == null || interceptable.invokeL(InputDeviceCompat.SOURCE_TOUCHPAD, this, camera) == null) || camera == null) {
            return;
        }
        MediaRecorder mediaRecorder = new MediaRecorder();
        this.f54842g = mediaRecorder;
        mediaRecorder.reset();
        try {
            camera.unlock();
        } catch (Throwable th) {
            th.printStackTrace();
        }
        this.f54842g.setCamera(camera);
        this.f54842g.setOnErrorListener(new a(this));
        SurfaceHolder surfaceHolder = this.f54841f;
        if (surfaceHolder != null) {
            this.f54842g.setPreviewDisplay(surfaceHolder.getSurface());
        }
        this.f54842g.setVideoSource(1);
        this.f54842g.setAudioSource(1);
        this.f54842g.setOutputFormat(2);
        this.f54842g.setVideoEncoder(2);
        this.f54842g.setAudioEncoder(3);
        this.f54842g.setAudioSamplingRate(MediaEncodeParams.AUDIO_SAMPLE_RATE);
        this.f54842g.setAudioChannels(1);
        this.f54842g.setVideoEncodingBitRate(2097152);
        this.f54842g.setVideoFrameRate(20);
        if (this.f54840e.k) {
            this.f54842g.setOrientationHint(270);
        } else {
            this.f54842g.setOrientationHint(90);
        }
        this.f54842g.setVideoSize(1280, 720);
        File file = new File(b.a.r0.z3.c.f28286f);
        if (!FileHelper.CheckTempDir(file.getAbsolutePath())) {
            file.mkdirs();
        }
        this.f54842g.setOutputFile(this.f54840e.o());
        try {
            this.f54842g.prepare();
            this.f54842g.start();
        } catch (Throwable th2) {
            th2.printStackTrace();
            b.a.r0.a2.g gVar = this.l;
            if (gVar != null) {
                gVar.b(28, b.a.r0.a2.a.a(th2));
            }
        }
    }

    @Override // b.a.r0.z3.l.f
    public void stopPreview(Camera camera) {
        Interceptable interceptable = $ic;
        if ((interceptable == null || interceptable.invokeL(1048585, this, camera) == null) && this.f54843h) {
            this.f54843h = false;
        }
    }

    @Override // b.a.r0.z3.l.f
    public void stopRecord(Camera camera) {
        MediaRecorder mediaRecorder;
        Interceptable interceptable = $ic;
        if (!(interceptable == null || interceptable.invokeL(1048586, this, camera) == null) || (mediaRecorder = this.f54842g) == null) {
            return;
        }
        try {
            mediaRecorder.stop();
            this.f54842g.release();
        } catch (Exception e2) {
            e2.printStackTrace();
            b.a.r0.a2.g gVar = this.l;
            if (gVar != null) {
                gVar.b(29, b.a.r0.a2.a.a(e2));
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
            this.f54841f = surfaceHolder;
            d();
            this.f54844i = true;
        }
    }

    @Override // android.view.SurfaceHolder.Callback
    public void surfaceDestroyed(SurfaceHolder surfaceHolder) {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeL(1048589, this, surfaceHolder) == null) {
        }
    }

    @Override // b.a.r0.z3.l.f
    public void takePicture(f.a aVar) {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeL(1048590, this, aVar) == null) {
            this.k = aVar;
            this.j = true;
        }
    }
}
