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
    private boolean djZ = false;
    private View.OnTouchListener dka;
    private BlankView ftB;
    private InterfaceC0196a ftC;
    private NavigationBar mNavigationBar;
    private static final int djX = l.e(TbadkCoreApplication.getInst(), d.e.ds160);
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
        this.dka = new View.OnTouchListener() { // from class: com.baidu.tieba.pb.pb.sub.a.1
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
                if (a.this.ftC != null && a.this.ftC.asY() && Math.abs(i2) > a.TOUCH_SLOP) {
                    if (a.this.ftB != null) {
                        a.this.ftB.setBackgroundResource(d.C0126d.transparent);
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
            view2.setOnTouchListener(this.dka);
        }
    }

    public void asZ() {
        if (this.djZ && this.mNavigationBar != null && this.ftB != null && this.ftB.getVisibility() == 0) {
            this.mNavigationBar.setStatusBarVisibility(0);
            this.bcJ.setExcludeHeight(0);
            if (this.ftC != null) {
                this.ftC.asW();
            }
            this.ftB.atg();
        }
    }

    public void ata() {
        ViewGroup viewGroup;
        if (!this.djZ && (viewGroup = (ViewGroup) this.bcJ.findViewById(16908290)) != null && (viewGroup.getParent() instanceof LinearLayout)) {
            this.ftB = new BlankView(this.bcJ.getPageContext().getPageActivity());
            this.ftB.setBackgroundResource(d.C0126d.transparent);
            ((LinearLayout) viewGroup.getParent()).addView(this.ftB, 0, new LinearLayout.LayoutParams(-1, djX));
            this.ftB.setVisibility(0);
            this.ftB.setOnClickListener(new View.OnClickListener() { // from class: com.baidu.tieba.pb.pb.sub.a.4
                @Override // android.view.View.OnClickListener
                public void onClick(View view2) {
                    a.this.bcJ.finish();
                }
            });
            this.ftB.setScrollCallBack(new BlankView.a() { // from class: com.baidu.tieba.pb.pb.sub.a.5
                @Override // com.baidu.tieba.pb.pb.sub.BlankView.a
                public void atc() {
                    if (a.this.ftB != null) {
                        a.this.ftB.setVisibility(8);
                    }
                    a.this.djZ = false;
                    if (a.this.ftC != null) {
                        a.this.ftC.asX();
                    }
                }
            });
            this.bcJ.setExcludeHeight(djX);
            this.djZ = true;
        }
    }

    public void a(InterfaceC0196a interfaceC0196a) {
        this.ftC = interfaceC0196a;
    }

    public boolean atb() {
        return this.djZ;
    }

    public void kM(int i) {
        if (this.ftB != null) {
            ak.i(this.ftB, i);
        }
    }
}
