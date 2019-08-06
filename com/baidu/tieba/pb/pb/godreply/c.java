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
    private boolean hKs;
    private boolean hKt;
    private final a hKu;
    private final com.baidu.tieba.f.b hKv;
    private a.InterfaceC0305a hKw = new a.InterfaceC0305a() { // from class: com.baidu.tieba.pb.pb.godreply.c.1
        @Override // com.baidu.tieba.f.a.InterfaceC0305a
        public void aY(int i, int i2) {
            if (c.this.hKu.isActive() && !c.this.bTT() && c.this.hKu.bTP().bTZ() && Math.abs(i2) > c.TOUCH_SLOP) {
                c.this.hKu.q(new Runnable() { // from class: com.baidu.tieba.pb.pb.godreply.c.1.1
                    @Override // java.lang.Runnable
                    public void run() {
                        c.this.oj(false);
                    }
                });
                c.this.oj(true);
                c.this.setFullscreen(false);
            }
        }

        @Override // com.baidu.tieba.f.a.InterfaceC0305a
        public void aZ(int i, int i2) {
            if (c.this.hKu.isActive() && !c.this.bTT() && !c.this.bTU()) {
                c.this.oj(true);
                c.this.setFullscreen(true);
                c.this.hKu.bTP().r(new Runnable() { // from class: com.baidu.tieba.pb.pb.godreply.c.1.2
                    @Override // java.lang.Runnable
                    public void run() {
                        c.this.oj(false);
                    }
                });
            }
        }

        @Override // com.baidu.tieba.f.a.InterfaceC0305a
        public void ba(int i, int i2) {
        }
    };
    private View.OnTouchListener hKx = new View.OnTouchListener() { // from class: com.baidu.tieba.pb.pb.godreply.c.2
        @Override // android.view.View.OnTouchListener
        public boolean onTouch(View view, MotionEvent motionEvent) {
            c.this.hKv.onTouchEvent(motionEvent);
            return false;
        }
    };

    public c(a aVar) {
        this.hKu = aVar;
        this.hKv = new com.baidu.tieba.f.b(aVar.hJW.getPageContext().getPageActivity());
        this.hKv.a(this.hKw);
    }

    public void initialize() {
        d bTP = this.hKu.bTP();
        if (bTP.bTW()) {
            bTP.getListView().setOnTouchListener(this.hKx);
        }
    }

    public boolean bTT() {
        return this.hKs;
    }

    public void oj(boolean z) {
        this.hKs = z;
    }

    public boolean bTU() {
        return this.hKt;
    }

    public void setFullscreen(boolean z) {
        this.hKt = z;
    }
}
