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
    private c kDU;
    private int kDV = 0;
    private int kDW = 0;
    private Handler mHandler = new Handler();

    public a(c cVar) {
        this.kDU = cVar;
    }

    public boolean a(g gVar, int i, int i2, int i3, Uri uri) {
        if (this.kDU == null) {
            return false;
        }
        if (i == -300) {
            if (this.kDW == 0) {
                this.kDW++;
                this.mHandler.postDelayed(new b(this.kDU, gVar, i, i2, i3, 3, cSe()), 200L);
            } else if (this.kDW == 1) {
                this.kDW++;
                this.mHandler.postDelayed(new b(this.kDU, gVar, i, i2, i3, 4, cSe()), 200L);
            } else {
                return false;
            }
            return true;
        }
        this.kDV++;
        if (this.kDV <= 2) {
            if (!a(gVar, i, i2, i3, uri, cSe())) {
                if (i == -200) {
                    this.mHandler.postDelayed(new b(this.kDU, gVar, i, i2, i3, this.kDV % 2 == 1 ? 7 : 17, cSe()), 200L);
                    this.kDV = 2;
                } else {
                    this.mHandler.postDelayed(new b(this.kDU, gVar, i, i2, i3, this.kDV % 2 == 1 ? 8 : 18, cSe()), 200L);
                    this.kDV = 4;
                    return false;
                }
            }
            return true;
        } else if (this.kDV <= 4) {
            if (i == -200) {
                this.mHandler.postDelayed(new b(this.kDU, gVar, i, i2, i3, this.kDV % 2 == 1 ? 1 : 11, cSe()), 200L);
                return true;
            }
            return false;
        } else if (this.kDV <= 6 && i == -200) {
            this.mHandler.postDelayed(new b(this.kDU, gVar, i, i2, i3, this.kDV % 2 == 1 ? 2 : 12, cSe()), 200L);
            return true;
        } else {
            return false;
        }
    }

    private int cSe() {
        return (this.kDW * 100) + this.kDV;
    }

    private boolean a(g gVar, int i, int i2, int i3, Uri uri, int i4) {
        if (!cSf() || i == -100 || uri == null || TextUtils.isEmpty(uri.getHost()) || uri.toString().contains("127.0.0.1") || !uri.toString().contains(HttpHost.DEFAULT_SCHEME_NAME)) {
            return false;
        }
        com.baidu.adp.lib.network.http.a.b.kN().a(new C0703a(this.mHandler, this.kDU, i, uri, gVar, i2, i3, i4));
        return com.baidu.adp.lib.network.http.a.b.kN().bE(uri.getHost());
    }

    private boolean cSf() {
        return (SwitchManager.getInstance().findType(VideoHttpDnsSwitch.HTTP_DNS_SWITCH_KEY) == 0 || !j.isNetWorkAvailable() || CustomPlayerSwitch.getSwitchStatus() == 0) ? false : true;
    }

    /* JADX INFO: Access modifiers changed from: private */
    /* renamed from: com.baidu.tieba.play.b.a$a  reason: collision with other inner class name */
    /* loaded from: classes.dex */
    public static class C0703a implements b.InterfaceC0022b {
        private int fzF;
        private c kDU;
        private g kDX;
        private int kDY;
        private int kDZ;
        private Handler mHandler;
        private Uri mUri;
        private int what;

        public C0703a(Handler handler, c cVar, int i, Uri uri, g gVar, int i2, int i3, int i4) {
            this.mHandler = handler;
            this.kDU = cVar;
            this.mUri = uri;
            this.kDX = gVar;
            this.kDY = i;
            this.what = i2;
            this.kDZ = i3;
            this.fzF = i4;
        }

        @Override // com.baidu.adp.lib.network.http.a.b.InterfaceC0022b
        public void u(String str, String str2) {
            try {
                if (TextUtils.isEmpty(str) || TextUtils.isEmpty(str2) || this.mUri == null || !str2.equals(this.mUri.getHost())) {
                    if (this.mHandler != null) {
                        this.mHandler.postDelayed(new b(this.kDU, this.kDX, this.kDY, this.what, this.kDZ, this.fzF % 2 == 1 ? 5 : 15, this.fzF), 200L);
                    }
                } else if (this.mHandler != null) {
                    this.mHandler.postDelayed(new b(this.kDU, this.kDX, this.kDY, this.what, this.kDZ, str, this.fzF % 2 == 1 ? 0 : 10, this.fzF), 200L);
                }
            } catch (Throwable th) {
                th.printStackTrace();
                if (this.mHandler != null) {
                    this.mHandler.postDelayed(new b(this.kDU, this.kDX, this.kDY, this.what, this.kDZ, this.fzF % 2 == 1 ? 6 : 16, this.fzF), 200L);
                }
            }
        }
    }

    public boolean cSg() {
        boolean z = this.kDV > 0 || this.kDW > 0;
        this.kDV = 0;
        this.kDW = 0;
        return z;
    }

    /* JADX INFO: Access modifiers changed from: private */
    /* loaded from: classes.dex */
    public static class b implements Runnable {
        private final int fzF;
        private final String ip;
        private c kDU;
        private final g kDX;
        private final int kDY;
        private final int kDZ;
        private final int type;
        private final int what;

        public b(c cVar, g gVar, int i, int i2, int i3, int i4, int i5) {
            this.kDU = cVar;
            this.kDX = gVar;
            this.kDY = i;
            this.what = i2;
            this.kDZ = i3;
            this.type = i4;
            this.fzF = i5;
            this.ip = "";
        }

        public b(c cVar, g gVar, int i, int i2, int i3, String str, int i4, int i5) {
            this.kDU = cVar;
            this.kDX = gVar;
            this.kDY = i;
            this.what = i2;
            this.kDZ = i3;
            this.ip = str;
            this.type = i4;
            this.fzF = i5;
        }

        @Override // java.lang.Runnable
        public void run() {
            if (this.kDU != null) {
                if (this.type == 1 || this.type == 5 || this.type == 3 || this.type == 6 || this.type == 7 || this.type == 11 || this.type == 15 || this.type == 16 || this.type == 17) {
                    this.kDU.a(this.kDX, this.kDY, this.what, this.kDZ, this.fzF, this.type);
                } else if (this.type == 2 || this.type == 4 || this.type == 8 || this.type == 12 || this.type == 18) {
                    this.kDU.b(this.kDX, this.kDY, this.what, this.kDZ, this.fzF, this.type);
                } else if (this.type == 0 || this.type == 10) {
                    this.kDU.a(this.kDX, this.kDY, this.what, this.kDZ, this.ip, this.fzF, this.type);
                }
            }
        }
    }

    public void clear() {
        if (this.mHandler != null) {
            this.mHandler.removeCallbacksAndMessages(null);
        }
    }

    public static void KE(String str) {
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
