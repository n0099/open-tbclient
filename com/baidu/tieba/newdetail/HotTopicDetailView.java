package com.baidu.tieba.newdetail;

import android.animation.ValueAnimator;
import android.annotation.SuppressLint;
import android.app.Activity;
import android.content.Context;
import android.graphics.Bitmap;
import android.graphics.drawable.Drawable;
import android.os.Bundle;
import android.text.SpannableString;
import android.text.SpannableStringBuilder;
import android.text.TextPaint;
import android.text.TextUtils;
import android.text.style.ClickableSpan;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.view.ViewParent;
import android.widget.ImageView;
import android.widget.RelativeLayout;
import android.widget.TextView;
import androidx.annotation.ColorInt;
import androidx.annotation.NonNull;
import androidx.annotation.Nullable;
import androidx.core.view.InputDeviceCompat;
import androidx.recyclerview.widget.RecyclerView;
import c.a.d.f.p.l;
import c.a.d.f.p.n;
import c.a.o0.a;
import c.a.s0.d1.o0;
import com.baidu.adp.framework.MessageManager;
import com.baidu.adp.framework.message.CustomResponsedMessage;
import com.baidu.adp.lib.featureSwitch.SwitchManager;
import com.baidu.adp.lib.util.StringUtils;
import com.baidu.adp.widget.design.TbTabLayout;
import com.baidu.android.imsdk.internal.Constants;
import com.baidu.smartcolor.SmartColorSDK;
import com.baidu.smartcolor.utils.Tri;
import com.baidu.tbadk.TbPageContext;
import com.baidu.tbadk.core.TbadkCoreApplication;
import com.baidu.tbadk.core.util.ListUtils;
import com.baidu.tbadk.core.util.SkinManager;
import com.baidu.tbadk.core.util.StatisticItem;
import com.baidu.tbadk.core.util.StatusbarColorUtils;
import com.baidu.tbadk.core.util.SvgManager;
import com.baidu.tbadk.core.util.TbadkCoreStatisticKey;
import com.baidu.tbadk.core.util.TiebaStatic;
import com.baidu.tbadk.core.util.UtilHelper;
import com.baidu.tbadk.core.util.ViewHelper;
import com.baidu.tbadk.core.util.WebPManager;
import com.baidu.tbadk.core.view.NavigationBar;
import com.baidu.tbadk.core.view.slideLoadingLayout.LottieSlideLoadingLayout;
import com.baidu.tbadk.plugin.ShadowLayout;
import com.baidu.tbadk.switchs.IColorSDKSwitch;
import com.baidu.tbadk.switchs.ShareSwitch;
import com.baidu.tbadk.widget.CustomViewPager;
import com.baidu.tieba.newdetail.adapter.HotTopicDetailPagerAdapter;
import com.baidu.tieba.newdetail.view.HotTopicDetailHeadView;
import com.baidu.tieba.newdetail.view.HotTopicDetailPkLayout;
import com.baidu.tieba.newdetail.view.HotTopicDetailSpecialLayout;
import com.baidu.titan.sdk.runtime.ClassClinitInterceptable;
import com.baidu.titan.sdk.runtime.ClassClinitInterceptorStorage;
import com.baidu.titan.sdk.runtime.FieldHolder;
import com.baidu.titan.sdk.runtime.InitContext;
import com.baidu.titan.sdk.runtime.InterceptResult;
import com.baidu.titan.sdk.runtime.Interceptable;
import com.baidu.titan.sdk.runtime.TitanRuntime;
import com.bumptech.glide.load.engine.GlideException;
import com.google.android.material.appbar.AppBarLayout;
import java.util.List;
@SuppressLint({"ViewConstructor"})
/* loaded from: classes12.dex */
public class HotTopicDetailView extends RelativeLayout implements c.a.t0.n2.b {
    public static /* synthetic */ Interceptable $ic;
    public static int P;
    public transient /* synthetic */ FieldHolder $fh;
    public c.a.t0.r1.k.c A;
    public CustomViewPager B;
    public HotTopicDetailPagerAdapter C;
    public TbTabLayout D;
    public View E;
    public RecyclerView.OnScrollListener F;
    public boolean G;
    public ValueAnimator H;
    public c.a.t0.r1.l.e I;
    public AppBarLayout.OnOffsetChangedListener J;
    public c.a.s0.s.k0.q.b K;
    public final c.a.d.f.l.c<c.a.d.n.d.a> L;
    public Runnable M;
    public ClickableSpan N;
    public ClickableSpan O;

    /* renamed from: e  reason: collision with root package name */
    public int f46098e;

    /* renamed from: f  reason: collision with root package name */
    public int f46099f;

    /* renamed from: g  reason: collision with root package name */
    public TbPageContext<HotTopicDetailActivity> f46100g;

    /* renamed from: h  reason: collision with root package name */
    public c.a.t0.n2.a f46101h;

    /* renamed from: i  reason: collision with root package name */
    public View f46102i;

    /* renamed from: j  reason: collision with root package name */
    public NavigationBar f46103j;
    public ImageView k;
    public boolean l;
    public ViewGroup m;
    public c.a.s0.g0.g n;
    public c.a.s0.g0.h o;
    public LottieSlideLoadingLayout p;
    public HotTopicDetailHeadView q;
    public TextView r;
    public TextView s;
    public String t;
    public int u;
    public View v;
    public AppBarLayout w;
    public View x;
    public HotTopicDetailPkLayout y;
    public HotTopicDetailSpecialLayout z;

    /* loaded from: classes12.dex */
    public class a extends ClickableSpan {
        public static /* synthetic */ Interceptable $ic;
        public transient /* synthetic */ FieldHolder $fh;

        /* renamed from: e  reason: collision with root package name */
        public final /* synthetic */ HotTopicDetailView f46104e;

