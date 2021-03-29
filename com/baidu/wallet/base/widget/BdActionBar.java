package com.baidu.wallet.base.widget;

import android.app.Activity;
import android.content.Context;
import android.content.res.ColorStateList;
import android.graphics.Color;
import android.graphics.drawable.Drawable;
import android.os.Build;
import android.text.TextUtils;
import android.util.AttributeSet;
import android.view.LayoutInflater;
import android.view.MotionEvent;
import android.view.View;
import android.widget.ImageView;
import android.widget.RelativeLayout;
import android.widget.TextView;
import com.baidu.apollon.base.widget.NetImageView;
import com.baidu.apollon.statusbar.ImmersiveStatusBarManager;
import com.baidu.apollon.statusbar.StatusBarUtils;
import com.baidu.apollon.utils.DisplayUtils;
import com.baidu.apollon.utils.ResUtils;
import com.baidu.apollon.utils.support.ViewHelper;
import com.baidu.wallet.utils.AccessibilityUtils;
/* loaded from: classes5.dex */
public class BdActionBar extends RelativeLayout {
    public static final int TEXT_ALIGN_CENTER = 1;
    public static final int TEXT_ALIGN_LEFT = 0;
    public static final int TEXT_ALIGN_RIGHT = 2;

    /* renamed from: a  reason: collision with root package name */
    public static final float f23727a = 0.5f;

    /* renamed from: b  reason: collision with root package name */
    public static final float f23728b = 1.0f;

    /* renamed from: c  reason: collision with root package name */
    public String f23729c;

    /* renamed from: d  reason: collision with root package name */
    public View f23730d;

    /* renamed from: e  reason: collision with root package name */
    public ImageView f23731e;

    /* renamed from: f  reason: collision with root package name */
    public TextView f23732f;

    /* renamed from: g  reason: collision with root package name */
    public TextView f23733g;

    /* renamed from: h  reason: collision with root package name */
    public TextView f23734h;
    public View i;
    public View j;
    public View k;
    public NetImageView l;
    public View m;
    public View mLeftImgZone2;
    public TextView mTitleCenterText;
    public NetImageView n;
    public TextView o;
    public View p;
    public TextView q;
    public ImageView r;
    public ImageView s;
    public ImageView t;
    public View u;
    public TextView v;
    public ImageView w;

    public BdActionBar(Context context) {
        super(context);
        this.f23729c = "";
        a();
    }

    public int getActionBarHeight() {
        return this.f23730d.getHeight() - this.i.getHeight();
    }

    public String getLayoutId() {
        return "wallet_base_action_bar";
    }

    public int getMainTitleViewWidth() {
        this.mTitleCenterText.measure(View.MeasureSpec.makeMeasureSpec(0, 0), View.MeasureSpec.makeMeasureSpec(0, 0));
        return this.mTitleCenterText.getMeasuredWidth();
    }

    public View getRightImgZone1ImgView() {
        return this.l;
    }

    public View getRightImgZone2ImgView() {
        return this.n;
    }

    public View getRightImgZone2NotifyView() {
        return this.o;
    }

    public int getRightImgZone2NotifyVisibility() {
        return this.o.getVisibility();
    }

    public View getRightNotifyZone1() {
        return this.u;
    }

    public View getRightZone1View() {
        return this.k;
    }

    public View getRightZoneView() {
        return this.m;
    }

    public int getStatusBarHeight() {
        return this.i.getHeight();
    }

    public String getTitle() {
        return this.f23729c;
    }

    public int[] getTitleSizeRange() {
        return new int[]{DisplayUtils.dip2px(getContext(), 18.0f), Math.round(this.f23734h.getTextSize())};
    }

    public void hideLeftZone() {
        this.mLeftImgZone2.setVisibility(8);
    }

    public boolean isLeftZoneImageSelected() {
        return this.mLeftImgZone2.isSelected();
    }

