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
    private BaseActivity brT;
    private com.baidu.tieba.e.b bzL;
    private boolean cMj = false;
    private View.OnTouchListener cMk;
    private com.baidu.tieba.pb.pb.sub.a eZr;
    private a eZs;
    private NavigationBar mNavigationBar;
    private static final int cMh = l.f(TbadkCoreApplication.getInst(), d.e.ds160);
    private static final int TOUCH_SLOP = l.f(TbadkCoreApplication.getInst(), d.e.ds20);

    /* loaded from: classes.dex */
    public interface a {
        void amX();

        void amY();

        boolean amZ();
    }

    public b(BaseActivity baseActivity, View view, NavigationBar navigationBar) {
        this.brT = baseActivity;
        this.bzL = new com.baidu.tieba.e.b(this.brT.getPageContext().getPageActivity());
        this.mNavigationBar = navigationBar;
        this.mNavigationBar.setStatusBarVisibility(8);
        this.cMk = new View.OnTouchListener() { // from class: com.baidu.tieba.pb.pb.sub.b.1
            @Override // android.view.View.OnTouchListener
            public boolean onTouch(View view2, MotionEvent motionEvent) {
                b.this.bzL.onTouchEvent(motionEvent);
                return true;
            }
        };
        view.setOnTouchListener(new View.OnTouchListener() { // from class: com.baidu.tieba.pb.pb.sub.b.2
            @Override // android.view.View.OnTouchListener
            public boolean onTouch(View view2, MotionEvent motionEvent) {
                b.this.bzL.onTouchEvent(motionEvent);
                return false;
            }
        });
        this.bzL.a(new a.InterfaceC0081a() { // from class: com.baidu.tieba.pb.pb.sub.b.3
            @Override // com.baidu.tieba.e.a.InterfaceC0081a
            public void ag(int i, int i2) {
                if (b.this.eZs != null && b.this.eZs.amZ() && Math.abs(i2) > b.TOUCH_SLOP) {
                    if (b.this.eZr != null) {
                        b.this.eZr.setBackgroundResource(d.C0080d.transparent);
                    }
                    b.this.brT.finish();
                }
            }

            @Override // com.baidu.tieba.e.a.InterfaceC0081a
            public void ah(int i, int i2) {
                b.this.ana();
            }

            @Override // com.baidu.tieba.e.a.InterfaceC0081a
            public void ai(int i, int i2) {
            }
        });
    }

    public void br(View view) {
        if (view != null) {
            view.setOnTouchListener(this.cMk);
        }
    }

    public void ana() {
        if (this.cMj && this.mNavigationBar != null && this.eZr != null && this.eZr.getVisibility() == 0) {
            this.mNavigationBar.setStatusBarVisibility(0);
            this.brT.setExcludeHeight(0);
            if (this.eZs != null) {
                this.eZs.amX();
            }
            this.eZr.anh();
        }
    }

    public void anb() {
        ViewGroup viewGroup;
        if (!this.cMj && (viewGroup = (ViewGroup) this.brT.findViewById(16908290)) != null && (viewGroup.getParent() instanceof LinearLayout)) {
            this.eZr = new com.baidu.tieba.pb.pb.sub.a(this.brT.getPageContext().getPageActivity());
            this.eZr.setBackgroundResource(d.C0080d.transparent);
            ((LinearLayout) viewGroup.getParent()).addView(this.eZr, 0, new LinearLayout.LayoutParams(-1, cMh));
            this.eZr.setVisibility(0);
            this.eZr.setOnClickListener(new View.OnClickListener() { // from class: com.baidu.tieba.pb.pb.sub.b.4
                @Override // android.view.View.OnClickListener
                public void onClick(View view) {
                    b.this.brT.finish();
                }
            });
            this.eZr.setScrollCallBack(new a.InterfaceC0115a() { // from class: com.baidu.tieba.pb.pb.sub.b.5
                @Override // com.baidu.tieba.pb.pb.sub.a.InterfaceC0115a
                public void and() {
                    if (b.this.eZr != null) {
                        b.this.eZr.setVisibility(8);
                    }
                    b.this.cMj = false;
                    if (b.this.eZs != null) {
                        b.this.eZs.amY();
                    }
                }
            });
            this.brT.setExcludeHeight(cMh);
            this.cMj = true;
        }
    }

    public void a(a aVar) {
        this.eZs = aVar;
    }

    public boolean anc() {
        return this.cMj;
    }

    public void kc(int i) {
        if (this.eZr != null) {
            aj.j(this.eZr, i);
        }
    }
}
