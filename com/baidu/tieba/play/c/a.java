package com.baidu.tieba.play.c;

import android.net.Uri;
import android.os.Handler;
import android.text.TextUtils;
import com.baidu.adp.lib.asyncTask.BdAsyncTask;
import com.baidu.adp.lib.util.StringUtils;
import com.baidu.adp.lib.util.j;
import com.baidu.tbadk.core.util.m;
import com.baidu.tbadk.t.s;
import com.baidu.tieba.play.b.b;
import com.baidu.tieba.play.g;
import java.io.File;
import org.apache.http.HttpHost;
/* loaded from: classes.dex */
public class a {
    private c iAp;
    private int iAq = 0;
    private int iAr = 0;
    private Handler mHandler = new Handler();

    public a(c cVar) {
        this.iAp = cVar;
    }

    public boolean a(g gVar, int i, int i2, int i3, Uri uri) {
        if (this.iAp == null) {
            return false;
        }
        if (i == -300) {
            if (this.iAr == 0) {
                this.iAr++;
                this.mHandler.postDelayed(new b(this.iAp, gVar, i, i2, i3, 3, cdk()), 200L);
            } else if (this.iAr == 1) {
                this.iAr++;
                this.mHandler.postDelayed(new b(this.iAp, gVar, i, i2, i3, 4, cdk()), 200L);
            } else {
                return false;
            }
            return true;
        }
        this.iAq++;
        if (this.iAq <= 2) {
            if (!a(gVar, i, i2, i3, uri, cdk())) {
                if (i == -200) {
                    this.mHandler.postDelayed(new b(this.iAp, gVar, i, i2, i3, this.iAq % 2 == 1 ? 7 : 17, cdk()), 200L);
                    this.iAq = 2;
                } else {
                    this.mHandler.postDelayed(new b(this.iAp, gVar, i, i2, i3, this.iAq % 2 == 1 ? 8 : 18, cdk()), 200L);
                    this.iAq = 4;
                    return false;
                }
            }
            return true;
        } else if (this.iAq <= 4) {
            if (i == -200) {
                this.mHandler.postDelayed(new b(this.iAp, gVar, i, i2, i3, this.iAq % 2 == 1 ? 1 : 11, cdk()), 200L);
                return true;
            }
            return false;
        } else if (this.iAq <= 6 && i == -200) {
            this.mHandler.postDelayed(new b(this.iAp, gVar, i, i2, i3, this.iAq % 2 == 1 ? 2 : 12, cdk()), 200L);
            return true;
        } else {
            return false;
        }
    }

    private int cdk() {
        return (this.iAr * 100) + this.iAq;
    }

    private boolean a(g gVar, int i, int i2, int i3, Uri uri, int i4) {
        if (!cdl() || i == -100 || uri == null || TextUtils.isEmpty(uri.getHost()) || uri.toString().contains("127.0.0.1") || !uri.toString().contains(HttpHost.DEFAULT_SCHEME_NAME)) {
            return false;
        }
        com.baidu.tieba.play.b.b.ccU().a(new C0496a(this.mHandler, this.iAp, i, uri, gVar, i2, i3, i4));
        return com.baidu.tieba.play.b.b.ccU().BU(uri.getHost());
    }

    private boolean cdl() {
        return (com.baidu.adp.lib.b.d.ft().af("android_video_http_dns_open") == 0 || !j.isNetWorkAvailable() || s.axg() == 0) ? false : true;
    }

    /* JADX INFO: Access modifiers changed from: private */
    /* renamed from: com.baidu.tieba.play.c.a$a  reason: collision with other inner class name */
    /* loaded from: classes.dex */
    public static class C0496a implements b.InterfaceC0495b {
        private int dNf;
        private c iAp;
        private g iAs;
        private int iAt;
        private int iAu;
        private Handler mHandler;
        private Uri mUri;
        private int what;

