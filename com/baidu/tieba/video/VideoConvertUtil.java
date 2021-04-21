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
import d.b.c.e.m.b;
import d.b.j0.q3.c;
import d.b.j0.q3.d;
import java.io.File;
import java.io.UnsupportedEncodingException;
import java.security.MessageDigest;
import java.security.NoSuchAlgorithmException;
/* loaded from: classes5.dex */
public class VideoConvertUtil {
    public static final String n = c.f60979c;

    /* renamed from: a  reason: collision with root package name */
    public Context f21391a;

    /* renamed from: b  reason: collision with root package name */
    public IVideoConvertService f21392b;

    /* renamed from: c  reason: collision with root package name */
    public String f21393c;

    /* renamed from: d  reason: collision with root package name */
    public String f21394d;

    /* renamed from: e  reason: collision with root package name */
    public File f21395e;

    /* renamed from: f  reason: collision with root package name */
    public File f21396f;

    /* renamed from: g  reason: collision with root package name */
    public d f21397g;
    public int i = -3;
    public boolean j = false;
    public boolean k = false;
    public int l = 1;
    public ServiceConnection m = new a();

    /* renamed from: h  reason: collision with root package name */
    public IntenalConvertListener f21398h = new IntenalConvertListener(this, null);

    /* loaded from: classes5.dex */
    public class IntenalConvertListener extends IVideoConvertListener.Stub {
        public IntenalConvertListener() {
        }

        @Override // com.baidu.tieba.video.convert.IVideoConvertListener
        public void onConvertAborted() throws RemoteException {
            if (VideoConvertUtil.this.f21397g != null) {
                VideoConvertUtil.this.f21397g.onConvertAborted();
            }
        }

        @Override // com.baidu.tieba.video.convert.IVideoConvertListener
        public void onConvertFailed() throws RemoteException {
            if (VideoConvertUtil.this.f21397g != null) {
                VideoConvertUtil.this.f21397g.onConvertFailed();
            }
        }

        @Override // com.baidu.tieba.video.convert.IVideoConvertListener
        public void onConvertProgress(int i) throws RemoteException {
            if (VideoConvertUtil.this.f21397g != null) {
                VideoConvertUtil.this.f21397g.onConvertProgress(i);
            }
            if ((VideoConvertUtil.this.f21395e == null || VideoConvertUtil.this.f21395e.exists()) && (VideoConvertUtil.this.f21396f == null || VideoConvertUtil.this.f21396f.exists())) {
                return;
            }
            VideoConvertUtil.this.a();
        }

        @Override // com.baidu.tieba.video.convert.IVideoConvertListener
        public void onConvertSuccess() throws RemoteException {
            VideoConvertUtil.this.i = 1;
            if (VideoConvertUtil.this.f21397g != null) {
                VideoConvertUtil.this.f21397g.onConvertSuccess();
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
            VideoConvertUtil.this.f21392b = IVideoConvertService.Stub.asInterface(iBinder);
            if (VideoConvertUtil.this.k) {
                VideoConvertUtil.this.q();
            }
        }

        @Override // android.content.ServiceConnection
        public void onServiceDisconnected(ComponentName componentName) {
            if (VideoConvertUtil.this.k) {
                if (!VideoConvertUtil.this.j && VideoConvertUtil.this.i == -3 && VideoConvertUtil.this.f21397g != null) {
                    VideoConvertUtil.this.f21397g.onConvertFailed();
                }
                VideoConvertUtil.this.k = false;
            }
            VideoConvertUtil.this.f21392b = null;
        }
    }

    public VideoConvertUtil(Context context) {
        this.f21391a = context;
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
        IVideoConvertService iVideoConvertService = this.f21392b;
        if (iVideoConvertService != null) {
            try {
                iVideoConvertService.abortConvert();
            } catch (RemoteException e2) {
                e2.printStackTrace();
            }
        }
    }

    public final void l() {
        if (this.f21391a != null) {
            Intent intent = new Intent("com.baidu.tieba.video.convert.VideoConvertService");
            intent.setPackage("com.baidu.tieba");
            this.f21391a.bindService(intent, this.m, 1);
        }
    }

    public void n(String str, String str2) {
        this.k = true;
        this.j = false;
        this.i = -3;
        this.f21393c = str;
        this.f21394d = str2;
        this.f21395e = new File(this.f21393c);
        this.f21396f = new File(this.f21394d);
        if (this.f21392b == null) {
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
            this.f21392b.setIVideoConvertListener(this.f21398h);
            this.f21392b.setConvertType(this.l);
            i = this.f21392b.doConvert(this.f21393c, this.f21394d);
        } catch (RemoteException e2) {
            e2.printStackTrace();
            i = -1;
        }
        d dVar = this.f21397g;
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
            if (this.f21392b != null) {
                return this.f21392b.isConvertRunning();
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
        this.f21397g = dVar;
    }

    public final void u() {
        if (this.f21391a != null) {
            Intent intent = new Intent("com.baidu.tieba.video.convert.VideoConvertService");
            intent.setPackage("com.baidu.tieba");
            this.f21391a.startService(intent);
        }
    }

    public final void w() {
        Context context;
        if (this.f21392b == null || (context = this.f21391a) == null) {
            return;
        }
        context.unbindService(this.m);
    }
}
