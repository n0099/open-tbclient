package com.baidu.tieba.play.b;

import android.net.Uri;
import android.os.Handler;
import android.text.TextUtils;
import com.baidu.adp.lib.asyncTask.BdAsyncTask;
import com.baidu.adp.lib.util.StringUtils;
import com.baidu.adp.lib.util.j;
import com.baidu.tbadk.core.util.m;
import com.baidu.tieba.play.CustomPlayerSwitchStatic;
import com.baidu.tieba.play.a.b;
import com.baidu.tieba.play.g;
import java.io.File;
import org.apache.http.HttpHost;
/* loaded from: classes.dex */
public class a {
    private c ian;
    private int iao = 0;
    private int iap = 0;
    private Handler mHandler = new Handler();

    public a(c cVar) {
        this.ian = cVar;
    }

    public boolean a(g gVar, int i, int i2, int i3, Uri uri) {
        if (this.ian == null) {
            return false;
        }
        if (i == -300) {
            if (this.iap == 0) {
                this.iap++;
                this.mHandler.postDelayed(new b(this.ian, gVar, i, i2, i3, 3, bUl()), 200L);
            } else if (this.iap == 1) {
                this.iap++;
                this.mHandler.postDelayed(new b(this.ian, gVar, i, i2, i3, 4, bUl()), 200L);
            } else {
                return false;
            }
            return true;
        }
        this.iao++;
        if (this.iao <= 2) {
            if (!a(gVar, i, i2, i3, uri, bUl())) {
                if (i == -200) {
                    this.mHandler.postDelayed(new b(this.ian, gVar, i, i2, i3, this.iao % 2 == 1 ? 7 : 17, bUl()), 200L);
                    this.iao = 2;
                } else {
                    this.mHandler.postDelayed(new b(this.ian, gVar, i, i2, i3, this.iao % 2 == 1 ? 8 : 18, bUl()), 200L);
                    this.iao = 4;
                    return false;
                }
            }
            return true;
        } else if (this.iao <= 4) {
            if (i == -200) {
                this.mHandler.postDelayed(new b(this.ian, gVar, i, i2, i3, this.iao % 2 == 1 ? 1 : 11, bUl()), 200L);
                return true;
            }
            return false;
        } else if (this.iao <= 6 && i == -200) {
            this.mHandler.postDelayed(new b(this.ian, gVar, i, i2, i3, this.iao % 2 == 1 ? 2 : 12, bUl()), 200L);
            return true;
        } else {
            return false;
        }
    }

    private int bUl() {
        return (this.iap * 100) + this.iao;
    }

    private boolean a(g gVar, int i, int i2, int i3, Uri uri, int i4) {
        if (!bUm() || i == -100 || uri == null || TextUtils.isEmpty(uri.getHost()) || uri.toString().contains("127.0.0.1") || !uri.toString().contains(HttpHost.DEFAULT_SCHEME_NAME)) {
            return false;
        }
        com.baidu.tieba.play.a.b.bTU().a(new C0367a(this.mHandler, this.ian, i, uri, gVar, i2, i3, i4));
        return com.baidu.tieba.play.a.b.bTU().AU(uri.getHost());
    }

    private boolean bUm() {
        return (com.baidu.adp.lib.b.d.iQ().aO("android_video_http_dns_open") == 0 || !j.kY() || CustomPlayerSwitchStatic.bSy() == 0) ? false : true;
    }

    /* JADX INFO: Access modifiers changed from: private */
    /* renamed from: com.baidu.tieba.play.b.a$a  reason: collision with other inner class name */
    /* loaded from: classes.dex */
    public static class C0367a implements b.InterfaceC0366b {
        private c ian;
        private g iaq;
        private int iar;
        private int ias;
        private Handler mHandler;
        private Uri mUri;
        private int times;
        private int what;

