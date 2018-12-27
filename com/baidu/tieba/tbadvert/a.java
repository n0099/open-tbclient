package com.baidu.tieba.tbadvert;

import android.content.Context;
import android.os.Handler;
import android.text.TextUtils;
import android.view.View;
import com.baidu.adp.base.i;
import com.baidu.adp.lib.util.j;
import com.baidu.tbadk.TbPageContext;
import com.baidu.tbadk.core.util.ay;
import com.baidu.tbadk.q.b;
import com.baidu.tieba.tbadvert.b.a;
import com.baidu.tieba.tbadvert.view.a;
/* loaded from: classes3.dex */
public class a implements com.baidu.tbadk.q.a {
    private final com.baidu.tieba.tbadvert.view.a hsi;
    private b hsj;
    private Context mContext;
    private final Handler mHandler = new Handler();
    private boolean fUs = true;
    private a.InterfaceC0320a hsl = new a.InterfaceC0320a() { // from class: com.baidu.tieba.tbadvert.a.1
        @Override // com.baidu.tieba.tbadvert.b.a.InterfaceC0320a
        public void a(com.baidu.tieba.tbadvert.a.a aVar) {
            if (j.kV()) {
                a.this.hsk.bFI();
            } else if (a.this.hsj != null) {
                a.this.hsj.PI();
            }
            if (a.this.fUs) {
                a.this.mHandler.postDelayed(new Runnable() { // from class: com.baidu.tieba.tbadvert.a.1.1
                    @Override // java.lang.Runnable
                    public void run() {
                        if (j.kV() && j.kW()) {
                            a.this.hsk.bFJ();
                        }
                    }
                }, 800L);
            } else if (j.kV() && j.kW()) {
                a.this.hsk.bFJ();
            }
        }

        @Override // com.baidu.tieba.tbadvert.b.a.InterfaceC0320a
        public void bFC() {
            if (a.this.fUs && a.this.hsj != null) {
                a.this.hsj.PI();
            }
        }

        @Override // com.baidu.tieba.tbadvert.b.a.InterfaceC0320a
        public void ak(Object obj) {
            com.baidu.tieba.tbadvert.a.b bFH;
            if (a.this.fUs && (bFH = a.this.hsk.bFH()) != null) {
                a.this.hsi.f(obj, ((int) bFH.showTime) / 1000);
                if (a.this.hsj != null) {
                    a.this.hsj.w(String.valueOf(bFH.id), bFH.isFullScreen());
                }
            }
        }
    };
    private a.InterfaceC0321a hsm = new a.InterfaceC0321a() { // from class: com.baidu.tieba.tbadvert.a.2
        @Override // com.baidu.tieba.tbadvert.view.a.InterfaceC0321a
        public void bFD() {
            com.baidu.tieba.tbadvert.a.b bFH = a.this.hsk.bFH();
            if (bFH != null) {
                if (a.this.hsj != null) {
                    a.this.hsj.ix(String.valueOf(bFH.id));
                }
                if (!TextUtils.isEmpty(bFH.linkUrl)) {
                    ay.Ef().a((TbPageContext) i.aK(a.this.mContext), new String[]{bFH.linkUrl}, true);
                }
            }
        }

        @Override // com.baidu.tieba.tbadvert.view.a.InterfaceC0321a
        public void bFE() {
            if (a.this.hsj != null) {
                a.this.hsj.wH();
            }
        }
    };
    private final com.baidu.tieba.tbadvert.b.a hsk = new com.baidu.tieba.tbadvert.b.a();

    public a(Context context) {
        this.mContext = context;
        this.hsk.a(this.hsl);
        this.hsi = new com.baidu.tieba.tbadvert.view.a(context, this.hsm);
    }

    @Override // com.baidu.tbadk.q.a
    public View getView() {
        return this.hsi.getView();
    }

    @Override // com.baidu.tbadk.q.a
    public void a(b bVar) {
        this.hsj = bVar;
    }

    @Override // com.baidu.tbadk.q.a
    public void PH() {
        this.hsk.bFG();
    }

    @Override // com.baidu.tbadk.q.a
    public void release() {
        this.fUs = false;
        this.mHandler.removeCallbacksAndMessages(null);
    }
}
