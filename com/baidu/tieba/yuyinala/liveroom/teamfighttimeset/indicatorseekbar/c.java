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
    private TextView hDI;
    private Context mContext;
    private int mIndicatorColor;
    private int ovc;
    private float ovd;
    private ArrowView ovj;
    private PopupWindow ovk;
    private LinearLayout ovl;
    private int ovm;
    private int ovn;
    private IndicatorSeekBar ovo;
    private View ovp;
    private View ovq;
    private View ovr;
    private int[] jnC = new int[2];
    private final int mWindowWidth = edt();

    public c(Context context, IndicatorSeekBar indicatorSeekBar, int i, int i2, int i3, int i4, View view, View view2) {
        this.mContext = context;
        this.ovo = indicatorSeekBar;
        this.mIndicatorColor = i;
        this.ovn = i2;
        this.ovq = view;
        this.ovr = view2;
        this.ovd = i3;
        this.ovc = i4;
        this.ovm = f.dp2px(this.mContext, 2.0f);
        edr();
    }

    private void edr() {
        View findViewById;
        if (this.ovn == 4) {
            if (this.ovq != null) {
                this.ovp = this.ovq;
                int identifier = this.mContext.getResources().getIdentifier("isb_progress", "id", this.mContext.getApplicationContext().getPackageName());
                if (identifier > 0 && (findViewById = this.ovp.findViewById(identifier)) != null) {
                    if (findViewById instanceof TextView) {
                        this.hDI = (TextView) findViewById;
                        this.hDI.setText(this.ovo.getIndicatorTextString());
                        this.hDI.setTextSize(f.px2sp(this.mContext, this.ovd));
                        this.hDI.setTextColor(this.ovc);
                        return;
                    }
                    throw new ClassCastException("the view identified by isb_progress in indicator custom layout can not be cast to TextView");
                }
                return;
            }
            throw new IllegalArgumentException("the attr：indicator_custom_layout must be set while you set the indicator type to CUSTOM.");
        } else if (this.ovn == 1) {
            this.ovp = new CircleBubbleView(this.mContext, this.ovd, this.ovc, this.mIndicatorColor, "1000");
            ((CircleBubbleView) this.ovp).setProgress(this.ovo.getIndicatorTextString());
        } else {
            this.ovp = View.inflate(this.mContext, a.g.isb_indicator, null);
            this.ovl = (LinearLayout) this.ovp.findViewById(a.f.indicator_container);
            this.ovj = (ArrowView) this.ovp.findViewById(a.f.indicator_arrow);
            this.ovj.setColor(this.mIndicatorColor);
            this.hDI = (TextView) this.ovp.findViewById(a.f.isb_progress);
            this.hDI.setText(this.ovo.getIndicatorTextString());
            this.hDI.setTextSize(f.px2sp(this.mContext, this.ovd));
            this.hDI.setTextColor(this.ovc);
            if (Build.VERSION.SDK_INT >= 16) {
                this.ovl.setBackground(eds());
            } else {
                this.ovl.setBackgroundDrawable(eds());
            }
            if (this.ovr != null) {
                int identifier2 = this.mContext.getResources().getIdentifier("isb_progress", "id", this.mContext.getApplicationContext().getPackageName());
                View view = this.ovr;
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
    private GradientDrawable eds() {
        GradientDrawable gradientDrawable;
        if (this.ovn == 2) {
            gradientDrawable = (GradientDrawable) this.mContext.getResources().getDrawable(a.e.isb_indicator_rounded_corners);
        } else {
            gradientDrawable = (GradientDrawable) this.mContext.getResources().getDrawable(a.e.isb_indicator_square_corners);
        }
        gradientDrawable.setColor(this.mIndicatorColor);
        return gradientDrawable;
    }

    private int edt() {
        WindowManager windowManager = (WindowManager) this.mContext.getSystemService("window");
        if (windowManager != null) {
            return windowManager.getDefaultDisplay().getWidth();
        }
        return 0;
    }

    private int edu() {
        this.ovo.getLocationOnScreen(this.jnC);
        return this.jnC[0];
    }

    private void be(float f) {
        if (this.ovn != 4 && this.ovn != 1) {
            int edu = edu();
            if (edu + f < this.ovk.getContentView().getMeasuredWidth() / 2) {
                i(this.ovj, -((int) (((this.ovk.getContentView().getMeasuredWidth() / 2) - edu) - f)), -1, -1, -1);
            } else if ((this.mWindowWidth - edu) - f < this.ovk.getContentView().getMeasuredWidth() / 2) {
                i(this.ovj, (int) ((this.ovk.getContentView().getMeasuredWidth() / 2) - ((this.mWindowWidth - edu) - f)), -1, -1, -1);
            } else {
                i(this.ovj, 0, 0, 0, 0);
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
    public void edv() {
        if (this.ovk == null && this.ovn != 0 && this.ovp != null) {
            this.ovp.measure(0, 0);
            this.ovk = new PopupWindow(this.ovp, -2, -2, false);
        }
    }

    /* JADX INFO: Access modifiers changed from: package-private */
    public View edw() {
        return this.ovp;
    }

    /* JADX INFO: Access modifiers changed from: package-private */
    public void Wa(String str) {
        if (this.ovp instanceof CircleBubbleView) {
            ((CircleBubbleView) this.ovp).setProgress(str);
        } else if (this.hDI != null) {
            this.hDI.setText(str);
        }
    }

    /* JADX INFO: Access modifiers changed from: package-private */
    public void Nu(int i) {
        i(this.ovp, i, -1, -1, -1);
    }

    /* JADX INFO: Access modifiers changed from: package-private */
    public void Nv(int i) {
        i(this.ovj, i, -1, -1, -1);
    }

    /* JADX INFO: Access modifiers changed from: package-private */
    public void bf(float f) {
        if (this.ovo.isEnabled() && this.ovo.getVisibility() == 0) {
            edx();
            if (this.ovk != null) {
                this.ovk.getContentView().measure(0, 0);
                this.ovk.update(this.ovo, (int) (f - (this.ovk.getContentView().getMeasuredWidth() / 2)), -(((this.ovo.getMeasuredHeight() + this.ovk.getContentView().getMeasuredHeight()) - this.ovo.getPaddingTop()) + this.ovm), -1, -1);
                be(f);
            }
        }
    }

    /* JADX INFO: Access modifiers changed from: package-private */
    public void bg(float f) {
        if (this.ovo.isEnabled() && this.ovo.getVisibility() == 0) {
            edx();
            if (this.ovk != null) {
                this.ovk.getContentView().measure(0, 0);
                this.ovk.showAsDropDown(this.ovo, (int) (f - (this.ovk.getContentView().getMeasuredWidth() / 2.0f)), -(((this.ovo.getMeasuredHeight() + this.ovk.getContentView().getMeasuredHeight()) - this.ovo.getPaddingTop()) + this.ovm));
                be(f);
            }
        }
    }

    /* JADX INFO: Access modifiers changed from: package-private */
    public void edx() {
        String indicatorTextString = this.ovo.getIndicatorTextString();
        if (this.ovp instanceof CircleBubbleView) {
            ((CircleBubbleView) this.ovp).setProgress(indicatorTextString);
        } else if (this.hDI != null) {
            this.hDI.setText(indicatorTextString);
        }
    }

    /* JADX INFO: Access modifiers changed from: package-private */
    public void hide() {
        if (this.ovk != null) {
            this.ovk.dismiss();
        }
    }

    /* JADX INFO: Access modifiers changed from: package-private */
    public boolean isShowing() {
        return this.ovk != null && this.ovk.isShowing();
    }

    public void eu(@NonNull View view) {
        a(view, null);
    }

    public void a(@NonNull View view, @Nullable TextView textView) {
        this.hDI = textView;
        this.ovl.removeAllViews();
        if (Build.VERSION.SDK_INT >= 16) {
            view.setBackground(eds());
        } else {
            view.setBackgroundDrawable(eds());
        }
        this.ovl.addView(view);
    }
}
