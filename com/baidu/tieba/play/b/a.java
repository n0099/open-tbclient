package com.baidu.tieba.play.b;

import android.net.Uri;
import android.os.Handler;
import android.text.TextUtils;
import com.baidu.adp.lib.asyncTask.BdAsyncTask;
import com.baidu.adp.lib.util.StringUtils;
import com.baidu.adp.lib.util.j;
import com.baidu.searchbox.ng.ai.apps.network.NetworkDef;
import com.baidu.tbadk.core.util.l;
import com.baidu.tieba.play.CustomPlayerSwitchStatic;
import com.baidu.tieba.play.a.b;
import com.baidu.tieba.play.g;
import java.io.File;
import org.apache.http.HttpHost;
/* loaded from: classes.dex */
public class a {
    private c gJf;
    private int gJg = 0;
    private int gJh = 0;
    private Handler mHandler = new Handler();

    public a(c cVar) {
        this.gJf = cVar;
    }

    public boolean a(g gVar, int i, int i2, int i3, Uri uri) {
        if (this.gJf == null) {
            return false;
        }
        if (i == -300) {
            if (this.gJh == 0) {
                this.gJh++;
                this.mHandler.postDelayed(new b(this.gJf, gVar, i, i2, i3, 3, btB()), 200L);
            } else if (this.gJh == 1) {
                this.gJh++;
                this.mHandler.postDelayed(new b(this.gJf, gVar, i, i2, i3, 4, btB()), 200L);
            } else {
                return false;
            }
            return true;
        }
        this.gJg++;
        if (this.gJg <= 2) {
            if (!a(gVar, i, i2, i3, uri, btB())) {
                if (i == -200) {
                    this.mHandler.postDelayed(new b(this.gJf, gVar, i, i2, i3, this.gJg % 2 == 1 ? 7 : 17, btB()), 200L);
                    this.gJg = 2;
                } else {
                    this.mHandler.postDelayed(new b(this.gJf, gVar, i, i2, i3, this.gJg % 2 == 1 ? 8 : 18, btB()), 200L);
                    this.gJg = 4;
                    return false;
                }
            }
            return true;
        } else if (this.gJg <= 4) {
            if (i == -200) {
                this.mHandler.postDelayed(new b(this.gJf, gVar, i, i2, i3, this.gJg % 2 == 1 ? 1 : 11, btB()), 200L);
                return true;
            }
            return false;
        } else if (this.gJg <= 6 && i == -200) {
            this.mHandler.postDelayed(new b(this.gJf, gVar, i, i2, i3, this.gJg % 2 == 1 ? 2 : 12, btB()), 200L);
            return true;
        } else {
            return false;
        }
    }

    private int btB() {
        return (this.gJh * 100) + this.gJg;
    }

    private boolean a(g gVar, int i, int i2, int i3, Uri uri, int i4) {
        if (!btC() || i == -100 || uri == null || TextUtils.isEmpty(uri.getHost()) || uri.toString().contains(NetworkDef.IP_LOOPBACK) || !uri.toString().contains(HttpHost.DEFAULT_SCHEME_NAME)) {
            return false;
        }
        com.baidu.tieba.play.a.b.btA().a(new C0296a(this.mHandler, this.gJf, i, uri, gVar, i2, i3, i4));
        return com.baidu.tieba.play.a.b.btA().ur(uri.getHost());
    }

    private boolean btC() {
        return (com.baidu.adp.lib.b.d.iQ().aO("android_video_http_dns_open") == 0 || !j.kV() || CustomPlayerSwitchStatic.bse() == 0) ? false : true;
    }

    /* JADX INFO: Access modifiers changed from: private */
    /* renamed from: com.baidu.tieba.play.b.a$a  reason: collision with other inner class name */
    /* loaded from: classes.dex */
    public static class C0296a implements b.InterfaceC0295b {
        private c gJf;
        private g gJi;
        private int gJj;
        private int gJk;
        private Handler mHandler;
        private Uri mUri;
        private int times;
        private int what;

