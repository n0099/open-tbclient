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
    private c jyf;
    private int jyg = 0;
    private int jyh = 0;
    private Handler mHandler = new Handler();

    public a(c cVar) {
        this.jyf = cVar;
    }

    public boolean a(g gVar, int i, int i2, int i3, Uri uri) {
        if (this.jyf == null) {
            return false;
        }
        if (i == -300) {
            if (this.jyh == 0) {
                this.jyh++;
                this.mHandler.postDelayed(new b(this.jyf, gVar, i, i2, i3, 3, cyo()), 200L);
            } else if (this.jyh == 1) {
                this.jyh++;
                this.mHandler.postDelayed(new b(this.jyf, gVar, i, i2, i3, 4, cyo()), 200L);
            } else {
                return false;
            }
            return true;
        }
        this.jyg++;
        if (this.jyg <= 2) {
            if (!a(gVar, i, i2, i3, uri, cyo())) {
                if (i == -200) {
                    this.mHandler.postDelayed(new b(this.jyf, gVar, i, i2, i3, this.jyg % 2 == 1 ? 7 : 17, cyo()), 200L);
                    this.jyg = 2;
                } else {
                    this.mHandler.postDelayed(new b(this.jyf, gVar, i, i2, i3, this.jyg % 2 == 1 ? 8 : 18, cyo()), 200L);
                    this.jyg = 4;
                    return false;
                }
            }
            return true;
        } else if (this.jyg <= 4) {
            if (i == -200) {
                this.mHandler.postDelayed(new b(this.jyf, gVar, i, i2, i3, this.jyg % 2 == 1 ? 1 : 11, cyo()), 200L);
                return true;
            }
            return false;
        } else if (this.jyg <= 6 && i == -200) {
            this.mHandler.postDelayed(new b(this.jyf, gVar, i, i2, i3, this.jyg % 2 == 1 ? 2 : 12, cyo()), 200L);
            return true;
        } else {
            return false;
        }
    }

    private int cyo() {
        return (this.jyh * 100) + this.jyg;
    }

    private boolean a(g gVar, int i, int i2, int i3, Uri uri, int i4) {
        if (!cyp() || i == -100 || uri == null || TextUtils.isEmpty(uri.getHost()) || uri.toString().contains("127.0.0.1") || !uri.toString().contains(HttpHost.DEFAULT_SCHEME_NAME)) {
            return false;
        }
        com.baidu.adp.lib.network.http.a.b.gi().a(new C0580a(this.mHandler, this.jyf, i, uri, gVar, i2, i3, i4));
        return com.baidu.adp.lib.network.http.a.b.gi().ao(uri.getHost());
    }

    private boolean cyp() {
        return (SwitchManager.getInstance().findType(VideoHttpDnsSwitch.HTTP_DNS_SWITCH_KEY) == 0 || !j.isNetWorkAvailable() || CustomPlayerSwitch.getSwitchStatus() == 0) ? false : true;
    }

    /* JADX INFO: Access modifiers changed from: private */
    /* renamed from: com.baidu.tieba.play.b.a$a  reason: collision with other inner class name */
    /* loaded from: classes.dex */
    public static class C0580a implements b.InterfaceC0018b {
        private int eCy;
        private c jyf;
        private g jyi;
        private int jyj;
        private int jyk;
        private Handler mHandler;
        private Uri mUri;
        private int what;

        public C0580a(Handler handler, c cVar, int i, Uri uri, g gVar, int i2, int i3, int i4) {
            this.mHandler = handler;
            this.jyf = cVar;
            this.mUri = uri;
            this.jyi = gVar;
            this.jyj = i;
            this.what = i2;
            this.jyk = i3;
            this.eCy = i4;
        }

        @Override // com.baidu.adp.lib.network.http.a.b.InterfaceC0018b
        public void n(String str, String str2) {
            try {
                if (TextUtils.isEmpty(str) || TextUtils.isEmpty(str2) || this.mUri == null || !str2.equals(this.mUri.getHost())) {
                    if (this.mHandler != null) {
                        this.mHandler.postDelayed(new b(this.jyf, this.jyi, this.jyj, this.what, this.jyk, this.eCy % 2 == 1 ? 5 : 15, this.eCy), 200L);
                    }
                } else if (this.mHandler != null) {
                    this.mHandler.postDelayed(new b(this.jyf, this.jyi, this.jyj, this.what, this.jyk, str, this.eCy % 2 == 1 ? 0 : 10, this.eCy), 200L);
                }
            } catch (Throwable th) {
                th.printStackTrace();
                if (this.mHandler != null) {
                    this.mHandler.postDelayed(new b(this.jyf, this.jyi, this.jyj, this.what, this.jyk, this.eCy % 2 == 1 ? 6 : 16, this.eCy), 200L);
                }
            }
        }
    }

    public boolean cyq() {
        boolean z = this.jyg > 0 || this.jyh > 0;
        this.jyg = 0;
        this.jyh = 0;
        return z;
    }

    /* JADX INFO: Access modifiers changed from: private */
    /* loaded from: classes.dex */
    public static class b implements Runnable {
        private final int eCy;
        private final String ip;
        private c jyf;
        private final g jyi;
        private final int jyj;
        private final int jyk;
        private final int type;
        private final int what;

        public b(c cVar, g gVar, int i, int i2, int i3, int i4, int i5) {
            this.jyf = cVar;
            this.jyi = gVar;
            this.jyj = i;
            this.what = i2;
            this.jyk = i3;
            this.type = i4;
            this.eCy = i5;
            this.ip = "";
        }

        public b(c cVar, g gVar, int i, int i2, int i3, String str, int i4, int i5) {
            this.jyf = cVar;
            this.jyi = gVar;
            this.jyj = i;
            this.what = i2;
            this.jyk = i3;
            this.ip = str;
            this.type = i4;
            this.eCy = i5;
        }

        @Override // java.lang.Runnable
        public void run() {
            if (this.jyf != null) {
                if (this.type == 1 || this.type == 5 || this.type == 3 || this.type == 6 || this.type == 7 || this.type == 11 || this.type == 15 || this.type == 16 || this.type == 17) {
                    this.jyf.a(this.jyi, this.jyj, this.what, this.jyk, this.eCy, this.type);
                } else if (this.type == 2 || this.type == 4 || this.type == 8 || this.type == 12 || this.type == 18) {
                    this.jyf.b(this.jyi, this.jyj, this.what, this.jyk, this.eCy, this.type);
                } else if (this.type == 0 || this.type == 10) {
                    this.jyf.a(this.jyi, this.jyj, this.what, this.jyk, this.ip, this.eCy, this.type);
                }
            }
        }
    }

    public void clear() {
        if (this.mHandler != null) {
            this.mHandler.removeCallbacksAndMessages(null);
        }
    }

    public static void GS(String str) {
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
