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
import androidx.coordinatorlayout.widget.CoordinatorLayout;
import androidx.core.view.InputDeviceCompat;
import androidx.recyclerview.widget.RecyclerView;
import com.baidu.adp.framework.MessageManager;
import com.baidu.adp.framework.message.CustomResponsedMessage;
import com.baidu.adp.lib.featureSwitch.SwitchManager;
import com.baidu.adp.lib.util.BdNetTypeUtil;
import com.baidu.adp.lib.util.StringUtils;
import com.baidu.adp.widget.design.TbTabLayout;
import com.baidu.android.imsdk.internal.Constants;
import com.baidu.smartcolor.SmartColorSDK;
import com.baidu.smartcolor.utils.Tri;
import com.baidu.tbadk.TbPageContext;
import com.baidu.tbadk.core.TbadkCoreApplication;
import com.baidu.tbadk.core.util.CommonStatisticKey;
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
import com.baidu.tieba.Cdo;
import com.baidu.tieba.R;
import com.baidu.tieba.aq7;
import com.baidu.tieba.bx4;
import com.baidu.tieba.d67;
import com.baidu.tieba.e67;
import com.baidu.tieba.ej;
import com.baidu.tieba.gh;
import com.baidu.tieba.h67;
import com.baidu.tieba.i67;
import com.baidu.tieba.j67;
import com.baidu.tieba.newdetail.adapter.HotTopicDetailPagerAdapter;
import com.baidu.tieba.newdetail.view.HotTopicDetailHeadView;
import com.baidu.tieba.newdetail.view.HotTopicDetailPkLayout;
import com.baidu.tieba.newdetail.view.HotTopicDetailSpecialLayout;
import com.baidu.tieba.on;
import com.baidu.tieba.py4;
import com.baidu.tieba.s85;
import com.baidu.tieba.t85;
import com.baidu.tieba.ug1;
import com.baidu.tieba.uu4;
import com.baidu.tieba.yg;
import com.baidu.tieba.yp7;
import com.baidu.tieba.zg;
import com.baidu.tieba.zk8;
import com.baidu.tieba.zp7;
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
import tbclient.RecomTopicList;
@SuppressLint({"ViewConstructor"})
/* loaded from: classes5.dex */
public class HotTopicDetailView extends RelativeLayout implements zp7 {
    public static /* synthetic */ Interceptable $ic;
    public static int Q;
    public transient /* synthetic */ FieldHolder $fh;
    public View A;
    public RecyclerView.OnScrollListener B;
    public View C;
    public ImageView D;
    public View E;
    public TextView F;
    public ImageView G;
    public boolean H;
    public ValueAnimator I;
    public i67 J;
    public AppBarLayout.OnOffsetChangedListener K;
    public py4 L;
    public final yg<on> M;
    public Runnable N;
    public ClickableSpan O;
    public ClickableSpan P;
    public int a;
    public int b;
    public TbPageContext<HotTopicDetailActivity> c;
    public yp7 d;
    public View e;
    public NavigationBar f;
    public ImageView g;
    public boolean h;
    public ViewGroup i;
    public s85 j;
    public t85 k;
    public LottieSlideLoadingLayout l;
    public HotTopicDetailHeadView m;
    public TextView n;
    public TextView o;
    public String p;
    public int q;
    public View r;
    public AppBarLayout s;
    public View t;
    public HotTopicDetailPkLayout u;
    public HotTopicDetailSpecialLayout v;
    public d67 w;
    public CustomViewPager x;
    public HotTopicDetailPagerAdapter y;
    public TbTabLayout z;

    /* loaded from: classes5.dex */
    public class a implements Runnable {
        public static /* synthetic */ Interceptable $ic;
        public transient /* synthetic */ FieldHolder $fh;
        public final /* synthetic */ HotTopicDetailView a;

        public a(HotTopicDetailView hotTopicDetailView) {
            Interceptable interceptable = $ic;
            if (interceptable != null) {
                InitContext newInitContext = TitanRuntime.newInitContext();
                newInitContext.initArgs = r2;
                Object[] objArr = {hotTopicDetailView};
                interceptable.invokeUnInit(65536, newInitContext);
                int i = newInitContext.flag;
                if ((i & 1) != 0) {
                    int i2 = i & 2;
                    newInitContext.thisArg = this;
                    interceptable.invokeInitBody(65536, newInitContext);
                    return;
                }
            }
            this.a = hotTopicDetailView;
        }

        @Override // java.lang.Runnable
        public void run() {
            Interceptable interceptable = $ic;
            if ((interceptable == null || interceptable.invokeV(1048576, this) == null) && this.a.H) {
                this.a.c0();
            }
        }
    }

