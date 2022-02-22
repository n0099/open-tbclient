package com.baidu.tieba.videoplay.view;

import android.animation.ArgbEvaluator;
import android.animation.ObjectAnimator;
import android.animation.ValueAnimator;
import android.content.Context;
import android.util.AttributeSet;
import android.widget.ImageView;
import android.widget.RelativeLayout;
import c.a.d.f.p.n;
import c.a.t0.s.v.b;
import c.a.t0.s.v.c;
import c.a.u0.p4.d;
import c.a.u0.p4.e;
import c.a.u0.p4.f;
import c.a.u0.p4.i;
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
/* loaded from: classes13.dex */
public class AdInfoButton extends RelativeLayout {
    public static /* synthetic */ Interceptable $ic;
    public transient /* synthetic */ FieldHolder $fh;

    /* renamed from: e  reason: collision with root package name */
    public RelativeLayout f49157e;

    /* renamed from: f  reason: collision with root package name */
    public ImageView f49158f;

    /* renamed from: g  reason: collision with root package name */
    public EMTextView f49159g;

    /* renamed from: h  reason: collision with root package name */
    public AdType f49160h;

    /* renamed from: i  reason: collision with root package name */
    public AdChannel f49161i;

    /* JADX WARN: Failed to restore enum class, 'enum' modifier and super class removed */
    /* loaded from: classes13.dex */
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
    /* loaded from: classes13.dex */
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

    /* loaded from: classes13.dex */
    public class a implements ValueAnimator.AnimatorUpdateListener {
        public static /* synthetic */ Interceptable $ic;
        public transient /* synthetic */ FieldHolder $fh;

        /* renamed from: e  reason: collision with root package name */
        public final /* synthetic */ AdInfoButton f49162e;

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
            this.f49162e = adInfoButton;
        }

        @Override // android.animation.ValueAnimator.AnimatorUpdateListener
        public void onAnimationUpdate(ValueAnimator valueAnimator) {
            Interceptable interceptable = $ic;
            if (interceptable == null || interceptable.invokeL(1048576, this, valueAnimator) == null) {
                int[] iArr = {((Integer) valueAnimator.getAnimatedValue()).intValue()};
                if (this.f49162e.f49157e.getBackground() instanceof b) {
                    ((b) this.f49162e.f49157e.getBackground()).D(iArr);
                    this.f49162e.f49157e.invalidate();
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
            this.f49157e = new RelativeLayout(context);
            RelativeLayout.LayoutParams layoutParams = new RelativeLayout.LayoutParams(-1, n.f(context, d.tbds86));
            layoutParams.bottomMargin = n.f(context, d.M_H_X006);
            this.f49157e.setLayoutParams(layoutParams);
            this.f49157e.setGravity(17);
            RelativeLayout relativeLayout = new RelativeLayout(context);
            relativeLayout.setLayoutParams(new RelativeLayout.LayoutParams(-2, -2));
            ImageView imageView = new ImageView(context);
            this.f49158f = imageView;
            imageView.setId(f.ad_icon);
            int f2 = n.f(context, d.tbds42);
            this.f49158f.setLayoutParams(new RelativeLayout.LayoutParams(f2, f2));
            relativeLayout.addView(this.f49158f);
            this.f49159g = new EMTextView(context);
            RelativeLayout.LayoutParams layoutParams2 = new RelativeLayout.LayoutParams(-2, -2);
            layoutParams2.addRule(1, f.ad_icon);
            layoutParams2.addRule(15);
            layoutParams2.leftMargin = n.f(context, d.M_W_X002);
            this.f49159g.setLayoutParams(layoutParams2);
            relativeLayout.addView(this.f49159g);
            this.f49157e.addView(relativeLayout);
            addView(this.f49157e);
            onChangeSkinType();
        }
    }

    public void onChangeSkinType() {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeV(Constants.METHOD_GET_CONTACTER_INFO_FOR_SESSION, this) == null) {
            if (this.f49161i == AdChannel.CSJ) {
                c d2 = c.d(this.f49157e);
                d2.n(i.J_X05);
                d2.m(0);
                d2.f(c.a.u0.p4.c.CAM_X0614);
            } else {
                c d3 = c.d(this.f49157e);
                d3.n(i.J_X05);
                d3.m(0);
                d3.f(c.a.u0.p4.c.CAM_X0302);
            }
            AdType adType = this.f49160h;
            if (adType == AdType.DOWNLOAD) {
                WebPManager.setPureDrawable(this.f49158f, e.icon_download16, c.a.u0.p4.c.CAM_X0101, WebPManager.ResourceStateType.NORMAL);
            } else if (adType == AdType.INFO) {
                WebPManager.setPureDrawable(this.f49158f, e.icon_link16, c.a.u0.p4.c.CAM_X0101, WebPManager.ResourceStateType.NORMAL);
            }
            c d4 = c.d(this.f49159g);
            d4.z(d.T_X08);
            d4.v(c.a.u0.p4.c.CAM_X0101);
        }
    }

    public void playStressAnimation() {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeV(Constants.METHOD_SEND_USER_MSG, this) == null) {
            ValueAnimator ofInt = ObjectAnimator.ofInt(SkinManager.getColor(c.a.u0.p4.c.CAM_X0614), SkinManager.getColor(c.a.u0.p4.c.CAM_X0302));
            ofInt.setDuration(400L);
            ofInt.setEvaluator(new ArgbEvaluator());
            ofInt.addUpdateListener(new a(this));
            ofInt.start();
        }
    }

    public void setChannel(AdChannel adChannel) {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeL(1048579, this, adChannel) == null) {
            this.f49161i = adChannel;
        }
    }

    public void setText(CharSequence charSequence) {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeL(1048580, this, charSequence) == null) {
            this.f49159g.setText(charSequence);
        }
    }

    public void setType(AdType adType) {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeL(1048581, this, adType) == null) {
            this.f49160h = adType;
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
