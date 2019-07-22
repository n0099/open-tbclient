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
    private BaseActivity cWM;
    private com.baidu.tieba.f.b eab;
    private boolean fID = false;
    private View.OnTouchListener fIE;
    private BlankView hZx;
    private InterfaceC0379a hZy;
    private NavigationBar mNavigationBar;
    private static final int fIB = l.g(TbadkCoreApplication.getInst(), R.dimen.ds160);
    private static final int TOUCH_SLOP = l.g(TbadkCoreApplication.getInst(), R.dimen.ds20);

    /* renamed from: com.baidu.tieba.pb.pb.sub.a$a  reason: collision with other inner class name */
    /* loaded from: classes4.dex */
    public interface InterfaceC0379a {
        void bpU();

        void bpV();

        boolean bpW();
    }

    public a(BaseActivity baseActivity, View view, NavigationBar navigationBar) {
        this.cWM = baseActivity;
        this.eab = new com.baidu.tieba.f.b(this.cWM.getPageContext().getPageActivity());
        this.mNavigationBar = navigationBar;
        this.mNavigationBar.setStatusBarVisibility(8);
        this.fIE = new View.OnTouchListener() { // from class: com.baidu.tieba.pb.pb.sub.a.1
            @Override // android.view.View.OnTouchListener
            public boolean onTouch(View view2, MotionEvent motionEvent) {
                a.this.eab.onTouchEvent(motionEvent);
                return true;
            }
        };
        view.setOnTouchListener(new View.OnTouchListener() { // from class: com.baidu.tieba.pb.pb.sub.a.2
            @Override // android.view.View.OnTouchListener
            public boolean onTouch(View view2, MotionEvent motionEvent) {
                a.this.eab.onTouchEvent(motionEvent);
                return false;
            }
        });
        this.eab.a(new a.InterfaceC0299a() { // from class: com.baidu.tieba.pb.pb.sub.a.3
            @Override // com.baidu.tieba.f.a.InterfaceC0299a
            public void aY(int i, int i2) {
                if (a.this.hZy != null && a.this.hZy.bpW() && Math.abs(i2) > a.TOUCH_SLOP) {
                    if (a.this.hZx != null) {
                        a.this.hZx.setBackgroundResource(R.color.transparent);
                    }
                    a.this.cWM.finish();
                }
            }

            @Override // com.baidu.tieba.f.a.InterfaceC0299a
            public void aZ(int i, int i2) {
                a.this.bpX();
            }

            @Override // com.baidu.tieba.f.a.InterfaceC0299a
            public void ba(int i, int i2) {
            }
        });
    }

    public void cF(View view) {
        if (view != null) {
            view.setOnTouchListener(this.fIE);
        }
    }

    public void bpX() {
        if (this.fID && this.mNavigationBar != null && this.hZx != null && this.hZx.getVisibility() == 0) {
            this.mNavigationBar.setStatusBarVisibility(0);
            this.cWM.setExcludeHeight(0);
            if (this.hZy != null) {
                this.hZy.bpU();
            }
            this.hZx.bqe();
        }
    }

    public void bpY() {
        ViewGroup viewGroup;
        if (!this.fID && (viewGroup = (ViewGroup) this.cWM.findViewById(16908290)) != null && (viewGroup.getParent() instanceof LinearLayout)) {
            this.hZx = new BlankView(this.cWM.getPageContext().getPageActivity());
            this.hZx.setBackgroundResource(R.color.transparent);
            ((LinearLayout) viewGroup.getParent()).addView(this.hZx, 0, new LinearLayout.LayoutParams(-1, fIB));
            this.hZx.setVisibility(0);
            this.hZx.setOnClickListener(new View.OnClickListener() { // from class: com.baidu.tieba.pb.pb.sub.a.4
                @Override // android.view.View.OnClickListener
                public void onClick(View view) {
                    a.this.cWM.finish();
                }
            });
            this.hZx.setScrollCallBack(new BlankView.a() { // from class: com.baidu.tieba.pb.pb.sub.a.5
                @Override // com.baidu.tieba.pb.pb.sub.BlankView.a
                public void bqa() {
                    if (a.this.hZx != null) {
                        a.this.hZx.setVisibility(8);
                    }
                    a.this.fID = false;
                    if (a.this.hZy != null) {
                        a.this.hZy.bpV();
                    }
                }
            });
            this.cWM.setExcludeHeight(fIB);
            this.fID = true;
        }
    }

    public void a(InterfaceC0379a interfaceC0379a) {
        this.hZy = interfaceC0379a;
    }

    public boolean bpZ() {
        return this.fID;
    }

    public void sl(int i) {
        if (this.hZx != null) {
            am.k(this.hZx, i);
        }
    }
}
