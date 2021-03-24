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
import d.b.b.e.m.b;
import d.b.i0.p3.c;
import d.b.i0.p3.d;
import java.io.File;
import java.io.UnsupportedEncodingException;
import java.security.MessageDigest;
import java.security.NoSuchAlgorithmException;
/* loaded from: classes5.dex */
public class VideoConvertUtil {
    public static final String n = c.f58889c;

    /* renamed from: a  reason: collision with root package name */
    public Context f21697a;

    /* renamed from: b  reason: collision with root package name */
    public IVideoConvertService f21698b;

    /* renamed from: c  reason: collision with root package name */
    public String f21699c;

    /* renamed from: d  reason: collision with root package name */
    public String f21700d;

    /* renamed from: e  reason: collision with root package name */
    public File f21701e;

    /* renamed from: f  reason: collision with root package name */
    public File f21702f;

    /* renamed from: g  reason: collision with root package name */
    public d f21703g;
    public int i = -3;
    public boolean j = false;
    public boolean k = false;
    public int l = 1;
    public ServiceConnection m = new a();

    /* renamed from: h  reason: collision with root package name */
    public IntenalConvertListener f21704h = new IntenalConvertListener(this, null);

    /* loaded from: classes5.dex */
    public class IntenalConvertListener extends IVideoConvertListener.Stub {
        public IntenalConvertListener() {
        }

        @Override // com.baidu.tieba.video.convert.IVideoConvertListener
        public void onConvertAborted() throws RemoteException {
            if (VideoConvertUtil.this.f21703g != null) {
                VideoConvertUtil.this.f21703g.onConvertAborted();
            }
        }

        @Override // com.baidu.tieba.video.convert.IVideoConvertListener
        public void onConvertFailed() throws RemoteException {
            if (VideoConvertUtil.this.f21703g != null) {
                VideoConvertUtil.this.f21703g.onConvertFailed();
            }
        }

        @Override // com.baidu.tieba.video.convert.IVideoConvertListener
        public void onConvertProgress(int i) throws RemoteException {
            if (VideoConvertUtil.this.f21703g != null) {
                VideoConvertUtil.this.f21703g.onConvertProgress(i);
            }
            if ((VideoConvertUtil.this.f21701e == null || VideoConvertUtil.this.f21701e.exists()) && (VideoConvertUtil.this.f21702f == null || VideoConvertUtil.this.f21702f.exists())) {
                return;
            }
            VideoConvertUtil.this.a();
        }

        @Override // com.baidu.tieba.video.convert.IVideoConvertListener
        public void onConvertSuccess() throws RemoteException {
            VideoConvertUtil.this.i = 1;
            if (VideoConvertUtil.this.f21703g != null) {
                VideoConvertUtil.this.f21703g.onConvertSuccess();
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
            VideoConvertUtil.this.f21698b = IVideoConvertService.Stub.asInterface(iBinder);
            if (VideoConvertUtil.this.k) {
                VideoConvertUtil.this.q();
            }
        }

        @Override // android.content.ServiceConnection
        public void onServiceDisconnected(ComponentName componentName) {
            if (VideoConvertUtil.this.k) {
                if (!VideoConvertUtil.this.j && VideoConvertUtil.this.i == -3 && VideoConvertUtil.this.f21703g != null) {
                    VideoConvertUtil.this.f21703g.onConvertFailed();
                }
                VideoConvertUtil.this.k = false;
            }
            VideoConvertUtil.this.f21698b = null;
        }
    }

    public VideoConvertUtil(Context context) {
        this.f21697a = context;
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
                    int i = b2 & 255;
                    if (i < 16) {
                        sb.append("0");
                    }
                    sb.append(Integer.toHexString(i));
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
        IVideoConvertService iVideoConvertService = this.f21698b;
        if (iVideoConvertService != null) {
            try {
                iVideoConvertService.abortConvert();
            } catch (RemoteException e2) {
                e2.printStackTrace();
            }
        }
    }

    public final void l() {
        if (this.f21697a != null) {
            Intent intent = new Intent("com.baidu.tieba.video.convert.VideoConvertService");
            intent.setPackage("com.baidu.tieba");
            this.f21697a.bindService(intent, this.m, 1);
        }
    }

    public void n(String str, String str2) {
        this.k = true;
        this.j = false;
        this.i = -3;
        this.f21699c = str;
        this.f21700d = str2;
        this.f21701e = new File(this.f21699c);
        this.f21702f = new File(this.f21700d);
        if (this.f21698b == null) {
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
        int i;
        try {
            this.f21698b.setIVideoConvertListener(this.f21704h);
            this.f21698b.setConvertType(this.l);
            i = this.f21698b.doConvert(this.f21699c, this.f21700d);
        } catch (RemoteException e2) {
            e2.printStackTrace();
            i = -1;
        }
        d dVar = this.f21703g;
        if (dVar != null) {
            if (i == 0) {
                dVar.b();
            } else {
                dVar.a(i);
            }
        }
    }

    public boolean r() {
        try {
            if (this.f21698b != null) {
                return this.f21698b.isConvertRunning();
            }
            return false;
        } catch (RemoteException e2) {
            e2.printStackTrace();
            return false;
        }
    }

    public void s(int i) {
        this.l = i;
    }

    public void t(d dVar) {
        this.f21703g = dVar;
    }

    public final void u() {
        if (this.f21697a != null) {
            Intent intent = new Intent("com.baidu.tieba.video.convert.VideoConvertService");
            intent.setPackage("com.baidu.tieba");
            this.f21697a.startService(intent);
        }
    }

    public final void w() {
        Context context;
        if (this.f21698b == null || (context = this.f21697a) == null) {
            return;
        }
        context.unbindService(this.m);
    }
}
