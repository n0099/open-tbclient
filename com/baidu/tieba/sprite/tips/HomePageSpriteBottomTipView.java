package com.baidu.tieba.sprite.tips;

import android.content.Context;
import android.graphics.drawable.Drawable;
import android.graphics.drawable.NinePatchDrawable;
import android.os.Handler;
import android.os.Looper;
import android.os.Message;
import android.text.TextUtils;
import android.util.AttributeSet;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.LinearLayout;
import android.widget.TextView;
import androidx.core.view.InputDeviceCompat;
import com.baidu.adp.lib.util.StringUtils;
import com.baidu.adp.log.DefaultLog;
import com.baidu.android.imsdk.internal.Constants;
import com.baidu.tbadk.TbPageContextSupport;
import com.baidu.tbadk.TbSingleton;
import com.baidu.tbadk.core.TbadkCoreApplication;
import com.baidu.tbadk.core.util.SkinManager;
import com.baidu.tbadk.core.util.StatisticItem;
import com.baidu.tbadk.core.util.StringHelper;
import com.baidu.tbadk.core.util.TiebaStatic;
import com.baidu.tbadk.core.util.UrlManager;
import com.baidu.tbadk.core.util.UtilHelper;
import com.baidu.tbadk.core.util.WebPManager;
import com.baidu.tieba.R;
import com.baidu.tieba.ed5;
import com.baidu.tieba.fn5;
import com.baidu.tieba.gn;
import com.baidu.tieba.hu9;
import com.baidu.tieba.hw5;
import com.baidu.tieba.o75;
import com.baidu.tieba.or6;
import com.baidu.tieba.ow9;
import com.baidu.tieba.pg;
import com.baidu.tieba.sprite.funnysprite.data.SpriteTipHttpResponseMessage;
import com.baidu.tieba.sprite.tips.HomePageSpriteBottomTipView;
import com.baidu.tieba.ui;
import com.baidu.tieba.uo9;
import com.baidu.tieba.vi;
import com.baidu.tieba.w6a;
import com.baidu.tieba.zq8;
import com.baidu.titan.sdk.runtime.ClassClinitInterceptable;
import com.baidu.titan.sdk.runtime.ClassClinitInterceptorStorage;
import com.baidu.titan.sdk.runtime.FieldHolder;
import com.baidu.titan.sdk.runtime.InitContext;
import com.baidu.titan.sdk.runtime.InterceptResult;
import com.baidu.titan.sdk.runtime.Interceptable;
import com.baidu.titan.sdk.runtime.TitanRuntime;
import com.google.android.gms.common.internal.ServiceSpecificExtraArgs;
import java.lang.ref.WeakReference;
import kotlin.Metadata;
import kotlin.Unit;
import kotlin.jvm.JvmOverloads;
import kotlin.jvm.functions.Function1;
import kotlin.jvm.internal.DefaultConstructorMarker;
import kotlin.jvm.internal.Intrinsics;
import tbclient.ThemeColorInfo;
@Metadata(d1 = {"\u0000P\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0010\u000b\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0000\n\u0002\u0010\u0002\n\u0002\b\u0012\u0018\u0000 (2\u00020\u0001:\u0002()B\u001b\b\u0007\u0012\u0006\u0010\u0002\u001a\u00020\u0003\u0012\n\b\u0002\u0010\u0004\u001a\u0004\u0018\u00010\u0005¢\u0006\u0002\u0010\u0006J\b\u0010\u001d\u001a\u00020\u0018H\u0002J\u0006\u0010\u001e\u001a\u00020\u0018J\u0006\u0010\u001f\u001a\u00020\u0018J\u0006\u0010 \u001a\u00020\u0018J\u0016\u0010!\u001a\u00020\u00182\u0006\u0010\"\u001a\u00020\u00112\u0006\u0010#\u001a\u00020\nJ\b\u0010$\u001a\u00020\u0018H\u0002J\b\u0010%\u001a\u00020\u0018H\u0002J\b\u0010&\u001a\u00020\u0018H\u0002J\b\u0010'\u001a\u00020\u0018H\u0002R\u0012\u0010\u0007\u001a\u00060\bR\u00020\u0000X\u0082\u0004¢\u0006\u0002\n\u0000R\u0010\u0010\t\u001a\u0004\u0018\u00010\nX\u0082\u000e¢\u0006\u0002\n\u0000R\u000e\u0010\u000b\u001a\u00020\fX\u0082\u000e¢\u0006\u0002\n\u0000R\u000e\u0010\r\u001a\u00020\u000eX\u0082\u000e¢\u0006\u0002\n\u0000R\u000e\u0010\u000f\u001a\u00020\u000eX\u0082\u000e¢\u0006\u0002\n\u0000R\u0010\u0010\u0010\u001a\u0004\u0018\u00010\u0011X\u0082\u000e¢\u0006\u0002\n\u0000R\u000e\u0010\u0012\u001a\u00020\u0013X\u0082\u000e¢\u0006\u0002\n\u0000R7\u0010\u0014\u001a\u001f\u0012\u0013\u0012\u00110\f¢\u0006\f\b\u0016\u0012\b\b\u0017\u0012\u0004\b\b(\u000b\u0012\u0004\u0012\u00020\u0018\u0018\u00010\u0015X\u0086\u000e¢\u0006\u000e\n\u0000\u001a\u0004\b\u0019\u0010\u001a\"\u0004\b\u001b\u0010\u001c¨\u0006*"}, d2 = {"Lcom/baidu/tieba/sprite/tips/HomePageSpriteBottomTipView;", "Landroid/widget/LinearLayout;", "context", "Landroid/content/Context;", "attrs", "Landroid/util/AttributeSet;", "(Landroid/content/Context;Landroid/util/AttributeSet;)V", "animationHandler", "Lcom/baidu/tieba/sprite/tips/HomePageSpriteBottomTipView$ShowAnimationHandler;", "dismissListener", "Lcom/baidu/tieba/controller/TipController$OnDismissListener;", "isVisibility", "", "mButton", "Landroid/widget/TextView;", "mContent", "mData", "Lcom/baidu/tieba/sprite/funnysprite/data/SpriteTipHttpResponseMessage;", "mRoot", "Landroid/view/View;", "onVisibilityChangedListener", "Lkotlin/Function1;", "Lkotlin/ParameterName;", "name", "", "getOnVisibilityChangedListener", "()Lkotlin/jvm/functions/Function1;", "setOnVisibilityChangedListener", "(Lkotlin/jvm/functions/Function1;)V", "clickToChatStatistic", "dismiss", "gotoChatPage", "onChangeSkin", "setDataAndShow", "responseMessage", ServiceSpecificExtraArgs.CastExtraArgs.LISTENER, "show", "updateButtonStatus", "updateMaxContentWidth", "updateMaxLineCount", "Companion", "ShowAnimationHandler", "recommendfrs_release"}, k = 1, mv = {1, 6, 0}, xi = 48)
/* loaded from: classes7.dex */
public final class HomePageSpriteBottomTipView extends LinearLayout {
    public static /* synthetic */ Interceptable $ic;
    public static final a i;
    public transient /* synthetic */ FieldHolder $fh;
    public View a;
    public SpriteTipHttpResponseMessage b;
    public or6.e c;
    public TextView d;
    public TextView e;
    public final b f;
    public Function1<? super Boolean, Unit> g;
    public boolean h;

