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
    private boolean iDZ;
    private boolean iEa;
    private final a iEb;
    private final com.baidu.tieba.f.b iEc;
    private a.InterfaceC0499a iEd = new a.InterfaceC0499a() { // from class: com.baidu.tieba.pb.pb.godreply.c.1
        @Override // com.baidu.tieba.f.a.InterfaceC0499a
        public void z(int i, int i2) {
            if (c.this.iEb.isActive() && !c.this.clE() && !c.this.clF()) {
                c.this.pz(true);
                c.this.setFullscreen(true);
                c.this.iEb.clA().r(new Runnable() { // from class: com.baidu.tieba.pb.pb.godreply.c.1.1
                    @Override // java.lang.Runnable
                    public void run() {
                        c.this.pz(false);
                    }
                });
            }
        }

        @Override // com.baidu.tieba.f.a.InterfaceC0499a
        public void A(int i, int i2) {
            if (c.this.iEb.isActive() && !c.this.clE() && c.this.iEb.clA().clK() && Math.abs(i2) > c.TOUCH_SLOP) {
                c.this.iEb.q(new Runnable() { // from class: com.baidu.tieba.pb.pb.godreply.c.1.2
                    @Override // java.lang.Runnable
                    public void run() {
                        c.this.pz(false);
                    }
                });
                c.this.pz(true);
                c.this.setFullscreen(false);
            }
        }

        @Override // com.baidu.tieba.f.a.InterfaceC0499a
        public void bA(int i, int i2) {
        }

        @Override // com.baidu.tieba.f.a.InterfaceC0499a
        public void B(int i, int i2) {
        }
    };
    private View.OnTouchListener iEe = new View.OnTouchListener() { // from class: com.baidu.tieba.pb.pb.godreply.c.2
        @Override // android.view.View.OnTouchListener
        public boolean onTouch(View view, MotionEvent motionEvent) {
            c.this.iEc.onTouchEvent(motionEvent);
            return false;
        }
    };

    public c(a aVar) {
        this.iEb = aVar;
        this.iEc = new com.baidu.tieba.f.b(aVar.iDD.getPageContext().getPageActivity());
        this.iEc.a(this.iEd);
    }

    public void initialize() {
        d clA = this.iEb.clA();
        if (clA.clH()) {
            clA.getListView().setOnTouchListener(this.iEe);
        }
    }

    public boolean clE() {
        return this.iDZ;
    }

    public void pz(boolean z) {
        this.iDZ = z;
    }

    public boolean clF() {
        return this.iEa;
    }

    public void setFullscreen(boolean z) {
        this.iEa = z;
    }
}
