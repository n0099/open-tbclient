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
    private c iBg;
    private int iBh = 0;
    private int iBi = 0;
    private Handler mHandler = new Handler();

    public a(c cVar) {
        this.iBg = cVar;
    }

    public boolean a(g gVar, int i, int i2, int i3, Uri uri) {
        if (this.iBg == null) {
            return false;
        }
        if (i == -300) {
            if (this.iBi == 0) {
                this.iBi++;
                this.mHandler.postDelayed(new b(this.iBg, gVar, i, i2, i3, 3, cdm()), 200L);
            } else if (this.iBi == 1) {
                this.iBi++;
                this.mHandler.postDelayed(new b(this.iBg, gVar, i, i2, i3, 4, cdm()), 200L);
            } else {
                return false;
            }
            return true;
        }
        this.iBh++;
        if (this.iBh <= 2) {
            if (!a(gVar, i, i2, i3, uri, cdm())) {
                if (i == -200) {
                    this.mHandler.postDelayed(new b(this.iBg, gVar, i, i2, i3, this.iBh % 2 == 1 ? 7 : 17, cdm()), 200L);
                    this.iBh = 2;
                } else {
                    this.mHandler.postDelayed(new b(this.iBg, gVar, i, i2, i3, this.iBh % 2 == 1 ? 8 : 18, cdm()), 200L);
                    this.iBh = 4;
                    return false;
                }
            }
            return true;
        } else if (this.iBh <= 4) {
            if (i == -200) {
                this.mHandler.postDelayed(new b(this.iBg, gVar, i, i2, i3, this.iBh % 2 == 1 ? 1 : 11, cdm()), 200L);
                return true;
            }
            return false;
        } else if (this.iBh <= 6 && i == -200) {
            this.mHandler.postDelayed(new b(this.iBg, gVar, i, i2, i3, this.iBh % 2 == 1 ? 2 : 12, cdm()), 200L);
            return true;
        } else {
            return false;
        }
    }

    private int cdm() {
        return (this.iBi * 100) + this.iBh;
    }

    private boolean a(g gVar, int i, int i2, int i3, Uri uri, int i4) {
        if (!cdn() || i == -100 || uri == null || TextUtils.isEmpty(uri.getHost()) || uri.toString().contains("127.0.0.1") || !uri.toString().contains(HttpHost.DEFAULT_SCHEME_NAME)) {
            return false;
        }
        com.baidu.tieba.play.b.b.ccW().a(new C0496a(this.mHandler, this.iBg, i, uri, gVar, i2, i3, i4));
        return com.baidu.tieba.play.b.b.ccW().BU(uri.getHost());
    }

    private boolean cdn() {
        return (com.baidu.adp.lib.b.d.ft().af("android_video_http_dns_open") == 0 || !j.isNetWorkAvailable() || s.axi() == 0) ? false : true;
    }

    /* JADX INFO: Access modifiers changed from: private */
    /* renamed from: com.baidu.tieba.play.c.a$a  reason: collision with other inner class name */
    /* loaded from: classes.dex */
    public static class C0496a implements b.InterfaceC0495b {
        private int dNW;
        private c iBg;
        private g iBj;
        private int iBk;
        private int iBl;
        private Handler mHandler;
        private Uri mUri;
        private int what;

        public C0496a(Handler handler, c cVar, int i, Uri uri, g gVar, int i2, int i3, int i4) {
            this.mHandler = handler;
            this.iBg = cVar;
            this.mUri = uri;
            this.iBj = gVar;
            this.iBk = i;
            this.what = i2;
            this.iBl = i3;
            this.dNW = i4;
        }

        @Override // com.baidu.tieba.play.b.b.InterfaceC0495b
        public void dG(String str, String str2) {
            try {
                if (TextUtils.isEmpty(str) || TextUtils.isEmpty(str2) || this.mUri == null || !str2.equals(this.mUri.getHost())) {
                    if (this.mHandler != null) {
                        this.mHandler.postDelayed(new b(this.iBg, this.iBj, this.iBk, this.what, this.iBl, this.dNW % 2 == 1 ? 5 : 15, this.dNW), 200L);
                    }
                } else if (this.mHandler != null) {
                    this.mHandler.postDelayed(new b(this.iBg, this.iBj, this.iBk, this.what, this.iBl, str, this.dNW % 2 == 1 ? 0 : 10, this.dNW), 200L);
                }
            } catch (Throwable th) {
                th.printStackTrace();
                if (this.mHandler != null) {
                    this.mHandler.postDelayed(new b(this.iBg, this.iBj, this.iBk, this.what, this.iBl, this.dNW % 2 == 1 ? 6 : 16, this.dNW), 200L);
                }
            }
        }
    }

    public boolean cdo() {
        boolean z = this.iBh > 0 || this.iBi > 0;
        this.iBh = 0;
        this.iBi = 0;
        return z;
    }

    /* loaded from: classes.dex */
    private static class b implements Runnable {
        private final int dNW;
        private c iBg;
        private final g iBj;
        private final int iBk;
        private final int iBl;
        private final String ip;
        private final int type;
        private final int what;

        public b(c cVar, g gVar, int i, int i2, int i3, int i4, int i5) {
            this.iBg = cVar;
            this.iBj = gVar;
            this.iBk = i;
            this.what = i2;
            this.iBl = i3;
            this.type = i4;
            this.dNW = i5;
            this.ip = "";
        }

        public b(c cVar, g gVar, int i, int i2, int i3, String str, int i4, int i5) {
            this.iBg = cVar;
            this.iBj = gVar;
            this.iBk = i;
            this.what = i2;
            this.iBl = i3;
            this.ip = str;
            this.type = i4;
            this.dNW = i5;
        }

        @Override // java.lang.Runnable
        public void run() {
            if (this.iBg != null) {
                if (this.type == 1 || this.type == 5 || this.type == 3 || this.type == 6 || this.type == 7 || this.type == 11 || this.type == 15 || this.type == 16 || this.type == 17) {
                    this.iBg.a(this.iBj, this.iBk, this.what, this.iBl, this.dNW, this.type);
                } else if (this.type == 2 || this.type == 4 || this.type == 8 || this.type == 12 || this.type == 18) {
                    this.iBg.b(this.iBj, this.iBk, this.what, this.iBl, this.dNW, this.type);
                } else if (this.type == 0 || this.type == 10) {
                    this.iBg.a(this.iBj, this.iBk, this.what, this.iBl, this.ip, this.dNW, this.type);
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