    static {
        InterceptResult invokeClinit;
        ClassClinitInterceptable classClinitInterceptable = ClassClinitInterceptorStorage.$ic;
        if (classClinitInterceptable != null && (invokeClinit = classClinitInterceptable.invokeClinit(1309092756, "Lcom/baidu/tieba/sprite/tips/HomePageSpriteBottomTipView;")) != null) {
            Interceptable interceptable = invokeClinit.interceptor;
            if (interceptable != null) {
                $ic = interceptable;
            }
            if ((invokeClinit.flags & 1) != 0) {
                classClinitInterceptable.invokePostClinit(1309092756, "Lcom/baidu/tieba/sprite/tips/HomePageSpriteBottomTipView;");
                return;
            }
        }
        i = new a(null);
    }

    /* JADX WARN: 'this' call moved to the top of the method (can break code semantics) */
    @JvmOverloads
    public HomePageSpriteBottomTipView(Context context) {
        this(context, null, 2, null);
        Interceptable interceptable = $ic;
        if (interceptable != null) {
            InitContext newInitContext = TitanRuntime.newInitContext();
            newInitContext.initArgs = r2;
            Object[] objArr = {context};
            interceptable.invokeUnInit(65537, newInitContext);
            int i2 = newInitContext.flag;
            if ((i2 & 1) != 0) {
                int i3 = i2 & 2;
                Object[] objArr2 = newInitContext.callArgs;
                this((Context) objArr2[0], (AttributeSet) objArr2[1], ((Integer) objArr2[2]).intValue(), (DefaultConstructorMarker) objArr2[3]);
                newInitContext.thisArg = this;
                interceptable.invokeInitBody(65537, newInitContext);
                return;
            }
        }
        Intrinsics.checkNotNullParameter(context, "context");
    }

