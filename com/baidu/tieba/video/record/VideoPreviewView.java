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
import d.a.n0.r3.i.d.c;
import d.a.n0.r3.l.g;
import d.a.n0.r3.l.h;
import d.a.n0.u1.k;
import d.e.b.d;
import java.io.File;
import java.io.IOException;
/* loaded from: classes5.dex */
public class VideoPreviewView extends SurfaceView implements SurfaceHolder.Callback, g, Camera.PreviewCallback {

    /* renamed from: e  reason: collision with root package name */
    public h f21475e;

    /* renamed from: f  reason: collision with root package name */
    public SurfaceHolder f21476f;

    /* renamed from: g  reason: collision with root package name */
    public MediaRecorder f21477g;

    /* renamed from: h  reason: collision with root package name */
    public boolean f21478h;

    /* renamed from: i  reason: collision with root package name */
    public boolean f21479i;
    public boolean j;
    public g.a k;
    public d.a.n0.u1.g l;

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
                d.a.n0.u1.g gVar = VideoPreviewView.this.l;
                gVar.b(28, "what-->" + i2 + "  extra-->" + i3);
            }
        }
    }

    /* loaded from: classes5.dex */
    public class b extends BdAsyncTask<Void, Void, String> {

        /* renamed from: a  reason: collision with root package name */
        public final /* synthetic */ byte[] f21481a;

        /* renamed from: b  reason: collision with root package name */
        public final /* synthetic */ int f21482b;

        /* renamed from: c  reason: collision with root package name */
        public final /* synthetic */ int f21483c;

        public b(byte[] bArr, int i2, int i3) {
            this.f21481a = bArr;
            this.f21482b = i2;
            this.f21483c = i3;
        }

        /* JADX DEBUG: Method merged with bridge method */
        @Override // com.baidu.adp.lib.asyncTask.BdAsyncTask
        /* renamed from: b */
        public String doInBackground(Void... voidArr) {
            Bitmap bitmap = null;
            try {
                bitmap = c.b(this.f21481a, this.f21482b, this.f21483c);
                if (this.f21482b > this.f21483c) {
                    Bitmap h2 = c.h(bitmap, 90.0f);
                    if (bitmap != null && !bitmap.isRecycled() && h2 != null) {
                        bitmap.recycle();
                        bitmap = h2;
                    }
                }
                return FileHelper.saveFileAsPic(d.a.n0.r3.c.f63689f, "pic_" + System.currentTimeMillis(), bitmap, 80, Bitmap.CompressFormat.JPEG);
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
        this.f21475e = hVar;
        getHolder().addCallback(this);
    }

    @Override // d.a.n0.r3.l.g
    public void a(Camera camera) {
        if (this.f21478h || camera == null) {
            return;
        }
        this.f21478h = true;
        try {
            camera.setPreviewDisplay(this.f21476f);
            camera.setPreviewCallback(this);
        } catch (IOException e2) {
            e2.printStackTrace();
            d.a.n0.u1.g gVar = this.l;
            if (gVar != null) {
                gVar.b(27, d.a.n0.u1.a.a(e2));
            }
        }
        camera.startPreview();
    }

    @Override // d.a.n0.r3.l.g
    public void b(Camera camera) {
        if (this.f21478h) {
            this.f21478h = false;
        }
    }

    @Override // d.a.n0.r3.l.g
    public void c(g.a aVar) {
        this.k = aVar;
        this.j = true;
    }

    @Override // d.a.n0.r3.l.g
    public void d(Camera camera) {
        if (camera == null) {
            return;
        }
        MediaRecorder mediaRecorder = new MediaRecorder();
        this.f21477g = mediaRecorder;
        mediaRecorder.reset();
        try {
            camera.unlock();
        } catch (Throwable th) {
            th.printStackTrace();
        }
        this.f21477g.setCamera(camera);
        this.f21477g.setOnErrorListener(new a());
        SurfaceHolder surfaceHolder = this.f21476f;
        if (surfaceHolder != null) {
            this.f21477g.setPreviewDisplay(surfaceHolder.getSurface());
        }
        this.f21477g.setVideoSource(1);
        this.f21477g.setAudioSource(1);
        this.f21477g.setOutputFormat(2);
        this.f21477g.setVideoEncoder(2);
        this.f21477g.setAudioEncoder(3);
        this.f21477g.setAudioSamplingRate(48000);
        this.f21477g.setAudioChannels(1);
        this.f21477g.setVideoEncodingBitRate(2097152);
        this.f21477g.setVideoFrameRate(20);
        if (this.f21475e.k) {
            this.f21477g.setOrientationHint(270);
        } else {
            this.f21477g.setOrientationHint(90);
        }
        this.f21477g.setVideoSize(1280, PeerConnectionClient.HD_VIDEO_HEIGHT);
        File file = new File(d.a.n0.r3.c.f63686c);
        if (!FileHelper.CheckTempDir(file.getAbsolutePath())) {
            file.mkdirs();
        }
        this.f21477g.setOutputFile(this.f21475e.o());
        try {
            this.f21477g.prepare();
            this.f21477g.start();
        } catch (Throwable th2) {
            th2.printStackTrace();
            d.a.n0.u1.g gVar = this.l;
            if (gVar != null) {
                gVar.b(28, d.a.n0.u1.a.a(th2));
            }
        }
    }

    @Override // d.a.n0.r3.l.g
    public void e(Camera camera) {
        MediaRecorder mediaRecorder = this.f21477g;
        if (mediaRecorder != null) {
            try {
                mediaRecorder.stop();
                this.f21477g.release();
            } catch (Exception e2) {
                e2.printStackTrace();
                d.a.n0.u1.g gVar = this.l;
                if (gVar != null) {
                    gVar.b(29, d.a.n0.u1.a.a(e2));
                }
            }
        }
    }

    public void h() {
        if (this.f21479i) {
            j();
        }
    }

    public final void i(byte[] bArr, int i2, int i3) {
        new b(bArr, i2, i3).execute(new Void[0]);
    }

    public final void j() {
        Handler n = this.f21475e.n();
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
        return this.f21475e.r(motionEvent, getParent());
    }

    @Override // d.a.n0.r3.l.g
    public void setOnEncoderStatusUpdateListener(d.InterfaceC1904d interfaceC1904d) {
    }

    @Override // d.a.n0.r3.l.g
    public void setPreviewSize(int i2, int i3) {
    }

    @Override // android.view.SurfaceHolder.Callback
    public void surfaceChanged(SurfaceHolder surfaceHolder, int i2, int i3, int i4) {
    }

    @Override // android.view.SurfaceHolder.Callback
    public void surfaceCreated(SurfaceHolder surfaceHolder) {
        this.f21476f = surfaceHolder;
        j();
        this.f21479i = true;
    }

    @Override // android.view.SurfaceHolder.Callback
    public void surfaceDestroyed(SurfaceHolder surfaceHolder) {
    }
}
