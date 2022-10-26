package com.baidu.tieba;

import android.app.Activity;
import android.content.Context;
import android.text.SpannableString;
import android.text.method.LinkMovementMethod;
import android.text.style.AbsoluteSizeSpan;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.TextView;
import com.baidu.tbadk.TbConfig;
import com.baidu.tbadk.TbPageContext;
import com.baidu.tbadk.core.TbadkCoreApplication;
import com.baidu.tbadk.core.elementsMaven.view.EMTextView;
import com.baidu.tbadk.core.util.SkinManager;
import com.baidu.tbadk.core.view.commonBtn.TBSpecificationBtn;
import com.baidu.titan.sdk.runtime.FieldHolder;
import com.baidu.titan.sdk.runtime.InitContext;
import com.baidu.titan.sdk.runtime.InterceptResult;
import com.baidu.titan.sdk.runtime.Interceptable;
import com.baidu.titan.sdk.runtime.TitanRuntime;
import java.util.Arrays;
import java.util.regex.Matcher;
import java.util.regex.Pattern;
import kotlin.jvm.internal.Intrinsics;
import kotlin.jvm.internal.StringCompanionObject;
import kotlin.text.StringsKt__StringsKt;
/* loaded from: classes5.dex */
public final class no5 {
    public static /* synthetic */ Interceptable $ic;
    public transient /* synthetic */ FieldHolder $fh;

    /* loaded from: classes5.dex */
    public final class a extends mo5 {
        public static /* synthetic */ Interceptable $ic;
        public transient /* synthetic */ FieldHolder $fh;
        public final /* synthetic */ Context a;

        public a(Context context) {
            Interceptable interceptable = $ic;
            if (interceptable != null) {
                InitContext newInitContext = TitanRuntime.newInitContext();
                newInitContext.initArgs = r2;
                Object[] objArr = {context};
                interceptable.invokeUnInit(65536, newInitContext);
                int i = newInitContext.flag;
                if ((i & 1) != 0) {
                    int i2 = i & 2;
                    newInitContext.thisArg = this;
                    interceptable.invokeInitBody(65536, newInitContext);
                    return;
                }
            }
            this.a = context;
        }

        @Override // android.text.style.ClickableSpan
        public void onClick(View widget) {
            Interceptable interceptable = $ic;
            if (interceptable == null || interceptable.invokeL(1048576, this, widget) == null) {
                Intrinsics.checkNotNullParameter(widget, "widget");
                zo4.l(this.a, Intrinsics.stringPlus(TbConfig.TIEBA_ADDRESS, "tb/mobile/wisemainstatic/secretright.html"));
            }
        }
    }

    /* loaded from: classes5.dex */
    public final class b extends mo5 {
        public static /* synthetic */ Interceptable $ic;
        public transient /* synthetic */ FieldHolder $fh;
        public final /* synthetic */ Context a;

        public b(Context context) {
            Interceptable interceptable = $ic;
            if (interceptable != null) {
                InitContext newInitContext = TitanRuntime.newInitContext();
                newInitContext.initArgs = r2;
                Object[] objArr = {context};
                interceptable.invokeUnInit(65536, newInitContext);
                int i = newInitContext.flag;
                if ((i & 1) != 0) {
                    int i2 = i & 2;
                    newInitContext.thisArg = this;
                    interceptable.invokeInitBody(65536, newInitContext);
                    return;
                }
            }
            this.a = context;
        }

        @Override // android.text.style.ClickableSpan
        public void onClick(View widget) {
            Interceptable interceptable = $ic;
            if (interceptable == null || interceptable.invokeL(1048576, this, widget) == null) {
                Intrinsics.checkNotNullParameter(widget, "widget");
                zo4.l(this.a, "https://gsp0.baidu.com/5aAHeD3nKhI2p27j8IqW0jdnxx1xbK/tb/eula.html");
            }
        }
    }