    /* loaded from: classes7.dex */
    public static final class a {
        public static /* synthetic */ Interceptable $ic;
        public transient /* synthetic */ FieldHolder $fh;

        public /* synthetic */ a(DefaultConstructorMarker defaultConstructorMarker) {
            this();
        }

        public a() {
            Interceptable interceptable = $ic;
            if (interceptable != null) {
                InitContext newInitContext = TitanRuntime.newInitContext();
                interceptable.invokeUnInit(65536, newInitContext);
                int i = newInitContext.flag;
                if ((i & 1) != 0) {
                    int i2 = i & 2;
                    newInitContext.thisArg = this;
                    interceptable.invokeInitBody(65536, newInitContext);
                }
            }
        }
    }

    /* loaded from: classes7.dex */
    public final class b extends Handler {
        public static /* synthetic */ Interceptable $ic;
        public transient /* synthetic */ FieldHolder $fh;
        public final WeakReference<HomePageSpriteBottomTipView> a;
        public final /* synthetic */ HomePageSpriteBottomTipView b;

        /* JADX WARN: 'super' call moved to the top of the method (can break code semantics) */
        public b(HomePageSpriteBottomTipView homePageSpriteBottomTipView, HomePageSpriteBottomTipView homePageSpriteBottomTipView2) {
            super(Looper.getMainLooper());
            Interceptable interceptable = $ic;
            if (interceptable != null) {
                InitContext newInitContext = TitanRuntime.newInitContext();
                newInitContext.initArgs = r2;
                Object[] objArr = {homePageSpriteBottomTipView, homePageSpriteBottomTipView2};
                interceptable.invokeUnInit(65536, newInitContext);
                int i = newInitContext.flag;
                if ((i & 1) != 0) {
                    int i2 = i & 2;
                    super((Looper) newInitContext.callArgs[0]);
                    newInitContext.thisArg = this;
                    interceptable.invokeInitBody(65536, newInitContext);
                    return;
                }
            }
            this.b = homePageSpriteBottomTipView;
            this.a = new WeakReference<>(homePageSpriteBottomTipView2);
        }

        @Override // android.os.Handler
        public void handleMessage(Message msg) {
            HomePageSpriteBottomTipView homePageSpriteBottomTipView;
            Interceptable interceptable = $ic;
            if (interceptable == null || interceptable.invokeL(1048576, this, msg) == null) {
                Intrinsics.checkNotNullParameter(msg, "msg");
                int i = msg.what;
                if (i != 1) {
                    if (i == 2 && (homePageSpriteBottomTipView = this.a.get()) != null) {
                        homePageSpriteBottomTipView.d();
                        return;
                    }
                    return;
                }
                HomePageSpriteBottomTipView homePageSpriteBottomTipView2 = this.a.get();
                if (homePageSpriteBottomTipView2 == null) {
                    return;
                }
                homePageSpriteBottomTipView2.g();
            }
        }
    }

