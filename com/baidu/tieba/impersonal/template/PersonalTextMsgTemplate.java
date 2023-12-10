package com.baidu.tieba.impersonal.template;

import android.content.Context;
import android.graphics.drawable.Drawable;
import android.text.SpannableStringBuilder;
import android.text.TextUtils;
import android.view.View;
import android.view.ViewGroup;
import android.widget.LinearLayout;
import android.widget.TextView;
import androidx.core.view.InputDeviceCompat;
import com.baidu.adp.base.BdPageContext;
import com.baidu.adp.lib.util.AndroidUtils;
import com.baidu.adp.lib.util.BdUtilHelper;
import com.baidu.adp.lib.util.StringUtils;
import com.baidu.android.imsdk.internal.Constants;
import com.baidu.platform.comapi.map.MapBundleKey;
import com.baidu.tbadk.TbPageContext;
import com.baidu.tbadk.core.TbadkCoreApplication;
import com.baidu.tbadk.core.elementsMaven.EMManager;
import com.baidu.tbadk.core.elementsMaven.span.EMRichTextAnyIconSpan;
import com.baidu.tbadk.core.elementsMaven.view.EMTextView;
import com.baidu.tbadk.core.util.ListUtils;
import com.baidu.tbadk.core.util.StatisticItem;
import com.baidu.tbadk.core.util.TbadkCoreStatisticKey;
import com.baidu.tbadk.core.util.TiebaStatic;
import com.baidu.tbadk.core.util.UrlManager;
import com.baidu.tbadk.core.util.UtilHelper;
import com.baidu.tbadk.widget.richText.TbRichText;
import com.baidu.tbadk.widget.richText.TbRichTextData;
import com.baidu.tbadk.widget.richText.TbRichTextView;
import com.baidu.tieba.R;
import com.baidu.tieba.a5;
import com.baidu.tieba.br6;
import com.baidu.tieba.id9;
import com.baidu.tieba.im.lib.socket.msg.data.AbilityItem;
import com.baidu.tieba.impersonal.components.MsgGuideLayout;
import com.baidu.tieba.impersonal.data.BehaviorExt;
import com.baidu.tieba.impersonal.data.Extra;
import com.baidu.tieba.impersonal.template.PersonalTextMsgTemplate;
import com.baidu.tieba.impersonal.typewriter.TextTypeWriter;
import com.baidu.tieba.l05;
import com.baidu.tieba.lq8;
import com.baidu.tieba.n05;
import com.baidu.tieba.nb9;
import com.baidu.tieba.p05;
import com.baidu.tieba.py5;
import com.baidu.tieba.rd9;
import com.baidu.tieba.uy5;
import com.baidu.tieba.vb9;
import com.baidu.tieba.wb9;
import com.baidu.tieba.yb9;
import com.baidu.tieba.zb9;
import com.baidu.titan.sdk.runtime.FieldHolder;
import com.baidu.titan.sdk.runtime.InitContext;
import com.baidu.titan.sdk.runtime.InterceptResult;
import com.baidu.titan.sdk.runtime.Interceptable;
import com.baidu.titan.sdk.runtime.TitanRuntime;
import com.bumptech.glide.Glide;
import com.bumptech.glide.RequestBuilder;
import com.bumptech.glide.request.target.SimpleTarget;
import com.bumptech.glide.request.transition.Transition;
import com.google.android.exoplayer2.text.ttml.TtmlNode;
import java.util.ArrayList;
import java.util.List;
import java.util.Map;
import kotlin.Lazy;
import kotlin.LazyKt__LazyJVMKt;
import kotlin.Metadata;
import kotlin.Unit;
import kotlin.jvm.functions.Function0;
import kotlin.jvm.functions.Function1;
import kotlin.jvm.internal.Intrinsics;
import org.json.JSONArray;
@Metadata(d1 = {"\u0000T\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0000\n\u0002\u0010\u000e\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0002\b\u0005\n\u0002\u0010\u0002\n\u0002\b\b\n\u0002\u0018\u0002\n\u0002\b\u0004\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\u0018\u00002\u0014\u0012\u0004\u0012\u00020\u0002\u0012\u0004\u0012\u00020\u0003\u0012\u0004\u0012\u00020\u00040\u0001B%\u0012\u0006\u0010\u0005\u001a\u00020\u0006\u0012\u0006\u0010\u0007\u001a\u00020\b\u0012\u0006\u0010\t\u001a\u00020\n\u0012\u0006\u0010\u000b\u001a\u00020\f¢\u0006\u0002\u0010\rJ\u001a\u0010\u0014\u001a\u00020\u00152\b\u0010\u0016\u001a\u0004\u0018\u00010\u00032\u0006\u0010\u0017\u001a\u00020\u0004H\u0016J\u001a\u0010\u0018\u001a\u00020\u00152\b\u0010\u0016\u001a\u0004\u0018\u00010\u00032\u0006\u0010\u0017\u001a\u00020\u0004H\u0002J\u001a\u0010\u0019\u001a\u00020\u00152\b\u0010\u0016\u001a\u0004\u0018\u00010\u00032\u0006\u0010\u0017\u001a\u00020\u0004H\u0002J\u001a\u0010\u001a\u001a\u00020\u00152\b\u0010\u0016\u001a\u0004\u0018\u00010\u00032\u0006\u0010\u0017\u001a\u00020\u0004H\u0002J\u001a\u0010\u001b\u001a\u00020\u00152\b\u0010\u0016\u001a\u0004\u0018\u00010\u00032\u0006\u0010\u0017\u001a\u00020\u0004H\u0002J\u0010\u0010\u001c\u001a\u00020\u00152\u0006\u0010\u001d\u001a\u00020\u001eH\u0016J\u0010\u0010\u001f\u001a\u00020\u00032\u0006\u0010 \u001a\u00020\u001eH\u0016J\u001c\u0010!\u001a\u00020\u00152\u0006\u0010\"\u001a\u00020#2\n\u0010$\u001a\u0006\u0012\u0002\b\u00030%H\u0002R\u000e\u0010\u000b\u001a\u00020\fX\u0082\u0004¢\u0006\u0002\n\u0000R\u000e\u0010\t\u001a\u00020\nX\u0082\u0004¢\u0006\u0002\n\u0000R\u000e\u0010\u0007\u001a\u00020\bX\u0082\u0004¢\u0006\u0002\n\u0000R\u001b\u0010\u000e\u001a\u00020\u000f8BX\u0082\u0084\u0002¢\u0006\f\n\u0004\b\u0012\u0010\u0013\u001a\u0004\b\u0010\u0010\u0011¨\u0006&"}, d2 = {"Lcom/baidu/tieba/impersonal/template/PersonalTextMsgTemplate;", "Lcom/baidu/tieba/impersonal/template/BasePersonalMsgTemplate;", "Lcom/baidu/tieba/impersonal/data/TextMsgContent;", "Landroid/widget/LinearLayout;", "Lcom/baidu/tieba/impersonal/components/uistate/PersonalTextMsgUiState;", "name", "", "sendMsgTransfer", "Lcom/baidu/tieba/impersonal/sprite/SendMsgTransfer;", "processor", "Lcom/baidu/tieba/im/base/core/uilist/AbilityProcessor;", "behaviorExt", "Lcom/baidu/tieba/impersonal/data/BehaviorExt;", "(Ljava/lang/String;Lcom/baidu/tieba/impersonal/sprite/SendMsgTransfer;Lcom/baidu/tieba/im/base/core/uilist/AbilityProcessor;Lcom/baidu/tieba/impersonal/data/BehaviorExt;)V", "textTypeWriter", "Lcom/baidu/tieba/impersonal/typewriter/TextTypeWriter;", "getTextTypeWriter", "()Lcom/baidu/tieba/impersonal/typewriter/TextTypeWriter;", "textTypeWriter$delegate", "Lkotlin/Lazy;", "bindChild", "", MapBundleKey.OfflineMapKey.OFFLINE_CHILD, "data", "bindCopy", "bindGuideLayout", "bindRichText", "bindText", "configContainer", "container", "Landroid/view/ViewGroup;", "createChild", "parent", "dealLink", TtmlNode.TAG_SPAN, "Lcom/baidu/tbadk/widget/richText/TbRichTextIntentSpan;", "context", "Lcom/baidu/adp/base/BdPageContext;", "im-personal_release"}, k = 1, mv = {1, 6, 0}, xi = 48)
/* loaded from: classes6.dex */
public final class PersonalTextMsgTemplate extends rd9<wb9, LinearLayout, nb9> {
    public static /* synthetic */ Interceptable $ic;
    public transient /* synthetic */ FieldHolder $fh;
    public final id9 b;
    public final lq8 c;
    public final BehaviorExt d;
    public final Lazy e;

