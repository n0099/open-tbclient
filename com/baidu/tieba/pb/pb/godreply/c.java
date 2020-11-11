package com.baidu.tieba.pb.pb.godreply;

import android.view.MotionEvent;
import android.view.View;
import com.baidu.adp.lib.util.l;
import com.baidu.tbadk.core.TbadkCoreApplication;
import com.baidu.tieba.R;
import com.baidu.tieba.f.a;
/* loaded from: classes22.dex */
public class c {
    private static final int TOUCH_SLOP = l.getDimens(TbadkCoreApplication.getInst(), R.dimen.ds20);
    private final com.baidu.tieba.f.b lpA;
    private a.InterfaceC0719a lpB = new a.InterfaceC0719a() { // from class: com.baidu.tieba.pb.pb.godreply.c.1
        @Override // com.baidu.tieba.f.a.InterfaceC0719a
        public void H(int i, int i2) {
            if (c.this.lpz.isActive() && !c.this.djB() && !c.this.djC()) {
                c.this.tW(true);
                c.this.setFullscreen(true);
                c.this.lpz.djx().u(new Runnable() { // from class: com.baidu.tieba.pb.pb.godreply.c.1.1
                    @Override // java.lang.Runnable
                    public void run() {
                        c.this.tW(false);
                    }
                });
            }
        }

        @Override // com.baidu.tieba.f.a.InterfaceC0719a
        public void I(int i, int i2) {
            if (c.this.lpz.isActive() && !c.this.djB() && c.this.lpz.djx().djH() && Math.abs(i2) > c.TOUCH_SLOP) {
                c.this.lpz.t(new Runnable() { // from class: com.baidu.tieba.pb.pb.godreply.c.1.2
                    @Override // java.lang.Runnable
                    public void run() {
                        c.this.tW(false);
                    }
                });
                c.this.tW(true);
                c.this.setFullscreen(false);
            }
        }

        @Override // com.baidu.tieba.f.a.InterfaceC0719a
        public void cg(int i, int i2) {
        }

        @Override // com.baidu.tieba.f.a.InterfaceC0719a
        public void J(int i, int i2) {
        }
    };
    private View.OnTouchListener lpC = new View.OnTouchListener() { // from class: com.baidu.tieba.pb.pb.godreply.c.2
        @Override // android.view.View.OnTouchListener
        public boolean onTouch(View view, MotionEvent motionEvent) {
            c.this.lpA.onTouchEvent(motionEvent);
            return false;
        }
    };
    private boolean lpx;
    private boolean lpy;
    private final a lpz;

    public c(a aVar) {
        this.lpz = aVar;
        this.lpA = new com.baidu.tieba.f.b(aVar.lpb.getPageContext().getPageActivity());
        this.lpA.a(this.lpB);
    }

    public void initialize() {
        d djx = this.lpz.djx();
        if (djx.djE()) {
            djx.getListView().setOnTouchListener(this.lpC);
        }
    }

    public boolean djB() {
        return this.lpx;
    }

    public void tW(boolean z) {
        this.lpx = z;
    }

    public boolean djC() {
        return this.lpy;
    }

    public void setFullscreen(boolean z) {
        this.lpy = z;
    }
}
