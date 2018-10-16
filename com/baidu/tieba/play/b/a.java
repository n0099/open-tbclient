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
    private c gwR;
    private int gwS = 0;
    private int gwT = 0;
    private Handler mHandler = new Handler();

    public a(c cVar) {
        this.gwR = cVar;
    }

    public boolean a(g gVar, int i, int i2, int i3, Uri uri) {
        if (this.gwR == null) {
            return false;
        }
        if (i == -300) {
            if (this.gwT == 0) {
                this.gwT++;
                this.mHandler.postDelayed(new b(this.gwR, gVar, i, i2, i3, 3, bqS()), 200L);
            } else if (this.gwT == 1) {
                this.gwT++;
                this.mHandler.postDelayed(new b(this.gwR, gVar, i, i2, i3, 4, bqS()), 200L);
            } else {
                return false;
            }
            return true;
        }
        this.gwS++;
        if (this.gwS <= 2) {
            if (!a(gVar, i, i2, i3, uri, bqS())) {
                if (i == -200) {
                    this.mHandler.postDelayed(new b(this.gwR, gVar, i, i2, i3, this.gwS % 2 == 1 ? 7 : 17, bqS()), 200L);
                    this.gwS = 2;
                } else {
                    this.mHandler.postDelayed(new b(this.gwR, gVar, i, i2, i3, this.gwS % 2 == 1 ? 8 : 18, bqS()), 200L);
                    this.gwS = 4;
                    return false;
                }
            }
            return true;
        } else if (this.gwS <= 4) {
            if (i == -200) {
                this.mHandler.postDelayed(new b(this.gwR, gVar, i, i2, i3, this.gwS % 2 == 1 ? 1 : 11, bqS()), 200L);
                return true;
            }
            return false;
        } else if (this.gwS <= 6 && i == -200) {
            this.mHandler.postDelayed(new b(this.gwR, gVar, i, i2, i3, this.gwS % 2 == 1 ? 2 : 12, bqS()), 200L);
            return true;
        } else {
            return false;
        }
    }

    private int bqS() {
        return (this.gwT * 100) + this.gwS;
    }

    private boolean a(g gVar, int i, int i2, int i3, Uri uri, int i4) {
        if (!bqT() || i == -100 || uri == null || TextUtils.isEmpty(uri.getHost()) || uri.toString().contains(NetworkDef.IP_LOOPBACK) || !uri.toString().contains(HttpHost.DEFAULT_SCHEME_NAME)) {
            return false;
        }
        com.baidu.tieba.play.a.b.bqR().a(new C0257a(this.mHandler, this.gwR, i, uri, gVar, i2, i3, i4));
        return com.baidu.tieba.play.a.b.bqR().tr(uri.getHost());
    }

    private boolean bqT() {
        return (com.baidu.adp.lib.b.d.iR().aO("android_video_http_dns_open") == 0 || !j.kX() || CustomPlayerSwitchStatic.bpw() == 0) ? false : true;
    }

    /* JADX INFO: Access modifiers changed from: private */
    /* renamed from: com.baidu.tieba.play.b.a$a  reason: collision with other inner class name */
    /* loaded from: classes.dex */
    public static class C0257a implements b.InterfaceC0256b {
        private c gwR;
        private g gwU;
        private int gwV;
        private int gwW;
        private Handler mHandler;
        private Uri mUri;
        private int times;
        private int what;

        public C0257a(Handler handler, c cVar, int i, Uri uri, g gVar, int i2, int i3, int i4) {
            this.mHandler = handler;
            this.gwR = cVar;
            this.mUri = uri;
            this.gwU = gVar;
            this.gwV = i;
            this.what = i2;
            this.gwW = i3;
            this.times = i4;
        }

        @Override // com.baidu.tieba.play.a.b.InterfaceC0256b
        public void cp(String str, String str2) {
            try {
                if (TextUtils.isEmpty(str) || TextUtils.isEmpty(str2) || this.mUri == null || !str2.equals(this.mUri.getHost())) {
                    if (this.mHandler != null) {
                        this.mHandler.postDelayed(new b(this.gwR, this.gwU, this.gwV, this.what, this.gwW, this.times % 2 == 1 ? 5 : 15, this.times), 200L);
                    }
                } else if (this.mHandler != null) {
                    this.mHandler.postDelayed(new b(this.gwR, this.gwU, this.gwV, this.what, this.gwW, str, this.times % 2 == 1 ? 0 : 10, this.times), 200L);
                }
            } catch (Throwable th) {
                th.printStackTrace();
                if (this.mHandler != null) {
                    this.mHandler.postDelayed(new b(this.gwR, this.gwU, this.gwV, this.what, this.gwW, this.times % 2 == 1 ? 6 : 16, this.times), 200L);
                }
            }
        }
    }

    public boolean bqU() {
        boolean z = this.gwS > 0 || this.gwT > 0;
        this.gwS = 0;
        this.gwT = 0;
        return z;
    }

    /* JADX INFO: Access modifiers changed from: private */
    /* loaded from: classes.dex */
    public static class b implements Runnable {
        private c gwR;
        private final g gwU;
        private final int gwV;
        private final int gwW;
        private final String ip;
        private final int times;
        private final int type;
        private final int what;

        public b(c cVar, g gVar, int i, int i2, int i3, int i4, int i5) {
            this.gwR = cVar;
            this.gwU = gVar;
            this.gwV = i;
            this.what = i2;
            this.gwW = i3;
            this.type = i4;
            this.times = i5;
            this.ip = "";
        }

        public b(c cVar, g gVar, int i, int i2, int i3, String str, int i4, int i5) {
            this.gwR = cVar;
            this.gwU = gVar;
            this.gwV = i;
            this.what = i2;
            this.gwW = i3;
            this.ip = str;
            this.type = i4;
            this.times = i5;
        }

        @Override // java.lang.Runnable
        public void run() {
            if (this.gwR != null) {
                if (this.type == 1 || this.type == 5 || this.type == 3 || this.type == 6 || this.type == 7 || this.type == 11 || this.type == 15 || this.type == 16 || this.type == 17) {
                    this.gwR.a(this.gwU, this.gwV, this.what, this.gwW, this.times, this.type);
                } else if (this.type == 2 || this.type == 4 || this.type == 8 || this.type == 12 || this.type == 18) {
                    this.gwR.b(this.gwU, this.gwV, this.what, this.gwW, this.times, this.type);
                } else if (this.type == 0 || this.type == 10) {
                    this.gwR.a(this.gwU, this.gwV, this.what, this.gwW, this.ip, this.times, this.type);
                }
            }
        }
    }

    public void clear() {
        if (this.mHandler != null) {
            this.mHandler.removeCallbacksAndMessages(null);
        }
    }

    public static void tt(String str) {
        if (!StringUtils.isNull(str)) {
            new BdAsyncTask<String, Void, Void>() { // from class: com.baidu.tieba.play.b.a.1
                /* JADX DEBUG: Method merged with bridge method */
                /* JADX INFO: Access modifiers changed from: protected */
                @Override // com.baidu.adp.lib.asyncTask.BdAsyncTask
                public Void doInBackground(String... strArr) {
                    if (strArr != null && strArr.length == 1) {
                        l.x(new File(strArr[0]).getParentFile());
                    }
                    return null;
                }
            }.execute(str);
        }
    }
}