    public void resetFullScreenTextColor() {
        TextView textView = this.f23732f;
        if (textView != null) {
            textView.setTextColor(ResUtils.getColor(getContext(), "wallet_base_click_text1_color_selector"));
        }
        TextView textView2 = this.f23733g;
        if (textView2 != null) {
            textView2.setTextColor(ResUtils.getColor(getContext(), "wallet_base_click_text1_color_selector"));
        }
        TextView textView3 = this.f23734h;
        if (textView3 != null) {
            textView3.setTextColor(ResUtils.getColor(getContext(), "wallet_base_click_text1_color_selector"));
        }
        TextView textView4 = this.mTitleCenterText;
        if (textView4 != null) {
            textView4.setTextColor(ResUtils.getColor(getContext(), "bd_wallet_black3"));
        }
        TextView textView5 = this.o;
        if (textView5 != null) {
            textView5.setTextColor(ResUtils.getColor(getContext(), "wallet_base_click_text2color_selector"));
        }
        TextView textView6 = this.q;
        if (textView6 != null) {
            textView6.setTextColor(ResUtils.getColor(getContext(), "bd_wallet_text_999999"));
        }
    }

    public void setBottomSeperatorvisible(boolean z) {
        ImageView imageView = this.s;
        if (imageView == null) {
            return;
        }
        imageView.setVisibility(z ? 0 : 8);
    }

    public int setCloseButtonVisibility(int i) {
        int visibility = this.j.getVisibility();
        if (i == 0 || 8 == i || 4 == i) {
            this.j.setVisibility(i);
            if (i == 0) {
                this.mTitleCenterText.setMaxEms(ResUtils.getInteger(getContext(), "wallet_base_titlebar_centertext_maxems_1"));
            }
        }
        return visibility;
    }

    public void setCloseOnClickListener(View.OnClickListener onClickListener) {
        this.j.setOnClickListener(onClickListener);
    }

    public void setFullScreenTextColor(int i) {
        TextView textView = this.f23732f;
        if (textView != null) {
            textView.setTextColor(i);
        }
        TextView textView2 = this.f23733g;
        if (textView2 != null) {
            textView2.setTextColor(i);
        }
        TextView textView3 = this.f23734h;
        if (textView3 != null) {
            textView3.setTextColor(i);
        }
        TextView textView4 = this.mTitleCenterText;
        if (textView4 != null) {
            textView4.setTextColor(i);
        }
        TextView textView5 = this.o;
        if (textView5 != null) {
            textView5.setTextColor(i);
        }
        TextView textView6 = this.q;
        if (textView6 != null) {
            textView6.setTextColor(i);
        }
    }

    public void setIconFlag(boolean z) {
        View view;
        if (z) {
            setLeftZoneImageSrc(ResUtils.drawable(getContext(), "wallet_base_actionbar_back_selector_white"));
            if (this.n.getVisibility() == 0) {
                setRightImgZone2Src(ResUtils.drawable(getContext(), "wallet_base_actionbar_more_selector_white"));
            }
            this.t.setImageDrawable(ResUtils.getDrawable(getContext(), "wallet_base_actionbar_close_selector_white"));
        } else {
            setLeftZoneImageSrc(ResUtils.drawable(getContext(), "wallet_base_actionbar_back_selector"));
            if (this.n.getVisibility() == 0) {
                setRightImgZone2Src(ResUtils.drawable(getContext(), "wallet_base_actionbar_more_selector"));
            }
            this.t.setImageDrawable(ResUtils.getDrawable(getContext(), "wallet_base_actionbar_close_selector"));
        }
        if (Build.VERSION.SDK_INT >= 19) {
            Activity activity = getContext() instanceof Activity ? (Activity) getContext() : null;
            if (activity == null || (view = this.i) == null) {
                return;
            }
            ImmersiveStatusBarManager.setTopBar(activity, view, !z);
        }
    }

    public void setImgZoneBackgroundResource(int i) {
        this.k.setBackgroundResource(i);
        this.m.setBackgroundResource(i);
    }

    public void setLeftImgZone2NotifyText(String str, float f2) {
        this.f23732f.setVisibility(8);
        if (f2 < 0.0f) {
            return;
        }
        this.f23732f.setText(str);
        this.f23732f.setTextSize(1, f2);
    }

