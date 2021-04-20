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
import com.baidu.adp.framework.MessageManager;
import com.baidu.adp.framework.message.CustomResponsedMessage;
import com.baidu.adp.lib.asyncTask.BdAsyncTask;
import com.baidu.rtc.PeerConnectionClient;
import com.baidu.tbadk.core.util.FileHelper;
import d.b.i0.q3.j.d.c;
import d.b.i0.q3.m.g;
import d.b.i0.q3.m.h;
import d.b.i0.t1.k;
import d.e.b.d;
import java.io.File;
import java.io.IOException;
/* loaded from: classes5.dex */
public class VideoPreviewView extends SurfaceView implements SurfaceHolder.Callback, g, Camera.PreviewCallback {

    /* renamed from: e  reason: collision with root package name */
    public h f21580e;

    /* renamed from: f  reason: collision with root package name */
    public SurfaceHolder f21581f;

    /* renamed from: g  reason: collision with root package name */
    public MediaRecorder f21582g;

    /* renamed from: h  reason: collision with root package name */
    public boolean f21583h;
    public boolean i;
    public boolean j;
    public g.a k;
    public d.b.i0.t1.g l;

    /* loaded from: classes5.dex */
    public class a implements MediaRecorder.OnErrorListener {
        public a() {
        }

        @Override // android.media.MediaRecorder.OnErrorListener
        public void onError(MediaRecorder mediaRecorder, int i, int i2) {
            if (mediaRecorder != null) {
                try {
                    mediaRecorder.reset();
                } catch (IllegalStateException e2) {
                    e2.printStackTrace();
                } catch (Exception e3) {
                    e3.printStackTrace();
                }
            }
            if (VideoPreviewView.this.l != null) {
                d.b.i0.t1.g gVar = VideoPreviewView.this.l;
                gVar.c(28, "what-->" + i + "  extra-->" + i2);
            }
        }
    }

    /* loaded from: classes5.dex */
    public class b extends BdAsyncTask<Void, Void, String> {

        /* renamed from: a  reason: collision with root package name */
        public final /* synthetic */ byte[] f21585a;

        /* renamed from: b  reason: collision with root package name */
        public final /* synthetic */ int f21586b;

        /* renamed from: c  reason: collision with root package name */
        public final /* synthetic */ int f21587c;

        public b(byte[] bArr, int i, int i2) {
            this.f21585a = bArr;
            this.f21586b = i;
            this.f21587c = i2;
        }

        /* JADX DEBUG: Method merged with bridge method */
        @Override // com.baidu.adp.lib.asyncTask.BdAsyncTask
        /* renamed from: b */
        public String doInBackground(Void... voidArr) {
            Bitmap bitmap = null;
            try {
                bitmap = c.b(this.f21585a, this.f21586b, this.f21587c);
                if (this.f21586b > this.f21587c) {
                    Bitmap h2 = c.h(bitmap, 90.0f);
                    if (bitmap != null && !bitmap.isRecycled() && h2 != null) {
                        bitmap.recycle();
                        bitmap = h2;
                    }
                }
                return FileHelper.saveFileAsPic(d.b.i0.q3.c.f60561f, "pic_" + System.currentTimeMillis(), bitmap, 80, Bitmap.CompressFormat.JPEG);
            } finally {
                if (bitmap != null && !bitmap.isRecycled()) {
                    bitmap.recycle();
                }
            }
        }

        /* JADX DEBUG: Method merged with bridge method */
        @Override // com.baidu.adp.lib.asyncTask.BdAsyncTask
        public void onPostExecute(String str) {
            if (VideoPreviewView.this.k != null) {
                VideoPreviewView.this.k.a(!TextUtils.isEmpty(str), str);
            }
        }
    }

    public VideoPreviewView(Context context, h hVar) {
        super(context);
        CustomResponsedMessage runTask = MessageManager.getInstance().runTask(2921309, k.class);
        k kVar = runTask != null ? (k) runTask.getData() : null;
        if (kVar != null) {
            this.l = kVar.get();
        }
        this.f21580e = hVar;
        getHolder().addCallback(this);
    }

    @Override // d.b.i0.q3.m.g
    public void a(Camera camera) {
        if (this.f21583h || camera == null) {
            return;
        }
        this.f21583h = true;
        try {
            camera.setPreviewDisplay(this.f21581f);
            camera.setPreviewCallback(this);
        } catch (IOException e2) {
            e2.printStackTrace();
            d.b.i0.t1.g gVar = this.l;
            if (gVar != null) {
                gVar.c(27, d.b.i0.t1.a.a(e2));
            }
        }
        camera.startPreview();
    }

