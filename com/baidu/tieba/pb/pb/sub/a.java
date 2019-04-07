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
/* loaded from: classes4.dex */
public class a {
    private BaseActivity cNc;
    private com.baidu.tieba.f.b dLI;
    private boolean fnj = false;
    private View.OnTouchListener fnk;
    private BlankView hBe;
    private InterfaceC0361a hBf;
    private NavigationBar mNavigationBar;
    private static final int fnh = l.h(TbadkCoreApplication.getInst(), d.e.ds160);
    private static final int TOUCH_SLOP = l.h(TbadkCoreApplication.getInst(), d.e.ds20);

    /* renamed from: com.baidu.tieba.pb.pb.sub.a$a  reason: collision with other inner class name */
    /* loaded from: classes4.dex */
    public interface InterfaceC0361a {
        void bgA();

        boolean bgB();

        void bgz();
    }

    public a(BaseActivity baseActivity, View view, NavigationBar navigationBar) {
        this.cNc = baseActivity;
        this.dLI = new com.baidu.tieba.f.b(this.cNc.getPageContext().getPageActivity());
        this.mNavigationBar = navigationBar;
        this.mNavigationBar.setStatusBarVisibility(8);
        this.fnk = new View.OnTouchListener() { // from class: com.baidu.tieba.pb.pb.sub.a.1
            @Override // android.view.View.OnTouchListener
            public boolean onTouch(View view2, MotionEvent motionEvent) {
                a.this.dLI.onTouchEvent(motionEvent);
                return true;
            }
        };
        view.setOnTouchListener(new View.OnTouchListener() { // from class: com.baidu.tieba.pb.pb.sub.a.2
            @Override // android.view.View.OnTouchListener
            public boolean onTouch(View view2, MotionEvent motionEvent) {
                a.this.dLI.onTouchEvent(motionEvent);
                return false;
            }
        });
        this.dLI.a(new a.InterfaceC0284a() { // from class: com.baidu.tieba.pb.pb.sub.a.3
            @Override // com.baidu.tieba.f.a.InterfaceC0284a
            public void aR(int i, int i2) {
                if (a.this.hBf != null && a.this.hBf.bgB() && Math.abs(i2) > a.TOUCH_SLOP) {
                    if (a.this.hBe != null) {
                        a.this.hBe.setBackgroundResource(d.C0277d.transparent);
                    }
                    a.this.cNc.finish();
                }
            }

            @Override // com.baidu.tieba.f.a.InterfaceC0284a
            public void aS(int i, int i2) {
                a.this.bgC();
            }

            @Override // com.baidu.tieba.f.a.InterfaceC0284a
            public void aT(int i, int i2) {
            }
        });
    }

    public void cu(View view) {
        if (view != null) {
            view.setOnTouchListener(this.fnk);
        }
    }

    public void bgC() {
        if (this.fnj && this.mNavigationBar != null && this.hBe != null && this.hBe.getVisibility() == 0) {
            this.mNavigationBar.setStatusBarVisibility(0);
            this.cNc.setExcludeHeight(0);
            if (this.hBf != null) {
                this.hBf.bgz();
            }
            this.hBe.bgJ();
        }
    }

    public void bgD() {
        ViewGroup viewGroup;
        if (!this.fnj && (viewGroup = (ViewGroup) this.cNc.findViewById(16908290)) != null && (viewGroup.getParent() instanceof LinearLayout)) {
            this.hBe = new BlankView(this.cNc.getPageContext().getPageActivity());
            this.hBe.setBackgroundResource(d.C0277d.transparent);
            ((LinearLayout) viewGroup.getParent()).addView(this.hBe, 0, new LinearLayout.LayoutParams(-1, fnh));
            this.hBe.setVisibility(0);
            this.hBe.setOnClickListener(new View.OnClickListener() { // from class: com.baidu.tieba.pb.pb.sub.a.4
                @Override // android.view.View.OnClickListener
                public void onClick(View view) {
                    a.this.cNc.finish();
                }
            });
            this.hBe.setScrollCallBack(new BlankView.a() { // from class: com.baidu.tieba.pb.pb.sub.a.5
                @Override // com.baidu.tieba.pb.pb.sub.BlankView.a
                public void bgF() {
                    if (a.this.hBe != null) {
                        a.this.hBe.setVisibility(8);
                    }
                    a.this.fnj = false;
                    if (a.this.hBf != null) {
                        a.this.hBf.bgA();
                    }
                }
            });
            this.cNc.setExcludeHeight(fnh);
            this.fnj = true;
        }
    }

    public void a(InterfaceC0361a interfaceC0361a) {
        this.hBf = interfaceC0361a;
    }

    public boolean bgE() {
        return this.fnj;
    }

    public void qL(int i) {
        if (this.hBe != null) {
            al.k(this.hBe, i);
        }
    }
}
