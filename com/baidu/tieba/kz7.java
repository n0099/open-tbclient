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
import com.baidu.tieba.tbadkCore.data.PostData;
import com.baidu.tieba.vr4;
import com.baidu.titan.sdk.runtime.FieldHolder;
import com.baidu.titan.sdk.runtime.InterceptResult;
import com.baidu.titan.sdk.runtime.Interceptable;
import com.baidu.webkit.sdk.dumper.ZeusCrashHandler;
import java.util.ArrayList;
import java.util.Iterator;
import java.util.List;
/* loaded from: classes4.dex */
public class kz7 {
    public static /* synthetic */ Interceptable $ic;
    public transient /* synthetic */ FieldHolder $fh;

    public static boolean a(List<cs4> list, gs4 gs4Var, PostData postData, au7 au7Var) {
        InterceptResult invokeLLLL;
        Interceptable interceptable = $ic;
        if (interceptable == null || (invokeLLLL = interceptable.invokeLLLL(65536, null, list, gs4Var, postData, au7Var)) == null) {
            if (list == null || postData == null || au7Var == null || !au7Var.q() || !TbadkCoreApplication.isLogin() || k(postData) || au7Var.p()) {
                return false;
            }
            cs4 cs4Var = new cs4(9, TbadkCoreApplication.getInst().getString(R.string.obfuscated_res_0x7f0f0320), gs4Var);
            list.add(cs4Var);
            bs8.f(cs4Var.d, postData);
            return true;
        }
        return invokeLLLL.booleanValue;
    }

    public static boolean b(List<cs4> list, gs4 gs4Var, PostData postData, PbModel pbModel) {
        InterceptResult invokeLLLL;
        Interceptable interceptable = $ic;
        if (interceptable == null || (invokeLLLL = interceptable.invokeLLLL(65537, null, list, gs4Var, postData, pbModel)) == null) {
            if (list != null && postData != null && pbModel != null && pbModel.S1() != null) {
                kt7 S1 = pbModel.S1();
                if (S1.j0() && TbadkCoreApplication.isLogin() && !k(postData) && !S1.i0()) {
                    cs4 cs4Var = new cs4(9, TbadkCoreApplication.getInst().getString(R.string.obfuscated_res_0x7f0f0320), gs4Var);
                    list.add(cs4Var);
                    bs8.f(cs4Var.d, postData);
                    return true;
                }
            }
            return false;
        }
        return invokeLLLL.booleanValue;
    }

    public static List<cs4> c(List<cs4> list, AgreeData agreeData, SparseArray<Object> sparseArray, gs4 gs4Var) {
        InterceptResult invokeLLLL;
        Interceptable interceptable = $ic;
        if (interceptable == null || (invokeLLLL = interceptable.invokeLLLL(65538, null, list, agreeData, sparseArray, gs4Var)) == null) {
            if (list == null) {
                list = new ArrayList<>();
            }
            ArrayList arrayList = new ArrayList();
            if (agreeData.hasAgree) {
                if (agreeData.agreeType == 2) {
                    cs4 cs4Var = new cs4(-1, qx7.j(R.string.obfuscated_res_0x7f0f035e, new Object[0]), gs4Var);
                    cs4Var.d.setTag(sparseArray);
                    arrayList.add(cs4Var);
                    if (sparseArray == null || sparseArray.get(R.id.obfuscated_res_0x7f0917b7) == null || !((Boolean) sparseArray.get(R.id.obfuscated_res_0x7f0917b7)).booleanValue()) {
                        cs4 cs4Var2 = new cs4(-2, qx7.j(R.string.obfuscated_res_0x7f0f035f, new Object[0]), gs4Var);
                        cs4Var2.d.setTag(sparseArray);
                        arrayList.add(cs4Var2);
                    }
                } else {
                    cs4 cs4Var3 = new cs4(-1, qx7.j(R.string.obfuscated_res_0x7f0f035d, new Object[0]), gs4Var);
                    cs4Var3.d.setTag(sparseArray);
                    arrayList.add(cs4Var3);
                    if (sparseArray == null || sparseArray.get(R.id.obfuscated_res_0x7f0917b7) == null || !((Boolean) sparseArray.get(R.id.obfuscated_res_0x7f0917b7)).booleanValue()) {
                        cs4 cs4Var4 = new cs4(-2, qx7.j(R.string.obfuscated_res_0x7f0f0360, new Object[0]), gs4Var);
                        cs4Var4.d.setTag(sparseArray);
                        arrayList.add(cs4Var4);
                    }
                }
            } else {
                cs4 cs4Var5 = new cs4(-1, qx7.j(R.string.obfuscated_res_0x7f0f035d, new Object[0]), gs4Var);
                cs4Var5.d.setTag(sparseArray);
                arrayList.add(cs4Var5);
                if (sparseArray == null || sparseArray.get(R.id.obfuscated_res_0x7f0917b7) == null || !((Boolean) sparseArray.get(R.id.obfuscated_res_0x7f0917b7)).booleanValue()) {
                    cs4 cs4Var6 = new cs4(-2, qx7.j(R.string.obfuscated_res_0x7f0f035f, new Object[0]), gs4Var);
                    cs4Var6.d.setTag(sparseArray);
                    arrayList.add(cs4Var6);
                }
            }
            cs4 cs4Var7 = new cs4(-3, qx7.j(R.string.obfuscated_res_0x7f0f0fe1, new Object[0]), gs4Var);
            cs4Var7.d.setTag(sparseArray);
            arrayList.add(cs4Var7);
            cs4 cs4Var8 = new cs4(-4, qx7.j(R.string.obfuscated_res_0x7f0f1129, new Object[0]), gs4Var);
            cs4Var8.d.setTag(sparseArray);
            arrayList.add(cs4Var8);
            list.addAll(0, arrayList);
            return list;
        }
        return (List) invokeLLLL.objValue;
    }

