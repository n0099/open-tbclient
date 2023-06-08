package com.baidu.tieba.videoplay.view;

import android.animation.ArgbEvaluator;
import android.animation.ObjectAnimator;
import android.animation.ValueAnimator;
import android.content.Context;
import android.util.AttributeSet;
import android.widget.ImageView;
import android.widget.RelativeLayout;
import com.baidu.android.imsdk.internal.Constants;
import com.baidu.tbadk.core.elementsMaven.view.EMTextView;
import com.baidu.tbadk.core.util.SkinManager;
import com.baidu.tbadk.core.util.WebPManager;
import com.baidu.tieba.R;
import com.baidu.tieba.n75;
import com.baidu.tieba.o75;
import com.baidu.tieba.vi;
import com.baidu.titan.sdk.runtime.ClassClinitInterceptable;
import com.baidu.titan.sdk.runtime.ClassClinitInterceptorStorage;
import com.baidu.titan.sdk.runtime.FieldHolder;
import com.baidu.titan.sdk.runtime.InitContext;
import com.baidu.titan.sdk.runtime.InterceptResult;
import com.baidu.titan.sdk.runtime.Interceptable;
import com.baidu.titan.sdk.runtime.TitanRuntime;
import com.qq.e.comm.managers.setting.GlobalSetting;
/* loaded from: classes8.dex */
public class AdInfoButton extends RelativeLayout {
    public static /* synthetic */ Interceptable $ic;
    public transient /* synthetic */ FieldHolder $fh;
    public RelativeLayout a;
    public ImageView b;
    public EMTextView c;
    public AdType d;
    public AdChannel e;

    /* JADX WARN: Failed to restore enum class, 'enum' modifier and super class removed */
    /* loaded from: classes8.dex */
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