        public a(HotTopicDetailView hotTopicDetailView) {
            Interceptable interceptable = $ic;
            if (interceptable != null) {
                InitContext newInitContext = TitanRuntime.newInitContext();
                newInitContext.initArgs = r2;
                Object[] objArr = {hotTopicDetailView};
                interceptable.invokeUnInit(65536, newInitContext);
                int i2 = newInitContext.flag;
                if ((i2 & 1) != 0) {
                    int i3 = i2 & 2;
                    newInitContext.thisArg = this;
                    interceptable.invokeInitBody(65536, newInitContext);
                    return;
                }
            }
            this.f46104e = hotTopicDetailView;
        }

        @Override // android.text.style.ClickableSpan
        public void onClick(View view) {
            Interceptable interceptable = $ic;
            if (interceptable == null || interceptable.invokeL(1048576, this, view) == null) {
                this.f46104e.s.setText(this.f46104e.t);
                this.f46104e.v();
            }
        }

        @Override // android.text.style.ClickableSpan, android.text.style.CharacterStyle
        public void updateDrawState(TextPaint textPaint) {
            Interceptable interceptable = $ic;
            if (interceptable == null || interceptable.invokeL(Constants.METHOD_GET_CONTACTER_INFO_FOR_SESSION, this, textPaint) == null) {
                textPaint.setColor(this.f46104e.getResources().getColor(c.a.t0.r1.b.CAM_X0304));
            }
        }
    }

    /* loaded from: classes12.dex */
    public class b extends RecyclerView.OnScrollListener {
        public static /* synthetic */ Interceptable $ic;
        public transient /* synthetic */ FieldHolder $fh;
        public final /* synthetic */ HotTopicDetailView a;

        public b(HotTopicDetailView hotTopicDetailView) {
            Interceptable interceptable = $ic;
            if (interceptable != null) {
                InitContext newInitContext = TitanRuntime.newInitContext();
                newInitContext.initArgs = r2;
                Object[] objArr = {hotTopicDetailView};
                interceptable.invokeUnInit(65536, newInitContext);
                int i2 = newInitContext.flag;
                if ((i2 & 1) != 0) {
                    int i3 = i2 & 2;
                    newInitContext.thisArg = this;
                    interceptable.invokeInitBody(65536, newInitContext);
                    return;
                }
            }
            this.a = hotTopicDetailView;
        }

        @Override // androidx.recyclerview.widget.RecyclerView.OnScrollListener
        public void onScrolled(RecyclerView recyclerView, int i2, int i3) {
            Interceptable interceptable = $ic;
            if (interceptable == null || interceptable.invokeLII(1048576, this, recyclerView, i2, i3) == null) {
                this.a.y();
            }
        }
    }

    /* loaded from: classes12.dex */
    public class c implements View.OnClickListener {
        public static /* synthetic */ Interceptable $ic;
        public transient /* synthetic */ FieldHolder $fh;

        /* renamed from: e  reason: collision with root package name */
        public final /* synthetic */ HotTopicDetailView f46105e;

        public c(HotTopicDetailView hotTopicDetailView) {
            Interceptable interceptable = $ic;
            if (interceptable != null) {
                InitContext newInitContext = TitanRuntime.newInitContext();
                newInitContext.initArgs = r2;
                Object[] objArr = {hotTopicDetailView};
                interceptable.invokeUnInit(65536, newInitContext);
                int i2 = newInitContext.flag;
                if ((i2 & 1) != 0) {
                    int i3 = i2 & 2;
                    newInitContext.thisArg = this;
                    interceptable.invokeInitBody(65536, newInitContext);
                    return;
                }
            }
            this.f46105e = hotTopicDetailView;
        }

        @Override // android.view.View.OnClickListener
        public void onClick(View view) {
            Interceptable interceptable = $ic;
            if (interceptable == null || interceptable.invokeL(1048576, this, view) == null) {
                c.a.t0.n2.c.e(this.f46105e.f46100g, "c14389");
                if (!l.z()) {
                    this.f46105e.f46100g.showToast(c.a.t0.r1.h.topic_share_no_network);
                    return;
                }
                MessageManager.getInstance().dispatchResponsedMessage(new CustomResponsedMessage(2004011));
                if (ShareSwitch.isOn() || ViewHelper.checkUpIsLogin(this.f46105e.k.getContext())) {
                    this.f46105e.f46101h.shareTopic(this.f46105e.I);
                }
            }
        }
    }

    /* loaded from: classes12.dex */
    public class d implements Runnable {
        public static /* synthetic */ Interceptable $ic;
        public transient /* synthetic */ FieldHolder $fh;

        /* renamed from: e  reason: collision with root package name */
        public final /* synthetic */ HotTopicDetailView f46106e;

        public d(HotTopicDetailView hotTopicDetailView) {
            Interceptable interceptable = $ic;
            if (interceptable != null) {
                InitContext newInitContext = TitanRuntime.newInitContext();
                newInitContext.initArgs = r2;
                Object[] objArr = {hotTopicDetailView};
                interceptable.invokeUnInit(65536, newInitContext);
                int i2 = newInitContext.flag;
                if ((i2 & 1) != 0) {
                    int i3 = i2 & 2;
                    newInitContext.thisArg = this;
                    interceptable.invokeInitBody(65536, newInitContext);
                    return;
                }
            }
            this.f46106e = hotTopicDetailView;
        }

        @Override // java.lang.Runnable
        public void run() {
            Interceptable interceptable = $ic;
            if (interceptable == null || interceptable.invokeV(1048576, this) == null) {
                this.f46106e.x.setMinimumHeight(this.f46106e.f46103j.getHeight() + this.f46106e.f46099f);
            }
        }
    }

    /* loaded from: classes12.dex */
    public class e implements AppBarLayout.OnOffsetChangedListener {
        public static /* synthetic */ Interceptable $ic;
        public transient /* synthetic */ FieldHolder $fh;
        public final /* synthetic */ HotTopicDetailView a;