    public static List<cs4> d(List<cs4> list, AgreeData agreeData, SparseArray<Object> sparseArray, gs4 gs4Var) {
        InterceptResult invokeLLLL;
        Interceptable interceptable = $ic;
        if (interceptable == null || (invokeLLLL = interceptable.invokeLLLL(65539, null, list, agreeData, sparseArray, gs4Var)) == null) {
            if (list == null) {
                list = new ArrayList<>();
            }
            ArrayList arrayList = new ArrayList();
            if (agreeData.hasAgree) {
                if (agreeData.agreeType == 2) {
                    if (sparseArray == null || sparseArray.get(R.id.obfuscated_res_0x7f0917b7) == null || !((Boolean) sparseArray.get(R.id.obfuscated_res_0x7f0917b7)).booleanValue()) {
                        cs4 cs4Var = new cs4(-2, qx7.j(R.string.obfuscated_res_0x7f0f0087, new Object[0]), gs4Var);
                        cs4Var.d.setTag(sparseArray);
                        arrayList.add(cs4Var);
                    }
                } else if (sparseArray == null || sparseArray.get(R.id.obfuscated_res_0x7f0917b7) == null || !((Boolean) sparseArray.get(R.id.obfuscated_res_0x7f0917b7)).booleanValue()) {
                    cs4 cs4Var2 = new cs4(-2, qx7.j(R.string.obfuscated_res_0x7f0f0360, new Object[0]), gs4Var);
                    cs4Var2.d.setTag(sparseArray);
                    arrayList.add(cs4Var2);
                }
            } else if (sparseArray == null || sparseArray.get(R.id.obfuscated_res_0x7f0917b7) == null || !((Boolean) sparseArray.get(R.id.obfuscated_res_0x7f0917b7)).booleanValue()) {
                cs4 cs4Var3 = new cs4(-2, qx7.j(R.string.obfuscated_res_0x7f0f0087, new Object[0]), gs4Var);
                cs4Var3.d.setTag(sparseArray);
                arrayList.add(cs4Var3);
            }
            cs4 cs4Var4 = new cs4(-3, qx7.j(R.string.obfuscated_res_0x7f0f0fe1, new Object[0]), gs4Var);
            cs4Var4.d.setTag(sparseArray);
            arrayList.add(0, cs4Var4);
            cs4 cs4Var5 = new cs4(-4, qx7.j(R.string.obfuscated_res_0x7f0f1129, new Object[0]), gs4Var);
            cs4Var5.d.setTag(sparseArray);
            arrayList.add(1, cs4Var5);
            list.addAll(0, arrayList);
            return list;
        }
        return (List) invokeLLLL.objValue;
    }

