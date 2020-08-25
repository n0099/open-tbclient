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
    private boolean kzi;
    private boolean kzj;
    private final a kzk;
    private final com.baidu.tieba.f.b kzl;
    private a.InterfaceC0674a kzm = new a.InterfaceC0674a() { // from class: com.baidu.tieba.pb.pb.godreply.c.1
        @Override // com.baidu.tieba.f.a.InterfaceC0674a
        public void H(int i, int i2) {
            if (c.this.kzk.isActive() && !c.this.cWF() && !c.this.cWG()) {
                c.this.sG(true);
                c.this.setFullscreen(true);
                c.this.kzk.cWB().u(new Runnable() { // from class: com.baidu.tieba.pb.pb.godreply.c.1.1
                    @Override // java.lang.Runnable
                    public void run() {
                        c.this.sG(false);
                    }
                });
            }
        }

        @Override // com.baidu.tieba.f.a.InterfaceC0674a
        public void I(int i, int i2) {
            if (c.this.kzk.isActive() && !c.this.cWF() && c.this.kzk.cWB().cWL() && Math.abs(i2) > c.TOUCH_SLOP) {
                c.this.kzk.t(new Runnable() { // from class: com.baidu.tieba.pb.pb.godreply.c.1.2
                    @Override // java.lang.Runnable
                    public void run() {
                        c.this.sG(false);
                    }
                });
                c.this.sG(true);
                c.this.setFullscreen(false);
            }
        }

        @Override // com.baidu.tieba.f.a.InterfaceC0674a
        public void bZ(int i, int i2) {
        }

        @Override // com.baidu.tieba.f.a.InterfaceC0674a
        public void J(int i, int i2) {
        }
    };
    private View.OnTouchListener kzn = new View.OnTouchListener() { // from class: com.baidu.tieba.pb.pb.godreply.c.2
        @Override // android.view.View.OnTouchListener
        public boolean onTouch(View view, MotionEvent motionEvent) {
            c.this.kzl.onTouchEvent(motionEvent);
            return false;
        }
    };

    public c(a aVar) {
        this.kzk = aVar;
        this.kzl = new com.baidu.tieba.f.b(aVar.kyM.getPageContext().getPageActivity());
        this.kzl.a(this.kzm);
    }

    public void initialize() {
        d cWB = this.kzk.cWB();
        if (cWB.cWI()) {
            cWB.getListView().setOnTouchListener(this.kzn);
        }
    }

    public boolean cWF() {
        return this.kzi;
    }

    public void sG(boolean z) {
        this.kzi = z;
    }

    public boolean cWG() {
        return this.kzj;
    }

    public void setFullscreen(boolean z) {
        this.kzj = z;
    }
}
