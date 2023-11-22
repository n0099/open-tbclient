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
import com.baidu.tieba.zz4;
import com.baidu.titan.sdk.runtime.FieldHolder;
import com.baidu.titan.sdk.runtime.InterceptResult;
import com.baidu.titan.sdk.runtime.Interceptable;
import com.baidu.webkit.sdk.dumper.ZeusCrashHandler;
import java.util.ArrayList;
import java.util.Iterator;
import java.util.List;
import tbclient.AigcFeedbackInfo;
/* loaded from: classes7.dex */
public class lz9 {
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

    public static boolean a(List<f05> list, j05 j05Var, vra vraVar, vs9 vs9Var, boolean z) {
        InterceptResult invokeCommon;
        Interceptable interceptable = $ic;
        if (interceptable == null || (invokeCommon = interceptable.invokeCommon(65536, null, new Object[]{list, j05Var, vraVar, vs9Var, Boolean.valueOf(z)})) == null) {
            if (list == null || vraVar == null || vs9Var == null || !z || !vs9Var.o() || !TbadkCoreApplication.isLogin() || l(vraVar) || vs9Var.n()) {
                return false;
            }
            f05 f05Var = new f05(9, TbadkCoreApplication.getInst().getString(R.string.obfuscated_res_0x7f0f0369), j05Var);
            list.add(f05Var);
            j0b.f(f05Var.d, vraVar);
            return true;
        }
        return invokeCommon.booleanValue;
    }

    public static boolean b(List<f05> list, j05 j05Var, vra vraVar, PbModel pbModel) {
        InterceptResult invokeLLLL;
        Interceptable interceptable = $ic;
        if (interceptable == null || (invokeLLLL = interceptable.invokeLLLL(65537, null, list, j05Var, vraVar, pbModel)) == null) {
            if (list != null && vraVar != null && pbModel != null && pbModel.t1() != null) {
                es9 t1 = pbModel.t1();
                if (t1.k0() && TbadkCoreApplication.isLogin() && !l(vraVar) && !t1.j0()) {
                    f05 f05Var = new f05(9, TbadkCoreApplication.getInst().getString(R.string.obfuscated_res_0x7f0f0369), j05Var);
                    list.add(f05Var);
                    j0b.f(f05Var.d, vraVar);
                    return true;
                }
            }
            return false;
        }
        return invokeLLLL.booleanValue;
    }

    public static List<f05> c(List<f05> list, AgreeData agreeData, SparseArray<?> sparseArray, j05 j05Var) {
        InterceptResult invokeLLLL;
        Interceptable interceptable = $ic;
        if (interceptable == null || (invokeLLLL = interceptable.invokeLLLL(65538, null, list, agreeData, sparseArray, j05Var)) == null) {
            return d(list, agreeData, sparseArray, j05Var, null);
        }
        return (List) invokeLLLL.objValue;
    }

    public static List<f05> d(List<f05> list, AgreeData agreeData, SparseArray<?> sparseArray, j05 j05Var, AigcFeedbackInfo aigcFeedbackInfo) {
        InterceptResult invokeLLLLL;
        Interceptable interceptable = $ic;
        if (interceptable == null || (invokeLLLLL = interceptable.invokeLLLLL(65539, null, list, agreeData, sparseArray, j05Var, aigcFeedbackInfo)) == null) {
            String u = ix9.u(R.string.c_agree, new Object[0]);
            String u2 = ix9.u(R.string.c_disagree, new Object[0]);
            String u3 = ix9.u(R.string.c_agreeed, new Object[0]);
            String u4 = ix9.u(R.string.c_disagreeed, new Object[0]);
            if (aigcFeedbackInfo != null) {
                String str = aigcFeedbackInfo.positive_text;
                String str2 = aigcFeedbackInfo.negative_text;
                if (!TextUtils.isEmpty(str) && !TextUtils.isEmpty(str2)) {
                    u2 = str2;
                    u4 = u2;
                    u = str;
                    u3 = u;
                }
            }
            if (list == null) {
                list = new ArrayList<>();
            }
            ArrayList arrayList = new ArrayList();
            if (agreeData.hasAgree) {
                if (agreeData.agreeType == 2) {
                    f05 f05Var = new f05(-1, u3, j05Var);
                    f05Var.o(true);
                    f05Var.d.setTag(sparseArray);
                    arrayList.add(f05Var);
                    if (!g(sparseArray, R.id.pb_dialog_item_isugc)) {
                        f05 f05Var2 = new f05(-2, u2, j05Var);
                        f05Var2.o(false);
                        f05Var2.d.setTag(sparseArray);
                        arrayList.add(f05Var2);
                    }
                } else {
                    f05 f05Var3 = new f05(-1, u, j05Var);
                    f05Var3.o(false);
                    f05Var3.d.setTag(sparseArray);
                    arrayList.add(f05Var3);
                    if (!g(sparseArray, R.id.pb_dialog_item_isugc)) {
                        f05 f05Var4 = new f05(-2, u4, j05Var);
                        f05Var4.o(true);
                        f05Var4.d.setTag(sparseArray);
                        arrayList.add(f05Var4);
                    }
                }
            } else {
                f05 f05Var5 = new f05(-1, u, j05Var);
                f05Var5.o(false);
                f05Var5.d.setTag(sparseArray);
                arrayList.add(f05Var5);
                if (!g(sparseArray, R.id.pb_dialog_item_isugc)) {
                    f05 f05Var6 = new f05(-2, u2, j05Var);
                    f05Var6.o(false);
                    f05Var6.d.setTag(sparseArray);
                    arrayList.add(f05Var6);
                }
            }
            f05 f05Var7 = new f05(-3, ix9.u(R.string.obfuscated_res_0x7f0f126c, new Object[0]), j05Var);
            f05Var7.d.setTag(sparseArray);
            arrayList.add(f05Var7);
            f05 f05Var8 = new f05(-4, ix9.u(R.string.obfuscated_res_0x7f0f13c7, new Object[0]), j05Var);
            f05Var8.d.setTag(sparseArray);
            arrayList.add(f05Var8);
            list.addAll(0, arrayList);
            return list;
        }
        return (List) invokeLLLLL.objValue;
    }

