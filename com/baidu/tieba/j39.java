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
import com.baidu.tieba.d25;
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
public class j39 {
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

    public static boolean a(List<k25> list, o25 o25Var, sr9 sr9Var, cy8 cy8Var, boolean z) {
        InterceptResult invokeCommon;
        Interceptable interceptable = $ic;
        if (interceptable == null || (invokeCommon = interceptable.invokeCommon(65536, null, new Object[]{list, o25Var, sr9Var, cy8Var, Boolean.valueOf(z)})) == null) {
            if (list == null || sr9Var == null || cy8Var == null || !z || !cy8Var.o() || !TbadkCoreApplication.isLogin() || l(sr9Var) || cy8Var.n()) {
                return false;
            }
            k25 k25Var = new k25(9, TbadkCoreApplication.getInst().getString(R.string.obfuscated_res_0x7f0f035c), o25Var);
            list.add(k25Var);
            kz9.f(k25Var.d, sr9Var);
            return true;
        }
        return invokeCommon.booleanValue;
    }

    public static boolean b(List<k25> list, o25 o25Var, sr9 sr9Var, PbModel pbModel) {
        InterceptResult invokeLLLL;
        Interceptable interceptable = $ic;
        if (interceptable == null || (invokeLLLL = interceptable.invokeLLLL(65537, null, list, o25Var, sr9Var, pbModel)) == null) {
            if (list != null && sr9Var != null && pbModel != null && pbModel.y1() != null) {
                mx8 y1 = pbModel.y1();
                if (y1.i0() && TbadkCoreApplication.isLogin() && !l(sr9Var) && !y1.h0()) {
                    k25 k25Var = new k25(9, TbadkCoreApplication.getInst().getString(R.string.obfuscated_res_0x7f0f035c), o25Var);
                    list.add(k25Var);
                    kz9.f(k25Var.d, sr9Var);
                    return true;
                }
            }
            return false;
        }
        return invokeLLLL.booleanValue;
    }

    public static List<k25> c(List<k25> list, AgreeData agreeData, SparseArray<?> sparseArray, o25 o25Var) {
        InterceptResult invokeLLLL;
        Interceptable interceptable = $ic;
        if (interceptable == null || (invokeLLLL = interceptable.invokeLLLL(65538, null, list, agreeData, sparseArray, o25Var)) == null) {
            if (list == null) {
                list = new ArrayList<>();
            }
            ArrayList arrayList = new ArrayList();
            if (agreeData.hasAgree) {
                if (agreeData.agreeType == 2) {
                    k25 k25Var = new k25(-1, o19.t(R.string.c_agreeed, new Object[0]), o25Var);
                    k25Var.d.setTag(sparseArray);
                    arrayList.add(k25Var);
                    if (!g(sparseArray, R.id.pb_dialog_item_isugc)) {
                        k25 k25Var2 = new k25(-2, o19.t(R.string.c_disagree, new Object[0]), o25Var);
                        k25Var2.d.setTag(sparseArray);
                        arrayList.add(k25Var2);
                    }
                } else {
                    k25 k25Var3 = new k25(-1, o19.t(R.string.c_agree, new Object[0]), o25Var);
                    k25Var3.d.setTag(sparseArray);
                    arrayList.add(k25Var3);
                    if (!g(sparseArray, R.id.pb_dialog_item_isugc)) {
                        k25 k25Var4 = new k25(-2, o19.t(R.string.c_disagreeed, new Object[0]), o25Var);
                        k25Var4.d.setTag(sparseArray);
                        arrayList.add(k25Var4);
                    }
                }
            } else {
                k25 k25Var5 = new k25(-1, o19.t(R.string.c_agree, new Object[0]), o25Var);
                k25Var5.d.setTag(sparseArray);
                arrayList.add(k25Var5);
                if (!g(sparseArray, R.id.pb_dialog_item_isugc)) {
                    k25 k25Var6 = new k25(-2, o19.t(R.string.c_disagree, new Object[0]), o25Var);
                    k25Var6.d.setTag(sparseArray);
                    arrayList.add(k25Var6);
                }
            }
            k25 k25Var7 = new k25(-3, o19.t(R.string.obfuscated_res_0x7f0f119b, new Object[0]), o25Var);
            k25Var7.d.setTag(sparseArray);
            arrayList.add(k25Var7);
            k25 k25Var8 = new k25(-4, o19.t(R.string.obfuscated_res_0x7f0f12ed, new Object[0]), o25Var);
            k25Var8.d.setTag(sparseArray);
            arrayList.add(k25Var8);
            list.addAll(0, arrayList);
            return list;
        }
        return (List) invokeLLLL.objValue;
    }

