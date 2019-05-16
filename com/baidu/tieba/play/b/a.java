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
    private c isT;
    private int isU = 0;
    private int isV = 0;
    private Handler mHandler = new Handler();

    public a(c cVar) {
        this.isT = cVar;
    }

    public boolean a(g gVar, int i, int i2, int i3, Uri uri) {
        if (this.isT == null) {
            return false;
        }
        if (i == -300) {
            if (this.isV == 0) {
                this.isV++;
                this.mHandler.postDelayed(new b(this.isT, gVar, i, i2, i3, 3, ccm()), 200L);
            } else if (this.isV == 1) {
                this.isV++;
                this.mHandler.postDelayed(new b(this.isT, gVar, i, i2, i3, 4, ccm()), 200L);
            } else {
                return false;
            }
            return true;
        }
        this.isU++;
        if (this.isU <= 2) {
            if (!a(gVar, i, i2, i3, uri, ccm())) {
                if (i == -200) {
                    this.mHandler.postDelayed(new b(this.isT, gVar, i, i2, i3, this.isU % 2 == 1 ? 7 : 17, ccm()), 200L);
                    this.isU = 2;
                } else {
                    this.mHandler.postDelayed(new b(this.isT, gVar, i, i2, i3, this.isU % 2 == 1 ? 8 : 18, ccm()), 200L);
                    this.isU = 4;
                    return false;
                }
            }
            return true;
        } else if (this.isU <= 4) {
            if (i == -200) {
                this.mHandler.postDelayed(new b(this.isT, gVar, i, i2, i3, this.isU % 2 == 1 ? 1 : 11, ccm()), 200L);
                return true;
            }
            return false;
        } else if (this.isU <= 6 && i == -200) {
            this.mHandler.postDelayed(new b(this.isT, gVar, i, i2, i3, this.isU % 2 == 1 ? 2 : 12, ccm()), 200L);
            return true;
        } else {
            return false;
        }
    }

    private int ccm() {
        return (this.isV * 100) + this.isU;
    }

    private boolean a(g gVar, int i, int i2, int i3, Uri uri, int i4) {
        if (!ccn() || i == -100 || uri == null || TextUtils.isEmpty(uri.getHost()) || uri.toString().contains("127.0.0.1") || !uri.toString().contains(HttpHost.DEFAULT_SCHEME_NAME)) {
            return false;
        }
        com.baidu.tieba.play.a.b.cbV().a(new C0386a(this.mHandler, this.isT, i, uri, gVar, i2, i3, i4));
        return com.baidu.tieba.play.a.b.cbV().Cm(uri.getHost());
    }

    private boolean ccn() {
        return (com.baidu.adp.lib.b.d.hI().ay("android_video_http_dns_open") == 0 || !j.jS() || s.auG() == 0) ? false : true;
    }

    /* JADX INFO: Access modifiers changed from: private */
    /* renamed from: com.baidu.tieba.play.b.a$a  reason: collision with other inner class name */
    /* loaded from: classes.dex */
    public static class C0386a implements b.InterfaceC0385b {
        private c isT;
        private g isW;
        private int isX;
        private int isY;
        private Handler mHandler;
        private Uri mUri;
        private int times;
        private int what;

        public C0386a(Handler handler, c cVar, int i, Uri uri, g gVar, int i2, int i3, int i4) {
            this.mHandler = handler;
            this.isT = cVar;
            this.mUri = uri;
            this.isW = gVar;
            this.isX = i;
            this.what = i2;
            this.isY = i3;
            this.times = i4;
        }

        @Override // com.baidu.tieba.play.a.b.InterfaceC0385b
        public void dS(String str, String str2) {
            try {
                if (TextUtils.isEmpty(str) || TextUtils.isEmpty(str2) || this.mUri == null || !str2.equals(this.mUri.getHost())) {
                    if (this.mHandler != null) {
                        this.mHandler.postDelayed(new b(this.isT, this.isW, this.isX, this.what, this.isY, this.times % 2 == 1 ? 5 : 15, this.times), 200L);
                    }
                } else if (this.mHandler != null) {
                    this.mHandler.postDelayed(new b(this.isT, this.isW, this.isX, this.what, this.isY, str, this.times % 2 == 1 ? 0 : 10, this.times), 200L);
                }
            } catch (Throwable th) {
                th.printStackTrace();
                if (this.mHandler != null) {
                    this.mHandler.postDelayed(new b(this.isT, this.isW, this.isX, this.what, this.isY, this.times % 2 == 1 ? 6 : 16, this.times), 200L);
                }
            }
        }
    }

    public boolean cco() {
        boolean z = this.isU > 0 || this.isV > 0;
        this.isU = 0;
        this.isV = 0;
        return z;
    }

    /* loaded from: classes.dex */
    private static class b implements Runnable {
        private final String ip;
        private c isT;
        private final g isW;
        private final int isX;
        private final int isY;
        private final int times;
        private final int type;
        private final int what;

        public b(c cVar, g gVar, int i, int i2, int i3, int i4, int i5) {
            this.isT = cVar;
            this.isW = gVar;
            this.isX = i;
            this.what = i2;
            this.isY = i3;
            this.type = i4;
            this.times = i5;
            this.ip = "";
        }

        public b(c cVar, g gVar, int i, int i2, int i3, String str, int i4, int i5) {
            this.isT = cVar;
            this.isW = gVar;
            this.isX = i;
            this.what = i2;
            this.isY = i3;
            this.ip = str;
            this.type = i4;
            this.times = i5;
        }

        @Override // java.lang.Runnable
        public void run() {
            if (this.isT != null) {
                if (this.type == 1 || this.type == 5 || this.type == 3 || this.type == 6 || this.type == 7 || this.type == 11 || this.type == 15 || this.type == 16 || this.type == 17) {
                    this.isT.a(this.isW, this.isX, this.what, this.isY, this.times, this.type);
                } else if (this.type == 2 || this.type == 4 || this.type == 8 || this.type == 12 || this.type == 18) {
                    this.isT.b(this.isW, this.isX, this.what, this.isY, this.times, this.type);
                } else if (this.type == 0 || this.type == 10) {
                    this.isT.a(this.isW, this.isX, this.what, this.isY, this.ip, this.times, this.type);
                }
            }
        }
    }

    public void clear() {
        if (this.mHandler != null) {
            this.mHandler.removeCallbacksAndMessages(null);
        }
    }

    public static void Co(String str) {
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
