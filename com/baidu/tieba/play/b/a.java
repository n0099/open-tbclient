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
    private c juy;
    private int juz = 0;
    private int juA = 0;
    private Handler mHandler = new Handler();

    public a(c cVar) {
        this.juy = cVar;
    }

    public boolean a(g gVar, int i, int i2, int i3, Uri uri) {
        if (this.juy == null) {
            return false;
        }
        if (i == -300) {
            if (this.juA == 0) {
                this.juA++;
                this.mHandler.postDelayed(new b(this.juy, gVar, i, i2, i3, 3, cxf()), 200L);
            } else if (this.juA == 1) {
                this.juA++;
                this.mHandler.postDelayed(new b(this.juy, gVar, i, i2, i3, 4, cxf()), 200L);
            } else {
                return false;
            }
            return true;
        }
        this.juz++;
        if (this.juz <= 2) {
            if (!a(gVar, i, i2, i3, uri, cxf())) {
                if (i == -200) {
                    this.mHandler.postDelayed(new b(this.juy, gVar, i, i2, i3, this.juz % 2 == 1 ? 7 : 17, cxf()), 200L);
                    this.juz = 2;
                } else {
                    this.mHandler.postDelayed(new b(this.juy, gVar, i, i2, i3, this.juz % 2 == 1 ? 8 : 18, cxf()), 200L);
                    this.juz = 4;
                    return false;
                }
            }
            return true;
        } else if (this.juz <= 4) {
            if (i == -200) {
                this.mHandler.postDelayed(new b(this.juy, gVar, i, i2, i3, this.juz % 2 == 1 ? 1 : 11, cxf()), 200L);
                return true;
            }
            return false;
        } else if (this.juz <= 6 && i == -200) {
            this.mHandler.postDelayed(new b(this.juy, gVar, i, i2, i3, this.juz % 2 == 1 ? 2 : 12, cxf()), 200L);
            return true;
        } else {
            return false;
        }
    }

    private int cxf() {
        return (this.juA * 100) + this.juz;
    }

    private boolean a(g gVar, int i, int i2, int i3, Uri uri, int i4) {
        if (!cxg() || i == -100 || uri == null || TextUtils.isEmpty(uri.getHost()) || uri.toString().contains("127.0.0.1") || !uri.toString().contains(HttpHost.DEFAULT_SCHEME_NAME)) {
            return false;
        }
        com.baidu.adp.lib.network.http.a.b.gj().a(new C0575a(this.mHandler, this.juy, i, uri, gVar, i2, i3, i4));
        return com.baidu.adp.lib.network.http.a.b.gj().ao(uri.getHost());
    }

    private boolean cxg() {
        return (SwitchManager.getInstance().findType(VideoHttpDnsSwitch.HTTP_DNS_SWITCH_KEY) == 0 || !j.isNetWorkAvailable() || CustomPlayerSwitch.getSwitchStatus() == 0) ? false : true;
    }

    /* JADX INFO: Access modifiers changed from: private */
    /* renamed from: com.baidu.tieba.play.b.a$a  reason: collision with other inner class name */
    /* loaded from: classes.dex */
    public static class C0575a implements b.InterfaceC0018b {
        private int eBn;
        private g juB;
        private int juC;
        private int juD;
        private c juy;
        private Handler mHandler;
        private Uri mUri;
        private int what;

        public C0575a(Handler handler, c cVar, int i, Uri uri, g gVar, int i2, int i3, int i4) {
            this.mHandler = handler;
            this.juy = cVar;
            this.mUri = uri;
            this.juB = gVar;
            this.juC = i;
            this.what = i2;
            this.juD = i3;
            this.eBn = i4;
        }

        @Override // com.baidu.adp.lib.network.http.a.b.InterfaceC0018b
        public void o(String str, String str2) {
            try {
                if (TextUtils.isEmpty(str) || TextUtils.isEmpty(str2) || this.mUri == null || !str2.equals(this.mUri.getHost())) {
                    if (this.mHandler != null) {
                        this.mHandler.postDelayed(new b(this.juy, this.juB, this.juC, this.what, this.juD, this.eBn % 2 == 1 ? 5 : 15, this.eBn), 200L);
                    }
                } else if (this.mHandler != null) {
                    this.mHandler.postDelayed(new b(this.juy, this.juB, this.juC, this.what, this.juD, str, this.eBn % 2 == 1 ? 0 : 10, this.eBn), 200L);
                }
            } catch (Throwable th) {
                th.printStackTrace();
                if (this.mHandler != null) {
                    this.mHandler.postDelayed(new b(this.juy, this.juB, this.juC, this.what, this.juD, this.eBn % 2 == 1 ? 6 : 16, this.eBn), 200L);
                }
            }
        }
    }

    public boolean cxh() {
        boolean z = this.juz > 0 || this.juA > 0;
        this.juz = 0;
        this.juA = 0;
        return z;
    }

    /* JADX INFO: Access modifiers changed from: private */
    /* loaded from: classes.dex */
    public static class b implements Runnable {
        private final int eBn;
        private final String ip;
        private final g juB;
        private final int juC;
        private final int juD;
        private c juy;
        private final int type;
        private final int what;

        public b(c cVar, g gVar, int i, int i2, int i3, int i4, int i5) {
            this.juy = cVar;
            this.juB = gVar;
            this.juC = i;
            this.what = i2;
            this.juD = i3;
            this.type = i4;
            this.eBn = i5;
            this.ip = "";
        }

        public b(c cVar, g gVar, int i, int i2, int i3, String str, int i4, int i5) {
            this.juy = cVar;
            this.juB = gVar;
            this.juC = i;
            this.what = i2;
            this.juD = i3;
            this.ip = str;
            this.type = i4;
            this.eBn = i5;
        }

        @Override // java.lang.Runnable
        public void run() {
            if (this.juy != null) {
                if (this.type == 1 || this.type == 5 || this.type == 3 || this.type == 6 || this.type == 7 || this.type == 11 || this.type == 15 || this.type == 16 || this.type == 17) {
                    this.juy.a(this.juB, this.juC, this.what, this.juD, this.eBn, this.type);
                } else if (this.type == 2 || this.type == 4 || this.type == 8 || this.type == 12 || this.type == 18) {
                    this.juy.b(this.juB, this.juC, this.what, this.juD, this.eBn, this.type);
                } else if (this.type == 0 || this.type == 10) {
                    this.juy.a(this.juB, this.juC, this.what, this.juD, this.ip, this.eBn, this.type);
                }
            }
        }
    }

    public void clear() {
        if (this.mHandler != null) {
            this.mHandler.removeCallbacksAndMessages(null);
        }
    }

    public static void GI(String str) {
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
