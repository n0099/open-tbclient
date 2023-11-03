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
import com.baidu.tieba.c16;
import com.baidu.tieba.tbadkCore.model.ForumManageModel;
import com.baidu.tieba.z06;
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
public final class pj7 {
    public static /* synthetic */ Interceptable $ic;
    public transient /* synthetic */ FieldHolder $fh;

    /* loaded from: classes7.dex */
    public static final class a extends ClickableSpan {
        public static /* synthetic */ Interceptable $ic;
        public transient /* synthetic */ FieldHolder $fh;
        public final /* synthetic */ String a;
        public final /* synthetic */ Activity b;
        public final /* synthetic */ String c;
        public final /* synthetic */ kj7 d;

        public a(String str, Activity activity, String str2, kj7 kj7Var) {
            Interceptable interceptable = $ic;
            if (interceptable != null) {
                InitContext newInitContext = TitanRuntime.newInitContext();
                newInitContext.initArgs = r2;
                Object[] objArr = {str, activity, str2, kj7Var};
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
            this.d = kj7Var;
        }

        @Override // android.text.style.ClickableSpan
        public void onClick(View widget) {
            Interceptable interceptable = $ic;
            if (interceptable == null || interceptable.invokeL(1048576, this, widget) == null) {
                Intrinsics.checkNotNullParameter(widget, "widget");
                rj7.a(this.a, 1);
                ga7.c(this.b, this.c);
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

    public static final void a(final TbPageContext<?> tbPageContext, final ForumManageModel forumManageModel, final o57 o57Var) {
        Interceptable interceptable = $ic;
        if ((interceptable == null || interceptable.invokeLLL(65536, null, tbPageContext, forumManageModel, o57Var) == null) && tbPageContext.getPageActivity() != null && tbPageContext.getPageActivity().getWindow() != null) {
            z06 z06Var = new z06(tbPageContext, tbPageContext.getPageActivity().getWindow().getDecorView());
            z06Var.z(false);
            SparseArray<String> sparseArray = new SparseArray<>();
            for (q57 q57Var : o57Var.f()) {
                sparseArray.put(q57Var.a(), q57Var.b());
            }
            JSONArray jSONArray = new JSONArray();
            jSONArray.put(o57Var.g());
            JSONArray jSONArray2 = new JSONArray();
            jSONArray2.put(o57Var.l());
            jSONArray2.put(o57Var.e());
            NegativeFeedBackData negativeFeedBackData = new NegativeFeedBackData();
            negativeFeedBackData.setFeedBackReasonMap(sparseArray);
            negativeFeedBackData.setDeleteType(1);
            negativeFeedBackData.setTidArray(jSONArray);
            negativeFeedBackData.setMaskTidArray(jSONArray2);
            negativeFeedBackData.setFid(o57Var.b());
            z06Var.A(negativeFeedBackData);
            z06Var.B(new String[]{TbadkCoreApplication.getInst().getString(R.string.delete_thread_reason_1), TbadkCoreApplication.getInst().getString(R.string.delete_thread_reason_2), TbadkCoreApplication.getInst().getString(R.string.delete_thread_reason_3), TbadkCoreApplication.getInst().getString(R.string.delete_thread_reason_4), TbadkCoreApplication.getInst().getString(R.string.delete_thread_reason_5)});
            z06Var.D("1");
            z06Var.C(new z06.h() { // from class: com.baidu.tieba.zi7
                public static /* synthetic */ Interceptable $ic;
                public transient /* synthetic */ FieldHolder $fh;

                @Override // com.baidu.tieba.z06.h
                public final void a(JSONArray jSONArray3) {
                    Interceptable interceptable2 = $ic;
                    if (interceptable2 == null || interceptable2.invokeL(1048576, this, jSONArray3) == null) {
                        pj7.b(TbPageContext.this, o57Var, forumManageModel, jSONArray3);
                    }
                }
            });
        }
    }

    public static final void g(final TbPageContext<?> tbPageContext, final ForumManageModel forumManageModel, final o57 o57Var) {
        Interceptable interceptable = $ic;
        if ((interceptable == null || interceptable.invokeLLL(65542, null, tbPageContext, forumManageModel, o57Var) == null) && tbPageContext.getPageActivity() != null && tbPageContext.getPageActivity().getWindow() != null) {
            c16 c16Var = new c16(tbPageContext, tbPageContext.getPageActivity().getWindow().getDecorView(), k(o57Var), l(o57Var));
            c16Var.G(false);
            SparseArray<String> sparseArray = new SparseArray<>();
            for (q57 q57Var : o57Var.f()) {
                sparseArray.put(q57Var.a(), q57Var.b());
            }
            JSONArray jSONArray = new JSONArray();
            jSONArray.put(o57Var.g());
            JSONArray jSONArray2 = new JSONArray();
            jSONArray2.put(o57Var.e());
            NegativeFeedBackData negativeFeedBackData = new NegativeFeedBackData();
            negativeFeedBackData.setFeedBackReasonMap(sparseArray);
            negativeFeedBackData.setDeleteType(1);
            negativeFeedBackData.setTidArray(jSONArray);
            negativeFeedBackData.setMaskTidArray(jSONArray2);
            negativeFeedBackData.setFid(o57Var.b());
            c16Var.H(negativeFeedBackData);
            c16Var.I(new String[]{TbadkCoreApplication.getInst().getString(R.string.delete_thread_new_reason_1), TbadkCoreApplication.getInst().getString(R.string.delete_thread_new_reason_2), TbadkCoreApplication.getInst().getString(R.string.delete_thread_new_reason_3), TbadkCoreApplication.getInst().getString(R.string.delete_thread_new_reason_4), TbadkCoreApplication.getInst().getString(R.string.delete_thread_new_reason_5)});
            c16Var.K("1");
            c16Var.J(new c16.i() { // from class: com.baidu.tieba.bj7
                public static /* synthetic */ Interceptable $ic;
                public transient /* synthetic */ FieldHolder $fh;

                @Override // com.baidu.tieba.c16.i
                public final void a(JSONArray jSONArray3) {
                    Interceptable interceptable2 = $ic;
                    if (interceptable2 == null || interceptable2.invokeL(1048576, this, jSONArray3) == null) {
                        pj7.h(TbPageContext.this, o57Var, forumManageModel, jSONArray3);
                    }
                }
            });
        }
    }

    public static final void b(TbPageContext pageContext, o57 deleteThreadItemData, ForumManageModel forumManageModel, JSONArray jSONArray) {
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

    public static final void h(TbPageContext pageContext, o57 deleteThreadItemData, ForumManageModel forumManageModel, JSONArray jSONArray) {
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
            TBAlertConfig.OperateBtnConfig operateBtnConfig = new TBAlertConfig.OperateBtnConfig((int) R.string.obfuscated_res_0x7f0f0553, TBAlertConfig.OperateBtnStyle.MAIN, new View.OnClickListener() { // from class: com.baidu.tieba.ij7
                public static /* synthetic */ Interceptable $ic;
                public transient /* synthetic */ FieldHolder $fh;

                @Override // android.view.View.OnClickListener
                public final void onClick(View view2) {
                    Interceptable interceptable2 = $ic;
                    if (interceptable2 == null || interceptable2.invokeL(1048576, this, view2) == null) {
                        pj7.e(activity, confirm, view2);
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

    public static final void f(TbPageContext<?> pageContext, ForumManageModel forumManageModel, o57 deleteThreadItemData) {
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

    public static final void j(String str, kj7 alertDialogDelegate, View view2) {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeLLL(65545, null, str, alertDialogDelegate, view2) == null) {
            Intrinsics.checkNotNullParameter(alertDialogDelegate, "$alertDialogDelegate");
            rj7.a(str, 2);
            alertDialogDelegate.a();
        }
    }

    public static final void i(Activity activity, int i, String topSchema, final String str) {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeLILL(65544, null, activity, i, topSchema, str) == null) {
            Intrinsics.checkNotNullParameter(activity, "activity");
            Intrinsics.checkNotNullParameter(topSchema, "topSchema");
            rj7.b(str);
            final kj7 kj7Var = new kj7();
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
            spannableString2.setSpan(new a(str, activity, topSchema, kj7Var), 9, spannableString2.length(), 18);
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
            TBAlertConfig.OperateBtnConfig operateBtnConfig = new TBAlertConfig.OperateBtnConfig("知道了", TBAlertConfig.OperateBtnStyle.CUSTOM, new View.OnClickListener() { // from class: com.baidu.tieba.yi7
                public static /* synthetic */ Interceptable $ic;
                public transient /* synthetic */ FieldHolder $fh;

                @Override // android.view.View.OnClickListener
                public final void onClick(View view3) {
                    Interceptable interceptable2 = $ic;
                    if (interceptable2 == null || interceptable2.invokeL(1048576, this, view3) == null) {
                        pj7.j(str, kj7Var, view3);
                    }
                }
            });
            operateBtnConfig.setCustomView(textView2);
            kj7Var.b(new TBAlertBuilder(activity).setDescStr(spannableString2).setCustomHeaderView(relativeLayout).setOperateBtn(operateBtnConfig).setCancelable(false).setDescMovementMethod(LinkMovementMethod.getInstance()).show());
        }
    }

    public static final b16 k(o57 o57Var) {
        InterceptResult invokeL;
        Interceptable interceptable = $ic;
        if (interceptable == null || (invokeL = interceptable.invokeL(65546, null, o57Var)) == null) {
            Intrinsics.checkNotNullParameter(o57Var, "<this>");
            b16 b16Var = new b16(o57Var.k(), o57Var.j(), o57Var.d());
            b16Var.i(o57Var.b(), o57Var.c());
            b16Var.h(o57Var.a());
            b16Var.j(o57Var.i());
            return b16Var;
        }
        return (b16) invokeL.objValue;
    }

    public static final UserData l(o57 o57Var) {
        InterceptResult invokeL;
        Interceptable interceptable = $ic;
        if (interceptable == null || (invokeL = interceptable.invokeL(65547, null, o57Var)) == null) {
            Intrinsics.checkNotNullParameter(o57Var, "<this>");
            UserData userData = new UserData();
            userData.setIsManager(o57Var.l());
            return userData;
        }
        return (UserData) invokeL.objValue;
    }
}
