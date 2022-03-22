package com.baidu.tieba.recapp.widget;

import android.animation.ValueAnimator;
import android.annotation.SuppressLint;
import android.content.Context;
import android.graphics.drawable.GradientDrawable;
import android.text.TextUtils;
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
import c.a.d.f.p.n;
import c.a.p0.l3.a0;
import c.a.p0.l3.j0.b.c;
import c.a.p0.x.g.g.b;
import com.baidu.android.imsdk.internal.Constants;
import com.baidu.tbadk.TbadkApplication;
import com.baidu.tbadk.core.data.AdvertAppInfo;
import com.baidu.tbadk.core.util.SkinManager;
import com.baidu.tbadk.download.DownloadData;
import com.baidu.tieba.R;
import com.baidu.tieba.ad.download.AdDownloadData;
import com.baidu.tieba.ad.download.DownloadCacheKey;
import com.baidu.tieba.ad.download.state.DownloadStatus;
import com.baidu.tieba.recapp.lego.model.AdCard;
import com.baidu.tieba.recapp.view.AdAppInfoView;
import com.baidu.titan.sdk.runtime.ClassClinitInterceptable;
import com.baidu.titan.sdk.runtime.ClassClinitInterceptorStorage;
import com.baidu.titan.sdk.runtime.FieldHolder;
import com.baidu.titan.sdk.runtime.InitContext;
import com.baidu.titan.sdk.runtime.InterceptResult;
import com.baidu.titan.sdk.runtime.Interceptable;
import com.baidu.titan.sdk.runtime.TitanRuntime;
import java.util.ArrayList;
import java.util.List;
/* loaded from: classes5.dex */
public class AdEnhanceButtonView extends FrameLayout {
    public static /* synthetic */ Interceptable $ic;
    public static final int n;
    public static final int o;
    public static final int p;
    public static final int q;
    public static final int r;
    public transient /* synthetic */ FieldHolder $fh;
    public AdAppInfoView a;

    /* renamed from: b  reason: collision with root package name */
    public FrameLayout f35810b;

    /* renamed from: c  reason: collision with root package name */
    public ApkDownloadView f35811c;

    /* renamed from: d  reason: collision with root package name */
    public TextView f35812d;

    /* renamed from: e  reason: collision with root package name */
    public List<g> f35813e;

    /* renamed from: f  reason: collision with root package name */
    public int f35814f;

    /* renamed from: g  reason: collision with root package name */
    public int f35815g;

    /* renamed from: h  reason: collision with root package name */
    public View f35816h;
    public c.a.p0.l3.p0.b i;
    public AdvertAppInfo j;
    public AdCard k;
    public DownloadCacheKey l;
    public c.a.p0.x.g.h.d m;

    /* loaded from: classes5.dex */
    public class a extends g {
        public static /* synthetic */ Interceptable $ic;
        public transient /* synthetic */ FieldHolder $fh;

        /* renamed from: c  reason: collision with root package name */
        public final /* synthetic */ AdEnhanceButtonView f35817c;

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
            this.f35817c = adEnhanceButtonView;
        }

        @Override // com.baidu.tieba.recapp.widget.AdEnhanceButtonView.g
        public void a() {
            Interceptable interceptable = $ic;
            if (interceptable == null || interceptable.invokeV(1048576, this) == null) {
            }
        }

