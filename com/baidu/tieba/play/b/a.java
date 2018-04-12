package com.baidu.tieba.play.b;

import android.net.Uri;
import android.os.Handler;
import android.text.TextUtils;
import com.baidu.adp.lib.asyncTask.BdAsyncTask;
import com.baidu.adp.lib.util.StringUtils;
import com.baidu.adp.lib.util.j;
import com.baidu.tbadk.core.util.k;
import com.baidu.tieba.play.CustomPlayerSwitchStatic;
import com.baidu.tieba.play.a.b;
import com.baidu.tieba.play.g;
import java.io.File;
import org.apache.http.HttpHost;
/* loaded from: classes.dex */
public class a {
    private c fRi;
    private int fRj = 0;
    private int fRk = 0;
    private Handler mHandler = new Handler();

    public a(c cVar) {
        this.fRi = cVar;
    }

    public boolean a(g gVar, int i, int i2, int i3, Uri uri) {
        if (this.fRi == null) {
            return false;
        }
        if (i == -300) {
            if (this.fRk == 0) {
                this.fRk++;
                this.mHandler.postDelayed(new b(this.fRi, gVar, i, i2, i3, 3, bhf()), 200L);
            } else if (this.fRk == 1) {
                this.fRk++;
                this.mHandler.postDelayed(new b(this.fRi, gVar, i, i2, i3, 4, bhf()), 200L);
            } else {
                return false;
            }
            return true;
        }
        this.fRj++;
        if (this.fRj <= 2) {
            if (!a(gVar, i, i2, i3, uri, bhf())) {
                if (i == -200) {
                    this.mHandler.postDelayed(new b(this.fRi, gVar, i, i2, i3, this.fRj % 2 == 1 ? 7 : 17, bhf()), 200L);
                    this.fRj = 2;
                } else {
                    this.mHandler.postDelayed(new b(this.fRi, gVar, i, i2, i3, this.fRj % 2 == 1 ? 8 : 18, bhf()), 200L);
                    this.fRj = 4;
                    return false;
                }
            }
            return true;
        } else if (this.fRj <= 4) {
            if (i == -200) {
                this.mHandler.postDelayed(new b(this.fRi, gVar, i, i2, i3, this.fRj % 2 == 1 ? 1 : 11, bhf()), 200L);
                return true;
            }
            return false;
        } else if (this.fRj <= 6 && i == -200) {
            this.mHandler.postDelayed(new b(this.fRi, gVar, i, i2, i3, this.fRj % 2 == 1 ? 2 : 12, bhf()), 200L);
            return true;
        } else {
            return false;
        }
    }

    private int bhf() {
        return (this.fRk * 100) + this.fRj;
    }

    private boolean a(g gVar, int i, int i2, int i3, Uri uri, int i4) {
        if (!bhg() || i == -100 || uri == null || TextUtils.isEmpty(uri.getHost()) || uri.toString().contains("127.0.0.1") || !uri.toString().contains(HttpHost.DEFAULT_SCHEME_NAME)) {
            return false;
        }
        com.baidu.tieba.play.a.b.bhe().a(new C0200a(this.mHandler, this.fRi, i, uri, gVar, i2, i3, i4));
        return com.baidu.tieba.play.a.b.bhe().rt(uri.getHost());
    }

    private boolean bhg() {
        return (com.baidu.adp.lib.b.d.eE().ak("android_video_http_dns_open") == 0 || !j.gP() || CustomPlayerSwitchStatic.bfR() == 0) ? false : true;
    }

    /* JADX INFO: Access modifiers changed from: private */
    /* renamed from: com.baidu.tieba.play.b.a$a  reason: collision with other inner class name */
    /* loaded from: classes.dex */
    public static class C0200a implements b.InterfaceC0199b {
        private int agt;
        private c fRi;
        private g fRl;
        private int fRm;
        private int fRn;
        private Handler mHandler;
        private Uri mUri;
        private int what;