        public e(HotTopicDetailView hotTopicDetailView) {
            Interceptable interceptable = $ic;
            if (interceptable != null) {
                InitContext newInitContext = TitanRuntime.newInitContext();
                newInitContext.initArgs = r2;
                Object[] objArr = {hotTopicDetailView};
                interceptable.invokeUnInit(65536, newInitContext);
                int i2 = newInitContext.flag;
                if ((i2 & 1) != 0) {
                    int i3 = i2 & 2;
                    newInitContext.thisArg = this;
                    interceptable.invokeInitBody(65536, newInitContext);
                    return;
                }
            }
            this.a = hotTopicDetailView;
        }

        @Override // com.google.android.material.appbar.AppBarLayout.OnOffsetChangedListener, com.google.android.material.appbar.AppBarLayout.BaseOnOffsetChangedListener
        public void onOffsetChanged(AppBarLayout appBarLayout, int i2) {
            Interceptable interceptable = $ic;
            if (interceptable == null || interceptable.invokeLI(1048576, this, appBarLayout, i2) == null) {
                if (this.a.p != null) {
                    this.a.p.setEnableSlideLoading(i2 == 0);
                }
                this.a.A(i2);
            }
        }
    }

    /* loaded from: classes12.dex */
    public class f implements c.a.s0.s.k0.q.b {
        public static /* synthetic */ Interceptable $ic;
        public transient /* synthetic */ FieldHolder $fh;
        public final /* synthetic */ HotTopicDetailView a;

        public f(HotTopicDetailView hotTopicDetailView) {
            Interceptable interceptable = $ic;
            if (interceptable != null) {
                InitContext newInitContext = TitanRuntime.newInitContext();
                newInitContext.initArgs = r2;
                Object[] objArr = {hotTopicDetailView};
                interceptable.invokeUnInit(65536, newInitContext);
                int i2 = newInitContext.flag;
                if ((i2 & 1) != 0) {
                    int i3 = i2 & 2;
                    newInitContext.thisArg = this;
                    interceptable.invokeInitBody(65536, newInitContext);
                    return;
                }
            }
            this.a = hotTopicDetailView;
        }

        @Override // c.a.s0.s.k0.q.b
        public void a() {
            Interceptable interceptable = $ic;
            if (interceptable == null || interceptable.invokeV(1048576, this) == null) {
            }
        }

        @Override // c.a.s0.s.k0.q.b
        public void onLoadingStart() {
            Interceptable interceptable = $ic;
            if (interceptable == null || interceptable.invokeV(Constants.METHOD_GET_CONTACTER_INFO_FOR_SESSION, this) == null) {
                this.a.u();
            }
        }
    }

    /* loaded from: classes12.dex */
    public class g extends c.a.d.f.l.c<c.a.d.n.d.a> {
        public static /* synthetic */ Interceptable $ic;
        public transient /* synthetic */ FieldHolder $fh;
        public final /* synthetic */ HotTopicDetailView a;

        public g(HotTopicDetailView hotTopicDetailView) {
            Interceptable interceptable = $ic;
            if (interceptable != null) {
                InitContext newInitContext = TitanRuntime.newInitContext();
                newInitContext.initArgs = r2;
                Object[] objArr = {hotTopicDetailView};
                interceptable.invokeUnInit(65536, newInitContext);
                int i2 = newInitContext.flag;
                if ((i2 & 1) != 0) {
                    int i3 = i2 & 2;
                    newInitContext.thisArg = this;
                    interceptable.invokeInitBody(65536, newInitContext);
                    return;
                }
            }
            this.a = hotTopicDetailView;
        }

        /* JADX DEBUG: Method merged with bridge method */
        @Override // c.a.d.f.l.c
        public void onLoaded(c.a.d.n.d.a aVar, String str, int i2) {
            Bitmap p;
            boolean z;
            int d2;
            Interceptable interceptable = $ic;
            if (interceptable == null || interceptable.invokeLLI(1048576, this, aVar, str, i2) == null) {
                super.onLoaded((g) aVar, str, i2);
                if (aVar == null || !aVar.w() || (p = aVar.p()) == null) {
                    return;
                }
                a.C0227a c0227a = new a.C0227a();
                c0227a.c(Tri.TRUE);
                c0227a.b(Tri.TRUE);
                c0227a.d(50, 100);
                c0227a.e(40, 80);
                String e2 = SmartColorSDK.d().e(c0227a.a(), p);
                if (TextUtils.isEmpty(e2) || (d2 = c.a.t0.x3.c.d(e2)) == Integer.MAX_VALUE) {
                    z = false;
                } else {
                    z = true;
                    if (this.a.r != null) {
                        HotTopicDetailView.setWriteViewStyle(this.a.r, d2);
                    }
                    if (this.a.q != null) {
                        this.a.q.setBgCoverViewColor(c.a.t0.x3.c.a(d2, 0.5f));
                    }
                }
                StatisticItem statisticItem = new StatisticItem(TbadkCoreStatisticKey.KEY_SMART_COLOR_FETCH_COLOR);
                statisticItem.addParam("obj_type", z ? "1" : "0");
                if (!z) {
                    if (str != null && str.length() > 100) {
                        statisticItem.addParam("obj_source", str.substring(0, 100));
                    } else {
                        statisticItem.addParam("obj_source", str);
                    }
                }
                TiebaStatic.log(statisticItem);
            }
        }
    }

    /* loaded from: classes12.dex */
    public class h implements View.OnClickListener {
        public static /* synthetic */ Interceptable $ic;
        public transient /* synthetic */ FieldHolder $fh;

        /* renamed from: e  reason: collision with root package name */
        public final /* synthetic */ HotTopicDetailView f46107e;

        public h(HotTopicDetailView hotTopicDetailView) {
            Interceptable interceptable = $ic;
            if (interceptable != null) {
                InitContext newInitContext = TitanRuntime.newInitContext();
                newInitContext.initArgs = r2;
                Object[] objArr = {hotTopicDetailView};
                interceptable.invokeUnInit(65536, newInitContext);
                int i2 = newInitContext.flag;
                if ((i2 & 1) != 0) {
                    int i3 = i2 & 2;
                    newInitContext.thisArg = this;
                    interceptable.invokeInitBody(65536, newInitContext);
                    return;
                }
            }
            this.f46107e = hotTopicDetailView;
        }

