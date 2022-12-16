package com.baidu.tieba.recapp.widget;

import android.animation.ValueAnimator;
import android.annotation.SuppressLint;
import android.content.Context;
import android.graphics.drawable.GradientDrawable;
import android.util.AttributeSet;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.view.animation.Animation;
import android.view.animation.AnimationUtils;
import android.widget.FrameLayout;
import android.widget.TextView;
import androidx.annotation.NonNull;
import androidx.annotation.Nullable;
import androidx.core.view.InputDeviceCompat;
import com.baidu.android.imsdk.internal.Constants;
import com.baidu.tbadk.TbadkApplication;
import com.baidu.tbadk.core.data.AdvertAppInfo;
import com.baidu.tbadk.core.util.SkinManager;
import com.baidu.tieba.R;
import com.baidu.tieba.as5;
import com.baidu.tieba.bs5;
import com.baidu.tieba.dk8;
import com.baidu.tieba.recapp.lego.model.AdCard;
import com.baidu.tieba.recapp.view.AdAppInfoView;
import com.baidu.tieba.rr5;
import com.baidu.tieba.vk8;
import com.baidu.tieba.xj8;
import com.baidu.tieba.xr4;
import com.baidu.tieba.yi;
import com.baidu.tieba.zl7;
import com.baidu.titan.sdk.runtime.ClassClinitInterceptable;
import com.baidu.titan.sdk.runtime.ClassClinitInterceptorStorage;
import com.baidu.titan.sdk.runtime.FieldHolder;
import com.baidu.titan.sdk.runtime.InitContext;
import com.baidu.titan.sdk.runtime.InterceptResult;
import com.baidu.titan.sdk.runtime.Interceptable;
import com.baidu.titan.sdk.runtime.TitanRuntime;
import java.util.ArrayList;
import java.util.List;
/* loaded from: classes6.dex */
public class AdEnhanceButtonView extends FrameLayout {
    public static /* synthetic */ Interceptable $ic;
    public static final int l;
    public static final int m;
    public static final int n;
    public static final int o;
    public static final int p;
    public transient /* synthetic */ FieldHolder $fh;
    public AdAppInfoView a;
    public FrameLayout b;
    public ApkDownloadView c;
    public TextView d;
    public List<g> e;
    public int f;
    public int g;
    public View h;
    public vk8 i;
    public AdvertAppInfo j;
    public AdCard k;

    /* JADX DEBUG: Method merged with bridge method */
    /* renamed from: getRealView */
    public View m53getRealView() {
        InterceptResult invokeV;
        Interceptable interceptable = $ic;
        return (interceptable == null || (invokeV = interceptable.invokeV(1048576, this)) == null) ? this : (View) invokeV.objValue;
    }

    /* loaded from: classes6.dex */
    public class a extends g {
        public static /* synthetic */ Interceptable $ic;
        public transient /* synthetic */ FieldHolder $fh;
        public final /* synthetic */ AdEnhanceButtonView c;

        @Override // com.baidu.tieba.recapp.widget.AdEnhanceButtonView.g
        public void a() {
            Interceptable interceptable = $ic;
            if (interceptable == null || interceptable.invokeV(1048576, this) == null) {
            }
        }

        /* JADX WARN: 'super' call moved to the top of the method (can break code semantics) */
        public a(AdEnhanceButtonView adEnhanceButtonView, long j, long j2) {
            super(j, j2);
            Interceptable interceptable = $ic;
            if (interceptable != null) {
                InitContext newInitContext = TitanRuntime.newInitContext();
                newInitContext.initArgs = r2;
                Object[] objArr = {adEnhanceButtonView, Long.valueOf(j), Long.valueOf(j2)};
                interceptable.invokeUnInit(65536, newInitContext);
                int i = newInitContext.flag;
                if ((i & 1) != 0) {
                    int i2 = i & 2;
                    Object[] objArr2 = newInitContext.callArgs;
                    super(((Long) objArr2[0]).longValue(), ((Long) objArr2[1]).longValue());
                    newInitContext.thisArg = this;
                    interceptable.invokeInitBody(65536, newInitContext);
                    return;
                }
            }
            this.c = adEnhanceButtonView;
        }

