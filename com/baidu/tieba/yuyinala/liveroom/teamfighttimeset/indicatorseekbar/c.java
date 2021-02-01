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
/* loaded from: classes11.dex */
public class c {
    private TextView hDn;
    private Context mContext;
    private int mIndicatorColor;
    private View oAA;
    private int oAl;
    private float oAm;
    private ArrowView oAs;
    private PopupWindow oAt;
    private LinearLayout oAu;
    private int oAv;
    private int oAw;
    private IndicatorSeekBar oAx;
    private View oAy;
    private View oAz;
    private int[] joC = new int[2];
    private final int mWindowWidth = ebP();

    public c(Context context, IndicatorSeekBar indicatorSeekBar, int i, int i2, int i3, int i4, View view, View view2) {
        this.mContext = context;
        this.oAx = indicatorSeekBar;
        this.mIndicatorColor = i;
        this.oAw = i2;
        this.oAz = view;
        this.oAA = view2;
        this.oAm = i3;
        this.oAl = i4;
        this.oAv = f.dp2px(this.mContext, 2.0f);
        ebN();
    }

    private void ebN() {
        View findViewById;
        if (this.oAw == 4) {
            if (this.oAz != null) {
                this.oAy = this.oAz;
                int identifier = this.mContext.getResources().getIdentifier("isb_progress", "id", this.mContext.getApplicationContext().getPackageName());
                if (identifier > 0 && (findViewById = this.oAy.findViewById(identifier)) != null) {
                    if (findViewById instanceof TextView) {
                        this.hDn = (TextView) findViewById;
                        this.hDn.setText(this.oAx.getIndicatorTextString());
                        this.hDn.setTextSize(f.px2sp(this.mContext, this.oAm));
                        this.hDn.setTextColor(this.oAl);
                        return;
                    }
                    throw new ClassCastException("the view identified by isb_progress in indicator custom layout can not be cast to TextView");
                }
                return;
            }
            throw new IllegalArgumentException("the attr：indicator_custom_layout must be set while you set the indicator type to CUSTOM.");
        } else if (this.oAw == 1) {
            this.oAy = new CircleBubbleView(this.mContext, this.oAm, this.oAl, this.mIndicatorColor, "1000");
            ((CircleBubbleView) this.oAy).setProgress(this.oAx.getIndicatorTextString());
        } else {
            this.oAy = View.inflate(this.mContext, a.g.isb_indicator, null);
            this.oAu = (LinearLayout) this.oAy.findViewById(a.f.indicator_container);
            this.oAs = (ArrowView) this.oAy.findViewById(a.f.indicator_arrow);
            this.oAs.setColor(this.mIndicatorColor);
            this.hDn = (TextView) this.oAy.findViewById(a.f.isb_progress);
            this.hDn.setText(this.oAx.getIndicatorTextString());
            this.hDn.setTextSize(f.px2sp(this.mContext, this.oAm));
            this.hDn.setTextColor(this.oAl);
            if (Build.VERSION.SDK_INT >= 16) {
                this.oAu.setBackground(ebO());
            } else {
                this.oAu.setBackgroundDrawable(ebO());
            }
            if (this.oAA != null) {
                int identifier2 = this.mContext.getResources().getIdentifier("isb_progress", "id", this.mContext.getApplicationContext().getPackageName());
                View view = this.oAA;
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
    private GradientDrawable ebO() {
        GradientDrawable gradientDrawable;
        if (this.oAw == 2) {
            gradientDrawable = (GradientDrawable) this.mContext.getResources().getDrawable(a.e.isb_indicator_rounded_corners);
        } else {
            gradientDrawable = (GradientDrawable) this.mContext.getResources().getDrawable(a.e.isb_indicator_square_corners);
        }
        gradientDrawable.setColor(this.mIndicatorColor);
        return gradientDrawable;
    }

    private int ebP() {
        WindowManager windowManager = (WindowManager) this.mContext.getSystemService("window");
        if (windowManager != null) {
            return windowManager.getDefaultDisplay().getWidth();
        }
        return 0;
    }

    private int ebQ() {
        this.oAx.getLocationOnScreen(this.joC);
        return this.joC[0];
    }

    private void bh(float f) {
        if (this.oAw != 4 && this.oAw != 1) {
            int ebQ = ebQ();
            if (ebQ + f < this.oAt.getContentView().getMeasuredWidth() / 2) {
                i(this.oAs, -((int) (((this.oAt.getContentView().getMeasuredWidth() / 2) - ebQ) - f)), -1, -1, -1);
            } else if ((this.mWindowWidth - ebQ) - f < this.oAt.getContentView().getMeasuredWidth() / 2) {
                i(this.oAs, (int) ((this.oAt.getContentView().getMeasuredWidth() / 2) - ((this.mWindowWidth - ebQ) - f)), -1, -1, -1);
            } else {
                i(this.oAs, 0, 0, 0, 0);
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
    public void ebR() {
        if (this.oAt == null && this.oAw != 0 && this.oAy != null) {
            this.oAy.measure(0, 0);
            this.oAt = new PopupWindow(this.oAy, -2, -2, false);
        }
    }

    /* JADX INFO: Access modifiers changed from: package-private */
    public View ebS() {
        return this.oAy;
    }

    /* JADX INFO: Access modifiers changed from: package-private */
    public void VQ(String str) {
        if (this.oAy instanceof CircleBubbleView) {
            ((CircleBubbleView) this.oAy).setProgress(str);
        } else if (this.hDn != null) {
            this.hDn.setText(str);
        }
    }

    /* JADX INFO: Access modifiers changed from: package-private */
    public void Mi(int i) {
        i(this.oAy, i, -1, -1, -1);
    }

    /* JADX INFO: Access modifiers changed from: package-private */
    public void Mj(int i) {
        i(this.oAs, i, -1, -1, -1);
    }

    /* JADX INFO: Access modifiers changed from: package-private */
    public void bi(float f) {
        if (this.oAx.isEnabled() && this.oAx.getVisibility() == 0) {
            ebT();
            if (this.oAt != null) {
                this.oAt.getContentView().measure(0, 0);
                this.oAt.update(this.oAx, (int) (f - (this.oAt.getContentView().getMeasuredWidth() / 2)), -(((this.oAx.getMeasuredHeight() + this.oAt.getContentView().getMeasuredHeight()) - this.oAx.getPaddingTop()) + this.oAv), -1, -1);
                bh(f);
            }
        }
    }

    /* JADX INFO: Access modifiers changed from: package-private */
    public void bj(float f) {
        if (this.oAx.isEnabled() && this.oAx.getVisibility() == 0) {
            ebT();
            if (this.oAt != null) {
                this.oAt.getContentView().measure(0, 0);
                this.oAt.showAsDropDown(this.oAx, (int) (f - (this.oAt.getContentView().getMeasuredWidth() / 2.0f)), -(((this.oAx.getMeasuredHeight() + this.oAt.getContentView().getMeasuredHeight()) - this.oAx.getPaddingTop()) + this.oAv));
                bh(f);
            }
        }
    }

    /* JADX INFO: Access modifiers changed from: package-private */
    public void ebT() {
        String indicatorTextString = this.oAx.getIndicatorTextString();
        if (this.oAy instanceof CircleBubbleView) {
            ((CircleBubbleView) this.oAy).setProgress(indicatorTextString);
        } else if (this.hDn != null) {
            this.hDn.setText(indicatorTextString);
        }
    }

    /* JADX INFO: Access modifiers changed from: package-private */
    public void hide() {
        if (this.oAt != null) {
            this.oAt.dismiss();
        }
    }

    /* JADX INFO: Access modifiers changed from: package-private */
    public boolean isShowing() {
        return this.oAt != null && this.oAt.isShowing();
    }

    public void es(@NonNull View view) {
        a(view, null);
    }

    public void a(@NonNull View view, @Nullable TextView textView) {
        this.hDn = textView;
        this.oAu.removeAllViews();
        if (Build.VERSION.SDK_INT >= 16) {
            view.setBackground(ebO());
        } else {
            view.setBackgroundDrawable(ebO());
        }
        this.oAu.addView(view);
    }
}
