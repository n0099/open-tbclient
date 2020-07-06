package com.baidu.tieba.tbadvert;

import android.content.Context;
import android.os.Handler;
import android.text.TextUtils;
import android.view.View;
import com.baidu.adp.base.i;
import com.baidu.adp.lib.f.e;
import com.baidu.adp.lib.util.j;
import com.baidu.tbadk.TbPageContext;
import com.baidu.tbadk.core.util.ao;
import com.baidu.tbadk.core.util.bc;
import com.baidu.tbadk.s.b;
import com.baidu.tieba.s.c;
import com.baidu.tieba.tbadvert.b.a;
import com.baidu.tieba.tbadvert.view.a;
/* loaded from: classes13.dex */
public class a implements com.baidu.tbadk.s.a {
    private final com.baidu.tieba.tbadvert.view.a lJW;
    private b lJX;
    private Context mContext;
    private final Handler mHandler = new Handler();
    private boolean isActive = true;
    private a.InterfaceC0748a lJZ = new a.InterfaceC0748a() { // from class: com.baidu.tieba.tbadvert.a.1
        @Override // com.baidu.tieba.tbadvert.b.a.InterfaceC0748a
        public void a(com.baidu.tieba.tbadvert.a.a aVar) {
            if (j.isNetWorkAvailable()) {
                a.this.lJY.djE();
            } else if (a.this.lJX != null) {
                a.this.lJX.Pa();
            }
            if (a.this.isActive) {
                a.this.mHandler.postDelayed(new Runnable() { // from class: com.baidu.tieba.tbadvert.a.1.1
                    @Override // java.lang.Runnable
                    public void run() {
                        if (j.isNetWorkAvailable() && j.isWifiNet()) {
                            a.this.lJY.djF();
                        }
                    }
                }, 800L);
            } else if (j.isNetWorkAvailable() && j.isWifiNet()) {
                a.this.lJY.djF();
            }
        }

        @Override // com.baidu.tieba.tbadvert.b.a.InterfaceC0748a
        public void djy() {
            if (a.this.isActive && a.this.lJX != null) {
                a.this.lJX.Pa();
            }
        }

        @Override // com.baidu.tieba.tbadvert.b.a.InterfaceC0748a
        public void aI(Object obj) {
            com.baidu.tieba.tbadvert.a.b djD;
            if (a.this.isActive && (djD = a.this.lJY.djD()) != null) {
                ao b = com.baidu.tieba.s.a.b("a064", "common_fill", true, 1);
                if (i.G(a.this.mContext) != null) {
                    c.dgY().b(i.G(a.this.mContext).getUniqueId(), b);
                }
                a.this.lJW.f(obj, ((int) djD.showTime) / 1000);
                if (a.this.lJX != null) {
                    a.this.lJX.g(String.valueOf(djD.id), djD.bqd(), djD.isFullScreen());
                }
            }
        }
    };
    private a.InterfaceC0749a lKa = new a.InterfaceC0749a() { // from class: com.baidu.tieba.tbadvert.a.2
        @Override // com.baidu.tieba.tbadvert.view.a.InterfaceC0749a
        public void djz() {
            com.baidu.tieba.tbadvert.a.b djD = a.this.lJY.djD();
            if (djD != null) {
                if (a.this.lJX != null) {
                    a.this.lJX.ap(String.valueOf(djD.id), djD.bqd());
                }
                if (!TextUtils.isEmpty(djD.linkUrl)) {
                    if (!a.this.Ny(djD.linkUrl)) {
                        bc.aWU().a((TbPageContext) i.G(a.this.mContext), new String[]{djD.linkUrl}, true);
                        return;
                    }
                    final String str = djD.linkUrl;
                    e.lt().postDelayed(new Runnable() { // from class: com.baidu.tieba.tbadvert.a.2.1
                        @Override // java.lang.Runnable
                        public void run() {
                            bc.aWU().a((TbPageContext) i.G(com.baidu.adp.base.a.jC().currentActivity()), new String[]{str}, true);
                        }
                    }, 500L);
                }
            }
        }

        @Override // com.baidu.tieba.tbadvert.view.a.InterfaceC0749a
        public void djA() {
            if (a.this.lJX != null) {
                a.this.lJX.aOE();
            }
        }
    };
    private final com.baidu.tieba.tbadvert.b.a lJY = new com.baidu.tieba.tbadvert.b.a();

    public a(Context context) {
        this.mContext = context;
        this.lJY.a(this.lJZ);
        this.lJW = new com.baidu.tieba.tbadvert.view.a(context, this.lKa);
    }

    /* JADX INFO: Access modifiers changed from: private */
    public boolean Ny(String str) {
        if (TextUtils.isEmpty(str)) {
            return false;
        }
        return (str.contains("/swan/") || str.contains("/swangame/")) && !com.baidu.h.a.a.checkPermissionGranted(com.baidu.adp.base.a.jC().currentActivity(), "android.permission.WRITE_EXTERNAL_STORAGE");
    }

    @Override // com.baidu.tbadk.s.a
    public View getView() {
        return this.lJW.getView();
    }

    @Override // com.baidu.tbadk.s.a
    public void a(b bVar) {
        this.lJX = bVar;
    }

    @Override // com.baidu.tbadk.s.a
    public void biv() {
        this.lJY.djC();
    }

    @Override // com.baidu.tbadk.s.a
    public void release() {
        this.isActive = false;
        this.mHandler.removeCallbacksAndMessages(null);
    }
}
