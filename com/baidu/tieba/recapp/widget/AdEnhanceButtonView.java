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
import b.a.e.e.p.l;
import b.a.r0.r.e.g.b;
import b.a.r0.z2.i0.b.c;
import b.a.r0.z2.z;
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
/* loaded from: classes9.dex */
public class AdEnhanceButtonView extends FrameLayout {
    public static /* synthetic */ Interceptable $ic;
    public static final int APP_INFO_HEIGHT;
    public static final int BTN_HEIGHT;
    public static final int MARGIN_HEIGHT;
    public static final int MARGIN_TOP;
    public static final int OPERATE_BTN_CORNOR_RADIUS;
    public transient /* synthetic */ FieldHolder $fh;

    /* renamed from: e  reason: collision with root package name */
    public AdAppInfoView f53703e;

    /* renamed from: f  reason: collision with root package name */
    public FrameLayout f53704f;

    /* renamed from: g  reason: collision with root package name */
    public ApkDownloadView f53705g;

    /* renamed from: h  reason: collision with root package name */
    public TextView f53706h;

    /* renamed from: i  reason: collision with root package name */
    public List<g> f53707i;
    public int j;
    public int k;
    public View l;
    public b.a.r0.z2.o0.b m;
    public AdvertAppInfo n;
    public AdCard o;
    public DownloadCacheKey p;
    public b.a.r0.r.e.h.d q;

    /* loaded from: classes9.dex */
    public class a extends g {
        public static /* synthetic */ Interceptable $ic;
        public transient /* synthetic */ FieldHolder $fh;

        /* renamed from: g  reason: collision with root package name */
        public final /* synthetic */ AdEnhanceButtonView f53708g;

        /* JADX WARN: 'super' call moved to the top of the method (can break code semantics) */
        public a(AdEnhanceButtonView adEnhanceButtonView, long j, long j2) {
            super(j, j2);
            Interceptable interceptable = $ic;
            if (interceptable != null) {
                InitContext newInitContext = TitanRuntime.newInitContext();
                newInitContext.initArgs = r2;
                Object[] objArr = {adEnhanceButtonView, Long.valueOf(j), Long.valueOf(j2)};
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
            this.f53708g = adEnhanceButtonView;
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
            if (!(interceptable == null || interceptable.invokeV(Constants.METHOD_GET_CONTACTER_INFO_FOR_SESSION, this) == null) || this.f53708g.m == null) {
                return;
            }
            this.f53708g.m.c();
        }
    }

    /* loaded from: classes9.dex */
    public class b implements ValueAnimator.AnimatorUpdateListener {
        public static /* synthetic */ Interceptable $ic;
        public transient /* synthetic */ FieldHolder $fh;

        /* renamed from: e  reason: collision with root package name */
        public final /* synthetic */ ViewGroup.MarginLayoutParams f53709e;

        /* renamed from: f  reason: collision with root package name */
        public final /* synthetic */ AdEnhanceButtonView f53710f;

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
            this.f53710f = adEnhanceButtonView;
            this.f53709e = marginLayoutParams;
        }

        @Override // android.animation.ValueAnimator.AnimatorUpdateListener
        public void onAnimationUpdate(ValueAnimator valueAnimator) {
            Interceptable interceptable = $ic;
            if (interceptable == null || interceptable.invokeL(1048576, this, valueAnimator) == null) {
                float animatedFraction = valueAnimator.getAnimatedFraction();
                int i2 = AdEnhanceButtonView.BTN_HEIGHT;
                if (this.f53710f.o != null && this.f53710f.o.appInfoModel != null) {
                    i2 += AdEnhanceButtonView.APP_INFO_HEIGHT + AdEnhanceButtonView.MARGIN_HEIGHT;
                }
                this.f53709e.height = Math.round(i2 * animatedFraction);
                this.f53709e.topMargin = Math.round(AdEnhanceButtonView.MARGIN_TOP * animatedFraction);
                this.f53710f.l.requestLayout();
            }
        }
    }

    /* loaded from: classes9.dex */
    public class c extends g {
        public static /* synthetic */ Interceptable $ic;
        public transient /* synthetic */ FieldHolder $fh;

        /* renamed from: g  reason: collision with root package name */
        public final /* synthetic */ ValueAnimator f53711g;

        /* renamed from: h  reason: collision with root package name */
        public final /* synthetic */ Animation f53712h;

        /* renamed from: i  reason: collision with root package name */
        public final /* synthetic */ AdEnhanceButtonView f53713i;