        @Override // com.baidu.tieba.recapp.widget.AdEnhanceButtonView.g
        public void b() {
            Interceptable interceptable = $ic;
            if ((interceptable == null || interceptable.invokeV(Constants.METHOD_GET_CONTACTER_INFO_FOR_SESSION, this) == null) && this.c.i != null) {
                this.c.i.c();
            }
        }
    }

    /* loaded from: classes6.dex */
    public class b implements ValueAnimator.AnimatorUpdateListener {
        public static /* synthetic */ Interceptable $ic;
        public transient /* synthetic */ FieldHolder $fh;
        public final /* synthetic */ ViewGroup.MarginLayoutParams a;
        public final /* synthetic */ AdEnhanceButtonView b;

        public b(AdEnhanceButtonView adEnhanceButtonView, ViewGroup.MarginLayoutParams marginLayoutParams) {
            Interceptable interceptable = $ic;
            if (interceptable != null) {
                InitContext newInitContext = TitanRuntime.newInitContext();
                newInitContext.initArgs = r2;
                Object[] objArr = {adEnhanceButtonView, marginLayoutParams};
                interceptable.invokeUnInit(65536, newInitContext);
                int i = newInitContext.flag;
                if ((i & 1) != 0) {
                    int i2 = i & 2;
                    newInitContext.thisArg = this;
                    interceptable.invokeInitBody(65536, newInitContext);
                    return;
                }
            }
            this.b = adEnhanceButtonView;
            this.a = marginLayoutParams;
        }

        @Override // android.animation.ValueAnimator.AnimatorUpdateListener
        public void onAnimationUpdate(ValueAnimator valueAnimator) {
            Interceptable interceptable = $ic;
            if (interceptable == null || interceptable.invokeL(1048576, this, valueAnimator) == null) {
                float animatedFraction = valueAnimator.getAnimatedFraction();
                int i = AdEnhanceButtonView.m;
                if (this.b.k != null && this.b.k.appInfoModel != null) {
                    i += AdEnhanceButtonView.n + AdEnhanceButtonView.o;
                }
                this.a.height = Math.round(i * animatedFraction);
                this.a.topMargin = Math.round(AdEnhanceButtonView.p * animatedFraction);
                this.b.h.requestLayout();
            }
        }
    }

    /* loaded from: classes6.dex */
    public class c extends g {
        public static /* synthetic */ Interceptable $ic;
        public transient /* synthetic */ FieldHolder $fh;
        public final /* synthetic */ ValueAnimator c;
        public final /* synthetic */ Animation d;
        public final /* synthetic */ AdEnhanceButtonView e;

        /* JADX WARN: 'super' call moved to the top of the method (can break code semantics) */
        public c(AdEnhanceButtonView adEnhanceButtonView, long j, long j2, ValueAnimator valueAnimator, Animation animation) {
            super(j, j2);
            Interceptable interceptable = $ic;
            if (interceptable != null) {
                InitContext newInitContext = TitanRuntime.newInitContext();
                newInitContext.initArgs = r3;
                Object[] objArr = {adEnhanceButtonView, Long.valueOf(j), Long.valueOf(j2), valueAnimator, animation};
                interceptable.invokeUnInit(65536, newInitContext);
                int i = newInitContext.flag;
                if ((i & 1) != 0) {
                    int i2 = i & 2;
                    Object[] objArr2 = newInitContext.callArgs;
                    super(((Long) objArr2[0]).longValue(), ((Long) objArr2[1]).longValue());
                    newInitContext.thisArg = this;
                    interceptable.invokeInitBody(65536, newInitContext);
                    return;
                }
            }
            this.e = adEnhanceButtonView;
            this.c = valueAnimator;
            this.d = animation;
        }

        @Override // com.baidu.tieba.recapp.widget.AdEnhanceButtonView.g
        public void a() {
            Interceptable interceptable = $ic;
            if (interceptable == null || interceptable.invokeV(1048576, this) == null) {
                this.c.cancel();
                this.d.cancel();
                this.e.s();
            }
        }

        @Override // com.baidu.tieba.recapp.widget.AdEnhanceButtonView.g
        public void b() {
            Interceptable interceptable = $ic;
            if ((interceptable != null && interceptable.invokeV(Constants.METHOD_GET_CONTACTER_INFO_FOR_SESSION, this) != null) || this.c.isRunning()) {
                return;
            }
            if (this.e.i != null) {
                this.e.i.d();
            }
            this.d.cancel();
            this.c.start();
            this.e.setAnimation(this.d);
            this.e.setVisibility(0);
            this.e.startAnimation(this.d);
        }
    }

