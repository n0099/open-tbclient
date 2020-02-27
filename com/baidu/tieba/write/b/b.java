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
/* loaded from: classes13.dex */
public class b extends PopupWindow {
    private ViewGroup aDx;
    private View.OnClickListener ecb;
    private View fZa;
    private TextView kOA;
    private TextView kOB;
    private a kOz;
    private Context mContext;
    private View mLine;
    private final View.OnClickListener mOnClickListener;
    private int mStatusBarHeight;

    /* loaded from: classes13.dex */
    public interface a {
        void onItemClick(int i);
    }

    public b(Context context) {
        super(context);
        this.ecb = new View.OnClickListener() { // from class: com.baidu.tieba.write.b.b.1
            @Override // android.view.View.OnClickListener
            public void onClick(View view) {
                if (view == b.this.kOA) {
                    if (b.this.kOz != null) {
                        b.this.kOz.onItemClick(1);
                    }
                } else if (view == b.this.kOB && b.this.kOz != null) {
                    b.this.kOz.onItemClick(0);
                }
                b.this.AR();
            }
        };
        this.mOnClickListener = new View.OnClickListener() { // from class: com.baidu.tieba.write.b.b.2
            @Override // android.view.View.OnClickListener
            public void onClick(View view) {
                b.this.AR();
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

    private View bzn() {
        bzo();
        FrameLayout frameLayout = new FrameLayout(this.mContext);
        FrameLayout frameLayout2 = new FrameLayout(this.mContext);
        this.aDx = frameLayout2;
        frameLayout.addView(frameLayout2);
        frameLayout.addView(this.fZa);
        this.aDx.setOnClickListener(this.mOnClickListener);
        am.setBackgroundColor(this.mLine, R.color.cp_bg_line_c);
        am.setBackgroundResource(this.fZa, R.drawable.window_bg_profession_select);
        return frameLayout;
    }

    private void bzo() {
        this.fZa = LayoutInflater.from(this.mContext).inflate(R.layout.layout_profession_select, (ViewGroup) null);
        this.kOA = (TextView) this.fZa.findViewById(R.id.profession_select_title_profession);
        this.mLine = this.fZa.findViewById(R.id.profession_select_line);
        this.kOB = (TextView) this.fZa.findViewById(R.id.profession_select_title_all);
        this.kOA.setOnClickListener(this.ecb);
        this.kOB.setOnClickListener(this.ecb);
    }

    public void setData(List<com.baidu.tieba.write.b.a> list, int i) {
        if (list != null) {
            View bzn = bzn();
            for (com.baidu.tieba.write.b.a aVar : list) {
                if (aVar.kOy == 1) {
                    this.kOA.setText(aVar.kOx);
                } else {
                    this.kOB.setText(aVar.kOx);
                }
                if (i == 1) {
                    am.setViewTextColor(this.kOA, (int) R.color.common_color_10140);
                    am.setViewTextColor(this.kOB, (int) R.color.cp_cont_j);
                } else {
                    am.setViewTextColor(this.kOB, (int) R.color.common_color_10140);
                    am.setViewTextColor(this.kOA, (int) R.color.cp_cont_j);
                }
            }
            setContentView(bzn);
        }
    }

    public void a(a aVar) {
        this.kOz = aVar;
    }

    public void R(View view) {
        if (view != null) {
            if (Build.VERSION.SDK_INT < 24) {
                int[] iArr = new int[2];
                view.getLocationInWindow(iArr);
                if (g.showPopupWindowAsDropDown(this, view, iArr[0] - (view.getWidth() / 2), 0)) {
                    AT();
                    return;
                }
                return;
            }
            int height = this.mStatusBarHeight + view.getHeight();
            int[] iArr2 = new int[2];
            view.getLocationInWindow(iArr2);
            if (g.showPopupWindowAtLocation(this, view, 0, iArr2[0] + (view.getWidth() / 2), height)) {
                AT();
            }
        }
    }

    public void rY(int i) {
        this.mStatusBarHeight = i;
    }

    @Override // android.widget.PopupWindow
    public void dismiss() {
        AR();
    }

    public void AR() {
        AU();
    }

    /* JADX INFO: Access modifiers changed from: private */
    public void AS() {
        super.dismiss();
    }

    private void AT() {
        TranslateAnimation translateAnimation = new TranslateAnimation(1, 0.0f, 1, 0.0f, 1, -1.0f, 1, 0.0f);
        translateAnimation.setDuration(350L);
        translateAnimation.setInterpolator(new DecelerateInterpolator());
        AlphaAnimation alphaAnimation = new AlphaAnimation(0.0f, 1.0f);
        alphaAnimation.setDuration(350L);
        alphaAnimation.setInterpolator(new LinearInterpolator());
        this.fZa.startAnimation(translateAnimation);
        this.aDx.startAnimation(alphaAnimation);
    }

    private void AU() {
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
                b.this.AS();
            }
        });
        this.fZa.startAnimation(translateAnimation);
        this.aDx.startAnimation(alphaAnimation);
    }
}