    public static void e(Activity activity, @Nullable BdPageContext<?> bdPageContext, zz4.e eVar, zz4.e eVar2) {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeLLLL(InputDeviceCompat.SOURCE_TRACKBALL, null, activity, bdPageContext, eVar, eVar2) == null) {
            zz4 zz4Var = new zz4(activity);
            zz4Var.setMessageId(R.string.del_post_confirm);
            zz4Var.setPositiveButton(R.string.obfuscated_res_0x7f0f05a3, eVar);
            zz4Var.setNegativeButton(R.string.obfuscated_res_0x7f0f0598, eVar2);
            zz4Var.setCancelable(true);
            zz4Var.create(bdPageContext);
            zz4Var.show();
        }
    }

    public static List<f05> f(List<f05> list) {
        InterceptResult invokeL;
        Interceptable interceptable = $ic;
        if (interceptable == null || (invokeL = interceptable.invokeL(65541, null, list)) == null) {
            if (list == null) {
                return list;
            }
            for (f05 f05Var : list) {
                f05Var.m(i(f05Var));
            }
            return list;
        }
        return (List) invokeL.objValue;
    }

    public static boolean j(PbModel pbModel) {
        InterceptResult invokeL;
        Interceptable interceptable = $ic;
        if (interceptable == null || (invokeL = interceptable.invokeL(65545, null, pbModel)) == null) {
            if (pbModel != null && pbModel.t1() != null && pbModel.t1().k0()) {
                return true;
            }
            return false;
        }
        return invokeL.booleanValue;
    }

    public static boolean k(vs9 vs9Var) {
        InterceptResult invokeL;
        Interceptable interceptable = $ic;
        if (interceptable == null || (invokeL = interceptable.invokeL(65546, null, vs9Var)) == null) {
            if (vs9Var != null && vs9Var.o()) {
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

    public static SpannableStringBuilder h(vra vraVar) {
        InterceptResult invokeL;
        String str;
        Interceptable interceptable = $ic;
        if (interceptable == null || (invokeL = interceptable.invokeL(65543, null, vraVar)) == null) {
            if (vraVar == null) {
                return null;
            }
            if (vraVar.e0() != null) {
                str = vraVar.e0().toString();
            } else {
                str = "";
            }
            SpannableString o = o(vraVar.t().getName_show() + ZeusCrashHandler.NAME_SEPERATOR, SkinManager.getColor(R.color.CAM_X0109));
            SpannableString o2 = o(str, SkinManager.getColor(R.color.CAM_X0107));
            SpannableStringBuilder spannableStringBuilder = new SpannableStringBuilder();
            spannableStringBuilder.append((CharSequence) o);
            spannableStringBuilder.append((CharSequence) o2);
            return spannableStringBuilder;
        }
        return (SpannableStringBuilder) invokeL.objValue;
    }

    public static Drawable i(f05 f05Var) {
        InterceptResult invokeL;
        Interceptable interceptable = $ic;
        if (interceptable == null || (invokeL = interceptable.invokeL(65544, null, f05Var)) == null) {
            switch (f05Var.f()) {
                case -4:
                    return WebPManager.getPureDrawable(R.drawable.icon_pure_pb_recommend_share30, SkinManager.getColor(R.color.CAM_X0107), null);
                case -3:
                    return WebPManager.getPureDrawable(R.drawable.icon_pure_pb_recommend_comment30, SkinManager.getColor(R.color.CAM_X0107), null);
                case -2:
                    if (!f05Var.k()) {
                        return WebPManager.getPureDrawable(R.drawable.icon_pure_pb_recommend_dislike30, SkinManager.getColor(R.color.CAM_X0107), null);
                    }
                    return WebPManager.getPureDrawable(R.drawable.icon_pure_pb_recommend_disliked30, SkinManager.getColor(R.color.CAM_X0107), null);
                case -1:
                    if (!f05Var.k()) {
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
                    if (ix9.u(R.string.obfuscated_res_0x7f0f0c7b, new Object[0]).equals(f05Var.g())) {
                        return WebPManager.getPureDrawable(R.drawable.icon_pure_pb_recommend_collect30, SkinManager.getColor(R.color.CAM_X0107), null);
                    }
                    return WebPManager.getPureDrawable(R.drawable.icon_pure_pb_recommend_collected30, SkinManager.getColor(R.color.CAM_X0305), null);
                case 5:
                    if (ix9.u(R.string.report_text, new Object[0]).equals(f05Var.g())) {
                        return WebPManager.getPureDrawable(R.drawable.icon_pure_pb_recommend_report30, SkinManager.getColor(R.color.CAM_X0107), null);
                    }
                    if (!ix9.u(R.string.obfuscated_res_0x7f0f0d3d, new Object[0]).equals(f05Var.g())) {
                        return null;
                    }
                    return WebPManager.getPureDrawable(R.drawable.icon_pure_pb_recommend_nospeakingset30, SkinManager.getColor(R.color.CAM_X0107), null);
                case 6:
                    if (ix9.u(R.string.report_text, new Object[0]).equals(f05Var.g())) {
                        return WebPManager.getPureDrawable(R.drawable.icon_pure_pb_recommend_report30, SkinManager.getColor(R.color.CAM_X0107), null);
                    }
                    if (!ix9.u(R.string.obfuscated_res_0x7f0f0553, new Object[0]).equals(f05Var.g())) {
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
                    if (ix9.u(R.string.obfuscated_res_0x7f0f0562, new Object[0]).equals(f05Var.g())) {
                        return WebPManager.getPureDrawable(R.drawable.icon_pure_pb_recommend_delete30, SkinManager.getColor(R.color.CAM_X0107), null);
                    }
                    if (!ix9.u(R.string.obfuscated_res_0x7f0f0553, new Object[0]).equals(f05Var.g())) {
                        return null;
                    }
                    return WebPManager.getPureDrawable(R.drawable.icon_pure_pb_recommend_delete30, SkinManager.getColor(R.color.CAM_X0107), null);
                case 11:
                    return WebPManager.getPureDrawable(R.drawable.icon_pure_pb_recommend_block30, SkinManager.getColor(R.color.CAM_X0107), null);
                case 12:
                    if (ix9.u(R.string.obfuscated_res_0x7f0f0d39, new Object[0]).equals(f05Var.g())) {
                        return WebPManager.getPureDrawable(R.drawable.icon_pure_pb_recommend_nospeaking30, SkinManager.getColor(R.color.CAM_X0107), null);
                    }
                    if (!ix9.u(R.string.un_mute, new Object[0]).equals(f05Var.g())) {
                        return null;
                    }
                    return WebPManager.getPureDrawable(R.drawable.icon_pure_pb_recommend_nospeakinged30, SkinManager.getColor(R.color.CAM_X0107), null);
                case 13:
                    return WebPManager.getPureDrawable(R.drawable.icon_pure_pb_batch_delete, SkinManager.getColor(R.color.CAM_X0107), null);
            }
        }
        return (Drawable) invokeL.objValue;
    }

    public static boolean l(vra vraVar) {
        InterceptResult invokeL;
        Interceptable interceptable = $ic;
        if (interceptable == null || (invokeL = interceptable.invokeL(65547, null, vraVar)) == null) {
            if (vraVar != null && vraVar.t() != null && !StringUtils.isNull(vraVar.t().getUserId()) && vraVar.t().getUserId().equals(TbadkCoreApplication.getCurrentAccount())) {
                return true;
            }
            return false;
        }
        return invokeL.booleanValue;
    }

    public static List<f05> m(List<f05> list, boolean z) {
        InterceptResult invokeLZ;
        Interceptable interceptable = $ic;
        if (interceptable == null || (invokeLZ = interceptable.invokeLZ(65548, null, list, z)) == null) {
            if (list != null && !z) {
                Iterator<f05> it = list.iterator();
                while (it.hasNext()) {
                    f05 next = it.next();
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
