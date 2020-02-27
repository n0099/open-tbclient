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
    private boolean iDL;
    private boolean iDM;
    private final a iDN;
    private final com.baidu.tieba.f.b iDO;
    private a.InterfaceC0499a iDP = new a.InterfaceC0499a() { // from class: com.baidu.tieba.pb.pb.godreply.c.1
        @Override // com.baidu.tieba.f.a.InterfaceC0499a
        public void z(int i, int i2) {
            if (c.this.iDN.isActive() && !c.this.clB() && !c.this.clC()) {
                c.this.pz(true);
                c.this.setFullscreen(true);
                c.this.iDN.clx().r(new Runnable() { // from class: com.baidu.tieba.pb.pb.godreply.c.1.1
                    @Override // java.lang.Runnable
                    public void run() {
                        c.this.pz(false);
                    }
                });
            }
        }

        @Override // com.baidu.tieba.f.a.InterfaceC0499a
        public void A(int i, int i2) {
            if (c.this.iDN.isActive() && !c.this.clB() && c.this.iDN.clx().clH() && Math.abs(i2) > c.TOUCH_SLOP) {
                c.this.iDN.q(new Runnable() { // from class: com.baidu.tieba.pb.pb.godreply.c.1.2
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
    private View.OnTouchListener iDQ = new View.OnTouchListener() { // from class: com.baidu.tieba.pb.pb.godreply.c.2
        @Override // android.view.View.OnTouchListener
        public boolean onTouch(View view, MotionEvent motionEvent) {
            c.this.iDO.onTouchEvent(motionEvent);
            return false;
        }
    };

    public c(a aVar) {
        this.iDN = aVar;
        this.iDO = new com.baidu.tieba.f.b(aVar.iDp.getPageContext().getPageActivity());
        this.iDO.a(this.iDP);
    }

    public void initialize() {
        d clx = this.iDN.clx();
        if (clx.clE()) {
            clx.getListView().setOnTouchListener(this.iDQ);
        }
    }

    public boolean clB() {
        return this.iDL;
    }

    public void pz(boolean z) {
        this.iDL = z;
    }

    public boolean clC() {
        return this.iDM;
    }

    public void setFullscreen(boolean z) {
        this.iDM = z;
    }
}
