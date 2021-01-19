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
    private ArrowView oqC;
    private PopupWindow oqD;
    private LinearLayout oqE;
    private int oqF;
    private int oqG;
    private IndicatorSeekBar oqH;
    private View oqI;
    private View oqJ;
    private View oqK;
    private int oqv;
    private float oqw;
    private int[] jiV = new int[2];
    private final int mWindowWidth = dZC();

    public c(Context context, IndicatorSeekBar indicatorSeekBar, int i, int i2, int i3, int i4, View view, View view2) {
        this.mContext = context;
        this.oqH = indicatorSeekBar;
        this.mIndicatorColor = i;
        this.oqG = i2;
        this.oqJ = view;
        this.oqK = view2;
        this.oqw = i3;
        this.oqv = i4;
        this.oqF = f.dp2px(this.mContext, 2.0f);
        dZA();
    }

    private void dZA() {
        View findViewById;
        if (this.oqG == 4) {
            if (this.oqJ != null) {
                this.oqI = this.oqJ;
                int identifier = this.mContext.getResources().getIdentifier("isb_progress", "id", this.mContext.getApplicationContext().getPackageName());
                if (identifier > 0 && (findViewById = this.oqI.findViewById(identifier)) != null) {
                    if (findViewById instanceof TextView) {
                        this.hzc = (TextView) findViewById;
                        this.hzc.setText(this.oqH.getIndicatorTextString());
                        this.hzc.setTextSize(f.px2sp(this.mContext, this.oqw));
                        this.hzc.setTextColor(this.oqv);
                        return;
                    }
                    throw new ClassCastException("the view identified by isb_progress in indicator custom layout can not be cast to TextView");
                }
                return;
            }
            throw new IllegalArgumentException("the attr：indicator_custom_layout must be set while you set the indicator type to CUSTOM.");
        } else if (this.oqG == 1) {
            this.oqI = new CircleBubbleView(this.mContext, this.oqw, this.oqv, this.mIndicatorColor, "1000");
            ((CircleBubbleView) this.oqI).setProgress(this.oqH.getIndicatorTextString());
        } else {
            this.oqI = View.inflate(this.mContext, a.g.isb_indicator, null);
            this.oqE = (LinearLayout) this.oqI.findViewById(a.f.indicator_container);
            this.oqC = (ArrowView) this.oqI.findViewById(a.f.indicator_arrow);
            this.oqC.setColor(this.mIndicatorColor);
            this.hzc = (TextView) this.oqI.findViewById(a.f.isb_progress);
            this.hzc.setText(this.oqH.getIndicatorTextString());
            this.hzc.setTextSize(f.px2sp(this.mContext, this.oqw));
            this.hzc.setTextColor(this.oqv);
            if (Build.VERSION.SDK_INT >= 16) {
                this.oqE.setBackground(dZB());
            } else {
                this.oqE.setBackgroundDrawable(dZB());
            }
            if (this.oqK != null) {
                int identifier2 = this.mContext.getResources().getIdentifier("isb_progress", "id", this.mContext.getApplicationContext().getPackageName());
                View view = this.oqK;
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
        if (this.oqG == 2) {
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
        this.oqH.getLocationOnScreen(this.jiV);
        return this.jiV[0];
    }

    private void be(float f) {
        if (this.oqG != 4 && this.oqG != 1) {
            int dZD = dZD();
            if (dZD + f < this.oqD.getContentView().getMeasuredWidth() / 2) {
                i(this.oqC, -((int) (((this.oqD.getContentView().getMeasuredWidth() / 2) - dZD) - f)), -1, -1, -1);
            } else if ((this.mWindowWidth - dZD) - f < this.oqD.getContentView().getMeasuredWidth() / 2) {
                i(this.oqC, (int) ((this.oqD.getContentView().getMeasuredWidth() / 2) - ((this.mWindowWidth - dZD) - f)), -1, -1, -1);
            } else {
                i(this.oqC, 0, 0, 0, 0);
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
        if (this.oqD == null && this.oqG != 0 && this.oqI != null) {
            this.oqI.measure(0, 0);
            this.oqD = new PopupWindow(this.oqI, -2, -2, false);
        }
    }

    /* JADX INFO: Access modifiers changed from: package-private */
    public View dZF() {
        return this.oqI;
    }

    /* JADX INFO: Access modifiers changed from: package-private */
    public void US(String str) {
        if (this.oqI instanceof CircleBubbleView) {
            ((CircleBubbleView) this.oqI).setProgress(str);
        } else if (this.hzc != null) {
            this.hzc.setText(str);
        }
    }

    /* JADX INFO: Access modifiers changed from: package-private */
    public void LN(int i) {
        i(this.oqI, i, -1, -1, -1);
    }

    /* JADX INFO: Access modifiers changed from: package-private */
    public void LO(int i) {
        i(this.oqC, i, -1, -1, -1);
    }

    /* JADX INFO: Access modifiers changed from: package-private */
    public void bf(float f) {
        if (this.oqH.isEnabled() && this.oqH.getVisibility() == 0) {
            dZG();
            if (this.oqD != null) {
                this.oqD.getContentView().measure(0, 0);
                this.oqD.update(this.oqH, (int) (f - (this.oqD.getContentView().getMeasuredWidth() / 2)), -(((this.oqH.getMeasuredHeight() + this.oqD.getContentView().getMeasuredHeight()) - this.oqH.getPaddingTop()) + this.oqF), -1, -1);
                be(f);
            }
        }
    }

    /* JADX INFO: Access modifiers changed from: package-private */
    public void bg(float f) {
        if (this.oqH.isEnabled() && this.oqH.getVisibility() == 0) {
            dZG();
            if (this.oqD != null) {
                this.oqD.getContentView().measure(0, 0);
                this.oqD.showAsDropDown(this.oqH, (int) (f - (this.oqD.getContentView().getMeasuredWidth() / 2.0f)), -(((this.oqH.getMeasuredHeight() + this.oqD.getContentView().getMeasuredHeight()) - this.oqH.getPaddingTop()) + this.oqF));
                be(f);
            }
        }
    }

    /* JADX INFO: Access modifiers changed from: package-private */
    public void dZG() {
        String indicatorTextString = this.oqH.getIndicatorTextString();
        if (this.oqI instanceof CircleBubbleView) {
            ((CircleBubbleView) this.oqI).setProgress(indicatorTextString);
        } else if (this.hzc != null) {
            this.hzc.setText(indicatorTextString);
        }
    }

    /* JADX INFO: Access modifiers changed from: package-private */
    public void hide() {
        if (this.oqD != null) {
            this.oqD.dismiss();
        }
    }

    /* JADX INFO: Access modifiers changed from: package-private */
    public boolean isShowing() {
        return this.oqD != null && this.oqD.isShowing();
    }

    public void eu(@NonNull View view) {
        a(view, null);
    }

    public void a(@NonNull View view, @Nullable TextView textView) {
        this.hzc = textView;
        this.oqE.removeAllViews();
        if (Build.VERSION.SDK_INT >= 16) {
            view.setBackground(dZB());
        } else {
            view.setBackgroundDrawable(dZB());
        }
        this.oqE.addView(view);
    }
}