        @Override // com.baidu.tieba.recapp.widget.AdEnhanceButtonView.g
        public void b() {
            Interceptable interceptable = $ic;
            if (!(interceptable == null || interceptable.invokeV(Constants.METHOD_GET_CONTACTER_INFO_FOR_SESSION, this) == null) || this.f35817c.i == null) {
                return;
            }
            this.f35817c.i.c();
        }
    }

    /* loaded from: classes5.dex */
    public class b implements ValueAnimator.AnimatorUpdateListener {
        public static /* synthetic */ Interceptable $ic;
        public transient /* synthetic */ FieldHolder $fh;
        public final /* synthetic */ ViewGroup.MarginLayoutParams a;

        /* renamed from: b  reason: collision with root package name */
        public final /* synthetic */ AdEnhanceButtonView f35818b;

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
            this.f35818b = adEnhanceButtonView;
            this.a = marginLayoutParams;
        }

        @Override // android.animation.ValueAnimator.AnimatorUpdateListener
        public void onAnimationUpdate(ValueAnimator valueAnimator) {
            Interceptable interceptable = $ic;
            if (interceptable == null || interceptable.invokeL(1048576, this, valueAnimator) == null) {
                float animatedFraction = valueAnimator.getAnimatedFraction();
                int i = AdEnhanceButtonView.o;
                if (this.f35818b.k != null && this.f35818b.k.appInfoModel != null) {
                    i += AdEnhanceButtonView.p + AdEnhanceButtonView.q;
                }
                this.a.height = Math.round(i * animatedFraction);
                this.a.topMargin = Math.round(AdEnhanceButtonView.r * animatedFraction);
                this.f35818b.f35816h.requestLayout();
            }
        }
    }

    /* loaded from: classes5.dex */
    public class c extends g {
        public static /* synthetic */ Interceptable $ic;
        public transient /* synthetic */ FieldHolder $fh;

        /* renamed from: c  reason: collision with root package name */
        public final /* synthetic */ ValueAnimator f35819c;

        /* renamed from: d  reason: collision with root package name */
        public final /* synthetic */ Animation f35820d;

        /* renamed from: e  reason: collision with root package name */
        public final /* synthetic */ AdEnhanceButtonView f35821e;

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
            this.f35821e = adEnhanceButtonView;
            this.f35819c = valueAnimator;
            this.f35820d = animation;
        }

        @Override // com.baidu.tieba.recapp.widget.AdEnhanceButtonView.g
        public void a() {
            Interceptable interceptable = $ic;
            if (interceptable == null || interceptable.invokeV(1048576, this) == null) {
                this.f35819c.cancel();
                this.f35820d.cancel();
                this.f35821e.v();
            }
        }

        @Override // com.baidu.tieba.recapp.widget.AdEnhanceButtonView.g
        public void b() {
            Interceptable interceptable = $ic;
            if (!(interceptable == null || interceptable.invokeV(Constants.METHOD_GET_CONTACTER_INFO_FOR_SESSION, this) == null) || this.f35819c.isRunning()) {
                return;
            }
            if (this.f35821e.i != null) {
                this.f35821e.i.d();
            }
            this.f35820d.cancel();
            this.f35819c.start();
            this.f35821e.setAnimation(this.f35820d);
            this.f35821e.setVisibility(0);
            this.f35821e.startAnimation(this.f35820d);
        }
    }

    /* loaded from: classes5.dex */
    public class d implements ValueAnimator.AnimatorUpdateListener {
        public static /* synthetic */ Interceptable $ic;
        public transient /* synthetic */ FieldHolder $fh;
        public final /* synthetic */ int a;

        /* renamed from: b  reason: collision with root package name */
        public final /* synthetic */ AdEnhanceButtonView f35822b;

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
            this.f35822b = adEnhanceButtonView;
            this.a = i;
        }

        @Override // android.animation.ValueAnimator.AnimatorUpdateListener
        public void onAnimationUpdate(ValueAnimator valueAnimator) {
            Interceptable interceptable = $ic;
            if (interceptable == null || interceptable.invokeL(1048576, this, valueAnimator) == null) {
                float animatedFraction = valueAnimator.getAnimatedFraction();
                View view = this.f35822b.s() ? this.f35822b.f35810b : this.f35822b.f35812d;
                if (view.getBackground() instanceof GradientDrawable) {
                    GradientDrawable gradientDrawable = (GradientDrawable) view.getBackground();
                    gradientDrawable.setColor(c.a.p0.l3.j0.c.a.f(animatedFraction, SkinManager.getColor(R.color.CAM_X0614), this.a));
                    gradientDrawable.setCornerRadius(AdEnhanceButtonView.n);
                }
            }
        }
    }

    /* loaded from: classes5.dex */
    public class e extends g {
        public static /* synthetic */ Interceptable $ic;
        public transient /* synthetic */ FieldHolder $fh;

        /* renamed from: c  reason: collision with root package name */
        public final /* synthetic */ ValueAnimator f35823c;

        /* renamed from: d  reason: collision with root package name */
        public final /* synthetic */ AdEnhanceButtonView f35824d;

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
            this.f35824d = adEnhanceButtonView;
            this.f35823c = valueAnimator;
        }

        @Override // com.baidu.tieba.recapp.widget.AdEnhanceButtonView.g
        public void a() {
            Interceptable interceptable = $ic;
            if (interceptable == null || interceptable.invokeV(1048576, this) == null) {
                this.f35823c.cancel();
            }
        }

        @Override // com.baidu.tieba.recapp.widget.AdEnhanceButtonView.g
        public void b() {
            Interceptable interceptable = $ic;
            if (!(interceptable == null || interceptable.invokeV(Constants.METHOD_GET_CONTACTER_INFO_FOR_SESSION, this) == null) || this.f35823c.isRunning()) {
                return;
            }
            if (this.f35824d.i != null) {
                this.f35824d.i.a();
            }
            this.f35823c.start();
        }
    }

    /* loaded from: classes5.dex */
    public class f implements b.a {
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

        @Override // c.a.p0.x.g.g.b.a
        public boolean b(View view) {
            InterceptResult invokeL;
            Interceptable interceptable = $ic;
            if (interceptable == null || (invokeL = interceptable.invokeL(1048576, this, view)) == null) {
                c.a.p0.x.a.a(this.a.k.getButtonCmdScheme());
                c.a.p0.b2.o.h.c.h(c.a.p0.b2.o.h.c.e(this.a.j));
                return false;
            }
            return invokeL.booleanValue;
        }
    }

    /* loaded from: classes5.dex */
    public static abstract class g implements Runnable {
        public static /* synthetic */ Interceptable $ic;
        public transient /* synthetic */ FieldHolder $fh;
        public long a;

        /* renamed from: b  reason: collision with root package name */
        public long f35825b;

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
            this.f35825b = j2;
        }

        public abstract void a();

        public abstract void b();

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
        n = n.f(TbadkApplication.getInst().getContext(), R.dimen.tbds21);
        o = n.f(TbadkApplication.getInst().getContext(), R.dimen.tbds86);
        p = n.f(TbadkApplication.getInst().getContext(), R.dimen.tbds102);
        q = n.f(TbadkApplication.getInst().getContext(), R.dimen.M_H_X002);
        r = n.f(TbadkApplication.getInst().getContext(), R.dimen.M_H_X004);
    }

    /* JADX WARN: 'this' call moved to the top of the method (can break code semantics) */
    public AdEnhanceButtonView(@NonNull Context context, @NonNull ViewGroup viewGroup, @NonNull View view) {
        this(context, null);
        Interceptable interceptable = $ic;
        if (interceptable != null) {
            InitContext newInitContext = TitanRuntime.newInitContext();
            newInitContext.initArgs = r2;
            Object[] objArr = {context, viewGroup, view};
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
        setBtnPlaceholder(view);
    }

    private int getBtnFinalColor() {
        InterceptResult invokeV;
        Interceptable interceptable = $ic;
        return (interceptable == null || (invokeV = interceptable.invokeV(65547, this)) == null) ? c.a.p0.l3.j0.c.a.g(this.k.enhanceModel.a, SkinManager.getColor(R.color.CAM_X0302)) : invokeV.intValue;
    }

    /* JADX DEBUG: Method merged with bridge method */
    /* renamed from: getRealView */
    public View m58getRealView() {
        InterceptResult invokeV;
        Interceptable interceptable = $ic;
        return (interceptable == null || (invokeV = interceptable.invokeV(1048576, this)) == null) ? this : (View) invokeV.objValue;
    }

    public void i(@NonNull AdvertAppInfo advertAppInfo) {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeL(Constants.METHOD_SEND_USER_MSG, this, advertAppInfo) == null) {
            this.j = advertAppInfo;
            AdvertAppInfo.ILegoAdvert iLegoAdvert = advertAppInfo.i;
            if (iLegoAdvert instanceof AdCard) {
                AdCard adCard = (AdCard) iLegoAdvert;
                this.k = adCard;
                if (adCard.enhanceModel == null) {
                    setVisibility(8);
                    return;
                }
                setVisibility(0);
                c.a.o0.r.r.c cVar = this.k.appInfoModel;
                if (cVar != null) {
                    this.a.setAppInfo(cVar);
                    this.a.setVisibility(0);
                }
                String str = this.k.operate.f16223b;
                if (s()) {
                    p();
                    q();
                    this.f35812d.setVisibility(8);
                    this.f35810b.setVisibility(0);
                    this.f35811c.setInitText(str);
                } else {
                    this.f35812d.setText(str);
                    this.f35812d.setVisibility(0);
                    this.f35810b.setVisibility(8);
                }
                m(true);
                l(this.k.enhanceModel);
            }
        }
    }

    public void j(DownloadCacheKey downloadCacheKey) {
        Interceptable interceptable = $ic;
        if (!(interceptable == null || interceptable.invokeL(1048579, this, downloadCacheKey) == null) || downloadCacheKey == null) {
            return;
        }
        this.l = downloadCacheKey;
        x();
        this.m = null;
        AdDownloadData b2 = c.a.p0.x.g.e.d().b(downloadCacheKey);
        if (a0.r(b2.getPkgName())) {
            b2.extra().setStatus(DownloadStatus.STATUS_INSTALL_SUCCESS);
        }
        AdCard adCard = this.k;
        if (adCard != null && adCard.getAdvertAppInfo() != null) {
            String str = this.k.getAdvertAppInfo().k;
            b2.setExtInfo(this.k.getAdvertAppInfo().f29821h);
            b2.setDownloadKey(this.k.getDownloadKey());
            b2.setPage(str);
            b2.setDeeplinkUrl(this.k.scheme);
            b2.setCmdScheme(this.k.cmdScheme);
        }
        c.a.p0.x.g.e d2 = c.a.p0.x.g.e.d();
        ApkDownloadView apkDownloadView = this.f35811c;
        c.a.p0.x.g.g.c c2 = d2.c(apkDownloadView, apkDownloadView, b2);
        this.m = new c.a.p0.x.g.h.b(c2);
        if (b2.extra().getPercent() > 0) {
            c2.e(b2);
        }
        t();
        this.f35811c.d(b2.getCurrentState());
    }

    public final void k(Context context) {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeL(1048580, this, context) == null) {
            LayoutInflater.from(context).inflate(R.layout.obfuscated_res_0x7f0d006c, this);
            this.a = (AdAppInfoView) findViewById(R.id.obfuscated_res_0x7f090289);
            this.f35810b = (FrameLayout) findViewById(R.id.obfuscated_res_0x7f090818);
            this.f35811c = (ApkDownloadView) findViewById(R.id.obfuscated_res_0x7f090817);
            this.f35812d = (TextView) findViewById(R.id.obfuscated_res_0x7f09069f);
            this.a.setTextSize(R.dimen.T_X08);
            this.a.setTextColor(R.color.CAM_X0620);
            this.f35811c.setTextColorInitSkin(R.color.CAM_X0101);
            this.f35811c.setTextColor(SkinManager.getColor(R.color.CAM_X0101));
            this.f35811c.setTextSize(R.dimen.T_X08);
            this.f35811c.setForegroundSkin(R.color.black_alpha15);
            this.f35811c.setBackgroundSkin(R.drawable.obfuscated_res_0x7f08122f);
            this.f35811c.setRatio(0);
            this.f35811c.j();
        }
    }

    public final void l(@NonNull c.a.p0.l3.j0.b.c cVar) {
        List<c.a> list;
        Interceptable interceptable = $ic;
        if (!(interceptable == null || interceptable.invokeL(1048581, this, cVar) == null) || (list = cVar.f16228b) == null || list.size() <= 0) {
            return;
        }
        this.f35813e = new ArrayList();
        for (c.a aVar : list) {
            if (aVar != null) {
                r(aVar);
            }
        }
    }

    @SuppressLint({"NewApi"})
    public final void m(boolean z) {
        int btnFinalColor;
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeZ(1048582, this, z) == null) {
            if (z) {
                btnFinalColor = getResources().getColor(R.color.CAM_X0614);
            } else {
                btnFinalColor = getBtnFinalColor();
            }
            GradientDrawable gradientDrawable = new GradientDrawable();
            gradientDrawable.setColor(btnFinalColor);
            gradientDrawable.setCornerRadius(n);
            (s() ? this.f35810b : this.f35812d).setBackground(gradientDrawable);
        }
    }

    public final void n(@NonNull c.a aVar) {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeL(1048583, this, aVar) == null) {
            v();
            if (aVar.f16230c <= 0) {
                return;
            }
            ValueAnimator duration = ValueAnimator.ofFloat(0.0f, 1.0f).setDuration(aVar.f16230c);
            ViewGroup.LayoutParams layoutParams = this.f35816h.getLayoutParams();
            View view = this.f35816h;
            if (view != null && (layoutParams instanceof ViewGroup.MarginLayoutParams)) {
                ViewGroup.MarginLayoutParams marginLayoutParams = (ViewGroup.MarginLayoutParams) layoutParams;
                marginLayoutParams.height = 0;
                marginLayoutParams.topMargin = 0;
                view.requestLayout();
                duration.addUpdateListener(new b(this, marginLayoutParams));
            }
            Animation loadAnimation = AnimationUtils.loadAnimation(getContext(), R.anim.obfuscated_res_0x7f01000e);
            loadAnimation.setDuration(aVar.f16230c);
            setVisibility(8);
            this.f35813e.add(new c(this, aVar.f16229b, aVar.f16230c, duration, loadAnimation));
        }
    }

    public final void o(@NonNull c.a aVar) {
        Interceptable interceptable = $ic;
        if (!(interceptable == null || interceptable.invokeL(InputDeviceCompat.SOURCE_TOUCHPAD, this, aVar) == null) || aVar.f16230c <= 0) {
            return;
        }
        m(true);
        ValueAnimator duration = ValueAnimator.ofFloat(1.0f).setDuration(aVar.f16230c);
        duration.addUpdateListener(new d(this, getBtnFinalColor()));
        this.f35813e.add(new e(this, aVar.f16229b, aVar.f16230c, duration));
    }

    @Override // android.view.ViewGroup, android.view.View
    public void onAttachedToWindow() {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeV(1048585, this) == null) {
            super.onAttachedToWindow();
            t();
        }
    }

    @Override // android.view.ViewGroup, android.view.View
    public void onDetachedFromWindow() {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeV(1048586, this) == null) {
            super.onDetachedFromWindow();
            x();
        }
    }

    public final void p() {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeV(1048587, this) == null) {
            AdCard adCard = this.k;
            if (adCard.downloadInfo == null) {
                return;
            }
            this.f35811c.setInitText(adCard.operate.f16223b);
            AdCard adCard2 = this.k;
            String str = adCard2.downloadInfo.a;
            DownloadData w = w(this.k, adCard2.getPosition());
            if (a0.r(str)) {
                w.setStatus(8);
            } else {
                w.setStatus(this.f35811c.getDownloadStatus());
            }
            this.f35811c.setData(w);
            this.f35811c.setOnClickInterceptListener(new f(this));
        }
    }

    public final void q() {
        DownloadCacheKey i;
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeV(1048588, this) == null) {
            AdCard adCard = this.k;
            String str = adCard.scheme;
            String downloadId = adCard.getDownloadId();
            if (!TextUtils.isEmpty(downloadId)) {
                i = c.a.p0.x.g.e.d().h(downloadId);
            } else {
                i = c.a.p0.x.g.e.d().i(str);
            }
            if (i == null) {
                c.a.p0.l3.j0.b.b bVar = this.k.downloadInfo;
                i = DownloadCacheKey.create(downloadId, bVar.f16226b, bVar.a);
                c.a.p0.x.g.e.d().j(i, null);
            }
            j(i);
        }
    }

    public final void r(@NonNull c.a aVar) {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeL(1048589, this, aVar) == null) {
            int i = aVar.a;
            if (i == 0) {
                this.f35813e.add(new a(this, aVar.f16229b, aVar.f16230c));
            } else if (i == 1) {
                n(aVar);
            } else if (i != 2) {
            } else {
                o(aVar);
            }
        }
    }

    @Nullable
    public final boolean s() {
        InterceptResult invokeV;
        Interceptable interceptable = $ic;
        if (interceptable == null || (invokeV = interceptable.invokeV(1048590, this)) == null) {
            AdvertAppInfo advertAppInfo = this.j;
            if (advertAppInfo == null) {
                return false;
            }
            return advertAppInfo.i();
        }
        return invokeV.booleanValue;
    }

    public void setBtnPlaceholder(View view) {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeL(1048591, this, view) == null) {
            this.f35816h = view;
            v();
        }
    }

    public void setContainer(@NonNull ViewGroup viewGroup) {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeL(1048592, this, viewGroup) == null) {
            View view = (View) getParent();
            if (view instanceof ViewGroup) {
                ((ViewGroup) view).removeView(this);
            }
            viewGroup.addView(this);
        }
    }

    public final void t() {
        Interceptable interceptable = $ic;
        if (!(interceptable == null || interceptable.invokeV(1048593, this) == null) || this.l == null || this.m == null) {
            return;
        }
        c.a.p0.x.g.e.d().j(this.l, this.m);
    }

    public void u() {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeV(1048594, this) == null) {
            List<g> list = this.f35813e;
            if (list != null) {
                for (g gVar : list) {
                    gVar.a();
                }
            }
            this.f35814f = 0;
            this.f35815g = 0;
        }
    }

    public void update(int i) {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeI(1048595, this, i) == null) {
            List<g> list = this.f35813e;
            if (list != null && this.f35814f < list.size()) {
                g gVar = this.f35813e.get(this.f35814f);
                if (i >= this.f35815g) {
                    gVar.b();
                    this.f35815g = (int) (this.f35815g + gVar.f35825b + gVar.a);
                    this.f35814f++;
                    return;
                }
                return;
            }
            c.a.p0.l3.p0.b bVar = this.i;
            if (bVar != null) {
                bVar.b();
            }
        }
    }

    public final void v() {
        View view;
        Interceptable interceptable = $ic;
        if (!(interceptable == null || interceptable.invokeV(1048596, this) == null) || (view = this.f35816h) == null) {
            return;
        }
        ViewGroup.LayoutParams layoutParams = view.getLayoutParams();
        int i = o;
        AdCard adCard = this.k;
        if (adCard != null && adCard.appInfoModel != null) {
            i += p + q;
        }
        layoutParams.height = i;
        if (layoutParams instanceof ViewGroup.MarginLayoutParams) {
            ((ViewGroup.MarginLayoutParams) layoutParams).topMargin = r;
        }
    }

    public DownloadData w(AdCard adCard, int i) {
        InterceptResult invokeLI;
        Interceptable interceptable = $ic;
        if (interceptable == null || (invokeLI = interceptable.invokeLI(1048597, this, adCard, i)) == null) {
            DownloadData downloadData = new DownloadData(adCard.getDownloadId());
            downloadData.setUrl(adCard.downloadInfo.f16226b);
            downloadData.setName(adCard.userName);
            downloadData.setPosition(i);
            downloadData.setNotifyId(c.a.d.f.m.b.e(adCard.adId, 0));
            return downloadData;
        }
        return (DownloadData) invokeLI.objValue;
    }

    public final void x() {
        Interceptable interceptable = $ic;
        if (!(interceptable == null || interceptable.invokeV(1048598, this) == null) || this.l == null || this.m == null) {
            return;
        }
        c.a.p0.x.g.e.d().r(this.l, this.m);
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
        this.f35814f = 0;
        this.f35815g = 0;
        this.i = null;
        this.m = null;
        k(context);
    }
}
