package com.baidu.tieba.play.b;

import android.net.Uri;
import android.os.Handler;
import android.text.TextUtils;
import com.baidu.adp.lib.asyncTask.BdAsyncTask;
import com.baidu.adp.lib.featureSwitch.SwitchManager;
import com.baidu.adp.lib.network.http.a.b;
import com.baidu.adp.lib.util.StringUtils;
import com.baidu.adp.lib.util.j;
import com.baidu.tbadk.core.util.m;
import com.baidu.tbadk.switchs.CustomPlayerSwitch;
import com.baidu.tbadk.switchs.VideoHttpDnsSwitch;
import com.baidu.tieba.play.g;
import java.io.File;
import org.apache.http.HttpHost;
/* loaded from: classes.dex */
public class a {
    private c kkN;
    private int kkO = 0;
    private int kkP = 0;
    private Handler mHandler = new Handler();

    public a(c cVar) {
        this.kkN = cVar;
    }

    public boolean a(g gVar, int i, int i2, int i3, Uri uri) {
        if (this.kkN == null) {
            return false;
        }
        if (i == -300) {
            if (this.kkP == 0) {
                this.kkP++;
                this.mHandler.postDelayed(new b(this.kkN, gVar, i, i2, i3, 3, cKQ()), 200L);
            } else if (this.kkP == 1) {
                this.kkP++;
                this.mHandler.postDelayed(new b(this.kkN, gVar, i, i2, i3, 4, cKQ()), 200L);
            } else {
                return false;
            }
            return true;
        }
        this.kkO++;
        if (this.kkO <= 2) {
            if (!a(gVar, i, i2, i3, uri, cKQ())) {
                if (i == -200) {
                    this.mHandler.postDelayed(new b(this.kkN, gVar, i, i2, i3, this.kkO % 2 == 1 ? 7 : 17, cKQ()), 200L);
                    this.kkO = 2;
                } else {
                    this.mHandler.postDelayed(new b(this.kkN, gVar, i, i2, i3, this.kkO % 2 == 1 ? 8 : 18, cKQ()), 200L);
                    this.kkO = 4;
                    return false;
                }
            }
            return true;
        } else if (this.kkO <= 4) {
            if (i == -200) {
                this.mHandler.postDelayed(new b(this.kkN, gVar, i, i2, i3, this.kkO % 2 == 1 ? 1 : 11, cKQ()), 200L);
                return true;
            }
            return false;
        } else if (this.kkO <= 6 && i == -200) {
            this.mHandler.postDelayed(new b(this.kkN, gVar, i, i2, i3, this.kkO % 2 == 1 ? 2 : 12, cKQ()), 200L);
            return true;
        } else {
            return false;
        }
    }

    private int cKQ() {
        return (this.kkP * 100) + this.kkO;
    }

    private boolean a(g gVar, int i, int i2, int i3, Uri uri, int i4) {
        if (!cKR() || i == -100 || uri == null || TextUtils.isEmpty(uri.getHost()) || uri.toString().contains("127.0.0.1") || !uri.toString().contains(HttpHost.DEFAULT_SCHEME_NAME)) {
            return false;
        }
        com.baidu.adp.lib.network.http.a.b.kL().a(new C0628a(this.mHandler, this.kkN, i, uri, gVar, i2, i3, i4));
        return com.baidu.adp.lib.network.http.a.b.kL().bD(uri.getHost());
    }

    private boolean cKR() {
        return (SwitchManager.getInstance().findType(VideoHttpDnsSwitch.HTTP_DNS_SWITCH_KEY) == 0 || !j.isNetWorkAvailable() || CustomPlayerSwitch.getSwitchStatus() == 0) ? false : true;
    }

    /* JADX INFO: Access modifiers changed from: private */
    /* renamed from: com.baidu.tieba.play.b.a$a  reason: collision with other inner class name */
    /* loaded from: classes.dex */
    public static class C0628a implements b.InterfaceC0020b {
        private int flI;
        private c kkN;
        private g kkQ;
        private int kkR;
        private int kkS;
        private Handler mHandler;
        private Uri mUri;
        private int what;

