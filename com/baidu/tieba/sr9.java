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
import com.baidu.tieba.z45;
import com.baidu.titan.sdk.runtime.FieldHolder;
import com.baidu.titan.sdk.runtime.InterceptResult;
import com.baidu.titan.sdk.runtime.Interceptable;
import com.baidu.webkit.sdk.dumper.ZeusCrashHandler;
import java.util.ArrayList;
import java.util.Iterator;
import java.util.List;
import tbclient.AigcFeedbackInfo;
/* loaded from: classes8.dex */
public class sr9 {
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

    public static boolean a(List<f55> list, j55 j55Var, zja zjaVar, cl9 cl9Var, boolean z) {
        InterceptResult invokeCommon;
        Interceptable interceptable = $ic;
        if (interceptable == null || (invokeCommon = interceptable.invokeCommon(65536, null, new Object[]{list, j55Var, zjaVar, cl9Var, Boolean.valueOf(z)})) == null) {
            if (list == null || zjaVar == null || cl9Var == null || !z || !cl9Var.o() || !TbadkCoreApplication.isLogin() || l(zjaVar) || cl9Var.n()) {
                return false;
            }
            f55 f55Var = new f55(9, TbadkCoreApplication.getInst().getString(R.string.obfuscated_res_0x7f0f0367), j55Var);
            list.add(f55Var);
            psa.f(f55Var.d, zjaVar);
            return true;
        }
        return invokeCommon.booleanValue;
    }

    public static boolean b(List<f55> list, j55 j55Var, zja zjaVar, PbModel pbModel) {
        InterceptResult invokeLLLL;
        Interceptable interceptable = $ic;
        if (interceptable == null || (invokeLLLL = interceptable.invokeLLLL(65537, null, list, j55Var, zjaVar, pbModel)) == null) {
            if (list != null && zjaVar != null && pbModel != null && pbModel.r1() != null) {
                lk9 r1 = pbModel.r1();
                if (r1.k0() && TbadkCoreApplication.isLogin() && !l(zjaVar) && !r1.j0()) {
                    f55 f55Var = new f55(9, TbadkCoreApplication.getInst().getString(R.string.obfuscated_res_0x7f0f0367), j55Var);
                    list.add(f55Var);
                    psa.f(f55Var.d, zjaVar);
                    return true;
                }
            }
            return false;
        }
        return invokeLLLL.booleanValue;
    }

    public static List<f55> c(List<f55> list, AgreeData agreeData, SparseArray<?> sparseArray, j55 j55Var) {
        InterceptResult invokeLLLL;
        Interceptable interceptable = $ic;
        if (interceptable == null || (invokeLLLL = interceptable.invokeLLLL(65538, null, list, agreeData, sparseArray, j55Var)) == null) {
            return d(list, agreeData, sparseArray, j55Var, null);
        }
        return (List) invokeLLLL.objValue;
    }

    public static List<f55> d(List<f55> list, AgreeData agreeData, SparseArray<?> sparseArray, j55 j55Var, AigcFeedbackInfo aigcFeedbackInfo) {
        InterceptResult invokeLLLLL;
        Interceptable interceptable = $ic;
        if (interceptable == null || (invokeLLLLL = interceptable.invokeLLLLL(65539, null, list, agreeData, sparseArray, j55Var, aigcFeedbackInfo)) == null) {
            String t = pp9.t(R.string.c_agree, new Object[0]);
            String t2 = pp9.t(R.string.c_disagree, new Object[0]);
            String t3 = pp9.t(R.string.c_agreeed, new Object[0]);
            String t4 = pp9.t(R.string.c_disagreeed, new Object[0]);
            if (aigcFeedbackInfo != null) {
                String str = aigcFeedbackInfo.positive_text;
                String str2 = aigcFeedbackInfo.negative_text;
                if (!TextUtils.isEmpty(str) && !TextUtils.isEmpty(str2)) {
                    t2 = str2;
                    t4 = t2;
                    t = str;
                    t3 = t;
                }
            }
            if (list == null) {
                list = new ArrayList<>();
            }
            ArrayList arrayList = new ArrayList();
            if (agreeData.hasAgree) {
                if (agreeData.agreeType == 2) {
                    f55 f55Var = new f55(-1, t3, j55Var);
                    f55Var.n(true);
                    f55Var.d.setTag(sparseArray);
                    arrayList.add(f55Var);
                    if (!g(sparseArray, R.id.pb_dialog_item_isugc)) {
                        f55 f55Var2 = new f55(-2, t2, j55Var);
                        f55Var2.n(false);
                        f55Var2.d.setTag(sparseArray);
                        arrayList.add(f55Var2);
                    }
                } else {
                    f55 f55Var3 = new f55(-1, t, j55Var);
                    f55Var3.n(false);
                    f55Var3.d.setTag(sparseArray);
                    arrayList.add(f55Var3);
                    if (!g(sparseArray, R.id.pb_dialog_item_isugc)) {
                        f55 f55Var4 = new f55(-2, t4, j55Var);
                        f55Var4.n(true);
                        f55Var4.d.setTag(sparseArray);
                        arrayList.add(f55Var4);
                    }
                }
            } else {
                f55 f55Var5 = new f55(-1, t, j55Var);
                f55Var5.n(false);
                f55Var5.d.setTag(sparseArray);
                arrayList.add(f55Var5);
                if (!g(sparseArray, R.id.pb_dialog_item_isugc)) {
                    f55 f55Var6 = new f55(-2, t2, j55Var);
                    f55Var6.n(false);
                    f55Var6.d.setTag(sparseArray);
                    arrayList.add(f55Var6);
                }
            }
            f55 f55Var7 = new f55(-3, pp9.t(R.string.obfuscated_res_0x7f0f1249, new Object[0]), j55Var);
            f55Var7.d.setTag(sparseArray);
            arrayList.add(f55Var7);
            f55 f55Var8 = new f55(-4, pp9.t(R.string.obfuscated_res_0x7f0f13a1, new Object[0]), j55Var);
            f55Var8.d.setTag(sparseArray);
            arrayList.add(f55Var8);
            list.addAll(0, arrayList);
            return list;
        }
        return (List) invokeLLLLL.objValue;
    }

