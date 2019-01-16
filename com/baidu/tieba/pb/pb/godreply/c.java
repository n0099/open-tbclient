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
    private boolean fVM;
    private boolean fVN;
    private final a fVO;
    private final com.baidu.tieba.f.b fVP;
    private a.InterfaceC0214a fVQ = new a.InterfaceC0214a() { // from class: com.baidu.tieba.pb.pb.godreply.c.1
        @Override // com.baidu.tieba.f.a.InterfaceC0214a
        public void ar(int i, int i2) {
            if (c.this.fVO.isActive() && !c.this.biF() && c.this.fVO.biB().biK() && Math.abs(i2) > c.TOUCH_SLOP) {
                c.this.fVO.i(new Runnable() { // from class: com.baidu.tieba.pb.pb.godreply.c.1.1
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
            if (c.this.fVO.isActive() && !c.this.biF() && !c.this.isFullscreen()) {
                c.this.kF(true);
                c.this.setFullscreen(true);
                c.this.fVO.biB().j(new Runnable() { // from class: com.baidu.tieba.pb.pb.godreply.c.1.2
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
    private View.OnTouchListener fVR = new View.OnTouchListener() { // from class: com.baidu.tieba.pb.pb.godreply.c.2
        @Override // android.view.View.OnTouchListener
        public boolean onTouch(View view, MotionEvent motionEvent) {
            c.this.fVP.onTouchEvent(motionEvent);
            return false;
        }
    };

    public c(a aVar) {
        this.fVO = aVar;
        this.fVP = new com.baidu.tieba.f.b(aVar.fVq.getPageContext().getPageActivity());
        this.fVP.a(this.fVQ);
    }

    public void initialize() {
        d biB = this.fVO.biB();
        if (biB.biH()) {
            biB.getListView().setOnTouchListener(this.fVR);
        }
    }

    public boolean biF() {
        return this.fVM;
    }

    public void kF(boolean z) {
        this.fVM = z;
    }

    public boolean isFullscreen() {
        return this.fVN;
    }

    public void setFullscreen(boolean z) {
        this.fVN = z;
    }
}
