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
import com.baidu.tieba.u05;
import com.baidu.titan.sdk.runtime.FieldHolder;
import com.baidu.titan.sdk.runtime.InterceptResult;
import com.baidu.titan.sdk.runtime.Interceptable;
import com.baidu.webkit.sdk.dumper.ZeusCrashHandler;
import java.util.ArrayList;
import java.util.Iterator;
import java.util.List;
/* loaded from: classes5.dex */
public class n19 {
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

    public static boolean a(List<b15> list, f15 f15Var, pp9 pp9Var, gw8 gw8Var, boolean z) {
        InterceptResult invokeCommon;
        Interceptable interceptable = $ic;
        if (interceptable == null || (invokeCommon = interceptable.invokeCommon(65536, null, new Object[]{list, f15Var, pp9Var, gw8Var, Boolean.valueOf(z)})) == null) {
            if (list == null || pp9Var == null || gw8Var == null || !z || !gw8Var.o() || !TbadkCoreApplication.isLogin() || l(pp9Var) || gw8Var.n()) {
                return false;
            }
            b15 b15Var = new b15(9, TbadkCoreApplication.getInst().getString(R.string.obfuscated_res_0x7f0f032c), f15Var);
            list.add(b15Var);
            hx9.f(b15Var.d, pp9Var);
            return true;
        }
        return invokeCommon.booleanValue;
    }

    public static boolean b(List<b15> list, f15 f15Var, pp9 pp9Var, PbModel pbModel) {
        InterceptResult invokeLLLL;
        Interceptable interceptable = $ic;
        if (interceptable == null || (invokeLLLL = interceptable.invokeLLLL(65537, null, list, f15Var, pp9Var, pbModel)) == null) {
            if (list != null && pp9Var != null && pbModel != null && pbModel.z1() != null) {
                qv8 z1 = pbModel.z1();
                if (z1.i0() && TbadkCoreApplication.isLogin() && !l(pp9Var) && !z1.h0()) {
                    b15 b15Var = new b15(9, TbadkCoreApplication.getInst().getString(R.string.obfuscated_res_0x7f0f032c), f15Var);
                    list.add(b15Var);
                    hx9.f(b15Var.d, pp9Var);
                    return true;
                }
            }
            return false;
        }
        return invokeLLLL.booleanValue;
    }

    public static List<b15> c(List<b15> list, AgreeData agreeData, SparseArray<?> sparseArray, f15 f15Var) {
        InterceptResult invokeLLLL;
        Interceptable interceptable = $ic;
        if (interceptable == null || (invokeLLLL = interceptable.invokeLLLL(65538, null, list, agreeData, sparseArray, f15Var)) == null) {
            if (list == null) {
                list = new ArrayList<>();
            }
            ArrayList arrayList = new ArrayList();
            if (agreeData.hasAgree) {
                if (agreeData.agreeType == 2) {
                    b15 b15Var = new b15(-1, sz8.s(R.string.c_agreeed, new Object[0]), f15Var);
                    b15Var.d.setTag(sparseArray);
                    arrayList.add(b15Var);
                    if (!g(sparseArray, R.id.pb_dialog_item_isugc)) {
                        b15 b15Var2 = new b15(-2, sz8.s(R.string.c_disagree, new Object[0]), f15Var);
                        b15Var2.d.setTag(sparseArray);
                        arrayList.add(b15Var2);
                    }
                } else {
                    b15 b15Var3 = new b15(-1, sz8.s(R.string.c_agree, new Object[0]), f15Var);
                    b15Var3.d.setTag(sparseArray);
                    arrayList.add(b15Var3);
                    if (!g(sparseArray, R.id.pb_dialog_item_isugc)) {
                        b15 b15Var4 = new b15(-2, sz8.s(R.string.c_disagreeed, new Object[0]), f15Var);
                        b15Var4.d.setTag(sparseArray);
                        arrayList.add(b15Var4);
                    }
                }
            } else {
                b15 b15Var5 = new b15(-1, sz8.s(R.string.c_agree, new Object[0]), f15Var);
                b15Var5.d.setTag(sparseArray);
                arrayList.add(b15Var5);
                if (!g(sparseArray, R.id.pb_dialog_item_isugc)) {
                    b15 b15Var6 = new b15(-2, sz8.s(R.string.c_disagree, new Object[0]), f15Var);
                    b15Var6.d.setTag(sparseArray);
                    arrayList.add(b15Var6);
                }
            }
            b15 b15Var7 = new b15(-3, sz8.s(R.string.obfuscated_res_0x7f0f10d4, new Object[0]), f15Var);
            b15Var7.d.setTag(sparseArray);
            arrayList.add(b15Var7);
            b15 b15Var8 = new b15(-4, sz8.s(R.string.obfuscated_res_0x7f0f1221, new Object[0]), f15Var);
            b15Var8.d.setTag(sparseArray);
            arrayList.add(b15Var8);
            list.addAll(0, arrayList);
            return list;
        }
        return (List) invokeLLLL.objValue;
    }

