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
    private c jAI;
    private int jAJ = 0;
    private int jAK = 0;
    private Handler mHandler = new Handler();

    public a(c cVar) {
        this.jAI = cVar;
    }

    public boolean a(g gVar, int i, int i2, int i3, Uri uri) {
        if (this.jAI == null) {
            return false;
        }
        if (i == -300) {
            if (this.jAK == 0) {
                this.jAK++;
                this.mHandler.postDelayed(new b(this.jAI, gVar, i, i2, i3, 3, cAg()), 200L);
            } else if (this.jAK == 1) {
                this.jAK++;
                this.mHandler.postDelayed(new b(this.jAI, gVar, i, i2, i3, 4, cAg()), 200L);
            } else {
                return false;
            }
            return true;
        }
        this.jAJ++;
        if (this.jAJ <= 2) {
            if (!a(gVar, i, i2, i3, uri, cAg())) {
                if (i == -200) {
                    this.mHandler.postDelayed(new b(this.jAI, gVar, i, i2, i3, this.jAJ % 2 == 1 ? 7 : 17, cAg()), 200L);
                    this.jAJ = 2;
                } else {
                    this.mHandler.postDelayed(new b(this.jAI, gVar, i, i2, i3, this.jAJ % 2 == 1 ? 8 : 18, cAg()), 200L);
                    this.jAJ = 4;
                    return false;
                }
            }
            return true;
        } else if (this.jAJ <= 4) {
            if (i == -200) {
                this.mHandler.postDelayed(new b(this.jAI, gVar, i, i2, i3, this.jAJ % 2 == 1 ? 1 : 11, cAg()), 200L);
                return true;
            }
            return false;
        } else if (this.jAJ <= 6 && i == -200) {
            this.mHandler.postDelayed(new b(this.jAI, gVar, i, i2, i3, this.jAJ % 2 == 1 ? 2 : 12, cAg()), 200L);
            return true;
        } else {
            return false;
        }
    }

    private int cAg() {
        return (this.jAK * 100) + this.jAJ;
    }

    private boolean a(g gVar, int i, int i2, int i3, Uri uri, int i4) {
        if (!cAh() || i == -100 || uri == null || TextUtils.isEmpty(uri.getHost()) || uri.toString().contains("127.0.0.1") || !uri.toString().contains(HttpHost.DEFAULT_SCHEME_NAME)) {
            return false;
        }
        com.baidu.adp.lib.network.http.a.b.gi().a(new C0589a(this.mHandler, this.jAI, i, uri, gVar, i2, i3, i4));
        return com.baidu.adp.lib.network.http.a.b.gi().ao(uri.getHost());
    }

    private boolean cAh() {
        return (SwitchManager.getInstance().findType(VideoHttpDnsSwitch.HTTP_DNS_SWITCH_KEY) == 0 || !j.isNetWorkAvailable() || CustomPlayerSwitch.getSwitchStatus() == 0) ? false : true;
    }

    /* JADX INFO: Access modifiers changed from: private */
    /* renamed from: com.baidu.tieba.play.b.a$a  reason: collision with other inner class name */
    /* loaded from: classes.dex */
    public static class C0589a implements b.InterfaceC0018b {
        private int eHr;
        private c jAI;
        private g jAL;
        private int jAM;
        private int jAN;
        private Handler mHandler;
        private Uri mUri;
        private int what;

        public C0589a(Handler handler, c cVar, int i, Uri uri, g gVar, int i2, int i3, int i4) {
            this.mHandler = handler;
            this.jAI = cVar;
            this.mUri = uri;
            this.jAL = gVar;
            this.jAM = i;
            this.what = i2;
            this.jAN = i3;
            this.eHr = i4;
        }

        @Override // com.baidu.adp.lib.network.http.a.b.InterfaceC0018b
        public void q(String str, String str2) {
            try {
                if (TextUtils.isEmpty(str) || TextUtils.isEmpty(str2) || this.mUri == null || !str2.equals(this.mUri.getHost())) {
                    if (this.mHandler != null) {
                        this.mHandler.postDelayed(new b(this.jAI, this.jAL, this.jAM, this.what, this.jAN, this.eHr % 2 == 1 ? 5 : 15, this.eHr), 200L);
                    }
                } else if (this.mHandler != null) {
                    this.mHandler.postDelayed(new b(this.jAI, this.jAL, this.jAM, this.what, this.jAN, str, this.eHr % 2 == 1 ? 0 : 10, this.eHr), 200L);
                }
            } catch (Throwable th) {
                th.printStackTrace();
                if (this.mHandler != null) {
                    this.mHandler.postDelayed(new b(this.jAI, this.jAL, this.jAM, this.what, this.jAN, this.eHr % 2 == 1 ? 6 : 16, this.eHr), 200L);
                }
            }
        }
    }

    public boolean cAi() {
        boolean z = this.jAJ > 0 || this.jAK > 0;
        this.jAJ = 0;
        this.jAK = 0;
        return z;
    }

    /* JADX INFO: Access modifiers changed from: private */
    /* loaded from: classes.dex */
    public static class b implements Runnable {
        private final int eHr;
        private final String ip;
        private c jAI;
        private final g jAL;
        private final int jAM;
        private final int jAN;
        private final int type;
        private final int what;

        public b(c cVar, g gVar, int i, int i2, int i3, int i4, int i5) {
            this.jAI = cVar;
            this.jAL = gVar;
            this.jAM = i;
            this.what = i2;
            this.jAN = i3;
            this.type = i4;
            this.eHr = i5;
            this.ip = "";
        }

        public b(c cVar, g gVar, int i, int i2, int i3, String str, int i4, int i5) {
            this.jAI = cVar;
            this.jAL = gVar;
            this.jAM = i;
            this.what = i2;
            this.jAN = i3;
            this.ip = str;
            this.type = i4;
            this.eHr = i5;
        }

        @Override // java.lang.Runnable
        public void run() {
            if (this.jAI != null) {
                if (this.type == 1 || this.type == 5 || this.type == 3 || this.type == 6 || this.type == 7 || this.type == 11 || this.type == 15 || this.type == 16 || this.type == 17) {
                    this.jAI.a(this.jAL, this.jAM, this.what, this.jAN, this.eHr, this.type);
                } else if (this.type == 2 || this.type == 4 || this.type == 8 || this.type == 12 || this.type == 18) {
                    this.jAI.b(this.jAL, this.jAM, this.what, this.jAN, this.eHr, this.type);
                } else if (this.type == 0 || this.type == 10) {
                    this.jAI.a(this.jAL, this.jAM, this.what, this.jAN, this.ip, this.eHr, this.type);
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