    public static void e(Activity activity, @Nullable BdPageContext<?> bdPageContext, z45.e eVar, z45.e eVar2) {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeLLLL(InputDeviceCompat.SOURCE_TRACKBALL, null, activity, bdPageContext, eVar, eVar2) == null) {
            z45 z45Var = new z45(activity);
            z45Var.setMessageId(R.string.del_post_confirm);
            z45Var.setPositiveButton(R.string.obfuscated_res_0x7f0f059b, eVar);
            z45Var.setNegativeButton(R.string.obfuscated_res_0x7f0f0590, eVar2);
            z45Var.setCancelable(true);
            z45Var.create(bdPageContext);
            z45Var.show();
        }
    }

    public static List<f55> f(List<f55> list) {
        InterceptResult invokeL;
        Interceptable interceptable = $ic;
        if (interceptable == null || (invokeL = interceptable.invokeL(65541, null, list)) == null) {
            if (list == null) {
                return list;
            }
            for (f55 f55Var : list) {
                f55Var.l(i(f55Var));
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

    public static boolean k(cl9 cl9Var) {
        InterceptResult invokeL;
        Interceptable interceptable = $ic;
        if (interceptable == null || (invokeL = interceptable.invokeL(65546, null, cl9Var)) == null) {
            if (cl9Var != null && cl9Var.o()) {
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

    public static SpannableStringBuilder h(zja zjaVar) {
        InterceptResult invokeL;
        String str;
        Interceptable interceptable = $ic;
        if (interceptable == null || (invokeL = interceptable.invokeL(65543, null, zjaVar)) == null) {
            if (zjaVar == null) {
                return null;
            }
            if (zjaVar.f0() != null) {
                str = zjaVar.f0().toString();
            } else {
                str = "";
            }
            SpannableString o = o(zjaVar.t().getName_show() + ZeusCrashHandler.NAME_SEPERATOR, SkinManager.getColor(R.color.CAM_X0109));
            SpannableString o2 = o(str, SkinManager.getColor(R.color.CAM_X0107));
            SpannableStringBuilder spannableStringBuilder = new SpannableStringBuilder();
            spannableStringBuilder.append((CharSequence) o);
            spannableStringBuilder.append((CharSequence) o2);
            return spannableStringBuilder;
        }
        return (SpannableStringBuilder) invokeL.objValue;
    }

    public static Drawable i(f55 f55Var) {
        InterceptResult invokeL;
        Interceptable interceptable = $ic;
        if (interceptable == null || (invokeL = interceptable.invokeL(65544, null, f55Var)) == null) {
            switch (f55Var.e()) {
                case -4:
                    return WebPManager.getPureDrawable(R.drawable.icon_pure_pb_recommend_share30, SkinManager.getColor(R.color.CAM_X0107), null);
                case -3:
                    return WebPManager.getPureDrawable(R.drawable.icon_pure_pb_recommend_comment30, SkinManager.getColor(R.color.CAM_X0107), null);
                case -2:
                    if (!f55Var.j()) {
                        return WebPManager.getPureDrawable(R.drawable.icon_pure_pb_recommend_dislike30, SkinManager.getColor(R.color.CAM_X0107), null);
                    }
                    return WebPManager.getPureDrawable(R.drawable.icon_pure_pb_recommend_disliked30, SkinManager.getColor(R.color.CAM_X0107), null);
                case -1:
                    if (!f55Var.j()) {
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
                    if (pp9.t(R.string.obfuscated_res_0x7f0f0c5c, new Object[0]).equals(f55Var.f())) {
                        return WebPManager.getPureDrawable(R.drawable.icon_pure_pb_recommend_collect30, SkinManager.getColor(R.color.CAM_X0107), null);
                    }
                    return WebPManager.getPureDrawable(R.drawable.icon_pure_pb_recommend_collected30, SkinManager.getColor(R.color.CAM_X0305), null);
                case 5:
                    if (pp9.t(R.string.report_text, new Object[0]).equals(f55Var.f())) {
                        return WebPManager.getPureDrawable(R.drawable.icon_pure_pb_recommend_report30, SkinManager.getColor(R.color.CAM_X0107), null);
                    }
                    if (!pp9.t(R.string.obfuscated_res_0x7f0f0d1e, new Object[0]).equals(f55Var.f())) {
                        return null;
                    }
                    return WebPManager.getPureDrawable(R.drawable.icon_pure_pb_recommend_nospeakingset30, SkinManager.getColor(R.color.CAM_X0107), null);
                case 6:
                    if (pp9.t(R.string.report_text, new Object[0]).equals(f55Var.f())) {
                        return WebPManager.getPureDrawable(R.drawable.icon_pure_pb_recommend_report30, SkinManager.getColor(R.color.CAM_X0107), null);
                    }
                    if (!pp9.t(R.string.obfuscated_res_0x7f0f054b, new Object[0]).equals(f55Var.f())) {
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
                    if (pp9.t(R.string.obfuscated_res_0x7f0f055a, new Object[0]).equals(f55Var.f())) {
                        return WebPManager.getPureDrawable(R.drawable.icon_pure_pb_recommend_delete30, SkinManager.getColor(R.color.CAM_X0107), null);
                    }
                    if (!pp9.t(R.string.obfuscated_res_0x7f0f054b, new Object[0]).equals(f55Var.f())) {
                        return null;
                    }
                    return WebPManager.getPureDrawable(R.drawable.icon_pure_pb_recommend_delete30, SkinManager.getColor(R.color.CAM_X0107), null);
                case 11:
                    return WebPManager.getPureDrawable(R.drawable.icon_pure_pb_recommend_block30, SkinManager.getColor(R.color.CAM_X0107), null);
                case 12:
                    if (pp9.t(R.string.obfuscated_res_0x7f0f0d1a, new Object[0]).equals(f55Var.f())) {
                        return WebPManager.getPureDrawable(R.drawable.icon_pure_pb_recommend_nospeaking30, SkinManager.getColor(R.color.CAM_X0107), null);
                    }
                    if (!pp9.t(R.string.un_mute, new Object[0]).equals(f55Var.f())) {
                        return null;
                    }
                    return WebPManager.getPureDrawable(R.drawable.icon_pure_pb_recommend_nospeakinged30, SkinManager.getColor(R.color.CAM_X0107), null);
                case 13:
                    return WebPManager.getPureDrawable(R.drawable.icon_pure_pb_batch_delete, SkinManager.getColor(R.color.CAM_X0107), null);
            }
        }
        return (Drawable) invokeL.objValue;
    }

    public static boolean l(zja zjaVar) {
        InterceptResult invokeL;
        Interceptable interceptable = $ic;
        if (interceptable == null || (invokeL = interceptable.invokeL(65547, null, zjaVar)) == null) {
            if (zjaVar != null && zjaVar.t() != null && !StringUtils.isNull(zjaVar.t().getUserId()) && zjaVar.t().getUserId().equals(TbadkCoreApplication.getCurrentAccount())) {
                return true;
            }
            return false;
        }
        return invokeL.booleanValue;
    }

    public static List<f55> m(List<f55> list, boolean z) {
        InterceptResult invokeLZ;
        Interceptable interceptable = $ic;
        if (interceptable == null || (invokeLZ = interceptable.invokeLZ(65548, null, list, z)) == null) {
            if (list != null && !z) {
                Iterator<f55> it = list.iterator();
                while (it.hasNext()) {
                    f55 next = it.next();
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
