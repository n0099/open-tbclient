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
    private c iaF;
    private int iaG = 0;
    private int iaH = 0;
    private Handler mHandler = new Handler();

    public a(c cVar) {
        this.iaF = cVar;
    }

    public boolean a(g gVar, int i, int i2, int i3, Uri uri) {
        if (this.iaF == null) {
            return false;
        }
        if (i == -300) {
            if (this.iaH == 0) {
                this.iaH++;
                this.mHandler.postDelayed(new b(this.iaF, gVar, i, i2, i3, 3, bUm()), 200L);
            } else if (this.iaH == 1) {
                this.iaH++;
                this.mHandler.postDelayed(new b(this.iaF, gVar, i, i2, i3, 4, bUm()), 200L);
            } else {
                return false;
            }
            return true;
        }
        this.iaG++;
        if (this.iaG <= 2) {
            if (!a(gVar, i, i2, i3, uri, bUm())) {
                if (i == -200) {
                    this.mHandler.postDelayed(new b(this.iaF, gVar, i, i2, i3, this.iaG % 2 == 1 ? 7 : 17, bUm()), 200L);
                    this.iaG = 2;
                } else {
                    this.mHandler.postDelayed(new b(this.iaF, gVar, i, i2, i3, this.iaG % 2 == 1 ? 8 : 18, bUm()), 200L);
                    this.iaG = 4;
                    return false;
                }
            }
            return true;
        } else if (this.iaG <= 4) {
            if (i == -200) {
                this.mHandler.postDelayed(new b(this.iaF, gVar, i, i2, i3, this.iaG % 2 == 1 ? 1 : 11, bUm()), 200L);
                return true;
            }
            return false;
        } else if (this.iaG <= 6 && i == -200) {
            this.mHandler.postDelayed(new b(this.iaF, gVar, i, i2, i3, this.iaG % 2 == 1 ? 2 : 12, bUm()), 200L);
            return true;
        } else {
            return false;
        }
    }

    private int bUm() {
        return (this.iaH * 100) + this.iaG;
    }

    private boolean a(g gVar, int i, int i2, int i3, Uri uri, int i4) {
        if (!bUn() || i == -100 || uri == null || TextUtils.isEmpty(uri.getHost()) || uri.toString().contains("127.0.0.1") || !uri.toString().contains(HttpHost.DEFAULT_SCHEME_NAME)) {
            return false;
        }
        com.baidu.tieba.play.a.b.bTV().a(new C0293a(this.mHandler, this.iaF, i, uri, gVar, i2, i3, i4));
        return com.baidu.tieba.play.a.b.bTV().AW(uri.getHost());
    }

    private boolean bUn() {
        return (com.baidu.adp.lib.b.d.iQ().aO("android_video_http_dns_open") == 0 || !j.kY() || CustomPlayerSwitchStatic.bSz() == 0) ? false : true;
    }

    /* JADX INFO: Access modifiers changed from: private */
    /* renamed from: com.baidu.tieba.play.b.a$a  reason: collision with other inner class name */
    /* loaded from: classes.dex */
    public static class C0293a implements b.InterfaceC0292b {
        private c iaF;
        private g iaI;
        private int iaJ;
        private int iaK;
        private Handler mHandler;
        private Uri mUri;
        private int times;
        private int what;

        public C0293a(Handler handler, c cVar, int i, Uri uri, g gVar, int i2, int i3, int i4) {
            this.mHandler = handler;
            this.iaF = cVar;
            this.mUri = uri;
            this.iaI = gVar;
            this.iaJ = i;
            this.what = i2;
            this.iaK = i3;
            this.times = i4;
        }

        @Override // com.baidu.tieba.play.a.b.InterfaceC0292b
        public void dF(String str, String str2) {
            try {
                if (TextUtils.isEmpty(str) || TextUtils.isEmpty(str2) || this.mUri == null || !str2.equals(this.mUri.getHost())) {
                    if (this.mHandler != null) {
                        this.mHandler.postDelayed(new b(this.iaF, this.iaI, this.iaJ, this.what, this.iaK, this.times % 2 == 1 ? 5 : 15, this.times), 200L);
                    }
                } else if (this.mHandler != null) {
                    this.mHandler.postDelayed(new b(this.iaF, this.iaI, this.iaJ, this.what, this.iaK, str, this.times % 2 == 1 ? 0 : 10, this.times), 200L);
                }
            } catch (Throwable th) {
                th.printStackTrace();
                if (this.mHandler != null) {
                    this.mHandler.postDelayed(new b(this.iaF, this.iaI, this.iaJ, this.what, this.iaK, this.times % 2 == 1 ? 6 : 16, this.times), 200L);
                }
            }
        }
    }

    public boolean bUo() {
        boolean z = this.iaG > 0 || this.iaH > 0;
        this.iaG = 0;
        this.iaH = 0;
        return z;
    }

    /* JADX INFO: Access modifiers changed from: private */
    /* loaded from: classes.dex */
    public static class b implements Runnable {
        private c iaF;
        private final g iaI;
        private final int iaJ;
        private final int iaK;
        private final String ip;
        private final int times;
        private final int type;
        private final int what;

        public b(c cVar, g gVar, int i, int i2, int i3, int i4, int i5) {
            this.iaF = cVar;
            this.iaI = gVar;
            this.iaJ = i;
            this.what = i2;
            this.iaK = i3;
            this.type = i4;
            this.times = i5;
            this.ip = "";
        }

        public b(c cVar, g gVar, int i, int i2, int i3, String str, int i4, int i5) {
            this.iaF = cVar;
            this.iaI = gVar;
            this.iaJ = i;
            this.what = i2;
            this.iaK = i3;
            this.ip = str;
            this.type = i4;
            this.times = i5;
        }

        @Override // java.lang.Runnable
        public void run() {
            if (this.iaF != null) {
                if (this.type == 1 || this.type == 5 || this.type == 3 || this.type == 6 || this.type == 7 || this.type == 11 || this.type == 15 || this.type == 16 || this.type == 17) {
                    this.iaF.a(this.iaI, this.iaJ, this.what, this.iaK, this.times, this.type);
                } else if (this.type == 2 || this.type == 4 || this.type == 8 || this.type == 12 || this.type == 18) {
                    this.iaF.b(this.iaI, this.iaJ, this.what, this.iaK, this.times, this.type);
                } else if (this.type == 0 || this.type == 10) {
                    this.iaF.a(this.iaI, this.iaJ, this.what, this.iaK, this.ip, this.times, this.type);
                }
            }
        }
    }

    public void clear() {
        if (this.mHandler != null) {
            this.mHandler.removeCallbacksAndMessages(null);
        }
    }

    public static void AY(String str) {
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