    /* loaded from: classes6.dex */
    public static final class a implements TbRichTextView.t {
        public static /* synthetic */ Interceptable $ic;
        public transient /* synthetic */ FieldHolder $fh;
        public final /* synthetic */ LinearLayout a;
        public final /* synthetic */ PersonalTextMsgTemplate b;

        /* renamed from: com.baidu.tieba.impersonal.template.PersonalTextMsgTemplate$a$a  reason: collision with other inner class name */
        /* loaded from: classes6.dex */
        public static final class C0348a extends SimpleTarget<Drawable> {
            public static /* synthetic */ Interceptable $ic;
            public transient /* synthetic */ FieldHolder $fh;
            public final /* synthetic */ EMRichTextAnyIconSpan a;
            public final /* synthetic */ TextView b;

            public C0348a(EMRichTextAnyIconSpan eMRichTextAnyIconSpan, TextView textView) {
                Interceptable interceptable = $ic;
                if (interceptable != null) {
                    InitContext newInitContext = TitanRuntime.newInitContext();
                    newInitContext.initArgs = r2;
                    Object[] objArr = {eMRichTextAnyIconSpan, textView};
                    interceptable.invokeUnInit(65536, newInitContext);
                    int i = newInitContext.flag;
                    if ((i & 1) != 0) {
                        int i2 = i & 2;
                        newInitContext.thisArg = this;
                        interceptable.invokeInitBody(65536, newInitContext);
                        return;
                    }
                }
                this.a = eMRichTextAnyIconSpan;
                this.b = textView;
            }

