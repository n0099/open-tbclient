package com.baidu.tieba.pb.pb.sub;

import android.view.MotionEvent;
import android.view.View;
import android.view.ViewGroup;
import android.widget.LinearLayout;
import com.baidu.adp.lib.util.l;
import com.baidu.tbadk.BaseActivity;
import com.baidu.tbadk.core.TbadkCoreApplication;
import com.baidu.tbadk.core.util.am;
import com.baidu.tbadk.core.view.NavigationBar;
import com.baidu.tieba.R;
import com.baidu.tieba.f.a;
import com.baidu.tieba.pb.pb.sub.BlankView;
/* loaded from: classes4.dex */
public class a {
    private View.OnTouchListener fKB;
    private com.baidu.tieba.f.b fzw;
    private BlankView iaZ;
    private InterfaceC0490a iba;
    private BaseActivity mActivity;
    private NavigationBar mNavigationBar;
    private static final int fKy = l.getDimens(TbadkCoreApplication.getInst(), R.dimen.ds160);
    private static final int TOUCH_SLOP = l.getDimens(TbadkCoreApplication.getInst(), R.dimen.ds20);
    private boolean fKA = false;
    private int ibb = R.color.transparent;

    /* renamed from: com.baidu.tieba.pb.pb.sub.a$a  reason: collision with other inner class name */
    /* loaded from: classes4.dex */
    public interface InterfaceC0490a {
        void bnX();

        void bnY();

        boolean bnZ();
    }

    public a(BaseActivity baseActivity, View view, NavigationBar navigationBar) {
        this.mActivity = baseActivity;
        this.fzw = new com.baidu.tieba.f.b(this.mActivity.getPageContext().getPageActivity());
        this.mNavigationBar = navigationBar;
        this.mNavigationBar.setStatusBarVisibility(8);
        this.fKB = new View.OnTouchListener() { // from class: com.baidu.tieba.pb.pb.sub.a.1
            @Override // android.view.View.OnTouchListener
            public boolean onTouch(View view2, MotionEvent motionEvent) {
                a.this.fzw.onTouchEvent(motionEvent);
                return true;
            }
        };
        view.setOnTouchListener(new View.OnTouchListener() { // from class: com.baidu.tieba.pb.pb.sub.a.2
            @Override // android.view.View.OnTouchListener
            public boolean onTouch(View view2, MotionEvent motionEvent) {
                a.this.fzw.onTouchEvent(motionEvent);
                return false;
            }
        });
        this.fzw.a(new a.InterfaceC0405a() { // from class: com.baidu.tieba.pb.pb.sub.a.3
            @Override // com.baidu.tieba.f.a.InterfaceC0405a
            public void v(int i, int i2) {
                if (a.this.iba != null && a.this.iba.bnZ() && Math.abs(i2) > a.TOUCH_SLOP) {
                    if (a.this.iaZ != null) {
                        a.this.iaZ.setBackgroundResource(R.color.transparent);
                    }
                    a.this.mActivity.finish();
                }
            }

            @Override // com.baidu.tieba.f.a.InterfaceC0405a
            public void w(int i, int i2) {
                a.this.boa();
            }

            @Override // com.baidu.tieba.f.a.InterfaceC0405a
            public void x(int i, int i2) {
            }
        });
    }

    public void cD(View view) {
        if (view != null) {
            view.setOnTouchListener(this.fKB);
        }
    }

    public void boa() {
        if (this.fKA && this.mNavigationBar != null && this.iaZ != null && this.iaZ.getVisibility() == 0) {
            this.mNavigationBar.setStatusBarVisibility(0);
            this.mActivity.setExcludeHeight(0);
            if (this.iba != null) {
                this.iba.bnX();
            }
            this.iaZ.boh();
        }
    }

    public void bob() {
        ViewGroup viewGroup;
        if (!this.fKA && (viewGroup = (ViewGroup) this.mActivity.findViewById(16908290)) != null && (viewGroup.getParent() instanceof LinearLayout)) {
            this.iaZ = new BlankView(this.mActivity.getPageContext().getPageActivity());
            this.iaZ.setBackgroundResource(R.color.transparent);
            ((LinearLayout) viewGroup.getParent()).addView(this.iaZ, 0, new LinearLayout.LayoutParams(-1, fKy));
            this.iaZ.setVisibility(0);
            this.iaZ.setOnClickListener(new View.OnClickListener() { // from class: com.baidu.tieba.pb.pb.sub.a.4
                @Override // android.view.View.OnClickListener
                public void onClick(View view) {
                    a.this.mActivity.finish();
                }
            });
            this.iaZ.setScrollCallBack(new BlankView.a() { // from class: com.baidu.tieba.pb.pb.sub.a.5
                @Override // com.baidu.tieba.pb.pb.sub.BlankView.a
                public void bod() {
                    if (a.this.iaZ != null) {
                        a.this.iaZ.setVisibility(8);
                    }
                    a.this.fKA = false;
                    if (a.this.iba != null) {
                        a.this.iba.bnY();
                    }
                }
            });
            this.mActivity.setExcludeHeight(fKy);
            this.fKA = true;
        }
    }

    public void a(InterfaceC0490a interfaceC0490a) {
        this.iba = interfaceC0490a;
    }

    public boolean boc() {
        return this.fKA;
    }

    public void rk(int i) {
        this.ibb = i;
        if (this.iaZ != null) {
            am.setBackgroundResource(this.iaZ, i);
        }
    }
}
