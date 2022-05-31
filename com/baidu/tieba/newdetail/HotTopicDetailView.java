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
import com.baidu.tbadk.core.util.StringHelper;
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
import com.repackage.c17;
import com.repackage.cu4;
import com.repackage.d17;
import com.repackage.e17;
import com.repackage.ef8;
import com.repackage.eg;
import com.repackage.fd1;
import com.repackage.fg;
import com.repackage.ji;
import com.repackage.jn;
import com.repackage.li;
import com.repackage.lk7;
import com.repackage.mg;
import com.repackage.mk7;
import com.repackage.nk7;
import com.repackage.rc5;
import com.repackage.s35;
import com.repackage.t35;
import com.repackage.um;
import com.repackage.wq4;
import com.repackage.y07;
import com.repackage.z07;
import java.util.List;
@SuppressLint({"ViewConstructor"})
/* loaded from: classes3.dex */
public class HotTopicDetailView extends RelativeLayout implements mk7 {
    public static /* synthetic */ Interceptable $ic;
    public static int L;
    public transient /* synthetic */ FieldHolder $fh;
    public View A;
    public RecyclerView.OnScrollListener B;
    public boolean C;
    public ValueAnimator D;
    public d17 E;
    public AppBarLayout.OnOffsetChangedListener F;
    public cu4 G;
    public final eg<um> H;
    public Runnable I;
    public ClickableSpan J;
    public ClickableSpan K;
    public int a;
    public int b;
    public TbPageContext<HotTopicDetailActivity> c;
    public lk7 d;
    public View e;
    public NavigationBar f;
    public ImageView g;
    public boolean h;
    public ViewGroup i;
    public s35 j;
    public t35 k;
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
    public y07 w;
    public CustomViewPager x;
    public HotTopicDetailPagerAdapter y;
    public TbTabLayout z;

    /* loaded from: classes3.dex */
    public class a extends ClickableSpan {
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

        @Override // android.text.style.ClickableSpan
        public void onClick(View view2) {
            Interceptable interceptable = $ic;
            if (interceptable == null || interceptable.invokeL(1048576, this, view2) == null) {
                this.a.o.setText(this.a.p);
                this.a.P();
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

    /* loaded from: classes3.dex */
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
                this.a.S();
            }
        }
    }

    /* loaded from: classes3.dex */
    public class c implements View.OnClickListener {
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

        @Override // android.view.View.OnClickListener
        public void onClick(View view2) {
            Interceptable interceptable = $ic;
            if (interceptable == null || interceptable.invokeL(1048576, this, view2) == null) {
                nk7.f(this.a.c, "c14389");
                if (!ji.z()) {
                    this.a.c.showToast(R.string.obfuscated_res_0x7f0f144c);
                    return;
                }
                MessageManager.getInstance().dispatchResponsedMessage(new CustomResponsedMessage(2004011));
                if (ShareSwitch.isOn() || ViewHelper.checkUpIsLogin(this.a.g.getContext())) {
                    this.a.d.shareTopic(this.a.E);
                }
            }
        }
    }

    /* loaded from: classes3.dex */
    public class d implements Runnable {
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

        @Override // java.lang.Runnable
        public void run() {
            Interceptable interceptable = $ic;
            if (interceptable == null || interceptable.invokeV(1048576, this) == null) {
                this.a.t.setMinimumHeight(this.a.f.getHeight() + this.a.b);
            }
        }
    }

