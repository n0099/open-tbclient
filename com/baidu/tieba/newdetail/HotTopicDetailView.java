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
import c.a.d.f.p.k;
import c.a.d.f.p.m;
import c.a.d.m.e.n;
import c.a.n0.a;
import c.a.r0.d1.o0;
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
import java.io.ByteArrayOutputStream;
import java.io.IOException;
import java.util.List;
@SuppressLint({"ViewConstructor"})
/* loaded from: classes12.dex */
public class HotTopicDetailView extends RelativeLayout implements c.a.s0.m2.b {
    public static /* synthetic */ Interceptable $ic;
    public static int P;
    public transient /* synthetic */ FieldHolder $fh;
    public c.a.s0.q1.k.c A;
    public CustomViewPager B;
    public HotTopicDetailPagerAdapter C;
    public TbTabLayout D;
    public View E;
    public RecyclerView.OnScrollListener F;
    public boolean G;
    public ValueAnimator H;
    public c.a.s0.q1.l.e I;
    public AppBarLayout.OnOffsetChangedListener J;
    public c.a.r0.s.i0.q.b K;
    public final c.a.d.f.l.c<c.a.d.m.d.a> L;
    public Runnable M;
    public ClickableSpan N;
    public ClickableSpan O;

    /* renamed from: e  reason: collision with root package name */
    public int f47631e;

    /* renamed from: f  reason: collision with root package name */
    public int f47632f;

    /* renamed from: g  reason: collision with root package name */
    public TbPageContext<HotTopicDetailActivity> f47633g;

    /* renamed from: h  reason: collision with root package name */
    public c.a.s0.m2.a f47634h;

    /* renamed from: i  reason: collision with root package name */
    public View f47635i;

    /* renamed from: j  reason: collision with root package name */
    public NavigationBar f47636j;

