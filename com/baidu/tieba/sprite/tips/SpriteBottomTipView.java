package com.baidu.tieba.sprite.tips;

import android.content.Context;
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
import com.baidu.adp.log.DefaultLog;
import com.baidu.android.imsdk.internal.Constants;
import com.baidu.tbadk.TbPageContextSupport;
import com.baidu.tbadk.core.TbadkCoreApplication;
import com.baidu.tbadk.core.message.SpriteTipHttpResponseMessage;
import com.baidu.tbadk.core.util.SkinManager;
import com.baidu.tbadk.core.util.StatisticItem;
import com.baidu.tbadk.core.util.TiebaStatic;
import com.baidu.tieba.R;
import com.baidu.tieba.bq5;
import com.baidu.tieba.bv5;
import com.baidu.tieba.gd9;
import com.baidu.tieba.ii;
import com.baidu.tieba.r25;
import com.baidu.tieba.sprite.tips.SpriteBottomTipView;
import com.baidu.tieba.vg8;
import com.baidu.tieba.zg5;
import com.baidu.titan.sdk.runtime.ClassClinitInterceptable;
import com.baidu.titan.sdk.runtime.ClassClinitInterceptorStorage;
import com.baidu.titan.sdk.runtime.FieldHolder;
import com.baidu.titan.sdk.runtime.InitContext;
import com.baidu.titan.sdk.runtime.InterceptResult;
import com.baidu.titan.sdk.runtime.Interceptable;
import com.baidu.titan.sdk.runtime.TitanRuntime;
import java.lang.ref.WeakReference;
import java.util.List;
import kotlin.Metadata;
import kotlin.Unit;
import kotlin.jvm.JvmOverloads;
import kotlin.jvm.functions.Function1;
import kotlin.jvm.internal.DefaultConstructorMarker;
import kotlin.jvm.internal.Intrinsics;
import tbclient.PbContent;
@Metadata(d1 = {"\u0000^\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0000\n\u0002\u0010\u000b\n\u0002\b\u0004\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0000\n\u0002\u0010\u0002\n\u0002\b\u0006\n\u0002\u0010\u000e\n\u0002\b\u0005\n\u0002\u0010 \n\u0002\u0018\u0002\n\u0002\b\u0004\u0018\u0000 (2\u00020\u0001:\u0002()B\u001b\b\u0007\u0012\u0006\u0010\u0002\u001a\u00020\u0003\u0012\n\b\u0002\u0010\u0004\u001a\u0004\u0018\u00010\u0005¢\u0006\u0002\u0010\u0006J\b\u0010\u001d\u001a\u00020\u0018H\u0002J\u0006\u0010\u001e\u001a\u00020\u001fJ\u0006\u0010 \u001a\u00020\u0018J\u000e\u0010!\u001a\u00020\u00182\u0006\u0010\"\u001a\u00020\u0011J\u0014\u0010#\u001a\u00020\u00182\f\u0010$\u001a\b\u0012\u0004\u0012\u00020&0%J\b\u0010'\u001a\u00020\u0018H\u0002R\u0012\u0010\u0007\u001a\u00060\bR\u00020\u0000X\u0082\u0004¢\u0006\u0002\n\u0000R\u001a\u0010\t\u001a\u00020\nX\u0086\u000e¢\u0006\u000e\n\u0000\u001a\u0004\b\t\u0010\u000b\"\u0004\b\f\u0010\rR\u000e\u0010\u000e\u001a\u00020\u000fX\u0082\u000e¢\u0006\u0002\n\u0000R\u0010\u0010\u0010\u001a\u0004\u0018\u00010\u0011X\u0082\u000e¢\u0006\u0002\n\u0000R\u000e\u0010\u0012\u001a\u00020\u0013X\u0082\u000e¢\u0006\u0002\n\u0000R7\u0010\u0014\u001a\u001f\u0012\u0013\u0012\u00110\n¢\u0006\f\b\u0016\u0012\b\b\u0017\u0012\u0004\b\b(\t\u0012\u0004\u0012\u00020\u0018\u0018\u00010\u0015X\u0086\u000e¢\u0006\u000e\n\u0000\u001a\u0004\b\u0019\u0010\u001a\"\u0004\b\u001b\u0010\u001c¨\u0006*"}, d2 = {"Lcom/baidu/tieba/sprite/tips/SpriteBottomTipView;", "Landroid/widget/LinearLayout;", "context", "Landroid/content/Context;", "attrs", "Landroid/util/AttributeSet;", "(Landroid/content/Context;Landroid/util/AttributeSet;)V", "animationHandler", "Lcom/baidu/tieba/sprite/tips/SpriteBottomTipView$ShowAnimationHandler;", "isVisibility", "", "()Z", "setVisibility", "(Z)V", "mContent", "Landroid/widget/TextView;", "mData", "Lcom/baidu/tbadk/core/message/SpriteTipHttpResponseMessage;", "mRoot", "Landroid/view/View;", "onVisibilityChangedListener", "Lkotlin/Function1;", "Lkotlin/ParameterName;", "name", "", "getOnVisibilityChangedListener", "()Lkotlin/jvm/functions/Function1;", "setOnVisibilityChangedListener", "(Lkotlin/jvm/functions/Function1;)V", "dismiss", "getJumpScheme", "", "onChangeSkin", "setDataAndShow", "responseMessage", "setRichText", "richTextList", "", "Ltbclient/PbContent;", "show", "Companion", "ShowAnimationHandler", "recommendfrs_release"}, k = 1, mv = {1, 6, 0}, xi = 48)
/* loaded from: classes6.dex */
public final class SpriteBottomTipView extends LinearLayout {
    public static /* synthetic */ Interceptable $ic;
    public static final a g;
    public static boolean h;
    public static boolean i;
    public transient /* synthetic */ FieldHolder $fh;
    public View a;
    public SpriteTipHttpResponseMessage b;
    public TextView c;
    public final b d;
    public Function1<? super Boolean, Unit> e;
    public boolean f;

