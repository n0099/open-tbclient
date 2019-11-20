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
    private ViewGroup aqK;
    private View.OnClickListener dkf;
    private View ffm;
    private a jPA;
    private TextView jPB;
    private TextView jPC;
    private Context mContext;
    private View mLine;
    private final View.OnClickListener mOnClickListener;
    private int mStatusBarHeight;

    /* loaded from: classes3.dex */
    public interface a {
        void lK(int i);
    }

    public b(Context context) {
        super(context);
        this.dkf = new View.OnClickListener() { // from class: com.baidu.tieba.write.b.b.1
            @Override // android.view.View.OnClickListener
            public void onClick(View view) {
                if (view == b.this.jPB) {
                    if (b.this.jPA != null) {
                        b.this.jPA.lK(1);
                    }
                } else if (view == b.this.jPC && b.this.jPA != null) {
                    b.this.jPA.lK(0);
                }
                b.this.wm();
            }
        };
        this.mOnClickListener = new View.OnClickListener() { // from class: com.baidu.tieba.write.b.b.2
            @Override // android.view.View.OnClickListener
            public void onClick(View view) {
                b.this.wm();
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

    private View bfo() {
        bfp();
        FrameLayout frameLayout = new FrameLayout(this.mContext);
        FrameLayout frameLayout2 = new FrameLayout(this.mContext);
        this.aqK = frameLayout2;
        frameLayout.addView(frameLayout2);
        frameLayout.addView(this.ffm);
        this.aqK.setOnClickListener(this.mOnClickListener);
        am.setBackgroundColor(this.mLine, R.color.cp_bg_line_c);
        am.setBackgroundResource(this.ffm, R.drawable.window_bg_profession_select);
        return frameLayout;
    }

    private void bfp() {
        this.ffm = LayoutInflater.from(this.mContext).inflate(R.layout.layout_profession_select, (ViewGroup) null);
        this.jPB = (TextView) this.ffm.findViewById(R.id.profession_select_title_profession);
        this.mLine = this.ffm.findViewById(R.id.profession_select_line);
        this.jPC = (TextView) this.ffm.findViewById(R.id.profession_select_title_all);
        this.jPB.setOnClickListener(this.dkf);
        this.jPC.setOnClickListener(this.dkf);
    }

    public void setData(List<com.baidu.tieba.write.b.a> list, int i) {
        if (list != null) {
            View bfo = bfo();
            for (com.baidu.tieba.write.b.a aVar : list) {
                if (aVar.jPz == 1) {
                    this.jPB.setText(aVar.jPy);
                } else {
                    this.jPC.setText(aVar.jPy);
                }
                if (i == 1) {
                    am.setViewTextColor(this.jPB, (int) R.color.common_color_10140);
                    am.setViewTextColor(this.jPC, (int) R.color.cp_cont_j);
                } else {
                    am.setViewTextColor(this.jPC, (int) R.color.common_color_10140);
                    am.setViewTextColor(this.jPB, (int) R.color.cp_cont_j);
                }
            }
            setContentView(bfo);
        }
    }

    public void a(a aVar) {
        this.jPA = aVar;
    }

    public void O(View view) {
        if (view != null) {
            if (Build.VERSION.SDK_INT < 24) {
                int[] iArr = new int[2];
                view.getLocationInWindow(iArr);
                if (g.showPopupWindowAsDropDown(this, view, iArr[0] - (view.getWidth() / 2), 0)) {
                    wo();
                    return;
                }
                return;
            }
            int height = this.mStatusBarHeight + view.getHeight();
            int[] iArr2 = new int[2];
            view.getLocationInWindow(iArr2);
            if (g.showPopupWindowAtLocation(this, view, 0, iArr2[0] + (view.getWidth() / 2), height)) {
                wo();
            }
        }
    }

    public void pH(int i) {
        this.mStatusBarHeight = i;
    }

    @Override // android.widget.PopupWindow
    public void dismiss() {
        wm();
    }

    public void wm() {
        wp();
    }

    /* JADX INFO: Access modifiers changed from: private */
    public void wn() {
        super.dismiss();
    }

    private void wo() {
        TranslateAnimation translateAnimation = new TranslateAnimation(1, 0.0f, 1, 0.0f, 1, -1.0f, 1, 0.0f);
        translateAnimation.setDuration(350L);
        translateAnimation.setInterpolator(new DecelerateInterpolator());
        AlphaAnimation alphaAnimation = new AlphaAnimation(0.0f, 1.0f);
        alphaAnimation.setDuration(350L);
        alphaAnimation.setInterpolator(new LinearInterpolator());
        this.ffm.startAnimation(translateAnimation);
        this.aqK.startAnimation(alphaAnimation);
    }

    private void wp() {
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
                b.this.wn();
            }
        });
        this.ffm.startAnimation(translateAnimation);
        this.aqK.startAnimation(alphaAnimation);
    }
}
