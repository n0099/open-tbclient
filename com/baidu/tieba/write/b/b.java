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
import com.baidu.tieba.R;
import java.util.List;
/* loaded from: classes3.dex */
public class b extends PopupWindow {
    private View.OnClickListener cYk;
    private ViewGroup eWq;
    private View eWs;
    private a jIa;
    private TextView jIb;
    private TextView jIc;
    private Context mContext;
    private View mLine;
    private final View.OnClickListener mOnClickListener;
    private int mStatusBarHeight;

    /* loaded from: classes3.dex */
    public interface a {
        void mu(int i);
    }

    public b(Context context) {
        super(context);
        this.cYk = new View.OnClickListener() { // from class: com.baidu.tieba.write.b.b.1
            @Override // android.view.View.OnClickListener
            public void onClick(View view) {
                if (view == b.this.jIb) {
                    if (b.this.jIa != null) {
                        b.this.jIa.mu(1);
                    }
                } else if (view == b.this.jIc && b.this.jIa != null) {
                    b.this.jIa.mu(0);
                }
                b.this.beJ();
            }
        };
        this.mOnClickListener = new View.OnClickListener() { // from class: com.baidu.tieba.write.b.b.2
            @Override // android.view.View.OnClickListener
            public void onClick(View view) {
                b.this.beJ();
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

    private View beI() {
        createContentView();
        FrameLayout frameLayout = new FrameLayout(this.mContext);
        FrameLayout frameLayout2 = new FrameLayout(this.mContext);
        this.eWq = frameLayout2;
        frameLayout.addView(frameLayout2);
        frameLayout.addView(this.eWs);
        this.eWq.setOnClickListener(this.mOnClickListener);
        al.l(this.mLine, R.color.cp_bg_line_c);
        al.k(this.eWs, R.drawable.window_bg_profession_select);
        return frameLayout;
    }

    private void createContentView() {
        this.eWs = LayoutInflater.from(this.mContext).inflate(R.layout.layout_profession_select, (ViewGroup) null);
        this.jIb = (TextView) this.eWs.findViewById(R.id.profession_select_title_profession);
        this.mLine = this.eWs.findViewById(R.id.profession_select_line);
        this.jIc = (TextView) this.eWs.findViewById(R.id.profession_select_title_all);
        this.jIb.setOnClickListener(this.cYk);
        this.jIc.setOnClickListener(this.cYk);
    }

    public void setData(List<com.baidu.tieba.write.b.a> list, int i) {
        if (list != null) {
            View beI = beI();
            for (com.baidu.tieba.write.b.a aVar : list) {
                if (aVar.jHZ == 1) {
                    this.jIb.setText(aVar.jHY);
                } else {
                    this.jIc.setText(aVar.jHY);
                }
                if (i == 1) {
                    al.j(this.jIb, R.color.common_color_10140);
                    al.j(this.jIc, R.color.cp_cont_j);
                } else {
                    al.j(this.jIc, R.color.common_color_10140);
                    al.j(this.jIb, R.color.cp_cont_j);
                }
            }
            setContentView(beI);
        }
    }

    public void a(a aVar) {
        this.jIa = aVar;
    }

    public void bm(View view) {
        if (view != null) {
            if (Build.VERSION.SDK_INT < 24) {
                int[] iArr = new int[2];
                view.getLocationInWindow(iArr);
                if (g.showPopupWindowAsDropDown(this, view, iArr[0] - (view.getWidth() / 2), 0)) {
                    beK();
                    return;
                }
                return;
            }
            int height = this.mStatusBarHeight + view.getHeight();
            int[] iArr2 = new int[2];
            view.getLocationInWindow(iArr2);
            if (g.showPopupWindowAtLocation(this, view, 0, iArr2[0] + (view.getWidth() / 2), height)) {
                beK();
            }
        }
    }

    public void qp(int i) {
        this.mStatusBarHeight = i;
    }

    @Override // android.widget.PopupWindow
    public void dismiss() {
        beJ();
    }

    public void beJ() {
        beL();
    }

    /* JADX INFO: Access modifiers changed from: private */
    public void Me() {
        super.dismiss();
    }

    private void beK() {
        TranslateAnimation translateAnimation = new TranslateAnimation(1, 0.0f, 1, 0.0f, 1, -1.0f, 1, 0.0f);
        translateAnimation.setDuration(350L);
        translateAnimation.setInterpolator(new DecelerateInterpolator());
        AlphaAnimation alphaAnimation = new AlphaAnimation(0.0f, 1.0f);
        alphaAnimation.setDuration(350L);
        alphaAnimation.setInterpolator(new LinearInterpolator());
        this.eWs.startAnimation(translateAnimation);
        this.eWq.startAnimation(alphaAnimation);
    }

    private void beL() {
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
                b.this.Me();
            }
        });
        this.eWs.startAnimation(translateAnimation);
        this.eWq.startAnimation(alphaAnimation);
    }
}
