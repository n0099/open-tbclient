package com.baidu.tieba;

import android.content.Context;
import android.text.SpannableString;
import android.text.TextUtils;
import android.text.method.LinkMovementMethod;
import android.view.View;
import android.widget.TextView;
import com.baidu.tbadk.TbPageContext;
import com.baidu.tbadk.core.TbadkCoreApplication;
import com.baidu.tbadk.core.data.ThreadData;
import com.baidu.tbadk.core.elementsMaven.EMManager;
import com.baidu.tbadk.core.util.UrlManager;
import com.baidu.tbadk.core.util.UtilHelper;
import com.baidu.tbadk.widget.ad.AbsDownloadGuide;
import com.baidu.tbadk.widget.ad.DownloadGuideFull;
import com.baidu.tbadk.widget.ad.DownloadGuidePart;
import com.baidu.tieba.view.RoundRelativeLayout;
import com.baidu.titan.sdk.runtime.FieldHolder;
import com.baidu.titan.sdk.runtime.InitContext;
import com.baidu.titan.sdk.runtime.InterceptResult;
import com.baidu.titan.sdk.runtime.Interceptable;
import com.baidu.titan.sdk.runtime.TitanRuntime;
import java.util.Arrays;
import java.util.List;
import kotlin.Unit;
import kotlin.jvm.internal.Intrinsics;
import kotlin.jvm.internal.StringCompanionObject;
import tbclient.PbContent;
import tbclient.TiebaPlusInfo;
/* loaded from: classes7.dex */
public final class oxa {
    public static /* synthetic */ Interceptable $ic;
    public transient /* synthetic */ FieldHolder $fh;

    /* loaded from: classes7.dex */
    public static final class a extends yv5 {
        public static /* synthetic */ Interceptable $ic;
        public transient /* synthetic */ FieldHolder $fh;
        public final /* synthetic */ Context a;
        public final /* synthetic */ String b;

        public a(Context context, String str) {
            Interceptable interceptable = $ic;
            if (interceptable != null) {
                InitContext newInitContext = TitanRuntime.newInitContext();
                newInitContext.initArgs = r2;
                Object[] objArr = {context, str};
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
            this.b = str;
        }

        @Override // com.baidu.tieba.yv5, android.text.style.ClickableSpan
        public void onClick(View widget) {
            Interceptable interceptable = $ic;
            if (interceptable == null || interceptable.invokeL(1048576, this, widget) == null) {
                Intrinsics.checkNotNullParameter(widget, "widget");
                super.onClick(widget);
                TbPageContext<?> tbPageContextWithContext = UtilHelper.getTbPageContextWithContext(this.a);
                if (tbPageContextWithContext != null) {
                    UrlManager.getInstance().dealOneLink(tbPageContextWithContext, new String[]{this.b});
                }
            }
        }
    }

    public static final void a(TextView policyInfo, Context context, ThreadData data) {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeLLL(65536, null, policyInfo, context, data) == null) {
            Intrinsics.checkNotNullParameter(policyInfo, "policyInfo");
            Intrinsics.checkNotNullParameter(context, "context");
            Intrinsics.checkNotNullParameter(data, "data");
            SpannableString b = b(data, context);
            if (TextUtils.isEmpty(b)) {
                policyInfo.setVisibility(8);
                return;
            }
            policyInfo.setVisibility(0);
            EMManager.from(policyInfo).setTextColor(R.color.CAM_X0619);
            policyInfo.setMovementMethod(LinkMovementMethod.getInstance());
            policyInfo.setHintTextColor(0);
            policyInfo.setText(b);
        }
    }

