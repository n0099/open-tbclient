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
import com.baidu.adp.lib.resourceLoader.BdResourceCallback;
import com.baidu.adp.lib.resourceLoader.BdResourceLoader;
import com.baidu.adp.lib.safe.SafeHandler;
import com.baidu.adp.lib.util.BdNetTypeUtil;
import com.baidu.adp.lib.util.BdUtilHelper;
import com.baidu.adp.lib.util.StringUtils;
import com.baidu.adp.widget.ImageView.BdImage;
import com.baidu.adp.widget.design.TbTabLayout;
import com.baidu.android.imsdk.internal.Constants;
import com.baidu.smartcolor.SmartColorSDK;
import com.baidu.smartcolor.utils.Tri;
import com.baidu.tbadk.TbPageContext;
import com.baidu.tbadk.core.TbadkCoreApplication;
import com.baidu.tbadk.core.elementsMaven.EMManager;
import com.baidu.tbadk.core.sharedPref.SharedPrefHelper;
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
import com.baidu.tbadk.loading.LoadingView;
import com.baidu.tbadk.plugin.ShadowLayout;
import com.baidu.tbadk.switchs.ShareSwitch;
import com.baidu.tbadk.widget.CustomViewPager;
import com.baidu.tieba.R;
import com.baidu.tieba.a68;
import com.baidu.tieba.cj1;
import com.baidu.tieba.gi5;
import com.baidu.tieba.i99;
import com.baidu.tieba.j99;
import com.baidu.tieba.k99;
import com.baidu.tieba.n55;
import com.baidu.tieba.newdetail.adapter.HotTopicDetailPagerAdapter;
import com.baidu.tieba.newdetail.view.HotTopicDetailHeadView;
import com.baidu.tieba.newdetail.view.HotTopicDetailPkLayout;
import com.baidu.tieba.newdetail.view.HotTopicDetailSpecialLayout;
import com.baidu.tieba.u58;
import com.baidu.tieba.v58;
import com.baidu.tieba.vca;
import com.baidu.tieba.y58;
import com.baidu.tieba.yh;
import com.baidu.tieba.z58;
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
/* loaded from: classes7.dex */
public class HotTopicDetailView extends RelativeLayout implements j99 {
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
    public z58 J;
    public AppBarLayout.OnOffsetChangedListener K;
    public n55 L;
    public final BdResourceCallback<BdImage> M;
    public Runnable N;
    public ClickableSpan O;
    public ClickableSpan P;
    public int a;
    public int b;
    public TbPageContext<HotTopicDetailActivity> c;
    public i99 d;
    public View e;
    public NavigationBar f;
    public ImageView g;
    public boolean h;
    public ViewGroup i;
    public LoadingView j;
    public gi5 k;
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
    public u58 w;
    public CustomViewPager x;
    public HotTopicDetailPagerAdapter y;
    public TbTabLayout z;

