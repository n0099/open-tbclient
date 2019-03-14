package com.baidu.tieba.play.b;

import android.net.Uri;
import android.os.Handler;
import android.text.TextUtils;
import com.baidu.adp.lib.asyncTask.BdAsyncTask;
import com.baidu.adp.lib.util.StringUtils;
import com.baidu.adp.lib.util.j;
import com.baidu.tbadk.core.util.m;
import com.baidu.tieba.play.CustomPlayerSwitchStatic;
import com.baidu.tieba.play.a.b;
import com.baidu.tieba.play.g;
import java.io.File;
import org.apache.http.HttpHost;
/* loaded from: classes.dex */
public class a {
    private c iaA;
    private int iaB = 0;
    private int iaC = 0;
    private Handler mHandler = new Handler();

    public a(c cVar) {
        this.iaA = cVar;
    }

    public boolean a(g gVar, int i, int i2, int i3, Uri uri) {
        if (this.iaA == null) {
            return false;
        }
        if (i == -300) {
            if (this.iaC == 0) {
                this.iaC++;
                this.mHandler.postDelayed(new b(this.iaA, gVar, i, i2, i3, 3, bUp()), 200L);
            } else if (this.iaC == 1) {
                this.iaC++;
                this.mHandler.postDelayed(new b(this.iaA, gVar, i, i2, i3, 4, bUp()), 200L);
            } else {
                return false;
            }
            return true;
        }
        this.iaB++;
        if (this.iaB <= 2) {
            if (!a(gVar, i, i2, i3, uri, bUp())) {
                if (i == -200) {
                    this.mHandler.postDelayed(new b(this.iaA, gVar, i, i2, i3, this.iaB % 2 == 1 ? 7 : 17, bUp()), 200L);
                    this.iaB = 2;
                } else {
                    this.mHandler.postDelayed(new b(this.iaA, gVar, i, i2, i3, this.iaB % 2 == 1 ? 8 : 18, bUp()), 200L);
                    this.iaB = 4;
                    return false;
                }
            }
            return true;
        } else if (this.iaB <= 4) {
            if (i == -200) {
                this.mHandler.postDelayed(new b(this.iaA, gVar, i, i2, i3, this.iaB % 2 == 1 ? 1 : 11, bUp()), 200L);
                return true;
            }
            return false;
        } else if (this.iaB <= 6 && i == -200) {
            this.mHandler.postDelayed(new b(this.iaA, gVar, i, i2, i3, this.iaB % 2 == 1 ? 2 : 12, bUp()), 200L);
            return true;
        } else {
            return false;
        }
    }

    private int bUp() {
        return (this.iaC * 100) + this.iaB;
    }

    private boolean a(g gVar, int i, int i2, int i3, Uri uri, int i4) {
        if (!bUq() || i == -100 || uri == null || TextUtils.isEmpty(uri.getHost()) || uri.toString().contains("127.0.0.1") || !uri.toString().contains(HttpHost.DEFAULT_SCHEME_NAME)) {
            return false;
        }
        com.baidu.tieba.play.a.b.bTY().a(new C0367a(this.mHandler, this.iaA, i, uri, gVar, i2, i3, i4));
        return com.baidu.tieba.play.a.b.bTY().AV(uri.getHost());
    }

    private boolean bUq() {
        return (com.baidu.adp.lib.b.d.iQ().aO("android_video_http_dns_open") == 0 || !j.kY() || CustomPlayerSwitchStatic.bSC() == 0) ? false : true;
    }

    /* JADX INFO: Access modifiers changed from: private */
    /* renamed from: com.baidu.tieba.play.b.a$a  reason: collision with other inner class name */
    /* loaded from: classes.dex */
    public static class C0367a implements b.InterfaceC0366b {
        private c iaA;
        private g iaD;
        private int iaE;
        private int iaF;
        private Handler mHandler;
        private Uri mUri;
        private int times;
        private int what;

