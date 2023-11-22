package com.baidu.tieba;

import android.app.Activity;
import android.text.SpannableString;
import android.text.TextPaint;
import android.text.method.LinkMovementMethod;
import android.text.style.AbsoluteSizeSpan;
import android.text.style.ClickableSpan;
import android.text.style.ForegroundColorSpan;
import android.util.SparseArray;
import android.view.View;
import android.widget.ImageView;
import android.widget.RelativeLayout;
import android.widget.TextView;
import androidx.core.view.InputDeviceCompat;
import com.baidu.adp.lib.util.BdNetTypeUtil;
import com.baidu.adp.lib.util.BdUtilHelper;
import com.baidu.android.imsdk.internal.Constants;
import com.baidu.tbadk.TbPageContext;
import com.baidu.tbadk.core.TbadkCoreApplication;
import com.baidu.tbadk.core.data.NegativeFeedBackData;
import com.baidu.tbadk.core.data.UserData;
import com.baidu.tbadk.core.dialog.TBAlertBuilder;
import com.baidu.tbadk.core.dialog.TBAlertConfig;
import com.baidu.tbadk.core.elementsMaven.EMManager;
import com.baidu.tbadk.core.util.SkinManager;
import com.baidu.tbadk.core.util.StringHelper;
import com.baidu.tbadk.core.util.UtilHelper;
import com.baidu.tbadk.core.util.WebPManager;
import com.baidu.tieba.a16;
import com.baidu.tieba.d16;
import com.baidu.tieba.tbadkCore.model.ForumManageModel;
import com.baidu.titan.sdk.runtime.FieldHolder;
import com.baidu.titan.sdk.runtime.InitContext;
import com.baidu.titan.sdk.runtime.InterceptResult;
import com.baidu.titan.sdk.runtime.Interceptable;
import com.baidu.titan.sdk.runtime.TitanRuntime;
import kotlin.Unit;
import kotlin.jvm.functions.Function0;
import kotlin.jvm.internal.Intrinsics;
import org.json.JSONArray;
/* loaded from: classes7.dex */
public final class qj7 {
    public static /* synthetic */ Interceptable $ic;
    public transient /* synthetic */ FieldHolder $fh;

    /* loaded from: classes7.dex */
    public static final class a extends ClickableSpan {
        public static /* synthetic */ Interceptable $ic;
        public transient /* synthetic */ FieldHolder $fh;
        public final /* synthetic */ String a;
        public final /* synthetic */ Activity b;
        public final /* synthetic */ String c;
        public final /* synthetic */ lj7 d;

        public a(String str, Activity activity, String str2, lj7 lj7Var) {
            Interceptable interceptable = $ic;
            if (interceptable != null) {
                InitContext newInitContext = TitanRuntime.newInitContext();
                newInitContext.initArgs = r2;
                Object[] objArr = {str, activity, str2, lj7Var};
                interceptable.invokeUnInit(65536, newInitContext);
                int i = newInitContext.flag;
                if ((i & 1) != 0) {
                    int i2 = i & 2;
                    newInitContext.thisArg = this;
                    interceptable.invokeInitBody(65536, newInitContext);
                    return;
                }
            }
            this.a = str;
            this.b = activity;
            this.c = str2;
            this.d = lj7Var;
        }

        @Override // android.text.style.ClickableSpan
        public void onClick(View widget) {
            Interceptable interceptable = $ic;
            if (interceptable == null || interceptable.invokeL(1048576, this, widget) == null) {
                Intrinsics.checkNotNullParameter(widget, "widget");
                sj7.a(this.a, 1);
                ha7.c(this.b, this.c);
                this.d.a();
            }
        }

        @Override // android.text.style.ClickableSpan, android.text.style.CharacterStyle
        public void updateDrawState(TextPaint ds) {
            Interceptable interceptable = $ic;
            if (interceptable == null || interceptable.invokeL(Constants.METHOD_GET_CONTACTER_INFO_FOR_SESSION, this, ds) == null) {
                Intrinsics.checkNotNullParameter(ds, "ds");
                ds.setColor(SkinManager.getColor(R.color.CAM_X0306));
                ds.setUnderlineText(false);
            }
        }
    }

