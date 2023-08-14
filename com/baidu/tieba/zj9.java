package com.baidu.tieba;

import android.app.Activity;
import android.graphics.drawable.Drawable;
import android.text.SpannableString;
import android.text.SpannableStringBuilder;
import android.text.style.ForegroundColorSpan;
import android.util.SparseArray;
import androidx.annotation.Nullable;
import androidx.core.view.InputDeviceCompat;
import com.baidu.adp.base.BdPageContext;
import com.baidu.adp.lib.util.StringUtils;
import com.baidu.tbadk.core.TbadkCoreApplication;
import com.baidu.tbadk.core.util.SkinManager;
import com.baidu.tbadk.core.util.WebPManager;
import com.baidu.tieba.m45;
import com.baidu.tieba.pb.pb.main.PbModel;
import com.baidu.tieba.tbadkCore.data.AgreeData;
import com.baidu.titan.sdk.runtime.FieldHolder;
import com.baidu.titan.sdk.runtime.InterceptResult;
import com.baidu.titan.sdk.runtime.Interceptable;
import com.baidu.webkit.sdk.dumper.ZeusCrashHandler;
import java.util.ArrayList;
import java.util.Iterator;
import java.util.List;
/* loaded from: classes8.dex */
public class zj9 {
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

    public static boolean a(List<s45> list, w45 w45Var, rba rbaVar, ke9 ke9Var, boolean z) {
        InterceptResult invokeCommon;
        Interceptable interceptable = $ic;
        if (interceptable == null || (invokeCommon = interceptable.invokeCommon(65536, null, new Object[]{list, w45Var, rbaVar, ke9Var, Boolean.valueOf(z)})) == null) {
            if (list == null || rbaVar == null || ke9Var == null || !z || !ke9Var.o() || !TbadkCoreApplication.isLogin() || k(rbaVar) || ke9Var.n()) {
                return false;
            }
            s45 s45Var = new s45(9, TbadkCoreApplication.getInst().getString(R.string.obfuscated_res_0x7f0f0365), w45Var);
            list.add(s45Var);
            bka.f(s45Var.d, rbaVar);
            return true;
        }
        return invokeCommon.booleanValue;
    }

    public static boolean b(List<s45> list, w45 w45Var, rba rbaVar, PbModel pbModel) {
        InterceptResult invokeLLLL;
        Interceptable interceptable = $ic;
        if (interceptable == null || (invokeLLLL = interceptable.invokeLLLL(65537, null, list, w45Var, rbaVar, pbModel)) == null) {
            if (list != null && rbaVar != null && pbModel != null && pbModel.s1() != null) {
                td9 s1 = pbModel.s1();
                if (s1.k0() && TbadkCoreApplication.isLogin() && !k(rbaVar) && !s1.j0()) {
                    s45 s45Var = new s45(9, TbadkCoreApplication.getInst().getString(R.string.obfuscated_res_0x7f0f0365), w45Var);
                    list.add(s45Var);
                    bka.f(s45Var.d, rbaVar);
                    return true;
                }
            }
            return false;
        }
        return invokeLLLL.booleanValue;
    }

    public static List<s45> c(List<s45> list, AgreeData agreeData, SparseArray<?> sparseArray, w45 w45Var) {
        InterceptResult invokeLLLL;
        Interceptable interceptable = $ic;
        if (interceptable == null || (invokeLLLL = interceptable.invokeLLLL(65538, null, list, agreeData, sparseArray, w45Var)) == null) {
            if (list == null) {
                list = new ArrayList<>();
            }
            ArrayList arrayList = new ArrayList();
            if (agreeData.hasAgree) {
                if (agreeData.agreeType == 2) {
                    s45 s45Var = new s45(-1, bi9.t(R.string.c_agreeed, new Object[0]), w45Var);
                    s45Var.d.setTag(sparseArray);
                    arrayList.add(s45Var);
                    if (!f(sparseArray, R.id.pb_dialog_item_isugc)) {
                        s45 s45Var2 = new s45(-2, bi9.t(R.string.c_disagree, new Object[0]), w45Var);
                        s45Var2.d.setTag(sparseArray);
                        arrayList.add(s45Var2);
                    }
                } else {
                    s45 s45Var3 = new s45(-1, bi9.t(R.string.c_agree, new Object[0]), w45Var);
                    s45Var3.d.setTag(sparseArray);
                    arrayList.add(s45Var3);
                    if (!f(sparseArray, R.id.pb_dialog_item_isugc)) {
                        s45 s45Var4 = new s45(-2, bi9.t(R.string.c_disagreeed, new Object[0]), w45Var);
                        s45Var4.d.setTag(sparseArray);
                        arrayList.add(s45Var4);
                    }
                }
            } else {
                s45 s45Var5 = new s45(-1, bi9.t(R.string.c_agree, new Object[0]), w45Var);
                s45Var5.d.setTag(sparseArray);
                arrayList.add(s45Var5);
                if (!f(sparseArray, R.id.pb_dialog_item_isugc)) {
                    s45 s45Var6 = new s45(-2, bi9.t(R.string.c_disagree, new Object[0]), w45Var);
                    s45Var6.d.setTag(sparseArray);
                    arrayList.add(s45Var6);
                }
            }
            s45 s45Var7 = new s45(-3, bi9.t(R.string.obfuscated_res_0x7f0f1223, new Object[0]), w45Var);
            s45Var7.d.setTag(sparseArray);
            arrayList.add(s45Var7);
            s45 s45Var8 = new s45(-4, bi9.t(R.string.obfuscated_res_0x7f0f137a, new Object[0]), w45Var);
            s45Var8.d.setTag(sparseArray);
            arrayList.add(s45Var8);
            list.addAll(0, arrayList);
            return list;
        }
        return (List) invokeLLLL.objValue;
    }

