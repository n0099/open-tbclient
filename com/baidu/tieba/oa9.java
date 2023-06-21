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
import com.baidu.tieba.d55;
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
public class oa9 {
    public static /* synthetic */ Interceptable $ic;
    public transient /* synthetic */ FieldHolder $fh;

    public static int m(int i) {
        InterceptResult invokeI;
        Interceptable interceptable = $ic;
        if (interceptable == null || (invokeI = interceptable.invokeI(65548, null, i)) == null) {
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

    public static boolean a(List<k55> list, o55 o55Var, b0a b0aVar, a59 a59Var, boolean z) {
        InterceptResult invokeCommon;
        Interceptable interceptable = $ic;
        if (interceptable == null || (invokeCommon = interceptable.invokeCommon(65536, null, new Object[]{list, o55Var, b0aVar, a59Var, Boolean.valueOf(z)})) == null) {
            if (list == null || b0aVar == null || a59Var == null || !z || !a59Var.o() || !TbadkCoreApplication.isLogin() || k(b0aVar) || a59Var.n()) {
                return false;
            }
            k55 k55Var = new k55(9, TbadkCoreApplication.getInst().getString(R.string.obfuscated_res_0x7f0f0363), o55Var);
            list.add(k55Var);
            s7a.f(k55Var.d, b0aVar);
            return true;
        }
        return invokeCommon.booleanValue;
    }

    public static boolean b(List<k55> list, o55 o55Var, b0a b0aVar, PbModel pbModel) {
        InterceptResult invokeLLLL;
        Interceptable interceptable = $ic;
        if (interceptable == null || (invokeLLLL = interceptable.invokeLLLL(65537, null, list, o55Var, b0aVar, pbModel)) == null) {
            if (list != null && b0aVar != null && pbModel != null && pbModel.y1() != null) {
                j49 y1 = pbModel.y1();
                if (y1.j0() && TbadkCoreApplication.isLogin() && !k(b0aVar) && !y1.i0()) {
                    k55 k55Var = new k55(9, TbadkCoreApplication.getInst().getString(R.string.obfuscated_res_0x7f0f0363), o55Var);
                    list.add(k55Var);
                    s7a.f(k55Var.d, b0aVar);
                    return true;
                }
            }
            return false;
        }
        return invokeLLLL.booleanValue;
    }

    public static List<k55> c(List<k55> list, AgreeData agreeData, SparseArray<?> sparseArray, o55 o55Var) {
        InterceptResult invokeLLLL;
        Interceptable interceptable = $ic;
        if (interceptable == null || (invokeLLLL = interceptable.invokeLLLL(65538, null, list, agreeData, sparseArray, o55Var)) == null) {
            if (list == null) {
                list = new ArrayList<>();
            }
            ArrayList arrayList = new ArrayList();
            if (agreeData.hasAgree) {
                if (agreeData.agreeType == 2) {
                    k55 k55Var = new k55(-1, q89.t(R.string.c_agreeed, new Object[0]), o55Var);
                    k55Var.d.setTag(sparseArray);
                    arrayList.add(k55Var);
                    if (!f(sparseArray, R.id.pb_dialog_item_isugc)) {
                        k55 k55Var2 = new k55(-2, q89.t(R.string.c_disagree, new Object[0]), o55Var);
                        k55Var2.d.setTag(sparseArray);
                        arrayList.add(k55Var2);
                    }
                } else {
                    k55 k55Var3 = new k55(-1, q89.t(R.string.c_agree, new Object[0]), o55Var);
                    k55Var3.d.setTag(sparseArray);
                    arrayList.add(k55Var3);
                    if (!f(sparseArray, R.id.pb_dialog_item_isugc)) {
                        k55 k55Var4 = new k55(-2, q89.t(R.string.c_disagreeed, new Object[0]), o55Var);
                        k55Var4.d.setTag(sparseArray);
                        arrayList.add(k55Var4);
                    }
                }
            } else {
                k55 k55Var5 = new k55(-1, q89.t(R.string.c_agree, new Object[0]), o55Var);
                k55Var5.d.setTag(sparseArray);
                arrayList.add(k55Var5);
                if (!f(sparseArray, R.id.pb_dialog_item_isugc)) {
                    k55 k55Var6 = new k55(-2, q89.t(R.string.c_disagree, new Object[0]), o55Var);
                    k55Var6.d.setTag(sparseArray);
                    arrayList.add(k55Var6);
                }
            }
            k55 k55Var7 = new k55(-3, q89.t(R.string.obfuscated_res_0x7f0f11f1, new Object[0]), o55Var);
            k55Var7.d.setTag(sparseArray);
            arrayList.add(k55Var7);
            k55 k55Var8 = new k55(-4, q89.t(R.string.obfuscated_res_0x7f0f1343, new Object[0]), o55Var);
            k55Var8.d.setTag(sparseArray);
            arrayList.add(k55Var8);
            list.addAll(0, arrayList);
            return list;
        }
        return (List) invokeLLLL.objValue;
    }

    public static void d(Activity activity, @Nullable k9<?> k9Var, d55.e eVar, d55.e eVar2) {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeLLLL(65539, null, activity, k9Var, eVar, eVar2) == null) {
            d55 d55Var = new d55(activity);
            d55Var.setMessageId(R.string.del_post_confirm);
            d55Var.setPositiveButton(R.string.obfuscated_res_0x7f0f0590, eVar);
            d55Var.setNegativeButton(R.string.obfuscated_res_0x7f0f0585, eVar2);
            d55Var.setCancelable(true);
            d55Var.create(k9Var);
            d55Var.show();
        }
    }

    public static List<k55> e(List<k55> list) {
        InterceptResult invokeL;
        Interceptable interceptable = $ic;
        if (interceptable == null || (invokeL = interceptable.invokeL(InputDeviceCompat.SOURCE_TRACKBALL, null, list)) == null) {
            if (list == null) {
                return list;
            }
            for (k55 k55Var : list) {
                k55Var.l(h(k55Var));
            }
            return list;
        }
        return (List) invokeL.objValue;
    }

    public static boolean i(PbModel pbModel) {
        InterceptResult invokeL;
        Interceptable interceptable = $ic;
        if (interceptable == null || (invokeL = interceptable.invokeL(65544, null, pbModel)) == null) {
            if (pbModel != null && pbModel.y1() != null && pbModel.y1().j0()) {
                return true;
            }
            return false;
        }
        return invokeL.booleanValue;
    }

    public static boolean j(a59 a59Var) {
        InterceptResult invokeL;
        Interceptable interceptable = $ic;
        if (interceptable == null || (invokeL = interceptable.invokeL(65545, null, a59Var)) == null) {
            if (a59Var != null && a59Var.o()) {
                return true;
            }
            return false;
        }
        return invokeL.booleanValue;
    }

    public static boolean f(SparseArray<?> sparseArray, int i) {
        InterceptResult invokeLI;
        Interceptable interceptable = $ic;
        if (interceptable == null || (invokeLI = interceptable.invokeLI(65541, null, sparseArray, i)) == null) {
            if (sparseArray != null && (sparseArray.get(i) instanceof Boolean)) {
                return ((Boolean) sparseArray.get(i)).booleanValue();
            }
            return false;
        }
        return invokeLI.booleanValue;
    }

    public static SpannableString n(String str, int i) {
        InterceptResult invokeLI;
        Interceptable interceptable = $ic;
        if (interceptable == null || (invokeLI = interceptable.invokeLI(65549, null, str, i)) == null) {
            SpannableString spannableString = new SpannableString(str);
            spannableString.setSpan(new ForegroundColorSpan(i), 0, str.length(), 33);
            return spannableString;
        }
        return (SpannableString) invokeLI.objValue;
    }

    public static SpannableStringBuilder g(b0a b0aVar) {
        InterceptResult invokeL;
        String str;
        Interceptable interceptable = $ic;
        if (interceptable == null || (invokeL = interceptable.invokeL(65542, null, b0aVar)) == null) {
            if (b0aVar == null) {
                return null;
            }
            if (b0aVar.e0() != null) {
                str = b0aVar.e0().toString();
            } else {
                str = "";
            }
            SpannableString n = n(b0aVar.q().getName_show() + ZeusCrashHandler.NAME_SEPERATOR, SkinManager.getColor(R.color.CAM_X0109));
            SpannableString n2 = n(str, SkinManager.getColor(R.color.CAM_X0107));
            SpannableStringBuilder spannableStringBuilder = new SpannableStringBuilder();
            spannableStringBuilder.append((CharSequence) n);
            spannableStringBuilder.append((CharSequence) n2);
            return spannableStringBuilder;
        }
        return (SpannableStringBuilder) invokeL.objValue;
    }

    public static Drawable h(k55 k55Var) {
        InterceptResult invokeL;
        Interceptable interceptable = $ic;
        if (interceptable == null || (invokeL = interceptable.invokeL(65543, null, k55Var)) == null) {
            switch (k55Var.f()) {
                case -4:
                    return WebPManager.getPureDrawable(R.drawable.icon_pure_pb_recommend_share30, SkinManager.getColor(R.color.CAM_X0107), null);
                case -3:
                    return WebPManager.getPureDrawable(R.drawable.icon_pure_pb_recommend_comment30, SkinManager.getColor(R.color.CAM_X0107), null);
                case -2:
                    if (q89.t(R.string.c_disagree, new Object[0]).equals(k55Var.g())) {
                        return WebPManager.getPureDrawable(R.drawable.icon_pure_pb_recommend_dislike30, SkinManager.getColor(R.color.CAM_X0107), null);
                    }
                    return WebPManager.getPureDrawable(R.drawable.icon_pure_pb_recommend_disliked30, SkinManager.getColor(R.color.CAM_X0107), null);
                case -1:
                    if (q89.t(R.string.c_agree, new Object[0]).equals(k55Var.g())) {
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
                    if (q89.t(R.string.obfuscated_res_0x7f0f0c2b, new Object[0]).equals(k55Var.g())) {
                        return WebPManager.getPureDrawable(R.drawable.icon_pure_pb_recommend_collect30, SkinManager.getColor(R.color.CAM_X0107), null);
                    }
                    return WebPManager.getPureDrawable(R.drawable.icon_pure_pb_recommend_collected30, SkinManager.getColor(R.color.CAM_X0305), null);
                case 5:
                    if (q89.t(R.string.report_text, new Object[0]).equals(k55Var.g())) {
                        return WebPManager.getPureDrawable(R.drawable.icon_pure_pb_recommend_report30, SkinManager.getColor(R.color.CAM_X0107), null);
                    }
                    if (!q89.t(R.string.obfuscated_res_0x7f0f0cd4, new Object[0]).equals(k55Var.g())) {
                        return null;
                    }
                    return WebPManager.getPureDrawable(R.drawable.icon_pure_pb_recommend_nospeakingset30, SkinManager.getColor(R.color.CAM_X0107), null);
                case 6:
                    if (q89.t(R.string.report_text, new Object[0]).equals(k55Var.g())) {
                        return WebPManager.getPureDrawable(R.drawable.icon_pure_pb_recommend_report30, SkinManager.getColor(R.color.CAM_X0107), null);
                    }
                    if (!q89.t(R.string.obfuscated_res_0x7f0f0540, new Object[0]).equals(k55Var.g())) {
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
                    if (q89.t(R.string.obfuscated_res_0x7f0f054f, new Object[0]).equals(k55Var.g())) {
                        return WebPManager.getPureDrawable(R.drawable.icon_pure_pb_recommend_delete30, SkinManager.getColor(R.color.CAM_X0107), null);
                    }
                    if (!q89.t(R.string.obfuscated_res_0x7f0f0540, new Object[0]).equals(k55Var.g())) {
                        return null;
                    }
                    return WebPManager.getPureDrawable(R.drawable.icon_pure_pb_recommend_delete30, SkinManager.getColor(R.color.CAM_X0107), null);
                case 11:
                    return WebPManager.getPureDrawable(R.drawable.icon_pure_pb_recommend_block30, SkinManager.getColor(R.color.CAM_X0107), null);
                case 12:
                    if (q89.t(R.string.obfuscated_res_0x7f0f0cd0, new Object[0]).equals(k55Var.g())) {
                        return WebPManager.getPureDrawable(R.drawable.icon_pure_pb_recommend_nospeaking30, SkinManager.getColor(R.color.CAM_X0107), null);
                    }
                    if (!q89.t(R.string.un_mute, new Object[0]).equals(k55Var.g())) {
                        return null;
                    }
                    return WebPManager.getPureDrawable(R.drawable.icon_pure_pb_recommend_nospeakinged30, SkinManager.getColor(R.color.CAM_X0107), null);
                case 13:
                    return WebPManager.getPureDrawable(R.drawable.icon_pure_pb_batch_delete, SkinManager.getColor(R.color.CAM_X0107), null);
            }
        }
        return (Drawable) invokeL.objValue;
    }

    public static boolean k(b0a b0aVar) {
        InterceptResult invokeL;
        Interceptable interceptable = $ic;
        if (interceptable == null || (invokeL = interceptable.invokeL(65546, null, b0aVar)) == null) {
            if (b0aVar != null && b0aVar.q() != null && !StringUtils.isNull(b0aVar.q().getUserId()) && b0aVar.q().getUserId().equals(TbadkCoreApplication.getCurrentAccount())) {
                return true;
            }
            return false;
        }
        return invokeL.booleanValue;
    }

    public static List<k55> l(List<k55> list, boolean z) {
        InterceptResult invokeLZ;
        Interceptable interceptable = $ic;
        if (interceptable == null || (invokeLZ = interceptable.invokeLZ(65547, null, list, z)) == null) {
            if (list != null && !z) {
                Iterator<k55> it = list.iterator();
                while (it.hasNext()) {
                    k55 next = it.next();
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