    public void setLeftImgZone2NotifyTextColor(int i) {
        this.f23732f.setTextColor(i);
    }

    public void setLeftImgZone2NotifyTextColorStateList(ColorStateList colorStateList) {
        this.f23732f.setTextColor(colorStateList);
    }

    public void setLeftZoneImageSelected(boolean z) {
    }

    public void setLeftZoneImageSrc(int i) {
        Drawable drawable = i != 0 ? getResources().getDrawable(i) : null;
        if (drawable != null) {
            drawable.setBounds(0, 0, drawable.getMinimumWidth(), drawable.getMinimumHeight());
        }
        this.f23731e.setImageDrawable(drawable);
    }

    public void setLeftZoneOnClickListener(View.OnClickListener onClickListener) {
        this.mLeftImgZone2.setOnClickListener(onClickListener);
    }

    public BdActionBar setOnlyIcons(boolean z) {
        int i = z ? 8 : 0;
        return a(i).b(i);
    }

    public void setRightImgZone1Enable(boolean z) {
        this.l.setEnabled(z);
        this.k.setEnabled(z);
    }

    public void setRightImgZone1OnClickListener(View.OnClickListener onClickListener) {
        this.k.setOnClickListener(onClickListener);
    }

    public void setRightImgZone1Src(int i) {
        this.k.setVisibility(0);
        this.l.setVisibility(0);
        this.l.setImageResource(i);
    }

    public void setRightImgZone1Visibility(int i) {
        this.k.setVisibility(i);
    }

    public void setRightImgZone2Enable(boolean z) {
        this.n.setEnabled(z);
        this.m.setEnabled(z);
    }

    public void setRightImgZone2NotifyClickListener(View.OnClickListener onClickListener) {
        if (onClickListener != null) {
            this.o.setVisibility(0);
        }
        this.o.setOnClickListener(onClickListener);
    }

    public void setRightImgZone2NotifyText(String str) {
        if (!TextUtils.isEmpty(str)) {
            setRightImgZone2NotifyVisibility(0);
        }
        this.o.setText(str);
    }

    public void setRightImgZone2NotifyTextBg(int i) {
        this.o.setBackgroundResource(i);
        this.o.setPadding(12, 6, 12, 6);
    }

    public void setRightImgZone2NotifyTextColor(int i) {
        this.o.setTextColor(i);
    }

    public void setRightImgZone2NotifyTextSize(float f2) {
        this.o.setTextSize(1, f2);
    }

    public void setRightImgZone2NotifyTextViewPadding(int i, int i2, int i3, int i4) {
        this.o.setPadding(i, i2, i3, i4);
    }

    public void setRightImgZone2NotifyVisibility(int i) {
        this.o.setVisibility(i);
    }

    public void setRightImgZone2OnClickListener(View.OnClickListener onClickListener) {
        if (onClickListener != null) {
            this.m.setVisibility(0);
        }
        this.m.setOnClickListener(onClickListener);
    }

    public void setRightImgZone2Src(int i) {
        this.n.setVisibility(0);
        this.n.setImageResource(i);
    }

    public void setRightImgZone2Visibility(int i) {
        this.m.setVisibility(i);
    }

    public void setRightNotifyImg(Drawable drawable) {
        this.w.setImageDrawable(drawable);
    }

    public void setRightNotifyText(String str) {
        this.v.setText(str);
    }

    public void setRightNotifyTextColor(int i) {
        this.v.setTextColor(i);
    }

    public void setRightNotifyTextSize(int i) {
        this.v.setTextSize(1, i);
    }

    public void setRightNotifyZone1Bg(Drawable drawable) {
        this.u.setBackgroundDrawable(drawable);
    }

    public void setRightNotifyZone1ClickListener(View.OnClickListener onClickListener) {
        this.u.setOnClickListener(onClickListener);
    }

    public void setRightNotifyZone1Visibility(int i) {
        this.u.setVisibility(i);
    }

