package com.baidu.tieba.play.b;

import android.net.Uri;
import android.os.Handler;
import android.text.TextUtils;
import com.baidu.adp.lib.asyncTask.BdAsyncTask;
import com.baidu.adp.lib.util.StringUtils;
import com.baidu.adp.lib.util.j;
import com.baidu.tbadk.core.util.l;
import com.baidu.tieba.play.CustomPlayerSwitchStatic;
import com.baidu.tieba.play.a.b;
import com.baidu.tieba.play.g;
import java.io.File;
import org.apache.http.HttpHost;
/* loaded from: classes.dex */
public class a {
    private c gdx;
    private int gdy = 0;
    private int gdz = 0;
    private Handler mHandler = new Handler();

    public a(c cVar) {
        this.gdx = cVar;
    }

    public boolean a(g gVar, int i, int i2, int i3, Uri uri) {
        if (this.gdx == null) {
            return false;
        }
        if (i == -300) {
            if (this.gdz == 0) {
                this.gdz++;
                this.mHandler.postDelayed(new b(this.gdx, gVar, i, i2, i3, 3, bmd()), 200L);
            } else if (this.gdz == 1) {
                this.gdz++;
                this.mHandler.postDelayed(new b(this.gdx, gVar, i, i2, i3, 4, bmd()), 200L);
            } else {
                return false;
            }
            return true;
        }
        this.gdy++;
        if (this.gdy <= 2) {
            if (!a(gVar, i, i2, i3, uri, bmd())) {
                if (i == -200) {
                    this.mHandler.postDelayed(new b(this.gdx, gVar, i, i2, i3, this.gdy % 2 == 1 ? 7 : 17, bmd()), 200L);
                    this.gdy = 2;
                } else {
                    this.mHandler.postDelayed(new b(this.gdx, gVar, i, i2, i3, this.gdy % 2 == 1 ? 8 : 18, bmd()), 200L);
                    this.gdy = 4;
                    return false;
                }
            }
            return true;
        } else if (this.gdy <= 4) {
            if (i == -200) {
                this.mHandler.postDelayed(new b(this.gdx, gVar, i, i2, i3, this.gdy % 2 == 1 ? 1 : 11, bmd()), 200L);
                return true;
            }
            return false;
        } else if (this.gdy <= 6 && i == -200) {
            this.mHandler.postDelayed(new b(this.gdx, gVar, i, i2, i3, this.gdy % 2 == 1 ? 2 : 12, bmd()), 200L);
            return true;
        } else {
            return false;
        }
    }

    private int bmd() {
        return (this.gdz * 100) + this.gdy;
    }

    private boolean a(g gVar, int i, int i2, int i3, Uri uri, int i4) {
        if (!bme() || i == -100 || uri == null || TextUtils.isEmpty(uri.getHost()) || uri.toString().contains("127.0.0.1") || !uri.toString().contains(HttpHost.DEFAULT_SCHEME_NAME)) {
            return false;
        }
        com.baidu.tieba.play.a.b.bmc().a(new C0216a(this.mHandler, this.gdx, i, uri, gVar, i2, i3, i4));
        return com.baidu.tieba.play.a.b.bmc().sn(uri.getHost());
    }

    private boolean bme() {
        return (com.baidu.adp.lib.b.d.hv().aw("android_video_http_dns_open") == 0 || !j.jD() || CustomPlayerSwitchStatic.bkP() == 0) ? false : true;
    }

    /* JADX INFO: Access modifiers changed from: private */
    /* renamed from: com.baidu.tieba.play.b.a$a  reason: collision with other inner class name */
    /* loaded from: classes.dex */
    public static class C0216a implements b.InterfaceC0215b {
        private int aoz;
        private g gdA;
        private int gdB;
        private int gdC;
        private c gdx;
        private Handler mHandler;
        private Uri mUri;
        private int what;

