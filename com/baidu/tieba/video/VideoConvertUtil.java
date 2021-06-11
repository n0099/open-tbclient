package com.baidu.tieba.video;

import android.content.ComponentName;
import android.content.Context;
import android.content.Intent;
import android.content.ServiceConnection;
import android.media.MediaMetadataRetriever;
import android.os.IBinder;
import android.os.RemoteException;
import com.baidu.tieba.video.convert.IVideoConvertListener;
import com.baidu.tieba.video.convert.IVideoConvertService;
import d.a.c.e.m.b;
import d.a.n0.r3.c;
import d.a.n0.r3.d;
import java.io.File;
import java.io.UnsupportedEncodingException;
import java.security.MessageDigest;
import java.security.NoSuchAlgorithmException;
/* loaded from: classes5.dex */
public class VideoConvertUtil {
    public static final String n = c.f63686c;

    /* renamed from: a  reason: collision with root package name */
    public Context f21259a;

    /* renamed from: b  reason: collision with root package name */
    public IVideoConvertService f21260b;

    /* renamed from: c  reason: collision with root package name */
    public String f21261c;

    /* renamed from: d  reason: collision with root package name */
    public String f21262d;

    /* renamed from: e  reason: collision with root package name */
    public File f21263e;

    /* renamed from: f  reason: collision with root package name */
    public File f21264f;

    /* renamed from: g  reason: collision with root package name */
    public d f21265g;

    /* renamed from: i  reason: collision with root package name */
    public int f21267i = -3;
    public boolean j = false;
    public boolean k = false;
    public int l = 1;
    public ServiceConnection m = new a();

    /* renamed from: h  reason: collision with root package name */
    public IntenalConvertListener f21266h = new IntenalConvertListener(this, null);

    /* loaded from: classes5.dex */
    public class IntenalConvertListener extends IVideoConvertListener.Stub {
        public IntenalConvertListener() {
        }

        @Override // com.baidu.tieba.video.convert.IVideoConvertListener
        public void onConvertAborted() throws RemoteException {
            if (VideoConvertUtil.this.f21265g != null) {
                VideoConvertUtil.this.f21265g.onConvertAborted();
            }
        }

        @Override // com.baidu.tieba.video.convert.IVideoConvertListener
        public void onConvertFailed() throws RemoteException {
            if (VideoConvertUtil.this.f21265g != null) {
                VideoConvertUtil.this.f21265g.onConvertFailed();
            }
        }

        @Override // com.baidu.tieba.video.convert.IVideoConvertListener
        public void onConvertProgress(int i2) throws RemoteException {
            if (VideoConvertUtil.this.f21265g != null) {
                VideoConvertUtil.this.f21265g.onConvertProgress(i2);
            }
            if ((VideoConvertUtil.this.f21263e == null || VideoConvertUtil.this.f21263e.exists()) && (VideoConvertUtil.this.f21264f == null || VideoConvertUtil.this.f21264f.exists())) {
                return;
            }
            VideoConvertUtil.this.a();
        }

        @Override // com.baidu.tieba.video.convert.IVideoConvertListener
        public void onConvertSuccess() throws RemoteException {
            VideoConvertUtil.this.f21267i = 1;
            if (VideoConvertUtil.this.f21265g != null) {
                VideoConvertUtil.this.f21265g.onConvertSuccess();
            }
        }

        public /* synthetic */ IntenalConvertListener(VideoConvertUtil videoConvertUtil, a aVar) {
            this();
        }
    }

    /* loaded from: classes5.dex */
    public class a implements ServiceConnection {
        public a() {
        }

        @Override // android.content.ServiceConnection
        public void onServiceConnected(ComponentName componentName, IBinder iBinder) {
            VideoConvertUtil.this.f21260b = IVideoConvertService.Stub.asInterface(iBinder);
            if (VideoConvertUtil.this.k) {
                VideoConvertUtil.this.q();
            }
        }

        @Override // android.content.ServiceConnection
        public void onServiceDisconnected(ComponentName componentName) {
            if (VideoConvertUtil.this.k) {
                if (!VideoConvertUtil.this.j && VideoConvertUtil.this.f21267i == -3 && VideoConvertUtil.this.f21265g != null) {
                    VideoConvertUtil.this.f21265g.onConvertFailed();
                }
                VideoConvertUtil.this.k = false;
            }
            VideoConvertUtil.this.f21260b = null;
        }
    }

