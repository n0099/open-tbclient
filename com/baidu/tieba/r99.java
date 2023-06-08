package com.baidu.tieba;

import android.app.Activity;
import android.graphics.drawable.Drawable;
import android.text.SpannableString;
import android.text.SpannableStringBuilder;
import android.text.style.ForegroundColorSpan;
import android.util.SparseArray;
import androidx.annotation.Nullable;
import androidx.core.view.InputDeviceCompat;
import com.baidu.adp.lib.util.StringUtils;
import com.baidu.tbadk.core.TbadkCoreApplication;
import com.baidu.tbadk.core.util.SkinManager;
import com.baidu.tbadk.core.util.WebPManager;
import com.baidu.tieba.c55;
import com.baidu.tieba.pb.pb.main.PbModel;
import com.baidu.tieba.tbadkCore.data.AgreeData;
import com.baidu.titan.sdk.runtime.FieldHolder;
import com.baidu.titan.sdk.runtime.InterceptResult;
import com.baidu.titan.sdk.runtime.Interceptable;
import com.baidu.webkit.sdk.dumper.ZeusCrashHandler;
import java.util.ArrayList;
import java.util.Iterator;
import java.util.List;
/* loaded from: classes7.dex */
public class r99 {
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

    public static boolean a(List<j55> list, n55 n55Var, jy9 jy9Var, e49 e49Var, boolean z) {
        InterceptResult invokeCommon;
        Interceptable interceptable = $ic;
        if (interceptable == null || (invokeCommon = interceptable.invokeCommon(65536, null, new Object[]{list, n55Var, jy9Var, e49Var, Boolean.valueOf(z)})) == null) {
            if (list == null || jy9Var == null || e49Var == null || !z || !e49Var.o() || !TbadkCoreApplication.isLogin() || l(jy9Var) || e49Var.n()) {
                return false;
            }
            j55 j55Var = new j55(9, TbadkCoreApplication.getInst().getString(R.string.obfuscated_res_0x7f0f0362), n55Var);
            list.add(j55Var);
            b6a.f(j55Var.d, jy9Var);
            return true;
        }
        return invokeCommon.booleanValue;
    }

    public static boolean b(List<j55> list, n55 n55Var, jy9 jy9Var, PbModel pbModel) {
        InterceptResult invokeLLLL;
        Interceptable interceptable = $ic;
        if (interceptable == null || (invokeLLLL = interceptable.invokeLLLL(65537, null, list, n55Var, jy9Var, pbModel)) == null) {
            if (list != null && jy9Var != null && pbModel != null && pbModel.y1() != null) {
                m39 y1 = pbModel.y1();
                if (y1.j0() && TbadkCoreApplication.isLogin() && !l(jy9Var) && !y1.i0()) {
                    j55 j55Var = new j55(9, TbadkCoreApplication.getInst().getString(R.string.obfuscated_res_0x7f0f0362), n55Var);
                    list.add(j55Var);
                    b6a.f(j55Var.d, jy9Var);
                    return true;
                }
            }
            return false;
        }
        return invokeLLLL.booleanValue;
    }

