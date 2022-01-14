package com.baidu.wallet.base.widget;

import android.app.Activity;
import android.content.Context;
import android.content.res.ColorStateList;
import android.graphics.Color;
import android.graphics.PorterDuff;
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
import androidx.annotation.RequiresApi;
import androidx.core.view.InputDeviceCompat;
import com.baidu.android.imsdk.internal.Constants;
import com.baidu.apollon.base.widget.NetImageView;
import com.baidu.apollon.statusbar.ImmersiveStatusBarManager;
import com.baidu.apollon.statusbar.StatusBarUtils;
import com.baidu.apollon.utils.DisplayUtils;
import com.baidu.apollon.utils.ResUtils;
import com.baidu.apollon.utils.support.ViewHelper;
import com.baidu.tbadk.core.util.FileHelper;
import com.baidu.titan.sdk.runtime.FieldHolder;
import com.baidu.titan.sdk.runtime.InitContext;
import com.baidu.titan.sdk.runtime.InterceptResult;
import com.baidu.titan.sdk.runtime.Interceptable;
import com.baidu.titan.sdk.runtime.TitanRuntime;
import com.baidu.wallet.core.utils.LogUtil;
import com.baidu.wallet.utils.AccessibilityUtils;
/* loaded from: classes13.dex */
public class BdActionBar extends RelativeLayout {
    public static /* synthetic */ Interceptable $ic = null;
    public static final int TEXT_ALIGN_CENTER = 1;
    public static final int TEXT_ALIGN_LEFT = 0;
    public static final int TEXT_ALIGN_RIGHT = 2;
    public static final float a = 0.5f;

    /* renamed from: b  reason: collision with root package name */
    public static final float f50553b = 1.0f;
    public transient /* synthetic */ FieldHolder $fh;

    /* renamed from: c  reason: collision with root package name */
    public String f50554c;

    /* renamed from: d  reason: collision with root package name */
    public View f50555d;

    /* renamed from: e  reason: collision with root package name */
    public ImageView f50556e;

    /* renamed from: f  reason: collision with root package name */
    public TextView f50557f;

    /* renamed from: g  reason: collision with root package name */
    public TextView f50558g;

    /* renamed from: h  reason: collision with root package name */
    public TextView f50559h;

    /* renamed from: i  reason: collision with root package name */
    public View f50560i;

    /* renamed from: j  reason: collision with root package name */
    public View f50561j;
    public NetImageView k;
    public View l;
    public NetImageView m;
    public View mClose;
    public View mLeftImgZone2;
    public TextView mTitleCenterText;
    public TextView n;
    public View o;
    public TextView p;
    public ImageView q;
    public ImageView r;
    public ImageView s;
    public View t;
    public TextView u;
    public ImageView v;
    public BubbleForSubMenu w;
    public boolean x;

    /* JADX WARN: 'super' call moved to the top of the method (can break code semantics) */
    public BdActionBar(Context context) {
        super(context);
        Interceptable interceptable = $ic;
        if (interceptable != null) {
            InitContext newInitContext = TitanRuntime.newInitContext();
            newInitContext.initArgs = r2;
            Object[] objArr = {context};
            interceptable.invokeUnInit(65536, newInitContext);
            int i2 = newInitContext.flag;
            if ((i2 & 1) != 0) {
                int i3 = i2 & 2;
                super((Context) newInitContext.callArgs[0]);
                newInitContext.thisArg = this;
                interceptable.invokeInitBody(65536, newInitContext);
                return;
            }
        }
        this.f50554c = "";
        this.x = false;
        a();
    }