    /* loaded from: classes6.dex */
    public class d implements ValueAnimator.AnimatorUpdateListener {
        public static /* synthetic */ Interceptable $ic;
        public transient /* synthetic */ FieldHolder $fh;
        public final /* synthetic */ int a;
        public final /* synthetic */ AdEnhanceButtonView b;

        public d(AdEnhanceButtonView adEnhanceButtonView, int i) {
            Interceptable interceptable = $ic;
            if (interceptable != null) {
                InitContext newInitContext = TitanRuntime.newInitContext();
                newInitContext.initArgs = r2;
                Object[] objArr = {adEnhanceButtonView, Integer.valueOf(i)};
                interceptable.invokeUnInit(65536, newInitContext);
                int i2 = newInitContext.flag;
                if ((i2 & 1) != 0) {
                    int i3 = i2 & 2;
                    newInitContext.thisArg = this;
                    interceptable.invokeInitBody(65536, newInitContext);
                    return;
                }
            }
            this.b = adEnhanceButtonView;
            this.a = i;
        }

        @Override // android.animation.ValueAnimator.AnimatorUpdateListener
        public void onAnimationUpdate(ValueAnimator valueAnimator) {
            Interceptable interceptable = $ic;
            if (interceptable == null || interceptable.invokeL(1048576, this, valueAnimator) == null) {
                float animatedFraction = valueAnimator.getAnimatedFraction();
                View view2 = this.b.q() ? this.b.b : this.b.d;
                if (view2.getBackground() instanceof GradientDrawable) {
                    GradientDrawable gradientDrawable = (GradientDrawable) view2.getBackground();
                    gradientDrawable.setColor(dk8.g(animatedFraction, SkinManager.getColor(R.color.CAM_X0614), this.a));
                    gradientDrawable.setCornerRadius(AdEnhanceButtonView.l);
                }
            }
        }
    }

    /* loaded from: classes6.dex */
    public class e extends g {
        public static /* synthetic */ Interceptable $ic;
        public transient /* synthetic */ FieldHolder $fh;
        public final /* synthetic */ ValueAnimator c;
        public final /* synthetic */ AdEnhanceButtonView d;

        /* JADX WARN: 'super' call moved to the top of the method (can break code semantics) */
        public e(AdEnhanceButtonView adEnhanceButtonView, long j, long j2, ValueAnimator valueAnimator) {
            super(j, j2);
            Interceptable interceptable = $ic;
            if (interceptable != null) {
                InitContext newInitContext = TitanRuntime.newInitContext();
                newInitContext.initArgs = r2;
                Object[] objArr = {adEnhanceButtonView, Long.valueOf(j), Long.valueOf(j2), valueAnimator};
                interceptable.invokeUnInit(65536, newInitContext);
                int i = newInitContext.flag;
                if ((i & 1) != 0) {
                    int i2 = i & 2;
                    Object[] objArr2 = newInitContext.callArgs;
                    super(((Long) objArr2[0]).longValue(), ((Long) objArr2[1]).longValue());
                    newInitContext.thisArg = this;
                    interceptable.invokeInitBody(65536, newInitContext);
                    return;
                }
            }
            this.d = adEnhanceButtonView;
            this.c = valueAnimator;
        }

        @Override // com.baidu.tieba.recapp.widget.AdEnhanceButtonView.g
        public void a() {
            Interceptable interceptable = $ic;
            if (interceptable == null || interceptable.invokeV(1048576, this) == null) {
                this.c.cancel();
            }
        }

        @Override // com.baidu.tieba.recapp.widget.AdEnhanceButtonView.g
        public void b() {
            Interceptable interceptable = $ic;
            if ((interceptable != null && interceptable.invokeV(Constants.METHOD_GET_CONTACTER_INFO_FOR_SESSION, this) != null) || this.c.isRunning()) {
                return;
            }
            if (this.d.i != null) {
                this.d.i.a();
            }
            this.c.start();
        }
    }

    /* loaded from: classes6.dex */
    public class f implements bs5.a {
        public static /* synthetic */ Interceptable $ic;
        public transient /* synthetic */ FieldHolder $fh;
        public final /* synthetic */ AdEnhanceButtonView a;

