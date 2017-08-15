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
    private BaseActivity bmE;
    private com.baidu.tieba.e.b cmM;
    private com.baidu.tieba.pb.pb.sub.a eWK;
    private a eWM;
    private boolean eWN = false;
    private View.OnTouchListener eWO;
    private NavigationBar mNavigationBar;
    private static final int eWL = k.g(TbadkCoreApplication.getInst(), d.f.ds160);
    private static final int TOUCH_SLOP = k.g(TbadkCoreApplication.getInst(), d.f.ds20);

    /* loaded from: classes.dex */
    public interface a {
        boolean aVA();

        void aVy();

        void aVz();
    }

    public b(BaseActivity baseActivity, View view, NavigationBar navigationBar) {
        this.bmE = baseActivity;
        this.cmM = new com.baidu.tieba.e.b(this.bmE.getPageContext().getPageActivity());
        this.mNavigationBar = navigationBar;
        this.mNavigationBar.setStatusBarVisibility(8);
        this.eWO = new View.OnTouchListener() { // from class: com.baidu.tieba.pb.pb.sub.b.1
            @Override // android.view.View.OnTouchListener
            public boolean onTouch(View view2, MotionEvent motionEvent) {
                b.this.cmM.onTouchEvent(motionEvent);
                return true;
            }
        };
        view.setOnTouchListener(new View.OnTouchListener() { // from class: com.baidu.tieba.pb.pb.sub.b.2
            @Override // android.view.View.OnTouchListener
            public boolean onTouch(View view2, MotionEvent motionEvent) {
                b.this.cmM.onTouchEvent(motionEvent);
                return false;
            }
        });
        this.cmM.a(new a.InterfaceC0080a() { // from class: com.baidu.tieba.pb.pb.sub.b.3
            @Override // com.baidu.tieba.e.a.InterfaceC0080a
            public void ah(int i, int i2) {
                if (b.this.eWM != null && b.this.eWM.aVA() && Math.abs(i2) > b.TOUCH_SLOP) {
                    if (b.this.eWK != null) {
                        b.this.eWK.setBackgroundResource(d.e.transparent);
                    }
                    b.this.bmE.finish();
                }
            }

            @Override // com.baidu.tieba.e.a.InterfaceC0080a
            public void ai(int i, int i2) {
                b.this.aVv();
            }
        });
    }

    public void bi(View view) {
        if (view != null) {
            view.setOnTouchListener(this.eWO);
        }
    }

    public void aVv() {
        if (this.eWN && this.mNavigationBar != null && this.eWK != null && this.eWK.getVisibility() == 0) {
            this.mNavigationBar.setStatusBarVisibility(0);
            this.bmE.setExcludeHeight(0);
            if (this.eWM != null) {
                this.eWM.aVy();
            }
            this.eWK.aVt();
        }
    }

    public void aVw() {
        ViewGroup viewGroup;
        if (!this.eWN && (viewGroup = (ViewGroup) this.bmE.findViewById(16908290)) != null && (viewGroup.getParent() instanceof LinearLayout)) {
            this.eWK = new com.baidu.tieba.pb.pb.sub.a(this.bmE.getPageContext().getPageActivity());
            this.eWK.setBackgroundResource(d.e.transparent);
            ((LinearLayout) viewGroup.getParent()).addView(this.eWK, 0, new LinearLayout.LayoutParams(-1, eWL));
            this.eWK.setVisibility(0);
            this.eWK.setOnClickListener(new View.OnClickListener() { // from class: com.baidu.tieba.pb.pb.sub.b.4
                @Override // android.view.View.OnClickListener
                public void onClick(View view) {
                    b.this.bmE.finish();
                }
            });
            this.eWK.setScrollCallBack(new a.InterfaceC0112a() { // from class: com.baidu.tieba.pb.pb.sub.b.5
                @Override // com.baidu.tieba.pb.pb.sub.a.InterfaceC0112a
                public void aVu() {
                    if (b.this.eWK != null) {
                        b.this.eWK.setVisibility(8);
                    }
                    b.this.eWN = false;
                    if (b.this.eWM != null) {
                        b.this.eWM.aVz();
                    }
                }
            });
            this.bmE.setExcludeHeight(eWL);
            this.eWN = true;
        }
    }

    public void a(a aVar) {
        this.eWM = aVar;
    }

    public boolean aVx() {
        return this.eWN;
    }

    public void pI(int i) {
        if (this.eWK != null) {
            ai.j(this.eWK, i);
        }
    }
}
