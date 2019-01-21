package com.baidu.tieba.pb.pb.sub;

import android.view.MotionEvent;
import android.view.View;
import android.view.ViewGroup;
import android.widget.LinearLayout;
import com.baidu.adp.lib.util.l;
import com.baidu.tbadk.BaseActivity;
import com.baidu.tbadk.core.TbadkCoreApplication;
import com.baidu.tbadk.core.util.al;
import com.baidu.tbadk.core.view.NavigationBar;
import com.baidu.tieba.e;
import com.baidu.tieba.f.a;
import com.baidu.tieba.pb.pb.sub.BlankView;
/* loaded from: classes6.dex */
public class a {
    private BaseActivity bBW;
    private com.baidu.tieba.f.b cxB;
    private boolean dZV = false;
    private View.OnTouchListener dZW;
    private BlankView glx;
    private InterfaceC0290a gly;
    private NavigationBar mNavigationBar;
    private static final int dZT = l.h(TbadkCoreApplication.getInst(), e.C0210e.ds160);
    private static final int TOUCH_SLOP = l.h(TbadkCoreApplication.getInst(), e.C0210e.ds20);

    /* renamed from: com.baidu.tieba.pb.pb.sub.a$a  reason: collision with other inner class name */
    /* loaded from: classes6.dex */
    public interface InterfaceC0290a {
        void aGj();

        void aGk();

        boolean aGl();
    }

    public a(BaseActivity baseActivity, View view, NavigationBar navigationBar) {
        this.bBW = baseActivity;
        this.cxB = new com.baidu.tieba.f.b(this.bBW.getPageContext().getPageActivity());
        this.mNavigationBar = navigationBar;
        this.mNavigationBar.setStatusBarVisibility(8);
        this.dZW = new View.OnTouchListener() { // from class: com.baidu.tieba.pb.pb.sub.a.1
            @Override // android.view.View.OnTouchListener
            public boolean onTouch(View view2, MotionEvent motionEvent) {
                a.this.cxB.onTouchEvent(motionEvent);
                return true;
            }
        };
        view.setOnTouchListener(new View.OnTouchListener() { // from class: com.baidu.tieba.pb.pb.sub.a.2
            @Override // android.view.View.OnTouchListener
            public boolean onTouch(View view2, MotionEvent motionEvent) {
                a.this.cxB.onTouchEvent(motionEvent);
                return false;
            }
        });
        this.cxB.a(new a.InterfaceC0214a() { // from class: com.baidu.tieba.pb.pb.sub.a.3
            @Override // com.baidu.tieba.f.a.InterfaceC0214a
            public void ar(int i, int i2) {
                if (a.this.gly != null && a.this.gly.aGl() && Math.abs(i2) > a.TOUCH_SLOP) {
                    if (a.this.glx != null) {
                        a.this.glx.setBackgroundResource(e.d.transparent);
                    }
                    a.this.bBW.finish();
                }
            }

            @Override // com.baidu.tieba.f.a.InterfaceC0214a
            public void as(int i, int i2) {
                a.this.aGm();
            }

            @Override // com.baidu.tieba.f.a.InterfaceC0214a
            public void at(int i, int i2) {
            }
        });
    }

    public void bI(View view) {
        if (view != null) {
            view.setOnTouchListener(this.dZW);
        }
    }

    public void aGm() {
        if (this.dZV && this.mNavigationBar != null && this.glx != null && this.glx.getVisibility() == 0) {
            this.mNavigationBar.setStatusBarVisibility(0);
            this.bBW.setExcludeHeight(0);
            if (this.gly != null) {
                this.gly.aGj();
            }
            this.glx.aGt();
        }
    }

    public void aGn() {
        ViewGroup viewGroup;
        if (!this.dZV && (viewGroup = (ViewGroup) this.bBW.findViewById(16908290)) != null && (viewGroup.getParent() instanceof LinearLayout)) {
            this.glx = new BlankView(this.bBW.getPageContext().getPageActivity());
            this.glx.setBackgroundResource(e.d.transparent);
            ((LinearLayout) viewGroup.getParent()).addView(this.glx, 0, new LinearLayout.LayoutParams(-1, dZT));
            this.glx.setVisibility(0);
            this.glx.setOnClickListener(new View.OnClickListener() { // from class: com.baidu.tieba.pb.pb.sub.a.4
                @Override // android.view.View.OnClickListener
                public void onClick(View view) {
                    a.this.bBW.finish();
                }
            });
            this.glx.setScrollCallBack(new BlankView.a() { // from class: com.baidu.tieba.pb.pb.sub.a.5
                @Override // com.baidu.tieba.pb.pb.sub.BlankView.a
                public void aGp() {
                    if (a.this.glx != null) {
                        a.this.glx.setVisibility(8);
                    }
                    a.this.dZV = false;
                    if (a.this.gly != null) {
                        a.this.gly.aGk();
                    }
                }
            });
            this.bBW.setExcludeHeight(dZT);
            this.dZV = true;
        }
    }

    public void a(InterfaceC0290a interfaceC0290a) {
        this.gly = interfaceC0290a;
    }

    public boolean aGo() {
        return this.dZV;
    }

    public void nc(int i) {
        if (this.glx != null) {
            al.i(this.glx, i);
        }
    }
}
