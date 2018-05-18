package com.baidu.tieba.pb.pb.sub;

import android.view.MotionEvent;
import android.view.View;
import android.view.ViewGroup;
import android.widget.LinearLayout;
import com.baidu.adp.lib.util.l;
import com.baidu.tbadk.BaseActivity;
import com.baidu.tbadk.core.TbadkCoreApplication;
import com.baidu.tbadk.core.util.ak;
import com.baidu.tbadk.core.view.NavigationBar;
import com.baidu.tieba.d;
import com.baidu.tieba.f.a;
import com.baidu.tieba.pb.pb.sub.BlankView;
/* loaded from: classes2.dex */
public class a {
    private BaseActivity bcK;
    private com.baidu.tieba.f.b bzr;
    private boolean dld = false;
    private View.OnTouchListener dle;
    private BlankView fuF;
    private InterfaceC0196a fuG;
    private NavigationBar mNavigationBar;
    private static final int dlb = l.e(TbadkCoreApplication.getInst(), d.e.ds160);
    private static final int TOUCH_SLOP = l.e(TbadkCoreApplication.getInst(), d.e.ds20);

    /* renamed from: com.baidu.tieba.pb.pb.sub.a$a  reason: collision with other inner class name */
    /* loaded from: classes2.dex */
    public interface InterfaceC0196a {
        void asV();

        void asW();

        boolean asX();
    }

    public a(BaseActivity baseActivity, View view2, NavigationBar navigationBar) {
        this.bcK = baseActivity;
        this.bzr = new com.baidu.tieba.f.b(this.bcK.getPageContext().getPageActivity());
        this.mNavigationBar = navigationBar;
        this.mNavigationBar.setStatusBarVisibility(8);
        this.dle = new View.OnTouchListener() { // from class: com.baidu.tieba.pb.pb.sub.a.1
            @Override // android.view.View.OnTouchListener
            public boolean onTouch(View view3, MotionEvent motionEvent) {
                a.this.bzr.onTouchEvent(motionEvent);
                return true;
            }
        };
        view2.setOnTouchListener(new View.OnTouchListener() { // from class: com.baidu.tieba.pb.pb.sub.a.2
            @Override // android.view.View.OnTouchListener
            public boolean onTouch(View view3, MotionEvent motionEvent) {
                a.this.bzr.onTouchEvent(motionEvent);
                return false;
            }
        });
        this.bzr.a(new a.InterfaceC0131a() { // from class: com.baidu.tieba.pb.pb.sub.a.3
            @Override // com.baidu.tieba.f.a.InterfaceC0131a
            public void W(int i, int i2) {
                if (a.this.fuG != null && a.this.fuG.asX() && Math.abs(i2) > a.TOUCH_SLOP) {
                    if (a.this.fuF != null) {
                        a.this.fuF.setBackgroundResource(d.C0126d.transparent);
                    }
                    a.this.bcK.finish();
                }
            }

            @Override // com.baidu.tieba.f.a.InterfaceC0131a
            public void X(int i, int i2) {
                a.this.asY();
            }

            @Override // com.baidu.tieba.f.a.InterfaceC0131a
            public void Y(int i, int i2) {
            }
        });
    }

    public void bh(View view2) {
        if (view2 != null) {
            view2.setOnTouchListener(this.dle);
        }
    }

    public void asY() {
        if (this.dld && this.mNavigationBar != null && this.fuF != null && this.fuF.getVisibility() == 0) {
            this.mNavigationBar.setStatusBarVisibility(0);
            this.bcK.setExcludeHeight(0);
            if (this.fuG != null) {
                this.fuG.asV();
            }
            this.fuF.atf();
        }
    }

    public void asZ() {
        ViewGroup viewGroup;
        if (!this.dld && (viewGroup = (ViewGroup) this.bcK.findViewById(16908290)) != null && (viewGroup.getParent() instanceof LinearLayout)) {
            this.fuF = new BlankView(this.bcK.getPageContext().getPageActivity());
            this.fuF.setBackgroundResource(d.C0126d.transparent);
            ((LinearLayout) viewGroup.getParent()).addView(this.fuF, 0, new LinearLayout.LayoutParams(-1, dlb));
            this.fuF.setVisibility(0);
            this.fuF.setOnClickListener(new View.OnClickListener() { // from class: com.baidu.tieba.pb.pb.sub.a.4
                @Override // android.view.View.OnClickListener
                public void onClick(View view2) {
                    a.this.bcK.finish();
                }
            });
            this.fuF.setScrollCallBack(new BlankView.a() { // from class: com.baidu.tieba.pb.pb.sub.a.5
                @Override // com.baidu.tieba.pb.pb.sub.BlankView.a
                public void atb() {
                    if (a.this.fuF != null) {
                        a.this.fuF.setVisibility(8);
                    }
                    a.this.dld = false;
                    if (a.this.fuG != null) {
                        a.this.fuG.asW();
                    }
                }
            });
            this.bcK.setExcludeHeight(dlb);
            this.dld = true;
        }
    }

    public void a(InterfaceC0196a interfaceC0196a) {
        this.fuG = interfaceC0196a;
    }

    public boolean ata() {
        return this.dld;
    }

    public void kK(int i) {
        if (this.fuF != null) {
            ak.i(this.fuF, i);
        }
    }
}