    public static List<k25> d(List<k25> list, AgreeData agreeData, SparseArray<?> sparseArray, o25 o25Var) {
        InterceptResult invokeLLLL;
        Interceptable interceptable = $ic;
        if (interceptable == null || (invokeLLLL = interceptable.invokeLLLL(65539, null, list, agreeData, sparseArray, o25Var)) == null) {
            if (list == null) {
                list = new ArrayList<>();
            }
            ArrayList arrayList = new ArrayList();
            if (agreeData.hasAgree) {
                if (agreeData.agreeType == 2) {
                    if (!g(sparseArray, R.id.pb_dialog_item_isugc)) {
                        k25 k25Var = new k25(-2, o19.t(R.string.action_dislike, new Object[0]), o25Var);
                        k25Var.d.setTag(sparseArray);
                        arrayList.add(k25Var);
                    }
                } else if (!g(sparseArray, R.id.pb_dialog_item_isugc)) {
                    k25 k25Var2 = new k25(-2, o19.t(R.string.c_disagreeed, new Object[0]), o25Var);
                    k25Var2.d.setTag(sparseArray);
                    arrayList.add(k25Var2);
                }
            } else if (!g(sparseArray, R.id.pb_dialog_item_isugc)) {
                k25 k25Var3 = new k25(-2, o19.t(R.string.action_dislike, new Object[0]), o25Var);
                k25Var3.d.setTag(sparseArray);
                arrayList.add(k25Var3);
            }
            k25 k25Var4 = new k25(-3, o19.t(R.string.obfuscated_res_0x7f0f119b, new Object[0]), o25Var);
            k25Var4.d.setTag(sparseArray);
            arrayList.add(0, k25Var4);
            k25 k25Var5 = new k25(-4, o19.t(R.string.obfuscated_res_0x7f0f12ed, new Object[0]), o25Var);
            k25Var5.d.setTag(sparseArray);
            arrayList.add(1, k25Var5);
            list.addAll(0, arrayList);
            return list;
        }
        return (List) invokeLLLL.objValue;
    }

