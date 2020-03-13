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
    private c jzj;
    private int jzk = 0;
    private int jzl = 0;
    private Handler mHandler = new Handler();

    public a(c cVar) {
        this.jzj = cVar;
    }

    public boolean a(g gVar, int i, int i2, int i3, Uri uri) {
        if (this.jzj == null) {
            return false;
        }
        if (i == -300) {
            if (this.jzl == 0) {
                this.jzl++;
                this.mHandler.postDelayed(new b(this.jzj, gVar, i, i2, i3, 3, czM()), 200L);
            } else if (this.jzl == 1) {
                this.jzl++;
                this.mHandler.postDelayed(new b(this.jzj, gVar, i, i2, i3, 4, czM()), 200L);
            } else {
                return false;
            }
            return true;
        }
        this.jzk++;
        if (this.jzk <= 2) {
            if (!a(gVar, i, i2, i3, uri, czM())) {
                if (i == -200) {
                    this.mHandler.postDelayed(new b(this.jzj, gVar, i, i2, i3, this.jzk % 2 == 1 ? 7 : 17, czM()), 200L);
                    this.jzk = 2;
                } else {
                    this.mHandler.postDelayed(new b(this.jzj, gVar, i, i2, i3, this.jzk % 2 == 1 ? 8 : 18, czM()), 200L);
                    this.jzk = 4;
                    return false;
                }
            }
            return true;
        } else if (this.jzk <= 4) {
            if (i == -200) {
                this.mHandler.postDelayed(new b(this.jzj, gVar, i, i2, i3, this.jzk % 2 == 1 ? 1 : 11, czM()), 200L);
                return true;
            }
            return false;
        } else if (this.jzk <= 6 && i == -200) {
            this.mHandler.postDelayed(new b(this.jzj, gVar, i, i2, i3, this.jzk % 2 == 1 ? 2 : 12, czM()), 200L);
            return true;
        } else {
            return false;
        }
    }

    private int czM() {
        return (this.jzl * 100) + this.jzk;
    }

    private boolean a(g gVar, int i, int i2, int i3, Uri uri, int i4) {
        if (!czN() || i == -100 || uri == null || TextUtils.isEmpty(uri.getHost()) || uri.toString().contains("127.0.0.1") || !uri.toString().contains(HttpHost.DEFAULT_SCHEME_NAME)) {
            return false;
        }
        com.baidu.adp.lib.network.http.a.b.gi().a(new C0588a(this.mHandler, this.jzj, i, uri, gVar, i2, i3, i4));
        return com.baidu.adp.lib.network.http.a.b.gi().ao(uri.getHost());
    }

    private boolean czN() {
        return (SwitchManager.getInstance().findType(VideoHttpDnsSwitch.HTTP_DNS_SWITCH_KEY) == 0 || !j.isNetWorkAvailable() || CustomPlayerSwitch.getSwitchStatus() == 0) ? false : true;
    }

    /* JADX INFO: Access modifiers changed from: private */
    /* renamed from: com.baidu.tieba.play.b.a$a  reason: collision with other inner class name */
    /* loaded from: classes.dex */
    public static class C0588a implements b.InterfaceC0018b {
        private int eGV;
        private c jzj;
        private g jzm;
        private int jzn;
        private int jzo;
        private Handler mHandler;
        private Uri mUri;
        private int what;

        public C0588a(Handler handler, c cVar, int i, Uri uri, g gVar, int i2, int i3, int i4) {
            this.mHandler = handler;
            this.jzj = cVar;
            this.mUri = uri;
            this.jzm = gVar;
            this.jzn = i;
            this.what = i2;
            this.jzo = i3;
            this.eGV = i4;
        }

        @Override // com.baidu.adp.lib.network.http.a.b.InterfaceC0018b
        public void q(String str, String str2) {
            try {
                if (TextUtils.isEmpty(str) || TextUtils.isEmpty(str2) || this.mUri == null || !str2.equals(this.mUri.getHost())) {
                    if (this.mHandler != null) {
                        this.mHandler.postDelayed(new b(this.jzj, this.jzm, this.jzn, this.what, this.jzo, this.eGV % 2 == 1 ? 5 : 15, this.eGV), 200L);
                    }
                } else if (this.mHandler != null) {
                    this.mHandler.postDelayed(new b(this.jzj, this.jzm, this.jzn, this.what, this.jzo, str, this.eGV % 2 == 1 ? 0 : 10, this.eGV), 200L);
                }
            } catch (Throwable th) {
                th.printStackTrace();
                if (this.mHandler != null) {
                    this.mHandler.postDelayed(new b(this.jzj, this.jzm, this.jzn, this.what, this.jzo, this.eGV % 2 == 1 ? 6 : 16, this.eGV), 200L);
                }
            }
        }
    }

    public boolean czO() {
        boolean z = this.jzk > 0 || this.jzl > 0;
        this.jzk = 0;
        this.jzl = 0;
        return z;
    }

    /* JADX INFO: Access modifiers changed from: private */
    /* loaded from: classes.dex */
    public static class b implements Runnable {
        private final int eGV;
        private final String ip;
        private c jzj;
        private final g jzm;
        private final int jzn;
        private final int jzo;
        private final int type;
        private final int what;

        public b(c cVar, g gVar, int i, int i2, int i3, int i4, int i5) {
            this.jzj = cVar;
            this.jzm = gVar;
            this.jzn = i;
            this.what = i2;
            this.jzo = i3;
            this.type = i4;
            this.eGV = i5;
            this.ip = "";
        }

        public b(c cVar, g gVar, int i, int i2, int i3, String str, int i4, int i5) {
            this.jzj = cVar;
            this.jzm = gVar;
            this.jzn = i;
            this.what = i2;
            this.jzo = i3;
            this.ip = str;
            this.type = i4;
            this.eGV = i5;
        }

        @Override // java.lang.Runnable
        public void run() {
            if (this.jzj != null) {
                if (this.type == 1 || this.type == 5 || this.type == 3 || this.type == 6 || this.type == 7 || this.type == 11 || this.type == 15 || this.type == 16 || this.type == 17) {
                    this.jzj.a(this.jzm, this.jzn, this.what, this.jzo, this.eGV, this.type);
                } else if (this.type == 2 || this.type == 4 || this.type == 8 || this.type == 12 || this.type == 18) {
                    this.jzj.b(this.jzm, this.jzn, this.what, this.jzo, this.eGV, this.type);
                } else if (this.type == 0 || this.type == 10) {
                    this.jzj.a(this.jzm, this.jzn, this.what, this.jzo, this.ip, this.eGV, this.type);
                }
            }
        }
    }

    public void clear() {
        if (this.mHandler != null) {
            this.mHandler.removeCallbacksAndMessages(null);
        }
    }

    public static void Hh(String str) {
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
