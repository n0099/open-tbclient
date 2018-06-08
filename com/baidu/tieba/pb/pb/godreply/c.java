package com.baidu.tieba.pb.pb.godreply;

import android.view.MotionEvent;
import android.view.View;
import com.baidu.adp.lib.util.l;
import com.baidu.tbadk.core.TbadkCoreApplication;
import com.baidu.tieba.d;
import com.baidu.tieba.f.a;
/* loaded from: classes2.dex */
public class c {
    private static final int TOUCH_SLOP = l.e(TbadkCoreApplication.getInst(), d.e.ds20);
    private boolean fqr;
    private boolean fqs;
    private final a fqt;
    private final com.baidu.tieba.f.b fqu;
    private a.InterfaceC0146a fqv = new a.InterfaceC0146a() { // from class: com.baidu.tieba.pb.pb.godreply.c.1
        @Override // com.baidu.tieba.f.a.InterfaceC0146a
        public void X(int i, int i2) {
            if (c.this.fqt.isActive() && !c.this.bbv() && c.this.fqt.bbr().bbA() && Math.abs(i2) > c.TOUCH_SLOP) {
                c.this.fqt.h(new Runnable() { // from class: com.baidu.tieba.pb.pb.godreply.c.1.1
                    @Override // java.lang.Runnable
                    public void run() {
                        c.this.jA(false);
                    }
                });
                c.this.jA(true);
                c.this.setFullscreen(false);
            }
        }

        @Override // com.baidu.tieba.f.a.InterfaceC0146a
        public void Y(int i, int i2) {
            if (c.this.fqt.isActive() && !c.this.bbv() && !c.this.isFullscreen()) {
                c.this.jA(true);
                c.this.setFullscreen(true);
                c.this.fqt.bbr().i(new Runnable() { // from class: com.baidu.tieba.pb.pb.godreply.c.1.2
                    @Override // java.lang.Runnable
                    public void run() {
                        c.this.jA(false);
                    }
                });
            }
        }

        @Override // com.baidu.tieba.f.a.InterfaceC0146a
        public void Z(int i, int i2) {
        }
    };
    private View.OnTouchListener fqw = new View.OnTouchListener() { // from class: com.baidu.tieba.pb.pb.godreply.c.2
        @Override // android.view.View.OnTouchListener
        public boolean onTouch(View view, MotionEvent motionEvent) {
            c.this.fqu.onTouchEvent(motionEvent);
            return false;
        }
    };

    public c(a aVar) {
        this.fqt = aVar;
        this.fqu = new com.baidu.tieba.f.b(aVar.fpV.getPageContext().getPageActivity());
        this.fqu.a(this.fqv);
    }

    public void initialize() {
        d bbr = this.fqt.bbr();
        if (bbr.bbx()) {
            bbr.getListView().setOnTouchListener(this.fqw);
        }
    }

    public boolean bbv() {
        return this.fqr;
    }

    public void jA(boolean z) {
        this.fqr = z;
    }

    public boolean isFullscreen() {
        return this.fqs;
    }

    public void setFullscreen(boolean z) {
        this.fqs = z;
    }
}
