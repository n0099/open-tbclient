package com.baidu.tieba.pb.pb.godreply;

import android.view.MotionEvent;
import android.view.View;
import com.baidu.adp.lib.util.l;
import com.baidu.tbadk.core.TbadkCoreApplication;
import com.baidu.tieba.e;
import com.baidu.tieba.f.a;
/* loaded from: classes6.dex */
public class c {
    private static final int TOUCH_SLOP = l.h(TbadkCoreApplication.getInst(), e.C0210e.ds20);
    private boolean fUP;
    private boolean fUQ;
    private final a fUR;
    private final com.baidu.tieba.f.b fUS;
    private a.InterfaceC0214a fUT = new a.InterfaceC0214a() { // from class: com.baidu.tieba.pb.pb.godreply.c.1
        @Override // com.baidu.tieba.f.a.InterfaceC0214a
        public void ar(int i, int i2) {
            if (c.this.fUR.isActive() && !c.this.bib() && c.this.fUR.bhX().big() && Math.abs(i2) > c.TOUCH_SLOP) {
                c.this.fUR.i(new Runnable() { // from class: com.baidu.tieba.pb.pb.godreply.c.1.1
                    @Override // java.lang.Runnable
                    public void run() {
                        c.this.kF(false);
                    }
                });
                c.this.kF(true);
                c.this.setFullscreen(false);
            }
        }

        @Override // com.baidu.tieba.f.a.InterfaceC0214a
        public void as(int i, int i2) {
            if (c.this.fUR.isActive() && !c.this.bib() && !c.this.isFullscreen()) {
                c.this.kF(true);
                c.this.setFullscreen(true);
                c.this.fUR.bhX().j(new Runnable() { // from class: com.baidu.tieba.pb.pb.godreply.c.1.2
                    @Override // java.lang.Runnable
                    public void run() {
                        c.this.kF(false);
                    }
                });
            }
        }

        @Override // com.baidu.tieba.f.a.InterfaceC0214a
        public void at(int i, int i2) {
        }
    };
    private View.OnTouchListener fUU = new View.OnTouchListener() { // from class: com.baidu.tieba.pb.pb.godreply.c.2
        @Override // android.view.View.OnTouchListener
        public boolean onTouch(View view, MotionEvent motionEvent) {
            c.this.fUS.onTouchEvent(motionEvent);
            return false;
        }
    };

    public c(a aVar) {
        this.fUR = aVar;
        this.fUS = new com.baidu.tieba.f.b(aVar.fUt.getPageContext().getPageActivity());
        this.fUS.a(this.fUT);
    }

    public void initialize() {
        d bhX = this.fUR.bhX();
        if (bhX.bid()) {
            bhX.getListView().setOnTouchListener(this.fUU);
        }
    }

    public boolean bib() {
        return this.fUP;
    }

    public void kF(boolean z) {
        this.fUP = z;
    }

    public boolean isFullscreen() {
        return this.fUQ;
    }

    public void setFullscreen(boolean z) {
        this.fUQ = z;
    }
}
