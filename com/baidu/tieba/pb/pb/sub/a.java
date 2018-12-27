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
    private BaseActivity bBi;
    private com.baidu.tieba.f.b cwP;
    private boolean dZo = false;
    private View.OnTouchListener dZp;
    private BlankView gkt;
    private InterfaceC0290a gku;
    private NavigationBar mNavigationBar;
    private static final int dZm = l.h(TbadkCoreApplication.getInst(), e.C0210e.ds160);
    private static final int TOUCH_SLOP = l.h(TbadkCoreApplication.getInst(), e.C0210e.ds20);

    /* renamed from: com.baidu.tieba.pb.pb.sub.a$a  reason: collision with other inner class name */
    /* loaded from: classes6.dex */
    public interface InterfaceC0290a {
        void aFM();

        void aFN();

        boolean aFO();
    }

    public a(BaseActivity baseActivity, View view, NavigationBar navigationBar) {
        this.bBi = baseActivity;
        this.cwP = new com.baidu.tieba.f.b(this.bBi.getPageContext().getPageActivity());
        this.mNavigationBar = navigationBar;
        this.mNavigationBar.setStatusBarVisibility(8);
        this.dZp = new View.OnTouchListener() { // from class: com.baidu.tieba.pb.pb.sub.a.1
            @Override // android.view.View.OnTouchListener
            public boolean onTouch(View view2, MotionEvent motionEvent) {
                a.this.cwP.onTouchEvent(motionEvent);
                return true;
            }
        };
        view.setOnTouchListener(new View.OnTouchListener() { // from class: com.baidu.tieba.pb.pb.sub.a.2
            @Override // android.view.View.OnTouchListener
            public boolean onTouch(View view2, MotionEvent motionEvent) {
                a.this.cwP.onTouchEvent(motionEvent);
                return false;
            }
        });
        this.cwP.a(new a.InterfaceC0214a() { // from class: com.baidu.tieba.pb.pb.sub.a.3
            @Override // com.baidu.tieba.f.a.InterfaceC0214a
            public void ar(int i, int i2) {
                if (a.this.gku != null && a.this.gku.aFO() && Math.abs(i2) > a.TOUCH_SLOP) {
                    if (a.this.gkt != null) {
                        a.this.gkt.setBackgroundResource(e.d.transparent);
                    }
                    a.this.bBi.finish();
                }
            }

            @Override // com.baidu.tieba.f.a.InterfaceC0214a
            public void as(int i, int i2) {
                a.this.aFP();
            }

            @Override // com.baidu.tieba.f.a.InterfaceC0214a
            public void at(int i, int i2) {
            }
        });
    }

    public void bI(View view) {
        if (view != null) {
            view.setOnTouchListener(this.dZp);
        }
    }

    public void aFP() {
        if (this.dZo && this.mNavigationBar != null && this.gkt != null && this.gkt.getVisibility() == 0) {
            this.mNavigationBar.setStatusBarVisibility(0);
            this.bBi.setExcludeHeight(0);
            if (this.gku != null) {
                this.gku.aFM();
            }
            this.gkt.aFW();
        }
    }

    public void aFQ() {
        ViewGroup viewGroup;
        if (!this.dZo && (viewGroup = (ViewGroup) this.bBi.findViewById(16908290)) != null && (viewGroup.getParent() instanceof LinearLayout)) {
            this.gkt = new BlankView(this.bBi.getPageContext().getPageActivity());
            this.gkt.setBackgroundResource(e.d.transparent);
            ((LinearLayout) viewGroup.getParent()).addView(this.gkt, 0, new LinearLayout.LayoutParams(-1, dZm));
            this.gkt.setVisibility(0);
            this.gkt.setOnClickListener(new View.OnClickListener() { // from class: com.baidu.tieba.pb.pb.sub.a.4
                @Override // android.view.View.OnClickListener
                public void onClick(View view) {
                    a.this.bBi.finish();
                }
            });
            this.gkt.setScrollCallBack(new BlankView.a() { // from class: com.baidu.tieba.pb.pb.sub.a.5
                @Override // com.baidu.tieba.pb.pb.sub.BlankView.a
                public void aFS() {
                    if (a.this.gkt != null) {
                        a.this.gkt.setVisibility(8);
                    }
                    a.this.dZo = false;
                    if (a.this.gku != null) {
                        a.this.gku.aFN();
                    }
                }
            });
            this.bBi.setExcludeHeight(dZm);
            this.dZo = true;
        }
    }

    public void a(InterfaceC0290a interfaceC0290a) {
        this.gku = interfaceC0290a;
    }

    public boolean aFR() {
        return this.dZo;
    }

    public void nb(int i) {
        if (this.gkt != null) {
            al.i(this.gkt, i);
        }
    }
}
