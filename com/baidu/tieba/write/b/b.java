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
/* loaded from: classes10.dex */
public class b extends PopupWindow {
    private ViewGroup ayy;
    private View.OnClickListener dXO;
    private View fTQ;
    private a kKn;
    private TextView kKo;
    private TextView kKp;
    private Context mContext;
    private View mLine;
    private final View.OnClickListener mOnClickListener;
    private int mStatusBarHeight;

    /* loaded from: classes10.dex */
    public interface a {
        void onItemClick(int i);
    }

    public b(Context context) {
        super(context);
        this.dXO = new View.OnClickListener() { // from class: com.baidu.tieba.write.b.b.1
            @Override // android.view.View.OnClickListener
            public void onClick(View view) {
                if (view == b.this.kKo) {
                    if (b.this.kKn != null) {
                        b.this.kKn.onItemClick(1);
                    }
                } else if (view == b.this.kKp && b.this.kKn != null) {
                    b.this.kKn.onItemClick(0);
                }
                b.this.yk();
            }
        };
        this.mOnClickListener = new View.OnClickListener() { // from class: com.baidu.tieba.write.b.b.2
            @Override // android.view.View.OnClickListener
            public void onClick(View view) {
                b.this.yk();
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

    private View bwJ() {
        bwK();
        FrameLayout frameLayout = new FrameLayout(this.mContext);
        FrameLayout frameLayout2 = new FrameLayout(this.mContext);
        this.ayy = frameLayout2;
        frameLayout.addView(frameLayout2);
        frameLayout.addView(this.fTQ);
        this.ayy.setOnClickListener(this.mOnClickListener);
        am.setBackgroundColor(this.mLine, R.color.cp_bg_line_c);
        am.setBackgroundResource(this.fTQ, R.drawable.window_bg_profession_select);
        return frameLayout;
    }

    private void bwK() {
        this.fTQ = LayoutInflater.from(this.mContext).inflate(R.layout.layout_profession_select, (ViewGroup) null);
        this.kKo = (TextView) this.fTQ.findViewById(R.id.profession_select_title_profession);
        this.mLine = this.fTQ.findViewById(R.id.profession_select_line);
        this.kKp = (TextView) this.fTQ.findViewById(R.id.profession_select_title_all);
        this.kKo.setOnClickListener(this.dXO);
        this.kKp.setOnClickListener(this.dXO);
    }

    public void setData(List<com.baidu.tieba.write.b.a> list, int i) {
        if (list != null) {
            View bwJ = bwJ();
            for (com.baidu.tieba.write.b.a aVar : list) {
                if (aVar.kKm == 1) {
                    this.kKo.setText(aVar.kKl);
                } else {
                    this.kKp.setText(aVar.kKl);
                }
                if (i == 1) {
                    am.setViewTextColor(this.kKo, (int) R.color.common_color_10140);
                    am.setViewTextColor(this.kKp, (int) R.color.cp_cont_j);
                } else {
                    am.setViewTextColor(this.kKp, (int) R.color.common_color_10140);
                    am.setViewTextColor(this.kKo, (int) R.color.cp_cont_j);
                }
            }
            setContentView(bwJ);
        }
    }

    public void a(a aVar) {
        this.kKn = aVar;
    }

    public void P(View view) {
        if (view != null) {
            if (Build.VERSION.SDK_INT < 24) {
                int[] iArr = new int[2];
                view.getLocationInWindow(iArr);
                if (g.showPopupWindowAsDropDown(this, view, iArr[0] - (view.getWidth() / 2), 0)) {
                    ym();
                    return;
                }
                return;
            }
            int height = this.mStatusBarHeight + view.getHeight();
            int[] iArr2 = new int[2];
            view.getLocationInWindow(iArr2);
            if (g.showPopupWindowAtLocation(this, view, 0, iArr2[0] + (view.getWidth() / 2), height)) {
                ym();
            }
        }
    }

    public void rN(int i) {
        this.mStatusBarHeight = i;
    }

    @Override // android.widget.PopupWindow
    public void dismiss() {
        yk();
    }

    public void yk() {
        yn();
    }

    /* JADX INFO: Access modifiers changed from: private */
    public void yl() {
        super.dismiss();
    }

    private void ym() {
        TranslateAnimation translateAnimation = new TranslateAnimation(1, 0.0f, 1, 0.0f, 1, -1.0f, 1, 0.0f);
        translateAnimation.setDuration(350L);
        translateAnimation.setInterpolator(new DecelerateInterpolator());
        AlphaAnimation alphaAnimation = new AlphaAnimation(0.0f, 1.0f);
        alphaAnimation.setDuration(350L);
        alphaAnimation.setInterpolator(new LinearInterpolator());
        this.fTQ.startAnimation(translateAnimation);
        this.ayy.startAnimation(alphaAnimation);
    }

    private void yn() {
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
                b.this.yl();
            }
        });
        this.fTQ.startAnimation(translateAnimation);
        this.ayy.startAnimation(alphaAnimation);
    }
}
