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
    private c kCM;
    private int kCN = 0;
    private int kCO = 0;
    private Handler mHandler = new Handler();

    public a(c cVar) {
        this.kCM = cVar;
    }

    public boolean a(g gVar, int i, int i2, int i3, Uri uri) {
        if (this.kCM == null) {
            return false;
        }
        if (i == -300) {
            if (this.kCO == 0) {
                this.kCO++;
                this.mHandler.postDelayed(new b(this.kCM, gVar, i, i2, i3, 3, cRO()), 200L);
            } else if (this.kCO == 1) {
                this.kCO++;
                this.mHandler.postDelayed(new b(this.kCM, gVar, i, i2, i3, 4, cRO()), 200L);
            } else {
                return false;
            }
            return true;
        }
        this.kCN++;
        if (this.kCN <= 2) {
            if (!a(gVar, i, i2, i3, uri, cRO())) {
                if (i == -200) {
                    this.mHandler.postDelayed(new b(this.kCM, gVar, i, i2, i3, this.kCN % 2 == 1 ? 7 : 17, cRO()), 200L);
                    this.kCN = 2;
                } else {
                    this.mHandler.postDelayed(new b(this.kCM, gVar, i, i2, i3, this.kCN % 2 == 1 ? 8 : 18, cRO()), 200L);
                    this.kCN = 4;
                    return false;
                }
            }
            return true;
        } else if (this.kCN <= 4) {
            if (i == -200) {
                this.mHandler.postDelayed(new b(this.kCM, gVar, i, i2, i3, this.kCN % 2 == 1 ? 1 : 11, cRO()), 200L);
                return true;
            }
            return false;
        } else if (this.kCN <= 6 && i == -200) {
            this.mHandler.postDelayed(new b(this.kCM, gVar, i, i2, i3, this.kCN % 2 == 1 ? 2 : 12, cRO()), 200L);
            return true;
        } else {
            return false;
        }
    }

    private int cRO() {
        return (this.kCO * 100) + this.kCN;
    }

    private boolean a(g gVar, int i, int i2, int i3, Uri uri, int i4) {
        if (!cRP() || i == -100 || uri == null || TextUtils.isEmpty(uri.getHost()) || uri.toString().contains("127.0.0.1") || !uri.toString().contains(HttpHost.DEFAULT_SCHEME_NAME)) {
            return false;
        }
        com.baidu.adp.lib.network.http.a.b.kN().a(new C0702a(this.mHandler, this.kCM, i, uri, gVar, i2, i3, i4));
        return com.baidu.adp.lib.network.http.a.b.kN().bE(uri.getHost());
    }

    private boolean cRP() {
        return (SwitchManager.getInstance().findType(VideoHttpDnsSwitch.HTTP_DNS_SWITCH_KEY) == 0 || !j.isNetWorkAvailable() || CustomPlayerSwitch.getSwitchStatus() == 0) ? false : true;
    }

    /* JADX INFO: Access modifiers changed from: private */
    /* renamed from: com.baidu.tieba.play.b.a$a  reason: collision with other inner class name */
    /* loaded from: classes.dex */
    public static class C0702a implements b.InterfaceC0022b {
        private int fzu;
        private c kCM;
        private g kCP;
        private int kCQ;
        private int kCR;
        private Handler mHandler;
        private Uri mUri;
        private int what;

        public C0702a(Handler handler, c cVar, int i, Uri uri, g gVar, int i2, int i3, int i4) {
            this.mHandler = handler;
            this.kCM = cVar;
            this.mUri = uri;
            this.kCP = gVar;
            this.kCQ = i;
            this.what = i2;
            this.kCR = i3;
            this.fzu = i4;
        }

        @Override // com.baidu.adp.lib.network.http.a.b.InterfaceC0022b
        public void u(String str, String str2) {
            try {
                if (TextUtils.isEmpty(str) || TextUtils.isEmpty(str2) || this.mUri == null || !str2.equals(this.mUri.getHost())) {
                    if (this.mHandler != null) {
                        this.mHandler.postDelayed(new b(this.kCM, this.kCP, this.kCQ, this.what, this.kCR, this.fzu % 2 == 1 ? 5 : 15, this.fzu), 200L);
                    }
                } else if (this.mHandler != null) {
                    this.mHandler.postDelayed(new b(this.kCM, this.kCP, this.kCQ, this.what, this.kCR, str, this.fzu % 2 == 1 ? 0 : 10, this.fzu), 200L);
                }
            } catch (Throwable th) {
                th.printStackTrace();
                if (this.mHandler != null) {
                    this.mHandler.postDelayed(new b(this.kCM, this.kCP, this.kCQ, this.what, this.kCR, this.fzu % 2 == 1 ? 6 : 16, this.fzu), 200L);
                }
            }
        }
    }

    public boolean cRQ() {
        boolean z = this.kCN > 0 || this.kCO > 0;
        this.kCN = 0;
        this.kCO = 0;
        return z;
    }

    /* JADX INFO: Access modifiers changed from: private */
    /* loaded from: classes.dex */
    public static class b implements Runnable {
        private final int fzu;
        private final String ip;
        private c kCM;
        private final g kCP;
        private final int kCQ;
        private final int kCR;
        private final int type;
        private final int what;

        public b(c cVar, g gVar, int i, int i2, int i3, int i4, int i5) {
            this.kCM = cVar;
            this.kCP = gVar;
            this.kCQ = i;
            this.what = i2;
            this.kCR = i3;
            this.type = i4;
            this.fzu = i5;
            this.ip = "";
        }

        public b(c cVar, g gVar, int i, int i2, int i3, String str, int i4, int i5) {
            this.kCM = cVar;
            this.kCP = gVar;
            this.kCQ = i;
            this.what = i2;
            this.kCR = i3;
            this.ip = str;
            this.type = i4;
            this.fzu = i5;
        }

        @Override // java.lang.Runnable
        public void run() {
            if (this.kCM != null) {
                if (this.type == 1 || this.type == 5 || this.type == 3 || this.type == 6 || this.type == 7 || this.type == 11 || this.type == 15 || this.type == 16 || this.type == 17) {
                    this.kCM.a(this.kCP, this.kCQ, this.what, this.kCR, this.fzu, this.type);
                } else if (this.type == 2 || this.type == 4 || this.type == 8 || this.type == 12 || this.type == 18) {
                    this.kCM.b(this.kCP, this.kCQ, this.what, this.kCR, this.fzu, this.type);
                } else if (this.type == 0 || this.type == 10) {
                    this.kCM.a(this.kCP, this.kCQ, this.what, this.kCR, this.ip, this.fzu, this.type);
                }
            }
        }
    }

    public void clear() {
        if (this.mHandler != null) {
            this.mHandler.removeCallbacksAndMessages(null);
        }
    }

    public static void KD(String str) {
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