    /* renamed from: k  reason: collision with root package name */
    public ImageView f47637k;
    public boolean l;
    public ViewGroup m;
    public c.a.r0.g0.g n;
    public c.a.r0.g0.h o;
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
        public final /* synthetic */ HotTopicDetailView f47638e;

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
            this.f47638e = hotTopicDetailView;
        }

        @Override // android.text.style.ClickableSpan
        public void onClick(View view) {
            Interceptable interceptable = $ic;
            if (interceptable == null || interceptable.invokeL(1048576, this, view) == null) {
                this.f47638e.s.setText(this.f47638e.t);
                this.f47638e.y();
            }
        }

        @Override // android.text.style.ClickableSpan, android.text.style.CharacterStyle
        public void updateDrawState(TextPaint textPaint) {
            Interceptable interceptable = $ic;
            if (interceptable == null || interceptable.invokeL(Constants.METHOD_GET_CONTACTER_INFO_FOR_SESSION, this, textPaint) == null) {
                textPaint.setColor(this.f47638e.getResources().getColor(c.a.s0.q1.b.CAM_X0304));
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
                this.a.B();
            }
        }
    }

    /* loaded from: classes12.dex */
    public class c implements View.OnClickListener {
        public static /* synthetic */ Interceptable $ic;
        public transient /* synthetic */ FieldHolder $fh;

        /* renamed from: e  reason: collision with root package name */
        public final /* synthetic */ HotTopicDetailView f47639e;

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
            this.f47639e = hotTopicDetailView;
        }

        @Override // android.view.View.OnClickListener
        public void onClick(View view) {
            Interceptable interceptable = $ic;
            if (interceptable == null || interceptable.invokeL(1048576, this, view) == null) {
                c.a.s0.m2.c.e(this.f47639e.f47633g, "c14389");
                if (!k.z()) {
                    this.f47639e.f47633g.showToast(c.a.s0.q1.h.topic_share_no_network);
                    return;
                }
                MessageManager.getInstance().dispatchResponsedMessage(new CustomResponsedMessage(2004011));
                if (ShareSwitch.isOn() || ViewHelper.checkUpIsLogin(this.f47639e.f47637k.getContext())) {
                    this.f47639e.f47634h.shareTopic(this.f47639e.I);
                }
            }
        }
    }

    /* loaded from: classes12.dex */
    public class d implements Runnable {
        public static /* synthetic */ Interceptable $ic;
        public transient /* synthetic */ FieldHolder $fh;

        /* renamed from: e  reason: collision with root package name */
        public final /* synthetic */ HotTopicDetailView f47640e;

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
            this.f47640e = hotTopicDetailView;
        }

        @Override // java.lang.Runnable
        public void run() {
            Interceptable interceptable = $ic;
            if (interceptable == null || interceptable.invokeV(1048576, this) == null) {
                this.f47640e.x.setMinimumHeight(this.f47640e.f47636j.getHeight() + this.f47640e.f47632f);
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
                this.a.D(i2);
            }
        }
    }

    /* loaded from: classes12.dex */
    public class f implements c.a.r0.s.i0.q.b {
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

        @Override // c.a.r0.s.i0.q.b
        public void a() {
            Interceptable interceptable = $ic;
            if (interceptable == null || interceptable.invokeV(1048576, this) == null) {
            }
        }

        @Override // c.a.r0.s.i0.q.b
        public void onLoadingStart() {
            Interceptable interceptable = $ic;
            if (interceptable == null || interceptable.invokeV(Constants.METHOD_GET_CONTACTER_INFO_FOR_SESSION, this) == null) {
                this.a.x();
            }
        }
    }

    /* loaded from: classes12.dex */
    public class g extends c.a.d.f.l.c<c.a.d.m.d.a> {
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
        public void onLoaded(c.a.d.m.d.a aVar, String str, int i2) {
            Bitmap p;
            byte[] w;
            boolean z;
            int d2;
            Interceptable interceptable = $ic;
            if (interceptable == null || interceptable.invokeLLI(1048576, this, aVar, str, i2) == null) {
                super.onLoaded((g) aVar, str, i2);
                if (aVar == null || !aVar.w() || (p = aVar.p()) == null || (w = this.a.w(p, Bitmap.CompressFormat.JPEG, 100)) == null) {
                    return;
                }
                a.C0188a c0188a = new a.C0188a();
                c0188a.c(Tri.TRUE);
                c0188a.b(Tri.TRUE);
                c0188a.d(50, 100);
                c0188a.e(40, 80);
                String c2 = SmartColorSDK.b().c(c0188a.a(), w, w.length);
                if (TextUtils.isEmpty(c2) || (d2 = c.a.s0.v3.c.d(c2)) == Integer.MAX_VALUE) {
                    z = false;
                } else {
                    z = true;
                    if (this.a.r != null) {
                        HotTopicDetailView.setWriteViewStyle(this.a.r, d2);
                    }
                    if (this.a.q != null) {
                        this.a.q.setBgCoverViewColor(c.a.s0.v3.c.a(d2, 0.5f));
                    }
                    if (this.a.D != null) {
                        this.a.D.setSelectedTabIndicatorColor(d2);
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
        public final /* synthetic */ HotTopicDetailView f47641e;

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
            this.f47641e = hotTopicDetailView;
        }

        @Override // android.view.View.OnClickListener
        public void onClick(View view) {
            Interceptable interceptable = $ic;
            if ((interceptable == null || interceptable.invokeL(1048576, this, view) == null) && k.A() && this.f47641e.f47634h != null) {
                this.f47641e.f47634h.refreshFullData(1);
            }
        }
    }

    /* loaded from: classes12.dex */
    public class i implements Runnable {
        public static /* synthetic */ Interceptable $ic;
        public transient /* synthetic */ FieldHolder $fh;

        /* renamed from: e  reason: collision with root package name */
        public final /* synthetic */ HotTopicDetailView f47642e;

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
            this.f47642e = hotTopicDetailView;
        }

        @Override // java.lang.Runnable
        public void run() {
            Interceptable interceptable = $ic;
            if ((interceptable == null || interceptable.invokeV(1048576, this) == null) && this.f47642e.G) {
                this.f47642e.G();
            }
        }
    }

    /* loaded from: classes12.dex */
    public class j extends ClickableSpan {
        public static /* synthetic */ Interceptable $ic;
        public transient /* synthetic */ FieldHolder $fh;

        /* renamed from: e  reason: collision with root package name */
        public final /* synthetic */ HotTopicDetailView f47643e;

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
            this.f47643e = hotTopicDetailView;
        }

        @Override // android.text.style.ClickableSpan
        public void onClick(View view) {
            Interceptable interceptable = $ic;
            if (interceptable == null || interceptable.invokeL(1048576, this, view) == null) {
                SpannableStringBuilder spannableStringBuilder = new SpannableStringBuilder();
                spannableStringBuilder.append((CharSequence) this.f47643e.t);
                if (this.f47643e.t.length() > 500) {
                    spannableStringBuilder.append((CharSequence) "...  ");
                }
                String str = this.f47643e.getResources().getString(c.a.s0.q1.h.hot_topic_coll) + GlideException.IndentedAppendable.INDENT;
                spannableStringBuilder.append((CharSequence) str);
                SpannableString spannableString = new SpannableString(spannableStringBuilder);
                spannableString.setSpan(this.f47643e.O, spannableString.length() - str.length(), spannableString.length(), 33);
                this.f47643e.s.setText(spannableString);
                this.f47643e.s.setHeight(this.f47643e.u * this.f47643e.s.getLineHeight());
                int lineCount = this.f47643e.s.getLineCount() * this.f47643e.s.getLineHeight();
                if (lineCount > this.f47643e.u * this.f47643e.s.getLineHeight()) {
                    this.f47643e.s.scrollTo(0, lineCount - (this.f47643e.u * this.f47643e.s.getLineHeight()));
                }
                this.f47643e.s.requestLayout();
            }
        }

        @Override // android.text.style.ClickableSpan, android.text.style.CharacterStyle
        public void updateDrawState(TextPaint textPaint) {
            Interceptable interceptable = $ic;
            if (interceptable == null || interceptable.invokeL(Constants.METHOD_GET_CONTACTER_INFO_FOR_SESSION, this, textPaint) == null) {
                textPaint.setColor(this.f47643e.getResources().getColor(c.a.s0.q1.b.CAM_X0304));
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
        P = TbadkCoreApplication.getInst().getResources().getDimensionPixelSize(c.a.s0.q1.c.tbds250);
    }

    /* JADX WARN: 'super' call moved to the top of the method (can break code semantics) */
    public HotTopicDetailView(TbPageContext<?> tbPageContext, c.a.s0.m2.a aVar, Bundle bundle) {
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
        this.f47631e = 3;
        this.f47632f = UtilHelper.getStatusBarHeight();
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
        this.f47633g = tbPageContext;
        this.f47634h = aVar;
        E(bundle);
        onChangeSkinType();
    }

    public static void setWriteViewStyle(@NonNull TextView textView, @ColorInt int i2) {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeLI(65557, null, textView, i2) == null) {
            c.a.r0.s.v.c d2 = c.a.r0.s.v.c.d(textView);
            d2.n(c.a.s0.q1.h.J_X01);
            d2.v(c.a.s0.q1.b.CAM_X0101);
            d2.g(i2);
            textView.setCompoundDrawablesWithIntrinsicBounds(WebPManager.getPureDrawable(c.a.s0.q1.d.icon_pure_topic_post48, SkinManager.getColor(c.a.s0.q1.b.CAM_X0101), null), (Drawable) null, (Drawable) null, (Drawable) null);
            ShadowLayout z = z(textView);
            if (z != null) {
                z.setPadding(c.a.s0.q1.c.ds10).setRadius(c.a.s0.q1.c.ds90).setOffset(c.a.s0.q1.c.ds0, c.a.s0.q1.c.ds4).setColor(c.a.s0.v3.c.a(i2, 0.5f)).buildShadow();
            }
        }
    }

    @Nullable
    public static ShadowLayout z(@NonNull TextView textView) {
        InterceptResult invokeL;
        Interceptable interceptable = $ic;
        if (interceptable == null || (invokeL = interceptable.invokeL(65561, null, textView)) == null) {
            ViewParent parent = textView.getParent();
            if (parent instanceof ShadowLayout) {
                return (ShadowLayout) parent;
            }
            return null;
        }
        return (ShadowLayout) invokeL.objValue;
    }

    public final void A(c.a.s0.q1.l.f fVar) {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeL(1048576, this, fVar) == null) {
            if (StringUtils.isNull(fVar.f21637g)) {
                this.s.setVisibility(8);
            } else {
                this.s.setText(fVar.f21637g);
            }
        }
    }

    public final void B() {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeV(Constants.METHOD_GET_CONTACTER_INFO_FOR_SESSION, this) == null) {
            if (this.f47632f + this.f47636j.getHeight() >= this.v.getY()) {
                SkinManager.setBackgroundColor(this.D, c.a.s0.q1.b.CAM_X0207);
                if (this.f47631e == 0) {
                    this.E.setVisibility(0);
                    return;
                }
                return;
            }
            SkinManager.setBackgroundColor(this.D, c.a.s0.q1.b.transparent);
            this.E.setVisibility(8);
        }
    }

    public final void C(@NonNull c.a.s0.q1.l.e eVar) {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeL(Constants.METHOD_SEND_USER_MSG, this, eVar) == null) {
            F();
            this.q.setTopicInfo(eVar.h());
            if (SwitchManager.getInstance().findType(IColorSDKSwitch.KEY) == 1 && eVar.h() != null && !TextUtils.isEmpty(eVar.h().f21640j)) {
                c.a.d.f.l.d.h().m(eVar.h().f21640j, 39, this.L, this.f47633g.getUniqueId());
            }
            A(eVar.h());
            refreshPkAndBless(eVar);
            List<n> l = eVar.l();
            if (ListUtils.isEmpty(l)) {
                this.z.setVisibility(8);
            } else {
                this.z.setData(l);
                this.z.setVisibility(0);
            }
            if (eVar.h() != null) {
                String str = eVar.h().f21636f;
                if (o0.d(str) > 15) {
                    str = o0.m(str, 15) + "...";
                }
                this.f47636j.setCenterTextTitle(String.format(getContext().getString(c.a.s0.q1.h.hot_topic_detail_write_name), str));
            }
        }
    }

    public final void D(int i2) {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeI(1048579, this, i2) == null) {
            int i3 = i2 + P;
            if (i3 < 0) {
                i3 = 0;
            }
            float f2 = 1.0f - ((i3 * 1.0f) / P);
            this.f47635i.setAlpha(f2);
            this.f47636j.getCenterText().setAlpha(f2);
            B();
            double d2 = f2;
            if (d2 > 0.1d) {
                StatusbarColorUtils.setStatusBarDarkIcon(this.f47633g.getPageActivity().getWindow(), true);
            } else {
                StatusbarColorUtils.setStatusBarDarkIcon(this.f47633g.getPageActivity().getWindow(), false);
            }
            if ((d2 > 0.3d && this.f47631e == 0) || this.I == null) {
                SvgManager.getInstance().setPureDrawableWithDayNightModeAutoChange((ImageView) this.f47636j.findViewById(c.a.s0.q1.e.widget_navi_back_button), c.a.s0.q1.d.ic_icon_pure_topbar_return40_svg, c.a.s0.q1.b.CAM_X0105, SvgManager.SvgResourceStateType.NORMAL_PRESS);
                SvgManager.getInstance().setPureDrawableWithDayNightModeAutoChange(this.f47637k, c.a.s0.q1.d.icon_pure_topbar_share44_svg, c.a.s0.q1.b.CAM_X0105, SvgManager.SvgResourceStateType.NORMAL_PRESS);
                return;
            }
            SvgManager.getInstance().setPureDrawableWithDayNightModeAutoChange((ImageView) this.f47636j.findViewById(c.a.s0.q1.e.widget_navi_back_button), c.a.s0.q1.d.ic_icon_pure_topbar_return40_svg, c.a.s0.q1.b.white_alpha100, SvgManager.SvgResourceStateType.NORMAL_PRESS);
            SvgManager.getInstance().setPureDrawableWithDayNightModeAutoChange(this.f47637k, c.a.s0.q1.d.icon_pure_topbar_share44_svg, c.a.s0.q1.b.white_alpha100, SvgManager.SvgResourceStateType.NORMAL_PRESS);
        }
    }

    public final void E(Bundle bundle) {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeL(1048580, this, bundle) == null) {
            LayoutInflater.from(getContext()).inflate(c.a.s0.q1.f.activity_hot_topic_detail_layout, (ViewGroup) this, true);
            View findViewById = findViewById(c.a.s0.q1.e.topBgView);
            this.f47635i = findViewById;
            findViewById.setAlpha(0.0f);
            NavigationBar navigationBar = (NavigationBar) findViewById(c.a.s0.q1.e.viewNavigationBar);
            this.f47636j = navigationBar;
            navigationBar.addSystemImageButton(NavigationBar.ControlAlign.HORIZONTAL_LEFT, NavigationBar.ControlType.BACK_BUTTON);
            this.f47636j.getCenterText().setAlpha(0.0f);
            ImageView imageView = (ImageView) this.f47636j.addCustomView(NavigationBar.ControlAlign.HORIZONTAL_RIGHT, c.a.s0.q1.f.hot_topic_share, new c(this));
            this.f47637k = imageView;
            imageView.setVisibility(4);
            View findViewById2 = findViewById(c.a.s0.q1.e.statusBarViewHolder);
            ViewGroup.LayoutParams layoutParams = findViewById2.getLayoutParams();
            layoutParams.height = this.f47632f;
            findViewById2.setLayoutParams(layoutParams);
            this.m = (ViewGroup) findViewById(c.a.s0.q1.e.contentRootLayout);
            LottieSlideLoadingLayout lottieSlideLoadingLayout = (LottieSlideLoadingLayout) findViewById(c.a.s0.q1.e.contentLayout);
            this.p = lottieSlideLoadingLayout;
            lottieSlideLoadingLayout.addLoadingListener(this.K);
            this.p.bringLoadViewToFront();
            HotTopicDetailHeadView hotTopicDetailHeadView = (HotTopicDetailHeadView) findViewById(c.a.s0.q1.e.hotTopicDetailHeadView);
            this.q = hotTopicDetailHeadView;
            this.p.addSyncHeightView(hotTopicDetailHeadView);
            this.x = findViewById(c.a.s0.q1.e.headerContainerLayout);
            this.f47636j.post(new d(this));
            this.s = (TextView) findViewById(c.a.s0.q1.e.hotTopicInfoAbstract);
            this.y = (HotTopicDetailPkLayout) findViewById(c.a.s0.q1.e.hotTopicDetailPkView);
            HotTopicDetailSpecialLayout hotTopicDetailSpecialLayout = (HotTopicDetailSpecialLayout) findViewById(c.a.s0.q1.e.hotTopicDetailSpecialLayout);
            this.z = hotTopicDetailSpecialLayout;
            hotTopicDetailSpecialLayout.initAdapters(this.f47633g);
            this.v = findViewById(c.a.s0.q1.e.contentContainer);
            AppBarLayout appBarLayout = (AppBarLayout) findViewById(c.a.s0.q1.e.appBarLayout);
            this.w = appBarLayout;
            appBarLayout.addOnOffsetChangedListener(this.J);
            this.B = (CustomViewPager) findViewById(c.a.s0.q1.e.hotTopicViewPager);
            HotTopicDetailPagerAdapter hotTopicDetailPagerAdapter = new HotTopicDetailPagerAdapter(getContext());
            this.C = hotTopicDetailPagerAdapter;
            hotTopicDetailPagerAdapter.setScrollListener(this.F);
            this.B.setAdapter(this.C);
            TbTabLayout tbTabLayout = (TbTabLayout) findViewById(c.a.s0.q1.e.tabLayout);
            this.D = tbTabLayout;
            tbTabLayout.setSelectedTabTextBlod(true);
            this.D.setTabTextSize(m.f(TbadkCoreApplication.getInst().getContext(), c.a.s0.q1.c.tbds46));
            this.D.setSelectedTabIndicatorColor(SkinManager.getColor(c.a.s0.q1.b.CAM_X0302));
            this.D.setupWithViewPager(this.B);
            this.E = findViewById(c.a.s0.q1.e.dividerShadow);
            TextView textView = (TextView) findViewById(c.a.s0.q1.e.topic_post_forum_button);
            this.r = textView;
            this.A = new c.a.s0.q1.k.c(textView, this.f47633g);
        }
    }

    public final void F() {
        Interceptable interceptable = $ic;
        if (!(interceptable == null || interceptable.invokeV(1048581, this) == null) || this.l) {
            return;
        }
        this.l = true;
        this.f47637k.setVisibility(0);
        SvgManager.getInstance().setPureDrawableWithDayNightModeAutoChange((ImageView) this.f47636j.findViewById(c.a.s0.q1.e.widget_navi_back_button), c.a.s0.q1.d.ic_icon_pure_topbar_return40_svg, c.a.s0.q1.b.white_alpha100, SvgManager.SvgResourceStateType.NORMAL_PRESS);
        SvgManager.getInstance().setPureDrawableWithDayNightModeAutoChange(this.f47637k, c.a.s0.q1.d.icon_pure_topbar_share44_svg, c.a.s0.q1.b.white_alpha100, SvgManager.SvgResourceStateType.NORMAL_PRESS);
        SkinManager.setNavbarTitleColor(this.f47636j.getCenterText(), c.a.s0.q1.b.CAM_X0105, c.a.s0.q1.b.s_navbar_title_color);
        c.a.s0.m2.a aVar = this.f47634h;
        if (aVar instanceof Activity) {
            UtilHelper.changeStatusBarIconAndTextColor(true, (Activity) aVar);
        }
    }

    public final void G() {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeV(1048582, this) == null) {
            this.G = false;
            this.p.endLoading();
        }
    }

    @Override // c.a.s0.m2.b
    public void changePkView(long j2, long j3, int i2) {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeCommon(1048583, this, new Object[]{Long.valueOf(j2), Long.valueOf(j3), Integer.valueOf(i2)}) == null) {
            this.y.changePkView(j2, j3, i2);
        }
    }

    @Override // c.a.s0.m2.b
    public c.a.s0.q1.l.d curFeedData(int i2) {
        InterceptResult invokeI;
        Interceptable interceptable = $ic;
        return (interceptable == null || (invokeI = interceptable.invokeI(InputDeviceCompat.SOURCE_TOUCHPAD, this, i2)) == null) ? this.C.curFeedData(i2) : (c.a.s0.q1.l.d) invokeI.objValue;
    }

    @Override // c.a.s0.m2.b
    public int curFeedType() {
        InterceptResult invokeV;
        Interceptable interceptable = $ic;
        return (interceptable == null || (invokeV = interceptable.invokeV(1048585, this)) == null) ? this.C.curFeedType() : invokeV.intValue;
    }

    @Override // c.a.s0.m2.b
    public c.a.s0.q1.l.e curHeadData() {
        InterceptResult invokeV;
        Interceptable interceptable = $ic;
        return (interceptable == null || (invokeV = interceptable.invokeV(1048586, this)) == null) ? this.I : (c.a.s0.q1.l.e) invokeV.objValue;
    }

    @Override // c.a.s0.m2.b
    public void destroy() {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeV(1048587, this) == null) {
            hideFullLoading();
            hideFullEmpty();
            HotTopicDetailPagerAdapter hotTopicDetailPagerAdapter = this.C;
            if (hotTopicDetailPagerAdapter != null) {
                hotTopicDetailPagerAdapter.destroy();
            }
            if (this.G) {
                G();
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

    @Override // c.a.s0.m2.b
    public void hideFeedEmpty(int i2) {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeI(1048588, this, i2) == null) {
            this.C.hideFeedEmpty(i2);
        }
    }

    @Override // c.a.s0.m2.b
    public void hideFeedLoading(int i2) {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeI(1048589, this, i2) == null) {
            this.C.hideFeedLoading(i2);
        }
    }

    @Override // c.a.s0.m2.b
    public void hideFullEmpty() {
        c.a.r0.g0.h hVar;
        Interceptable interceptable = $ic;
        if (!(interceptable == null || interceptable.invokeV(1048590, this) == null) || (hVar = this.o) == null) {
            return;
        }
        hVar.dettachView(this.m);
        this.o = null;
    }

    @Override // c.a.s0.m2.b
    public void hideFullLoading() {
        c.a.r0.g0.g gVar;
        Interceptable interceptable = $ic;
        if (!(interceptable == null || interceptable.invokeV(1048591, this) == null) || (gVar = this.n) == null) {
            return;
        }
        gVar.dettachView(this.m);
    }

    @Override // c.a.s0.m2.b
    public void initViewPage() {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeV(1048592, this) == null) {
            this.C.initViewPage();
        }
    }

    @Override // c.a.s0.m2.b
    public void onChangeSkinType() {
        int skinType;
        Interceptable interceptable = $ic;
        if (!(interceptable == null || interceptable.invokeV(1048593, this) == null) || (skinType = TbadkCoreApplication.getInst().getSkinType()) == this.f47631e) {
            return;
        }
        this.q.onChangeSkinType(skinType);
        SkinManager.setViewTextColor(this.s, c.a.s0.q1.b.CAM_X0105, 1);
        SkinManager.setBackgroundColor(this.x, c.a.s0.q1.b.CAM_X0201);
        SkinManager.setBackgroundColor(this.f47635i, c.a.s0.q1.b.CAM_X0207);
        SkinManager.setNavbarTitleColor(this.f47636j.getCenterText(), c.a.s0.q1.b.CAM_X0105, c.a.s0.q1.b.s_navbar_title_color);
        c.a.r0.g0.g gVar = this.n;
        if (gVar != null) {
            gVar.n(SkinManager.getColor(c.a.s0.q1.b.CAM_X0201));
        }
        this.y.onChangeSkinType(skinType);
        this.D.setTabTextColors(SkinManager.getColor(c.a.s0.q1.b.CAM_X0107), SkinManager.getColor(c.a.s0.q1.b.CAM_X0105));
        this.z.onChangeSkinType(skinType);
        this.C.onChangeSkinType(skinType);
        this.f47631e = skinType;
    }

    @Override // android.view.ViewGroup, android.view.View
    public void onDetachedFromWindow() {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeV(1048594, this) == null) {
            destroy();
            super.onDetachedFromWindow();
        }
    }

    @Override // c.a.s0.m2.b
    public void pause() {
        HotTopicDetailPagerAdapter hotTopicDetailPagerAdapter;
        Interceptable interceptable = $ic;
        if (!(interceptable == null || interceptable.invokeV(1048595, this) == null) || (hotTopicDetailPagerAdapter = this.C) == null) {
            return;
        }
        hotTopicDetailPagerAdapter.pause();
    }

    @Override // c.a.s0.m2.b
    public void refreshPkAndBless(c.a.s0.q1.l.e eVar) {
        c.a.s0.q1.l.a aVar;
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeL(1048596, this, eVar) == null) {
            if (eVar.c() != null) {
                aVar = eVar.c();
                aVar.f21611i = 3;
            } else if (eVar.d() != null) {
                aVar = eVar.d();
                aVar.f21611i = 2;
            } else if (eVar.m() != null) {
                aVar = eVar.m();
                aVar.f21611i = 1;
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

    @Override // c.a.s0.m2.b
    public void resume() {
        HotTopicDetailPagerAdapter hotTopicDetailPagerAdapter;
        Interceptable interceptable = $ic;
        if (!(interceptable == null || interceptable.invokeV(1048597, this) == null) || (hotTopicDetailPagerAdapter = this.C) == null) {
            return;
        }
        hotTopicDetailPagerAdapter.resume();
    }

    @Override // c.a.s0.m2.b
    public void showBlessView(long j2, long j3) {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeCommon(1048598, this, new Object[]{Long.valueOf(j2), Long.valueOf(j3)}) == null) {
            this.q.changeBlessView(j2, j3);
        }
    }

    @Override // c.a.s0.m2.b
    public void showFeedEmpty(boolean z, int i2) {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeCommon(1048599, this, new Object[]{Boolean.valueOf(z), Integer.valueOf(i2)}) == null) {
            this.C.showFeedEmpty(z, i2);
        }
    }

    @Override // c.a.s0.m2.b
    public void showFeedLoading(int i2) {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeI(1048600, this, i2) == null) {
            this.C.showFeedLoading(i2);
        }
    }

    @Override // c.a.s0.m2.b
    public void showFeedView(c.a.s0.q1.l.d dVar, boolean z, int i2) {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeCommon(1048601, this, new Object[]{dVar, Boolean.valueOf(z), Integer.valueOf(i2)}) == null) {
            c.a.s0.q1.l.e eVar = this.I;
            if (eVar != null) {
                this.C.setRecommendForumInfoListData(eVar.e());
            }
            this.C.showFeedView(dVar, z, i2);
        }
    }

    @Override // c.a.s0.m2.b
    public void showFullEmpty(boolean z) {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeZ(1048602, this, z) == null) {
            c.a.r0.g0.h hVar = this.o;
            if (hVar == null || !hVar.isViewAttached()) {
                if (this.o == null) {
                    this.o = new c.a.r0.g0.h(getContext(), new h(this));
                }
                this.o.k(this.f47633g.getResources().getDimensionPixelSize(c.a.s0.q1.c.ds360));
                this.o.attachView(this.m, false);
                this.o.f(c.a.s0.q1.b.CAM_X0201);
                this.o.p();
            }
        }
    }

    @Override // c.a.s0.m2.b
    public void showFullLoading() {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeV(1048603, this) == null) {
            if (this.n == null) {
                c.a.r0.g0.g gVar = new c.a.r0.g0.g(getContext(), getContext().getResources().getDimensionPixelSize(c.a.s0.q1.c.ds386));
                this.n = gVar;
                gVar.n(SkinManager.getColor(c.a.s0.q1.b.CAM_X0201));
            }
            this.n.attachView(this.m, false);
        }
    }

    @Override // c.a.s0.m2.b
    public void showHasDeleteEmpty(boolean z) {
        int i2;
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeZ(1048604, this, z) == null) {
            ShadowLayout z2 = z(this.r);
            if (!z) {
                if (z2 != null) {
                    z2.setVisibility(0);
                    return;
                }
                return;
            }
            if (z2 != null) {
                z2.setVisibility(8);
            }
            if (this.o == null) {
                this.o = new c.a.r0.g0.h(this.f47633g.getPageActivity(), null);
            }
            this.o.k(this.f47633g.getResources().getDimensionPixelSize(c.a.s0.q1.c.ds360));
            this.o.e();
            this.o.f(c.a.s0.q1.b.CAM_X0201);
            this.o.i(c.a.s0.q1.d.new_pic_emotion_06);
            this.o.o(this.f47633g.getString(c.a.s0.q1.h.hot_topic_deleted_empty_title));
            this.o.attachView(this.m, false);
            c.a.s0.m2.a aVar = this.f47634h;
            if (!(aVar instanceof Activity) || (i2 = this.f47631e) == 1 || i2 == 4) {
                return;
            }
            UtilHelper.changeStatusBarIconAndTextColor(false, (Activity) aVar);
        }
    }

    @Override // c.a.s0.m2.b
    public void showHeadView(@NonNull c.a.s0.q1.l.e eVar) {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeL(1048605, this, eVar) == null) {
            this.I = eVar;
            if (eVar.h() != null) {
                this.A.e(this.I.h().f21635e);
                this.A.d(this.I.h().f21636f);
            }
            C(eVar);
        }
    }

    @Override // c.a.s0.m2.b
    public void stopPullRefresh() {
        Interceptable interceptable = $ic;
        if ((interceptable == null || interceptable.invokeV(1048606, this) == null) && this.G) {
            G();
            c.a.d.f.m.e.a().removeCallbacks(this.M);
        }
    }

    public final byte[] w(Bitmap bitmap, Bitmap.CompressFormat compressFormat, int i2) {
        InterceptResult invokeLLI;
        Interceptable interceptable = $ic;
        if (interceptable == null || (invokeLLI = interceptable.invokeLLI(1048607, this, bitmap, compressFormat, i2)) == null) {
            try {
                ByteArrayOutputStream byteArrayOutputStream = new ByteArrayOutputStream();
                bitmap.compress(compressFormat, i2, byteArrayOutputStream);
                byte[] byteArray = byteArrayOutputStream.toByteArray();
                byteArrayOutputStream.close();
                return byteArray;
            } catch (IOException e2) {
                e2.printStackTrace();
                return null;
            }
        }
        return (byte[]) invokeLLI.objValue;
    }

    public final void x() {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeV(1048608, this) == null) {
            c.a.d.f.m.e.a().postDelayed(this.M, 5000L);
            this.G = true;
            this.f47634h.refreshFullData(curFeedType());
        }
    }

    public final void y() {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeV(1048609, this) == null) {
            SpannableStringBuilder spannableStringBuilder = new SpannableStringBuilder();
            spannableStringBuilder.append((CharSequence) this.t);
            String string = getResources().getString(c.a.s0.q1.h.hot_topic_detail);
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
}
