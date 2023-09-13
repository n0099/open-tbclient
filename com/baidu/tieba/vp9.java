package com.baidu.tieba;

import android.app.Activity;
import android.graphics.drawable.Drawable;
import android.text.SpannableString;
import android.text.SpannableStringBuilder;
import android.text.TextUtils;
import android.text.style.ForegroundColorSpan;
import android.util.SparseArray;
import androidx.annotation.Nullable;
import androidx.core.view.InputDeviceCompat;
import com.baidu.adp.base.BdPageContext;
import com.baidu.adp.lib.util.StringUtils;
import com.baidu.tbadk.core.TbadkCoreApplication;
import com.baidu.tbadk.core.util.SkinManager;
import com.baidu.tbadk.core.util.WebPManager;
import com.baidu.tieba.pb.pb.main.PbModel;
import com.baidu.tieba.tbadkCore.data.AgreeData;
import com.baidu.tieba.y45;
import com.baidu.titan.sdk.runtime.FieldHolder;
import com.baidu.titan.sdk.runtime.InterceptResult;
import com.baidu.titan.sdk.runtime.Interceptable;
import com.baidu.webkit.sdk.dumper.ZeusCrashHandler;
import java.util.ArrayList;
import java.util.Iterator;
import java.util.List;
import tbclient.AigcFeedbackInfo;
/* loaded from: classes8.dex */
public class vp9 {
    public static /* synthetic */ Interceptable $ic;
    public transient /* synthetic */ FieldHolder $fh;

    public static int n(int i) {
        InterceptResult invokeI;
        Interceptable interceptable = $ic;
        if (interceptable == null || (invokeI = interceptable.invokeI(65549, null, i)) == null) {
            if (i != -4) {
                if (i != -3) {
                    if (i != -2) {
                        if (i != -1) {
                            switch (i) {
                                case 4:
                                    return 5;
                                case 5:
                                    return 7;
                                case 6:
                                    return 6;
                                case 7:
                                    return 9;
                                case 8:
                                    return 8;
                                default:
                                    return 0;
                            }
                        }
                        return 1;
                    }
                    return 2;
                }
                return 3;
            }
            return 4;
        }
        return invokeI.intValue;
    }

    public static boolean a(List<e55> list, i55 i55Var, tha thaVar, rj9 rj9Var, boolean z) {
        InterceptResult invokeCommon;
        Interceptable interceptable = $ic;
        if (interceptable == null || (invokeCommon = interceptable.invokeCommon(65536, null, new Object[]{list, i55Var, thaVar, rj9Var, Boolean.valueOf(z)})) == null) {
            if (list == null || thaVar == null || rj9Var == null || !z || !rj9Var.o() || !TbadkCoreApplication.isLogin() || l(thaVar) || rj9Var.n()) {
                return false;
            }
            e55 e55Var = new e55(9, TbadkCoreApplication.getInst().getString(R.string.obfuscated_res_0x7f0f0367), i55Var);
            list.add(e55Var);
            iqa.f(e55Var.d, thaVar);
            return true;
        }
        return invokeCommon.booleanValue;
    }

    public static boolean b(List<e55> list, i55 i55Var, tha thaVar, PbModel pbModel) {
        InterceptResult invokeLLLL;
        Interceptable interceptable = $ic;
        if (interceptable == null || (invokeLLLL = interceptable.invokeLLLL(65537, null, list, i55Var, thaVar, pbModel)) == null) {
            if (list != null && thaVar != null && pbModel != null && pbModel.r1() != null) {
                aj9 r1 = pbModel.r1();
                if (r1.k0() && TbadkCoreApplication.isLogin() && !l(thaVar) && !r1.j0()) {
                    e55 e55Var = new e55(9, TbadkCoreApplication.getInst().getString(R.string.obfuscated_res_0x7f0f0367), i55Var);
                    list.add(e55Var);
                    iqa.f(e55Var.d, thaVar);
                    return true;
                }
            }
            return false;
        }
        return invokeLLLL.booleanValue;
    }

    public static List<e55> c(List<e55> list, AgreeData agreeData, SparseArray<?> sparseArray, i55 i55Var) {
        InterceptResult invokeLLLL;
        Interceptable interceptable = $ic;
        if (interceptable == null || (invokeLLLL = interceptable.invokeLLLL(65538, null, list, agreeData, sparseArray, i55Var)) == null) {
            return d(list, agreeData, sparseArray, i55Var, null);
        }
        return (List) invokeLLLL.objValue;
    }

