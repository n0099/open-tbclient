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
import com.baidu.android.imsdk.internal.Constants;
import com.baidu.platform.comapi.map.MapBundleKey;
import com.baidu.tbadk.TbPageContext;
import com.baidu.tbadk.core.TbadkCoreApplication;
import com.baidu.tbadk.core.elementsMaven.span.EMRichTextAnyIconSpan;
import com.baidu.tbadk.core.elementsMaven.view.EMTextView;
import com.baidu.tbadk.core.util.StatisticItem;
import com.baidu.tbadk.core.util.TbadkCoreStatisticKey;
import com.baidu.tbadk.core.util.TiebaStatic;
import com.baidu.tbadk.core.util.UrlManager;
import com.baidu.tbadk.core.util.UtilHelper;
import com.baidu.tbadk.widget.richText.TbRichText;
import com.baidu.tbadk.widget.richText.TbRichTextData;
import com.baidu.tbadk.widget.richText.TbRichTextView;
import com.baidu.tieba.R;
import com.baidu.tieba.b26;
import com.baidu.tieba.cq8;
import com.baidu.tieba.eq8;
import com.baidu.tieba.gs6;
import com.baidu.tieba.impersonal.template.PersonalTextMsgTemplate;
import com.baidu.tieba.impersonal.typewriter.TextTypeWriter;
import com.baidu.tieba.l9;
import com.baidu.tieba.n55;
import com.baidu.tieba.ni;
import com.baidu.tieba.p55;
import com.baidu.tieba.r55;
import com.baidu.tieba.r9;
import com.baidu.tieba.s75;
import com.baidu.tieba.sr8;
import com.baidu.tieba.tp8;
import com.baidu.tieba.w16;
import com.baidu.tieba.xi;
import com.baidu.titan.sdk.runtime.FieldHolder;
import com.baidu.titan.sdk.runtime.InitContext;
import com.baidu.titan.sdk.runtime.InterceptResult;
import com.baidu.titan.sdk.runtime.Interceptable;
import com.baidu.titan.sdk.runtime.TitanRuntime;
import com.bumptech.glide.Glide;
import com.bumptech.glide.RequestBuilder;
import com.bumptech.glide.request.target.SimpleTarget;
import com.bumptech.glide.request.transition.Transition;
import java.util.ArrayList;
import kotlin.Lazy;
import kotlin.LazyKt__LazyJVMKt;
import kotlin.Metadata;
import kotlin.Unit;
import kotlin.jvm.functions.Function0;
import kotlin.jvm.functions.Function1;
import kotlin.jvm.internal.Intrinsics;
import org.json.JSONArray;
@Metadata(d1 = {"\u00006\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0000\n\u0002\u0010\u000e\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0002\b\u0005\n\u0002\u0010\u0002\n\u0002\b\u0007\n\u0002\u0018\u0002\n\u0002\b\u0003\u0018\u00002\u0014\u0012\u0004\u0012\u00020\u0002\u0012\u0004\u0012\u00020\u0003\u0012\u0004\u0012\u00020\u00040\u0001B\r\u0012\u0006\u0010\u0005\u001a\u00020\u0006¢\u0006\u0002\u0010\u0007J\u001a\u0010\u000e\u001a\u00020\u000f2\b\u0010\u0010\u001a\u0004\u0018\u00010\u00032\u0006\u0010\u0011\u001a\u00020\u0004H\u0016J\u001a\u0010\u0012\u001a\u00020\u000f2\b\u0010\u0010\u001a\u0004\u0018\u00010\u00032\u0006\u0010\u0011\u001a\u00020\u0004H\u0002J\u001a\u0010\u0013\u001a\u00020\u000f2\b\u0010\u0010\u001a\u0004\u0018\u00010\u00032\u0006\u0010\u0011\u001a\u00020\u0004H\u0002J\u001a\u0010\u0014\u001a\u00020\u000f2\b\u0010\u0010\u001a\u0004\u0018\u00010\u00032\u0006\u0010\u0011\u001a\u00020\u0004H\u0002J\u0010\u0010\u0015\u001a\u00020\u000f2\u0006\u0010\u0016\u001a\u00020\u0017H\u0016J\u0010\u0010\u0018\u001a\u00020\u00032\u0006\u0010\u0019\u001a\u00020\u0017H\u0016R\u001b\u0010\b\u001a\u00020\t8BX\u0082\u0084\u0002¢\u0006\f\n\u0004\b\f\u0010\r\u001a\u0004\b\n\u0010\u000b¨\u0006\u001a"}, d2 = {"Lcom/baidu/tieba/impersonal/template/PersonalTextMsgTemplate;", "Lcom/baidu/tieba/impersonal/template/BasePersonalMsgTemplate;", "Lcom/baidu/tieba/impersonal/data/TextMsgContent;", "Landroid/widget/LinearLayout;", "Lcom/baidu/tieba/impersonal/components/uistate/PersonalTextMsgUiState;", "name", "", "(Ljava/lang/String;)V", "textTypeWriter", "Lcom/baidu/tieba/impersonal/typewriter/TextTypeWriter;", "getTextTypeWriter", "()Lcom/baidu/tieba/impersonal/typewriter/TextTypeWriter;", "textTypeWriter$delegate", "Lkotlin/Lazy;", "bindChild", "", MapBundleKey.OfflineMapKey.OFFLINE_CHILD, "data", "bindCopy", "bindRichText", "bindText", "configContainer", "container", "Landroid/view/ViewGroup;", "createChild", "parent", "im-personal_release"}, k = 1, mv = {1, 6, 0}, xi = 48)
/* loaded from: classes6.dex */
public final class PersonalTextMsgTemplate extends sr8<cq8, LinearLayout, tp8> {
    public static /* synthetic */ Interceptable $ic;
    public transient /* synthetic */ FieldHolder $fh;
    public final Lazy b;

