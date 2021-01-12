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
    private boolean lDX;
    private boolean lDY;
    private final a lDZ;
    private final com.baidu.tieba.f.b lEa;
    private a.InterfaceC0710a lEb = new a.InterfaceC0710a() { // from class: com.baidu.tieba.pb.pb.godreply.c.1
        @Override // com.baidu.tieba.f.a.InterfaceC0710a
        public void G(int i, int i2) {
            if (c.this.lDZ.isActive() && !c.this.dkf() && !c.this.dkg()) {
                c.this.uy(true);
                c.this.setFullscreen(true);
                c.this.lDZ.dkb().t(new Runnable() { // from class: com.baidu.tieba.pb.pb.godreply.c.1.1
                    @Override // java.lang.Runnable
                    public void run() {
                        c.this.uy(false);
                    }
                });
            }
        }

        @Override // com.baidu.tieba.f.a.InterfaceC0710a
        public void H(int i, int i2) {
            if (c.this.lDZ.isActive() && !c.this.dkf() && c.this.lDZ.dkb().dkl() && Math.abs(i2) > c.TOUCH_SLOP) {
                c.this.lDZ.s(new Runnable() { // from class: com.baidu.tieba.pb.pb.godreply.c.1.2
                    @Override // java.lang.Runnable
                    public void run() {
                        c.this.uy(false);
                    }
                });
                c.this.uy(true);
                c.this.setFullscreen(false);
            }
        }

        @Override // com.baidu.tieba.f.a.InterfaceC0710a
        public void cj(int i, int i2) {
        }

        @Override // com.baidu.tieba.f.a.InterfaceC0710a
        public void I(int i, int i2) {
        }
    };
    private View.OnTouchListener lEc = new View.OnTouchListener() { // from class: com.baidu.tieba.pb.pb.godreply.c.2
        @Override // android.view.View.OnTouchListener
        public boolean onTouch(View view, MotionEvent motionEvent) {
            c.this.lEa.onTouchEvent(motionEvent);
            return false;
        }
    };

    public c(a aVar) {
        this.lDZ = aVar;
        this.lEa = new com.baidu.tieba.f.b(aVar.lDB.getPageContext().getPageActivity());
        this.lEa.a(this.lEb);
    }

    public void initialize() {
        d dkb = this.lDZ.dkb();
        if (dkb.dki()) {
            dkb.getListView().setOnTouchListener(this.lEc);
        }
    }

    public boolean dkf() {
        return this.lDX;
    }

    public void uy(boolean z) {
        this.lDX = z;
    }

    public boolean dkg() {
        return this.lDY;
    }

    public void setFullscreen(boolean z) {
        this.lDY = z;
    }
}
