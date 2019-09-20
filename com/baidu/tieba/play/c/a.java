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
    private c iCK;
    private int iCL = 0;
    private int iCM = 0;
    private Handler mHandler = new Handler();

    public a(c cVar) {
        this.iCK = cVar;
    }

    public boolean a(g gVar, int i, int i2, int i3, Uri uri) {
        if (this.iCK == null) {
            return false;
        }
        if (i == -300) {
            if (this.iCM == 0) {
                this.iCM++;
                this.mHandler.postDelayed(new b(this.iCK, gVar, i, i2, i3, 3, cgm()), 200L);
            } else if (this.iCM == 1) {
                this.iCM++;
                this.mHandler.postDelayed(new b(this.iCK, gVar, i, i2, i3, 4, cgm()), 200L);
            } else {
                return false;
            }
            return true;
        }
        this.iCL++;
        if (this.iCL <= 2) {
            if (!a(gVar, i, i2, i3, uri, cgm())) {
                if (i == -200) {
                    this.mHandler.postDelayed(new b(this.iCK, gVar, i, i2, i3, this.iCL % 2 == 1 ? 7 : 17, cgm()), 200L);
                    this.iCL = 2;
                } else {
                    this.mHandler.postDelayed(new b(this.iCK, gVar, i, i2, i3, this.iCL % 2 == 1 ? 8 : 18, cgm()), 200L);
                    this.iCL = 4;
                    return false;
                }
            }
            return true;
        } else if (this.iCL <= 4) {
            if (i == -200) {
                this.mHandler.postDelayed(new b(this.iCK, gVar, i, i2, i3, this.iCL % 2 == 1 ? 1 : 11, cgm()), 200L);
                return true;
            }
            return false;
        } else if (this.iCL <= 6 && i == -200) {
            this.mHandler.postDelayed(new b(this.iCK, gVar, i, i2, i3, this.iCL % 2 == 1 ? 2 : 12, cgm()), 200L);
            return true;
        } else {
            return false;
        }
    }

    private int cgm() {
        return (this.iCM * 100) + this.iCL;
    }

    private boolean a(g gVar, int i, int i2, int i3, Uri uri, int i4) {
        if (!cgn() || i == -100 || uri == null || TextUtils.isEmpty(uri.getHost()) || uri.toString().contains("127.0.0.1") || !uri.toString().contains(HttpHost.DEFAULT_SCHEME_NAME)) {
            return false;
        }
        com.baidu.tieba.play.b.b.cfV().a(new C0402a(this.mHandler, this.iCK, i, uri, gVar, i2, i3, i4));
        return com.baidu.tieba.play.b.b.cfV().DB(uri.getHost());
    }

    private boolean cgn() {
        return (com.baidu.adp.lib.b.d.hS().az("android_video_http_dns_open") == 0 || !j.kc() || s.awd() == 0) ? false : true;
    }

    /* JADX INFO: Access modifiers changed from: private */
    /* renamed from: com.baidu.tieba.play.c.a$a  reason: collision with other inner class name */
    /* loaded from: classes.dex */
    public static class C0402a implements b.InterfaceC0401b {
        private c iCK;
        private g iCN;
        private int iCO;
        private int iCP;
        private Handler mHandler;
        private Uri mUri;
        private int times;
        private int what;

        public C0402a(Handler handler, c cVar, int i, Uri uri, g gVar, int i2, int i3, int i4) {
            this.mHandler = handler;
            this.iCK = cVar;
            this.mUri = uri;
            this.iCN = gVar;
            this.iCO = i;
            this.what = i2;
            this.iCP = i3;
            this.times = i4;
        }

        @Override // com.baidu.tieba.play.b.b.InterfaceC0401b
        public void dU(String str, String str2) {
            try {
                if (TextUtils.isEmpty(str) || TextUtils.isEmpty(str2) || this.mUri == null || !str2.equals(this.mUri.getHost())) {
                    if (this.mHandler != null) {
                        this.mHandler.postDelayed(new b(this.iCK, this.iCN, this.iCO, this.what, this.iCP, this.times % 2 == 1 ? 5 : 15, this.times), 200L);
                    }
                } else if (this.mHandler != null) {
                    this.mHandler.postDelayed(new b(this.iCK, this.iCN, this.iCO, this.what, this.iCP, str, this.times % 2 == 1 ? 0 : 10, this.times), 200L);
                }
            } catch (Throwable th) {
                th.printStackTrace();
                if (this.mHandler != null) {
                    this.mHandler.postDelayed(new b(this.iCK, this.iCN, this.iCO, this.what, this.iCP, this.times % 2 == 1 ? 6 : 16, this.times), 200L);
                }
            }
        }
    }

    public boolean cgo() {
        boolean z = this.iCL > 0 || this.iCM > 0;
        this.iCL = 0;
        this.iCM = 0;
        return z;
    }

    /* JADX INFO: Access modifiers changed from: private */
    /* loaded from: classes.dex */
    public static class b implements Runnable {
        private c iCK;
        private final g iCN;
        private final int iCO;
        private final int iCP;
        private final String ip;
        private final int times;
        private final int type;
        private final int what;

        public b(c cVar, g gVar, int i, int i2, int i3, int i4, int i5) {
            this.iCK = cVar;
            this.iCN = gVar;
            this.iCO = i;
            this.what = i2;
            this.iCP = i3;
            this.type = i4;
            this.times = i5;
            this.ip = "";
        }

        public b(c cVar, g gVar, int i, int i2, int i3, String str, int i4, int i5) {
            this.iCK = cVar;
            this.iCN = gVar;
            this.iCO = i;
            this.what = i2;
            this.iCP = i3;
            this.ip = str;
            this.type = i4;
            this.times = i5;
        }

        @Override // java.lang.Runnable
        public void run() {
            if (this.iCK != null) {
                if (this.type == 1 || this.type == 5 || this.type == 3 || this.type == 6 || this.type == 7 || this.type == 11 || this.type == 15 || this.type == 16 || this.type == 17) {
                    this.iCK.a(this.iCN, this.iCO, this.what, this.iCP, this.times, this.type);
                } else if (this.type == 2 || this.type == 4 || this.type == 8 || this.type == 12 || this.type == 18) {
                    this.iCK.b(this.iCN, this.iCO, this.what, this.iCP, this.times, this.type);
                } else if (this.type == 0 || this.type == 10) {
                    this.iCK.a(this.iCN, this.iCO, this.what, this.iCP, this.ip, this.times, this.type);
                }
            }
        }
    }

    public void clear() {
        if (this.mHandler != null) {
            this.mHandler.removeCallbacksAndMessages(null);
        }
    }

    public static void DD(String str) {
        if (!StringUtils.isNull(str)) {
            new BdAsyncTask<String, Void, Void>() { // from class: com.baidu.tieba.play.c.a.1
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
