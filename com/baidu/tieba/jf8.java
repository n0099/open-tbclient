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
import com.baidu.tieba.j05;
import com.baidu.tieba.pb.pb.main.PbModel;
import com.baidu.tieba.tbadkCore.data.AgreeData;
import com.baidu.tieba.tbadkCore.data.PostData;
import com.baidu.titan.sdk.runtime.FieldHolder;
import com.baidu.titan.sdk.runtime.InterceptResult;
import com.baidu.titan.sdk.runtime.Interceptable;
import com.baidu.webkit.sdk.dumper.ZeusCrashHandler;
import java.util.ArrayList;
import java.util.Iterator;
import java.util.List;
/* loaded from: classes5.dex */
public class jf8 {
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

    public static boolean a(List<q05> list, u05 u05Var, PostData postData, ja8 ja8Var, boolean z) {
        InterceptResult invokeCommon;
        Interceptable interceptable = $ic;
        if (interceptable == null || (invokeCommon = interceptable.invokeCommon(65536, null, new Object[]{list, u05Var, postData, ja8Var, Boolean.valueOf(z)})) == null) {
            if (list == null || postData == null || ja8Var == null || !z || !ja8Var.q() || !TbadkCoreApplication.isLogin() || l(postData) || ja8Var.p()) {
                return false;
            }
            q05 q05Var = new q05(9, TbadkCoreApplication.getInst().getString(R.string.obfuscated_res_0x7f0f032d), u05Var);
            list.add(q05Var);
            k89.f(q05Var.d, postData);
            return true;
        }
        return invokeCommon.booleanValue;
    }

    public static boolean b(List<q05> list, u05 u05Var, PostData postData, PbModel pbModel) {
        InterceptResult invokeLLLL;
        Interceptable interceptable = $ic;
        if (interceptable == null || (invokeLLLL = interceptable.invokeLLLL(65537, null, list, u05Var, postData, pbModel)) == null) {
            if (list != null && postData != null && pbModel != null && pbModel.k1() != null) {
                u98 k1 = pbModel.k1();
                if (k1.j0() && TbadkCoreApplication.isLogin() && !l(postData) && !k1.i0()) {
                    q05 q05Var = new q05(9, TbadkCoreApplication.getInst().getString(R.string.obfuscated_res_0x7f0f032d), u05Var);
                    list.add(q05Var);
                    k89.f(q05Var.d, postData);
                    return true;
                }
            }
            return false;
        }
        return invokeLLLL.booleanValue;
    }

    public static List<q05> c(List<q05> list, AgreeData agreeData, SparseArray<?> sparseArray, u05 u05Var) {
        InterceptResult invokeLLLL;
        Interceptable interceptable = $ic;
        if (interceptable == null || (invokeLLLL = interceptable.invokeLLLL(65538, null, list, agreeData, sparseArray, u05Var)) == null) {
            if (list == null) {
                list = new ArrayList<>();
            }
            ArrayList arrayList = new ArrayList();
            if (agreeData.hasAgree) {
                if (agreeData.agreeType == 2) {
                    q05 q05Var = new q05(-1, qd8.t(R.string.c_agreeed, new Object[0]), u05Var);
                    q05Var.d.setTag(sparseArray);
                    arrayList.add(q05Var);
                    if (!g(sparseArray, R.id.pb_dialog_item_isugc)) {
                        q05 q05Var2 = new q05(-2, qd8.t(R.string.c_disagree, new Object[0]), u05Var);
                        q05Var2.d.setTag(sparseArray);
                        arrayList.add(q05Var2);
                    }
                } else {
                    q05 q05Var3 = new q05(-1, qd8.t(R.string.c_agree, new Object[0]), u05Var);
                    q05Var3.d.setTag(sparseArray);
                    arrayList.add(q05Var3);
                    if (!g(sparseArray, R.id.pb_dialog_item_isugc)) {
                        q05 q05Var4 = new q05(-2, qd8.t(R.string.c_disagreeed, new Object[0]), u05Var);
                        q05Var4.d.setTag(sparseArray);
                        arrayList.add(q05Var4);
                    }
                }
            } else {
                q05 q05Var5 = new q05(-1, qd8.t(R.string.c_agree, new Object[0]), u05Var);
                q05Var5.d.setTag(sparseArray);
                arrayList.add(q05Var5);
                if (!g(sparseArray, R.id.pb_dialog_item_isugc)) {
                    q05 q05Var6 = new q05(-2, qd8.t(R.string.c_disagree, new Object[0]), u05Var);
                    q05Var6.d.setTag(sparseArray);
                    arrayList.add(q05Var6);
                }
            }
            q05 q05Var7 = new q05(-3, qd8.t(R.string.obfuscated_res_0x7f0f109d, new Object[0]), u05Var);
            q05Var7.d.setTag(sparseArray);
            arrayList.add(q05Var7);
            q05 q05Var8 = new q05(-4, qd8.t(R.string.obfuscated_res_0x7f0f11e9, new Object[0]), u05Var);
            q05Var8.d.setTag(sparseArray);
            arrayList.add(q05Var8);
            list.addAll(0, arrayList);
            return list;
        }
        return (List) invokeLLLL.objValue;
    }