        public AdChannel(String str, int i) {
            Interceptable interceptable = $ic;
            if (interceptable != null) {
                InitContext newInitContext = TitanRuntime.newInitContext();
                newInitContext.initArgs = r2;
                Object[] objArr = {str, Integer.valueOf(i)};
                interceptable.invokeUnInit(65537, newInitContext);
                int i2 = newInitContext.flag;
                if ((i2 & 1) != 0) {
                    int i3 = i2 & 2;
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
            if (interceptable == null || (invokeL = interceptable.invokeL(65538, null, str)) == null) {
                return (AdChannel) Enum.valueOf(AdChannel.class, str);
            }
            return (AdChannel) invokeL.objValue;
        }

        public static AdChannel[] values() {
            InterceptResult invokeV;
            Interceptable interceptable = $ic;
            if (interceptable == null || (invokeV = interceptable.invokeV(65539, null)) == null) {
                return (AdChannel[]) $VALUES.clone();
            }
            return (AdChannel[]) invokeV.objValue;
        }
    }

    /* JADX WARN: Failed to restore enum class, 'enum' modifier and super class removed */
    /* loaded from: classes8.dex */
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

        public AdType(String str, int i) {
            Interceptable interceptable = $ic;
            if (interceptable != null) {
                InitContext newInitContext = TitanRuntime.newInitContext();
                newInitContext.initArgs = r2;
                Object[] objArr = {str, Integer.valueOf(i)};
                interceptable.invokeUnInit(65537, newInitContext);
                int i2 = newInitContext.flag;
                if ((i2 & 1) != 0) {
                    int i3 = i2 & 2;
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
            if (interceptable == null || (invokeL = interceptable.invokeL(65538, null, str)) == null) {
                return (AdType) Enum.valueOf(AdType.class, str);
            }
            return (AdType) invokeL.objValue;
        }

        public static AdType[] values() {
            InterceptResult invokeV;
            Interceptable interceptable = $ic;
            if (interceptable == null || (invokeV = interceptable.invokeV(65539, null)) == null) {
                return (AdType[]) $VALUES.clone();
            }
            return (AdType[]) invokeV.objValue;
        }
    }

    /* loaded from: classes8.dex */
    public class a implements ValueAnimator.AnimatorUpdateListener {
        public static /* synthetic */ Interceptable $ic;
        public transient /* synthetic */ FieldHolder $fh;
        public final /* synthetic */ AdInfoButton a;

        public a(AdInfoButton adInfoButton) {
            Interceptable interceptable = $ic;
            if (interceptable != null) {
                InitContext newInitContext = TitanRuntime.newInitContext();
                newInitContext.initArgs = r2;
                Object[] objArr = {adInfoButton};
                interceptable.invokeUnInit(65536, newInitContext);
                int i = newInitContext.flag;
                if ((i & 1) != 0) {
                    int i2 = i & 2;
                    newInitContext.thisArg = this;
                    interceptable.invokeInitBody(65536, newInitContext);
                    return;
                }
            }
            this.a = adInfoButton;
        }

        @Override // android.animation.ValueAnimator.AnimatorUpdateListener
        public void onAnimationUpdate(ValueAnimator valueAnimator) {
            Interceptable interceptable = $ic;
            if (interceptable == null || interceptable.invokeL(1048576, this, valueAnimator) == null) {
                int[] iArr = {((Integer) valueAnimator.getAnimatedValue()).intValue()};
                if (this.a.a.getBackground() instanceof n75) {
                    ((n75) this.a.a.getBackground()).C(iArr);
                    this.a.a.invalidate();
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
            int i = newInitContext.flag;
            if ((i & 1) != 0) {
                int i2 = i & 2;
                Object[] objArr2 = newInitContext.callArgs;
                this((Context) objArr2[0], (AttributeSet) objArr2[1]);
                newInitContext.thisArg = this;
                interceptable.invokeInitBody(65536, newInitContext);
                return;
            }
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
            int i = newInitContext.flag;
            if ((i & 1) != 0) {
                int i2 = i & 2;
                Object[] objArr2 = newInitContext.callArgs;
                this((Context) objArr2[0], (AttributeSet) objArr2[1], ((Integer) objArr2[2]).intValue());
                newInitContext.thisArg = this;
                interceptable.invokeInitBody(65537, newInitContext);
                return;
            }
        }
    }

    /* JADX WARN: 'super' call moved to the top of the method (can break code semantics) */
    public AdInfoButton(Context context, AttributeSet attributeSet, int i) {
        super(context, attributeSet, i);
        Interceptable interceptable = $ic;
        if (interceptable != null) {
            InitContext newInitContext = TitanRuntime.newInitContext();
            newInitContext.initArgs = r2;
            Object[] objArr = {context, attributeSet, Integer.valueOf(i)};
            interceptable.invokeUnInit(65538, newInitContext);
            int i2 = newInitContext.flag;
            if ((i2 & 1) != 0) {
                int i3 = i2 & 2;
                Object[] objArr2 = newInitContext.callArgs;
                super((Context) objArr2[0], (AttributeSet) objArr2[1], ((Integer) objArr2[2]).intValue());
                newInitContext.thisArg = this;
                interceptable.invokeInitBody(65538, newInitContext);
                return;
            }
        }
        b(context);
    }

    public void setChannel(AdChannel adChannel) {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeL(1048579, this, adChannel) == null) {
            this.e = adChannel;
        }
    }

    public void setText(CharSequence charSequence) {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeL(1048580, this, charSequence) == null) {
            this.c.setText(charSequence);
        }
    }

    public void setType(AdType adType) {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeL(1048581, this, adType) == null) {
            this.d = adType;
        }
    }

    public final void b(Context context) {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeL(1048576, this, context) == null) {
            this.a = new RelativeLayout(context);
            RelativeLayout.LayoutParams layoutParams = new RelativeLayout.LayoutParams(-1, vi.g(context, R.dimen.tbds86));
            layoutParams.bottomMargin = vi.g(context, R.dimen.M_H_X006);
            this.a.setLayoutParams(layoutParams);
            this.a.setGravity(17);
            RelativeLayout relativeLayout = new RelativeLayout(context);
            relativeLayout.setLayoutParams(new RelativeLayout.LayoutParams(-2, -2));
            ImageView imageView = new ImageView(context);
            this.b = imageView;
            imageView.setId(R.id.obfuscated_res_0x7f0900ba);
            int g = vi.g(context, R.dimen.tbds42);
            this.b.setLayoutParams(new RelativeLayout.LayoutParams(g, g));
            relativeLayout.addView(this.b);
            this.c = new EMTextView(context);
            RelativeLayout.LayoutParams layoutParams2 = new RelativeLayout.LayoutParams(-2, -2);
            layoutParams2.addRule(1, R.id.obfuscated_res_0x7f0900ba);
            layoutParams2.addRule(15);
            layoutParams2.leftMargin = vi.g(context, R.dimen.M_W_X002);
            this.c.setLayoutParams(layoutParams2);
            relativeLayout.addView(this.c);
            this.a.addView(relativeLayout);
            addView(this.a);
            c();
        }
    }

    public void c() {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeV(Constants.METHOD_GET_CONTACTER_INFO_FOR_SESSION, this) == null) {
            if (this.e == AdChannel.CSJ) {
                o75 d = o75.d(this.a);
                d.o(R.string.J_X05);
                d.n(0);
                d.f(R.color.CAM_X0614);
            } else {
                o75 d2 = o75.d(this.a);
                d2.o(R.string.J_X05);
                d2.n(0);
                d2.f(R.color.CAM_X0302);
            }
            AdType adType = this.d;
            if (adType == AdType.DOWNLOAD) {
                WebPManager.setPureDrawable(this.b, R.drawable.obfuscated_res_0x7f080884, R.color.CAM_X0101, WebPManager.ResourceStateType.NORMAL);
            } else if (adType == AdType.INFO) {
                WebPManager.setPureDrawable(this.b, R.drawable.obfuscated_res_0x7f080963, R.color.CAM_X0101, WebPManager.ResourceStateType.NORMAL);
            }
            o75 d3 = o75.d(this.c);
            d3.B(R.dimen.T_X08);
            d3.w(R.color.CAM_X0101);
        }
    }

    public void d() {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeV(Constants.METHOD_SEND_USER_MSG, this) == null) {
            ValueAnimator ofInt = ObjectAnimator.ofInt(SkinManager.getColor(R.color.CAM_X0614), SkinManager.getColor(R.color.CAM_X0302));
            ofInt.setDuration(400L);
            ofInt.setEvaluator(new ArgbEvaluator());
            ofInt.addUpdateListener(new a(this));
            ofInt.start();
        }
    }
}
