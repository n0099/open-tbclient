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
    private c gwS;
    private int gwT = 0;
    private int gwU = 0;
    private Handler mHandler = new Handler();

    public a(c cVar) {
        this.gwS = cVar;
    }

    public boolean a(g gVar, int i, int i2, int i3, Uri uri) {
        if (this.gwS == null) {
            return false;
        }
        if (i == -300) {
            if (this.gwU == 0) {
                this.gwU++;
                this.mHandler.postDelayed(new b(this.gwS, gVar, i, i2, i3, 3, bqS()), 200L);
            } else if (this.gwU == 1) {
                this.gwU++;
                this.mHandler.postDelayed(new b(this.gwS, gVar, i, i2, i3, 4, bqS()), 200L);
            } else {
                return false;
            }
            return true;
        }
        this.gwT++;
        if (this.gwT <= 2) {
            if (!a(gVar, i, i2, i3, uri, bqS())) {
                if (i == -200) {
                    this.mHandler.postDelayed(new b(this.gwS, gVar, i, i2, i3, this.gwT % 2 == 1 ? 7 : 17, bqS()), 200L);
                    this.gwT = 2;
                } else {
                    this.mHandler.postDelayed(new b(this.gwS, gVar, i, i2, i3, this.gwT % 2 == 1 ? 8 : 18, bqS()), 200L);
                    this.gwT = 4;
                    return false;
                }
            }
            return true;
        } else if (this.gwT <= 4) {
            if (i == -200) {
                this.mHandler.postDelayed(new b(this.gwS, gVar, i, i2, i3, this.gwT % 2 == 1 ? 1 : 11, bqS()), 200L);
                return true;
            }
            return false;
        } else if (this.gwT <= 6 && i == -200) {
            this.mHandler.postDelayed(new b(this.gwS, gVar, i, i2, i3, this.gwT % 2 == 1 ? 2 : 12, bqS()), 200L);
            return true;
        } else {
            return false;
        }
    }

    private int bqS() {
        return (this.gwU * 100) + this.gwT;
    }

    private boolean a(g gVar, int i, int i2, int i3, Uri uri, int i4) {
        if (!bqT() || i == -100 || uri == null || TextUtils.isEmpty(uri.getHost()) || uri.toString().contains(NetworkDef.IP_LOOPBACK) || !uri.toString().contains(HttpHost.DEFAULT_SCHEME_NAME)) {
            return false;
        }
        com.baidu.tieba.play.a.b.bqR().a(new C0257a(this.mHandler, this.gwS, i, uri, gVar, i2, i3, i4));
        return com.baidu.tieba.play.a.b.bqR().tr(uri.getHost());
    }

    private boolean bqT() {
        return (com.baidu.adp.lib.b.d.iR().aO("android_video_http_dns_open") == 0 || !j.kX() || CustomPlayerSwitchStatic.bpw() == 0) ? false : true;
    }

    /* JADX INFO: Access modifiers changed from: private */
    /* renamed from: com.baidu.tieba.play.b.a$a  reason: collision with other inner class name */
    /* loaded from: classes.dex */
    public static class C0257a implements b.InterfaceC0256b {
        private c gwS;
        private g gwV;
        private int gwW;
        private int gwX;
        private Handler mHandler;
        private Uri mUri;
        private int times;
        private int what;

        public C0257a(Handler handler, c cVar, int i, Uri uri, g gVar, int i2, int i3, int i4) {
            this.mHandler = handler;
            this.gwS = cVar;
            this.mUri = uri;
            this.gwV = gVar;
            this.gwW = i;
            this.what = i2;
            this.gwX = i3;
            this.times = i4;
        }

        @Override // com.baidu.tieba.play.a.b.InterfaceC0256b
        public void cp(String str, String str2) {
            try {
                if (TextUtils.isEmpty(str) || TextUtils.isEmpty(str2) || this.mUri == null || !str2.equals(this.mUri.getHost())) {
                    if (this.mHandler != null) {
                        this.mHandler.postDelayed(new b(this.gwS, this.gwV, this.gwW, this.what, this.gwX, this.times % 2 == 1 ? 5 : 15, this.times), 200L);
                    }
                } else if (this.mHandler != null) {
                    this.mHandler.postDelayed(new b(this.gwS, this.gwV, this.gwW, this.what, this.gwX, str, this.times % 2 == 1 ? 0 : 10, this.times), 200L);
                }
            } catch (Throwable th) {
                th.printStackTrace();
                if (this.mHandler != null) {
                    this.mHandler.postDelayed(new b(this.gwS, this.gwV, this.gwW, this.what, this.gwX, this.times % 2 == 1 ? 6 : 16, this.times), 200L);
                }
            }
        }
    }

    public boolean bqU() {
        boolean z = this.gwT > 0 || this.gwU > 0;
        this.gwT = 0;
        this.gwU = 0;
        return z;
    }

    /* JADX INFO: Access modifiers changed from: private */
    /* loaded from: classes.dex */
    public static class b implements Runnable {
        private c gwS;
        private final g gwV;
        private final int gwW;
        private final int gwX;
        private final String ip;
        private final int times;
        private final int type;
        private final int what;

        public b(c cVar, g gVar, int i, int i2, int i3, int i4, int i5) {
            this.gwS = cVar;
            this.gwV = gVar;
            this.gwW = i;
            this.what = i2;
            this.gwX = i3;
            this.type = i4;
            this.times = i5;
            this.ip = "";
        }

        public b(c cVar, g gVar, int i, int i2, int i3, String str, int i4, int i5) {
            this.gwS = cVar;
            this.gwV = gVar;
            this.gwW = i;
            this.what = i2;
            this.gwX = i3;
            this.ip = str;
            this.type = i4;
            this.times = i5;
        }

        @Override // java.lang.Runnable
        public void run() {
            if (this.gwS != null) {
                if (this.type == 1 || this.type == 5 || this.type == 3 || this.type == 6 || this.type == 7 || this.type == 11 || this.type == 15 || this.type == 16 || this.type == 17) {
                    this.gwS.a(this.gwV, this.gwW, this.what, this.gwX, this.times, this.type);
                } else if (this.type == 2 || this.type == 4 || this.type == 8 || this.type == 12 || this.type == 18) {
                    this.gwS.b(this.gwV, this.gwW, this.what, this.gwX, this.times, this.type);
                } else if (this.type == 0 || this.type == 10) {
                    this.gwS.a(this.gwV, this.gwW, this.what, this.gwX, this.ip, this.times, this.type);
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