    private void a() {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeV(InputDeviceCompat.SOURCE_TRACKBALL, this) == null) {
            LayoutInflater.from(getContext()).inflate(ResUtils.layout(getContext(), getLayoutId()), this);
            this.f50560i = findViewById(ResUtils.id(getContext(), "actionbar_statusbar_top"));
            setTop((Activity) null);
            this.f50555d = findViewById(ResUtils.id(getContext(), "title"));
            this.mLeftImgZone2 = findViewById(ResUtils.id(getContext(), "title_left_imgzone2"));
            this.f50556e = (ImageView) findViewById(ResUtils.id(getContext(), "title_left_imgzone2_img"));
            this.f50558g = (TextView) findViewById(ResUtils.id(getContext(), "wallet_titlebar_left_imgzone2_close"));
            this.s = (ImageView) findViewById(ResUtils.id(getContext(), "bd_ab_ic_close"));
            this.f50559h = (TextView) findViewById(ResUtils.id(getContext(), "title_left_imgzone2_notify"));
            this.f50557f = (TextView) findViewById(ResUtils.id(getContext(), "title_left_imgzone2_notify"));
            this.mLeftImgZone2.setOnTouchListener(new View.OnTouchListener(this) { // from class: com.baidu.wallet.base.widget.BdActionBar.1
                public static /* synthetic */ Interceptable $ic;
                public transient /* synthetic */ FieldHolder $fh;
                public final /* synthetic */ BdActionBar a;

                {
                    Interceptable interceptable2 = $ic;
                    if (interceptable2 != null) {
                        InitContext newInitContext = TitanRuntime.newInitContext();
                        newInitContext.initArgs = r2;
                        Object[] objArr = {this};
                        interceptable2.invokeUnInit(65536, newInitContext);
                        int i2 = newInitContext.flag;
                        if ((i2 & 1) != 0) {
                            int i3 = i2 & 2;
                            newInitContext.thisArg = this;
                            interceptable2.invokeInitBody(65536, newInitContext);
                            return;
                        }
                    }
                    this.a = this;
                }

                @Override // android.view.View.OnTouchListener
                public boolean onTouch(View view, MotionEvent motionEvent) {
                    InterceptResult invokeLL;
                    Interceptable interceptable2 = $ic;
                    if (interceptable2 == null || (invokeLL = interceptable2.invokeLL(1048576, this, view, motionEvent)) == null) {
                        if (motionEvent.getAction() != 0 && motionEvent.getAction() != 2) {
                            ViewHelper.setAlpha(this.a.mLeftImgZone2, 1.0f);
                            return false;
                        }
                        ViewHelper.setAlpha(this.a.mLeftImgZone2, 0.5f);
                        return false;
                    }
                    return invokeLL.booleanValue;
                }
            });
            View findViewById = findViewById(ResUtils.id(getContext(), "title_close"));
            this.mClose = findViewById;
            findViewById.setOnTouchListener(new View.OnTouchListener(this) { // from class: com.baidu.wallet.base.widget.BdActionBar.2
                public static /* synthetic */ Interceptable $ic;
                public transient /* synthetic */ FieldHolder $fh;
                public final /* synthetic */ BdActionBar a;

                {
                    Interceptable interceptable2 = $ic;
                    if (interceptable2 != null) {
                        InitContext newInitContext = TitanRuntime.newInitContext();
                        newInitContext.initArgs = r2;
                        Object[] objArr = {this};
                        interceptable2.invokeUnInit(65536, newInitContext);
                        int i2 = newInitContext.flag;
                        if ((i2 & 1) != 0) {
                            int i3 = i2 & 2;
                            newInitContext.thisArg = this;
                            interceptable2.invokeInitBody(65536, newInitContext);
                            return;
                        }
                    }
                    this.a = this;
                }

                @Override // android.view.View.OnTouchListener
                public boolean onTouch(View view, MotionEvent motionEvent) {
                    InterceptResult invokeLL;
                    Interceptable interceptable2 = $ic;
                    if (interceptable2 == null || (invokeLL = interceptable2.invokeLL(1048576, this, view, motionEvent)) == null) {
                        if (motionEvent.getAction() != 0 && motionEvent.getAction() != 2) {
                            ViewHelper.setAlpha(this.a.mClose, 1.0f);
                            return false;
                        }
                        ViewHelper.setAlpha(this.a.mClose, 0.5f);
                        return false;
                    }
                    return invokeLL.booleanValue;
                }
            });
            this.mTitleCenterText = (TextView) findViewById(ResUtils.id(getContext(), "title_center_text"));
            this.o = findViewById(ResUtils.id(getContext(), "title_center_safe_layout"));
            this.p = (TextView) findViewById(ResUtils.id(getContext(), "title_center_safe_tip"));
            this.q = (ImageView) findViewById(ResUtils.id(getContext(), "safe_icon"));
            this.f50561j = findViewById(ResUtils.id(getContext(), "title_right_imgzone1"));
            this.k = (NetImageView) findViewById(ResUtils.id(getContext(), "title_right_imgzone2_img1"));
            this.l = findViewById(ResUtils.id(getContext(), "title_right_imgzone2"));
            this.m = (NetImageView) findViewById(ResUtils.id(getContext(), "title_right_imgzone2_img"));
            this.n = (TextView) findViewById(ResUtils.id(getContext(), "title_right_imgzone2_notify"));
            this.t = findViewById(ResUtils.id(getContext(), "title_right_imgzone2_notify_zone"));
            this.u = (TextView) findViewById(ResUtils.id(getContext(), "title_right_imgzone2_notify1"));
            this.v = (ImageView) findViewById(ResUtils.id(getContext(), "title_right_imgzone2_notify_triangle"));
            if (!TextUtils.isEmpty(this.f50554c)) {
                setTitle(this.f50554c);
            }
            this.r = (ImageView) findViewById(ResUtils.id(getContext(), "title_bottom_seperator"));
        }
    }

    private BdActionBar b(int i2) {
        InterceptResult invokeI;
        Interceptable interceptable = $ic;
        if (interceptable == null || (invokeI = interceptable.invokeI(65542, this, i2)) == null) {
            if (i2 == 0 || 8 == i2) {
                if (this.s.getVisibility() != i2) {
                    a(this.f50558g);
                }
                this.s.setVisibility(i2);
            }
            return this;
        }
        return (BdActionBar) invokeI.objValue;
    }

    public int getActionBarHeight() {
        InterceptResult invokeV;
        Interceptable interceptable = $ic;
        return (interceptable == null || (invokeV = interceptable.invokeV(1048576, this)) == null) ? this.f50555d.getHeight() - this.f50560i.getHeight() : invokeV.intValue;
    }

    public String getLayoutId() {
        InterceptResult invokeV;
        Interceptable interceptable = $ic;
        return (interceptable == null || (invokeV = interceptable.invokeV(Constants.METHOD_GET_CONTACTER_INFO_FOR_SESSION, this)) == null) ? "wallet_base_action_bar" : (String) invokeV.objValue;
    }

    public int getMainTitleViewWidth() {
        InterceptResult invokeV;
        Interceptable interceptable = $ic;
        if (interceptable == null || (invokeV = interceptable.invokeV(Constants.METHOD_SEND_USER_MSG, this)) == null) {
            this.mTitleCenterText.measure(View.MeasureSpec.makeMeasureSpec(0, 0), View.MeasureSpec.makeMeasureSpec(0, 0));
            return this.mTitleCenterText.getMeasuredWidth();
        }
        return invokeV.intValue;
    }

    public View getRightImgZone1ImgView() {
        InterceptResult invokeV;
        Interceptable interceptable = $ic;
        return (interceptable == null || (invokeV = interceptable.invokeV(1048579, this)) == null) ? this.k : (View) invokeV.objValue;
    }

    public View getRightImgZone2ImgView() {
        InterceptResult invokeV;
        Interceptable interceptable = $ic;
        return (interceptable == null || (invokeV = interceptable.invokeV(1048580, this)) == null) ? this.m : (View) invokeV.objValue;
    }

    public View getRightImgZone2NotifyView() {
        InterceptResult invokeV;
        Interceptable interceptable = $ic;
        return (interceptable == null || (invokeV = interceptable.invokeV(1048581, this)) == null) ? this.n : (View) invokeV.objValue;
    }

    public int getRightImgZone2NotifyVisibility() {
        InterceptResult invokeV;
        Interceptable interceptable = $ic;
        return (interceptable == null || (invokeV = interceptable.invokeV(1048582, this)) == null) ? this.n.getVisibility() : invokeV.intValue;
    }

    public View getRightNotifyZone1() {
        InterceptResult invokeV;
        Interceptable interceptable = $ic;
        return (interceptable == null || (invokeV = interceptable.invokeV(1048583, this)) == null) ? this.t : (View) invokeV.objValue;
    }

    public View getRightZone1View() {
        InterceptResult invokeV;
        Interceptable interceptable = $ic;
        return (interceptable == null || (invokeV = interceptable.invokeV(InputDeviceCompat.SOURCE_TOUCHPAD, this)) == null) ? this.f50561j : (View) invokeV.objValue;
    }

    public View getRightZoneView() {
        InterceptResult invokeV;
        Interceptable interceptable = $ic;
        return (interceptable == null || (invokeV = interceptable.invokeV(1048585, this)) == null) ? this.l : (View) invokeV.objValue;
    }

    public int getStatusBarHeight() {
        InterceptResult invokeV;
        Interceptable interceptable = $ic;
        return (interceptable == null || (invokeV = interceptable.invokeV(1048586, this)) == null) ? this.f50560i.getHeight() : invokeV.intValue;
    }

    public String getTitle() {
        InterceptResult invokeV;
        Interceptable interceptable = $ic;
        return (interceptable == null || (invokeV = interceptable.invokeV(1048587, this)) == null) ? this.f50554c : (String) invokeV.objValue;
    }

    public int[] getTitleSizeRange() {
        InterceptResult invokeV;
        Interceptable interceptable = $ic;
        return (interceptable == null || (invokeV = interceptable.invokeV(1048588, this)) == null) ? new int[]{DisplayUtils.dip2px(getContext(), 18.0f), Math.round(this.f50559h.getTextSize())} : (int[]) invokeV.objValue;
    }

    @RequiresApi(api = 11)
    public void hideBubble(boolean z) {
        BubbleForSubMenu bubbleForSubMenu;
        Interceptable interceptable = $ic;
        if ((interceptable == null || interceptable.invokeZ(1048589, this, z) == null) && (bubbleForSubMenu = this.w) != null && bubbleForSubMenu.isShowingBubble()) {
            this.w.hideBubble(z);
        }
    }

    public void hideLeftZone() {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeV(1048590, this) == null) {
            this.mLeftImgZone2.setVisibility(8);
            RelativeLayout.LayoutParams layoutParams = (RelativeLayout.LayoutParams) this.mClose.getLayoutParams();
            layoutParams.width = DisplayUtils.dip2px(getContext(), 50.0f);
            this.mClose.setLayoutParams(layoutParams);
            this.mClose.setPadding(DisplayUtils.dip2px(getContext(), 12.0f), 0, 0, 0);
        }
    }

    public boolean isIconWhite() {
        InterceptResult invokeV;
        Interceptable interceptable = $ic;
        return (interceptable == null || (invokeV = interceptable.invokeV(1048591, this)) == null) ? this.x : invokeV.booleanValue;
    }

    public boolean isLeftZoneImageSelected() {
        InterceptResult invokeV;
        Interceptable interceptable = $ic;
        return (interceptable == null || (invokeV = interceptable.invokeV(1048592, this)) == null) ? this.mLeftImgZone2.isSelected() : invokeV.booleanValue;
    }

    public void resetFullScreenTextColor() {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeV(1048593, this) == null) {
            TextView textView = this.f50557f;
            if (textView != null) {
                textView.setTextColor(ResUtils.getColor(getContext(), "wallet_base_click_text1_color_selector"));
            }
            TextView textView2 = this.f50558g;
            if (textView2 != null) {
                textView2.setTextColor(ResUtils.getColor(getContext(), "wallet_base_click_text1_color_selector"));
            }
            TextView textView3 = this.f50559h;
            if (textView3 != null) {
                textView3.setTextColor(ResUtils.getColor(getContext(), "wallet_base_click_text1_color_selector"));
            }
            TextView textView4 = this.mTitleCenterText;
            if (textView4 != null) {
                textView4.setTextColor(ResUtils.getColor(getContext(), "bd_wallet_black3"));
            }
            TextView textView5 = this.n;
            if (textView5 != null) {
                textView5.setTextColor(ResUtils.getColor(getContext(), "wallet_base_click_text2color_selector"));
            }
            TextView textView6 = this.p;
            if (textView6 != null) {
                textView6.setTextColor(ResUtils.getColor(getContext(), "bd_wallet_text_999999"));
            }
        }
    }

    public void setBottomSeperatorvisible(boolean z) {
        ImageView imageView;
        Interceptable interceptable = $ic;
        if (!(interceptable == null || interceptable.invokeZ(1048594, this, z) == null) || (imageView = this.r) == null) {
            return;
        }
        imageView.setVisibility(z ? 0 : 8);
    }

    public int setCloseButtonVisibility(int i2) {
        InterceptResult invokeI;
        Interceptable interceptable = $ic;
        if (interceptable == null || (invokeI = interceptable.invokeI(1048595, this, i2)) == null) {
            int visibility = this.mClose.getVisibility();
            if (i2 == 0 || 8 == i2 || 4 == i2) {
                this.mClose.setVisibility(i2);
                if (i2 == 0) {
                    this.mTitleCenterText.setMaxEms(ResUtils.getInteger(getContext(), "wallet_base_titlebar_centertext_maxems_1"));
                }
            }
            return visibility;
        }
        return invokeI.intValue;
    }

    public void setCloseOnClickListener(View.OnClickListener onClickListener) {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeL(1048596, this, onClickListener) == null) {
            this.mClose.setOnClickListener(onClickListener);
        }
    }

    public void setFullScreenTextColor(int i2) {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeI(1048597, this, i2) == null) {
            TextView textView = this.f50557f;
            if (textView != null) {
                textView.setTextColor(i2);
            }
            TextView textView2 = this.f50558g;
            if (textView2 != null) {
                textView2.setTextColor(i2);
            }
            TextView textView3 = this.f50559h;
            if (textView3 != null) {
                textView3.setTextColor(i2);
            }
            TextView textView4 = this.mTitleCenterText;
            if (textView4 != null) {
                textView4.setTextColor(i2);
            }
            TextView textView5 = this.n;
            if (textView5 != null) {
                textView5.setTextColor(i2);
            }
            TextView textView6 = this.p;
            if (textView6 != null) {
                textView6.setTextColor(i2);
            }
        }
    }

    public void setIconFlag(boolean z) {
        NetImageView netImageView;
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeZ(1048598, this, z) == null) {
            this.x = z;
            if (z) {
                setLeftZoneImageSrc(ResUtils.drawable(getContext(), "wallet_base_actionbar_white_back_arrow"));
                if (this.m.getVisibility() == 0) {
                    setRightImgZone2Src(ResUtils.drawable(getContext(), "wallet_base_actionbar_white_more"));
                }
                this.s.setImageDrawable(ResUtils.getDrawable(getContext(), "wallet_base_actionbar_clear_white_normal"));
                if (this.k.getVisibility() == 0) {
                    this.k.setColorFilter(-1, PorterDuff.Mode.SRC_IN);
                }
            } else {
                setLeftZoneImageSrc(ResUtils.drawable(getContext(), "wallet_base_actionbar_back_arrow"));
                if (this.m.getVisibility() == 0) {
                    setRightImgZone2Src(ResUtils.drawable(getContext(), "wallet_base_actionbar_more"));
                }
                this.s.setImageDrawable(ResUtils.getDrawable(getContext(), "wallet_base_actionbar_clear_normal"));
                if (this.k.getVisibility() == 0 && (netImageView = this.k) != null && netImageView.getDrawable() != null) {
                    this.k.getDrawable().clearColorFilter();
                }
            }
            setTopStatusWhite(z);
        }
    }

    public void setImgZoneBackgroundResource(int i2) {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeI(1048599, this, i2) == null) {
            this.f50561j.setBackgroundResource(i2);
            this.l.setBackgroundResource(i2);
        }
    }

    public void setLeftImgZone2NotifyText(String str, float f2) {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeLF(1048600, this, str, f2) == null) {
            this.f50557f.setVisibility(8);
            if (f2 < 0.0f) {
                return;
            }
            this.f50557f.setText(str);
            this.f50557f.setTextSize(1, f2);
        }
    }

    public void setLeftImgZone2NotifyTextColor(int i2) {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeI(1048601, this, i2) == null) {
            this.f50557f.setTextColor(i2);
        }
    }

    public void setLeftImgZone2NotifyTextColorStateList(ColorStateList colorStateList) {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeL(1048602, this, colorStateList) == null) {
            this.f50557f.setTextColor(colorStateList);
        }
    }

    public void setLeftZoneImageSelected(boolean z) {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeZ(1048603, this, z) == null) {
        }
    }

    public void setLeftZoneImageSrc(int i2) {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeI(1048604, this, i2) == null) {
            Drawable drawable = i2 != 0 ? getResources().getDrawable(i2) : null;
            if (drawable != null) {
                drawable.setBounds(0, 0, drawable.getMinimumWidth(), drawable.getMinimumHeight());
            }
            this.f50556e.setImageDrawable(drawable);
        }
    }

    public void setLeftZoneOnClickListener(View.OnClickListener onClickListener) {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeL(1048606, this, onClickListener) == null) {
            this.mLeftImgZone2.setOnClickListener(onClickListener);
        }
    }

    public BdActionBar setOnlyIcons(boolean z) {
        InterceptResult invokeZ;
        Interceptable interceptable = $ic;
        if (interceptable == null || (invokeZ = interceptable.invokeZ(1048607, this, z)) == null) {
            return a(z ? 8 : 0);
        }
        return (BdActionBar) invokeZ.objValue;
    }

    public void setRightImgZone1Enable(boolean z) {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeZ(1048608, this, z) == null) {
            this.k.setEnabled(z);
            this.f50561j.setEnabled(z);
        }
    }

    public void setRightImgZone1OnClickListener(View.OnClickListener onClickListener) {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeL(1048609, this, onClickListener) == null) {
            this.f50561j.setOnClickListener(onClickListener);
        }
    }

    public void setRightImgZone1Src(int i2) {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeI(1048610, this, i2) == null) {
            this.f50561j.setVisibility(0);
            this.k.setVisibility(0);
            this.k.setImageResource(i2);
        }
    }

    public void setRightImgZone1Visibility(int i2) {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeI(1048612, this, i2) == null) {
            this.f50561j.setVisibility(i2);
        }
    }

    public void setRightImgZone2Enable(boolean z) {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeZ(1048613, this, z) == null) {
            this.m.setEnabled(z);
            this.l.setEnabled(z);
        }
    }

    public void setRightImgZone2NotifyClickListener(View.OnClickListener onClickListener) {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeL(1048614, this, onClickListener) == null) {
            if (onClickListener != null) {
                this.n.setVisibility(0);
            }
            this.n.setOnClickListener(onClickListener);
        }
    }

    public void setRightImgZone2NotifyText(String str) {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeL(1048615, this, str) == null) {
            if (!TextUtils.isEmpty(str)) {
                setRightImgZone2NotifyVisibility(0);
            }
            this.n.setText(str);
        }
    }

    public void setRightImgZone2NotifyTextBg(int i2) {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeI(1048616, this, i2) == null) {
            this.n.setBackgroundResource(i2);
            this.n.setPadding(12, 6, 12, 6);
        }
    }

    public void setRightImgZone2NotifyTextColor(int i2) {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeI(1048617, this, i2) == null) {
            this.n.setTextColor(i2);
        }
    }

    public void setRightImgZone2NotifyTextSize(float f2) {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeF(1048618, this, f2) == null) {
            this.n.setTextSize(1, f2);
        }
    }

    public void setRightImgZone2NotifyTextViewPadding(int i2, int i3, int i4, int i5) {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeIIII(1048619, this, i2, i3, i4, i5) == null) {
            this.n.setPadding(i2, i3, i4, i5);
        }
    }

    public void setRightImgZone2NotifyVisibility(int i2) {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeI(1048620, this, i2) == null) {
            this.n.setVisibility(i2);
        }
    }

    public void setRightImgZone2OnClickListener(View.OnClickListener onClickListener) {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeL(1048621, this, onClickListener) == null) {
            if (onClickListener != null) {
                this.l.setVisibility(0);
            }
            this.l.setOnClickListener(onClickListener);
        }
    }

    public void setRightImgZone2Src(int i2) {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeI(1048622, this, i2) == null) {
            this.m.setVisibility(0);
            this.m.setImageResource(i2);
        }
    }

    public void setRightImgZone2Visibility(int i2) {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeI(1048625, this, i2) == null) {
            this.l.setVisibility(i2);
        }
    }

    public void setRightNotifyImg(Drawable drawable) {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeL(1048626, this, drawable) == null) {
            this.v.setImageDrawable(drawable);
        }
    }

    public void setRightNotifyText(String str) {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeL(1048627, this, str) == null) {
            this.u.setText(str);
        }
    }

    public void setRightNotifyTextColor(int i2) {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeI(1048628, this, i2) == null) {
            this.u.setTextColor(i2);
        }
    }

    public void setRightNotifyTextSize(int i2) {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeI(1048629, this, i2) == null) {
            this.u.setTextSize(1, i2);
        }
    }

    public void setRightNotifyZone1Bg(Drawable drawable) {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeL(1048630, this, drawable) == null) {
            this.t.setBackgroundDrawable(drawable);
        }
    }

    public void setRightNotifyZone1ClickListener(View.OnClickListener onClickListener) {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeL(1048631, this, onClickListener) == null) {
            this.t.setOnClickListener(onClickListener);
        }
    }

    public void setRightNotifyZone1Visibility(int i2) {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeI(1048632, this, i2) == null) {
            this.t.setVisibility(i2);
        }
    }

    public void setSafeIconVisible(boolean z) {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeZ(1048633, this, z) == null) {
            if (z) {
                this.q.setVisibility(0);
            } else {
                this.q.setVisibility(8);
            }
        }
    }

    public void setTitle(String str) {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeL(1048635, this, str) == null) {
            this.f50554c = str;
            this.mTitleCenterText.setText(str);
            setTitleSize(getTitleSizeRange()[0]);
        }
    }

    public void setTitleCenterSafeTipColor(int i2) {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeI(1048636, this, i2) == null) {
            this.p.setTextColor(i2);
        }
    }

    public void setTitleCenterSafeTipText(String str) {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeL(1048637, this, str) == null) {
            if (TextUtils.isEmpty(str)) {
                this.o.setVisibility(8);
                return;
            }
            this.o.setVisibility(0);
            this.p.setText(str);
        }
    }

    public void setTitleColor(int i2) {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeI(1048638, this, i2) == null) {
            this.mTitleCenterText.setTextColor(i2);
        }
    }

    public void setTitleEllipsize(TextUtils.TruncateAt truncateAt) {
        Interceptable interceptable = $ic;
        if (!(interceptable == null || interceptable.invokeL(1048639, this, truncateAt) == null) || truncateAt == null) {
            return;
        }
        this.mTitleCenterText.setSingleLine();
        this.mTitleCenterText.setEllipsize(truncateAt);
    }

    public void setTitleShadowLayer(float f2, float f3, float f4, int i2) {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeCommon(1048640, this, new Object[]{Float.valueOf(f2), Float.valueOf(f3), Float.valueOf(f4), Integer.valueOf(i2)}) == null) {
            this.mTitleCenterText.setShadowLayer(f2, f3, f4, i2);
        }
    }

    public void setTitleSize(int i2) {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeI(1048641, this, i2) == null) {
            this.mTitleCenterText.setTextSize(0, i2);
        }
    }

    public void setTitleTextColorAlpha(int i2) {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeI(1048642, this, i2) == null) {
            try {
                int currentTextColor = this.mTitleCenterText.getCurrentTextColor();
                this.mTitleCenterText.setTextColor(Color.argb(i2, Color.red(currentTextColor), Color.green(currentTextColor), Color.blue(currentTextColor)));
                int currentTextColor2 = this.p.getCurrentTextColor();
                this.p.setTextColor(Color.argb(i2, Color.red(currentTextColor2), Color.green(currentTextColor2), Color.blue(currentTextColor2)));
            } catch (Throwable unused) {
            }
        }
    }

    public void setTitlebgColor(int i2) {
        View view;
        Interceptable interceptable = $ic;
        if (!(interceptable == null || interceptable.invokeI(1048643, this, i2) == null) || (view = this.f50555d) == null) {
            return;
        }
        view.setBackgroundColor(i2);
    }

    public void setTop(Activity activity) {
        Interceptable interceptable = $ic;
        if (!(interceptable == null || interceptable.invokeL(1048644, this, activity) == null) || Build.VERSION.SDK_INT < 19) {
            return;
        }
        if (activity == null) {
            activity = getContext() instanceof Activity ? (Activity) getContext() : null;
        }
        if (activity == null) {
            return;
        }
        this.f50560i.setLayoutParams(new RelativeLayout.LayoutParams(-1, StatusBarUtils.getStatusBarHeight(activity)));
        ImmersiveStatusBarManager.setTopBar(activity, this.f50560i, true);
    }

    public void setTopStatusWhite(boolean z) {
        View view;
        Interceptable interceptable = $ic;
        if (!(interceptable == null || interceptable.invokeZ(1048645, this, z) == null) || Build.VERSION.SDK_INT < 19) {
            return;
        }
        Activity activity = getContext() instanceof Activity ? (Activity) getContext() : null;
        if (activity == null || (view = this.f50560i) == null) {
            return;
        }
        ImmersiveStatusBarManager.setTopBar(activity, view, !z);
    }

    public void setbackBg(Drawable drawable) {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeL(1048646, this, drawable) == null) {
            this.mLeftImgZone2.setBackgroundDrawable(drawable);
        }
    }

    public void showBubble(String str, boolean z) {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeLZ(1048647, this, str, z) == null) {
            if (this.w == null && !TextUtils.isEmpty(str)) {
                this.w = new BubbleForSubMenu(getContext());
                ((RelativeLayout) findViewById(ResUtils.id(getContext(), "title_bar_content"))).addView(this.w);
            } else {
                LogUtil.d(FileHelper.FILE_CACHE_BUBBLE, "不展示气泡");
            }
            BubbleForSubMenu bubbleForSubMenu = this.w;
            if (bubbleForSubMenu != null) {
                bubbleForSubMenu.showBubble(str, z);
            }
        }
    }

    public void setRightImgZone2Src(int i2, CharSequence charSequence) {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeIL(1048623, this, i2, charSequence) == null) {
            setRightImgZone2Src(i2);
            AccessibilityUtils.setContentDescription(this.m, charSequence);
        }
    }

    public void setLeftZoneImageSrc(Drawable drawable) {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeL(1048605, this, drawable) == null) {
            if (drawable != null) {
                drawable.setBounds(0, 0, drawable.getMinimumWidth(), drawable.getMinimumHeight());
            }
            this.f50556e.setImageDrawable(drawable);
        }
    }

    public void setRightImgZone1Src(String str) {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeL(1048611, this, str) == null) {
            this.f50561j.setVisibility(0);
            this.k.setVisibility(0);
            this.k.setImageUrl(str);
        }
    }

    public void setTitle(int i2) {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeI(1048634, this, i2) == null) {
            setTitle(getResources().getString(i2));
        }
    }

    /* JADX WARN: 'super' call moved to the top of the method (can break code semantics) */
    public BdActionBar(Context context, AttributeSet attributeSet) {
        super(context, attributeSet);
        Interceptable interceptable = $ic;
        if (interceptable != null) {
            InitContext newInitContext = TitanRuntime.newInitContext();
            newInitContext.initArgs = r2;
            Object[] objArr = {context, attributeSet};
            interceptable.invokeUnInit(65537, newInitContext);
            int i2 = newInitContext.flag;
            if ((i2 & 1) != 0) {
                int i3 = i2 & 2;
                Object[] objArr2 = newInitContext.callArgs;
                super((Context) objArr2[0], (AttributeSet) objArr2[1]);
                newInitContext.thisArg = this;
                interceptable.invokeInitBody(65537, newInitContext);
                return;
            }
        }
        this.f50554c = "";
        this.x = false;
        a();
    }

    public void setRightImgZone2Src(String str) {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeL(1048624, this, str) == null) {
            this.m.setVisibility(0);
            this.m.setImageUrl(str);
        }
    }

    /* JADX WARN: 'super' call moved to the top of the method (can break code semantics) */
    public BdActionBar(Context context, AttributeSet attributeSet, int i2) {
        super(context, attributeSet, i2);
        Interceptable interceptable = $ic;
        if (interceptable != null) {
            InitContext newInitContext = TitanRuntime.newInitContext();
            newInitContext.initArgs = r2;
            Object[] objArr = {context, attributeSet, Integer.valueOf(i2)};
            interceptable.invokeUnInit(65538, newInitContext);
            int i3 = newInitContext.flag;
            if ((i3 & 1) != 0) {
                int i4 = i3 & 2;
                Object[] objArr2 = newInitContext.callArgs;
                super((Context) objArr2[0], (AttributeSet) objArr2[1], ((Integer) objArr2[2]).intValue());
                newInitContext.thisArg = this;
                interceptable.invokeInitBody(65538, newInitContext);
                return;
            }
        }
        this.f50554c = "";
        this.x = false;
        a();
    }

    private BdActionBar a(int i2) {
        InterceptResult invokeI;
        Interceptable interceptable = $ic;
        if (interceptable == null || (invokeI = interceptable.invokeI(65539, this, i2)) == null) {
            if (i2 == 0 || 8 == i2) {
                this.f50557f.setVisibility(8);
            }
            return this;
        }
        return (BdActionBar) invokeI.objValue;
    }

    private void a(View view) {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeL(65541, this, view) == null) {
            view.setVisibility(view.getVisibility() == 0 ? 8 : 0);
        }
    }
}
