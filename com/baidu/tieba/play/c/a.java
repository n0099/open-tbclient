package com.baidu.tieba.play.c;

import android.net.Uri;
import android.os.Handler;
import android.text.TextUtils;
import com.baidu.adp.lib.asyncTask.BdAsyncTask;
import com.baidu.adp.lib.util.StringUtils;
import com.baidu.adp.lib.util.j;
import com.baidu.tbadk.core.util.k;
import com.baidu.tieba.play.CustomPlayerSwitchStatic;
import com.baidu.tieba.play.a.b;
import com.baidu.tieba.play.g;
import java.io.File;
import org.apache.http.HttpHost;
/* loaded from: classes.dex */
public class a {
    private c gFi;
    private int gFj = 0;
    private int gFk = 0;
    private Handler mHandler = new Handler();

    public a(c cVar) {
        this.gFi = cVar;
    }

    public boolean a(g gVar, int i, int i2, int i3, Uri uri) {
        if (this.gFi == null) {
            return false;
        }
        if (i == -300) {
            if (this.gFk == 0) {
                this.gFk++;
                this.mHandler.postDelayed(new b(this.gFi, gVar, i, i2, i3, 3, brs()), 200L);
            } else if (this.gFk == 1) {
                this.gFk++;
                this.mHandler.postDelayed(new b(this.gFi, gVar, i, i2, i3, 4, brs()), 200L);
            } else {
                return false;
            }
            return true;
        }
        this.gFj++;
        if (this.gFj <= 2) {
            if (!a(gVar, i, i2, i3, uri, brs())) {
                if (i == -200) {
                    this.mHandler.postDelayed(new b(this.gFi, gVar, i, i2, i3, this.gFj % 2 == 1 ? 7 : 17, brs()), 200L);
                    this.gFj = 2;
                } else {
                    this.mHandler.postDelayed(new b(this.gFi, gVar, i, i2, i3, this.gFj % 2 == 1 ? 8 : 18, brs()), 200L);
                    this.gFj = 4;
                    return false;
                }
            }
            return true;
        } else if (this.gFj <= 4) {
            if (i == -200) {
                this.mHandler.postDelayed(new b(this.gFi, gVar, i, i2, i3, this.gFj % 2 == 1 ? 1 : 11, brs()), 200L);
                return true;
            }
            return false;
        } else if (this.gFj <= 6 && i == -200) {
            this.mHandler.postDelayed(new b(this.gFi, gVar, i, i2, i3, this.gFj % 2 == 1 ? 2 : 12, brs()), 200L);
            return true;
        } else {
            return false;
        }
    }

    private int brs() {
        return (this.gFk * 100) + this.gFj;
    }

    private boolean a(g gVar, int i, int i2, int i3, Uri uri, int i4) {
        if (!brt() || i == -100 || uri == null || TextUtils.isEmpty(uri.getHost()) || uri.toString().contains("127.0.0.1") || !uri.toString().contains(HttpHost.DEFAULT_SCHEME_NAME)) {
            return false;
        }
        com.baidu.tieba.play.a.b.brr().a(new C0148a(this.mHandler, this.gFi, i, uri, gVar, i2, i3, i4));
        return com.baidu.tieba.play.a.b.brr().rF(uri.getHost());
    }

    private boolean brt() {
        return (com.baidu.adp.lib.b.d.mz().an("android_video_http_dns_open") == 0 || !j.oI() || CustomPlayerSwitchStatic.bqj() == 0) ? false : true;
    }

    /* JADX INFO: Access modifiers changed from: private */
    /* renamed from: com.baidu.tieba.play.c.a$a  reason: collision with other inner class name */
    /* loaded from: classes.dex */
    public static class C0148a implements b.InterfaceC0147b {
        private int aTC;
        private c gFi;
        private g gFl;
        private int gFm;
        private int gFn;
        private Handler mHandler;
        private Uri mUri;
        private int what;

