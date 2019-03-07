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
    private BaseActivity cNd;
    private com.baidu.tieba.f.b dMv;
    private boolean fny = false;
    private View.OnTouchListener fnz;
    private BlankView hBx;
    private InterfaceC0288a hBy;
    private NavigationBar mNavigationBar;
    private static final int fnw = l.h(TbadkCoreApplication.getInst(), d.e.ds160);
    private static final int TOUCH_SLOP = l.h(TbadkCoreApplication.getInst(), d.e.ds20);

    /* renamed from: com.baidu.tieba.pb.pb.sub.a$a  reason: collision with other inner class name */
    /* loaded from: classes4.dex */
    public interface InterfaceC0288a {
        void bgB();

        void bgC();

        boolean bgD();
    }

    public a(BaseActivity baseActivity, View view, NavigationBar navigationBar) {
        this.cNd = baseActivity;
        this.dMv = new com.baidu.tieba.f.b(this.cNd.getPageContext().getPageActivity());
        this.mNavigationBar = navigationBar;
        this.mNavigationBar.setStatusBarVisibility(8);
        this.fnz = new View.OnTouchListener() { // from class: com.baidu.tieba.pb.pb.sub.a.1
            @Override // android.view.View.OnTouchListener
            public boolean onTouch(View view2, MotionEvent motionEvent) {
                a.this.dMv.onTouchEvent(motionEvent);
                return true;
            }
        };
        view.setOnTouchListener(new View.OnTouchListener() { // from class: com.baidu.tieba.pb.pb.sub.a.2
            @Override // android.view.View.OnTouchListener
            public boolean onTouch(View view2, MotionEvent motionEvent) {
                a.this.dMv.onTouchEvent(motionEvent);
                return false;
            }
        });
        this.dMv.a(new a.InterfaceC0243a() { // from class: com.baidu.tieba.pb.pb.sub.a.3
            @Override // com.baidu.tieba.f.a.InterfaceC0243a
            public void aR(int i, int i2) {
                if (a.this.hBy != null && a.this.hBy.bgD() && Math.abs(i2) > a.TOUCH_SLOP) {
                    if (a.this.hBx != null) {
                        a.this.hBx.setBackgroundResource(d.C0236d.transparent);
                    }
                    a.this.cNd.finish();
                }
            }

            @Override // com.baidu.tieba.f.a.InterfaceC0243a
            public void aS(int i, int i2) {
                a.this.bgE();
            }

            @Override // com.baidu.tieba.f.a.InterfaceC0243a
            public void aT(int i, int i2) {
            }
        });
    }

    public void cu(View view) {
        if (view != null) {
            view.setOnTouchListener(this.fnz);
        }
    }

    public void bgE() {
        if (this.fny && this.mNavigationBar != null && this.hBx != null && this.hBx.getVisibility() == 0) {
            this.mNavigationBar.setStatusBarVisibility(0);
            this.cNd.setExcludeHeight(0);
            if (this.hBy != null) {
                this.hBy.bgB();
            }
            this.hBx.bgL();
        }
    }

    public void bgF() {
        ViewGroup viewGroup;
        if (!this.fny && (viewGroup = (ViewGroup) this.cNd.findViewById(16908290)) != null && (viewGroup.getParent() instanceof LinearLayout)) {
            this.hBx = new BlankView(this.cNd.getPageContext().getPageActivity());
            this.hBx.setBackgroundResource(d.C0236d.transparent);
            ((LinearLayout) viewGroup.getParent()).addView(this.hBx, 0, new LinearLayout.LayoutParams(-1, fnw));
            this.hBx.setVisibility(0);
            this.hBx.setOnClickListener(new View.OnClickListener() { // from class: com.baidu.tieba.pb.pb.sub.a.4
                @Override // android.view.View.OnClickListener
                public void onClick(View view) {
                    a.this.cNd.finish();
                }
            });
            this.hBx.setScrollCallBack(new BlankView.a() { // from class: com.baidu.tieba.pb.pb.sub.a.5
                @Override // com.baidu.tieba.pb.pb.sub.BlankView.a
                public void bgH() {
                    if (a.this.hBx != null) {
                        a.this.hBx.setVisibility(8);
                    }
                    a.this.fny = false;
                    if (a.this.hBy != null) {
                        a.this.hBy.bgC();
                    }
                }
            });
            this.cNd.setExcludeHeight(fnw);
            this.fny = true;
        }
    }

    public void a(InterfaceC0288a interfaceC0288a) {
        this.hBy = interfaceC0288a;
    }

    public boolean bgG() {
        return this.fny;
    }

    public void qP(int i) {
        if (this.hBx != null) {
            al.k(this.hBx, i);
        }
    }
}
