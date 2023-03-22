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
import com.baidu.tieba.pb.pb.main.PbModel;
import com.baidu.tieba.tbadkCore.data.AgreeData;
import com.baidu.tieba.zz4;
import com.baidu.titan.sdk.runtime.FieldHolder;
import com.baidu.titan.sdk.runtime.InterceptResult;
import com.baidu.titan.sdk.runtime.Interceptable;
import com.baidu.webkit.sdk.dumper.ZeusCrashHandler;
import java.util.ArrayList;
import java.util.Iterator;
import java.util.List;
/* loaded from: classes5.dex */
public class jo8 {
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

    public static boolean a(List<g05> list, k05 k05Var, bc9 bc9Var, aj8 aj8Var, boolean z) {
        InterceptResult invokeCommon;
        Interceptable interceptable = $ic;
        if (interceptable == null || (invokeCommon = interceptable.invokeCommon(65536, null, new Object[]{list, k05Var, bc9Var, aj8Var, Boolean.valueOf(z)})) == null) {
            if (list == null || bc9Var == null || aj8Var == null || !z || !aj8Var.q() || !TbadkCoreApplication.isLogin() || l(bc9Var) || aj8Var.p()) {
                return false;
            }
            g05 g05Var = new g05(9, TbadkCoreApplication.getInst().getString(R.string.obfuscated_res_0x7f0f032f), k05Var);
            list.add(g05Var);
            nj9.f(g05Var.d, bc9Var);
            return true;
        }
        return invokeCommon.booleanValue;
    }

    public static boolean b(List<g05> list, k05 k05Var, bc9 bc9Var, PbModel pbModel) {
        InterceptResult invokeLLLL;
        Interceptable interceptable = $ic;
        if (interceptable == null || (invokeLLLL = interceptable.invokeLLLL(65537, null, list, k05Var, bc9Var, pbModel)) == null) {
            if (list != null && bc9Var != null && pbModel != null && pbModel.w1() != null) {
                ki8 w1 = pbModel.w1();
                if (w1.m0() && TbadkCoreApplication.isLogin() && !l(bc9Var) && !w1.l0()) {
                    g05 g05Var = new g05(9, TbadkCoreApplication.getInst().getString(R.string.obfuscated_res_0x7f0f032f), k05Var);
                    list.add(g05Var);
                    nj9.f(g05Var.d, bc9Var);
                    return true;
                }
            }
            return false;
        }
        return invokeLLLL.booleanValue;
    }

    public static List<g05> c(List<g05> list, AgreeData agreeData, SparseArray<?> sparseArray, k05 k05Var) {
        InterceptResult invokeLLLL;
        Interceptable interceptable = $ic;
        if (interceptable == null || (invokeLLLL = interceptable.invokeLLLL(65538, null, list, agreeData, sparseArray, k05Var)) == null) {
            if (list == null) {
                list = new ArrayList<>();
            }
            ArrayList arrayList = new ArrayList();
            if (agreeData.hasAgree) {
                if (agreeData.agreeType == 2) {
                    g05 g05Var = new g05(-1, mm8.u(R.string.c_agreeed, new Object[0]), k05Var);
                    g05Var.d.setTag(sparseArray);
                    arrayList.add(g05Var);
                    if (!g(sparseArray, R.id.pb_dialog_item_isugc)) {
                        g05 g05Var2 = new g05(-2, mm8.u(R.string.c_disagree, new Object[0]), k05Var);
                        g05Var2.d.setTag(sparseArray);
                        arrayList.add(g05Var2);
                    }
                } else {
                    g05 g05Var3 = new g05(-1, mm8.u(R.string.c_agree, new Object[0]), k05Var);
                    g05Var3.d.setTag(sparseArray);
                    arrayList.add(g05Var3);
                    if (!g(sparseArray, R.id.pb_dialog_item_isugc)) {
                        g05 g05Var4 = new g05(-2, mm8.u(R.string.c_disagreeed, new Object[0]), k05Var);
                        g05Var4.d.setTag(sparseArray);
                        arrayList.add(g05Var4);
                    }
                }
            } else {
                g05 g05Var5 = new g05(-1, mm8.u(R.string.c_agree, new Object[0]), k05Var);
                g05Var5.d.setTag(sparseArray);
                arrayList.add(g05Var5);
                if (!g(sparseArray, R.id.pb_dialog_item_isugc)) {
                    g05 g05Var6 = new g05(-2, mm8.u(R.string.c_disagree, new Object[0]), k05Var);
                    g05Var6.d.setTag(sparseArray);
                    arrayList.add(g05Var6);
                }
            }
            g05 g05Var7 = new g05(-3, mm8.u(R.string.obfuscated_res_0x7f0f10c3, new Object[0]), k05Var);
            g05Var7.d.setTag(sparseArray);
            arrayList.add(g05Var7);
            g05 g05Var8 = new g05(-4, mm8.u(R.string.obfuscated_res_0x7f0f1211, new Object[0]), k05Var);
            g05Var8.d.setTag(sparseArray);
            arrayList.add(g05Var8);
            list.addAll(0, arrayList);
            return list;
        }
        return (List) invokeLLLL.objValue;
    }

