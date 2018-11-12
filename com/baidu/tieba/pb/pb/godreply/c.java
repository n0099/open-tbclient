package com.baidu.tieba.pb.pb.godreply;

import android.view.MotionEvent;
import android.view.View;
import com.baidu.adp.lib.util.l;
import com.baidu.tbadk.core.TbadkCoreApplication;
import com.baidu.tieba.e;
import com.baidu.tieba.f.a;
/* loaded from: classes6.dex */
public class c {
    private static final int TOUCH_SLOP = l.h(TbadkCoreApplication.getInst(), e.C0200e.ds20);
    private boolean fLh;
    private boolean fLi;
    private final a fLj;
    private final com.baidu.tieba.f.b fLk;
    private a.InterfaceC0204a fLl = new a.InterfaceC0204a() { // from class: com.baidu.tieba.pb.pb.godreply.c.1
        @Override // com.baidu.tieba.f.a.InterfaceC0204a
        public void ap(int i, int i2) {
            if (c.this.fLj.isActive() && !c.this.bfz() && c.this.fLj.bfv().bfE() && Math.abs(i2) > c.TOUCH_SLOP) {
                c.this.fLj.h(new Runnable() { // from class: com.baidu.tieba.pb.pb.godreply.c.1.1
                    @Override // java.lang.Runnable
                    public void run() {
                        c.this.kz(false);
                    }
                });
                c.this.kz(true);
                c.this.setFullscreen(false);
            }
        }

        @Override // com.baidu.tieba.f.a.InterfaceC0204a
        public void aq(int i, int i2) {
            if (c.this.fLj.isActive() && !c.this.bfz() && !c.this.isFullscreen()) {
                c.this.kz(true);
                c.this.setFullscreen(true);
                c.this.fLj.bfv().i(new Runnable() { // from class: com.baidu.tieba.pb.pb.godreply.c.1.2
                    @Override // java.lang.Runnable
                    public void run() {
                        c.this.kz(false);
                    }
                });
            }
        }

        @Override // com.baidu.tieba.f.a.InterfaceC0204a
        public void ar(int i, int i2) {
        }
    };
    private View.OnTouchListener fLm = new View.OnTouchListener() { // from class: com.baidu.tieba.pb.pb.godreply.c.2
        @Override // android.view.View.OnTouchListener
        public boolean onTouch(View view, MotionEvent motionEvent) {
            c.this.fLk.onTouchEvent(motionEvent);
            return false;
        }
    };

    public c(a aVar) {
        this.fLj = aVar;
        this.fLk = new com.baidu.tieba.f.b(aVar.fKL.getPageContext().getPageActivity());
        this.fLk.a(this.fLl);
    }

    public void initialize() {
        d bfv = this.fLj.bfv();
        if (bfv.bfB()) {
            bfv.getListView().setOnTouchListener(this.fLm);
        }
    }

    public boolean bfz() {
        return this.fLh;
    }

    public void kz(boolean z) {
        this.fLh = z;
    }

    public boolean isFullscreen() {
        return this.fLi;
    }

    public void setFullscreen(boolean z) {
        this.fLi = z;
    }
}
