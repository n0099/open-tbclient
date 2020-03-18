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
    private boolean iFA;
    private boolean iFB;
    private final a iFC;
    private final com.baidu.tieba.f.b iFD;
    private a.InterfaceC0499a iFE = new a.InterfaceC0499a() { // from class: com.baidu.tieba.pb.pb.godreply.c.1
        @Override // com.baidu.tieba.f.a.InterfaceC0499a
        public void z(int i, int i2) {
            if (c.this.iFC.isActive() && !c.this.clZ() && !c.this.cma()) {
                c.this.pF(true);
                c.this.setFullscreen(true);
                c.this.iFC.clV().r(new Runnable() { // from class: com.baidu.tieba.pb.pb.godreply.c.1.1
                    @Override // java.lang.Runnable
                    public void run() {
                        c.this.pF(false);
                    }
                });
            }
        }

        @Override // com.baidu.tieba.f.a.InterfaceC0499a
        public void A(int i, int i2) {
            if (c.this.iFC.isActive() && !c.this.clZ() && c.this.iFC.clV().cmf() && Math.abs(i2) > c.TOUCH_SLOP) {
                c.this.iFC.q(new Runnable() { // from class: com.baidu.tieba.pb.pb.godreply.c.1.2
                    @Override // java.lang.Runnable
                    public void run() {
                        c.this.pF(false);
                    }
                });
                c.this.pF(true);
                c.this.setFullscreen(false);
            }
        }

        @Override // com.baidu.tieba.f.a.InterfaceC0499a
        public void bB(int i, int i2) {
        }

        @Override // com.baidu.tieba.f.a.InterfaceC0499a
        public void B(int i, int i2) {
        }
    };
    private View.OnTouchListener iFF = new View.OnTouchListener() { // from class: com.baidu.tieba.pb.pb.godreply.c.2
        @Override // android.view.View.OnTouchListener
        public boolean onTouch(View view, MotionEvent motionEvent) {
            c.this.iFD.onTouchEvent(motionEvent);
            return false;
        }
    };

    public c(a aVar) {
        this.iFC = aVar;
        this.iFD = new com.baidu.tieba.f.b(aVar.iFe.getPageContext().getPageActivity());
        this.iFD.a(this.iFE);
    }

    public void initialize() {
        d clV = this.iFC.clV();
        if (clV.cmc()) {
            clV.getListView().setOnTouchListener(this.iFF);
        }
    }

    public boolean clZ() {
        return this.iFA;
    }

    public void pF(boolean z) {
        this.iFA = z;
    }

    public boolean cma() {
        return this.iFB;
    }

    public void setFullscreen(boolean z) {
        this.iFB = z;
    }
}
