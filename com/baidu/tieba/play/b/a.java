package com.baidu.tieba.play.b;

import android.net.Uri;
import android.os.Handler;
import android.text.TextUtils;
import com.baidu.adp.lib.asyncTask.BdAsyncTask;
import com.baidu.adp.lib.featureSwitch.SwitchManager;
import com.baidu.adp.lib.network.http.a.b;
import com.baidu.adp.lib.util.StringUtils;
import com.baidu.adp.lib.util.j;
import com.baidu.tbadk.core.util.n;
import com.baidu.tbadk.switchs.CustomPlayerSwitch;
import com.baidu.tbadk.switchs.VideoHttpDnsSwitch;
import com.baidu.tieba.play.g;
import java.io.File;
import org.apache.http.HttpHost;
/* loaded from: classes.dex */
public class a {
    private c kXQ;
    private int kXR = 0;
    private int kXS = 0;
    private Handler mHandler = new Handler();

    public a(c cVar) {
        this.kXQ = cVar;
    }

    public boolean a(g gVar, int i, int i2, int i3, Uri uri) {
        if (this.kXQ == null) {
            return false;
        }
        if (i == -300) {
            if (this.kXS == 0) {
                this.kXS++;
                this.mHandler.postDelayed(new b(this.kXQ, gVar, i, i2, i3, 3, cWv()), 200L);
            } else if (this.kXS == 1) {
                this.kXS++;
                this.mHandler.postDelayed(new b(this.kXQ, gVar, i, i2, i3, 4, cWv()), 200L);
            } else {
                return false;
            }
            return true;
        }
        this.kXR++;
        if (this.kXR <= 2) {
            if (!a(gVar, i, i2, i3, uri, cWv())) {
                if (i == -200) {
                    this.mHandler.postDelayed(new b(this.kXQ, gVar, i, i2, i3, this.kXR % 2 == 1 ? 7 : 17, cWv()), 200L);
                    this.kXR = 2;
                } else {
                    this.mHandler.postDelayed(new b(this.kXQ, gVar, i, i2, i3, this.kXR % 2 == 1 ? 8 : 18, cWv()), 200L);
                    this.kXR = 4;
                    return false;
                }
            }
            return true;
        } else if (this.kXR <= 4) {
            if (i == -200) {
                this.mHandler.postDelayed(new b(this.kXQ, gVar, i, i2, i3, this.kXR % 2 == 1 ? 1 : 11, cWv()), 200L);
                return true;
            }
            return false;
        } else if (this.kXR <= 6 && i == -200) {
            this.mHandler.postDelayed(new b(this.kXQ, gVar, i, i2, i3, this.kXR % 2 == 1 ? 2 : 12, cWv()), 200L);
            return true;
        } else {
            return false;
        }
    }

    private int cWv() {
        return (this.kXS * 100) + this.kXR;
    }

    private boolean a(g gVar, int i, int i2, int i3, Uri uri, int i4) {
        if (!cWw() || i == -100 || uri == null || TextUtils.isEmpty(uri.getHost()) || uri.toString().contains("127.0.0.1") || !uri.toString().contains(HttpHost.DEFAULT_SCHEME_NAME)) {
            return false;
        }
        com.baidu.adp.lib.network.http.a.b.ld().a(new C0719a(this.mHandler, this.kXQ, i, uri, gVar, i2, i3, i4));
        return com.baidu.adp.lib.network.http.a.b.ld().bF(uri.getHost());
    }

    private boolean cWw() {
        return (SwitchManager.getInstance().findType(VideoHttpDnsSwitch.HTTP_DNS_SWITCH_KEY) == 0 || !j.isNetWorkAvailable() || CustomPlayerSwitch.getSwitchStatus() == 0) ? false : true;
    }

    /* JADX INFO: Access modifiers changed from: private */
    /* renamed from: com.baidu.tieba.play.b.a$a  reason: collision with other inner class name */
    /* loaded from: classes.dex */
    public static class C0719a implements b.InterfaceC0022b {
        private int fKO;
        private c kXQ;
        private g kXT;
        private int kXU;
        private int kXV;
        private Handler mHandler;
        private Uri mUri;
        private int what;