    /* loaded from: classes7.dex */
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
            if ((interceptable != null && interceptable.invokeV(1048576, this) != null) || !this.a.H) {
                return;
            }
            this.a.b0();
        }
    }

    /* loaded from: classes7.dex */
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

        @Override // android.text.style.ClickableSpan, android.text.style.CharacterStyle
        public void updateDrawState(TextPaint textPaint) {
            Interceptable interceptable = $ic;
            if (interceptable == null || interceptable.invokeL(Constants.METHOD_GET_CONTACTER_INFO_FOR_SESSION, this, textPaint) == null) {
                textPaint.setColor(this.a.getResources().getColor(R.color.CAM_X0304));
            }
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
                String str = this.a.getResources().getString(R.string.obfuscated_res_0x7f0f0a16) + GlideException.IndentedAppendable.INDENT;
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
    }

    /* loaded from: classes7.dex */
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
                this.a.R();
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

    /* loaded from: classes7.dex */
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
            if (interceptable != null && interceptable.invokeLII(1048576, this, recyclerView, i, i2) != null) {
                return;
            }
            this.a.V();
        }
    }

    /* loaded from: classes7.dex */
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
                k99.f(this.a.c, "c14389");
                if (!BdNetTypeUtil.isNetWorkAvailable()) {
                    this.a.c.showToast(R.string.obfuscated_res_0x7f0f16ff);
                    return;
                }
                MessageManager.getInstance().dispatchResponsedMessage(new CustomResponsedMessage(2004011));
                if (!ShareSwitch.isOn() && !ViewHelper.checkUpIsLogin(this.a.g.getContext())) {
                    return;
                }
                this.a.d.e0(this.a.J);
            }
        }
    }

    /* loaded from: classes7.dex */
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

    /* loaded from: classes7.dex */
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
            if (interceptable != null && interceptable.invokeL(1048576, this, view2) != null) {
                return;
            }
            this.a.a0();
            this.a.T();
        }
    }

    /* loaded from: classes7.dex */
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
            if (interceptable != null && interceptable.invokeL(1048576, this, view2) != null) {
                return;
            }
            this.a.a0();
            this.a.T();
        }
    }

    /* loaded from: classes7.dex */
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
            boolean z;
            Interceptable interceptable = $ic;
            if (interceptable == null || interceptable.invokeLI(1048576, this, appBarLayout, i) == null) {
                if (this.a.l != null) {
                    LottieSlideLoadingLayout lottieSlideLoadingLayout = this.a.l;
                    if (i == 0) {
                        z = true;
                    } else {
                        z = false;
                    }
                    lottieSlideLoadingLayout.setEnableSlideLoading(z);
                }
                this.a.X(i);
            }
        }
    }

    /* loaded from: classes7.dex */
    public class j implements n55 {
        public static /* synthetic */ Interceptable $ic;
        public transient /* synthetic */ FieldHolder $fh;
        public final /* synthetic */ HotTopicDetailView a;

        @Override // com.baidu.tieba.n55
        public void onLoadingEnd() {
            Interceptable interceptable = $ic;
            if (interceptable == null || interceptable.invokeV(1048576, this) == null) {
            }
        }

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

        @Override // com.baidu.tieba.n55
        public void onLoadingStart() {
            Interceptable interceptable = $ic;
            if (interceptable != null && interceptable.invokeV(Constants.METHOD_GET_CONTACTER_INFO_FOR_SESSION, this) != null) {
                return;
            }
            this.a.Q();
        }
    }

    /* loaded from: classes7.dex */
    public class k extends BdResourceCallback<BdImage> {
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
        @Override // com.baidu.adp.lib.resourceLoader.BdResourceCallback
        public void onLoaded(BdImage bdImage, String str, int i) {
            Bitmap rawBitmap;
            boolean z;
            String str2;
            Interceptable interceptable = $ic;
            if (interceptable == null || interceptable.invokeLLI(1048576, this, bdImage, str, i) == null) {
                super.onLoaded((k) bdImage, str, i);
                if (bdImage != null && bdImage.isValidNow() && (rawBitmap = bdImage.getRawBitmap()) != null) {
                    cj1.a aVar = new cj1.a();
                    aVar.c(Tri.TRUE);
                    aVar.b(Tri.TRUE);
                    aVar.d(50, 100);
                    aVar.e(40, 80);
                    String e = SmartColorSDK.d().e(aVar.a(), rawBitmap);
                    if (!TextUtils.isEmpty(e)) {
                        int f = vca.f(e);
                        if (f != Integer.MAX_VALUE) {
                            z = true;
                            if (this.a.n != null) {
                                HotTopicDetailView.setWriteViewStyle(this.a.n, f);
                            }
                            if (this.a.m != null) {
                                this.a.m.setBgCoverViewColor(vca.a(f, 0.5f));
                            }
                        } else {
                            z = false;
                        }
                        this.a.z.setSelectedTabIndicatorColor(f);
                    } else {
                        z = false;
                    }
                    StatisticItem statisticItem = new StatisticItem(TbadkCoreStatisticKey.KEY_SMART_COLOR_FETCH_COLOR);
                    if (z) {
                        str2 = "1";
                    } else {
                        str2 = "0";
                    }
                    statisticItem.addParam("obj_type", str2);
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
    }

    /* loaded from: classes7.dex */
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
                this.a.d.r0(1);
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

    public final void Q() {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeV(1048576, this) == null) {
            SafeHandler.getInst().postDelayed(this.N, 5000L);
            this.H = true;
            this.d.r0(k());
        }
    }

    public final void T() {
        z58 z58Var;
        RecomTopicList recomTopicList;
        Interceptable interceptable = $ic;
        if ((interceptable == null || interceptable.invokeV(Constants.METHOD_SEND_USER_MSG, this) == null) && (z58Var = this.J) != null && (recomTopicList = z58Var.q) != null) {
            this.d.r(recomTopicList);
        }
    }

    public final void b0() {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeV(1048588, this) == null) {
            this.H = false;
            this.l.o();
        }
    }

    @Override // com.baidu.tieba.j99
    public void d() {
        gi5 gi5Var;
        Interceptable interceptable = $ic;
        if ((interceptable == null || interceptable.invokeV(1048590, this) == null) && (gi5Var = this.k) != null) {
            gi5Var.dettachView(this.i);
            this.k = null;
        }
    }

    @Override // com.baidu.tieba.j99
    public z58 g() {
        InterceptResult invokeV;
        Interceptable interceptable = $ic;
        if (interceptable == null || (invokeV = interceptable.invokeV(1048594, this)) == null) {
            return this.J;
        }
        return (z58) invokeV.objValue;
    }

    @Override // com.baidu.tieba.j99
    public int k() {
        InterceptResult invokeV;
        Interceptable interceptable = $ic;
        if (interceptable == null || (invokeV = interceptable.invokeV(1048598, this)) == null) {
            return this.y.c();
        }
        return invokeV.intValue;
    }

    @Override // com.baidu.tieba.j99
    public void l() {
        Interceptable interceptable = $ic;
        if ((interceptable == null || interceptable.invokeV(1048599, this) == null) && this.H) {
            b0();
            SafeHandler.getInst().removeCallbacks(this.N);
        }
    }

    @Override // android.view.ViewGroup, android.view.View
    public void onDetachedFromWindow() {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeV(1048604, this) == null) {
            destroy();
            super.onDetachedFromWindow();
        }
    }

    @Override // com.baidu.tieba.j99
    public void p() {
        LoadingView loadingView;
        Interceptable interceptable = $ic;
        if ((interceptable == null || interceptable.invokeV(1048605, this) == null) && (loadingView = this.j) != null) {
            loadingView.dettachView(this.i);
        }
    }

    @Override // com.baidu.tieba.j99
    public void pause() {
        HotTopicDetailPagerAdapter hotTopicDetailPagerAdapter;
        Interceptable interceptable = $ic;
        if ((interceptable == null || interceptable.invokeV(1048606, this) == null) && (hotTopicDetailPagerAdapter = this.y) != null) {
            hotTopicDetailPagerAdapter.m();
        }
    }

    @Override // com.baidu.tieba.j99
    public void q() {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeV(1048607, this) == null) {
            this.y.j();
        }
    }

    @Override // com.baidu.tieba.j99
    public void resume() {
        HotTopicDetailPagerAdapter hotTopicDetailPagerAdapter;
        Interceptable interceptable = $ic;
        if ((interceptable == null || interceptable.invokeV(1048610, this) == null) && (hotTopicDetailPagerAdapter = this.y) != null) {
            hotTopicDetailPagerAdapter.o();
        }
    }

    /* JADX WARN: 'super' call moved to the top of the method (can break code semantics) */
    public HotTopicDetailView(TbPageContext<?> tbPageContext, i99 i99Var, Bundle bundle) {
        super(tbPageContext.getPageActivity());
        Interceptable interceptable = $ic;
        if (interceptable != null) {
            InitContext newInitContext = TitanRuntime.newInitContext();
            newInitContext.initArgs = r2;
            Object[] objArr = {tbPageContext, i99Var, bundle};
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
        this.d = i99Var;
        Y(bundle);
        onChangeSkinType();
    }

    @Nullable
    public static ShadowLayout S(@NonNull TextView textView) {
        InterceptResult invokeL;
        Interceptable interceptable = $ic;
        if (interceptable == null || (invokeL = interceptable.invokeL(65554, null, textView)) == null) {
            ViewParent parent = textView.getParent();
            if (parent instanceof ShadowLayout) {
                return (ShadowLayout) parent;
            }
            return null;
        }
        return (ShadowLayout) invokeL.objValue;
    }

    public final void U(a68 a68Var) {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeL(1048579, this, a68Var) == null) {
            if (StringUtils.isNull(a68Var.c)) {
                this.o.setVisibility(8);
            } else {
                this.o.setText(a68Var.c);
            }
        }
    }

    @Override // com.baidu.tieba.j99
    public void b(int i2) {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeI(1048587, this, i2) == null) {
            this.y.g(i2);
        }
    }

    @Override // com.baidu.tieba.j99
    public void j(int i2) {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeI(1048597, this, i2) == null) {
            this.y.s(i2);
        }
    }

    @Override // com.baidu.tieba.j99
    public y58 o(int i2) {
        InterceptResult invokeI;
        Interceptable interceptable = $ic;
        if (interceptable == null || (invokeI = interceptable.invokeI(1048602, this, i2)) == null) {
            return this.y.b(i2);
        }
        return (y58) invokeI.objValue;
    }

    @Override // com.baidu.tieba.j99
    public void r(int i2) {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeI(1048608, this, i2) == null) {
            this.y.h(i2);
        }
    }

    public static void setWriteViewStyle(@NonNull TextView textView, @ColorInt int i2) {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeLI(65555, null, textView, i2) == null) {
            EMManager.from(textView).setCorner(R.string.J_X01).setTextColor(R.color.CAM_X0101).setBackGroundRealColor(i2);
            textView.setCompoundDrawablesWithIntrinsicBounds(WebPManager.getPureDrawable(R.drawable.icon_pure_topic_post48, SkinManager.getColor(R.color.CAM_X0101), null), (Drawable) null, (Drawable) null, (Drawable) null);
            ShadowLayout S = S(textView);
            if (S != null) {
                S.e(R.dimen.obfuscated_res_0x7f070359);
                S.f(R.dimen.obfuscated_res_0x7f070422);
                S.d(R.dimen.obfuscated_res_0x7f070358, R.dimen.obfuscated_res_0x7f070224);
                S.c(vca.a(i2, 0.5f));
                S.a();
            }
        }
    }

    @Override // com.baidu.tieba.j99
    public void f(long j2, long j3) {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeCommon(1048593, this, new Object[]{Long.valueOf(j2), Long.valueOf(j3)}) == null) {
            this.m.d(j2, j3);
        }
    }

    @Override // com.baidu.tieba.j99
    public void i(boolean z, int i2) {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeCommon(1048596, this, new Object[]{Boolean.valueOf(z), Integer.valueOf(i2)}) == null) {
            this.y.r(z, i2);
        }
    }

    public final void R() {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeV(Constants.METHOD_GET_CONTACTER_INFO_FOR_SESSION, this) == null) {
            SpannableStringBuilder spannableStringBuilder = new SpannableStringBuilder();
            spannableStringBuilder.append((CharSequence) this.p);
            String string = getResources().getString(R.string.obfuscated_res_0x7f0f0a19);
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

    public final void V() {
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

    public final void a0() {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeV(1048586, this) == null) {
            StatisticItem statisticItem = new StatisticItem(CommonStatisticKey.KEY_HOT_TOPIC_NEXT_ONE);
            TbPageContext<HotTopicDetailActivity> tbPageContext = this.c;
            if (tbPageContext != null && (tbPageContext.getPageActivity() instanceof HotTopicDetailActivity)) {
                statisticItem.addParam("topic_id", ((HotTopicDetailActivity) this.c.getPageActivity()).Q0());
            }
            TiebaStatic.log(statisticItem);
        }
    }

    @Override // com.baidu.tieba.j99
    public void destroy() {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeV(1048591, this) == null) {
            p();
            d();
            HotTopicDetailPagerAdapter hotTopicDetailPagerAdapter = this.y;
            if (hotTopicDetailPagerAdapter != null) {
                hotTopicDetailPagerAdapter.d();
            }
            if (this.H) {
                b0();
            }
            ValueAnimator valueAnimator = this.I;
            if (valueAnimator != null) {
                valueAnimator.cancel();
                this.I.removeAllListeners();
                this.I.removeAllUpdateListeners();
                this.I = null;
            }
            SafeHandler.getInst().removeCallbacks(this.N);
        }
    }

    @Override // com.baidu.tieba.j99
    public void h() {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeV(1048595, this) == null) {
            if (this.j == null) {
                LoadingView loadingView = new LoadingView(getContext(), getContext().getResources().getDimensionPixelSize(R.dimen.obfuscated_res_0x7f0703d0));
                this.j = loadingView;
                loadingView.setBackground(SkinManager.getColor(R.color.CAM_X0201));
            }
            this.j.attachView(this.i, false);
        }
    }

    public final void W(@NonNull z58 z58Var) {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeL(1048581, this, z58Var) == null) {
            Z();
            this.m.setTopicInfo(z58Var.e());
            if (z58Var.e() != null && !TextUtils.isEmpty(z58Var.e().f)) {
                BdResourceLoader.getInstance().loadResource(z58Var.e().f, 39, this.M, this.c.getUniqueId());
            }
            U(z58Var.e());
            c(z58Var);
            List<yh> f2 = z58Var.f();
            if (ListUtils.isEmpty(f2)) {
                this.v.setVisibility(8);
            } else {
                this.v.setData(f2);
                this.v.setVisibility(0);
            }
            if (z58Var.e() != null) {
                this.f.setCenterTextTitle(String.format(getContext().getString(R.string.obfuscated_res_0x7f0f0a1b), z58Var.e().b));
            }
            if (z58Var.q != null) {
                SharedPrefHelper sharedPrefHelper = SharedPrefHelper.getInstance();
                if (!sharedPrefHelper.getBoolean("key_hot_topic_next_btn_show_" + TbadkCoreApplication.getCurrentAccount(), false)) {
                    SharedPrefHelper sharedPrefHelper2 = SharedPrefHelper.getInstance();
                    sharedPrefHelper2.putBoolean("key_hot_topic_next_btn_show_" + TbadkCoreApplication.getCurrentAccount(), true);
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

    public final void X(int i2) {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeI(1048582, this, i2) == null) {
            int i3 = i2 + Q;
            if (i3 < 0) {
                i3 = 0;
            }
            float f2 = 1.0f - ((i3 * 1.0f) / Q);
            this.e.setAlpha(f2);
            this.f.getCenterText().setAlpha(f2);
            V();
            double d2 = f2;
            if (d2 > 0.1d) {
                StatusbarColorUtils.setStatusBarDarkIcon(this.c.getPageActivity().getWindow(), true);
            } else {
                StatusbarColorUtils.setStatusBarDarkIcon(this.c.getPageActivity().getWindow(), false);
            }
            if ((d2 > 0.3d && this.a == 0) || this.J == null) {
                SvgManager.getInstance().setPureDrawableWithDayNightModeAutoChange((ImageView) this.f.findViewById(R.id.widget_navi_back_button), R.drawable.ic_icon_pure_topbar_return40_svg, R.color.CAM_X0105, SvgManager.SvgResourceStateType.NORMAL_PRESS);
                SvgManager.getInstance().setPureDrawableWithDayNightModeAutoChange(this.g, R.drawable.icon_pure_topbar_share44_svg, R.color.CAM_X0105, SvgManager.SvgResourceStateType.NORMAL_PRESS);
                return;
            }
            SvgManager.getInstance().setPureDrawableWithDayNightModeAutoChange((ImageView) this.f.findViewById(R.id.widget_navi_back_button), R.drawable.ic_icon_pure_topbar_return40_svg, R.color.white_alpha100, SvgManager.SvgResourceStateType.NORMAL_PRESS);
            SvgManager.getInstance().setPureDrawableWithDayNightModeAutoChange(this.g, R.drawable.icon_pure_topbar_share44_svg, R.color.white_alpha100, SvgManager.SvgResourceStateType.NORMAL_PRESS);
        }
    }

    public final void Y(Bundle bundle) {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeL(1048583, this, bundle) == null) {
            LayoutInflater.from(getContext()).inflate(R.layout.obfuscated_res_0x7f0d003f, (ViewGroup) this, true);
            View findViewById = findViewById(R.id.obfuscated_res_0x7f092621);
            this.e = findViewById;
            findViewById.setAlpha(0.0f);
            NavigationBar navigationBar = (NavigationBar) findViewById(R.id.obfuscated_res_0x7f092949);
            this.f = navigationBar;
            navigationBar.addSystemImageButton(NavigationBar.ControlAlign.HORIZONTAL_LEFT, NavigationBar.ControlType.BACK_BUTTON);
            this.f.getCenterText().setAlpha(0.0f);
            ImageView imageView = (ImageView) this.f.addCustomView(NavigationBar.ControlAlign.HORIZONTAL_RIGHT, R.layout.obfuscated_res_0x7f0d041f, new e(this));
            this.g = imageView;
            imageView.setVisibility(4);
            View findViewById2 = findViewById(R.id.obfuscated_res_0x7f0922f3);
            ViewGroup.LayoutParams layoutParams = findViewById2.getLayoutParams();
            layoutParams.height = this.b;
            findViewById2.setLayoutParams(layoutParams);
            this.i = (ViewGroup) findViewById(R.id.obfuscated_res_0x7f0907d6);
            LottieSlideLoadingLayout lottieSlideLoadingLayout = (LottieSlideLoadingLayout) findViewById(R.id.obfuscated_res_0x7f0907d4);
            this.l = lottieSlideLoadingLayout;
            lottieSlideLoadingLayout.j(this.L);
            this.l.n();
            HotTopicDetailHeadView hotTopicDetailHeadView = (HotTopicDetailHeadView) findViewById(R.id.obfuscated_res_0x7f090fad);
            this.m = hotTopicDetailHeadView;
            this.l.l(hotTopicDetailHeadView);
            this.t = findViewById(R.id.obfuscated_res_0x7f090f2a);
            this.f.post(new f(this));
            this.o = (TextView) findViewById(R.id.obfuscated_res_0x7f090fb0);
            this.u = (HotTopicDetailPkLayout) findViewById(R.id.obfuscated_res_0x7f090fae);
            HotTopicDetailSpecialLayout hotTopicDetailSpecialLayout = (HotTopicDetailSpecialLayout) findViewById(R.id.obfuscated_res_0x7f090faf);
            this.v = hotTopicDetailSpecialLayout;
            hotTopicDetailSpecialLayout.a(this.c);
            this.r = findViewById(R.id.obfuscated_res_0x7f0907d3);
            AppBarLayout appBarLayout = (AppBarLayout) findViewById(R.id.obfuscated_res_0x7f0902a5);
            this.s = appBarLayout;
            appBarLayout.addOnOffsetChangedListener(this.K);
            this.x = (CustomViewPager) findViewById(R.id.obfuscated_res_0x7f090fb3);
            HotTopicDetailPagerAdapter hotTopicDetailPagerAdapter = new HotTopicDetailPagerAdapter(getContext());
            this.y = hotTopicDetailPagerAdapter;
            hotTopicDetailPagerAdapter.q(this.B);
            this.x.setAdapter(this.y);
            TbTabLayout tbTabLayout = (TbTabLayout) findViewById(R.id.obfuscated_res_0x7f092385);
            this.z = tbTabLayout;
            tbTabLayout.setSelectedTabTextBlod(true);
            this.z.setTabTextSize(BdUtilHelper.getDimens(TbadkCoreApplication.getInst().getContext(), R.dimen.tbds46));
            this.z.setupWithViewPager(this.x);
            this.A = findViewById(R.id.obfuscated_res_0x7f090909);
            TextView textView = (TextView) findViewById(R.id.obfuscated_res_0x7f092690);
            this.n = textView;
            this.w = new u58(textView, this.c);
            int skinType = TbadkCoreApplication.getInst().getSkinType();
            TbadkCoreApplication.getInst().setSkinTypeValue(0);
            this.C = findViewById(R.id.obfuscated_res_0x7f09198b);
            this.D = (ImageView) findViewById(R.id.obfuscated_res_0x7f091989);
            this.C.setOnClickListener(new g(this));
            EMManager.from(this.C).setShadow(R.array.S_O_X004);
            this.E = findViewById(R.id.obfuscated_res_0x7f09198c);
            this.F = (TextView) findViewById(R.id.obfuscated_res_0x7f09198d);
            this.G = (ImageView) findViewById(R.id.obfuscated_res_0x7f09198a);
            this.E.setOnClickListener(new h(this));
            EMManager.from(this.E).setShadow(R.array.S_O_X004);
            TbadkCoreApplication.getInst().setSkinTypeValue(skinType);
        }
    }

    public final void Z() {
        Interceptable interceptable = $ic;
        if ((interceptable == null || interceptable.invokeV(InputDeviceCompat.SOURCE_TOUCHPAD, this) == null) && !this.h) {
            this.h = true;
            this.g.setVisibility(0);
            SvgManager.getInstance().setPureDrawableWithDayNightModeAutoChange((ImageView) this.f.findViewById(R.id.widget_navi_back_button), R.drawable.ic_icon_pure_topbar_return40_svg, R.color.white_alpha100, SvgManager.SvgResourceStateType.NORMAL_PRESS);
            SvgManager.getInstance().setPureDrawableWithDayNightModeAutoChange(this.g, R.drawable.icon_pure_topbar_share44_svg, R.color.white_alpha100, SvgManager.SvgResourceStateType.NORMAL_PRESS);
            SkinManager.setNavbarTitleColor(this.f.getCenterText(), R.color.CAM_X0105, R.color.s_navbar_title_color);
            i99 i99Var = this.d;
            if (i99Var instanceof Activity) {
                UtilHelper.changeStatusBarIconAndTextColor(true, (Activity) i99Var);
            }
        }
    }

    @Override // com.baidu.tieba.j99
    public void resetView() {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeV(1048609, this) == null) {
            l();
            CoordinatorLayout.Behavior behavior = ((CoordinatorLayout.LayoutParams) this.s.getLayoutParams()).getBehavior();
            if (behavior instanceof AppBarLayout.Behavior) {
                AppBarLayout.Behavior behavior2 = (AppBarLayout.Behavior) behavior;
                if (behavior2.getTopAndBottomOffset() != 0) {
                    behavior2.setTopAndBottomOffset(0);
                }
            }
            this.h = false;
            this.J = null;
            ShadowLayout S = S(this.n);
            if (S != null) {
                S.setVisibility(8);
            }
            this.C.setVisibility(8);
            this.x.setCurrentItem(0, false);
            this.y.n();
        }
    }

    @Override // com.baidu.tieba.j99
    public void a(boolean z) {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeZ(1048585, this, z) == null) {
            ShadowLayout S = S(this.n);
            if (!z) {
                if (S != null) {
                    S.setVisibility(0);
                    return;
                }
                return;
            }
            if (S != null) {
                S.setVisibility(8);
            }
            if (this.k == null) {
                this.k = new gi5(this.c.getPageActivity(), null);
            }
            this.k.j(this.c.getResources().getDimensionPixelSize(R.dimen.obfuscated_res_0x7f0703c8));
            this.k.d();
            this.k.e(R.color.CAM_X0201);
            this.k.h(R.drawable.new_pic_emotion_06);
            this.k.n(this.c.getString(R.string.obfuscated_res_0x7f0f0a18));
            this.k.attachView(this.i, false);
            i99 i99Var = this.d;
            if ((i99Var instanceof Activity) && this.a != 4) {
                UtilHelper.changeStatusBarIconAndTextColor(false, (Activity) i99Var);
            }
        }
    }

    @Override // com.baidu.tieba.j99
    public void c(z58 z58Var) {
        v58 v58Var;
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeL(1048589, this, z58Var) == null) {
            if (z58Var.a() != null) {
                v58Var = z58Var.a();
                v58Var.e = 3;
            } else if (z58Var.b() != null) {
                v58Var = z58Var.b();
                v58Var.e = 2;
            } else if (z58Var.g() != null) {
                v58Var = z58Var.g();
                v58Var.e = 1;
            } else {
                v58Var = null;
            }
            this.m.setBlessInfo(v58Var);
            if (z58Var.d() == null) {
                this.u.setVisibility(8);
                return;
            }
            this.u.setVisibility(0);
            this.u.i(z58Var.d());
        }
    }

    @Override // com.baidu.tieba.j99
    public void e(boolean z) {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeZ(1048592, this, z) == null) {
            gi5 gi5Var = this.k;
            if (gi5Var != null && gi5Var.isViewAttached()) {
                return;
            }
            if (this.k == null) {
                this.k = new gi5(getContext(), new l(this));
            }
            this.k.j(this.c.getResources().getDimensionPixelSize(R.dimen.obfuscated_res_0x7f0703c8));
            this.k.attachView(this.i, false);
            this.k.e(R.color.CAM_X0201);
            this.k.o();
        }
    }

    @Override // com.baidu.tieba.j99
    public void m(@NonNull z58 z58Var) {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeL(1048600, this, z58Var) == null) {
            this.J = z58Var;
            if (z58Var.e() != null) {
                this.w.e(this.J.e().a);
                this.w.d(this.J.e().b);
            }
            W(z58Var);
        }
    }

    @Override // com.baidu.tieba.j99
    public void n(long j2, long j3, int i2) {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeCommon(1048601, this, new Object[]{Long.valueOf(j2), Long.valueOf(j3), Integer.valueOf(i2)}) == null) {
            this.u.j(j2, j3, i2);
        }
    }

    @Override // com.baidu.tieba.j99
    public void s(y58 y58Var, boolean z, int i2) {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeCommon(1048611, this, new Object[]{y58Var, Boolean.valueOf(z), Integer.valueOf(i2)}) == null) {
            z58 z58Var = this.J;
            if (z58Var != null) {
                this.y.p(z58Var.c());
            }
            this.y.t(y58Var, z, i2);
        }
    }

    @Override // com.baidu.tieba.j99
    public void onChangeSkinType() {
        int skinType;
        Interceptable interceptable = $ic;
        if ((interceptable != null && interceptable.invokeV(1048603, this) != null) || (skinType = TbadkCoreApplication.getInst().getSkinType()) == this.a) {
            return;
        }
        this.m.h(skinType);
        SkinManager.setViewTextColor(this.o, R.color.CAM_X0105, 1);
        SkinManager.setBackgroundColor(this.t, R.color.CAM_X0201);
        SkinManager.setBackgroundColor(this.e, R.color.CAM_X0207);
        SkinManager.setNavbarTitleColor(this.f.getCenterText(), R.color.CAM_X0105, R.color.s_navbar_title_color);
        LoadingView loadingView = this.j;
        if (loadingView != null) {
            loadingView.setBackground(SkinManager.getColor(R.color.CAM_X0201));
        }
        this.u.m(skinType);
        this.z.setTabTextColors(SkinManager.getColor(R.color.CAM_X0107), SkinManager.getColor(R.color.CAM_X0105));
        this.v.c(skinType);
        this.y.l(skinType);
        EMManager.from(this.C).setCorner(R.string.J_X07).setBackGroundColor(R.color.CAM_X0213);
        WebPManager.setPureDrawable(this.D, R.drawable.obfuscated_res_0x7f080b4d, R.color.CAM_X0105, WebPManager.ResourceStateType.NORMAL);
        EMManager.from(this.E).setCorner(R.string.J_X07).setBackGroundColor(R.color.CAM_X0213);
        EMManager.from(this.F).setTextColor(R.color.CAM_X0105).setTextSize(R.dimen.T_X07).setTextStyle(R.string.F_X01);
        WebPManager.setPureDrawable(this.G, R.drawable.obfuscated_res_0x7f080b4d, R.color.CAM_X0105, WebPManager.ResourceStateType.NORMAL);
        this.a = skinType;
    }
}
