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
    private BaseActivity bll;
    private com.baidu.tieba.e.b ckS;
    private com.baidu.tieba.pb.pb.sub.a eTE;
    private a eTG;
    private boolean eTH = false;
    private View.OnTouchListener eTI;
    private NavigationBar mNavigationBar;
    private static final int eTF = k.g(TbadkCoreApplication.getInst(), d.f.ds160);
    private static final int TOUCH_SLOP = k.g(TbadkCoreApplication.getInst(), d.f.ds20);

    /* loaded from: classes.dex */
    public interface a {
        void aUG();

        void aUH();

        boolean aUI();
    }

    public b(BaseActivity baseActivity, View view, NavigationBar navigationBar) {
        this.bll = baseActivity;
        this.ckS = new com.baidu.tieba.e.b(this.bll.getPageContext().getPageActivity());
        this.mNavigationBar = navigationBar;
        this.mNavigationBar.setStatusBarVisibility(8);
        this.eTI = new View.OnTouchListener() { // from class: com.baidu.tieba.pb.pb.sub.b.1
            @Override // android.view.View.OnTouchListener
            public boolean onTouch(View view2, MotionEvent motionEvent) {
                b.this.ckS.onTouchEvent(motionEvent);
                return true;
            }
        };
        view.setOnTouchListener(new View.OnTouchListener() { // from class: com.baidu.tieba.pb.pb.sub.b.2
            @Override // android.view.View.OnTouchListener
            public boolean onTouch(View view2, MotionEvent motionEvent) {
                b.this.ckS.onTouchEvent(motionEvent);
                return false;
            }
        });
        this.ckS.a(new a.InterfaceC0080a() { // from class: com.baidu.tieba.pb.pb.sub.b.3
            @Override // com.baidu.tieba.e.a.InterfaceC0080a
            public void ag(int i, int i2) {
                if (b.this.eTG != null && b.this.eTG.aUI() && Math.abs(i2) > b.TOUCH_SLOP) {
                    if (b.this.eTE != null) {
                        b.this.eTE.setBackgroundResource(d.e.transparent);
                    }
                    b.this.bll.finish();
                }
            }

            @Override // com.baidu.tieba.e.a.InterfaceC0080a
            public void ah(int i, int i2) {
                b.this.aUD();
            }
        });
    }

    public void bg(View view) {
        if (view != null) {
            view.setOnTouchListener(this.eTI);
        }
    }

    public void aUD() {
        if (this.eTH && this.mNavigationBar != null && this.eTE != null && this.eTE.getVisibility() == 0) {
            this.mNavigationBar.setStatusBarVisibility(0);
            this.bll.setExcludeHeight(0);
            if (this.eTG != null) {
                this.eTG.aUG();
            }
            this.eTE.aUB();
        }
    }

    public void aUE() {
        ViewGroup viewGroup;
        if (!this.eTH && (viewGroup = (ViewGroup) this.bll.findViewById(16908290)) != null && (viewGroup.getParent() instanceof LinearLayout)) {
            this.eTE = new com.baidu.tieba.pb.pb.sub.a(this.bll.getPageContext().getPageActivity());
            this.eTE.setBackgroundResource(d.e.transparent);
            ((LinearLayout) viewGroup.getParent()).addView(this.eTE, 0, new LinearLayout.LayoutParams(-1, eTF));
            this.eTE.setVisibility(0);
            this.eTE.setOnClickListener(new View.OnClickListener() { // from class: com.baidu.tieba.pb.pb.sub.b.4
                @Override // android.view.View.OnClickListener
                public void onClick(View view) {
                    b.this.bll.finish();
                }
            });
            this.eTE.setScrollCallBack(new a.InterfaceC0112a() { // from class: com.baidu.tieba.pb.pb.sub.b.5
                @Override // com.baidu.tieba.pb.pb.sub.a.InterfaceC0112a
                public void aUC() {
                    if (b.this.eTE != null) {
                        b.this.eTE.setVisibility(8);
                    }
                    b.this.eTH = false;
                    if (b.this.eTG != null) {
                        b.this.eTG.aUH();
                    }
                }
            });
            this.bll.setExcludeHeight(eTF);
            this.eTH = true;
        }
    }

    public void a(a aVar) {
        this.eTG = aVar;
    }

    public boolean aUF() {
        return this.eTH;
    }

    public void py(int i) {
        if (this.eTE != null) {
            ai.j(this.eTE, i);
        }
    }
}
