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
import com.baidu.tbadk.core.util.am;
import com.baidu.tieba.R;
import java.util.List;
/* loaded from: classes3.dex */
public class b extends PopupWindow {
    private View.OnClickListener cZG;
    private ViewGroup fbr;
    private View fbt;
    private a jPb;
    private TextView jPc;
    private TextView jPd;
    private Context mContext;
    private View mLine;
    private final View.OnClickListener mOnClickListener;
    private int mStatusBarHeight;

    /* loaded from: classes3.dex */
    public interface a {
        void mB(int i);
    }

    public b(Context context) {
        super(context);
        this.cZG = new View.OnClickListener() { // from class: com.baidu.tieba.write.b.b.1
            @Override // android.view.View.OnClickListener
            public void onClick(View view) {
                if (view == b.this.jPc) {
                    if (b.this.jPb != null) {
                        b.this.jPb.mB(1);
                    }
                } else if (view == b.this.jPd && b.this.jPb != null) {
                    b.this.jPb.mB(0);
                }
                b.this.bgM();
            }
        };
        this.mOnClickListener = new View.OnClickListener() { // from class: com.baidu.tieba.write.b.b.2
            @Override // android.view.View.OnClickListener
            public void onClick(View view) {
                b.this.bgM();
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

    private View bgL() {
        createContentView();
        FrameLayout frameLayout = new FrameLayout(this.mContext);
        FrameLayout frameLayout2 = new FrameLayout(this.mContext);
        this.fbr = frameLayout2;
        frameLayout.addView(frameLayout2);
        frameLayout.addView(this.fbt);
        this.fbr.setOnClickListener(this.mOnClickListener);
        am.l(this.mLine, R.color.cp_bg_line_c);
        am.k(this.fbt, R.drawable.window_bg_profession_select);
        return frameLayout;
    }

    private void createContentView() {
        this.fbt = LayoutInflater.from(this.mContext).inflate(R.layout.layout_profession_select, (ViewGroup) null);
        this.jPc = (TextView) this.fbt.findViewById(R.id.profession_select_title_profession);
        this.mLine = this.fbt.findViewById(R.id.profession_select_line);
        this.jPd = (TextView) this.fbt.findViewById(R.id.profession_select_title_all);
        this.jPc.setOnClickListener(this.cZG);
        this.jPd.setOnClickListener(this.cZG);
    }

    public void setData(List<com.baidu.tieba.write.b.a> list, int i) {
        if (list != null) {
            View bgL = bgL();
            for (com.baidu.tieba.write.b.a aVar : list) {
                if (aVar.jPa == 1) {
                    this.jPc.setText(aVar.jOZ);
                } else {
                    this.jPd.setText(aVar.jOZ);
                }
                if (i == 1) {
                    am.j(this.jPc, R.color.common_color_10140);
                    am.j(this.jPd, R.color.cp_cont_j);
                } else {
                    am.j(this.jPd, R.color.common_color_10140);
                    am.j(this.jPc, R.color.cp_cont_j);
                }
            }
            setContentView(bgL);
        }
    }

    public void a(a aVar) {
        this.jPb = aVar;
    }

    public void bo(View view) {
        if (view != null) {
            if (Build.VERSION.SDK_INT < 24) {
                int[] iArr = new int[2];
                view.getLocationInWindow(iArr);
                if (g.showPopupWindowAsDropDown(this, view, iArr[0] - (view.getWidth() / 2), 0)) {
                    bgN();
                    return;
                }
                return;
            }
            int height = this.mStatusBarHeight + view.getHeight();
            int[] iArr2 = new int[2];
            view.getLocationInWindow(iArr2);
            if (g.showPopupWindowAtLocation(this, view, 0, iArr2[0] + (view.getWidth() / 2), height)) {
                bgN();
            }
        }
    }

    public void qH(int i) {
        this.mStatusBarHeight = i;
    }

    @Override // android.widget.PopupWindow
    public void dismiss() {
        bgM();
    }

    public void bgM() {
        bgO();
    }

    /* JADX INFO: Access modifiers changed from: private */
    public void MS() {
        super.dismiss();
    }

    private void bgN() {
        TranslateAnimation translateAnimation = new TranslateAnimation(1, 0.0f, 1, 0.0f, 1, -1.0f, 1, 0.0f);
        translateAnimation.setDuration(350L);
        translateAnimation.setInterpolator(new DecelerateInterpolator());
        AlphaAnimation alphaAnimation = new AlphaAnimation(0.0f, 1.0f);
        alphaAnimation.setDuration(350L);
        alphaAnimation.setInterpolator(new LinearInterpolator());
        this.fbt.startAnimation(translateAnimation);
        this.fbr.startAnimation(alphaAnimation);
    }

    private void bgO() {
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
                b.this.MS();
            }
        });
        this.fbt.startAnimation(translateAnimation);
        this.fbr.startAnimation(alphaAnimation);
    }
}
