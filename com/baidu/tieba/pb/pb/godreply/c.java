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
    private boolean fKl;
    private boolean fKm;
    private final a fKn;
    private final com.baidu.tieba.e.b fKo;
    private a.InterfaceC0143a fKp = new a.InterfaceC0143a() { // from class: com.baidu.tieba.pb.pb.godreply.c.1
        @Override // com.baidu.tieba.e.a.InterfaceC0143a
        public void aY(int i, int i2) {
            if (c.this.fKn.isActive() && !c.this.bbC() && c.this.fKn.bby().bbH() && Math.abs(i2) > c.TOUCH_SLOP) {
                c.this.fKn.j(new Runnable() { // from class: com.baidu.tieba.pb.pb.godreply.c.1.1
                    @Override // java.lang.Runnable
                    public void run() {
                        c.this.jX(false);
                    }
                });
                c.this.jX(true);
                c.this.setFullscreen(false);
            }
        }

        @Override // com.baidu.tieba.e.a.InterfaceC0143a
        public void aZ(int i, int i2) {
            if (c.this.fKn.isActive() && !c.this.bbC() && !c.this.isFullscreen()) {
                c.this.jX(true);
                c.this.setFullscreen(true);
                c.this.fKn.bby().k(new Runnable() { // from class: com.baidu.tieba.pb.pb.godreply.c.1.2
                    @Override // java.lang.Runnable
                    public void run() {
                        c.this.jX(false);
                    }
                });
            }
        }

        @Override // com.baidu.tieba.e.a.InterfaceC0143a
        public void ba(int i, int i2) {
        }
    };
    private View.OnTouchListener fKq = new View.OnTouchListener() { // from class: com.baidu.tieba.pb.pb.godreply.c.2
        @Override // android.view.View.OnTouchListener
        public boolean onTouch(View view, MotionEvent motionEvent) {
            c.this.fKo.onTouchEvent(motionEvent);
            return false;
        }
    };

    public c(a aVar) {
        this.fKn = aVar;
        this.fKo = new com.baidu.tieba.e.b(aVar.fJQ.getPageContext().getPageActivity());
        this.fKo.a(this.fKp);
    }

    public void Em() {
        d bby = this.fKn.bby();
        if (bby.bbE()) {
            bby.getListView().setOnTouchListener(this.fKq);
        }
    }

    public boolean bbC() {
        return this.fKl;
    }

    public void jX(boolean z) {
        this.fKl = z;
    }

    public boolean isFullscreen() {
        return this.fKm;
    }

    public void setFullscreen(boolean z) {
        this.fKm = z;
    }
}
