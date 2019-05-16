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
    private BaseActivity cVo;
    private com.baidu.tieba.f.b dWi;
    private boolean fDE = false;
    private View.OnTouchListener fDF;
    private BlankView hTg;
    private InterfaceC0380a hTh;
    private NavigationBar mNavigationBar;
    private static final int fDC = l.g(TbadkCoreApplication.getInst(), R.dimen.ds160);
    private static final int TOUCH_SLOP = l.g(TbadkCoreApplication.getInst(), R.dimen.ds20);

    /* renamed from: com.baidu.tieba.pb.pb.sub.a$a  reason: collision with other inner class name */
    /* loaded from: classes4.dex */
    public interface InterfaceC0380a {
        void bnQ();

        void bnR();

        boolean bnS();
    }

    public a(BaseActivity baseActivity, View view, NavigationBar navigationBar) {
        this.cVo = baseActivity;
        this.dWi = new com.baidu.tieba.f.b(this.cVo.getPageContext().getPageActivity());
        this.mNavigationBar = navigationBar;
        this.mNavigationBar.setStatusBarVisibility(8);
        this.fDF = new View.OnTouchListener() { // from class: com.baidu.tieba.pb.pb.sub.a.1
            @Override // android.view.View.OnTouchListener
            public boolean onTouch(View view2, MotionEvent motionEvent) {
                a.this.dWi.onTouchEvent(motionEvent);
                return true;
            }
        };
        view.setOnTouchListener(new View.OnTouchListener() { // from class: com.baidu.tieba.pb.pb.sub.a.2
            @Override // android.view.View.OnTouchListener
            public boolean onTouch(View view2, MotionEvent motionEvent) {
                a.this.dWi.onTouchEvent(motionEvent);
                return false;
            }
        });
        this.dWi.a(new a.InterfaceC0302a() { // from class: com.baidu.tieba.pb.pb.sub.a.3
            @Override // com.baidu.tieba.f.a.InterfaceC0302a
            public void aT(int i, int i2) {
                if (a.this.hTh != null && a.this.hTh.bnS() && Math.abs(i2) > a.TOUCH_SLOP) {
                    if (a.this.hTg != null) {
                        a.this.hTg.setBackgroundResource(R.color.transparent);
                    }
                    a.this.cVo.finish();
                }
            }

            @Override // com.baidu.tieba.f.a.InterfaceC0302a
            public void aU(int i, int i2) {
                a.this.bnT();
            }

            @Override // com.baidu.tieba.f.a.InterfaceC0302a
            public void aV(int i, int i2) {
            }
        });
    }

    public void cC(View view) {
        if (view != null) {
            view.setOnTouchListener(this.fDF);
        }
    }

    public void bnT() {
        if (this.fDE && this.mNavigationBar != null && this.hTg != null && this.hTg.getVisibility() == 0) {
            this.mNavigationBar.setStatusBarVisibility(0);
            this.cVo.setExcludeHeight(0);
            if (this.hTh != null) {
                this.hTh.bnQ();
            }
            this.hTg.boa();
        }
    }

    public void bnU() {
        ViewGroup viewGroup;
        if (!this.fDE && (viewGroup = (ViewGroup) this.cVo.findViewById(16908290)) != null && (viewGroup.getParent() instanceof LinearLayout)) {
            this.hTg = new BlankView(this.cVo.getPageContext().getPageActivity());
            this.hTg.setBackgroundResource(R.color.transparent);
            ((LinearLayout) viewGroup.getParent()).addView(this.hTg, 0, new LinearLayout.LayoutParams(-1, fDC));
            this.hTg.setVisibility(0);
            this.hTg.setOnClickListener(new View.OnClickListener() { // from class: com.baidu.tieba.pb.pb.sub.a.4
                @Override // android.view.View.OnClickListener
                public void onClick(View view) {
                    a.this.cVo.finish();
                }
            });
            this.hTg.setScrollCallBack(new BlankView.a() { // from class: com.baidu.tieba.pb.pb.sub.a.5
                @Override // com.baidu.tieba.pb.pb.sub.BlankView.a
                public void bnW() {
                    if (a.this.hTg != null) {
                        a.this.hTg.setVisibility(8);
                    }
                    a.this.fDE = false;
                    if (a.this.hTh != null) {
                        a.this.hTh.bnR();
                    }
                }
            });
            this.cVo.setExcludeHeight(fDC);
            this.fDE = true;
        }
    }

    public void a(InterfaceC0380a interfaceC0380a) {
        this.hTh = interfaceC0380a;
    }

    public boolean bnV() {
        return this.fDE;
    }

    public void rT(int i) {
        if (this.hTg != null) {
            al.k(this.hTg, i);
        }
    }
}
