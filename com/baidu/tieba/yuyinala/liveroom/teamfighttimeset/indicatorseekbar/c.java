package com.baidu.tieba.yuyinala.liveroom.teamfighttimeset.indicatorseekbar;

import android.content.Context;
import android.graphics.drawable.GradientDrawable;
import android.os.Build;
import android.view.View;
import android.view.ViewGroup;
import android.view.WindowManager;
import android.widget.LinearLayout;
import android.widget.PopupWindow;
import android.widget.TextView;
import androidx.annotation.NonNull;
import androidx.annotation.Nullable;
import com.baidu.live.sdk.a;
/* loaded from: classes10.dex */
public class c {
    private TextView hzc;
    private Context mContext;
    private int mIndicatorColor;
    private ArrowView oqB;
    private PopupWindow oqC;
    private LinearLayout oqD;
    private int oqE;
    private int oqF;
    private IndicatorSeekBar oqG;
    private View oqH;
    private View oqI;
    private View oqJ;
    private int oqu;
    private float oqv;
    private int[] jiV = new int[2];
    private final int mWindowWidth = dZC();

    public c(Context context, IndicatorSeekBar indicatorSeekBar, int i, int i2, int i3, int i4, View view, View view2) {
        this.mContext = context;
        this.oqG = indicatorSeekBar;
        this.mIndicatorColor = i;
        this.oqF = i2;
        this.oqI = view;
        this.oqJ = view2;
        this.oqv = i3;
        this.oqu = i4;
        this.oqE = f.dp2px(this.mContext, 2.0f);
        dZA();
    }

    private void dZA() {
        View findViewById;
        if (this.oqF == 4) {
            if (this.oqI != null) {
                this.oqH = this.oqI;
                int identifier = this.mContext.getResources().getIdentifier("isb_progress", "id", this.mContext.getApplicationContext().getPackageName());
                if (identifier > 0 && (findViewById = this.oqH.findViewById(identifier)) != null) {
                    if (findViewById instanceof TextView) {
                        this.hzc = (TextView) findViewById;
                        this.hzc.setText(this.oqG.getIndicatorTextString());
                        this.hzc.setTextSize(f.px2sp(this.mContext, this.oqv));
                        this.hzc.setTextColor(this.oqu);
                        return;
                    }
                    throw new ClassCastException("the view identified by isb_progress in indicator custom layout can not be cast to TextView");
                }
                return;
            }
            throw new IllegalArgumentException("the attr：indicator_custom_layout must be set while you set the indicator type to CUSTOM.");
        } else if (this.oqF == 1) {
            this.oqH = new CircleBubbleView(this.mContext, this.oqv, this.oqu, this.mIndicatorColor, "1000");
            ((CircleBubbleView) this.oqH).setProgress(this.oqG.getIndicatorTextString());
        } else {
            this.oqH = View.inflate(this.mContext, a.g.isb_indicator, null);
            this.oqD = (LinearLayout) this.oqH.findViewById(a.f.indicator_container);
            this.oqB = (ArrowView) this.oqH.findViewById(a.f.indicator_arrow);
            this.oqB.setColor(this.mIndicatorColor);
            this.hzc = (TextView) this.oqH.findViewById(a.f.isb_progress);
            this.hzc.setText(this.oqG.getIndicatorTextString());
            this.hzc.setTextSize(f.px2sp(this.mContext, this.oqv));
            this.hzc.setTextColor(this.oqu);
            if (Build.VERSION.SDK_INT >= 16) {
                this.oqD.setBackground(dZB());
            } else {
                this.oqD.setBackgroundDrawable(dZB());
            }
            if (this.oqJ != null) {
                int identifier2 = this.mContext.getResources().getIdentifier("isb_progress", "id", this.mContext.getApplicationContext().getPackageName());
                View view = this.oqJ;
                if (identifier2 > 0) {
                    View findViewById2 = view.findViewById(identifier2);
                    if (findViewById2 != null && (findViewById2 instanceof TextView)) {
                        a(view, (TextView) findViewById2);
                        return;
                    } else {
                        eu(view);
                        return;
                    }
                }
                eu(view);
            }
        }
    }

    @NonNull
    private GradientDrawable dZB() {
        GradientDrawable gradientDrawable;
        if (this.oqF == 2) {
            gradientDrawable = (GradientDrawable) this.mContext.getResources().getDrawable(a.e.isb_indicator_rounded_corners);
        } else {
            gradientDrawable = (GradientDrawable) this.mContext.getResources().getDrawable(a.e.isb_indicator_square_corners);
        }
        gradientDrawable.setColor(this.mIndicatorColor);
        return gradientDrawable;
    }

    private int dZC() {
        WindowManager windowManager = (WindowManager) this.mContext.getSystemService("window");
        if (windowManager != null) {
            return windowManager.getDefaultDisplay().getWidth();
        }
        return 0;
    }

    private int dZD() {
        this.oqG.getLocationOnScreen(this.jiV);
        return this.jiV[0];
    }