            /* JADX DEBUG: Method merged with bridge method */
            @Override // com.bumptech.glide.request.target.Target
            /* renamed from: a */
            public void onResourceReady(Drawable resource, Transition<? super Drawable> transition) {
                Interceptable interceptable = $ic;
                if (interceptable == null || interceptable.invokeLL(1048576, this, resource, transition) == null) {
                    Intrinsics.checkNotNullParameter(resource, "resource");
                    this.a.d(resource);
                    TextView textView = this.b;
                    if (textView != null) {
                        textView.invalidate();
                    }
                }
            }
        }

        public a(LinearLayout linearLayout, PersonalTextMsgTemplate personalTextMsgTemplate) {
            Interceptable interceptable = $ic;
            if (interceptable != null) {
                InitContext newInitContext = TitanRuntime.newInitContext();
                newInitContext.initArgs = r2;
                Object[] objArr = {linearLayout, personalTextMsgTemplate};
                interceptable.invokeUnInit(65536, newInitContext);
                int i = newInitContext.flag;
                if ((i & 1) != 0) {
                    int i2 = i & 2;
                    newInitContext.thisArg = this;
                    interceptable.invokeInitBody(65536, newInitContext);
                    return;
                }
            }
            this.a = linearLayout;
            this.b = personalTextMsgTemplate;
        }

        public static final void a(uy5[] uy5VarArr) {
            Interceptable interceptable = $ic;
            if ((interceptable == null || interceptable.invokeL(65537, null, uy5VarArr) == null) && uy5VarArr != null) {
                for (uy5 uy5Var : uy5VarArr) {
                    TiebaStatic.log(new StatisticItem(TbadkCoreStatisticKey.GROUP_CHAT_RICHTEXT_LINK_EXPOSE_KEY).param("uid", TbadkCoreApplication.getCurrentAccount()).param("obj_type", uy5Var.h()).param("obj_param1", uy5Var.f()));
                }
            }
        }

        public static final void b(TbRichTextView tbRichTextView, PersonalTextMsgTemplate this$0, uy5 it) {
            Context context;
            Interceptable interceptable = $ic;
            if (interceptable == null || interceptable.invokeLLL(65538, null, tbRichTextView, this$0, it) == null) {
                Intrinsics.checkNotNullParameter(this$0, "this$0");
                if (tbRichTextView != null) {
                    context = tbRichTextView.getContext();
                } else {
                    context = null;
                }
                BdPageContext<?> context2 = a5.a(context);
                Intrinsics.checkNotNullExpressionValue(it, "it");
                Intrinsics.checkNotNullExpressionValue(context2, "context");
                this$0.t(it, context2);
                TiebaStatic.log(new StatisticItem(TbadkCoreStatisticKey.GROUP_CHAT_RICHTEXT_LINK_CLICK_KEY).param("uid", TbadkCoreApplication.getCurrentAccount()).param("obj_type", it.h()).param("obj_param1", it.f()));
            }
        }

