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
import com.baidu.tieba.f05;
import com.baidu.tieba.tbadkCore.data.AgreeData;
import com.baidu.titan.sdk.runtime.FieldHolder;
import com.baidu.titan.sdk.runtime.InterceptResult;
import com.baidu.titan.sdk.runtime.Interceptable;
import com.baidu.webkit.sdk.dumper.ZeusCrashHandler;
import java.util.ArrayList;
import java.util.Iterator;
import java.util.List;
import tbclient.AigcFeedbackInfo;
/* loaded from: classes6.dex */
public class j4a {
    public static /* synthetic */ Interceptable $ic;
    public transient /* synthetic */ FieldHolder $fh;

    public static int j(int i) {
        InterceptResult invokeI;
        Interceptable interceptable = $ic;
        if (interceptable == null || (invokeI = interceptable.invokeI(65545, null, i)) == null) {
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

    public static List<l05> a(List<l05> list, AgreeData agreeData, SparseArray<?> sparseArray, p05 p05Var) {
        InterceptResult invokeLLLL;
        Interceptable interceptable = $ic;
        if (interceptable == null || (invokeLLLL = interceptable.invokeLLLL(65536, null, list, agreeData, sparseArray, p05Var)) == null) {
            return b(list, agreeData, sparseArray, p05Var, null);
        }
        return (List) invokeLLLL.objValue;
    }

    public static List<l05> b(List<l05> list, AgreeData agreeData, SparseArray<?> sparseArray, p05 p05Var, AigcFeedbackInfo aigcFeedbackInfo) {
        InterceptResult invokeLLLLL;
        Interceptable interceptable = $ic;
        if (interceptable == null || (invokeLLLLL = interceptable.invokeLLLLL(65537, null, list, agreeData, sparseArray, p05Var, aigcFeedbackInfo)) == null) {
            String p = n1a.p(R.string.c_agree, new Object[0]);
            String p2 = n1a.p(R.string.c_disagree, new Object[0]);
            String p3 = n1a.p(R.string.c_agreeed, new Object[0]);
            String p4 = n1a.p(R.string.c_disagreeed, new Object[0]);
            if (aigcFeedbackInfo != null) {
                String str = aigcFeedbackInfo.positive_text;
                String str2 = aigcFeedbackInfo.negative_text;
                if (!TextUtils.isEmpty(str) && !TextUtils.isEmpty(str2)) {
                    p2 = str2;
                    p4 = p2;
                    p = str;
                    p3 = p;
                }
            }
            if (list == null) {
                list = new ArrayList<>();
            }
            ArrayList arrayList = new ArrayList();
            if (agreeData.hasAgree) {
                if (agreeData.agreeType == 2) {
                    l05 l05Var = new l05(-1, p3, p05Var);
                    l05Var.o(true);
                    l05Var.d.setTag(sparseArray);
                    arrayList.add(l05Var);
                    if (!e(sparseArray, R.id.pb_dialog_item_isugc)) {
                        l05 l05Var2 = new l05(-2, p2, p05Var);
                        l05Var2.o(false);
                        l05Var2.d.setTag(sparseArray);
                        arrayList.add(l05Var2);
                    }
                } else {
                    l05 l05Var3 = new l05(-1, p, p05Var);
                    l05Var3.o(false);
                    l05Var3.d.setTag(sparseArray);
                    arrayList.add(l05Var3);
                    if (!e(sparseArray, R.id.pb_dialog_item_isugc)) {
                        l05 l05Var4 = new l05(-2, p4, p05Var);
                        l05Var4.o(true);
                        l05Var4.d.setTag(sparseArray);
                        arrayList.add(l05Var4);
                    }
                }
            } else {
                l05 l05Var5 = new l05(-1, p, p05Var);
                l05Var5.o(false);
                l05Var5.d.setTag(sparseArray);
                arrayList.add(l05Var5);
                if (!e(sparseArray, R.id.pb_dialog_item_isugc)) {
                    l05 l05Var6 = new l05(-2, p2, p05Var);
                    l05Var6.o(false);
                    l05Var6.d.setTag(sparseArray);
                    arrayList.add(l05Var6);
                }
            }
            l05 l05Var7 = new l05(-3, n1a.p(R.string.obfuscated_res_0x7f0f127d, new Object[0]), p05Var);
            l05Var7.d.setTag(sparseArray);
            arrayList.add(l05Var7);
            l05 l05Var8 = new l05(-4, n1a.p(R.string.obfuscated_res_0x7f0f13d8, new Object[0]), p05Var);
            l05Var8.d.setTag(sparseArray);
            arrayList.add(l05Var8);
            list.addAll(0, arrayList);
            return list;
        }
        return (List) invokeLLLLL.objValue;
    }

    public static void c(Activity activity, @Nullable BdPageContext<?> bdPageContext, f05.e eVar, f05.e eVar2) {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeLLLL(65538, null, activity, bdPageContext, eVar, eVar2) == null) {
            f05 f05Var = new f05(activity);
            f05Var.setMessageId(R.string.del_post_confirm);
            f05Var.setPositiveButton(R.string.obfuscated_res_0x7f0f05ab, eVar);
            f05Var.setNegativeButton(R.string.obfuscated_res_0x7f0f05a0, eVar2);
            f05Var.setCancelable(true);
            f05Var.create(bdPageContext);
            f05Var.show();
        }
    }

    public static List<l05> d(List<l05> list) {
        InterceptResult invokeL;
        Interceptable interceptable = $ic;
        if (interceptable == null || (invokeL = interceptable.invokeL(65539, null, list)) == null) {
            if (list == null) {
                return list;
            }
            for (l05 l05Var : list) {
                l05Var.m(g(l05Var));
            }
            return list;
        }
        return (List) invokeL.objValue;
    }

    public static boolean e(SparseArray<?> sparseArray, int i) {
        InterceptResult invokeLI;
        Interceptable interceptable = $ic;
        if (interceptable == null || (invokeLI = interceptable.invokeLI(InputDeviceCompat.SOURCE_TRACKBALL, null, sparseArray, i)) == null) {
            if (sparseArray != null && (sparseArray.get(i) instanceof Boolean)) {
                return ((Boolean) sparseArray.get(i)).booleanValue();
            }
            return false;
        }
        return invokeLI.booleanValue;
    }

    public static SpannableString k(String str, int i) {
        InterceptResult invokeLI;
        Interceptable interceptable = $ic;
        if (interceptable == null || (invokeLI = interceptable.invokeLI(65546, null, str, i)) == null) {
            SpannableString spannableString = new SpannableString(str);
            spannableString.setSpan(new ForegroundColorSpan(i), 0, str.length(), 33);
            return spannableString;
        }
        return (SpannableString) invokeLI.objValue;
    }

    public static SpannableStringBuilder f(nwa nwaVar) {
        InterceptResult invokeL;
        String str;
        Interceptable interceptable = $ic;
        if (interceptable == null || (invokeL = interceptable.invokeL(65541, null, nwaVar)) == null) {
            if (nwaVar == null) {
                return null;
            }
            if (nwaVar.f0() != null) {
                str = nwaVar.f0().toString();
            } else {
                str = "";
            }
            SpannableString k = k(nwaVar.u().getName_show() + ZeusCrashHandler.NAME_SEPERATOR, SkinManager.getColor(R.color.CAM_X0109));
            SpannableString k2 = k(str, SkinManager.getColor(R.color.CAM_X0107));
            SpannableStringBuilder spannableStringBuilder = new SpannableStringBuilder();
            spannableStringBuilder.append((CharSequence) k);
            spannableStringBuilder.append((CharSequence) k2);
            return spannableStringBuilder;
        }
        return (SpannableStringBuilder) invokeL.objValue;
    }

    public static Drawable g(l05 l05Var) {
        InterceptResult invokeL;
        Interceptable interceptable = $ic;
        if (interceptable == null || (invokeL = interceptable.invokeL(65542, null, l05Var)) == null) {
            switch (l05Var.f()) {
                case -4:
                    return WebPManager.getPureDrawable(R.drawable.icon_pure_pb_recommend_share30, SkinManager.getColor(R.color.CAM_X0107), null);
                case -3:
                    return WebPManager.getPureDrawable(R.drawable.icon_pure_pb_recommend_comment30, SkinManager.getColor(R.color.CAM_X0107), null);
                case -2:
                    if (!l05Var.k()) {
                        return WebPManager.getPureDrawable(R.drawable.icon_pure_pb_recommend_dislike30, SkinManager.getColor(R.color.CAM_X0107), null);
                    }
                    return WebPManager.getPureDrawable(R.drawable.icon_pure_pb_recommend_disliked30, SkinManager.getColor(R.color.CAM_X0107), null);
                case -1:
                    if (!l05Var.k()) {
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
                    if (n1a.p(R.string.obfuscated_res_0x7f0f0c89, new Object[0]).equals(l05Var.g())) {
                        return WebPManager.getPureDrawable(R.drawable.icon_pure_pb_recommend_collect30, SkinManager.getColor(R.color.CAM_X0107), null);
                    }
                    return WebPManager.getPureDrawable(R.drawable.icon_pure_pb_recommend_collected30, SkinManager.getColor(R.color.CAM_X0305), null);
                case 5:
                    if (n1a.p(R.string.report_text, new Object[0]).equals(l05Var.g())) {
                        return WebPManager.getPureDrawable(R.drawable.icon_pure_pb_recommend_report30, SkinManager.getColor(R.color.CAM_X0107), null);
                    }
                    if (!n1a.p(R.string.obfuscated_res_0x7f0f0d4b, new Object[0]).equals(l05Var.g())) {
                        return null;
                    }
                    return WebPManager.getPureDrawable(R.drawable.icon_pure_pb_recommend_nospeakingset30, SkinManager.getColor(R.color.CAM_X0107), null);
                case 6:
                    if (n1a.p(R.string.report_text, new Object[0]).equals(l05Var.g())) {
                        return WebPManager.getPureDrawable(R.drawable.icon_pure_pb_recommend_report30, SkinManager.getColor(R.color.CAM_X0107), null);
                    }
                    if (!n1a.p(R.string.obfuscated_res_0x7f0f055b, new Object[0]).equals(l05Var.g())) {
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
                    if (n1a.p(R.string.obfuscated_res_0x7f0f056a, new Object[0]).equals(l05Var.g())) {
                        return WebPManager.getPureDrawable(R.drawable.icon_pure_pb_recommend_delete30, SkinManager.getColor(R.color.CAM_X0107), null);
                    }
                    if (!n1a.p(R.string.obfuscated_res_0x7f0f055b, new Object[0]).equals(l05Var.g())) {
                        return null;
                    }
                    return WebPManager.getPureDrawable(R.drawable.icon_pure_pb_recommend_delete30, SkinManager.getColor(R.color.CAM_X0107), null);
                case 11:
                    return WebPManager.getPureDrawable(R.drawable.icon_pure_pb_recommend_block30, SkinManager.getColor(R.color.CAM_X0107), null);
                case 12:
                    if (n1a.p(R.string.obfuscated_res_0x7f0f0d47, new Object[0]).equals(l05Var.g())) {
                        return WebPManager.getPureDrawable(R.drawable.icon_pure_pb_recommend_nospeaking30, SkinManager.getColor(R.color.CAM_X0107), null);
                    }
                    if (!n1a.p(R.string.un_mute, new Object[0]).equals(l05Var.g())) {
                        return null;
                    }
                    return WebPManager.getPureDrawable(R.drawable.icon_pure_pb_recommend_nospeakinged30, SkinManager.getColor(R.color.CAM_X0107), null);
                case 13:
                    return WebPManager.getPureDrawable(R.drawable.icon_pure_pb_batch_delete, SkinManager.getColor(R.color.CAM_X0107), null);
            }
        }
        return (Drawable) invokeL.objValue;
    }

    public static boolean h(nwa nwaVar) {
        InterceptResult invokeL;
        Interceptable interceptable = $ic;
        if (interceptable == null || (invokeL = interceptable.invokeL(65543, null, nwaVar)) == null) {
            if (nwaVar != null && nwaVar.u() != null && !StringUtils.isNull(nwaVar.u().getUserId()) && nwaVar.u().getUserId().equals(TbadkCoreApplication.getCurrentAccount())) {
                return true;
            }
            return false;
        }
        return invokeL.booleanValue;
    }

    public static List<l05> i(List<l05> list, boolean z) {
        InterceptResult invokeLZ;
        Interceptable interceptable = $ic;
        if (interceptable == null || (invokeLZ = interceptable.invokeLZ(65544, null, list, z)) == null) {
            if (list != null && !z) {
                Iterator<l05> it = list.iterator();
                while (it.hasNext()) {
                    l05 next = it.next();
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
