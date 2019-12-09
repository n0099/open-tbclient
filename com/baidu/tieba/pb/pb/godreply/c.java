package com.baidu.tieba.pb.pb.godreply;

import android.view.MotionEvent;
import android.view.View;
import com.baidu.adp.lib.util.l;
import com.baidu.tbadk.core.TbadkCoreApplication;
import com.baidu.tieba.R;
import com.baidu.tieba.f.a;
/* loaded from: classes4.dex */
public class c {
    private static final int TOUCH_SLOP = l.getDimens(TbadkCoreApplication.getInst(), R.dimen.ds20);
    private boolean hKc;
    private boolean hKd;
    private final a hKe;
    private final com.baidu.tieba.f.b hKf;
    private a.InterfaceC0400a hKg = new a.InterfaceC0400a() { // from class: com.baidu.tieba.pb.pb.godreply.c.1
        @Override // com.baidu.tieba.f.a.InterfaceC0400a
        public void t(int i, int i2) {
            if (c.this.hKe.isActive() && !c.this.bRF() && c.this.hKe.bRB().bRL() && Math.abs(i2) > c.TOUCH_SLOP) {
                c.this.hKe.n(new Runnable() { // from class: com.baidu.tieba.pb.pb.godreply.c.1.1
                    @Override // java.lang.Runnable
                    public void run() {
                        c.this.nW(false);
                    }
                });
                c.this.nW(true);
                c.this.setFullscreen(false);
            }
        }

        @Override // com.baidu.tieba.f.a.InterfaceC0400a
        public void u(int i, int i2) {
            if (c.this.hKe.isActive() && !c.this.bRF() && !c.this.bRG()) {
                c.this.nW(true);
                c.this.setFullscreen(true);
                c.this.hKe.bRB().o(new Runnable() { // from class: com.baidu.tieba.pb.pb.godreply.c.1.2
                    @Override // java.lang.Runnable
                    public void run() {
                        c.this.nW(false);
                    }
                });
            }
        }

        @Override // com.baidu.tieba.f.a.InterfaceC0400a
        public void v(int i, int i2) {
        }
    };
    private View.OnTouchListener hKh = new View.OnTouchListener() { // from class: com.baidu.tieba.pb.pb.godreply.c.2
        @Override // android.view.View.OnTouchListener
        public boolean onTouch(View view, MotionEvent motionEvent) {
            c.this.hKf.onTouchEvent(motionEvent);
            return false;
        }
    };

    public c(a aVar) {
        this.hKe = aVar;
        this.hKf = new com.baidu.tieba.f.b(aVar.hJF.getPageContext().getPageActivity());
        this.hKf.a(this.hKg);
    }

    public void initialize() {
        d bRB = this.hKe.bRB();
        if (bRB.bRI()) {
            bRB.getListView().setOnTouchListener(this.hKh);
        }
    }

    public boolean bRF() {
        return this.hKc;
    }

    public void nW(boolean z) {
        this.hKc = z;
    }

    public boolean bRG() {
        return this.hKd;
    }

    public void setFullscreen(boolean z) {
        this.hKd = z;
    }
}
