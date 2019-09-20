package com.baidu.tieba.pb.pb.sub;

import android.view.MotionEvent;
import android.view.View;
import android.view.ViewGroup;
import android.widget.LinearLayout;
import com.baidu.adp.lib.util.l;
import com.baidu.tbadk.BaseActivity;
import com.baidu.tbadk.core.TbadkCoreApplication;
import com.baidu.tbadk.core.util.am;
import com.baidu.tbadk.core.view.NavigationBar;
import com.baidu.tieba.R;
import com.baidu.tieba.f.a;
import com.baidu.tieba.pb.pb.sub.BlankView;
/* loaded from: classes4.dex */
public class a {
    private BaseActivity cXM;
    private com.baidu.tieba.f.b ebS;
    private View.OnTouchListener fLh;
    private BlankView icr;
    private InterfaceC0396a ics;
    private NavigationBar mNavigationBar;
    private static final int fLe = l.g(TbadkCoreApplication.getInst(), R.dimen.ds160);
    private static final int TOUCH_SLOP = l.g(TbadkCoreApplication.getInst(), R.dimen.ds20);
    private boolean fLg = false;
    private int ict = R.color.transparent;

    /* renamed from: com.baidu.tieba.pb.pb.sub.a$a  reason: collision with other inner class name */
    /* loaded from: classes4.dex */
    public interface InterfaceC0396a {
        void bqT();

        void bqU();

        boolean bqV();
    }

    public a(BaseActivity baseActivity, View view, NavigationBar navigationBar) {
        this.cXM = baseActivity;
        this.ebS = new com.baidu.tieba.f.b(this.cXM.getPageContext().getPageActivity());
        this.mNavigationBar = navigationBar;
        this.mNavigationBar.setStatusBarVisibility(8);
        this.fLh = new View.OnTouchListener() { // from class: com.baidu.tieba.pb.pb.sub.a.1
            @Override // android.view.View.OnTouchListener
            public boolean onTouch(View view2, MotionEvent motionEvent) {
                a.this.ebS.onTouchEvent(motionEvent);
                return true;
            }
        };
        view.setOnTouchListener(new View.OnTouchListener() { // from class: com.baidu.tieba.pb.pb.sub.a.2
            @Override // android.view.View.OnTouchListener
            public boolean onTouch(View view2, MotionEvent motionEvent) {
                a.this.ebS.onTouchEvent(motionEvent);
                return false;
            }
        });
        this.ebS.a(new a.InterfaceC0316a() { // from class: com.baidu.tieba.pb.pb.sub.a.3
            @Override // com.baidu.tieba.f.a.InterfaceC0316a
            public void aY(int i, int i2) {
                if (a.this.ics != null && a.this.ics.bqV() && Math.abs(i2) > a.TOUCH_SLOP) {
                    if (a.this.icr != null) {
                        a.this.icr.setBackgroundResource(R.color.transparent);
                    }
                    a.this.cXM.finish();
                }
            }

            @Override // com.baidu.tieba.f.a.InterfaceC0316a
            public void aZ(int i, int i2) {
                a.this.bqW();
            }

            @Override // com.baidu.tieba.f.a.InterfaceC0316a
            public void ba(int i, int i2) {
            }
        });
    }

    public void cH(View view) {
        if (view != null) {
            view.setOnTouchListener(this.fLh);
        }
    }

    public void bqW() {
        if (this.fLg && this.mNavigationBar != null && this.icr != null && this.icr.getVisibility() == 0) {
            this.mNavigationBar.setStatusBarVisibility(0);
            this.cXM.setExcludeHeight(0);
            if (this.ics != null) {
                this.ics.bqT();
            }
            this.icr.brd();
        }
    }

    public void bqX() {
        ViewGroup viewGroup;
        if (!this.fLg && (viewGroup = (ViewGroup) this.cXM.findViewById(16908290)) != null && (viewGroup.getParent() instanceof LinearLayout)) {
            this.icr = new BlankView(this.cXM.getPageContext().getPageActivity());
            this.icr.setBackgroundResource(R.color.transparent);
            ((LinearLayout) viewGroup.getParent()).addView(this.icr, 0, new LinearLayout.LayoutParams(-1, fLe));
            this.icr.setVisibility(0);
            this.icr.setOnClickListener(new View.OnClickListener() { // from class: com.baidu.tieba.pb.pb.sub.a.4
                @Override // android.view.View.OnClickListener
                public void onClick(View view) {
                    a.this.cXM.finish();
                }
            });
            this.icr.setScrollCallBack(new BlankView.a() { // from class: com.baidu.tieba.pb.pb.sub.a.5
                @Override // com.baidu.tieba.pb.pb.sub.BlankView.a
                public void bqZ() {
                    if (a.this.icr != null) {
                        a.this.icr.setVisibility(8);
                    }
                    a.this.fLg = false;
                    if (a.this.ics != null) {
                        a.this.ics.bqU();
                    }
                }
            });
            this.cXM.setExcludeHeight(fLe);
            this.fLg = true;
        }
    }

    public void a(InterfaceC0396a interfaceC0396a) {
        this.ics = interfaceC0396a;
    }

    public boolean bqY() {
        return this.fLg;
    }

    public void sr(int i) {
        this.ict = i;
        if (this.icr != null) {
            am.k(this.icr, i);
        }
    }
}
