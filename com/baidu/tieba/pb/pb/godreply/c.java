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
    private boolean hDi;
    private boolean hDj;
    private final a hDk;
    private final com.baidu.tieba.f.b hDl;
    private a.InterfaceC0302a hDm = new a.InterfaceC0302a() { // from class: com.baidu.tieba.pb.pb.godreply.c.1
        @Override // com.baidu.tieba.f.a.InterfaceC0302a
        public void aT(int i, int i2) {
            if (c.this.hDk.isActive() && !c.this.bQQ() && c.this.hDk.bQM().bQV() && Math.abs(i2) > c.TOUCH_SLOP) {
                c.this.hDk.p(new Runnable() { // from class: com.baidu.tieba.pb.pb.godreply.c.1.1
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
            if (c.this.hDk.isActive() && !c.this.bQQ() && !c.this.isFullscreen()) {
                c.this.nU(true);
                c.this.setFullscreen(true);
                c.this.hDk.bQM().q(new Runnable() { // from class: com.baidu.tieba.pb.pb.godreply.c.1.2
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
    private View.OnTouchListener hDn = new View.OnTouchListener() { // from class: com.baidu.tieba.pb.pb.godreply.c.2
        @Override // android.view.View.OnTouchListener
        public boolean onTouch(View view, MotionEvent motionEvent) {
            c.this.hDl.onTouchEvent(motionEvent);
            return false;
        }
    };

    public c(a aVar) {
        this.hDk = aVar;
        this.hDl = new com.baidu.tieba.f.b(aVar.hCM.getPageContext().getPageActivity());
        this.hDl.a(this.hDm);
    }

    public void initialize() {
        d bQM = this.hDk.bQM();
        if (bQM.bQS()) {
            bQM.getListView().setOnTouchListener(this.hDn);
        }
    }

    public boolean bQQ() {
        return this.hDi;
    }

    public void nU(boolean z) {
        this.hDi = z;
    }

    public boolean isFullscreen() {
        return this.hDj;
    }

    public void setFullscreen(boolean z) {
        this.hDj = z;
    }
}