        public C0367a(Handler handler, c cVar, int i, Uri uri, g gVar, int i2, int i3, int i4) {
            this.mHandler = handler;
            this.iaA = cVar;
            this.mUri = uri;
            this.iaD = gVar;
            this.iaE = i;
            this.what = i2;
            this.iaF = i3;
            this.times = i4;
        }

        @Override // com.baidu.tieba.play.a.b.InterfaceC0366b
        public void dF(String str, String str2) {
            try {
                if (TextUtils.isEmpty(str) || TextUtils.isEmpty(str2) || this.mUri == null || !str2.equals(this.mUri.getHost())) {
                    if (this.mHandler != null) {
                        this.mHandler.postDelayed(new b(this.iaA, this.iaD, this.iaE, this.what, this.iaF, this.times % 2 == 1 ? 5 : 15, this.times), 200L);
                    }
                } else if (this.mHandler != null) {
                    this.mHandler.postDelayed(new b(this.iaA, this.iaD, this.iaE, this.what, this.iaF, str, this.times % 2 == 1 ? 0 : 10, this.times), 200L);
                }
            } catch (Throwable th) {
                th.printStackTrace();
                if (this.mHandler != null) {
                    this.mHandler.postDelayed(new b(this.iaA, this.iaD, this.iaE, this.what, this.iaF, this.times % 2 == 1 ? 6 : 16, this.times), 200L);
                }
            }
        }
    }

    public boolean bUr() {
        boolean z = this.iaB > 0 || this.iaC > 0;
        this.iaB = 0;
        this.iaC = 0;
        return z;
    }

    /* JADX INFO: Access modifiers changed from: private */
    /* loaded from: classes.dex */
    public static class b implements Runnable {
        private c iaA;
        private final g iaD;
        private final int iaE;
        private final int iaF;
        private final String ip;
        private final int times;
        private final int type;
        private final int what;

        public b(c cVar, g gVar, int i, int i2, int i3, int i4, int i5) {
            this.iaA = cVar;
            this.iaD = gVar;
            this.iaE = i;
            this.what = i2;
            this.iaF = i3;
            this.type = i4;
            this.times = i5;
            this.ip = "";
        }

        public b(c cVar, g gVar, int i, int i2, int i3, String str, int i4, int i5) {
            this.iaA = cVar;
            this.iaD = gVar;
            this.iaE = i;
            this.what = i2;
            this.iaF = i3;
            this.ip = str;
            this.type = i4;
            this.times = i5;
        }

        @Override // java.lang.Runnable
        public void run() {
            if (this.iaA != null) {
                if (this.type == 1 || this.type == 5 || this.type == 3 || this.type == 6 || this.type == 7 || this.type == 11 || this.type == 15 || this.type == 16 || this.type == 17) {
                    this.iaA.a(this.iaD, this.iaE, this.what, this.iaF, this.times, this.type);
                } else if (this.type == 2 || this.type == 4 || this.type == 8 || this.type == 12 || this.type == 18) {
                    this.iaA.b(this.iaD, this.iaE, this.what, this.iaF, this.times, this.type);
                } else if (this.type == 0 || this.type == 10) {
                    this.iaA.a(this.iaD, this.iaE, this.what, this.iaF, this.ip, this.times, this.type);
                }
            }
        }
    }

    public void clear() {
        if (this.mHandler != null) {
            this.mHandler.removeCallbacksAndMessages(null);
        }
    }

    public static void AX(String str) {
        if (!StringUtils.isNull(str)) {
            new BdAsyncTask<String, Void, Void>() { // from class: com.baidu.tieba.play.b.a.1
                /* JADX DEBUG: Method merged with bridge method */
                /* JADX INFO: Access modifiers changed from: protected */
                @Override // com.baidu.adp.lib.asyncTask.BdAsyncTask
                public Void doInBackground(String... strArr) {
                    if (strArr != null && strArr.length == 1) {
                        m.G(new File(strArr[0]).getParentFile());
                    }
                    return null;
                }
            }.execute(str);
        }
    }
}