    /* loaded from: classes3.dex */
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
                this.a.U(i);
            }
        }
    }

    /* loaded from: classes3.dex */
    public class f implements cu4 {
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

        @Override // com.repackage.cu4
        public void a() {
            Interceptable interceptable = $ic;
            if (interceptable == null || interceptable.invokeV(1048576, this) == null) {
            }
        }

        @Override // com.repackage.cu4
        public void onLoadingStart() {
            Interceptable interceptable = $ic;
            if (interceptable == null || interceptable.invokeV(Constants.METHOD_GET_CONTACTER_INFO_FOR_SESSION, this) == null) {
                this.a.O();
            }
        }
    }

    /* loaded from: classes3.dex */
    public class g extends eg<um> {
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

        /* JADX DEBUG: Method merged with bridge method */
        @Override // com.repackage.eg
        public void onLoaded(um umVar, String str, int i) {
            Bitmap p;
            boolean z;
            int e;
            Interceptable interceptable = $ic;
            if (interceptable == null || interceptable.invokeLLI(1048576, this, umVar, str, i) == null) {
                super.onLoaded((g) umVar, str, i);
                if (umVar == null || !umVar.w() || (p = umVar.p()) == null) {
                    return;
                }
                fd1.a aVar = new fd1.a();
                aVar.c(Tri.TRUE);
                aVar.b(Tri.TRUE);
                aVar.d(50, 100);
                aVar.e(40, 80);
                String e2 = SmartColorSDK.d().e(aVar.a(), p);
                if (TextUtils.isEmpty(e2) || (e = ef8.e(e2)) == Integer.MAX_VALUE) {
                    z = false;
                } else {
                    z = true;
                    if (this.a.n != null) {
                        HotTopicDetailView.setWriteViewStyle(this.a.n, e);
                    }
                    if (this.a.m != null) {
                        this.a.m.setBgCoverViewColor(ef8.a(e, 0.5f));
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

    /* loaded from: classes3.dex */
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
            if ((interceptable == null || interceptable.invokeL(1048576, this, view2) == null) && ji.A() && this.a.d != null) {
                this.a.d.refreshFullData(1);
            }
        }
    }

    /* loaded from: classes3.dex */
    public class i implements Runnable {
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

        @Override // java.lang.Runnable
        public void run() {
            Interceptable interceptable = $ic;
            if ((interceptable == null || interceptable.invokeV(1048576, this) == null) && this.a.C) {
                this.a.X();
            }
        }
    }

    /* loaded from: classes3.dex */
    public class j extends ClickableSpan {
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

        @Override // android.text.style.ClickableSpan
        public void onClick(View view2) {
            Interceptable interceptable = $ic;
            if (interceptable == null || interceptable.invokeL(1048576, this, view2) == null) {
                SpannableStringBuilder spannableStringBuilder = new SpannableStringBuilder();
                spannableStringBuilder.append((CharSequence) this.a.p);
                if (this.a.p.length() > 500) {
                    spannableStringBuilder.append((CharSequence) "...  ");
                }
                String str = this.a.getResources().getString(R.string.obfuscated_res_0x7f0f0873) + GlideException.IndentedAppendable.INDENT;
                spannableStringBuilder.append((CharSequence) str);
                SpannableString spannableString = new SpannableString(spannableStringBuilder);
                spannableString.setSpan(this.a.K, spannableString.length() - str.length(), spannableString.length(), 33);
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
        L = TbadkCoreApplication.getInst().getResources().getDimensionPixelSize(R.dimen.tbds250);
    }

    /* JADX WARN: 'super' call moved to the top of the method (can break code semantics) */
    public HotTopicDetailView(TbPageContext<?> tbPageContext, lk7 lk7Var, Bundle bundle) {
        super(tbPageContext.getPageActivity());
        Interceptable interceptable = $ic;
        if (interceptable != null) {
            InitContext newInitContext = TitanRuntime.newInitContext();
            newInitContext.initArgs = r2;
            Object[] objArr = {tbPageContext, lk7Var, bundle};
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
        this.B = new b(this);
        this.C = false;
        this.F = new e(this);
        this.G = new f(this);
        this.H = new g(this);
        this.I = new i(this);
        this.J = new j(this);
        this.K = new a(this);
        this.c = tbPageContext;
        this.d = lk7Var;
        V(bundle);
        a();
    }

    @Nullable
    public static ShadowLayout Q(@NonNull TextView textView) {
        InterceptResult invokeL;
        Interceptable interceptable = $ic;
        if (interceptable == null || (invokeL = interceptable.invokeL(65552, null, textView)) == null) {
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
        if (interceptable == null || interceptable.invokeLI(65553, null, textView, i2) == null) {
            wq4 d2 = wq4.d(textView);
            d2.n(R.string.J_X01);
            d2.v(R.color.CAM_X0101);
            d2.g(i2);
            textView.setCompoundDrawablesWithIntrinsicBounds(WebPManager.getPureDrawable(R.drawable.icon_pure_topic_post48, SkinManager.getColor(R.color.CAM_X0101), null), (Drawable) null, (Drawable) null, (Drawable) null);
            ShadowLayout Q = Q(textView);
            if (Q != null) {
                Q.e(R.dimen.obfuscated_res_0x7f070234);
                Q.f(R.dimen.obfuscated_res_0x7f07030b);
                Q.d(R.dimen.obfuscated_res_0x7f070232, R.dimen.obfuscated_res_0x7f070224);
                Q.c(ef8.a(i2, 0.5f));
                Q.a();
            }
        }
    }

    public final void O() {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeV(1048576, this) == null) {
            mg.a().postDelayed(this.I, 5000L);
            this.C = true;
            this.d.refreshFullData(l());
        }
    }

    public final void P() {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeV(Constants.METHOD_GET_CONTACTER_INFO_FOR_SESSION, this) == null) {
            SpannableStringBuilder spannableStringBuilder = new SpannableStringBuilder();
            spannableStringBuilder.append((CharSequence) this.p);
            String string = getResources().getString(R.string.obfuscated_res_0x7f0f0876);
            SpannableStringBuilder spannableStringBuilder2 = (SpannableStringBuilder) spannableStringBuilder.subSequence(0, (this.o.getLayout().getLineEnd(1) - string.length()) - 2);
            spannableStringBuilder2.append((CharSequence) "...  ");
            int length = spannableStringBuilder2.length();
            spannableStringBuilder2.append((CharSequence) string);
            SpannableString spannableString = new SpannableString(spannableStringBuilder2);
            spannableString.setSpan(this.J, length - 1, spannableString.length(), 33);
            this.o.setText(spannableString);
            TextView textView = this.o;
            textView.setHeight(textView.getLineHeight() * 2);
            this.o.scrollTo(0, 0);
            this.o.requestLayout();
        }
    }

    public final void R(e17 e17Var) {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeL(Constants.METHOD_SEND_USER_MSG, this, e17Var) == null) {
            if (StringUtils.isNull(e17Var.c)) {
                this.o.setVisibility(8);
            } else {
                this.o.setText(e17Var.c);
            }
        }
    }

    public final void S() {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeV(1048579, this) == null) {
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

    public final void T(@NonNull d17 d17Var) {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeL(1048580, this, d17Var) == null) {
            W();
            this.m.setTopicInfo(d17Var.e());
            if (SwitchManager.getInstance().findType(IColorSDKSwitch.KEY) == 1 && d17Var.e() != null && !TextUtils.isEmpty(d17Var.e().f)) {
                fg.h().m(d17Var.e().f, 39, this.H, this.c.getUniqueId());
            }
            R(d17Var.e());
            d(d17Var);
            List<jn> f2 = d17Var.f();
            if (ListUtils.isEmpty(f2)) {
                this.v.setVisibility(8);
            } else {
                this.v.setData(f2);
                this.v.setVisibility(0);
            }
            if (d17Var.e() != null) {
                String str = d17Var.e().b;
                if (rc5.d(str) > 15) {
                    str = rc5.n(str, 15) + StringHelper.STRING_MORE;
                }
                this.f.setCenterTextTitle(String.format(getContext().getString(R.string.obfuscated_res_0x7f0f0878), str));
            }
        }
    }

    public final void U(int i2) {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeI(1048581, this, i2) == null) {
            int i3 = i2 + L;
            if (i3 < 0) {
                i3 = 0;
            }
            float f2 = 1.0f - ((i3 * 1.0f) / L);
            this.e.setAlpha(f2);
            this.f.getCenterText().setAlpha(f2);
            S();
            double d2 = f2;
            if (d2 > 0.1d) {
                StatusbarColorUtils.setStatusBarDarkIcon(this.c.getPageActivity().getWindow(), true);
            } else {
                StatusbarColorUtils.setStatusBarDarkIcon(this.c.getPageActivity().getWindow(), false);
            }
            if ((d2 > 0.3d && this.a == 0) || this.E == null) {
                SvgManager.getInstance().setPureDrawableWithDayNightModeAutoChange((ImageView) this.f.findViewById(R.id.obfuscated_res_0x7f092442), R.drawable.obfuscated_res_0x7f08060f, R.color.CAM_X0105, SvgManager.SvgResourceStateType.NORMAL_PRESS);
                SvgManager.getInstance().setPureDrawableWithDayNightModeAutoChange(this.g, R.drawable.obfuscated_res_0x7f0809f2, R.color.CAM_X0105, SvgManager.SvgResourceStateType.NORMAL_PRESS);
                return;
            }
            SvgManager.getInstance().setPureDrawableWithDayNightModeAutoChange((ImageView) this.f.findViewById(R.id.obfuscated_res_0x7f092442), R.drawable.obfuscated_res_0x7f08060f, R.color.white_alpha100, SvgManager.SvgResourceStateType.NORMAL_PRESS);
            SvgManager.getInstance().setPureDrawableWithDayNightModeAutoChange(this.g, R.drawable.obfuscated_res_0x7f0809f2, R.color.white_alpha100, SvgManager.SvgResourceStateType.NORMAL_PRESS);
        }
    }

    public final void V(Bundle bundle) {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeL(1048582, this, bundle) == null) {
            LayoutInflater.from(getContext()).inflate(R.layout.obfuscated_res_0x7f0d0039, (ViewGroup) this, true);
            View findViewById = findViewById(R.id.obfuscated_res_0x7f092083);
            this.e = findViewById;
            findViewById.setAlpha(0.0f);
            NavigationBar navigationBar = (NavigationBar) findViewById(R.id.obfuscated_res_0x7f092379);
            this.f = navigationBar;
            navigationBar.addSystemImageButton(NavigationBar.ControlAlign.HORIZONTAL_LEFT, NavigationBar.ControlType.BACK_BUTTON);
            this.f.getCenterText().setAlpha(0.0f);
            ImageView imageView = (ImageView) this.f.addCustomView(NavigationBar.ControlAlign.HORIZONTAL_RIGHT, R.layout.obfuscated_res_0x7f0d03aa, new c(this));
            this.g = imageView;
            imageView.setVisibility(4);
            View findViewById2 = findViewById(R.id.obfuscated_res_0x7f091d9a);
            ViewGroup.LayoutParams layoutParams = findViewById2.getLayoutParams();
            layoutParams.height = this.b;
            findViewById2.setLayoutParams(layoutParams);
            this.i = (ViewGroup) findViewById(R.id.obfuscated_res_0x7f0906c3);
            LottieSlideLoadingLayout lottieSlideLoadingLayout = (LottieSlideLoadingLayout) findViewById(R.id.obfuscated_res_0x7f0906c0);
            this.l = lottieSlideLoadingLayout;
            lottieSlideLoadingLayout.j(this.G);
            this.l.n();
            HotTopicDetailHeadView hotTopicDetailHeadView = (HotTopicDetailHeadView) findViewById(R.id.obfuscated_res_0x7f090d6e);
            this.m = hotTopicDetailHeadView;
            this.l.l(hotTopicDetailHeadView);
            this.t = findViewById(R.id.obfuscated_res_0x7f090cee);
            this.f.post(new d(this));
            this.o = (TextView) findViewById(R.id.obfuscated_res_0x7f090d71);
            this.u = (HotTopicDetailPkLayout) findViewById(R.id.obfuscated_res_0x7f090d6f);
            HotTopicDetailSpecialLayout hotTopicDetailSpecialLayout = (HotTopicDetailSpecialLayout) findViewById(R.id.obfuscated_res_0x7f090d70);
            this.v = hotTopicDetailSpecialLayout;
            hotTopicDetailSpecialLayout.G(this.c);
            this.r = findViewById(R.id.obfuscated_res_0x7f0906bf);
            AppBarLayout appBarLayout = (AppBarLayout) findViewById(R.id.obfuscated_res_0x7f090276);
            this.s = appBarLayout;
            appBarLayout.addOnOffsetChangedListener(this.F);
            this.x = (CustomViewPager) findViewById(R.id.obfuscated_res_0x7f090d74);
            HotTopicDetailPagerAdapter hotTopicDetailPagerAdapter = new HotTopicDetailPagerAdapter(getContext());
            this.y = hotTopicDetailPagerAdapter;
            hotTopicDetailPagerAdapter.q(this.B);
            this.x.setAdapter(this.y);
            TbTabLayout tbTabLayout = (TbTabLayout) findViewById(R.id.obfuscated_res_0x7f091e23);
            this.z = tbTabLayout;
            tbTabLayout.setSelectedTabTextBlod(true);
            this.z.setTabTextSize(li.f(TbadkCoreApplication.getInst().getContext(), R.dimen.tbds46));
            this.z.setSelectedTabIndicatorColor(SkinManager.getColor(R.color.CAM_X0302));
            this.z.setupWithViewPager(this.x);
            this.A = findViewById(R.id.obfuscated_res_0x7f0907ca);
            TextView textView = (TextView) findViewById(R.id.obfuscated_res_0x7f0920f5);
            this.n = textView;
            this.w = new y07(textView, this.c);
        }
    }

    public final void W() {
        Interceptable interceptable = $ic;
        if (!(interceptable == null || interceptable.invokeV(1048583, this) == null) || this.h) {
            return;
        }
        this.h = true;
        this.g.setVisibility(0);
        SvgManager.getInstance().setPureDrawableWithDayNightModeAutoChange((ImageView) this.f.findViewById(R.id.obfuscated_res_0x7f092442), R.drawable.obfuscated_res_0x7f08060f, R.color.white_alpha100, SvgManager.SvgResourceStateType.NORMAL_PRESS);
        SvgManager.getInstance().setPureDrawableWithDayNightModeAutoChange(this.g, R.drawable.obfuscated_res_0x7f0809f2, R.color.white_alpha100, SvgManager.SvgResourceStateType.NORMAL_PRESS);
        SkinManager.setNavbarTitleColor(this.f.getCenterText(), R.color.CAM_X0105, R.color.s_navbar_title_color);
        lk7 lk7Var = this.d;
        if (lk7Var instanceof Activity) {
            UtilHelper.changeStatusBarIconAndTextColor(true, (Activity) lk7Var);
        }
    }

    public final void X() {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeV(InputDeviceCompat.SOURCE_TOUCHPAD, this) == null) {
            this.C = false;
            this.l.o();
        }
    }

    @Override // com.repackage.mk7
    public void a() {
        int skinType;
        Interceptable interceptable = $ic;
        if (!(interceptable == null || interceptable.invokeV(1048585, this) == null) || (skinType = TbadkCoreApplication.getInst().getSkinType()) == this.a) {
            return;
        }
        this.m.h(skinType);
        SkinManager.setViewTextColor(this.o, R.color.CAM_X0105, 1);
        SkinManager.setBackgroundColor(this.t, R.color.CAM_X0201);
        SkinManager.setBackgroundColor(this.e, R.color.CAM_X0207);
        SkinManager.setNavbarTitleColor(this.f.getCenterText(), R.color.CAM_X0105, R.color.s_navbar_title_color);
        s35 s35Var = this.j;
        if (s35Var != null) {
            s35Var.o(SkinManager.getColor(R.color.CAM_X0201));
        }
        this.u.m(skinType);
        this.z.setTabTextColors(SkinManager.getColor(R.color.CAM_X0107), SkinManager.getColor(R.color.CAM_X0105));
        this.v.I(skinType);
        this.y.l(skinType);
        this.a = skinType;
    }

    @Override // com.repackage.mk7
    public void b(boolean z) {
        int i2;
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeZ(1048586, this, z) == null) {
            ShadowLayout Q = Q(this.n);
            if (!z) {
                if (Q != null) {
                    Q.setVisibility(0);
                    return;
                }
                return;
            }
            if (Q != null) {
                Q.setVisibility(8);
            }
            if (this.k == null) {
                this.k = new t35(this.c.getPageActivity(), null);
            }
            this.k.k(this.c.getResources().getDimensionPixelSize(R.dimen.obfuscated_res_0x7f0702ad));
            this.k.e();
            this.k.f(R.color.CAM_X0201);
            this.k.i(R.drawable.new_pic_emotion_06);
            this.k.o(this.c.getString(R.string.obfuscated_res_0x7f0f0875));
            this.k.attachView(this.i, false);
            lk7 lk7Var = this.d;
            if (!(lk7Var instanceof Activity) || (i2 = this.a) == 1 || i2 == 4) {
                return;
            }
            UtilHelper.changeStatusBarIconAndTextColor(false, (Activity) lk7Var);
        }
    }

    @Override // com.repackage.mk7
    public void c(int i2) {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeI(1048587, this, i2) == null) {
            this.y.g(i2);
        }
    }

    @Override // com.repackage.mk7
    public void d(d17 d17Var) {
        z07 z07Var;
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeL(1048588, this, d17Var) == null) {
            if (d17Var.a() != null) {
                z07Var = d17Var.a();
                z07Var.e = 3;
            } else if (d17Var.b() != null) {
                z07Var = d17Var.b();
                z07Var.e = 2;
            } else if (d17Var.g() != null) {
                z07Var = d17Var.g();
                z07Var.e = 1;
            } else {
                z07Var = null;
            }
            this.m.setBlessInfo(z07Var);
            if (d17Var.d() == null) {
                this.u.setVisibility(8);
                return;
            }
            this.u.setVisibility(0);
            this.u.i(d17Var.d());
        }
    }

    @Override // com.repackage.mk7
    public void destroy() {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeV(1048589, this) == null) {
            q();
            e();
            HotTopicDetailPagerAdapter hotTopicDetailPagerAdapter = this.y;
            if (hotTopicDetailPagerAdapter != null) {
                hotTopicDetailPagerAdapter.d();
            }
            if (this.C) {
                X();
            }
            ValueAnimator valueAnimator = this.D;
            if (valueAnimator != null) {
                valueAnimator.cancel();
                this.D.removeAllListeners();
                this.D.removeAllUpdateListeners();
                this.D = null;
            }
            mg.a().removeCallbacks(this.I);
        }
    }

    @Override // com.repackage.mk7
    public void e() {
        t35 t35Var;
        Interceptable interceptable = $ic;
        if (!(interceptable == null || interceptable.invokeV(1048590, this) == null) || (t35Var = this.k) == null) {
            return;
        }
        t35Var.dettachView(this.i);
        this.k = null;
    }

    @Override // com.repackage.mk7
    public void f(boolean z) {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeZ(1048591, this, z) == null) {
            t35 t35Var = this.k;
            if (t35Var == null || !t35Var.isViewAttached()) {
                if (this.k == null) {
                    this.k = new t35(getContext(), new h(this));
                }
                this.k.k(this.c.getResources().getDimensionPixelSize(R.dimen.obfuscated_res_0x7f0702ad));
                this.k.attachView(this.i, false);
                this.k.f(R.color.CAM_X0201);
                this.k.p();
            }
        }
    }

    @Override // com.repackage.mk7
    public void g(long j2, long j3) {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeCommon(1048592, this, new Object[]{Long.valueOf(j2), Long.valueOf(j3)}) == null) {
            this.m.d(j2, j3);
        }
    }

    @Override // com.repackage.mk7
    public d17 h() {
        InterceptResult invokeV;
        Interceptable interceptable = $ic;
        return (interceptable == null || (invokeV = interceptable.invokeV(1048593, this)) == null) ? this.E : (d17) invokeV.objValue;
    }

    @Override // com.repackage.mk7
    public void i() {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeV(1048594, this) == null) {
            if (this.j == null) {
                s35 s35Var = new s35(getContext(), getContext().getResources().getDimensionPixelSize(R.dimen.obfuscated_res_0x7f0702b8));
                this.j = s35Var;
                s35Var.o(SkinManager.getColor(R.color.CAM_X0201));
            }
            this.j.attachView(this.i, false);
        }
    }

    @Override // com.repackage.mk7
    public void j(boolean z, int i2) {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeCommon(1048595, this, new Object[]{Boolean.valueOf(z), Integer.valueOf(i2)}) == null) {
            this.y.r(z, i2);
        }
    }

    @Override // com.repackage.mk7
    public void k(int i2) {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeI(1048596, this, i2) == null) {
            this.y.s(i2);
        }
    }

    @Override // com.repackage.mk7
    public int l() {
        InterceptResult invokeV;
        Interceptable interceptable = $ic;
        return (interceptable == null || (invokeV = interceptable.invokeV(1048597, this)) == null) ? this.y.c() : invokeV.intValue;
    }

    @Override // com.repackage.mk7
    public void m() {
        Interceptable interceptable = $ic;
        if ((interceptable == null || interceptable.invokeV(1048598, this) == null) && this.C) {
            X();
            mg.a().removeCallbacks(this.I);
        }
    }

    @Override // com.repackage.mk7
    public void n(@NonNull d17 d17Var) {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeL(1048599, this, d17Var) == null) {
            this.E = d17Var;
            if (d17Var.e() != null) {
                this.w.e(this.E.e().a);
                this.w.d(this.E.e().b);
            }
            T(d17Var);
        }
    }

    @Override // com.repackage.mk7
    public void o(long j2, long j3, int i2) {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeCommon(1048600, this, new Object[]{Long.valueOf(j2), Long.valueOf(j3), Integer.valueOf(i2)}) == null) {
            this.u.j(j2, j3, i2);
        }
    }

    @Override // android.view.ViewGroup, android.view.View
    public void onDetachedFromWindow() {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeV(1048601, this) == null) {
            destroy();
            super.onDetachedFromWindow();
        }
    }

    @Override // com.repackage.mk7
    public c17 p(int i2) {
        InterceptResult invokeI;
        Interceptable interceptable = $ic;
        return (interceptable == null || (invokeI = interceptable.invokeI(1048602, this, i2)) == null) ? this.y.b(i2) : (c17) invokeI.objValue;
    }

    @Override // com.repackage.mk7
    public void pause() {
        HotTopicDetailPagerAdapter hotTopicDetailPagerAdapter;
        Interceptable interceptable = $ic;
        if (!(interceptable == null || interceptable.invokeV(1048603, this) == null) || (hotTopicDetailPagerAdapter = this.y) == null) {
            return;
        }
        hotTopicDetailPagerAdapter.m();
    }

    @Override // com.repackage.mk7
    public void q() {
        s35 s35Var;
        Interceptable interceptable = $ic;
        if (!(interceptable == null || interceptable.invokeV(1048604, this) == null) || (s35Var = this.j) == null) {
            return;
        }
        s35Var.dettachView(this.i);
    }

    @Override // com.repackage.mk7
    public void r() {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeV(1048605, this) == null) {
            this.y.j();
        }
    }

    @Override // com.repackage.mk7
    public void resume() {
        HotTopicDetailPagerAdapter hotTopicDetailPagerAdapter;
        Interceptable interceptable = $ic;
        if (!(interceptable == null || interceptable.invokeV(1048606, this) == null) || (hotTopicDetailPagerAdapter = this.y) == null) {
            return;
        }
        hotTopicDetailPagerAdapter.n();
    }

    @Override // com.repackage.mk7
    public void s(int i2) {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeI(1048607, this, i2) == null) {
            this.y.h(i2);
        }
    }

    @Override // com.repackage.mk7
    public void t(c17 c17Var, boolean z, int i2) {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeCommon(1048608, this, new Object[]{c17Var, Boolean.valueOf(z), Integer.valueOf(i2)}) == null) {
            d17 d17Var = this.E;
            if (d17Var != null) {
                this.y.o(d17Var.c());
            }
            this.y.t(c17Var, z, i2);
        }
    }
}