    public static List<g05> d(List<g05> list, AgreeData agreeData, SparseArray<?> sparseArray, k05 k05Var) {
        InterceptResult invokeLLLL;
        Interceptable interceptable = $ic;
        if (interceptable == null || (invokeLLLL = interceptable.invokeLLLL(65539, null, list, agreeData, sparseArray, k05Var)) == null) {
            if (list == null) {
                list = new ArrayList<>();
            }
            ArrayList arrayList = new ArrayList();
            if (agreeData.hasAgree) {
                if (agreeData.agreeType == 2) {
                    if (!g(sparseArray, R.id.pb_dialog_item_isugc)) {
                        g05 g05Var = new g05(-2, mm8.u(R.string.action_dislike, new Object[0]), k05Var);
                        g05Var.d.setTag(sparseArray);
                        arrayList.add(g05Var);
                    }
                } else if (!g(sparseArray, R.id.pb_dialog_item_isugc)) {
                    g05 g05Var2 = new g05(-2, mm8.u(R.string.c_disagreeed, new Object[0]), k05Var);
                    g05Var2.d.setTag(sparseArray);
                    arrayList.add(g05Var2);
                }
            } else if (!g(sparseArray, R.id.pb_dialog_item_isugc)) {
                g05 g05Var3 = new g05(-2, mm8.u(R.string.action_dislike, new Object[0]), k05Var);
                g05Var3.d.setTag(sparseArray);
                arrayList.add(g05Var3);
            }
            g05 g05Var4 = new g05(-3, mm8.u(R.string.obfuscated_res_0x7f0f10c3, new Object[0]), k05Var);
            g05Var4.d.setTag(sparseArray);
            arrayList.add(0, g05Var4);
            g05 g05Var5 = new g05(-4, mm8.u(R.string.obfuscated_res_0x7f0f1211, new Object[0]), k05Var);
            g05Var5.d.setTag(sparseArray);
            arrayList.add(1, g05Var5);
            list.addAll(0, arrayList);
            return list;
        }
        return (List) invokeLLLL.objValue;
    }

