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
    private boolean kjQ;
    private boolean kjR;
    private final a kjS;
    private final com.baidu.tieba.f.b kjT;
    private a.InterfaceC0623a kjU = new a.InterfaceC0623a() { // from class: com.baidu.tieba.pb.pb.godreply.c.1
        @Override // com.baidu.tieba.f.a.InterfaceC0623a
        public void D(int i, int i2) {
            if (c.this.kjS.isActive() && !c.this.cLR() && !c.this.cLS()) {
                c.this.rZ(true);
                c.this.setFullscreen(true);
                c.this.kjS.cLN().x(new Runnable() { // from class: com.baidu.tieba.pb.pb.godreply.c.1.1
                    @Override // java.lang.Runnable
                    public void run() {
                        c.this.rZ(false);
                    }
                });
            }
        }

        @Override // com.baidu.tieba.f.a.InterfaceC0623a
        public void E(int i, int i2) {
            if (c.this.kjS.isActive() && !c.this.cLR() && c.this.kjS.cLN().cLX() && Math.abs(i2) > c.TOUCH_SLOP) {
                c.this.kjS.w(new Runnable() { // from class: com.baidu.tieba.pb.pb.godreply.c.1.2
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
    private View.OnTouchListener kjV = new View.OnTouchListener() { // from class: com.baidu.tieba.pb.pb.godreply.c.2
        @Override // android.view.View.OnTouchListener
        public boolean onTouch(View view, MotionEvent motionEvent) {
            c.this.kjT.onTouchEvent(motionEvent);
            return false;
        }
    };

    public c(a aVar) {
        this.kjS = aVar;
        this.kjT = new com.baidu.tieba.f.b(aVar.kju.getPageContext().getPageActivity());
        this.kjT.a(this.kjU);
    }

    public void initialize() {
        d cLN = this.kjS.cLN();
        if (cLN.cLU()) {
            cLN.getListView().setOnTouchListener(this.kjV);
        }
    }

    public boolean cLR() {
        return this.kjQ;
    }

    public void rZ(boolean z) {
        this.kjQ = z;
    }

    public boolean cLS() {
        return this.kjR;
    }

    public void setFullscreen(boolean z) {
        this.kjR = z;
    }
}
