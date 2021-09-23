package com.baidu.tieba.newdetail;

import android.animation.ValueAnimator;
import android.annotation.SuppressLint;
import android.app.Activity;
import android.content.Context;
import android.graphics.Bitmap;
import android.os.Bundle;
import android.text.SpannableString;
import android.text.SpannableStringBuilder;
import android.text.TextPaint;
import android.text.TextUtils;
import android.text.style.ClickableSpan;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.ImageView;
import android.widget.RelativeLayout;
import android.widget.TextView;
import androidx.annotation.NonNull;
import androidx.core.view.InputDeviceCompat;
import androidx.recyclerview.widget.RecyclerView;
import c.a.e.e.p.l;
import c.a.e.l.e.n;
import c.a.l0.a;
import c.a.q0.d1.n0;
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
import com.baidu.tbadk.core.view.NavigationBar;
import com.baidu.tbadk.core.view.slideLoadingLayout.LottieSlideLoadingLayout;
import com.baidu.tbadk.switchs.IColorSDKSwitch;
import com.baidu.tbadk.switchs.ShareSwitch;
import com.baidu.tbadk.widget.CustomViewPager;
import com.baidu.tbadk.widget.OvalActionButton;
import com.baidu.tieba.R;
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
/* loaded from: classes7.dex */
public class HotTopicDetailView extends RelativeLayout implements c.a.r0.d2.b {
    public static /* synthetic */ Interceptable $ic;
    public static int P;
    public transient /* synthetic */ FieldHolder $fh;
    public c.a.r0.i1.b.c A;
    public CustomViewPager B;
    public HotTopicDetailPagerAdapter C;
    public TbTabLayout D;
    public View E;
    public RecyclerView.OnScrollListener F;
    public boolean G;
    public ValueAnimator H;
    public c.a.r0.i1.c.e I;
    public AppBarLayout.OnOffsetChangedListener J;
    public c.a.q0.s.f0.q.b K;
    public final c.a.e.e.l.c<c.a.e.l.d.a> L;
    public Runnable M;
    public ClickableSpan N;
    public ClickableSpan O;

    /* renamed from: e  reason: collision with root package name */
    public int f54622e;

    /* renamed from: f  reason: collision with root package name */
    public int f54623f;

    /* renamed from: g  reason: collision with root package name */
    public TbPageContext<?> f54624g;

    /* renamed from: h  reason: collision with root package name */
    public c.a.r0.d2.a f54625h;

    /* renamed from: i  reason: collision with root package name */
    public View f54626i;

    /* renamed from: j  reason: collision with root package name */
    public NavigationBar f54627j;
    public ImageView k;
    public boolean l;
    public ViewGroup m;
    public c.a.q0.g0.g n;
    public c.a.q0.g0.h o;
    public LottieSlideLoadingLayout p;
    public HotTopicDetailHeadView q;
    public OvalActionButton r;
    public TextView s;
    public String t;
    public int u;
    public View v;
    public AppBarLayout w;
    public View x;
    public HotTopicDetailPkLayout y;
    public HotTopicDetailSpecialLayout z;

    /* loaded from: classes7.dex */
    public class a extends ClickableSpan {
        public static /* synthetic */ Interceptable $ic;
        public transient /* synthetic */ FieldHolder $fh;

        /* renamed from: e  reason: collision with root package name */
        public final /* synthetic */ HotTopicDetailView f54628e;

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
            this.f54628e = hotTopicDetailView;
        }

        @Override // android.text.style.ClickableSpan
        public void onClick(View view) {
            Interceptable interceptable = $ic;
            if (interceptable == null || interceptable.invokeL(1048576, this, view) == null) {
                this.f54628e.s.setText(this.f54628e.t);
                this.f54628e.w();
            }
        }

