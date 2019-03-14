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
    private BaseActivity cNa;
    private com.baidu.tieba.f.b dMr;
    private boolean fnx = false;
    private View.OnTouchListener fny;
    private BlankView hBs;
    private InterfaceC0361a hBt;
    private NavigationBar mNavigationBar;
    private static final int fnv = l.h(TbadkCoreApplication.getInst(), d.e.ds160);
    private static final int TOUCH_SLOP = l.h(TbadkCoreApplication.getInst(), d.e.ds20);

    /* renamed from: com.baidu.tieba.pb.pb.sub.a$a  reason: collision with other inner class name */
    /* loaded from: classes4.dex */
    public interface InterfaceC0361a {
        void bgB();

        void bgC();

        boolean bgD();
    }

    public a(BaseActivity baseActivity, View view, NavigationBar navigationBar) {
        this.cNa = baseActivity;
        this.dMr = new com.baidu.tieba.f.b(this.cNa.getPageContext().getPageActivity());
        this.mNavigationBar = navigationBar;
        this.mNavigationBar.setStatusBarVisibility(8);
        this.fny = new View.OnTouchListener() { // from class: com.baidu.tieba.pb.pb.sub.a.1
            @Override // android.view.View.OnTouchListener
            public boolean onTouch(View view2, MotionEvent motionEvent) {
                a.this.dMr.onTouchEvent(motionEvent);
                return true;
            }
        };
        view.setOnTouchListener(new View.OnTouchListener() { // from class: com.baidu.tieba.pb.pb.sub.a.2
            @Override // android.view.View.OnTouchListener
            public boolean onTouch(View view2, MotionEvent motionEvent) {
                a.this.dMr.onTouchEvent(motionEvent);
                return false;
            }
        });
        this.dMr.a(new a.InterfaceC0284a() { // from class: com.baidu.tieba.pb.pb.sub.a.3
            @Override // com.baidu.tieba.f.a.InterfaceC0284a
            public void aR(int i, int i2) {
                if (a.this.hBt != null && a.this.hBt.bgD() && Math.abs(i2) > a.TOUCH_SLOP) {
                    if (a.this.hBs != null) {
                        a.this.hBs.setBackgroundResource(d.C0277d.transparent);
                    }
                    a.this.cNa.finish();
                }
            }

            @Override // com.baidu.tieba.f.a.InterfaceC0284a
            public void aS(int i, int i2) {
                a.this.bgE();
            }

            @Override // com.baidu.tieba.f.a.InterfaceC0284a
            public void aT(int i, int i2) {
            }
        });
    }

    public void cu(View view) {
        if (view != null) {
            view.setOnTouchListener(this.fny);
        }
    }

    public void bgE() {
        if (this.fnx && this.mNavigationBar != null && this.hBs != null && this.hBs.getVisibility() == 0) {
            this.mNavigationBar.setStatusBarVisibility(0);
            this.cNa.setExcludeHeight(0);
            if (this.hBt != null) {
                this.hBt.bgB();
            }
            this.hBs.bgL();
        }
    }

    public void bgF() {
        ViewGroup viewGroup;
        if (!this.fnx && (viewGroup = (ViewGroup) this.cNa.findViewById(16908290)) != null && (viewGroup.getParent() instanceof LinearLayout)) {
            this.hBs = new BlankView(this.cNa.getPageContext().getPageActivity());
            this.hBs.setBackgroundResource(d.C0277d.transparent);
            ((LinearLayout) viewGroup.getParent()).addView(this.hBs, 0, new LinearLayout.LayoutParams(-1, fnv));
            this.hBs.setVisibility(0);
            this.hBs.setOnClickListener(new View.OnClickListener() { // from class: com.baidu.tieba.pb.pb.sub.a.4
                @Override // android.view.View.OnClickListener
                public void onClick(View view) {
                    a.this.cNa.finish();
                }
            });
            this.hBs.setScrollCallBack(new BlankView.a() { // from class: com.baidu.tieba.pb.pb.sub.a.5
                @Override // com.baidu.tieba.pb.pb.sub.BlankView.a
                public void bgH() {
                    if (a.this.hBs != null) {
                        a.this.hBs.setVisibility(8);
                    }
                    a.this.fnx = false;
                    if (a.this.hBt != null) {
                        a.this.hBt.bgC();
                    }
                }
            });
            this.cNa.setExcludeHeight(fnv);
            this.fnx = true;
        }
    }

    public void a(InterfaceC0361a interfaceC0361a) {
        this.hBt = interfaceC0361a;
    }

    public boolean bgG() {
        return this.fnx;
    }

    public void qP(int i) {
        if (this.hBs != null) {
            al.k(this.hBs, i);
        }
    }
}
