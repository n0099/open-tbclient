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
    private c ghy;
    private int ghz = 0;
    private int ghA = 0;
    private Handler mHandler = new Handler();

    public a(c cVar) {
        this.ghy = cVar;
    }

    public boolean a(g gVar, int i, int i2, int i3, Uri uri) {
        if (this.ghy == null) {
            return false;
        }
        if (i == -300) {
            if (this.ghA == 0) {
                this.ghA++;
                this.mHandler.postDelayed(new b(this.ghy, gVar, i, i2, i3, 3, bmH()), 200L);
            } else if (this.ghA == 1) {
                this.ghA++;
                this.mHandler.postDelayed(new b(this.ghy, gVar, i, i2, i3, 4, bmH()), 200L);
            } else {
                return false;
            }
            return true;
        }
        this.ghz++;
        if (this.ghz <= 2) {
            if (!a(gVar, i, i2, i3, uri, bmH())) {
                if (i == -200) {
                    this.mHandler.postDelayed(new b(this.ghy, gVar, i, i2, i3, this.ghz % 2 == 1 ? 7 : 17, bmH()), 200L);
                    this.ghz = 2;
                } else {
                    this.mHandler.postDelayed(new b(this.ghy, gVar, i, i2, i3, this.ghz % 2 == 1 ? 8 : 18, bmH()), 200L);
                    this.ghz = 4;
                    return false;
                }
            }
            return true;
        } else if (this.ghz <= 4) {
            if (i == -200) {
                this.mHandler.postDelayed(new b(this.ghy, gVar, i, i2, i3, this.ghz % 2 == 1 ? 1 : 11, bmH()), 200L);
                return true;
            }
            return false;
        } else if (this.ghz <= 6 && i == -200) {
            this.mHandler.postDelayed(new b(this.ghy, gVar, i, i2, i3, this.ghz % 2 == 1 ? 2 : 12, bmH()), 200L);
            return true;
        } else {
            return false;
        }
    }

    private int bmH() {
        return (this.ghA * 100) + this.ghz;
    }

    private boolean a(g gVar, int i, int i2, int i3, Uri uri, int i4) {
        if (!bmI() || i == -100 || uri == null || TextUtils.isEmpty(uri.getHost()) || uri.toString().contains("127.0.0.1") || !uri.toString().contains(HttpHost.DEFAULT_SCHEME_NAME)) {
            return false;
        }
        com.baidu.tieba.play.a.b.bmG().a(new C0218a(this.mHandler, this.ghy, i, uri, gVar, i2, i3, i4));
        return com.baidu.tieba.play.a.b.bmG().sm(uri.getHost());
    }

    private boolean bmI() {
        return (com.baidu.adp.lib.b.d.hv().aw("android_video_http_dns_open") == 0 || !j.jD() || CustomPlayerSwitchStatic.blt() == 0) ? false : true;
    }

    /* JADX INFO: Access modifiers changed from: private */
    /* renamed from: com.baidu.tieba.play.b.a$a  reason: collision with other inner class name */
    /* loaded from: classes.dex */
    public static class C0218a implements b.InterfaceC0217b {
        private int aoY;
        private g ghB;
        private int ghC;
        private int ghD;
        private c ghy;
        private Handler mHandler;
        private Uri mUri;
        private int what;

        public C0218a(Handler handler, c cVar, int i, Uri uri, g gVar, int i2, int i3, int i4) {
            this.mHandler = handler;
            this.ghy = cVar;
            this.mUri = uri;
            this.ghB = gVar;
            this.ghC = i;
            this.what = i2;
            this.ghD = i3;
            this.aoY = i4;
        }

        @Override // com.baidu.tieba.play.a.b.InterfaceC0217b
        public void bZ(String str, String str2) {
            try {
                if (TextUtils.isEmpty(str) || TextUtils.isEmpty(str2) || this.mUri == null || !str2.equals(this.mUri.getHost())) {
                    if (this.mHandler != null) {
                        this.mHandler.postDelayed(new b(this.ghy, this.ghB, this.ghC, this.what, this.ghD, this.aoY % 2 == 1 ? 5 : 15, this.aoY), 200L);
                    }
                } else if (this.mHandler != null) {
                    this.mHandler.postDelayed(new b(this.ghy, this.ghB, this.ghC, this.what, this.ghD, str, this.aoY % 2 == 1 ? 0 : 10, this.aoY), 200L);
                }
            } catch (Throwable th) {
                th.printStackTrace();
                if (this.mHandler != null) {
                    this.mHandler.postDelayed(new b(this.ghy, this.ghB, this.ghC, this.what, this.ghD, this.aoY % 2 == 1 ? 6 : 16, this.aoY), 200L);
                }
            }
        }
    }

    public boolean bmJ() {
        boolean z = this.ghz > 0 || this.ghA > 0;
        this.ghz = 0;
        this.ghA = 0;
        return z;
    }

    /* JADX INFO: Access modifiers changed from: private */
    /* loaded from: classes.dex */
    public static class b implements Runnable {
        private final int aoY;
        private final g ghB;
        private final int ghC;
        private final int ghD;
        private c ghy;
        private final String ip;
        private final int type;
        private final int what;

        public b(c cVar, g gVar, int i, int i2, int i3, int i4, int i5) {
            this.ghy = cVar;
            this.ghB = gVar;
            this.ghC = i;
            this.what = i2;
            this.ghD = i3;
            this.type = i4;
            this.aoY = i5;
            this.ip = "";
        }

        public b(c cVar, g gVar, int i, int i2, int i3, String str, int i4, int i5) {
            this.ghy = cVar;
            this.ghB = gVar;
            this.ghC = i;
            this.what = i2;
            this.ghD = i3;
            this.ip = str;
            this.type = i4;
            this.aoY = i5;
        }

        @Override // java.lang.Runnable
        public void run() {
            if (this.ghy != null) {
                if (this.type == 1 || this.type == 5 || this.type == 3 || this.type == 6 || this.type == 7 || this.type == 11 || this.type == 15 || this.type == 16 || this.type == 17) {
                    this.ghy.a(this.ghB, this.ghC, this.what, this.ghD, this.aoY, this.type);
                } else if (this.type == 2 || this.type == 4 || this.type == 8 || this.type == 12 || this.type == 18) {
                    this.ghy.b(this.ghB, this.ghC, this.what, this.ghD, this.aoY, this.type);
                } else if (this.type == 0 || this.type == 10) {
                    this.ghy.a(this.ghB, this.ghC, this.what, this.ghD, this.ip, this.aoY, this.type);
                }
            }
        }
    }

    public void clear() {
        if (this.mHandler != null) {
            this.mHandler.removeCallbacksAndMessages(null);
        }
    }

    public static void so(String str) {
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