    public static List<j55> c(List<j55> list, AgreeData agreeData, SparseArray<?> sparseArray, n55 n55Var) {
        InterceptResult invokeLLLL;
        Interceptable interceptable = $ic;
        if (interceptable == null || (invokeLLLL = interceptable.invokeLLLL(65538, null, list, agreeData, sparseArray, n55Var)) == null) {
            if (list == null) {
                list = new ArrayList<>();
            }
            ArrayList arrayList = new ArrayList();
            if (agreeData.hasAgree) {
                if (agreeData.agreeType == 2) {
                    j55 j55Var = new j55(-1, u79.t(R.string.c_agreeed, new Object[0]), n55Var);
                    j55Var.d.setTag(sparseArray);
                    arrayList.add(j55Var);
                    if (!g(sparseArray, R.id.pb_dialog_item_isugc)) {
                        j55 j55Var2 = new j55(-2, u79.t(R.string.c_disagree, new Object[0]), n55Var);
                        j55Var2.d.setTag(sparseArray);
                        arrayList.add(j55Var2);
                    }
                } else {
                    j55 j55Var3 = new j55(-1, u79.t(R.string.c_agree, new Object[0]), n55Var);
                    j55Var3.d.setTag(sparseArray);
                    arrayList.add(j55Var3);
                    if (!g(sparseArray, R.id.pb_dialog_item_isugc)) {
                        j55 j55Var4 = new j55(-2, u79.t(R.string.c_disagreeed, new Object[0]), n55Var);
                        j55Var4.d.setTag(sparseArray);
                        arrayList.add(j55Var4);
                    }
                }
            } else {
                j55 j55Var5 = new j55(-1, u79.t(R.string.c_agree, new Object[0]), n55Var);
                j55Var5.d.setTag(sparseArray);
                arrayList.add(j55Var5);
                if (!g(sparseArray, R.id.pb_dialog_item_isugc)) {
                    j55 j55Var6 = new j55(-2, u79.t(R.string.c_disagree, new Object[0]), n55Var);
                    j55Var6.d.setTag(sparseArray);
                    arrayList.add(j55Var6);
                }
            }
            j55 j55Var7 = new j55(-3, u79.t(R.string.obfuscated_res_0x7f0f11ed, new Object[0]), n55Var);
            j55Var7.d.setTag(sparseArray);
            arrayList.add(j55Var7);
            j55 j55Var8 = new j55(-4, u79.t(R.string.obfuscated_res_0x7f0f133f, new Object[0]), n55Var);
            j55Var8.d.setTag(sparseArray);
            arrayList.add(j55Var8);
            list.addAll(0, arrayList);
            return list;
        }
        return (List) invokeLLLL.objValue;
    }

    public static List<j55> d(List<j55> list, AgreeData agreeData, SparseArray<?> sparseArray, n55 n55Var) {
        InterceptResult invokeLLLL;
        Interceptable interceptable = $ic;
        if (interceptable == null || (invokeLLLL = interceptable.invokeLLLL(65539, null, list, agreeData, sparseArray, n55Var)) == null) {
            if (list == null) {
                list = new ArrayList<>();
            }
            ArrayList arrayList = new ArrayList();
            if (agreeData.hasAgree) {
                if (agreeData.agreeType == 2) {
                    if (!g(sparseArray, R.id.pb_dialog_item_isugc)) {
                        j55 j55Var = new j55(-2, u79.t(R.string.action_dislike, new Object[0]), n55Var);
                        j55Var.d.setTag(sparseArray);
                        arrayList.add(j55Var);
                    }
                } else if (!g(sparseArray, R.id.pb_dialog_item_isugc)) {
                    j55 j55Var2 = new j55(-2, u79.t(R.string.c_disagreeed, new Object[0]), n55Var);
                    j55Var2.d.setTag(sparseArray);
                    arrayList.add(j55Var2);
                }
            } else if (!g(sparseArray, R.id.pb_dialog_item_isugc)) {
                j55 j55Var3 = new j55(-2, u79.t(R.string.action_dislike, new Object[0]), n55Var);
                j55Var3.d.setTag(sparseArray);
                arrayList.add(j55Var3);
            }
            j55 j55Var4 = new j55(-3, u79.t(R.string.obfuscated_res_0x7f0f11ed, new Object[0]), n55Var);
            j55Var4.d.setTag(sparseArray);
            arrayList.add(0, j55Var4);
            j55 j55Var5 = new j55(-4, u79.t(R.string.obfuscated_res_0x7f0f133f, new Object[0]), n55Var);
            j55Var5.d.setTag(sparseArray);
            arrayList.add(1, j55Var5);
            list.addAll(0, arrayList);
            return list;
        }
        return (List) invokeLLLL.objValue;
    }

