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
    private TextView hDB;
    private Context mContext;
    private int mIndicatorColor;
    private int oAL;
    private float oAM;
    private ArrowView oAS;
    private PopupWindow oAT;
    private LinearLayout oAU;
    private int oAV;
    private int oAW;
    private IndicatorSeekBar oAX;
    private View oAY;
    private View oAZ;
    private View oBa;
    private int[] joQ = new int[2];
    private final int mWindowWidth = ebX();

    public c(Context context, IndicatorSeekBar indicatorSeekBar, int i, int i2, int i3, int i4, View view, View view2) {
        this.mContext = context;
        this.oAX = indicatorSeekBar;
        this.mIndicatorColor = i;
        this.oAW = i2;
        this.oAZ = view;
        this.oBa = view2;
        this.oAM = i3;
        this.oAL = i4;
        this.oAV = f.dp2px(this.mContext, 2.0f);
        ebV();
    }

    private void ebV() {
        View findViewById;
        if (this.oAW == 4) {
            if (this.oAZ != null) {
                this.oAY = this.oAZ;
                int identifier = this.mContext.getResources().getIdentifier("isb_progress", "id", this.mContext.getApplicationContext().getPackageName());
                if (identifier > 0 && (findViewById = this.oAY.findViewById(identifier)) != null) {
                    if (findViewById instanceof TextView) {
                        this.hDB = (TextView) findViewById;
                        this.hDB.setText(this.oAX.getIndicatorTextString());
                        this.hDB.setTextSize(f.px2sp(this.mContext, this.oAM));
                        this.hDB.setTextColor(this.oAL);
                        return;
                    }
                    throw new ClassCastException("the view identified by isb_progress in indicator custom layout can not be cast to TextView");
                }
                return;
            }
            throw new IllegalArgumentException("the attr：indicator_custom_layout must be set while you set the indicator type to CUSTOM.");
        } else if (this.oAW == 1) {
            this.oAY = new CircleBubbleView(this.mContext, this.oAM, this.oAL, this.mIndicatorColor, "1000");
            ((CircleBubbleView) this.oAY).setProgress(this.oAX.getIndicatorTextString());
        } else {
            this.oAY = View.inflate(this.mContext, a.g.isb_indicator, null);
            this.oAU = (LinearLayout) this.oAY.findViewById(a.f.indicator_container);
            this.oAS = (ArrowView) this.oAY.findViewById(a.f.indicator_arrow);
            this.oAS.setColor(this.mIndicatorColor);
            this.hDB = (TextView) this.oAY.findViewById(a.f.isb_progress);
            this.hDB.setText(this.oAX.getIndicatorTextString());
            this.hDB.setTextSize(f.px2sp(this.mContext, this.oAM));
            this.hDB.setTextColor(this.oAL);
            if (Build.VERSION.SDK_INT >= 16) {
                this.oAU.setBackground(ebW());
            } else {
                this.oAU.setBackgroundDrawable(ebW());
            }
            if (this.oBa != null) {
                int identifier2 = this.mContext.getResources().getIdentifier("isb_progress", "id", this.mContext.getApplicationContext().getPackageName());
                View view = this.oBa;
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
    private GradientDrawable ebW() {
        GradientDrawable gradientDrawable;
        if (this.oAW == 2) {
            gradientDrawable = (GradientDrawable) this.mContext.getResources().getDrawable(a.e.isb_indicator_rounded_corners);
        } else {
            gradientDrawable = (GradientDrawable) this.mContext.getResources().getDrawable(a.e.isb_indicator_square_corners);
        }
        gradientDrawable.setColor(this.mIndicatorColor);
        return gradientDrawable;
    }

    private int ebX() {
        WindowManager windowManager = (WindowManager) this.mContext.getSystemService("window");
        if (windowManager != null) {
            return windowManager.getDefaultDisplay().getWidth();
        }
        return 0;
    }

    private int ebY() {
        this.oAX.getLocationOnScreen(this.joQ);
        return this.joQ[0];
    }

    private void bh(float f) {
        if (this.oAW != 4 && this.oAW != 1) {
            int ebY = ebY();
            if (ebY + f < this.oAT.getContentView().getMeasuredWidth() / 2) {
                i(this.oAS, -((int) (((this.oAT.getContentView().getMeasuredWidth() / 2) - ebY) - f)), -1, -1, -1);
            } else if ((this.mWindowWidth - ebY) - f < this.oAT.getContentView().getMeasuredWidth() / 2) {
                i(this.oAS, (int) ((this.oAT.getContentView().getMeasuredWidth() / 2) - ((this.mWindowWidth - ebY) - f)), -1, -1, -1);
            } else {
                i(this.oAS, 0, 0, 0, 0);
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
    public void ebZ() {
        if (this.oAT == null && this.oAW != 0 && this.oAY != null) {
            this.oAY.measure(0, 0);
            this.oAT = new PopupWindow(this.oAY, -2, -2, false);
        }
    }

    /* JADX INFO: Access modifiers changed from: package-private */
    public View eca() {
        return this.oAY;
    }

    /* JADX INFO: Access modifiers changed from: package-private */
    public void Wc(String str) {
        if (this.oAY instanceof CircleBubbleView) {
            ((CircleBubbleView) this.oAY).setProgress(str);
        } else if (this.hDB != null) {
            this.hDB.setText(str);
        }
    }

    /* JADX INFO: Access modifiers changed from: package-private */
    public void Mj(int i) {
        i(this.oAY, i, -1, -1, -1);
    }

    /* JADX INFO: Access modifiers changed from: package-private */
    public void Mk(int i) {
        i(this.oAS, i, -1, -1, -1);
    }

    /* JADX INFO: Access modifiers changed from: package-private */
    public void bi(float f) {
        if (this.oAX.isEnabled() && this.oAX.getVisibility() == 0) {
            ecb();
            if (this.oAT != null) {
                this.oAT.getContentView().measure(0, 0);
                this.oAT.update(this.oAX, (int) (f - (this.oAT.getContentView().getMeasuredWidth() / 2)), -(((this.oAX.getMeasuredHeight() + this.oAT.getContentView().getMeasuredHeight()) - this.oAX.getPaddingTop()) + this.oAV), -1, -1);
                bh(f);
            }
        }
    }

    /* JADX INFO: Access modifiers changed from: package-private */
    public void bj(float f) {
        if (this.oAX.isEnabled() && this.oAX.getVisibility() == 0) {
            ecb();
            if (this.oAT != null) {
                this.oAT.getContentView().measure(0, 0);
                this.oAT.showAsDropDown(this.oAX, (int) (f - (this.oAT.getContentView().getMeasuredWidth() / 2.0f)), -(((this.oAX.getMeasuredHeight() + this.oAT.getContentView().getMeasuredHeight()) - this.oAX.getPaddingTop()) + this.oAV));
                bh(f);
            }
        }
    }

    /* JADX INFO: Access modifiers changed from: package-private */
    public void ecb() {
        String indicatorTextString = this.oAX.getIndicatorTextString();
        if (this.oAY instanceof CircleBubbleView) {
            ((CircleBubbleView) this.oAY).setProgress(indicatorTextString);
        } else if (this.hDB != null) {
            this.hDB.setText(indicatorTextString);
        }
    }

    /* JADX INFO: Access modifiers changed from: package-private */
    public void hide() {
        if (this.oAT != null) {
            this.oAT.dismiss();
        }
    }

    /* JADX INFO: Access modifiers changed from: package-private */
    public boolean isShowing() {
        return this.oAT != null && this.oAT.isShowing();
    }

    public void es(@NonNull View view) {
        a(view, null);
    }

    public void a(@NonNull View view, @Nullable TextView textView) {
        this.hDB = textView;
        this.oAU.removeAllViews();
        if (Build.VERSION.SDK_INT >= 16) {
            view.setBackground(ebW());
        } else {
            view.setBackgroundDrawable(ebW());
        }
        this.oAU.addView(view);
    }
}
