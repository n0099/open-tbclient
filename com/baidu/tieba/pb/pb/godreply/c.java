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
    private boolean hDl;
    private boolean hDm;
    private final a hDn;
    private final com.baidu.tieba.f.b hDo;
    private a.InterfaceC0302a hDp = new a.InterfaceC0302a() { // from class: com.baidu.tieba.pb.pb.godreply.c.1
        @Override // com.baidu.tieba.f.a.InterfaceC0302a
        public void aT(int i, int i2) {
            if (c.this.hDn.isActive() && !c.this.bQT() && c.this.hDn.bQP().bQY() && Math.abs(i2) > c.TOUCH_SLOP) {
                c.this.hDn.p(new Runnable() { // from class: com.baidu.tieba.pb.pb.godreply.c.1.1
                    @Override // java.lang.Runnable
                    public void run() {
                        c.this.nU(false);
                    }
                });
                c.this.nU(true);
                c.this.setFullscreen(false);
            }
        }

        @Override // com.baidu.tieba.f.a.InterfaceC0302a
        public void aU(int i, int i2) {
            if (c.this.hDn.isActive() && !c.this.bQT() && !c.this.isFullscreen()) {
                c.this.nU(true);
                c.this.setFullscreen(true);
                c.this.hDn.bQP().q(new Runnable() { // from class: com.baidu.tieba.pb.pb.godreply.c.1.2
                    @Override // java.lang.Runnable
                    public void run() {
                        c.this.nU(false);
                    }
                });
            }
        }

        @Override // com.baidu.tieba.f.a.InterfaceC0302a
        public void aV(int i, int i2) {
        }
    };
    private View.OnTouchListener hDq = new View.OnTouchListener() { // from class: com.baidu.tieba.pb.pb.godreply.c.2
        @Override // android.view.View.OnTouchListener
        public boolean onTouch(View view, MotionEvent motionEvent) {
            c.this.hDo.onTouchEvent(motionEvent);
            return false;
        }
    };

    public c(a aVar) {
        this.hDn = aVar;
        this.hDo = new com.baidu.tieba.f.b(aVar.hCP.getPageContext().getPageActivity());
        this.hDo.a(this.hDp);
    }

    public void initialize() {
        d bQP = this.hDn.bQP();
        if (bQP.bQV()) {
            bQP.getListView().setOnTouchListener(this.hDq);
        }
    }

    public boolean bQT() {
        return this.hDl;
    }

    public void nU(boolean z) {
        this.hDl = z;
    }

    public boolean isFullscreen() {
        return this.hDm;
    }

    public void setFullscreen(boolean z) {
        this.hDm = z;
    }
}
