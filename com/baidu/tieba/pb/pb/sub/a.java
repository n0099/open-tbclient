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
    private BaseActivity bcJ;
    private com.baidu.tieba.f.b byy;
    private boolean djW = false;
    private View.OnTouchListener djX;
    private BlankView fty;
    private InterfaceC0196a ftz;
    private NavigationBar mNavigationBar;
    private static final int djU = l.e(TbadkCoreApplication.getInst(), d.e.ds160);
    private static final int TOUCH_SLOP = l.e(TbadkCoreApplication.getInst(), d.e.ds20);

    /* renamed from: com.baidu.tieba.pb.pb.sub.a$a  reason: collision with other inner class name */
    /* loaded from: classes2.dex */
    public interface InterfaceC0196a {
        void asW();

        void asX();

        boolean asY();
    }

    public a(BaseActivity baseActivity, View view2, NavigationBar navigationBar) {
        this.bcJ = baseActivity;
        this.byy = new com.baidu.tieba.f.b(this.bcJ.getPageContext().getPageActivity());
        this.mNavigationBar = navigationBar;
        this.mNavigationBar.setStatusBarVisibility(8);
        this.djX = new View.OnTouchListener() { // from class: com.baidu.tieba.pb.pb.sub.a.1
            @Override // android.view.View.OnTouchListener
            public boolean onTouch(View view3, MotionEvent motionEvent) {
                a.this.byy.onTouchEvent(motionEvent);
                return true;
            }
        };
        view2.setOnTouchListener(new View.OnTouchListener() { // from class: com.baidu.tieba.pb.pb.sub.a.2
            @Override // android.view.View.OnTouchListener
            public boolean onTouch(View view3, MotionEvent motionEvent) {
                a.this.byy.onTouchEvent(motionEvent);
                return false;
            }
        });
        this.byy.a(new a.InterfaceC0131a() { // from class: com.baidu.tieba.pb.pb.sub.a.3
            @Override // com.baidu.tieba.f.a.InterfaceC0131a
            public void W(int i, int i2) {
                if (a.this.ftz != null && a.this.ftz.asY() && Math.abs(i2) > a.TOUCH_SLOP) {
                    if (a.this.fty != null) {
                        a.this.fty.setBackgroundResource(d.C0126d.transparent);
                    }
                    a.this.bcJ.finish();
                }
            }

            @Override // com.baidu.tieba.f.a.InterfaceC0131a
            public void X(int i, int i2) {
                a.this.asZ();
            }

            @Override // com.baidu.tieba.f.a.InterfaceC0131a
            public void Y(int i, int i2) {
            }
        });
    }

    public void bh(View view2) {
        if (view2 != null) {
            view2.setOnTouchListener(this.djX);
        }
    }

    public void asZ() {
        if (this.djW && this.mNavigationBar != null && this.fty != null && this.fty.getVisibility() == 0) {
            this.mNavigationBar.setStatusBarVisibility(0);
            this.bcJ.setExcludeHeight(0);
            if (this.ftz != null) {
                this.ftz.asW();
            }
            this.fty.atg();
        }
    }

    public void ata() {
        ViewGroup viewGroup;
        if (!this.djW && (viewGroup = (ViewGroup) this.bcJ.findViewById(16908290)) != null && (viewGroup.getParent() instanceof LinearLayout)) {
            this.fty = new BlankView(this.bcJ.getPageContext().getPageActivity());
            this.fty.setBackgroundResource(d.C0126d.transparent);
            ((LinearLayout) viewGroup.getParent()).addView(this.fty, 0, new LinearLayout.LayoutParams(-1, djU));
            this.fty.setVisibility(0);
            this.fty.setOnClickListener(new View.OnClickListener() { // from class: com.baidu.tieba.pb.pb.sub.a.4
                @Override // android.view.View.OnClickListener
                public void onClick(View view2) {
                    a.this.bcJ.finish();
                }
            });
            this.fty.setScrollCallBack(new BlankView.a() { // from class: com.baidu.tieba.pb.pb.sub.a.5
                @Override // com.baidu.tieba.pb.pb.sub.BlankView.a
                public void atc() {
                    if (a.this.fty != null) {
                        a.this.fty.setVisibility(8);
                    }
                    a.this.djW = false;
                    if (a.this.ftz != null) {
                        a.this.ftz.asX();
                    }
                }
            });
            this.bcJ.setExcludeHeight(djU);
            this.djW = true;
        }
    }

    public void a(InterfaceC0196a interfaceC0196a) {
        this.ftz = interfaceC0196a;
    }

    public boolean atb() {
        return this.djW;
    }

    public void kL(int i) {
        if (this.fty != null) {
            ak.i(this.fty, i);
        }
    }
}