        @Override // android.view.View.OnClickListener
        public void onClick(View view) {
            Interceptable interceptable = $ic;
            if ((interceptable == null || interceptable.invokeL(1048576, this, view) == null) && l.A() && this.f46107e.f46101h != null) {
                this.f46107e.f46101h.refreshFullData(1);
            }
        }
    }

    /* loaded from: classes12.dex */
    public class i implements Runnable {
        public static /* synthetic */ Interceptable $ic;
        public transient /* synthetic */ FieldHolder $fh;

        /* renamed from: e  reason: collision with root package name */
        public final /* synthetic */ HotTopicDetailView f46108e;

        public i(HotTopicDetailView hotTopicDetailView) {
            Interceptable interceptable = $ic;
            if (interceptable != null) {
                InitContext newInitContext = TitanRuntime.newInitContext();
                newInitContext.initArgs = r2;
                Object[] objArr = {hotTopicDetailView};
                interceptable.invokeUnInit(65536, newInitContext);
                int i2 = newInitContext.flag;
                if ((i2 & 1) != 0) {
                    int i3 = i2 & 2;
                    newInitContext.thisArg = this;
                    interceptable.invokeInitBody(65536, newInitContext);
                    return;
                }
            }
            this.f46108e = hotTopicDetailView;
        }

        @Override // java.lang.Runnable
        public void run() {
            Interceptable interceptable = $ic;
            if ((interceptable == null || interceptable.invokeV(1048576, this) == null) && this.f46108e.G) {
                this.f46108e.D();
            }
        }
    }

    /* loaded from: classes12.dex */
    public class j extends ClickableSpan {
        public static /* synthetic */ Interceptable $ic;
        public transient /* synthetic */ FieldHolder $fh;

        /* renamed from: e  reason: collision with root package name */
        public final /* synthetic */ HotTopicDetailView f46109e;

        public j(HotTopicDetailView hotTopicDetailView) {
            Interceptable interceptable = $ic;
            if (interceptable != null) {
                InitContext newInitContext = TitanRuntime.newInitContext();
                newInitContext.initArgs = r2;
                Object[] objArr = {hotTopicDetailView};
                interceptable.invokeUnInit(65536, newInitContext);
                int i2 = newInitContext.flag;
                if ((i2 & 1) != 0) {
                    int i3 = i2 & 2;
                    newInitContext.thisArg = this;
                    interceptable.invokeInitBody(65536, newInitContext);
                    return;
                }
            }
            this.f46109e = hotTopicDetailView;
        }

        @Override // android.text.style.ClickableSpan
        public void onClick(View view) {
            Interceptable interceptable = $ic;
            if (interceptable == null || interceptable.invokeL(1048576, this, view) == null) {
                SpannableStringBuilder spannableStringBuilder = new SpannableStringBuilder();
                spannableStringBuilder.append((CharSequence) this.f46109e.t);
                if (this.f46109e.t.length() > 500) {
                    spannableStringBuilder.append((CharSequence) "...  ");
                }
                String str = this.f46109e.getResources().getString(c.a.t0.r1.h.hot_topic_coll) + GlideException.IndentedAppendable.INDENT;
                spannableStringBuilder.append((CharSequence) str);
                SpannableString spannableString = new SpannableString(spannableStringBuilder);
                spannableString.setSpan(this.f46109e.O, spannableString.length() - str.length(), spannableString.length(), 33);
                this.f46109e.s.setText(spannableString);
                this.f46109e.s.setHeight(this.f46109e.u * this.f46109e.s.getLineHeight());
                int lineCount = this.f46109e.s.getLineCount() * this.f46109e.s.getLineHeight();
                if (lineCount > this.f46109e.u * this.f46109e.s.getLineHeight()) {
                    this.f46109e.s.scrollTo(0, lineCount - (this.f46109e.u * this.f46109e.s.getLineHeight()));
                }
                this.f46109e.s.requestLayout();
            }
        }

        @Override // android.text.style.ClickableSpan, android.text.style.CharacterStyle
        public void updateDrawState(TextPaint textPaint) {
            Interceptable interceptable = $ic;
            if (interceptable == null || interceptable.invokeL(Constants.METHOD_GET_CONTACTER_INFO_FOR_SESSION, this, textPaint) == null) {
                textPaint.setColor(this.f46109e.getResources().getColor(c.a.t0.r1.b.CAM_X0304));
            }
        }
    }

    static {
        InterceptResult invokeClinit;
        ClassClinitInterceptable classClinitInterceptable = ClassClinitInterceptorStorage.$ic;
        if (classClinitInterceptable != null && (invokeClinit = classClinitInterceptable.invokeClinit(877700567, "Lcom/baidu/tieba/newdetail/HotTopicDetailView;")) != null) {
            Interceptable interceptable = invokeClinit.interceptor;
            if (interceptable != null) {
                $ic = interceptable;
            }
            if ((invokeClinit.flags & 1) != 0) {
                classClinitInterceptable.invokePostClinit(877700567, "Lcom/baidu/tieba/newdetail/HotTopicDetailView;");
                return;
            }
        }
        P = TbadkCoreApplication.getInst().getResources().getDimensionPixelSize(c.a.t0.r1.c.tbds250);
    }