        public C0216a(Handler handler, c cVar, int i, Uri uri, g gVar, int i2, int i3, int i4) {
            this.mHandler = handler;
            this.gdx = cVar;
            this.mUri = uri;
            this.gdA = gVar;
            this.gdB = i;
            this.what = i2;
            this.gdC = i3;
            this.aoz = i4;
        }

        @Override // com.baidu.tieba.play.a.b.InterfaceC0215b
        public void bV(String str, String str2) {
            try {
                if (TextUtils.isEmpty(str) || TextUtils.isEmpty(str2) || this.mUri == null || !str2.equals(this.mUri.getHost())) {
                    if (this.mHandler != null) {
                        this.mHandler.postDelayed(new b(this.gdx, this.gdA, this.gdB, this.what, this.gdC, this.aoz % 2 == 1 ? 5 : 15, this.aoz), 200L);
                    }
                } else if (this.mHandler != null) {
                    this.mHandler.postDelayed(new b(this.gdx, this.gdA, this.gdB, this.what, this.gdC, str, this.aoz % 2 == 1 ? 0 : 10, this.aoz), 200L);
                }
            } catch (Throwable th) {
                th.printStackTrace();
                if (this.mHandler != null) {
                    this.mHandler.postDelayed(new b(this.gdx, this.gdA, this.gdB, this.what, this.gdC, this.aoz % 2 == 1 ? 6 : 16, this.aoz), 200L);
                }
            }
        }
    }

    public boolean bmf() {
        boolean z = this.gdy > 0 || this.gdz > 0;
        this.gdy = 0;
        this.gdz = 0;
        return z;
    }

    /* JADX INFO: Access modifiers changed from: private */
    /* loaded from: classes.dex */
    public static class b implements Runnable {
        private final int aoz;
        private final g gdA;
        private final int gdB;
        private final int gdC;
        private c gdx;
        private final String ip;
        private final int type;
        private final int what;

        public b(c cVar, g gVar, int i, int i2, int i3, int i4, int i5) {
            this.gdx = cVar;
            this.gdA = gVar;
            this.gdB = i;
            this.what = i2;
            this.gdC = i3;
            this.type = i4;
            this.aoz = i5;
            this.ip = "";
        }

        public b(c cVar, g gVar, int i, int i2, int i3, String str, int i4, int i5) {
            this.gdx = cVar;
            this.gdA = gVar;
            this.gdB = i;
            this.what = i2;
            this.gdC = i3;
            this.ip = str;
            this.type = i4;
            this.aoz = i5;
        }

        @Override // java.lang.Runnable
        public void run() {
            if (this.gdx != null) {
                if (this.type == 1 || this.type == 5 || this.type == 3 || this.type == 6 || this.type == 7 || this.type == 11 || this.type == 15 || this.type == 16 || this.type == 17) {
                    this.gdx.a(this.gdA, this.gdB, this.what, this.gdC, this.aoz, this.type);
                } else if (this.type == 2 || this.type == 4 || this.type == 8 || this.type == 12 || this.type == 18) {
                    this.gdx.b(this.gdA, this.gdB, this.what, this.gdC, this.aoz, this.type);
                } else if (this.type == 0 || this.type == 10) {
                    this.gdx.a(this.gdA, this.gdB, this.what, this.gdC, this.ip, this.aoz, this.type);
                }
            }
        }
    }

    public void clear() {
        if (this.mHandler != null) {
            this.mHandler.removeCallbacksAndMessages(null);
        }
    }

    public static void sp(String str) {
        if (!StringUtils.isNull(str)) {
            new BdAsyncTask<String, Void, Void>() { // from class: com.baidu.tieba.play.b.a.1
                /* JADX DEBUG: Method merged with bridge method */
                /* JADX INFO: Access modifiers changed from: protected */
                @Override // com.baidu.adp.lib.asyncTask.BdAsyncTask
                public Void doInBackground(String... strArr) {
                    if (strArr != null && strArr.length == 1) {
                        l.r(new File(strArr[0]).getParentFile());
                    }
                    return null;
                }
            }.execute(str);
        }
    }
}
