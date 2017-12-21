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
    private boolean eSn;
    private boolean eSo;
    private final a eSp;
    private final com.baidu.tieba.e.b eSq;
    private a.InterfaceC0096a eSr = new a.InterfaceC0096a() { // from class: com.baidu.tieba.pb.pb.godreply.c.1
        @Override // com.baidu.tieba.e.a.InterfaceC0096a
        public void ag(int i, int i2) {
            if (c.this.eSp.isActive() && !c.this.aSz() && c.this.eSp.aSv().aSF() && Math.abs(i2) > c.TOUCH_SLOP) {
                c.this.eSp.j(new Runnable() { // from class: com.baidu.tieba.pb.pb.godreply.c.1.1
                    @Override // java.lang.Runnable
                    public void run() {
                        c.this.jb(false);
                    }
                });
                c.this.jb(true);
                c.this.setFullscreen(false);
            }
        }

        @Override // com.baidu.tieba.e.a.InterfaceC0096a
        public void ah(int i, int i2) {
            if (c.this.eSp.isActive() && !c.this.aSz() && !c.this.aSA()) {
                c.this.jb(true);
                c.this.setFullscreen(true);
                c.this.eSp.aSv().k(new Runnable() { // from class: com.baidu.tieba.pb.pb.godreply.c.1.2
                    @Override // java.lang.Runnable
                    public void run() {
                        c.this.jb(false);
                    }
                });
            }
        }

        @Override // com.baidu.tieba.e.a.InterfaceC0096a
        public void ai(int i, int i2) {
        }
    };
    private View.OnTouchListener eSs = new View.OnTouchListener() { // from class: com.baidu.tieba.pb.pb.godreply.c.2
        @Override // android.view.View.OnTouchListener
        public boolean onTouch(View view, MotionEvent motionEvent) {
            c.this.eSq.onTouchEvent(motionEvent);
            return false;
        }
    };

    public c(a aVar) {
        this.eSp = aVar;
        this.eSq = new com.baidu.tieba.e.b(aVar.eRS.getPageContext().getPageActivity());
        this.eSq.a(this.eSr);
    }

    public void wB() {
        d aSv = this.eSp.aSv();
        if (aSv.aSC()) {
            aSv.getListView().setOnTouchListener(this.eSs);
        }
    }

    public boolean aSz() {
        return this.eSn;
    }

    public void jb(boolean z) {
        this.eSn = z;
    }

    public boolean aSA() {
        return this.eSo;
    }

    public void setFullscreen(boolean z) {
        this.eSo = z;
    }
}
