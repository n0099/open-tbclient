package com.baidu.tieba.tbadvert;

import android.content.Context;
import android.os.Handler;
import android.text.TextUtils;
import android.view.View;
import com.baidu.adp.base.i;
import com.baidu.adp.lib.f.e;
import com.baidu.adp.lib.util.j;
import com.baidu.tbadk.TbPageContext;
import com.baidu.tbadk.core.util.an;
import com.baidu.tbadk.core.util.ba;
import com.baidu.tbadk.r.b;
import com.baidu.tieba.s.c;
import com.baidu.tieba.tbadvert.b.a;
import com.baidu.tieba.tbadvert.view.a;
/* loaded from: classes13.dex */
public class a implements com.baidu.tbadk.r.a {
    private final com.baidu.tieba.tbadvert.view.a kmk;
    private b kml;
    private Context mContext;
    private final Handler mHandler = new Handler();
    private boolean isActive = true;
    private a.InterfaceC0616a kmn = new a.InterfaceC0616a() { // from class: com.baidu.tieba.tbadvert.a.1
        @Override // com.baidu.tieba.tbadvert.b.a.InterfaceC0616a
        public void a(com.baidu.tieba.tbadvert.a.a aVar) {
            if (j.isNetWorkAvailable()) {
                a.this.kmm.cMU();
            } else if (a.this.kml != null) {
                a.this.kml.aRP();
            }
            if (a.this.isActive) {
                a.this.mHandler.postDelayed(new Runnable() { // from class: com.baidu.tieba.tbadvert.a.1.1
                    @Override // java.lang.Runnable
                    public void run() {
                        if (j.isNetWorkAvailable() && j.isWifiNet()) {
                            a.this.kmm.cMV();
                        }
                    }
                }, 800L);
            } else if (j.isNetWorkAvailable() && j.isWifiNet()) {
                a.this.kmm.cMV();
            }
        }

        @Override // com.baidu.tieba.tbadvert.b.a.InterfaceC0616a
        public void cMO() {
            if (a.this.isActive && a.this.kml != null) {
                a.this.kml.aRP();
            }
        }

        @Override // com.baidu.tieba.tbadvert.b.a.InterfaceC0616a
        public void aB(Object obj) {
            com.baidu.tieba.tbadvert.a.b cMT;
            if (a.this.isActive && (cMT = a.this.kmm.cMT()) != null) {
                an b = com.baidu.tieba.s.a.b("a064", "common_fill", true, 1);
                if (i.ab(a.this.mContext) != null) {
                    c.cKv().b(i.ab(a.this.mContext).getUniqueId(), b);
                }
                a.this.kmk.e(obj, ((int) cMT.showTime) / 1000);
                if (a.this.kml != null) {
                    a.this.kml.g(String.valueOf(cMT.id), cMT.aZn(), cMT.isFullScreen());
                }
            }
        }
    };
    private a.InterfaceC0617a kmo = new a.InterfaceC0617a() { // from class: com.baidu.tieba.tbadvert.a.2
        @Override // com.baidu.tieba.tbadvert.view.a.InterfaceC0617a
        public void cMP() {
            com.baidu.tieba.tbadvert.a.b cMT = a.this.kmm.cMT();
            if (cMT != null) {
                if (a.this.kml != null) {
                    a.this.kml.V(String.valueOf(cMT.id), cMT.aZn());
                }
                if (!TextUtils.isEmpty(cMT.linkUrl)) {
                    if (!a.this.Jw(cMT.linkUrl)) {
                        ba.aGK().a((TbPageContext) i.ab(a.this.mContext), new String[]{cMT.linkUrl}, true);
                        return;
                    }
                    final String str = cMT.linkUrl;
                    e.gx().postDelayed(new Runnable() { // from class: com.baidu.tieba.tbadvert.a.2.1
                        @Override // java.lang.Runnable
                        public void run() {
                            ba.aGK().a((TbPageContext) i.ab(com.baidu.adp.base.a.eH().currentActivity()), new String[]{str}, true);
                        }
                    }, 500L);
                }
            }
        }

        @Override // com.baidu.tieba.tbadvert.view.a.InterfaceC0617a
        public void cMQ() {
            if (a.this.kml != null) {
                a.this.kml.aze();
            }
        }
    };
    private final com.baidu.tieba.tbadvert.b.a kmm = new com.baidu.tieba.tbadvert.b.a();

    public a(Context context) {
        this.mContext = context;
        this.kmm.a(this.kmn);
        this.kmk = new com.baidu.tieba.tbadvert.view.a(context, this.kmo);
    }

    /* JADX INFO: Access modifiers changed from: private */
    public boolean Jw(String str) {
        if (TextUtils.isEmpty(str)) {
            return false;
        }
        return (str.contains("/swan/") || str.contains("/swangame/")) && !com.baidu.k.a.a.checkPermissionGranted(com.baidu.adp.base.a.eH().currentActivity(), "android.permission.WRITE_EXTERNAL_STORAGE");
    }

    @Override // com.baidu.tbadk.r.a
    public View getView() {
        return this.kmk.getView();
    }

    @Override // com.baidu.tbadk.r.a
    public void a(b bVar) {
        this.kml = bVar;
    }

    @Override // com.baidu.tbadk.r.a
    public void aRO() {
        this.kmm.cMS();
    }

    @Override // com.baidu.tbadk.r.a
    public void release() {
        this.isActive = false;
        this.mHandler.removeCallbacksAndMessages(null);
    }
}
