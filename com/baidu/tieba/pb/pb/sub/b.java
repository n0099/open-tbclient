package com.baidu.tieba.pb.pb.sub;

import android.view.MotionEvent;
import android.view.View;
import android.view.ViewGroup;
import android.widget.LinearLayout;
import com.baidu.adp.lib.util.l;
import com.baidu.tbadk.BaseActivity;
import com.baidu.tbadk.core.TbadkCoreApplication;
import com.baidu.tbadk.core.util.aj;
import com.baidu.tbadk.core.view.NavigationBar;
import com.baidu.tieba.d;
import com.baidu.tieba.e.a;
import com.baidu.tieba.pb.pb.sub.a;
/* loaded from: classes.dex */
public class b {
    private com.baidu.tieba.e.b bHP;
    private BaseActivity byF;
    private boolean cVM = false;
    private View.OnTouchListener cVN;
    private com.baidu.tieba.pb.pb.sub.a fhn;
    private a fho;
    private NavigationBar mNavigationBar;
    private static final int cVK = l.f(TbadkCoreApplication.getInst(), d.e.ds160);
    private static final int TOUCH_SLOP = l.f(TbadkCoreApplication.getInst(), d.e.ds20);

    /* loaded from: classes.dex */
    public interface a {
        void apa();

        void apb();

        boolean apc();
    }

    public b(BaseActivity baseActivity, View view, NavigationBar navigationBar) {
        this.byF = baseActivity;
        this.bHP = new com.baidu.tieba.e.b(this.byF.getPageContext().getPageActivity());
        this.mNavigationBar = navigationBar;
        this.mNavigationBar.setStatusBarVisibility(8);
        this.cVN = new View.OnTouchListener() { // from class: com.baidu.tieba.pb.pb.sub.b.1
            @Override // android.view.View.OnTouchListener
            public boolean onTouch(View view2, MotionEvent motionEvent) {
                b.this.bHP.onTouchEvent(motionEvent);
                return true;
            }
        };
        view.setOnTouchListener(new View.OnTouchListener() { // from class: com.baidu.tieba.pb.pb.sub.b.2
            @Override // android.view.View.OnTouchListener
            public boolean onTouch(View view2, MotionEvent motionEvent) {
                b.this.bHP.onTouchEvent(motionEvent);
                return false;
            }
        });
        this.bHP.a(new a.InterfaceC0096a() { // from class: com.baidu.tieba.pb.pb.sub.b.3
            @Override // com.baidu.tieba.e.a.InterfaceC0096a
            public void ag(int i, int i2) {
                if (b.this.fho != null && b.this.fho.apc() && Math.abs(i2) > b.TOUCH_SLOP) {
                    if (b.this.fhn != null) {
                        b.this.fhn.setBackgroundResource(d.C0095d.transparent);
                    }
                    b.this.byF.finish();
                }
            }

            @Override // com.baidu.tieba.e.a.InterfaceC0096a
            public void ah(int i, int i2) {
                b.this.apd();
            }

            @Override // com.baidu.tieba.e.a.InterfaceC0096a
            public void ai(int i, int i2) {
            }
        });
    }

    public void bp(View view) {
        if (view != null) {
            view.setOnTouchListener(this.cVN);
        }
    }

    public void apd() {
        if (this.cVM && this.mNavigationBar != null && this.fhn != null && this.fhn.getVisibility() == 0) {
            this.mNavigationBar.setStatusBarVisibility(0);
            this.byF.setExcludeHeight(0);
            if (this.fho != null) {
                this.fho.apa();
            }
            this.fhn.apk();
        }
    }

    public void ape() {
        ViewGroup viewGroup;
        if (!this.cVM && (viewGroup = (ViewGroup) this.byF.findViewById(16908290)) != null && (viewGroup.getParent() instanceof LinearLayout)) {
            this.fhn = new com.baidu.tieba.pb.pb.sub.a(this.byF.getPageContext().getPageActivity());
            this.fhn.setBackgroundResource(d.C0095d.transparent);
            ((LinearLayout) viewGroup.getParent()).addView(this.fhn, 0, new LinearLayout.LayoutParams(-1, cVK));
            this.fhn.setVisibility(0);
            this.fhn.setOnClickListener(new View.OnClickListener() { // from class: com.baidu.tieba.pb.pb.sub.b.4
                @Override // android.view.View.OnClickListener
                public void onClick(View view) {
                    b.this.byF.finish();
                }
            });
            this.fhn.setScrollCallBack(new a.InterfaceC0132a() { // from class: com.baidu.tieba.pb.pb.sub.b.5
                @Override // com.baidu.tieba.pb.pb.sub.a.InterfaceC0132a
                public void apg() {
                    if (b.this.fhn != null) {
                        b.this.fhn.setVisibility(8);
                    }
                    b.this.cVM = false;
                    if (b.this.fho != null) {
                        b.this.fho.apb();
                    }
                }
            });
            this.byF.setExcludeHeight(cVK);
            this.cVM = true;
        }
    }

    public void a(a aVar) {
        this.fho = aVar;
    }

    public boolean apf() {
        return this.cVM;
    }

    public void kC(int i) {
        if (this.fhn != null) {
            aj.j(this.fhn, i);
        }
    }
}
