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
import b.a.e.e.p.l;
import b.a.e.l.e.n;
import b.a.l0.a;
import b.a.q0.d1.m0;
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
/* loaded from: classes9.dex */
public class HotTopicDetailView extends RelativeLayout implements b.a.r0.e2.b {
    public static /* synthetic */ Interceptable $ic;
    public static int P;
    public transient /* synthetic */ FieldHolder $fh;
    public b.a.r0.j1.k.c A;
    public CustomViewPager B;
    public HotTopicDetailPagerAdapter C;
    public TbTabLayout D;
    public View E;
    public RecyclerView.OnScrollListener F;
    public boolean G;
    public ValueAnimator H;
    public b.a.r0.j1.l.e I;
    public AppBarLayout.OnOffsetChangedListener J;
    public b.a.q0.s.g0.q.b K;
    public final b.a.e.e.l.c<b.a.e.l.d.a> L;
    public Runnable M;
    public ClickableSpan N;
    public ClickableSpan O;

    /* renamed from: e  reason: collision with root package name */
    public int f51734e;

    /* renamed from: f  reason: collision with root package name */
    public int f51735f;

    /* renamed from: g  reason: collision with root package name */
    public TbPageContext<HotTopicDetailActivity> f51736g;

    /* renamed from: h  reason: collision with root package name */
    public b.a.r0.e2.a f51737h;

    /* renamed from: i  reason: collision with root package name */
    public View f51738i;
    public NavigationBar j;
    public ImageView k;
    public boolean l;
    public ViewGroup m;
    public b.a.q0.g0.g n;
    public b.a.q0.g0.h o;
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

    /* loaded from: classes9.dex */
    public class a extends ClickableSpan {
        public static /* synthetic */ Interceptable $ic;
        public transient /* synthetic */ FieldHolder $fh;

        /* renamed from: e  reason: collision with root package name */
        public final /* synthetic */ HotTopicDetailView f51739e;

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
            this.f51739e = hotTopicDetailView;
        }

        @Override // android.text.style.ClickableSpan
        public void onClick(View view) {
            Interceptable interceptable = $ic;
            if (interceptable == null || interceptable.invokeL(1048576, this, view) == null) {
                this.f51739e.s.setText(this.f51739e.t);
                this.f51739e.w();
            }
        }