    public static List<b15> d(List<b15> list, AgreeData agreeData, SparseArray<?> sparseArray, f15 f15Var) {
        InterceptResult invokeLLLL;
        Interceptable interceptable = $ic;
        if (interceptable == null || (invokeLLLL = interceptable.invokeLLLL(65539, null, list, agreeData, sparseArray, f15Var)) == null) {
            if (list == null) {
                list = new ArrayList<>();
            }
            ArrayList arrayList = new ArrayList();
            if (agreeData.hasAgree) {
                if (agreeData.agreeType == 2) {
                    if (!g(sparseArray, R.id.pb_dialog_item_isugc)) {
                        b15 b15Var = new b15(-2, sz8.s(R.string.action_dislike, new Object[0]), f15Var);
                        b15Var.d.setTag(sparseArray);
                        arrayList.add(b15Var);
                    }
                } else if (!g(sparseArray, R.id.pb_dialog_item_isugc)) {
                    b15 b15Var2 = new b15(-2, sz8.s(R.string.c_disagreeed, new Object[0]), f15Var);
                    b15Var2.d.setTag(sparseArray);
                    arrayList.add(b15Var2);
                }
            } else if (!g(sparseArray, R.id.pb_dialog_item_isugc)) {
                b15 b15Var3 = new b15(-2, sz8.s(R.string.action_dislike, new Object[0]), f15Var);
                b15Var3.d.setTag(sparseArray);
                arrayList.add(b15Var3);
            }
            b15 b15Var4 = new b15(-3, sz8.s(R.string.obfuscated_res_0x7f0f10d4, new Object[0]), f15Var);
            b15Var4.d.setTag(sparseArray);
            arrayList.add(0, b15Var4);
            b15 b15Var5 = new b15(-4, sz8.s(R.string.obfuscated_res_0x7f0f1221, new Object[0]), f15Var);
            b15Var5.d.setTag(sparseArray);
            arrayList.add(1, b15Var5);
            list.addAll(0, arrayList);
            return list;
        }
        return (List) invokeLLLL.objValue;
    }

