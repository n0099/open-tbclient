package com.baidu.tieba.pb.pb.godreply;

import android.view.MotionEvent;
import android.view.View;
import com.baidu.adp.lib.util.l;
import com.baidu.tbadk.core.TbadkCoreApplication;
import com.baidu.tieba.R;
import com.baidu.tieba.f.a;
/* loaded from: classes2.dex */
public class c {
    private static final int TOUCH_SLOP = l.getDimens(TbadkCoreApplication.getInst(), R.dimen.ds20);
    private boolean lNb;
    private boolean lNc;
    private final a lNd;
    private final com.baidu.tieba.f.b lNe;
    private a.InterfaceC0711a lNf = new a.InterfaceC0711a() { // from class: com.baidu.tieba.pb.pb.godreply.c.1
        @Override // com.baidu.tieba.f.a.InterfaceC0711a
        public void G(int i, int i2) {
            if (c.this.lNd.isActive() && !c.this.dmz() && !c.this.dmA()) {
                c.this.uM(true);
                c.this.setFullscreen(true);
                c.this.lNd.dmv().r(new Runnable() { // from class: com.baidu.tieba.pb.pb.godreply.c.1.1
                    @Override // java.lang.Runnable
                    public void run() {
                        c.this.uM(false);
                    }
                });
            }
        }

        @Override // com.baidu.tieba.f.a.InterfaceC0711a
        public void H(int i, int i2) {
            if (c.this.lNd.isActive() && !c.this.dmz() && c.this.lNd.dmv().dmF() && Math.abs(i2) > c.TOUCH_SLOP) {
                c.this.lNd.q(new Runnable() { // from class: com.baidu.tieba.pb.pb.godreply.c.1.2
                    @Override // java.lang.Runnable
                    public void run() {
                        c.this.uM(false);
                    }
                });
                c.this.uM(true);
                c.this.setFullscreen(false);
            }
        }

        @Override // com.baidu.tieba.f.a.InterfaceC0711a
        public void ch(int i, int i2) {
        }

        @Override // com.baidu.tieba.f.a.InterfaceC0711a
        public void I(int i, int i2) {
        }
    };
    private View.OnTouchListener lNg = new View.OnTouchListener() { // from class: com.baidu.tieba.pb.pb.godreply.c.2
        @Override // android.view.View.OnTouchListener
        public boolean onTouch(View view, MotionEvent motionEvent) {
            c.this.lNe.onTouchEvent(motionEvent);
            return false;
        }
    };

    public c(a aVar) {
        this.lNd = aVar;
        this.lNe = new com.baidu.tieba.f.b(aVar.lMF.getPageContext().getPageActivity());
        this.lNe.a(this.lNf);
    }

    public void initialize() {
        d dmv = this.lNd.dmv();
        if (dmv.dmC()) {
            dmv.getListView().setOnTouchListener(this.lNg);
        }
    }

    public boolean dmz() {
        return this.lNb;
    }

    public void uM(boolean z) {
        this.lNb = z;
    }

    public boolean dmA() {
        return this.lNc;
    }

    public void setFullscreen(boolean z) {
        this.lNc = z;
    }
}
