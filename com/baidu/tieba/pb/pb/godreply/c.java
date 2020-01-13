package com.baidu.tieba.pb.pb.godreply;

import android.view.MotionEvent;
import android.view.View;
import com.baidu.adp.lib.util.l;
import com.baidu.tbadk.core.TbadkCoreApplication;
import com.baidu.tieba.R;
import com.baidu.tieba.f.a;
/* loaded from: classes7.dex */
public class c {
    private static final int TOUCH_SLOP = l.getDimens(TbadkCoreApplication.getInst(), R.dimen.ds20);
    private boolean iBT;
    private boolean iBU;
    private final a iBV;
    private final com.baidu.tieba.f.b iBW;
    private a.InterfaceC0492a iBX = new a.InterfaceC0492a() { // from class: com.baidu.tieba.pb.pb.godreply.c.1
        @Override // com.baidu.tieba.f.a.InterfaceC0492a
        public void y(int i, int i2) {
            if (c.this.iBV.isActive() && !c.this.cke() && !c.this.ckf()) {
                c.this.pw(true);
                c.this.setFullscreen(true);
                c.this.iBV.cka().r(new Runnable() { // from class: com.baidu.tieba.pb.pb.godreply.c.1.1
                    @Override // java.lang.Runnable
                    public void run() {
                        c.this.pw(false);
                    }
                });
            }
        }

        @Override // com.baidu.tieba.f.a.InterfaceC0492a
        public void z(int i, int i2) {
            if (c.this.iBV.isActive() && !c.this.cke() && c.this.iBV.cka().ckk() && Math.abs(i2) > c.TOUCH_SLOP) {
                c.this.iBV.q(new Runnable() { // from class: com.baidu.tieba.pb.pb.godreply.c.1.2
                    @Override // java.lang.Runnable
                    public void run() {
                        c.this.pw(false);
                    }
                });
                c.this.pw(true);
                c.this.setFullscreen(false);
            }
        }

        @Override // com.baidu.tieba.f.a.InterfaceC0492a
        public void bz(int i, int i2) {
        }

        @Override // com.baidu.tieba.f.a.InterfaceC0492a
        public void A(int i, int i2) {
        }
    };
    private View.OnTouchListener iBY = new View.OnTouchListener() { // from class: com.baidu.tieba.pb.pb.godreply.c.2
        @Override // android.view.View.OnTouchListener
        public boolean onTouch(View view, MotionEvent motionEvent) {
            c.this.iBW.onTouchEvent(motionEvent);
            return false;
        }
    };

    public c(a aVar) {
        this.iBV = aVar;
        this.iBW = new com.baidu.tieba.f.b(aVar.iBw.getPageContext().getPageActivity());
        this.iBW.a(this.iBX);
    }

    public void initialize() {
        d cka = this.iBV.cka();
        if (cka.ckh()) {
            cka.getListView().setOnTouchListener(this.iBY);
        }
    }

    public boolean cke() {
        return this.iBT;
    }

    public void pw(boolean z) {
        this.iBT = z;
    }

    public boolean ckf() {
        return this.iBU;
    }

    public void setFullscreen(boolean z) {
        this.iBU = z;
    }
}