    public static final void a(final TbPageContext<?> tbPageContext, final ForumManageModel forumManageModel, final p57 p57Var) {
        Interceptable interceptable = $ic;
        if ((interceptable == null || interceptable.invokeLLL(65536, null, tbPageContext, forumManageModel, p57Var) == null) && tbPageContext.getPageActivity() != null && tbPageContext.getPageActivity().getWindow() != null) {
            a16 a16Var = new a16(tbPageContext, tbPageContext.getPageActivity().getWindow().getDecorView());
            a16Var.z(false);
            SparseArray<String> sparseArray = new SparseArray<>();
            for (r57 r57Var : p57Var.f()) {
                sparseArray.put(r57Var.a(), r57Var.b());
            }
            JSONArray jSONArray = new JSONArray();
            jSONArray.put(p57Var.g());
            JSONArray jSONArray2 = new JSONArray();
            jSONArray2.put(p57Var.l());
            jSONArray2.put(p57Var.e());
            NegativeFeedBackData negativeFeedBackData = new NegativeFeedBackData();
            negativeFeedBackData.setFeedBackReasonMap(sparseArray);
            negativeFeedBackData.setDeleteType(1);
            negativeFeedBackData.setTidArray(jSONArray);
            negativeFeedBackData.setMaskTidArray(jSONArray2);
            negativeFeedBackData.setFid(p57Var.b());
            a16Var.A(negativeFeedBackData);
            a16Var.B(new String[]{TbadkCoreApplication.getInst().getString(R.string.delete_thread_reason_1), TbadkCoreApplication.getInst().getString(R.string.delete_thread_reason_2), TbadkCoreApplication.getInst().getString(R.string.delete_thread_reason_3), TbadkCoreApplication.getInst().getString(R.string.delete_thread_reason_4), TbadkCoreApplication.getInst().getString(R.string.delete_thread_reason_5)});
            a16Var.D("1");
            a16Var.C(new a16.h() { // from class: com.baidu.tieba.aj7
                public static /* synthetic */ Interceptable $ic;
                public transient /* synthetic */ FieldHolder $fh;

                @Override // com.baidu.tieba.a16.h
                public final void a(JSONArray jSONArray3) {
                    Interceptable interceptable2 = $ic;
                    if (interceptable2 == null || interceptable2.invokeL(1048576, this, jSONArray3) == null) {
                        qj7.b(TbPageContext.this, p57Var, forumManageModel, jSONArray3);
                    }
                }
            });
        }
    }

    public static final void g(final TbPageContext<?> tbPageContext, final ForumManageModel forumManageModel, final p57 p57Var) {
        Interceptable interceptable = $ic;
        if ((interceptable == null || interceptable.invokeLLL(65542, null, tbPageContext, forumManageModel, p57Var) == null) && tbPageContext.getPageActivity() != null && tbPageContext.getPageActivity().getWindow() != null) {
            d16 d16Var = new d16(tbPageContext, tbPageContext.getPageActivity().getWindow().getDecorView(), k(p57Var), l(p57Var));
            d16Var.G(false);
            SparseArray<String> sparseArray = new SparseArray<>();
            for (r57 r57Var : p57Var.f()) {
                sparseArray.put(r57Var.a(), r57Var.b());
            }
            JSONArray jSONArray = new JSONArray();
            jSONArray.put(p57Var.g());
            JSONArray jSONArray2 = new JSONArray();
            jSONArray2.put(p57Var.e());
            NegativeFeedBackData negativeFeedBackData = new NegativeFeedBackData();
            negativeFeedBackData.setFeedBackReasonMap(sparseArray);
            negativeFeedBackData.setDeleteType(1);
            negativeFeedBackData.setTidArray(jSONArray);
            negativeFeedBackData.setMaskTidArray(jSONArray2);
            negativeFeedBackData.setFid(p57Var.b());
            d16Var.H(negativeFeedBackData);
            d16Var.I(new String[]{TbadkCoreApplication.getInst().getString(R.string.delete_thread_new_reason_1), TbadkCoreApplication.getInst().getString(R.string.delete_thread_new_reason_2), TbadkCoreApplication.getInst().getString(R.string.delete_thread_new_reason_3), TbadkCoreApplication.getInst().getString(R.string.delete_thread_new_reason_4), TbadkCoreApplication.getInst().getString(R.string.delete_thread_new_reason_5)});
            d16Var.K("1");
            d16Var.J(new d16.i() { // from class: com.baidu.tieba.cj7
                public static /* synthetic */ Interceptable $ic;
                public transient /* synthetic */ FieldHolder $fh;

                @Override // com.baidu.tieba.d16.i
                public final void a(JSONArray jSONArray3) {
                    Interceptable interceptable2 = $ic;
                    if (interceptable2 == null || interceptable2.invokeL(1048576, this, jSONArray3) == null) {
                        qj7.h(TbPageContext.this, p57Var, forumManageModel, jSONArray3);
                    }
                }
            });
        }
    }

