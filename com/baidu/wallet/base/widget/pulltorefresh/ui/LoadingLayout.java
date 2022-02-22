package com.baidu.wallet.base.widget.pulltorefresh.ui;

import android.annotation.SuppressLint;
import android.content.Context;
import android.content.res.ColorStateList;
import android.content.res.TypedArray;
import android.graphics.Typeface;
import android.graphics.drawable.AnimationDrawable;
import android.graphics.drawable.Drawable;
import android.text.TextUtils;
import android.view.LayoutInflater;
import android.view.View;
import android.view.animation.Interpolator;
import android.view.animation.LinearInterpolator;
import android.widget.FrameLayout;
import android.widget.ImageView;
import android.widget.ProgressBar;
import android.widget.TextView;
import androidx.core.view.InputDeviceCompat;
import com.baidu.android.imsdk.internal.Constants;
import com.baidu.apollon.utils.ResUtils;
import com.baidu.titan.sdk.runtime.ClassClinitInterceptable;
import com.baidu.titan.sdk.runtime.ClassClinitInterceptorStorage;
import com.baidu.titan.sdk.runtime.FieldHolder;
import com.baidu.titan.sdk.runtime.InitContext;
import com.baidu.titan.sdk.runtime.InterceptResult;
import com.baidu.titan.sdk.runtime.Interceptable;
import com.baidu.titan.sdk.runtime.TitanRuntime;
@SuppressLint({"ViewConstructor"})
/* loaded from: classes13.dex */
public abstract class LoadingLayout extends FrameLayout implements ILoadingLayout {
    public static /* synthetic */ Interceptable $ic = null;
    public static final String a = "PullToRefresh-LoadingLayout";

    /* renamed from: b  reason: collision with root package name */
    public static final Interpolator f51075b;
    public transient /* synthetic */ FieldHolder $fh;

    /* renamed from: c  reason: collision with root package name */
    public View f51076c;

    /* renamed from: d  reason: collision with root package name */
    public boolean f51077d;

    /* renamed from: e  reason: collision with root package name */
    public final TextView f51078e;

    /* renamed from: f  reason: collision with root package name */
    public final TextView f51079f;

    /* renamed from: g  reason: collision with root package name */
    public CharSequence f51080g;

    /* renamed from: h  reason: collision with root package name */
    public CharSequence f51081h;

    /* renamed from: i  reason: collision with root package name */
    public CharSequence f51082i;

    /* renamed from: j  reason: collision with root package name */
    public float f51083j;
    public final ImageView mHeaderImage;
    public final ProgressBar mHeaderProgress;
    public final Mode mMode;
    public final Orientation mScrollDirection;

    /* renamed from: com.baidu.wallet.base.widget.pulltorefresh.ui.LoadingLayout$1  reason: invalid class name */
    /* loaded from: classes13.dex */
    public static /* synthetic */ class AnonymousClass1 {
        public static /* synthetic */ Interceptable $ic;
        public static final /* synthetic */ int[] a;

        /* renamed from: b  reason: collision with root package name */
        public static final /* synthetic */ int[] f51084b;
        public transient /* synthetic */ FieldHolder $fh;

        static {
            InterceptResult invokeClinit;
            ClassClinitInterceptable classClinitInterceptable = ClassClinitInterceptorStorage.$ic;
            if (classClinitInterceptable != null && (invokeClinit = classClinitInterceptable.invokeClinit(-1833473414, "Lcom/baidu/wallet/base/widget/pulltorefresh/ui/LoadingLayout$1;")) != null) {
                Interceptable interceptable = invokeClinit.interceptor;
                if (interceptable != null) {
                    $ic = interceptable;
                }
                if ((invokeClinit.flags & 1) != 0) {
                    classClinitInterceptable.invokePostClinit(-1833473414, "Lcom/baidu/wallet/base/widget/pulltorefresh/ui/LoadingLayout$1;");
                    return;
                }
            }
            int[] iArr = new int[Orientation.values().length];
            f51084b = iArr;
            try {
                iArr[Orientation.HORIZONTAL.ordinal()] = 1;
            } catch (NoSuchFieldError unused) {
            }
            try {
                f51084b[Orientation.VERTICAL.ordinal()] = 2;
            } catch (NoSuchFieldError unused2) {
            }
            int[] iArr2 = new int[Mode.values().length];
            a = iArr2;
            try {
                iArr2[Mode.PULL_FROM_END.ordinal()] = 1;
            } catch (NoSuchFieldError unused3) {
            }
            try {
                a[Mode.PULL_FROM_START.ordinal()] = 2;
            } catch (NoSuchFieldError unused4) {
            }
        }
    }

