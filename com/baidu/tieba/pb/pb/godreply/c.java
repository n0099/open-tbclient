package com.baidu.tieba.pb.pb.godreply;

import android.view.MotionEvent;
import android.view.View;
import com.baidu.adp.lib.util.l;
import com.baidu.tbadk.core.TbadkCoreApplication;
import com.baidu.tieba.R;
import com.baidu.tieba.f.a;
/* loaded from: classes4.dex */
public class c {
    private static final int TOUCH_SLOP = l.g(TbadkCoreApplication.getInst(), R.dimen.ds20);
    private boolean hDm;
    private boolean hDn;
    private final a hDo;
    private final com.baidu.tieba.f.b hDp;
    private a.InterfaceC0302a hDq = new a.InterfaceC0302a() { // from class: com.baidu.tieba.pb.pb.godreply.c.1
        @Override // com.baidu.tieba.f.a.InterfaceC0302a
        public void aT(int i, int i2) {
            if (c.this.hDo.isActive() && !c.this.bQU() && c.this.hDo.bQQ().bQZ() && Math.abs(i2) > c.TOUCH_SLOP) {
                c.this.hDo.p(new Runnable() { // from class: com.baidu.tieba.pb.pb.godreply.c.1.1
                    @Override // java.lang.Runnable
                    public void run() {
                        c.this.nV(false);
                    }
                });
                c.this.nV(true);
                c.this.setFullscreen(false);
            }
        }

        @Override // com.baidu.tieba.f.a.InterfaceC0302a
        public void aU(int i, int i2) {
            if (c.this.hDo.isActive() && !c.this.bQU() && !c.this.isFullscreen()) {
                c.this.nV(true);
                c.this.setFullscreen(true);
                c.this.hDo.bQQ().q(new Runnable() { // from class: com.baidu.tieba.pb.pb.godreply.c.1.2
                    @Override // java.lang.Runnable
                    public void run() {
                        c.this.nV(false);
                    }
                });
            }
        }

        @Override // com.baidu.tieba.f.a.InterfaceC0302a
        public void aV(int i, int i2) {
        }
    };
    private View.OnTouchListener hDr = new View.OnTouchListener() { // from class: com.baidu.tieba.pb.pb.godreply.c.2
        @Override // android.view.View.OnTouchListener
        public boolean onTouch(View view, MotionEvent motionEvent) {
            c.this.hDp.onTouchEvent(motionEvent);
            return false;
        }
    };

    public c(a aVar) {
        this.hDo = aVar;
        this.hDp = new com.baidu.tieba.f.b(aVar.hCQ.getPageContext().getPageActivity());
        this.hDp.a(this.hDq);
    }

    public void initialize() {
        d bQQ = this.hDo.bQQ();
        if (bQQ.bQW()) {
            bQQ.getListView().setOnTouchListener(this.hDr);
        }
    }

    public boolean bQU() {
        return this.hDm;
    }

    public void nV(boolean z) {
        this.hDm = z;
    }

    public boolean isFullscreen() {
        return this.hDn;
    }

    public void setFullscreen(boolean z) {
        this.hDn = z;
    }
}