        public C0496a(Handler handler, c cVar, int i, Uri uri, g gVar, int i2, int i3, int i4) {
            this.mHandler = handler;
            this.iAp = cVar;
            this.mUri = uri;
            this.iAs = gVar;
            this.iAt = i;
            this.what = i2;
            this.iAu = i3;
            this.dNf = i4;
        }

        @Override // com.baidu.tieba.play.b.b.InterfaceC0495b
        public void dG(String str, String str2) {
            try {
                if (TextUtils.isEmpty(str) || TextUtils.isEmpty(str2) || this.mUri == null || !str2.equals(this.mUri.getHost())) {
                    if (this.mHandler != null) {
                        this.mHandler.postDelayed(new b(this.iAp, this.iAs, this.iAt, this.what, this.iAu, this.dNf % 2 == 1 ? 5 : 15, this.dNf), 200L);
                    }
                } else if (this.mHandler != null) {
                    this.mHandler.postDelayed(new b(this.iAp, this.iAs, this.iAt, this.what, this.iAu, str, this.dNf % 2 == 1 ? 0 : 10, this.dNf), 200L);
                }
            } catch (Throwable th) {
                th.printStackTrace();
                if (this.mHandler != null) {
                    this.mHandler.postDelayed(new b(this.iAp, this.iAs, this.iAt, this.what, this.iAu, this.dNf % 2 == 1 ? 6 : 16, this.dNf), 200L);
                }
            }
        }
    }

    public boolean cdm() {
        boolean z = this.iAq > 0 || this.iAr > 0;
        this.iAq = 0;
        this.iAr = 0;
        return z;
    }

    /* JADX INFO: Access modifiers changed from: private */
    /* loaded from: classes.dex */
    public static class b implements Runnable {
        private final int dNf;
        private c iAp;
        private final g iAs;
        private final int iAt;
        private final int iAu;
        private final String ip;
        private final int type;
        private final int what;

        public b(c cVar, g gVar, int i, int i2, int i3, int i4, int i5) {
            this.iAp = cVar;
            this.iAs = gVar;
            this.iAt = i;
            this.what = i2;
            this.iAu = i3;
            this.type = i4;
            this.dNf = i5;
            this.ip = "";
        }

        public b(c cVar, g gVar, int i, int i2, int i3, String str, int i4, int i5) {
            this.iAp = cVar;
            this.iAs = gVar;
            this.iAt = i;
            this.what = i2;
            this.iAu = i3;
            this.ip = str;
            this.type = i4;
            this.dNf = i5;
        }

        @Override // java.lang.Runnable
        public void run() {
            if (this.iAp != null) {
                if (this.type == 1 || this.type == 5 || this.type == 3 || this.type == 6 || this.type == 7 || this.type == 11 || this.type == 15 || this.type == 16 || this.type == 17) {
                    this.iAp.a(this.iAs, this.iAt, this.what, this.iAu, this.dNf, this.type);
                } else if (this.type == 2 || this.type == 4 || this.type == 8 || this.type == 12 || this.type == 18) {
                    this.iAp.b(this.iAs, this.iAt, this.what, this.iAu, this.dNf, this.type);
                } else if (this.type == 0 || this.type == 10) {
                    this.iAp.a(this.iAs, this.iAt, this.what, this.iAu, this.ip, this.dNf, this.type);
                }
            }
        }
    }

    public void clear() {
        if (this.mHandler != null) {
            this.mHandler.removeCallbacksAndMessages(null);
        }
    }

    public static void BW(String str) {
        if (!StringUtils.isNull(str)) {
            new BdAsyncTask<String, Void, Void>() { // from class: com.baidu.tieba.play.c.a.1
                /* JADX DEBUG: Method merged with bridge method */
                /* JADX INFO: Access modifiers changed from: protected */
                @Override // com.baidu.adp.lib.asyncTask.BdAsyncTask
                public Void doInBackground(String... strArr) {
                    if (strArr != null && strArr.length == 1) {
                        m.deleteFileOrDir(new File(strArr[0]).getParentFile());
                    }
                    return null;
                }
            }.execute(str);
        }
    }
}