    /* JADX WARN: Failed to restore enum class, 'enum' modifier and super class removed */
    /* loaded from: classes13.dex */
    public static final class Mode {
        public static final /* synthetic */ Mode[] $VALUES;
        public static /* synthetic */ Interceptable $ic;
        public static final Mode BOTH;
        public static final Mode DISABLED;
        public static final Mode MANUAL_REFRESH_ONLY;
        public static Mode PULL_DOWN_TO_REFRESH;
        public static final Mode PULL_FROM_END;
        public static final Mode PULL_FROM_START;
        public static Mode PULL_UP_TO_REFRESH;
        public transient /* synthetic */ FieldHolder $fh;
        public int mIntValue;

        static {
            InterceptResult invokeClinit;
            ClassClinitInterceptable classClinitInterceptable = ClassClinitInterceptorStorage.$ic;
            if (classClinitInterceptable != null && (invokeClinit = classClinitInterceptable.invokeClinit(-1879866232, "Lcom/baidu/wallet/base/widget/pulltorefresh/ui/LoadingLayout$Mode;")) != null) {
                Interceptable interceptable = invokeClinit.interceptor;
                if (interceptable != null) {
                    $ic = interceptable;
                }
                if ((invokeClinit.flags & 1) != 0) {
                    classClinitInterceptable.invokePostClinit(-1879866232, "Lcom/baidu/wallet/base/widget/pulltorefresh/ui/LoadingLayout$Mode;");
                    return;
                }
            }
            DISABLED = new Mode("DISABLED", 0, 0);
            PULL_FROM_START = new Mode("PULL_FROM_START", 1, 1);
            PULL_FROM_END = new Mode("PULL_FROM_END", 2, 2);
            BOTH = new Mode("BOTH", 3, 3);
            Mode mode = new Mode("MANUAL_REFRESH_ONLY", 4, 4);
            MANUAL_REFRESH_ONLY = mode;
            Mode mode2 = PULL_FROM_START;
            Mode mode3 = PULL_FROM_END;
            $VALUES = new Mode[]{DISABLED, mode2, mode3, BOTH, mode};
            PULL_DOWN_TO_REFRESH = mode2;
            PULL_UP_TO_REFRESH = mode3;
        }

        public Mode(String str, int i2, int i3) {
            Interceptable interceptable = $ic;
            if (interceptable != null) {
                InitContext newInitContext = TitanRuntime.newInitContext();
                newInitContext.initArgs = r2;
                Object[] objArr = {str, Integer.valueOf(i2), Integer.valueOf(i3)};
                interceptable.invokeUnInit(65537, newInitContext);
                int i4 = newInitContext.flag;
                if ((i4 & 1) != 0) {
                    int i5 = i4 & 2;
                    Object[] objArr2 = newInitContext.callArgs;
                    String str2 = (String) objArr2[0];
                    ((Integer) objArr2[1]).intValue();
                    newInitContext.thisArg = this;
                    interceptable.invokeInitBody(65537, newInitContext);
                    return;
                }
            }
            this.mIntValue = i3;
        }

        public static Mode getDefault() {
            InterceptResult invokeV;
            Interceptable interceptable = $ic;
            return (interceptable == null || (invokeV = interceptable.invokeV(65538, null)) == null) ? PULL_FROM_START : (Mode) invokeV.objValue;
        }