    /* loaded from: classes6.dex */
    public static final class a implements TbRichTextView.t {
        public static /* synthetic */ Interceptable $ic;
        public transient /* synthetic */ FieldHolder $fh;
        public final /* synthetic */ LinearLayout a;

        /* renamed from: com.baidu.tieba.impersonal.template.PersonalTextMsgTemplate$a$a  reason: collision with other inner class name */
        /* loaded from: classes6.dex */
        public static final class C0353a extends SimpleTarget<Drawable> {
            public static /* synthetic */ Interceptable $ic;
            public transient /* synthetic */ FieldHolder $fh;
            public final /* synthetic */ EMRichTextAnyIconSpan a;
            public final /* synthetic */ TextView b;

            public C0353a(EMRichTextAnyIconSpan eMRichTextAnyIconSpan, TextView textView) {
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

        public a(LinearLayout linearLayout) {
            Interceptable interceptable = $ic;
            if (interceptable != null) {
                InitContext newInitContext = TitanRuntime.newInitContext();
                newInitContext.initArgs = r2;
                Object[] objArr = {linearLayout};
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
        }

        public static final void a(b26[] b26VarArr) {
            Interceptable interceptable = $ic;
            if ((interceptable == null || interceptable.invokeL(65537, null, b26VarArr) == null) && b26VarArr != null) {
                for (b26 b26Var : b26VarArr) {
                    TiebaStatic.log(new StatisticItem(TbadkCoreStatisticKey.GROUP_CHAT_RICHTEXT_LINK_EXPOSE_KEY).param("uid", TbadkCoreApplication.getCurrentAccount()).param("obj_type", b26Var.e()));
                }
            }
        }

        public static final void b(TbRichTextView tbRichTextView, b26 b26Var) {
            Context context;
            boolean z;
            Interceptable interceptable = $ic;
            if (interceptable == null || interceptable.invokeLL(65538, null, tbRichTextView, b26Var) == null) {
                if (tbRichTextView != null) {
                    context = tbRichTextView.getContext();
                } else {
                    context = null;
                }
                l9<?> a = r9.a(context);
                if (a == null) {
                    z = true;
                } else {
                    z = a instanceof TbPageContext;
                }
                if (z) {
                    String d = b26Var.d();
                    Intrinsics.checkNotNullExpressionValue(d, "it.link");
                    UrlManager.getInstance().dealOneLink((TbPageContext) a, new String[]{d});
                }
                TiebaStatic.log(new StatisticItem(TbadkCoreStatisticKey.GROUP_CHAT_RICHTEXT_LINK_CLICK_KEY).param("uid", TbadkCoreApplication.getCurrentAccount()).param("obj_type", b26Var.e()));
            }
        }

        @Override // com.baidu.tbadk.widget.richText.TbRichTextView.t
        public void D0(SpannableStringBuilder spannableStringBuilder, TextView textView, final TbRichTextView tbRichTextView) {
            EMRichTextAnyIconSpan[] eMRichTextAnyIconSpanArr;
            final b26[] b26VarArr;
            TbRichText richText;
            ArrayList<TbRichTextData> W;
            Interceptable interceptable = $ic;
            if (interceptable == null || interceptable.invokeLLL(1048576, this, spannableStringBuilder, textView, tbRichTextView) == null) {
                if (tbRichTextView != null && (richText = tbRichTextView.getRichText()) != null && (W = richText.W()) != null) {
                    for (TbRichTextData tbRichTextData : W) {
                        tbRichTextData.u0(false);
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
                            Glide.with(TbadkCoreApplication.getInst()).load(eMRichTextAnyIconSpan.b()).into((RequestBuilder<Drawable>) new C0353a(eMRichTextAnyIconSpan, textView));
                        }
                    }
                }
                if (spannableStringBuilder != null) {
                    b26VarArr = (b26[]) spannableStringBuilder.getSpans(0, spannableStringBuilder.length(), b26.class);
                } else {
                    b26VarArr = null;
                }
                LinearLayout linearLayout = this.a;
                Object tag = linearLayout.getTag();
                if (tag instanceof Runnable) {
                    runnable = (Runnable) tag;
                }
                linearLayout.removeCallbacks(runnable);
                Runnable runnable2 = new Runnable() { // from class: com.baidu.tieba.or8
                    public static /* synthetic */ Interceptable $ic;
                    public transient /* synthetic */ FieldHolder $fh;

                    @Override // java.lang.Runnable
                    public final void run() {
                        Interceptable interceptable2 = $ic;
                        if (interceptable2 == null || interceptable2.invokeV(1048576, this) == null) {
                            PersonalTextMsgTemplate.a.a(b26VarArr);
                        }
                    }
                };
                this.a.setTag(runnable2);
                this.a.postDelayed(runnable2, 500L);
                if (b26VarArr != null) {
                    for (b26 b26Var : b26VarArr) {
                        b26Var.i(new b26.b() { // from class: com.baidu.tieba.nr8
                            public static /* synthetic */ Interceptable $ic;
                            public transient /* synthetic */ FieldHolder $fh;

                            @Override // com.baidu.tieba.b26.b
                            public final void a(b26 b26Var2) {
                                Interceptable interceptable2 = $ic;
                                if (interceptable2 == null || interceptable2.invokeL(1048576, this, b26Var2) == null) {
                                    PersonalTextMsgTemplate.a.b(TbRichTextView.this, b26Var2);
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
                gs6.b().b(new eq8(i));
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
    public PersonalTextMsgTemplate(String name) {
        super(name);
        Interceptable interceptable = $ic;
        if (interceptable != null) {
            InitContext newInitContext = TitanRuntime.newInitContext();
            newInitContext.initArgs = r2;
            Object[] objArr = {name};
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
        this.b = LazyKt__LazyJVMKt.lazy(PersonalTextMsgTemplate$textTypeWriter$2.INSTANCE);
    }

    public static final boolean m(LinearLayout linearLayout, final tp8 data, View view2) {
        InterceptResult invokeLLL;
        Interceptable interceptable = $ic;
        if (interceptable == null || (invokeLLL = interceptable.invokeLLL(65537, null, linearLayout, data, view2)) == null) {
            Intrinsics.checkNotNullParameter(data, "$data");
            r55 r55Var = new r55(linearLayout.getContext());
            ArrayList arrayList = new ArrayList();
            arrayList.add(new n55(0, TbadkCoreApplication.getInst().getString(R.string.obfuscated_res_0x7f0f04de), r55Var));
            r55Var.l(arrayList);
            l9<?> a2 = r9.a(linearLayout.getContext());
            if (a2 == null) {
                return true;
            }
            final p55 p55Var = new p55(a2, r55Var);
            r55Var.q(new r55.f() { // from class: com.baidu.tieba.qr8
                public static /* synthetic */ Interceptable $ic;
                public transient /* synthetic */ FieldHolder $fh;

                @Override // com.baidu.tieba.r55.f
                public final void M0(r55 r55Var2, int i, View view3) {
                    Interceptable interceptable2 = $ic;
                    if (interceptable2 == null || interceptable2.invokeLIL(1048576, this, r55Var2, i, view3) == null) {
                        PersonalTextMsgTemplate.n(p55.this, data, r55Var2, i, view3);
                    }
                }
            });
            p55Var.l();
            return true;
        }
        return invokeLLL.booleanValue;
    }

    public static final void n(p55 dialog, tp8 data, r55 r55Var, int i, View view2) {
        String str;
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeCommon(65538, null, new Object[]{dialog, data, r55Var, Integer.valueOf(i), view2}) == null) {
            Intrinsics.checkNotNullParameter(dialog, "$dialog");
            Intrinsics.checkNotNullParameter(data, "$data");
            dialog.dismiss();
            cq8 f = data.c().f();
            if (f != null) {
                str = f.a();
            } else {
                str = null;
            }
            ni.a(str);
        }
    }

    /* JADX DEBUG: Method merged with bridge method */
    @Override // com.baidu.tieba.sr8
    /* renamed from: k */
    public void d(LinearLayout linearLayout, tp8 data) {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeLL(1048579, this, linearLayout, data) == null) {
            Intrinsics.checkNotNullParameter(data, "data");
            p(linearLayout, data);
            o(linearLayout, data);
            l(linearLayout, data);
        }
    }

    public final void l(final LinearLayout linearLayout, final tp8 tp8Var) {
        Interceptable interceptable = $ic;
        if ((interceptable == null || interceptable.invokeLL(1048580, this, linearLayout, tp8Var) == null) && linearLayout != null && linearLayout.getContext() != null) {
            linearLayout.setOnLongClickListener(new View.OnLongClickListener() { // from class: com.baidu.tieba.pr8
                public static /* synthetic */ Interceptable $ic;
                public transient /* synthetic */ FieldHolder $fh;

                @Override // android.view.View.OnLongClickListener
                public final boolean onLongClick(View view2) {
                    InterceptResult invokeL;
                    Interceptable interceptable2 = $ic;
                    return (interceptable2 == null || (invokeL = interceptable2.invokeL(1048576, this, view2)) == null) ? PersonalTextMsgTemplate.m(linearLayout, tp8Var, view2) : invokeL.booleanValue;
                }
            });
        }
    }

    @Override // com.baidu.tieba.sr8
    public void f(ViewGroup container) {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeL(Constants.METHOD_GET_CONTACTER_INFO_FOR_SESSION, this, container) == null) {
            Intrinsics.checkNotNullParameter(container, "container");
            super.f(container);
            int g = xi.g(container.getContext(), R.dimen.M_H_X003);
            int g2 = xi.g(container.getContext(), R.dimen.M_H_X003);
            int g3 = xi.g(container.getContext(), R.dimen.M_W_X004);
            int g4 = xi.g(container.getContext(), R.dimen.M_W_X004);
            if (j()) {
                g = xi.g(container.getContext(), R.dimen.M_H_X005);
            }
            container.setPadding(g3, g, g4, g2);
        }
    }

    /* JADX DEBUG: Method merged with bridge method */
    @Override // com.baidu.tieba.sr8
    /* renamed from: q */
    public LinearLayout g(ViewGroup parent) {
        InterceptResult invokeL;
        Interceptable interceptable = $ic;
        if (interceptable == null || (invokeL = interceptable.invokeL(1048583, this, parent)) == null) {
            Intrinsics.checkNotNullParameter(parent, "parent");
            LinearLayout linearLayout = new LinearLayout(parent.getContext());
            linearLayout.setOrientation(1);
            return linearLayout;
        }
        return (LinearLayout) invokeL.objValue;
    }

    public final void o(LinearLayout linearLayout, tp8 tp8Var) {
        JSONArray jSONArray;
        JSONArray jSONArray2;
        Interceptable interceptable = $ic;
        if ((interceptable != null && interceptable.invokeLL(1048581, this, linearLayout, tp8Var) != null) || linearLayout == null) {
            return;
        }
        TbRichTextView tbRichTextView = (TbRichTextView) linearLayout.findViewById(R.id.obfuscated_res_0x7f091c0d);
        JSONArray jSONArray3 = null;
        if (tbRichTextView != null) {
            cq8 f = tp8Var.c().f();
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
            cq8 f2 = tp8Var.c().f();
            if (f2 != null) {
                jSONArray = f2.b();
            } else {
                jSONArray = null;
            }
            if (jSONArray != null) {
                tbRichTextView = new TbRichTextView(linearLayout.getContext());
                ViewGroup.LayoutParams layoutParams = new LinearLayout.LayoutParams(-2, -2);
                w16 w16Var = new w16();
                w16Var.x(xi.g(linearLayout.getContext(), R.dimen.T_X05));
                w16Var.p(xi.g(TbadkCoreApplication.getInst().getContext(), R.dimen.M_H_X002), 1.0f);
                w16Var.j(xi.g(TbadkCoreApplication.getInst().getContext(), R.dimen.tbds42), xi.g(TbadkCoreApplication.getInst().getContext(), R.dimen.tbds42));
                tbRichTextView.setLayoutStrategy(w16Var);
                tbRichTextView.setId(R.id.obfuscated_res_0x7f091c0d);
                tbRichTextView.setPadding(xi.g(linearLayout.getContext(), R.dimen.M_W_X006), xi.g(linearLayout.getContext(), R.dimen.M_H_X004), xi.g(linearLayout.getContext(), R.dimen.M_W_X006), xi.g(linearLayout.getContext(), R.dimen.M_H_X004));
                linearLayout.addView(tbRichTextView, layoutParams);
            }
        }
        if (tbRichTextView != null) {
            cq8 f3 = tp8Var.c().f();
            if (f3 != null) {
                jSONArray3 = f3.b();
            }
            tbRichTextView.setText(TbRichTextView.Y(jSONArray3, 19), false, new a(linearLayout));
        }
    }

    public final void p(LinearLayout linearLayout, final tp8 tp8Var) {
        String str;
        String str2;
        Interceptable interceptable = $ic;
        if ((interceptable != null && interceptable.invokeLL(1048582, this, linearLayout, tp8Var) != null) || linearLayout == null) {
            return;
        }
        TextView textView = (TextView) linearLayout.findViewById(R.id.obfuscated_res_0x7f091c0e);
        String str3 = null;
        if (textView != null) {
            cq8 f = tp8Var.c().f();
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
            cq8 f2 = tp8Var.c().f();
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
                textView.setPadding(xi.g(linearLayout.getContext(), R.dimen.M_W_X006), xi.g(linearLayout.getContext(), R.dimen.M_H_X005), xi.g(linearLayout.getContext(), R.dimen.M_W_X006), xi.g(linearLayout.getContext(), R.dimen.M_H_X005));
                s75 d = s75.d(textView);
                d.C(R.dimen.T_X05);
                d.z(R.dimen.M_T_X002);
                textView.setId(R.id.obfuscated_res_0x7f091c0e);
                linearLayout.addView(textView, new LinearLayout.LayoutParams(-2, -2));
            }
        }
        if (tp8Var.j()) {
            TextTypeWriter r = r();
            cq8 f3 = tp8Var.c().f();
            r.n(textView, (f3 == null || (r0 = f3.c()) == null) ? "" : "", new b(), new Function0<Unit>(tp8Var) { // from class: com.baidu.tieba.impersonal.template.PersonalTextMsgTemplate$bindText$2
                public static /* synthetic */ Interceptable $ic;
                public final /* synthetic */ tp8 $data;
                public transient /* synthetic */ FieldHolder $fh;

                /* JADX WARN: 'super' call moved to the top of the method (can break code semantics) */
                {
                    super(0);
                    Interceptable interceptable2 = $ic;
                    if (interceptable2 != null) {
                        InitContext newInitContext = TitanRuntime.newInitContext();
                        newInitContext.initArgs = r2;
                        Object[] objArr = {tp8Var};
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
                    this.$data = tp8Var;
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
            cq8 f4 = tp8Var.c().f();
            if (f4 != null) {
                str3 = f4.c();
            }
            textView.setText(str3);
        }
    }

    public final TextTypeWriter r() {
        InterceptResult invokeV;
        Interceptable interceptable = $ic;
        if (interceptable == null || (invokeV = interceptable.invokeV(InputDeviceCompat.SOURCE_TOUCHPAD, this)) == null) {
            return (TextTypeWriter) this.b.getValue();
        }
        return (TextTypeWriter) invokeV.objValue;
    }
}
