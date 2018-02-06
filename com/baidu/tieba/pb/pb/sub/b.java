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
    private BaseActivity bSO;
    private com.baidu.tieba.e.b coo;
    private boolean dPS = false;
    private View.OnTouchListener dPT;
    private com.baidu.tieba.pb.pb.sub.a fZq;
    private a fZr;
    private NavigationBar mNavigationBar;
    private static final int dPQ = l.t(TbadkCoreApplication.getInst(), d.e.ds160);
    private static final int TOUCH_SLOP = l.t(TbadkCoreApplication.getInst(), d.e.ds20);

    /* loaded from: classes2.dex */
    public interface a {
        void ayg();

        void ayh();

        boolean ayi();
    }

    public b(BaseActivity baseActivity, View view, NavigationBar navigationBar) {
        this.bSO = baseActivity;
        this.coo = new com.baidu.tieba.e.b(this.bSO.getPageContext().getPageActivity());
        this.mNavigationBar = navigationBar;
        this.mNavigationBar.setStatusBarVisibility(8);
        this.dPT = new View.OnTouchListener() { // from class: com.baidu.tieba.pb.pb.sub.b.1
            @Override // android.view.View.OnTouchListener
            public boolean onTouch(View view2, MotionEvent motionEvent) {
                b.this.coo.onTouchEvent(motionEvent);
                return true;
            }
        };
        view.setOnTouchListener(new View.OnTouchListener() { // from class: com.baidu.tieba.pb.pb.sub.b.2
            @Override // android.view.View.OnTouchListener
            public boolean onTouch(View view2, MotionEvent motionEvent) {
                b.this.coo.onTouchEvent(motionEvent);
                return false;
            }
        });
        this.coo.a(new a.InterfaceC0142a() { // from class: com.baidu.tieba.pb.pb.sub.b.3
            @Override // com.baidu.tieba.e.a.InterfaceC0142a
            public void aY(int i, int i2) {
                if (b.this.fZr != null && b.this.fZr.ayi() && Math.abs(i2) > b.TOUCH_SLOP) {
                    if (b.this.fZq != null) {
                        b.this.fZq.setBackgroundResource(d.C0140d.transparent);
                    }
                    b.this.bSO.finish();
                }
            }

            @Override // com.baidu.tieba.e.a.InterfaceC0142a
            public void aZ(int i, int i2) {
                b.this.ayj();
            }

            @Override // com.baidu.tieba.e.a.InterfaceC0142a
            public void ba(int i, int i2) {
            }
        });
    }

    public void cB(View view) {
        if (view != null) {
            view.setOnTouchListener(this.dPT);
        }
    }

    public void ayj() {
        if (this.dPS && this.mNavigationBar != null && this.fZq != null && this.fZq.getVisibility() == 0) {
            this.mNavigationBar.setStatusBarVisibility(0);
            this.bSO.setExcludeHeight(0);
            if (this.fZr != null) {
                this.fZr.ayg();
            }
            this.fZq.ayq();
        }
    }

    public void ayk() {
        ViewGroup viewGroup;
        if (!this.dPS && (viewGroup = (ViewGroup) this.bSO.findViewById(16908290)) != null && (viewGroup.getParent() instanceof LinearLayout)) {
            this.fZq = new com.baidu.tieba.pb.pb.sub.a(this.bSO.getPageContext().getPageActivity());
            this.fZq.setBackgroundResource(d.C0140d.transparent);
            ((LinearLayout) viewGroup.getParent()).addView(this.fZq, 0, new LinearLayout.LayoutParams(-1, dPQ));
            this.fZq.setVisibility(0);
            this.fZq.setOnClickListener(new View.OnClickListener() { // from class: com.baidu.tieba.pb.pb.sub.b.4
                @Override // android.view.View.OnClickListener
                public void onClick(View view) {
                    b.this.bSO.finish();
                }
            });
            this.fZq.setScrollCallBack(new a.InterfaceC0213a() { // from class: com.baidu.tieba.pb.pb.sub.b.5
                @Override // com.baidu.tieba.pb.pb.sub.a.InterfaceC0213a
                public void aym() {
                    if (b.this.fZq != null) {
                        b.this.fZq.setVisibility(8);
                    }
                    b.this.dPS = false;
                    if (b.this.fZr != null) {
                        b.this.fZr.ayh();
                    }
                }
            });
            this.bSO.setExcludeHeight(dPQ);
            this.dPS = true;
        }
    }

    public void a(a aVar) {
        this.fZr = aVar;
    }

    public boolean ayl() {
        return this.dPS;
    }

    public void nx(int i) {
        if (this.fZq != null) {
            aj.s(this.fZq, i);
        }
    }
}