    public static void e(Activity activity, @Nullable g9<?> g9Var, d25.e eVar, d25.e eVar2) {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeLLLL(InputDeviceCompat.SOURCE_TRACKBALL, null, activity, g9Var, eVar, eVar2) == null) {
            d25 d25Var = new d25(activity);
            d25Var.setMessageId(R.string.del_post_confirm);
            d25Var.setPositiveButton(R.string.obfuscated_res_0x7f0f0584, eVar);
            d25Var.setNegativeButton(R.string.obfuscated_res_0x7f0f057a, eVar2);
            d25Var.setCancelable(true);
            d25Var.create(g9Var);
            d25Var.show();
        }
    }

    public static List<k25> f(List<k25> list) {
        InterceptResult invokeL;
        Interceptable interceptable = $ic;
        if (interceptable == null || (invokeL = interceptable.invokeL(65541, null, list)) == null) {
            if (list == null) {
                return list;
            }
            for (k25 k25Var : list) {
                k25Var.l(i(k25Var));
            }
            return list;
        }
        return (List) invokeL.objValue;
    }

    public static boolean j(PbModel pbModel) {
        InterceptResult invokeL;
        Interceptable interceptable = $ic;
        if (interceptable == null || (invokeL = interceptable.invokeL(65545, null, pbModel)) == null) {
            if (pbModel != null && pbModel.y1() != null && pbModel.y1().i0()) {
                return true;
            }
            return false;
        }
        return invokeL.booleanValue;
    }

    public static boolean k(cy8 cy8Var) {
        InterceptResult invokeL;
        Interceptable interceptable = $ic;
        if (interceptable == null || (invokeL = interceptable.invokeL(65546, null, cy8Var)) == null) {
            if (cy8Var != null && cy8Var.o()) {
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

    public static SpannableStringBuilder h(sr9 sr9Var) {
        InterceptResult invokeL;
        String str;
        Interceptable interceptable = $ic;
        if (interceptable == null || (invokeL = interceptable.invokeL(65543, null, sr9Var)) == null) {
            if (sr9Var == null) {
                return null;
            }
            if (sr9Var.a0() != null) {
                str = sr9Var.a0().toString();
            } else {
                str = "";
            }
            SpannableString o = o(sr9Var.p().getName_show() + ZeusCrashHandler.NAME_SEPERATOR, SkinManager.getColor(R.color.CAM_X0109));
            SpannableString o2 = o(str, SkinManager.getColor(R.color.CAM_X0107));
            SpannableStringBuilder spannableStringBuilder = new SpannableStringBuilder();
            spannableStringBuilder.append((CharSequence) o);
            spannableStringBuilder.append((CharSequence) o2);
            return spannableStringBuilder;
        }
        return (SpannableStringBuilder) invokeL.objValue;
    }

    public static Drawable i(k25 k25Var) {
        InterceptResult invokeL;
        Interceptable interceptable = $ic;
        if (interceptable == null || (invokeL = interceptable.invokeL(65544, null, k25Var)) == null) {
            switch (k25Var.f()) {
                case -4:
                    return WebPManager.getPureDrawable(R.drawable.icon_pure_pb_recommend_share30, SkinManager.getColor(R.color.CAM_X0107), null);
                case -3:
                    return WebPManager.getPureDrawable(R.drawable.icon_pure_pb_recommend_comment30, SkinManager.getColor(R.color.CAM_X0107), null);
                case -2:
                    if (o19.t(R.string.c_disagree, new Object[0]).equals(k25Var.g())) {
                        return WebPManager.getPureDrawable(R.drawable.icon_pure_pb_recommend_dislike30, SkinManager.getColor(R.color.CAM_X0107), null);
                    }
                    return WebPManager.getPureDrawable(R.drawable.icon_pure_pb_recommend_disliked30, SkinManager.getColor(R.color.CAM_X0107), null);
                case -1:
                    if (o19.t(R.string.c_agree, new Object[0]).equals(k25Var.g())) {
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
                    if (o19.t(R.string.obfuscated_res_0x7f0f0bee, new Object[0]).equals(k25Var.g())) {
                        return WebPManager.getPureDrawable(R.drawable.icon_pure_pb_recommend_collect30, SkinManager.getColor(R.color.CAM_X0107), null);
                    }
                    return WebPManager.getPureDrawable(R.drawable.icon_pure_pb_recommend_collected30, SkinManager.getColor(R.color.CAM_X0305), null);
                case 5:
                    if (o19.t(R.string.report_text, new Object[0]).equals(k25Var.g())) {
                        return WebPManager.getPureDrawable(R.drawable.icon_pure_pb_recommend_report30, SkinManager.getColor(R.color.CAM_X0107), null);
                    }
                    if (!o19.t(R.string.obfuscated_res_0x7f0f0c97, new Object[0]).equals(k25Var.g())) {
                        return null;
                    }
                    return WebPManager.getPureDrawable(R.drawable.icon_pure_pb_recommend_nospeakingset30, SkinManager.getColor(R.color.CAM_X0107), null);
                case 6:
                    if (o19.t(R.string.report_text, new Object[0]).equals(k25Var.g())) {
                        return WebPManager.getPureDrawable(R.drawable.icon_pure_pb_recommend_report30, SkinManager.getColor(R.color.CAM_X0107), null);
                    }
                    if (!o19.t(R.string.obfuscated_res_0x7f0f0535, new Object[0]).equals(k25Var.g())) {
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
                    if (o19.t(R.string.obfuscated_res_0x7f0f0544, new Object[0]).equals(k25Var.g())) {
                        return WebPManager.getPureDrawable(R.drawable.icon_pure_pb_recommend_delete30, SkinManager.getColor(R.color.CAM_X0107), null);
                    }
                    if (!o19.t(R.string.obfuscated_res_0x7f0f0535, new Object[0]).equals(k25Var.g())) {
                        return null;
                    }
                    return WebPManager.getPureDrawable(R.drawable.icon_pure_pb_recommend_delete30, SkinManager.getColor(R.color.CAM_X0107), null);
                case 11:
                    return WebPManager.getPureDrawable(R.drawable.icon_pure_pb_recommend_block30, SkinManager.getColor(R.color.CAM_X0107), null);
                case 12:
                    if (o19.t(R.string.obfuscated_res_0x7f0f0c93, new Object[0]).equals(k25Var.g())) {
                        return WebPManager.getPureDrawable(R.drawable.icon_pure_pb_recommend_nospeaking30, SkinManager.getColor(R.color.CAM_X0107), null);
                    }
                    if (!o19.t(R.string.un_mute, new Object[0]).equals(k25Var.g())) {
                        return null;
                    }
                    return WebPManager.getPureDrawable(R.drawable.icon_pure_pb_recommend_nospeakinged30, SkinManager.getColor(R.color.CAM_X0107), null);
                case 13:
                    return WebPManager.getPureDrawable(R.drawable.icon_pure_pb_batch_delete, SkinManager.getColor(R.color.CAM_X0107), null);
            }
        }
        return (Drawable) invokeL.objValue;
    }

    public static boolean l(sr9 sr9Var) {
        InterceptResult invokeL;
        Interceptable interceptable = $ic;
        if (interceptable == null || (invokeL = interceptable.invokeL(65547, null, sr9Var)) == null) {
            if (sr9Var != null && sr9Var.p() != null && !StringUtils.isNull(sr9Var.p().getUserId()) && sr9Var.p().getUserId().equals(TbadkCoreApplication.getCurrentAccount())) {
                return true;
            }
            return false;
        }
        return invokeL.booleanValue;
    }

    public static List<k25> m(List<k25> list, boolean z) {
        InterceptResult invokeLZ;
        Interceptable interceptable = $ic;
        if (interceptable == null || (invokeLZ = interceptable.invokeLZ(65548, null, list, z)) == null) {
            if (list != null && !z) {
                Iterator<k25> it = list.iterator();
                while (it.hasNext()) {
                    k25 next = it.next();
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
