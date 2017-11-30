package com.baidu.tieba.pb.pb.godreply;

import android.view.MotionEvent;
import android.view.View;
import com.baidu.adp.lib.util.l;
import com.baidu.tbadk.core.TbadkCoreApplication;
import com.baidu.tieba.d;
import com.baidu.tieba.e.a;
/* loaded from: classes.dex */
public class c {
    private static final int TOUCH_SLOP = l.f(TbadkCoreApplication.getInst(), d.e.ds20);
    private boolean eRf;
    private boolean eRg;
    private final a eRh;
    private final com.baidu.tieba.e.b eRi;
    private a.InterfaceC0083a eRj = new a.InterfaceC0083a() { // from class: com.baidu.tieba.pb.pb.godreply.c.1
        @Override // com.baidu.tieba.e.a.InterfaceC0083a
        public void af(int i, int i2) {
            if (c.this.eRh.isActive() && !c.this.aSq() && c.this.eRh.aSm().aSw() && Math.abs(i2) > c.TOUCH_SLOP) {
                c.this.eRh.j(new Runnable() { // from class: com.baidu.tieba.pb.pb.godreply.c.1.1
                    @Override // java.lang.Runnable
                    public void run() {
                        c.this.ja(false);
                    }
                });
                c.this.ja(true);
                c.this.setFullscreen(false);
            }
        }

        @Override // com.baidu.tieba.e.a.InterfaceC0083a
        public void ag(int i, int i2) {
            if (c.this.eRh.isActive() && !c.this.aSq() && !c.this.aSr()) {
                c.this.ja(true);
                c.this.setFullscreen(true);
                c.this.eRh.aSm().k(new Runnable() { // from class: com.baidu.tieba.pb.pb.godreply.c.1.2
                    @Override // java.lang.Runnable
                    public void run() {
                        c.this.ja(false);
                    }
                });
            }
        }

        @Override // com.baidu.tieba.e.a.InterfaceC0083a
        public void ah(int i, int i2) {
        }
    };
    private View.OnTouchListener eRk = new View.OnTouchListener() { // from class: com.baidu.tieba.pb.pb.godreply.c.2
        @Override // android.view.View.OnTouchListener
        public boolean onTouch(View view, MotionEvent motionEvent) {
            c.this.eRi.onTouchEvent(motionEvent);
            return false;
        }
    };

    public c(a aVar) {
        this.eRh = aVar;
        this.eRi = new com.baidu.tieba.e.b(aVar.eQK.getPageContext().getPageActivity());
        this.eRi.a(this.eRj);
    }

    public void wD() {
        d aSm = this.eRh.aSm();
        if (aSm.aSt()) {
            aSm.getListView().setOnTouchListener(this.eRk);
        }
    }

    public boolean aSq() {
        return this.eRf;
    }

    public void ja(boolean z) {
        this.eRf = z;
    }

    public boolean aSr() {
        return this.eRg;
    }

    public void setFullscreen(boolean z) {
        this.eRg = z;
    }
}