    public static List<q05> d(List<q05> list, AgreeData agreeData, SparseArray<?> sparseArray, u05 u05Var) {
        InterceptResult invokeLLLL;
        Interceptable interceptable = $ic;
        if (interceptable == null || (invokeLLLL = interceptable.invokeLLLL(65539, null, list, agreeData, sparseArray, u05Var)) == null) {
            if (list == null) {
                list = new ArrayList<>();
            }
            ArrayList arrayList = new ArrayList();
            if (agreeData.hasAgree) {
                if (agreeData.agreeType == 2) {
                    if (!g(sparseArray, R.id.pb_dialog_item_isugc)) {
                        q05 q05Var = new q05(-2, qd8.t(R.string.action_dislike, new Object[0]), u05Var);
                        q05Var.d.setTag(sparseArray);
                        arrayList.add(q05Var);
                    }
                } else if (!g(sparseArray, R.id.pb_dialog_item_isugc)) {
                    q05 q05Var2 = new q05(-2, qd8.t(R.string.c_disagreeed, new Object[0]), u05Var);
                    q05Var2.d.setTag(sparseArray);
                    arrayList.add(q05Var2);
                }
            } else if (!g(sparseArray, R.id.pb_dialog_item_isugc)) {
                q05 q05Var3 = new q05(-2, qd8.t(R.string.action_dislike, new Object[0]), u05Var);
                q05Var3.d.setTag(sparseArray);
                arrayList.add(q05Var3);
            }
            q05 q05Var4 = new q05(-3, qd8.t(R.string.obfuscated_res_0x7f0f109d, new Object[0]), u05Var);
            q05Var4.d.setTag(sparseArray);
            arrayList.add(0, q05Var4);
            q05 q05Var5 = new q05(-4, qd8.t(R.string.obfuscated_res_0x7f0f11e9, new Object[0]), u05Var);
            q05Var5.d.setTag(sparseArray);
            arrayList.add(1, q05Var5);
            list.addAll(0, arrayList);
            return list;
        }
        return (List) invokeLLLL.objValue;
    }

