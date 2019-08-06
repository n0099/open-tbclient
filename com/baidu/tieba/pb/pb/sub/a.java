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
    private BaseActivity cWT;
    private com.baidu.tieba.f.b eai;
    private boolean fJr = false;
    private View.OnTouchListener fJs;
    private BlankView iau;
    private InterfaceC0385a iav;
    private NavigationBar mNavigationBar;
    private static final int fJp = l.g(TbadkCoreApplication.getInst(), R.dimen.ds160);
    private static final int TOUCH_SLOP = l.g(TbadkCoreApplication.getInst(), R.dimen.ds20);

    /* renamed from: com.baidu.tieba.pb.pb.sub.a$a  reason: collision with other inner class name */
    /* loaded from: classes4.dex */
    public interface InterfaceC0385a {
        void bqh();

        void bqi();

        boolean bqj();
    }

    public a(BaseActivity baseActivity, View view, NavigationBar navigationBar) {
        this.cWT = baseActivity;
        this.eai = new com.baidu.tieba.f.b(this.cWT.getPageContext().getPageActivity());
        this.mNavigationBar = navigationBar;
        this.mNavigationBar.setStatusBarVisibility(8);
        this.fJs = new View.OnTouchListener() { // from class: com.baidu.tieba.pb.pb.sub.a.1
            @Override // android.view.View.OnTouchListener
            public boolean onTouch(View view2, MotionEvent motionEvent) {
                a.this.eai.onTouchEvent(motionEvent);
                return true;
            }
        };
        view.setOnTouchListener(new View.OnTouchListener() { // from class: com.baidu.tieba.pb.pb.sub.a.2
            @Override // android.view.View.OnTouchListener
            public boolean onTouch(View view2, MotionEvent motionEvent) {
                a.this.eai.onTouchEvent(motionEvent);
                return false;
            }
        });
        this.eai.a(new a.InterfaceC0305a() { // from class: com.baidu.tieba.pb.pb.sub.a.3
            @Override // com.baidu.tieba.f.a.InterfaceC0305a
            public void aY(int i, int i2) {
                if (a.this.iav != null && a.this.iav.bqj() && Math.abs(i2) > a.TOUCH_SLOP) {
                    if (a.this.iau != null) {
                        a.this.iau.setBackgroundResource(R.color.transparent);
                    }
                    a.this.cWT.finish();
                }
            }

            @Override // com.baidu.tieba.f.a.InterfaceC0305a
            public void aZ(int i, int i2) {
                a.this.bqk();
            }

            @Override // com.baidu.tieba.f.a.InterfaceC0305a
            public void ba(int i, int i2) {
            }
        });
    }

    public void cH(View view) {
        if (view != null) {
            view.setOnTouchListener(this.fJs);
        }
    }

    public void bqk() {
        if (this.fJr && this.mNavigationBar != null && this.iau != null && this.iau.getVisibility() == 0) {
            this.mNavigationBar.setStatusBarVisibility(0);
            this.cWT.setExcludeHeight(0);
            if (this.iav != null) {
                this.iav.bqh();
            }
            this.iau.bqr();
        }
    }

    public void bql() {
        ViewGroup viewGroup;
        if (!this.fJr && (viewGroup = (ViewGroup) this.cWT.findViewById(16908290)) != null && (viewGroup.getParent() instanceof LinearLayout)) {
            this.iau = new BlankView(this.cWT.getPageContext().getPageActivity());
            this.iau.setBackgroundResource(R.color.transparent);
            ((LinearLayout) viewGroup.getParent()).addView(this.iau, 0, new LinearLayout.LayoutParams(-1, fJp));
            this.iau.setVisibility(0);
            this.iau.setOnClickListener(new View.OnClickListener() { // from class: com.baidu.tieba.pb.pb.sub.a.4
                @Override // android.view.View.OnClickListener
                public void onClick(View view) {
                    a.this.cWT.finish();
                }
            });
            this.iau.setScrollCallBack(new BlankView.a() { // from class: com.baidu.tieba.pb.pb.sub.a.5
                @Override // com.baidu.tieba.pb.pb.sub.BlankView.a
                public void bqn() {
                    if (a.this.iau != null) {
                        a.this.iau.setVisibility(8);
                    }
                    a.this.fJr = false;
                    if (a.this.iav != null) {
                        a.this.iav.bqi();
                    }
                }
            });
            this.cWT.setExcludeHeight(fJp);
            this.fJr = true;
        }
    }

    public void a(InterfaceC0385a interfaceC0385a) {
        this.iav = interfaceC0385a;
    }

    public boolean bqm() {
        return this.fJr;
    }

    public void sn(int i) {
        if (this.iau != null) {
            am.k(this.iau, i);
        }
    }
}
