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
    private boolean eSi;
    private boolean eSj;
    private final a eSk;
    private final com.baidu.tieba.e.b eSl;
    private a.InterfaceC0097a eSm = new a.InterfaceC0097a() { // from class: com.baidu.tieba.pb.pb.godreply.c.1
        @Override // com.baidu.tieba.e.a.InterfaceC0097a
        public void ag(int i, int i2) {
            if (c.this.eSk.isActive() && !c.this.aSy() && c.this.eSk.aSu().aSE() && Math.abs(i2) > c.TOUCH_SLOP) {
                c.this.eSk.j(new Runnable() { // from class: com.baidu.tieba.pb.pb.godreply.c.1.1
                    @Override // java.lang.Runnable
                    public void run() {
                        c.this.jb(false);
                    }
                });
                c.this.jb(true);
                c.this.setFullscreen(false);
            }
        }

        @Override // com.baidu.tieba.e.a.InterfaceC0097a
        public void ah(int i, int i2) {
            if (c.this.eSk.isActive() && !c.this.aSy() && !c.this.aSz()) {
                c.this.jb(true);
                c.this.setFullscreen(true);
                c.this.eSk.aSu().k(new Runnable() { // from class: com.baidu.tieba.pb.pb.godreply.c.1.2
                    @Override // java.lang.Runnable
                    public void run() {
                        c.this.jb(false);
                    }
                });
            }
        }

        @Override // com.baidu.tieba.e.a.InterfaceC0097a
        public void ai(int i, int i2) {
        }
    };
    private View.OnTouchListener eSn = new View.OnTouchListener() { // from class: com.baidu.tieba.pb.pb.godreply.c.2
        @Override // android.view.View.OnTouchListener
        public boolean onTouch(View view, MotionEvent motionEvent) {
            c.this.eSl.onTouchEvent(motionEvent);
            return false;
        }
    };

    public c(a aVar) {
        this.eSk = aVar;
        this.eSl = new com.baidu.tieba.e.b(aVar.eRN.getPageContext().getPageActivity());
        this.eSl.a(this.eSm);
    }

    public void wB() {
        d aSu = this.eSk.aSu();
        if (aSu.aSB()) {
            aSu.getListView().setOnTouchListener(this.eSn);
        }
    }

    public boolean aSy() {
        return this.eSi;
    }

    public void jb(boolean z) {
        this.eSi = z;
    }

    public boolean aSz() {
        return this.eSj;
    }

    public void setFullscreen(boolean z) {
        this.eSj = z;
    }
}
