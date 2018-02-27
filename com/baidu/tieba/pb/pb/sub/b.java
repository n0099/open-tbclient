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
    private BaseActivity bSC;
    private com.baidu.tieba.e.b coc;
    private boolean dPG = false;
    private View.OnTouchListener dPH;
    private com.baidu.tieba.pb.pb.sub.a fZf;
    private a fZg;
    private NavigationBar mNavigationBar;
    private static final int dPE = l.t(TbadkCoreApplication.getInst(), d.e.ds160);
    private static final int TOUCH_SLOP = l.t(TbadkCoreApplication.getInst(), d.e.ds20);

    /* loaded from: classes2.dex */
    public interface a {
        void ayf();

        void ayg();

        boolean ayh();
    }

    public b(BaseActivity baseActivity, View view, NavigationBar navigationBar) {
        this.bSC = baseActivity;
        this.coc = new com.baidu.tieba.e.b(this.bSC.getPageContext().getPageActivity());
        this.mNavigationBar = navigationBar;
        this.mNavigationBar.setStatusBarVisibility(8);
        this.dPH = new View.OnTouchListener() { // from class: com.baidu.tieba.pb.pb.sub.b.1
            @Override // android.view.View.OnTouchListener
            public boolean onTouch(View view2, MotionEvent motionEvent) {
                b.this.coc.onTouchEvent(motionEvent);
                return true;
            }
        };
        view.setOnTouchListener(new View.OnTouchListener() { // from class: com.baidu.tieba.pb.pb.sub.b.2
            @Override // android.view.View.OnTouchListener
            public boolean onTouch(View view2, MotionEvent motionEvent) {
                b.this.coc.onTouchEvent(motionEvent);
                return false;
            }
        });
        this.coc.a(new a.InterfaceC0143a() { // from class: com.baidu.tieba.pb.pb.sub.b.3
            @Override // com.baidu.tieba.e.a.InterfaceC0143a
            public void aY(int i, int i2) {
                if (b.this.fZg != null && b.this.fZg.ayh() && Math.abs(i2) > b.TOUCH_SLOP) {
                    if (b.this.fZf != null) {
                        b.this.fZf.setBackgroundResource(d.C0141d.transparent);
                    }
                    b.this.bSC.finish();
                }
            }

            @Override // com.baidu.tieba.e.a.InterfaceC0143a
            public void aZ(int i, int i2) {
                b.this.ayi();
            }

            @Override // com.baidu.tieba.e.a.InterfaceC0143a
            public void ba(int i, int i2) {
            }
        });
    }

    public void cB(View view) {
        if (view != null) {
            view.setOnTouchListener(this.dPH);
        }
    }

    public void ayi() {
        if (this.dPG && this.mNavigationBar != null && this.fZf != null && this.fZf.getVisibility() == 0) {
            this.mNavigationBar.setStatusBarVisibility(0);
            this.bSC.setExcludeHeight(0);
            if (this.fZg != null) {
                this.fZg.ayf();
            }
            this.fZf.ayp();
        }
    }

    public void ayj() {
        ViewGroup viewGroup;
        if (!this.dPG && (viewGroup = (ViewGroup) this.bSC.findViewById(16908290)) != null && (viewGroup.getParent() instanceof LinearLayout)) {
            this.fZf = new com.baidu.tieba.pb.pb.sub.a(this.bSC.getPageContext().getPageActivity());
            this.fZf.setBackgroundResource(d.C0141d.transparent);
            ((LinearLayout) viewGroup.getParent()).addView(this.fZf, 0, new LinearLayout.LayoutParams(-1, dPE));
            this.fZf.setVisibility(0);
            this.fZf.setOnClickListener(new View.OnClickListener() { // from class: com.baidu.tieba.pb.pb.sub.b.4
                @Override // android.view.View.OnClickListener
                public void onClick(View view) {
                    b.this.bSC.finish();
                }
            });
            this.fZf.setScrollCallBack(new a.InterfaceC0214a() { // from class: com.baidu.tieba.pb.pb.sub.b.5
                @Override // com.baidu.tieba.pb.pb.sub.a.InterfaceC0214a
                public void ayl() {
                    if (b.this.fZf != null) {
                        b.this.fZf.setVisibility(8);
                    }
                    b.this.dPG = false;
                    if (b.this.fZg != null) {
                        b.this.fZg.ayg();
                    }
                }
            });
            this.bSC.setExcludeHeight(dPE);
            this.dPG = true;
        }
    }

    public void a(a aVar) {
        this.fZg = aVar;
    }

    public boolean ayk() {
        return this.dPG;
    }

    public void nx(int i) {
        if (this.fZf != null) {
            aj.s(this.fZf, i);
        }
    }
}
