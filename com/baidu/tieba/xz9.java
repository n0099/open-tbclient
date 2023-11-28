package com.baidu.tieba;

import android.text.TextUtils;
import android.util.SparseArray;
import android.view.View;
import androidx.annotation.StringRes;
import androidx.appcompat.app.AlertDialog;
import androidx.core.view.InputDeviceCompat;
import com.baidu.adp.lib.util.BdNetTypeUtil;
import com.baidu.adp.lib.util.BdUtilHelper;
import com.baidu.adp.lib.util.StringUtils;
import com.baidu.android.imsdk.internal.Constants;
import com.baidu.tbadk.TbPageContext;
import com.baidu.tbadk.core.data.AntiData;
import com.baidu.tbadk.core.data.DeleteThreadInfo;
import com.baidu.tbadk.core.data.NegativeFeedBackData;
import com.baidu.tbadk.core.data.UserData;
import com.baidu.tbadk.core.dialog.TBAlertBuilder;
import com.baidu.tbadk.core.dialog.TBAlertConfig;
import com.baidu.tieba.c05;
import com.baidu.tieba.h16;
import com.baidu.tieba.k16;
import com.baidu.tieba.pb.pb.main.PbModel;
import com.baidu.titan.sdk.runtime.FieldHolder;
import com.baidu.titan.sdk.runtime.InitContext;
import com.baidu.titan.sdk.runtime.InterceptResult;
import com.baidu.titan.sdk.runtime.Interceptable;
import com.baidu.titan.sdk.runtime.TitanRuntime;
import java.util.List;
import kotlin.jvm.internal.Intrinsics;
import org.json.JSONArray;
/* loaded from: classes9.dex */
public final class xz9 {
    public static /* synthetic */ Interceptable $ic;
    public transient /* synthetic */ FieldHolder $fh;
    public final TbPageContext<?> a;
    public final PbModel b;
    public a c;
    public final int d;
    public c05 e;
    public h16 f;
    public k16 g;

    /* loaded from: classes9.dex */
    public interface a {
        void a(c05 c05Var, JSONArray jSONArray);

        void b(c05 c05Var);

        void c(SparseArray<Object> sparseArray, JSONArray jSONArray);
    }

    public xz9(TbPageContext<?> pageContext, PbModel pbModel) {
        Interceptable interceptable = $ic;
        if (interceptable != null) {
            InitContext newInitContext = TitanRuntime.newInitContext();
            newInitContext.initArgs = r2;
            Object[] objArr = {pageContext, pbModel};
            interceptable.invokeUnInit(65536, newInitContext);
            int i = newInitContext.flag;
            if ((i & 1) != 0) {
                int i2 = i & 2;
                newInitContext.thisArg = this;
                interceptable.invokeInitBody(65536, newInitContext);
                return;
            }
        }
        Intrinsics.checkNotNullParameter(pageContext, "pageContext");
        Intrinsics.checkNotNullParameter(pbModel, "pbModel");
        this.a = pageContext;
        this.b = pbModel;
        this.d = 1;
    }

