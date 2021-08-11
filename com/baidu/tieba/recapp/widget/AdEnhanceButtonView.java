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
import c.a.e.e.p.l;
import c.a.p0.q.d.g.b;
import c.a.p0.x2.i0.b.c;
import c.a.p0.x2.z;
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
/* loaded from: classes7.dex */
public class AdEnhanceButtonView extends FrameLayout {
    public static /* synthetic */ Interceptable $ic;
    public static final int APP_INFO_HEIGHT;
    public static final int BTN_HEIGHT;
    public static final int MARGIN_HEIGHT;
    public static final int MARGIN_TOP;
    public static final int OPERATE_BTN_CORNOR_RADIUS;
    public transient /* synthetic */ FieldHolder $fh;

    /* renamed from: e  reason: collision with root package name */
    public AdAppInfoView f56222e;

    /* renamed from: f  reason: collision with root package name */
    public FrameLayout f56223f;

    /* renamed from: g  reason: collision with root package name */
    public ApkDownloadView f56224g;

    /* renamed from: h  reason: collision with root package name */
    public TextView f56225h;

    /* renamed from: i  reason: collision with root package name */
    public List<g> f56226i;

    /* renamed from: j  reason: collision with root package name */
    public int f56227j;
    public int k;
    public View l;
    public c.a.p0.x2.o0.b m;
    public AdvertAppInfo n;
    public AdCard o;
    public DownloadCacheKey p;
    public c.a.p0.q.d.h.d q;

    /* loaded from: classes7.dex */
    public class a extends g {
        public static /* synthetic */ Interceptable $ic;
        public transient /* synthetic */ FieldHolder $fh;

        /* renamed from: g  reason: collision with root package name */
        public final /* synthetic */ AdEnhanceButtonView f56228g;

        /* JADX WARN: 'super' call moved to the top of the method (can break code semantics) */
        public a(AdEnhanceButtonView adEnhanceButtonView, long j2, long j3) {
            super(j2, j3);
            Interceptable interceptable = $ic;
            if (interceptable != null) {
                InitContext newInitContext = TitanRuntime.newInitContext();
                newInitContext.initArgs = r2;
                Object[] objArr = {adEnhanceButtonView, Long.valueOf(j2), Long.valueOf(j3)};
                interceptable.invokeUnInit(65536, newInitContext);
                int i2 = newInitContext.flag;
                if ((i2 & 1) != 0) {
                    int i3 = i2 & 2;
                    Object[] objArr2 = newInitContext.callArgs;
                    super(((Long) objArr2[0]).longValue(), ((Long) objArr2[1]).longValue());
                    newInitContext.thisArg = this;
                    interceptable.invokeInitBody(65536, newInitContext);
                    return;
                }
            }
            this.f56228g = adEnhanceButtonView;
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
            if (!(interceptable == null || interceptable.invokeV(Constants.METHOD_GET_CONTACTER_INFO_FOR_SESSION, this) == null) || this.f56228g.m == null) {
                return;
            }
            this.f56228g.m.c();
        }
    }

    /* loaded from: classes7.dex */
    public class b implements ValueAnimator.AnimatorUpdateListener {
        public static /* synthetic */ Interceptable $ic;
        public transient /* synthetic */ FieldHolder $fh;

        /* renamed from: e  reason: collision with root package name */
        public final /* synthetic */ ViewGroup.MarginLayoutParams f56229e;

        /* renamed from: f  reason: collision with root package name */
        public final /* synthetic */ AdEnhanceButtonView f56230f;

        public b(AdEnhanceButtonView adEnhanceButtonView, ViewGroup.MarginLayoutParams marginLayoutParams) {
            Interceptable interceptable = $ic;
            if (interceptable != null) {
                InitContext newInitContext = TitanRuntime.newInitContext();
                newInitContext.initArgs = r2;
                Object[] objArr = {adEnhanceButtonView, marginLayoutParams};
                interceptable.invokeUnInit(65536, newInitContext);
                int i2 = newInitContext.flag;
                if ((i2 & 1) != 0) {
                    int i3 = i2 & 2;
                    newInitContext.thisArg = this;
                    interceptable.invokeInitBody(65536, newInitContext);
                    return;
                }
            }
            this.f56230f = adEnhanceButtonView;
            this.f56229e = marginLayoutParams;
        }

