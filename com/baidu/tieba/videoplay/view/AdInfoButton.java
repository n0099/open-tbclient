package com.baidu.tieba.videoplay.view;

import android.animation.ArgbEvaluator;
import android.animation.ObjectAnimator;
import android.animation.ValueAnimator;
import android.content.Context;
import android.util.AttributeSet;
import android.widget.ImageView;
import android.widget.RelativeLayout;
import b.a.e.e.p.l;
import b.a.q0.s.u.b;
import b.a.q0.s.u.c;
import b.a.r0.b4.d;
import b.a.r0.b4.e;
import b.a.r0.b4.f;
import b.a.r0.b4.i;
import com.baidu.android.imsdk.internal.Constants;
import com.baidu.tbadk.core.elementsMaven.view.EMTextView;
import com.baidu.tbadk.core.util.SkinManager;
import com.baidu.tbadk.core.util.WebPManager;
import com.baidu.titan.sdk.runtime.ClassClinitInterceptable;
import com.baidu.titan.sdk.runtime.ClassClinitInterceptorStorage;
import com.baidu.titan.sdk.runtime.FieldHolder;
import com.baidu.titan.sdk.runtime.InitContext;
import com.baidu.titan.sdk.runtime.InterceptResult;
import com.baidu.titan.sdk.runtime.Interceptable;
import com.baidu.titan.sdk.runtime.TitanRuntime;
import com.qq.e.comm.managers.setting.GlobalSetting;
/* loaded from: classes9.dex */
public class AdInfoButton extends RelativeLayout {
    public static /* synthetic */ Interceptable $ic;
    public transient /* synthetic */ FieldHolder $fh;

    /* renamed from: e  reason: collision with root package name */
    public RelativeLayout f55173e;

    /* renamed from: f  reason: collision with root package name */
    public ImageView f55174f;

    /* renamed from: g  reason: collision with root package name */
    public EMTextView f55175g;

    /* renamed from: h  reason: collision with root package name */
    public AdType f55176h;

    /* renamed from: i  reason: collision with root package name */
    public AdChannel f55177i;

    /* JADX WARN: Failed to restore enum class, 'enum' modifier and super class removed */
    /* loaded from: classes9.dex */
    public static final class AdChannel {
        public static final /* synthetic */ AdChannel[] $VALUES;
        public static /* synthetic */ Interceptable $ic;
        public static final AdChannel CSJ;
        public static final AdChannel GDT;
        public static final AdChannel KS;
        public transient /* synthetic */ FieldHolder $fh;

        static {
            InterceptResult invokeClinit;
            ClassClinitInterceptable classClinitInterceptable = ClassClinitInterceptorStorage.$ic;
            if (classClinitInterceptable != null && (invokeClinit = classClinitInterceptable.invokeClinit(-380699680, "Lcom/baidu/tieba/videoplay/view/AdInfoButton$AdChannel;")) != null) {
                Interceptable interceptable = invokeClinit.interceptor;
                if (interceptable != null) {
                    $ic = interceptable;
                }
                if ((invokeClinit.flags & 1) != 0) {
                    classClinitInterceptable.invokePostClinit(-380699680, "Lcom/baidu/tieba/videoplay/view/AdInfoButton$AdChannel;");
                    return;
                }
            }
            GDT = new AdChannel("GDT", 0);
            KS = new AdChannel(GlobalSetting.KS_SDK_WRAPPER, 1);
            AdChannel adChannel = new AdChannel("CSJ", 2);
            CSJ = adChannel;
            $VALUES = new AdChannel[]{GDT, KS, adChannel};
        }

        public AdChannel(String str, int i2) {
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

        public static AdChannel valueOf(String str) {
            InterceptResult invokeL;
            Interceptable interceptable = $ic;
            return (interceptable == null || (invokeL = interceptable.invokeL(65538, null, str)) == null) ? (AdChannel) Enum.valueOf(AdChannel.class, str) : (AdChannel) invokeL.objValue;
        }

        public static AdChannel[] values() {
            InterceptResult invokeV;
            Interceptable interceptable = $ic;
            return (interceptable == null || (invokeV = interceptable.invokeV(65539, null)) == null) ? (AdChannel[]) $VALUES.clone() : (AdChannel[]) invokeV.objValue;
        }
    }