        /* JADX WARN: 'super' call moved to the top of the method (can break code semantics) */
        public c(AdEnhanceButtonView adEnhanceButtonView, long j, long j2, ValueAnimator valueAnimator, Animation animation) {
            super(j, j2);
            Interceptable interceptable = $ic;
            if (interceptable != null) {
                InitContext newInitContext = TitanRuntime.newInitContext();
                newInitContext.initArgs = r3;
                Object[] objArr = {adEnhanceButtonView, Long.valueOf(j), Long.valueOf(j2), valueAnimator, animation};
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
            this.f53713i = adEnhanceButtonView;
            this.f53711g = valueAnimator;
            this.f53712h = animation;
        }

        @Override // com.baidu.tieba.recapp.widget.AdEnhanceButtonView.g
        public void a() {
            Interceptable interceptable = $ic;
            if (interceptable == null || interceptable.invokeV(1048576, this) == null) {
                this.f53711g.cancel();
                this.f53712h.cancel();
                this.f53713i.s();
            }
        }

        @Override // com.baidu.tieba.recapp.widget.AdEnhanceButtonView.g
        public void b() {
            Interceptable interceptable = $ic;
            if (!(interceptable == null || interceptable.invokeV(Constants.METHOD_GET_CONTACTER_INFO_FOR_SESSION, this) == null) || this.f53711g.isRunning()) {
                return;
            }
            if (this.f53713i.m != null) {
                this.f53713i.m.d();
            }
            this.f53712h.cancel();
            this.f53711g.start();
            this.f53713i.setAnimation(this.f53712h);
            this.f53713i.setVisibility(0);
            this.f53713i.startAnimation(this.f53712h);
        }
    }

    /* loaded from: classes9.dex */
    public class d implements ValueAnimator.AnimatorUpdateListener {
        public static /* synthetic */ Interceptable $ic;
        public transient /* synthetic */ FieldHolder $fh;

        /* renamed from: e  reason: collision with root package name */
        public final /* synthetic */ int f53714e;

        /* renamed from: f  reason: collision with root package name */
        public final /* synthetic */ AdEnhanceButtonView f53715f;

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
            this.f53715f = adEnhanceButtonView;
            this.f53714e = i2;
        }

        @Override // android.animation.ValueAnimator.AnimatorUpdateListener
        public void onAnimationUpdate(ValueAnimator valueAnimator) {
            Interceptable interceptable = $ic;
            if (interceptable == null || interceptable.invokeL(1048576, this, valueAnimator) == null) {
                float animatedFraction = valueAnimator.getAnimatedFraction();
                View view = this.f53715f.q() ? this.f53715f.f53704f : this.f53715f.f53706h;
                if (view.getBackground() instanceof GradientDrawable) {
                    GradientDrawable gradientDrawable = (GradientDrawable) view.getBackground();
                    gradientDrawable.setColor(b.a.r0.z2.i0.c.a.f(animatedFraction, SkinManager.getColor(R.color.CAM_X0614), this.f53714e));
                    gradientDrawable.setCornerRadius(AdEnhanceButtonView.OPERATE_BTN_CORNOR_RADIUS);
                }
            }
        }
    }

    /* loaded from: classes9.dex */
    public class e extends g {
        public static /* synthetic */ Interceptable $ic;
        public transient /* synthetic */ FieldHolder $fh;

        /* renamed from: g  reason: collision with root package name */
        public final /* synthetic */ ValueAnimator f53716g;

        /* renamed from: h  reason: collision with root package name */
        public final /* synthetic */ AdEnhanceButtonView f53717h;

        /* JADX WARN: 'super' call moved to the top of the method (can break code semantics) */
        public e(AdEnhanceButtonView adEnhanceButtonView, long j, long j2, ValueAnimator valueAnimator) {
            super(j, j2);
            Interceptable interceptable = $ic;
            if (interceptable != null) {
                InitContext newInitContext = TitanRuntime.newInitContext();
                newInitContext.initArgs = r2;
                Object[] objArr = {adEnhanceButtonView, Long.valueOf(j), Long.valueOf(j2), valueAnimator};
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
            this.f53717h = adEnhanceButtonView;
            this.f53716g = valueAnimator;
        }

        @Override // com.baidu.tieba.recapp.widget.AdEnhanceButtonView.g
        public void a() {
            Interceptable interceptable = $ic;
            if (interceptable == null || interceptable.invokeV(1048576, this) == null) {
                this.f53716g.cancel();
            }
        }

        @Override // com.baidu.tieba.recapp.widget.AdEnhanceButtonView.g
        public void b() {
            Interceptable interceptable = $ic;
            if (!(interceptable == null || interceptable.invokeV(Constants.METHOD_GET_CONTACTER_INFO_FOR_SESSION, this) == null) || this.f53716g.isRunning()) {
                return;
            }
            if (this.f53717h.m != null) {
                this.f53717h.m.a();
            }
            this.f53716g.start();
        }
    }

    /* loaded from: classes9.dex */
    public class f implements b.a {
        public static /* synthetic */ Interceptable $ic;
        public transient /* synthetic */ FieldHolder $fh;