        public f(AdEnhanceButtonView adEnhanceButtonView) {
            Interceptable interceptable = $ic;
            if (interceptable != null) {
                InitContext newInitContext = TitanRuntime.newInitContext();
                newInitContext.initArgs = r2;
                Object[] objArr = {adEnhanceButtonView};
                interceptable.invokeUnInit(65536, newInitContext);
                int i = newInitContext.flag;
                if ((i & 1) != 0) {
                    int i2 = i & 2;
                    newInitContext.thisArg = this;
                    interceptable.invokeInitBody(65536, newInitContext);
                    return;
                }
            }
            this.a = adEnhanceButtonView;
        }

        @Override // com.baidu.tieba.bs5.a
        public boolean a(View view2) {
            InterceptResult invokeL;
            Interceptable interceptable = $ic;
            if (interceptable == null || (invokeL = interceptable.invokeL(1048576, this, view2)) == null) {
                rr5.a(this.a.k.getButtonCmdScheme());
                zl7.c(this.a.j);
                return false;
            }
            return invokeL.booleanValue;
        }
    }

    /* loaded from: classes6.dex */
    public static abstract class g implements Runnable {
        public static /* synthetic */ Interceptable $ic;
        public transient /* synthetic */ FieldHolder $fh;
        public long a;
        public long b;

        public abstract void a();

        public abstract void b();

        public g(long j, long j2) {
            Interceptable interceptable = $ic;
            if (interceptable != null) {
                InitContext newInitContext = TitanRuntime.newInitContext();
                newInitContext.initArgs = r2;
                Object[] objArr = {Long.valueOf(j), Long.valueOf(j2)};
                interceptable.invokeUnInit(65536, newInitContext);
                int i = newInitContext.flag;
                if ((i & 1) != 0) {
                    int i2 = i & 2;
                    newInitContext.thisArg = this;
                    interceptable.invokeInitBody(65536, newInitContext);
                    return;
                }
            }
            this.a = j;
            this.b = j2;
        }

        @Override // java.lang.Runnable
        public void run() {
            Interceptable interceptable = $ic;
            if (interceptable == null || interceptable.invokeV(Constants.METHOD_SEND_USER_MSG, this) == null) {
                b();
            }
        }
    }

    static {
        InterceptResult invokeClinit;
        ClassClinitInterceptable classClinitInterceptable = ClassClinitInterceptorStorage.$ic;
        if (classClinitInterceptable != null && (invokeClinit = classClinitInterceptable.invokeClinit(1403936756, "Lcom/baidu/tieba/recapp/widget/AdEnhanceButtonView;")) != null) {
            Interceptable interceptable = invokeClinit.interceptor;
            if (interceptable != null) {
                $ic = interceptable;
            }
            if ((invokeClinit.flags & 1) != 0) {
                classClinitInterceptable.invokePostClinit(1403936756, "Lcom/baidu/tieba/recapp/widget/AdEnhanceButtonView;");
                return;
            }
        }
        l = yi.g(TbadkApplication.getInst().getContext(), R.dimen.tbds21);
        m = yi.g(TbadkApplication.getInst().getContext(), R.dimen.tbds86);
        n = yi.g(TbadkApplication.getInst().getContext(), R.dimen.tbds102);
        o = yi.g(TbadkApplication.getInst().getContext(), R.dimen.M_H_X002);
        p = yi.g(TbadkApplication.getInst().getContext(), R.dimen.M_H_X004);
    }

    /* JADX WARN: 'this' call moved to the top of the method (can break code semantics) */
    public AdEnhanceButtonView(Context context, AttributeSet attributeSet) {
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
    public AdEnhanceButtonView(Context context, AttributeSet attributeSet, int i) {
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
        this.f = 0;
        this.g = 0;
        this.i = null;
        j(context);
    }

    /* JADX WARN: 'this' call moved to the top of the method (can break code semantics) */
    public AdEnhanceButtonView(@NonNull Context context, @NonNull ViewGroup viewGroup, @NonNull View view2) {
        this(context, null);
        Interceptable interceptable = $ic;
        if (interceptable != null) {
            InitContext newInitContext = TitanRuntime.newInitContext();
            newInitContext.initArgs = r2;
            Object[] objArr = {context, viewGroup, view2};
            interceptable.invokeUnInit(65539, newInitContext);
            int i = newInitContext.flag;
            if ((i & 1) != 0) {
                int i2 = i & 2;
                Object[] objArr2 = newInitContext.callArgs;
                this((Context) objArr2[0], (AttributeSet) objArr2[1]);
                newInitContext.thisArg = this;
                interceptable.invokeInitBody(65539, newInitContext);
                return;
            }
        }
        setContainer(viewGroup);
        setBtnPlaceholder(view2);
    }

    public void setBtnPlaceholder(View view2) {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeL(1048589, this, view2) == null) {
            this.h = view2;
            s();
        }
    }