    public static void e(Activity activity, @Nullable x9<?> x9Var, j05.e eVar, j05.e eVar2) {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeLLLL(InputDeviceCompat.SOURCE_TRACKBALL, null, activity, x9Var, eVar, eVar2) == null) {
            j05 j05Var = new j05(activity);
            j05Var.setMessageId(R.string.del_post_confirm);
            j05Var.setPositiveButton(R.string.obfuscated_res_0x7f0f051d, eVar);
            j05Var.setNegativeButton(R.string.obfuscated_res_0x7f0f0515, eVar2);
            j05Var.setCancelable(true);
            j05Var.create(x9Var);
            j05Var.show();
        }
    }

    public static List<q05> f(List<q05> list) {
        InterceptResult invokeL;
        Interceptable interceptable = $ic;
        if (interceptable == null || (invokeL = interceptable.invokeL(65541, null, list)) == null) {
            if (list == null) {
                return list;
            }
            for (q05 q05Var : list) {
                q05Var.l(i(q05Var));
            }
            return list;
        }
        return (List) invokeL.objValue;
    }

    public static boolean j(PbModel pbModel) {
        InterceptResult invokeL;
        Interceptable interceptable = $ic;
        if (interceptable == null || (invokeL = interceptable.invokeL(65545, null, pbModel)) == null) {
            if (pbModel != null && pbModel.k1() != null && pbModel.k1().j0()) {
                return true;
            }
            return false;
        }
        return invokeL.booleanValue;
    }

    public static boolean k(ja8 ja8Var) {
        InterceptResult invokeL;
        Interceptable interceptable = $ic;
        if (interceptable == null || (invokeL = interceptable.invokeL(65546, null, ja8Var)) == null) {
            if (ja8Var != null && ja8Var.q()) {
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

    public static SpannableStringBuilder h(PostData postData) {
        InterceptResult invokeL;
        String str;
        Interceptable interceptable = $ic;
        if (interceptable == null || (invokeL = interceptable.invokeL(65543, null, postData)) == null) {
            if (postData == null) {
                return null;
            }
            if (postData.Z() != null) {
                str = postData.Z().toString();
            } else {
                str = "";
            }
            SpannableString o = o(postData.r().getName_show() + ZeusCrashHandler.NAME_SEPERATOR, SkinManager.getColor(R.color.CAM_X0109));
            SpannableString o2 = o(str, SkinManager.getColor(R.color.CAM_X0107));
            SpannableStringBuilder spannableStringBuilder = new SpannableStringBuilder();
            spannableStringBuilder.append((CharSequence) o);
            spannableStringBuilder.append((CharSequence) o2);
            return spannableStringBuilder;
        }
        return (SpannableStringBuilder) invokeL.objValue;
    }

    public static Drawable i(q05 q05Var) {
        InterceptResult invokeL;
        Interceptable interceptable = $ic;
        if (interceptable == null || (invokeL = interceptable.invokeL(65544, null, q05Var)) == null) {
            switch (q05Var.f()) {
                case -4:
                    return WebPManager.getPureDrawable(R.drawable.icon_pure_pb_recommend_share30, SkinManager.getColor(R.color.CAM_X0107), null);
                case -3:
                    return WebPManager.getPureDrawable(R.drawable.icon_pure_pb_recommend_comment30, SkinManager.getColor(R.color.CAM_X0107), null);
                case -2:
                    if (qd8.t(R.string.c_disagree, new Object[0]).equals(q05Var.g())) {
                        return WebPManager.getPureDrawable(R.drawable.icon_pure_pb_recommend_dislike30, SkinManager.getColor(R.color.CAM_X0107), null);
                    }
                    return WebPManager.getPureDrawable(R.drawable.icon_pure_pb_recommend_disliked30, SkinManager.getColor(R.color.CAM_X0107), null);
                case -1:
                    if (qd8.t(R.string.c_agree, new Object[0]).equals(q05Var.g())) {
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
                    if (qd8.t(R.string.obfuscated_res_0x7f0f0b3c, new Object[0]).equals(q05Var.g())) {
                        return WebPManager.getPureDrawable(R.drawable.icon_pure_pb_recommend_collect30, SkinManager.getColor(R.color.CAM_X0107), null);
                    }
                    return WebPManager.getPureDrawable(R.drawable.icon_pure_pb_recommend_collected30, SkinManager.getColor(R.color.CAM_X0305), null);
                case 5:
                    if (qd8.t(R.string.report_text, new Object[0]).equals(q05Var.g())) {
                        return WebPManager.getPureDrawable(R.drawable.icon_pure_pb_recommend_report30, SkinManager.getColor(R.color.CAM_X0107), null);
                    }
                    if (!qd8.t(R.string.obfuscated_res_0x7f0f0be0, new Object[0]).equals(q05Var.g())) {
                        return null;
                    }
                    return WebPManager.getPureDrawable(R.drawable.icon_pure_pb_recommend_nospeakingset30, SkinManager.getColor(R.color.CAM_X0107), null);
                case 6:
                    if (qd8.t(R.string.report_text, new Object[0]).equals(q05Var.g())) {
                        return WebPManager.getPureDrawable(R.drawable.icon_pure_pb_recommend_report30, SkinManager.getColor(R.color.CAM_X0107), null);
                    }
                    if (!qd8.t(R.string.obfuscated_res_0x7f0f04d5, new Object[0]).equals(q05Var.g())) {
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
                    if (qd8.t(R.string.obfuscated_res_0x7f0f04e2, new Object[0]).equals(q05Var.g())) {
                        return WebPManager.getPureDrawable(R.drawable.icon_pure_pb_recommend_delete30, SkinManager.getColor(R.color.CAM_X0107), null);
                    }
                    if (!qd8.t(R.string.obfuscated_res_0x7f0f04d5, new Object[0]).equals(q05Var.g())) {
                        return null;
                    }
                    return WebPManager.getPureDrawable(R.drawable.icon_pure_pb_recommend_delete30, SkinManager.getColor(R.color.CAM_X0107), null);
                case 11:
                    return WebPManager.getPureDrawable(R.drawable.icon_pure_pb_recommend_block30, SkinManager.getColor(R.color.CAM_X0107), null);
                case 12:
                    if (qd8.t(R.string.obfuscated_res_0x7f0f0bdc, new Object[0]).equals(q05Var.g())) {
                        return WebPManager.getPureDrawable(R.drawable.icon_pure_pb_recommend_nospeaking30, SkinManager.getColor(R.color.CAM_X0107), null);
                    }
                    if (!qd8.t(R.string.un_mute, new Object[0]).equals(q05Var.g())) {
                        return null;
                    }
                    return WebPManager.getPureDrawable(R.drawable.icon_pure_pb_recommend_nospeakinged30, SkinManager.getColor(R.color.CAM_X0107), null);
                case 13:
                    return WebPManager.getPureDrawable(R.drawable.icon_pure_pb_batch_delete, SkinManager.getColor(R.color.CAM_X0107), null);
            }
        }
        return (Drawable) invokeL.objValue;
    }

    public static boolean l(PostData postData) {
        InterceptResult invokeL;
        Interceptable interceptable = $ic;
        if (interceptable == null || (invokeL = interceptable.invokeL(65547, null, postData)) == null) {
            if (postData != null && postData.r() != null && !StringUtils.isNull(postData.r().getUserId()) && postData.r().getUserId().equals(TbadkCoreApplication.getCurrentAccount())) {
                return true;
            }
            return false;
        }
        return invokeL.booleanValue;
    }

    public static List<q05> m(List<q05> list, boolean z) {
        InterceptResult invokeLZ;
        Interceptable interceptable = $ic;
        if (interceptable == null || (invokeLZ = interceptable.invokeLZ(65548, null, list, z)) == null) {
            if (list != null && !z) {
                Iterator<q05> it = list.iterator();
                while (it.hasNext()) {
                    q05 next = it.next();
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
