package com.baidu.tieba.play.b;

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
    private c gwr;
    private int gws = 0;
    private int gwt = 0;
    private Handler mHandler = new Handler();

    public a(c cVar) {
        this.gwr = cVar;
    }

    public boolean a(g gVar, int i, int i2, int i3, Uri uri) {
        if (this.gwr == null) {
            return false;
        }
        if (i == -300) {
            if (this.gwt == 0) {
                this.gwt++;
                this.mHandler.postDelayed(new b(this.gwr, gVar, i, i2, i3, 3, blZ()), 200L);
            } else if (this.gwt == 1) {
                this.gwt++;
                this.mHandler.postDelayed(new b(this.gwr, gVar, i, i2, i3, 4, blZ()), 200L);
            } else {
                return false;
            }
            return true;
        }
        this.gws++;
        if (this.gws <= 2) {
            if (!a(gVar, i, i2, i3, uri, blZ())) {
                if (i == -200) {
                    this.mHandler.postDelayed(new b(this.gwr, gVar, i, i2, i3, this.gws % 2 == 1 ? 7 : 17, blZ()), 200L);
                    this.gws = 2;
                } else {
                    this.mHandler.postDelayed(new b(this.gwr, gVar, i, i2, i3, this.gws % 2 == 1 ? 8 : 18, blZ()), 200L);
                    this.gws = 4;
                    return false;
                }
            }
            return true;
        } else if (this.gws <= 4) {
            if (i == -200) {
                this.mHandler.postDelayed(new b(this.gwr, gVar, i, i2, i3, this.gws % 2 == 1 ? 1 : 11, blZ()), 200L);
                return true;
            }
            return false;
        } else if (this.gws <= 6 && i == -200) {
            this.mHandler.postDelayed(new b(this.gwr, gVar, i, i2, i3, this.gws % 2 == 1 ? 2 : 12, blZ()), 200L);
            return true;
        } else {
            return false;
        }
    }

    private int blZ() {
        return (this.gwt * 100) + this.gws;
    }

    private boolean a(g gVar, int i, int i2, int i3, Uri uri, int i4) {
        if (!bma() || i == -100 || uri == null || TextUtils.isEmpty(uri.getHost()) || uri.toString().contains("127.0.0.1") || !uri.toString().contains(HttpHost.DEFAULT_SCHEME_NAME)) {
            return false;
        }
        com.baidu.tieba.play.a.b.blY().a(new C0217a(this.mHandler, this.gwr, i, uri, gVar, i2, i3, i4));
        return com.baidu.tieba.play.a.b.blY().rn(uri.getHost());
    }

    private boolean bma() {
        return (com.baidu.adp.lib.b.d.mA().an("android_video_http_dns_open") == 0 || !j.oJ() || CustomPlayerSwitchStatic.bkN() == 0) ? false : true;
    }

    /* JADX INFO: Access modifiers changed from: private */
    /* renamed from: com.baidu.tieba.play.b.a$a  reason: collision with other inner class name */
    /* loaded from: classes.dex */
    public static class C0217a implements b.InterfaceC0216b {
        private int aVj;
        private c gwr;
        private g gwu;
        private int gwv;
        private int gww;
        private Handler mHandler;
        private Uri mUri;
        private int what;

        public C0217a(Handler handler, c cVar, int i, Uri uri, g gVar, int i2, int i3, int i4) {
            this.mHandler = handler;
            this.gwr = cVar;
            this.mUri = uri;
            this.gwu = gVar;
            this.gwv = i;
            this.what = i2;
            this.gww = i3;
            this.aVj = i4;
        }

        @Override // com.baidu.tieba.play.a.b.InterfaceC0216b
        public void bO(String str, String str2) {
            try {
                if (TextUtils.isEmpty(str) || TextUtils.isEmpty(str2) || this.mUri == null || !str2.equals(this.mUri.getHost())) {
                    if (this.mHandler != null) {
                        this.mHandler.postDelayed(new b(this.gwr, this.gwu, this.gwv, this.what, this.gww, this.aVj % 2 == 1 ? 5 : 15, this.aVj), 200L);
                    }
                } else if (this.mHandler != null) {
                    this.mHandler.postDelayed(new b(this.gwr, this.gwu, this.gwv, this.what, this.gww, str, this.aVj % 2 == 1 ? 0 : 10, this.aVj), 200L);
                }
            } catch (Throwable th) {
                th.printStackTrace();
                if (this.mHandler != null) {
                    this.mHandler.postDelayed(new b(this.gwr, this.gwu, this.gwv, this.what, this.gww, this.aVj % 2 == 1 ? 6 : 16, this.aVj), 200L);
                }
            }
        }
    }

    public boolean bmb() {
        boolean z = this.gws > 0 || this.gwt > 0;
        this.gws = 0;
        this.gwt = 0;
        return z;
    }

    /* JADX INFO: Access modifiers changed from: private */
    /* loaded from: classes.dex */
    public static class b implements Runnable {
        private final int aVj;
        private c gwr;
        private final g gwu;
        private final int gwv;
        private final int gww;
        private final String ip;
        private final int type;
        private final int what;

        public b(c cVar, g gVar, int i, int i2, int i3, int i4, int i5) {
            this.gwr = cVar;
            this.gwu = gVar;
            this.gwv = i;
            this.what = i2;
            this.gww = i3;
            this.type = i4;
            this.aVj = i5;
            this.ip = "";
        }

        public b(c cVar, g gVar, int i, int i2, int i3, String str, int i4, int i5) {
            this.gwr = cVar;
            this.gwu = gVar;
            this.gwv = i;
            this.what = i2;
            this.gww = i3;
            this.ip = str;
            this.type = i4;
            this.aVj = i5;
        }

        @Override // java.lang.Runnable
        public void run() {
            if (this.gwr != null) {
                if (this.type == 1 || this.type == 5 || this.type == 3 || this.type == 6 || this.type == 7 || this.type == 11 || this.type == 15 || this.type == 16 || this.type == 17) {
                    this.gwr.a(this.gwu, this.gwv, this.what, this.gww, this.aVj, this.type);
                } else if (this.type == 2 || this.type == 4 || this.type == 8 || this.type == 12 || this.type == 18) {
                    this.gwr.b(this.gwu, this.gwv, this.what, this.gww, this.aVj, this.type);
                } else if (this.type == 0 || this.type == 10) {
                    this.gwr.a(this.gwu, this.gwv, this.what, this.gww, this.ip, this.aVj, this.type);
                }
            }
        }
    }

    public void clear() {
        if (this.mHandler != null) {
            this.mHandler.removeCallbacksAndMessages(null);
        }
    }

    public static void rp(String str) {
        if (!StringUtils.isNull(str)) {
            new BdAsyncTask<String, Void, Void>() { // from class: com.baidu.tieba.play.b.a.1
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