        public static Mode mapIntToValue(int i2) {
            InterceptResult invokeI;
            Mode[] values;
            Interceptable interceptable = $ic;
            if (interceptable == null || (invokeI = interceptable.invokeI(65539, null, i2)) == null) {
                for (Mode mode : values()) {
                    if (i2 == mode.getIntValue()) {
                        return mode;
                    }
                }
                return getDefault();
            }
            return (Mode) invokeI.objValue;
        }

        public static Mode valueOf(String str) {
            InterceptResult invokeL;
            Interceptable interceptable = $ic;
            return (interceptable == null || (invokeL = interceptable.invokeL(InputDeviceCompat.SOURCE_TRACKBALL, null, str)) == null) ? (Mode) Enum.valueOf(Mode.class, str) : (Mode) invokeL.objValue;
        }

        public static Mode[] values() {
            InterceptResult invokeV;
            Interceptable interceptable = $ic;
            return (interceptable == null || (invokeV = interceptable.invokeV(65541, null)) == null) ? (Mode[]) $VALUES.clone() : (Mode[]) invokeV.objValue;
        }

        public int getIntValue() {
            InterceptResult invokeV;
            Interceptable interceptable = $ic;
            return (interceptable == null || (invokeV = interceptable.invokeV(1048576, this)) == null) ? this.mIntValue : invokeV.intValue;
        }

        public boolean permitsPullToRefresh() {
            InterceptResult invokeV;
            Interceptable interceptable = $ic;
            return (interceptable == null || (invokeV = interceptable.invokeV(Constants.METHOD_GET_CONTACTER_INFO_FOR_SESSION, this)) == null) ? (this == DISABLED || this == MANUAL_REFRESH_ONLY) ? false : true : invokeV.booleanValue;
        }

        public boolean showFooterLoadingLayout() {
            InterceptResult invokeV;
            Interceptable interceptable = $ic;
            return (interceptable == null || (invokeV = interceptable.invokeV(Constants.METHOD_SEND_USER_MSG, this)) == null) ? this == PULL_FROM_END || this == BOTH || this == MANUAL_REFRESH_ONLY : invokeV.booleanValue;
        }

        public boolean showHeaderLoadingLayout() {
            InterceptResult invokeV;
            Interceptable interceptable = $ic;
            return (interceptable == null || (invokeV = interceptable.invokeV(1048579, this)) == null) ? this == PULL_FROM_START || this == BOTH : invokeV.booleanValue;
        }
    }

    /* JADX WARN: Failed to restore enum class, 'enum' modifier and super class removed */
    /* loaded from: classes13.dex */
    public static final class Orientation {
        public static final /* synthetic */ Orientation[] $VALUES;
        public static /* synthetic */ Interceptable $ic;
        public static final Orientation HORIZONTAL;
        public static final Orientation VERTICAL;
        public transient /* synthetic */ FieldHolder $fh;

        static {
            InterceptResult invokeClinit;
            ClassClinitInterceptable classClinitInterceptable = ClassClinitInterceptorStorage.$ic;
            if (classClinitInterceptable != null && (invokeClinit = classClinitInterceptable.invokeClinit(1564039387, "Lcom/baidu/wallet/base/widget/pulltorefresh/ui/LoadingLayout$Orientation;")) != null) {
                Interceptable interceptable = invokeClinit.interceptor;
                if (interceptable != null) {
                    $ic = interceptable;
                }
                if ((invokeClinit.flags & 1) != 0) {
                    classClinitInterceptable.invokePostClinit(1564039387, "Lcom/baidu/wallet/base/widget/pulltorefresh/ui/LoadingLayout$Orientation;");
                    return;
                }
            }
            VERTICAL = new Orientation("VERTICAL", 0);
            Orientation orientation = new Orientation("HORIZONTAL", 1);
            HORIZONTAL = orientation;
            $VALUES = new Orientation[]{VERTICAL, orientation};
        }