        public C0200a(Handler handler, c cVar, int i, Uri uri, g gVar, int i2, int i3, int i4) {
            this.mHandler = handler;
            this.fRi = cVar;
            this.mUri = uri;
            this.fRl = gVar;
            this.fRm = i;
            this.what = i2;
            this.fRn = i3;
            this.agt = i4;
        }

        @Override // com.baidu.tieba.play.a.b.InterfaceC0199b
        public void bN(String str, String str2) {
            try {
                if (TextUtils.isEmpty(str) || TextUtils.isEmpty(str2) || this.mUri == null || !str2.equals(this.mUri.getHost())) {
                    if (this.mHandler != null) {
                        this.mHandler.postDelayed(new b(this.fRi, this.fRl, this.fRm, this.what, this.fRn, this.agt % 2 == 1 ? 5 : 15, this.agt), 200L);
                    }
                } else if (this.mHandler != null) {
                    this.mHandler.postDelayed(new b(this.fRi, this.fRl, this.fRm, this.what, this.fRn, str, this.agt % 2 == 1 ? 0 : 10, this.agt), 200L);
                }
            } catch (Throwable th) {
                th.printStackTrace();
                if (this.mHandler != null) {
                    this.mHandler.postDelayed(new b(this.fRi, this.fRl, this.fRm, this.what, this.fRn, this.agt % 2 == 1 ? 6 : 16, this.agt), 200L);
                }
            }
        }
    }

    public boolean bhh() {
        boolean z = this.fRj > 0 || this.fRk > 0;
        this.fRj = 0;
        this.fRk = 0;
        return z;
    }

    /* JADX INFO: Access modifiers changed from: private */
    /* loaded from: classes.dex */
    public static class b implements Runnable {
        private final int agt;
        private c fRi;
        private final g fRl;
        private final int fRm;
        private final int fRn;
        private final String ip;
        private final int type;
        private final int what;

        public b(c cVar, g gVar, int i, int i2, int i3, int i4, int i5) {
            this.fRi = cVar;
            this.fRl = gVar;
            this.fRm = i;
            this.what = i2;
            this.fRn = i3;
            this.type = i4;
            this.agt = i5;
            this.ip = "";
        }

        public b(c cVar, g gVar, int i, int i2, int i3, String str, int i4, int i5) {
            this.fRi = cVar;
            this.fRl = gVar;
            this.fRm = i;
            this.what = i2;
            this.fRn = i3;
            this.ip = str;
            this.type = i4;
            this.agt = i5;
        }

        @Override // java.lang.Runnable
        public void run() {
            if (this.fRi != null) {
                if (this.type == 1 || this.type == 5 || this.type == 3 || this.type == 6 || this.type == 7 || this.type == 11 || this.type == 15 || this.type == 16 || this.type == 17) {
                    this.fRi.a(this.fRl, this.fRm, this.what, this.fRn, this.agt, this.type);
                } else if (this.type == 2 || this.type == 4 || this.type == 8 || this.type == 12 || this.type == 18) {
                    this.fRi.b(this.fRl, this.fRm, this.what, this.fRn, this.agt, this.type);
                } else if (this.type == 0 || this.type == 10) {
                    this.fRi.a(this.fRl, this.fRm, this.what, this.fRn, this.ip, this.agt, this.type);
                }
            }
        }
    }

    public void clear() {
        if (this.mHandler != null) {
            this.mHandler.removeCallbacksAndMessages(null);
        }
    }

    public static void rv(String str) {
        if (!StringUtils.isNull(str)) {
            new BdAsyncTask<String, Void, Void>() { // from class: com.baidu.tieba.play.b.a.1
                /* JADX DEBUG: Method merged with bridge method */
                /* JADX INFO: Access modifiers changed from: protected */
                @Override // com.baidu.adp.lib.asyncTask.BdAsyncTask
                public Void doInBackground(String... strArr) {
                    if (strArr != null && strArr.length == 1) {
                        k.r(new File(strArr[0]).getParentFile());
                    }
                    return null;
                }
            }.execute(str);
        }
    }
}
