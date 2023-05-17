package com.baidu.tieba.sprite.tips;

import android.content.Context;
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
import androidx.annotation.NonNull;
import androidx.core.view.InputDeviceCompat;
import com.baidu.adp.lib.util.StringUtils;
import com.baidu.adp.log.DefaultLog;
import com.baidu.android.imsdk.internal.Constants;
import com.baidu.tbadk.TbPageContextSupport;
import com.baidu.tbadk.TbSingleton;
import com.baidu.tbadk.core.TbadkCoreApplication;
import com.baidu.tbadk.core.message.SpriteTipHttpResponseMessage;
import com.baidu.tbadk.core.util.SkinManager;
import com.baidu.tbadk.core.util.StatisticItem;
import com.baidu.tbadk.core.util.TiebaStatic;
import com.baidu.tieba.R;
import com.baidu.tieba.ae5;
import com.baidu.tieba.an6;
import com.baidu.tieba.bj5;
import com.baidu.tieba.cn;
import com.baidu.tieba.ds5;
import com.baidu.tieba.e0a;
import com.baidu.tieba.ga5;
import com.baidu.tieba.hi9;
import com.baidu.tieba.lg;
import com.baidu.tieba.nx5;
import com.baidu.tieba.p45;
import com.baidu.tieba.qi;
import com.baidu.tieba.ri;
import com.baidu.tieba.sprite.tips.HomePageSpriteBottomTipView;
import com.baidu.tieba.wp9;
import com.baidu.tieba.yk8;
import com.baidu.titan.sdk.runtime.ClassClinitInterceptable;
import com.baidu.titan.sdk.runtime.ClassClinitInterceptorStorage;
import com.baidu.titan.sdk.runtime.FieldHolder;
import com.baidu.titan.sdk.runtime.InitContext;
import com.baidu.titan.sdk.runtime.InterceptResult;
import com.baidu.titan.sdk.runtime.Interceptable;
import com.baidu.titan.sdk.runtime.TitanRuntime;
import com.google.android.gms.common.internal.ServiceSpecificExtraArgs;
import java.lang.ref.WeakReference;
import java.util.List;
import kotlin.Metadata;
import kotlin.Unit;
import kotlin.jvm.JvmOverloads;
import kotlin.jvm.functions.Function1;
import kotlin.jvm.internal.DefaultConstructorMarker;
import kotlin.jvm.internal.Intrinsics;
import tbclient.PbContent;
@Metadata(d1 = {"\u0000b\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0010\u000b\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0000\n\u0002\u0010\u0002\n\u0002\b\u0006\n\u0002\u0010\u000e\n\u0002\b\b\n\u0002\u0010 \n\u0002\u0018\u0002\n\u0002\b\u0004\u0018\u0000 *2\u00020\u0001:\u0002*+B\u001b\b\u0007\u0012\u0006\u0010\u0002\u001a\u00020\u0003\u0012\n\b\u0002\u0010\u0004\u001a\u0004\u0018\u00010\u0005¢\u0006\u0002\u0010\u0006J\u0006\u0010\u001c\u001a\u00020\u0017J\u0010\u0010\u001d\u001a\u00020\u001e2\b\b\u0001\u0010\u001f\u001a\u00020\u001eJ\u0006\u0010 \u001a\u00020\u0017J\u0006\u0010!\u001a\u00020\u0017J\u0016\u0010\"\u001a\u00020\u00172\u0006\u0010#\u001a\u00020\u00102\u0006\u0010$\u001a\u00020\nJ\u0014\u0010%\u001a\u00020\u00172\f\u0010&\u001a\b\u0012\u0004\u0012\u00020(0'J\b\u0010)\u001a\u00020\u0017H\u0002R\u0012\u0010\u0007\u001a\u00060\bR\u00020\u0000X\u0082\u0004¢\u0006\u0002\n\u0000R\u0010\u0010\t\u001a\u0004\u0018\u00010\nX\u0082\u000e¢\u0006\u0002\n\u0000R\u000e\u0010\u000b\u001a\u00020\fX\u0082\u000e¢\u0006\u0002\n\u0000R\u000e\u0010\r\u001a\u00020\u000eX\u0082\u000e¢\u0006\u0002\n\u0000R\u0010\u0010\u000f\u001a\u0004\u0018\u00010\u0010X\u0082\u000e¢\u0006\u0002\n\u0000R\u000e\u0010\u0011\u001a\u00020\u0012X\u0082\u000e¢\u0006\u0002\n\u0000R7\u0010\u0013\u001a\u001f\u0012\u0013\u0012\u00110\f¢\u0006\f\b\u0015\u0012\b\b\u0016\u0012\u0004\b\b(\u000b\u0012\u0004\u0012\u00020\u0017\u0018\u00010\u0014X\u0086\u000e¢\u0006\u000e\n\u0000\u001a\u0004\b\u0018\u0010\u0019\"\u0004\b\u001a\u0010\u001b¨\u0006,"}, d2 = {"Lcom/baidu/tieba/sprite/tips/HomePageSpriteBottomTipView;", "Landroid/widget/LinearLayout;", "context", "Landroid/content/Context;", "attrs", "Landroid/util/AttributeSet;", "(Landroid/content/Context;Landroid/util/AttributeSet;)V", "animationHandler", "Lcom/baidu/tieba/sprite/tips/HomePageSpriteBottomTipView$ShowAnimationHandler;", "dismissListener", "Lcom/baidu/tieba/controller/TipController$OnDismissListener;", "isVisibility", "", "mContent", "Landroid/widget/TextView;", "mData", "Lcom/baidu/tbadk/core/message/SpriteTipHttpResponseMessage;", "mRoot", "Landroid/view/View;", "onVisibilityChangedListener", "Lkotlin/Function1;", "Lkotlin/ParameterName;", "name", "", "getOnVisibilityChangedListener", "()Lkotlin/jvm/functions/Function1;", "setOnVisibilityChangedListener", "(Lkotlin/jvm/functions/Function1;)V", "dismiss", "getResultContent", "", "text", "gotoChatPage", "onChangeSkin", "setDataAndShow", "responseMessage", ServiceSpecificExtraArgs.CastExtraArgs.LISTENER, "setRichText", "richTextList", "", "Ltbclient/PbContent;", "show", "Companion", "ShowAnimationHandler", "recommendfrs_release"}, k = 1, mv = {1, 6, 0}, xi = 48)
/* loaded from: classes7.dex */
public final class HomePageSpriteBottomTipView extends LinearLayout {
    public static /* synthetic */ Interceptable $ic;
    public static final a h;
    public static boolean i;
    public static boolean j;
    public transient /* synthetic */ FieldHolder $fh;
    public View a;
    public SpriteTipHttpResponseMessage b;
    public an6.e c;
    public TextView d;
    public final b e;
    public Function1<? super Boolean, Unit> f;
    public boolean g;

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
        h = new a(null);
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
                        homePageSpriteBottomTipView.c();
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
        LayoutInflater.from(context).inflate(R.layout.obfuscated_res_0x7f0d088b, (ViewGroup) this, true);
        View findViewById = findViewById(R.id.obfuscated_res_0x7f0907a2);
        Intrinsics.checkNotNullExpressionValue(findViewById, "findViewById(R.id.content)");
        this.a = findViewById;
        View findViewById2 = findViewById(R.id.obfuscated_res_0x7f0916e1);
        Intrinsics.checkNotNullExpressionValue(findViewById2, "findViewById(R.id.message)");
        this.d = (TextView) findViewById2;
        this.d.setMaxWidth((ri.l(context) - ri.g(context, R.dimen.M_W_X021)) - (ri.g(context, R.dimen.M_W_X012) * 2));
        f();
        this.e = new b(this, this);
        setOnClickListener(new View.OnClickListener() { // from class: com.baidu.tieba.pn9
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

    public final void setDataAndShow(SpriteTipHttpResponseMessage responseMessage, an6.e listener) {
        String str;
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeLL(1048582, this, responseMessage, listener) == null) {
            Intrinsics.checkNotNullParameter(responseMessage, "responseMessage");
            Intrinsics.checkNotNullParameter(listener, "listener");
            if (TextUtils.isEmpty(responseMessage.getText())) {
                return;
            }
            TextView textView = this.d;
            String text = responseMessage.getText();
            Intrinsics.checkNotNullExpressionValue(text, "responseMessage.text");
            textView.setText(d(text));
            this.b = responseMessage;
            f();
            int i2 = 1;
            this.e.removeMessages(1);
            this.e.removeMessages(2);
            this.c = listener;
            this.e.sendEmptyMessage(1);
            this.e.sendEmptyMessageDelayed(2, 5000L);
            yk8 defaultLog = DefaultLog.getInstance();
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
            StatisticItem param = new StatisticItem("c15225").param("uid", TbadkCoreApplication.getCurrentAccountId()).param("content", responseMessage.getText());
            if (!i) {
                i2 = 2;
            }
            StatisticItem param2 = param.param("obj_type", i2);
            Intrinsics.checkNotNullExpressionValue(param2, "StatisticItem(\"c15225\")\n…f (isFirstShow) 1 else 2)");
            TiebaStatic.log(param2);
            i = false;
        }
    }

    public /* synthetic */ HomePageSpriteBottomTipView(Context context, AttributeSet attributeSet, int i2, DefaultConstructorMarker defaultConstructorMarker) {
        this(context, (i2 & 2) != 0 ? null : attributeSet);
    }

    public static final void a(Context context, HomePageSpriteBottomTipView this$0, View view2) {
        String str;
        int i2;
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeLLL(InputDeviceCompat.SOURCE_TRACKBALL, null, context, this$0, view2) == null) {
            Intrinsics.checkNotNullParameter(context, "$context");
            Intrinsics.checkNotNullParameter(this$0, "this$0");
            if (!ds5.a() && (context instanceof TbPageContextSupport)) {
                this$0.e();
                StatisticItem param = new StatisticItem("c15226").param("uid", TbadkCoreApplication.getCurrentAccountId());
                SpriteTipHttpResponseMessage spriteTipHttpResponseMessage = this$0.b;
                if (spriteTipHttpResponseMessage != null) {
                    str = spriteTipHttpResponseMessage.getText();
                } else {
                    str = null;
                }
                StatisticItem param2 = param.param("content", str);
                if (j) {
                    i2 = 1;
                } else {
                    i2 = 2;
                }
                StatisticItem param3 = param2.param("obj_type", i2);
                Intrinsics.checkNotNullExpressionValue(param3, "StatisticItem(\"c15226\")\n… (isFirstClick) 1 else 2)");
                TiebaStatic.log(param3);
                j = false;
            }
        }
    }