        public C0148a(Handler handler, c cVar, int i, Uri uri, g gVar, int i2, int i3, int i4) {
            this.mHandler = handler;
            this.gFi = cVar;
            this.mUri = uri;
            this.gFl = gVar;
            this.gFm = i;
            this.what = i2;
            this.gFn = i3;
            this.aTC = i4;
        }

        @Override // com.baidu.tieba.play.a.b.InterfaceC0147b
        public void bT(String str, String str2) {
            try {
                if (TextUtils.isEmpty(str) || TextUtils.isEmpty(str2) || this.mUri == null || !str2.equals(this.mUri.getHost())) {
                    if (this.mHandler != null) {
                        this.mHandler.postDelayed(new b(this.gFi, this.gFl, this.gFm, this.what, this.gFn, this.aTC % 2 == 1 ? 5 : 15, this.aTC), 200L);
                    }
                } else if (this.mHandler != null) {
                    this.mHandler.postDelayed(new b(this.gFi, this.gFl, this.gFm, this.what, this.gFn, str, this.aTC % 2 == 1 ? 0 : 10, this.aTC), 200L);
                }
            } catch (Throwable th) {
                th.printStackTrace();
                if (this.mHandler != null) {
                    this.mHandler.postDelayed(new b(this.gFi, this.gFl, this.gFm, this.what, this.gFn, this.aTC % 2 == 1 ? 6 : 16, this.aTC), 200L);
                }
            }
        }
    }

    public boolean bru() {
        boolean z = this.gFj > 0 || this.gFk > 0;
        this.gFj = 0;
        this.gFk = 0;
        return z;
    }

    /* JADX INFO: Access modifiers changed from: private */
    /* loaded from: classes.dex */
    public static class b implements Runnable {
        private final int aTC;
        private c gFi;
        private final g gFl;
        private final int gFm;
        private final int gFn;
        private final String ip;
        private final int type;
        private final int what;

        public b(c cVar, g gVar, int i, int i2, int i3, int i4, int i5) {
            this.gFi = cVar;
            this.gFl = gVar;
            this.gFm = i;
            this.what = i2;
            this.gFn = i3;
            this.type = i4;
            this.aTC = i5;
            this.ip = "";
        }

        public b(c cVar, g gVar, int i, int i2, int i3, String str, int i4, int i5) {
            this.gFi = cVar;
            this.gFl = gVar;
            this.gFm = i;
            this.what = i2;
            this.gFn = i3;
            this.ip = str;
            this.type = i4;
            this.aTC = i5;
        }

        @Override // java.lang.Runnable
        public void run() {
            if (this.gFi != null) {
                if (this.type == 1 || this.type == 5 || this.type == 3 || this.type == 6 || this.type == 7 || this.type == 11 || this.type == 15 || this.type == 16 || this.type == 17) {
                    this.gFi.a(this.gFl, this.gFm, this.what, this.gFn, this.aTC, this.type);
                } else if (this.type == 2 || this.type == 4 || this.type == 8 || this.type == 12 || this.type == 18) {
                    this.gFi.b(this.gFl, this.gFm, this.what, this.gFn, this.aTC, this.type);
                } else if (this.type == 0 || this.type == 10) {
                    this.gFi.a(this.gFl, this.gFm, this.what, this.gFn, this.ip, this.aTC, this.type);
                }
            }
        }
    }

    public void clear() {
        if (this.mHandler != null) {
            this.mHandler.removeCallbacksAndMessages(null);
        }
    }

    public static void rH(String str) {
        if (!StringUtils.isNull(str)) {
            new BdAsyncTask<String, Void, Void>() { // from class: com.baidu.tieba.play.c.a.1
                /* JADX DEBUG: Method merged with bridge method */
                /* JADX INFO: Access modifiers changed from: protected */
                @Override // com.baidu.adp.lib.asyncTask.BdAsyncTask
                public Void doInBackground(String... strArr) {
                    if (strArr != null && strArr.length == 1) {
                        k.s(new File(strArr[0]).getParentFile());
                    }
                    return null;
                }
            }.execute(str);
        }
    }
}