        @Override // android.text.style.ClickableSpan, android.text.style.CharacterStyle
        public void updateDrawState(TextPaint textPaint) {
            Interceptable interceptable = $ic;
            if (interceptable == null || interceptable.invokeL(Constants.METHOD_GET_CONTACTER_INFO_FOR_SESSION, this, textPaint) == null) {
                textPaint.setColor(this.f51739e.getResources().getColor(b.a.r0.j1.b.CAM_X0304));
            }
        }
    }

    /* loaded from: classes9.dex */
    public class b extends RecyclerView.OnScrollListener {
        public static /* synthetic */ Interceptable $ic;
        public transient /* synthetic */ FieldHolder $fh;

        /* renamed from: a  reason: collision with root package name */
        public final /* synthetic */ HotTopicDetailView f51740a;

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
            this.f51740a = hotTopicDetailView;
        }

        @Override // androidx.recyclerview.widget.RecyclerView.OnScrollListener
        public void onScrolled(RecyclerView recyclerView, int i2, int i3) {
            Interceptable interceptable = $ic;
            if (interceptable == null || interceptable.invokeLII(1048576, this, recyclerView, i2, i3) == null) {
                this.f51740a.z();
            }
        }
    }

    /* loaded from: classes9.dex */
    public class c implements View.OnClickListener {
        public static /* synthetic */ Interceptable $ic;
        public transient /* synthetic */ FieldHolder $fh;

        /* renamed from: e  reason: collision with root package name */
        public final /* synthetic */ HotTopicDetailView f51741e;

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
            this.f51741e = hotTopicDetailView;
        }

        @Override // android.view.View.OnClickListener
        public void onClick(View view) {
            Interceptable interceptable = $ic;
            if (interceptable == null || interceptable.invokeL(1048576, this, view) == null) {
                b.a.r0.e2.c.e(this.f51741e.f51736g, "c14389");
                if (!b.a.e.e.p.j.z()) {
                    this.f51741e.f51736g.showToast(b.a.r0.j1.h.topic_share_no_network);
                    return;
                }
                MessageManager.getInstance().dispatchResponsedMessage(new CustomResponsedMessage(2004011));
                if (ShareSwitch.isOn() || ViewHelper.checkUpIsLogin(this.f51741e.k.getContext())) {
                    this.f51741e.f51737h.shareTopic(this.f51741e.I);
                }
            }
        }
    }

    /* loaded from: classes9.dex */
    public class d implements Runnable {
        public static /* synthetic */ Interceptable $ic;
        public transient /* synthetic */ FieldHolder $fh;

        /* renamed from: e  reason: collision with root package name */
        public final /* synthetic */ HotTopicDetailView f51742e;

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
            this.f51742e = hotTopicDetailView;
        }

        @Override // java.lang.Runnable
        public void run() {
            Interceptable interceptable = $ic;
            if (interceptable == null || interceptable.invokeV(1048576, this) == null) {
                this.f51742e.x.setMinimumHeight(this.f51742e.j.getHeight() + this.f51742e.f51735f);
            }
        }
    }

    /* loaded from: classes9.dex */
    public class e implements AppBarLayout.OnOffsetChangedListener {
        public static /* synthetic */ Interceptable $ic;
        public transient /* synthetic */ FieldHolder $fh;

        /* renamed from: a  reason: collision with root package name */
        public final /* synthetic */ HotTopicDetailView f51743a;

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
            this.f51743a = hotTopicDetailView;
        }

        @Override // com.google.android.material.appbar.AppBarLayout.OnOffsetChangedListener, com.google.android.material.appbar.AppBarLayout.BaseOnOffsetChangedListener
        public void onOffsetChanged(AppBarLayout appBarLayout, int i2) {
            Interceptable interceptable = $ic;
            if (interceptable == null || interceptable.invokeLI(1048576, this, appBarLayout, i2) == null) {
                if (this.f51743a.p != null) {
                    this.f51743a.p.setEnableSlideLoading(i2 == 0);
                }
                this.f51743a.B(i2);
            }
        }
    }

    /* loaded from: classes9.dex */
    public class f implements b.a.q0.s.g0.q.b {
        public static /* synthetic */ Interceptable $ic;
        public transient /* synthetic */ FieldHolder $fh;

        /* renamed from: a  reason: collision with root package name */
        public final /* synthetic */ HotTopicDetailView f51744a;

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
            this.f51744a = hotTopicDetailView;
        }

        @Override // b.a.q0.s.g0.q.b
        public void a() {
            Interceptable interceptable = $ic;
            if (interceptable == null || interceptable.invokeV(1048576, this) == null) {
            }
        }

        @Override // b.a.q0.s.g0.q.b
        public void onLoadingStart() {
            Interceptable interceptable = $ic;
            if (interceptable == null || interceptable.invokeV(Constants.METHOD_GET_CONTACTER_INFO_FOR_SESSION, this) == null) {
                this.f51744a.v();
            }
        }
    }

    /* loaded from: classes9.dex */
    public class g extends b.a.e.e.l.c<b.a.e.l.d.a> {
        public static /* synthetic */ Interceptable $ic;
        public transient /* synthetic */ FieldHolder $fh;

        /* renamed from: a  reason: collision with root package name */
        public final /* synthetic */ HotTopicDetailView f51745a;

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
            this.f51745a = hotTopicDetailView;
        }

        /* JADX DEBUG: Method merged with bridge method */
        @Override // b.a.e.e.l.c
        public void onLoaded(b.a.e.l.d.a aVar, String str, int i2) {
            Bitmap p;
            byte[] u;
            boolean z;
            int c2;
            Interceptable interceptable = $ic;
            if (interceptable == null || interceptable.invokeLLI(1048576, this, aVar, str, i2) == null) {
                super.onLoaded((g) aVar, str, i2);
                if (aVar == null || !aVar.w() || (p = aVar.p()) == null || (u = this.f51745a.u(p, Bitmap.CompressFormat.JPEG, 100)) == null) {
                    return;
                }
                a.C0091a c0091a = new a.C0091a();
                c0091a.c(Tri.TRUE);
                c0091a.b(Tri.TRUE);
                c0091a.d(50, 100);
                c0091a.e(40, 80);
                String c3 = SmartColorSDK.b().c(c0091a.a(), u, u.length);
                if (TextUtils.isEmpty(c3) || (c2 = b.a.r0.l3.c.c(c3)) == Integer.MAX_VALUE) {
                    z = false;
                } else {
                    z = true;
                    if (this.f51745a.r != null) {
                        HotTopicDetailView.setWriteViewStyle(this.f51745a.r, c2);
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

    /* loaded from: classes9.dex */
    public class h implements View.OnClickListener {
        public static /* synthetic */ Interceptable $ic;
        public transient /* synthetic */ FieldHolder $fh;

        /* renamed from: e  reason: collision with root package name */
        public final /* synthetic */ HotTopicDetailView f51746e;

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
            this.f51746e = hotTopicDetailView;
        }

        @Override // android.view.View.OnClickListener
        public void onClick(View view) {
            Interceptable interceptable = $ic;
            if ((interceptable == null || interceptable.invokeL(1048576, this, view) == null) && b.a.e.e.p.j.A() && this.f51746e.f51737h != null) {
                this.f51746e.f51737h.refreshFullData(1);
            }
        }
    }

    /* loaded from: classes9.dex */
    public class i implements Runnable {
        public static /* synthetic */ Interceptable $ic;
        public transient /* synthetic */ FieldHolder $fh;

        /* renamed from: e  reason: collision with root package name */
        public final /* synthetic */ HotTopicDetailView f51747e;

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
            this.f51747e = hotTopicDetailView;
        }

        @Override // java.lang.Runnable
        public void run() {
            Interceptable interceptable = $ic;
            if ((interceptable == null || interceptable.invokeV(1048576, this) == null) && this.f51747e.G) {
                this.f51747e.E();
            }
        }
    }

    /* loaded from: classes9.dex */
    public class j extends ClickableSpan {
        public static /* synthetic */ Interceptable $ic;
        public transient /* synthetic */ FieldHolder $fh;

        /* renamed from: e  reason: collision with root package name */
        public final /* synthetic */ HotTopicDetailView f51748e;

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
            this.f51748e = hotTopicDetailView;
        }

        @Override // android.text.style.ClickableSpan
        public void onClick(View view) {
            Interceptable interceptable = $ic;
            if (interceptable == null || interceptable.invokeL(1048576, this, view) == null) {
                SpannableStringBuilder spannableStringBuilder = new SpannableStringBuilder();
                spannableStringBuilder.append((CharSequence) this.f51748e.t);
                if (this.f51748e.t.length() > 500) {
                    spannableStringBuilder.append((CharSequence) "...  ");
                }
                String str = this.f51748e.getResources().getString(b.a.r0.j1.h.hot_topic_coll) + GlideException.IndentedAppendable.INDENT;
                spannableStringBuilder.append((CharSequence) str);
                SpannableString spannableString = new SpannableString(spannableStringBuilder);
                spannableString.setSpan(this.f51748e.O, spannableString.length() - str.length(), spannableString.length(), 33);
                this.f51748e.s.setText(spannableString);
                this.f51748e.s.setHeight(this.f51748e.u * this.f51748e.s.getLineHeight());
                int lineCount = this.f51748e.s.getLineCount() * this.f51748e.s.getLineHeight();
                if (lineCount > this.f51748e.u * this.f51748e.s.getLineHeight()) {
                    this.f51748e.s.scrollTo(0, lineCount - (this.f51748e.u * this.f51748e.s.getLineHeight()));
                }
                this.f51748e.s.requestLayout();
            }
        }

        @Override // android.text.style.ClickableSpan, android.text.style.CharacterStyle
        public void updateDrawState(TextPaint textPaint) {
            Interceptable interceptable = $ic;
            if (interceptable == null || interceptable.invokeL(Constants.METHOD_GET_CONTACTER_INFO_FOR_SESSION, this, textPaint) == null) {
                textPaint.setColor(this.f51748e.getResources().getColor(b.a.r0.j1.b.CAM_X0304));
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
        P = TbadkCoreApplication.getInst().getResources().getDimensionPixelSize(b.a.r0.j1.c.tbds250);
    }

    /* JADX WARN: 'super' call moved to the top of the method (can break code semantics) */
    public HotTopicDetailView(TbPageContext<?> tbPageContext, b.a.r0.e2.a aVar, Bundle bundle) {
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
        this.f51734e = 3;
        this.f51735f = UtilHelper.getStatusBarHeight();
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
        this.f51736g = tbPageContext;
        this.f51737h = aVar;
        C(bundle);
        onChangeSkinType();
    }

    public static void setWriteViewStyle(@NonNull TextView textView, @ColorInt int i2) {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeLI(65557, null, textView, i2) == null) {
            b.a.q0.s.u.c d2 = b.a.q0.s.u.c.d(textView);
            d2.n(b.a.r0.j1.h.J_X01);
            d2.v(b.a.r0.j1.b.CAM_X0101);
            d2.g(i2);
            textView.setCompoundDrawablesWithIntrinsicBounds(WebPManager.getPureDrawable(b.a.r0.j1.d.icon_pure_topic_post48, SkinManager.getColor(b.a.r0.j1.b.CAM_X0101), null), (Drawable) null, (Drawable) null, (Drawable) null);
            ShadowLayout x = x(textView);
            if (x != null) {
                x.setPadding(b.a.r0.j1.c.ds10).setRadius(b.a.r0.j1.c.ds90).setOffset(b.a.r0.j1.c.ds0, b.a.r0.j1.c.ds4).setColor(b.a.r0.l3.c.a(i2, 0.5f)).buildShadow();
            }
        }
    }

    @Nullable
    public static ShadowLayout x(@NonNull TextView textView) {
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

    public final void A(@NonNull b.a.r0.j1.l.e eVar) {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeL(1048576, this, eVar) == null) {
            D();
            this.q.setTopicInfo(eVar.h());
            if (SwitchManager.getInstance().findType(IColorSDKSwitch.KEY) == 1 && eVar.h() != null && !TextUtils.isEmpty(eVar.h().f18451i)) {
                b.a.e.e.l.d.h().m(eVar.h().f18451i, 39, this.L, this.f51736g.getUniqueId());
            }
            y(eVar.h());
            refreshPkAndBless(eVar);
            List<n> l = eVar.l();
            if (ListUtils.isEmpty(l)) {
                this.z.setVisibility(8);
            } else {
                this.z.setData(l);
                this.z.setVisibility(0);
            }
            if (eVar.h() != null) {
                String str = eVar.h().f18448f;
                if (m0.d(str) > 15) {
                    str = m0.m(str, 15) + "...";
                }
                this.j.setCenterTextTitle(String.format(getContext().getString(b.a.r0.j1.h.hot_topic_detail_write_name), str));
            }
        }
    }

    public final void B(int i2) {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeI(Constants.METHOD_GET_CONTACTER_INFO_FOR_SESSION, this, i2) == null) {
            int i3 = i2 + P;
            if (i3 < 0) {
                i3 = 0;
            }
            float f2 = 1.0f - ((i3 * 1.0f) / P);
            this.f51738i.setAlpha(f2);
            this.j.getCenterText().setAlpha(f2);
            z();
            double d2 = f2;
            if (d2 > 0.1d) {
                StatusbarColorUtils.setStatusBarDarkIcon(this.f51736g.getPageActivity().getWindow(), true);
            } else {
                StatusbarColorUtils.setStatusBarDarkIcon(this.f51736g.getPageActivity().getWindow(), false);
            }
            if ((d2 > 0.3d && this.f51734e == 0) || this.I == null) {
                SvgManager.getInstance().setPureDrawableWithDayNightModeAutoChange((ImageView) this.j.findViewById(b.a.r0.j1.e.widget_navi_back_button), b.a.r0.j1.d.ic_icon_pure_topbar_return40_svg, b.a.r0.j1.b.CAM_X0105, SvgManager.SvgResourceStateType.NORMAL_PRESS);
                SvgManager.getInstance().setPureDrawableWithDayNightModeAutoChange(this.k, b.a.r0.j1.d.icon_pure_topbar_share44_svg, b.a.r0.j1.b.CAM_X0105, SvgManager.SvgResourceStateType.NORMAL_PRESS);
                return;
            }
            SvgManager.getInstance().setPureDrawableWithDayNightModeAutoChange((ImageView) this.j.findViewById(b.a.r0.j1.e.widget_navi_back_button), b.a.r0.j1.d.ic_icon_pure_topbar_return40_svg, b.a.r0.j1.b.white_alpha100, SvgManager.SvgResourceStateType.NORMAL_PRESS);
            SvgManager.getInstance().setPureDrawableWithDayNightModeAutoChange(this.k, b.a.r0.j1.d.icon_pure_topbar_share44_svg, b.a.r0.j1.b.white_alpha100, SvgManager.SvgResourceStateType.NORMAL_PRESS);
        }
    }

    public final void C(Bundle bundle) {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeL(Constants.METHOD_SEND_USER_MSG, this, bundle) == null) {
            LayoutInflater.from(getContext()).inflate(b.a.r0.j1.f.activity_hot_topic_detail_layout, (ViewGroup) this, true);
            View findViewById = findViewById(b.a.r0.j1.e.topBgView);
            this.f51738i = findViewById;
            findViewById.setAlpha(0.0f);
            NavigationBar navigationBar = (NavigationBar) findViewById(b.a.r0.j1.e.viewNavigationBar);
            this.j = navigationBar;
            navigationBar.addSystemImageButton(NavigationBar.ControlAlign.HORIZONTAL_LEFT, NavigationBar.ControlType.BACK_BUTTON);
            this.j.getCenterText().setAlpha(0.0f);
            ImageView imageView = (ImageView) this.j.addCustomView(NavigationBar.ControlAlign.HORIZONTAL_RIGHT, b.a.r0.j1.f.hot_topic_share, new c(this));
            this.k = imageView;
            imageView.setVisibility(4);
            View findViewById2 = findViewById(b.a.r0.j1.e.statusBarViewHolder);
            ViewGroup.LayoutParams layoutParams = findViewById2.getLayoutParams();
            layoutParams.height = this.f51735f;
            findViewById2.setLayoutParams(layoutParams);
            this.m = (ViewGroup) findViewById(b.a.r0.j1.e.contentRootLayout);
            LottieSlideLoadingLayout lottieSlideLoadingLayout = (LottieSlideLoadingLayout) findViewById(b.a.r0.j1.e.contentLayout);
            this.p = lottieSlideLoadingLayout;
            lottieSlideLoadingLayout.addLoadingListener(this.K);
            this.p.bringLoadViewToFront();
            HotTopicDetailHeadView hotTopicDetailHeadView = (HotTopicDetailHeadView) findViewById(b.a.r0.j1.e.hotTopicDetailHeadView);
            this.q = hotTopicDetailHeadView;
            this.p.addSyncHeightView(hotTopicDetailHeadView);
            this.x = findViewById(b.a.r0.j1.e.headerContainerLayout);
            this.j.post(new d(this));
            this.s = (TextView) findViewById(b.a.r0.j1.e.hotTopicInfoAbstract);
            this.y = (HotTopicDetailPkLayout) findViewById(b.a.r0.j1.e.hotTopicDetailPkView);
            HotTopicDetailSpecialLayout hotTopicDetailSpecialLayout = (HotTopicDetailSpecialLayout) findViewById(b.a.r0.j1.e.hotTopicDetailSpecialLayout);
            this.z = hotTopicDetailSpecialLayout;
            hotTopicDetailSpecialLayout.initAdapters(this.f51736g);
            this.v = findViewById(b.a.r0.j1.e.contentContainer);
            AppBarLayout appBarLayout = (AppBarLayout) findViewById(b.a.r0.j1.e.appBarLayout);
            this.w = appBarLayout;
            appBarLayout.addOnOffsetChangedListener(this.J);
            this.B = (CustomViewPager) findViewById(b.a.r0.j1.e.hotTopicViewPager);
            HotTopicDetailPagerAdapter hotTopicDetailPagerAdapter = new HotTopicDetailPagerAdapter(getContext());
            this.C = hotTopicDetailPagerAdapter;
            hotTopicDetailPagerAdapter.setScrollListener(this.F);
            this.B.setAdapter(this.C);
            TbTabLayout tbTabLayout = (TbTabLayout) findViewById(b.a.r0.j1.e.tabLayout);
            this.D = tbTabLayout;
            tbTabLayout.setSelectedTabTextBlod(true);
            this.D.setTabTextSize(l.g(TbadkCoreApplication.getInst().getContext(), b.a.r0.j1.c.tbds46));
            this.D.setSelectedTabIndicatorColor(SkinManager.getColor(b.a.r0.j1.b.CAM_X0302));
            this.D.setupWithViewPager(this.B);
            this.E = findViewById(b.a.r0.j1.e.dividerShadow);
            TextView textView = (TextView) findViewById(b.a.r0.j1.e.topic_post_forum_button);
            this.r = textView;
            this.A = new b.a.r0.j1.k.c(textView, this.f51736g);
        }
    }

    public final void D() {
        Interceptable interceptable = $ic;
        if (!(interceptable == null || interceptable.invokeV(1048579, this) == null) || this.l) {
            return;
        }
        this.l = true;
        this.k.setVisibility(0);
        SvgManager.getInstance().setPureDrawableWithDayNightModeAutoChange((ImageView) this.j.findViewById(b.a.r0.j1.e.widget_navi_back_button), b.a.r0.j1.d.ic_icon_pure_topbar_return40_svg, b.a.r0.j1.b.white_alpha100, SvgManager.SvgResourceStateType.NORMAL_PRESS);
        SvgManager.getInstance().setPureDrawableWithDayNightModeAutoChange(this.k, b.a.r0.j1.d.icon_pure_topbar_share44_svg, b.a.r0.j1.b.white_alpha100, SvgManager.SvgResourceStateType.NORMAL_PRESS);
        SkinManager.setNavbarTitleColor(this.j.getCenterText(), b.a.r0.j1.b.CAM_X0105, b.a.r0.j1.b.s_navbar_title_color);
        b.a.r0.e2.a aVar = this.f51737h;
        if (aVar instanceof Activity) {
            UtilHelper.changeStatusBarIconAndTextColor(true, (Activity) aVar);
        }
    }

    public final void E() {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeV(1048580, this) == null) {
            this.G = false;
            this.p.endLoading();
        }
    }

    @Override // b.a.r0.e2.b
    public void changePkView(long j2, long j3, int i2) {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeCommon(1048581, this, new Object[]{Long.valueOf(j2), Long.valueOf(j3), Integer.valueOf(i2)}) == null) {
            this.y.changePkView(j2, j3, i2);
        }
    }

    @Override // b.a.r0.e2.b
    public b.a.r0.j1.l.d curFeedData(int i2) {
        InterceptResult invokeI;
        Interceptable interceptable = $ic;
        return (interceptable == null || (invokeI = interceptable.invokeI(1048582, this, i2)) == null) ? this.C.curFeedData(i2) : (b.a.r0.j1.l.d) invokeI.objValue;
    }

    @Override // b.a.r0.e2.b
    public int curFeedType() {
        InterceptResult invokeV;
        Interceptable interceptable = $ic;
        return (interceptable == null || (invokeV = interceptable.invokeV(1048583, this)) == null) ? this.C.curFeedType() : invokeV.intValue;
    }

    @Override // b.a.r0.e2.b
    public b.a.r0.j1.l.e curHeadData() {
        InterceptResult invokeV;
        Interceptable interceptable = $ic;
        return (interceptable == null || (invokeV = interceptable.invokeV(InputDeviceCompat.SOURCE_TOUCHPAD, this)) == null) ? this.I : (b.a.r0.j1.l.e) invokeV.objValue;
    }

    @Override // b.a.r0.e2.b
    public void destroy() {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeV(1048585, this) == null) {
            hideFullLoading();
            hideFullEmpty();
            HotTopicDetailPagerAdapter hotTopicDetailPagerAdapter = this.C;
            if (hotTopicDetailPagerAdapter != null) {
                hotTopicDetailPagerAdapter.destroy();
            }
            if (this.G) {
                E();
            }
            ValueAnimator valueAnimator = this.H;
            if (valueAnimator != null) {
                valueAnimator.cancel();
                this.H.removeAllListeners();
                this.H.removeAllUpdateListeners();
                this.H = null;
            }
            b.a.e.e.m.e.a().removeCallbacks(this.M);
        }
    }

    @Override // b.a.r0.e2.b
    public void hideFeedEmpty(int i2) {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeI(1048586, this, i2) == null) {
            this.C.hideFeedEmpty(i2);
        }
    }

    @Override // b.a.r0.e2.b
    public void hideFeedLoading(int i2) {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeI(1048587, this, i2) == null) {
            this.C.hideFeedLoading(i2);
        }
    }

    @Override // b.a.r0.e2.b
    public void hideFullEmpty() {
        b.a.q0.g0.h hVar;
        Interceptable interceptable = $ic;
        if (!(interceptable == null || interceptable.invokeV(1048588, this) == null) || (hVar = this.o) == null) {
            return;
        }
        hVar.dettachView(this.m);
        this.o = null;
    }

    @Override // b.a.r0.e2.b
    public void hideFullLoading() {
        b.a.q0.g0.g gVar;
        Interceptable interceptable = $ic;
        if (!(interceptable == null || interceptable.invokeV(1048589, this) == null) || (gVar = this.n) == null) {
            return;
        }
        gVar.dettachView(this.m);
    }

    @Override // b.a.r0.e2.b
    public void initViewPage() {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeV(1048590, this) == null) {
            this.C.initViewPage();
        }
    }

    @Override // b.a.r0.e2.b
    public void onChangeSkinType() {
        int skinType;
        Interceptable interceptable = $ic;
        if (!(interceptable == null || interceptable.invokeV(1048591, this) == null) || (skinType = TbadkCoreApplication.getInst().getSkinType()) == this.f51734e) {
            return;
        }
        this.q.onChangeSkinType(skinType);
        SkinManager.setViewTextColor(this.s, b.a.r0.j1.b.CAM_X0105, 1);
        SkinManager.setBackgroundColor(this.x, b.a.r0.j1.b.CAM_X0201);
        SkinManager.setBackgroundColor(this.f51738i, b.a.r0.j1.b.CAM_X0207);
        SkinManager.setNavbarTitleColor(this.j.getCenterText(), b.a.r0.j1.b.CAM_X0105, b.a.r0.j1.b.s_navbar_title_color);
        b.a.q0.g0.g gVar = this.n;
        if (gVar != null) {
            gVar.n(SkinManager.getColor(b.a.r0.j1.b.CAM_X0201));
        }
        this.y.onChangeSkinType(skinType);
        this.D.setTabTextColors(SkinManager.getColor(b.a.r0.j1.b.CAM_X0107), SkinManager.getColor(b.a.r0.j1.b.CAM_X0105));
        this.z.onChangeSkinType(skinType);
        this.C.onChangeSkinType(skinType);
        this.f51734e = skinType;
    }

    @Override // android.view.ViewGroup, android.view.View
    public void onDetachedFromWindow() {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeV(1048592, this) == null) {
            destroy();
            super.onDetachedFromWindow();
        }
    }

    @Override // b.a.r0.e2.b
    public void pause() {
        HotTopicDetailPagerAdapter hotTopicDetailPagerAdapter;
        Interceptable interceptable = $ic;
        if (!(interceptable == null || interceptable.invokeV(1048593, this) == null) || (hotTopicDetailPagerAdapter = this.C) == null) {
            return;
        }
        hotTopicDetailPagerAdapter.pause();
    }

    @Override // b.a.r0.e2.b
    public void refreshPkAndBless(b.a.r0.j1.l.e eVar) {
        b.a.r0.j1.l.a aVar;
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeL(1048594, this, eVar) == null) {
            if (eVar.c() != null) {
                aVar = eVar.c();
                aVar.f18427i = 3;
            } else if (eVar.d() != null) {
                aVar = eVar.d();
                aVar.f18427i = 2;
            } else if (eVar.m() != null) {
                aVar = eVar.m();
                aVar.f18427i = 1;
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

    @Override // b.a.r0.e2.b
    public void resume() {
        HotTopicDetailPagerAdapter hotTopicDetailPagerAdapter;
        Interceptable interceptable = $ic;
        if (!(interceptable == null || interceptable.invokeV(1048595, this) == null) || (hotTopicDetailPagerAdapter = this.C) == null) {
            return;
        }
        hotTopicDetailPagerAdapter.resume();
    }

    @Override // b.a.r0.e2.b
    public void showBlessView(long j2, long j3) {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeCommon(1048596, this, new Object[]{Long.valueOf(j2), Long.valueOf(j3)}) == null) {
            this.q.changeBlessView(j2, j3);
        }
    }

    @Override // b.a.r0.e2.b
    public void showFeedEmpty(boolean z, int i2) {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeCommon(1048597, this, new Object[]{Boolean.valueOf(z), Integer.valueOf(i2)}) == null) {
            this.C.showFeedEmpty(z, i2);
        }
    }

    @Override // b.a.r0.e2.b
    public void showFeedLoading(int i2) {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeI(1048598, this, i2) == null) {
            this.C.showFeedLoading(i2);
        }
    }

    @Override // b.a.r0.e2.b
    public void showFeedView(b.a.r0.j1.l.d dVar, boolean z, int i2) {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeCommon(1048599, this, new Object[]{dVar, Boolean.valueOf(z), Integer.valueOf(i2)}) == null) {
            b.a.r0.j1.l.e eVar = this.I;
            if (eVar != null) {
                this.C.setRecommendForumInfoListData(eVar.e());
            }
            this.C.showFeedView(dVar, z, i2);
        }
    }

    @Override // b.a.r0.e2.b
    public void showFullEmpty(boolean z) {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeZ(1048600, this, z) == null) {
            b.a.q0.g0.h hVar = this.o;
            if (hVar == null || !hVar.isViewAttached()) {
                if (this.o == null) {
                    this.o = new b.a.q0.g0.h(getContext(), new h(this));
                }
                this.o.j(this.f51736g.getResources().getDimensionPixelSize(b.a.r0.j1.c.ds360));
                this.o.attachView(this.m, false);
                this.o.f(b.a.r0.j1.b.CAM_X0201);
                this.o.o();
            }
        }
    }

    @Override // b.a.r0.e2.b
    public void showFullLoading() {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeV(1048601, this) == null) {
            if (this.n == null) {
                b.a.q0.g0.g gVar = new b.a.q0.g0.g(getContext(), getContext().getResources().getDimensionPixelSize(b.a.r0.j1.c.ds386));
                this.n = gVar;
                gVar.n(SkinManager.getColor(b.a.r0.j1.b.CAM_X0201));
            }
            this.n.attachView(this.m, false);
        }
    }

    @Override // b.a.r0.e2.b
    public void showHasDeleteEmpty(boolean z) {
        int i2;
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeZ(1048602, this, z) == null) {
            ShadowLayout x = x(this.r);
            if (!z) {
                if (x != null) {
                    x.setVisibility(0);
                    return;
                }
                return;
            }
            if (x != null) {
                x.setVisibility(8);
            }
            if (this.o == null) {
                this.o = new b.a.q0.g0.h(this.f51736g.getPageActivity(), null);
            }
            this.o.j(this.f51736g.getResources().getDimensionPixelSize(b.a.r0.j1.c.ds360));
            this.o.e();
            this.o.f(b.a.r0.j1.b.CAM_X0201);
            this.o.i(b.a.r0.j1.d.new_pic_emotion_06);
            this.o.n(this.f51736g.getString(b.a.r0.j1.h.hot_topic_deleted_empty_title));
            this.o.attachView(this.m, false);
            b.a.r0.e2.a aVar = this.f51737h;
            if (!(aVar instanceof Activity) || (i2 = this.f51734e) == 1 || i2 == 4) {
                return;
            }
            UtilHelper.changeStatusBarIconAndTextColor(false, (Activity) aVar);
        }
    }

    @Override // b.a.r0.e2.b
    public void showHeadView(@NonNull b.a.r0.j1.l.e eVar) {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeL(1048603, this, eVar) == null) {
            this.I = eVar;
            if (eVar.h() != null) {
                this.A.e(this.I.h().f18447e);
                this.A.d(this.I.h().f18448f);
            }
            A(eVar);
        }
    }

    @Override // b.a.r0.e2.b
    public void stopPullRefresh() {
        Interceptable interceptable = $ic;
        if ((interceptable == null || interceptable.invokeV(1048604, this) == null) && this.G) {
            E();
            b.a.e.e.m.e.a().removeCallbacks(this.M);
        }
    }

    public final byte[] u(Bitmap bitmap, Bitmap.CompressFormat compressFormat, int i2) {
        InterceptResult invokeLLI;
        Interceptable interceptable = $ic;
        if (interceptable == null || (invokeLLI = interceptable.invokeLLI(1048605, this, bitmap, compressFormat, i2)) == null) {
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

    public final void v() {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeV(1048606, this) == null) {
            b.a.e.e.m.e.a().postDelayed(this.M, 5000L);
            this.G = true;
            this.f51737h.refreshFullData(curFeedType());
        }
    }

    public final void w() {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeV(1048607, this) == null) {
            SpannableStringBuilder spannableStringBuilder = new SpannableStringBuilder();
            spannableStringBuilder.append((CharSequence) this.t);
            String string = getResources().getString(b.a.r0.j1.h.hot_topic_detail);
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

    public final void y(b.a.r0.j1.l.f fVar) {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeL(1048608, this, fVar) == null) {
            if (StringUtils.isNull(fVar.f18449g)) {
                this.s.setVisibility(8);
            } else {
                this.s.setText(fVar.f18449g);
            }
        }
    }

    public final void z() {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeV(1048609, this) == null) {
            if (this.f51735f + this.j.getHeight() >= this.v.getY()) {
                SkinManager.setBackgroundColor(this.D, b.a.r0.j1.b.CAM_X0207);
                if (this.f51734e == 0) {
                    this.E.setVisibility(0);
                    return;
                }
                return;
            }
            SkinManager.setBackgroundColor(this.D, b.a.r0.j1.b.transparent);
            this.E.setVisibility(8);
        }
    }
}