    /* JADX WARN: 'super' call moved to the top of the method (can break code semantics) */
    @JvmOverloads
    public HomePageSpriteBottomTipView(final Context context, AttributeSet attributeSet) {
        super(context, attributeSet);
        Interceptable interceptable = $ic;
        if (interceptable != null) {
            InitContext newInitContext = TitanRuntime.newInitContext();
            newInitContext.initArgs = r2;
            Object[] objArr = {context, attributeSet};
            interceptable.invokeUnInit(65538, newInitContext);
            int i2 = newInitContext.flag;
            if ((i2 & 1) != 0) {
                int i3 = i2 & 2;
                Object[] objArr2 = newInitContext.callArgs;
                super((Context) objArr2[0], (AttributeSet) objArr2[1]);
                newInitContext.thisArg = this;
                interceptable.invokeInitBody(65538, newInitContext);
                return;
            }
        }
        Intrinsics.checkNotNullParameter(context, "context");
        LayoutInflater.from(context).inflate(R.layout.obfuscated_res_0x7f0d08a4, (ViewGroup) this, true);
        View findViewById = findViewById(R.id.obfuscated_res_0x7f0907ad);
        Intrinsics.checkNotNullExpressionValue(findViewById, "findViewById(R.id.content)");
        this.a = findViewById;
        View findViewById2 = findViewById(R.id.obfuscated_res_0x7f091705);
        Intrinsics.checkNotNullExpressionValue(findViewById2, "findViewById(R.id.message)");
        this.d = (TextView) findViewById2;
        View findViewById3 = findViewById(R.id.obfuscated_res_0x7f0921b4);
        Intrinsics.checkNotNullExpressionValue(findViewById3, "findViewById(R.id.sprite_tip_button)");
        this.e = (TextView) findViewById3;
        f();
        this.f = new b(this, this);
        setOnClickListener(new View.OnClickListener() { // from class: com.baidu.tieba.fu9
            public static /* synthetic */ Interceptable $ic;
            public transient /* synthetic */ FieldHolder $fh;

            @Override // android.view.View.OnClickListener
            public final void onClick(View view2) {
                Interceptable interceptable2 = $ic;
                if (interceptable2 == null || interceptable2.invokeL(1048576, this, view2) == null) {
                    HomePageSpriteBottomTipView.a(context, this, view2);
                }
            }
        });
    }

    public /* synthetic */ HomePageSpriteBottomTipView(Context context, AttributeSet attributeSet, int i2, DefaultConstructorMarker defaultConstructorMarker) {
        this(context, (i2 & 2) != 0 ? null : attributeSet);
    }

