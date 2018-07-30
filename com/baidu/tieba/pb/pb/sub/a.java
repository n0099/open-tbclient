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
import com.baidu.tieba.d;
import com.baidu.tieba.f.a;
import com.baidu.tieba.pb.pb.sub.BlankView;
/* loaded from: classes2.dex */
public class a {
    private com.baidu.tieba.f.b bKb;
    private BaseActivity bmZ;
    private boolean dAm = false;
    private View.OnTouchListener dAn;
    private BlankView fKp;
    private InterfaceC0213a fKq;
    private NavigationBar mNavigationBar;
    private static final int dAk = l.f(TbadkCoreApplication.getInst(), d.e.ds160);
    private static final int TOUCH_SLOP = l.f(TbadkCoreApplication.getInst(), d.e.ds20);

    /* renamed from: com.baidu.tieba.pb.pb.sub.a$a  reason: collision with other inner class name */
    /* loaded from: classes2.dex */
    public interface InterfaceC0213a {
        void ayk();

        void ayl();

        boolean aym();
    }

    public a(BaseActivity baseActivity, View view, NavigationBar navigationBar) {
        this.bmZ = baseActivity;
        this.bKb = new com.baidu.tieba.f.b(this.bmZ.getPageContext().getPageActivity());
        this.mNavigationBar = navigationBar;
        this.mNavigationBar.setStatusBarVisibility(8);
        this.dAn = new View.OnTouchListener() { // from class: com.baidu.tieba.pb.pb.sub.a.1
            @Override // android.view.View.OnTouchListener
            public boolean onTouch(View view2, MotionEvent motionEvent) {
                a.this.bKb.onTouchEvent(motionEvent);
                return true;
            }
        };
        view.setOnTouchListener(new View.OnTouchListener() { // from class: com.baidu.tieba.pb.pb.sub.a.2
            @Override // android.view.View.OnTouchListener
            public boolean onTouch(View view2, MotionEvent motionEvent) {
                a.this.bKb.onTouchEvent(motionEvent);
                return false;
            }
        });
        this.bKb.a(new a.InterfaceC0145a() { // from class: com.baidu.tieba.pb.pb.sub.a.3
            @Override // com.baidu.tieba.f.a.InterfaceC0145a
            public void Y(int i, int i2) {
                if (a.this.fKq != null && a.this.fKq.aym() && Math.abs(i2) > a.TOUCH_SLOP) {
                    if (a.this.fKp != null) {
                        a.this.fKp.setBackgroundResource(d.C0140d.transparent);
                    }
                    a.this.bmZ.finish();
                }
            }

            @Override // com.baidu.tieba.f.a.InterfaceC0145a
            public void Z(int i, int i2) {
                a.this.ayn();
            }

            @Override // com.baidu.tieba.f.a.InterfaceC0145a
            public void aa(int i, int i2) {
            }
        });
    }

    public void bo(View view) {
        if (view != null) {
            view.setOnTouchListener(this.dAn);
        }
    }

    public void ayn() {
        if (this.dAm && this.mNavigationBar != null && this.fKp != null && this.fKp.getVisibility() == 0) {
            this.mNavigationBar.setStatusBarVisibility(0);
            this.bmZ.setExcludeHeight(0);
            if (this.fKq != null) {
                this.fKq.ayk();
            }
            this.fKp.ayu();
        }
    }

    public void ayo() {
        ViewGroup viewGroup;
        if (!this.dAm && (viewGroup = (ViewGroup) this.bmZ.findViewById(16908290)) != null && (viewGroup.getParent() instanceof LinearLayout)) {
            this.fKp = new BlankView(this.bmZ.getPageContext().getPageActivity());
            this.fKp.setBackgroundResource(d.C0140d.transparent);
            ((LinearLayout) viewGroup.getParent()).addView(this.fKp, 0, new LinearLayout.LayoutParams(-1, dAk));
            this.fKp.setVisibility(0);
            this.fKp.setOnClickListener(new View.OnClickListener() { // from class: com.baidu.tieba.pb.pb.sub.a.4
                @Override // android.view.View.OnClickListener
                public void onClick(View view) {
                    a.this.bmZ.finish();
                }
            });
            this.fKp.setScrollCallBack(new BlankView.a() { // from class: com.baidu.tieba.pb.pb.sub.a.5
                @Override // com.baidu.tieba.pb.pb.sub.BlankView.a
                public void ayq() {
                    if (a.this.fKp != null) {
                        a.this.fKp.setVisibility(8);
                    }
                    a.this.dAm = false;
                    if (a.this.fKq != null) {
                        a.this.fKq.ayl();
                    }
                }
            });
            this.bmZ.setExcludeHeight(dAk);
            this.dAm = true;
        }
    }

    public void a(InterfaceC0213a interfaceC0213a) {
        this.fKq = interfaceC0213a;
    }

    public boolean ayp() {
        return this.dAm;
    }

    public void lh(int i) {
        if (this.fKp != null) {
            am.i(this.fKp, i);
        }
    }
}
