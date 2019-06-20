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
    private c isX;
    private int isY = 0;
    private int isZ = 0;
    private Handler mHandler = new Handler();

    public a(c cVar) {
        this.isX = cVar;
    }

    public boolean a(g gVar, int i, int i2, int i3, Uri uri) {
        if (this.isX == null) {
            return false;
        }
        if (i == -300) {
            if (this.isZ == 0) {
                this.isZ++;
                this.mHandler.postDelayed(new b(this.isX, gVar, i, i2, i3, 3, ccq()), 200L);
            } else if (this.isZ == 1) {
                this.isZ++;
                this.mHandler.postDelayed(new b(this.isX, gVar, i, i2, i3, 4, ccq()), 200L);
            } else {
                return false;
            }
            return true;
        }
        this.isY++;
        if (this.isY <= 2) {
            if (!a(gVar, i, i2, i3, uri, ccq())) {
                if (i == -200) {
                    this.mHandler.postDelayed(new b(this.isX, gVar, i, i2, i3, this.isY % 2 == 1 ? 7 : 17, ccq()), 200L);
                    this.isY = 2;
                } else {
                    this.mHandler.postDelayed(new b(this.isX, gVar, i, i2, i3, this.isY % 2 == 1 ? 8 : 18, ccq()), 200L);
                    this.isY = 4;
                    return false;
                }
            }
            return true;
        } else if (this.isY <= 4) {
            if (i == -200) {
                this.mHandler.postDelayed(new b(this.isX, gVar, i, i2, i3, this.isY % 2 == 1 ? 1 : 11, ccq()), 200L);
                return true;
            }
            return false;
        } else if (this.isY <= 6 && i == -200) {
            this.mHandler.postDelayed(new b(this.isX, gVar, i, i2, i3, this.isY % 2 == 1 ? 2 : 12, ccq()), 200L);
            return true;
        } else {
            return false;
        }
    }

    private int ccq() {
        return (this.isZ * 100) + this.isY;
    }

    private boolean a(g gVar, int i, int i2, int i3, Uri uri, int i4) {
        if (!ccr() || i == -100 || uri == null || TextUtils.isEmpty(uri.getHost()) || uri.toString().contains("127.0.0.1") || !uri.toString().contains(HttpHost.DEFAULT_SCHEME_NAME)) {
            return false;
        }
        com.baidu.tieba.play.a.b.cbZ().a(new C0386a(this.mHandler, this.isX, i, uri, gVar, i2, i3, i4));
        return com.baidu.tieba.play.a.b.cbZ().Co(uri.getHost());
    }

    private boolean ccr() {
        return (com.baidu.adp.lib.b.d.hI().ay("android_video_http_dns_open") == 0 || !j.jS() || s.auG() == 0) ? false : true;
    }

    /* JADX INFO: Access modifiers changed from: private */
    /* renamed from: com.baidu.tieba.play.b.a$a  reason: collision with other inner class name */
    /* loaded from: classes.dex */
    public static class C0386a implements b.InterfaceC0385b {
        private c isX;
        private g ita;
        private int itb;
        private int itc;
        private Handler mHandler;
        private Uri mUri;
        private int times;
        private int what;

        public C0386a(Handler handler, c cVar, int i, Uri uri, g gVar, int i2, int i3, int i4) {
            this.mHandler = handler;
            this.isX = cVar;
            this.mUri = uri;
            this.ita = gVar;
            this.itb = i;
            this.what = i2;
            this.itc = i3;
            this.times = i4;
        }

        @Override // com.baidu.tieba.play.a.b.InterfaceC0385b
        public void dS(String str, String str2) {
            try {
                if (TextUtils.isEmpty(str) || TextUtils.isEmpty(str2) || this.mUri == null || !str2.equals(this.mUri.getHost())) {
                    if (this.mHandler != null) {
                        this.mHandler.postDelayed(new b(this.isX, this.ita, this.itb, this.what, this.itc, this.times % 2 == 1 ? 5 : 15, this.times), 200L);
                    }
                } else if (this.mHandler != null) {
                    this.mHandler.postDelayed(new b(this.isX, this.ita, this.itb, this.what, this.itc, str, this.times % 2 == 1 ? 0 : 10, this.times), 200L);
                }
            } catch (Throwable th) {
                th.printStackTrace();
                if (this.mHandler != null) {
                    this.mHandler.postDelayed(new b(this.isX, this.ita, this.itb, this.what, this.itc, this.times % 2 == 1 ? 6 : 16, this.times), 200L);
                }
            }
        }
    }

    public boolean ccs() {
        boolean z = this.isY > 0 || this.isZ > 0;
        this.isY = 0;
        this.isZ = 0;
        return z;
    }

    /* loaded from: classes.dex */
    private static class b implements Runnable {
        private final String ip;
        private c isX;
        private final g ita;
        private final int itb;
        private final int itc;
        private final int times;
        private final int type;
        private final int what;

        public b(c cVar, g gVar, int i, int i2, int i3, int i4, int i5) {
            this.isX = cVar;
            this.ita = gVar;
            this.itb = i;
            this.what = i2;
            this.itc = i3;
            this.type = i4;
            this.times = i5;
            this.ip = "";
        }

        public b(c cVar, g gVar, int i, int i2, int i3, String str, int i4, int i5) {
            this.isX = cVar;
            this.ita = gVar;
            this.itb = i;
            this.what = i2;
            this.itc = i3;
            this.ip = str;
            this.type = i4;
            this.times = i5;
        }

        @Override // java.lang.Runnable
        public void run() {
            if (this.isX != null) {
                if (this.type == 1 || this.type == 5 || this.type == 3 || this.type == 6 || this.type == 7 || this.type == 11 || this.type == 15 || this.type == 16 || this.type == 17) {
                    this.isX.a(this.ita, this.itb, this.what, this.itc, this.times, this.type);
                } else if (this.type == 2 || this.type == 4 || this.type == 8 || this.type == 12 || this.type == 18) {
                    this.isX.b(this.ita, this.itb, this.what, this.itc, this.times, this.type);
                } else if (this.type == 0 || this.type == 10) {
                    this.isX.a(this.ita, this.itb, this.what, this.itc, this.ip, this.times, this.type);
                }
            }
        }
    }

    public void clear() {
        if (this.mHandler != null) {
            this.mHandler.removeCallbacksAndMessages(null);
        }
    }

    public static void Cq(String str) {
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
