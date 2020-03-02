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
    private boolean iDN;
    private boolean iDO;
    private final a iDP;
    private final com.baidu.tieba.f.b iDQ;
    private a.InterfaceC0499a iDR = new a.InterfaceC0499a() { // from class: com.baidu.tieba.pb.pb.godreply.c.1
        @Override // com.baidu.tieba.f.a.InterfaceC0499a
        public void z(int i, int i2) {
            if (c.this.iDP.isActive() && !c.this.clD() && !c.this.clE()) {
                c.this.pz(true);
                c.this.setFullscreen(true);
                c.this.iDP.clz().r(new Runnable() { // from class: com.baidu.tieba.pb.pb.godreply.c.1.1
                    @Override // java.lang.Runnable
                    public void run() {
                        c.this.pz(false);
                    }
                });
            }
        }

        @Override // com.baidu.tieba.f.a.InterfaceC0499a
        public void A(int i, int i2) {
            if (c.this.iDP.isActive() && !c.this.clD() && c.this.iDP.clz().clJ() && Math.abs(i2) > c.TOUCH_SLOP) {
                c.this.iDP.q(new Runnable() { // from class: com.baidu.tieba.pb.pb.godreply.c.1.2
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
    private View.OnTouchListener iDS = new View.OnTouchListener() { // from class: com.baidu.tieba.pb.pb.godreply.c.2
        @Override // android.view.View.OnTouchListener
        public boolean onTouch(View view, MotionEvent motionEvent) {
            c.this.iDQ.onTouchEvent(motionEvent);
            return false;
        }
    };

    public c(a aVar) {
        this.iDP = aVar;
        this.iDQ = new com.baidu.tieba.f.b(aVar.iDr.getPageContext().getPageActivity());
        this.iDQ.a(this.iDR);
    }

    public void initialize() {
        d clz = this.iDP.clz();
        if (clz.clG()) {
            clz.getListView().setOnTouchListener(this.iDS);
        }
    }

    public boolean clD() {
        return this.iDN;
    }

    public void pz(boolean z) {
        this.iDN = z;
    }

    public boolean clE() {
        return this.iDO;
    }

    public void setFullscreen(boolean z) {
        this.iDO = z;
    }
}