        public C0296a(Handler handler, c cVar, int i, Uri uri, g gVar, int i2, int i3, int i4) {
            this.mHandler = handler;
            this.gJf = cVar;
            this.mUri = uri;
            this.gJi = gVar;
            this.gJj = i;
            this.what = i2;
            this.gJk = i3;
            this.times = i4;
        }

        @Override // com.baidu.tieba.play.a.b.InterfaceC0295b
        public void cv(String str, String str2) {
            try {
                if (TextUtils.isEmpty(str) || TextUtils.isEmpty(str2) || this.mUri == null || !str2.equals(this.mUri.getHost())) {
                    if (this.mHandler != null) {
                        this.mHandler.postDelayed(new b(this.gJf, this.gJi, this.gJj, this.what, this.gJk, this.times % 2 == 1 ? 5 : 15, this.times), 200L);
                    }
                } else if (this.mHandler != null) {
                    this.mHandler.postDelayed(new b(this.gJf, this.gJi, this.gJj, this.what, this.gJk, str, this.times % 2 == 1 ? 0 : 10, this.times), 200L);
                }
            } catch (Throwable th) {
                th.printStackTrace();
                if (this.mHandler != null) {
                    this.mHandler.postDelayed(new b(this.gJf, this.gJi, this.gJj, this.what, this.gJk, this.times % 2 == 1 ? 6 : 16, this.times), 200L);
                }
            }
        }
    }

    public boolean btD() {
        boolean z = this.gJg > 0 || this.gJh > 0;
        this.gJg = 0;
        this.gJh = 0;
        return z;
    }

    /* JADX INFO: Access modifiers changed from: private */
    /* loaded from: classes.dex */
    public static class b implements Runnable {
        private c gJf;
        private final g gJi;
        private final int gJj;
        private final int gJk;
        private final String ip;
        private final int times;
        private final int type;
        private final int what;

        public b(c cVar, g gVar, int i, int i2, int i3, int i4, int i5) {
            this.gJf = cVar;
            this.gJi = gVar;
            this.gJj = i;
            this.what = i2;
            this.gJk = i3;
            this.type = i4;
            this.times = i5;
            this.ip = "";
        }

        public b(c cVar, g gVar, int i, int i2, int i3, String str, int i4, int i5) {
            this.gJf = cVar;
            this.gJi = gVar;
            this.gJj = i;
            this.what = i2;
            this.gJk = i3;
            this.ip = str;
            this.type = i4;
            this.times = i5;
        }

        @Override // java.lang.Runnable
        public void run() {
            if (this.gJf != null) {
                if (this.type == 1 || this.type == 5 || this.type == 3 || this.type == 6 || this.type == 7 || this.type == 11 || this.type == 15 || this.type == 16 || this.type == 17) {
                    this.gJf.a(this.gJi, this.gJj, this.what, this.gJk, this.times, this.type);
                } else if (this.type == 2 || this.type == 4 || this.type == 8 || this.type == 12 || this.type == 18) {
                    this.gJf.b(this.gJi, this.gJj, this.what, this.gJk, this.times, this.type);
                } else if (this.type == 0 || this.type == 10) {
                    this.gJf.a(this.gJi, this.gJj, this.what, this.gJk, this.ip, this.times, this.type);
                }
            }
        }
    }

    public void clear() {
        if (this.mHandler != null) {
            this.mHandler.removeCallbacksAndMessages(null);
        }
    }

    public static void ut(String str) {
        if (!StringUtils.isNull(str)) {
            new BdAsyncTask<String, Void, Void>() { // from class: com.baidu.tieba.play.b.a.1
                /* JADX DEBUG: Method merged with bridge method */
                /* JADX INFO: Access modifiers changed from: protected */
                @Override // com.baidu.adp.lib.asyncTask.BdAsyncTask
                public Void doInBackground(String... strArr) {
                    if (strArr != null && strArr.length == 1) {
                        l.y(new File(strArr[0]).getParentFile());
                    }
                    return null;
                }
            }.execute(str);
        }
    }
}