        @Override // com.baidu.tbadk.widget.richText.TbRichTextView.t
        public void h1(SpannableStringBuilder spannableStringBuilder, TextView textView, final TbRichTextView tbRichTextView) {
            EMRichTextAnyIconSpan[] eMRichTextAnyIconSpanArr;
            final uy5[] uy5VarArr;
            TbRichText richText;
            ArrayList<TbRichTextData> Q;
            Interceptable interceptable = $ic;
            if (interceptable == null || interceptable.invokeLLL(1048576, this, spannableStringBuilder, textView, tbRichTextView) == null) {
                if (tbRichTextView != null && (richText = tbRichTextView.getRichText()) != null && (Q = richText.Q()) != null) {
                    for (TbRichTextData tbRichTextData : Q) {
                        tbRichTextData.n0(false);
                    }
                }
                Runnable runnable = null;
                if (spannableStringBuilder != null) {
                    eMRichTextAnyIconSpanArr = (EMRichTextAnyIconSpan[]) spannableStringBuilder.getSpans(0, spannableStringBuilder.length(), EMRichTextAnyIconSpan.class);
                } else {
                    eMRichTextAnyIconSpanArr = null;
                }
                if (eMRichTextAnyIconSpanArr != null) {
                    for (EMRichTextAnyIconSpan eMRichTextAnyIconSpan : eMRichTextAnyIconSpanArr) {
                        if (!TextUtils.isEmpty(eMRichTextAnyIconSpan.b())) {
                            eMRichTextAnyIconSpan.e(EMRichTextAnyIconSpan.IconType.NET);
                            eMRichTextAnyIconSpan.f(UtilHelper.getDimenPixelSize(R.dimen.M_W_X004));
                            eMRichTextAnyIconSpan.j(UtilHelper.getDimenPixelSize(R.dimen.M_W_X002));
                            Glide.with(TbadkCoreApplication.getInst()).load(eMRichTextAnyIconSpan.b()).into((RequestBuilder<Drawable>) new C0348a(eMRichTextAnyIconSpan, textView));
                        }
                    }
                }
                if (spannableStringBuilder != null) {
                    uy5VarArr = (uy5[]) spannableStringBuilder.getSpans(0, spannableStringBuilder.length(), uy5.class);
                } else {
                    uy5VarArr = null;
                }
                LinearLayout linearLayout = this.a;
                Object tag = linearLayout.getTag();
                if (tag instanceof Runnable) {
                    runnable = (Runnable) tag;
                }
                linearLayout.removeCallbacks(runnable);
                Runnable runnable2 = new Runnable() { // from class: com.baidu.tieba.nd9
                    public static /* synthetic */ Interceptable $ic;
                    public transient /* synthetic */ FieldHolder $fh;

                    @Override // java.lang.Runnable
                    public final void run() {
                        Interceptable interceptable2 = $ic;
                        if (interceptable2 == null || interceptable2.invokeV(1048576, this) == null) {
                            PersonalTextMsgTemplate.a.a(uy5VarArr);
                        }
                    }
                };
                this.a.setTag(runnable2);
                this.a.postDelayed(runnable2, 500L);
                if (uy5VarArr != null) {
                    final PersonalTextMsgTemplate personalTextMsgTemplate = this.b;
                    for (uy5 uy5Var : uy5VarArr) {
                        uy5Var.o(new uy5.b() { // from class: com.baidu.tieba.qd9
                            public static /* synthetic */ Interceptable $ic;
                            public transient /* synthetic */ FieldHolder $fh;

                            @Override // com.baidu.tieba.uy5.b
                            public final void a(uy5 uy5Var2) {
                                Interceptable interceptable2 = $ic;
                                if (interceptable2 == null || interceptable2.invokeL(1048576, this, uy5Var2) == null) {
                                    PersonalTextMsgTemplate.a.b(TbRichTextView.this, personalTextMsgTemplate, uy5Var2);
                                }
                            }
                        });
                    }
                }
            }
        }
    }

    /* loaded from: classes6.dex */
    public static final class b implements Function1<Integer, Unit> {
        public static /* synthetic */ Interceptable $ic;
        public transient /* synthetic */ FieldHolder $fh;

        public b() {
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

        public void a(int i) {
            Interceptable interceptable = $ic;
            if (interceptable == null || interceptable.invokeI(1048576, this, i) == null) {
                br6.b().c(new yb9(i));
            }
        }

        /* JADX DEBUG: Method arguments types fixed to match base method, original types: [java.lang.Object] */
        /* JADX DEBUG: Return type fixed from 'java.lang.Object' to match base method */
        @Override // kotlin.jvm.functions.Function1
        public /* bridge */ /* synthetic */ Unit invoke(Integer num) {
            a(num.intValue());
            return Unit.INSTANCE;
        }
    }