    /* JADX WARN: 'super' call moved to the top of the method (can break code semantics) */
    public HotTopicDetailView(TbPageContext<?> tbPageContext, c.a.t0.n2.a aVar, Bundle bundle) {
        super(tbPageContext.getPageActivity());
        Interceptable interceptable = $ic;
        if (interceptable != null) {
            InitContext newInitContext = TitanRuntime.newInitContext();
            newInitContext.initArgs = r2;
            Object[] objArr = {tbPageContext, aVar, bundle};
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
        this.f46098e = 3;
        this.f46099f = UtilHelper.getStatusBarHeight();
        this.l = false;
        this.t = "";
        this.F = new b(this);
        this.G = false;
        this.J = new e(this);
        this.K = new f(this);
        this.L = new g(this);
        this.M = new i(this);
        this.N = new j(this);
        this.O = new a(this);
        this.f46100g = tbPageContext;
        this.f46101h = aVar;
        B(bundle);
        onChangeSkinType();
    }

    public static void setWriteViewStyle(@NonNull TextView textView, @ColorInt int i2) {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeLI(65557, null, textView, i2) == null) {
            c.a.s0.s.u.c d2 = c.a.s0.s.u.c.d(textView);
            d2.n(c.a.t0.r1.h.J_X01);
            d2.v(c.a.t0.r1.b.CAM_X0101);
            d2.g(i2);
            textView.setCompoundDrawablesWithIntrinsicBounds(WebPManager.getPureDrawable(c.a.t0.r1.d.icon_pure_topic_post48, SkinManager.getColor(c.a.t0.r1.b.CAM_X0101), null), (Drawable) null, (Drawable) null, (Drawable) null);
            ShadowLayout w = w(textView);
            if (w != null) {
                w.setPadding(c.a.t0.r1.c.ds10).setRadius(c.a.t0.r1.c.ds90).setOffset(c.a.t0.r1.c.ds0, c.a.t0.r1.c.ds4).setColor(c.a.t0.x3.c.a(i2, 0.5f)).buildShadow();
            }
        }
    }

    @Nullable
    public static ShadowLayout w(@NonNull TextView textView) {
        InterceptResult invokeL;
        Interceptable interceptable = $ic;
        if (interceptable == null || (invokeL = interceptable.invokeL(65559, null, textView)) == null) {
            ViewParent parent = textView.getParent();
            if (parent instanceof ShadowLayout) {
                return (ShadowLayout) parent;
            }
            return null;
        }
        return (ShadowLayout) invokeL.objValue;
    }