    public static final void c(xz9 this$0, c05 c05Var) {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeLL(65537, null, this$0, c05Var) == null) {
            Intrinsics.checkNotNullParameter(this$0, "this$0");
            a aVar = this$0.c;
            if (aVar != null) {
                aVar.b(c05Var);
            }
        }
    }

    public static final void j(AlertDialog alertDialog, View view2) {
        Interceptable interceptable = $ic;
        if ((interceptable == null || interceptable.invokeLL(InputDeviceCompat.SOURCE_TRACKBALL, null, alertDialog, view2) == null) && alertDialog != null) {
            alertDialog.dismiss();
        }
    }

    public static final void n(AlertDialog alertDialog, View view2) {
        Interceptable interceptable = $ic;
        if ((interceptable == null || interceptable.invokeLL(65542, null, alertDialog, view2) == null) && alertDialog != null) {
            alertDialog.dismiss();
        }
    }

    public static final void d(c05 c05Var) {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeL(65538, null, c05Var) == null) {
            Intrinsics.checkNotNull(c05Var);
            c05Var.dismiss();
        }
    }

    public final void f(a listener) {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeL(1048579, this, listener) == null) {
            Intrinsics.checkNotNullParameter(listener, "listener");
            this.c = listener;
        }
    }

    public static final void i(AlertDialog alertDialog, xz9 this$0, SparseArray sparseArray, View view2) {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeLLLL(65539, null, alertDialog, this$0, sparseArray, view2) == null) {
            Intrinsics.checkNotNullParameter(this$0, "this$0");
            if (alertDialog != null) {
                alertDialog.dismiss();
            }
            if (!BdNetTypeUtil.isNetworkAvailableForImmediately()) {
                BdUtilHelper.showToast(this$0.a.getPageActivity(), (int) R.string.obfuscated_res_0x7f0f0e6f);
                return;
            }
            a aVar = this$0.c;
            if (aVar != null) {
                aVar.c(sparseArray, null);
            }
        }
    }

    public static final void m(AlertDialog alertDialog, xz9 this$0, SparseArray delTags, View view2) {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeLLLL(65541, null, alertDialog, this$0, delTags, view2) == null) {
            Intrinsics.checkNotNullParameter(this$0, "this$0");
            Intrinsics.checkNotNullParameter(delTags, "$delTags");
            if (alertDialog != null) {
                alertDialog.dismiss();
            }
            if (!BdNetTypeUtil.isNetworkAvailableForImmediately()) {
                BdUtilHelper.showToast(this$0.a.getPageActivity(), (int) R.string.obfuscated_res_0x7f0f0e6f);
                return;
            }
            a aVar = this$0.c;
            if (aVar != null) {
                aVar.c(delTags, null);
            }
        }
    }

    public static final void p(xz9 this$0, SparseArray sparseArray, JSONArray jSONArray) {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeLLL(65543, null, this$0, sparseArray, jSONArray) == null) {
            Intrinsics.checkNotNullParameter(this$0, "this$0");
            a aVar = this$0.c;
            if (aVar != null) {
                aVar.c(sparseArray, jSONArray);
            }
        }
    }

    public static final void r(xz9 this$0, c05 c05Var, JSONArray jSONArray) {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeLLL(65544, null, this$0, c05Var, jSONArray) == null) {
            Intrinsics.checkNotNullParameter(this$0, "this$0");
            a aVar = this$0.c;
            if (aVar != null) {
                aVar.a(c05Var, jSONArray);
            }
        }
    }

    public final void a() {
        c05 c05Var;
        Interceptable interceptable = $ic;
        if ((interceptable == null || interceptable.invokeV(1048576, this) == null) && (c05Var = this.e) != null) {
            c05Var.dismiss();
        }
    }

    public final void b(View view2, int i, String str, int i2, boolean z, String str2, boolean z2) {
        int i3;
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeCommon(Constants.METHOD_GET_CONTACTER_INFO_FOR_SESSION, this, new Object[]{view2, Integer.valueOf(i), str, Integer.valueOf(i2), Boolean.valueOf(z), str2, Boolean.valueOf(z2)}) == null) {
            SparseArray<Object> sparseArray = new SparseArray<>();
            sparseArray.put(R.id.tag_del_post_id, str);
            sparseArray.put(R.id.tag_del_post_type, Integer.valueOf(i));
            sparseArray.put(R.id.tag_manage_user_identity, Integer.valueOf(i2));
            sparseArray.put(R.id.tag_del_post_is_self, Boolean.valueOf(z));
            sparseArray.put(j1a.i2, Integer.valueOf(j1a.j2));
            if (i2 == 1002 && !z) {
                i3 = R.string.report_post_confirm;
            } else {
                i3 = R.string.del_all_post_confirm;
            }
            int i4 = R.string.confirm_title;
            if (i == 0) {
                if (i2 == 1002 && !z) {
                    i3 = R.string.report_thread_confirm;
                } else {
                    i4 = R.string.del_my_thread_confirm;
                    i3 = R.string.del_my_thread_confirm_subtitle;
                }
            }
            this.e = new c05(this.a.getPageActivity());
            if (StringUtils.isNull(str2)) {
                c05 c05Var = this.e;
                Intrinsics.checkNotNull(c05Var);
                c05Var.setMessageId(i3);
            } else {
                c05 c05Var2 = this.e;
                Intrinsics.checkNotNull(c05Var2);
                c05Var2.setOnlyMessageShowCenter(false);
                c05 c05Var3 = this.e;
                Intrinsics.checkNotNull(c05Var3);
                c05Var3.setMessage(str2);
            }
            c05 c05Var4 = this.e;
            Intrinsics.checkNotNull(c05Var4);
            c05Var4.setYesButtonTag(sparseArray);
            c05 c05Var5 = this.e;
            Intrinsics.checkNotNull(c05Var5);
            c05Var5.setPositiveButton(R.string.obfuscated_res_0x7f0f05ab, new c05.e() { // from class: com.baidu.tieba.ez9
                public static /* synthetic */ Interceptable $ic;
                public transient /* synthetic */ FieldHolder $fh;

                @Override // com.baidu.tieba.c05.e
                public final void onClick(c05 c05Var6) {
                    Interceptable interceptable2 = $ic;
                    if (interceptable2 == null || interceptable2.invokeL(1048576, this, c05Var6) == null) {
                        xz9.c(xz9.this, c05Var6);
                    }
                }
            });
            c05 c05Var6 = this.e;
            Intrinsics.checkNotNull(c05Var6);
            c05Var6.setNegativeButton(R.string.obfuscated_res_0x7f0f05a0, new c05.e() { // from class: com.baidu.tieba.dz9
                public static /* synthetic */ Interceptable $ic;
                public transient /* synthetic */ FieldHolder $fh;

                @Override // com.baidu.tieba.c05.e
                public final void onClick(c05 c05Var7) {
                    Interceptable interceptable2 = $ic;
                    if (interceptable2 == null || interceptable2.invokeL(1048576, this, c05Var7) == null) {
                        xz9.d(c05Var7);
                    }
                }
            });
            c05 c05Var7 = this.e;
            Intrinsics.checkNotNull(c05Var7);
            c05Var7.setCancelable(true);
            c05 c05Var8 = this.e;
            Intrinsics.checkNotNull(c05Var8);
            c05Var8.create(this.a);
            if (z2) {
                l(sparseArray, i4, i3);
            } else if (z) {
                l(sparseArray, i4, i3);
            } else if (g(this.b)) {
                Integer num = this.b.s1().n().getDeletedReasonInfo().is_grays_cale_forum;
                Intrinsics.checkNotNullExpressionValue(num, "pbModel.getPbData().getF…nfo().is_grays_cale_forum");
                int intValue = num.intValue();
                Integer num2 = this.b.s1().n().getDeletedReasonInfo().is_boomgrow;
                Intrinsics.checkNotNullExpressionValue(num2, "pbModel.getPbData().getF…dReasonInfo().is_boomgrow");
                int intValue2 = num2.intValue();
                Integer num3 = this.b.s1().q().has_forum_rule;
                Intrinsics.checkNotNullExpressionValue(num3, "pbModel.getPbData().getForumRule().has_forum_rule");
                j16 j16Var = new j16(intValue, intValue2, num3.intValue());
                j16Var.i(this.b.s1().n().getId(), this.b.s1().n().getName());
                j16Var.h(this.b.s1().n().getImage_url());
                j16Var.j(this.b.s1().n().getUser_level());
                UserData Y = this.b.s1().Y();
                Intrinsics.checkNotNullExpressionValue(Y, "pbModel.getPbData().getUserData()");
                o(view2, sparseArray, i, j16Var, Y, false);
            } else {
                q(view2, this.e, i);
            }
        }
    }

    public final void e(View view2, int i, String postId, int i2, boolean z) {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeCommon(Constants.METHOD_SEND_USER_MSG, this, new Object[]{view2, Integer.valueOf(i), postId, Integer.valueOf(i2), Boolean.valueOf(z)}) == null) {
            Intrinsics.checkNotNullParameter(postId, "postId");
            SparseArray<Object> sparseArray = new SparseArray<>();
            sparseArray.put(R.id.tag_del_post_id, postId);
            sparseArray.put(R.id.tag_del_post_type, Integer.valueOf(i));
            sparseArray.put(R.id.tag_manage_user_identity, Integer.valueOf(i2));
            sparseArray.put(R.id.tag_del_post_is_self, Boolean.valueOf(z));
            sparseArray.put(j1a.i2, Integer.valueOf(j1a.j2));
            if (z) {
                h(sparseArray);
            } else {
                k(view2, i, sparseArray);
            }
        }
    }

    public final boolean g(PbModel pbModel) {
        InterceptResult invokeL;
        Interceptable interceptable = $ic;
        if (interceptable == null || (invokeL = interceptable.invokeL(1048580, this, pbModel)) == null) {
            if (pbModel.s1().n().getDeletedReasonInfo() == null) {
                return false;
            }
            int i = this.d;
            Integer num = pbModel.s1().n().getDeletedReasonInfo().is_grays_cale_forum;
            if (num == null || i != num.intValue()) {
                return false;
            }
            return true;
        }
        return invokeL.booleanValue;
    }

    public final void h(final SparseArray<Object> sparseArray) {
        Interceptable interceptable = $ic;
        if ((interceptable != null && interceptable.invokeL(1048581, this, sparseArray) != null) || this.a.getPageActivity() == null) {
            return;
        }
        if (sparseArray != null) {
            sparseArray.put(R.id.tag_is_block_thread, Boolean.TRUE);
        }
        TBAlertConfig.OperateBtnConfig operateBtnConfig = new TBAlertConfig.OperateBtnConfig((int) R.string.obfuscated_res_0x7f0f1428, TBAlertConfig.OperateBtnStyle.MAIN);
        TBAlertConfig.OperateBtnConfig operateBtnConfig2 = new TBAlertConfig.OperateBtnConfig((int) R.string.obfuscated_res_0x7f0f03db, TBAlertConfig.OperateBtnStyle.SECONDARY);
        final AlertDialog show = new TBAlertBuilder(this.a.getPageActivity()).setTitle(R.string.musk_my_thread_confirm).setDesc(R.string.musk_my_thread_confirm_subtitle).setDescLightStyle(true).setOperateBtn(operateBtnConfig2, operateBtnConfig).setCancelable(false).show();
        operateBtnConfig.setListener(new View.OnClickListener() { // from class: com.baidu.tieba.hz9
            public static /* synthetic */ Interceptable $ic;
            public transient /* synthetic */ FieldHolder $fh;

            @Override // android.view.View.OnClickListener
            public final void onClick(View view2) {
                Interceptable interceptable2 = $ic;
                if (interceptable2 == null || interceptable2.invokeL(1048576, this, view2) == null) {
                    xz9.i(AlertDialog.this, this, sparseArray, view2);
                }
            }
        });
        operateBtnConfig2.setListener(new View.OnClickListener() { // from class: com.baidu.tieba.gz9
            public static /* synthetic */ Interceptable $ic;
            public transient /* synthetic */ FieldHolder $fh;

            @Override // android.view.View.OnClickListener
            public final void onClick(View view2) {
                Interceptable interceptable2 = $ic;
                if (interceptable2 == null || interceptable2.invokeL(1048576, this, view2) == null) {
                    xz9.j(AlertDialog.this, view2);
                }
            }
        });
    }

    public final void k(View view2, int i, SparseArray<Object> sparseArray) {
        PbModel pbModel;
        Interceptable interceptable = $ic;
        if ((interceptable == null || interceptable.invokeLIL(1048582, this, view2, i, sparseArray) == null) && (pbModel = this.b) != null && pbModel.s1() != null && this.b.s1().q() != null && this.b.s1().n() != null && this.b.s1().n().getDeletedReasonInfo() != null) {
            if (sparseArray != null) {
                sparseArray.put(R.id.tag_is_block_thread, Boolean.TRUE);
            }
            Integer num = this.b.s1().n().getDeletedReasonInfo().is_grays_cale_forum;
            Intrinsics.checkNotNullExpressionValue(num, "pbModel.getPbData().getF…nfo().is_grays_cale_forum");
            int intValue = num.intValue();
            Integer num2 = this.b.s1().n().getDeletedReasonInfo().is_boomgrow;
            Intrinsics.checkNotNullExpressionValue(num2, "pbModel.getPbData().getF…dReasonInfo().is_boomgrow");
            int intValue2 = num2.intValue();
            Integer num3 = this.b.s1().q().has_forum_rule;
            Intrinsics.checkNotNullExpressionValue(num3, "pbModel.getPbData().getForumRule().has_forum_rule");
            j16 j16Var = new j16(intValue, intValue2, num3.intValue());
            j16Var.i(this.b.s1().n().getId(), this.b.s1().n().getName());
            j16Var.h(this.b.s1().n().getImage_url());
            j16Var.j(this.b.s1().n().getUser_level());
            UserData Y = this.b.s1().Y();
            Intrinsics.checkNotNullExpressionValue(Y, "pbModel.getPbData().getUserData()");
            o(view2, sparseArray, i, j16Var, Y, true);
        }
    }

    public final void q(View view2, final c05 c05Var, int i) {
        AntiData antiData;
        String str;
        Interceptable interceptable = $ic;
        if ((interceptable != null && interceptable.invokeLLI(1048585, this, view2, c05Var, i) != null) || c05Var == null) {
            return;
        }
        if (this.f == null) {
            this.f = new h16(this.a, view2);
        }
        SparseArray<String> sparseArray = new SparseArray<>();
        vv9 s1 = this.b.s1();
        if (s1 != null) {
            antiData = s1.f();
        } else {
            antiData = null;
        }
        if (antiData != null && antiData.getDelThreadInfoList() != null) {
            List<DeleteThreadInfo> delThreadInfoList = antiData.getDelThreadInfoList();
            int size = delThreadInfoList.size();
            for (int i2 = 0; i2 < size; i2++) {
                if (!TextUtils.isEmpty(delThreadInfoList.get(i2).text_info)) {
                    sparseArray.put(delThreadInfoList.get(i2).text_id, delThreadInfoList.get(i2).text_info);
                }
            }
        }
        NegativeFeedBackData negativeFeedBackData = new NegativeFeedBackData();
        negativeFeedBackData.setFeedBackReasonMap(sparseArray);
        String string = this.a.getString(R.string.delete_thread_reason_1);
        Intrinsics.checkNotNullExpressionValue(string, "pageContext.getString(R.…g.delete_thread_reason_1)");
        String string2 = this.a.getString(R.string.delete_thread_reason_2);
        Intrinsics.checkNotNullExpressionValue(string2, "pageContext.getString(R.…g.delete_thread_reason_2)");
        String string3 = this.a.getString(R.string.delete_thread_reason_3);
        Intrinsics.checkNotNullExpressionValue(string3, "pageContext.getString(R.…g.delete_thread_reason_3)");
        String string4 = this.a.getString(R.string.delete_thread_reason_4);
        Intrinsics.checkNotNullExpressionValue(string4, "pageContext.getString(R.…g.delete_thread_reason_4)");
        String string5 = this.a.getString(R.string.delete_thread_reason_5);
        Intrinsics.checkNotNullExpressionValue(string5, "pageContext.getString(R.…g.delete_thread_reason_5)");
        String[] strArr = {string, string2, string3, string4, string5};
        h16 h16Var = this.f;
        Intrinsics.checkNotNull(h16Var);
        h16Var.B(strArr);
        h16 h16Var2 = this.f;
        Intrinsics.checkNotNull(h16Var2);
        h16Var2.A(negativeFeedBackData);
        if (i != 1 && i != 2) {
            str = "3";
        } else {
            str = "4";
        }
        h16 h16Var3 = this.f;
        Intrinsics.checkNotNull(h16Var3);
        h16Var3.D(str);
        h16 h16Var4 = this.f;
        Intrinsics.checkNotNull(h16Var4);
        h16Var4.C(new h16.h() { // from class: com.baidu.tieba.az9
            public static /* synthetic */ Interceptable $ic;
            public transient /* synthetic */ FieldHolder $fh;

            @Override // com.baidu.tieba.h16.h
            public final void a(JSONArray jSONArray) {
                Interceptable interceptable2 = $ic;
                if (interceptable2 == null || interceptable2.invokeL(1048576, this, jSONArray) == null) {
                    xz9.r(xz9.this, c05Var, jSONArray);
                }
            }
        });
    }

    public final void l(final SparseArray<Object> sparseArray, @StringRes int i, @StringRes int i2) {
        Interceptable interceptable = $ic;
        if ((interceptable != null && interceptable.invokeLII(1048583, this, sparseArray, i, i2) != null) || this.a.getPageActivity() == null) {
            return;
        }
        TBAlertConfig.OperateBtnConfig operateBtnConfig = new TBAlertConfig.OperateBtnConfig((int) R.string.obfuscated_res_0x7f0f055b, TBAlertConfig.OperateBtnStyle.MAIN);
        TBAlertConfig.OperateBtnConfig operateBtnConfig2 = new TBAlertConfig.OperateBtnConfig((int) R.string.obfuscated_res_0x7f0f03db, TBAlertConfig.OperateBtnStyle.SECONDARY);
        final AlertDialog show = new TBAlertBuilder(this.a.getPageActivity()).setTitle(i).setDesc(i2).setDescLightStyle(true).setOperateBtn(operateBtnConfig2, operateBtnConfig).setCancelable(false).show();
        operateBtnConfig.setListener(new View.OnClickListener() { // from class: com.baidu.tieba.cz9
            public static /* synthetic */ Interceptable $ic;
            public transient /* synthetic */ FieldHolder $fh;

            @Override // android.view.View.OnClickListener
            public final void onClick(View view2) {
                Interceptable interceptable2 = $ic;
                if (interceptable2 == null || interceptable2.invokeL(1048576, this, view2) == null) {
                    xz9.m(AlertDialog.this, this, sparseArray, view2);
                }
            }
        });
        operateBtnConfig2.setListener(new View.OnClickListener() { // from class: com.baidu.tieba.zy9
            public static /* synthetic */ Interceptable $ic;
            public transient /* synthetic */ FieldHolder $fh;

            @Override // android.view.View.OnClickListener
            public final void onClick(View view2) {
                Interceptable interceptable2 = $ic;
                if (interceptable2 == null || interceptable2.invokeL(1048576, this, view2) == null) {
                    xz9.n(AlertDialog.this, view2);
                }
            }
        });
    }

    public final void o(View view2, final SparseArray<Object> sparseArray, int i, j16 j16Var, UserData userData, boolean z) {
        AntiData antiData;
        String str;
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeCommon(InputDeviceCompat.SOURCE_TOUCHPAD, this, new Object[]{view2, sparseArray, Integer.valueOf(i), j16Var, userData, Boolean.valueOf(z)}) == null) {
            if (this.g == null) {
                this.g = new k16(this.a, view2, j16Var, userData);
            }
            k16 k16Var = this.g;
            if (k16Var != null) {
                k16Var.G(z);
            }
            SparseArray<String> sparseArray2 = new SparseArray<>();
            vv9 s1 = this.b.s1();
            if (s1 != null) {
                antiData = s1.f();
            } else {
                antiData = null;
            }
            if (antiData != null && antiData.getDelThreadInfoList() != null) {
                List<DeleteThreadInfo> delThreadInfoList = antiData.getDelThreadInfoList();
                int size = delThreadInfoList.size();
                for (int i2 = 0; i2 < size; i2++) {
                    if (!TextUtils.isEmpty(delThreadInfoList.get(i2).text_info)) {
                        sparseArray2.put(delThreadInfoList.get(i2).text_id, delThreadInfoList.get(i2).text_info);
                    }
                }
            }
            NegativeFeedBackData negativeFeedBackData = new NegativeFeedBackData();
            negativeFeedBackData.setFeedBackReasonMap(sparseArray2);
            String string = this.a.getString(R.string.delete_thread_reason_1);
            Intrinsics.checkNotNullExpressionValue(string, "pageContext.getString(R.…g.delete_thread_reason_1)");
            String string2 = this.a.getString(R.string.delete_thread_reason_2);
            Intrinsics.checkNotNullExpressionValue(string2, "pageContext.getString(R.…g.delete_thread_reason_2)");
            String string3 = this.a.getString(R.string.delete_thread_reason_3);
            Intrinsics.checkNotNullExpressionValue(string3, "pageContext.getString(R.…g.delete_thread_reason_3)");
            String string4 = this.a.getString(R.string.delete_thread_reason_4);
            Intrinsics.checkNotNullExpressionValue(string4, "pageContext.getString(R.…g.delete_thread_reason_4)");
            String string5 = this.a.getString(R.string.delete_thread_reason_5);
            Intrinsics.checkNotNullExpressionValue(string5, "pageContext.getString(R.…g.delete_thread_reason_5)");
            String[] strArr = {string, string2, string3, string4, string5};
            k16 k16Var2 = this.g;
            if (k16Var2 != null) {
                k16Var2.I(strArr);
            }
            k16 k16Var3 = this.g;
            if (k16Var3 != null) {
                k16Var3.H(negativeFeedBackData);
            }
            if (i != 1 && i != 2) {
                str = "3";
            } else {
                str = "4";
            }
            k16 k16Var4 = this.g;
            if (k16Var4 != null) {
                k16Var4.K(str);
            }
            k16 k16Var5 = this.g;
            if (k16Var5 != null) {
                k16Var5.J(new k16.i() { // from class: com.baidu.tieba.fz9
                    public static /* synthetic */ Interceptable $ic;
                    public transient /* synthetic */ FieldHolder $fh;

                    @Override // com.baidu.tieba.k16.i
                    public final void a(JSONArray jSONArray) {
                        Interceptable interceptable2 = $ic;
                        if (interceptable2 == null || interceptable2.invokeL(1048576, this, jSONArray) == null) {
                            xz9.p(xz9.this, sparseArray, jSONArray);
                        }
                    }
                });
            }
        }
    }
}
