package com.baidu.tieba.pb.pb.godreply;

import android.view.MotionEvent;
import android.view.View;
import com.baidu.adp.lib.util.l;
import com.baidu.tbadk.core.TbadkCoreApplication;
import com.baidu.tieba.R;
import com.baidu.tieba.f.a;
/* loaded from: classes16.dex */
public class c {
    private static final int TOUCH_SLOP = l.getDimens(TbadkCoreApplication.getInst(), R.dimen.ds20);
    private boolean kjO;
    private boolean kjP;
    private final a kjQ;
    private final com.baidu.tieba.f.b kjR;
    private a.InterfaceC0623a kjS = new a.InterfaceC0623a() { // from class: com.baidu.tieba.pb.pb.godreply.c.1
        @Override // com.baidu.tieba.f.a.InterfaceC0623a
        public void D(int i, int i2) {
            if (c.this.kjQ.isActive() && !c.this.cLR() && !c.this.cLS()) {
                c.this.rZ(true);
                c.this.setFullscreen(true);
                c.this.kjQ.cLN().x(new Runnable() { // from class: com.baidu.tieba.pb.pb.godreply.c.1.1
                    @Override // java.lang.Runnable
                    public void run() {
                        c.this.rZ(false);
                    }
                });
            }
        }

        @Override // com.baidu.tieba.f.a.InterfaceC0623a
        public void E(int i, int i2) {
            if (c.this.kjQ.isActive() && !c.this.cLR() && c.this.kjQ.cLN().cLX() && Math.abs(i2) > c.TOUCH_SLOP) {
                c.this.kjQ.w(new Runnable() { // from class: com.baidu.tieba.pb.pb.godreply.c.1.2
                    @Override // java.lang.Runnable
                    public void run() {
                        c.this.rZ(false);
                    }
                });
                c.this.rZ(true);
                c.this.setFullscreen(false);
            }
        }

        @Override // com.baidu.tieba.f.a.InterfaceC0623a
        public void bR(int i, int i2) {
        }

        @Override // com.baidu.tieba.f.a.InterfaceC0623a
        public void F(int i, int i2) {
        }
    };
    private View.OnTouchListener kjT = new View.OnTouchListener() { // from class: com.baidu.tieba.pb.pb.godreply.c.2
        @Override // android.view.View.OnTouchListener
        public boolean onTouch(View view, MotionEvent motionEvent) {
            c.this.kjR.onTouchEvent(motionEvent);
            return false;
        }
    };

    public c(a aVar) {
        this.kjQ = aVar;
        this.kjR = new com.baidu.tieba.f.b(aVar.kjs.getPageContext().getPageActivity());
        this.kjR.a(this.kjS);
    }

    public void initialize() {
        d cLN = this.kjQ.cLN();
        if (cLN.cLU()) {
            cLN.getListView().setOnTouchListener(this.kjT);
        }
    }

    public boolean cLR() {
        return this.kjO;
    }

    public void rZ(boolean z) {
        this.kjO = z;
    }

    public boolean cLS() {
        return this.kjP;
    }

    public void setFullscreen(boolean z) {
        this.kjP = z;
    }
}