        @Override // android.animation.ValueAnimator.AnimatorUpdateListener
        public void onAnimationUpdate(ValueAnimator valueAnimator) {
            Interceptable interceptable = $ic;
            if (interceptable == null || interceptable.invokeL(1048576, this, valueAnimator) == null) {
                float animatedFraction = valueAnimator.getAnimatedFraction();
                int i2 = AdEnhanceButtonView.BTN_HEIGHT;
                if (this.f56230f.o != null && this.f56230f.o.appInfoModel != null) {
                    i2 += AdEnhanceButtonView.APP_INFO_HEIGHT + AdEnhanceButtonView.MARGIN_HEIGHT;
                }
                this.f56229e.height = Math.round(i2 * animatedFraction);
                this.f56229e.topMargin = Math.round(AdEnhanceButtonView.MARGIN_TOP * animatedFraction);
                this.f56230f.l.requestLayout();
            }
        }
    }

    /* loaded from: classes7.dex */
    public class c extends g {
        public static /* synthetic */ Interceptable $ic;
        public transient /* synthetic */ FieldHolder $fh;

        /* renamed from: g  reason: collision with root package name */
        public final /* synthetic */ ValueAnimator f56231g;

        /* renamed from: h  reason: collision with root package name */
        public final /* synthetic */ Animation f56232h;

        /* renamed from: i  reason: collision with root package name */
        public final /* synthetic */ AdEnhanceButtonView f56233i;

        /* JADX WARN: 'super' call moved to the top of the method (can break code semantics) */
        public c(AdEnhanceButtonView adEnhanceButtonView, long j2, long j3, ValueAnimator valueAnimator, Animation animation) {
            super(j2, j3);
            Interceptable interceptable = $ic;
            if (interceptable != null) {
                InitContext newInitContext = TitanRuntime.newInitContext();
                newInitContext.initArgs = r3;
                Object[] objArr = {adEnhanceButtonView, Long.valueOf(j2), Long.valueOf(j3), valueAnimator, animation};
                interceptable.invokeUnInit(65536, newInitContext);
                int i2 = newInitContext.flag;
                if ((i2 & 1) != 0) {
                    int i3 = i2 & 2;
                    Object[] objArr2 = newInitContext.callArgs;
                    super(((Long) objArr2[0]).longValue(), ((Long) objArr2[1]).longValue());
                    newInitContext.thisArg = this;
                    interceptable.invokeInitBody(65536, newInitContext);
                    return;
                }
            }
            this.f56233i = adEnhanceButtonView;
            this.f56231g = valueAnimator;
            this.f56232h = animation;
        }

        @Override // com.baidu.tieba.recapp.widget.AdEnhanceButtonView.g
        public void a() {
            Interceptable interceptable = $ic;
            if (interceptable == null || interceptable.invokeV(1048576, this) == null) {
                this.f56231g.cancel();
                this.f56232h.cancel();
                this.f56233i.s();
            }
        }

        @Override // com.baidu.tieba.recapp.widget.AdEnhanceButtonView.g
        public void b() {
            Interceptable interceptable = $ic;
            if (!(interceptable == null || interceptable.invokeV(Constants.METHOD_GET_CONTACTER_INFO_FOR_SESSION, this) == null) || this.f56231g.isRunning()) {
                return;
            }
            if (this.f56233i.m != null) {
                this.f56233i.m.d();
            }
            this.f56232h.cancel();
            this.f56231g.start();
            this.f56233i.setAnimation(this.f56232h);
            this.f56233i.setVisibility(0);
            this.f56233i.startAnimation(this.f56232h);
        }
    }

    /* loaded from: classes7.dex */
    public class d implements ValueAnimator.AnimatorUpdateListener {
        public static /* synthetic */ Interceptable $ic;
        public transient /* synthetic */ FieldHolder $fh;

