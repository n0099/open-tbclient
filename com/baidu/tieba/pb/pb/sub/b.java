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
    private BaseActivity brJ;
    private com.baidu.tieba.e.b bzz;
    private boolean cLQ = false;
    private View.OnTouchListener cLR;
    private com.baidu.tieba.pb.pb.sub.a eYW;
    private a eYX;
    private NavigationBar mNavigationBar;
    private static final int cLO = l.f(TbadkCoreApplication.getInst(), d.e.ds160);
    private static final int TOUCH_SLOP = l.f(TbadkCoreApplication.getInst(), d.e.ds20);

    /* loaded from: classes.dex */
    public interface a {
        void amJ();

        void amK();

        boolean amL();
    }

    public b(BaseActivity baseActivity, View view, NavigationBar navigationBar) {
        this.brJ = baseActivity;
        this.bzz = new com.baidu.tieba.e.b(this.brJ.getPageContext().getPageActivity());
        this.mNavigationBar = navigationBar;
        this.mNavigationBar.setStatusBarVisibility(8);
        this.cLR = new View.OnTouchListener() { // from class: com.baidu.tieba.pb.pb.sub.b.1
            @Override // android.view.View.OnTouchListener
            public boolean onTouch(View view2, MotionEvent motionEvent) {
                b.this.bzz.onTouchEvent(motionEvent);
                return true;
            }
        };
        view.setOnTouchListener(new View.OnTouchListener() { // from class: com.baidu.tieba.pb.pb.sub.b.2
            @Override // android.view.View.OnTouchListener
            public boolean onTouch(View view2, MotionEvent motionEvent) {
                b.this.bzz.onTouchEvent(motionEvent);
                return false;
            }
        });
        this.bzz.a(new a.InterfaceC0081a() { // from class: com.baidu.tieba.pb.pb.sub.b.3
            @Override // com.baidu.tieba.e.a.InterfaceC0081a
            public void ag(int i, int i2) {
                if (b.this.eYX != null && b.this.eYX.amL() && Math.abs(i2) > b.TOUCH_SLOP) {
                    if (b.this.eYW != null) {
                        b.this.eYW.setBackgroundResource(d.C0080d.transparent);
                    }
                    b.this.brJ.finish();
                }
            }

            @Override // com.baidu.tieba.e.a.InterfaceC0081a
            public void ah(int i, int i2) {
                b.this.amM();
            }

            @Override // com.baidu.tieba.e.a.InterfaceC0081a
            public void ai(int i, int i2) {
            }
        });
    }

    public void bq(View view) {
        if (view != null) {
            view.setOnTouchListener(this.cLR);
        }
    }

    public void amM() {
        if (this.cLQ && this.mNavigationBar != null && this.eYW != null && this.eYW.getVisibility() == 0) {
            this.mNavigationBar.setStatusBarVisibility(0);
            this.brJ.setExcludeHeight(0);
            if (this.eYX != null) {
                this.eYX.amJ();
            }
            this.eYW.amT();
        }
    }

    public void amN() {
        ViewGroup viewGroup;
        if (!this.cLQ && (viewGroup = (ViewGroup) this.brJ.findViewById(16908290)) != null && (viewGroup.getParent() instanceof LinearLayout)) {
            this.eYW = new com.baidu.tieba.pb.pb.sub.a(this.brJ.getPageContext().getPageActivity());
            this.eYW.setBackgroundResource(d.C0080d.transparent);
            ((LinearLayout) viewGroup.getParent()).addView(this.eYW, 0, new LinearLayout.LayoutParams(-1, cLO));
            this.eYW.setVisibility(0);
            this.eYW.setOnClickListener(new View.OnClickListener() { // from class: com.baidu.tieba.pb.pb.sub.b.4
                @Override // android.view.View.OnClickListener
                public void onClick(View view) {
                    b.this.brJ.finish();
                }
            });
            this.eYW.setScrollCallBack(new a.InterfaceC0115a() { // from class: com.baidu.tieba.pb.pb.sub.b.5
                @Override // com.baidu.tieba.pb.pb.sub.a.InterfaceC0115a
                public void amP() {
                    if (b.this.eYW != null) {
                        b.this.eYW.setVisibility(8);
                    }
                    b.this.cLQ = false;
                    if (b.this.eYX != null) {
                        b.this.eYX.amK();
                    }
                }
            });
            this.brJ.setExcludeHeight(cLO);
            this.cLQ = true;
        }
    }

    public void a(a aVar) {
        this.eYX = aVar;
    }

    public boolean amO() {
        return this.cLQ;
    }

    public void kd(int i) {
        if (this.eYW != null) {
            aj.j(this.eYW, i);
        }
    }
}
