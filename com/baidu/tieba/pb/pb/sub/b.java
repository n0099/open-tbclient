package com.baidu.tieba.pb.pb.sub;

import android.view.MotionEvent;
import android.view.View;
import android.view.ViewGroup;
import android.widget.LinearLayout;
import com.baidu.adp.lib.util.l;
import com.baidu.tbadk.BaseActivity;
import com.baidu.tbadk.core.TbadkCoreApplication;
import com.baidu.tbadk.core.util.aj;
import com.baidu.tbadk.core.view.NavigationBar;
import com.baidu.tieba.d;
import com.baidu.tieba.e.a;
import com.baidu.tieba.pb.pb.sub.a;
/* loaded from: classes2.dex */
public class b {
    private com.baidu.tieba.e.b ckD;
    private BaseActivity cmI;
    private boolean dHX = false;
    private View.OnTouchListener dHY;
    private com.baidu.tieba.pb.pb.sub.a fUn;
    private a fUo;
    private NavigationBar mNavigationBar;
    private static final int dHV = l.s(TbadkCoreApplication.getInst(), d.e.ds160);
    private static final int TOUCH_SLOP = l.s(TbadkCoreApplication.getInst(), d.e.ds20);

    /* loaded from: classes2.dex */
    public interface a {
        void awa();

        void awb();

        boolean awc();
    }

    public b(BaseActivity baseActivity, View view, NavigationBar navigationBar) {
        this.cmI = baseActivity;
        this.ckD = new com.baidu.tieba.e.b(this.cmI.getPageContext().getPageActivity());
        this.mNavigationBar = navigationBar;
        this.mNavigationBar.setStatusBarVisibility(8);
        this.dHY = new View.OnTouchListener() { // from class: com.baidu.tieba.pb.pb.sub.b.1
            @Override // android.view.View.OnTouchListener
            public boolean onTouch(View view2, MotionEvent motionEvent) {
                b.this.ckD.onTouchEvent(motionEvent);
                return true;
            }
        };
        view.setOnTouchListener(new View.OnTouchListener() { // from class: com.baidu.tieba.pb.pb.sub.b.2
            @Override // android.view.View.OnTouchListener
            public boolean onTouch(View view2, MotionEvent motionEvent) {
                b.this.ckD.onTouchEvent(motionEvent);
                return false;
            }
        });
        this.ckD.a(new a.InterfaceC0109a() { // from class: com.baidu.tieba.pb.pb.sub.b.3
            @Override // com.baidu.tieba.e.a.InterfaceC0109a
            public void aY(int i, int i2) {
                if (b.this.fUo != null && b.this.fUo.awc() && Math.abs(i2) > b.TOUCH_SLOP) {
                    if (b.this.fUn != null) {
                        b.this.fUn.setBackgroundResource(d.C0108d.transparent);
                    }
                    b.this.cmI.finish();
                }
            }

            @Override // com.baidu.tieba.e.a.InterfaceC0109a
            public void aZ(int i, int i2) {
                b.this.awd();
            }

            @Override // com.baidu.tieba.e.a.InterfaceC0109a
            public void ba(int i, int i2) {
            }
        });
    }

    public void cA(View view) {
        if (view != null) {
            view.setOnTouchListener(this.dHY);
        }
    }

    public void awd() {
        if (this.dHX && this.mNavigationBar != null && this.fUn != null && this.fUn.getVisibility() == 0) {
            this.mNavigationBar.setStatusBarVisibility(0);
            this.cmI.setExcludeHeight(0);
            if (this.fUo != null) {
                this.fUo.awa();
            }
            this.fUn.awk();
        }
    }

    public void awe() {
        ViewGroup viewGroup;
        if (!this.dHX && (viewGroup = (ViewGroup) this.cmI.findViewById(16908290)) != null && (viewGroup.getParent() instanceof LinearLayout)) {
            this.fUn = new com.baidu.tieba.pb.pb.sub.a(this.cmI.getPageContext().getPageActivity());
            this.fUn.setBackgroundResource(d.C0108d.transparent);
            ((LinearLayout) viewGroup.getParent()).addView(this.fUn, 0, new LinearLayout.LayoutParams(-1, dHV));
            this.fUn.setVisibility(0);
            this.fUn.setOnClickListener(new View.OnClickListener() { // from class: com.baidu.tieba.pb.pb.sub.b.4
                @Override // android.view.View.OnClickListener
                public void onClick(View view) {
                    b.this.cmI.finish();
                }
            });
            this.fUn.setScrollCallBack(new a.InterfaceC0145a() { // from class: com.baidu.tieba.pb.pb.sub.b.5
                @Override // com.baidu.tieba.pb.pb.sub.a.InterfaceC0145a
                public void awg() {
                    if (b.this.fUn != null) {
                        b.this.fUn.setVisibility(8);
                    }
                    b.this.dHX = false;
                    if (b.this.fUo != null) {
                        b.this.fUo.awb();
                    }
                }
            });
            this.cmI.setExcludeHeight(dHV);
            this.dHX = true;
        }
    }

    public void a(a aVar) {
        this.fUo = aVar;
    }

    public boolean awf() {
        return this.dHX;
    }

    public void nw(int i) {
        if (this.fUn != null) {
            aj.s(this.fUn, i);
        }
    }
}
