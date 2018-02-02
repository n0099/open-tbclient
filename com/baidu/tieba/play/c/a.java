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
    private c guL;
    private int guM = 0;
    private int guN = 0;
    private Handler mHandler = new Handler();

    public a(c cVar) {
        this.guL = cVar;
    }

    public boolean a(g gVar, int i, int i2, int i3, Uri uri) {
        if (this.guL == null) {
            return false;
        }
        if (i == -300) {
            if (this.guN == 0) {
                this.guN++;
                this.mHandler.postDelayed(new b(this.guL, gVar, i, i2, i3, 3, bkM()), 200L);
            } else if (this.guN == 1) {
                this.guN++;
                this.mHandler.postDelayed(new b(this.guL, gVar, i, i2, i3, 4, bkM()), 200L);
            } else {
                return false;
            }
            return true;
        }
        this.guM++;
        if (this.guM <= 2) {
            if (!a(gVar, i, i2, i3, uri, bkM())) {
                if (i == -200) {
                    this.mHandler.postDelayed(new b(this.guL, gVar, i, i2, i3, this.guM % 2 == 1 ? 7 : 17, bkM()), 200L);
                    this.guM = 2;
                } else {
                    this.mHandler.postDelayed(new b(this.guL, gVar, i, i2, i3, this.guM % 2 == 1 ? 8 : 18, bkM()), 200L);
                    this.guM = 4;
                    return false;
                }
            }
            return true;
        } else if (this.guM <= 4) {
            if (i == -200) {
                this.mHandler.postDelayed(new b(this.guL, gVar, i, i2, i3, this.guM % 2 == 1 ? 1 : 11, bkM()), 200L);
                return true;
            }
            return false;
        } else if (this.guM <= 6 && i == -200) {
            this.mHandler.postDelayed(new b(this.guL, gVar, i, i2, i3, this.guM % 2 == 1 ? 2 : 12, bkM()), 200L);
            return true;
        } else {
            return false;
        }
    }

    private int bkM() {
        return (this.guN * 100) + this.guM;
    }

    private boolean a(g gVar, int i, int i2, int i3, Uri uri, int i4) {
        if (!bkN() || i == -100 || uri == null || TextUtils.isEmpty(uri.getHost()) || uri.toString().contains("127.0.0.1") || !uri.toString().contains(HttpHost.DEFAULT_SCHEME_NAME)) {
            return false;
        }
        com.baidu.tieba.play.a.b.bkL().a(new C0148a(this.mHandler, this.guL, i, uri, gVar, i2, i3, i4));
        return com.baidu.tieba.play.a.b.bkL().rh(uri.getHost());
    }

    private boolean bkN() {
        return (com.baidu.adp.lib.b.d.mA().an("android_video_http_dns_open") == 0 || !j.oJ() || CustomPlayerSwitchStatic.bjD() == 0) ? false : true;
    }

    /* JADX INFO: Access modifiers changed from: private */
    /* renamed from: com.baidu.tieba.play.c.a$a  reason: collision with other inner class name */
    /* loaded from: classes.dex */
    public static class C0148a implements b.InterfaceC0147b {
        private int aTE;
        private c guL;
        private g guO;
        private int guP;
        private int guQ;
        private Handler mHandler;
        private Uri mUri;
        private int what;

        public C0148a(Handler handler, c cVar, int i, Uri uri, g gVar, int i2, int i3, int i4) {
            this.mHandler = handler;
            this.guL = cVar;
            this.mUri = uri;
            this.guO = gVar;
            this.guP = i;
            this.what = i2;
            this.guQ = i3;
            this.aTE = i4;
        }

        @Override // com.baidu.tieba.play.a.b.InterfaceC0147b
        public void bO(String str, String str2) {
            try {
                if (TextUtils.isEmpty(str) || TextUtils.isEmpty(str2) || this.mUri == null || !str2.equals(this.mUri.getHost())) {
                    if (this.mHandler != null) {
                        this.mHandler.postDelayed(new b(this.guL, this.guO, this.guP, this.what, this.guQ, this.aTE % 2 == 1 ? 5 : 15, this.aTE), 200L);
                    }
                } else if (this.mHandler != null) {
                    this.mHandler.postDelayed(new b(this.guL, this.guO, this.guP, this.what, this.guQ, str, this.aTE % 2 == 1 ? 0 : 10, this.aTE), 200L);
                }
            } catch (Throwable th) {
                th.printStackTrace();
                if (this.mHandler != null) {
                    this.mHandler.postDelayed(new b(this.guL, this.guO, this.guP, this.what, this.guQ, this.aTE % 2 == 1 ? 6 : 16, this.aTE), 200L);
                }
            }
        }
    }

    public boolean bkO() {
        boolean z = this.guM > 0 || this.guN > 0;
        this.guM = 0;
        this.guN = 0;
        return z;
    }

    /* JADX INFO: Access modifiers changed from: private */
    /* loaded from: classes.dex */
    public static class b implements Runnable {
        private final int aTE;
        private c guL;
        private final g guO;
        private final int guP;
        private final int guQ;
        private final String ip;
        private final int type;
        private final int what;

        public b(c cVar, g gVar, int i, int i2, int i3, int i4, int i5) {
            this.guL = cVar;
            this.guO = gVar;
            this.guP = i;
            this.what = i2;
            this.guQ = i3;
            this.type = i4;
            this.aTE = i5;
            this.ip = "";
        }

        public b(c cVar, g gVar, int i, int i2, int i3, String str, int i4, int i5) {
            this.guL = cVar;
            this.guO = gVar;
            this.guP = i;
            this.what = i2;
            this.guQ = i3;
            this.ip = str;
            this.type = i4;
            this.aTE = i5;
        }

        @Override // java.lang.Runnable
        public void run() {
            if (this.guL != null) {
                if (this.type == 1 || this.type == 5 || this.type == 3 || this.type == 6 || this.type == 7 || this.type == 11 || this.type == 15 || this.type == 16 || this.type == 17) {
                    this.guL.a(this.guO, this.guP, this.what, this.guQ, this.aTE, this.type);
                } else if (this.type == 2 || this.type == 4 || this.type == 8 || this.type == 12 || this.type == 18) {
                    this.guL.b(this.guO, this.guP, this.what, this.guQ, this.aTE, this.type);
                } else if (this.type == 0 || this.type == 10) {
                    this.guL.a(this.guO, this.guP, this.what, this.guQ, this.ip, this.aTE, this.type);
                }
            }
        }
    }

    public void clear() {
        if (this.mHandler != null) {
            this.mHandler.removeCallbacksAndMessages(null);
        }
    }

    public static void rj(String str) {
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