        public C0367a(Handler handler, c cVar, int i, Uri uri, g gVar, int i2, int i3, int i4) {
            this.mHandler = handler;
            this.ian = cVar;
            this.mUri = uri;
            this.iaq = gVar;
            this.iar = i;
            this.what = i2;
            this.ias = i3;
            this.times = i4;
        }

        @Override // com.baidu.tieba.play.a.b.InterfaceC0366b
        public void dG(String str, String str2) {
            try {
                if (TextUtils.isEmpty(str) || TextUtils.isEmpty(str2) || this.mUri == null || !str2.equals(this.mUri.getHost())) {
                    if (this.mHandler != null) {
                        this.mHandler.postDelayed(new b(this.ian, this.iaq, this.iar, this.what, this.ias, this.times % 2 == 1 ? 5 : 15, this.times), 200L);
                    }
                } else if (this.mHandler != null) {
                    this.mHandler.postDelayed(new b(this.ian, this.iaq, this.iar, this.what, this.ias, str, this.times % 2 == 1 ? 0 : 10, this.times), 200L);
                }
            } catch (Throwable th) {
                th.printStackTrace();
                if (this.mHandler != null) {
                    this.mHandler.postDelayed(new b(this.ian, this.iaq, this.iar, this.what, this.ias, this.times % 2 == 1 ? 6 : 16, this.times), 200L);
                }
            }
        }
    }

    public boolean bUn() {
        boolean z = this.iao > 0 || this.iap > 0;
        this.iao = 0;
        this.iap = 0;
        return z;
    }

    /* JADX INFO: Access modifiers changed from: private */
    /* loaded from: classes.dex */
    public static class b implements Runnable {
        private c ian;
        private final g iaq;
        private final int iar;
        private final int ias;
        private final String ip;
        private final int times;
        private final int type;
        private final int what;

        public b(c cVar, g gVar, int i, int i2, int i3, int i4, int i5) {
            this.ian = cVar;
            this.iaq = gVar;
            this.iar = i;
            this.what = i2;
            this.ias = i3;
            this.type = i4;
            this.times = i5;
            this.ip = "";
        }

        public b(c cVar, g gVar, int i, int i2, int i3, String str, int i4, int i5) {
            this.ian = cVar;
            this.iaq = gVar;
            this.iar = i;
            this.what = i2;
            this.ias = i3;
            this.ip = str;
            this.type = i4;
            this.times = i5;
        }

        @Override // java.lang.Runnable
        public void run() {
            if (this.ian != null) {
                if (this.type == 1 || this.type == 5 || this.type == 3 || this.type == 6 || this.type == 7 || this.type == 11 || this.type == 15 || this.type == 16 || this.type == 17) {
                    this.ian.a(this.iaq, this.iar, this.what, this.ias, this.times, this.type);
                } else if (this.type == 2 || this.type == 4 || this.type == 8 || this.type == 12 || this.type == 18) {
                    this.ian.b(this.iaq, this.iar, this.what, this.ias, this.times, this.type);
                } else if (this.type == 0 || this.type == 10) {
                    this.ian.a(this.iaq, this.iar, this.what, this.ias, this.ip, this.times, this.type);
                }
            }
        }
    }

    public void clear() {
        if (this.mHandler != null) {
            this.mHandler.removeCallbacksAndMessages(null);
        }
    }

    public static void AW(String str) {
        if (!StringUtils.isNull(str)) {
            new BdAsyncTask<String, Void, Void>() { // from class: com.baidu.tieba.play.b.a.1
                /* JADX DEBUG: Method merged with bridge method */
                /* JADX INFO: Access modifiers changed from: protected */
                @Override // com.baidu.adp.lib.asyncTask.BdAsyncTask
                public Void doInBackground(String... strArr) {
                    if (strArr != null && strArr.length == 1) {
                        m.G(new File(strArr[0]).getParentFile());
                    }
                    return null;
                }
            }.execute(str);
        }
    }
}
