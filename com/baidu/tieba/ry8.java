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
import com.baidu.tieba.c05;
import com.baidu.tieba.pb.pb.main.PbModel;
import com.baidu.tieba.tbadkCore.data.AgreeData;
import com.baidu.titan.sdk.runtime.FieldHolder;
import com.baidu.titan.sdk.runtime.InterceptResult;
import com.baidu.titan.sdk.runtime.Interceptable;
import com.baidu.webkit.sdk.dumper.ZeusCrashHandler;
import java.util.ArrayList;
import java.util.Iterator;
import java.util.List;
/* loaded from: classes6.dex */
public class ry8 {
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

    public static boolean a(List<j05> list, n05 n05Var, sl9 sl9Var, ot8 ot8Var, boolean z) {
        InterceptResult invokeCommon;
        Interceptable interceptable = $ic;
        if (interceptable == null || (invokeCommon = interceptable.invokeCommon(65536, null, new Object[]{list, n05Var, sl9Var, ot8Var, Boolean.valueOf(z)})) == null) {
            if (list == null || sl9Var == null || ot8Var == null || !z || !ot8Var.o() || !TbadkCoreApplication.isLogin() || l(sl9Var) || ot8Var.n()) {
                return false;
            }
            j05 j05Var = new j05(9, TbadkCoreApplication.getInst().getString(R.string.obfuscated_res_0x7f0f032e), n05Var);
            list.add(j05Var);
            et9.f(j05Var.d, sl9Var);
            return true;
        }
        return invokeCommon.booleanValue;
    }

    public static boolean b(List<j05> list, n05 n05Var, sl9 sl9Var, PbModel pbModel) {
        InterceptResult invokeLLLL;
        Interceptable interceptable = $ic;
        if (interceptable == null || (invokeLLLL = interceptable.invokeLLLL(65537, null, list, n05Var, sl9Var, pbModel)) == null) {
            if (list != null && sl9Var != null && pbModel != null && pbModel.u1() != null) {
                zs8 u1 = pbModel.u1();
                if (u1.i0() && TbadkCoreApplication.isLogin() && !l(sl9Var) && !u1.h0()) {
                    j05 j05Var = new j05(9, TbadkCoreApplication.getInst().getString(R.string.obfuscated_res_0x7f0f032e), n05Var);
                    list.add(j05Var);
                    et9.f(j05Var.d, sl9Var);
                    return true;
                }
            }
            return false;
        }
        return invokeLLLL.booleanValue;
    }

    public static List<j05> c(List<j05> list, AgreeData agreeData, SparseArray<?> sparseArray, n05 n05Var) {
        InterceptResult invokeLLLL;
        Interceptable interceptable = $ic;
        if (interceptable == null || (invokeLLLL = interceptable.invokeLLLL(65538, null, list, agreeData, sparseArray, n05Var)) == null) {
            if (list == null) {
                list = new ArrayList<>();
            }
            ArrayList arrayList = new ArrayList();
            if (agreeData.hasAgree) {
                if (agreeData.agreeType == 2) {
                    j05 j05Var = new j05(-1, ww8.t(R.string.c_agreeed, new Object[0]), n05Var);
                    j05Var.d.setTag(sparseArray);
                    arrayList.add(j05Var);
                    if (!g(sparseArray, R.id.pb_dialog_item_isugc)) {
                        j05 j05Var2 = new j05(-2, ww8.t(R.string.c_disagree, new Object[0]), n05Var);
                        j05Var2.d.setTag(sparseArray);
                        arrayList.add(j05Var2);
                    }
                } else {
                    j05 j05Var3 = new j05(-1, ww8.t(R.string.c_agree, new Object[0]), n05Var);
                    j05Var3.d.setTag(sparseArray);
                    arrayList.add(j05Var3);
                    if (!g(sparseArray, R.id.pb_dialog_item_isugc)) {
                        j05 j05Var4 = new j05(-2, ww8.t(R.string.c_disagreeed, new Object[0]), n05Var);
                        j05Var4.d.setTag(sparseArray);
                        arrayList.add(j05Var4);
                    }
                }
            } else {
                j05 j05Var5 = new j05(-1, ww8.t(R.string.c_agree, new Object[0]), n05Var);
                j05Var5.d.setTag(sparseArray);
                arrayList.add(j05Var5);
                if (!g(sparseArray, R.id.pb_dialog_item_isugc)) {
                    j05 j05Var6 = new j05(-2, ww8.t(R.string.c_disagree, new Object[0]), n05Var);
                    j05Var6.d.setTag(sparseArray);
                    arrayList.add(j05Var6);
                }
            }
            j05 j05Var7 = new j05(-3, ww8.t(R.string.obfuscated_res_0x7f0f10bc, new Object[0]), n05Var);
            j05Var7.d.setTag(sparseArray);
            arrayList.add(j05Var7);
            j05 j05Var8 = new j05(-4, ww8.t(R.string.obfuscated_res_0x7f0f1208, new Object[0]), n05Var);
            j05Var8.d.setTag(sparseArray);
            arrayList.add(j05Var8);
            list.addAll(0, arrayList);
            return list;
        }
        return (List) invokeLLLL.objValue;
    }