    /* JADX WARN: Failed to restore enum class, 'enum' modifier and super class removed */
    /* loaded from: classes9.dex */
    public static final class AdType {
        public static final /* synthetic */ AdType[] $VALUES;
        public static /* synthetic */ Interceptable $ic;
        public static final AdType DOWNLOAD;
        public static final AdType INFO;
        public transient /* synthetic */ FieldHolder $fh;

        static {
            InterceptResult invokeClinit;
            ClassClinitInterceptable classClinitInterceptable = ClassClinitInterceptorStorage.$ic;
            if (classClinitInterceptable != null && (invokeClinit = classClinitInterceptable.invokeClinit(695248121, "Lcom/baidu/tieba/videoplay/view/AdInfoButton$AdType;")) != null) {
                Interceptable interceptable = invokeClinit.interceptor;
                if (interceptable != null) {
                    $ic = interceptable;
                }
                if ((invokeClinit.flags & 1) != 0) {
                    classClinitInterceptable.invokePostClinit(695248121, "Lcom/baidu/tieba/videoplay/view/AdInfoButton$AdType;");
                    return;
                }
            }
            DOWNLOAD = new AdType("DOWNLOAD", 0);
            AdType adType = new AdType("INFO", 1);
            INFO = adType;
            $VALUES = new AdType[]{DOWNLOAD, adType};
        }

        public AdType(String str, int i2) {
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

        public static AdType valueOf(String str) {
            InterceptResult invokeL;
            Interceptable interceptable = $ic;
            return (interceptable == null || (invokeL = interceptable.invokeL(65538, null, str)) == null) ? (AdType) Enum.valueOf(AdType.class, str) : (AdType) invokeL.objValue;
        }

        public static AdType[] values() {
            InterceptResult invokeV;
            Interceptable interceptable = $ic;
            return (interceptable == null || (invokeV = interceptable.invokeV(65539, null)) == null) ? (AdType[]) $VALUES.clone() : (AdType[]) invokeV.objValue;
        }
    }

    /* loaded from: classes9.dex */
    public class a implements ValueAnimator.AnimatorUpdateListener {
        public static /* synthetic */ Interceptable $ic;
        public transient /* synthetic */ FieldHolder $fh;

        /* renamed from: e  reason: collision with root package name */
        public final /* synthetic */ AdInfoButton f55178e;

        public a(AdInfoButton adInfoButton) {
            Interceptable interceptable = $ic;
            if (interceptable != null) {
                InitContext newInitContext = TitanRuntime.newInitContext();
                newInitContext.initArgs = r2;
                Object[] objArr = {adInfoButton};
                interceptable.invokeUnInit(65536, newInitContext);
                int i2 = newInitContext.flag;
                if ((i2 & 1) != 0) {
                    int i3 = i2 & 2;
                    newInitContext.thisArg = this;
                    interceptable.invokeInitBody(65536, newInitContext);
                    return;
                }
            }
            this.f55178e = adInfoButton;
        }

        @Override // android.animation.ValueAnimator.AnimatorUpdateListener
        public void onAnimationUpdate(ValueAnimator valueAnimator) {
            Interceptable interceptable = $ic;
            if (interceptable == null || interceptable.invokeL(1048576, this, valueAnimator) == null) {
                int[] iArr = {((Integer) valueAnimator.getAnimatedValue()).intValue()};
                if (this.f55178e.f55173e.getBackground() instanceof b) {
                    ((b) this.f55178e.f55173e.getBackground()).D(iArr);
                    this.f55178e.f55173e.invalidate();
                }
            }
        }
    }

    /* JADX WARN: 'this' call moved to the top of the method (can break code semantics) */
    public AdInfoButton(Context context) {
        this(context, null);
        Interceptable interceptable = $ic;
        if (interceptable != null) {
            InitContext newInitContext = TitanRuntime.newInitContext();
            newInitContext.initArgs = r2;
            Object[] objArr = {context};
            interceptable.invokeUnInit(65536, newInitContext);
            int i2 = newInitContext.flag;
            if ((i2 & 1) != 0) {
                int i3 = i2 & 2;
                Object[] objArr2 = newInitContext.callArgs;
                this((Context) objArr2[0], (AttributeSet) objArr2[1]);
                newInitContext.thisArg = this;
                interceptable.invokeInitBody(65536, newInitContext);
                return;
            }
        }
    }