        public C0628a(Handler handler, c cVar, int i, Uri uri, g gVar, int i2, int i3, int i4) {
            this.mHandler = handler;
            this.kkN = cVar;
            this.mUri = uri;
            this.kkQ = gVar;
            this.kkR = i;
            this.what = i2;
            this.kkS = i3;
            this.flI = i4;
        }

        @Override // com.baidu.adp.lib.network.http.a.b.InterfaceC0020b
        public void u(String str, String str2) {
            try {
                if (TextUtils.isEmpty(str) || TextUtils.isEmpty(str2) || this.mUri == null || !str2.equals(this.mUri.getHost())) {
                    if (this.mHandler != null) {
                        this.mHandler.postDelayed(new b(this.kkN, this.kkQ, this.kkR, this.what, this.kkS, this.flI % 2 == 1 ? 5 : 15, this.flI), 200L);
                    }
                } else if (this.mHandler != null) {
                    this.mHandler.postDelayed(new b(this.kkN, this.kkQ, this.kkR, this.what, this.kkS, str, this.flI % 2 == 1 ? 0 : 10, this.flI), 200L);
                }
            } catch (Throwable th) {
                th.printStackTrace();
                if (this.mHandler != null) {
                    this.mHandler.postDelayed(new b(this.kkN, this.kkQ, this.kkR, this.what, this.kkS, this.flI % 2 == 1 ? 6 : 16, this.flI), 200L);
                }
            }
        }
    }

    public boolean cKS() {
        boolean z = this.kkO > 0 || this.kkP > 0;
        this.kkO = 0;
        this.kkP = 0;
        return z;
    }

    /* JADX INFO: Access modifiers changed from: private */
    /* loaded from: classes.dex */
    public static class b implements Runnable {
        private final int flI;
        private final String ip;
        private c kkN;
        private final g kkQ;
        private final int kkR;
        private final int kkS;
        private final int type;
        private final int what;

        public b(c cVar, g gVar, int i, int i2, int i3, int i4, int i5) {
            this.kkN = cVar;
            this.kkQ = gVar;
            this.kkR = i;
            this.what = i2;
            this.kkS = i3;
            this.type = i4;
            this.flI = i5;
            this.ip = "";
        }

        public b(c cVar, g gVar, int i, int i2, int i3, String str, int i4, int i5) {
            this.kkN = cVar;
            this.kkQ = gVar;
            this.kkR = i;
            this.what = i2;
            this.kkS = i3;
            this.ip = str;
            this.type = i4;
            this.flI = i5;
        }

        @Override // java.lang.Runnable
        public void run() {
            if (this.kkN != null) {
                if (this.type == 1 || this.type == 5 || this.type == 3 || this.type == 6 || this.type == 7 || this.type == 11 || this.type == 15 || this.type == 16 || this.type == 17) {
                    this.kkN.a(this.kkQ, this.kkR, this.what, this.kkS, this.flI, this.type);
                } else if (this.type == 2 || this.type == 4 || this.type == 8 || this.type == 12 || this.type == 18) {
                    this.kkN.b(this.kkQ, this.kkR, this.what, this.kkS, this.flI, this.type);
                } else if (this.type == 0 || this.type == 10) {
                    this.kkN.a(this.kkQ, this.kkR, this.what, this.kkS, this.ip, this.flI, this.type);
                }
            }
        }
    }

    public void clear() {
        if (this.mHandler != null) {
            this.mHandler.removeCallbacksAndMessages(null);
        }
    }

    public static void IO(String str) {
        if (!StringUtils.isNull(str)) {
            new BdAsyncTask<String, Void, Void>() { // from class: com.baidu.tieba.play.b.a.1
                /* JADX DEBUG: Method merged with bridge method */
                /* JADX INFO: Access modifiers changed from: protected */
                @Override // com.baidu.adp.lib.asyncTask.BdAsyncTask
                public Void doInBackground(String... strArr) {
                    if (strArr != null && strArr.length == 1) {
                        m.deleteFileOrDir(new File(strArr[0]).getParentFile());
                    }
                    return null;
                }
            }.execute(str);
        }
    }
}