        public Orientation(String str, int i2) {
            Interceptable interceptable = $ic;
            if (interceptable != null) {
                InitContext newInitContext = TitanRuntime.newInitContext();
                newInitContext.initArgs = r2;
                Object[] objArr = {str, Integer.valueOf(i2)};
                interceptable.invokeUnInit(65537, newInitContext);
                int i3 = newInitContext.flag;
                if ((i3 & 1) != 0) {
                    int i4 = i3 & 2;
                    Object[] objArr2 = newInitContext.callArgs;
                    String str2 = (String) objArr2[0];
                    ((Integer) objArr2[1]).intValue();
                    newInitContext.thisArg = this;
                    interceptable.invokeInitBody(65537, newInitContext);
                }
            }
        }

        public static Orientation valueOf(String str) {
            InterceptResult invokeL;
            Interceptable interceptable = $ic;
            return (interceptable == null || (invokeL = interceptable.invokeL(65538, null, str)) == null) ? (Orientation) Enum.valueOf(Orientation.class, str) : (Orientation) invokeL.objValue;
        }

        public static Orientation[] values() {
            InterceptResult invokeV;
            Interceptable interceptable = $ic;
            return (interceptable == null || (invokeV = interceptable.invokeV(65539, null)) == null) ? (Orientation[]) $VALUES.clone() : (Orientation[]) invokeV.objValue;
        }
    }

    static {
        InterceptResult invokeClinit;
        ClassClinitInterceptable classClinitInterceptable = ClassClinitInterceptorStorage.$ic;
        if (classClinitInterceptable != null && (invokeClinit = classClinitInterceptable.invokeClinit(-1159448473, "Lcom/baidu/wallet/base/widget/pulltorefresh/ui/LoadingLayout;")) != null) {
            Interceptable interceptable = invokeClinit.interceptor;
            if (interceptable != null) {
                $ic = interceptable;
            }
            if ((invokeClinit.flags & 1) != 0) {
                classClinitInterceptable.invokePostClinit(-1159448473, "Lcom/baidu/wallet/base/widget/pulltorefresh/ui/LoadingLayout;");
                return;
            }
        }
        f51075b = new LinearInterpolator();
    }

    /* JADX WARN: 'super' call moved to the top of the method (can break code semantics) */
    public LoadingLayout(Context context, Mode mode, Orientation orientation, TypedArray typedArray) {
        super(context);
        Interceptable interceptable = $ic;
        if (interceptable != null) {
            InitContext newInitContext = TitanRuntime.newInitContext();
            newInitContext.initArgs = r2;
            Object[] objArr = {context, mode, orientation, typedArray};
            interceptable.invokeUnInit(65537, newInitContext);
            int i2 = newInitContext.flag;
            if ((i2 & 1) != 0) {
                int i3 = i2 & 2;
                super((Context) newInitContext.callArgs[0]);
                newInitContext.thisArg = this;
                interceptable.invokeInitBody(65537, newInitContext);
                return;
            }
        }
        this.mMode = mode;
        this.mScrollDirection = orientation;
        int loadingLayout = getLoadingLayout();
        LayoutInflater.from(context).inflate(loadingLayout <= 0 ? ResUtils.layout(getContext(), "wallet_finance_tab_home_surprise_refresh_bar") : loadingLayout, this);
        this.f51076c = findViewById(ResUtils.id(getContext(), "load_layout"));
        this.f51078e = (TextView) findViewById(ResUtils.id(getContext(), "surprise_text"));
        this.f51079f = (TextView) findViewById(ResUtils.id(getContext(), "pull_to_refresh_text"));
        this.mHeaderProgress = (ProgressBar) findViewById(ResUtils.id(getContext(), "pull_to_refresh_progress"));
        this.mHeaderImage = (ImageView) findViewById(ResUtils.id(getContext(), "pull_to_refresh_image"));
        FrameLayout.LayoutParams layoutParams = (FrameLayout.LayoutParams) this.f51076c.getLayoutParams();
        if (AnonymousClass1.a[mode.ordinal()] != 1) {
            layoutParams.gravity = orientation == Orientation.VERTICAL ? 80 : 5;
            this.f51080g = context.getString(ResUtils.string(getContext(), "wallet_refresh_pull_down"));
            this.f51081h = context.getString(ResUtils.string(getContext(), "wallet_refresh_loading"));
            this.f51082i = context.getString(ResUtils.string(getContext(), "wallet_refresh_release"));
        } else {
            layoutParams.gravity = orientation == Orientation.VERTICAL ? 48 : 3;
            this.f51080g = context.getString(ResUtils.string(getContext(), "wallet_tab_pull_to_refresh_from_bottom_pull_label"));
            this.f51081h = context.getString(ResUtils.string(getContext(), "wallet_tab_pull_to_refresh_from_bottom_refreshing_label"));
            this.f51082i = context.getString(ResUtils.string(getContext(), "wallet_tab_pull_to_refresh_from_bottom_release_label"));
        }
        if (this.f51083j > 0.0f) {
            this.f51076c.getLayoutParams().height = (int) this.f51083j;
        }
        setLoadingDrawable(context.getResources().getDrawable(getDefaultDrawableResId()));
        reset();
    }