    public final void b(Context context) {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeL(1048576, this, context) == null) {
            this.f55173e = new RelativeLayout(context);
            RelativeLayout.LayoutParams layoutParams = new RelativeLayout.LayoutParams(-1, l.g(context, d.tbds86));
            layoutParams.bottomMargin = l.g(context, d.M_H_X006);
            this.f55173e.setLayoutParams(layoutParams);
            this.f55173e.setGravity(17);
            RelativeLayout relativeLayout = new RelativeLayout(context);
            relativeLayout.setLayoutParams(new RelativeLayout.LayoutParams(-2, -2));
            ImageView imageView = new ImageView(context);
            this.f55174f = imageView;
            imageView.setId(f.ad_icon);
            int g2 = l.g(context, d.tbds42);
            this.f55174f.setLayoutParams(new RelativeLayout.LayoutParams(g2, g2));
            relativeLayout.addView(this.f55174f);
            this.f55175g = new EMTextView(context);
            RelativeLayout.LayoutParams layoutParams2 = new RelativeLayout.LayoutParams(-2, -2);
            layoutParams2.addRule(1, f.ad_icon);
            layoutParams2.addRule(15);
            layoutParams2.leftMargin = l.g(context, d.M_W_X002);
            this.f55175g.setLayoutParams(layoutParams2);
            relativeLayout.addView(this.f55175g);
            this.f55173e.addView(relativeLayout);
            addView(this.f55173e);
            onChangeSkinType();
        }
    }

    public void onChangeSkinType() {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeV(Constants.METHOD_GET_CONTACTER_INFO_FOR_SESSION, this) == null) {
            if (this.f55177i == AdChannel.CSJ) {
                c d2 = c.d(this.f55173e);
                d2.n(i.J_X05);
                d2.m(0);
                d2.f(b.a.r0.b4.c.CAM_X0614);
            } else {
                c d3 = c.d(this.f55173e);
                d3.n(i.J_X05);
                d3.m(0);
                d3.f(b.a.r0.b4.c.CAM_X0302);
            }
            AdType adType = this.f55176h;
            if (adType == AdType.DOWNLOAD) {
                WebPManager.setPureDrawable(this.f55174f, e.icon_download16, b.a.r0.b4.c.CAM_X0101, WebPManager.ResourceStateType.NORMAL);
            } else if (adType == AdType.INFO) {
                WebPManager.setPureDrawable(this.f55174f, e.icon_link16, b.a.r0.b4.c.CAM_X0101, WebPManager.ResourceStateType.NORMAL);
            }
            c d4 = c.d(this.f55175g);
            d4.z(d.T_X08);
            d4.v(b.a.r0.b4.c.CAM_X0101);
        }
    }

    public void playStressAnimation() {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeV(Constants.METHOD_SEND_USER_MSG, this) == null) {
            ValueAnimator ofInt = ObjectAnimator.ofInt(SkinManager.getColor(b.a.r0.b4.c.CAM_X0614), SkinManager.getColor(b.a.r0.b4.c.CAM_X0302));
            ofInt.setDuration(400L);
            ofInt.setEvaluator(new ArgbEvaluator());
            ofInt.addUpdateListener(new a(this));
            ofInt.start();
        }
    }

    public void setChannel(AdChannel adChannel) {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeL(1048579, this, adChannel) == null) {
            this.f55177i = adChannel;
        }
    }

    public void setText(CharSequence charSequence) {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeL(1048580, this, charSequence) == null) {
            this.f55175g.setText(charSequence);
        }
    }

    public void setType(AdType adType) {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeL(1048581, this, adType) == null) {
            this.f55176h = adType;
        }
    }

    /* JADX WARN: 'this' call moved to the top of the method (can break code semantics) */
    public AdInfoButton(Context context, AttributeSet attributeSet) {
        this(context, attributeSet, 0);
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
                this((Context) objArr2[0], (AttributeSet) objArr2[1], ((Integer) objArr2[2]).intValue());
                newInitContext.thisArg = this;
                interceptable.invokeInitBody(65537, newInitContext);
                return;
            }
        }
    }

    /* JADX WARN: 'super' call moved to the top of the method (can break code semantics) */
    public AdInfoButton(Context context, AttributeSet attributeSet, int i2) {
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
        b(context);
    }
}