    public final void setOnVisibilityChangedListener(Function1<? super Boolean, Unit> function1) {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeL(1048583, this, function1) == null) {
            this.f = function1;
        }
    }

    public final void setRichText(List<PbContent> richTextList) {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeL(InputDeviceCompat.SOURCE_TOUCHPAD, this, richTextList) == null) {
            Intrinsics.checkNotNullParameter(richTextList, "richTextList");
            TextView textView = this.d;
            String spannableStringBuilder = nx5.H(richTextList).toString();
            Intrinsics.checkNotNullExpressionValue(spannableStringBuilder, "parseRichContent(richTextList).toString()");
            textView.setText(d(spannableStringBuilder));
        }
    }

    public final void c() {
        Interceptable interceptable = $ic;
        if ((interceptable != null && interceptable.invokeV(1048576, this) != null) || !this.g) {
            return;
        }
        this.g = false;
        an6.e eVar = this.c;
        if (eVar != null) {
            eVar.onDismiss();
        }
        this.c = null;
        Function1<? super Boolean, Unit> function1 = this.f;
        if (function1 != null) {
            function1.invoke(Boolean.FALSE);
        }
    }

    public final void g() {
        Interceptable interceptable = $ic;
        if ((interceptable != null && interceptable.invokeV(1048580, this) != null) || this.g) {
            return;
        }
        this.g = true;
        Function1<? super Boolean, Unit> function1 = this.f;
        if (function1 != null) {
            function1.invoke(Boolean.TRUE);
        }
    }

    /* JADX DEBUG: Type inference failed for r0v2. Raw type applied. Possible types: kotlin.jvm.functions.Function1<? super java.lang.Boolean, kotlin.Unit>, kotlin.jvm.functions.Function1<java.lang.Boolean, kotlin.Unit> */
    public final Function1<Boolean, Unit> getOnVisibilityChangedListener() {
        InterceptResult invokeV;
        Interceptable interceptable = $ic;
        if (interceptable == null || (invokeV = interceptable.invokeV(1048581, this)) == null) {
            return this.f;
        }
        return (Function1) invokeV.objValue;
    }

    public final String d(@NonNull String text) {
        InterceptResult invokeL;
        Integer a2;
        int intValue;
        Interceptable interceptable = $ic;
        if (interceptable == null || (invokeL = interceptable.invokeL(Constants.METHOD_GET_CONTACTER_INFO_FOR_SESSION, this, text)) == null) {
            Intrinsics.checkNotNullParameter(text, "text");
            ga5 funnySpriteConfig = TbSingleton.getInstance().getFunnySpriteConfig();
            int i2 = 12;
            if (funnySpriteConfig != null && (a2 = funnySpriteConfig.a()) != null && (intValue = a2.intValue()) > 0) {
                i2 = intValue;
            }
            if (i2 > text.length()) {
                return text;
            }
            String substring = TextUtils.substring(text, 0, i2);
            Intrinsics.checkNotNullExpressionValue(substring, "substring(text, 0, resultIndex)");
            return substring;
        }
        return (String) invokeL.objValue;
    }

    public final void e() {
        String str;
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeV(Constants.METHOD_SEND_USER_MSG, this) == null) {
            String b2 = bj5.b("", 0);
            SpriteTipHttpResponseMessage spriteTipHttpResponseMessage = this.b;
            if (spriteTipHttpResponseMessage != null && this.g) {
                Intrinsics.checkNotNull(spriteTipHttpResponseMessage);
                if (spriteTipHttpResponseMessage.getNeedSend()) {
                    SpriteTipHttpResponseMessage spriteTipHttpResponseMessage2 = this.b;
                    Intrinsics.checkNotNull(spriteTipHttpResponseMessage2);
                    String sendText = spriteTipHttpResponseMessage2.getSendText();
                    Intrinsics.checkNotNullExpressionValue(sendText, "mData!!.sendText");
                    b2 = bj5.b(sendText, 1);
                } else {
                    SpriteTipHttpResponseMessage spriteTipHttpResponseMessage3 = this.b;
                    Intrinsics.checkNotNull(spriteTipHttpResponseMessage3);
                    String text = spriteTipHttpResponseMessage3.getText();
                    Intrinsics.checkNotNullExpressionValue(text, "mData!!.text");
                    b2 = bj5.b(text, 2);
                }
            }
            SpriteTipHttpResponseMessage spriteTipHttpResponseMessage4 = this.b;
            if (spriteTipHttpResponseMessage4 != null) {
                str = spriteTipHttpResponseMessage4.getText();
            } else {
                str = null;
            }
            if (StringUtils.isNotNull(str)) {
                SpriteTipHttpResponseMessage spriteTipHttpResponseMessage5 = this.b;
                Intrinsics.checkNotNull(spriteTipHttpResponseMessage5);
                String text2 = spriteTipHttpResponseMessage5.getText();
                Intrinsics.checkNotNullExpressionValue(text2, "mData!!.text");
                bj5.g(text2);
            }
            Context context = getContext();
            if (context != null) {
                hi9.b(((TbPageContextSupport) context).getPageContext(), new String[]{b2});
                return;
            }
            throw new NullPointerException("null cannot be cast to non-null type com.baidu.tbadk.TbPageContextSupport");
        }
    }

    public final void f() {
        String str;
        cn cnVar;
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeV(1048579, this) == null) {
            p45 d = p45.d(this.d);
            d.B(R.dimen.T_X05);
            d.w(R.color.CAM_X0119);
            SpriteTipHttpResponseMessage spriteTipHttpResponseMessage = this.b;
            if (spriteTipHttpResponseMessage != null) {
                ae5 textColorTheme = spriteTipHttpResponseMessage.getTextColorTheme();
                if (textColorTheme != null) {
                    Intrinsics.checkNotNullExpressionValue(textColorTheme, "textColorTheme");
                    int f = wp9.f(e0a.e(textColorTheme));
                    if (!wp9.e(f)) {
                        this.d.setTextColor(f);
                    }
                }
                ae5 bgUrlTheme = spriteTipHttpResponseMessage.getBgUrlTheme();
                if (bgUrlTheme != null) {
                    Intrinsics.checkNotNullExpressionValue(bgUrlTheme, "bgUrlTheme");
                    str = e0a.g(bgUrlTheme);
                } else {
                    str = null;
                }
                if (!qi.isEmpty(str)) {
                    Object n = lg.h().n(str, 19, new Object[0]);
                    if (n instanceof cn) {
                        cnVar = (cn) n;
                    } else {
                        cnVar = null;
                    }
                    if (cnVar != null) {
                        this.a.setBackgroundDrawable(new NinePatchDrawable(getResources(), cnVar.p(), cnVar.p().getNinePatchChunk(), cnVar.o(), null));
                        return;
                    }
                    SkinManager.setBackgroundResource(this.a, R.drawable.funny_sprite_tip_bg_left);
                    lg.h().m(str, 19, null, null);
                    return;
                }
                SkinManager.setBackgroundResource(this.a, R.drawable.funny_sprite_tip_bg_left);
            }
        }
    }
}
