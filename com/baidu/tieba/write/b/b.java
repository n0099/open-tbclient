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
    private View.OnClickListener dbz;
    private ViewGroup fdr;
    private View fdt;
    private a jSF;
    private TextView jSG;
    private TextView jSH;
    private Context mContext;
    private View mLine;
    private final View.OnClickListener mOnClickListener;
    private int mStatusBarHeight;

    /* loaded from: classes3.dex */
    public interface a {
        void mG(int i);
    }

    public b(Context context) {
        super(context);
        this.dbz = new View.OnClickListener() { // from class: com.baidu.tieba.write.b.b.1
            @Override // android.view.View.OnClickListener
            public void onClick(View view) {
                if (view == b.this.jSG) {
                    if (b.this.jSF != null) {
                        b.this.jSF.mG(1);
                    }
                } else if (view == b.this.jSH && b.this.jSF != null) {
                    b.this.jSF.mG(0);
                }
                b.this.bhx();
            }
        };
        this.mOnClickListener = new View.OnClickListener() { // from class: com.baidu.tieba.write.b.b.2
            @Override // android.view.View.OnClickListener
            public void onClick(View view) {
                b.this.bhx();
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

    private View bhw() {
        createContentView();
        FrameLayout frameLayout = new FrameLayout(this.mContext);
        FrameLayout frameLayout2 = new FrameLayout(this.mContext);
        this.fdr = frameLayout2;
        frameLayout.addView(frameLayout2);
        frameLayout.addView(this.fdt);
        this.fdr.setOnClickListener(this.mOnClickListener);
        am.l(this.mLine, R.color.cp_bg_line_c);
        am.k(this.fdt, R.drawable.window_bg_profession_select);
        return frameLayout;
    }

    private void createContentView() {
        this.fdt = LayoutInflater.from(this.mContext).inflate(R.layout.layout_profession_select, (ViewGroup) null);
        this.jSG = (TextView) this.fdt.findViewById(R.id.profession_select_title_profession);
        this.mLine = this.fdt.findViewById(R.id.profession_select_line);
        this.jSH = (TextView) this.fdt.findViewById(R.id.profession_select_title_all);
        this.jSG.setOnClickListener(this.dbz);
        this.jSH.setOnClickListener(this.dbz);
    }

    public void setData(List<com.baidu.tieba.write.b.a> list, int i) {
        if (list != null) {
            View bhw = bhw();
            for (com.baidu.tieba.write.b.a aVar : list) {
                if (aVar.jSE == 1) {
                    this.jSG.setText(aVar.jSD);
                } else {
                    this.jSH.setText(aVar.jSD);
                }
                if (i == 1) {
                    am.j(this.jSG, R.color.common_color_10140);
                    am.j(this.jSH, R.color.cp_cont_j);
                } else {
                    am.j(this.jSH, R.color.common_color_10140);
                    am.j(this.jSG, R.color.cp_cont_j);
                }
            }
            setContentView(bhw);
        }
    }

    public void a(a aVar) {
        this.jSF = aVar;
    }

    public void bo(View view) {
        if (view != null) {
            if (Build.VERSION.SDK_INT < 24) {
                int[] iArr = new int[2];
                view.getLocationInWindow(iArr);
                if (g.showPopupWindowAsDropDown(this, view, iArr[0] - (view.getWidth() / 2), 0)) {
                    bhy();
                    return;
                }
                return;
            }
            int height = this.mStatusBarHeight + view.getHeight();
            int[] iArr2 = new int[2];
            view.getLocationInWindow(iArr2);
            if (g.showPopupWindowAtLocation(this, view, 0, iArr2[0] + (view.getWidth() / 2), height)) {
                bhy();
            }
        }
    }

    public void qM(int i) {
        this.mStatusBarHeight = i;
    }

    @Override // android.widget.PopupWindow
    public void dismiss() {
        bhx();
    }

    public void bhx() {
        bhz();
    }

    /* JADX INFO: Access modifiers changed from: private */
    public void MW() {
        super.dismiss();
    }

    private void bhy() {
        TranslateAnimation translateAnimation = new TranslateAnimation(1, 0.0f, 1, 0.0f, 1, -1.0f, 1, 0.0f);
        translateAnimation.setDuration(350L);
        translateAnimation.setInterpolator(new DecelerateInterpolator());
        AlphaAnimation alphaAnimation = new AlphaAnimation(0.0f, 1.0f);
        alphaAnimation.setDuration(350L);
        alphaAnimation.setInterpolator(new LinearInterpolator());
        this.fdt.startAnimation(translateAnimation);
        this.fdr.startAnimation(alphaAnimation);
    }

    private void bhz() {
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
                b.this.MW();
            }
        });
        this.fdt.startAnimation(translateAnimation);
        this.fdr.startAnimation(alphaAnimation);
    }
}