    @Override // d.b.i0.q3.m.g
    public void b(Camera camera) {
        if (camera == null) {
            return;
        }
        MediaRecorder mediaRecorder = new MediaRecorder();
        this.f21582g = mediaRecorder;
        mediaRecorder.reset();
        try {
            camera.unlock();
        } catch (Throwable th) {
            th.printStackTrace();
        }
        this.f21582g.setCamera(camera);
        this.f21582g.setOnErrorListener(new a());
        SurfaceHolder surfaceHolder = this.f21581f;
        if (surfaceHolder != null) {
            this.f21582g.setPreviewDisplay(surfaceHolder.getSurface());
        }
        this.f21582g.setVideoSource(1);
        this.f21582g.setAudioSource(1);
        this.f21582g.setOutputFormat(2);
        this.f21582g.setVideoEncoder(2);
        this.f21582g.setAudioEncoder(3);
        this.f21582g.setAudioSamplingRate(48000);
        this.f21582g.setAudioChannels(1);
        this.f21582g.setVideoEncodingBitRate(2097152);
        this.f21582g.setVideoFrameRate(20);
        if (this.f21580e.k) {
            this.f21582g.setOrientationHint(270);
        } else {
            this.f21582g.setOrientationHint(90);
        }
        this.f21582g.setVideoSize(1280, PeerConnectionClient.HD_VIDEO_HEIGHT);
        File file = new File(d.b.i0.q3.c.f60558c);
        if (!FileHelper.CheckTempDir(file.getAbsolutePath())) {
            file.mkdirs();
        }
        this.f21582g.setOutputFile(this.f21580e.o());
        try {
            this.f21582g.prepare();
            this.f21582g.start();
        } catch (Throwable th2) {
            th2.printStackTrace();
            d.b.i0.t1.g gVar = this.l;
            if (gVar != null) {
                gVar.c(28, d.b.i0.t1.a.a(th2));
            }
        }
    }

    @Override // d.b.i0.q3.m.g
    public void c(Camera camera) {
        if (this.f21583h) {
            this.f21583h = false;
        }
    }

    @Override // d.b.i0.q3.m.g
    public void d(Camera camera) {
        MediaRecorder mediaRecorder = this.f21582g;
        if (mediaRecorder != null) {
            try {
                mediaRecorder.stop();
                this.f21582g.release();
            } catch (Exception e2) {
                e2.printStackTrace();
                d.b.i0.t1.g gVar = this.l;
                if (gVar != null) {
                    gVar.c(29, d.b.i0.t1.a.a(e2));
                }
            }
        }
    }

    @Override // d.b.i0.q3.m.g
    public void e(g.a aVar) {
        this.k = aVar;
        this.j = true;
    }

    public void h() {
        if (this.i) {
            j();
        }
    }

    public final void i(byte[] bArr, int i, int i2) {
        new b(bArr, i, i2).execute(new Void[0]);
    }

    public final void j() {
        Handler n = this.f21580e.n();
        n.sendMessage(n.obtainMessage(1));
    }

    @Override // android.hardware.Camera.PreviewCallback
    public void onPreviewFrame(byte[] bArr, Camera camera) {
        if (this.j) {
            if (bArr != null) {
                Camera.Size previewSize = camera.getParameters().getPreviewSize();
                i(bArr, previewSize.width, previewSize.height);
            }
            this.j = false;
        }
    }

    @Override // android.view.View
    public boolean onTouchEvent(MotionEvent motionEvent) {
        return this.f21580e.r(motionEvent, getParent());
    }

    @Override // d.b.i0.q3.m.g
    public void setOnEncoderStatusUpdateListener(d.InterfaceC1833d interfaceC1833d) {
    }

    @Override // d.b.i0.q3.m.g
    public void setPreviewSize(int i, int i2) {
    }

    @Override // android.view.SurfaceHolder.Callback
    public void surfaceChanged(SurfaceHolder surfaceHolder, int i, int i2, int i3) {
    }

    @Override // android.view.SurfaceHolder.Callback
    public void surfaceCreated(SurfaceHolder surfaceHolder) {
        this.f21581f = surfaceHolder;
        j();
        this.i = true;
    }

    @Override // android.view.SurfaceHolder.Callback
    public void surfaceDestroyed(SurfaceHolder surfaceHolder) {
    }
}