    public static final void b(TbPageContext pageContext, p57 deleteThreadItemData, ForumManageModel forumManageModel, JSONArray jSONArray) {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeLLLL(65537, null, pageContext, deleteThreadItemData, forumManageModel, jSONArray) == null) {
            Intrinsics.checkNotNullParameter(pageContext, "$pageContext");
            Intrinsics.checkNotNullParameter(deleteThreadItemData, "$deleteThreadItemData");
            Intrinsics.checkNotNullParameter(forumManageModel, "$forumManageModel");
            if (!BdNetTypeUtil.isNetworkAvailableForImmediately()) {
                BdUtilHelper.showToast(pageContext.getContext(), (int) R.string.obfuscated_res_0x7f0f0e61);
                return;
            }
            String h = deleteThreadItemData.h();
            String g = deleteThreadItemData.g();
            String c = deleteThreadItemData.c();
            String b = deleteThreadItemData.b();
            boolean isCurrentAccount = UtilHelper.isCurrentAccount(h);
            if (jSONArray != null) {
                forumManageModel.j0(StringHelper.JsonArrayToString(jSONArray));
            }
            forumManageModel.k0(b, c, g, null, 0, 1, isCurrentAccount, null, false);
        }
    }

    public static final void h(TbPageContext pageContext, p57 deleteThreadItemData, ForumManageModel forumManageModel, JSONArray jSONArray) {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeLLLL(65543, null, pageContext, deleteThreadItemData, forumManageModel, jSONArray) == null) {
            Intrinsics.checkNotNullParameter(pageContext, "$pageContext");
            Intrinsics.checkNotNullParameter(deleteThreadItemData, "$deleteThreadItemData");
            Intrinsics.checkNotNullParameter(forumManageModel, "$forumManageModel");
            if (!BdNetTypeUtil.isNetworkAvailableForImmediately()) {
                BdUtilHelper.showToast(pageContext.getContext(), (int) R.string.obfuscated_res_0x7f0f0e61);
                return;
            }
            String h = deleteThreadItemData.h();
            String g = deleteThreadItemData.g();
            String c = deleteThreadItemData.c();
            String b = deleteThreadItemData.b();
            boolean isCurrentAccount = UtilHelper.isCurrentAccount(h);
            if (jSONArray != null) {
                forumManageModel.j0(StringHelper.JsonArrayToString(jSONArray));
            }
            forumManageModel.k0(b, c, g, null, 0, 1, isCurrentAccount, null, false);
        }
    }

    public static final void c(Activity activity, String errorMessage) {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeLL(65538, null, activity, errorMessage) == null) {
            Intrinsics.checkNotNullParameter(errorMessage, "errorMessage");
            if (activity == null) {
                return;
            }
            new TBAlertBuilder(activity).setDescStr(errorMessage).setDescLightStyle(true).setOperateBtn(new TBAlertConfig.OperateBtnConfig((int) R.string.dialog_known, TBAlertConfig.OperateBtnStyle.MAIN)).setAutoClose().setCancelable(false).show();
        }
    }

    public static final void d(final Activity activity, final Function0<Unit> confirm) {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeLL(65539, null, activity, confirm) == null) {
            Intrinsics.checkNotNullParameter(confirm, "confirm");
            if (activity == null) {
                return;
            }
            TBAlertConfig.OperateBtnConfig operateBtnConfig = new TBAlertConfig.OperateBtnConfig((int) R.string.obfuscated_res_0x7f0f0553, TBAlertConfig.OperateBtnStyle.MAIN, new View.OnClickListener() { // from class: com.baidu.tieba.jj7
                public static /* synthetic */ Interceptable $ic;
                public transient /* synthetic */ FieldHolder $fh;

                @Override // android.view.View.OnClickListener
                public final void onClick(View view2) {
                    Interceptable interceptable2 = $ic;
                    if (interceptable2 == null || interceptable2.invokeL(1048576, this, view2) == null) {
                        qj7.e(activity, confirm, view2);
                    }
                }
            });
            new TBAlertBuilder(activity).setTitle(R.string.del_my_thread_confirm).setDesc(R.string.del_my_thread_confirm_subtitle).setDescLightStyle(true).setOperateBtn(new TBAlertConfig.OperateBtnConfig((int) R.string.obfuscated_res_0x7f0f03d3, TBAlertConfig.OperateBtnStyle.SECONDARY), operateBtnConfig).setAutoClose().setCancelable(false).show();
        }
    }

    public static final void e(Activity activity, Function0 confirm, View view2) {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeLLL(InputDeviceCompat.SOURCE_TRACKBALL, null, activity, confirm, view2) == null) {
            Intrinsics.checkNotNullParameter(confirm, "$confirm");
            if (!BdNetTypeUtil.isNetworkAvailableForImmediately()) {
                BdUtilHelper.showToast(activity, (int) R.string.obfuscated_res_0x7f0f0e61);
            } else {
                confirm.invoke();
            }
        }
    }

    public static final void f(TbPageContext<?> pageContext, ForumManageModel forumManageModel, p57 deleteThreadItemData) {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeLLL(65541, null, pageContext, forumManageModel, deleteThreadItemData) == null) {
            Intrinsics.checkNotNullParameter(pageContext, "pageContext");
            Intrinsics.checkNotNullParameter(forumManageModel, "forumManageModel");
            Intrinsics.checkNotNullParameter(deleteThreadItemData, "deleteThreadItemData");
            if (1 == deleteThreadItemData.k()) {
                g(pageContext, forumManageModel, deleteThreadItemData);
            } else {
                a(pageContext, forumManageModel, deleteThreadItemData);
            }
        }
    }

    public static final void j(String str, lj7 alertDialogDelegate, View view2) {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeLLL(65545, null, str, alertDialogDelegate, view2) == null) {
            Intrinsics.checkNotNullParameter(alertDialogDelegate, "$alertDialogDelegate");
            sj7.a(str, 2);
            alertDialogDelegate.a();
        }
    }

    public static final void i(Activity activity, int i, String topSchema, final String str) {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeLILL(65544, null, activity, i, topSchema, str) == null) {
            Intrinsics.checkNotNullParameter(activity, "activity");
            Intrinsics.checkNotNullParameter(topSchema, "topSchema");
            sj7.b(str);
            final lj7 lj7Var = new lj7();
            RelativeLayout relativeLayout = new RelativeLayout(activity);
            View view2 = new View(activity);
            EMManager.from(view2).setCardType(1).setCorner(R.string.J_X06).setBackGroundColor(R.color.CAM_X0205);
            RelativeLayout.LayoutParams layoutParams = new RelativeLayout.LayoutParams(-1, UtilHelper.getDimenPixelSize(R.dimen.tbds229));
            layoutParams.setMargins(0, UtilHelper.getDimenPixelSize(R.dimen.tbds21), 0, 0);
            view2.setId(R.id.title_id);
            relativeLayout.addView(view2, layoutParams);
            ImageView imageView = new ImageView(activity);
            if (i >= 0) {
                imageView.setImageDrawable(WebPManager.getMaskDrawable((int) R.drawable.obfuscated_res_0x7f081515, WebPManager.ResourceStateType.NORMAL));
            } else {
                imageView.setImageDrawable(WebPManager.getMaskDrawable((int) R.drawable.obfuscated_res_0x7f081514, WebPManager.ResourceStateType.NORMAL));
            }
            RelativeLayout.LayoutParams layoutParams2 = new RelativeLayout.LayoutParams(UtilHelper.getDimenPixelSize(R.dimen.tbds420), UtilHelper.getDimenPixelSize(R.dimen.tbds115));
            layoutParams2.addRule(14);
            relativeLayout.addView(imageView, layoutParams2);
            SpannableString spannableString = new SpannableString("本月还剩 " + i + "次 置顶机会");
            spannableString.setSpan(new AbsoluteSizeSpan(UtilHelper.getDimenPixelSize(R.dimen.T_X11)), 5, spannableString.length() + (-4), 33);
            spannableString.setSpan(new ForegroundColorSpan(SkinManager.getColor(R.color.CAM_X0306)), 5, spannableString.length() + (-4), 33);
            SpannableString spannableString2 = new SpannableString("如需增加，请去提升吧主评级");
            spannableString2.setSpan(new a(str, activity, topSchema, lj7Var), 9, spannableString2.length(), 18);
            TextView textView = new TextView(activity);
            EMManager.from(textView).setTextSize(R.dimen.T_X05).setTextStyle(R.string.F_X02).setTextColor(R.color.CAM_X0105);
            RelativeLayout.LayoutParams layoutParams3 = new RelativeLayout.LayoutParams(-2, -2);
            layoutParams3.addRule(14);
            layoutParams3.addRule(8, R.id.title_id);
            layoutParams3.setMargins(0, 0, 0, UtilHelper.getDimenPixelSize(R.dimen.M_H_X005));
            if (i >= 0) {
                textView.setText(spannableString);
            } else {
                textView.setText(activity.getString(R.string.top_fail_no_times));
            }
            relativeLayout.addView(textView, layoutParams3);
            TextView textView2 = new TextView(activity);
            textView2.setMaxLines(1);
            textView2.setSingleLine();
            textView2.setGravity(17);
            EMManager.from(textView2).setTextSize(R.dimen.T_X07).setTextSelectorColor(R.color.CAM_X0306).setTextStyle(R.string.F_X01).setBorderWidth(R.dimen.L_X02).setBorderColor(R.color.CAM_X0306).setBorderAlpha(R.string.A_X07).setCorner(R.string.J_X07).setAlpha(R.string.obfuscated_res_0x7f0f000e).setBackGroundColor(R.color.CAM_X0306);
            TBAlertConfig.OperateBtnConfig operateBtnConfig = new TBAlertConfig.OperateBtnConfig("知道了", TBAlertConfig.OperateBtnStyle.CUSTOM, new View.OnClickListener() { // from class: com.baidu.tieba.zi7
                public static /* synthetic */ Interceptable $ic;
                public transient /* synthetic */ FieldHolder $fh;

                @Override // android.view.View.OnClickListener
                public final void onClick(View view3) {
                    Interceptable interceptable2 = $ic;
                    if (interceptable2 == null || interceptable2.invokeL(1048576, this, view3) == null) {
                        qj7.j(str, lj7Var, view3);
                    }
                }
            });
            operateBtnConfig.setCustomView(textView2);
            lj7Var.b(new TBAlertBuilder(activity).setDescStr(spannableString2).setCustomHeaderView(relativeLayout).setOperateBtn(operateBtnConfig).setCancelable(false).setDescMovementMethod(LinkMovementMethod.getInstance()).show());
        }
    }

    public static final c16 k(p57 p57Var) {
        InterceptResult invokeL;
        Interceptable interceptable = $ic;
        if (interceptable == null || (invokeL = interceptable.invokeL(65546, null, p57Var)) == null) {
            Intrinsics.checkNotNullParameter(p57Var, "<this>");
            c16 c16Var = new c16(p57Var.k(), p57Var.j(), p57Var.d());
            c16Var.i(p57Var.b(), p57Var.c());
            c16Var.h(p57Var.a());
            c16Var.j(p57Var.i());
            return c16Var;
        }
        return (c16) invokeL.objValue;
    }

    public static final UserData l(p57 p57Var) {
        InterceptResult invokeL;
        Interceptable interceptable = $ic;
        if (interceptable == null || (invokeL = interceptable.invokeL(65547, null, p57Var)) == null) {
            Intrinsics.checkNotNullParameter(p57Var, "<this>");
            UserData userData = new UserData();
            userData.setIsManager(p57Var.l());
            return userData;
        }
        return (UserData) invokeL.objValue;
    }
}
