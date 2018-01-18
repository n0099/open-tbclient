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
    private com.baidu.tieba.e.b ckL;
    private BaseActivity cmR;
    private boolean dMy = false;
    private View.OnTouchListener dMz;
    private com.baidu.tieba.pb.pb.sub.a fVN;
    private a fVO;
    private NavigationBar mNavigationBar;
    private static final int dMw = l.s(TbadkCoreApplication.getInst(), d.e.ds160);
    private static final int TOUCH_SLOP = l.s(TbadkCoreApplication.getInst(), d.e.ds20);

    /* loaded from: classes2.dex */
    public interface a {
        void axd();

        void axe();

        boolean axf();
    }

    public b(BaseActivity baseActivity, View view, NavigationBar navigationBar) {
        this.cmR = baseActivity;
        this.ckL = new com.baidu.tieba.e.b(this.cmR.getPageContext().getPageActivity());
        this.mNavigationBar = navigationBar;
        this.mNavigationBar.setStatusBarVisibility(8);
        this.dMz = new View.OnTouchListener() { // from class: com.baidu.tieba.pb.pb.sub.b.1
            @Override // android.view.View.OnTouchListener
            public boolean onTouch(View view2, MotionEvent motionEvent) {
                b.this.ckL.onTouchEvent(motionEvent);
                return true;
            }
        };
        view.setOnTouchListener(new View.OnTouchListener() { // from class: com.baidu.tieba.pb.pb.sub.b.2
            @Override // android.view.View.OnTouchListener
            public boolean onTouch(View view2, MotionEvent motionEvent) {
                b.this.ckL.onTouchEvent(motionEvent);
                return false;
            }
        });
        this.ckL.a(new a.InterfaceC0108a() { // from class: com.baidu.tieba.pb.pb.sub.b.3
            @Override // com.baidu.tieba.e.a.InterfaceC0108a
            public void aY(int i, int i2) {
                if (b.this.fVO != null && b.this.fVO.axf() && Math.abs(i2) > b.TOUCH_SLOP) {
                    if (b.this.fVN != null) {
                        b.this.fVN.setBackgroundResource(d.C0107d.transparent);
                    }
                    b.this.cmR.finish();
                }
            }

            @Override // com.baidu.tieba.e.a.InterfaceC0108a
            public void aZ(int i, int i2) {
                b.this.axg();
            }

            @Override // com.baidu.tieba.e.a.InterfaceC0108a
            public void ba(int i, int i2) {
            }
        });
    }

    public void cC(View view) {
        if (view != null) {
            view.setOnTouchListener(this.dMz);
        }
    }

    public void axg() {
        if (this.dMy && this.mNavigationBar != null && this.fVN != null && this.fVN.getVisibility() == 0) {
            this.mNavigationBar.setStatusBarVisibility(0);
            this.cmR.setExcludeHeight(0);
            if (this.fVO != null) {
                this.fVO.axd();
            }
            this.fVN.axn();
        }
    }

    public void axh() {
        ViewGroup viewGroup;
        if (!this.dMy && (viewGroup = (ViewGroup) this.cmR.findViewById(16908290)) != null && (viewGroup.getParent() instanceof LinearLayout)) {
            this.fVN = new com.baidu.tieba.pb.pb.sub.a(this.cmR.getPageContext().getPageActivity());
            this.fVN.setBackgroundResource(d.C0107d.transparent);
            ((LinearLayout) viewGroup.getParent()).addView(this.fVN, 0, new LinearLayout.LayoutParams(-1, dMw));
            this.fVN.setVisibility(0);
            this.fVN.setOnClickListener(new View.OnClickListener() { // from class: com.baidu.tieba.pb.pb.sub.b.4
                @Override // android.view.View.OnClickListener
                public void onClick(View view) {
                    b.this.cmR.finish();
                }
            });
            this.fVN.setScrollCallBack(new a.InterfaceC0144a() { // from class: com.baidu.tieba.pb.pb.sub.b.5
                @Override // com.baidu.tieba.pb.pb.sub.a.InterfaceC0144a
                public void axj() {
                    if (b.this.fVN != null) {
                        b.this.fVN.setVisibility(8);
                    }
                    b.this.dMy = false;
                    if (b.this.fVO != null) {
                        b.this.fVO.axe();
                    }
                }
            });
            this.cmR.setExcludeHeight(dMw);
            this.dMy = true;
        }
    }

    public void a(a aVar) {
        this.fVO = aVar;
    }

    public boolean axi() {
        return this.dMy;
    }

    public void nz(int i) {
        if (this.fVN != null) {
            aj.s(this.fVN, i);
        }
    }
}