    public final void A(int i2) {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeI(1048576, this, i2) == null) {
            int i3 = i2 + P;
            if (i3 < 0) {
                i3 = 0;
            }
            float f2 = 1.0f - ((i3 * 1.0f) / P);
            this.f46102i.setAlpha(f2);
            this.f46103j.getCenterText().setAlpha(f2);
            y();
            double d2 = f2;
            if (d2 > 0.1d) {
                StatusbarColorUtils.setStatusBarDarkIcon(this.f46100g.getPageActivity().getWindow(), true);
            } else {
                StatusbarColorUtils.setStatusBarDarkIcon(this.f46100g.getPageActivity().getWindow(), false);
            }
            if ((d2 > 0.3d && this.f46098e == 0) || this.I == null) {
                SvgManager.getInstance().setPureDrawableWithDayNightModeAutoChange((ImageView) this.f46103j.findViewById(c.a.t0.r1.e.widget_navi_back_button), c.a.t0.r1.d.ic_icon_pure_topbar_return40_svg, c.a.t0.r1.b.CAM_X0105, SvgManager.SvgResourceStateType.NORMAL_PRESS);
                SvgManager.getInstance().setPureDrawableWithDayNightModeAutoChange(this.k, c.a.t0.r1.d.icon_pure_topbar_share44_svg, c.a.t0.r1.b.CAM_X0105, SvgManager.SvgResourceStateType.NORMAL_PRESS);
                return;
            }
            SvgManager.getInstance().setPureDrawableWithDayNightModeAutoChange((ImageView) this.f46103j.findViewById(c.a.t0.r1.e.widget_navi_back_button), c.a.t0.r1.d.ic_icon_pure_topbar_return40_svg, c.a.t0.r1.b.white_alpha100, SvgManager.SvgResourceStateType.NORMAL_PRESS);
            SvgManager.getInstance().setPureDrawableWithDayNightModeAutoChange(this.k, c.a.t0.r1.d.icon_pure_topbar_share44_svg, c.a.t0.r1.b.white_alpha100, SvgManager.SvgResourceStateType.NORMAL_PRESS);
        }
    }

    public final void B(Bundle bundle) {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeL(Constants.METHOD_GET_CONTACTER_INFO_FOR_SESSION, this, bundle) == null) {
            LayoutInflater.from(getContext()).inflate(c.a.t0.r1.f.activity_hot_topic_detail_layout, (ViewGroup) this, true);
            View findViewById = findViewById(c.a.t0.r1.e.topBgView);
            this.f46102i = findViewById;
            findViewById.setAlpha(0.0f);
            NavigationBar navigationBar = (NavigationBar) findViewById(c.a.t0.r1.e.viewNavigationBar);
            this.f46103j = navigationBar;
            navigationBar.addSystemImageButton(NavigationBar.ControlAlign.HORIZONTAL_LEFT, NavigationBar.ControlType.BACK_BUTTON);
            this.f46103j.getCenterText().setAlpha(0.0f);
            ImageView imageView = (ImageView) this.f46103j.addCustomView(NavigationBar.ControlAlign.HORIZONTAL_RIGHT, c.a.t0.r1.f.hot_topic_share, new c(this));
            this.k = imageView;
            imageView.setVisibility(4);
            View findViewById2 = findViewById(c.a.t0.r1.e.statusBarViewHolder);
            ViewGroup.LayoutParams layoutParams = findViewById2.getLayoutParams();
            layoutParams.height = this.f46099f;
            findViewById2.setLayoutParams(layoutParams);
            this.m = (ViewGroup) findViewById(c.a.t0.r1.e.contentRootLayout);
            LottieSlideLoadingLayout lottieSlideLoadingLayout = (LottieSlideLoadingLayout) findViewById(c.a.t0.r1.e.contentLayout);
            this.p = lottieSlideLoadingLayout;
            lottieSlideLoadingLayout.addLoadingListener(this.K);
            this.p.bringLoadViewToFront();
            HotTopicDetailHeadView hotTopicDetailHeadView = (HotTopicDetailHeadView) findViewById(c.a.t0.r1.e.hotTopicDetailHeadView);
            this.q = hotTopicDetailHeadView;
            this.p.addSyncHeightView(hotTopicDetailHeadView);
            this.x = findViewById(c.a.t0.r1.e.headerContainerLayout);
            this.f46103j.post(new d(this));
            this.s = (TextView) findViewById(c.a.t0.r1.e.hotTopicInfoAbstract);
            this.y = (HotTopicDetailPkLayout) findViewById(c.a.t0.r1.e.hotTopicDetailPkView);
            HotTopicDetailSpecialLayout hotTopicDetailSpecialLayout = (HotTopicDetailSpecialLayout) findViewById(c.a.t0.r1.e.hotTopicDetailSpecialLayout);
            this.z = hotTopicDetailSpecialLayout;
            hotTopicDetailSpecialLayout.initAdapters(this.f46100g);
            this.v = findViewById(c.a.t0.r1.e.contentContainer);
            AppBarLayout appBarLayout = (AppBarLayout) findViewById(c.a.t0.r1.e.appBarLayout);
            this.w = appBarLayout;
            appBarLayout.addOnOffsetChangedListener(this.J);
            this.B = (CustomViewPager) findViewById(c.a.t0.r1.e.hotTopicViewPager);
            HotTopicDetailPagerAdapter hotTopicDetailPagerAdapter = new HotTopicDetailPagerAdapter(getContext());
            this.C = hotTopicDetailPagerAdapter;
            hotTopicDetailPagerAdapter.setScrollListener(this.F);
            this.B.setAdapter(this.C);
            TbTabLayout tbTabLayout = (TbTabLayout) findViewById(c.a.t0.r1.e.tabLayout);
            this.D = tbTabLayout;
            tbTabLayout.setSelectedTabTextBlod(true);
            this.D.setTabTextSize(n.f(TbadkCoreApplication.getInst().getContext(), c.a.t0.r1.c.tbds46));
            this.D.setSelectedTabIndicatorColor(SkinManager.getColor(c.a.t0.r1.b.CAM_X0302));
            this.D.setupWithViewPager(this.B);
            this.E = findViewById(c.a.t0.r1.e.dividerShadow);
            TextView textView = (TextView) findViewById(c.a.t0.r1.e.topic_post_forum_button);
            this.r = textView;
            this.A = new c.a.t0.r1.k.c(textView, this.f46100g);
        }
    }

    public final void C() {
        Interceptable interceptable = $ic;
        if (!(interceptable == null || interceptable.invokeV(Constants.METHOD_SEND_USER_MSG, this) == null) || this.l) {
            return;
        }
        this.l = true;
        this.k.setVisibility(0);
        SvgManager.getInstance().setPureDrawableWithDayNightModeAutoChange((ImageView) this.f46103j.findViewById(c.a.t0.r1.e.widget_navi_back_button), c.a.t0.r1.d.ic_icon_pure_topbar_return40_svg, c.a.t0.r1.b.white_alpha100, SvgManager.SvgResourceStateType.NORMAL_PRESS);
        SvgManager.getInstance().setPureDrawableWithDayNightModeAutoChange(this.k, c.a.t0.r1.d.icon_pure_topbar_share44_svg, c.a.t0.r1.b.white_alpha100, SvgManager.SvgResourceStateType.NORMAL_PRESS);
        SkinManager.setNavbarTitleColor(this.f46103j.getCenterText(), c.a.t0.r1.b.CAM_X0105, c.a.t0.r1.b.s_navbar_title_color);
        c.a.t0.n2.a aVar = this.f46101h;
        if (aVar instanceof Activity) {
            UtilHelper.changeStatusBarIconAndTextColor(true, (Activity) aVar);
        }
    }

    public final void D() {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeV(1048579, this) == null) {
            this.G = false;
            this.p.endLoading();
        }
    }

    @Override // c.a.t0.n2.b
    public void changePkView(long j2, long j3, int i2) {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeCommon(1048580, this, new Object[]{Long.valueOf(j2), Long.valueOf(j3), Integer.valueOf(i2)}) == null) {
            this.y.changePkView(j2, j3, i2);
        }
    }

    @Override // c.a.t0.n2.b
    public c.a.t0.r1.l.d curFeedData(int i2) {
        InterceptResult invokeI;
        Interceptable interceptable = $ic;
        return (interceptable == null || (invokeI = interceptable.invokeI(1048581, this, i2)) == null) ? this.C.curFeedData(i2) : (c.a.t0.r1.l.d) invokeI.objValue;
    }

    @Override // c.a.t0.n2.b
    public int curFeedType() {
        InterceptResult invokeV;
        Interceptable interceptable = $ic;
        return (interceptable == null || (invokeV = interceptable.invokeV(1048582, this)) == null) ? this.C.curFeedType() : invokeV.intValue;
    }

    @Override // c.a.t0.n2.b
    public c.a.t0.r1.l.e curHeadData() {
        InterceptResult invokeV;
        Interceptable interceptable = $ic;
        return (interceptable == null || (invokeV = interceptable.invokeV(1048583, this)) == null) ? this.I : (c.a.t0.r1.l.e) invokeV.objValue;
    }

    @Override // c.a.t0.n2.b
    public void destroy() {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeV(InputDeviceCompat.SOURCE_TOUCHPAD, this) == null) {
            hideFullLoading();
            hideFullEmpty();
            HotTopicDetailPagerAdapter hotTopicDetailPagerAdapter = this.C;
            if (hotTopicDetailPagerAdapter != null) {
                hotTopicDetailPagerAdapter.destroy();
            }
            if (this.G) {
                D();
            }
            ValueAnimator valueAnimator = this.H;
            if (valueAnimator != null) {
                valueAnimator.cancel();
                this.H.removeAllListeners();
                this.H.removeAllUpdateListeners();
                this.H = null;
            }
            c.a.d.f.m.e.a().removeCallbacks(this.M);
        }
    }

    @Override // c.a.t0.n2.b
    public void hideFeedEmpty(int i2) {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeI(1048585, this, i2) == null) {
            this.C.hideFeedEmpty(i2);
        }
    }

    @Override // c.a.t0.n2.b
    public void hideFeedLoading(int i2) {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeI(1048586, this, i2) == null) {
            this.C.hideFeedLoading(i2);
        }
    }

    @Override // c.a.t0.n2.b
    public void hideFullEmpty() {
        c.a.s0.g0.h hVar;
        Interceptable interceptable = $ic;
        if (!(interceptable == null || interceptable.invokeV(1048587, this) == null) || (hVar = this.o) == null) {
            return;
        }
        hVar.dettachView(this.m);
        this.o = null;
    }

    @Override // c.a.t0.n2.b
    public void hideFullLoading() {
        c.a.s0.g0.g gVar;
        Interceptable interceptable = $ic;
        if (!(interceptable == null || interceptable.invokeV(1048588, this) == null) || (gVar = this.n) == null) {
            return;
        }
        gVar.dettachView(this.m);
    }

    @Override // c.a.t0.n2.b
    public void initViewPage() {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeV(1048589, this) == null) {
            this.C.initViewPage();
        }
    }

    @Override // c.a.t0.n2.b
    public void onChangeSkinType() {
        int skinType;
        Interceptable interceptable = $ic;
        if (!(interceptable == null || interceptable.invokeV(1048590, this) == null) || (skinType = TbadkCoreApplication.getInst().getSkinType()) == this.f46098e) {
            return;
        }
        this.q.onChangeSkinType(skinType);
        SkinManager.setViewTextColor(this.s, c.a.t0.r1.b.CAM_X0105, 1);
        SkinManager.setBackgroundColor(this.x, c.a.t0.r1.b.CAM_X0201);
        SkinManager.setBackgroundColor(this.f46102i, c.a.t0.r1.b.CAM_X0207);
        SkinManager.setNavbarTitleColor(this.f46103j.getCenterText(), c.a.t0.r1.b.CAM_X0105, c.a.t0.r1.b.s_navbar_title_color);
        c.a.s0.g0.g gVar = this.n;
        if (gVar != null) {
            gVar.n(SkinManager.getColor(c.a.t0.r1.b.CAM_X0201));
        }
        this.y.onChangeSkinType(skinType);
        this.D.setTabTextColors(SkinManager.getColor(c.a.t0.r1.b.CAM_X0107), SkinManager.getColor(c.a.t0.r1.b.CAM_X0105));
        this.z.onChangeSkinType(skinType);
        this.C.onChangeSkinType(skinType);
        this.f46098e = skinType;
    }

    @Override // android.view.ViewGroup, android.view.View
    public void onDetachedFromWindow() {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeV(1048591, this) == null) {
            destroy();
            super.onDetachedFromWindow();
        }
    }

    @Override // c.a.t0.n2.b
    public void pause() {
        HotTopicDetailPagerAdapter hotTopicDetailPagerAdapter;
        Interceptable interceptable = $ic;
        if (!(interceptable == null || interceptable.invokeV(1048592, this) == null) || (hotTopicDetailPagerAdapter = this.C) == null) {
            return;
        }
        hotTopicDetailPagerAdapter.pause();
    }

    @Override // c.a.t0.n2.b
    public void refreshPkAndBless(c.a.t0.r1.l.e eVar) {
        c.a.t0.r1.l.a aVar;
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeL(1048593, this, eVar) == null) {
            if (eVar.c() != null) {
                aVar = eVar.c();
                aVar.f21835i = 3;
            } else if (eVar.d() != null) {
                aVar = eVar.d();
                aVar.f21835i = 2;
            } else if (eVar.m() != null) {
                aVar = eVar.m();
                aVar.f21835i = 1;
            } else {
                aVar = null;
            }
            this.q.setBlessInfo(aVar);
            if (eVar.g() == null) {
                this.y.setVisibility(8);
                return;
            }
            this.y.setVisibility(0);
            this.y.bindData(eVar.g());
        }
    }

    @Override // c.a.t0.n2.b
    public void resume() {
        HotTopicDetailPagerAdapter hotTopicDetailPagerAdapter;
        Interceptable interceptable = $ic;
        if (!(interceptable == null || interceptable.invokeV(1048594, this) == null) || (hotTopicDetailPagerAdapter = this.C) == null) {
            return;
        }
        hotTopicDetailPagerAdapter.resume();
    }

    @Override // c.a.t0.n2.b
    public void showBlessView(long j2, long j3) {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeCommon(1048595, this, new Object[]{Long.valueOf(j2), Long.valueOf(j3)}) == null) {
            this.q.changeBlessView(j2, j3);
        }
    }

    @Override // c.a.t0.n2.b
    public void showFeedEmpty(boolean z, int i2) {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeCommon(1048596, this, new Object[]{Boolean.valueOf(z), Integer.valueOf(i2)}) == null) {
            this.C.showFeedEmpty(z, i2);
        }
    }

    @Override // c.a.t0.n2.b
    public void showFeedLoading(int i2) {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeI(1048597, this, i2) == null) {
            this.C.showFeedLoading(i2);
        }
    }

    @Override // c.a.t0.n2.b
    public void showFeedView(c.a.t0.r1.l.d dVar, boolean z, int i2) {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeCommon(1048598, this, new Object[]{dVar, Boolean.valueOf(z), Integer.valueOf(i2)}) == null) {
            c.a.t0.r1.l.e eVar = this.I;
            if (eVar != null) {
                this.C.setRecommendForumInfoListData(eVar.e());
            }
            this.C.showFeedView(dVar, z, i2);
        }
    }

    @Override // c.a.t0.n2.b
    public void showFullEmpty(boolean z) {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeZ(1048599, this, z) == null) {
            c.a.s0.g0.h hVar = this.o;
            if (hVar == null || !hVar.isViewAttached()) {
                if (this.o == null) {
                    this.o = new c.a.s0.g0.h(getContext(), new h(this));
                }
                this.o.k(this.f46100g.getResources().getDimensionPixelSize(c.a.t0.r1.c.ds360));
                this.o.attachView(this.m, false);
                this.o.f(c.a.t0.r1.b.CAM_X0201);
                this.o.p();
            }
        }
    }

    @Override // c.a.t0.n2.b
    public void showFullLoading() {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeV(1048600, this) == null) {
            if (this.n == null) {
                c.a.s0.g0.g gVar = new c.a.s0.g0.g(getContext(), getContext().getResources().getDimensionPixelSize(c.a.t0.r1.c.ds386));
                this.n = gVar;
                gVar.n(SkinManager.getColor(c.a.t0.r1.b.CAM_X0201));
            }
            this.n.attachView(this.m, false);
        }
    }

    @Override // c.a.t0.n2.b
    public void showHasDeleteEmpty(boolean z) {
        int i2;
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeZ(1048601, this, z) == null) {
            ShadowLayout w = w(this.r);
            if (!z) {
                if (w != null) {
                    w.setVisibility(0);
                    return;
                }
                return;
            }
            if (w != null) {
                w.setVisibility(8);
            }
            if (this.o == null) {
                this.o = new c.a.s0.g0.h(this.f46100g.getPageActivity(), null);
            }
            this.o.k(this.f46100g.getResources().getDimensionPixelSize(c.a.t0.r1.c.ds360));
            this.o.e();
            this.o.f(c.a.t0.r1.b.CAM_X0201);
            this.o.i(c.a.t0.r1.d.new_pic_emotion_06);
            this.o.o(this.f46100g.getString(c.a.t0.r1.h.hot_topic_deleted_empty_title));
            this.o.attachView(this.m, false);
            c.a.t0.n2.a aVar = this.f46101h;
            if (!(aVar instanceof Activity) || (i2 = this.f46098e) == 1 || i2 == 4) {
                return;
            }
            UtilHelper.changeStatusBarIconAndTextColor(false, (Activity) aVar);
        }
    }

    @Override // c.a.t0.n2.b
    public void showHeadView(@NonNull c.a.t0.r1.l.e eVar) {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeL(1048602, this, eVar) == null) {
            this.I = eVar;
            if (eVar.h() != null) {
                this.A.e(this.I.h().f21857e);
                this.A.d(this.I.h().f21858f);
            }
            z(eVar);
        }
    }

    @Override // c.a.t0.n2.b
    public void stopPullRefresh() {
        Interceptable interceptable = $ic;
        if ((interceptable == null || interceptable.invokeV(1048603, this) == null) && this.G) {
            D();
            c.a.d.f.m.e.a().removeCallbacks(this.M);
        }
    }

    public final void u() {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeV(1048604, this) == null) {
            c.a.d.f.m.e.a().postDelayed(this.M, 5000L);
            this.G = true;
            this.f46101h.refreshFullData(curFeedType());
        }
    }

    public final void v() {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeV(1048605, this) == null) {
            SpannableStringBuilder spannableStringBuilder = new SpannableStringBuilder();
            spannableStringBuilder.append((CharSequence) this.t);
            String string = getResources().getString(c.a.t0.r1.h.hot_topic_detail);
            SpannableStringBuilder spannableStringBuilder2 = (SpannableStringBuilder) spannableStringBuilder.subSequence(0, (this.s.getLayout().getLineEnd(1) - string.length()) - 2);
            spannableStringBuilder2.append((CharSequence) "...  ");
            int length = spannableStringBuilder2.length();
            spannableStringBuilder2.append((CharSequence) string);
            SpannableString spannableString = new SpannableString(spannableStringBuilder2);
            spannableString.setSpan(this.N, length - 1, spannableString.length(), 33);
            this.s.setText(spannableString);
            TextView textView = this.s;
            textView.setHeight(textView.getLineHeight() * 2);
            this.s.scrollTo(0, 0);
            this.s.requestLayout();
        }
    }

    public final void x(c.a.t0.r1.l.f fVar) {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeL(1048606, this, fVar) == null) {
            if (StringUtils.isNull(fVar.f21859g)) {
                this.s.setVisibility(8);
            } else {
                this.s.setText(fVar.f21859g);
            }
        }
    }

    public final void y() {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeV(1048607, this) == null) {
            if (this.f46099f + this.f46103j.getHeight() >= this.v.getY()) {
                SkinManager.setBackgroundColor(this.D, c.a.t0.r1.b.CAM_X0207);
                if (this.f46098e == 0) {
                    this.E.setVisibility(0);
                    return;
                }
                return;
            }
            SkinManager.setBackgroundColor(this.D, c.a.t0.r1.b.transparent);
            this.E.setVisibility(8);
        }
    }

    public final void z(@NonNull c.a.t0.r1.l.e eVar) {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeL(1048608, this, eVar) == null) {
            C();
            this.q.setTopicInfo(eVar.h());
            if (SwitchManager.getInstance().findType(IColorSDKSwitch.KEY) == 1 && eVar.h() != null && !TextUtils.isEmpty(eVar.h().f21862j)) {
                c.a.d.f.l.d.h().m(eVar.h().f21862j, 39, this.L, this.f46100g.getUniqueId());
            }
            x(eVar.h());
            refreshPkAndBless(eVar);
            List<c.a.d.n.e.n> l = eVar.l();
            if (ListUtils.isEmpty(l)) {
                this.z.setVisibility(8);
            } else {
                this.z.setData(l);
                this.z.setVisibility(0);
            }
            if (eVar.h() != null) {
                String str = eVar.h().f21858f;
                if (o0.d(str) > 15) {
                    str = o0.n(str, 15) + "...";
                }
                this.f46103j.setCenterTextTitle(String.format(getContext().getString(c.a.t0.r1.h.hot_topic_detail_write_name), str));
            }
        }
    }
}
