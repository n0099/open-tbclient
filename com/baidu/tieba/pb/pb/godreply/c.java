package com.baidu.tieba.pb.pb.godreply;

import android.view.MotionEvent;
import android.view.View;
import com.baidu.adp.lib.util.l;
import com.baidu.tbadk.core.TbadkCoreApplication;
import com.baidu.tieba.R;
import com.baidu.tieba.f.a;
/* loaded from: classes2.dex */
public class c {
    private static final int TOUCH_SLOP = l.getDimens(TbadkCoreApplication.getInst(), R.dimen.ds20);
    private boolean lPd;
    private boolean lPe;
    private final a lPf;
    private final com.baidu.tieba.f.b lPg;
    private a.InterfaceC0717a lPh = new a.InterfaceC0717a() { // from class: com.baidu.tieba.pb.pb.godreply.c.1
        @Override // com.baidu.tieba.f.a.InterfaceC0717a
        public void G(int i, int i2) {
            if (c.this.lPf.isActive() && !c.this.dmI() && !c.this.dmJ()) {
                c.this.uM(true);
                c.this.setFullscreen(true);
                c.this.lPf.dmE().q(new Runnable() { // from class: com.baidu.tieba.pb.pb.godreply.c.1.1
                    @Override // java.lang.Runnable
                    public void run() {
                        c.this.uM(false);
                    }
                });
            }
        }

        @Override // com.baidu.tieba.f.a.InterfaceC0717a
        public void H(int i, int i2) {
            if (c.this.lPf.isActive() && !c.this.dmI() && c.this.lPf.dmE().dmO() && Math.abs(i2) > c.TOUCH_SLOP) {
                c.this.lPf.p(new Runnable() { // from class: com.baidu.tieba.pb.pb.godreply.c.1.2
                    @Override // java.lang.Runnable
                    public void run() {
                        c.this.uM(false);
                    }
                });
                c.this.uM(true);
                c.this.setFullscreen(false);
            }
        }

        @Override // com.baidu.tieba.f.a.InterfaceC0717a
        public void ch(int i, int i2) {
        }

        @Override // com.baidu.tieba.f.a.InterfaceC0717a
        public void I(int i, int i2) {
        }
    };
    private View.OnTouchListener lPi = new View.OnTouchListener() { // from class: com.baidu.tieba.pb.pb.godreply.c.2
        @Override // android.view.View.OnTouchListener
        public boolean onTouch(View view, MotionEvent motionEvent) {
            c.this.lPg.onTouchEvent(motionEvent);
            return false;
        }
    };

    public c(a aVar) {
        this.lPf = aVar;
        this.lPg = new com.baidu.tieba.f.b(aVar.lOH.getPageContext().getPageActivity());
        this.lPg.a(this.lPh);
    }

    public void initialize() {
        d dmE = this.lPf.dmE();
        if (dmE.dmL()) {
            dmE.getListView().setOnTouchListener(this.lPi);
        }
    }

    public boolean dmI() {
        return this.lPd;
    }

    public void uM(boolean z) {
        this.lPd = z;
    }

    public boolean dmJ() {
        return this.lPe;
    }

    public void setFullscreen(boolean z) {
        this.lPe = z;
    }
}