        /* renamed from: e  reason: collision with root package name */
        public final /* synthetic */ int f56234e;

        /* renamed from: f  reason: collision with root package name */
        public final /* synthetic */ AdEnhanceButtonView f56235f;

        public d(AdEnhanceButtonView adEnhanceButtonView, int i2) {
            Interceptable interceptable = $ic;
            if (interceptable != null) {
                InitContext newInitContext = TitanRuntime.newInitContext();
                newInitContext.initArgs = r2;
                Object[] objArr = {adEnhanceButtonView, Integer.valueOf(i2)};
                interceptable.invokeUnInit(65536, newInitContext);
                int i3 = newInitContext.flag;
                if ((i3 & 1) != 0) {
                    int i4 = i3 & 2;
                    newInitContext.thisArg = this;
                    interceptable.invokeInitBody(65536, newInitContext);
                    return;
                }
            }
            this.f56235f = adEnhanceButtonView;
            this.f56234e = i2;
        }

        @Override // android.animation.ValueAnimator.AnimatorUpdateListener
        public void onAnimationUpdate(ValueAnimator valueAnimator) {
            Interceptable interceptable = $ic;
            if (interceptable == null || interceptable.invokeL(1048576, this, valueAnimator) == null) {
                float animatedFraction = valueAnimator.getAnimatedFraction();
                View view = this.f56235f.q() ? this.f56235f.f56223f : this.f56235f.f56225h;
                if (view.getBackground() instanceof GradientDrawable) {
                    GradientDrawable gradientDrawable = (GradientDrawable) view.getBackground();
                    gradientDrawable.setColor(c.a.p0.x2.i0.c.a.e(animatedFraction, SkinManager.getColor(R.color.CAM_X0614), this.f56234e));
                    gradientDrawable.setCornerRadius(AdEnhanceButtonView.OPERATE_BTN_CORNOR_RADIUS);
                }
            }
        }
    }

    /* loaded from: classes7.dex */
    public class e extends g {
        public static /* synthetic */ Interceptable $ic;
        public transient /* synthetic */ FieldHolder $fh;

        /* renamed from: g  reason: collision with root package name */
        public final /* synthetic */ ValueAnimator f56236g;

        /* renamed from: h  reason: collision with root package name */
        public final /* synthetic */ AdEnhanceButtonView f56237h;

        /* JADX WARN: 'super' call moved to the top of the method (can break code semantics) */
        public e(AdEnhanceButtonView adEnhanceButtonView, long j2, long j3, ValueAnimator valueAnimator) {
            super(j2, j3);
            Interceptable interceptable = $ic;
            if (interceptable != null) {
                InitContext newInitContext = TitanRuntime.newInitContext();
                newInitContext.initArgs = r2;
                Object[] objArr = {adEnhanceButtonView, Long.valueOf(j2), Long.valueOf(j3), valueAnimator};
                interceptable.invokeUnInit(65536, newInitContext);
                int i2 = newInitContext.flag;
                if ((i2 & 1) != 0) {
                    int i3 = i2 & 2;
                    Object[] objArr2 = newInitContext.callArgs;
                    super(((Long) objArr2[0]).longValue(), ((Long) objArr2[1]).longValue());
                    newInitContext.thisArg = this;
                    interceptable.invokeInitBody(65536, newInitContext);
                    return;
                }
            }
            this.f56237h = adEnhanceButtonView;
            this.f56236g = valueAnimator;
        }

        @Override // com.baidu.tieba.recapp.widget.AdEnhanceButtonView.g
        public void a() {
            Interceptable interceptable = $ic;
            if (interceptable == null || interceptable.invokeV(1048576, this) == null) {
                this.f56236g.cancel();
            }
        }

        @Override // com.baidu.tieba.recapp.widget.AdEnhanceButtonView.g
        public void b() {
            Interceptable interceptable = $ic;
            if (!(interceptable == null || interceptable.invokeV(Constants.METHOD_GET_CONTACTER_INFO_FOR_SESSION, this) == null) || this.f56236g.isRunning()) {
                return;
            }
            if (this.f56237h.m != null) {
                this.f56237h.m.a();
            }
            this.f56236g.start();
        }
    }