    public void setSafeIconVisible(boolean z) {
        if (z) {
            this.r.setVisibility(0);
        } else {
            this.r.setVisibility(8);
        }
    }

    public void setTitle(String str) {
        this.f23729c = str;
        this.mTitleCenterText.setText(str);
    }

    public void setTitleCenterSafeTipColor(int i) {
        this.q.setTextColor(i);
    }

    public void setTitleCenterSafeTipText(String str) {
        if (TextUtils.isEmpty(str)) {
            this.p.setVisibility(8);
            return;
        }
        this.p.setVisibility(0);
        this.q.setText(str);
    }

    public void setTitleColor(int i) {
        this.mTitleCenterText.setTextColor(i);
    }

    public void setTitleEllipsize(TextUtils.TruncateAt truncateAt) {
        if (truncateAt != null) {
            this.mTitleCenterText.setSingleLine();
            this.mTitleCenterText.setEllipsize(truncateAt);
        }
    }

    public void setTitleShadowLayer(float f2, float f3, float f4, int i) {
        this.mTitleCenterText.setShadowLayer(f2, f3, f4, i);
    }

    public void setTitleSize(int i) {
        this.mTitleCenterText.setTextSize(0, i);
    }

    public void setTitleTextColorAlpha(int i) {
        try {
            int currentTextColor = this.mTitleCenterText.getCurrentTextColor();
            this.mTitleCenterText.setTextColor(Color.argb(i, Color.red(currentTextColor), Color.green(currentTextColor), Color.blue(currentTextColor)));
            int currentTextColor2 = this.q.getCurrentTextColor();
            this.q.setTextColor(Color.argb(i, Color.red(currentTextColor2), Color.green(currentTextColor2), Color.blue(currentTextColor2)));
        } catch (Throwable unused) {
        }
    }

    public void setTitlebgColor(int i) {
        View view = this.f23730d;
        if (view == null) {
            return;
        }
        view.setBackgroundColor(i);
    }

    public void setTop(Activity activity) {
        if (Build.VERSION.SDK_INT < 19) {
            return;
        }
        if (activity == null) {
            activity = getContext() instanceof Activity ? (Activity) getContext() : null;
        }
        if (activity == null) {
            return;
        }
        this.i.setLayoutParams(new RelativeLayout.LayoutParams(-1, StatusBarUtils.getStatusBarHeight(activity)));
        ImmersiveStatusBarManager.setTopBar(activity, this.i, true);
    }

    public void setbackBg(Drawable drawable) {
        this.mLeftImgZone2.setBackgroundDrawable(drawable);
    }

