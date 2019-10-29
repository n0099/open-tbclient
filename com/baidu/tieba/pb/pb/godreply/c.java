package com.baidu.tieba.pb.pb.godreply;

import android.view.MotionEvent;
import android.view.View;
import com.baidu.adp.lib.util.l;
import com.baidu.tbadk.core.TbadkCoreApplication;
import com.baidu.tieba.R;
import com.baidu.tieba.f.a;
/* loaded from: classes4.dex */
public class c {
    private static final int TOUCH_SLOP = l.getDimens(TbadkCoreApplication.getInst(), R.dimen.ds20);
    private boolean hKT;
    private boolean hKU;
    private final a hKV;
    private final com.baidu.tieba.f.b hKW;
    private a.InterfaceC0405a hKX = new a.InterfaceC0405a() { // from class: com.baidu.tieba.pb.pb.godreply.c.1
        @Override // com.baidu.tieba.f.a.InterfaceC0405a
        public void v(int i, int i2) {
            if (c.this.hKV.isActive() && !c.this.bRH() && c.this.hKV.bRD().bRN() && Math.abs(i2) > c.TOUCH_SLOP) {
                c.this.hKV.n(new Runnable() { // from class: com.baidu.tieba.pb.pb.godreply.c.1.1
                    @Override // java.lang.Runnable
                    public void run() {
                        c.this.nW(false);
                    }
                });
                c.this.nW(true);
                c.this.setFullscreen(false);
            }
        }

        @Override // com.baidu.tieba.f.a.InterfaceC0405a
        public void w(int i, int i2) {
            if (c.this.hKV.isActive() && !c.this.bRH() && !c.this.bRI()) {
                c.this.nW(true);
                c.this.setFullscreen(true);
                c.this.hKV.bRD().o(new Runnable() { // from class: com.baidu.tieba.pb.pb.godreply.c.1.2
                    @Override // java.lang.Runnable
                    public void run() {
                        c.this.nW(false);
                    }
                });
            }
        }

        @Override // com.baidu.tieba.f.a.InterfaceC0405a
        public void x(int i, int i2) {
        }
    };
    private View.OnTouchListener hKY = new View.OnTouchListener() { // from class: com.baidu.tieba.pb.pb.godreply.c.2
        @Override // android.view.View.OnTouchListener
        public boolean onTouch(View view, MotionEvent motionEvent) {
            c.this.hKW.onTouchEvent(motionEvent);
            return false;
        }
    };

    public c(a aVar) {
        this.hKV = aVar;
        this.hKW = new com.baidu.tieba.f.b(aVar.hKw.getPageContext().getPageActivity());
        this.hKW.a(this.hKX);
    }

    public void initialize() {
        d bRD = this.hKV.bRD();
        if (bRD.bRK()) {
            bRD.getListView().setOnTouchListener(this.hKY);
        }
    }

    public boolean bRH() {
        return this.hKT;
    }

    public void nW(boolean z) {
        this.hKT = z;
    }

    public boolean bRI() {
        return this.hKU;
    }

    public void setFullscreen(boolean z) {
        this.hKU = z;
    }
}
