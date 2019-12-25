package com.baidu.tieba.pb.pb.godreply;

import android.view.MotionEvent;
import android.view.View;
import com.baidu.adp.lib.util.l;
import com.baidu.tbadk.core.TbadkCoreApplication;
import com.baidu.tieba.R;
import com.baidu.tieba.f.a;
/* loaded from: classes6.dex */
public class c {
    private static final int TOUCH_SLOP = l.getDimens(TbadkCoreApplication.getInst(), R.dimen.ds20);
    private boolean iyp;
    private boolean iyq;
    private final a iyr;
    private final com.baidu.tieba.f.b iys;
    private a.InterfaceC0488a iyt = new a.InterfaceC0488a() { // from class: com.baidu.tieba.pb.pb.godreply.c.1
        @Override // com.baidu.tieba.f.a.InterfaceC0488a
        public void u(int i, int i2) {
            if (c.this.iyr.isActive() && !c.this.ciW() && !c.this.ciX()) {
                c.this.pk(true);
                c.this.setFullscreen(true);
                c.this.iyr.ciS().r(new Runnable() { // from class: com.baidu.tieba.pb.pb.godreply.c.1.1
                    @Override // java.lang.Runnable
                    public void run() {
                        c.this.pk(false);
                    }
                });
            }
        }

        @Override // com.baidu.tieba.f.a.InterfaceC0488a
        public void v(int i, int i2) {
            if (c.this.iyr.isActive() && !c.this.ciW() && c.this.iyr.ciS().cjc() && Math.abs(i2) > c.TOUCH_SLOP) {
                c.this.iyr.q(new Runnable() { // from class: com.baidu.tieba.pb.pb.godreply.c.1.2
                    @Override // java.lang.Runnable
                    public void run() {
                        c.this.pk(false);
                    }
                });
                c.this.pk(true);
                c.this.setFullscreen(false);
            }
        }

        @Override // com.baidu.tieba.f.a.InterfaceC0488a
        public void bA(int i, int i2) {
        }

        @Override // com.baidu.tieba.f.a.InterfaceC0488a
        public void w(int i, int i2) {
        }
    };
    private View.OnTouchListener iyu = new View.OnTouchListener() { // from class: com.baidu.tieba.pb.pb.godreply.c.2
        @Override // android.view.View.OnTouchListener
        public boolean onTouch(View view, MotionEvent motionEvent) {
            c.this.iys.onTouchEvent(motionEvent);
            return false;
        }
    };

    public c(a aVar) {
        this.iyr = aVar;
        this.iys = new com.baidu.tieba.f.b(aVar.ixS.getPageContext().getPageActivity());
        this.iys.a(this.iyt);
    }

    public void initialize() {
        d ciS = this.iyr.ciS();
        if (ciS.ciZ()) {
            ciS.getListView().setOnTouchListener(this.iyu);
        }
    }

    public boolean ciW() {
        return this.iyp;
    }

    public void pk(boolean z) {
        this.iyp = z;
    }

    public boolean ciX() {
        return this.iyq;
    }

    public void setFullscreen(boolean z) {
        this.iyq = z;
    }
}
