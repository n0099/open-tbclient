package com.baidu.tieba.pb.pb.godreply;

import android.view.MotionEvent;
import android.view.View;
import com.baidu.adp.lib.util.l;
import com.baidu.tbadk.core.TbadkCoreApplication;
import com.baidu.tieba.f;
import com.baidu.tieba.f.a;
/* loaded from: classes2.dex */
public class c {
    private static final int TOUCH_SLOP = l.f(TbadkCoreApplication.getInst(), f.e.ds20);
    private boolean fuo;
    private boolean fup;
    private final a fuq;
    private final com.baidu.tieba.f.b fur;
    private a.InterfaceC0144a fus = new a.InterfaceC0144a() { // from class: com.baidu.tieba.pb.pb.godreply.c.1
        @Override // com.baidu.tieba.f.a.InterfaceC0144a
        public void Y(int i, int i2) {
            if (c.this.fuq.isActive() && !c.this.baq() && c.this.fuq.bam().bav() && Math.abs(i2) > c.TOUCH_SLOP) {
                c.this.fuq.h(new Runnable() { // from class: com.baidu.tieba.pb.pb.godreply.c.1.1
                    @Override // java.lang.Runnable
                    public void run() {
                        c.this.jw(false);
                    }
                });
                c.this.jw(true);
                c.this.setFullscreen(false);
            }
        }

        @Override // com.baidu.tieba.f.a.InterfaceC0144a
        public void Z(int i, int i2) {
            if (c.this.fuq.isActive() && !c.this.baq() && !c.this.isFullscreen()) {
                c.this.jw(true);
                c.this.setFullscreen(true);
                c.this.fuq.bam().i(new Runnable() { // from class: com.baidu.tieba.pb.pb.godreply.c.1.2
                    @Override // java.lang.Runnable
                    public void run() {
                        c.this.jw(false);
                    }
                });
            }
        }

        @Override // com.baidu.tieba.f.a.InterfaceC0144a
        public void aa(int i, int i2) {
        }
    };
    private View.OnTouchListener fut = new View.OnTouchListener() { // from class: com.baidu.tieba.pb.pb.godreply.c.2
        @Override // android.view.View.OnTouchListener
        public boolean onTouch(View view, MotionEvent motionEvent) {
            c.this.fur.onTouchEvent(motionEvent);
            return false;
        }
    };

    public c(a aVar) {
        this.fuq = aVar;
        this.fur = new com.baidu.tieba.f.b(aVar.ftS.getPageContext().getPageActivity());
        this.fur.a(this.fus);
    }

    public void AC() {
        d bam = this.fuq.bam();
        if (bam.bas()) {
            bam.getListView().setOnTouchListener(this.fut);
        }
    }

    public boolean baq() {
        return this.fuo;
    }

    public void jw(boolean z) {
        this.fuo = z;
    }

    public boolean isFullscreen() {
        return this.fup;
    }

    public void setFullscreen(boolean z) {
        this.fup = z;
    }
}
