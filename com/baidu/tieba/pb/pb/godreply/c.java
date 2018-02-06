package com.baidu.tieba.pb.pb.godreply;

import android.view.MotionEvent;
import android.view.View;
import com.baidu.adp.lib.util.l;
import com.baidu.tbadk.core.TbadkCoreApplication;
import com.baidu.tieba.d;
import com.baidu.tieba.e.a;
/* loaded from: classes2.dex */
public class c {
    private static final int TOUCH_SLOP = l.t(TbadkCoreApplication.getInst(), d.e.ds20);
    private boolean fKg;
    private boolean fKh;
    private final a fKi;
    private final com.baidu.tieba.e.b fKj;
    private a.InterfaceC0142a fKk = new a.InterfaceC0142a() { // from class: com.baidu.tieba.pb.pb.godreply.c.1
        @Override // com.baidu.tieba.e.a.InterfaceC0142a
        public void aY(int i, int i2) {
            if (c.this.fKi.isActive() && !c.this.bbC() && c.this.fKi.bby().bbH() && Math.abs(i2) > c.TOUCH_SLOP) {
                c.this.fKi.j(new Runnable() { // from class: com.baidu.tieba.pb.pb.godreply.c.1.1
                    @Override // java.lang.Runnable
                    public void run() {
                        c.this.jS(false);
                    }
                });
                c.this.jS(true);
                c.this.setFullscreen(false);
            }
        }

        @Override // com.baidu.tieba.e.a.InterfaceC0142a
        public void aZ(int i, int i2) {
            if (c.this.fKi.isActive() && !c.this.bbC() && !c.this.isFullscreen()) {
                c.this.jS(true);
                c.this.setFullscreen(true);
                c.this.fKi.bby().k(new Runnable() { // from class: com.baidu.tieba.pb.pb.godreply.c.1.2
                    @Override // java.lang.Runnable
                    public void run() {
                        c.this.jS(false);
                    }
                });
            }
        }

        @Override // com.baidu.tieba.e.a.InterfaceC0142a
        public void ba(int i, int i2) {
        }
    };
    private View.OnTouchListener fKl = new View.OnTouchListener() { // from class: com.baidu.tieba.pb.pb.godreply.c.2
        @Override // android.view.View.OnTouchListener
        public boolean onTouch(View view, MotionEvent motionEvent) {
            c.this.fKj.onTouchEvent(motionEvent);
            return false;
        }
    };

    public c(a aVar) {
        this.fKi = aVar;
        this.fKj = new com.baidu.tieba.e.b(aVar.fJL.getPageContext().getPageActivity());
        this.fKj.a(this.fKk);
    }

    public void Em() {
        d bby = this.fKi.bby();
        if (bby.bbE()) {
            bby.getListView().setOnTouchListener(this.fKl);
        }
    }

    public boolean bbC() {
        return this.fKg;
    }

    public void jS(boolean z) {
        this.fKg = z;
    }

    public boolean isFullscreen() {
        return this.fKh;
    }

    public void setFullscreen(boolean z) {
        this.fKh = z;
    }
}
