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
import com.baidu.tieba.f;
import com.baidu.tieba.f.a;
import com.baidu.tieba.pb.pb.sub.BlankView;
/* loaded from: classes2.dex */
public class a {
    private com.baidu.tieba.f.b bKa;
    private BaseActivity bnc;
    private boolean dAj = false;
    private View.OnTouchListener dAk;
    private BlankView fKi;
    private InterfaceC0213a fKj;
    private NavigationBar mNavigationBar;
    private static final int dAh = l.f(TbadkCoreApplication.getInst(), f.e.ds160);
    private static final int TOUCH_SLOP = l.f(TbadkCoreApplication.getInst(), f.e.ds20);

    /* renamed from: com.baidu.tieba.pb.pb.sub.a$a  reason: collision with other inner class name */
    /* loaded from: classes2.dex */
    public interface InterfaceC0213a {
        void ayi();

        void ayj();

        boolean ayk();
    }

    public a(BaseActivity baseActivity, View view, NavigationBar navigationBar) {
        this.bnc = baseActivity;
        this.bKa = new com.baidu.tieba.f.b(this.bnc.getPageContext().getPageActivity());
        this.mNavigationBar = navigationBar;
        this.mNavigationBar.setStatusBarVisibility(8);
        this.dAk = new View.OnTouchListener() { // from class: com.baidu.tieba.pb.pb.sub.a.1
            @Override // android.view.View.OnTouchListener
            public boolean onTouch(View view2, MotionEvent motionEvent) {
                a.this.bKa.onTouchEvent(motionEvent);
                return true;
            }
        };
        view.setOnTouchListener(new View.OnTouchListener() { // from class: com.baidu.tieba.pb.pb.sub.a.2
            @Override // android.view.View.OnTouchListener
            public boolean onTouch(View view2, MotionEvent motionEvent) {
                a.this.bKa.onTouchEvent(motionEvent);
                return false;
            }
        });
        this.bKa.a(new a.InterfaceC0144a() { // from class: com.baidu.tieba.pb.pb.sub.a.3
            @Override // com.baidu.tieba.f.a.InterfaceC0144a
            public void Y(int i, int i2) {
                if (a.this.fKj != null && a.this.fKj.ayk() && Math.abs(i2) > a.TOUCH_SLOP) {
                    if (a.this.fKi != null) {
                        a.this.fKi.setBackgroundResource(f.d.transparent);
                    }
                    a.this.bnc.finish();
                }
            }

            @Override // com.baidu.tieba.f.a.InterfaceC0144a
            public void Z(int i, int i2) {
                a.this.ayl();
            }

            @Override // com.baidu.tieba.f.a.InterfaceC0144a
            public void aa(int i, int i2) {
            }
        });
    }

    public void bo(View view) {
        if (view != null) {
            view.setOnTouchListener(this.dAk);
        }
    }

    public void ayl() {
        if (this.dAj && this.mNavigationBar != null && this.fKi != null && this.fKi.getVisibility() == 0) {
            this.mNavigationBar.setStatusBarVisibility(0);
            this.bnc.setExcludeHeight(0);
            if (this.fKj != null) {
                this.fKj.ayi();
            }
            this.fKi.ays();
        }
    }

    public void aym() {
        ViewGroup viewGroup;
        if (!this.dAj && (viewGroup = (ViewGroup) this.bnc.findViewById(16908290)) != null && (viewGroup.getParent() instanceof LinearLayout)) {
            this.fKi = new BlankView(this.bnc.getPageContext().getPageActivity());
            this.fKi.setBackgroundResource(f.d.transparent);
            ((LinearLayout) viewGroup.getParent()).addView(this.fKi, 0, new LinearLayout.LayoutParams(-1, dAh));
            this.fKi.setVisibility(0);
            this.fKi.setOnClickListener(new View.OnClickListener() { // from class: com.baidu.tieba.pb.pb.sub.a.4
                @Override // android.view.View.OnClickListener
                public void onClick(View view) {
                    a.this.bnc.finish();
                }
            });
            this.fKi.setScrollCallBack(new BlankView.a() { // from class: com.baidu.tieba.pb.pb.sub.a.5
                @Override // com.baidu.tieba.pb.pb.sub.BlankView.a
                public void ayo() {
                    if (a.this.fKi != null) {
                        a.this.fKi.setVisibility(8);
                    }
                    a.this.dAj = false;
                    if (a.this.fKj != null) {
                        a.this.fKj.ayj();
                    }
                }
            });
            this.bnc.setExcludeHeight(dAh);
            this.dAj = true;
        }
    }

    public void a(InterfaceC0213a interfaceC0213a) {
        this.fKj = interfaceC0213a;
    }

    public boolean ayn() {
        return this.dAj;
    }

    public void lg(int i) {
        if (this.fKi != null) {
            am.i(this.fKi, i);
        }
    }
}