    public static void e(Activity activity, @Nullable d9<?> d9Var, vr4.e eVar, vr4.e eVar2) {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeLLLL(InputDeviceCompat.SOURCE_TRACKBALL, null, activity, d9Var, eVar, eVar2) == null) {
            vr4 vr4Var = new vr4(activity);
            vr4Var.setMessageId(R.string.obfuscated_res_0x7f0f04a8);
            vr4Var.setPositiveButton(R.string.obfuscated_res_0x7f0f04ef, eVar);
            vr4Var.setNegativeButton(R.string.obfuscated_res_0x7f0f04ea, eVar2);
            vr4Var.setCancelable(true);
            vr4Var.create(d9Var);
            vr4Var.show();
        }
    }

    public static List<cs4> f(List<cs4> list) {
        InterceptResult invokeL;
        Interceptable interceptable = $ic;
        if (interceptable == null || (invokeL = interceptable.invokeL(65541, null, list)) == null) {
            if (list == null) {
                return list;
            }
            for (cs4 cs4Var : list) {
                cs4Var.l(h(cs4Var));
            }
            return list;
        }
        return (List) invokeL.objValue;
    }

    public static SpannableStringBuilder g(PostData postData) {
        InterceptResult invokeL;
        Interceptable interceptable = $ic;
        if (interceptable == null || (invokeL = interceptable.invokeL(65542, null, postData)) == null) {
            if (postData == null) {
                return null;
            }
            String tbRichText = postData.V() != null ? postData.V().toString() : "";
            SpannableString n = n(postData.s().getName_show() + ZeusCrashHandler.NAME_SEPERATOR, SkinManager.getColor(R.color.CAM_X0109));
            SpannableString n2 = n(tbRichText, SkinManager.getColor(R.color.CAM_X0107));
            SpannableStringBuilder spannableStringBuilder = new SpannableStringBuilder();
            spannableStringBuilder.append((CharSequence) n);
            spannableStringBuilder.append((CharSequence) n2);
            return spannableStringBuilder;
        }
        return (SpannableStringBuilder) invokeL.objValue;
    }

    public static Drawable h(cs4 cs4Var) {
        InterceptResult invokeL;
        Interceptable interceptable = $ic;
        if (interceptable == null || (invokeL = interceptable.invokeL(65543, null, cs4Var)) == null) {
            switch (cs4Var.f()) {
                case -4:
                    return WebPManager.getPureDrawable(R.drawable.obfuscated_res_0x7f080988, SkinManager.getColor(R.color.CAM_X0107), null);
                case -3:
                    return WebPManager.getPureDrawable(R.drawable.obfuscated_res_0x7f080972, SkinManager.getColor(R.color.CAM_X0107), null);
                case -2:
                    if (qx7.j(R.string.obfuscated_res_0x7f0f035f, new Object[0]).equals(cs4Var.g())) {
                        return WebPManager.getPureDrawable(R.drawable.obfuscated_res_0x7f080976, SkinManager.getColor(R.color.CAM_X0107), null);
                    }
                    return WebPManager.getPureDrawable(R.drawable.obfuscated_res_0x7f080977, SkinManager.getColor(R.color.CAM_X0107), null);
                case -1:
                    if (qx7.j(R.string.obfuscated_res_0x7f0f035d, new Object[0]).equals(cs4Var.g())) {
                        return WebPManager.getPureDrawable(R.drawable.obfuscated_res_0x7f08097f, SkinManager.getColor(R.color.CAM_X0107), null);
                    }
                    return WebPManager.getPureDrawable(R.drawable.obfuscated_res_0x7f080980, SkinManager.getColor(R.color.CAM_X0301), null);
                case 0:
                default:
                    return null;
                case 1:
                    return WebPManager.getPureDrawable(R.drawable.obfuscated_res_0x7f080978, SkinManager.getColor(R.color.CAM_X0107), null);
                case 2:
                    return WebPManager.getPureDrawable(R.drawable.obfuscated_res_0x7f080987, SkinManager.getColor(R.color.CAM_X0107), null);
                case 3:
                    return WebPManager.getPureDrawable(R.drawable.obfuscated_res_0x7f080973, SkinManager.getColor(R.color.CAM_X0107), null);
                case 4:
                    if (qx7.j(R.string.obfuscated_res_0x7f0f0a94, new Object[0]).equals(cs4Var.g())) {
                        return WebPManager.getPureDrawable(R.drawable.obfuscated_res_0x7f080970, SkinManager.getColor(R.color.CAM_X0107), null);
                    }
                    return WebPManager.getPureDrawable(R.drawable.obfuscated_res_0x7f080971, SkinManager.getColor(R.color.CAM_X0305), null);
                case 5:
                    if (qx7.j(R.string.obfuscated_res_0x7f0f0ffa, new Object[0]).equals(cs4Var.g())) {
                        return WebPManager.getPureDrawable(R.drawable.obfuscated_res_0x7f080986, SkinManager.getColor(R.color.CAM_X0107), null);
                    }
                    if (qx7.j(R.string.obfuscated_res_0x7f0f0b37, new Object[0]).equals(cs4Var.g())) {
                        return WebPManager.getPureDrawable(R.drawable.obfuscated_res_0x7f080984, SkinManager.getColor(R.color.CAM_X0107), null);
                    }
                    return null;
                case 6:
                    if (qx7.j(R.string.obfuscated_res_0x7f0f0ffa, new Object[0]).equals(cs4Var.g())) {
                        return WebPManager.getPureDrawable(R.drawable.obfuscated_res_0x7f080986, SkinManager.getColor(R.color.CAM_X0107), null);
                    }
                    if (qx7.j(R.string.obfuscated_res_0x7f0f04ac, new Object[0]).equals(cs4Var.g())) {
                        return WebPManager.getPureDrawable(R.drawable.obfuscated_res_0x7f080975, SkinManager.getColor(R.color.CAM_X0107), null);
                    }
                    return null;
                case 7:
                    return WebPManager.getPureDrawable(R.drawable.obfuscated_res_0x7f08096b, SkinManager.getColor(R.color.CAM_X0107), null);
                case 8:
                    return WebPManager.getPureDrawable(R.drawable.obfuscated_res_0x7f08097b, SkinManager.getColor(R.color.CAM_X0107), null);
                case 9:
                    return WebPManager.getPureDrawable(R.drawable.obfuscated_res_0x7f08095e, SkinManager.getColor(R.color.CAM_X0107), null);
                case 10:
                    if (qx7.j(R.string.obfuscated_res_0x7f0f04b7, new Object[0]).equals(cs4Var.g())) {
                        return WebPManager.getPureDrawable(R.drawable.obfuscated_res_0x7f080975, SkinManager.getColor(R.color.CAM_X0107), null);
                    }
                    if (qx7.j(R.string.obfuscated_res_0x7f0f04ac, new Object[0]).equals(cs4Var.g())) {
                        return WebPManager.getPureDrawable(R.drawable.obfuscated_res_0x7f080975, SkinManager.getColor(R.color.CAM_X0107), null);
                    }
                    return null;
                case 11:
                    return WebPManager.getPureDrawable(R.drawable.obfuscated_res_0x7f08096f, SkinManager.getColor(R.color.CAM_X0107), null);
                case 12:
                    if (qx7.j(R.string.obfuscated_res_0x7f0f0b33, new Object[0]).equals(cs4Var.g())) {
                        return WebPManager.getPureDrawable(R.drawable.obfuscated_res_0x7f080982, SkinManager.getColor(R.color.CAM_X0107), null);
                    }
                    if (qx7.j(R.string.obfuscated_res_0x7f0f149c, new Object[0]).equals(cs4Var.g())) {
                        return WebPManager.getPureDrawable(R.drawable.obfuscated_res_0x7f080983, SkinManager.getColor(R.color.CAM_X0107), null);
                    }
                    return null;
                case 13:
                    return WebPManager.getPureDrawable(R.drawable.obfuscated_res_0x7f08095d, SkinManager.getColor(R.color.CAM_X0107), null);
            }
        }
        return (Drawable) invokeL.objValue;
    }

    public static boolean i(PbModel pbModel) {
        InterceptResult invokeL;
        Interceptable interceptable = $ic;
        return (interceptable == null || (invokeL = interceptable.invokeL(65544, null, pbModel)) == null) ? (pbModel == null || pbModel.S1() == null || !pbModel.S1().j0()) ? false : true : invokeL.booleanValue;
    }

    public static boolean j(au7 au7Var) {
        InterceptResult invokeL;
        Interceptable interceptable = $ic;
        return (interceptable == null || (invokeL = interceptable.invokeL(65545, null, au7Var)) == null) ? au7Var != null && au7Var.q() : invokeL.booleanValue;
    }

    public static boolean k(PostData postData) {
        InterceptResult invokeL;
        Interceptable interceptable = $ic;
        return (interceptable == null || (invokeL = interceptable.invokeL(65546, null, postData)) == null) ? (postData == null || postData.s() == null || StringUtils.isNull(postData.s().getUserId()) || !postData.s().getUserId().equals(TbadkCoreApplication.getCurrentAccount())) ? false : true : invokeL.booleanValue;
    }

    public static List<cs4> l(List<cs4> list, boolean z) {
        InterceptResult invokeLZ;
        Interceptable interceptable = $ic;
        if (interceptable == null || (invokeLZ = interceptable.invokeLZ(65547, null, list, z)) == null) {
            if (list != null && !z) {
                Iterator<cs4> it = list.iterator();
                while (it.hasNext()) {
                    cs4 next = it.next();
                    if (next.f() == 2 || next.f() == 1 || next.f() == 3) {
                        it.remove();
                    }
                }
            }
            return list;
        }
        return (List) invokeLZ.objValue;
    }

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
}