    public static List<j05> d(List<j05> list, AgreeData agreeData, SparseArray<?> sparseArray, n05 n05Var) {
        InterceptResult invokeLLLL;
        Interceptable interceptable = $ic;
        if (interceptable == null || (invokeLLLL = interceptable.invokeLLLL(65539, null, list, agreeData, sparseArray, n05Var)) == null) {
            if (list == null) {
                list = new ArrayList<>();
            }
            ArrayList arrayList = new ArrayList();
            if (agreeData.hasAgree) {
                if (agreeData.agreeType == 2) {
                    if (!g(sparseArray, R.id.pb_dialog_item_isugc)) {
                        j05 j05Var = new j05(-2, ww8.t(R.string.action_dislike, new Object[0]), n05Var);
                        j05Var.d.setTag(sparseArray);
                        arrayList.add(j05Var);
                    }
                } else if (!g(sparseArray, R.id.pb_dialog_item_isugc)) {
                    j05 j05Var2 = new j05(-2, ww8.t(R.string.c_disagreeed, new Object[0]), n05Var);
                    j05Var2.d.setTag(sparseArray);
                    arrayList.add(j05Var2);
                }
            } else if (!g(sparseArray, R.id.pb_dialog_item_isugc)) {
                j05 j05Var3 = new j05(-2, ww8.t(R.string.action_dislike, new Object[0]), n05Var);
                j05Var3.d.setTag(sparseArray);
                arrayList.add(j05Var3);
            }
            j05 j05Var4 = new j05(-3, ww8.t(R.string.obfuscated_res_0x7f0f10bc, new Object[0]), n05Var);
            j05Var4.d.setTag(sparseArray);
            arrayList.add(0, j05Var4);
            j05 j05Var5 = new j05(-4, ww8.t(R.string.obfuscated_res_0x7f0f1208, new Object[0]), n05Var);
            j05Var5.d.setTag(sparseArray);
            arrayList.add(1, j05Var5);
            list.addAll(0, arrayList);
            return list;
        }
        return (List) invokeLLLL.objValue;
    }

