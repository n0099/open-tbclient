package com.baidu.tieba.play.b;

import android.net.Uri;
import android.os.Handler;
import android.text.TextUtils;
import com.baidu.adp.lib.asyncTask.BdAsyncTask;
import com.baidu.adp.lib.util.StringUtils;
import com.baidu.adp.lib.util.j;
import com.baidu.tbadk.core.util.l;
import com.baidu.tieba.play.CustomPlayerSwitchStatic;
import com.baidu.tieba.play.a.b;
import com.baidu.tieba.play.g;
import java.io.File;
import org.apache.http.HttpHost;
/* loaded from: classes.dex */
public class a {
    private c ghX;
    private int ghY = 0;
    private int ghZ = 0;
    private Handler mHandler = new Handler();

    public a(c cVar) {
        this.ghX = cVar;
    }

    public boolean a(g gVar, int i, int i2, int i3, Uri uri) {
        if (this.ghX == null) {
            return false;
        }
        if (i == -300) {
            if (this.ghZ == 0) {
                this.ghZ++;
                this.mHandler.postDelayed(new b(this.ghX, gVar, i, i2, i3, 3, bkX()), 200L);
            } else if (this.ghZ == 1) {
                this.ghZ++;
                this.mHandler.postDelayed(new b(this.ghX, gVar, i, i2, i3, 4, bkX()), 200L);
            } else {
                return false;
            }
            return true;
        }
        this.ghY++;
        if (this.ghY <= 2) {
            if (!a(gVar, i, i2, i3, uri, bkX())) {
                if (i == -200) {
                    this.mHandler.postDelayed(new b(this.ghX, gVar, i, i2, i3, this.ghY % 2 == 1 ? 7 : 17, bkX()), 200L);
                    this.ghY = 2;
                } else {
                    this.mHandler.postDelayed(new b(this.ghX, gVar, i, i2, i3, this.ghY % 2 == 1 ? 8 : 18, bkX()), 200L);
                    this.ghY = 4;
                    return false;
                }
            }
            return true;
        } else if (this.ghY <= 4) {
            if (i == -200) {
                this.mHandler.postDelayed(new b(this.ghX, gVar, i, i2, i3, this.ghY % 2 == 1 ? 1 : 11, bkX()), 200L);
                return true;
            }
            return false;
        } else if (this.ghY <= 6 && i == -200) {
            this.mHandler.postDelayed(new b(this.ghX, gVar, i, i2, i3, this.ghY % 2 == 1 ? 2 : 12, bkX()), 200L);
            return true;
        } else {
            return false;
        }
    }

    private int bkX() {
        return (this.ghZ * 100) + this.ghY;
    }

    private boolean a(g gVar, int i, int i2, int i3, Uri uri, int i4) {
        if (!bkY() || i == -100 || uri == null || TextUtils.isEmpty(uri.getHost()) || uri.toString().contains("127.0.0.1") || !uri.toString().contains(HttpHost.DEFAULT_SCHEME_NAME)) {
            return false;
        }
        com.baidu.tieba.play.a.b.bkW().a(new C0217a(this.mHandler, this.ghX, i, uri, gVar, i2, i3, i4));
        return com.baidu.tieba.play.a.b.bkW().sj(uri.getHost());
    }

    private boolean bkY() {
        return (com.baidu.adp.lib.b.d.hv().ax("android_video_http_dns_open") == 0 || !j.jE() || CustomPlayerSwitchStatic.bjK() == 0) ? false : true;
    }

    /* JADX INFO: Access modifiers changed from: private */
    /* renamed from: com.baidu.tieba.play.b.a$a  reason: collision with other inner class name */
    /* loaded from: classes.dex */
    public static class C0217a implements b.InterfaceC0216b {
        private c ghX;
        private g gia;
        private int gib;
        private int gic;
        private Handler mHandler;
        private Uri mUri;
        private int times;
        private int what;

