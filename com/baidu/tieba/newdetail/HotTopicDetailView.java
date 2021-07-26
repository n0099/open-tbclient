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
import d.a.d.e.p.l;
import d.a.d.k.e.n;
import d.a.k0.a;
import d.a.p0.b1.j0;
import java.io.ByteArrayOutputStream;
import java.io.IOException;
import java.util.List;
@SuppressLint({"ViewConstructor"})
/* loaded from: classes4.dex */
public class HotTopicDetailView extends RelativeLayout implements d.a.q0.b2.b {
    public static /* synthetic */ Interceptable $ic;
    public static int P;
    public transient /* synthetic */ FieldHolder $fh;
    public d.a.q0.g1.b.c A;
    public CustomViewPager B;
    public HotTopicDetailPagerAdapter C;
    public TbTabLayout D;
    public View E;
    public RecyclerView.OnScrollListener F;
    public boolean G;
    public ValueAnimator H;
    public d.a.q0.g1.c.e I;
    public AppBarLayout.OnOffsetChangedListener J;
    public d.a.p0.s.f0.q.b K;
    public final d.a.d.e.l.c<d.a.d.k.d.a> L;
    public Runnable M;
    public ClickableSpan N;
    public ClickableSpan O;

    /* renamed from: e  reason: collision with root package name */
    public int f18861e;

    /* renamed from: f  reason: collision with root package name */
    public int f18862f;

    /* renamed from: g  reason: collision with root package name */
    public TbPageContext<?> f18863g;

    /* renamed from: h  reason: collision with root package name */
    public d.a.q0.b2.a f18864h;

    /* renamed from: i  reason: collision with root package name */
    public View f18865i;
    public NavigationBar j;
    public ImageView k;
    public boolean l;
    public ViewGroup m;
    public d.a.p0.f0.g n;
    public d.a.p0.f0.h o;
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

    /* loaded from: classes4.dex */
    public class a extends ClickableSpan {
        public static /* synthetic */ Interceptable $ic;
        public transient /* synthetic */ FieldHolder $fh;

        /* renamed from: e  reason: collision with root package name */
        public final /* synthetic */ HotTopicDetailView f18866e;

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
            this.f18866e = hotTopicDetailView;
        }

        @Override // android.text.style.ClickableSpan
        public void onClick(View view) {
            Interceptable interceptable = $ic;
            if (interceptable == null || interceptable.invokeL(1048576, this, view) == null) {
                this.f18866e.s.setText(this.f18866e.t);
                this.f18866e.P();
            }
        }