        /* renamed from: a  reason: collision with root package name */
        public final /* synthetic */ AdEnhanceButtonView f53718a;

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
            this.f53718a = adEnhanceButtonView;
        }

        @Override // b.a.r0.r.e.g.b.a
        public boolean onClickIntercept(View view) {
            InterceptResult invokeL;
            Interceptable interceptable = $ic;
            if (interceptable == null || (invokeL = interceptable.invokeL(1048576, this, view)) == null) {
                b.a.r0.q1.o.h.c.h(b.a.r0.q1.o.h.c.e(this.f53718a.n));
                return false;
            }
            return invokeL.booleanValue;
        }
    }

    /* loaded from: classes9.dex */
    public static abstract class g implements Runnable {
        public static /* synthetic */ Interceptable $ic;
        public transient /* synthetic */ FieldHolder $fh;

        /* renamed from: e  reason: collision with root package name */
        public long f53719e;

        /* renamed from: f  reason: collision with root package name */
        public long f53720f;

        public g(long j, long j2) {
            Interceptable interceptable = $ic;
            if (interceptable != null) {
                InitContext newInitContext = TitanRuntime.newInitContext();
                newInitContext.initArgs = r2;
                Object[] objArr = {Long.valueOf(j), Long.valueOf(j2)};
                interceptable.invokeUnInit(65536, newInitContext);
                int i2 = newInitContext.flag;
                if ((i2 & 1) != 0) {
                    int i3 = i2 & 2;
                    newInitContext.thisArg = this;
                    interceptable.invokeInitBody(65536, newInitContext);
                    return;
                }
            }
            this.f53719e = j;
            this.f53720f = j2;
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
        return (interceptable == null || (invokeV = interceptable.invokeV(65547, this)) == null) ? b.a.r0.z2.i0.c.a.g(this.o.enhanceModel.f28100a, SkinManager.getColor(R.color.CAM_X0302)) : invokeV.intValue;
    }

    public void bindData(@NonNull AdvertAppInfo advertAppInfo) {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeL(1048576, this, advertAppInfo) == null) {
            this.n = advertAppInfo;
            AdvertAppInfo.ILegoAdvert iLegoAdvert = advertAppInfo.f4;
            if (iLegoAdvert instanceof AdCard) {
                AdCard adCard = (AdCard) iLegoAdvert;
                this.o = adCard;
                if (adCard.enhanceModel == null) {
                    setVisibility(8);
                    return;
                }
                setVisibility(0);
                b.a.q0.s.q.c cVar = this.o.appInfoModel;
                if (cVar != null) {
                    this.f53703e.setAppInfo(cVar);
                    this.f53703e.setVisibility(0);
                }
                String str = this.o.operate.f28094b;
                if (q()) {
                    n();
                    o();
                    this.f53706h.setVisibility(8);
                    this.f53704f.setVisibility(0);
                    this.f53705g.setInitText(str);
                } else {
                    this.f53706h.setText(str);
                    this.f53706h.setVisibility(0);
                    this.f53704f.setVisibility(8);
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
        AdDownloadData b2 = b.a.r0.r.e.e.c().b(downloadCacheKey);
        if (z.q(b2.getPkgName())) {
            b2.extra().setStatus(DownloadStatus.STATUS_INSTALL_SUCCESS);
        }
        AdCard adCard = this.o;
        if (adCard != null && adCard.getAdvertAppInfo() != null) {
            String str = this.o.getAdvertAppInfo().h4;
            b2.setExtInfo(this.o.getAdvertAppInfo().e4);
            b2.setDownloadKey(this.o.getDownloadKey());
            b2.setPage(str);
            b2.setDeeplinkUrl(this.o.scheme);
        }
        b.a.r0.r.d.b.d.a aVar = new b.a.r0.r.d.b.d.a(this.f53705g, b2);
        this.q = new b.a.r0.r.e.h.b(aVar);
        if (b2.extra().getPercent() > 0) {
            aVar.e(b2);
        }
        r();
        this.f53705g.onStatusChanged(b2.getCurrentState());
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
            this.f53703e = (AdAppInfoView) findViewById(R.id.app_info);
            this.f53704f = (FrameLayout) findViewById(R.id.download_btn_background);
            this.f53705g = (ApkDownloadView) findViewById(R.id.download_btn);
            this.f53706h = (TextView) findViewById(R.id.common_btn_text);
            this.f53703e.setTextSize(R.dimen.T_X08);
            this.f53703e.setTextColor(R.color.CAM_X0620);
            this.f53705g.setTextColorInitSkin(R.color.CAM_X0101);
            this.f53705g.setTextColor(SkinManager.getColor(R.color.CAM_X0101));
            this.f53705g.setTextSize(R.dimen.T_X08);
            this.f53705g.setForegroundSkin(R.color.black_alpha15);
            this.f53705g.setBackgroundSkin(R.drawable.video_flow_btn_bg_transparent);
            this.f53705g.setRatio(0);
            this.f53705g.changeSkin();
        }
    }

    public final void j(@NonNull b.a.r0.z2.i0.b.c cVar) {
        List<c.a> list;
        Interceptable interceptable = $ic;
        if (!(interceptable == null || interceptable.invokeL(1048581, this, cVar) == null) || (list = cVar.f28101b) == null || list.size() <= 0) {
            return;
        }
        this.f53707i = new ArrayList();
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
            (q() ? this.f53704f : this.f53706h).setBackground(gradientDrawable);
        }
    }

