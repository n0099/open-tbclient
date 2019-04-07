package com.baidu.tieba.write.b;

import android.content.Context;
import android.graphics.drawable.ColorDrawable;
import android.os.Build;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.view.animation.AccelerateInterpolator;
import android.view.animation.AlphaAnimation;
import android.view.animation.Animation;
import android.view.animation.DecelerateInterpolator;
import android.view.animation.LinearInterpolator;
import android.view.animation.TranslateAnimation;
import android.widget.FrameLayout;
import android.widget.PopupWindow;
import android.widget.TextView;
import com.baidu.adp.lib.g.g;
import com.baidu.tbadk.core.util.al;
import com.baidu.tieba.d;
import java.util.List;
/* loaded from: classes3.dex */
public class b extends PopupWindow {
    private View.OnClickListener cPW;
    private ViewGroup eGn;
    private View eGp;
    private a joT;
    private TextView joU;
    private TextView joV;
    private Context mContext;
    private View mLine;
    private final View.OnClickListener mOnClickListener;
    private int mStatusBarHeight;

    /* loaded from: classes3.dex */
    public interface a {
        void lH(int i);
    }

    public b(Context context) {
        super(context);
        this.cPW = new View.OnClickListener() { // from class: com.baidu.tieba.write.b.b.1
            @Override // android.view.View.OnClickListener
            public void onClick(View view) {
                if (view == b.this.joU) {
                    if (b.this.joT != null) {
                        b.this.joT.lH(1);
                    }
                } else if (view == b.this.joV && b.this.joT != null) {
                    b.this.joT.lH(0);
                }
                b.this.aXr();
            }
        };
        this.mOnClickListener = new View.OnClickListener() { // from class: com.baidu.tieba.write.b.b.2
            @Override // android.view.View.OnClickListener
            public void onClick(View view) {
                b.this.aXr();
            }
        };
        this.mContext = context;
        setWidth(-2);
        setHeight(-2);
        setFocusable(true);
        setTouchable(true);
        setOutsideTouchable(true);
        setAnimationStyle(0);
        setBackgroundDrawable(new ColorDrawable(0));
    }

    private View aXq() {
        createContentView();
        FrameLayout frameLayout = new FrameLayout(this.mContext);
        FrameLayout frameLayout2 = new FrameLayout(this.mContext);
        this.eGn = frameLayout2;
        frameLayout.addView(frameLayout2);
        frameLayout.addView(this.eGp);
        this.eGn.setOnClickListener(this.mOnClickListener);
        al.l(this.mLine, d.C0277d.cp_bg_line_c);
        al.k(this.eGp, d.f.window_bg_profession_select);
        return frameLayout;
    }

    private void createContentView() {
        this.eGp = LayoutInflater.from(this.mContext).inflate(d.h.layout_profession_select, (ViewGroup) null);
        this.joU = (TextView) this.eGp.findViewById(d.g.profession_select_title_profession);
        this.mLine = this.eGp.findViewById(d.g.profession_select_line);
        this.joV = (TextView) this.eGp.findViewById(d.g.profession_select_title_all);
        this.joU.setOnClickListener(this.cPW);
        this.joV.setOnClickListener(this.cPW);
    }

    public void setData(List<com.baidu.tieba.write.b.a> list, int i) {
        if (list != null) {
            View aXq = aXq();
            for (com.baidu.tieba.write.b.a aVar : list) {
                if (aVar.joS == 1) {
                    this.joU.setText(aVar.joR);
                } else {
                    this.joV.setText(aVar.joR);
                }
                if (i == 1) {
                    al.j(this.joU, d.C0277d.common_color_10140);
                    al.j(this.joV, d.C0277d.cp_cont_j);
                } else {
                    al.j(this.joV, d.C0277d.common_color_10140);
                    al.j(this.joU, d.C0277d.cp_cont_j);
                }
            }
            setContentView(aXq);
        }
    }

    public void a(a aVar) {
        this.joT = aVar;
    }

    public void bg(View view) {
        if (view != null) {
            if (Build.VERSION.SDK_INT < 24) {
                int[] iArr = new int[2];
                view.getLocationInWindow(iArr);
                if (g.showPopupWindowAsDropDown(this, view, iArr[0] - (view.getWidth() / 2), 0)) {
                    aXt();
                    return;
                }
                return;
            }
            int height = this.mStatusBarHeight + view.getHeight();
            int[] iArr2 = new int[2];
            view.getLocationInWindow(iArr2);
            if (g.showPopupWindowAtLocation(this, view, 0, iArr2[0] + (view.getWidth() / 2), height)) {
                aXt();
            }
        }
    }

    public void pj(int i) {
        this.mStatusBarHeight = i;
    }

    @Override // android.widget.PopupWindow
    public void dismiss() {
        aXr();
    }

    public void aXr() {
        aXu();
    }

    /* JADX INFO: Access modifiers changed from: private */
    public void aXs() {
        super.dismiss();
    }

    private void aXt() {
        TranslateAnimation translateAnimation = new TranslateAnimation(1, 0.0f, 1, 0.0f, 1, -1.0f, 1, 0.0f);
        translateAnimation.setDuration(350L);
        translateAnimation.setInterpolator(new DecelerateInterpolator());
        AlphaAnimation alphaAnimation = new AlphaAnimation(0.0f, 1.0f);
        alphaAnimation.setDuration(350L);
        alphaAnimation.setInterpolator(new LinearInterpolator());
        this.eGp.startAnimation(translateAnimation);
        this.eGn.startAnimation(alphaAnimation);
    }

    private void aXu() {
        TranslateAnimation translateAnimation = new TranslateAnimation(1, 0.0f, 1, 0.0f, 1, 0.0f, 1, -1.0f);
        translateAnimation.setDuration(350L);
        translateAnimation.setFillAfter(true);
        translateAnimation.setInterpolator(new AccelerateInterpolator());
        AlphaAnimation alphaAnimation = new AlphaAnimation(1.0f, 0.0f);
        alphaAnimation.setDuration(350L);
        alphaAnimation.setInterpolator(new LinearInterpolator());
        alphaAnimation.setAnimationListener(new Animation.AnimationListener() { // from class: com.baidu.tieba.write.b.b.3
            @Override // android.view.animation.Animation.AnimationListener
            public void onAnimationStart(Animation animation) {
            }

            @Override // android.view.animation.Animation.AnimationListener
            public void onAnimationRepeat(Animation animation) {
            }

            @Override // android.view.animation.Animation.AnimationListener
            public void onAnimationEnd(Animation animation) {
                b.this.aXs();
            }
        });
        this.eGp.startAnimation(translateAnimation);
        this.eGn.startAnimation(alphaAnimation);
    }
}
