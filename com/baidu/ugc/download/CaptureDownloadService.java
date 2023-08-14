package com.baidu.ugc.download;

import android.app.Service;
import android.content.Context;
import android.content.Intent;
import android.os.IBinder;
import androidx.localbroadcastmanager.content.LocalBroadcastManager;
import com.baidu.tieba.a7b;
import com.baidu.tieba.l9b;
import com.baidu.tieba.x6b;
import com.baidu.tieba.y6b;
import com.baidu.tieba.z6b;
import com.baidu.ugc.download.exception.DownloadException;
/* loaded from: classes9.dex */
public class CaptureDownloadService extends Service {
    public static final String ACTION_CANCEL = "com.baidu.ugc.download.ACTION_CANCEL";
    public static final String ACTION_CANCEL_ALL = "com.baidu.ugc.download.ACTION_CANCEL_ALL";
    public static final String ACTION_DOWNLOAD = "com.baidu.ugc.download.ACTION_DOWNLOAD";
    public static final String ACTION_DOWNLOAD_BROAD_CAST = "com.baidu.ugc.download.ACTION_BROAD_CAST";
    public static final String ACTION_PAUSE = "com.baidu.ugc.download.ACTION_PAUSE";
    public static final String ACTION_PAUSE_ALL = "com.baidu.ugc.download.ACTION_PAUSE_ALL";
    public static final String EXTRA_FILE_INFO = "extra_file_info";
    public static final String EXTRA_POSITION = "extra_position";
    public static final String EXTRA_TAG = "extra_tag";
    public static final String TAG = "CaptureDownloadService";
    public x6b mDownloadManager;

    @Override // android.app.Service
    public IBinder onBind(Intent intent) {
        return null;
    }

    /* loaded from: classes9.dex */
    public static class a extends a7b {
        public int a;
        public z6b b;
        public LocalBroadcastManager c;
        public long d;
        public int e;

        public a(int i, z6b z6bVar, Context context) {
            this.a = i;
            this.b = z6bVar;
            this.c = LocalBroadcastManager.getInstance(context);
        }

        @Override // com.baidu.tieba.a7b
        public void g(long j, long j2, int i) {
            if (this.d == 0) {
                this.d = System.currentTimeMillis();
            }
            this.b.f(3);
            this.b.d(i);
            this.b.c(l9b.a(j, j2));
            if (i(i)) {
                j(this.b);
            }
        }

        @Override // com.baidu.tieba.a7b
        public void a(String str) {
            this.b.f(6);
            this.b.d(100);
            this.b.e(str);
            j(this.b);
        }

        @Override // com.baidu.tieba.a7b
        public void f(DownloadException downloadException) {
            downloadException.printStackTrace();
            this.b.f(5);
            j(this.b);
        }

        public final boolean i(int i) {
            long currentTimeMillis = System.currentTimeMillis();
            if (currentTimeMillis - this.d > 300 && i != this.e) {
                this.d = currentTimeMillis;
                this.e = i;
                return true;
            }
            return false;
        }

        public final void j(z6b z6bVar) {
            Intent intent = new Intent();
            intent.setAction("com.baidu.ugc.download.ACTION_BROAD_CAST");
            intent.putExtra("extra_position", this.a);
            intent.putExtra("extra_file_info", z6bVar.g().toString());
            this.c.sendBroadcast(intent);
        }

        @Override // com.baidu.tieba.a7b
        public void d() {
            this.b.f(0);
            this.b.d(0);
            this.b.c("");
            j(this.b);
        }

        @Override // com.baidu.tieba.a7b
        public void e() {
            this.b.f(4);
            j(this.b);
        }
    }

    private void cancelAll() {
        this.mDownloadManager.d();
    }

    private void pauseAll() {
        this.mDownloadManager.m();
    }

    @Override // android.app.Service
    public void onCreate() {
        super.onCreate();
        this.mDownloadManager = x6b.h();
    }

    @Override // android.app.Service
    public void onDestroy() {
        super.onDestroy();
        this.mDownloadManager.m();
    }

