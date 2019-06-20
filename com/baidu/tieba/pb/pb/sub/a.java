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
import com.baidu.tieba.R;
import com.baidu.tieba.f.a;
import com.baidu.tieba.pb.pb.sub.BlankView;
/* loaded from: classes4.dex */
public class a {
    private BaseActivity cVq;
    private com.baidu.tieba.f.b dWj;
    private boolean fDF = false;
    private View.OnTouchListener fDG;
    private BlankView hTk;
    private InterfaceC0380a hTl;
    private NavigationBar mNavigationBar;
    private static final int fDD = l.g(TbadkCoreApplication.getInst(), R.dimen.ds160);
    private static final int TOUCH_SLOP = l.g(TbadkCoreApplication.getInst(), R.dimen.ds20);

    /* renamed from: com.baidu.tieba.pb.pb.sub.a$a  reason: collision with other inner class name */
    /* loaded from: classes4.dex */
    public interface InterfaceC0380a {
        void bnT();

        void bnU();

        boolean bnV();
    }

    public a(BaseActivity baseActivity, View view, NavigationBar navigationBar) {
        this.cVq = baseActivity;
        this.dWj = new com.baidu.tieba.f.b(this.cVq.getPageContext().getPageActivity());
        this.mNavigationBar = navigationBar;
        this.mNavigationBar.setStatusBarVisibility(8);
        this.fDG = new View.OnTouchListener() { // from class: com.baidu.tieba.pb.pb.sub.a.1
            @Override // android.view.View.OnTouchListener
            public boolean onTouch(View view2, MotionEvent motionEvent) {
                a.this.dWj.onTouchEvent(motionEvent);
                return true;
            }
        };
        view.setOnTouchListener(new View.OnTouchListener() { // from class: com.baidu.tieba.pb.pb.sub.a.2
            @Override // android.view.View.OnTouchListener
            public boolean onTouch(View view2, MotionEvent motionEvent) {
                a.this.dWj.onTouchEvent(motionEvent);
                return false;
            }
        });
        this.dWj.a(new a.InterfaceC0302a() { // from class: com.baidu.tieba.pb.pb.sub.a.3
            @Override // com.baidu.tieba.f.a.InterfaceC0302a
            public void aT(int i, int i2) {
                if (a.this.hTl != null && a.this.hTl.bnV() && Math.abs(i2) > a.TOUCH_SLOP) {
                    if (a.this.hTk != null) {
                        a.this.hTk.setBackgroundResource(R.color.transparent);
                    }
                    a.this.cVq.finish();
                }
            }

            @Override // com.baidu.tieba.f.a.InterfaceC0302a
            public void aU(int i, int i2) {
                a.this.bnW();
            }

            @Override // com.baidu.tieba.f.a.InterfaceC0302a
            public void aV(int i, int i2) {
            }
        });
    }

    public void cC(View view) {
        if (view != null) {
            view.setOnTouchListener(this.fDG);
        }
    }

    public void bnW() {
        if (this.fDF && this.mNavigationBar != null && this.hTk != null && this.hTk.getVisibility() == 0) {
            this.mNavigationBar.setStatusBarVisibility(0);
            this.cVq.setExcludeHeight(0);
            if (this.hTl != null) {
                this.hTl.bnT();
            }
            this.hTk.bod();
        }
    }

    public void bnX() {
        ViewGroup viewGroup;
        if (!this.fDF && (viewGroup = (ViewGroup) this.cVq.findViewById(16908290)) != null && (viewGroup.getParent() instanceof LinearLayout)) {
            this.hTk = new BlankView(this.cVq.getPageContext().getPageActivity());
            this.hTk.setBackgroundResource(R.color.transparent);
            ((LinearLayout) viewGroup.getParent()).addView(this.hTk, 0, new LinearLayout.LayoutParams(-1, fDD));
            this.hTk.setVisibility(0);
            this.hTk.setOnClickListener(new View.OnClickListener() { // from class: com.baidu.tieba.pb.pb.sub.a.4
                @Override // android.view.View.OnClickListener
                public void onClick(View view) {
                    a.this.cVq.finish();
                }
            });
            this.hTk.setScrollCallBack(new BlankView.a() { // from class: com.baidu.tieba.pb.pb.sub.a.5
                @Override // com.baidu.tieba.pb.pb.sub.BlankView.a
                public void bnZ() {
                    if (a.this.hTk != null) {
                        a.this.hTk.setVisibility(8);
                    }
                    a.this.fDF = false;
                    if (a.this.hTl != null) {
                        a.this.hTl.bnU();
                    }
                }
            });
            this.cVq.setExcludeHeight(fDD);
            this.fDF = true;
        }
    }

    public void a(InterfaceC0380a interfaceC0380a) {
        this.hTl = interfaceC0380a;
    }

    public boolean bnY() {
        return this.fDF;
    }

    public void rT(int i) {
        if (this.hTk != null) {
            al.k(this.hTk, i);
        }
    }
}