    static {
        InterceptResult invokeClinit;
        ClassClinitInterceptable classClinitInterceptable = ClassClinitInterceptorStorage.$ic;
        if (classClinitInterceptable != null && (invokeClinit = classClinitInterceptable.invokeClinit(9769318, "Lcom/baidu/tieba/sprite/tips/SpriteBottomTipView;")) != null) {
            Interceptable interceptable = invokeClinit.interceptor;
            if (interceptable != null) {
                $ic = interceptable;
            }
            if ((invokeClinit.flags & 1) != 0) {
                classClinitInterceptable.invokePostClinit(9769318, "Lcom/baidu/tieba/sprite/tips/SpriteBottomTipView;");
                return;
            }
        }
        g = new a(null);
    }

    /* JADX WARN: 'this' call moved to the top of the method (can break code semantics) */
    @JvmOverloads
    public SpriteBottomTipView(Context context) {
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

    /* loaded from: classes6.dex */
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

    /* loaded from: classes6.dex */
    public final class b extends Handler {
        public static /* synthetic */ Interceptable $ic;
        public transient /* synthetic */ FieldHolder $fh;
        public final WeakReference<SpriteBottomTipView> a;
        public final /* synthetic */ SpriteBottomTipView b;

        /* JADX WARN: 'super' call moved to the top of the method (can break code semantics) */
        public b(SpriteBottomTipView spriteBottomTipView, SpriteBottomTipView spriteBottomTipView2) {
            super(Looper.getMainLooper());
            Interceptable interceptable = $ic;
            if (interceptable != null) {
                InitContext newInitContext = TitanRuntime.newInitContext();
                newInitContext.initArgs = r2;
                Object[] objArr = {spriteBottomTipView, spriteBottomTipView2};
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
            this.b = spriteBottomTipView;
            this.a = new WeakReference<>(spriteBottomTipView2);
        }

        @Override // android.os.Handler
        public void handleMessage(Message msg) {
            SpriteBottomTipView spriteBottomTipView;
            Interceptable interceptable = $ic;
            if (interceptable == null || interceptable.invokeL(1048576, this, msg) == null) {
                Intrinsics.checkNotNullParameter(msg, "msg");
                int i = msg.what;
                if (i != 1) {
                    if (i != 2 || (spriteBottomTipView = this.a.get()) == null) {
                        return;
                    }
                    spriteBottomTipView.d();
                    return;
                }
                SpriteBottomTipView spriteBottomTipView2 = this.a.get();
                if (spriteBottomTipView2 == null) {
                    return;
                }
                spriteBottomTipView2.f();
            }
        }
    }

    /* JADX WARN: 'super' call moved to the top of the method (can break code semantics) */
    @JvmOverloads
    public SpriteBottomTipView(final Context context, AttributeSet attributeSet) {
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
        LayoutInflater.from(context).inflate(R.layout.obfuscated_res_0x7f0d084e, (ViewGroup) this, true);
        View findViewById = findViewById(R.id.obfuscated_res_0x7f090782);
        Intrinsics.checkNotNullExpressionValue(findViewById, "findViewById(R.id.content)");
        this.a = findViewById;
        View findViewById2 = findViewById(R.id.obfuscated_res_0x7f09168f);
        Intrinsics.checkNotNullExpressionValue(findViewById2, "findViewById(R.id.message)");
        this.c = (TextView) findViewById2;
        this.c.setMaxWidth((ii.l(context) - ii.g(context, R.dimen.M_W_X017)) - ii.g(context, R.dimen.M_W_X021));
        e();
        this.d = new b(this, this);
        setOnClickListener(new View.OnClickListener() { // from class: com.baidu.tieba.oi9
            public static /* synthetic */ Interceptable $ic;
            public transient /* synthetic */ FieldHolder $fh;

            @Override // android.view.View.OnClickListener
            public final void onClick(View view2) {
                Interceptable interceptable2 = $ic;
                if (interceptable2 == null || interceptable2.invokeL(1048576, this, view2) == null) {
                    SpriteBottomTipView.a(SpriteBottomTipView.this, context, view2);
                }
            }
        });
    }

    public /* synthetic */ SpriteBottomTipView(Context context, AttributeSet attributeSet, int i2, DefaultConstructorMarker defaultConstructorMarker) {
        this(context, (i2 & 2) != 0 ? null : attributeSet);
    }

    public static final void a(SpriteBottomTipView this$0, Context context, View view2) {
        String str;
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeLLL(InputDeviceCompat.SOURCE_TRACKBALL, null, this$0, context, view2) == null) {
            Intrinsics.checkNotNullParameter(this$0, "this$0");
            Intrinsics.checkNotNullParameter(context, "$context");
            if (bq5.a()) {
                return;
            }
            String jumpScheme = this$0.getJumpScheme();
            if (!TextUtils.isEmpty(jumpScheme) && (context instanceof TbPageContextSupport)) {
                int i2 = 1;
                gd9.b(((TbPageContextSupport) context).getPageContext(), new String[]{jumpScheme});
                StatisticItem param = new StatisticItem("c15226").param("uid", TbadkCoreApplication.getCurrentAccountId());
                SpriteTipHttpResponseMessage spriteTipHttpResponseMessage = this$0.b;
                if (spriteTipHttpResponseMessage != null) {
                    str = spriteTipHttpResponseMessage.getText();
                } else {
                    str = null;
                }
                StatisticItem param2 = param.param("content", str);
                if (!i) {
                    i2 = 2;
                }
                StatisticItem param3 = param2.param("obj_type", i2);
                Intrinsics.checkNotNullExpressionValue(param3, "StatisticItem(\"c15226\")\n… (isFirstClick) 1 else 2)");
                TiebaStatic.log(param3);
                i = false;
            }
        }
    }

    public final void setOnVisibilityChangedListener(Function1<? super Boolean, Unit> function1) {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeL(1048582, this, function1) == null) {
            this.e = function1;
        }
    }

