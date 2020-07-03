package com.baidu.tieba.pb.pb.godreply;

import android.view.MotionEvent;
import android.view.View;
import com.baidu.adp.lib.util.l;
import com.baidu.tbadk.core.TbadkCoreApplication;
import com.baidu.tieba.R;
import com.baidu.tieba.f.a;
/* loaded from: classes9.dex */
public class c {
    private static final int TOUCH_SLOP = l.getDimens(TbadkCoreApplication.getInst(), R.dimen.ds20);
    private boolean kbk;
    private boolean kbl;
    private final a kbm;
    private final com.baidu.tieba.f.b kbn;
    private a.InterfaceC0614a kbo = new a.InterfaceC0614a() { // from class: com.baidu.tieba.pb.pb.godreply.c.1
        @Override // com.baidu.tieba.f.a.InterfaceC0614a
        public void D(int i, int i2) {
            if (c.this.kbm.isActive() && !c.this.cIg() && !c.this.cIh()) {
                c.this.ru(true);
                c.this.setFullscreen(true);
                c.this.kbm.cIc().y(new Runnable() { // from class: com.baidu.tieba.pb.pb.godreply.c.1.1
                    @Override // java.lang.Runnable
                    public void run() {
                        c.this.ru(false);
                    }
                });
            }
        }

        @Override // com.baidu.tieba.f.a.InterfaceC0614a
        public void E(int i, int i2) {
            if (c.this.kbm.isActive() && !c.this.cIg() && c.this.kbm.cIc().cIm() && Math.abs(i2) > c.TOUCH_SLOP) {
                c.this.kbm.x(new Runnable() { // from class: com.baidu.tieba.pb.pb.godreply.c.1.2
                    @Override // java.lang.Runnable
                    public void run() {
                        c.this.ru(false);
                    }
                });
                c.this.ru(true);
                c.this.setFullscreen(false);
            }
        }

        @Override // com.baidu.tieba.f.a.InterfaceC0614a
        public void bO(int i, int i2) {
        }

        @Override // com.baidu.tieba.f.a.InterfaceC0614a
        public void F(int i, int i2) {
        }
    };
    private View.OnTouchListener kbp = new View.OnTouchListener() { // from class: com.baidu.tieba.pb.pb.godreply.c.2
        @Override // android.view.View.OnTouchListener
        public boolean onTouch(View view, MotionEvent motionEvent) {
            c.this.kbn.onTouchEvent(motionEvent);
            return false;
        }
    };

    public c(a aVar) {
        this.kbm = aVar;
        this.kbn = new com.baidu.tieba.f.b(aVar.kaO.getPageContext().getPageActivity());
        this.kbn.a(this.kbo);
    }

    public void initialize() {
        d cIc = this.kbm.cIc();
        if (cIc.cIj()) {
            cIc.getListView().setOnTouchListener(this.kbp);
        }
    }

    public boolean cIg() {
        return this.kbk;
    }

    public void ru(boolean z) {
        this.kbk = z;
    }

    public boolean cIh() {
        return this.kbl;
    }

    public void setFullscreen(boolean z) {
        this.kbl = z;
    }
}