    public static void e(Activity activity, @Nullable a9<?> a9Var, zz4.e eVar, zz4.e eVar2) {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeLLLL(InputDeviceCompat.SOURCE_TRACKBALL, null, activity, a9Var, eVar, eVar2) == null) {
            zz4 zz4Var = new zz4(activity);
            zz4Var.setMessageId(R.string.del_post_confirm);
            zz4Var.setPositiveButton(R.string.obfuscated_res_0x7f0f0523, eVar);
            zz4Var.setNegativeButton(R.string.obfuscated_res_0x7f0f051b, eVar2);
            zz4Var.setCancelable(true);
            zz4Var.create(a9Var);
            zz4Var.show();
        }
    }

    public static List<g05> f(List<g05> list) {
        InterceptResult invokeL;
        Interceptable interceptable = $ic;
        if (interceptable == null || (invokeL = interceptable.invokeL(65541, null, list)) == null) {
            if (list == null) {
                return list;
            }
            for (g05 g05Var : list) {
                g05Var.l(i(g05Var));
            }
            return list;
        }
        return (List) invokeL.objValue;
    }

    public static boolean j(PbModel pbModel) {
        InterceptResult invokeL;
        Interceptable interceptable = $ic;
        if (interceptable == null || (invokeL = interceptable.invokeL(65545, null, pbModel)) == null) {
            if (pbModel != null && pbModel.w1() != null && pbModel.w1().m0()) {
                return true;
            }
            return false;
        }
        return invokeL.booleanValue;
    }

    public static boolean k(aj8 aj8Var) {
        InterceptResult invokeL;
        Interceptable interceptable = $ic;
        if (interceptable == null || (invokeL = interceptable.invokeL(65546, null, aj8Var)) == null) {
            if (aj8Var != null && aj8Var.q()) {
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

    public static SpannableStringBuilder h(bc9 bc9Var) {
        InterceptResult invokeL;
        String str;
        Interceptable interceptable = $ic;
        if (interceptable == null || (invokeL = interceptable.invokeL(65543, null, bc9Var)) == null) {
            if (bc9Var == null) {
                return null;
            }
            if (bc9Var.Z() != null) {
                str = bc9Var.Z().toString();
            } else {
                str = "";
            }
            SpannableString o = o(bc9Var.r().getName_show() + ZeusCrashHandler.NAME_SEPERATOR, SkinManager.getColor(R.color.CAM_X0109));
            SpannableString o2 = o(str, SkinManager.getColor(R.color.CAM_X0107));
            SpannableStringBuilder spannableStringBuilder = new SpannableStringBuilder();
            spannableStringBuilder.append((CharSequence) o);
            spannableStringBuilder.append((CharSequence) o2);
            return spannableStringBuilder;
        }
        return (SpannableStringBuilder) invokeL.objValue;
    }

    public static Drawable i(g05 g05Var) {
        InterceptResult invokeL;
        Interceptable interceptable = $ic;
        if (interceptable == null || (invokeL = interceptable.invokeL(65544, null, g05Var)) == null) {
            switch (g05Var.f()) {
                case -4:
                    return WebPManager.getPureDrawable(R.drawable.icon_pure_pb_recommend_share30, SkinManager.getColor(R.color.CAM_X0107), null);
                case -3:
                    return WebPManager.getPureDrawable(R.drawable.icon_pure_pb_recommend_comment30, SkinManager.getColor(R.color.CAM_X0107), null);
                case -2:
                    if (mm8.u(R.string.c_disagree, new Object[0]).equals(g05Var.g())) {
                        return WebPManager.getPureDrawable(R.drawable.icon_pure_pb_recommend_dislike30, SkinManager.getColor(R.color.CAM_X0107), null);
                    }
                    return WebPManager.getPureDrawable(R.drawable.icon_pure_pb_recommend_disliked30, SkinManager.getColor(R.color.CAM_X0107), null);
                case -1:
                    if (mm8.u(R.string.c_agree, new Object[0]).equals(g05Var.g())) {
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
                    if (mm8.u(R.string.obfuscated_res_0x7f0f0b5c, new Object[0]).equals(g05Var.g())) {
                        return WebPManager.getPureDrawable(R.drawable.icon_pure_pb_recommend_collect30, SkinManager.getColor(R.color.CAM_X0107), null);
                    }
                    return WebPManager.getPureDrawable(R.drawable.icon_pure_pb_recommend_collected30, SkinManager.getColor(R.color.CAM_X0305), null);
                case 5:
                    if (mm8.u(R.string.report_text, new Object[0]).equals(g05Var.g())) {
                        return WebPManager.getPureDrawable(R.drawable.icon_pure_pb_recommend_report30, SkinManager.getColor(R.color.CAM_X0107), null);
                    }
                    if (!mm8.u(R.string.obfuscated_res_0x7f0f0c00, new Object[0]).equals(g05Var.g())) {
                        return null;
                    }
                    return WebPManager.getPureDrawable(R.drawable.icon_pure_pb_recommend_nospeakingset30, SkinManager.getColor(R.color.CAM_X0107), null);
                case 6:
                    if (mm8.u(R.string.report_text, new Object[0]).equals(g05Var.g())) {
                        return WebPManager.getPureDrawable(R.drawable.icon_pure_pb_recommend_report30, SkinManager.getColor(R.color.CAM_X0107), null);
                    }
                    if (!mm8.u(R.string.obfuscated_res_0x7f0f04db, new Object[0]).equals(g05Var.g())) {
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
                    if (mm8.u(R.string.obfuscated_res_0x7f0f04e8, new Object[0]).equals(g05Var.g())) {
                        return WebPManager.getPureDrawable(R.drawable.icon_pure_pb_recommend_delete30, SkinManager.getColor(R.color.CAM_X0107), null);
                    }
                    if (!mm8.u(R.string.obfuscated_res_0x7f0f04db, new Object[0]).equals(g05Var.g())) {
                        return null;
                    }
                    return WebPManager.getPureDrawable(R.drawable.icon_pure_pb_recommend_delete30, SkinManager.getColor(R.color.CAM_X0107), null);
                case 11:
                    return WebPManager.getPureDrawable(R.drawable.icon_pure_pb_recommend_block30, SkinManager.getColor(R.color.CAM_X0107), null);
                case 12:
                    if (mm8.u(R.string.obfuscated_res_0x7f0f0bfc, new Object[0]).equals(g05Var.g())) {
                        return WebPManager.getPureDrawable(R.drawable.icon_pure_pb_recommend_nospeaking30, SkinManager.getColor(R.color.CAM_X0107), null);
                    }
                    if (!mm8.u(R.string.un_mute, new Object[0]).equals(g05Var.g())) {
                        return null;
                    }
                    return WebPManager.getPureDrawable(R.drawable.icon_pure_pb_recommend_nospeakinged30, SkinManager.getColor(R.color.CAM_X0107), null);
                case 13:
                    return WebPManager.getPureDrawable(R.drawable.icon_pure_pb_batch_delete, SkinManager.getColor(R.color.CAM_X0107), null);
            }
        }
        return (Drawable) invokeL.objValue;
    }

    public static boolean l(bc9 bc9Var) {
        InterceptResult invokeL;
        Interceptable interceptable = $ic;
        if (interceptable == null || (invokeL = interceptable.invokeL(65547, null, bc9Var)) == null) {
            if (bc9Var != null && bc9Var.r() != null && !StringUtils.isNull(bc9Var.r().getUserId()) && bc9Var.r().getUserId().equals(TbadkCoreApplication.getCurrentAccount())) {
                return true;
            }
            return false;
        }
        return invokeL.booleanValue;
    }

    public static List<g05> m(List<g05> list, boolean z) {
        InterceptResult invokeLZ;
        Interceptable interceptable = $ic;
        if (interceptable == null || (invokeLZ = interceptable.invokeLZ(65548, null, list, z)) == null) {
            if (list != null && !z) {
                Iterator<g05> it = list.iterator();
                while (it.hasNext()) {
                    g05 next = it.next();
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