    public static void d(Activity activity, @Nullable BdPageContext<?> bdPageContext, m45.e eVar, m45.e eVar2) {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeLLLL(65539, null, activity, bdPageContext, eVar, eVar2) == null) {
            m45 m45Var = new m45(activity);
            m45Var.setMessageId(R.string.del_post_confirm);
            m45Var.setPositiveButton(R.string.obfuscated_res_0x7f0f0596, eVar);
            m45Var.setNegativeButton(R.string.obfuscated_res_0x7f0f058b, eVar2);
            m45Var.setCancelable(true);
            m45Var.create(bdPageContext);
            m45Var.show();
        }
    }

    public static List<s45> e(List<s45> list) {
        InterceptResult invokeL;
        Interceptable interceptable = $ic;
        if (interceptable == null || (invokeL = interceptable.invokeL(InputDeviceCompat.SOURCE_TRACKBALL, null, list)) == null) {
            if (list == null) {
                return list;
            }
            for (s45 s45Var : list) {
                s45Var.l(h(s45Var));
            }
            return list;
        }
        return (List) invokeL.objValue;
    }

    public static boolean i(PbModel pbModel) {
        InterceptResult invokeL;
        Interceptable interceptable = $ic;
        if (interceptable == null || (invokeL = interceptable.invokeL(65544, null, pbModel)) == null) {
            if (pbModel != null && pbModel.s1() != null && pbModel.s1().k0()) {
                return true;
            }
            return false;
        }
        return invokeL.booleanValue;
    }

    public static boolean j(ke9 ke9Var) {
        InterceptResult invokeL;
        Interceptable interceptable = $ic;
        if (interceptable == null || (invokeL = interceptable.invokeL(65545, null, ke9Var)) == null) {
            if (ke9Var != null && ke9Var.o()) {
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

    public static SpannableStringBuilder g(rba rbaVar) {
        InterceptResult invokeL;
        String str;
        Interceptable interceptable = $ic;
        if (interceptable == null || (invokeL = interceptable.invokeL(65542, null, rbaVar)) == null) {
            if (rbaVar == null) {
                return null;
            }
            if (rbaVar.e0() != null) {
                str = rbaVar.e0().toString();
            } else {
                str = "";
            }
            SpannableString n = n(rbaVar.r().getName_show() + ZeusCrashHandler.NAME_SEPERATOR, SkinManager.getColor(R.color.CAM_X0109));
            SpannableString n2 = n(str, SkinManager.getColor(R.color.CAM_X0107));
            SpannableStringBuilder spannableStringBuilder = new SpannableStringBuilder();
            spannableStringBuilder.append((CharSequence) n);
            spannableStringBuilder.append((CharSequence) n2);
            return spannableStringBuilder;
        }
        return (SpannableStringBuilder) invokeL.objValue;
    }

    public static Drawable h(s45 s45Var) {
        InterceptResult invokeL;
        Interceptable interceptable = $ic;
        if (interceptable == null || (invokeL = interceptable.invokeL(65543, null, s45Var)) == null) {
            switch (s45Var.f()) {
                case -4:
                    return WebPManager.getPureDrawable(R.drawable.icon_pure_pb_recommend_share30, SkinManager.getColor(R.color.CAM_X0107), null);
                case -3:
                    return WebPManager.getPureDrawable(R.drawable.icon_pure_pb_recommend_comment30, SkinManager.getColor(R.color.CAM_X0107), null);
                case -2:
                    if (bi9.t(R.string.c_disagree, new Object[0]).equals(s45Var.g())) {
                        return WebPManager.getPureDrawable(R.drawable.icon_pure_pb_recommend_dislike30, SkinManager.getColor(R.color.CAM_X0107), null);
                    }
                    return WebPManager.getPureDrawable(R.drawable.icon_pure_pb_recommend_disliked30, SkinManager.getColor(R.color.CAM_X0107), null);
                case -1:
                    if (bi9.t(R.string.c_agree, new Object[0]).equals(s45Var.g())) {
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
                    if (bi9.t(R.string.obfuscated_res_0x7f0f0c3d, new Object[0]).equals(s45Var.g())) {
                        return WebPManager.getPureDrawable(R.drawable.icon_pure_pb_recommend_collect30, SkinManager.getColor(R.color.CAM_X0107), null);
                    }
                    return WebPManager.getPureDrawable(R.drawable.icon_pure_pb_recommend_collected30, SkinManager.getColor(R.color.CAM_X0305), null);
                case 5:
                    if (bi9.t(R.string.report_text, new Object[0]).equals(s45Var.g())) {
                        return WebPManager.getPureDrawable(R.drawable.icon_pure_pb_recommend_report30, SkinManager.getColor(R.color.CAM_X0107), null);
                    }
                    if (!bi9.t(R.string.obfuscated_res_0x7f0f0cfd, new Object[0]).equals(s45Var.g())) {
                        return null;
                    }
                    return WebPManager.getPureDrawable(R.drawable.icon_pure_pb_recommend_nospeakingset30, SkinManager.getColor(R.color.CAM_X0107), null);
                case 6:
                    if (bi9.t(R.string.report_text, new Object[0]).equals(s45Var.g())) {
                        return WebPManager.getPureDrawable(R.drawable.icon_pure_pb_recommend_report30, SkinManager.getColor(R.color.CAM_X0107), null);
                    }
                    if (!bi9.t(R.string.obfuscated_res_0x7f0f0546, new Object[0]).equals(s45Var.g())) {
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
                    if (bi9.t(R.string.obfuscated_res_0x7f0f0555, new Object[0]).equals(s45Var.g())) {
                        return WebPManager.getPureDrawable(R.drawable.icon_pure_pb_recommend_delete30, SkinManager.getColor(R.color.CAM_X0107), null);
                    }
                    if (!bi9.t(R.string.obfuscated_res_0x7f0f0546, new Object[0]).equals(s45Var.g())) {
                        return null;
                    }
                    return WebPManager.getPureDrawable(R.drawable.icon_pure_pb_recommend_delete30, SkinManager.getColor(R.color.CAM_X0107), null);
                case 11:
                    return WebPManager.getPureDrawable(R.drawable.icon_pure_pb_recommend_block30, SkinManager.getColor(R.color.CAM_X0107), null);
                case 12:
                    if (bi9.t(R.string.obfuscated_res_0x7f0f0cf9, new Object[0]).equals(s45Var.g())) {
                        return WebPManager.getPureDrawable(R.drawable.icon_pure_pb_recommend_nospeaking30, SkinManager.getColor(R.color.CAM_X0107), null);
                    }
                    if (!bi9.t(R.string.un_mute, new Object[0]).equals(s45Var.g())) {
                        return null;
                    }
                    return WebPManager.getPureDrawable(R.drawable.icon_pure_pb_recommend_nospeakinged30, SkinManager.getColor(R.color.CAM_X0107), null);
                case 13:
                    return WebPManager.getPureDrawable(R.drawable.icon_pure_pb_batch_delete, SkinManager.getColor(R.color.CAM_X0107), null);
            }
        }
        return (Drawable) invokeL.objValue;
    }

    public static boolean k(rba rbaVar) {
        InterceptResult invokeL;
        Interceptable interceptable = $ic;
        if (interceptable == null || (invokeL = interceptable.invokeL(65546, null, rbaVar)) == null) {
            if (rbaVar != null && rbaVar.r() != null && !StringUtils.isNull(rbaVar.r().getUserId()) && rbaVar.r().getUserId().equals(TbadkCoreApplication.getCurrentAccount())) {
                return true;
            }
            return false;
        }
        return invokeL.booleanValue;
    }

    public static List<s45> l(List<s45> list, boolean z) {
        InterceptResult invokeLZ;
        Interceptable interceptable = $ic;
        if (interceptable == null || (invokeLZ = interceptable.invokeLZ(65547, null, list, z)) == null) {
            if (list != null && !z) {
                Iterator<s45> it = list.iterator();
                while (it.hasNext()) {
                    s45 next = it.next();
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
