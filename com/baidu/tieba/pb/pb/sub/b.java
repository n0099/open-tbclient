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
    private BaseActivity bmv;
    private com.baidu.tieba.e.b cma;
    private com.baidu.tieba.pb.pb.sub.a eUR;
    private a eUT;
    private boolean eUU = false;
    private View.OnTouchListener eUV;
    private NavigationBar mNavigationBar;
    private static final int eUS = k.g(TbadkCoreApplication.getInst(), d.f.ds160);
    private static final int TOUCH_SLOP = k.g(TbadkCoreApplication.getInst(), d.f.ds20);

    /* loaded from: classes.dex */
    public interface a {
        void aUR();

        void aUS();

        boolean aUT();
    }

    public b(BaseActivity baseActivity, View view, NavigationBar navigationBar) {
        this.bmv = baseActivity;
        this.cma = new com.baidu.tieba.e.b(this.bmv.getPageContext().getPageActivity());
        this.mNavigationBar = navigationBar;
        this.mNavigationBar.setStatusBarVisibility(8);
        this.eUV = new View.OnTouchListener() { // from class: com.baidu.tieba.pb.pb.sub.b.1
            @Override // android.view.View.OnTouchListener
            public boolean onTouch(View view2, MotionEvent motionEvent) {
                b.this.cma.onTouchEvent(motionEvent);
                return true;
            }
        };
        view.setOnTouchListener(new View.OnTouchListener() { // from class: com.baidu.tieba.pb.pb.sub.b.2
            @Override // android.view.View.OnTouchListener
            public boolean onTouch(View view2, MotionEvent motionEvent) {
                b.this.cma.onTouchEvent(motionEvent);
                return false;
            }
        });
        this.cma.a(new a.InterfaceC0079a() { // from class: com.baidu.tieba.pb.pb.sub.b.3
            @Override // com.baidu.tieba.e.a.InterfaceC0079a
            public void ah(int i, int i2) {
                if (b.this.eUT != null && b.this.eUT.aUT() && Math.abs(i2) > b.TOUCH_SLOP) {
                    if (b.this.eUR != null) {
                        b.this.eUR.setBackgroundResource(d.e.transparent);
                    }
                    b.this.bmv.finish();
                }
            }

            @Override // com.baidu.tieba.e.a.InterfaceC0079a
            public void ai(int i, int i2) {
                b.this.aUO();
            }
        });
    }

    public void bg(View view) {
        if (view != null) {
            view.setOnTouchListener(this.eUV);
        }
    }

    public void aUO() {
        if (this.eUU && this.mNavigationBar != null && this.eUR != null && this.eUR.getVisibility() == 0) {
            this.mNavigationBar.setStatusBarVisibility(0);
            this.bmv.setExcludeHeight(0);
            if (this.eUT != null) {
                this.eUT.aUR();
            }
            this.eUR.aUM();
        }
    }

    public void aUP() {
        ViewGroup viewGroup;
        if (!this.eUU && (viewGroup = (ViewGroup) this.bmv.findViewById(16908290)) != null && (viewGroup.getParent() instanceof LinearLayout)) {
            this.eUR = new com.baidu.tieba.pb.pb.sub.a(this.bmv.getPageContext().getPageActivity());
            this.eUR.setBackgroundResource(d.e.transparent);
            ((LinearLayout) viewGroup.getParent()).addView(this.eUR, 0, new LinearLayout.LayoutParams(-1, eUS));
            this.eUR.setVisibility(0);
            this.eUR.setOnClickListener(new View.OnClickListener() { // from class: com.baidu.tieba.pb.pb.sub.b.4
                @Override // android.view.View.OnClickListener
                public void onClick(View view) {
                    b.this.bmv.finish();
                }
            });
            this.eUR.setScrollCallBack(new a.InterfaceC0111a() { // from class: com.baidu.tieba.pb.pb.sub.b.5
                @Override // com.baidu.tieba.pb.pb.sub.a.InterfaceC0111a
                public void aUN() {
                    if (b.this.eUR != null) {
                        b.this.eUR.setVisibility(8);
                    }
                    b.this.eUU = false;
                    if (b.this.eUT != null) {
                        b.this.eUT.aUS();
                    }
                }
            });
            this.bmv.setExcludeHeight(eUS);
            this.eUU = true;
        }
    }

    public void a(a aVar) {
        this.eUT = aVar;
    }

    public boolean aUQ() {
        return this.eUU;
    }

    public void py(int i) {
        if (this.eUR != null) {
            ai.j(this.eUR, i);
        }
    }
}