    public static void e(Activity activity, @Nullable k9<?> k9Var, c55.e eVar, c55.e eVar2) {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeLLLL(InputDeviceCompat.SOURCE_TRACKBALL, null, activity, k9Var, eVar, eVar2) == null) {
            c55 c55Var = new c55(activity);
            c55Var.setMessageId(R.string.del_post_confirm);
            c55Var.setPositiveButton(R.string.obfuscated_res_0x7f0f058f, eVar);
            c55Var.setNegativeButton(R.string.obfuscated_res_0x7f0f0584, eVar2);
            c55Var.setCancelable(true);
            c55Var.create(k9Var);
            c55Var.show();
        }
    }

    public static List<j55> f(List<j55> list) {
        InterceptResult invokeL;
        Interceptable interceptable = $ic;
        if (interceptable == null || (invokeL = interceptable.invokeL(65541, null, list)) == null) {
            if (list == null) {
                return list;
            }
            for (j55 j55Var : list) {
                j55Var.l(i(j55Var));
            }
            return list;
        }
        return (List) invokeL.objValue;
    }

    public static boolean j(PbModel pbModel) {
        InterceptResult invokeL;
        Interceptable interceptable = $ic;
        if (interceptable == null || (invokeL = interceptable.invokeL(65545, null, pbModel)) == null) {
            if (pbModel != null && pbModel.y1() != null && pbModel.y1().j0()) {
                return true;
            }
            return false;
        }
        return invokeL.booleanValue;
    }

    public static boolean k(e49 e49Var) {
        InterceptResult invokeL;
        Interceptable interceptable = $ic;
        if (interceptable == null || (invokeL = interceptable.invokeL(65546, null, e49Var)) == null) {
            if (e49Var != null && e49Var.o()) {
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

    public static SpannableStringBuilder h(jy9 jy9Var) {
        InterceptResult invokeL;
        String str;
        Interceptable interceptable = $ic;
        if (interceptable == null || (invokeL = interceptable.invokeL(65543, null, jy9Var)) == null) {
            if (jy9Var == null) {
                return null;
            }
            if (jy9Var.a0() != null) {
                str = jy9Var.a0().toString();
            } else {
                str = "";
            }
            SpannableString o = o(jy9Var.p().getName_show() + ZeusCrashHandler.NAME_SEPERATOR, SkinManager.getColor(R.color.CAM_X0109));
            SpannableString o2 = o(str, SkinManager.getColor(R.color.CAM_X0107));
            SpannableStringBuilder spannableStringBuilder = new SpannableStringBuilder();
            spannableStringBuilder.append((CharSequence) o);
            spannableStringBuilder.append((CharSequence) o2);
            return spannableStringBuilder;
        }
        return (SpannableStringBuilder) invokeL.objValue;
    }

    public static Drawable i(j55 j55Var) {
        InterceptResult invokeL;
        Interceptable interceptable = $ic;
        if (interceptable == null || (invokeL = interceptable.invokeL(65544, null, j55Var)) == null) {
            switch (j55Var.f()) {
                case -4:
                    return WebPManager.getPureDrawable(R.drawable.icon_pure_pb_recommend_share30, SkinManager.getColor(R.color.CAM_X0107), null);
                case -3:
                    return WebPManager.getPureDrawable(R.drawable.icon_pure_pb_recommend_comment30, SkinManager.getColor(R.color.CAM_X0107), null);
                case -2:
                    if (u79.t(R.string.c_disagree, new Object[0]).equals(j55Var.g())) {
                        return WebPManager.getPureDrawable(R.drawable.icon_pure_pb_recommend_dislike30, SkinManager.getColor(R.color.CAM_X0107), null);
                    }
                    return WebPManager.getPureDrawable(R.drawable.icon_pure_pb_recommend_disliked30, SkinManager.getColor(R.color.CAM_X0107), null);
                case -1:
                    if (u79.t(R.string.c_agree, new Object[0]).equals(j55Var.g())) {
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
                    if (u79.t(R.string.obfuscated_res_0x7f0f0c27, new Object[0]).equals(j55Var.g())) {
                        return WebPManager.getPureDrawable(R.drawable.icon_pure_pb_recommend_collect30, SkinManager.getColor(R.color.CAM_X0107), null);
                    }
                    return WebPManager.getPureDrawable(R.drawable.icon_pure_pb_recommend_collected30, SkinManager.getColor(R.color.CAM_X0305), null);
                case 5:
                    if (u79.t(R.string.report_text, new Object[0]).equals(j55Var.g())) {
                        return WebPManager.getPureDrawable(R.drawable.icon_pure_pb_recommend_report30, SkinManager.getColor(R.color.CAM_X0107), null);
                    }
                    if (!u79.t(R.string.obfuscated_res_0x7f0f0cd0, new Object[0]).equals(j55Var.g())) {
                        return null;
                    }
                    return WebPManager.getPureDrawable(R.drawable.icon_pure_pb_recommend_nospeakingset30, SkinManager.getColor(R.color.CAM_X0107), null);
                case 6:
                    if (u79.t(R.string.report_text, new Object[0]).equals(j55Var.g())) {
                        return WebPManager.getPureDrawable(R.drawable.icon_pure_pb_recommend_report30, SkinManager.getColor(R.color.CAM_X0107), null);
                    }
                    if (!u79.t(R.string.obfuscated_res_0x7f0f053f, new Object[0]).equals(j55Var.g())) {
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
                    if (u79.t(R.string.obfuscated_res_0x7f0f054e, new Object[0]).equals(j55Var.g())) {
                        return WebPManager.getPureDrawable(R.drawable.icon_pure_pb_recommend_delete30, SkinManager.getColor(R.color.CAM_X0107), null);
                    }
                    if (!u79.t(R.string.obfuscated_res_0x7f0f053f, new Object[0]).equals(j55Var.g())) {
                        return null;
                    }
                    return WebPManager.getPureDrawable(R.drawable.icon_pure_pb_recommend_delete30, SkinManager.getColor(R.color.CAM_X0107), null);
                case 11:
                    return WebPManager.getPureDrawable(R.drawable.icon_pure_pb_recommend_block30, SkinManager.getColor(R.color.CAM_X0107), null);
                case 12:
                    if (u79.t(R.string.obfuscated_res_0x7f0f0ccc, new Object[0]).equals(j55Var.g())) {
                        return WebPManager.getPureDrawable(R.drawable.icon_pure_pb_recommend_nospeaking30, SkinManager.getColor(R.color.CAM_X0107), null);
                    }
                    if (!u79.t(R.string.un_mute, new Object[0]).equals(j55Var.g())) {
                        return null;
                    }
                    return WebPManager.getPureDrawable(R.drawable.icon_pure_pb_recommend_nospeakinged30, SkinManager.getColor(R.color.CAM_X0107), null);
                case 13:
                    return WebPManager.getPureDrawable(R.drawable.icon_pure_pb_batch_delete, SkinManager.getColor(R.color.CAM_X0107), null);
            }
        }
        return (Drawable) invokeL.objValue;
    }

    public static boolean l(jy9 jy9Var) {
        InterceptResult invokeL;
        Interceptable interceptable = $ic;
        if (interceptable == null || (invokeL = interceptable.invokeL(65547, null, jy9Var)) == null) {
            if (jy9Var != null && jy9Var.p() != null && !StringUtils.isNull(jy9Var.p().getUserId()) && jy9Var.p().getUserId().equals(TbadkCoreApplication.getCurrentAccount())) {
                return true;
            }
            return false;
        }
        return invokeL.booleanValue;
    }

    public static List<j55> m(List<j55> list, boolean z) {
        InterceptResult invokeLZ;
        Interceptable interceptable = $ic;
        if (interceptable == null || (invokeLZ = interceptable.invokeLZ(65548, null, list, z)) == null) {
            if (list != null && !z) {
                Iterator<j55> it = list.iterator();
                while (it.hasNext()) {
                    j55 next = it.next();
                    if (next.f() == 2 || next.f() == 1 || next.f() == 3) {
                        it.remove();
                    }
                }
            }
            return list;
        }
        return (List) invokeLZ.objValue;
    }
}
