package com.baidu.tieba.play.b;

import android.net.Uri;
import android.os.Handler;
import android.text.TextUtils;
import com.baidu.adp.lib.asyncTask.BdAsyncTask;
import com.baidu.adp.lib.util.StringUtils;
import com.baidu.adp.lib.util.j;
import com.baidu.tbadk.core.util.m;
import com.baidu.tbadk.t.s;
import com.baidu.tieba.play.a.b;
import com.baidu.tieba.play.g;
import java.io.File;
import org.apache.http.HttpHost;
/* loaded from: classes.dex */
public class a {
    private c izo;
    private int izp = 0;
    private int izq = 0;
    private Handler mHandler = new Handler();

    public a(c cVar) {
        this.izo = cVar;
    }

    public boolean a(g gVar, int i, int i2, int i3, Uri uri) {
        if (this.izo == null) {
            return false;
        }
        if (i == -300) {
            if (this.izq == 0) {
                this.izq++;
                this.mHandler.postDelayed(new b(this.izo, gVar, i, i2, i3, 3, cfg()), 200L);
            } else if (this.izq == 1) {
                this.izq++;
                this.mHandler.postDelayed(new b(this.izo, gVar, i, i2, i3, 4, cfg()), 200L);
            } else {
                return false;
            }
            return true;
        }
        this.izp++;
        if (this.izp <= 2) {
            if (!a(gVar, i, i2, i3, uri, cfg())) {
                if (i == -200) {
                    this.mHandler.postDelayed(new b(this.izo, gVar, i, i2, i3, this.izp % 2 == 1 ? 7 : 17, cfg()), 200L);
                    this.izp = 2;
                } else {
                    this.mHandler.postDelayed(new b(this.izo, gVar, i, i2, i3, this.izp % 2 == 1 ? 8 : 18, cfg()), 200L);
                    this.izp = 4;
                    return false;
                }
            }
            return true;
        } else if (this.izp <= 4) {
            if (i == -200) {
                this.mHandler.postDelayed(new b(this.izo, gVar, i, i2, i3, this.izp % 2 == 1 ? 1 : 11, cfg()), 200L);
                return true;
            }
            return false;
        } else if (this.izp <= 6 && i == -200) {
            this.mHandler.postDelayed(new b(this.izo, gVar, i, i2, i3, this.izp % 2 == 1 ? 2 : 12, cfg()), 200L);
            return true;
        } else {
            return false;
        }
    }

    private int cfg() {
        return (this.izq * 100) + this.izp;
    }

    private boolean a(g gVar, int i, int i2, int i3, Uri uri, int i4) {
        if (!cfh() || i == -100 || uri == null || TextUtils.isEmpty(uri.getHost()) || uri.toString().contains("127.0.0.1") || !uri.toString().contains(HttpHost.DEFAULT_SCHEME_NAME)) {
            return false;
        }
        com.baidu.tieba.play.a.b.ceP().a(new C0391a(this.mHandler, this.izo, i, uri, gVar, i2, i3, i4));
        return com.baidu.tieba.play.a.b.ceP().Db(uri.getHost());
    }

    private boolean cfh() {
        return (com.baidu.adp.lib.b.d.hS().az("android_video_http_dns_open") == 0 || !j.kc() || s.avP() == 0) ? false : true;
    }

    /* JADX INFO: Access modifiers changed from: private */
    /* renamed from: com.baidu.tieba.play.b.a$a  reason: collision with other inner class name */
    /* loaded from: classes.dex */
    public static class C0391a implements b.InterfaceC0390b {
        private c izo;
        private g izr;
        private int izs;
        private int izt;
        private Handler mHandler;
        private Uri mUri;
        private int times;
        private int what;

        public C0391a(Handler handler, c cVar, int i, Uri uri, g gVar, int i2, int i3, int i4) {
            this.mHandler = handler;
            this.izo = cVar;
            this.mUri = uri;
            this.izr = gVar;
            this.izs = i;
            this.what = i2;
            this.izt = i3;
            this.times = i4;
        }

        @Override // com.baidu.tieba.play.a.b.InterfaceC0390b
        public void dT(String str, String str2) {
            try {
                if (TextUtils.isEmpty(str) || TextUtils.isEmpty(str2) || this.mUri == null || !str2.equals(this.mUri.getHost())) {
                    if (this.mHandler != null) {
                        this.mHandler.postDelayed(new b(this.izo, this.izr, this.izs, this.what, this.izt, this.times % 2 == 1 ? 5 : 15, this.times), 200L);
                    }
                } else if (this.mHandler != null) {
                    this.mHandler.postDelayed(new b(this.izo, this.izr, this.izs, this.what, this.izt, str, this.times % 2 == 1 ? 0 : 10, this.times), 200L);
                }
            } catch (Throwable th) {
                th.printStackTrace();
                if (this.mHandler != null) {
                    this.mHandler.postDelayed(new b(this.izo, this.izr, this.izs, this.what, this.izt, this.times % 2 == 1 ? 6 : 16, this.times), 200L);
                }
            }
        }
    }

    public boolean cfi() {
        boolean z = this.izp > 0 || this.izq > 0;
        this.izp = 0;
        this.izq = 0;
        return z;
    }

    /* loaded from: classes.dex */
    private static class b implements Runnable {
        private final String ip;
        private c izo;
        private final g izr;
        private final int izs;
        private final int izt;
        private final int times;
        private final int type;
        private final int what;

        public b(c cVar, g gVar, int i, int i2, int i3, int i4, int i5) {
            this.izo = cVar;
            this.izr = gVar;
            this.izs = i;
            this.what = i2;
            this.izt = i3;
            this.type = i4;
            this.times = i5;
            this.ip = "";
        }

        public b(c cVar, g gVar, int i, int i2, int i3, String str, int i4, int i5) {
            this.izo = cVar;
            this.izr = gVar;
            this.izs = i;
            this.what = i2;
            this.izt = i3;
            this.ip = str;
            this.type = i4;
            this.times = i5;
        }

        @Override // java.lang.Runnable
        public void run() {
            if (this.izo != null) {
                if (this.type == 1 || this.type == 5 || this.type == 3 || this.type == 6 || this.type == 7 || this.type == 11 || this.type == 15 || this.type == 16 || this.type == 17) {
                    this.izo.a(this.izr, this.izs, this.what, this.izt, this.times, this.type);
                } else if (this.type == 2 || this.type == 4 || this.type == 8 || this.type == 12 || this.type == 18) {
                    this.izo.b(this.izr, this.izs, this.what, this.izt, this.times, this.type);
                } else if (this.type == 0 || this.type == 10) {
                    this.izo.a(this.izr, this.izs, this.what, this.izt, this.ip, this.times, this.type);
                }
            }
        }
    }

    public void clear() {
        if (this.mHandler != null) {
            this.mHandler.removeCallbacksAndMessages(null);
        }
    }

    public static void Dd(String str) {
        if (!StringUtils.isNull(str)) {
            new BdAsyncTask<String, Void, Void>() { // from class: com.baidu.tieba.play.b.a.1
                /* JADX DEBUG: Method merged with bridge method */
                /* JADX INFO: Access modifiers changed from: protected */
                @Override // com.baidu.adp.lib.asyncTask.BdAsyncTask
                public Void doInBackground(String... strArr) {
                    if (strArr != null && strArr.length == 1) {
                        m.A(new File(strArr[0]).getParentFile());
                    }
                    return null;
                }
            }.execute(str);
        }
    }
}
