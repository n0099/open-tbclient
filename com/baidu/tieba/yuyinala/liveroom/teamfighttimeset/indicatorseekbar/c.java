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
    private TextView hFk;
    private Context mContext;
    private int mIndicatorColor;
    private int oCQ;
    private float oCR;
    private ArrowView oCX;
    private PopupWindow oCY;
    private LinearLayout oCZ;
    private int oDa;
    private int oDb;
    private IndicatorSeekBar oDc;
    private View oDd;
    private View oDe;
    private View oDf;
    private int[] jqz = new int[2];
    private final int mWindowWidth = ecf();

    public c(Context context, IndicatorSeekBar indicatorSeekBar, int i, int i2, int i3, int i4, View view, View view2) {
        this.mContext = context;
        this.oDc = indicatorSeekBar;
        this.mIndicatorColor = i;
        this.oDb = i2;
        this.oDe = view;
        this.oDf = view2;
        this.oCR = i3;
        this.oCQ = i4;
        this.oDa = f.dp2px(this.mContext, 2.0f);
        ecd();
    }

    private void ecd() {
        View findViewById;
        if (this.oDb == 4) {
            if (this.oDe != null) {
                this.oDd = this.oDe;
                int identifier = this.mContext.getResources().getIdentifier("isb_progress", "id", this.mContext.getApplicationContext().getPackageName());
                if (identifier > 0 && (findViewById = this.oDd.findViewById(identifier)) != null) {
                    if (findViewById instanceof TextView) {
                        this.hFk = (TextView) findViewById;
                        this.hFk.setText(this.oDc.getIndicatorTextString());
                        this.hFk.setTextSize(f.px2sp(this.mContext, this.oCR));
                        this.hFk.setTextColor(this.oCQ);
                        return;
                    }
                    throw new ClassCastException("the view identified by isb_progress in indicator custom layout can not be cast to TextView");
                }
                return;
            }
            throw new IllegalArgumentException("the attr：indicator_custom_layout must be set while you set the indicator type to CUSTOM.");
        } else if (this.oDb == 1) {
            this.oDd = new CircleBubbleView(this.mContext, this.oCR, this.oCQ, this.mIndicatorColor, "1000");
            ((CircleBubbleView) this.oDd).setProgress(this.oDc.getIndicatorTextString());
        } else {
            this.oDd = View.inflate(this.mContext, a.g.isb_indicator, null);
            this.oCZ = (LinearLayout) this.oDd.findViewById(a.f.indicator_container);
            this.oCX = (ArrowView) this.oDd.findViewById(a.f.indicator_arrow);
            this.oCX.setColor(this.mIndicatorColor);
            this.hFk = (TextView) this.oDd.findViewById(a.f.isb_progress);
            this.hFk.setText(this.oDc.getIndicatorTextString());
            this.hFk.setTextSize(f.px2sp(this.mContext, this.oCR));
            this.hFk.setTextColor(this.oCQ);
            if (Build.VERSION.SDK_INT >= 16) {
                this.oCZ.setBackground(ece());
            } else {
                this.oCZ.setBackgroundDrawable(ece());
            }
            if (this.oDf != null) {
                int identifier2 = this.mContext.getResources().getIdentifier("isb_progress", "id", this.mContext.getApplicationContext().getPackageName());
                View view = this.oDf;
                if (identifier2 > 0) {
                    View findViewById2 = view.findViewById(identifier2);
                    if (findViewById2 != null && (findViewById2 instanceof TextView)) {
                        a(view, (TextView) findViewById2);
                        return;
                    } else {
                        es(view);
                        return;
                    }
                }
                es(view);
            }
        }
    }

    @NonNull
    private GradientDrawable ece() {
        GradientDrawable gradientDrawable;
        if (this.oDb == 2) {
            gradientDrawable = (GradientDrawable) this.mContext.getResources().getDrawable(a.e.isb_indicator_rounded_corners);
        } else {
            gradientDrawable = (GradientDrawable) this.mContext.getResources().getDrawable(a.e.isb_indicator_square_corners);
        }
        gradientDrawable.setColor(this.mIndicatorColor);
        return gradientDrawable;
    }

    private int ecf() {
        WindowManager windowManager = (WindowManager) this.mContext.getSystemService("window");
        if (windowManager != null) {
            return windowManager.getDefaultDisplay().getWidth();
        }
        return 0;
    }

    private int ecg() {
        this.oDc.getLocationOnScreen(this.jqz);
        return this.jqz[0];
    }

    private void bl(float f) {
        if (this.oDb != 4 && this.oDb != 1) {
            int ecg = ecg();
            if (ecg + f < this.oCY.getContentView().getMeasuredWidth() / 2) {
                i(this.oCX, -((int) (((this.oCY.getContentView().getMeasuredWidth() / 2) - ecg) - f)), -1, -1, -1);
            } else if ((this.mWindowWidth - ecg) - f < this.oCY.getContentView().getMeasuredWidth() / 2) {
                i(this.oCX, (int) ((this.oCY.getContentView().getMeasuredWidth() / 2) - ((this.mWindowWidth - ecg) - f)), -1, -1, -1);
            } else {
                i(this.oCX, 0, 0, 0, 0);
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
    public void ech() {
        if (this.oCY == null && this.oDb != 0 && this.oDd != null) {
            this.oDd.measure(0, 0);
            this.oCY = new PopupWindow(this.oDd, -2, -2, false);
        }
    }

    /* JADX INFO: Access modifiers changed from: package-private */
    public View eci() {
        return this.oDd;
    }

    /* JADX INFO: Access modifiers changed from: package-private */
    public void Wj(String str) {
        if (this.oDd instanceof CircleBubbleView) {
            ((CircleBubbleView) this.oDd).setProgress(str);
        } else if (this.hFk != null) {
            this.hFk.setText(str);
        }
    }

    /* JADX INFO: Access modifiers changed from: package-private */
    public void Mn(int i) {
        i(this.oDd, i, -1, -1, -1);
    }

    /* JADX INFO: Access modifiers changed from: package-private */
    public void Mo(int i) {
        i(this.oCX, i, -1, -1, -1);
    }

    /* JADX INFO: Access modifiers changed from: package-private */
    public void bm(float f) {
        if (this.oDc.isEnabled() && this.oDc.getVisibility() == 0) {
            ecj();
            if (this.oCY != null) {
                this.oCY.getContentView().measure(0, 0);
                this.oCY.update(this.oDc, (int) (f - (this.oCY.getContentView().getMeasuredWidth() / 2)), -(((this.oDc.getMeasuredHeight() + this.oCY.getContentView().getMeasuredHeight()) - this.oDc.getPaddingTop()) + this.oDa), -1, -1);
                bl(f);
            }
        }
    }

    /* JADX INFO: Access modifiers changed from: package-private */
    public void bn(float f) {
        if (this.oDc.isEnabled() && this.oDc.getVisibility() == 0) {
            ecj();
            if (this.oCY != null) {
                this.oCY.getContentView().measure(0, 0);
                this.oCY.showAsDropDown(this.oDc, (int) (f - (this.oCY.getContentView().getMeasuredWidth() / 2.0f)), -(((this.oDc.getMeasuredHeight() + this.oCY.getContentView().getMeasuredHeight()) - this.oDc.getPaddingTop()) + this.oDa));
                bl(f);
            }
        }
    }

    /* JADX INFO: Access modifiers changed from: package-private */
    public void ecj() {
        String indicatorTextString = this.oDc.getIndicatorTextString();
        if (this.oDd instanceof CircleBubbleView) {
            ((CircleBubbleView) this.oDd).setProgress(indicatorTextString);
        } else if (this.hFk != null) {
            this.hFk.setText(indicatorTextString);
        }
    }

    /* JADX INFO: Access modifiers changed from: package-private */
    public void hide() {
        if (this.oCY != null) {
            this.oCY.dismiss();
        }
    }

    /* JADX INFO: Access modifiers changed from: package-private */
    public boolean isShowing() {
        return this.oCY != null && this.oCY.isShowing();
    }

    public void es(@NonNull View view) {
        a(view, null);
    }

    public void a(@NonNull View view, @Nullable TextView textView) {
        this.hFk = textView;
        this.oCZ.removeAllViews();
        if (Build.VERSION.SDK_INT >= 16) {
            view.setBackground(ece());
        } else {
            view.setBackgroundDrawable(ece());
        }
        this.oCZ.addView(view);
    }
}