    public static List<e55> d(List<e55> list, AgreeData agreeData, SparseArray<?> sparseArray, i55 i55Var, AigcFeedbackInfo aigcFeedbackInfo) {
        InterceptResult invokeLLLLL;
        Interceptable interceptable = $ic;
        if (interceptable == null || (invokeLLLLL = interceptable.invokeLLLLL(65539, null, list, agreeData, sparseArray, i55Var, aigcFeedbackInfo)) == null) {
            String s = wn9.s(R.string.c_agree, new Object[0]);
            String s2 = wn9.s(R.string.c_disagree, new Object[0]);
            String s3 = wn9.s(R.string.c_agreeed, new Object[0]);
            String s4 = wn9.s(R.string.c_disagreeed, new Object[0]);
            if (aigcFeedbackInfo != null) {
                String str = aigcFeedbackInfo.positive_text;
                String str2 = aigcFeedbackInfo.negative_text;
                if (!TextUtils.isEmpty(str) && !TextUtils.isEmpty(str2)) {
                    s2 = str2;
                    s4 = s2;
                    s = str;
                    s3 = s;
                }
            }
            if (list == null) {
                list = new ArrayList<>();
            }
            ArrayList arrayList = new ArrayList();
            if (agreeData.hasAgree) {
                if (agreeData.agreeType == 2) {
                    e55 e55Var = new e55(-1, s3, i55Var);
                    e55Var.n(true);
                    e55Var.d.setTag(sparseArray);
                    arrayList.add(e55Var);
                    if (!g(sparseArray, R.id.pb_dialog_item_isugc)) {
                        e55 e55Var2 = new e55(-2, s2, i55Var);
                        e55Var2.n(false);
                        e55Var2.d.setTag(sparseArray);
                        arrayList.add(e55Var2);
                    }
                } else {
                    e55 e55Var3 = new e55(-1, s, i55Var);
                    e55Var3.n(false);
                    e55Var3.d.setTag(sparseArray);
                    arrayList.add(e55Var3);
                    if (!g(sparseArray, R.id.pb_dialog_item_isugc)) {
                        e55 e55Var4 = new e55(-2, s4, i55Var);
                        e55Var4.n(true);
                        e55Var4.d.setTag(sparseArray);
                        arrayList.add(e55Var4);
                    }
                }
            } else {
                e55 e55Var5 = new e55(-1, s, i55Var);
                e55Var5.n(false);
                e55Var5.d.setTag(sparseArray);
                arrayList.add(e55Var5);
                if (!g(sparseArray, R.id.pb_dialog_item_isugc)) {
                    e55 e55Var6 = new e55(-2, s2, i55Var);
                    e55Var6.n(false);
                    e55Var6.d.setTag(sparseArray);
                    arrayList.add(e55Var6);
                }
            }
            e55 e55Var7 = new e55(-3, wn9.s(R.string.obfuscated_res_0x7f0f1247, new Object[0]), i55Var);
            e55Var7.d.setTag(sparseArray);
            arrayList.add(e55Var7);
            e55 e55Var8 = new e55(-4, wn9.s(R.string.obfuscated_res_0x7f0f13a0, new Object[0]), i55Var);
            e55Var8.d.setTag(sparseArray);
            arrayList.add(e55Var8);
            list.addAll(0, arrayList);
            return list;
        }
        return (List) invokeLLLLL.objValue;
    }