    public static final pu4 a(TbPageContext tbPageContext, View.OnClickListener listener, int i, int i2) {
        InterceptResult invokeLLII;
        Interceptable interceptable = $ic;
        if (interceptable == null || (invokeLLII = interceptable.invokeLLII(65536, null, tbPageContext, listener, i, i2)) == null) {
            Intrinsics.checkNotNullParameter(tbPageContext, "tbPageContext");
            Intrinsics.checkNotNullParameter(listener, "listener");
            View inflate = LayoutInflater.from(tbPageContext.getPageActivity()).inflate(R.layout.obfuscated_res_0x7f0d0753, (ViewGroup) null);
            Intrinsics.checkNotNullExpressionValue(inflate, "from(tbPageContext.pageA…olicy_guide_dialog, null)");
            EMTextView eMTextView = (EMTextView) inflate.findViewById(R.id.obfuscated_res_0x7f092203);
            eMTextView.setText(R.string.obfuscated_res_0x7f0f110f);
            nv4 d = nv4.d(eMTextView);
            d.A(R.string.F_X02);
            d.z(R.dimen.T_X05);
            EMTextView eMTextView2 = (EMTextView) inflate.findViewById(R.id.obfuscated_res_0x7f0906ec);
            eMTextView2.setHighlightColor(0);
            StringCompanionObject stringCompanionObject = StringCompanionObject.INSTANCE;
            String string = tbPageContext.getString(i);
            Intrinsics.checkNotNullExpressionValue(string, "tbPageContext.getString(contentTestResId)");
            String format = String.format(string, Arrays.copyOf(new Object[]{tbPageContext.getString(R.string.obfuscated_res_0x7f0f0f34), tbPageContext.getString(R.string.obfuscated_res_0x7f0f152d)}, 2));
            Intrinsics.checkNotNullExpressionValue(format, "java.lang.String.format(format, *args)");
            Activity pageActivity = tbPageContext.getPageActivity();
            Intrinsics.checkNotNullExpressionValue(pageActivity, "tbPageContext.pageActivity");
            SpannableString d2 = d(pageActivity, format);
            eMTextView2.setMovementMethod(LinkMovementMethod.getInstance());
            eMTextView2.setText(d2);
            nv4.d(eMTextView2).z(R.dimen.T_X07);
            EMTextView eMTextView3 = (EMTextView) inflate.findViewById(R.id.obfuscated_res_0x7f090419);
            eMTextView3.setText(i2);
            nv4.d(eMTextView3).z(R.dimen.T_X08);
            eMTextView3.setOnClickListener(listener);
            TBSpecificationBtn tBSpecificationBtn = (TBSpecificationBtn) inflate.findViewById(R.id.obfuscated_res_0x7f0926bd);
            tBSpecificationBtn.setText(tbPageContext.getString(R.string.obfuscated_res_0x7f0f1103));
            tBSpecificationBtn.setTextSize(R.dimen.T_X07);
            ty4 ty4Var = new ty4();
            ty4Var.p(R.color.CAM_X0303, R.color.CAM_X0101);
            tBSpecificationBtn.setConfig(ty4Var);
            tBSpecificationBtn.setOnClickListener(listener);
            pu4 pu4Var = new pu4(tbPageContext.getPageActivity());
            pu4Var.setContentView(inflate);
            pu4Var.setContentViewSize(8);
            pu4Var.setAutoNight(false);
            pu4Var.setCanceledOnTouchOutside(false);
            pu4Var.setCancelable(false);
            pu4Var.create(tbPageContext);
            return pu4Var;
        }
        return (pu4) invokeLLII.objValue;
    }

