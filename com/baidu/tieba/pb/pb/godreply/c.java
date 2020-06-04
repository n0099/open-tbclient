package com.baidu.tieba.pb.pb.godreply;

import android.view.MotionEvent;
import android.view.View;
import com.baidu.adp.lib.util.l;
import com.baidu.tbadk.core.TbadkCoreApplication;
import com.baidu.tieba.R;
import com.baidu.tieba.f.a;
/* loaded from: classes9.dex */
public class c {
    private static final int TOUCH_SLOP = l.getDimens(TbadkCoreApplication.getInst(), R.dimen.ds20);
    private boolean jHA;
    private boolean jHB;
    private final a jHC;
    private final com.baidu.tieba.f.b jHD;
    private a.InterfaceC0607a jHE = new a.InterfaceC0607a() { // from class: com.baidu.tieba.pb.pb.godreply.c.1
        @Override // com.baidu.tieba.f.a.InterfaceC0607a
        public void B(int i, int i2) {
            if (c.this.jHC.isActive() && !c.this.cDQ() && !c.this.cDR()) {
                c.this.rh(true);
                c.this.setFullscreen(true);
                c.this.jHC.cDM().y(new Runnable() { // from class: com.baidu.tieba.pb.pb.godreply.c.1.1
                    @Override // java.lang.Runnable
                    public void run() {
                        c.this.rh(false);
                    }
                });
            }
        }

        @Override // com.baidu.tieba.f.a.InterfaceC0607a
        public void C(int i, int i2) {
            if (c.this.jHC.isActive() && !c.this.cDQ() && c.this.jHC.cDM().cDW() && Math.abs(i2) > c.TOUCH_SLOP) {
                c.this.jHC.x(new Runnable() { // from class: com.baidu.tieba.pb.pb.godreply.c.1.2
                    @Override // java.lang.Runnable
                    public void run() {
                        c.this.rh(false);
                    }
                });
                c.this.rh(true);
                c.this.setFullscreen(false);
            }
        }

        @Override // com.baidu.tieba.f.a.InterfaceC0607a
        public void bK(int i, int i2) {
        }

        @Override // com.baidu.tieba.f.a.InterfaceC0607a
        public void D(int i, int i2) {
        }
    };
    private View.OnTouchListener jHF = new View.OnTouchListener() { // from class: com.baidu.tieba.pb.pb.godreply.c.2
        @Override // android.view.View.OnTouchListener
        public boolean onTouch(View view, MotionEvent motionEvent) {
            c.this.jHD.onTouchEvent(motionEvent);
            return false;
        }
    };

    public c(a aVar) {
        this.jHC = aVar;
        this.jHD = new com.baidu.tieba.f.b(aVar.jHe.getPageContext().getPageActivity());
        this.jHD.a(this.jHE);
    }

    public void initialize() {
        d cDM = this.jHC.cDM();
        if (cDM.cDT()) {
            cDM.getListView().setOnTouchListener(this.jHF);
        }
    }

    public boolean cDQ() {
        return this.jHA;
    }

    public void rh(boolean z) {
        this.jHA = z;
    }

    public boolean cDR() {
        return this.jHB;
    }

    public void setFullscreen(boolean z) {
        this.jHB = z;
    }
}