    /* loaded from: classes7.dex */
    public class f implements b.a {
        public static /* synthetic */ Interceptable $ic;
        public transient /* synthetic */ FieldHolder $fh;

        /* renamed from: a  reason: collision with root package name */
        public final /* synthetic */ AdEnhanceButtonView f56238a;

        public f(AdEnhanceButtonView adEnhanceButtonView) {
            Interceptable interceptable = $ic;
            if (interceptable != null) {
                InitContext newInitContext = TitanRuntime.newInitContext();
                newInitContext.initArgs = r2;
                Object[] objArr = {adEnhanceButtonView};
                interceptable.invokeUnInit(65536, newInitContext);
                int i2 = newInitContext.flag;
                if ((i2 & 1) != 0) {
                    int i3 = i2 & 2;
                    newInitContext.thisArg = this;
                    interceptable.invokeInitBody(65536, newInitContext);
                    return;
                }
            }
            this.f56238a = adEnhanceButtonView;
        }

        @Override // c.a.p0.q.d.g.b.a
        public boolean onClickIntercept(View view) {
            InterceptResult invokeL;
            Interceptable interceptable = $ic;
            if (interceptable == null || (invokeL = interceptable.invokeL(1048576, this, view)) == null) {
                c.a.p0.o1.o.h.c.h(c.a.p0.o1.o.h.c.e(this.f56238a.n));
                return false;
            }
            return invokeL.booleanValue;
        }
    }

    /* loaded from: classes7.dex */
    public static abstract class g implements Runnable {
        public static /* synthetic */ Interceptable $ic;
        public transient /* synthetic */ FieldHolder $fh;

        /* renamed from: e  reason: collision with root package name */
        public long f56239e;

        /* renamed from: f  reason: collision with root package name */
        public long f56240f;

        public g(long j2, long j3) {
            Interceptable interceptable = $ic;
            if (interceptable != null) {
                InitContext newInitContext = TitanRuntime.newInitContext();
                newInitContext.initArgs = r2;
                Object[] objArr = {Long.valueOf(j2), Long.valueOf(j3)};
                interceptable.invokeUnInit(65536, newInitContext);
                int i2 = newInitContext.flag;
                if ((i2 & 1) != 0) {
                    int i3 = i2 & 2;
                    newInitContext.thisArg = this;
                    interceptable.invokeInitBody(65536, newInitContext);
                    return;
                }
            }
            this.f56239e = j2;
            this.f56240f = j3;
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
        OPERATE_BTN_CORNOR_RADIUS = l.g(TbadkApplication.getInst().getContext(), R.dimen.tbds21);
        BTN_HEIGHT = l.g(TbadkApplication.getInst().getContext(), R.dimen.tbds86);
        APP_INFO_HEIGHT = l.g(TbadkApplication.getInst().getContext(), R.dimen.tbds102);
        MARGIN_HEIGHT = l.g(TbadkApplication.getInst().getContext(), R.dimen.M_H_X002);
        MARGIN_TOP = l.g(TbadkApplication.getInst().getContext(), R.dimen.M_H_X004);
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
            int i2 = newInitContext.flag;
            if ((i2 & 1) != 0) {
                int i3 = i2 & 2;
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
        return (interceptable == null || (invokeV = interceptable.invokeV(65547, this)) == null) ? c.a.p0.x2.i0.c.a.f(this.o.enhanceModel.f28535a, SkinManager.getColor(R.color.CAM_X0302)) : invokeV.intValue;
    }

    public void bindData(@NonNull AdvertAppInfo advertAppInfo) {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeL(1048576, this, advertAppInfo) == null) {
            this.n = advertAppInfo;
            AdvertAppInfo.ILegoAdvert iLegoAdvert = advertAppInfo.b4;
            if (iLegoAdvert instanceof AdCard) {
                AdCard adCard = (AdCard) iLegoAdvert;
                this.o = adCard;
                if (adCard.enhanceModel == null) {
                    setVisibility(8);
                    return;
                }
                setVisibility(0);
                c.a.o0.s.q.c cVar = this.o.appInfoModel;
                if (cVar != null) {
                    this.f56222e.setAppInfo(cVar);
                    this.f56222e.setVisibility(0);
                }
                String str = this.o.operate.f28529b;
                if (q()) {
                    n();
                    o();
                    this.f56225h.setVisibility(8);
                    this.f56223f.setVisibility(0);
                    this.f56224g.setInitText(str);
                } else {
                    this.f56225h.setText(str);
                    this.f56225h.setVisibility(0);
                    this.f56223f.setVisibility(8);
                }
                k(true);
                j(this.o.enhanceModel);
            }
        }
    }

