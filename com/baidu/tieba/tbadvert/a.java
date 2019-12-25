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
import com.baidu.tieba.r.c;
import com.baidu.tieba.tbadvert.b.a;
import com.baidu.tieba.tbadvert.view.a;
/* loaded from: classes10.dex */
public class a implements com.baidu.tbadk.r.a {
    private final com.baidu.tieba.tbadvert.view.a kfQ;
    private b kfR;
    private Context mContext;
    private final Handler mHandler = new Handler();
    private boolean isActive = true;
    private a.InterfaceC0602a kfT = new a.InterfaceC0602a() { // from class: com.baidu.tieba.tbadvert.a.1
        @Override // com.baidu.tieba.tbadvert.b.a.InterfaceC0602a
        public void a(com.baidu.tieba.tbadvert.a.a aVar) {
            if (j.isNetWorkAvailable()) {
                a.this.kfS.cJW();
            } else if (a.this.kfR != null) {
                a.this.kfR.aOZ();
            }
            if (a.this.isActive) {
                a.this.mHandler.postDelayed(new Runnable() { // from class: com.baidu.tieba.tbadvert.a.1.1
                    @Override // java.lang.Runnable
                    public void run() {
                        if (j.isNetWorkAvailable() && j.isWifiNet()) {
                            a.this.kfS.cJX();
                        }
                    }
                }, 800L);
            } else if (j.isNetWorkAvailable() && j.isWifiNet()) {
                a.this.kfS.cJX();
            }
        }

        @Override // com.baidu.tieba.tbadvert.b.a.InterfaceC0602a
        public void cJQ() {
            if (a.this.isActive && a.this.kfR != null) {
                a.this.kfR.aOZ();
            }
        }

        @Override // com.baidu.tieba.tbadvert.b.a.InterfaceC0602a
        public void az(Object obj) {
            com.baidu.tieba.tbadvert.a.b cJV;
            if (a.this.isActive && (cJV = a.this.kfS.cJV()) != null) {
                an b = com.baidu.tieba.r.a.b("a064", "common_fill", true, 1);
                if (i.ab(a.this.mContext) != null) {
                    c.cHo().b(i.ab(a.this.mContext).getUniqueId(), b);
                }
                a.this.kfQ.e(obj, ((int) cJV.showTime) / 1000);
                if (a.this.kfR != null) {
                    a.this.kfR.g(String.valueOf(cJV.id), cJV.aWx(), cJV.isFullScreen());
                }
            }
        }
    };
    private a.InterfaceC0603a kfU = new a.InterfaceC0603a() { // from class: com.baidu.tieba.tbadvert.a.2
        @Override // com.baidu.tieba.tbadvert.view.a.InterfaceC0603a
        public void cJR() {
            com.baidu.tieba.tbadvert.a.b cJV = a.this.kfS.cJV();
            if (cJV != null) {
                if (a.this.kfR != null) {
                    a.this.kfR.V(String.valueOf(cJV.id), cJV.aWx());
                }
                if (!TextUtils.isEmpty(cJV.linkUrl)) {
                    if (!a.this.IY(cJV.linkUrl)) {
                        ba.aEa().a((TbPageContext) i.ab(a.this.mContext), new String[]{cJV.linkUrl}, true);
                        return;
                    }
                    final String str = cJV.linkUrl;
                    e.gy().postDelayed(new Runnable() { // from class: com.baidu.tieba.tbadvert.a.2.1
                        @Override // java.lang.Runnable
                        public void run() {
                            ba.aEa().a((TbPageContext) i.ab(com.baidu.adp.base.a.eG().currentActivity()), new String[]{str}, true);
                        }
                    }, 500L);
                }
            }
        }

        @Override // com.baidu.tieba.tbadvert.view.a.InterfaceC0603a
        public void cJS() {
            if (a.this.kfR != null) {
                a.this.kfR.awt();
            }
        }
    };
    private final com.baidu.tieba.tbadvert.b.a kfS = new com.baidu.tieba.tbadvert.b.a();

    public a(Context context) {
        this.mContext = context;
        this.kfS.a(this.kfT);
        this.kfQ = new com.baidu.tieba.tbadvert.view.a(context, this.kfU);
    }

    /* JADX INFO: Access modifiers changed from: private */
    public boolean IY(String str) {
        if (TextUtils.isEmpty(str)) {
            return false;
        }
        return (str.contains("/swan/") || str.contains("/swangame/")) && !com.baidu.k.a.a.checkPermissionGranted(com.baidu.adp.base.a.eG().currentActivity(), "android.permission.WRITE_EXTERNAL_STORAGE");
    }

    @Override // com.baidu.tbadk.r.a
    public View getView() {
        return this.kfQ.getView();
    }

    @Override // com.baidu.tbadk.r.a
    public void a(b bVar) {
        this.kfR = bVar;
    }

    @Override // com.baidu.tbadk.r.a
    public void aOY() {
        this.kfS.cJU();
    }

    @Override // com.baidu.tbadk.r.a
    public void release() {
        this.isActive = false;
        this.mHandler.removeCallbacksAndMessages(null);
    }
}
