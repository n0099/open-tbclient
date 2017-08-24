package com.baidu.tieba.pb.pb.sub;

import android.view.MotionEvent;
import android.view.View;
import android.view.ViewGroup;
import android.widget.LinearLayout;
import com.baidu.adp.lib.util.k;
import com.baidu.tbadk.BaseActivity;
import com.baidu.tbadk.core.TbadkCoreApplication;
import com.baidu.tbadk.core.util.ai;
import com.baidu.tbadk.core.view.NavigationBar;
import com.baidu.tieba.d;
import com.baidu.tieba.e.a;
import com.baidu.tieba.pb.pb.sub.a;
/* loaded from: classes.dex */
public class b {
    private BaseActivity bmG;
    private com.baidu.tieba.e.b cmN;
    private com.baidu.tieba.pb.pb.sub.a eWM;
    private a eWO;
    private boolean eWP = false;
    private View.OnTouchListener eWQ;
    private NavigationBar mNavigationBar;
    private static final int eWN = k.g(TbadkCoreApplication.getInst(), d.f.ds160);
    private static final int TOUCH_SLOP = k.g(TbadkCoreApplication.getInst(), d.f.ds20);

    /* loaded from: classes.dex */
    public interface a {
        void aVt();

        void aVu();

        boolean aVv();
    }

    public b(BaseActivity baseActivity, View view, NavigationBar navigationBar) {
        this.bmG = baseActivity;
        this.cmN = new com.baidu.tieba.e.b(this.bmG.getPageContext().getPageActivity());
        this.mNavigationBar = navigationBar;
        this.mNavigationBar.setStatusBarVisibility(8);
        this.eWQ = new View.OnTouchListener() { // from class: com.baidu.tieba.pb.pb.sub.b.1
            @Override // android.view.View.OnTouchListener
            public boolean onTouch(View view2, MotionEvent motionEvent) {
                b.this.cmN.onTouchEvent(motionEvent);
                return true;
            }
        };
        view.setOnTouchListener(new View.OnTouchListener() { // from class: com.baidu.tieba.pb.pb.sub.b.2
            @Override // android.view.View.OnTouchListener
            public boolean onTouch(View view2, MotionEvent motionEvent) {
                b.this.cmN.onTouchEvent(motionEvent);
                return false;
            }
        });
        this.cmN.a(new a.InterfaceC0080a() { // from class: com.baidu.tieba.pb.pb.sub.b.3
            @Override // com.baidu.tieba.e.a.InterfaceC0080a
            public void ah(int i, int i2) {
                if (b.this.eWO != null && b.this.eWO.aVv() && Math.abs(i2) > b.TOUCH_SLOP) {
                    if (b.this.eWM != null) {
                        b.this.eWM.setBackgroundResource(d.e.transparent);
                    }
                    b.this.bmG.finish();
                }
            }

            @Override // com.baidu.tieba.e.a.InterfaceC0080a
            public void ai(int i, int i2) {
                b.this.aVq();
            }
        });
    }

    public void bh(View view) {
        if (view != null) {
            view.setOnTouchListener(this.eWQ);
        }
    }

    public void aVq() {
        if (this.eWP && this.mNavigationBar != null && this.eWM != null && this.eWM.getVisibility() == 0) {
            this.mNavigationBar.setStatusBarVisibility(0);
            this.bmG.setExcludeHeight(0);
            if (this.eWO != null) {
                this.eWO.aVt();
            }
            this.eWM.aVo();
        }
    }

    public void aVr() {
        ViewGroup viewGroup;
        if (!this.eWP && (viewGroup = (ViewGroup) this.bmG.findViewById(16908290)) != null && (viewGroup.getParent() instanceof LinearLayout)) {
            this.eWM = new com.baidu.tieba.pb.pb.sub.a(this.bmG.getPageContext().getPageActivity());
            this.eWM.setBackgroundResource(d.e.transparent);
            ((LinearLayout) viewGroup.getParent()).addView(this.eWM, 0, new LinearLayout.LayoutParams(-1, eWN));
            this.eWM.setVisibility(0);
            this.eWM.setOnClickListener(new View.OnClickListener() { // from class: com.baidu.tieba.pb.pb.sub.b.4
                @Override // android.view.View.OnClickListener
                public void onClick(View view) {
                    b.this.bmG.finish();
                }
            });
            this.eWM.setScrollCallBack(new a.InterfaceC0112a() { // from class: com.baidu.tieba.pb.pb.sub.b.5
                @Override // com.baidu.tieba.pb.pb.sub.a.InterfaceC0112a
                public void aVp() {
                    if (b.this.eWM != null) {
                        b.this.eWM.setVisibility(8);
                    }
                    b.this.eWP = false;
                    if (b.this.eWO != null) {
                        b.this.eWO.aVu();
                    }
                }
            });
            this.bmG.setExcludeHeight(eWN);
            this.eWP = true;
        }
    }

    public void a(a aVar) {
        this.eWO = aVar;
    }

    public boolean aVs() {
        return this.eWP;
    }

    public void pI(int i) {
        if (this.eWM != null) {
            ai.j(this.eWM, i);
        }
    }
}