    public final void l(@NonNull c.a aVar) {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeL(1048583, this, aVar) == null) {
            s();
            if (aVar.f28104c <= 0) {
                return;
            }
            ValueAnimator duration = ValueAnimator.ofFloat(0.0f, 1.0f).setDuration(aVar.f28104c);
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
            loadAnimation.setDuration(aVar.f28104c);
            setVisibility(8);
            this.f53707i.add(new c(this, aVar.f28103b, aVar.f28104c, duration, loadAnimation));
        }
    }

    public final void m(@NonNull c.a aVar) {
        Interceptable interceptable = $ic;
        if (!(interceptable == null || interceptable.invokeL(InputDeviceCompat.SOURCE_TOUCHPAD, this, aVar) == null) || aVar.f28104c <= 0) {
            return;
        }
        k(true);
        ValueAnimator duration = ValueAnimator.ofFloat(1.0f).setDuration(aVar.f28104c);
        duration.addUpdateListener(new d(this, getBtnFinalColor()));
        this.f53707i.add(new e(this, aVar.f28103b, aVar.f28104c, duration));
    }

    public final void n() {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeV(1048585, this) == null) {
            AdCard adCard = this.o;
            if (adCard.downloadInfo == null) {
                return;
            }
            this.f53705g.setInitText(adCard.operate.f28094b);
            AdCard adCard2 = this.o;
            String str = adCard2.downloadInfo.f28096a;
            DownloadData t = t(this.o, adCard2.getPosition());
            if (z.q(str)) {
                t.setStatus(8);
            } else {
                t.setStatus(this.f53705g.getDownloadStatus());
            }
            this.f53705g.setData(t);
            this.f53705g.setOnClickInterceptListener(new f(this));
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
                h2 = b.a.r0.r.e.e.c().g(downloadId);
            } else {
                h2 = b.a.r0.r.e.e.c().h(str);
            }
            if (h2 == null) {
                b.a.r0.z2.i0.b.b bVar = this.o.downloadInfo;
                h2 = DownloadCacheKey.create(downloadId, bVar.f28097b, bVar.f28096a);
                b.a.r0.r.e.e.c().i(h2, null);
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
            int i2 = aVar.f28102a;
            if (i2 == 0) {
                this.f53707i.add(new a(this, aVar.f28103b, aVar.f28104c));
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
            return advertAppInfo.R4();
        }
        return invokeV.booleanValue;
    }

    public final void r() {
        Interceptable interceptable = $ic;
        if (!(interceptable == null || interceptable.invokeV(1048592, this) == null) || this.p == null || this.q == null) {
            return;
        }
        b.a.r0.r.e.e.c().i(this.p, this.q);
    }

    public void resetAnim() {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeV(1048593, this) == null) {
            List<g> list = this.f53707i;
            if (list != null) {
                for (g gVar : list) {
                    gVar.a();
                }
            }
            this.j = 0;
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
            downloadData.setUrl(adCard.downloadInfo.f28097b);
            downloadData.setName(adCard.userName);
            downloadData.setPosition(i2);
            downloadData.setNotifyId(b.a.e.e.m.b.e(adCard.adId, 0));
            return downloadData;
        }
        return (DownloadData) invokeLI.objValue;
    }

    public final void u() {
        Interceptable interceptable = $ic;
        if (!(interceptable == null || interceptable.invokeV(1048598, this) == null) || this.p == null || this.q == null) {
            return;
        }
        b.a.r0.r.e.e.c().q(this.p, this.q);
    }

    public void update(int i2) {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeI(1048599, this, i2) == null) {
            List<g> list = this.f53707i;
            if (list != null && this.j < list.size()) {
                g gVar = this.f53707i.get(this.j);
                if (i2 >= this.k) {
                    gVar.b();
                    this.k = (int) (this.k + gVar.f53720f + gVar.f53719e);
                    this.j++;
                    return;
                }
                return;
            }
            b.a.r0.z2.o0.b bVar = this.m;
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
        this.j = 0;
        this.k = 0;
        this.m = null;
        this.q = null;
        i(context);
    }
}