    public static final SpannableString b(ThreadData threadData, Context context) {
        InterceptResult invokeLL;
        TiebaPlusInfo tiebaPlusInfo;
        Integer num;
        boolean z;
        boolean z2;
        boolean z3;
        Interceptable interceptable = $ic;
        if (interceptable == null || (invokeLL = interceptable.invokeLL(65537, null, threadData, context)) == null) {
            SpannableString spannableString = new SpannableString("");
            List<PbContent> richAbstractList = threadData.getRichAbstractList();
            if (richAbstractList.isEmpty()) {
                return spannableString;
            }
            for (PbContent pbContent : richAbstractList) {
                if (pbContent != null && (tiebaPlusInfo = pbContent.tiebaplus_info) != null && (num = pbContent.type) != null && num.intValue() == 35) {
                    StringBuilder sb = new StringBuilder();
                    String str = tiebaPlusInfo.title;
                    int i = 0;
                    if (str != null && str.length() != 0) {
                        z = false;
                    } else {
                        z = true;
                    }
                    if (!z) {
                        sb.append(tiebaPlusInfo.title);
                        sb.append(" | ");
                    }
                    String str2 = tiebaPlusInfo.app_version;
                    if (str2 != null && str2.length() != 0) {
                        z2 = false;
                    } else {
                        z2 = true;
                    }
                    if (!z2) {
                        StringCompanionObject stringCompanionObject = StringCompanionObject.INSTANCE;
                        String string = TbadkCoreApplication.getInst().getString(R.string.app_version);
                        Intrinsics.checkNotNullExpressionValue(string, "getInst()\n              …ing(R.string.app_version)");
                        String format = String.format(string, Arrays.copyOf(new Object[]{tiebaPlusInfo.app_version}, 1));
                        Intrinsics.checkNotNullExpressionValue(format, "format(format, *args)");
                        sb.append(format);
                        sb.append(" | ");
                    }
                    String str3 = tiebaPlusInfo.app_company;
                    if (str3 != null && str3.length() != 0) {
                        z3 = false;
                    } else {
                        z3 = true;
                    }
                    if (!z3) {
                        sb.append(tiebaPlusInfo.app_company);
                        sb.append(" | ");
                    }
                    if (sb.length() != 0) {
                        int length = sb.length() - 1;
                        sb.append(TbadkCoreApplication.getInst().getString(R.string.app_permission));
                        int length2 = sb.length();
                        sb.append(" | ");
                        int length3 = sb.length() - 1;
                        sb.append(TbadkCoreApplication.getInst().getString(R.string.obfuscated_res_0x7f0f118e));
                        int length4 = sb.length();
                        sb.append(" | ");
                        int length5 = sb.length() - 1;
                        sb.append(TbadkCoreApplication.getInst().getString(R.string.product_function));
                        int length6 = sb.length();
                        SpannableString spannableString2 = new SpannableString(sb);
                        if (length < 0) {
                            length = 0;
                        }
                        d(spannableString2, tiebaPlusInfo.app_power, context, length, length2);
                        if (length3 < 0) {
                            length3 = 0;
                        }
                        d(spannableString2, tiebaPlusInfo.app_privacy, context, length3, length4);
                        if (length5 >= 0) {
                            i = length5;
                        }
                        d(spannableString2, tiebaPlusInfo.app_effect, context, i, length6);
                        return spannableString2;
                    }
                }
            }
            return spannableString;
        }
        return (SpannableString) invokeLL.objValue;
    }

    public static final AbsDownloadGuide c(Context context, ThreadData data, RoundRelativeLayout parentView, AbsDownloadGuide absDownloadGuide) {
        InterceptResult invokeLLLL;
        Interceptable interceptable = $ic;
        if (interceptable == null || (invokeLLLL = interceptable.invokeLLLL(65538, null, context, data, parentView, absDownloadGuide)) == null) {
            Intrinsics.checkNotNullParameter(context, "context");
            Intrinsics.checkNotNullParameter(data, "data");
            Intrinsics.checkNotNullParameter(parentView, "parentView");
            String convertBtnType = data.getConvertBtnType();
            Unit unit = null;
            if (nz4.a(data)) {
                if (Intrinsics.areEqual("a", convertBtnType)) {
                    if (!(absDownloadGuide instanceof DownloadGuidePart)) {
                        absDownloadGuide = new DownloadGuidePart(context);
                    }
                } else if (Intrinsics.areEqual("b", convertBtnType) && !(absDownloadGuide instanceof DownloadGuideFull)) {
                    absDownloadGuide = new DownloadGuideFull(context);
                }
                if (absDownloadGuide != null) {
                    absDownloadGuide.setData(data);
                    parentView.removeAllViews();
                    parentView.setRoundLayoutRadius(x25.B(R.string.J_X16));
                    parentView.addView(absDownloadGuide);
                    parentView.setVisibility(0);
                    unit = Unit.INSTANCE;
                }
                if (unit == null) {
                    parentView.setVisibility(8);
                }
                return absDownloadGuide;
            }
            parentView.setVisibility(8);
            return null;
        }
        return (AbsDownloadGuide) invokeLLLL.objValue;
    }

    public static final void d(SpannableString spannableString, String str, Context context, int i, int i2) {
        boolean z;
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeCommon(65539, null, new Object[]{spannableString, str, context, Integer.valueOf(i), Integer.valueOf(i2)}) == null) {
            if (str != null && str.length() != 0) {
                z = false;
            } else {
                z = true;
            }
            if (z) {
                return;
            }
            spannableString.setSpan(new a(context, str), i, i2, 17);
        }
    }
}