    private void a() {
        LayoutInflater.from(getContext()).inflate(ResUtils.layout(getContext(), getLayoutId()), this);
        this.i = findViewById(ResUtils.id(getContext(), "actionbar_statusbar_top"));
        setTop((Activity) null);
        this.f23730d = findViewById(ResUtils.id(getContext(), "title"));
        this.mLeftImgZone2 = findViewById(ResUtils.id(getContext(), "title_left_imgzone2"));
        this.f23731e = (ImageView) findViewById(ResUtils.id(getContext(), "title_left_imgzone2_img"));
        this.f23733g = (TextView) findViewById(ResUtils.id(getContext(), "wallet_titlebar_left_imgzone2_close"));
        this.t = (ImageView) findViewById(ResUtils.id(getContext(), "bd_ab_ic_close"));
        this.f23734h = (TextView) findViewById(ResUtils.id(getContext(), "title_left_imgzone2_notify"));
        this.f23732f = (TextView) findViewById(ResUtils.id(getContext(), "title_left_imgzone2_notify"));
        this.mLeftImgZone2.setOnTouchListener(new View.OnTouchListener() { // from class: com.baidu.wallet.base.widget.BdActionBar.1
            @Override // android.view.View.OnTouchListener
            public boolean onTouch(View view, MotionEvent motionEvent) {
                if (motionEvent.getAction() == 0 || motionEvent.getAction() == 2) {
                    ViewHelper.setAlpha(BdActionBar.this.mLeftImgZone2, 0.5f);
                    return false;
                }
                ViewHelper.setAlpha(BdActionBar.this.mLeftImgZone2, 1.0f);
                return false;
            }
        });
        View findViewById = findViewById(ResUtils.id(getContext(), "title_close"));
        this.j = findViewById;
        findViewById.setOnTouchListener(new View.OnTouchListener() { // from class: com.baidu.wallet.base.widget.BdActionBar.2
            @Override // android.view.View.OnTouchListener
            public boolean onTouch(View view, MotionEvent motionEvent) {
                if (motionEvent.getAction() == 0 || motionEvent.getAction() == 2) {
                    ViewHelper.setAlpha(BdActionBar.this.j, 0.5f);
                    return false;
                }
                ViewHelper.setAlpha(BdActionBar.this.j, 1.0f);
                return false;
            }
        });
        this.mTitleCenterText = (TextView) findViewById(ResUtils.id(getContext(), "title_center_text"));
        this.p = findViewById(ResUtils.id(getContext(), "title_center_safe_layout"));
        this.q = (TextView) findViewById(ResUtils.id(getContext(), "title_center_safe_tip"));
        this.r = (ImageView) findViewById(ResUtils.id(getContext(), "safe_icon"));
        this.k = findViewById(ResUtils.id(getContext(), "title_right_imgzone1"));
        this.l = (NetImageView) findViewById(ResUtils.id(getContext(), "title_right_imgzone2_img1"));
        this.m = findViewById(ResUtils.id(getContext(), "title_right_imgzone2"));
        this.n = (NetImageView) findViewById(ResUtils.id(getContext(), "title_right_imgzone2_img"));
        this.o = (TextView) findViewById(ResUtils.id(getContext(), "title_right_imgzone2_notify"));
        this.u = findViewById(ResUtils.id(getContext(), "title_right_imgzone2_notify_zone"));
        this.v = (TextView) findViewById(ResUtils.id(getContext(), "title_right_imgzone2_notify1"));
        this.w = (ImageView) findViewById(ResUtils.id(getContext(), "title_right_imgzone2_notify_triangle"));
        if (!TextUtils.isEmpty(this.f23729c)) {
            setTitle(this.f23729c);
        }
        this.s = (ImageView) findViewById(ResUtils.id(getContext(), "title_bottom_seperator"));
    }

    private BdActionBar b(int i) {
        if (i == 0 || 8 == i) {
            if (this.f23733g.getVisibility() != i) {
                a(this.t);
            }
            this.f23733g.setVisibility(i);
        }
        return this;
    }

    public void setRightImgZone2Src(int i, CharSequence charSequence) {
        setRightImgZone2Src(i);
        AccessibilityUtils.setContentDescription(this.n, charSequence);
    }

    public void setTitle(int i) {
        setTitle(getResources().getString(i));
    }

    public BdActionBar(Context context, AttributeSet attributeSet) {
        super(context, attributeSet);
        this.f23729c = "";
        a();
    }

    public void setLeftZoneImageSrc(Drawable drawable) {
        if (drawable != null) {
            drawable.setBounds(0, 0, drawable.getMinimumWidth(), drawable.getMinimumHeight());
        }
        this.f23731e.setImageDrawable(drawable);
    }

    public void setRightImgZone1Src(String str) {
        this.k.setVisibility(0);
        this.l.setVisibility(0);
        this.l.setImageUrl(str);
    }

    public void setRightImgZone2Src(String str) {
        this.n.setVisibility(0);
        this.n.setImageUrl(str);
    }

    public BdActionBar(Context context, AttributeSet attributeSet, int i) {
        super(context, attributeSet, i);
        this.f23729c = "";
        a();
    }

    private BdActionBar a(int i) {
        if (i == 0 || 8 == i) {
            this.f23732f.setVisibility(8);
        }
        return this;
    }

    private void a(View view) {
        view.setVisibility(view.getVisibility() == 0 ? 8 : 0);
    }
}