    public static void e(Activity activity, @Nullable a9<?> a9Var, c05.e eVar, c05.e eVar2) {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeLLLL(InputDeviceCompat.SOURCE_TRACKBALL, null, activity, a9Var, eVar, eVar2) == null) {
            c05 c05Var = new c05(activity);
            c05Var.setMessageId(R.string.del_post_confirm);
            c05Var.setPositiveButton(R.string.obfuscated_res_0x7f0f0521, eVar);
            c05Var.setNegativeButton(R.string.obfuscated_res_0x7f0f0519, eVar2);
            c05Var.setCancelable(true);
            c05Var.create(a9Var);
            c05Var.show();
        }
    }

    public static List<j05> f(List<j05> list) {
        InterceptResult invokeL;
        Interceptable interceptable = $ic;
        if (interceptable == null || (invokeL = interceptable.invokeL(65541, null, list)) == null) {
            if (list == null) {
                return list;
            }
            for (j05 j05Var : list) {
                j05Var.l(i(j05Var));
            }
            return list;
        }
        return (List) invokeL.objValue;
    }

    public static boolean j(PbModel pbModel) {
        InterceptResult invokeL;
        Interceptable interceptable = $ic;
        if (interceptable == null || (invokeL = interceptable.invokeL(65545, null, pbModel)) == null) {
            if (pbModel != null && pbModel.u1() != null && pbModel.u1().i0()) {
                return true;
            }
            return false;
        }
        return invokeL.booleanValue;
    }

    public static boolean k(ot8 ot8Var) {
        InterceptResult invokeL;
        Interceptable interceptable = $ic;
        if (interceptable == null || (invokeL = interceptable.invokeL(65546, null, ot8Var)) == null) {
            if (ot8Var != null && ot8Var.o()) {
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

    public static SpannableStringBuilder h(sl9 sl9Var) {
        InterceptResult invokeL;
        String str;
        Interceptable interceptable = $ic;
        if (interceptable == null || (invokeL = interceptable.invokeL(65543, null, sl9Var)) == null) {
            if (sl9Var == null) {
                return null;
            }
            if (sl9Var.a0() != null) {
                str = sl9Var.a0().toString();
            } else {
                str = "";
            }
            SpannableString o = o(sl9Var.q().getName_show() + ZeusCrashHandler.NAME_SEPERATOR, SkinManager.getColor(R.color.CAM_X0109));
            SpannableString o2 = o(str, SkinManager.getColor(R.color.CAM_X0107));
            SpannableStringBuilder spannableStringBuilder = new SpannableStringBuilder();
            spannableStringBuilder.append((CharSequence) o);
            spannableStringBuilder.append((CharSequence) o2);
            return spannableStringBuilder;
        }
        return (SpannableStringBuilder) invokeL.objValue;
    }

    public static Drawable i(j05 j05Var) {
        InterceptResult invokeL;
        Interceptable interceptable = $ic;
        if (interceptable == null || (invokeL = interceptable.invokeL(65544, null, j05Var)) == null) {
            switch (j05Var.f()) {
                case -4:
                    return WebPManager.getPureDrawable(R.drawable.icon_pure_pb_recommend_share30, SkinManager.getColor(R.color.CAM_X0107), null);
                case -3:
                    return WebPManager.getPureDrawable(R.drawable.icon_pure_pb_recommend_comment30, SkinManager.getColor(R.color.CAM_X0107), null);
                case -2:
                    if (ww8.t(R.string.c_disagree, new Object[0]).equals(j05Var.g())) {
                        return WebPManager.getPureDrawable(R.drawable.icon_pure_pb_recommend_dislike30, SkinManager.getColor(R.color.CAM_X0107), null);
                    }
                    return WebPManager.getPureDrawable(R.drawable.icon_pure_pb_recommend_disliked30, SkinManager.getColor(R.color.CAM_X0107), null);
                case -1:
                    if (ww8.t(R.string.c_agree, new Object[0]).equals(j05Var.g())) {
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
                    if (ww8.t(R.string.obfuscated_res_0x7f0f0b58, new Object[0]).equals(j05Var.g())) {
                        return WebPManager.getPureDrawable(R.drawable.icon_pure_pb_recommend_collect30, SkinManager.getColor(R.color.CAM_X0107), null);
                    }
                    return WebPManager.getPureDrawable(R.drawable.icon_pure_pb_recommend_collected30, SkinManager.getColor(R.color.CAM_X0305), null);
                case 5:
                    if (ww8.t(R.string.report_text, new Object[0]).equals(j05Var.g())) {
                        return WebPManager.getPureDrawable(R.drawable.icon_pure_pb_recommend_report30, SkinManager.getColor(R.color.CAM_X0107), null);
                    }
                    if (!ww8.t(R.string.obfuscated_res_0x7f0f0bfc, new Object[0]).equals(j05Var.g())) {
                        return null;
                    }
                    return WebPManager.getPureDrawable(R.drawable.icon_pure_pb_recommend_nospeakingset30, SkinManager.getColor(R.color.CAM_X0107), null);
                case 6:
                    if (ww8.t(R.string.report_text, new Object[0]).equals(j05Var.g())) {
                        return WebPManager.getPureDrawable(R.drawable.icon_pure_pb_recommend_report30, SkinManager.getColor(R.color.CAM_X0107), null);
                    }
                    if (!ww8.t(R.string.obfuscated_res_0x7f0f04d9, new Object[0]).equals(j05Var.g())) {
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
                    if (ww8.t(R.string.obfuscated_res_0x7f0f04e6, new Object[0]).equals(j05Var.g())) {
                        return WebPManager.getPureDrawable(R.drawable.icon_pure_pb_recommend_delete30, SkinManager.getColor(R.color.CAM_X0107), null);
                    }
                    if (!ww8.t(R.string.obfuscated_res_0x7f0f04d9, new Object[0]).equals(j05Var.g())) {
                        return null;
                    }
                    return WebPManager.getPureDrawable(R.drawable.icon_pure_pb_recommend_delete30, SkinManager.getColor(R.color.CAM_X0107), null);
                case 11:
                    return WebPManager.getPureDrawable(R.drawable.icon_pure_pb_recommend_block30, SkinManager.getColor(R.color.CAM_X0107), null);
                case 12:
                    if (ww8.t(R.string.obfuscated_res_0x7f0f0bf8, new Object[0]).equals(j05Var.g())) {
                        return WebPManager.getPureDrawable(R.drawable.icon_pure_pb_recommend_nospeaking30, SkinManager.getColor(R.color.CAM_X0107), null);
                    }
                    if (!ww8.t(R.string.un_mute, new Object[0]).equals(j05Var.g())) {
                        return null;
                    }
                    return WebPManager.getPureDrawable(R.drawable.icon_pure_pb_recommend_nospeakinged30, SkinManager.getColor(R.color.CAM_X0107), null);
                case 13:
                    return WebPManager.getPureDrawable(R.drawable.icon_pure_pb_batch_delete, SkinManager.getColor(R.color.CAM_X0107), null);
            }
        }
        return (Drawable) invokeL.objValue;
    }

    public static boolean l(sl9 sl9Var) {
        InterceptResult invokeL;
        Interceptable interceptable = $ic;
        if (interceptable == null || (invokeL = interceptable.invokeL(65547, null, sl9Var)) == null) {
            if (sl9Var != null && sl9Var.q() != null && !StringUtils.isNull(sl9Var.q().getUserId()) && sl9Var.q().getUserId().equals(TbadkCoreApplication.getCurrentAccount())) {
                return true;
            }
            return false;
        }
        return invokeL.booleanValue;
    }

    public static List<j05> m(List<j05> list, boolean z) {
        InterceptResult invokeLZ;
        Interceptable interceptable = $ic;
        if (interceptable == null || (invokeLZ = interceptable.invokeLZ(65548, null, list, z)) == null) {
            if (list != null && !z) {
                Iterator<j05> it = list.iterator();
                while (it.hasNext()) {
                    j05 next = it.next();
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
