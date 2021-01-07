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
    private int ovb;
    private float ovc;
    private ArrowView ovi;
    private PopupWindow ovj;
    private LinearLayout ovk;
    private int ovl;
    private int ovm;
    private IndicatorSeekBar ovn;
    private View ovo;
    private View ovp;
    private View ovq;
    private int[] jnC = new int[2];
    private final int mWindowWidth = edu();

    public c(Context context, IndicatorSeekBar indicatorSeekBar, int i, int i2, int i3, int i4, View view, View view2) {
        this.mContext = context;
        this.ovn = indicatorSeekBar;
        this.mIndicatorColor = i;
        this.ovm = i2;
        this.ovp = view;
        this.ovq = view2;
        this.ovc = i3;
        this.ovb = i4;
        this.ovl = f.dp2px(this.mContext, 2.0f);
        eds();
    }

    private void eds() {
        View findViewById;
        if (this.ovm == 4) {
            if (this.ovp != null) {
                this.ovo = this.ovp;
                int identifier = this.mContext.getResources().getIdentifier("isb_progress", "id", this.mContext.getApplicationContext().getPackageName());
                if (identifier > 0 && (findViewById = this.ovo.findViewById(identifier)) != null) {
                    if (findViewById instanceof TextView) {
                        this.hDI = (TextView) findViewById;
                        this.hDI.setText(this.ovn.getIndicatorTextString());
                        this.hDI.setTextSize(f.px2sp(this.mContext, this.ovc));
                        this.hDI.setTextColor(this.ovb);
                        return;
                    }
                    throw new ClassCastException("the view identified by isb_progress in indicator custom layout can not be cast to TextView");
                }
                return;
            }
            throw new IllegalArgumentException("the attr：indicator_custom_layout must be set while you set the indicator type to CUSTOM.");
        } else if (this.ovm == 1) {
            this.ovo = new CircleBubbleView(this.mContext, this.ovc, this.ovb, this.mIndicatorColor, "1000");
            ((CircleBubbleView) this.ovo).setProgress(this.ovn.getIndicatorTextString());
        } else {
            this.ovo = View.inflate(this.mContext, a.g.isb_indicator, null);
            this.ovk = (LinearLayout) this.ovo.findViewById(a.f.indicator_container);
            this.ovi = (ArrowView) this.ovo.findViewById(a.f.indicator_arrow);
            this.ovi.setColor(this.mIndicatorColor);
            this.hDI = (TextView) this.ovo.findViewById(a.f.isb_progress);
            this.hDI.setText(this.ovn.getIndicatorTextString());
            this.hDI.setTextSize(f.px2sp(this.mContext, this.ovc));
            this.hDI.setTextColor(this.ovb);
            if (Build.VERSION.SDK_INT >= 16) {
                this.ovk.setBackground(edt());
            } else {
                this.ovk.setBackgroundDrawable(edt());
            }
            if (this.ovq != null) {
                int identifier2 = this.mContext.getResources().getIdentifier("isb_progress", "id", this.mContext.getApplicationContext().getPackageName());
                View view = this.ovq;
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
    private GradientDrawable edt() {
        GradientDrawable gradientDrawable;
        if (this.ovm == 2) {
            gradientDrawable = (GradientDrawable) this.mContext.getResources().getDrawable(a.e.isb_indicator_rounded_corners);
        } else {
            gradientDrawable = (GradientDrawable) this.mContext.getResources().getDrawable(a.e.isb_indicator_square_corners);
        }
        gradientDrawable.setColor(this.mIndicatorColor);
        return gradientDrawable;
    }

    private int edu() {
        WindowManager windowManager = (WindowManager) this.mContext.getSystemService("window");
        if (windowManager != null) {
            return windowManager.getDefaultDisplay().getWidth();
        }
        return 0;
    }

    private int edv() {
        this.ovn.getLocationOnScreen(this.jnC);
        return this.jnC[0];
    }

    private void be(float f) {
        if (this.ovm != 4 && this.ovm != 1) {
            int edv = edv();
            if (edv + f < this.ovj.getContentView().getMeasuredWidth() / 2) {
                i(this.ovi, -((int) (((this.ovj.getContentView().getMeasuredWidth() / 2) - edv) - f)), -1, -1, -1);
            } else if ((this.mWindowWidth - edv) - f < this.ovj.getContentView().getMeasuredWidth() / 2) {
                i(this.ovi, (int) ((this.ovj.getContentView().getMeasuredWidth() / 2) - ((this.mWindowWidth - edv) - f)), -1, -1, -1);
            } else {
                i(this.ovi, 0, 0, 0, 0);
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
    public void edw() {
        if (this.ovj == null && this.ovm != 0 && this.ovo != null) {
            this.ovo.measure(0, 0);
            this.ovj = new PopupWindow(this.ovo, -2, -2, false);
        }
    }

    /* JADX INFO: Access modifiers changed from: package-private */
    public View edx() {
        return this.ovo;
    }

    /* JADX INFO: Access modifiers changed from: package-private */
    public void VZ(String str) {
        if (this.ovo instanceof CircleBubbleView) {
            ((CircleBubbleView) this.ovo).setProgress(str);
        } else if (this.hDI != null) {
            this.hDI.setText(str);
        }
    }

    /* JADX INFO: Access modifiers changed from: package-private */
    public void Nu(int i) {
        i(this.ovo, i, -1, -1, -1);
    }

    /* JADX INFO: Access modifiers changed from: package-private */
    public void Nv(int i) {
        i(this.ovi, i, -1, -1, -1);
    }

    /* JADX INFO: Access modifiers changed from: package-private */
    public void bf(float f) {
        if (this.ovn.isEnabled() && this.ovn.getVisibility() == 0) {
            edy();
            if (this.ovj != null) {
                this.ovj.getContentView().measure(0, 0);
                this.ovj.update(this.ovn, (int) (f - (this.ovj.getContentView().getMeasuredWidth() / 2)), -(((this.ovn.getMeasuredHeight() + this.ovj.getContentView().getMeasuredHeight()) - this.ovn.getPaddingTop()) + this.ovl), -1, -1);
                be(f);
            }
        }
    }

    /* JADX INFO: Access modifiers changed from: package-private */
    public void bg(float f) {
        if (this.ovn.isEnabled() && this.ovn.getVisibility() == 0) {
            edy();
            if (this.ovj != null) {
                this.ovj.getContentView().measure(0, 0);
                this.ovj.showAsDropDown(this.ovn, (int) (f - (this.ovj.getContentView().getMeasuredWidth() / 2.0f)), -(((this.ovn.getMeasuredHeight() + this.ovj.getContentView().getMeasuredHeight()) - this.ovn.getPaddingTop()) + this.ovl));
                be(f);
            }
        }
    }

    /* JADX INFO: Access modifiers changed from: package-private */
    public void edy() {
        String indicatorTextString = this.ovn.getIndicatorTextString();
        if (this.ovo instanceof CircleBubbleView) {
            ((CircleBubbleView) this.ovo).setProgress(indicatorTextString);
        } else if (this.hDI != null) {
            this.hDI.setText(indicatorTextString);
        }
    }

    /* JADX INFO: Access modifiers changed from: package-private */
    public void hide() {
        if (this.ovj != null) {
            this.ovj.dismiss();
        }
    }

    /* JADX INFO: Access modifiers changed from: package-private */
    public boolean isShowing() {
        return this.ovj != null && this.ovj.isShowing();
    }

    public void eu(@NonNull View view) {
        a(view, null);
    }

    public void a(@NonNull View view, @Nullable TextView textView) {
        this.hDI = textView;
        this.ovk.removeAllViews();
        if (Build.VERSION.SDK_INT >= 16) {
            view.setBackground(edt());
        } else {
            view.setBackgroundDrawable(edt());
        }
        this.ovk.addView(view);
    }
}
