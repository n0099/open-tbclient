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
    private final com.baidu.tieba.tbadvert.view.a kkI;
    private b kkJ;
    private Context mContext;
    private final Handler mHandler = new Handler();
    private boolean isActive = true;
    private a.InterfaceC0615a kkL = new a.InterfaceC0615a() { // from class: com.baidu.tieba.tbadvert.a.1
        @Override // com.baidu.tieba.tbadvert.b.a.InterfaceC0615a
        public void a(com.baidu.tieba.tbadvert.a.a aVar) {
            if (j.isNetWorkAvailable()) {
                a.this.kkK.cMA();
            } else if (a.this.kkJ != null) {
                a.this.kkJ.aRL();
            }
            if (a.this.isActive) {
                a.this.mHandler.postDelayed(new Runnable() { // from class: com.baidu.tieba.tbadvert.a.1.1
                    @Override // java.lang.Runnable
                    public void run() {
                        if (j.isNetWorkAvailable() && j.isWifiNet()) {
                            a.this.kkK.cMB();
                        }
                    }
                }, 800L);
            } else if (j.isNetWorkAvailable() && j.isWifiNet()) {
                a.this.kkK.cMB();
            }
        }

        @Override // com.baidu.tieba.tbadvert.b.a.InterfaceC0615a
        public void cMu() {
            if (a.this.isActive && a.this.kkJ != null) {
                a.this.kkJ.aRL();
            }
        }

        @Override // com.baidu.tieba.tbadvert.b.a.InterfaceC0615a
        public void aB(Object obj) {
            com.baidu.tieba.tbadvert.a.b cMz;
            if (a.this.isActive && (cMz = a.this.kkK.cMz()) != null) {
                an b = com.baidu.tieba.s.a.b("a064", "common_fill", true, 1);
                if (i.ab(a.this.mContext) != null) {
                    c.cKb().b(i.ab(a.this.mContext).getUniqueId(), b);
                }
                a.this.kkI.e(obj, ((int) cMz.showTime) / 1000);
                if (a.this.kkJ != null) {
                    a.this.kkJ.g(String.valueOf(cMz.id), cMz.aZj(), cMz.isFullScreen());
                }
            }
        }
    };
    private a.InterfaceC0616a kkM = new a.InterfaceC0616a() { // from class: com.baidu.tieba.tbadvert.a.2
        @Override // com.baidu.tieba.tbadvert.view.a.InterfaceC0616a
        public void cMv() {
            com.baidu.tieba.tbadvert.a.b cMz = a.this.kkK.cMz();
            if (cMz != null) {
                if (a.this.kkJ != null) {
                    a.this.kkJ.V(String.valueOf(cMz.id), cMz.aZj());
                }
                if (!TextUtils.isEmpty(cMz.linkUrl)) {
                    if (!a.this.Jw(cMz.linkUrl)) {
                        ba.aGG().a((TbPageContext) i.ab(a.this.mContext), new String[]{cMz.linkUrl}, true);
                        return;
                    }
                    final String str = cMz.linkUrl;
                    e.gx().postDelayed(new Runnable() { // from class: com.baidu.tieba.tbadvert.a.2.1
                        @Override // java.lang.Runnable
                        public void run() {
                            ba.aGG().a((TbPageContext) i.ab(com.baidu.adp.base.a.eH().currentActivity()), new String[]{str}, true);
                        }
                    }, 500L);
                }
            }
        }

        @Override // com.baidu.tieba.tbadvert.view.a.InterfaceC0616a
        public void cMw() {
            if (a.this.kkJ != null) {
                a.this.kkJ.azb();
            }
        }
    };
    private final com.baidu.tieba.tbadvert.b.a kkK = new com.baidu.tieba.tbadvert.b.a();

    public a(Context context) {
        this.mContext = context;
        this.kkK.a(this.kkL);
        this.kkI = new com.baidu.tieba.tbadvert.view.a(context, this.kkM);
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
        return this.kkI.getView();
    }

    @Override // com.baidu.tbadk.r.a
    public void a(b bVar) {
        this.kkJ = bVar;
    }

    @Override // com.baidu.tbadk.r.a
    public void aRK() {
        this.kkK.cMy();
    }

    @Override // com.baidu.tbadk.r.a
    public void release() {
        this.isActive = false;
        this.mHandler.removeCallbacksAndMessages(null);
    }
}
