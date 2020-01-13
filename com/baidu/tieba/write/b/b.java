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
import com.baidu.adp.lib.f.g;
import com.baidu.tbadk.core.util.am;
import com.baidu.tieba.R;
import java.util.List;
/* loaded from: classes11.dex */
public class b extends PopupWindow {
    private ViewGroup azh;
    private View.OnClickListener dXX;
    private View fWZ;
    private a kNO;
    private TextView kNP;
    private TextView kNQ;
    private Context mContext;
    private View mLine;
    private final View.OnClickListener mOnClickListener;
    private int mStatusBarHeight;

    /* loaded from: classes11.dex */
    public interface a {
        void onItemClick(int i);
    }

    public b(Context context) {
        super(context);
        this.dXX = new View.OnClickListener() { // from class: com.baidu.tieba.write.b.b.1
            @Override // android.view.View.OnClickListener
            public void onClick(View view) {
                if (view == b.this.kNP) {
                    if (b.this.kNO != null) {
                        b.this.kNO.onItemClick(1);
                    }
                } else if (view == b.this.kNQ && b.this.kNO != null) {
                    b.this.kNO.onItemClick(0);
                }
                b.this.yA();
            }
        };
        this.mOnClickListener = new View.OnClickListener() { // from class: com.baidu.tieba.write.b.b.2
            @Override // android.view.View.OnClickListener
            public void onClick(View view) {
                b.this.yA();
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

    private View bxL() {
        bxM();
        FrameLayout frameLayout = new FrameLayout(this.mContext);
        FrameLayout frameLayout2 = new FrameLayout(this.mContext);
        this.azh = frameLayout2;
        frameLayout.addView(frameLayout2);
        frameLayout.addView(this.fWZ);
        this.azh.setOnClickListener(this.mOnClickListener);
        am.setBackgroundColor(this.mLine, R.color.cp_bg_line_c);
        am.setBackgroundResource(this.fWZ, R.drawable.window_bg_profession_select);
        return frameLayout;
    }

    private void bxM() {
        this.fWZ = LayoutInflater.from(this.mContext).inflate(R.layout.layout_profession_select, (ViewGroup) null);
        this.kNP = (TextView) this.fWZ.findViewById(R.id.profession_select_title_profession);
        this.mLine = this.fWZ.findViewById(R.id.profession_select_line);
        this.kNQ = (TextView) this.fWZ.findViewById(R.id.profession_select_title_all);
        this.kNP.setOnClickListener(this.dXX);
        this.kNQ.setOnClickListener(this.dXX);
    }

    public void setData(List<com.baidu.tieba.write.b.a> list, int i) {
        if (list != null) {
            View bxL = bxL();
            for (com.baidu.tieba.write.b.a aVar : list) {
                if (aVar.kNN == 1) {
                    this.kNP.setText(aVar.kNM);
                } else {
                    this.kNQ.setText(aVar.kNM);
                }
                if (i == 1) {
                    am.setViewTextColor(this.kNP, (int) R.color.common_color_10140);
                    am.setViewTextColor(this.kNQ, (int) R.color.cp_cont_j);
                } else {
                    am.setViewTextColor(this.kNQ, (int) R.color.common_color_10140);
                    am.setViewTextColor(this.kNP, (int) R.color.cp_cont_j);
                }
            }
            setContentView(bxL);
        }
    }

    public void a(a aVar) {
        this.kNO = aVar;
    }

    public void R(View view) {
        if (view != null) {
            if (Build.VERSION.SDK_INT < 24) {
                int[] iArr = new int[2];
                view.getLocationInWindow(iArr);
                if (g.showPopupWindowAsDropDown(this, view, iArr[0] - (view.getWidth() / 2), 0)) {
                    yC();
                    return;
                }
                return;
            }
            int height = this.mStatusBarHeight + view.getHeight();
            int[] iArr2 = new int[2];
            view.getLocationInWindow(iArr2);
            if (g.showPopupWindowAtLocation(this, view, 0, iArr2[0] + (view.getWidth() / 2), height)) {
                yC();
            }
        }
    }

    public void rS(int i) {
        this.mStatusBarHeight = i;
    }

    @Override // android.widget.PopupWindow
    public void dismiss() {
        yA();
    }

    public void yA() {
        yD();
    }

    /* JADX INFO: Access modifiers changed from: private */
    public void yB() {
        super.dismiss();
    }

    private void yC() {
        TranslateAnimation translateAnimation = new TranslateAnimation(1, 0.0f, 1, 0.0f, 1, -1.0f, 1, 0.0f);
        translateAnimation.setDuration(350L);
        translateAnimation.setInterpolator(new DecelerateInterpolator());
        AlphaAnimation alphaAnimation = new AlphaAnimation(0.0f, 1.0f);
        alphaAnimation.setDuration(350L);
        alphaAnimation.setInterpolator(new LinearInterpolator());
        this.fWZ.startAnimation(translateAnimation);
        this.azh.startAnimation(alphaAnimation);
    }

    private void yD() {
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
                b.this.yB();
            }
        });
        this.fWZ.startAnimation(translateAnimation);
        this.azh.startAnimation(alphaAnimation);
    }
}