    public static void cancel(Context context, String str) {
        Intent intent = new Intent(context, CaptureDownloadService.class);
        intent.setAction("com.baidu.ugc.download.ACTION_CANCEL");
        intent.putExtra("extra_tag", str);
        context.startService(intent);
    }

    public static void pause(Context context, String str) {
        Intent intent = new Intent(context, CaptureDownloadService.class);
        intent.setAction("com.baidu.ugc.download.ACTION_PAUSE");
        intent.putExtra("extra_tag", str);
        context.startService(intent);
    }

    private void cancel(String str) {
        this.mDownloadManager.c(str);
    }

    public static void cancelAll(Context context) {
        Intent intent = new Intent(context, CaptureDownloadService.class);
        intent.setAction("com.baidu.ugc.download.ACTION_CANCEL_ALL");
        context.startService(intent);
    }

    public static void destroy(Context context) {
        context.stopService(new Intent(context, CaptureDownloadService.class));
    }

    private void pause(String str) {
        this.mDownloadManager.l(str);
    }

    public static void pauseAll(Context context) {
        Intent intent = new Intent(context, CaptureDownloadService.class);
        intent.setAction("com.baidu.ugc.download.ACTION_PAUSE_ALL");
        context.startService(intent);
    }

    private void download(int i, z6b z6bVar, String str) {
        y6b.b bVar = new y6b.b();
        bVar.d(z6bVar.a());
        this.mDownloadManager.f(bVar.a(), str, new a(i, z6bVar, getApplicationContext()));
    }

    public static void start(Context context, String str, z6b z6bVar) {
        start(context, 0, str, z6bVar);
    }

    public static void start(Context context, int i, String str, z6b z6bVar) {
        Intent intent = new Intent(context, CaptureDownloadService.class);
        intent.setAction("com.baidu.ugc.download.ACTION_DOWNLOAD");
        intent.putExtra("extra_position", i);
        intent.putExtra("extra_tag", str);
        intent.putExtra("extra_file_info", z6bVar.g().toString());
        context.startService(intent);
    }

    /* JADX WARN: Can't fix incorrect switch cases order, some code will duplicate */
    /* JADX WARN: Code restructure failed: missing block: B:10:0x003e, code lost:
        if (r0.equals("com.baidu.ugc.download.ACTION_DOWNLOAD") != false) goto L7;
     */
    @Override // android.app.Service
    /*
        Code decompiled incorrectly, please refer to instructions dump.
    */
    public int onStartCommand(Intent intent, int i, int i2) {
        if (intent != null) {
            String action = intent.getAction();
            char c = 0;
            int intExtra = intent.getIntExtra("extra_position", 0);
            z6b z6bVar = new z6b();
            z6bVar.b(intent.getStringExtra("extra_file_info"));
            String stringExtra = intent.getStringExtra("extra_tag");
            switch (action.hashCode()) {
                case -2000112966:
                    if (action.equals("com.baidu.ugc.download.ACTION_CANCEL")) {
                        c = 2;
                        break;
                    }
                    c = 65535;
                    break;
                case -1148652932:
                    if (action.equals("com.baidu.ugc.download.ACTION_CANCEL_ALL")) {
                        c = 4;
                        break;
                    }
                    c = 65535;
                    break;
                case -929888424:
                    if (action.equals("com.baidu.ugc.download.ACTION_PAUSE_ALL")) {
                        c = 3;
                        break;
                    }
                    c = 65535;
                    break;
                case -707184440:
                    break;
                case 1610061206:
                    if (action.equals("com.baidu.ugc.download.ACTION_PAUSE")) {
                        c = 1;
                        break;
                    }
                    c = 65535;
                    break;
                default:
                    c = 65535;
                    break;
            }
            if (c != 0) {
                if (c != 1) {
                    if (c != 2) {
                        if (c != 3) {
                            if (c == 4) {
                                cancelAll();
                            }
                        } else {
                            pauseAll();
                        }
                    } else {
                        cancel(stringExtra);
                    }
                } else {
                    pause(stringExtra);
                }
            } else {
                download(intExtra, z6bVar, stringExtra);
            }
        }
        return super.onStartCommand(intent, i, i2);
    }
}