        @Override // android.text.style.ClickableSpan, android.text.style.CharacterStyle
        public void updateDrawState(TextPaint textPaint) {
            Interceptable interceptable = $ic;
            if (interceptable == null || interceptable.invokeL(Constants.METHOD_GET_CONTACTER_INFO_FOR_SESSION, this, textPaint) == null) {
                textPaint.setColor(this.f54628e.getResources().getColor(R.color.CAM_X0304));
            }
        }
    }

    /* loaded from: classes7.dex */
    public class b extends RecyclerView.OnScrollListener {
        public static /* synthetic */ Interceptable $ic;
        public transient /* synthetic */ FieldHolder $fh;

        /* renamed from: a  reason: collision with root package name */
        public final /* synthetic */ HotTopicDetailView f54629a;

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
            this.f54629a = hotTopicDetailView;
        }

        @Override // androidx.recyclerview.widget.RecyclerView.OnScrollListener
        public void onScrolled(RecyclerView recyclerView, int i2, int i3) {
            Interceptable interceptable = $ic;
            if (interceptable == null || interceptable.invokeLII(1048576, this, recyclerView, i2, i3) == null) {
                this.f54629a.y();
            }
        }
    }

    /* loaded from: classes7.dex */
    public class c implements View.OnClickListener {
        public static /* synthetic */ Interceptable $ic;
        public transient /* synthetic */ FieldHolder $fh;

        /* renamed from: e  reason: collision with root package name */
        public final /* synthetic */ HotTopicDetailView f54630e;

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
            this.f54630e = hotTopicDetailView;
        }

        @Override // android.view.View.OnClickListener
        public void onClick(View view) {
            Interceptable interceptable = $ic;
            if (interceptable == null || interceptable.invokeL(1048576, this, view) == null) {
                if (!c.a.e.e.p.j.z()) {
                    this.f54630e.f54624g.showToast(R.string.topic_share_no_network);
                    return;
                }
                MessageManager.getInstance().dispatchResponsedMessage(new CustomResponsedMessage(2004011));
                if (ShareSwitch.isOn() || ViewHelper.checkUpIsLogin(this.f54630e.k.getContext())) {
                    this.f54630e.f54625h.shareTopic(this.f54630e.I);
                }
            }
        }
    }

    /* loaded from: classes7.dex */
    public class d implements Runnable {
        public static /* synthetic */ Interceptable $ic;
        public transient /* synthetic */ FieldHolder $fh;

        /* renamed from: e  reason: collision with root package name */
        public final /* synthetic */ HotTopicDetailView f54631e;

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
            this.f54631e = hotTopicDetailView;
        }

        @Override // java.lang.Runnable
        public void run() {
            Interceptable interceptable = $ic;
            if (interceptable == null || interceptable.invokeV(1048576, this) == null) {
                this.f54631e.x.setMinimumHeight(this.f54631e.f54627j.getHeight() + this.f54631e.f54623f);
            }
        }
    }

    /* loaded from: classes7.dex */
    public class e implements AppBarLayout.OnOffsetChangedListener {
        public static /* synthetic */ Interceptable $ic;
        public transient /* synthetic */ FieldHolder $fh;

        /* renamed from: a  reason: collision with root package name */
        public final /* synthetic */ HotTopicDetailView f54632a;

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
            this.f54632a = hotTopicDetailView;
        }

        @Override // com.google.android.material.appbar.AppBarLayout.OnOffsetChangedListener, com.google.android.material.appbar.AppBarLayout.BaseOnOffsetChangedListener
        public void onOffsetChanged(AppBarLayout appBarLayout, int i2) {
            Interceptable interceptable = $ic;
            if (interceptable == null || interceptable.invokeLI(1048576, this, appBarLayout, i2) == null) {
                if (this.f54632a.p != null) {
                    this.f54632a.p.setEnableSlideLoading(i2 == 0);
                }
                this.f54632a.A(i2);
            }
        }
    }

    /* loaded from: classes7.dex */
    public class f implements c.a.q0.s.f0.q.b {
        public static /* synthetic */ Interceptable $ic;
        public transient /* synthetic */ FieldHolder $fh;

        /* renamed from: a  reason: collision with root package name */
        public final /* synthetic */ HotTopicDetailView f54633a;

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
            this.f54633a = hotTopicDetailView;
        }

        @Override // c.a.q0.s.f0.q.b
        public void a() {
            Interceptable interceptable = $ic;
            if (interceptable == null || interceptable.invokeV(1048576, this) == null) {
            }
        }

        @Override // c.a.q0.s.f0.q.b
        public void onLoadingStart() {
            Interceptable interceptable = $ic;
            if (interceptable == null || interceptable.invokeV(Constants.METHOD_GET_CONTACTER_INFO_FOR_SESSION, this) == null) {
                this.f54633a.v();
            }
        }
    }

    /* loaded from: classes7.dex */
    public class g extends c.a.e.e.l.c<c.a.e.l.d.a> {
        public static /* synthetic */ Interceptable $ic;
        public transient /* synthetic */ FieldHolder $fh;

        /* renamed from: a  reason: collision with root package name */
        public final /* synthetic */ HotTopicDetailView f54634a;

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
            this.f54634a = hotTopicDetailView;
        }

        /* JADX DEBUG: Method merged with bridge method */
        @Override // c.a.e.e.l.c
        public void onLoaded(c.a.e.l.d.a aVar, String str, int i2) {
            Bitmap p;
            byte[] u;
            boolean z;
            int c2;
            Interceptable interceptable = $ic;
            if (interceptable == null || interceptable.invokeLLI(1048576, this, aVar, str, i2) == null) {
                super.onLoaded((g) aVar, str, i2);
                if (aVar == null || !aVar.w() || (p = aVar.p()) == null || (u = this.f54634a.u(p, Bitmap.CompressFormat.JPEG, 100)) == null) {
                    return;
                }
                a.C0096a c0096a = new a.C0096a();
                c0096a.c(Tri.TRUE);
                c0096a.b(Tri.TRUE);
                c0096a.d(50, 100);
                c0096a.e(40, 80);
                String c3 = SmartColorSDK.b().c(c0096a.a(), u, u.length);
                if (TextUtils.isEmpty(c3) || (c2 = c.a.r0.j3.c.c(c3)) == Integer.MAX_VALUE) {
                    z = false;
                } else {
                    z = true;
                    if (this.f54634a.r != null) {
                        this.f54634a.r.setStartAndEndColor(c2, c2);
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

    /* loaded from: classes7.dex */
    public class h implements View.OnClickListener {
        public static /* synthetic */ Interceptable $ic;
        public transient /* synthetic */ FieldHolder $fh;

        /* renamed from: e  reason: collision with root package name */
        public final /* synthetic */ HotTopicDetailView f54635e;

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
            this.f54635e = hotTopicDetailView;
        }

        @Override // android.view.View.OnClickListener
        public void onClick(View view) {
            Interceptable interceptable = $ic;
            if ((interceptable == null || interceptable.invokeL(1048576, this, view) == null) && c.a.e.e.p.j.A() && this.f54635e.f54625h != null) {
                this.f54635e.f54625h.refreshFullData(1);
            }
        }
    }

    /* loaded from: classes7.dex */
    public class i implements Runnable {
        public static /* synthetic */ Interceptable $ic;
        public transient /* synthetic */ FieldHolder $fh;

        /* renamed from: e  reason: collision with root package name */
        public final /* synthetic */ HotTopicDetailView f54636e;

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
            this.f54636e = hotTopicDetailView;
        }

        @Override // java.lang.Runnable
        public void run() {
            Interceptable interceptable = $ic;
            if ((interceptable == null || interceptable.invokeV(1048576, this) == null) && this.f54636e.G) {
                this.f54636e.D();
            }
        }
    }

    /* loaded from: classes7.dex */
    public class j extends ClickableSpan {
        public static /* synthetic */ Interceptable $ic;
        public transient /* synthetic */ FieldHolder $fh;

        /* renamed from: e  reason: collision with root package name */
        public final /* synthetic */ HotTopicDetailView f54637e;

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
            this.f54637e = hotTopicDetailView;
        }

        @Override // android.text.style.ClickableSpan
        public void onClick(View view) {
            Interceptable interceptable = $ic;
            if (interceptable == null || interceptable.invokeL(1048576, this, view) == null) {
                SpannableStringBuilder spannableStringBuilder = new SpannableStringBuilder();
                spannableStringBuilder.append((CharSequence) this.f54637e.t);
                if (this.f54637e.t.length() > 500) {
                    spannableStringBuilder.append((CharSequence) "...  ");
                }
                String str = this.f54637e.getResources().getString(R.string.hot_topic_coll) + GlideException.IndentedAppendable.INDENT;
                spannableStringBuilder.append((CharSequence) str);
                SpannableString spannableString = new SpannableString(spannableStringBuilder);
                spannableString.setSpan(this.f54637e.O, spannableString.length() - str.length(), spannableString.length(), 33);
                this.f54637e.s.setText(spannableString);
                this.f54637e.s.setHeight(this.f54637e.u * this.f54637e.s.getLineHeight());
                int lineCount = this.f54637e.s.getLineCount() * this.f54637e.s.getLineHeight();
                if (lineCount > this.f54637e.u * this.f54637e.s.getLineHeight()) {
                    this.f54637e.s.scrollTo(0, lineCount - (this.f54637e.u * this.f54637e.s.getLineHeight()));
                }
                this.f54637e.s.requestLayout();
            }
        }

        @Override // android.text.style.ClickableSpan, android.text.style.CharacterStyle
        public void updateDrawState(TextPaint textPaint) {
            Interceptable interceptable = $ic;
            if (interceptable == null || interceptable.invokeL(Constants.METHOD_GET_CONTACTER_INFO_FOR_SESSION, this, textPaint) == null) {
                textPaint.setColor(this.f54637e.getResources().getColor(R.color.CAM_X0304));
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
        P = TbadkCoreApplication.getInst().getResources().getDimensionPixelSize(R.dimen.tbds250);
    }

    /* JADX WARN: 'super' call moved to the top of the method (can break code semantics) */
    public HotTopicDetailView(TbPageContext<?> tbPageContext, c.a.r0.d2.a aVar, Bundle bundle) {
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
        this.f54622e = 3;
        this.f54623f = UtilHelper.getStatusBarHeight();
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
        this.f54624g = tbPageContext;
        this.f54625h = aVar;
        B(bundle);
        onChangeSkinType();
    }

    public final void A(int i2) {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeI(1048576, this, i2) == null) {
            int i3 = i2 + P;
            if (i3 < 0) {
                i3 = 0;
            }
            float f2 = 1.0f - ((i3 * 1.0f) / P);
            this.f54626i.setAlpha(f2);
            this.f54627j.getCenterText().setAlpha(f2);
            y();
            double d2 = f2;
            if (d2 > 0.1d) {
                StatusbarColorUtils.setStatusBarDarkIcon(this.f54624g.getPageActivity().getWindow(), true);
            } else {
                StatusbarColorUtils.setStatusBarDarkIcon(this.f54624g.getPageActivity().getWindow(), false);
            }
            if ((d2 > 0.3d && this.f54622e == 0) || this.I == null) {
                SvgManager.getInstance().setPureDrawableWithDayNightModeAutoChange((ImageView) this.f54627j.findViewById(R.id.widget_navi_back_button), R.drawable.ic_icon_pure_topbar_return40_svg, R.color.CAM_X0105, SvgManager.SvgResourceStateType.NORMAL_PRESS);
                SvgManager.getInstance().setPureDrawableWithDayNightModeAutoChange(this.k, R.drawable.icon_pure_topbar_share44_svg, R.color.CAM_X0105, SvgManager.SvgResourceStateType.NORMAL_PRESS);
                return;
            }
            SvgManager.getInstance().setPureDrawableWithDayNightModeAutoChange((ImageView) this.f54627j.findViewById(R.id.widget_navi_back_button), R.drawable.ic_icon_pure_topbar_return40_svg, R.color.white_alpha100, SvgManager.SvgResourceStateType.NORMAL_PRESS);
            SvgManager.getInstance().setPureDrawableWithDayNightModeAutoChange(this.k, R.drawable.icon_pure_topbar_share44_svg, R.color.white_alpha100, SvgManager.SvgResourceStateType.NORMAL_PRESS);
        }
    }

    public final void B(Bundle bundle) {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeL(Constants.METHOD_GET_CONTACTER_INFO_FOR_SESSION, this, bundle) == null) {
            LayoutInflater.from(getContext()).inflate(R.layout.activity_hot_topic_detail_layout, (ViewGroup) this, true);
            View findViewById = findViewById(R.id.topBgView);
            this.f54626i = findViewById;
            findViewById.setAlpha(0.0f);
            NavigationBar navigationBar = (NavigationBar) findViewById(R.id.viewNavigationBar);
            this.f54627j = navigationBar;
            navigationBar.addSystemImageButton(NavigationBar.ControlAlign.HORIZONTAL_LEFT, NavigationBar.ControlType.BACK_BUTTON);
            this.f54627j.getCenterText().setAlpha(0.0f);
            ImageView imageView = (ImageView) this.f54627j.addCustomView(NavigationBar.ControlAlign.HORIZONTAL_RIGHT, R.layout.hot_topic_share, new c(this));
            this.k = imageView;
            imageView.setVisibility(4);
            View findViewById2 = findViewById(R.id.statusBarViewHolder);
            ViewGroup.LayoutParams layoutParams = findViewById2.getLayoutParams();
            layoutParams.height = this.f54623f;
            findViewById2.setLayoutParams(layoutParams);
            this.m = (ViewGroup) findViewById(R.id.contentRootLayout);
            LottieSlideLoadingLayout lottieSlideLoadingLayout = (LottieSlideLoadingLayout) findViewById(R.id.contentLayout);
            this.p = lottieSlideLoadingLayout;
            lottieSlideLoadingLayout.addLoadingListener(this.K);
            this.p.bringLoadViewToFront();
            HotTopicDetailHeadView hotTopicDetailHeadView = (HotTopicDetailHeadView) findViewById(R.id.hotTopicDetailHeadView);
            this.q = hotTopicDetailHeadView;
            this.p.addSyncHeightView(hotTopicDetailHeadView);
            this.x = findViewById(R.id.headerContainerLayout);
            this.f54627j.post(new d(this));
            this.s = (TextView) findViewById(R.id.hotTopicInfoAbstract);
            this.y = (HotTopicDetailPkLayout) findViewById(R.id.hotTopicDetailPkView);
            HotTopicDetailSpecialLayout hotTopicDetailSpecialLayout = (HotTopicDetailSpecialLayout) findViewById(R.id.hotTopicDetailSpecialLayout);
            this.z = hotTopicDetailSpecialLayout;
            hotTopicDetailSpecialLayout.initAdapters(this.f54624g);
            this.v = findViewById(R.id.contentContainer);
            AppBarLayout appBarLayout = (AppBarLayout) findViewById(R.id.appBarLayout);
            this.w = appBarLayout;
            appBarLayout.addOnOffsetChangedListener(this.J);
            this.B = (CustomViewPager) findViewById(R.id.hotTopicViewPager);
            HotTopicDetailPagerAdapter hotTopicDetailPagerAdapter = new HotTopicDetailPagerAdapter(getContext());
            this.C = hotTopicDetailPagerAdapter;
            hotTopicDetailPagerAdapter.setScrollListener(this.F);
            this.B.setAdapter(this.C);
            TbTabLayout tbTabLayout = (TbTabLayout) findViewById(R.id.tabLayout);
            this.D = tbTabLayout;
            tbTabLayout.setSelectedTabTextBlod(true);
            this.D.setTabTextSize(l.g(TbadkCoreApplication.getInst().getContext(), R.dimen.tbds46));
            this.D.setSelectedTabIndicatorColor(SkinManager.getColor(R.color.CAM_X0302));
            this.D.setupWithViewPager(this.B);
            this.E = findViewById(R.id.dividerShadow);
            OvalActionButton ovalActionButton = (OvalActionButton) findViewById(R.id.topic_post_forum_button);
            this.r = ovalActionButton;
            this.A = new c.a.r0.i1.b.c(ovalActionButton, this.f54624g);
        }
    }

    public final void C() {
        Interceptable interceptable = $ic;
        if (!(interceptable == null || interceptable.invokeV(Constants.METHOD_SEND_USER_MSG, this) == null) || this.l) {
            return;
        }
        this.l = true;
        this.k.setVisibility(0);
        SvgManager.getInstance().setPureDrawableWithDayNightModeAutoChange((ImageView) this.f54627j.findViewById(R.id.widget_navi_back_button), R.drawable.ic_icon_pure_topbar_return40_svg, R.color.white_alpha100, SvgManager.SvgResourceStateType.NORMAL_PRESS);
        SvgManager.getInstance().setPureDrawableWithDayNightModeAutoChange(this.k, R.drawable.icon_pure_topbar_share44_svg, R.color.white_alpha100, SvgManager.SvgResourceStateType.NORMAL_PRESS);
        SkinManager.setNavbarTitleColor(this.f54627j.getCenterText(), R.color.CAM_X0105, R.color.s_navbar_title_color);
        c.a.r0.d2.a aVar = this.f54625h;
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

    @Override // c.a.r0.d2.b
    public void changePkView(long j2, long j3, int i2) {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeCommon(1048580, this, new Object[]{Long.valueOf(j2), Long.valueOf(j3), Integer.valueOf(i2)}) == null) {
            this.y.changePkView(j2, j3, i2);
        }
    }

    @Override // c.a.r0.d2.b
    public c.a.r0.i1.c.d curFeedData(int i2) {
        InterceptResult invokeI;
        Interceptable interceptable = $ic;
        return (interceptable == null || (invokeI = interceptable.invokeI(1048581, this, i2)) == null) ? this.C.curFeedData(i2) : (c.a.r0.i1.c.d) invokeI.objValue;
    }

    @Override // c.a.r0.d2.b
    public int curFeedType() {
        InterceptResult invokeV;
        Interceptable interceptable = $ic;
        return (interceptable == null || (invokeV = interceptable.invokeV(1048582, this)) == null) ? this.C.curFeedType() : invokeV.intValue;
    }

    @Override // c.a.r0.d2.b
    public c.a.r0.i1.c.e curHeadData() {
        InterceptResult invokeV;
        Interceptable interceptable = $ic;
        return (interceptable == null || (invokeV = interceptable.invokeV(1048583, this)) == null) ? this.I : (c.a.r0.i1.c.e) invokeV.objValue;
    }

    @Override // c.a.r0.d2.b
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
            c.a.e.e.m.e.a().removeCallbacks(this.M);
        }
    }

    @Override // c.a.r0.d2.b
    public void hideFeedEmpty(int i2) {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeI(1048585, this, i2) == null) {
            this.C.hideFeedEmpty(i2);
        }
    }

    @Override // c.a.r0.d2.b
    public void hideFeedLoading(int i2) {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeI(1048586, this, i2) == null) {
            this.C.hideFeedLoading(i2);
        }
    }

    @Override // c.a.r0.d2.b
    public void hideFullEmpty() {
        c.a.q0.g0.h hVar;
        Interceptable interceptable = $ic;
        if (!(interceptable == null || interceptable.invokeV(1048587, this) == null) || (hVar = this.o) == null) {
            return;
        }
        hVar.dettachView(this.m);
        this.o = null;
    }

    @Override // c.a.r0.d2.b
    public void hideFullLoading() {
        c.a.q0.g0.g gVar;
        Interceptable interceptable = $ic;
        if (!(interceptable == null || interceptable.invokeV(1048588, this) == null) || (gVar = this.n) == null) {
            return;
        }
        gVar.dettachView(this.m);
    }

    @Override // c.a.r0.d2.b
    public void initViewPage() {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeV(1048589, this) == null) {
            this.C.initViewPage();
        }
    }

    @Override // c.a.r0.d2.b
    public void onChangeSkinType() {
        int skinType;
        Interceptable interceptable = $ic;
        if (!(interceptable == null || interceptable.invokeV(1048590, this) == null) || (skinType = TbadkCoreApplication.getInst().getSkinType()) == this.f54622e) {
            return;
        }
        this.q.onChangeSkinType(skinType);
        SkinManager.setViewTextColor(this.s, R.color.CAM_X0105, 1);
        SkinManager.setBackgroundColor(this.x, R.color.CAM_X0201);
        SkinManager.setBackgroundColor(this.f54626i, R.color.CAM_X0207);
        SkinManager.setNavbarTitleColor(this.f54627j.getCenterText(), R.color.CAM_X0105, R.color.s_navbar_title_color);
        c.a.q0.g0.g gVar = this.n;
        if (gVar != null) {
            gVar.n(SkinManager.getColor(R.color.CAM_X0201));
        }
        this.y.onChangeSkinType(skinType);
        this.D.setTabTextColors(SkinManager.getColor(R.color.CAM_X0107), SkinManager.getColor(R.color.CAM_X0105));
        this.z.onChangeSkinType(skinType);
        this.C.onChangeSkinType(skinType);
        this.f54622e = skinType;
    }

    @Override // android.view.ViewGroup, android.view.View
    public void onDetachedFromWindow() {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeV(1048591, this) == null) {
            destroy();
            super.onDetachedFromWindow();
        }
    }

    @Override // c.a.r0.d2.b
    public void pause() {
        HotTopicDetailPagerAdapter hotTopicDetailPagerAdapter;
        Interceptable interceptable = $ic;
        if (!(interceptable == null || interceptable.invokeV(1048592, this) == null) || (hotTopicDetailPagerAdapter = this.C) == null) {
            return;
        }
        hotTopicDetailPagerAdapter.pause();
    }

    @Override // c.a.r0.d2.b
    public void refreshPkAndBless(c.a.r0.i1.c.e eVar) {
        c.a.r0.i1.c.a aVar;
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeL(1048593, this, eVar) == null) {
            if (eVar.c() != null) {
                aVar = eVar.c();
                aVar.f19271i = 3;
            } else if (eVar.d() != null) {
                aVar = eVar.d();
                aVar.f19271i = 2;
            } else if (eVar.m() != null) {
                aVar = eVar.m();
                aVar.f19271i = 1;
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

    @Override // c.a.r0.d2.b
    public void resume() {
        HotTopicDetailPagerAdapter hotTopicDetailPagerAdapter;
        Interceptable interceptable = $ic;
        if (!(interceptable == null || interceptable.invokeV(1048594, this) == null) || (hotTopicDetailPagerAdapter = this.C) == null) {
            return;
        }
        hotTopicDetailPagerAdapter.resume();
    }

    @Override // c.a.r0.d2.b
    public void showBlessView(long j2, long j3) {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeCommon(1048595, this, new Object[]{Long.valueOf(j2), Long.valueOf(j3)}) == null) {
            this.q.changeBlessView(j2, j3);
        }
    }

    @Override // c.a.r0.d2.b
    public void showFeedEmpty(boolean z, int i2) {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeCommon(1048596, this, new Object[]{Boolean.valueOf(z), Integer.valueOf(i2)}) == null) {
            this.C.showFeedEmpty(z, i2);
        }
    }

    @Override // c.a.r0.d2.b
    public void showFeedLoading(int i2) {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeI(1048597, this, i2) == null) {
            this.C.showFeedLoading(i2);
        }
    }

    @Override // c.a.r0.d2.b
    public void showFeedView(c.a.r0.i1.c.d dVar, boolean z, int i2) {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeCommon(1048598, this, new Object[]{dVar, Boolean.valueOf(z), Integer.valueOf(i2)}) == null) {
            c.a.r0.i1.c.e eVar = this.I;
            if (eVar != null) {
                this.C.setRecommendForumInfoListData(eVar.e());
            }
            this.C.showFeedView(dVar, z, i2);
        }
    }

    @Override // c.a.r0.d2.b
    public void showFullEmpty(boolean z) {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeZ(1048599, this, z) == null) {
            c.a.q0.g0.h hVar = this.o;
            if (hVar == null || !hVar.isViewAttached()) {
                if (this.o == null) {
                    this.o = new c.a.q0.g0.h(getContext(), new h(this));
                }
                this.o.j(this.f54624g.getResources().getDimensionPixelSize(R.dimen.ds360));
                this.o.attachView(this.m, false);
                this.o.f(R.color.CAM_X0201);
                this.o.o();
            }
        }
    }

    @Override // c.a.r0.d2.b
    public void showFullLoading() {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeV(1048600, this) == null) {
            if (this.n == null) {
                c.a.q0.g0.g gVar = new c.a.q0.g0.g(getContext(), getContext().getResources().getDimensionPixelSize(R.dimen.ds386));
                this.n = gVar;
                gVar.n(SkinManager.getColor(R.color.CAM_X0201));
            }
            this.n.attachView(this.m, false);
        }
    }

    @Override // c.a.r0.d2.b
    public void showHasDeleteEmpty(boolean z) {
        int i2;
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeZ(1048601, this, z) == null) {
            if (!z) {
                this.r.setVisibility(0);
                return;
            }
            this.r.setVisibility(8);
            if (this.o == null) {
                this.o = new c.a.q0.g0.h(this.f54624g.getPageActivity(), null);
            }
            this.o.j(this.f54624g.getResources().getDimensionPixelSize(R.dimen.ds360));
            this.o.e();
            this.o.f(R.color.CAM_X0201);
            this.o.i(R.drawable.new_pic_emotion_06);
            this.o.n(this.f54624g.getString(R.string.hot_topic_deleted_empty_title));
            this.o.attachView(this.m, false);
            c.a.r0.d2.a aVar = this.f54625h;
            if (!(aVar instanceof Activity) || (i2 = this.f54622e) == 1 || i2 == 4) {
                return;
            }
            UtilHelper.changeStatusBarIconAndTextColor(false, (Activity) aVar);
        }
    }

    @Override // c.a.r0.d2.b
    public void showHeadView(@NonNull c.a.r0.i1.c.e eVar) {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeL(1048602, this, eVar) == null) {
            this.I = eVar;
            if (eVar.h() != null) {
                this.A.d(this.I.h().f19294e);
                this.A.c(this.I.h().f19295f);
            }
            z(eVar);
        }
    }

    @Override // c.a.r0.d2.b
    public void stopPullRefresh() {
        Interceptable interceptable = $ic;
        if ((interceptable == null || interceptable.invokeV(1048603, this) == null) && this.G) {
            D();
            c.a.e.e.m.e.a().removeCallbacks(this.M);
        }
    }

    public final byte[] u(Bitmap bitmap, Bitmap.CompressFormat compressFormat, int i2) {
        InterceptResult invokeLLI;
        Interceptable interceptable = $ic;
        if (interceptable == null || (invokeLLI = interceptable.invokeLLI(1048604, this, bitmap, compressFormat, i2)) == null) {
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
        if (interceptable == null || interceptable.invokeV(1048605, this) == null) {
            c.a.e.e.m.e.a().postDelayed(this.M, 5000L);
            this.G = true;
            this.f54625h.refreshFullData(curFeedType());
        }
    }

    public final void w() {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeV(1048606, this) == null) {
            SpannableStringBuilder spannableStringBuilder = new SpannableStringBuilder();
            spannableStringBuilder.append((CharSequence) this.t);
            String string = getResources().getString(R.string.hot_topic_detail);
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

    public final void x(c.a.r0.i1.c.f fVar) {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeL(1048607, this, fVar) == null) {
            if (StringUtils.isNull(fVar.f19296g)) {
                this.s.setVisibility(8);
            } else {
                this.s.setText(fVar.f19296g);
            }
        }
    }

    public final void y() {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeV(1048608, this) == null) {
            if (this.f54623f + this.f54627j.getHeight() >= this.v.getY()) {
                SkinManager.setBackgroundColor(this.D, R.color.CAM_X0207);
                if (this.f54622e == 0) {
                    this.E.setVisibility(0);
                    return;
                }
                return;
            }
            SkinManager.setBackgroundColor(this.D, R.color.transparent);
            this.E.setVisibility(8);
        }
    }

    public final void z(@NonNull c.a.r0.i1.c.e eVar) {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeL(1048609, this, eVar) == null) {
            C();
            this.q.setTopicInfo(eVar.h());
            if (SwitchManager.getInstance().findType(IColorSDKSwitch.KEY) == 1 && eVar.h() != null && !TextUtils.isEmpty(eVar.h().f19298i)) {
                c.a.e.e.l.d.h().m(eVar.h().f19298i, 39, this.L, this.f54624g.getUniqueId());
            }
            x(eVar.h());
            refreshPkAndBless(eVar);
            List<n> l = eVar.l();
            if (ListUtils.isEmpty(l)) {
                this.z.setVisibility(8);
            } else {
                this.z.setData(l);
                this.z.setVisibility(0);
            }
            if (eVar.h() != null) {
                String str = eVar.h().f19295f;
                if (n0.d(str) > 15) {
                    str = n0.m(str, 15) + "...";
                }
                this.f54627j.setCenterTextTitle(String.format(getContext().getString(R.string.hot_topic_detail_write_name), str));
            }
        }
    }
}