    /* JADX WARN: 'super' call moved to the top of the method (can break code semantics) */
    public PersonalTextMsgTemplate(String name, id9 sendMsgTransfer, lq8 processor, BehaviorExt behaviorExt) {
        super(name);
        Interceptable interceptable = $ic;
        if (interceptable != null) {
            InitContext newInitContext = TitanRuntime.newInitContext();
            newInitContext.initArgs = r2;
            Object[] objArr = {name, sendMsgTransfer, processor, behaviorExt};
            interceptable.invokeUnInit(65536, newInitContext);
            int i = newInitContext.flag;
            if ((i & 1) != 0) {
                int i2 = i & 2;
                super((String) newInitContext.callArgs[0]);
                newInitContext.thisArg = this;
                interceptable.invokeInitBody(65536, newInitContext);
                return;
            }
        }
        Intrinsics.checkNotNullParameter(name, "name");
        Intrinsics.checkNotNullParameter(sendMsgTransfer, "sendMsgTransfer");
        Intrinsics.checkNotNullParameter(processor, "processor");
        Intrinsics.checkNotNullParameter(behaviorExt, "behaviorExt");
        this.b = sendMsgTransfer;
        this.c = processor;
        this.d = behaviorExt;
        this.e = LazyKt__LazyJVMKt.lazy(PersonalTextMsgTemplate$textTypeWriter$2.INSTANCE);
    }

    public static final boolean n(LinearLayout linearLayout, final nb9 data, View view2) {
        InterceptResult invokeLLL;
        Interceptable interceptable = $ic;
        if (interceptable == null || (invokeLLL = interceptable.invokeLLL(65538, null, linearLayout, data, view2)) == null) {
            Intrinsics.checkNotNullParameter(data, "$data");
            p05 p05Var = new p05(linearLayout.getContext());
            ArrayList arrayList = new ArrayList();
            arrayList.add(new l05(0, TbadkCoreApplication.getInst().getString(R.string.obfuscated_res_0x7f0f04f5), p05Var));
            p05Var.m(arrayList);
            BdPageContext<?> a2 = a5.a(linearLayout.getContext());
            if (a2 == null) {
                return true;
            }
            final n05 n05Var = new n05(a2, p05Var);
            p05Var.r(new p05.f() { // from class: com.baidu.tieba.md9
                public static /* synthetic */ Interceptable $ic;
                public transient /* synthetic */ FieldHolder $fh;

                @Override // com.baidu.tieba.p05.f
                public final void E0(p05 p05Var2, int i, View view3) {
                    Interceptable interceptable2 = $ic;
                    if (interceptable2 == null || interceptable2.invokeLIL(1048576, this, p05Var2, i, view3) == null) {
                        PersonalTextMsgTemplate.o(n05.this, data, p05Var2, i, view3);
                    }
                }
            });
            n05Var.l();
            return true;
        }
        return invokeLLL.booleanValue;
    }

    public static final void o(n05 dialog, nb9 data, p05 p05Var, int i, View view2) {
        String str;
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeCommon(65539, null, new Object[]{dialog, data, p05Var, Integer.valueOf(i), view2}) == null) {
            Intrinsics.checkNotNullParameter(dialog, "$dialog");
            Intrinsics.checkNotNullParameter(data, "$data");
            dialog.dismiss();
            wb9 f = data.c().f();
            if (f != null) {
                str = f.a();
            } else {
                str = null;
            }
            AndroidUtils.copyToClipboard(str);
        }
    }

