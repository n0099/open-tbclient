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
/* loaded from: classes.dex */
public class b {
    private BaseActivity boA;
    private com.baidu.tieba.e.b ctr;
    private com.baidu.tieba.pb.pb.sub.a eQh;
    private a eQj;
    private boolean eQk = false;
    private View.OnTouchListener eQl;
    private NavigationBar mNavigationBar;
    private static final int eQi = l.f(TbadkCoreApplication.getInst(), d.f.ds160);
    private static final int TOUCH_SLOP = l.f(TbadkCoreApplication.getInst(), d.f.ds20);

    /* loaded from: classes.dex */
    public interface a {
        void aSU();

        void aSV();

        boolean aSW();
    }

    public b(BaseActivity baseActivity, View view, NavigationBar navigationBar) {
        this.boA = baseActivity;
        this.ctr = new com.baidu.tieba.e.b(this.boA.getPageContext().getPageActivity());
        this.mNavigationBar = navigationBar;
        this.mNavigationBar.setStatusBarVisibility(8);
        this.eQl = new View.OnTouchListener() { // from class: com.baidu.tieba.pb.pb.sub.b.1
            @Override // android.view.View.OnTouchListener
            public boolean onTouch(View view2, MotionEvent motionEvent) {
                b.this.ctr.onTouchEvent(motionEvent);
                return true;
            }
        };
        view.setOnTouchListener(new View.OnTouchListener() { // from class: com.baidu.tieba.pb.pb.sub.b.2
            @Override // android.view.View.OnTouchListener
            public boolean onTouch(View view2, MotionEvent motionEvent) {
                b.this.ctr.onTouchEvent(motionEvent);
                return false;
            }
        });
        this.ctr.a(new a.InterfaceC0081a() { // from class: com.baidu.tieba.pb.pb.sub.b.3
            @Override // com.baidu.tieba.e.a.InterfaceC0081a
            public void ao(int i, int i2) {
                if (b.this.eQj != null && b.this.eQj.aSW() && Math.abs(i2) > b.TOUCH_SLOP) {
                    if (b.this.eQh != null) {
                        b.this.eQh.setBackgroundResource(d.e.transparent);
                    }
                    b.this.boA.finish();
                }
            }

            @Override // com.baidu.tieba.e.a.InterfaceC0081a
            public void ap(int i, int i2) {
                b.this.aSR();
            }

            @Override // com.baidu.tieba.e.a.InterfaceC0081a
            public void aq(int i, int i2) {
            }
        });
    }

    public void bm(View view) {
        if (view != null) {
            view.setOnTouchListener(this.eQl);
        }
    }

    public void aSR() {
        if (this.eQk && this.mNavigationBar != null && this.eQh != null && this.eQh.getVisibility() == 0) {
            this.mNavigationBar.setStatusBarVisibility(0);
            this.boA.setExcludeHeight(0);
            if (this.eQj != null) {
                this.eQj.aSU();
            }
            this.eQh.aSP();
        }
    }

    public void aSS() {
        ViewGroup viewGroup;
        if (!this.eQk && (viewGroup = (ViewGroup) this.boA.findViewById(16908290)) != null && (viewGroup.getParent() instanceof LinearLayout)) {
            this.eQh = new com.baidu.tieba.pb.pb.sub.a(this.boA.getPageContext().getPageActivity());
            this.eQh.setBackgroundResource(d.e.transparent);
            ((LinearLayout) viewGroup.getParent()).addView(this.eQh, 0, new LinearLayout.LayoutParams(-1, eQi));
            this.eQh.setVisibility(0);
            this.eQh.setOnClickListener(new View.OnClickListener() { // from class: com.baidu.tieba.pb.pb.sub.b.4
                @Override // android.view.View.OnClickListener
                public void onClick(View view) {
                    b.this.boA.finish();
                }
            });
            this.eQh.setScrollCallBack(new a.InterfaceC0115a() { // from class: com.baidu.tieba.pb.pb.sub.b.5
                @Override // com.baidu.tieba.pb.pb.sub.a.InterfaceC0115a
                public void aSQ() {
                    if (b.this.eQh != null) {
                        b.this.eQh.setVisibility(8);
                    }
                    b.this.eQk = false;
                    if (b.this.eQj != null) {
                        b.this.eQj.aSV();
                    }
                }
            });
            this.boA.setExcludeHeight(eQi);
            this.eQk = true;
        }
    }

    public void a(a aVar) {
        this.eQj = aVar;
    }

    public boolean aST() {
        return this.eQk;
    }

    public void pH(int i) {
        if (this.eQh != null) {
            aj.j(this.eQh, i);
        }
    }
}