    public static void e(Activity activity, @Nullable BdPageContext<?> bdPageContext, y45.e eVar, y45.e eVar2) {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeLLLL(InputDeviceCompat.SOURCE_TRACKBALL, null, activity, bdPageContext, eVar, eVar2) == null) {
            y45 y45Var = new y45(activity);
            y45Var.setMessageId(R.string.del_post_confirm);
            y45Var.setPositiveButton(R.string.obfuscated_res_0x7f0f059b, eVar);
            y45Var.setNegativeButton(R.string.obfuscated_res_0x7f0f0590, eVar2);
            y45Var.setCancelable(true);
            y45Var.create(bdPageContext);
            y45Var.show();
        }
    }

    public static List<e55> f(List<e55> list) {
        InterceptResult invokeL;
        Interceptable interceptable = $ic;
        if (interceptable == null || (invokeL = interceptable.invokeL(65541, null, list)) == null) {
            if (list == null) {
                return list;
            }
            for (e55 e55Var : list) {
                e55Var.l(i(e55Var));
            }
            return list;
        }
        return (List) invokeL.objValue;
    }

    public static boolean j(PbModel pbModel) {
        InterceptResult invokeL;
        Interceptable interceptable = $ic;
        if (interceptable == null || (invokeL = interceptable.invokeL(65545, null, pbModel)) == null) {
            if (pbModel != null && pbModel.r1() != null && pbModel.r1().k0()) {
                return true;
            }
            return false;
        }
        return invokeL.booleanValue;
    }

    public static boolean k(rj9 rj9Var) {
        InterceptResult invokeL;
        Interceptable interceptable = $ic;
        if (interceptable == null || (invokeL = interceptable.invokeL(65546, null, rj9Var)) == null) {
            if (rj9Var != null && rj9Var.o()) {
                return true;
            }
            return false;
        }
        return invokeL.booleanValue;
    }

    public static boolean g(SparseArray<?> sparseArray, int i) {
        InterceptResult invokeLI;
        Interceptable interceptable = $ic;
        if (interceptable == null || (invokeLI = interceptable.invokeLI(65542, null, sparseArray, i)) == null) {
            if (sparseArray != null && (sparseArray.get(i) instanceof Boolean)) {
                return ((Boolean) sparseArray.get(i)).booleanValue();
            }
            return false;
        }
        return invokeLI.booleanValue;
    }

    public static SpannableString o(String str, int i) {
        InterceptResult invokeLI;
        Interceptable interceptable = $ic;
        if (interceptable == null || (invokeLI = interceptable.invokeLI(65550, null, str, i)) == null) {
            SpannableString spannableString = new SpannableString(str);
            spannableString.setSpan(new ForegroundColorSpan(i), 0, str.length(), 33);
            return spannableString;
        }
        return (SpannableString) invokeLI.objValue;
    }

    public static SpannableStringBuilder h(tha thaVar) {
        InterceptResult invokeL;
        String str;
        Interceptable interceptable = $ic;
        if (interceptable == null || (invokeL = interceptable.invokeL(65543, null, thaVar)) == null) {
            if (thaVar == null) {
                return null;
            }
            if (thaVar.f0() != null) {
                str = thaVar.f0().toString();
            } else {
                str = "";
            }
            SpannableString o = o(thaVar.t().getName_show() + ZeusCrashHandler.NAME_SEPERATOR, SkinManager.getColor(R.color.CAM_X0109));
            SpannableString o2 = o(str, SkinManager.getColor(R.color.CAM_X0107));
            SpannableStringBuilder spannableStringBuilder = new SpannableStringBuilder();
            spannableStringBuilder.append((CharSequence) o);
            spannableStringBuilder.append((CharSequence) o2);
            return spannableStringBuilder;
        }
        return (SpannableStringBuilder) invokeL.objValue;
    }

    public static Drawable i(e55 e55Var) {
        InterceptResult invokeL;
        Interceptable interceptable = $ic;
        if (interceptable == null || (invokeL = interceptable.invokeL(65544, null, e55Var)) == null) {
            switch (e55Var.e()) {
                case -4:
                    return WebPManager.getPureDrawable(R.drawable.icon_pure_pb_recommend_share30, SkinManager.getColor(R.color.CAM_X0107), null);
                case -3:
                    return WebPManager.getPureDrawable(R.drawable.icon_pure_pb_recommend_comment30, SkinManager.getColor(R.color.CAM_X0107), null);
                case -2:
                    if (!e55Var.j()) {
                        return WebPManager.getPureDrawable(R.drawable.icon_pure_pb_recommend_dislike30, SkinManager.getColor(R.color.CAM_X0107), null);
                    }
                    return WebPManager.getPureDrawable(R.drawable.icon_pure_pb_recommend_disliked30, SkinManager.getColor(R.color.CAM_X0107), null);
                case -1:
                    if (!e55Var.j()) {
                        return WebPManager.getPureDrawable(R.drawable.icon_pure_pb_recommend_like30, SkinManager.getColor(R.color.CAM_X0107), null);
                    }
                    return WebPManager.getPureDrawable(R.drawable.icon_pure_pb_recommend_liked30, SkinManager.getColor(R.color.CAM_X0301), null);
                case 0:
                default:
                    return null;
                case 1:
                    return WebPManager.getPureDrawable(R.drawable.icon_pure_pb_recommend_expression30, SkinManager.getColor(R.color.CAM_X0107), null);
                case 2:
                    return WebPManager.getPureDrawable(R.drawable.icon_pure_pb_recommend_save30, SkinManager.getColor(R.color.CAM_X0107), null);
                case 3:
                    return WebPManager.getPureDrawable(R.drawable.icon_pure_pb_recommend_copy30, SkinManager.getColor(R.color.CAM_X0107), null);
                case 4:
                    if (wn9.s(R.string.obfuscated_res_0x7f0f0c5a, new Object[0]).equals(e55Var.f())) {
                        return WebPManager.getPureDrawable(R.drawable.icon_pure_pb_recommend_collect30, SkinManager.getColor(R.color.CAM_X0107), null);
                    }
                    return WebPManager.getPureDrawable(R.drawable.icon_pure_pb_recommend_collected30, SkinManager.getColor(R.color.CAM_X0305), null);
                case 5:
                    if (wn9.s(R.string.report_text, new Object[0]).equals(e55Var.f())) {
                        return WebPManager.getPureDrawable(R.drawable.icon_pure_pb_recommend_report30, SkinManager.getColor(R.color.CAM_X0107), null);
                    }
                    if (!wn9.s(R.string.obfuscated_res_0x7f0f0d1c, new Object[0]).equals(e55Var.f())) {
                        return null;
                    }
                    return WebPManager.getPureDrawable(R.drawable.icon_pure_pb_recommend_nospeakingset30, SkinManager.getColor(R.color.CAM_X0107), null);
                case 6:
                    if (wn9.s(R.string.report_text, new Object[0]).equals(e55Var.f())) {
                        return WebPManager.getPureDrawable(R.drawable.icon_pure_pb_recommend_report30, SkinManager.getColor(R.color.CAM_X0107), null);
                    }
                    if (!wn9.s(R.string.obfuscated_res_0x7f0f054b, new Object[0]).equals(e55Var.f())) {
                        return null;
                    }
                    return WebPManager.getPureDrawable(R.drawable.icon_pure_pb_recommend_delete30, SkinManager.getColor(R.color.CAM_X0107), null);
                case 7:
                    return WebPManager.getPureDrawable(R.drawable.icon_pure_pb_recommend_administration30, SkinManager.getColor(R.color.CAM_X0107), null);
                case 8:
                    return WebPManager.getPureDrawable(R.drawable.icon_pure_pb_recommend_hide30, SkinManager.getColor(R.color.CAM_X0107), null);
                case 9:
                    return WebPManager.getPureDrawable(R.drawable.icon_pure_pb_block30, SkinManager.getColor(R.color.CAM_X0107), null);
                case 10:
                    if (wn9.s(R.string.obfuscated_res_0x7f0f055a, new Object[0]).equals(e55Var.f())) {
                        return WebPManager.getPureDrawable(R.drawable.icon_pure_pb_recommend_delete30, SkinManager.getColor(R.color.CAM_X0107), null);
                    }
                    if (!wn9.s(R.string.obfuscated_res_0x7f0f054b, new Object[0]).equals(e55Var.f())) {
                        return null;
                    }
                    return WebPManager.getPureDrawable(R.drawable.icon_pure_pb_recommend_delete30, SkinManager.getColor(R.color.CAM_X0107), null);
                case 11:
                    return WebPManager.getPureDrawable(R.drawable.icon_pure_pb_recommend_block30, SkinManager.getColor(R.color.CAM_X0107), null);
                case 12:
                    if (wn9.s(R.string.obfuscated_res_0x7f0f0d18, new Object[0]).equals(e55Var.f())) {
                        return WebPManager.getPureDrawable(R.drawable.icon_pure_pb_recommend_nospeaking30, SkinManager.getColor(R.color.CAM_X0107), null);
                    }
                    if (!wn9.s(R.string.un_mute, new Object[0]).equals(e55Var.f())) {
                        return null;
                    }
                    return WebPManager.getPureDrawable(R.drawable.icon_pure_pb_recommend_nospeakinged30, SkinManager.getColor(R.color.CAM_X0107), null);
                case 13:
                    return WebPManager.getPureDrawable(R.drawable.icon_pure_pb_batch_delete, SkinManager.getColor(R.color.CAM_X0107), null);
            }
        }
        return (Drawable) invokeL.objValue;
    }

    public static boolean l(tha thaVar) {
        InterceptResult invokeL;
        Interceptable interceptable = $ic;
        if (interceptable == null || (invokeL = interceptable.invokeL(65547, null, thaVar)) == null) {
            if (thaVar != null && thaVar.t() != null && !StringUtils.isNull(thaVar.t().getUserId()) && thaVar.t().getUserId().equals(TbadkCoreApplication.getCurrentAccount())) {
                return true;
            }
            return false;
        }
        return invokeL.booleanValue;
    }

    public static List<e55> m(List<e55> list, boolean z) {
        InterceptResult invokeLZ;
        Interceptable interceptable = $ic;
        if (interceptable == null || (invokeLZ = interceptable.invokeLZ(65548, null, list, z)) == null) {
            if (list != null && !z) {
                Iterator<e55> it = list.iterator();
                while (it.hasNext()) {
                    e55 next = it.next();
                    if (next.e() == 2 || next.e() == 1 || next.e() == 3) {
                        it.remove();
                    }
                }
            }
            return list;
        }
        return (List) invokeLZ.objValue;
    }
}
