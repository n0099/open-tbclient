package com.baidu.tieba.pb.pb.sub;

import android.view.MotionEvent;
import android.view.View;
import android.view.ViewGroup;
import android.widget.LinearLayout;
import com.baidu.adp.lib.util.l;
import com.baidu.tbadk.BaseActivity;
import com.baidu.tbadk.core.TbadkCoreApplication;
import com.baidu.tbadk.core.util.al;
import com.baidu.tbadk.core.view.NavigationBar;
import com.baidu.tieba.e;
import com.baidu.tieba.f.a;
import com.baidu.tieba.pb.pb.sub.BlankView;
/* loaded from: classes6.dex */
public class a {
    private com.baidu.tieba.f.b bYq;
    private BaseActivity bwX;
    private boolean dOS = false;
    private View.OnTouchListener dOT;
    private BlankView fZn;
    private InterfaceC0252a fZo;
    private NavigationBar mNavigationBar;
    private static final int dOQ = l.h(TbadkCoreApplication.getInst(), e.C0175e.ds160);
    private static final int TOUCH_SLOP = l.h(TbadkCoreApplication.getInst(), e.C0175e.ds20);

    /* renamed from: com.baidu.tieba.pb.pb.sub.a$a  reason: collision with other inner class name */
    /* loaded from: classes6.dex */
    public interface InterfaceC0252a {
        void aDQ();

        void aDR();

        boolean aDS();
    }

    public a(BaseActivity baseActivity, View view, NavigationBar navigationBar) {
        this.bwX = baseActivity;
        this.bYq = new com.baidu.tieba.f.b(this.bwX.getPageContext().getPageActivity());
        this.mNavigationBar = navigationBar;
        this.mNavigationBar.setStatusBarVisibility(8);
        this.dOT = new View.OnTouchListener() { // from class: com.baidu.tieba.pb.pb.sub.a.1
            @Override // android.view.View.OnTouchListener
            public boolean onTouch(View view2, MotionEvent motionEvent) {
                a.this.bYq.onTouchEvent(motionEvent);
                return true;
            }
        };
        view.setOnTouchListener(new View.OnTouchListener() { // from class: com.baidu.tieba.pb.pb.sub.a.2
            @Override // android.view.View.OnTouchListener
            public boolean onTouch(View view2, MotionEvent motionEvent) {
                a.this.bYq.onTouchEvent(motionEvent);
                return false;
            }
        });
        this.bYq.a(new a.InterfaceC0179a() { // from class: com.baidu.tieba.pb.pb.sub.a.3
            @Override // com.baidu.tieba.f.a.InterfaceC0179a
            public void af(int i, int i2) {
                if (a.this.fZo != null && a.this.fZo.aDS() && Math.abs(i2) > a.TOUCH_SLOP) {
                    if (a.this.fZn != null) {
                        a.this.fZn.setBackgroundResource(e.d.transparent);
                    }
                    a.this.bwX.finish();
                }
            }

            @Override // com.baidu.tieba.f.a.InterfaceC0179a
            public void ag(int i, int i2) {
                a.this.aDT();
            }

            @Override // com.baidu.tieba.f.a.InterfaceC0179a
            public void ah(int i, int i2) {
            }
        });
    }

    public void bD(View view) {
        if (view != null) {
            view.setOnTouchListener(this.dOT);
        }
    }

    public void aDT() {
        if (this.dOS && this.mNavigationBar != null && this.fZn != null && this.fZn.getVisibility() == 0) {
            this.mNavigationBar.setStatusBarVisibility(0);
            this.bwX.setExcludeHeight(0);
            if (this.fZo != null) {
                this.fZo.aDQ();
            }
            this.fZn.aEa();
        }
    }

    public void aDU() {
        ViewGroup viewGroup;
        if (!this.dOS && (viewGroup = (ViewGroup) this.bwX.findViewById(16908290)) != null && (viewGroup.getParent() instanceof LinearLayout)) {
            this.fZn = new BlankView(this.bwX.getPageContext().getPageActivity());
            this.fZn.setBackgroundResource(e.d.transparent);
            ((LinearLayout) viewGroup.getParent()).addView(this.fZn, 0, new LinearLayout.LayoutParams(-1, dOQ));
            this.fZn.setVisibility(0);
            this.fZn.setOnClickListener(new View.OnClickListener() { // from class: com.baidu.tieba.pb.pb.sub.a.4
                @Override // android.view.View.OnClickListener
                public void onClick(View view) {
                    a.this.bwX.finish();
                }
            });
            this.fZn.setScrollCallBack(new BlankView.a() { // from class: com.baidu.tieba.pb.pb.sub.a.5
                @Override // com.baidu.tieba.pb.pb.sub.BlankView.a
                public void aDW() {
                    if (a.this.fZn != null) {
                        a.this.fZn.setVisibility(8);
                    }
                    a.this.dOS = false;
                    if (a.this.fZo != null) {
                        a.this.fZo.aDR();
                    }
                }
            });
            this.bwX.setExcludeHeight(dOQ);
            this.dOS = true;
        }
    }

    public void a(InterfaceC0252a interfaceC0252a) {
        this.fZo = interfaceC0252a;
    }

    public boolean aDV() {
        return this.dOS;
    }

    public void mh(int i) {
        if (this.fZn != null) {
            al.i(this.fZn, i);
        }
    }
}