        public C0719a(Handler handler, c cVar, int i, Uri uri, g gVar, int i2, int i3, int i4) {
            this.mHandler = handler;
            this.kXQ = cVar;
            this.mUri = uri;
            this.kXT = gVar;
            this.kXU = i;
            this.what = i2;
            this.kXV = i3;
            this.fKO = i4;
        }

        @Override // com.baidu.adp.lib.network.http.a.b.InterfaceC0022b
        public void u(String str, String str2) {
            try {
                if (TextUtils.isEmpty(str) || TextUtils.isEmpty(str2) || this.mUri == null || !str2.equals(this.mUri.getHost())) {
                    if (this.mHandler != null) {
                        this.mHandler.postDelayed(new b(this.kXQ, this.kXT, this.kXU, this.what, this.kXV, this.fKO % 2 == 1 ? 5 : 15, this.fKO), 200L);
                    }
                } else if (this.mHandler != null) {
                    this.mHandler.postDelayed(new b(this.kXQ, this.kXT, this.kXU, this.what, this.kXV, str, this.fKO % 2 == 1 ? 0 : 10, this.fKO), 200L);
                }
            } catch (Throwable th) {
                th.printStackTrace();
                if (this.mHandler != null) {
                    this.mHandler.postDelayed(new b(this.kXQ, this.kXT, this.kXU, this.what, this.kXV, this.fKO % 2 == 1 ? 6 : 16, this.fKO), 200L);
                }
            }
        }
    }

    public boolean cWx() {
        boolean z = this.kXR > 0 || this.kXS > 0;
        this.kXR = 0;
        this.kXS = 0;
        return z;
    }

    /* JADX INFO: Access modifiers changed from: private */
    /* loaded from: classes.dex */
    public static class b implements Runnable {
        private final int fKO;
        private final String ip;
        private c kXQ;
        private final g kXT;
        private final int kXU;
        private final int kXV;
        private final int type;
        private final int what;

        public b(c cVar, g gVar, int i, int i2, int i3, int i4, int i5) {
            this.kXQ = cVar;
            this.kXT = gVar;
            this.kXU = i;
            this.what = i2;
            this.kXV = i3;
            this.type = i4;
            this.fKO = i5;
            this.ip = "";
        }

        public b(c cVar, g gVar, int i, int i2, int i3, String str, int i4, int i5) {
            this.kXQ = cVar;
            this.kXT = gVar;
            this.kXU = i;
            this.what = i2;
            this.kXV = i3;
            this.ip = str;
            this.type = i4;
            this.fKO = i5;
        }

        @Override // java.lang.Runnable
        public void run() {
            if (this.kXQ != null) {
                if (this.type == 1 || this.type == 5 || this.type == 3 || this.type == 6 || this.type == 7 || this.type == 11 || this.type == 15 || this.type == 16 || this.type == 17) {
                    this.kXQ.a(this.kXT, this.kXU, this.what, this.kXV, this.fKO, this.type);
                } else if (this.type == 2 || this.type == 4 || this.type == 8 || this.type == 12 || this.type == 18) {
                    this.kXQ.b(this.kXT, this.kXU, this.what, this.kXV, this.fKO, this.type);
                } else if (this.type == 0 || this.type == 10) {
                    this.kXQ.a(this.kXT, this.kXU, this.what, this.kXV, this.ip, this.fKO, this.type);
                }
            }
        }
    }

    public void clear() {
        if (this.mHandler != null) {
            this.mHandler.removeCallbacksAndMessages(null);
        }
    }

    public static void Lf(String str) {
        if (!StringUtils.isNull(str)) {
            new BdAsyncTask<String, Void, Void>() { // from class: com.baidu.tieba.play.b.a.1
                /* JADX DEBUG: Method merged with bridge method */
                /* JADX INFO: Access modifiers changed from: protected */
                @Override // com.baidu.adp.lib.asyncTask.BdAsyncTask
                public Void doInBackground(String... strArr) {
                    if (strArr != null && strArr.length == 1) {
                        n.deleteFileOrDir(new File(strArr[0]).getParentFile());
                    }
                    return null;
                }
            }.execute(str);
        }
    }
}
