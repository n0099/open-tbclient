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
    private com.baidu.tieba.e.b ckT;
    private BaseActivity cmZ;
    private boolean dMT = false;
    private View.OnTouchListener dMU;
    private com.baidu.tieba.pb.pb.sub.a fWi;
    private a fWj;
    private NavigationBar mNavigationBar;
    private static final int dMR = l.s(TbadkCoreApplication.getInst(), d.e.ds160);
    private static final int TOUCH_SLOP = l.s(TbadkCoreApplication.getInst(), d.e.ds20);

    /* loaded from: classes2.dex */
    public interface a {
        void axi();

        void axj();

        boolean axk();
    }

    public b(BaseActivity baseActivity, View view, NavigationBar navigationBar) {
        this.cmZ = baseActivity;
        this.ckT = new com.baidu.tieba.e.b(this.cmZ.getPageContext().getPageActivity());
        this.mNavigationBar = navigationBar;
        this.mNavigationBar.setStatusBarVisibility(8);
        this.dMU = new View.OnTouchListener() { // from class: com.baidu.tieba.pb.pb.sub.b.1
            @Override // android.view.View.OnTouchListener
            public boolean onTouch(View view2, MotionEvent motionEvent) {
                b.this.ckT.onTouchEvent(motionEvent);
                return true;
            }
        };
        view.setOnTouchListener(new View.OnTouchListener() { // from class: com.baidu.tieba.pb.pb.sub.b.2
            @Override // android.view.View.OnTouchListener
            public boolean onTouch(View view2, MotionEvent motionEvent) {
                b.this.ckT.onTouchEvent(motionEvent);
                return false;
            }
        });
        this.ckT.a(new a.InterfaceC0109a() { // from class: com.baidu.tieba.pb.pb.sub.b.3
            @Override // com.baidu.tieba.e.a.InterfaceC0109a
            public void aY(int i, int i2) {
                if (b.this.fWj != null && b.this.fWj.axk() && Math.abs(i2) > b.TOUCH_SLOP) {
                    if (b.this.fWi != null) {
                        b.this.fWi.setBackgroundResource(d.C0108d.transparent);
                    }
                    b.this.cmZ.finish();
                }
            }

            @Override // com.baidu.tieba.e.a.InterfaceC0109a
            public void aZ(int i, int i2) {
                b.this.axl();
            }

            @Override // com.baidu.tieba.e.a.InterfaceC0109a
            public void ba(int i, int i2) {
            }
        });
    }

    public void cC(View view) {
        if (view != null) {
            view.setOnTouchListener(this.dMU);
        }
    }

    public void axl() {
        if (this.dMT && this.mNavigationBar != null && this.fWi != null && this.fWi.getVisibility() == 0) {
            this.mNavigationBar.setStatusBarVisibility(0);
            this.cmZ.setExcludeHeight(0);
            if (this.fWj != null) {
                this.fWj.axi();
            }
            this.fWi.axs();
        }
    }

    public void axm() {
        ViewGroup viewGroup;
        if (!this.dMT && (viewGroup = (ViewGroup) this.cmZ.findViewById(16908290)) != null && (viewGroup.getParent() instanceof LinearLayout)) {
            this.fWi = new com.baidu.tieba.pb.pb.sub.a(this.cmZ.getPageContext().getPageActivity());
            this.fWi.setBackgroundResource(d.C0108d.transparent);
            ((LinearLayout) viewGroup.getParent()).addView(this.fWi, 0, new LinearLayout.LayoutParams(-1, dMR));
            this.fWi.setVisibility(0);
            this.fWi.setOnClickListener(new View.OnClickListener() { // from class: com.baidu.tieba.pb.pb.sub.b.4
                @Override // android.view.View.OnClickListener
                public void onClick(View view) {
                    b.this.cmZ.finish();
                }
            });
            this.fWi.setScrollCallBack(new a.InterfaceC0145a() { // from class: com.baidu.tieba.pb.pb.sub.b.5
                @Override // com.baidu.tieba.pb.pb.sub.a.InterfaceC0145a
                public void axo() {
                    if (b.this.fWi != null) {
                        b.this.fWi.setVisibility(8);
                    }
                    b.this.dMT = false;
                    if (b.this.fWj != null) {
                        b.this.fWj.axj();
                    }
                }
            });
            this.cmZ.setExcludeHeight(dMR);
            this.dMT = true;
        }
    }

    public void a(a aVar) {
        this.fWj = aVar;
    }

    public boolean axn() {
        return this.dMT;
    }

    public void nz(int i) {
        if (this.fWi != null) {
            aj.s(this.fWi, i);
        }
    }
}
