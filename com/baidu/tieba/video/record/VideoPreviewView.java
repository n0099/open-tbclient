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
import d.b.j0.q3.j.d.c;
import d.b.j0.q3.m.g;
import d.b.j0.q3.m.h;
import d.b.j0.t1.k;
import d.f.b.d;
import java.io.File;
import java.io.IOException;
/* loaded from: classes5.dex */
public class VideoPreviewView extends SurfaceView implements SurfaceHolder.Callback, g, Camera.PreviewCallback {

    /* renamed from: e  reason: collision with root package name */
    public h f21588e;

    /* renamed from: f  reason: collision with root package name */
    public SurfaceHolder f21589f;

    /* renamed from: g  reason: collision with root package name */
    public MediaRecorder f21590g;

    /* renamed from: h  reason: collision with root package name */
    public boolean f21591h;
    public boolean i;
    public boolean j;
    public g.a k;
    public d.b.j0.t1.g l;

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
                d.b.j0.t1.g gVar = VideoPreviewView.this.l;
                gVar.c(28, "what-->" + i + "  extra-->" + i2);
            }
        }
    }

    /* loaded from: classes5.dex */
    public class b extends BdAsyncTask<Void, Void, String> {

        /* renamed from: a  reason: collision with root package name */
        public final /* synthetic */ byte[] f21593a;

        /* renamed from: b  reason: collision with root package name */
        public final /* synthetic */ int f21594b;

        /* renamed from: c  reason: collision with root package name */
        public final /* synthetic */ int f21595c;

        public b(byte[] bArr, int i, int i2) {
            this.f21593a = bArr;
            this.f21594b = i;
            this.f21595c = i2;
        }

        /* JADX DEBUG: Method merged with bridge method */
        @Override // com.baidu.adp.lib.asyncTask.BdAsyncTask
        /* renamed from: b */
        public String doInBackground(Void... voidArr) {
            Bitmap bitmap = null;
            try {
                bitmap = c.b(this.f21593a, this.f21594b, this.f21595c);
                if (this.f21594b > this.f21595c) {
                    Bitmap h2 = c.h(bitmap, 90.0f);
                    if (bitmap != null && !bitmap.isRecycled() && h2 != null) {
                        bitmap.recycle();
                        bitmap = h2;
                    }
                }
                return FileHelper.saveFileAsPic(d.b.j0.q3.c.f60982f, "pic_" + System.currentTimeMillis(), bitmap, 80, Bitmap.CompressFormat.JPEG);
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
        this.f21588e = hVar;
        getHolder().addCallback(this);
    }

    @Override // d.b.j0.q3.m.g
    public void a(Camera camera) {
        if (this.f21591h || camera == null) {
            return;
        }
        this.f21591h = true;
        try {
            camera.setPreviewDisplay(this.f21589f);
            camera.setPreviewCallback(this);
        } catch (IOException e2) {
            e2.printStackTrace();
            d.b.j0.t1.g gVar = this.l;
            if (gVar != null) {
                gVar.c(27, d.b.j0.t1.a.a(e2));
            }
        }
        camera.startPreview();
    }

    @Override // d.b.j0.q3.m.g
    public void b(Camera camera) {
        if (camera == null) {
            return;
        }
        MediaRecorder mediaRecorder = new MediaRecorder();
        this.f21590g = mediaRecorder;
        mediaRecorder.reset();
        try {
            camera.unlock();
        } catch (Throwable th) {
            th.printStackTrace();
        }
        this.f21590g.setCamera(camera);
        this.f21590g.setOnErrorListener(new a());
        SurfaceHolder surfaceHolder = this.f21589f;
        if (surfaceHolder != null) {
            this.f21590g.setPreviewDisplay(surfaceHolder.getSurface());
        }
        this.f21590g.setVideoSource(1);
        this.f21590g.setAudioSource(1);
        this.f21590g.setOutputFormat(2);
        this.f21590g.setVideoEncoder(2);
        this.f21590g.setAudioEncoder(3);
        this.f21590g.setAudioSamplingRate(48000);
        this.f21590g.setAudioChannels(1);
        this.f21590g.setVideoEncodingBitRate(2097152);
        this.f21590g.setVideoFrameRate(20);
        if (this.f21588e.k) {
            this.f21590g.setOrientationHint(270);
        } else {
            this.f21590g.setOrientationHint(90);
        }
        this.f21590g.setVideoSize(1280, PeerConnectionClient.HD_VIDEO_HEIGHT);
        File file = new File(d.b.j0.q3.c.f60979c);
        if (!FileHelper.CheckTempDir(file.getAbsolutePath())) {
            file.mkdirs();
        }
        this.f21590g.setOutputFile(this.f21588e.o());
        try {
            this.f21590g.prepare();
            this.f21590g.start();
        } catch (Throwable th2) {
            th2.printStackTrace();
            d.b.j0.t1.g gVar = this.l;
            if (gVar != null) {
                gVar.c(28, d.b.j0.t1.a.a(th2));
            }
        }
    }

    @Override // d.b.j0.q3.m.g
    public void c(Camera camera) {
        if (this.f21591h) {
            this.f21591h = false;
        }
    }

    @Override // d.b.j0.q3.m.g
    public void d(Camera camera) {
        MediaRecorder mediaRecorder = this.f21590g;
        if (mediaRecorder != null) {
            try {
                mediaRecorder.stop();
                this.f21590g.release();
            } catch (Exception e2) {
                e2.printStackTrace();
                d.b.j0.t1.g gVar = this.l;
                if (gVar != null) {
                    gVar.c(29, d.b.j0.t1.a.a(e2));
                }
            }
        }
    }

    @Override // d.b.j0.q3.m.g
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
        Handler n = this.f21588e.n();
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
        return this.f21588e.r(motionEvent, getParent());
    }

    @Override // d.b.j0.q3.m.g
    public void setOnEncoderStatusUpdateListener(d.InterfaceC1837d interfaceC1837d) {
    }

    @Override // d.b.j0.q3.m.g
    public void setPreviewSize(int i, int i2) {
    }

    @Override // android.view.SurfaceHolder.Callback
    public void surfaceChanged(SurfaceHolder surfaceHolder, int i, int i2, int i3) {
    }

    @Override // android.view.SurfaceHolder.Callback
    public void surfaceCreated(SurfaceHolder surfaceHolder) {
        this.f21589f = surfaceHolder;
        j();
        this.i = true;
    }

    @Override // android.view.SurfaceHolder.Callback
    public void surfaceDestroyed(SurfaceHolder surfaceHolder) {
    }
}