    private void setTextAppearance(int i2) {
        TextView textView;
        Interceptable interceptable = $ic;
        if (!(interceptable == null || interceptable.invokeI(65538, this, i2) == null) || (textView = this.f51079f) == null) {
            return;
        }
        textView.setTextAppearance(getContext(), i2);
    }

    private void setTextColor(ColorStateList colorStateList) {
        TextView textView;
        Interceptable interceptable = $ic;
        if (!(interceptable == null || interceptable.invokeL(65539, this, colorStateList) == null) || (textView = this.f51079f) == null) {
            return;
        }
        textView.setTextColor(colorStateList);
    }

    public final int getContentSize() {
        InterceptResult invokeV;
        Interceptable interceptable = $ic;
        if (interceptable == null || (invokeV = interceptable.invokeV(1048576, this)) == null) {
            float f2 = this.f51083j;
            if (f2 > 0.0f) {
                return (int) f2;
            }
            if (AnonymousClass1.f51084b[this.mScrollDirection.ordinal()] != 1) {
                return this.f51076c.getHeight();
            }
            return this.f51076c.getWidth();
        }
        return invokeV.intValue;
    }

    public abstract int getDefaultDrawableResId();

    public abstract int getLoadingLayout();

    public final void hideAllViews() {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeV(1048579, this) == null) {
            if (this.f51079f.getVisibility() == 0) {
                this.f51079f.setVisibility(4);
            }
            if (this.mHeaderProgress.getVisibility() == 0) {
                this.mHeaderProgress.setVisibility(4);
            }
            if (this.mHeaderImage.getVisibility() == 0) {
                this.mHeaderImage.setVisibility(4);
            }
        }
    }

    public abstract void onLoadingDrawableSet(Drawable drawable);

    public final void onPull(float f2) {
        Interceptable interceptable = $ic;
        if (!(interceptable == null || interceptable.invokeF(1048581, this, f2) == null) || this.f51077d) {
            return;
        }
        onPullImpl(f2);
    }

    public abstract void onPullImpl(float f2);

    public final void pullToRefresh() {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeV(1048583, this) == null) {
            TextView textView = this.f51079f;
            if (textView != null) {
                textView.setText(this.f51080g);
            }
            pullToRefreshImpl();
        }
    }

    public abstract void pullToRefreshImpl();

    public final void refreshing() {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeV(1048585, this) == null) {
            TextView textView = this.f51079f;
            if (textView != null) {
                textView.setText(this.f51081h);
            }
            if (this.f51077d) {
                ((AnimationDrawable) this.mHeaderImage.getDrawable()).start();
            } else {
                refreshingImpl();
            }
        }
    }

    public abstract void refreshingImpl();

    public final void releaseToRefresh() {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeV(1048587, this) == null) {
            TextView textView = this.f51079f;
            if (textView != null) {
                textView.setText(this.f51082i);
            }
            releaseToRefreshImpl();
        }
    }

    public abstract void releaseToRefreshImpl();

    public final void reset() {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeV(1048589, this) == null) {
            TextView textView = this.f51079f;
            if (textView != null) {
                textView.setText(this.f51080g);
            }
            this.mHeaderImage.setVisibility(0);
            if (this.f51077d) {
                ((AnimationDrawable) this.mHeaderImage.getDrawable()).stop();
            } else {
                resetImpl();
            }
        }
    }

    public abstract void resetImpl();

    public final void setHeight(int i2) {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeI(1048591, this, i2) == null) {
            getLayoutParams().height = i2;
            requestLayout();
        }
    }

    @Override // com.baidu.wallet.base.widget.pulltorefresh.ui.ILoadingLayout
    public void setLastUpdatedLabel(CharSequence charSequence) {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeL(1048592, this, charSequence) == null) {
        }
    }

    @Override // com.baidu.wallet.base.widget.pulltorefresh.ui.ILoadingLayout
    public final void setLoadingDrawable(Drawable drawable) {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeL(1048593, this, drawable) == null) {
            this.mHeaderImage.setImageDrawable(drawable);
            this.f51077d = drawable instanceof AnimationDrawable;
            onLoadingDrawableSet(drawable);
        }
    }

    @Override // com.baidu.wallet.base.widget.pulltorefresh.ui.ILoadingLayout
    public void setPullLabel(CharSequence charSequence) {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeL(1048594, this, charSequence) == null) {
            this.f51080g = charSequence;
        }
    }

    @Override // com.baidu.wallet.base.widget.pulltorefresh.ui.ILoadingLayout
    public void setRefreshingLabel(CharSequence charSequence) {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeL(1048595, this, charSequence) == null) {
            this.f51081h = charSequence;
        }
    }

    @Override // com.baidu.wallet.base.widget.pulltorefresh.ui.ILoadingLayout
    public void setReleaseLabel(CharSequence charSequence) {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeL(1048596, this, charSequence) == null) {
            this.f51082i = charSequence;
        }
    }

    @Override // com.baidu.wallet.base.widget.pulltorefresh.ui.ILoadingLayout
    public void setTextTypeface(Typeface typeface) {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeL(1048597, this, typeface) == null) {
            this.f51079f.setTypeface(typeface);
        }
    }

    public final void setWidth(int i2) {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeI(1048598, this, i2) == null) {
            getLayoutParams().width = i2;
            requestLayout();
        }
    }

    public final void showInvisibleViews() {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeV(1048599, this) == null) {
            if (4 == this.f51079f.getVisibility()) {
                this.f51079f.setVisibility(0);
            }
            if (4 == this.mHeaderProgress.getVisibility()) {
                this.mHeaderProgress.setVisibility(0);
            }
            if (4 == this.mHeaderImage.getVisibility()) {
                this.mHeaderImage.setVisibility(0);
            }
        }
    }

    public void showSurprise(CharSequence charSequence, String str, int i2) {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeLLI(1048601, this, charSequence, str, i2) == null) {
            if (TextUtils.isEmpty(charSequence) && TextUtils.isEmpty(str)) {
                this.f51078e.setVisibility(8);
                return;
            }
            if (!TextUtils.isEmpty(charSequence)) {
                this.f51078e.setText(charSequence);
            }
            TextUtils.isEmpty(str);
            this.f51078e.setVisibility(0);
        }
    }

    public void showSurpriseText(CharSequence charSequence) {
        Interceptable interceptable = $ic;
        if (!(interceptable == null || interceptable.invokeL(1048602, this, charSequence) == null) || TextUtils.isEmpty(charSequence)) {
            return;
        }
        this.f51078e.setText(charSequence);
        this.f51078e.setVisibility(0);
    }

    public void showSurprise(CharSequence charSequence, int i2) {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeLI(1048600, this, charSequence, i2) == null) {
            if (TextUtils.isEmpty(charSequence) && i2 <= 0) {
                this.f51078e.setVisibility(8);
                return;
            }
            if (!TextUtils.isEmpty(charSequence)) {
                this.f51078e.setText(charSequence);
            }
            this.f51078e.setVisibility(0);
        }
    }
}