    public VideoConvertUtil(Context context) {
        this.f21259a = context;
    }

    public static boolean m() {
        File file = new File(n);
        if (file.exists() && !file.isDirectory()) {
            file.delete();
        }
        if (!file.exists()) {
            file.mkdirs();
        }
        return file.exists() && file.isDirectory();
    }

    public static int p(String str) {
        MediaMetadataRetriever mediaMetadataRetriever = new MediaMetadataRetriever();
        try {
            try {
                mediaMetadataRetriever.setDataSource(str);
                int d2 = b.d(mediaMetadataRetriever.extractMetadata(20), 0);
                try {
                    mediaMetadataRetriever.release();
                } catch (Exception e2) {
                    e2.printStackTrace();
                }
                return d2;
            } catch (Exception e3) {
                e3.printStackTrace();
                try {
                    mediaMetadataRetriever.release();
                } catch (Exception e4) {
                    e4.printStackTrace();
                }
                return 0;
            }
        } catch (Throwable th) {
            try {
                mediaMetadataRetriever.release();
            } catch (Exception e5) {
                e5.printStackTrace();
            }
            throw th;
        }
    }

    public static String v(String str) {
        if (str != null && !str.isEmpty()) {
            try {
                byte[] digest = MessageDigest.getInstance("MD5").digest(str.getBytes("UTF-8"));
                StringBuilder sb = new StringBuilder(digest.length * 2);
                for (byte b2 : digest) {
                    int i2 = b2 & 255;
                    if (i2 < 16) {
                        sb.append("0");
                    }
                    sb.append(Integer.toHexString(i2));
                }
                return sb.toString();
            } catch (UnsupportedEncodingException e2) {
                e2.printStackTrace();
                return "";
            } catch (NoSuchAlgorithmException e3) {
                e3.printStackTrace();
            }
        }
        return "";
    }

    public void a() {
        IVideoConvertService iVideoConvertService = this.f21260b;
        if (iVideoConvertService != null) {
            try {
                iVideoConvertService.abortConvert();
            } catch (RemoteException e2) {
                e2.printStackTrace();
            }
        }
    }

    public final void l() {
        if (this.f21259a != null) {
            Intent intent = new Intent("com.baidu.tieba.video.convert.VideoConvertService");
            intent.setPackage("com.baidu.tieba");
            this.f21259a.bindService(intent, this.m, 1);
        }
    }

    public void n(String str, String str2) {
        this.k = true;
        this.j = false;
        this.f21267i = -3;
        this.f21261c = str;
        this.f21262d = str2;
        this.f21263e = new File(this.f21261c);
        this.f21264f = new File(this.f21262d);
        if (this.f21260b == null) {
            u();
            l();
            return;
        }
        q();
    }

    public void o() {
        this.j = true;
        a();
        w();
    }

    public final void q() {
        int i2;
        try {
            this.f21260b.setIVideoConvertListener(this.f21266h);
            this.f21260b.setConvertType(this.l);
            i2 = this.f21260b.doConvert(this.f21261c, this.f21262d);
        } catch (RemoteException e2) {
            e2.printStackTrace();
            i2 = -1;
        }
        d dVar = this.f21265g;
        if (dVar != null) {
            if (i2 == 0) {
                dVar.b();
            } else {
                dVar.a(i2);
            }
        }
    }

    public boolean r() {
        try {
            if (this.f21260b != null) {
                return this.f21260b.isConvertRunning();
            }
            return false;
        } catch (RemoteException e2) {
            e2.printStackTrace();
            return false;
        }
    }

    public void s(int i2) {
        this.l = i2;
    }

    public void t(d dVar) {
        this.f21265g = dVar;
    }

    public final void u() {
        if (this.f21259a != null) {
            Intent intent = new Intent("com.baidu.tieba.video.convert.VideoConvertService");
            intent.setPackage("com.baidu.tieba");
            this.f21259a.startService(intent);
        }
    }

    public final void w() {
        Context context;
        if (this.f21260b == null || (context = this.f21259a) == null) {
            return;
        }
        context.unbindService(this.m);
    }
}