    public void bindDownloadData(DownloadCacheKey downloadCacheKey) {
        Interceptable interceptable = $ic;
        if (!(interceptable == null || interceptable.invokeL(Constants.METHOD_GET_CONTACTER_INFO_FOR_SESSION, this, downloadCacheKey) == null) || downloadCacheKey == null) {
            return;
        }
        this.p = downloadCacheKey;
        u();
        this.q = null;
        AdDownloadData b2 = c.a.p0.q.d.e.c().b(downloadCacheKey);
        if (z.q(b2.getPkgName())) {
            b2.extra().setStatus(DownloadStatus.STATUS_INSTALL_SUCCESS);
        }
        AdCard adCard = this.o;
        if (adCard != null && adCard.getAdvertAppInfo() != null) {
            String str = this.o.getAdvertAppInfo().d4;
            b2.setExtInfo(this.o.getAdvertAppInfo().a4);
            b2.setDownloadKey(this.o.getDownloadKey());
            b2.setPage(str);
            b2.setDeeplinkUrl(this.o.scheme);
        }
        c.a.p0.q.c.b.d.a aVar = new c.a.p0.q.c.b.d.a(this.f56224g, b2);
        this.q = new c.a.p0.q.d.h.b(aVar);
        if (b2.extra().getPercent() > 0) {
            aVar.e(b2);
        }
        r();
        this.f56224g.onStatusChanged(b2.getCurrentState());
    }

    /* JADX DEBUG: Method merged with bridge method */
    /* renamed from: getRealView */
    public View m39getRealView() {
        InterceptResult invokeV;
        Interceptable interceptable = $ic;
        return (interceptable == null || (invokeV = interceptable.invokeV(Constants.METHOD_SEND_USER_MSG, this)) == null) ? this : (View) invokeV.objValue;
    }

    public final void i(Context context) {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeL(1048580, this, context) == null) {
            LayoutInflater.from(context).inflate(R.layout.ad_enhance_button_view, this);
            this.f56222e = (AdAppInfoView) findViewById(R.id.app_info);
            this.f56223f = (FrameLayout) findViewById(R.id.download_btn_background);
            this.f56224g = (ApkDownloadView) findViewById(R.id.download_btn);
            this.f56225h = (TextView) findViewById(R.id.common_btn_text);
            this.f56222e.setTextSize(R.dimen.T_X08);
            this.f56222e.setTextColor(R.color.CAM_X0620);
            this.f56224g.setTextColorInitSkin(R.color.CAM_X0101);
            this.f56224g.setTextColor(SkinManager.getColor(R.color.CAM_X0101));
            this.f56224g.setTextSize(R.dimen.T_X08);
            this.f56224g.setForegroundSkin(R.color.black_alpha15);
            this.f56224g.setBackgroundSkin(R.drawable.video_flow_btn_bg_transparent);
            this.f56224g.setRatio(0);
            this.f56224g.changeSkin();
        }
    }

    public final void j(@NonNull c.a.p0.x2.i0.b.c cVar) {
        List<c.a> list;
        Interceptable interceptable = $ic;
        if (!(interceptable == null || interceptable.invokeL(1048581, this, cVar) == null) || (list = cVar.f28536b) == null || list.size() <= 0) {
            return;
        }
        this.f56226i = new ArrayList();
        for (c.a aVar : list) {
            if (aVar != null) {
                p(aVar);
            }
        }
    }