        @Override // android.text.style.ClickableSpan, android.text.style.CharacterStyle
        public void updateDrawState(TextPaint textPaint) {
            Interceptable interceptable = $ic;
            if (interceptable == null || interceptable.invokeL(Constants.METHOD_GET_CONTACTER_INFO_FOR_SESSION, this, textPaint) == null) {
                textPaint.setColor(this.f18866e.getResources().getColor(R.color.CAM_X0304));
            }
        }
    }

    /* loaded from: classes4.dex */
    public class b extends RecyclerView.OnScrollListener {
        public static /* synthetic */ Interceptable $ic;
        public transient /* synthetic */ FieldHolder $fh;

        /* renamed from: a  reason: collision with root package name */
        public final /* synthetic */ HotTopicDetailView f18867a;

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
            this.f18867a = hotTopicDetailView;
        }

        @Override // androidx.recyclerview.widget.RecyclerView.OnScrollListener
        public void onScrolled(RecyclerView recyclerView, int i2, int i3) {
            Interceptable interceptable = $ic;
            if (interceptable == null || interceptable.invokeLII(1048576, this, recyclerView, i2, i3) == null) {
                this.f18867a.R();
            }
        }
    }

    /* loaded from: classes4.dex */
    public class c implements View.OnClickListener {
        public static /* synthetic */ Interceptable $ic;
        public transient /* synthetic */ FieldHolder $fh;

        /* renamed from: e  reason: collision with root package name */
        public final /* synthetic */ HotTopicDetailView f18868e;

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
            this.f18868e = hotTopicDetailView;
        }

        @Override // android.view.View.OnClickListener
        public void onClick(View view) {
            Interceptable interceptable = $ic;
            if (interceptable == null || interceptable.invokeL(1048576, this, view) == null) {
                if (!d.a.d.e.p.j.z()) {
                    this.f18868e.f18863g.showToast(R.string.topic_share_no_network);
                    return;
                }
                MessageManager.getInstance().dispatchResponsedMessage(new CustomResponsedMessage(2004011));
                if (ShareSwitch.isOn() || ViewHelper.checkUpIsLogin(this.f18868e.k.getContext())) {
                    this.f18868e.f18864h.shareTopic(this.f18868e.I);
                }
            }
        }
    }

    /* loaded from: classes4.dex */
    public class d implements Runnable {
        public static /* synthetic */ Interceptable $ic;
        public transient /* synthetic */ FieldHolder $fh;

        /* renamed from: e  reason: collision with root package name */
        public final /* synthetic */ HotTopicDetailView f18869e;

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
            this.f18869e = hotTopicDetailView;
        }

        @Override // java.lang.Runnable
        public void run() {
            Interceptable interceptable = $ic;
            if (interceptable == null || interceptable.invokeV(1048576, this) == null) {
                this.f18869e.x.setMinimumHeight(this.f18869e.j.getHeight() + this.f18869e.f18862f);
            }
        }
    }

    /* loaded from: classes4.dex */
    public class e implements AppBarLayout.OnOffsetChangedListener {
        public static /* synthetic */ Interceptable $ic;
        public transient /* synthetic */ FieldHolder $fh;

        /* renamed from: a  reason: collision with root package name */
        public final /* synthetic */ HotTopicDetailView f18870a;

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
            this.f18870a = hotTopicDetailView;
        }

        @Override // com.google.android.material.appbar.AppBarLayout.OnOffsetChangedListener, com.google.android.material.appbar.AppBarLayout.BaseOnOffsetChangedListener
        public void onOffsetChanged(AppBarLayout appBarLayout, int i2) {
            Interceptable interceptable = $ic;
            if (interceptable == null || interceptable.invokeLI(1048576, this, appBarLayout, i2) == null) {
                if (this.f18870a.p != null) {
                    this.f18870a.p.setEnableSlideLoading(i2 == 0);
                }
                this.f18870a.T(i2);
            }
        }
    }

    /* loaded from: classes4.dex */
    public class f implements d.a.p0.s.f0.q.b {
        public static /* synthetic */ Interceptable $ic;
        public transient /* synthetic */ FieldHolder $fh;

        /* renamed from: a  reason: collision with root package name */
        public final /* synthetic */ HotTopicDetailView f18871a;

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
            this.f18871a = hotTopicDetailView;
        }

        @Override // d.a.p0.s.f0.q.b
        public void a() {
            Interceptable interceptable = $ic;
            if (interceptable == null || interceptable.invokeV(1048576, this) == null) {
            }
        }

        @Override // d.a.p0.s.f0.q.b
        public void onLoadingStart() {
            Interceptable interceptable = $ic;
            if (interceptable == null || interceptable.invokeV(Constants.METHOD_GET_CONTACTER_INFO_FOR_SESSION, this) == null) {
                this.f18871a.O();
            }
        }
    }

    /* loaded from: classes4.dex */
    public class g extends d.a.d.e.l.c<d.a.d.k.d.a> {
        public static /* synthetic */ Interceptable $ic;
        public transient /* synthetic */ FieldHolder $fh;

        /* renamed from: a  reason: collision with root package name */
        public final /* synthetic */ HotTopicDetailView f18872a;

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
            this.f18872a = hotTopicDetailView;
        }

        /* JADX DEBUG: Method merged with bridge method */
        @Override // d.a.d.e.l.c
        public void onLoaded(d.a.d.k.d.a aVar, String str, int i2) {
            Bitmap p;
            byte[] N;
            boolean z;
            int c2;
            Interceptable interceptable = $ic;
            if (interceptable == null || interceptable.invokeLLI(1048576, this, aVar, str, i2) == null) {
                super.onLoaded((g) aVar, str, i2);
                if (aVar == null || !aVar.w() || (p = aVar.p()) == null || (N = this.f18872a.N(p, Bitmap.CompressFormat.JPEG, 100)) == null) {
                    return;
                }
                a.C0621a c0621a = new a.C0621a();
                c0621a.c(Tri.TRUE);
                c0621a.b(Tri.TRUE);
                c0621a.d(50, 100);
                c0621a.e(40, 80);
                String c3 = SmartColorSDK.b().c(c0621a.a(), N, N.length);
                if (TextUtils.isEmpty(c3) || (c2 = d.a.q0.h3.c.c(c3)) == Integer.MAX_VALUE) {
                    z = false;
                } else {
                    z = true;
                    if (this.f18872a.r != null) {
                        this.f18872a.r.setStartAndEndColor(c2, c2);
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

    /* loaded from: classes4.dex */
    public class h implements View.OnClickListener {
        public static /* synthetic */ Interceptable $ic;
        public transient /* synthetic */ FieldHolder $fh;

        /* renamed from: e  reason: collision with root package name */
        public final /* synthetic */ HotTopicDetailView f18873e;

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
            this.f18873e = hotTopicDetailView;
        }

        @Override // android.view.View.OnClickListener
        public void onClick(View view) {
            Interceptable interceptable = $ic;
            if ((interceptable == null || interceptable.invokeL(1048576, this, view) == null) && d.a.d.e.p.j.A() && this.f18873e.f18864h != null) {
                this.f18873e.f18864h.refreshFullData(1);
            }
        }
    }

    /* loaded from: classes4.dex */
    public class i implements Runnable {
        public static /* synthetic */ Interceptable $ic;
        public transient /* synthetic */ FieldHolder $fh;

        /* renamed from: e  reason: collision with root package name */
        public final /* synthetic */ HotTopicDetailView f18874e;

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
            this.f18874e = hotTopicDetailView;
        }

        @Override // java.lang.Runnable
        public void run() {
            Interceptable interceptable = $ic;
            if ((interceptable == null || interceptable.invokeV(1048576, this) == null) && this.f18874e.G) {
                this.f18874e.W();
            }
        }
    }

    /* loaded from: classes4.dex */
    public class j extends ClickableSpan {
        public static /* synthetic */ Interceptable $ic;
        public transient /* synthetic */ FieldHolder $fh;

        /* renamed from: e  reason: collision with root package name */
        public final /* synthetic */ HotTopicDetailView f18875e;

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
            this.f18875e = hotTopicDetailView;
        }

        @Override // android.text.style.ClickableSpan
        public void onClick(View view) {
            Interceptable interceptable = $ic;
            if (interceptable == null || interceptable.invokeL(1048576, this, view) == null) {
                SpannableStringBuilder spannableStringBuilder = new SpannableStringBuilder();
                spannableStringBuilder.append((CharSequence) this.f18875e.t);
                if (this.f18875e.t.length() > 500) {
                    spannableStringBuilder.append((CharSequence) "...  ");
                }
                String str = this.f18875e.getResources().getString(R.string.hot_topic_coll) + GlideException.IndentedAppendable.INDENT;
                spannableStringBuilder.append((CharSequence) str);
                SpannableString spannableString = new SpannableString(spannableStringBuilder);
                spannableString.setSpan(this.f18875e.O, spannableString.length() - str.length(), spannableString.length(), 33);
                this.f18875e.s.setText(spannableString);
                this.f18875e.s.setHeight(this.f18875e.u * this.f18875e.s.getLineHeight());
                int lineCount = this.f18875e.s.getLineCount() * this.f18875e.s.getLineHeight();
                if (lineCount > this.f18875e.u * this.f18875e.s.getLineHeight()) {
                    this.f18875e.s.scrollTo(0, lineCount - (this.f18875e.u * this.f18875e.s.getLineHeight()));
                }
                this.f18875e.s.requestLayout();
            }
        }

        @Override // android.text.style.ClickableSpan, android.text.style.CharacterStyle
        public void updateDrawState(TextPaint textPaint) {
            Interceptable interceptable = $ic;
            if (interceptable == null || interceptable.invokeL(Constants.METHOD_GET_CONTACTER_INFO_FOR_SESSION, this, textPaint) == null) {
                textPaint.setColor(this.f18875e.getResources().getColor(R.color.CAM_X0304));
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
    public HotTopicDetailView(TbPageContext<?> tbPageContext, d.a.q0.b2.a aVar, Bundle bundle) {
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
        this.f18861e = 3;
        this.f18862f = UtilHelper.getStatusBarHeight();
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
        this.f18863g = tbPageContext;
        this.f18864h = aVar;
        U(bundle);
        a();
    }

    public final byte[] N(Bitmap bitmap, Bitmap.CompressFormat compressFormat, int i2) {
        InterceptResult invokeLLI;
        Interceptable interceptable = $ic;
        if (interceptable == null || (invokeLLI = interceptable.invokeLLI(1048576, this, bitmap, compressFormat, i2)) == null) {
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

    public final void O() {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeV(Constants.METHOD_GET_CONTACTER_INFO_FOR_SESSION, this) == null) {
            d.a.d.e.m.e.a().postDelayed(this.M, 5000L);
            this.G = true;
            this.f18864h.refreshFullData(k());
        }
    }

    public final void P() {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeV(Constants.METHOD_SEND_USER_MSG, this) == null) {
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

    public final void Q(d.a.q0.g1.c.f fVar) {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeL(1048579, this, fVar) == null) {
            if (StringUtils.isNull(fVar.f56962g)) {
                this.s.setVisibility(8);
            } else {
                this.s.setText(fVar.f56962g);
            }
        }
    }

    public final void R() {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeV(1048580, this) == null) {
            if (this.f18862f + this.j.getHeight() >= this.v.getY()) {
                SkinManager.setBackgroundColor(this.D, R.color.CAM_X0207);
                if (this.f18861e == 0) {
                    this.E.setVisibility(0);
                    return;
                }
                return;
            }
            SkinManager.setBackgroundColor(this.D, R.color.transparent);
            this.E.setVisibility(8);
        }
    }

    public final void S(@NonNull d.a.q0.g1.c.e eVar) {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeL(1048581, this, eVar) == null) {
            V();
            this.q.setTopicInfo(eVar.h());
            if (SwitchManager.getInstance().findType(IColorSDKSwitch.KEY) == 1 && eVar.h() != null && !TextUtils.isEmpty(eVar.h().f56964i)) {
                d.a.d.e.l.d.h().m(eVar.h().f56964i, 39, this.L, this.f18863g.getUniqueId());
            }
            Q(eVar.h());
            c(eVar);
            List<n> l = eVar.l();
            if (ListUtils.isEmpty(l)) {
                this.z.setVisibility(8);
            } else {
                this.z.setData(l);
                this.z.setVisibility(0);
            }
            if (eVar.h() != null) {
                String str = eVar.h().f56961f;
                if (j0.d(str) > 15) {
                    str = j0.m(str, 15) + StringHelper.STRING_MORE;
                }
                this.j.setCenterTextTitle(String.format(getContext().getString(R.string.hot_topic_detail_write_name), str));
            }
        }
    }

    public final void T(int i2) {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeI(1048582, this, i2) == null) {
            int i3 = i2 + P;
            if (i3 < 0) {
                i3 = 0;
            }
            float f2 = 1.0f - ((i3 * 1.0f) / P);
            this.f18865i.setAlpha(f2);
            this.j.getCenterText().setAlpha(f2);
            R();
            double d2 = f2;
            if (d2 > 0.1d) {
                StatusbarColorUtils.setStatusBarDarkIcon(this.f18863g.getPageActivity().getWindow(), true);
            } else {
                StatusbarColorUtils.setStatusBarDarkIcon(this.f18863g.getPageActivity().getWindow(), false);
            }
            if ((d2 > 0.3d && this.f18861e == 0) || this.I == null) {
                SvgManager.getInstance().setPureDrawableWithDayNightModeAutoChange((ImageView) this.j.findViewById(R.id.widget_navi_back_button), R.drawable.ic_icon_pure_topbar_return40_svg, R.color.CAM_X0105, SvgManager.SvgResourceStateType.NORMAL_PRESS);
                SvgManager.getInstance().setPureDrawableWithDayNightModeAutoChange(this.k, R.drawable.icon_pure_topbar_share44_svg, R.color.CAM_X0105, SvgManager.SvgResourceStateType.NORMAL_PRESS);
                return;
            }
            SvgManager.getInstance().setPureDrawableWithDayNightModeAutoChange((ImageView) this.j.findViewById(R.id.widget_navi_back_button), R.drawable.ic_icon_pure_topbar_return40_svg, R.color.white_alpha100, SvgManager.SvgResourceStateType.NORMAL_PRESS);
            SvgManager.getInstance().setPureDrawableWithDayNightModeAutoChange(this.k, R.drawable.icon_pure_topbar_share44_svg, R.color.white_alpha100, SvgManager.SvgResourceStateType.NORMAL_PRESS);
        }
    }

    public final void U(Bundle bundle) {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeL(1048583, this, bundle) == null) {
            LayoutInflater.from(getContext()).inflate(R.layout.activity_hot_topic_detail_layout, (ViewGroup) this, true);
            View findViewById = findViewById(R.id.topBgView);
            this.f18865i = findViewById;
            findViewById.setAlpha(0.0f);
            NavigationBar navigationBar = (NavigationBar) findViewById(R.id.viewNavigationBar);
            this.j = navigationBar;
            navigationBar.addSystemImageButton(NavigationBar.ControlAlign.HORIZONTAL_LEFT, NavigationBar.ControlType.BACK_BUTTON);
            this.j.getCenterText().setAlpha(0.0f);
            ImageView imageView = (ImageView) this.j.addCustomView(NavigationBar.ControlAlign.HORIZONTAL_RIGHT, R.layout.hot_topic_share, new c(this));
            this.k = imageView;
            imageView.setVisibility(4);
            View findViewById2 = findViewById(R.id.statusBarViewHolder);
            ViewGroup.LayoutParams layoutParams = findViewById2.getLayoutParams();
            layoutParams.height = this.f18862f;
            findViewById2.setLayoutParams(layoutParams);
            this.m = (ViewGroup) findViewById(R.id.contentRootLayout);
            LottieSlideLoadingLayout lottieSlideLoadingLayout = (LottieSlideLoadingLayout) findViewById(R.id.contentLayout);
            this.p = lottieSlideLoadingLayout;
            lottieSlideLoadingLayout.j(this.K);
            this.p.n();
            HotTopicDetailHeadView hotTopicDetailHeadView = (HotTopicDetailHeadView) findViewById(R.id.hotTopicDetailHeadView);
            this.q = hotTopicDetailHeadView;
            this.p.l(hotTopicDetailHeadView);
            this.x = findViewById(R.id.headerContainerLayout);
            this.j.post(new d(this));
            this.s = (TextView) findViewById(R.id.hotTopicInfoAbstract);
            this.y = (HotTopicDetailPkLayout) findViewById(R.id.hotTopicDetailPkView);
            HotTopicDetailSpecialLayout hotTopicDetailSpecialLayout = (HotTopicDetailSpecialLayout) findViewById(R.id.hotTopicDetailSpecialLayout);
            this.z = hotTopicDetailSpecialLayout;
            hotTopicDetailSpecialLayout.F(this.f18863g);
            this.v = findViewById(R.id.contentContainer);
            AppBarLayout appBarLayout = (AppBarLayout) findViewById(R.id.appBarLayout);
            this.w = appBarLayout;
            appBarLayout.addOnOffsetChangedListener(this.J);
            this.B = (CustomViewPager) findViewById(R.id.hotTopicViewPager);
            HotTopicDetailPagerAdapter hotTopicDetailPagerAdapter = new HotTopicDetailPagerAdapter(getContext());
            this.C = hotTopicDetailPagerAdapter;
            hotTopicDetailPagerAdapter.p(this.F);
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
            this.A = new d.a.q0.g1.b.c(ovalActionButton, this.f18863g);
        }
    }

    public final void V() {
        Interceptable interceptable = $ic;
        if (!(interceptable == null || interceptable.invokeV(InputDeviceCompat.SOURCE_TOUCHPAD, this) == null) || this.l) {
            return;
        }
        this.l = true;
        this.k.setVisibility(0);
        SvgManager.getInstance().setPureDrawableWithDayNightModeAutoChange((ImageView) this.j.findViewById(R.id.widget_navi_back_button), R.drawable.ic_icon_pure_topbar_return40_svg, R.color.white_alpha100, SvgManager.SvgResourceStateType.NORMAL_PRESS);
        SvgManager.getInstance().setPureDrawableWithDayNightModeAutoChange(this.k, R.drawable.icon_pure_topbar_share44_svg, R.color.white_alpha100, SvgManager.SvgResourceStateType.NORMAL_PRESS);
        SkinManager.setNavbarTitleColor(this.j.getCenterText(), R.color.CAM_X0105, R.color.s_navbar_title_color);
        d.a.q0.b2.a aVar = this.f18864h;
        if (aVar instanceof Activity) {
            UtilHelper.changeStatusBarIconAndTextColor(true, (Activity) aVar);
        }
    }

    public final void W() {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeV(1048585, this) == null) {
            this.G = false;
            this.p.o();
        }
    }

    @Override // d.a.q0.b2.b
    public void a() {
        int skinType;
        Interceptable interceptable = $ic;
        if (!(interceptable == null || interceptable.invokeV(1048586, this) == null) || (skinType = TbadkCoreApplication.getInst().getSkinType()) == this.f18861e) {
            return;
        }
        this.q.h(skinType);
        SkinManager.setViewTextColor(this.s, R.color.CAM_X0105, 1);
        SkinManager.setBackgroundColor(this.x, R.color.CAM_X0201);
        SkinManager.setBackgroundColor(this.f18865i, R.color.CAM_X0207);
        SkinManager.setNavbarTitleColor(this.j.getCenterText(), R.color.CAM_X0105, R.color.s_navbar_title_color);
        d.a.p0.f0.g gVar = this.n;
        if (gVar != null) {
            gVar.n(SkinManager.getColor(R.color.CAM_X0201));
        }
        this.y.m(skinType);
        this.D.setTabTextColors(SkinManager.getColor(R.color.CAM_X0107), SkinManager.getColor(R.color.CAM_X0105));
        this.z.H(skinType);
        this.C.l(skinType);
        this.f18861e = skinType;
    }

    @Override // d.a.q0.b2.b
    public void b(int i2) {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeI(1048587, this, i2) == null) {
            this.C.g(i2);
        }
    }

    @Override // d.a.q0.b2.b
    public void c(d.a.q0.g1.c.e eVar) {
        d.a.q0.g1.c.a aVar;
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeL(1048588, this, eVar) == null) {
            if (eVar.c() != null) {
                aVar = eVar.c();
                aVar.f56940i = 3;
            } else if (eVar.d() != null) {
                aVar = eVar.d();
                aVar.f56940i = 2;
            } else if (eVar.m() != null) {
                aVar = eVar.m();
                aVar.f56940i = 1;
            } else {
                aVar = null;
            }
            this.q.setBlessInfo(aVar);
            if (eVar.g() == null) {
                this.y.setVisibility(8);
                return;
            }
            this.y.setVisibility(0);
            this.y.i(eVar.g());
        }
    }

    @Override // d.a.q0.b2.b
    public void d() {
        d.a.p0.f0.h hVar;
        Interceptable interceptable = $ic;
        if (!(interceptable == null || interceptable.invokeV(1048589, this) == null) || (hVar = this.o) == null) {
            return;
        }
        hVar.dettachView(this.m);
        this.o = null;
    }

    @Override // d.a.q0.b2.b
    public void destroy() {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeV(1048590, this) == null) {
            p();
            d();
            HotTopicDetailPagerAdapter hotTopicDetailPagerAdapter = this.C;
            if (hotTopicDetailPagerAdapter != null) {
                hotTopicDetailPagerAdapter.d();
            }
            if (this.G) {
                W();
            }
            ValueAnimator valueAnimator = this.H;
            if (valueAnimator != null) {
                valueAnimator.cancel();
                this.H.removeAllListeners();
                this.H.removeAllUpdateListeners();
                this.H = null;
            }
            d.a.d.e.m.e.a().removeCallbacks(this.M);
        }
    }

    @Override // d.a.q0.b2.b
    public void e(boolean z) {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeZ(1048591, this, z) == null) {
            d.a.p0.f0.h hVar = this.o;
            if (hVar == null || !hVar.isViewAttached()) {
                if (this.o == null) {
                    this.o = new d.a.p0.f0.h(getContext(), new h(this));
                }
                this.o.j(this.f18863g.getResources().getDimensionPixelSize(R.dimen.ds360));
                this.o.attachView(this.m, false);
                this.o.f(R.color.CAM_X0201);
                this.o.o();
            }
        }
    }

    @Override // d.a.q0.b2.b
    public void f(long j2, long j3) {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeCommon(1048592, this, new Object[]{Long.valueOf(j2), Long.valueOf(j3)}) == null) {
            this.q.d(j2, j3);
        }
    }

    @Override // d.a.q0.b2.b
    public d.a.q0.g1.c.e g() {
        InterceptResult invokeV;
        Interceptable interceptable = $ic;
        return (interceptable == null || (invokeV = interceptable.invokeV(1048593, this)) == null) ? this.I : (d.a.q0.g1.c.e) invokeV.objValue;
    }

    @Override // d.a.q0.b2.b
    public void h() {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeV(1048594, this) == null) {
            if (this.n == null) {
                d.a.p0.f0.g gVar = new d.a.p0.f0.g(getContext(), getContext().getResources().getDimensionPixelSize(R.dimen.ds386));
                this.n = gVar;
                gVar.n(SkinManager.getColor(R.color.CAM_X0201));
            }
            this.n.attachView(this.m, false);
        }
    }

    @Override // d.a.q0.b2.b
    public void i(boolean z, int i2) {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeCommon(1048595, this, new Object[]{Boolean.valueOf(z), Integer.valueOf(i2)}) == null) {
            this.C.q(z, i2);
        }
    }

    @Override // d.a.q0.b2.b
    public void j(int i2) {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeI(1048596, this, i2) == null) {
            this.C.r(i2);
        }
    }

    @Override // d.a.q0.b2.b
    public int k() {
        InterceptResult invokeV;
        Interceptable interceptable = $ic;
        return (interceptable == null || (invokeV = interceptable.invokeV(1048597, this)) == null) ? this.C.c() : invokeV.intValue;
    }

    @Override // d.a.q0.b2.b
    public void l() {
        Interceptable interceptable = $ic;
        if ((interceptable == null || interceptable.invokeV(1048598, this) == null) && this.G) {
            W();
            d.a.d.e.m.e.a().removeCallbacks(this.M);
        }
    }

    @Override // d.a.q0.b2.b
    public void m(@NonNull d.a.q0.g1.c.e eVar) {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeL(1048599, this, eVar) == null) {
            this.I = eVar;
            if (eVar.h() != null) {
                this.A.d(this.I.h().f56960e);
                this.A.c(this.I.h().f56961f);
            }
            S(eVar);
        }
    }

    @Override // d.a.q0.b2.b
    public void n(long j2, long j3, int i2) {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeCommon(1048600, this, new Object[]{Long.valueOf(j2), Long.valueOf(j3), Integer.valueOf(i2)}) == null) {
            this.y.j(j2, j3, i2);
        }
    }

    @Override // d.a.q0.b2.b
    public d.a.q0.g1.c.d o(int i2) {
        InterceptResult invokeI;
        Interceptable interceptable = $ic;
        return (interceptable == null || (invokeI = interceptable.invokeI(1048601, this, i2)) == null) ? this.C.b(i2) : (d.a.q0.g1.c.d) invokeI.objValue;
    }

    @Override // android.view.ViewGroup, android.view.View
    public void onDetachedFromWindow() {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeV(1048602, this) == null) {
            destroy();
            super.onDetachedFromWindow();
        }
    }

    @Override // d.a.q0.b2.b
    public void p() {
        d.a.p0.f0.g gVar;
        Interceptable interceptable = $ic;
        if (!(interceptable == null || interceptable.invokeV(1048603, this) == null) || (gVar = this.n) == null) {
            return;
        }
        gVar.dettachView(this.m);
    }

    @Override // d.a.q0.b2.b
    public void pause() {
        HotTopicDetailPagerAdapter hotTopicDetailPagerAdapter;
        Interceptable interceptable = $ic;
        if (!(interceptable == null || interceptable.invokeV(1048604, this) == null) || (hotTopicDetailPagerAdapter = this.C) == null) {
            return;
        }
        hotTopicDetailPagerAdapter.m();
    }

    @Override // d.a.q0.b2.b
    public void q() {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeV(1048605, this) == null) {
            this.C.j();
        }
    }

    @Override // d.a.q0.b2.b
    public void r(int i2) {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeI(1048606, this, i2) == null) {
            this.C.h(i2);
        }
    }

    @Override // d.a.q0.b2.b
    public void resume() {
        HotTopicDetailPagerAdapter hotTopicDetailPagerAdapter;
        Interceptable interceptable = $ic;
        if (!(interceptable == null || interceptable.invokeV(1048607, this) == null) || (hotTopicDetailPagerAdapter = this.C) == null) {
            return;
        }
        hotTopicDetailPagerAdapter.n();
    }

    @Override // d.a.q0.b2.b
    public void s(d.a.q0.g1.c.d dVar, boolean z, int i2) {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeCommon(1048608, this, new Object[]{dVar, Boolean.valueOf(z), Integer.valueOf(i2)}) == null) {
            d.a.q0.g1.c.e eVar = this.I;
            if (eVar != null) {
                this.C.o(eVar.e());
            }
            this.C.s(dVar, z, i2);
        }
    }
}