    public static final pu4 b(TbPageContext tbPageContext, View.OnClickListener listener) {
        InterceptResult invokeLL;
        Interceptable interceptable = $ic;
        if (interceptable == null || (invokeLL = interceptable.invokeLL(65537, null, tbPageContext, listener)) == null) {
            Intrinsics.checkNotNullParameter(tbPageContext, "tbPageContext");
            Intrinsics.checkNotNullParameter(listener, "listener");
            View inflate = LayoutInflater.from(tbPageContext.getPageActivity()).inflate(R.layout.obfuscated_res_0x7f0d0754, (ViewGroup) null);
            Intrinsics.checkNotNullExpressionValue(inflate, "from(tbPageContext.pageA…rivate_hint_dialog, null)");
            ((TextView) inflate.findViewById(R.id.obfuscated_res_0x7f091a8e)).setText(R.string.obfuscated_res_0x7f0f110f);
            inflate.findViewById(R.id.obfuscated_res_0x7f091ad3).setVisibility(0);
            TextView textView = (TextView) inflate.findViewById(R.id.obfuscated_res_0x7f091ad4);
            textView.setHighlightColor(0);
            StringCompanionObject stringCompanionObject = StringCompanionObject.INSTANCE;
            String string = tbPageContext.getString(R.string.obfuscated_res_0x7f0f110e);
            Intrinsics.checkNotNullExpressionValue(string, "tbPageContext.getString(…tring.secret_hint_format)");
            String format = String.format(string, Arrays.copyOf(new Object[]{tbPageContext.getString(R.string.obfuscated_res_0x7f0f110d), tbPageContext.getString(R.string.obfuscated_res_0x7f0f1112), tbPageContext.getString(R.string.obfuscated_res_0x7f0f1106), tbPageContext.getString(R.string.obfuscated_res_0x7f0f1107), tbPageContext.getString(R.string.obfuscated_res_0x7f0f1108), tbPageContext.getString(R.string.obfuscated_res_0x7f0f1109), tbPageContext.getString(R.string.obfuscated_res_0x7f0f110a)}, 7));
            Intrinsics.checkNotNullExpressionValue(format, "java.lang.String.format(format, *args)");
            Activity pageActivity = tbPageContext.getPageActivity();
            Intrinsics.checkNotNullExpressionValue(pageActivity, "tbPageContext.pageActivity");
            SpannableString d = d(pageActivity, format);
            Matcher matcher = Pattern.compile("\n\n").matcher(format);
            while (matcher.find()) {
                d.setSpan(new AbsoluteSizeSpan(2, true), matcher.start() + 1, matcher.end(), 33);
            }
            textView.setMovementMethod(LinkMovementMethod.getInstance());
            textView.setText(d);
            TextView textView2 = (TextView) inflate.findViewById(R.id.obfuscated_res_0x7f091a8a);
            textView2.setOnClickListener(listener);
            SkinManager.setViewTextColorSelector(textView2, R.color.CAM_X0110, R.color.CAM_X0110, 0);
            TextView textView3 = (TextView) inflate.findViewById(R.id.obfuscated_res_0x7f091a8f);
            textView3.setOnClickListener(listener);
            nv4 d2 = nv4.d(textView3);
            d2.n(R.string.J_X01);
            d2.f(R.color.CAM_X0303);
            SkinManager.setViewTextColorSelector(textView3, R.color.CAM_X0101, R.color.CAM_X0618, 0);
            pu4 pu4Var = new pu4(tbPageContext.getPageActivity());
            pu4Var.setContentView(inflate);
            pu4Var.setContentViewSize(7);
            pu4Var.setCanceledOnTouchOutside(false);
            pu4Var.setAutoNight(false);
            pu4Var.setCancelable(false);
            pu4Var.create(tbPageContext);
            return pu4Var;
        }
        return (pu4) invokeLL.objValue;
    }

    public static final int[] c(String str, int i) {
        InterceptResult invokeLI;
        Interceptable interceptable = $ic;
        if (interceptable == null || (invokeLI = interceptable.invokeLI(65538, null, str, i)) == null) {
            String string = TbadkCoreApplication.getInst().getString(i);
            Intrinsics.checkNotNullExpressionValue(string, "getInst().getString(patternTextResId)");
            int[] iArr = {StringsKt__StringsKt.indexOf$default((CharSequence) str, string, 0, false, 6, (Object) null), iArr[0] + string.length()};
            return iArr;
        }
        return (int[]) invokeLI.objValue;
    }

    public static final SpannableString d(Context context, String str) {
        InterceptResult invokeLL;
        Interceptable interceptable = $ic;
        if (interceptable == null || (invokeLL = interceptable.invokeLL(65539, null, context, str)) == null) {
            SpannableString spannableString = new SpannableString(str);
            int[] c = c(str, R.string.obfuscated_res_0x7f0f0f34);
            if (c[0] != -1) {
                spannableString.setSpan(new a(context), c[0], c[1], 18);
            }
            int[] c2 = c(str, R.string.obfuscated_res_0x7f0f152d);
            if (c2[0] != -1) {
                spannableString.setSpan(new b(context), c2[0], c2[1], 18);
            }
            return spannableString;
        }
        return (SpannableString) invokeLL.objValue;
    }
}
