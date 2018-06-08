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
import com.baidu.tieba.d;
import com.baidu.tieba.f.a;
import com.baidu.tieba.pb.pb.sub.BlankView;
/* loaded from: classes2.dex */
public class a {
    private com.baidu.tieba.f.b bHu;
    private BaseActivity bkU;
    private boolean dur = false;
    private View.OnTouchListener dus;
    private BlankView fGa;
    private InterfaceC0212a fGb;
    private NavigationBar mNavigationBar;
    private static final int dup = l.e(TbadkCoreApplication.getInst(), d.e.ds160);
    private static final int TOUCH_SLOP = l.e(TbadkCoreApplication.getInst(), d.e.ds20);

    /* renamed from: com.baidu.tieba.pb.pb.sub.a$a  reason: collision with other inner class name */
    /* loaded from: classes2.dex */
    public interface InterfaceC0212a {
        void axb();

        void axc();

        boolean axd();
    }

    public a(BaseActivity baseActivity, View view, NavigationBar navigationBar) {
        this.bkU = baseActivity;
        this.bHu = new com.baidu.tieba.f.b(this.bkU.getPageContext().getPageActivity());
        this.mNavigationBar = navigationBar;
        this.mNavigationBar.setStatusBarVisibility(8);
        this.dus = new View.OnTouchListener() { // from class: com.baidu.tieba.pb.pb.sub.a.1
            @Override // android.view.View.OnTouchListener
            public boolean onTouch(View view2, MotionEvent motionEvent) {
                a.this.bHu.onTouchEvent(motionEvent);
                return true;
            }
        };
        view.setOnTouchListener(new View.OnTouchListener() { // from class: com.baidu.tieba.pb.pb.sub.a.2
            @Override // android.view.View.OnTouchListener
            public boolean onTouch(View view2, MotionEvent motionEvent) {
                a.this.bHu.onTouchEvent(motionEvent);
                return false;
            }
        });
        this.bHu.a(new a.InterfaceC0146a() { // from class: com.baidu.tieba.pb.pb.sub.a.3
            @Override // com.baidu.tieba.f.a.InterfaceC0146a
            public void X(int i, int i2) {
                if (a.this.fGb != null && a.this.fGb.axd() && Math.abs(i2) > a.TOUCH_SLOP) {
                    if (a.this.fGa != null) {
                        a.this.fGa.setBackgroundResource(d.C0141d.transparent);
                    }
                    a.this.bkU.finish();
                }
            }

            @Override // com.baidu.tieba.f.a.InterfaceC0146a
            public void Y(int i, int i2) {
                a.this.axe();
            }

            @Override // com.baidu.tieba.f.a.InterfaceC0146a
            public void Z(int i, int i2) {
            }
        });
    }

    public void bk(View view) {
        if (view != null) {
            view.setOnTouchListener(this.dus);
        }
    }

    public void axe() {
        if (this.dur && this.mNavigationBar != null && this.fGa != null && this.fGa.getVisibility() == 0) {
            this.mNavigationBar.setStatusBarVisibility(0);
            this.bkU.setExcludeHeight(0);
            if (this.fGb != null) {
                this.fGb.axb();
            }
            this.fGa.axl();
        }
    }

    public void axf() {
        ViewGroup viewGroup;
        if (!this.dur && (viewGroup = (ViewGroup) this.bkU.findViewById(16908290)) != null && (viewGroup.getParent() instanceof LinearLayout)) {
            this.fGa = new BlankView(this.bkU.getPageContext().getPageActivity());
            this.fGa.setBackgroundResource(d.C0141d.transparent);
            ((LinearLayout) viewGroup.getParent()).addView(this.fGa, 0, new LinearLayout.LayoutParams(-1, dup));
            this.fGa.setVisibility(0);
            this.fGa.setOnClickListener(new View.OnClickListener() { // from class: com.baidu.tieba.pb.pb.sub.a.4
                @Override // android.view.View.OnClickListener
                public void onClick(View view) {
                    a.this.bkU.finish();
                }
            });
            this.fGa.setScrollCallBack(new BlankView.a() { // from class: com.baidu.tieba.pb.pb.sub.a.5
                @Override // com.baidu.tieba.pb.pb.sub.BlankView.a
                public void axh() {
                    if (a.this.fGa != null) {
                        a.this.fGa.setVisibility(8);
                    }
                    a.this.dur = false;
                    if (a.this.fGb != null) {
                        a.this.fGb.axc();
                    }
                }
            });
            this.bkU.setExcludeHeight(dup);
            this.dur = true;
        }
    }

    public void a(InterfaceC0212a interfaceC0212a) {
        this.fGb = interfaceC0212a;
    }

    public boolean axg() {
        return this.dur;
    }

    public void kP(int i) {
        if (this.fGa != null) {
            al.i(this.fGa, i);
        }
    }
}