    private void be(float f) {
        if (this.oqF != 4 && this.oqF != 1) {
            int dZD = dZD();
            if (dZD + f < this.oqC.getContentView().getMeasuredWidth() / 2) {
                i(this.oqB, -((int) (((this.oqC.getContentView().getMeasuredWidth() / 2) - dZD) - f)), -1, -1, -1);
            } else if ((this.mWindowWidth - dZD) - f < this.oqC.getContentView().getMeasuredWidth() / 2) {
                i(this.oqB, (int) ((this.oqC.getContentView().getMeasuredWidth() / 2) - ((this.mWindowWidth - dZD) - f)), -1, -1, -1);
            } else {
                i(this.oqB, 0, 0, 0, 0);
            }
        }
    }

    private void i(View view, int i, int i2, int i3, int i4) {
        if (view != null && (view.getLayoutParams() instanceof ViewGroup.MarginLayoutParams)) {
            ViewGroup.MarginLayoutParams marginLayoutParams = (ViewGroup.MarginLayoutParams) view.getLayoutParams();
            if (i == -1) {
                i = marginLayoutParams.leftMargin;
            }
            if (i2 == -1) {
                i2 = marginLayoutParams.topMargin;
            }
            if (i3 == -1) {
                i3 = marginLayoutParams.rightMargin;
            }
            if (i4 == -1) {
                i4 = marginLayoutParams.bottomMargin;
            }
            marginLayoutParams.setMargins(i, i2, i3, i4);
            view.requestLayout();
        }
    }

    /* JADX INFO: Access modifiers changed from: package-private */
    public void dZE() {
        if (this.oqC == null && this.oqF != 0 && this.oqH != null) {
            this.oqH.measure(0, 0);
            this.oqC = new PopupWindow(this.oqH, -2, -2, false);
        }
    }

    /* JADX INFO: Access modifiers changed from: package-private */
    public View dZF() {
        return this.oqH;
    }

    /* JADX INFO: Access modifiers changed from: package-private */
    public void UR(String str) {
        if (this.oqH instanceof CircleBubbleView) {
            ((CircleBubbleView) this.oqH).setProgress(str);
        } else if (this.hzc != null) {
            this.hzc.setText(str);
        }
    }

    /* JADX INFO: Access modifiers changed from: package-private */
    public void LN(int i) {
        i(this.oqH, i, -1, -1, -1);
    }

    /* JADX INFO: Access modifiers changed from: package-private */
    public void LO(int i) {
        i(this.oqB, i, -1, -1, -1);
    }

    /* JADX INFO: Access modifiers changed from: package-private */
    public void bf(float f) {
        if (this.oqG.isEnabled() && this.oqG.getVisibility() == 0) {
            dZG();
            if (this.oqC != null) {
                this.oqC.getContentView().measure(0, 0);
                this.oqC.update(this.oqG, (int) (f - (this.oqC.getContentView().getMeasuredWidth() / 2)), -(((this.oqG.getMeasuredHeight() + this.oqC.getContentView().getMeasuredHeight()) - this.oqG.getPaddingTop()) + this.oqE), -1, -1);
                be(f);
            }
        }
    }

    /* JADX INFO: Access modifiers changed from: package-private */
    public void bg(float f) {
        if (this.oqG.isEnabled() && this.oqG.getVisibility() == 0) {
            dZG();
            if (this.oqC != null) {
                this.oqC.getContentView().measure(0, 0);
                this.oqC.showAsDropDown(this.oqG, (int) (f - (this.oqC.getContentView().getMeasuredWidth() / 2.0f)), -(((this.oqG.getMeasuredHeight() + this.oqC.getContentView().getMeasuredHeight()) - this.oqG.getPaddingTop()) + this.oqE));
                be(f);
            }
        }
    }

    /* JADX INFO: Access modifiers changed from: package-private */
    public void dZG() {
        String indicatorTextString = this.oqG.getIndicatorTextString();
        if (this.oqH instanceof CircleBubbleView) {
            ((CircleBubbleView) this.oqH).setProgress(indicatorTextString);
        } else if (this.hzc != null) {
            this.hzc.setText(indicatorTextString);
        }
    }

    /* JADX INFO: Access modifiers changed from: package-private */
    public void hide() {
        if (this.oqC != null) {
            this.oqC.dismiss();
        }
    }

    /* JADX INFO: Access modifiers changed from: package-private */
    public boolean isShowing() {
        return this.oqC != null && this.oqC.isShowing();
    }

    public void eu(@NonNull View view) {
        a(view, null);
    }

    public void a(@NonNull View view, @Nullable TextView textView) {
        this.hzc = textView;
        this.oqD.removeAllViews();
        if (Build.VERSION.SDK_INT >= 16) {
            view.setBackground(dZB());
        } else {
            view.setBackgroundDrawable(dZB());
        }
        this.oqD.addView(view);
    }
}