    public void setContainer(@NonNull ViewGroup viewGroup) {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeL(1048590, this, viewGroup) == null) {
            View view2 = (View) getParent();
            if (view2 instanceof ViewGroup) {
                ((ViewGroup) view2).removeView(this);
            }
            viewGroup.addView(this);
        }
    }

    private int getBtnFinalColor() {
        InterceptResult invokeV;
        Interceptable interceptable = $ic;
        if (interceptable == null || (invokeV = interceptable.invokeV(65547, this)) == null) {
            return dk8.h(this.k.enhanceModel.a, SkinManager.getColor(R.color.CAM_X0302));
        }
        return invokeV.intValue;
    }

    @Nullable
    public final boolean q() {
        InterceptResult invokeV;
        Interceptable interceptable = $ic;
        if (interceptable == null || (invokeV = interceptable.invokeV(1048586, this)) == null) {
            AdvertAppInfo advertAppInfo = this.j;
            if (advertAppInfo == null) {
                return false;
            }
            return advertAppInfo.g();
        }
        return invokeV.booleanValue;
    }

    public void r() {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeV(1048587, this) == null) {
            List<g> list = this.e;
            if (list != null) {
                for (g gVar : list) {
                    gVar.a();
                }
            }
            this.f = 0;
            this.g = 0;
        }
    }

    public void i(@NonNull AdvertAppInfo advertAppInfo) {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeL(Constants.METHOD_SEND_USER_MSG, this, advertAppInfo) == null) {
            this.j = advertAppInfo;
            AdvertAppInfo.ILegoAdvert iLegoAdvert = advertAppInfo.h;
            if (!(iLegoAdvert instanceof AdCard)) {
                return;
            }
            AdCard adCard = (AdCard) iLegoAdvert;
            this.k = adCard;
            if (adCard.enhanceModel == null) {
                setVisibility(8);
                return;
            }
            setVisibility(0);
            xr4 xr4Var = this.k.appInfoModel;
            if (xr4Var != null) {
                this.a.setAppInfo(xr4Var);
                this.a.setVisibility(0);
            }
            String str = this.k.operate.a;
            if (q()) {
                o();
                this.d.setVisibility(8);
                this.b.setVisibility(0);
                this.c.setInitText(str);
            } else {
                this.d.setText(str);
                this.d.setVisibility(0);
                this.b.setVisibility(8);
            }
            l(true);
            k(this.k.enhanceModel);
        }
    }

    public final void j(Context context) {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeL(1048579, this, context) == null) {
            LayoutInflater.from(context).inflate(R.layout.obfuscated_res_0x7f0d0069, this);
            this.a = (AdAppInfoView) findViewById(R.id.app_info);
            this.b = (FrameLayout) findViewById(R.id.obfuscated_res_0x7f090864);
            this.c = (ApkDownloadView) findViewById(R.id.download_btn);
            this.d = (TextView) findViewById(R.id.common_btn_text);
            this.a.setTextSize(R.dimen.T_X08);
            this.a.setTextColor(R.color.CAM_X0620);
            this.c.setTextColorInitSkin(R.color.CAM_X0101);
            this.c.setTextColor(SkinManager.getColor(R.color.CAM_X0101));
            this.c.setTextSize(R.dimen.T_X08);
            this.c.setForegroundSkin(R.color.black_alpha15);
            this.c.setBackgroundSkin(R.drawable.obfuscated_res_0x7f0812e9);
            this.c.setRatio(0);
            this.c.c();
        }
    }

    public final void m(@NonNull xj8.a aVar) {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeL(1048582, this, aVar) == null) {
            s();
            if (aVar.c <= 0) {
                return;
            }
            ValueAnimator duration = ValueAnimator.ofFloat(0.0f, 1.0f).setDuration(aVar.c);
            ViewGroup.LayoutParams layoutParams = this.h.getLayoutParams();
            View view2 = this.h;
            if (view2 != null && (layoutParams instanceof ViewGroup.MarginLayoutParams)) {
                ViewGroup.MarginLayoutParams marginLayoutParams = (ViewGroup.MarginLayoutParams) layoutParams;
                marginLayoutParams.height = 0;
                marginLayoutParams.topMargin = 0;
                view2.requestLayout();
                duration.addUpdateListener(new b(this, marginLayoutParams));
            }
            Animation loadAnimation = AnimationUtils.loadAnimation(getContext(), R.anim.obfuscated_res_0x7f01000e);
            loadAnimation.setDuration(aVar.c);
            setVisibility(8);
            this.e.add(new c(this, aVar.b, aVar.c, duration, loadAnimation));
        }
    }

    public final void k(@NonNull xj8 xj8Var) {
        List<xj8.a> list;
        Interceptable interceptable = $ic;
        if ((interceptable == null || interceptable.invokeL(1048580, this, xj8Var) == null) && (list = xj8Var.b) != null && list.size() > 0) {
            this.e = new ArrayList();
            for (xj8.a aVar : list) {
                if (aVar != null) {
                    p(aVar);
                }
            }
        }
    }

    @SuppressLint({"NewApi"})
    public final void l(boolean z) {
        int btnFinalColor;
        View view2;
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeZ(1048581, this, z) == null) {
            if (z) {
                btnFinalColor = getResources().getColor(R.color.CAM_X0614);
            } else {
                btnFinalColor = getBtnFinalColor();
            }
            GradientDrawable gradientDrawable = new GradientDrawable();
            gradientDrawable.setColor(btnFinalColor);
            gradientDrawable.setCornerRadius(l);
            if (q()) {
                view2 = this.b;
            } else {
                view2 = this.d;
            }
            view2.setBackground(gradientDrawable);
        }
    }

    public final void p(@NonNull xj8.a aVar) {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeL(1048585, this, aVar) == null) {
            int i = aVar.a;
            if (i != 0) {
                if (i != 1) {
                    if (i != 2) {
                        return;
                    }
                    n(aVar);
                    return;
                }
                m(aVar);
                return;
            }
            this.e.add(new a(this, aVar.b, aVar.c));
        }
    }

    public final void n(@NonNull xj8.a aVar) {
        Interceptable interceptable = $ic;
        if ((interceptable != null && interceptable.invokeL(1048583, this, aVar) != null) || aVar.c <= 0) {
            return;
        }
        l(true);
        ValueAnimator duration = ValueAnimator.ofFloat(1.0f).setDuration(aVar.c);
        duration.addUpdateListener(new d(this, getBtnFinalColor()));
        this.e.add(new e(this, aVar.b, aVar.c, duration));
    }

    public void update(int i) {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeI(1048591, this, i) == null) {
            List<g> list = this.e;
            if (list != null && this.f < list.size()) {
                g gVar = this.e.get(this.f);
                if (i >= this.g) {
                    gVar.b();
                    this.g = (int) (this.g + gVar.b + gVar.a);
                    this.f++;
                    return;
                }
                return;
            }
            vk8 vk8Var = this.i;
            if (vk8Var != null) {
                vk8Var.b();
            }
        }
    }

    public final void o() {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeV(InputDeviceCompat.SOURCE_TOUCHPAD, this) == null) {
            AdCard adCard = this.k;
            if (adCard.downloadInfo == null) {
                return;
            }
            this.c.setInitText(adCard.operate.a);
            this.c.setOnClickInterceptListener(new f(this));
            new as5(this.c, dk8.d(this.k));
        }
    }

    public final void s() {
        View view2;
        Interceptable interceptable = $ic;
        if ((interceptable != null && interceptable.invokeV(1048588, this) != null) || (view2 = this.h) == null) {
            return;
        }
        ViewGroup.LayoutParams layoutParams = view2.getLayoutParams();
        int i = m;
        AdCard adCard = this.k;
        if (adCard != null && adCard.appInfoModel != null) {
            i += n + o;
        }
        layoutParams.height = i;
        if (layoutParams instanceof ViewGroup.MarginLayoutParams) {
            ((ViewGroup.MarginLayoutParams) layoutParams).topMargin = p;
        }
    }
}
