package com.baidu.tieba.pb.pb.godreply;

import android.view.MotionEvent;
import android.view.View;
import com.baidu.adp.lib.util.l;
import com.baidu.tbadk.core.TbadkCoreApplication;
import com.baidu.tieba.R;
import com.baidu.tieba.f.a;
/* loaded from: classes21.dex */
public class c {
    private static final int TOUCH_SLOP = l.getDimens(TbadkCoreApplication.getInst(), R.dimen.ds20);
    private boolean kHM;
    private boolean kHN;
    private final a kHO;
    private final com.baidu.tieba.f.b kHP;
    private a.InterfaceC0671a kHQ = new a.InterfaceC0671a() { // from class: com.baidu.tieba.pb.pb.godreply.c.1
        @Override // com.baidu.tieba.f.a.InterfaceC0671a
        public void H(int i, int i2) {
            if (c.this.kHO.isActive() && !c.this.daj() && !c.this.dak()) {
                c.this.sP(true);
                c.this.setFullscreen(true);
                c.this.kHO.daf().u(new Runnable() { // from class: com.baidu.tieba.pb.pb.godreply.c.1.1
                    @Override // java.lang.Runnable
                    public void run() {
                        c.this.sP(false);
                    }
                });
            }
        }

        @Override // com.baidu.tieba.f.a.InterfaceC0671a
        public void I(int i, int i2) {
            if (c.this.kHO.isActive() && !c.this.daj() && c.this.kHO.daf().dap() && Math.abs(i2) > c.TOUCH_SLOP) {
                c.this.kHO.t(new Runnable() { // from class: com.baidu.tieba.pb.pb.godreply.c.1.2
                    @Override // java.lang.Runnable
                    public void run() {
                        c.this.sP(false);
                    }
                });
                c.this.sP(true);
                c.this.setFullscreen(false);
            }
        }

        @Override // com.baidu.tieba.f.a.InterfaceC0671a
        public void cc(int i, int i2) {
        }

        @Override // com.baidu.tieba.f.a.InterfaceC0671a
        public void J(int i, int i2) {
        }
    };
    private View.OnTouchListener kHR = new View.OnTouchListener() { // from class: com.baidu.tieba.pb.pb.godreply.c.2
        @Override // android.view.View.OnTouchListener
        public boolean onTouch(View view, MotionEvent motionEvent) {
            c.this.kHP.onTouchEvent(motionEvent);
            return false;
        }
    };

    public c(a aVar) {
        this.kHO = aVar;
        this.kHP = new com.baidu.tieba.f.b(aVar.kHq.getPageContext().getPageActivity());
        this.kHP.a(this.kHQ);
    }

    public void initialize() {
        d daf = this.kHO.daf();
        if (daf.dam()) {
            daf.getListView().setOnTouchListener(this.kHR);
        }
    }

    public boolean daj() {
        return this.kHM;
    }

    public void sP(boolean z) {
        this.kHM = z;
    }

    public boolean dak() {
        return this.kHN;
    }

    public void setFullscreen(boolean z) {
        this.kHN = z;
    }
}