    public static final void a(Context context, HomePageSpriteBottomTipView this$0, View view2) {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeLLL(InputDeviceCompat.SOURCE_TRACKBALL, null, context, this$0, view2) == null) {
            Intrinsics.checkNotNullParameter(context, "$context");
            Intrinsics.checkNotNullParameter(this$0, "this$0");
            if (!hw5.a() && (context instanceof TbPageContextSupport)) {
                this$0.e();
                this$0.c();
            }
        }
    }

    public final void setOnVisibilityChangedListener(Function1<? super Boolean, Unit> function1) {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeL(1048586, this, function1) == null) {
            this.g = function1;
        }
    }

    public static final void i(HomePageSpriteBottomTipView this$0, SpriteTipHttpResponseMessage this_run, View view2) {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeLLL(65542, null, this$0, this_run, view2) == null) {
            Intrinsics.checkNotNullParameter(this$0, "this$0");
            Intrinsics.checkNotNullParameter(this_run, "$this_run");
            this$0.c();
            if (StringUtils.isNotNull(this_run.getButtonInfo().b)) {
                UrlManager.getInstance().dealOneLink(this_run.getButtonInfo().b);
            } else {
                this$0.e();
            }
        }
    }

    public final void c() {
        String str;
        int i2;
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeV(1048576, this) == null) {
            StatisticItem param = new StatisticItem("c15226").param("uid", TbadkCoreApplication.getCurrentAccountId());
            SpriteTipHttpResponseMessage spriteTipHttpResponseMessage = this.b;
            if (spriteTipHttpResponseMessage != null) {
                str = spriteTipHttpResponseMessage.getText();
            } else {
                str = null;
            }
            StatisticItem param2 = param.param("content", str);
            SpriteTipHttpResponseMessage spriteTipHttpResponseMessage2 = this.b;
            if (spriteTipHttpResponseMessage2 != null) {
                i2 = spriteTipHttpResponseMessage2.getSpeechType();
            } else {
                i2 = 0;
            }
            StatisticItem param3 = param2.param("obj_type", i2);
            Intrinsics.checkNotNullExpressionValue(param3, "StatisticItem(\"c15226\")\n…, mData?.speechType ?: 0)");
            TiebaStatic.log(param3);
        }
    }

    /* JADX WARN: Code restructure failed: missing block: B:14:0x0028, code lost:
        if (r1 == true) goto L13;
     */
    /*
        Code decompiled incorrectly, please refer to instructions dump.
    */
    public final void h() {
        final SpriteTipHttpResponseMessage spriteTipHttpResponseMessage;
        boolean z;
        Interceptable interceptable = $ic;
        if ((interceptable == null || interceptable.invokeV(1048582, this) == null) && (spriteTipHttpResponseMessage = this.b) != null) {
            if (spriteTipHttpResponseMessage.getButtonInfo() != null) {
                String text = spriteTipHttpResponseMessage.getButtonInfo().a;
                boolean z2 = true;
                if (text != null) {
                    Intrinsics.checkNotNullExpressionValue(text, "text");
                    if (text.length() > 0) {
                        z = true;
                    } else {
                        z = false;
                    }
                }
                z2 = false;
                if (z2) {
                    this.e.setText(StringHelper.cutChineseAndEnglishWithSuffix(spriteTipHttpResponseMessage.getButtonInfo().a, 8, (String) null));
                    this.e.setOnClickListener(new View.OnClickListener() { // from class: com.baidu.tieba.eu9
                        public static /* synthetic */ Interceptable $ic;
                        public transient /* synthetic */ FieldHolder $fh;

                        @Override // android.view.View.OnClickListener
                        public final void onClick(View view2) {
                            Interceptable interceptable2 = $ic;
                            if (interceptable2 == null || interceptable2.invokeL(1048576, this, view2) == null) {
                                HomePageSpriteBottomTipView.i(HomePageSpriteBottomTipView.this, spriteTipHttpResponseMessage, view2);
                            }
                        }
                    });
                    this.e.setVisibility(0);
                    return;
                }
            }
            this.e.setVisibility(8);
        }
    }

    public final void d() {
        Interceptable interceptable = $ic;
        if ((interceptable != null && interceptable.invokeV(Constants.METHOD_GET_CONTACTER_INFO_FOR_SESSION, this) != null) || !this.h) {
            return;
        }
        this.h = false;
        or6.e eVar = this.c;
        if (eVar != null) {
            eVar.onDismiss();
        }
        this.c = null;
        Function1<? super Boolean, Unit> function1 = this.g;
        if (function1 != null) {
            function1.invoke(Boolean.FALSE);
        }
    }

    public final void g() {
        Interceptable interceptable = $ic;
        if ((interceptable != null && interceptable.invokeV(1048580, this) != null) || this.h) {
            return;
        }
        this.h = true;
        Function1<? super Boolean, Unit> function1 = this.g;
        if (function1 != null) {
            function1.invoke(Boolean.TRUE);
        }
    }

    /* JADX DEBUG: Type inference failed for r0v2. Raw type applied. Possible types: kotlin.jvm.functions.Function1<? super java.lang.Boolean, kotlin.Unit>, kotlin.jvm.functions.Function1<java.lang.Boolean, kotlin.Unit> */
    public final Function1<Boolean, Unit> getOnVisibilityChangedListener() {
        InterceptResult invokeV;
        Interceptable interceptable = $ic;
        if (interceptable == null || (invokeV = interceptable.invokeV(1048581, this)) == null) {
            return this.g;
        }
        return (Function1) invokeV.objValue;
    }

    public final void e() {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeV(Constants.METHOD_SEND_USER_MSG, this) == null) {
            String b2 = fn5.b("", 0);
            SpriteTipHttpResponseMessage spriteTipHttpResponseMessage = this.b;
            if (spriteTipHttpResponseMessage != null && this.h) {
                Intrinsics.checkNotNull(spriteTipHttpResponseMessage);
                if (spriteTipHttpResponseMessage.getNeedSend()) {
                    SpriteTipHttpResponseMessage spriteTipHttpResponseMessage2 = this.b;
                    Intrinsics.checkNotNull(spriteTipHttpResponseMessage2);
                    String sendText = spriteTipHttpResponseMessage2.getSendText();
                    Intrinsics.checkNotNullExpressionValue(sendText, "mData!!.sendText");
                    b2 = fn5.b(sendText, 1);
                } else {
                    SpriteTipHttpResponseMessage spriteTipHttpResponseMessage3 = this.b;
                    Intrinsics.checkNotNull(spriteTipHttpResponseMessage3);
                    String text = spriteTipHttpResponseMessage3.getText();
                    Intrinsics.checkNotNullExpressionValue(text, "mData!!.text");
                    b2 = fn5.b(text, 2);
                }
            }
            SpriteTipHttpResponseMessage spriteTipHttpResponseMessage4 = this.b;
            if (spriteTipHttpResponseMessage4 != null) {
                if (StringUtils.isNotNull(spriteTipHttpResponseMessage4.getSpriteText())) {
                    String spriteText = spriteTipHttpResponseMessage4.getSpriteText();
                    Intrinsics.checkNotNullExpressionValue(spriteText, "spriteText");
                    fn5.i(spriteText);
                } else if (StringUtils.isNotNull(spriteTipHttpResponseMessage4.getText())) {
                    String text2 = spriteTipHttpResponseMessage4.getText();
                    Intrinsics.checkNotNullExpressionValue(text2, "text");
                    fn5.i(text2);
                }
            }
            Context context = getContext();
            if (context != null) {
                uo9.b(((TbPageContextSupport) context).getPageContext(), new String[]{b2});
                return;
            }
            throw new NullPointerException("null cannot be cast to non-null type com.baidu.tbadk.TbPageContextSupport");
        }
    }

    public final void f() {
        String str;
        gn gnVar;
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeV(1048579, this) == null) {
            o75.d(this.d).w(R.color.CAM_X0119);
            o75.d(this.e).w(R.color.CAM_X0920);
            Drawable pureDrawable = WebPManager.getPureDrawable(R.drawable.icon_pure_list_arrow16_right, SkinManager.getColor(R.color.CAM_X0920), null);
            if (pureDrawable != null) {
                int dimenPixelSize = UtilHelper.getDimenPixelSize(R.dimen.tbds42);
                pureDrawable.setBounds(0, 0, dimenPixelSize, dimenPixelSize);
                this.e.setCompoundDrawablesWithIntrinsicBounds((Drawable) null, (Drawable) null, new hu9(pureDrawable), (Drawable) null);
            }
            SpriteTipHttpResponseMessage spriteTipHttpResponseMessage = this.b;
            if (spriteTipHttpResponseMessage != null) {
                ThemeColorInfo textColorTheme = spriteTipHttpResponseMessage.getTextColorTheme();
                if (textColorTheme != null) {
                    Intrinsics.checkNotNullExpressionValue(textColorTheme, "textColorTheme");
                    int f = ow9.f(w6a.e(textColorTheme));
                    if (!ow9.e(f)) {
                        this.d.setTextColor(f);
                    }
                }
                ThemeColorInfo bgUrlTheme = spriteTipHttpResponseMessage.getBgUrlTheme();
                if (bgUrlTheme != null) {
                    Intrinsics.checkNotNullExpressionValue(bgUrlTheme, "bgUrlTheme");
                    str = w6a.g(bgUrlTheme);
                } else {
                    str = null;
                }
                if (!ui.isEmpty(str)) {
                    Object n = pg.h().n(str, 19, new Object[0]);
                    if (n instanceof gn) {
                        gnVar = (gn) n;
                    } else {
                        gnVar = null;
                    }
                    if (gnVar != null) {
                        this.a.setBackgroundDrawable(new NinePatchDrawable(getResources(), gnVar.p(), gnVar.p().getNinePatchChunk(), gnVar.o(), null));
                        return;
                    }
                    SkinManager.setBackgroundResource(this.a, R.drawable.funny_sprite_tip_bg_left);
                    pg.h().m(str, 19, null, null);
                    return;
                }
                SkinManager.setBackgroundResource(this.a, R.drawable.funny_sprite_tip_bg_left);
            }
        }
    }

    public final void j() {
        int l;
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeV(1048583, this) == null) {
            int g = vi.g(getContext(), R.dimen.tbds190);
            if (UtilHelper.isFoldScreen() && UtilHelper.isLargeScreen(getContext())) {
                l = vi.l(getContext()) / 2;
            } else {
                l = vi.l(getContext());
            }
            int g2 = vi.g(getContext(), R.dimen.M_W_X012);
            int g3 = vi.g(getContext(), R.dimen.tbds42);
            int i2 = 0;
            if (this.e.getVisibility() == 0) {
                i2 = (int) (this.e.getPaint().measureText(this.e.getText().toString()) + g3);
            }
            this.d.setMaxWidth(((l - g) - (g2 * 2)) - i2);
        }
    }

    public final void k() {
        Integer num;
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeV(InputDeviceCompat.SOURCE_TOUCHPAD, this) == null) {
            ed5 funnySpriteConfig = TbSingleton.getInstance().getFunnySpriteConfig();
            if (funnySpriteConfig != null) {
                num = funnySpriteConfig.a();
            } else {
                num = null;
            }
            this.d.setMaxLines(((num == null || num.intValue() <= 0) ? 1 : 1).intValue());
        }
    }

    public final void setDataAndShow(SpriteTipHttpResponseMessage responseMessage, or6.e listener) {
        String str;
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeLL(1048585, this, responseMessage, listener) == null) {
            Intrinsics.checkNotNullParameter(responseMessage, "responseMessage");
            Intrinsics.checkNotNullParameter(listener, "listener");
            if (TextUtils.isEmpty(responseMessage.getText())) {
                return;
            }
            this.b = responseMessage;
            this.d.setText(responseMessage.getText());
            h();
            j();
            k();
            f();
            this.f.removeMessages(1);
            this.f.removeMessages(2);
            this.c = listener;
            this.f.sendEmptyMessage(1);
            this.f.sendEmptyMessageDelayed(2, 5000L);
            zq8 defaultLog = DefaultLog.getInstance();
            StringBuilder sb = new StringBuilder();
            sb.append("showTip:");
            SpriteTipHttpResponseMessage spriteTipHttpResponseMessage = this.b;
            if (spriteTipHttpResponseMessage != null) {
                str = spriteTipHttpResponseMessage.getText();
            } else {
                str = null;
            }
            sb.append(str);
            defaultLog.c("SpriteTip", sb.toString());
            StatisticItem param = new StatisticItem("c15225").param("uid", TbadkCoreApplication.getCurrentAccountId()).param("content", responseMessage.getText()).param("obj_type", responseMessage.getSpeechType());
            Intrinsics.checkNotNullExpressionValue(param, "StatisticItem(\"c15225\")\n…sponseMessage.speechType)");
            TiebaStatic.log(param);
        }
    }
}
