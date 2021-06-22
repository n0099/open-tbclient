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
import d.a.o0.r3.i.d.c;
import d.a.o0.r3.l.g;
import d.a.o0.r3.l.h;
import d.a.o0.u1.k;
import d.e.b.d;
import java.io.File;
import java.io.IOException;
/* loaded from: classes5.dex */
public class VideoPreviewView extends SurfaceView implements SurfaceHolder.Callback, g, Camera.PreviewCallback {

    /* renamed from: e  reason: collision with root package name */
    public h f21557e;

    /* renamed from: f  reason: collision with root package name */
    public SurfaceHolder f21558f;

    /* renamed from: g  reason: collision with root package name */
    public MediaRecorder f21559g;

    /* renamed from: h  reason: collision with root package name */
    public boolean f21560h;

    /* renamed from: i  reason: collision with root package name */
    public boolean f21561i;
    public boolean j;
    public g.a k;
    public d.a.o0.u1.g l;

    /* loaded from: classes5.dex */
    public class a implements MediaRecorder.OnErrorListener {
        public a() {
        }

        @Override // android.media.MediaRecorder.OnErrorListener
        public void onError(MediaRecorder mediaRecorder, int i2, int i3) {
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
                d.a.o0.u1.g gVar = VideoPreviewView.this.l;
                gVar.b(28, "what-->" + i2 + "  extra-->" + i3);
            }
        }
    }

    /* loaded from: classes5.dex */
    public class b extends BdAsyncTask<Void, Void, String> {

        /* renamed from: a  reason: collision with root package name */
        public final /* synthetic */ byte[] f21563a;

        /* renamed from: b  reason: collision with root package name */
        public final /* synthetic */ int f21564b;

        /* renamed from: c  reason: collision with root package name */
        public final /* synthetic */ int f21565c;

        public b(byte[] bArr, int i2, int i3) {
            this.f21563a = bArr;
            this.f21564b = i2;
            this.f21565c = i3;
        }

        /* JADX DEBUG: Method merged with bridge method */
        @Override // com.baidu.adp.lib.asyncTask.BdAsyncTask
        /* renamed from: b */
        public String doInBackground(Void... voidArr) {
            Bitmap bitmap = null;
            try {
                bitmap = c.b(this.f21563a, this.f21564b, this.f21565c);
                if (this.f21564b > this.f21565c) {
                    Bitmap h2 = c.h(bitmap, 90.0f);
                    if (bitmap != null && !bitmap.isRecycled() && h2 != null) {
                        bitmap.recycle();
                        bitmap = h2;
                    }
                }
                return FileHelper.saveFileAsPic(d.a.o0.r3.c.f63814f, "pic_" + System.currentTimeMillis(), bitmap, 80, Bitmap.CompressFormat.JPEG);
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
        this.f21557e = hVar;
        getHolder().addCallback(this);
    }

    @Override // d.a.o0.r3.l.g
    public void a(Camera camera) {
        if (this.f21560h || camera == null) {
            return;
        }
        this.f21560h = true;
        try {
            camera.setPreviewDisplay(this.f21558f);
            camera.setPreviewCallback(this);
        } catch (IOException e2) {
            e2.printStackTrace();
            d.a.o0.u1.g gVar = this.l;
            if (gVar != null) {
                gVar.b(27, d.a.o0.u1.a.a(e2));
            }
        }
        camera.startPreview();
    }

    @Override // d.a.o0.r3.l.g
    public void b(Camera camera) {
        if (this.f21560h) {
            this.f21560h = false;
        }
    }

    @Override // d.a.o0.r3.l.g
    public void c(g.a aVar) {
        this.k = aVar;
        this.j = true;
    }

    @Override // d.a.o0.r3.l.g
    public void d(Camera camera) {
        if (camera == null) {
            return;
        }
        MediaRecorder mediaRecorder = new MediaRecorder();
        this.f21559g = mediaRecorder;
        mediaRecorder.reset();
        try {
            camera.unlock();
        } catch (Throwable th) {
            th.printStackTrace();
        }
        this.f21559g.setCamera(camera);
        this.f21559g.setOnErrorListener(new a());
        SurfaceHolder surfaceHolder = this.f21558f;
        if (surfaceHolder != null) {
            this.f21559g.setPreviewDisplay(surfaceHolder.getSurface());
        }
        this.f21559g.setVideoSource(1);
        this.f21559g.setAudioSource(1);
        this.f21559g.setOutputFormat(2);
        this.f21559g.setVideoEncoder(2);
        this.f21559g.setAudioEncoder(3);
        this.f21559g.setAudioSamplingRate(48000);
        this.f21559g.setAudioChannels(1);
        this.f21559g.setVideoEncodingBitRate(2097152);
        this.f21559g.setVideoFrameRate(20);
        if (this.f21557e.k) {
            this.f21559g.setOrientationHint(270);
        } else {
            this.f21559g.setOrientationHint(90);
        }
        this.f21559g.setVideoSize(1280, PeerConnectionClient.HD_VIDEO_HEIGHT);
        File file = new File(d.a.o0.r3.c.f63811c);
        if (!FileHelper.CheckTempDir(file.getAbsolutePath())) {
            file.mkdirs();
        }
        this.f21559g.setOutputFile(this.f21557e.o());
        try {
            this.f21559g.prepare();
            this.f21559g.start();
        } catch (Throwable th2) {
            th2.printStackTrace();
            d.a.o0.u1.g gVar = this.l;
            if (gVar != null) {
                gVar.b(28, d.a.o0.u1.a.a(th2));
            }
        }
    }

    @Override // d.a.o0.r3.l.g
    public void e(Camera camera) {
        MediaRecorder mediaRecorder = this.f21559g;
        if (mediaRecorder != null) {
            try {
                mediaRecorder.stop();
                this.f21559g.release();
            } catch (Exception e2) {
                e2.printStackTrace();
                d.a.o0.u1.g gVar = this.l;
                if (gVar != null) {
                    gVar.b(29, d.a.o0.u1.a.a(e2));
                }
            }
        }
    }

    public void h() {
        if (this.f21561i) {
            j();
        }
    }

    public final void i(byte[] bArr, int i2, int i3) {
        new b(bArr, i2, i3).execute(new Void[0]);
    }

    public final void j() {
        Handler n = this.f21557e.n();
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
        return this.f21557e.r(motionEvent, getParent());
    }

    @Override // d.a.o0.r3.l.g
    public void setOnEncoderStatusUpdateListener(d.InterfaceC1907d interfaceC1907d) {
    }

    @Override // d.a.o0.r3.l.g
    public void setPreviewSize(int i2, int i3) {
    }

    @Override // android.view.SurfaceHolder.Callback
    public void surfaceChanged(SurfaceHolder surfaceHolder, int i2, int i3, int i4) {
    }

    @Override // android.view.SurfaceHolder.Callback
    public void surfaceCreated(SurfaceHolder surfaceHolder) {
        this.f21558f = surfaceHolder;
        j();
        this.f21561i = true;
    }

    @Override // android.view.SurfaceHolder.Callback
    public void surfaceDestroyed(SurfaceHolder surfaceHolder) {
    }
}