    /* loaded from: classes5.dex */
    public class b extends ClickableSpan {
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
                int i = newInitContext.flag;
                if ((i & 1) != 0) {
                    int i2 = i & 2;
                    newInitContext.thisArg = this;
                    interceptable.invokeInitBody(65536, newInitContext);
                    return;
                }
            }
            this.a = hotTopicDetailView;
        }

        @Override // android.text.style.ClickableSpan
        public void onClick(View view2) {
            Interceptable interceptable = $ic;
            if (interceptable == null || interceptable.invokeL(1048576, this, view2) == null) {
                SpannableStringBuilder spannableStringBuilder = new SpannableStringBuilder();
                spannableStringBuilder.append((CharSequence) this.a.p);
                if (this.a.p.length() > 500) {
                    spannableStringBuilder.append((CharSequence) "...  ");
                }
                String str = this.a.getResources().getString(R.string.obfuscated_res_0x7f0f088e) + GlideException.IndentedAppendable.INDENT;
                spannableStringBuilder.append((CharSequence) str);
                SpannableString spannableString = new SpannableString(spannableStringBuilder);
                spannableString.setSpan(this.a.P, spannableString.length() - str.length(), spannableString.length(), 33);
                this.a.o.setText(spannableString);
                this.a.o.setHeight(this.a.q * this.a.o.getLineHeight());
                int lineCount = this.a.o.getLineCount() * this.a.o.getLineHeight();
                if (lineCount > this.a.q * this.a.o.getLineHeight()) {
                    this.a.o.scrollTo(0, lineCount - (this.a.q * this.a.o.getLineHeight()));
                }
                this.a.o.requestLayout();
            }
        }

        @Override // android.text.style.ClickableSpan, android.text.style.CharacterStyle
        public void updateDrawState(TextPaint textPaint) {
            Interceptable interceptable = $ic;
            if (interceptable == null || interceptable.invokeL(Constants.METHOD_GET_CONTACTER_INFO_FOR_SESSION, this, textPaint) == null) {
                textPaint.setColor(this.a.getResources().getColor(R.color.CAM_X0304));
            }
        }
    }

    /* loaded from: classes5.dex */
    public class c extends ClickableSpan {
        public static /* synthetic */ Interceptable $ic;
        public transient /* synthetic */ FieldHolder $fh;
        public final /* synthetic */ HotTopicDetailView a;

        public c(HotTopicDetailView hotTopicDetailView) {
            Interceptable interceptable = $ic;
            if (interceptable != null) {
                InitContext newInitContext = TitanRuntime.newInitContext();
                newInitContext.initArgs = r2;
                Object[] objArr = {hotTopicDetailView};
                interceptable.invokeUnInit(65536, newInitContext);
                int i = newInitContext.flag;
                if ((i & 1) != 0) {
                    int i2 = i & 2;
                    newInitContext.thisArg = this;
                    interceptable.invokeInitBody(65536, newInitContext);
                    return;
                }
            }
            this.a = hotTopicDetailView;
        }

        @Override // android.text.style.ClickableSpan
        public void onClick(View view2) {
            Interceptable interceptable = $ic;
            if (interceptable == null || interceptable.invokeL(1048576, this, view2) == null) {
                this.a.o.setText(this.a.p);
                this.a.S();
            }
        }

        @Override // android.text.style.ClickableSpan, android.text.style.CharacterStyle
        public void updateDrawState(TextPaint textPaint) {
            Interceptable interceptable = $ic;
            if (interceptable == null || interceptable.invokeL(Constants.METHOD_GET_CONTACTER_INFO_FOR_SESSION, this, textPaint) == null) {
                textPaint.setColor(this.a.getResources().getColor(R.color.CAM_X0304));
            }
        }
    }

    /* loaded from: classes5.dex */
    public class d extends RecyclerView.OnScrollListener {
        public static /* synthetic */ Interceptable $ic;
        public transient /* synthetic */ FieldHolder $fh;
        public final /* synthetic */ HotTopicDetailView a;

        public d(HotTopicDetailView hotTopicDetailView) {
            Interceptable interceptable = $ic;
            if (interceptable != null) {
                InitContext newInitContext = TitanRuntime.newInitContext();
                newInitContext.initArgs = r2;
                Object[] objArr = {hotTopicDetailView};
                interceptable.invokeUnInit(65536, newInitContext);
                int i = newInitContext.flag;
                if ((i & 1) != 0) {
                    int i2 = i & 2;
                    newInitContext.thisArg = this;
                    interceptable.invokeInitBody(65536, newInitContext);
                    return;
                }
            }
            this.a = hotTopicDetailView;
        }

        @Override // androidx.recyclerview.widget.RecyclerView.OnScrollListener
        public void onScrolled(RecyclerView recyclerView, int i, int i2) {
            Interceptable interceptable = $ic;
            if (interceptable == null || interceptable.invokeLII(1048576, this, recyclerView, i, i2) == null) {
                this.a.W();
            }
        }
    }

    /* loaded from: classes5.dex */
    public class e implements View.OnClickListener {
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
                int i = newInitContext.flag;
                if ((i & 1) != 0) {
                    int i2 = i & 2;
                    newInitContext.thisArg = this;
                    interceptable.invokeInitBody(65536, newInitContext);
                    return;
                }
            }
            this.a = hotTopicDetailView;
        }

        @Override // android.view.View.OnClickListener
        public void onClick(View view2) {
            Interceptable interceptable = $ic;
            if (interceptable == null || interceptable.invokeL(1048576, this, view2) == null) {
                aq7.f(this.a.c, "c14389");
                if (!BdNetTypeUtil.isNetWorkAvailable()) {
                    this.a.c.showToast(R.string.obfuscated_res_0x7f0f1465);
                    return;
                }
                MessageManager.getInstance().dispatchResponsedMessage(new CustomResponsedMessage(2004011));
                if (ShareSwitch.isOn() || ViewHelper.checkUpIsLogin(this.a.g.getContext())) {
                    this.a.d.W0(this.a.J);
                }
            }
        }
    }

    /* loaded from: classes5.dex */
    public class f implements Runnable {
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
                int i = newInitContext.flag;
                if ((i & 1) != 0) {
                    int i2 = i & 2;
                    newInitContext.thisArg = this;
                    interceptable.invokeInitBody(65536, newInitContext);
                    return;
                }
            }
            this.a = hotTopicDetailView;
        }

        @Override // java.lang.Runnable
        public void run() {
            Interceptable interceptable = $ic;
            if (interceptable == null || interceptable.invokeV(1048576, this) == null) {
                this.a.t.setMinimumHeight(this.a.f.getHeight() + this.a.b);
            }
        }
    }

    /* loaded from: classes5.dex */
    public class g implements View.OnClickListener {
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
                int i = newInitContext.flag;
                if ((i & 1) != 0) {
                    int i2 = i & 2;
                    newInitContext.thisArg = this;
                    interceptable.invokeInitBody(65536, newInitContext);
                    return;
                }
            }
            this.a = hotTopicDetailView;
        }

        @Override // android.view.View.OnClickListener
        public void onClick(View view2) {
            Interceptable interceptable = $ic;
            if (interceptable == null || interceptable.invokeL(1048576, this, view2) == null) {
                this.a.b0();
                this.a.U();
            }
        }
    }

    /* loaded from: classes5.dex */
    public class h implements View.OnClickListener {
        public static /* synthetic */ Interceptable $ic;
        public transient /* synthetic */ FieldHolder $fh;
        public final /* synthetic */ HotTopicDetailView a;

        public h(HotTopicDetailView hotTopicDetailView) {
            Interceptable interceptable = $ic;
            if (interceptable != null) {
                InitContext newInitContext = TitanRuntime.newInitContext();
                newInitContext.initArgs = r2;
                Object[] objArr = {hotTopicDetailView};
                interceptable.invokeUnInit(65536, newInitContext);
                int i = newInitContext.flag;
                if ((i & 1) != 0) {
                    int i2 = i & 2;
                    newInitContext.thisArg = this;
                    interceptable.invokeInitBody(65536, newInitContext);
                    return;
                }
            }
            this.a = hotTopicDetailView;
        }

        @Override // android.view.View.OnClickListener
        public void onClick(View view2) {
            Interceptable interceptable = $ic;
            if (interceptable == null || interceptable.invokeL(1048576, this, view2) == null) {
                this.a.b0();
                this.a.U();
            }
        }
    }

    /* loaded from: classes5.dex */
    public class i implements AppBarLayout.OnOffsetChangedListener {
        public static /* synthetic */ Interceptable $ic;
        public transient /* synthetic */ FieldHolder $fh;
        public final /* synthetic */ HotTopicDetailView a;

        public i(HotTopicDetailView hotTopicDetailView) {
            Interceptable interceptable = $ic;
            if (interceptable != null) {
                InitContext newInitContext = TitanRuntime.newInitContext();
                newInitContext.initArgs = r2;
                Object[] objArr = {hotTopicDetailView};
                interceptable.invokeUnInit(65536, newInitContext);
                int i = newInitContext.flag;
                if ((i & 1) != 0) {
                    int i2 = i & 2;
                    newInitContext.thisArg = this;
                    interceptable.invokeInitBody(65536, newInitContext);
                    return;
                }
            }
            this.a = hotTopicDetailView;
        }

        @Override // com.google.android.material.appbar.AppBarLayout.OnOffsetChangedListener, com.google.android.material.appbar.AppBarLayout.BaseOnOffsetChangedListener
        public void onOffsetChanged(AppBarLayout appBarLayout, int i) {
            Interceptable interceptable = $ic;
            if (interceptable == null || interceptable.invokeLI(1048576, this, appBarLayout, i) == null) {
                if (this.a.l != null) {
                    this.a.l.setEnableSlideLoading(i == 0);
                }
                this.a.Y(i);
            }
        }
    }

    /* loaded from: classes5.dex */
    public class j implements py4 {
        public static /* synthetic */ Interceptable $ic;
        public transient /* synthetic */ FieldHolder $fh;
        public final /* synthetic */ HotTopicDetailView a;

        public j(HotTopicDetailView hotTopicDetailView) {
            Interceptable interceptable = $ic;
            if (interceptable != null) {
                InitContext newInitContext = TitanRuntime.newInitContext();
                newInitContext.initArgs = r2;
                Object[] objArr = {hotTopicDetailView};
                interceptable.invokeUnInit(65536, newInitContext);
                int i = newInitContext.flag;
                if ((i & 1) != 0) {
                    int i2 = i & 2;
                    newInitContext.thisArg = this;
                    interceptable.invokeInitBody(65536, newInitContext);
                    return;
                }
            }
            this.a = hotTopicDetailView;
        }

        @Override // com.baidu.tieba.py4
        public void a() {
            Interceptable interceptable = $ic;
            if (interceptable == null || interceptable.invokeV(1048576, this) == null) {
            }
        }

        @Override // com.baidu.tieba.py4
        public void onLoadingStart() {
            Interceptable interceptable = $ic;
            if (interceptable == null || interceptable.invokeV(Constants.METHOD_GET_CONTACTER_INFO_FOR_SESSION, this) == null) {
                this.a.R();
            }
        }
    }

    /* loaded from: classes5.dex */
    public class k extends yg<on> {
        public static /* synthetic */ Interceptable $ic;
        public transient /* synthetic */ FieldHolder $fh;
        public final /* synthetic */ HotTopicDetailView a;

        public k(HotTopicDetailView hotTopicDetailView) {
            Interceptable interceptable = $ic;
            if (interceptable != null) {
                InitContext newInitContext = TitanRuntime.newInitContext();
                newInitContext.initArgs = r2;
                Object[] objArr = {hotTopicDetailView};
                interceptable.invokeUnInit(65536, newInitContext);
                int i = newInitContext.flag;
                if ((i & 1) != 0) {
                    int i2 = i & 2;
                    newInitContext.thisArg = this;
                    interceptable.invokeInitBody(65536, newInitContext);
                    return;
                }
            }
            this.a = hotTopicDetailView;
        }

        /* JADX DEBUG: Method merged with bridge method */
        @Override // com.baidu.tieba.yg
        public void onLoaded(on onVar, String str, int i) {
            Bitmap p;
            boolean z;
            Interceptable interceptable = $ic;
            if (interceptable == null || interceptable.invokeLLI(1048576, this, onVar, str, i) == null) {
                super.onLoaded((k) onVar, str, i);
                if (onVar == null || !onVar.w() || (p = onVar.p()) == null) {
                    return;
                }
                ug1.a aVar = new ug1.a();
                aVar.c(Tri.TRUE);
                aVar.b(Tri.TRUE);
                aVar.d(50, 100);
                aVar.e(40, 80);
                String e = SmartColorSDK.d().e(aVar.a(), p);
                if (TextUtils.isEmpty(e)) {
                    z = false;
                } else {
                    int f = zk8.f(e);
                    if (f != Integer.MAX_VALUE) {
                        z = true;
                        if (this.a.n != null) {
                            HotTopicDetailView.setWriteViewStyle(this.a.n, f);
                        }
                        if (this.a.m != null) {
                            this.a.m.setBgCoverViewColor(zk8.a(f, 0.5f));
                        }
                    } else {
                        z = false;
                    }
                    this.a.z.setSelectedTabIndicatorColor(f);
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

    /* loaded from: classes5.dex */
    public class l implements View.OnClickListener {
        public static /* synthetic */ Interceptable $ic;
        public transient /* synthetic */ FieldHolder $fh;
        public final /* synthetic */ HotTopicDetailView a;

        public l(HotTopicDetailView hotTopicDetailView) {
            Interceptable interceptable = $ic;
            if (interceptable != null) {
                InitContext newInitContext = TitanRuntime.newInitContext();
                newInitContext.initArgs = r2;
                Object[] objArr = {hotTopicDetailView};
                interceptable.invokeUnInit(65536, newInitContext);
                int i = newInitContext.flag;
                if ((i & 1) != 0) {
                    int i2 = i & 2;
                    newInitContext.thisArg = this;
                    interceptable.invokeInitBody(65536, newInitContext);
                    return;
                }
            }
            this.a = hotTopicDetailView;
        }

        @Override // android.view.View.OnClickListener
        public void onClick(View view2) {
            Interceptable interceptable = $ic;
            if ((interceptable == null || interceptable.invokeL(1048576, this, view2) == null) && BdNetTypeUtil.isNetworkAvailableForImmediately() && this.a.d != null) {
                this.a.d.f1(1);
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
        Q = TbadkCoreApplication.getInst().getResources().getDimensionPixelSize(R.dimen.tbds250);
    }

    /* JADX WARN: 'super' call moved to the top of the method (can break code semantics) */
    public HotTopicDetailView(TbPageContext<?> tbPageContext, yp7 yp7Var, Bundle bundle) {
        super(tbPageContext.getPageActivity());
        Interceptable interceptable = $ic;
        if (interceptable != null) {
            InitContext newInitContext = TitanRuntime.newInitContext();
            newInitContext.initArgs = r2;
            Object[] objArr = {tbPageContext, yp7Var, bundle};
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
        this.a = 3;
        this.b = UtilHelper.getStatusBarHeight();
        this.h = false;
        this.p = "";
        this.B = new d(this);
        this.H = false;
        this.K = new i(this);
        this.L = new j(this);
        this.M = new k(this);
        this.N = new a(this);
        this.O = new b(this);
        this.P = new c(this);
        this.c = tbPageContext;
        this.d = yp7Var;
        Z(bundle);
        a();
    }

    @Nullable
    public static ShadowLayout T(@NonNull TextView textView) {
        InterceptResult invokeL;
        Interceptable interceptable = $ic;
        if (interceptable == null || (invokeL = interceptable.invokeL(65555, null, textView)) == null) {
            ViewParent parent = textView.getParent();
            if (parent instanceof ShadowLayout) {
                return (ShadowLayout) parent;
            }
            return null;
        }
        return (ShadowLayout) invokeL.objValue;
    }

    public static void setWriteViewStyle(@NonNull TextView textView, @ColorInt int i2) {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeLI(65556, null, textView, i2) == null) {
            uu4 d2 = uu4.d(textView);
            d2.n(R.string.J_X01);
            d2.v(R.color.CAM_X0101);
            d2.g(i2);
            textView.setCompoundDrawablesWithIntrinsicBounds(WebPManager.getPureDrawable(R.drawable.icon_pure_topic_post48, SkinManager.getColor(R.color.CAM_X0101), null), (Drawable) null, (Drawable) null, (Drawable) null);
            ShadowLayout T = T(textView);
            if (T != null) {
                T.e(R.dimen.obfuscated_res_0x7f070230);
                T.f(R.dimen.obfuscated_res_0x7f070308);
                T.d(R.dimen.obfuscated_res_0x7f07022f, R.dimen.obfuscated_res_0x7f070224);
                T.c(zk8.a(i2, 0.5f));
                T.a();
            }
        }
    }

    public final void R() {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeV(1048576, this) == null) {
            gh.a().postDelayed(this.N, 5000L);
            this.H = true;
            this.d.f1(l());
        }
    }

    public final void S() {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeV(Constants.METHOD_GET_CONTACTER_INFO_FOR_SESSION, this) == null) {
            SpannableStringBuilder spannableStringBuilder = new SpannableStringBuilder();
            spannableStringBuilder.append((CharSequence) this.p);
            String string = getResources().getString(R.string.obfuscated_res_0x7f0f0891);
            SpannableStringBuilder spannableStringBuilder2 = (SpannableStringBuilder) spannableStringBuilder.subSequence(0, (this.o.getLayout().getLineEnd(1) - string.length()) - 2);
            spannableStringBuilder2.append((CharSequence) "...  ");
            int length = spannableStringBuilder2.length();
            spannableStringBuilder2.append((CharSequence) string);
            SpannableString spannableString = new SpannableString(spannableStringBuilder2);
            spannableString.setSpan(this.O, length - 1, spannableString.length(), 33);
            this.o.setText(spannableString);
            TextView textView = this.o;
            textView.setHeight(textView.getLineHeight() * 2);
            this.o.scrollTo(0, 0);
            this.o.requestLayout();
        }
    }

    public final void U() {
        i67 i67Var;
        RecomTopicList recomTopicList;
        Interceptable interceptable = $ic;
        if (!(interceptable == null || interceptable.invokeV(Constants.METHOD_SEND_USER_MSG, this) == null) || (i67Var = this.J) == null || (recomTopicList = i67Var.q) == null) {
            return;
        }
        this.d.S(recomTopicList);
    }

    public final void V(j67 j67Var) {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeL(1048579, this, j67Var) == null) {
            if (StringUtils.isNull(j67Var.c)) {
                this.o.setVisibility(8);
            } else {
                this.o.setText(j67Var.c);
            }
        }
    }

    public final void W() {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeV(1048580, this) == null) {
            if (this.b + this.f.getHeight() >= this.r.getY()) {
                SkinManager.setBackgroundColor(this.z, R.color.CAM_X0207);
                if (this.a == 0) {
                    this.A.setVisibility(0);
                    return;
                }
                return;
            }
            SkinManager.setBackgroundColor(this.z, R.color.transparent);
            this.A.setVisibility(8);
        }
    }

    public final void X(@NonNull i67 i67Var) {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeL(1048581, this, i67Var) == null) {
            a0();
            this.m.setTopicInfo(i67Var.e());
            if (SwitchManager.getInstance().findType(IColorSDKSwitch.KEY) == 1 && i67Var.e() != null && !TextUtils.isEmpty(i67Var.e().f)) {
                zg.h().m(i67Var.e().f, 39, this.M, this.c.getUniqueId());
            }
            V(i67Var.e());
            d(i67Var);
            List<Cdo> f2 = i67Var.f();
            if (ListUtils.isEmpty(f2)) {
                this.v.setVisibility(8);
            } else {
                this.v.setData(f2);
                this.v.setVisibility(0);
            }
            if (i67Var.e() != null) {
                this.f.setCenterTextTitle(String.format(getContext().getString(R.string.obfuscated_res_0x7f0f0893), i67Var.e().b));
            }
            if (i67Var.q != null) {
                bx4 k2 = bx4.k();
                if (!k2.h("key_hot_topic_next_btn_show_" + TbadkCoreApplication.getCurrentAccount(), false)) {
                    bx4 k3 = bx4.k();
                    k3.u("key_hot_topic_next_btn_show_" + TbadkCoreApplication.getCurrentAccount(), true);
                    this.E.setVisibility(0);
                    this.C.setVisibility(8);
                    return;
                }
                this.E.setVisibility(8);
                this.C.setVisibility(0);
                return;
            }
            this.C.setVisibility(8);
            this.E.setVisibility(8);
        }
    }

    public final void Y(int i2) {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeI(1048582, this, i2) == null) {
            int i3 = i2 + Q;
            if (i3 < 0) {
                i3 = 0;
            }
            float f2 = 1.0f - ((i3 * 1.0f) / Q);
            this.e.setAlpha(f2);
            this.f.getCenterText().setAlpha(f2);
            W();
            double d2 = f2;
            if (d2 > 0.1d) {
                StatusbarColorUtils.setStatusBarDarkIcon(this.c.getPageActivity().getWindow(), true);
            } else {
                StatusbarColorUtils.setStatusBarDarkIcon(this.c.getPageActivity().getWindow(), false);
            }
            if ((d2 > 0.3d && this.a == 0) || this.J == null) {
                SvgManager.getInstance().setPureDrawableWithDayNightModeAutoChange((ImageView) this.f.findViewById(R.id.obfuscated_res_0x7f09267d), R.drawable.obfuscated_res_0x7f080628, R.color.CAM_X0105, SvgManager.SvgResourceStateType.NORMAL_PRESS);
                SvgManager.getInstance().setPureDrawableWithDayNightModeAutoChange(this.g, R.drawable.obfuscated_res_0x7f080a25, R.color.CAM_X0105, SvgManager.SvgResourceStateType.NORMAL_PRESS);
                return;
            }
            SvgManager.getInstance().setPureDrawableWithDayNightModeAutoChange((ImageView) this.f.findViewById(R.id.obfuscated_res_0x7f09267d), R.drawable.obfuscated_res_0x7f080628, R.color.white_alpha100, SvgManager.SvgResourceStateType.NORMAL_PRESS);
            SvgManager.getInstance().setPureDrawableWithDayNightModeAutoChange(this.g, R.drawable.obfuscated_res_0x7f080a25, R.color.white_alpha100, SvgManager.SvgResourceStateType.NORMAL_PRESS);
        }
    }

    public final void Z(Bundle bundle) {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeL(1048583, this, bundle) == null) {
            LayoutInflater.from(getContext()).inflate(R.layout.obfuscated_res_0x7f0d003a, (ViewGroup) this, true);
            View findViewById = findViewById(R.id.obfuscated_res_0x7f092285);
            this.e = findViewById;
            findViewById.setAlpha(0.0f);
            NavigationBar navigationBar = (NavigationBar) findViewById(R.id.obfuscated_res_0x7f092599);
            this.f = navigationBar;
            navigationBar.addSystemImageButton(NavigationBar.ControlAlign.HORIZONTAL_LEFT, NavigationBar.ControlType.BACK_BUTTON);
            this.f.getCenterText().setAlpha(0.0f);
            ImageView imageView = (ImageView) this.f.addCustomView(NavigationBar.ControlAlign.HORIZONTAL_RIGHT, R.layout.obfuscated_res_0x7f0d03b1, new e(this));
            this.g = imageView;
            imageView.setVisibility(4);
            View findViewById2 = findViewById(R.id.obfuscated_res_0x7f091f82);
            ViewGroup.LayoutParams layoutParams = findViewById2.getLayoutParams();
            layoutParams.height = this.b;
            findViewById2.setLayoutParams(layoutParams);
            this.i = (ViewGroup) findViewById(R.id.obfuscated_res_0x7f0906e7);
            LottieSlideLoadingLayout lottieSlideLoadingLayout = (LottieSlideLoadingLayout) findViewById(R.id.obfuscated_res_0x7f0906e5);
            this.l = lottieSlideLoadingLayout;
            lottieSlideLoadingLayout.j(this.L);
            this.l.n();
            HotTopicDetailHeadView hotTopicDetailHeadView = (HotTopicDetailHeadView) findViewById(R.id.obfuscated_res_0x7f090dcb);
            this.m = hotTopicDetailHeadView;
            this.l.l(hotTopicDetailHeadView);
            this.t = findViewById(R.id.obfuscated_res_0x7f090d46);
            this.f.post(new f(this));
            this.o = (TextView) findViewById(R.id.obfuscated_res_0x7f090dce);
            this.u = (HotTopicDetailPkLayout) findViewById(R.id.obfuscated_res_0x7f090dcc);
            HotTopicDetailSpecialLayout hotTopicDetailSpecialLayout = (HotTopicDetailSpecialLayout) findViewById(R.id.obfuscated_res_0x7f090dcd);
            this.v = hotTopicDetailSpecialLayout;
            hotTopicDetailSpecialLayout.F(this.c);
            this.r = findViewById(R.id.obfuscated_res_0x7f0906e4);
            AppBarLayout appBarLayout = (AppBarLayout) findViewById(R.id.obfuscated_res_0x7f090291);
            this.s = appBarLayout;
            appBarLayout.addOnOffsetChangedListener(this.K);
            this.x = (CustomViewPager) findViewById(R.id.obfuscated_res_0x7f090dd1);
            HotTopicDetailPagerAdapter hotTopicDetailPagerAdapter = new HotTopicDetailPagerAdapter(getContext());
            this.y = hotTopicDetailPagerAdapter;
            hotTopicDetailPagerAdapter.q(this.B);
            this.x.setAdapter(this.y);
            TbTabLayout tbTabLayout = (TbTabLayout) findViewById(R.id.obfuscated_res_0x7f092008);
            this.z = tbTabLayout;
            tbTabLayout.setSelectedTabTextBlod(true);
            this.z.setTabTextSize(ej.f(TbadkCoreApplication.getInst().getContext(), R.dimen.tbds46));
            this.z.setupWithViewPager(this.x);
            this.A = findViewById(R.id.obfuscated_res_0x7f0907fe);
            TextView textView = (TextView) findViewById(R.id.obfuscated_res_0x7f0922f3);
            this.n = textView;
            this.w = new d67(textView, this.c);
            int skinType = TbadkCoreApplication.getInst().getSkinType();
            TbadkCoreApplication.getInst().setSkinTypeValue(0);
            this.C = findViewById(R.id.obfuscated_res_0x7f0916b4);
            this.D = (ImageView) findViewById(R.id.obfuscated_res_0x7f0916b2);
            this.C.setOnClickListener(new g(this));
            uu4.d(this.C).u(R.array.S_O_X004);
            this.E = findViewById(R.id.obfuscated_res_0x7f0916b5);
            this.F = (TextView) findViewById(R.id.obfuscated_res_0x7f0916b6);
            this.G = (ImageView) findViewById(R.id.obfuscated_res_0x7f0916b3);
            this.E.setOnClickListener(new h(this));
            uu4.d(this.E).u(R.array.S_O_X004);
            TbadkCoreApplication.getInst().setSkinTypeValue(skinType);
        }
    }

    @Override // com.baidu.tieba.zp7
    public void a() {
        int skinType;
        Interceptable interceptable = $ic;
        if (!(interceptable == null || interceptable.invokeV(InputDeviceCompat.SOURCE_TOUCHPAD, this) == null) || (skinType = TbadkCoreApplication.getInst().getSkinType()) == this.a) {
            return;
        }
        this.m.h(skinType);
        SkinManager.setViewTextColor(this.o, R.color.CAM_X0105, 1);
        SkinManager.setBackgroundColor(this.t, R.color.CAM_X0201);
        SkinManager.setBackgroundColor(this.e, R.color.CAM_X0207);
        SkinManager.setNavbarTitleColor(this.f.getCenterText(), R.color.CAM_X0105, R.color.s_navbar_title_color);
        s85 s85Var = this.j;
        if (s85Var != null) {
            s85Var.o(SkinManager.getColor(R.color.CAM_X0201));
        }
        this.u.m(skinType);
        this.z.setTabTextColors(SkinManager.getColor(R.color.CAM_X0107), SkinManager.getColor(R.color.CAM_X0105));
        this.v.H(skinType);
        this.y.l(skinType);
        uu4 d2 = uu4.d(this.C);
        d2.n(R.string.J_X07);
        d2.f(R.color.CAM_X0213);
        WebPManager.setPureDrawable(this.D, R.drawable.obfuscated_res_0x7f080943, R.color.CAM_X0105, WebPManager.ResourceStateType.NORMAL);
        uu4 d3 = uu4.d(this.E);
        d3.n(R.string.J_X07);
        d3.f(R.color.CAM_X0213);
        uu4 d4 = uu4.d(this.F);
        d4.v(R.color.CAM_X0105);
        d4.z(R.dimen.T_X07);
        d4.A(R.string.F_X01);
        WebPManager.setPureDrawable(this.G, R.drawable.obfuscated_res_0x7f080943, R.color.CAM_X0105, WebPManager.ResourceStateType.NORMAL);
        this.a = skinType;
    }

    public final void a0() {
        Interceptable interceptable = $ic;
        if (!(interceptable == null || interceptable.invokeV(1048585, this) == null) || this.h) {
            return;
        }
        this.h = true;
        this.g.setVisibility(0);
        SvgManager.getInstance().setPureDrawableWithDayNightModeAutoChange((ImageView) this.f.findViewById(R.id.obfuscated_res_0x7f09267d), R.drawable.obfuscated_res_0x7f080628, R.color.white_alpha100, SvgManager.SvgResourceStateType.NORMAL_PRESS);
        SvgManager.getInstance().setPureDrawableWithDayNightModeAutoChange(this.g, R.drawable.obfuscated_res_0x7f080a25, R.color.white_alpha100, SvgManager.SvgResourceStateType.NORMAL_PRESS);
        SkinManager.setNavbarTitleColor(this.f.getCenterText(), R.color.CAM_X0105, R.color.s_navbar_title_color);
        yp7 yp7Var = this.d;
        if (yp7Var instanceof Activity) {
            UtilHelper.changeStatusBarIconAndTextColor(true, (Activity) yp7Var);
        }
    }

    @Override // com.baidu.tieba.zp7
    public void b(boolean z) {
        int i2;
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeZ(1048586, this, z) == null) {
            ShadowLayout T = T(this.n);
            if (!z) {
                if (T != null) {
                    T.setVisibility(0);
                    return;
                }
                return;
            }
            if (T != null) {
                T.setVisibility(8);
            }
            if (this.k == null) {
                this.k = new t85(this.c.getPageActivity(), null);
            }
            this.k.k(this.c.getResources().getDimensionPixelSize(R.dimen.obfuscated_res_0x7f0702aa));
            this.k.e();
            this.k.f(R.color.CAM_X0201);
            this.k.i(R.drawable.new_pic_emotion_06);
            this.k.o(this.c.getString(R.string.obfuscated_res_0x7f0f0890));
            this.k.attachView(this.i, false);
            yp7 yp7Var = this.d;
            if (!(yp7Var instanceof Activity) || (i2 = this.a) == 1 || i2 == 4) {
                return;
            }
            UtilHelper.changeStatusBarIconAndTextColor(false, (Activity) yp7Var);
        }
    }

    public final void b0() {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeV(1048587, this) == null) {
            StatisticItem statisticItem = new StatisticItem(CommonStatisticKey.KEY_HOT_TOPIC_NEXT_ONE);
            TbPageContext<HotTopicDetailActivity> tbPageContext = this.c;
            if (tbPageContext != null && (tbPageContext.getPageActivity() instanceof HotTopicDetailActivity)) {
                statisticItem.addParam("topic_id", ((HotTopicDetailActivity) this.c.getPageActivity()).B1());
            }
            TiebaStatic.log(statisticItem);
        }
    }

    @Override // com.baidu.tieba.zp7
    public void c(int i2) {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeI(1048588, this, i2) == null) {
            this.y.g(i2);
        }
    }

    public final void c0() {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeV(1048589, this) == null) {
            this.H = false;
            this.l.o();
        }
    }

    @Override // com.baidu.tieba.zp7
    public void d(i67 i67Var) {
        e67 e67Var;
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeL(1048590, this, i67Var) == null) {
            if (i67Var.a() != null) {
                e67Var = i67Var.a();
                e67Var.e = 3;
            } else if (i67Var.b() != null) {
                e67Var = i67Var.b();
                e67Var.e = 2;
            } else if (i67Var.g() != null) {
                e67Var = i67Var.g();
                e67Var.e = 1;
            } else {
                e67Var = null;
            }
            this.m.setBlessInfo(e67Var);
            if (i67Var.d() == null) {
                this.u.setVisibility(8);
                return;
            }
            this.u.setVisibility(0);
            this.u.i(i67Var.d());
        }
    }

    @Override // com.baidu.tieba.zp7
    public void destroy() {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeV(1048591, this) == null) {
            q();
            e();
            HotTopicDetailPagerAdapter hotTopicDetailPagerAdapter = this.y;
            if (hotTopicDetailPagerAdapter != null) {
                hotTopicDetailPagerAdapter.d();
            }
            if (this.H) {
                c0();
            }
            ValueAnimator valueAnimator = this.I;
            if (valueAnimator != null) {
                valueAnimator.cancel();
                this.I.removeAllListeners();
                this.I.removeAllUpdateListeners();
                this.I = null;
            }
            gh.a().removeCallbacks(this.N);
        }
    }

    @Override // com.baidu.tieba.zp7
    public void e() {
        t85 t85Var;
        Interceptable interceptable = $ic;
        if (!(interceptable == null || interceptable.invokeV(1048592, this) == null) || (t85Var = this.k) == null) {
            return;
        }
        t85Var.dettachView(this.i);
        this.k = null;
    }

    @Override // com.baidu.tieba.zp7
    public void f(boolean z) {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeZ(1048593, this, z) == null) {
            t85 t85Var = this.k;
            if (t85Var == null || !t85Var.isViewAttached()) {
                if (this.k == null) {
                    this.k = new t85(getContext(), new l(this));
                }
                this.k.k(this.c.getResources().getDimensionPixelSize(R.dimen.obfuscated_res_0x7f0702aa));
                this.k.attachView(this.i, false);
                this.k.f(R.color.CAM_X0201);
                this.k.p();
            }
        }
    }

    @Override // com.baidu.tieba.zp7
    public void g(long j2, long j3) {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeCommon(1048594, this, new Object[]{Long.valueOf(j2), Long.valueOf(j3)}) == null) {
            this.m.d(j2, j3);
        }
    }

    @Override // com.baidu.tieba.zp7
    public i67 h() {
        InterceptResult invokeV;
        Interceptable interceptable = $ic;
        return (interceptable == null || (invokeV = interceptable.invokeV(1048595, this)) == null) ? this.J : (i67) invokeV.objValue;
    }

    @Override // com.baidu.tieba.zp7
    public void i() {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeV(1048596, this) == null) {
            if (this.j == null) {
                s85 s85Var = new s85(getContext(), getContext().getResources().getDimensionPixelSize(R.dimen.obfuscated_res_0x7f0702b2));
                this.j = s85Var;
                s85Var.o(SkinManager.getColor(R.color.CAM_X0201));
            }
            this.j.attachView(this.i, false);
        }
    }

    @Override // com.baidu.tieba.zp7
    public void j(boolean z, int i2) {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeCommon(1048597, this, new Object[]{Boolean.valueOf(z), Integer.valueOf(i2)}) == null) {
            this.y.r(z, i2);
        }
    }

    @Override // com.baidu.tieba.zp7
    public void k(int i2) {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeI(1048598, this, i2) == null) {
            this.y.s(i2);
        }
    }

    @Override // com.baidu.tieba.zp7
    public int l() {
        InterceptResult invokeV;
        Interceptable interceptable = $ic;
        return (interceptable == null || (invokeV = interceptable.invokeV(1048599, this)) == null) ? this.y.c() : invokeV.intValue;
    }

    @Override // com.baidu.tieba.zp7
    public void m() {
        Interceptable interceptable = $ic;
        if ((interceptable == null || interceptable.invokeV(1048600, this) == null) && this.H) {
            c0();
            gh.a().removeCallbacks(this.N);
        }
    }

    @Override // com.baidu.tieba.zp7
    public void n(@NonNull i67 i67Var) {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeL(1048601, this, i67Var) == null) {
            this.J = i67Var;
            if (i67Var.e() != null) {
                this.w.e(this.J.e().a);
                this.w.d(this.J.e().b);
            }
            X(i67Var);
        }
    }

    @Override // com.baidu.tieba.zp7
    public void o(long j2, long j3, int i2) {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeCommon(1048602, this, new Object[]{Long.valueOf(j2), Long.valueOf(j3), Integer.valueOf(i2)}) == null) {
            this.u.j(j2, j3, i2);
        }
    }

    @Override // android.view.ViewGroup, android.view.View
    public void onDetachedFromWindow() {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeV(1048603, this) == null) {
            destroy();
            super.onDetachedFromWindow();
        }
    }

    @Override // com.baidu.tieba.zp7
    public h67 p(int i2) {
        InterceptResult invokeI;
        Interceptable interceptable = $ic;
        return (interceptable == null || (invokeI = interceptable.invokeI(1048604, this, i2)) == null) ? this.y.b(i2) : (h67) invokeI.objValue;
    }

    @Override // com.baidu.tieba.zp7
    public void pause() {
        HotTopicDetailPagerAdapter hotTopicDetailPagerAdapter;
        Interceptable interceptable = $ic;
        if (!(interceptable == null || interceptable.invokeV(1048605, this) == null) || (hotTopicDetailPagerAdapter = this.y) == null) {
            return;
        }
        hotTopicDetailPagerAdapter.m();
    }

    @Override // com.baidu.tieba.zp7
    public void q() {
        s85 s85Var;
        Interceptable interceptable = $ic;
        if (!(interceptable == null || interceptable.invokeV(1048606, this) == null) || (s85Var = this.j) == null) {
            return;
        }
        s85Var.dettachView(this.i);
    }

    @Override // com.baidu.tieba.zp7
    public void r() {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeV(1048607, this) == null) {
            this.y.j();
        }
    }

    @Override // com.baidu.tieba.zp7
    public void resetView() {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeV(1048608, this) == null) {
            m();
            CoordinatorLayout.Behavior behavior = ((CoordinatorLayout.LayoutParams) this.s.getLayoutParams()).getBehavior();
            if (behavior instanceof AppBarLayout.Behavior) {
                AppBarLayout.Behavior behavior2 = (AppBarLayout.Behavior) behavior;
                if (behavior2.getTopAndBottomOffset() != 0) {
                    behavior2.setTopAndBottomOffset(0);
                }
            }
            this.h = false;
            this.J = null;
            ShadowLayout T = T(this.n);
            if (T != null) {
                T.setVisibility(8);
            }
            this.C.setVisibility(8);
            this.x.setCurrentItem(0, false);
            this.y.n();
        }
    }

    @Override // com.baidu.tieba.zp7
    public void resume() {
        HotTopicDetailPagerAdapter hotTopicDetailPagerAdapter;
        Interceptable interceptable = $ic;
        if (!(interceptable == null || interceptable.invokeV(1048609, this) == null) || (hotTopicDetailPagerAdapter = this.y) == null) {
            return;
        }
        hotTopicDetailPagerAdapter.o();
    }

    @Override // com.baidu.tieba.zp7
    public void s(int i2) {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeI(1048610, this, i2) == null) {
            this.y.h(i2);
        }
    }

    @Override // com.baidu.tieba.zp7
    public void t(h67 h67Var, boolean z, int i2) {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeCommon(1048611, this, new Object[]{h67Var, Boolean.valueOf(z), Integer.valueOf(i2)}) == null) {
            i67 i67Var = this.J;
            if (i67Var != null) {
                this.y.p(i67Var.c());
            }
            this.y.t(h67Var, z, i2);
        }
    }
}
