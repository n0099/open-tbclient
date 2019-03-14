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
    private View.OnClickListener cPU;
    private ViewGroup eGB;
    private View eGD;
    private a jpe;
    private TextView jpf;
    private TextView jpg;
    private Context mContext;
    private View mLine;
    private final View.OnClickListener mOnClickListener;
    private int mStatusBarHeight;

    /* loaded from: classes3.dex */
    public interface a {
        void lI(int i);
    }

    public b(Context context) {
        super(context);
        this.cPU = new View.OnClickListener() { // from class: com.baidu.tieba.write.b.b.1
            @Override // android.view.View.OnClickListener
            public void onClick(View view) {
                if (view == b.this.jpf) {
                    if (b.this.jpe != null) {
                        b.this.jpe.lI(1);
                    }
                } else if (view == b.this.jpg && b.this.jpe != null) {
                    b.this.jpe.lI(0);
                }
                b.this.aXu();
            }
        };
        this.mOnClickListener = new View.OnClickListener() { // from class: com.baidu.tieba.write.b.b.2
            @Override // android.view.View.OnClickListener
            public void onClick(View view) {
                b.this.aXu();
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

    private View aXs() {
        aXt();
        FrameLayout frameLayout = new FrameLayout(this.mContext);
        FrameLayout frameLayout2 = new FrameLayout(this.mContext);
        this.eGB = frameLayout2;
        frameLayout.addView(frameLayout2);
        frameLayout.addView(this.eGD);
        this.eGB.setOnClickListener(this.mOnClickListener);
        al.l(this.mLine, d.C0277d.cp_bg_line_c);
        al.k(this.eGD, d.f.window_bg_profession_select);
        return frameLayout;
    }

    private void aXt() {
        this.eGD = LayoutInflater.from(this.mContext).inflate(d.h.layout_profession_select, (ViewGroup) null);
        this.jpf = (TextView) this.eGD.findViewById(d.g.profession_select_title_profession);
        this.mLine = this.eGD.findViewById(d.g.profession_select_line);
        this.jpg = (TextView) this.eGD.findViewById(d.g.profession_select_title_all);
        this.jpf.setOnClickListener(this.cPU);
        this.jpg.setOnClickListener(this.cPU);
    }

    public void setData(List<com.baidu.tieba.write.b.a> list, int i) {
        if (list != null) {
            View aXs = aXs();
            for (com.baidu.tieba.write.b.a aVar : list) {
                if (aVar.jpd == 1) {
                    this.jpf.setText(aVar.jpc);
                } else {
                    this.jpg.setText(aVar.jpc);
                }
                if (i == 1) {
                    al.j(this.jpf, d.C0277d.common_color_10140);
                    al.j(this.jpg, d.C0277d.cp_cont_j);
                } else {
                    al.j(this.jpg, d.C0277d.common_color_10140);
                    al.j(this.jpf, d.C0277d.cp_cont_j);
                }
            }
            setContentView(aXs);
        }
    }

    public void a(a aVar) {
        this.jpe = aVar;
    }

    public void bg(View view) {
        if (view != null) {
            if (Build.VERSION.SDK_INT < 24) {
                int[] iArr = new int[2];
                view.getLocationInWindow(iArr);
                if (g.showPopupWindowAsDropDown(this, view, iArr[0] - (view.getWidth() / 2), 0)) {
                    aXw();
                    return;
                }
                return;
            }
            int height = this.mStatusBarHeight + view.getHeight();
            int[] iArr2 = new int[2];
            view.getLocationInWindow(iArr2);
            if (g.showPopupWindowAtLocation(this, view, 0, iArr2[0] + (view.getWidth() / 2), height)) {
                aXw();
            }
        }
    }

    public void po(int i) {
        this.mStatusBarHeight = i;
    }

    @Override // android.widget.PopupWindow
    public void dismiss() {
        aXu();
    }

    public void aXu() {
        aXx();
    }

    /* JADX INFO: Access modifiers changed from: private */
    public void aXv() {
        super.dismiss();
    }

    private void aXw() {
        TranslateAnimation translateAnimation = new TranslateAnimation(1, 0.0f, 1, 0.0f, 1, -1.0f, 1, 0.0f);
        translateAnimation.setDuration(350L);
        translateAnimation.setInterpolator(new DecelerateInterpolator());
        AlphaAnimation alphaAnimation = new AlphaAnimation(0.0f, 1.0f);
        alphaAnimation.setDuration(350L);
        alphaAnimation.setInterpolator(new LinearInterpolator());
        this.eGD.startAnimation(translateAnimation);
        this.eGB.startAnimation(alphaAnimation);
    }

    private void aXx() {
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
                b.this.aXv();
            }
        });
        this.eGD.startAnimation(translateAnimation);
        this.eGB.startAnimation(alphaAnimation);
    }
}