    @SuppressLint({"NewApi"})
    public final void k(boolean z) {
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
            gradientDrawable.setCornerRadius(OPERATE_BTN_CORNOR_RADIUS);
            (q() ? this.f56223f : this.f56225h).setBackground(gradientDrawable);
        }
    }

    public final void l(@NonNull c.a aVar) {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeL(1048583, this, aVar) == null) {
            s();
            if (aVar.f28539c <= 0) {
                return;
            }
            ValueAnimator duration = ValueAnimator.ofFloat(0.0f, 1.0f).setDuration(aVar.f28539c);
            ViewGroup.LayoutParams layoutParams = this.l.getLayoutParams();
            View view = this.l;
            if (view != null && (layoutParams instanceof ViewGroup.MarginLayoutParams)) {
                ViewGroup.MarginLayoutParams marginLayoutParams = (ViewGroup.MarginLayoutParams) layoutParams;
                marginLayoutParams.height = 0;
                marginLayoutParams.topMargin = 0;
                view.requestLayout();
                duration.addUpdateListener(new b(this, marginLayoutParams));
            }
            Animation loadAnimation = AnimationUtils.loadAnimation(getContext(), R.anim.ad_video_pop_view_fade_in);
            loadAnimation.setDuration(aVar.f28539c);
            setVisibility(8);
            this.f56226i.add(new c(this, aVar.f28538b, aVar.f28539c, duration, loadAnimation));
        }
    }

    public final void m(@NonNull c.a aVar) {
        Interceptable interceptable = $ic;
        if (!(interceptable == null || interceptable.invokeL(InputDeviceCompat.SOURCE_TOUCHPAD, this, aVar) == null) || aVar.f28539c <= 0) {
            return;
        }
        k(true);
        ValueAnimator duration = ValueAnimator.ofFloat(1.0f).setDuration(aVar.f28539c);
        duration.addUpdateListener(new d(this, getBtnFinalColor()));
        this.f56226i.add(new e(this, aVar.f28538b, aVar.f28539c, duration));
    }

    public final void n() {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeV(1048585, this) == null) {
            AdCard adCard = this.o;
            if (adCard.downloadInfo == null) {
                return;
            }
            this.f56224g.setInitText(adCard.operate.f28529b);
            AdCard adCard2 = this.o;
            String str = adCard2.downloadInfo.f28531a;
            DownloadData t = t(this.o, adCard2.getPosition());
            if (z.q(str)) {
                t.setStatus(8);
            } else {
                t.setStatus(this.f56224g.getDownloadStatus());
            }
            this.f56224g.setData(t);
            this.f56224g.setOnClickInterceptListener(new f(this));
        }
    }

    public final void o() {
        DownloadCacheKey h2;
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeV(1048586, this) == null) {
            AdCard adCard = this.o;
            String str = adCard.scheme;
            String downloadId = adCard.getDownloadId();
            if (!TextUtils.isEmpty(downloadId)) {
                h2 = c.a.p0.q.d.e.c().g(downloadId);
            } else {
                h2 = c.a.p0.q.d.e.c().h(str);
            }
            if (h2 == null) {
                c.a.p0.x2.i0.b.b bVar = this.o.downloadInfo;
                h2 = DownloadCacheKey.create(downloadId, bVar.f28532b, bVar.f28531a);
                c.a.p0.q.d.e.c().i(h2, null);
            }
            bindDownloadData(h2);
        }
    }

    @Override // android.view.ViewGroup, android.view.View
    public void onAttachedToWindow() {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeV(1048587, this) == null) {
            super.onAttachedToWindow();
            r();
        }
    }

    public void onChangeSkinType() {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeV(1048588, this) == null) {
        }
    }

    @Override // android.view.ViewGroup, android.view.View
    public void onDetachedFromWindow() {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeV(1048589, this) == null) {
            super.onDetachedFromWindow();
            u();
        }
    }

    public final void p(@NonNull c.a aVar) {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeL(1048590, this, aVar) == null) {
            int i2 = aVar.f28537a;
            if (i2 == 0) {
                this.f56226i.add(new a(this, aVar.f28538b, aVar.f28539c));
            } else if (i2 == 1) {
                l(aVar);
            } else if (i2 != 2) {
            } else {
                m(aVar);
            }
        }
    }

    @Nullable
    public final boolean q() {
        InterceptResult invokeV;
        Interceptable interceptable = $ic;
        if (interceptable == null || (invokeV = interceptable.invokeV(1048591, this)) == null) {
            AdvertAppInfo advertAppInfo = this.n;
            if (advertAppInfo == null) {
                return false;
            }
            return advertAppInfo.F4();
        }
        return invokeV.booleanValue;
    }

    public final void r() {
        Interceptable interceptable = $ic;
        if (!(interceptable == null || interceptable.invokeV(1048592, this) == null) || this.p == null || this.q == null) {
            return;
        }
        c.a.p0.q.d.e.c().i(this.p, this.q);
    }

    public void resetAnim() {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeV(1048593, this) == null) {
            List<g> list = this.f56226i;
            if (list != null) {
                for (g gVar : list) {
                    gVar.a();
                }
            }
            this.f56227j = 0;
            this.k = 0;
        }
    }

    public final void s() {
        View view;
        Interceptable interceptable = $ic;
        if (!(interceptable == null || interceptable.invokeV(1048594, this) == null) || (view = this.l) == null) {
            return;
        }
        ViewGroup.LayoutParams layoutParams = view.getLayoutParams();
        int i2 = BTN_HEIGHT;
        AdCard adCard = this.o;
        if (adCard != null && adCard.appInfoModel != null) {
            i2 += APP_INFO_HEIGHT + MARGIN_HEIGHT;
        }
        layoutParams.height = i2;
        if (layoutParams instanceof ViewGroup.MarginLayoutParams) {
            ((ViewGroup.MarginLayoutParams) layoutParams).topMargin = MARGIN_TOP;
        }
    }

    public void setBtnPlaceholder(View view) {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeL(1048595, this, view) == null) {
            this.l = view;
            s();
        }
    }

    public void setContainer(@NonNull ViewGroup viewGroup) {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeL(1048596, this, viewGroup) == null) {
            View view = (View) getParent();
            if (view instanceof ViewGroup) {
                ((ViewGroup) view).removeView(this);
            }
            viewGroup.addView(this);
        }
    }

    public DownloadData t(AdCard adCard, int i2) {
        InterceptResult invokeLI;
        Interceptable interceptable = $ic;
        if (interceptable == null || (invokeLI = interceptable.invokeLI(1048597, this, adCard, i2)) == null) {
            DownloadData downloadData = new DownloadData(adCard.getDownloadId());
            downloadData.setUrl(adCard.downloadInfo.f28532b);
            downloadData.setName(adCard.userName);
            downloadData.setPosition(i2);
            downloadData.setNotifyId(c.a.e.e.m.b.d(adCard.adId, 0));
            return downloadData;
        }
        return (DownloadData) invokeLI.objValue;
    }

    public final void u() {
        Interceptable interceptable = $ic;
        if (!(interceptable == null || interceptable.invokeV(1048598, this) == null) || this.p == null || this.q == null) {
            return;
        }
        c.a.p0.q.d.e.c().q(this.p, this.q);
    }

    public void update(int i2) {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeI(1048599, this, i2) == null) {
            List<g> list = this.f56226i;
            if (list != null && this.f56227j < list.size()) {
                g gVar = this.f56226i.get(this.f56227j);
                if (i2 >= this.k) {
                    gVar.b();
                    this.k = (int) (this.k + gVar.f56240f + gVar.f56239e);
                    this.f56227j++;
                    return;
                }
                return;
            }
            c.a.p0.x2.o0.b bVar = this.m;
            if (bVar != null) {
                bVar.b();
            }
        }
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
    public AdEnhanceButtonView(Context context, AttributeSet attributeSet, int i2) {
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
        this.f56227j = 0;
        this.k = 0;
        this.m = null;
        this.q = null;
        i(context);
    }
}