    /* JADX DEBUG: Method merged with bridge method */
    @Override // com.baidu.tieba.rd9
    /* renamed from: l */
    public void d(LinearLayout linearLayout, nb9 data) {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeLL(1048579, this, linearLayout, data) == null) {
            Intrinsics.checkNotNullParameter(data, "data");
            r(linearLayout, data);
            q(linearLayout, data);
            p(linearLayout, data);
            m(linearLayout, data);
        }
    }

    public final void m(final LinearLayout linearLayout, final nb9 nb9Var) {
        Interceptable interceptable = $ic;
        if ((interceptable == null || interceptable.invokeLL(1048580, this, linearLayout, nb9Var) == null) && linearLayout != null && linearLayout.getContext() != null) {
            linearLayout.setOnLongClickListener(new View.OnLongClickListener() { // from class: com.baidu.tieba.od9
                public static /* synthetic */ Interceptable $ic;
                public transient /* synthetic */ FieldHolder $fh;

                @Override // android.view.View.OnLongClickListener
                public final boolean onLongClick(View view2) {
                    InterceptResult invokeL;
                    Interceptable interceptable2 = $ic;
                    return (interceptable2 == null || (invokeL = interceptable2.invokeL(1048576, this, view2)) == null) ? PersonalTextMsgTemplate.n(linearLayout, nb9Var, view2) : invokeL.booleanValue;
                }
            });
        }
    }

    @Override // com.baidu.tieba.rd9
    public void f(ViewGroup container) {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeL(Constants.METHOD_GET_CONTACTER_INFO_FOR_SESSION, this, container) == null) {
            Intrinsics.checkNotNullParameter(container, "container");
            super.f(container);
            int dimens = BdUtilHelper.getDimens(container.getContext(), R.dimen.M_H_X003);
            int dimens2 = BdUtilHelper.getDimens(container.getContext(), R.dimen.M_H_X003);
            int dimens3 = BdUtilHelper.getDimens(container.getContext(), R.dimen.M_W_X004);
            int dimens4 = BdUtilHelper.getDimens(container.getContext(), R.dimen.M_W_X004);
            if (j()) {
                dimens = BdUtilHelper.getDimens(container.getContext(), R.dimen.M_H_X005);
            }
            container.setPadding(dimens3, dimens, dimens4, dimens2);
        }
    }

    /* JADX DEBUG: Method merged with bridge method */
    @Override // com.baidu.tieba.rd9
    /* renamed from: s */
    public LinearLayout g(ViewGroup parent) {
        InterceptResult invokeL;
        Interceptable interceptable = $ic;
        if (interceptable == null || (invokeL = interceptable.invokeL(InputDeviceCompat.SOURCE_TOUCHPAD, this, parent)) == null) {
            Intrinsics.checkNotNullParameter(parent, "parent");
            LinearLayout linearLayout = new LinearLayout(parent.getContext());
            linearLayout.setOrientation(1);
            return linearLayout;
        }
        return (LinearLayout) invokeL.objValue;
    }

    /* JADX DEBUG: Failed to insert an additional move for type inference into block B:20:0x003c */
    /* JADX WARN: Multi-variable type inference failed */
    /* JADX WARN: Type inference failed for: r3v0, types: [android.view.View] */
    /* JADX WARN: Type inference failed for: r3v1 */
    /* JADX WARN: Type inference failed for: r3v3, types: [com.baidu.tieba.impersonal.components.MsgGuideLayout, android.widget.RelativeLayout, android.view.View] */
    /* JADX WARN: Type inference failed for: r7v0, types: [android.widget.LinearLayout, java.lang.Object] */
    public final void p(LinearLayout linearLayout, nb9 nb9Var) {
        List<AbilityItem> list;
        String str;
        MsgGuideLayout msgGuideLayout;
        Extra.MsgSugInfo msgSugInfo;
        Interceptable interceptable = $ic;
        if ((interceptable == null || interceptable.invokeLL(1048581, this, linearLayout, nb9Var) == null) && linearLayout != 0 && !j()) {
            Extra a2 = nb9Var.c().g().a();
            JSONArray jSONArray = null;
            if (a2 != null && (msgSugInfo = a2.getMsgSugInfo()) != null) {
                list = msgSugInfo.getMsgSugAbilityItems();
            } else {
                list = null;
            }
            ?? findViewById = linearLayout.findViewById(R.id.obfuscated_res_0x7f091d2f);
            if (findViewById != 0 && ListUtils.isEmpty(list)) {
                linearLayout.removeView(findViewById);
                return;
            }
            if (findViewById == 0 && ListUtils.isNotEmpty(list)) {
                Context context = linearLayout.getContext();
                Intrinsics.checkNotNullExpressionValue(context, "child.context");
                findViewById = new MsgGuideLayout(context, null, 2, null);
                findViewById.c(this.c, this.d);
                findViewById.setId(R.id.obfuscated_res_0x7f091d2f);
                linearLayout.addView(findViewById, new LinearLayout.LayoutParams(-2, -2));
            }
            if (linearLayout.getChildCount() > 0) {
                wb9 f = nb9Var.c().f();
                if (f != null) {
                    str = f.c();
                } else {
                    str = null;
                }
                if (!StringUtils.isNotNull(str)) {
                    wb9 f2 = nb9Var.c().f();
                    if (f2 != null) {
                        jSONArray = f2.b();
                    }
                    if (jSONArray == null) {
                        return;
                    }
                }
                if (list != null && (msgGuideLayout = (MsgGuideLayout) findViewById) != null) {
                    msgGuideLayout.d(list);
                }
            }
        }
    }

    public final void q(LinearLayout linearLayout, nb9 nb9Var) {
        JSONArray jSONArray;
        JSONArray jSONArray2;
        Interceptable interceptable = $ic;
        if ((interceptable != null && interceptable.invokeLL(1048582, this, linearLayout, nb9Var) != null) || linearLayout == null) {
            return;
        }
        TbRichTextView tbRichTextView = (TbRichTextView) linearLayout.findViewById(R.id.obfuscated_res_0x7f091d31);
        JSONArray jSONArray3 = null;
        if (tbRichTextView != null) {
            wb9 f = nb9Var.c().f();
            if (f != null) {
                jSONArray2 = f.b();
            } else {
                jSONArray2 = null;
            }
            if (jSONArray2 == null) {
                linearLayout.removeView(tbRichTextView);
                return;
            }
        }
        if (tbRichTextView == null) {
            wb9 f2 = nb9Var.c().f();
            if (f2 != null) {
                jSONArray = f2.b();
            } else {
                jSONArray = null;
            }
            if (jSONArray != null) {
                tbRichTextView = new TbRichTextView(linearLayout.getContext());
                ViewGroup.LayoutParams layoutParams = new LinearLayout.LayoutParams(-2, -2);
                py5 py5Var = new py5();
                py5Var.x(BdUtilHelper.getDimens(linearLayout.getContext(), R.dimen.T_X05));
                py5Var.p(BdUtilHelper.getDimens(TbadkCoreApplication.getInst().getContext(), R.dimen.M_H_X002), 1.0f);
                py5Var.j(BdUtilHelper.getDimens(TbadkCoreApplication.getInst().getContext(), R.dimen.tbds42), BdUtilHelper.getDimens(TbadkCoreApplication.getInst().getContext(), R.dimen.tbds42));
                tbRichTextView.setLayoutStrategy(py5Var);
                tbRichTextView.setId(R.id.obfuscated_res_0x7f091d31);
                tbRichTextView.setPadding(BdUtilHelper.getDimens(linearLayout.getContext(), R.dimen.M_W_X006), BdUtilHelper.getDimens(linearLayout.getContext(), R.dimen.M_H_X004), BdUtilHelper.getDimens(linearLayout.getContext(), R.dimen.M_W_X006), BdUtilHelper.getDimens(linearLayout.getContext(), R.dimen.M_H_X004));
                linearLayout.addView(tbRichTextView, layoutParams);
            }
        }
        if (tbRichTextView != null) {
            wb9 f3 = nb9Var.c().f();
            if (f3 != null) {
                jSONArray3 = f3.b();
            }
            tbRichTextView.setText(TbRichTextView.Y(jSONArray3, 19), false, new a(linearLayout, this));
        }
    }

    public final void r(LinearLayout linearLayout, final nb9 nb9Var) {
        String str;
        String str2;
        Interceptable interceptable = $ic;
        if ((interceptable != null && interceptable.invokeLL(1048583, this, linearLayout, nb9Var) != null) || linearLayout == null) {
            return;
        }
        TextView textView = (TextView) linearLayout.findViewById(R.id.obfuscated_res_0x7f091d32);
        String str3 = null;
        if (textView != null) {
            wb9 f = nb9Var.c().f();
            if (f != null) {
                str2 = f.c();
            } else {
                str2 = null;
            }
            if (TextUtils.isEmpty(str2)) {
                linearLayout.removeView(textView);
                return;
            }
        }
        if (textView == null) {
            wb9 f2 = nb9Var.c().f();
            if (f2 != null) {
                str = f2.c();
            } else {
                str = null;
            }
            if (!TextUtils.isEmpty(str)) {
                textView = new EMTextView(linearLayout.getContext());
                if (j()) {
                    textView.setTextColor(linearLayout.getContext().getResources().getColor(R.color.CAM_X0119));
                } else {
                    textView.setTextColor(linearLayout.getContext().getResources().getColor(R.color.CAM_X0105));
                }
                textView.setPadding(BdUtilHelper.getDimens(linearLayout.getContext(), R.dimen.M_W_X006), BdUtilHelper.getDimens(linearLayout.getContext(), R.dimen.M_H_X005), BdUtilHelper.getDimens(linearLayout.getContext(), R.dimen.M_W_X006), BdUtilHelper.getDimens(linearLayout.getContext(), R.dimen.M_H_X005));
                EMManager.from(textView).setTextSize(R.dimen.T_X05).setTextLinePadding(R.dimen.M_T_X002);
                textView.setId(R.id.obfuscated_res_0x7f091d32);
                linearLayout.addView(textView, new LinearLayout.LayoutParams(-2, -2));
            }
        }
        if (nb9Var.j()) {
            TextTypeWriter u = u();
            wb9 f3 = nb9Var.c().f();
            u.n(textView, (f3 == null || (r0 = f3.c()) == null) ? "" : "", new b(), new Function0<Unit>(nb9Var) { // from class: com.baidu.tieba.impersonal.template.PersonalTextMsgTemplate$bindText$2
                public static /* synthetic */ Interceptable $ic;
                public final /* synthetic */ nb9 $data;
                public transient /* synthetic */ FieldHolder $fh;

                /* JADX WARN: 'super' call moved to the top of the method (can break code semantics) */
                {
                    super(0);
                    Interceptable interceptable2 = $ic;
                    if (interceptable2 != null) {
                        InitContext newInitContext = TitanRuntime.newInitContext();
                        newInitContext.initArgs = r2;
                        Object[] objArr = {nb9Var};
                        interceptable2.invokeUnInit(65536, newInitContext);
                        int i = newInitContext.flag;
                        if ((i & 1) != 0) {
                            int i2 = i & 2;
                            super(((Integer) newInitContext.callArgs[0]).intValue());
                            newInitContext.thisArg = this;
                            interceptable2.invokeInitBody(65536, newInitContext);
                            return;
                        }
                    }
                    this.$data = nb9Var;
                }

                /* JADX DEBUG: Return type fixed from 'java.lang.Object' to match base method */
                @Override // kotlin.jvm.functions.Function0
                public /* bridge */ /* synthetic */ Unit invoke() {
                    invoke2();
                    return Unit.INSTANCE;
                }

                /* JADX DEBUG: Possible override for method kotlin.jvm.functions.Function0.invoke()Ljava/lang/Object; */
                /* renamed from: invoke  reason: avoid collision after fix types in other method */
                public final void invoke2() {
                    Interceptable interceptable2 = $ic;
                    if (interceptable2 == null || interceptable2.invokeV(Constants.METHOD_GET_CONTACTER_INFO_FOR_SESSION, this) == null) {
                        this.$data.k(false);
                    }
                }
            });
        } else if (textView != null) {
            wb9 f4 = nb9Var.c().f();
            if (f4 != null) {
                str3 = f4.c();
            }
            textView.setText(str3);
        }
    }

    public final void t(uy5 uy5Var, BdPageContext<?> bdPageContext) {
        boolean z;
        Object obj;
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeLL(1048585, this, uy5Var, bdPageContext) == null) {
            if (StringUtils.isNull(uy5Var.g()) && StringUtils.isNotNull(uy5Var.e())) {
                Map<String, Object> d = uy5Var.d();
                if (d != null && d.containsKey("content")) {
                    z = true;
                } else {
                    z = false;
                }
                if (z) {
                    Map<String, Object> d2 = uy5Var.d();
                    if (d2 != null && (obj = d2.get("content")) != null && (obj instanceof String)) {
                        String str = (String) obj;
                        if (StringUtils.isNotNull(str)) {
                            id9 id9Var = this.b;
                            vb9<wb9> a2 = zb9.a(str);
                            Intrinsics.checkNotNullExpressionValue(a2, "genTextMsg(content)");
                            id9Var.a(a2);
                            return;
                        }
                        return;
                    }
                    return;
                }
            }
            if (bdPageContext instanceof TbPageContext) {
                String g = uy5Var.g();
                Intrinsics.checkNotNullExpressionValue(g, "span.link");
                UrlManager.getInstance().dealOneLink((TbPageContext) bdPageContext, new String[]{g});
            }
        }
    }

    public final TextTypeWriter u() {
        InterceptResult invokeV;
        Interceptable interceptable = $ic;
        if (interceptable == null || (invokeV = interceptable.invokeV(1048586, this)) == null) {
            return (TextTypeWriter) this.e.getValue();
        }
        return (TextTypeWriter) invokeV.objValue;
    }
}