    public static void e(Activity activity, @Nullable a9<?> a9Var, u05.e eVar, u05.e eVar2) {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeLLLL(InputDeviceCompat.SOURCE_TRACKBALL, null, activity, a9Var, eVar, eVar2) == null) {
            u05 u05Var = new u05(activity);
            u05Var.setMessageId(R.string.del_post_confirm);
            u05Var.setPositiveButton(R.string.obfuscated_res_0x7f0f052e, eVar);
            u05Var.setNegativeButton(R.string.obfuscated_res_0x7f0f0526, eVar2);
            u05Var.setCancelable(true);
            u05Var.create(a9Var);
            u05Var.show();
        }
    }

    public static List<b15> f(List<b15> list) {
        InterceptResult invokeL;
        Interceptable interceptable = $ic;
        if (interceptable == null || (invokeL = interceptable.invokeL(65541, null, list)) == null) {
            if (list == null) {
                return list;
            }
            for (b15 b15Var : list) {
                b15Var.l(i(b15Var));
            }
            return list;
        }
        return (List) invokeL.objValue;
    }

    public static boolean j(PbModel pbModel) {
        InterceptResult invokeL;
        Interceptable interceptable = $ic;
        if (interceptable == null || (invokeL = interceptable.invokeL(65545, null, pbModel)) == null) {
            if (pbModel != null && pbModel.z1() != null && pbModel.z1().i0()) {
                return true;
            }
            return false;
        }
        return invokeL.booleanValue;
    }

    public static boolean k(gw8 gw8Var) {
        InterceptResult invokeL;
        Interceptable interceptable = $ic;
        if (interceptable == null || (invokeL = interceptable.invokeL(65546, null, gw8Var)) == null) {
            if (gw8Var != null && gw8Var.o()) {
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

    public static SpannableStringBuilder h(pp9 pp9Var) {
        InterceptResult invokeL;
        String str;
        Interceptable interceptable = $ic;
        if (interceptable == null || (invokeL = interceptable.invokeL(65543, null, pp9Var)) == null) {
            if (pp9Var == null) {
                return null;
            }
            if (pp9Var.a0() != null) {
                str = pp9Var.a0().toString();
            } else {
                str = "";
            }
            SpannableString o = o(pp9Var.p().getName_show() + ZeusCrashHandler.NAME_SEPERATOR, SkinManager.getColor(R.color.CAM_X0109));
            SpannableString o2 = o(str, SkinManager.getColor(R.color.CAM_X0107));
            SpannableStringBuilder spannableStringBuilder = new SpannableStringBuilder();
            spannableStringBuilder.append((CharSequence) o);
            spannableStringBuilder.append((CharSequence) o2);
            return spannableStringBuilder;
        }
        return (SpannableStringBuilder) invokeL.objValue;
    }

    public static Drawable i(b15 b15Var) {
        InterceptResult invokeL;
        Interceptable interceptable = $ic;
        if (interceptable == null || (invokeL = interceptable.invokeL(65544, null, b15Var)) == null) {
            switch (b15Var.f()) {
                case -4:
                    return WebPManager.getPureDrawable(R.drawable.icon_pure_pb_recommend_share30, SkinManager.getColor(R.color.CAM_X0107), null);
                case -3:
                    return WebPManager.getPureDrawable(R.drawable.icon_pure_pb_recommend_comment30, SkinManager.getColor(R.color.CAM_X0107), null);
                case -2:
                    if (sz8.s(R.string.c_disagree, new Object[0]).equals(b15Var.g())) {
                        return WebPManager.getPureDrawable(R.drawable.icon_pure_pb_recommend_dislike30, SkinManager.getColor(R.color.CAM_X0107), null);
                    }
                    return WebPManager.getPureDrawable(R.drawable.icon_pure_pb_recommend_disliked30, SkinManager.getColor(R.color.CAM_X0107), null);
                case -1:
                    if (sz8.s(R.string.c_agree, new Object[0]).equals(b15Var.g())) {
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
                    if (sz8.s(R.string.obfuscated_res_0x7f0f0b6d, new Object[0]).equals(b15Var.g())) {
                        return WebPManager.getPureDrawable(R.drawable.icon_pure_pb_recommend_collect30, SkinManager.getColor(R.color.CAM_X0107), null);
                    }
                    return WebPManager.getPureDrawable(R.drawable.icon_pure_pb_recommend_collected30, SkinManager.getColor(R.color.CAM_X0305), null);
                case 5:
                    if (sz8.s(R.string.report_text, new Object[0]).equals(b15Var.g())) {
                        return WebPManager.getPureDrawable(R.drawable.icon_pure_pb_recommend_report30, SkinManager.getColor(R.color.CAM_X0107), null);
                    }
                    if (!sz8.s(R.string.obfuscated_res_0x7f0f0c11, new Object[0]).equals(b15Var.g())) {
                        return null;
                    }
                    return WebPManager.getPureDrawable(R.drawable.icon_pure_pb_recommend_nospeakingset30, SkinManager.getColor(R.color.CAM_X0107), null);
                case 6:
                    if (sz8.s(R.string.report_text, new Object[0]).equals(b15Var.g())) {
                        return WebPManager.getPureDrawable(R.drawable.icon_pure_pb_recommend_report30, SkinManager.getColor(R.color.CAM_X0107), null);
                    }
                    if (!sz8.s(R.string.obfuscated_res_0x7f0f04e3, new Object[0]).equals(b15Var.g())) {
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
                    if (sz8.s(R.string.obfuscated_res_0x7f0f04f0, new Object[0]).equals(b15Var.g())) {
                        return WebPManager.getPureDrawable(R.drawable.icon_pure_pb_recommend_delete30, SkinManager.getColor(R.color.CAM_X0107), null);
                    }
                    if (!sz8.s(R.string.obfuscated_res_0x7f0f04e3, new Object[0]).equals(b15Var.g())) {
                        return null;
                    }
                    return WebPManager.getPureDrawable(R.drawable.icon_pure_pb_recommend_delete30, SkinManager.getColor(R.color.CAM_X0107), null);
                case 11:
                    return WebPManager.getPureDrawable(R.drawable.icon_pure_pb_recommend_block30, SkinManager.getColor(R.color.CAM_X0107), null);
                case 12:
                    if (sz8.s(R.string.obfuscated_res_0x7f0f0c0d, new Object[0]).equals(b15Var.g())) {
                        return WebPManager.getPureDrawable(R.drawable.icon_pure_pb_recommend_nospeaking30, SkinManager.getColor(R.color.CAM_X0107), null);
                    }
                    if (!sz8.s(R.string.un_mute, new Object[0]).equals(b15Var.g())) {
                        return null;
                    }
                    return WebPManager.getPureDrawable(R.drawable.icon_pure_pb_recommend_nospeakinged30, SkinManager.getColor(R.color.CAM_X0107), null);
                case 13:
                    return WebPManager.getPureDrawable(R.drawable.icon_pure_pb_batch_delete, SkinManager.getColor(R.color.CAM_X0107), null);
            }
        }
        return (Drawable) invokeL.objValue;
    }

    public static boolean l(pp9 pp9Var) {
        InterceptResult invokeL;
        Interceptable interceptable = $ic;
        if (interceptable == null || (invokeL = interceptable.invokeL(65547, null, pp9Var)) == null) {
            if (pp9Var != null && pp9Var.p() != null && !StringUtils.isNull(pp9Var.p().getUserId()) && pp9Var.p().getUserId().equals(TbadkCoreApplication.getCurrentAccount())) {
                return true;
            }
            return false;
        }
        return invokeL.booleanValue;
    }

    public static List<b15> m(List<b15> list, boolean z) {
        InterceptResult invokeLZ;
        Interceptable interceptable = $ic;
        if (interceptable == null || (invokeLZ = interceptable.invokeLZ(65548, null, list, z)) == null) {
            if (list != null && !z) {
                Iterator<b15> it = list.iterator();
                while (it.hasNext()) {
                    b15 next = it.next();
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
