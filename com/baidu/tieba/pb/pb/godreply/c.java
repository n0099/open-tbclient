package com.baidu.tieba.pb.pb.godreply;

import android.view.MotionEvent;
import android.view.View;
import com.baidu.adp.lib.util.l;
import com.baidu.tbadk.core.TbadkCoreApplication;
import com.baidu.tieba.e;
import com.baidu.tieba.f.a;
/* loaded from: classes2.dex */
public class c {
    private static final int TOUCH_SLOP = l.h(TbadkCoreApplication.getInst(), e.C0141e.ds20);
    private boolean fCg;
    private boolean fCh;
    private final a fCi;
    private final com.baidu.tieba.f.b fCj;
    private a.InterfaceC0145a fCk = new a.InterfaceC0145a() { // from class: com.baidu.tieba.pb.pb.godreply.c.1
        @Override // com.baidu.tieba.f.a.InterfaceC0145a
        public void ac(int i, int i2) {
            if (c.this.fCi.isActive() && !c.this.bcQ() && c.this.fCi.bcM().bcV() && Math.abs(i2) > c.TOUCH_SLOP) {
                c.this.fCi.h(new Runnable() { // from class: com.baidu.tieba.pb.pb.godreply.c.1.1
                    @Override // java.lang.Runnable
                    public void run() {
                        c.this.jX(false);
                    }
                });
                c.this.jX(true);
                c.this.setFullscreen(false);
            }
        }

        @Override // com.baidu.tieba.f.a.InterfaceC0145a
        public void ad(int i, int i2) {
            if (c.this.fCi.isActive() && !c.this.bcQ() && !c.this.isFullscreen()) {
                c.this.jX(true);
                c.this.setFullscreen(true);
                c.this.fCi.bcM().i(new Runnable() { // from class: com.baidu.tieba.pb.pb.godreply.c.1.2
                    @Override // java.lang.Runnable
                    public void run() {
                        c.this.jX(false);
                    }
                });
            }
        }

        @Override // com.baidu.tieba.f.a.InterfaceC0145a
        public void ae(int i, int i2) {
        }
    };
    private View.OnTouchListener fCl = new View.OnTouchListener() { // from class: com.baidu.tieba.pb.pb.godreply.c.2
        @Override // android.view.View.OnTouchListener
        public boolean onTouch(View view, MotionEvent motionEvent) {
            c.this.fCj.onTouchEvent(motionEvent);
            return false;
        }
    };

    public c(a aVar) {
        this.fCi = aVar;
        this.fCj = new com.baidu.tieba.f.b(aVar.fBK.getPageContext().getPageActivity());
        this.fCj.a(this.fCk);
    }

    public void BP() {
        d bcM = this.fCi.bcM();
        if (bcM.bcS()) {
            bcM.getListView().setOnTouchListener(this.fCl);
        }
    }

    public boolean bcQ() {
        return this.fCg;
    }

    public void jX(boolean z) {
        this.fCg = z;
    }

    public boolean isFullscreen() {
        return this.fCh;
    }

    public void setFullscreen(boolean z) {
        this.fCh = z;
    }
}
