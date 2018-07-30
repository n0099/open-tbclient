package com.baidu.tieba.pb.pb.godreply;

import android.view.MotionEvent;
import android.view.View;
import com.baidu.adp.lib.util.l;
import com.baidu.tbadk.core.TbadkCoreApplication;
import com.baidu.tieba.d;
import com.baidu.tieba.f.a;
/* loaded from: classes2.dex */
public class c {
    private static final int TOUCH_SLOP = l.f(TbadkCoreApplication.getInst(), d.e.ds20);
    private boolean fuv;
    private boolean fuw;
    private final a fux;
    private final com.baidu.tieba.f.b fuy;
    private a.InterfaceC0145a fuz = new a.InterfaceC0145a() { // from class: com.baidu.tieba.pb.pb.godreply.c.1
        @Override // com.baidu.tieba.f.a.InterfaceC0145a
        public void Y(int i, int i2) {
            if (c.this.fux.isActive() && !c.this.bav() && c.this.fux.bar().baA() && Math.abs(i2) > c.TOUCH_SLOP) {
                c.this.fux.h(new Runnable() { // from class: com.baidu.tieba.pb.pb.godreply.c.1.1
                    @Override // java.lang.Runnable
                    public void run() {
                        c.this.jw(false);
                    }
                });
                c.this.jw(true);
                c.this.setFullscreen(false);
            }
        }

        @Override // com.baidu.tieba.f.a.InterfaceC0145a
        public void Z(int i, int i2) {
            if (c.this.fux.isActive() && !c.this.bav() && !c.this.isFullscreen()) {
                c.this.jw(true);
                c.this.setFullscreen(true);
                c.this.fux.bar().i(new Runnable() { // from class: com.baidu.tieba.pb.pb.godreply.c.1.2
                    @Override // java.lang.Runnable
                    public void run() {
                        c.this.jw(false);
                    }
                });
            }
        }

        @Override // com.baidu.tieba.f.a.InterfaceC0145a
        public void aa(int i, int i2) {
        }
    };
    private View.OnTouchListener fuA = new View.OnTouchListener() { // from class: com.baidu.tieba.pb.pb.godreply.c.2
        @Override // android.view.View.OnTouchListener
        public boolean onTouch(View view, MotionEvent motionEvent) {
            c.this.fuy.onTouchEvent(motionEvent);
            return false;
        }
    };

    public c(a aVar) {
        this.fux = aVar;
        this.fuy = new com.baidu.tieba.f.b(aVar.ftZ.getPageContext().getPageActivity());
        this.fuy.a(this.fuz);
    }

    public void AF() {
        d bar = this.fux.bar();
        if (bar.bax()) {
            bar.getListView().setOnTouchListener(this.fuA);
        }
    }

    public boolean bav() {
        return this.fuv;
    }

    public void jw(boolean z) {
        this.fuv = z;
    }

    public boolean isFullscreen() {
        return this.fuw;
    }

    public void setFullscreen(boolean z) {
        this.fuw = z;
    }
}