    public final void setRichText(List<PbContent> richTextList) {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeL(1048583, this, richTextList) == null) {
            Intrinsics.checkNotNullParameter(richTextList, "richTextList");
            this.c.setText(bv5.H(richTextList));
        }
    }

    public final void setVisibility(boolean z) {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeZ(InputDeviceCompat.SOURCE_TOUCHPAD, this, z) == null) {
            this.f = z;
        }
    }

    public final void d() {
        Interceptable interceptable = $ic;
        if ((interceptable != null && interceptable.invokeV(1048576, this) != null) || !this.f) {
            return;
        }
        this.f = false;
        Function1<? super Boolean, Unit> function1 = this.e;
        if (function1 != null) {
            function1.invoke(Boolean.FALSE);
        }
    }

    public final void e() {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeV(Constants.METHOD_GET_CONTACTER_INFO_FOR_SESSION, this) == null) {
            SkinManager.setBackgroundResource(this.a, R.drawable.sprite_bottom_tip_bg);
            r25 d = r25.d(this.c);
            d.B(R.dimen.T_X05);
            d.w(R.color.CAM_X0105);
        }
    }

    public final void f() {
        Interceptable interceptable = $ic;
        if ((interceptable != null && interceptable.invokeV(Constants.METHOD_SEND_USER_MSG, this) != null) || this.f) {
            return;
        }
        this.f = true;
        Function1<? super Boolean, Unit> function1 = this.e;
        if (function1 != null) {
            function1.invoke(Boolean.TRUE);
        }
    }

    /* JADX DEBUG: Type inference failed for r0v2. Raw type applied. Possible types: kotlin.jvm.functions.Function1<? super java.lang.Boolean, kotlin.Unit>, kotlin.jvm.functions.Function1<java.lang.Boolean, kotlin.Unit> */
    public final Function1<Boolean, Unit> getOnVisibilityChangedListener() {
        InterceptResult invokeV;
        Interceptable interceptable = $ic;
        if (interceptable == null || (invokeV = interceptable.invokeV(1048580, this)) == null) {
            return this.e;
        }
        return (Function1) invokeV.objValue;
    }

    public final String getJumpScheme() {
        InterceptResult invokeV;
        Interceptable interceptable = $ic;
        if (interceptable == null || (invokeV = interceptable.invokeV(1048579, this)) == null) {
            if (this.b != null && getVisibility() != 8) {
                SpriteTipHttpResponseMessage spriteTipHttpResponseMessage = this.b;
                Intrinsics.checkNotNull(spriteTipHttpResponseMessage);
                if (spriteTipHttpResponseMessage.getNeedSend()) {
                    SpriteTipHttpResponseMessage spriteTipHttpResponseMessage2 = this.b;
                    Intrinsics.checkNotNull(spriteTipHttpResponseMessage2);
                    String sendText = spriteTipHttpResponseMessage2.getSendText();
                    Intrinsics.checkNotNullExpressionValue(sendText, "mData!!.sendText");
                    return zg5.a(sendText, 1);
                }
                SpriteTipHttpResponseMessage spriteTipHttpResponseMessage3 = this.b;
                Intrinsics.checkNotNull(spriteTipHttpResponseMessage3);
                String text = spriteTipHttpResponseMessage3.getText();
                Intrinsics.checkNotNullExpressionValue(text, "mData!!.text");
                return zg5.a(text, 2);
            }
            return zg5.a("", 0);
        }
        return (String) invokeV.objValue;
    }

    public final void setDataAndShow(SpriteTipHttpResponseMessage responseMessage) {
        String str;
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeL(1048581, this, responseMessage) == null) {
            Intrinsics.checkNotNullParameter(responseMessage, "responseMessage");
            if (TextUtils.isEmpty(responseMessage.getText())) {
                return;
            }
            this.c.setText(responseMessage.getText());
            this.b = responseMessage;
            e();
            int i2 = 1;
            this.d.removeMessages(1);
            this.d.removeMessages(2);
            this.d.sendEmptyMessage(1);
            this.d.sendEmptyMessageDelayed(2, 5000L);
            vg8 defaultLog = DefaultLog.getInstance();
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
            if (!h) {
                i2 = 2;
            }
            StatisticItem param2 = param.param("obj_type", i2);
            Intrinsics.checkNotNullExpressionValue(param2, "StatisticItem(\"c15225\")\n…f (isFirstShow) 1 else 2)");
            TiebaStatic.log(param2);
            h = false;
        }
    }
}
