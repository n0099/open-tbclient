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
    private final com.baidu.tieba.tbadvert.view.a htr;
    private b hts;
    private Context mContext;
    private final Handler mHandler = new Handler();
    private boolean fVq = true;
    private a.InterfaceC0319a htu = new a.InterfaceC0319a() { // from class: com.baidu.tieba.tbadvert.a.1
        @Override // com.baidu.tieba.tbadvert.b.a.InterfaceC0319a
        public void a(com.baidu.tieba.tbadvert.a.a aVar) {
            if (j.kV()) {
                a.this.htt.bGr();
            } else if (a.this.hts != null) {
                a.this.hts.Qa();
            }
            if (a.this.fVq) {
                a.this.mHandler.postDelayed(new Runnable() { // from class: com.baidu.tieba.tbadvert.a.1.1
                    @Override // java.lang.Runnable
                    public void run() {
                        if (j.kV() && j.kW()) {
                            a.this.htt.bGs();
                        }
                    }
                }, 800L);
            } else if (j.kV() && j.kW()) {
                a.this.htt.bGs();
            }
        }

        @Override // com.baidu.tieba.tbadvert.b.a.InterfaceC0319a
        public void bGl() {
            if (a.this.fVq && a.this.hts != null) {
                a.this.hts.Qa();
            }
        }

        @Override // com.baidu.tieba.tbadvert.b.a.InterfaceC0319a
        public void ak(Object obj) {
            com.baidu.tieba.tbadvert.a.b bGq;
            if (a.this.fVq && (bGq = a.this.htt.bGq()) != null) {
                a.this.htr.f(obj, ((int) bGq.showTime) / 1000);
                if (a.this.hts != null) {
                    a.this.hts.w(String.valueOf(bGq.id), bGq.isFullScreen());
                }
            }
        }
    };
    private a.InterfaceC0320a htv = new a.InterfaceC0320a() { // from class: com.baidu.tieba.tbadvert.a.2
        @Override // com.baidu.tieba.tbadvert.view.a.InterfaceC0320a
        public void bGm() {
            com.baidu.tieba.tbadvert.a.b bGq = a.this.htt.bGq();
            if (bGq != null) {
                if (a.this.hts != null) {
                    a.this.hts.iL(String.valueOf(bGq.id));
                }
                if (!TextUtils.isEmpty(bGq.linkUrl)) {
                    ay.Es().a((TbPageContext) i.aK(a.this.mContext), new String[]{bGq.linkUrl}, true);
                }
            }
        }

        @Override // com.baidu.tieba.tbadvert.view.a.InterfaceC0320a
        public void bGn() {
            if (a.this.hts != null) {
                a.this.hts.wO();
            }
        }
    };
    private final com.baidu.tieba.tbadvert.b.a htt = new com.baidu.tieba.tbadvert.b.a();

    public a(Context context) {
        this.mContext = context;
        this.htt.a(this.htu);
        this.htr = new com.baidu.tieba.tbadvert.view.a(context, this.htv);
    }

    @Override // com.baidu.tbadk.q.a
    public View getView() {
        return this.htr.getView();
    }

    @Override // com.baidu.tbadk.q.a
    public void a(b bVar) {
        this.hts = bVar;
    }

    @Override // com.baidu.tbadk.q.a
    public void PZ() {
        this.htt.bGp();
    }

    @Override // com.baidu.tbadk.q.a
    public void release() {
        this.fVq = false;
        this.mHandler.removeCallbacksAndMessages(null);
    }
}
