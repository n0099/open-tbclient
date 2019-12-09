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
    private View.OnTouchListener fJK;
    private com.baidu.tieba.f.b fyF;
    private BlankView iai;
    private InterfaceC0485a iaj;
    private BaseActivity mActivity;
    private NavigationBar mNavigationBar;
    private static final int fJH = l.getDimens(TbadkCoreApplication.getInst(), R.dimen.ds160);
    private static final int TOUCH_SLOP = l.getDimens(TbadkCoreApplication.getInst(), R.dimen.ds20);
    private boolean fJJ = false;
    private int iak = R.color.transparent;

    /* renamed from: com.baidu.tieba.pb.pb.sub.a$a  reason: collision with other inner class name */
    /* loaded from: classes4.dex */
    public interface InterfaceC0485a {
        void bnV();

        void bnW();

        boolean bnX();
    }

    public a(BaseActivity baseActivity, View view, NavigationBar navigationBar) {
        this.mActivity = baseActivity;
        this.fyF = new com.baidu.tieba.f.b(this.mActivity.getPageContext().getPageActivity());
        this.mNavigationBar = navigationBar;
        this.mNavigationBar.setStatusBarVisibility(8);
        this.fJK = new View.OnTouchListener() { // from class: com.baidu.tieba.pb.pb.sub.a.1
            @Override // android.view.View.OnTouchListener
            public boolean onTouch(View view2, MotionEvent motionEvent) {
                a.this.fyF.onTouchEvent(motionEvent);
                return true;
            }
        };
        view.setOnTouchListener(new View.OnTouchListener() { // from class: com.baidu.tieba.pb.pb.sub.a.2
            @Override // android.view.View.OnTouchListener
            public boolean onTouch(View view2, MotionEvent motionEvent) {
                a.this.fyF.onTouchEvent(motionEvent);
                return false;
            }
        });
        this.fyF.a(new a.InterfaceC0400a() { // from class: com.baidu.tieba.pb.pb.sub.a.3
            @Override // com.baidu.tieba.f.a.InterfaceC0400a
            public void t(int i, int i2) {
                if (a.this.iaj != null && a.this.iaj.bnX() && Math.abs(i2) > a.TOUCH_SLOP) {
                    if (a.this.iai != null) {
                        a.this.iai.setBackgroundResource(R.color.transparent);
                    }
                    a.this.mActivity.finish();
                }
            }

            @Override // com.baidu.tieba.f.a.InterfaceC0400a
            public void u(int i, int i2) {
                a.this.bnY();
            }

            @Override // com.baidu.tieba.f.a.InterfaceC0400a
            public void v(int i, int i2) {
            }
        });
    }

    public void cD(View view) {
        if (view != null) {
            view.setOnTouchListener(this.fJK);
        }
    }

    public void bnY() {
        if (this.fJJ && this.mNavigationBar != null && this.iai != null && this.iai.getVisibility() == 0) {
            this.mNavigationBar.setStatusBarVisibility(0);
            this.mActivity.setExcludeHeight(0);
            if (this.iaj != null) {
                this.iaj.bnV();
            }
            this.iai.bof();
        }
    }

    public void bnZ() {
        ViewGroup viewGroup;
        if (!this.fJJ && (viewGroup = (ViewGroup) this.mActivity.findViewById(16908290)) != null && (viewGroup.getParent() instanceof LinearLayout)) {
            this.iai = new BlankView(this.mActivity.getPageContext().getPageActivity());
            this.iai.setBackgroundResource(R.color.transparent);
            ((LinearLayout) viewGroup.getParent()).addView(this.iai, 0, new LinearLayout.LayoutParams(-1, fJH));
            this.iai.setVisibility(0);
            this.iai.setOnClickListener(new View.OnClickListener() { // from class: com.baidu.tieba.pb.pb.sub.a.4
                @Override // android.view.View.OnClickListener
                public void onClick(View view) {
                    a.this.mActivity.finish();
                }
            });
            this.iai.setScrollCallBack(new BlankView.a() { // from class: com.baidu.tieba.pb.pb.sub.a.5
                @Override // com.baidu.tieba.pb.pb.sub.BlankView.a
                public void bob() {
                    if (a.this.iai != null) {
                        a.this.iai.setVisibility(8);
                    }
                    a.this.fJJ = false;
                    if (a.this.iaj != null) {
                        a.this.iaj.bnW();
                    }
                }
            });
            this.mActivity.setExcludeHeight(fJH);
            this.fJJ = true;
        }
    }

    public void a(InterfaceC0485a interfaceC0485a) {
        this.iaj = interfaceC0485a;
    }

    public boolean boa() {
        return this.fJJ;
    }

    public void rj(int i) {
        this.iak = i;
        if (this.iai != null) {
            am.setBackgroundResource(this.iai, i);
        }
    }
}
