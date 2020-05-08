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
    private c kkR;
    private int kkS = 0;
    private int kkT = 0;
    private Handler mHandler = new Handler();

    public a(c cVar) {
        this.kkR = cVar;
    }

    public boolean a(g gVar, int i, int i2, int i3, Uri uri) {
        if (this.kkR == null) {
            return false;
        }
        if (i == -300) {
            if (this.kkT == 0) {
                this.kkT++;
                this.mHandler.postDelayed(new b(this.kkR, gVar, i, i2, i3, 3, cKN()), 200L);
            } else if (this.kkT == 1) {
                this.kkT++;
                this.mHandler.postDelayed(new b(this.kkR, gVar, i, i2, i3, 4, cKN()), 200L);
            } else {
                return false;
            }
            return true;
        }
        this.kkS++;
        if (this.kkS <= 2) {
            if (!a(gVar, i, i2, i3, uri, cKN())) {
                if (i == -200) {
                    this.mHandler.postDelayed(new b(this.kkR, gVar, i, i2, i3, this.kkS % 2 == 1 ? 7 : 17, cKN()), 200L);
                    this.kkS = 2;
                } else {
                    this.mHandler.postDelayed(new b(this.kkR, gVar, i, i2, i3, this.kkS % 2 == 1 ? 8 : 18, cKN()), 200L);
                    this.kkS = 4;
                    return false;
                }
            }
            return true;
        } else if (this.kkS <= 4) {
            if (i == -200) {
                this.mHandler.postDelayed(new b(this.kkR, gVar, i, i2, i3, this.kkS % 2 == 1 ? 1 : 11, cKN()), 200L);
                return true;
            }
            return false;
        } else if (this.kkS <= 6 && i == -200) {
            this.mHandler.postDelayed(new b(this.kkR, gVar, i, i2, i3, this.kkS % 2 == 1 ? 2 : 12, cKN()), 200L);
            return true;
        } else {
            return false;
        }
    }

    private int cKN() {
        return (this.kkT * 100) + this.kkS;
    }

    private boolean a(g gVar, int i, int i2, int i3, Uri uri, int i4) {
        if (!cKO() || i == -100 || uri == null || TextUtils.isEmpty(uri.getHost()) || uri.toString().contains("127.0.0.1") || !uri.toString().contains(HttpHost.DEFAULT_SCHEME_NAME)) {
            return false;
        }
        com.baidu.adp.lib.network.http.a.b.kL().a(new C0649a(this.mHandler, this.kkR, i, uri, gVar, i2, i3, i4));
        return com.baidu.adp.lib.network.http.a.b.kL().bD(uri.getHost());
    }

    private boolean cKO() {
        return (SwitchManager.getInstance().findType(VideoHttpDnsSwitch.HTTP_DNS_SWITCH_KEY) == 0 || !j.isNetWorkAvailable() || CustomPlayerSwitch.getSwitchStatus() == 0) ? false : true;
    }

    /* JADX INFO: Access modifiers changed from: private */
    /* renamed from: com.baidu.tieba.play.b.a$a  reason: collision with other inner class name */
    /* loaded from: classes.dex */
    public static class C0649a implements b.InterfaceC0020b {
        private int flN;
        private c kkR;
        private g kkU;
        private int kkV;
        private int kkW;
        private Handler mHandler;
        private Uri mUri;
        private int what;

        public C0649a(Handler handler, c cVar, int i, Uri uri, g gVar, int i2, int i3, int i4) {
            this.mHandler = handler;
            this.kkR = cVar;
            this.mUri = uri;
            this.kkU = gVar;
            this.kkV = i;
            this.what = i2;
            this.kkW = i3;
            this.flN = i4;
        }

        @Override // com.baidu.adp.lib.network.http.a.b.InterfaceC0020b
        public void u(String str, String str2) {
            try {
                if (TextUtils.isEmpty(str) || TextUtils.isEmpty(str2) || this.mUri == null || !str2.equals(this.mUri.getHost())) {
                    if (this.mHandler != null) {
                        this.mHandler.postDelayed(new b(this.kkR, this.kkU, this.kkV, this.what, this.kkW, this.flN % 2 == 1 ? 5 : 15, this.flN), 200L);
                    }
                } else if (this.mHandler != null) {
                    this.mHandler.postDelayed(new b(this.kkR, this.kkU, this.kkV, this.what, this.kkW, str, this.flN % 2 == 1 ? 0 : 10, this.flN), 200L);
                }
            } catch (Throwable th) {
                th.printStackTrace();
                if (this.mHandler != null) {
                    this.mHandler.postDelayed(new b(this.kkR, this.kkU, this.kkV, this.what, this.kkW, this.flN % 2 == 1 ? 6 : 16, this.flN), 200L);
                }
            }
        }
    }

    public boolean cKP() {
        boolean z = this.kkS > 0 || this.kkT > 0;
        this.kkS = 0;
        this.kkT = 0;
        return z;
    }

    /* JADX INFO: Access modifiers changed from: private */
    /* loaded from: classes.dex */
    public static class b implements Runnable {
        private final int flN;
        private final String ip;
        private c kkR;
        private final g kkU;
        private final int kkV;
        private final int kkW;
        private final int type;
        private final int what;

        public b(c cVar, g gVar, int i, int i2, int i3, int i4, int i5) {
            this.kkR = cVar;
            this.kkU = gVar;
            this.kkV = i;
            this.what = i2;
            this.kkW = i3;
            this.type = i4;
            this.flN = i5;
            this.ip = "";
        }

        public b(c cVar, g gVar, int i, int i2, int i3, String str, int i4, int i5) {
            this.kkR = cVar;
            this.kkU = gVar;
            this.kkV = i;
            this.what = i2;
            this.kkW = i3;
            this.ip = str;
            this.type = i4;
            this.flN = i5;
        }

        @Override // java.lang.Runnable
        public void run() {
            if (this.kkR != null) {
                if (this.type == 1 || this.type == 5 || this.type == 3 || this.type == 6 || this.type == 7 || this.type == 11 || this.type == 15 || this.type == 16 || this.type == 17) {
                    this.kkR.a(this.kkU, this.kkV, this.what, this.kkW, this.flN, this.type);
                } else if (this.type == 2 || this.type == 4 || this.type == 8 || this.type == 12 || this.type == 18) {
                    this.kkR.b(this.kkU, this.kkV, this.what, this.kkW, this.flN, this.type);
                } else if (this.type == 0 || this.type == 10) {
                    this.kkR.a(this.kkU, this.kkV, this.what, this.kkW, this.ip, this.flN, this.type);
                }
            }
        }
    }

    public void clear() {
        if (this.mHandler != null) {
            this.mHandler.removeCallbacksAndMessages(null);
        }
    }

    public static void IR(String str) {
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
