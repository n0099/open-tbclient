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
    private View.OnClickListener cZN;
    private ViewGroup fbQ;
    private View fbS;
    private a jQi;
    private TextView jQj;
    private TextView jQk;
    private Context mContext;
    private View mLine;
    private final View.OnClickListener mOnClickListener;
    private int mStatusBarHeight;

    /* loaded from: classes3.dex */
    public interface a {
        void mC(int i);
    }

    public b(Context context) {
        super(context);
        this.cZN = new View.OnClickListener() { // from class: com.baidu.tieba.write.b.b.1
            @Override // android.view.View.OnClickListener
            public void onClick(View view) {
                if (view == b.this.jQj) {
                    if (b.this.jQi != null) {
                        b.this.jQi.mC(1);
                    }
                } else if (view == b.this.jQk && b.this.jQi != null) {
                    b.this.jQi.mC(0);
                }
                b.this.bgT();
            }
        };
        this.mOnClickListener = new View.OnClickListener() { // from class: com.baidu.tieba.write.b.b.2
            @Override // android.view.View.OnClickListener
            public void onClick(View view) {
                b.this.bgT();
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

    private View bgS() {
        createContentView();
        FrameLayout frameLayout = new FrameLayout(this.mContext);
        FrameLayout frameLayout2 = new FrameLayout(this.mContext);
        this.fbQ = frameLayout2;
        frameLayout.addView(frameLayout2);
        frameLayout.addView(this.fbS);
        this.fbQ.setOnClickListener(this.mOnClickListener);
        am.l(this.mLine, R.color.cp_bg_line_c);
        am.k(this.fbS, R.drawable.window_bg_profession_select);
        return frameLayout;
    }

    private void createContentView() {
        this.fbS = LayoutInflater.from(this.mContext).inflate(R.layout.layout_profession_select, (ViewGroup) null);
        this.jQj = (TextView) this.fbS.findViewById(R.id.profession_select_title_profession);
        this.mLine = this.fbS.findViewById(R.id.profession_select_line);
        this.jQk = (TextView) this.fbS.findViewById(R.id.profession_select_title_all);
        this.jQj.setOnClickListener(this.cZN);
        this.jQk.setOnClickListener(this.cZN);
    }

    public void setData(List<com.baidu.tieba.write.b.a> list, int i) {
        if (list != null) {
            View bgS = bgS();
            for (com.baidu.tieba.write.b.a aVar : list) {
                if (aVar.jQh == 1) {
                    this.jQj.setText(aVar.jQg);
                } else {
                    this.jQk.setText(aVar.jQg);
                }
                if (i == 1) {
                    am.j(this.jQj, R.color.common_color_10140);
                    am.j(this.jQk, R.color.cp_cont_j);
                } else {
                    am.j(this.jQk, R.color.common_color_10140);
                    am.j(this.jQj, R.color.cp_cont_j);
                }
            }
            setContentView(bgS);
        }
    }

    public void a(a aVar) {
        this.jQi = aVar;
    }

    public void bo(View view) {
        if (view != null) {
            if (Build.VERSION.SDK_INT < 24) {
                int[] iArr = new int[2];
                view.getLocationInWindow(iArr);
                if (g.showPopupWindowAsDropDown(this, view, iArr[0] - (view.getWidth() / 2), 0)) {
                    bgU();
                    return;
                }
                return;
            }
            int height = this.mStatusBarHeight + view.getHeight();
            int[] iArr2 = new int[2];
            view.getLocationInWindow(iArr2);
            if (g.showPopupWindowAtLocation(this, view, 0, iArr2[0] + (view.getWidth() / 2), height)) {
                bgU();
            }
        }
    }

    public void qJ(int i) {
        this.mStatusBarHeight = i;
    }

    @Override // android.widget.PopupWindow
    public void dismiss() {
        bgT();
    }

    public void bgT() {
        bgV();
    }

    /* JADX INFO: Access modifiers changed from: private */
    public void MS() {
        super.dismiss();
    }

    private void bgU() {
        TranslateAnimation translateAnimation = new TranslateAnimation(1, 0.0f, 1, 0.0f, 1, -1.0f, 1, 0.0f);
        translateAnimation.setDuration(350L);
        translateAnimation.setInterpolator(new DecelerateInterpolator());
        AlphaAnimation alphaAnimation = new AlphaAnimation(0.0f, 1.0f);
        alphaAnimation.setDuration(350L);
        alphaAnimation.setInterpolator(new LinearInterpolator());
        this.fbS.startAnimation(translateAnimation);
        this.fbQ.startAnimation(alphaAnimation);
    }

    private void bgV() {
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
        this.fbS.startAnimation(translateAnimation);
        this.fbQ.startAnimation(alphaAnimation);
    }
}