        public C0217a(Handler handler, c cVar, int i, Uri uri, g gVar, int i2, int i3, int i4) {
            this.mHandler = handler;
            this.ghX = cVar;
            this.mUri = uri;
            this.gia = gVar;
            this.gib = i;
            this.what = i2;
            this.gic = i3;
            this.times = i4;
        }

        @Override // com.baidu.tieba.play.a.b.InterfaceC0216b
        public void bU(String str, String str2) {
            try {
                if (TextUtils.isEmpty(str) || TextUtils.isEmpty(str2) || this.mUri == null || !str2.equals(this.mUri.getHost())) {
                    if (this.mHandler != null) {
                        this.mHandler.postDelayed(new b(this.ghX, this.gia, this.gib, this.what, this.gic, this.times % 2 == 1 ? 5 : 15, this.times), 200L);
                    }
                } else if (this.mHandler != null) {
                    this.mHandler.postDelayed(new b(this.ghX, this.gia, this.gib, this.what, this.gic, str, this.times % 2 == 1 ? 0 : 10, this.times), 200L);
                }
            } catch (Throwable th) {
                th.printStackTrace();
                if (this.mHandler != null) {
                    this.mHandler.postDelayed(new b(this.ghX, this.gia, this.gib, this.what, this.gic, this.times % 2 == 1 ? 6 : 16, this.times), 200L);
                }
            }
        }
    }

    public boolean bkZ() {
        boolean z = this.ghY > 0 || this.ghZ > 0;
        this.ghY = 0;
        this.ghZ = 0;
        return z;
    }

    /* JADX INFO: Access modifiers changed from: private */
    /* loaded from: classes.dex */
    public static class b implements Runnable {
        private c ghX;
        private final g gia;
        private final int gib;
        private final int gic;
        private final String ip;
        private final int times;
        private final int type;
        private final int what;

        public b(c cVar, g gVar, int i, int i2, int i3, int i4, int i5) {
            this.ghX = cVar;
            this.gia = gVar;
            this.gib = i;
            this.what = i2;
            this.gic = i3;
            this.type = i4;
            this.times = i5;
            this.ip = "";
        }

        public b(c cVar, g gVar, int i, int i2, int i3, String str, int i4, int i5) {
            this.ghX = cVar;
            this.gia = gVar;
            this.gib = i;
            this.what = i2;
            this.gic = i3;
            this.ip = str;
            this.type = i4;
            this.times = i5;
        }

        @Override // java.lang.Runnable
        public void run() {
            if (this.ghX != null) {
                if (this.type == 1 || this.type == 5 || this.type == 3 || this.type == 6 || this.type == 7 || this.type == 11 || this.type == 15 || this.type == 16 || this.type == 17) {
                    this.ghX.a(this.gia, this.gib, this.what, this.gic, this.times, this.type);
                } else if (this.type == 2 || this.type == 4 || this.type == 8 || this.type == 12 || this.type == 18) {
                    this.ghX.b(this.gia, this.gib, this.what, this.gic, this.times, this.type);
                } else if (this.type == 0 || this.type == 10) {
                    this.ghX.a(this.gia, this.gib, this.what, this.gic, this.ip, this.times, this.type);
                }
            }
        }
    }

    public void clear() {
        if (this.mHandler != null) {
            this.mHandler.removeCallbacksAndMessages(null);
        }
    }

    public static void sl(String str) {
        if (!StringUtils.isNull(str)) {
            new BdAsyncTask<String, Void, Void>() { // from class: com.baidu.tieba.play.b.a.1
                /* JADX DEBUG: Method merged with bridge method */
                /* JADX INFO: Access modifiers changed from: protected */
                @Override // com.baidu.adp.lib.asyncTask.BdAsyncTask
                public Void doInBackground(String... strArr) {
                    if (strArr != null && strArr.length == 1) {
                        l.r(new File(strArr[0]).getParentFile());
                    }
                    return null;
                }
            }.execute(str);
        }
    }
}
