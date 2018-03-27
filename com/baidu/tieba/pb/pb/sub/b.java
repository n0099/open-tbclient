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
/* loaded from: classes2.dex */
public class b {
    private BaseActivity bSF;
    private com.baidu.tieba.e.b cof;
    private boolean dPL = false;
    private View.OnTouchListener dPM;
    private com.baidu.tieba.pb.pb.sub.a fZv;
    private a fZw;
    private NavigationBar mNavigationBar;
    private static final int dPJ = l.t(TbadkCoreApplication.getInst(), d.e.ds160);
    private static final int TOUCH_SLOP = l.t(TbadkCoreApplication.getInst(), d.e.ds20);

    /* loaded from: classes2.dex */
    public interface a {
        void ayh();

        void ayi();

        boolean ayj();
    }

    public b(BaseActivity baseActivity, View view, NavigationBar navigationBar) {
        this.bSF = baseActivity;
        this.cof = new com.baidu.tieba.e.b(this.bSF.getPageContext().getPageActivity());
        this.mNavigationBar = navigationBar;
        this.mNavigationBar.setStatusBarVisibility(8);
        this.dPM = new View.OnTouchListener() { // from class: com.baidu.tieba.pb.pb.sub.b.1
            @Override // android.view.View.OnTouchListener
            public boolean onTouch(View view2, MotionEvent motionEvent) {
                b.this.cof.onTouchEvent(motionEvent);
                return true;
            }
        };
        view.setOnTouchListener(new View.OnTouchListener() { // from class: com.baidu.tieba.pb.pb.sub.b.2
            @Override // android.view.View.OnTouchListener
            public boolean onTouch(View view2, MotionEvent motionEvent) {
                b.this.cof.onTouchEvent(motionEvent);
                return false;
            }
        });
        this.cof.a(new a.InterfaceC0143a() { // from class: com.baidu.tieba.pb.pb.sub.b.3
            @Override // com.baidu.tieba.e.a.InterfaceC0143a
            public void aY(int i, int i2) {
                if (b.this.fZw != null && b.this.fZw.ayj() && Math.abs(i2) > b.TOUCH_SLOP) {
                    if (b.this.fZv != null) {
                        b.this.fZv.setBackgroundResource(d.C0141d.transparent);
                    }
                    b.this.bSF.finish();
                }
            }

            @Override // com.baidu.tieba.e.a.InterfaceC0143a
            public void aZ(int i, int i2) {
                b.this.ayk();
            }

            @Override // com.baidu.tieba.e.a.InterfaceC0143a
            public void ba(int i, int i2) {
            }
        });
    }

    public void cB(View view) {
        if (view != null) {
            view.setOnTouchListener(this.dPM);
        }
    }

    public void ayk() {
        if (this.dPL && this.mNavigationBar != null && this.fZv != null && this.fZv.getVisibility() == 0) {
            this.mNavigationBar.setStatusBarVisibility(0);
            this.bSF.setExcludeHeight(0);
            if (this.fZw != null) {
                this.fZw.ayh();
            }
            this.fZv.ayr();
        }
    }

    public void ayl() {
        ViewGroup viewGroup;
        if (!this.dPL && (viewGroup = (ViewGroup) this.bSF.findViewById(16908290)) != null && (viewGroup.getParent() instanceof LinearLayout)) {
            this.fZv = new com.baidu.tieba.pb.pb.sub.a(this.bSF.getPageContext().getPageActivity());
            this.fZv.setBackgroundResource(d.C0141d.transparent);
            ((LinearLayout) viewGroup.getParent()).addView(this.fZv, 0, new LinearLayout.LayoutParams(-1, dPJ));
            this.fZv.setVisibility(0);
            this.fZv.setOnClickListener(new View.OnClickListener() { // from class: com.baidu.tieba.pb.pb.sub.b.4
                @Override // android.view.View.OnClickListener
                public void onClick(View view) {
                    b.this.bSF.finish();
                }
            });
            this.fZv.setScrollCallBack(new a.InterfaceC0214a() { // from class: com.baidu.tieba.pb.pb.sub.b.5
                @Override // com.baidu.tieba.pb.pb.sub.a.InterfaceC0214a
                public void ayn() {
                    if (b.this.fZv != null) {
                        b.this.fZv.setVisibility(8);
                    }
                    b.this.dPL = false;
                    if (b.this.fZw != null) {
                        b.this.fZw.ayi();
                    }
                }
            });
            this.bSF.setExcludeHeight(dPJ);
            this.dPL = true;
        }
    }

    public void a(a aVar) {
        this.fZw = aVar;
    }

    public boolean aym() {
        return this.dPL;
    }

    public void nx(int i) {
        if (this.fZv != null) {
            aj.s(this.fZv, i);
        }
    }
}
