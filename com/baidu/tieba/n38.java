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
import com.baidu.tieba.kv4;
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
public class n38 {
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

    public static boolean a(List<rv4> list, vv4 vv4Var, PostData postData, fy7 fy7Var, boolean z) {
        InterceptResult invokeCommon;
        Interceptable interceptable = $ic;
        if (interceptable == null || (invokeCommon = interceptable.invokeCommon(65536, null, new Object[]{list, vv4Var, postData, fy7Var, Boolean.valueOf(z)})) == null) {
            if (list == null || postData == null || fy7Var == null || !z || !fy7Var.q() || !TbadkCoreApplication.isLogin() || l(postData) || fy7Var.p()) {
                return false;
            }
            rv4 rv4Var = new rv4(9, TbadkCoreApplication.getInst().getString(R.string.obfuscated_res_0x7f0f0325), vv4Var);
            list.add(rv4Var);
            mw8.f(rv4Var.d, postData);
            return true;
        }
        return invokeCommon.booleanValue;
    }

    public static boolean b(List<rv4> list, vv4 vv4Var, PostData postData, PbModel pbModel) {
        InterceptResult invokeLLLL;
        Interceptable interceptable = $ic;
        if (interceptable == null || (invokeLLLL = interceptable.invokeLLLL(65537, null, list, vv4Var, postData, pbModel)) == null) {
            if (list != null && postData != null && pbModel != null && pbModel.S1() != null) {
                px7 S1 = pbModel.S1();
                if (S1.m0() && TbadkCoreApplication.isLogin() && !l(postData) && !S1.l0()) {
                    rv4 rv4Var = new rv4(9, TbadkCoreApplication.getInst().getString(R.string.obfuscated_res_0x7f0f0325), vv4Var);
                    list.add(rv4Var);
                    mw8.f(rv4Var.d, postData);
                    return true;
                }
            }
            return false;
        }
        return invokeLLLL.booleanValue;
    }

    public static List<rv4> c(List<rv4> list, AgreeData agreeData, SparseArray<?> sparseArray, vv4 vv4Var) {
        InterceptResult invokeLLLL;
        Interceptable interceptable = $ic;
        if (interceptable == null || (invokeLLLL = interceptable.invokeLLLL(65538, null, list, agreeData, sparseArray, vv4Var)) == null) {
            if (list == null) {
                list = new ArrayList<>();
            }
            ArrayList arrayList = new ArrayList();
            if (agreeData.hasAgree) {
                if (agreeData.agreeType == 2) {
                    rv4 rv4Var = new rv4(-1, r18.u(R.string.obfuscated_res_0x7f0f0363, new Object[0]), vv4Var);
                    rv4Var.d.setTag(sparseArray);
                    arrayList.add(rv4Var);
                    if (!g(sparseArray, R.id.obfuscated_res_0x7f091826)) {
                        rv4 rv4Var2 = new rv4(-2, r18.u(R.string.obfuscated_res_0x7f0f0364, new Object[0]), vv4Var);
                        rv4Var2.d.setTag(sparseArray);
                        arrayList.add(rv4Var2);
                    }
                } else {
                    rv4 rv4Var3 = new rv4(-1, r18.u(R.string.obfuscated_res_0x7f0f0362, new Object[0]), vv4Var);
                    rv4Var3.d.setTag(sparseArray);
                    arrayList.add(rv4Var3);
                    if (!g(sparseArray, R.id.obfuscated_res_0x7f091826)) {
                        rv4 rv4Var4 = new rv4(-2, r18.u(R.string.obfuscated_res_0x7f0f0365, new Object[0]), vv4Var);
                        rv4Var4.d.setTag(sparseArray);
                        arrayList.add(rv4Var4);
                    }
                }
            } else {
                rv4 rv4Var5 = new rv4(-1, r18.u(R.string.obfuscated_res_0x7f0f0362, new Object[0]), vv4Var);
                rv4Var5.d.setTag(sparseArray);
                arrayList.add(rv4Var5);
                if (!g(sparseArray, R.id.obfuscated_res_0x7f091826)) {
                    rv4 rv4Var6 = new rv4(-2, r18.u(R.string.obfuscated_res_0x7f0f0364, new Object[0]), vv4Var);
                    rv4Var6.d.setTag(sparseArray);
                    arrayList.add(rv4Var6);
                }
            }
            rv4 rv4Var7 = new rv4(-3, r18.u(R.string.obfuscated_res_0x7f0f1031, new Object[0]), vv4Var);
            rv4Var7.d.setTag(sparseArray);
            arrayList.add(rv4Var7);
            rv4 rv4Var8 = new rv4(-4, r18.u(R.string.obfuscated_res_0x7f0f117f, new Object[0]), vv4Var);
            rv4Var8.d.setTag(sparseArray);
            arrayList.add(rv4Var8);
            list.addAll(0, arrayList);
            return list;
        }
        return (List) invokeLLLL.objValue;
    }

    public static List<rv4> d(List<rv4> list, AgreeData agreeData, SparseArray<?> sparseArray, vv4 vv4Var) {
        InterceptResult invokeLLLL;
        Interceptable interceptable = $ic;
        if (interceptable == null || (invokeLLLL = interceptable.invokeLLLL(65539, null, list, agreeData, sparseArray, vv4Var)) == null) {
            if (list == null) {
                list = new ArrayList<>();
            }
            ArrayList arrayList = new ArrayList();
            if (agreeData.hasAgree) {
                if (agreeData.agreeType == 2) {
                    if (!g(sparseArray, R.id.obfuscated_res_0x7f091826)) {
                        rv4 rv4Var = new rv4(-2, r18.u(R.string.obfuscated_res_0x7f0f0087, new Object[0]), vv4Var);
                        rv4Var.d.setTag(sparseArray);
                        arrayList.add(rv4Var);
                    }
                } else if (!g(sparseArray, R.id.obfuscated_res_0x7f091826)) {
                    rv4 rv4Var2 = new rv4(-2, r18.u(R.string.obfuscated_res_0x7f0f0365, new Object[0]), vv4Var);
                    rv4Var2.d.setTag(sparseArray);
                    arrayList.add(rv4Var2);
                }
            } else if (!g(sparseArray, R.id.obfuscated_res_0x7f091826)) {
                rv4 rv4Var3 = new rv4(-2, r18.u(R.string.obfuscated_res_0x7f0f0087, new Object[0]), vv4Var);
                rv4Var3.d.setTag(sparseArray);
                arrayList.add(rv4Var3);
            }
            rv4 rv4Var4 = new rv4(-3, r18.u(R.string.obfuscated_res_0x7f0f1031, new Object[0]), vv4Var);
            rv4Var4.d.setTag(sparseArray);
            arrayList.add(0, rv4Var4);
            rv4 rv4Var5 = new rv4(-4, r18.u(R.string.obfuscated_res_0x7f0f117f, new Object[0]), vv4Var);
            rv4Var5.d.setTag(sparseArray);
            arrayList.add(1, rv4Var5);
            list.addAll(0, arrayList);
            return list;
        }
        return (List) invokeLLLL.objValue;
    }

    public static void e(Activity activity, @Nullable r9<?> r9Var, kv4.e eVar, kv4.e eVar2) {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeLLLL(InputDeviceCompat.SOURCE_TRACKBALL, null, activity, r9Var, eVar, eVar2) == null) {
            kv4 kv4Var = new kv4(activity);
            kv4Var.setMessageId(R.string.obfuscated_res_0x7f0f04b7);
            kv4Var.setPositiveButton(R.string.dialog_ok, eVar);
            kv4Var.setNegativeButton(R.string.dialog_cancel, eVar2);
            kv4Var.setCancelable(true);
            kv4Var.create(r9Var);
            kv4Var.show();
        }
    }

    public static List<rv4> f(List<rv4> list) {
        InterceptResult invokeL;
        Interceptable interceptable = $ic;
        if (interceptable == null || (invokeL = interceptable.invokeL(65541, null, list)) == null) {
            if (list == null) {
                return list;
            }
            for (rv4 rv4Var : list) {
                rv4Var.l(i(rv4Var));
            }
            return list;
        }
        return (List) invokeL.objValue;
    }

    public static boolean j(PbModel pbModel) {
        InterceptResult invokeL;
        Interceptable interceptable = $ic;
        if (interceptable == null || (invokeL = interceptable.invokeL(65545, null, pbModel)) == null) {
            if (pbModel != null && pbModel.S1() != null && pbModel.S1().m0()) {
                return true;
            }
            return false;
        }
        return invokeL.booleanValue;
    }

    public static boolean k(fy7 fy7Var) {
        InterceptResult invokeL;
        Interceptable interceptable = $ic;
        if (interceptable == null || (invokeL = interceptable.invokeL(65546, null, fy7Var)) == null) {
            if (fy7Var != null && fy7Var.q()) {
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
            if (postData.X() != null) {
                str = postData.X().toString();
            } else {
                str = "";
            }
            SpannableString o = o(postData.s().getName_show() + ZeusCrashHandler.NAME_SEPERATOR, SkinManager.getColor(R.color.CAM_X0109));
            SpannableString o2 = o(str, SkinManager.getColor(R.color.CAM_X0107));
            SpannableStringBuilder spannableStringBuilder = new SpannableStringBuilder();
            spannableStringBuilder.append((CharSequence) o);
            spannableStringBuilder.append((CharSequence) o2);
            return spannableStringBuilder;
        }
        return (SpannableStringBuilder) invokeL.objValue;
    }

    public static Drawable i(rv4 rv4Var) {
        InterceptResult invokeL;
        Interceptable interceptable = $ic;
        if (interceptable == null || (invokeL = interceptable.invokeL(65544, null, rv4Var)) == null) {
            switch (rv4Var.f()) {
                case -4:
                    return WebPManager.getPureDrawable(R.drawable.obfuscated_res_0x7f0809c3, SkinManager.getColor(R.color.CAM_X0107), null);
                case -3:
                    return WebPManager.getPureDrawable(R.drawable.obfuscated_res_0x7f0809ad, SkinManager.getColor(R.color.CAM_X0107), null);
                case -2:
                    if (r18.u(R.string.obfuscated_res_0x7f0f0364, new Object[0]).equals(rv4Var.g())) {
                        return WebPManager.getPureDrawable(R.drawable.obfuscated_res_0x7f0809b1, SkinManager.getColor(R.color.CAM_X0107), null);
                    }
                    return WebPManager.getPureDrawable(R.drawable.obfuscated_res_0x7f0809b2, SkinManager.getColor(R.color.CAM_X0107), null);
                case -1:
                    if (r18.u(R.string.obfuscated_res_0x7f0f0362, new Object[0]).equals(rv4Var.g())) {
                        return WebPManager.getPureDrawable(R.drawable.obfuscated_res_0x7f0809ba, SkinManager.getColor(R.color.CAM_X0107), null);
                    }
                    return WebPManager.getPureDrawable(R.drawable.obfuscated_res_0x7f0809bb, SkinManager.getColor(R.color.CAM_X0301), null);
                case 0:
                default:
                    return null;
                case 1:
                    return WebPManager.getPureDrawable(R.drawable.obfuscated_res_0x7f0809b3, SkinManager.getColor(R.color.CAM_X0107), null);
                case 2:
                    return WebPManager.getPureDrawable(R.drawable.obfuscated_res_0x7f0809c2, SkinManager.getColor(R.color.CAM_X0107), null);
                case 3:
                    return WebPManager.getPureDrawable(R.drawable.obfuscated_res_0x7f0809ae, SkinManager.getColor(R.color.CAM_X0107), null);
                case 4:
                    if (r18.u(R.string.obfuscated_res_0x7f0f0ac6, new Object[0]).equals(rv4Var.g())) {
                        return WebPManager.getPureDrawable(R.drawable.obfuscated_res_0x7f0809ab, SkinManager.getColor(R.color.CAM_X0107), null);
                    }
                    return WebPManager.getPureDrawable(R.drawable.obfuscated_res_0x7f0809ac, SkinManager.getColor(R.color.CAM_X0305), null);
                case 5:
                    if (r18.u(R.string.obfuscated_res_0x7f0f104a, new Object[0]).equals(rv4Var.g())) {
                        return WebPManager.getPureDrawable(R.drawable.obfuscated_res_0x7f0809c1, SkinManager.getColor(R.color.CAM_X0107), null);
                    }
                    if (!r18.u(R.string.obfuscated_res_0x7f0f0b6a, new Object[0]).equals(rv4Var.g())) {
                        return null;
                    }
                    return WebPManager.getPureDrawable(R.drawable.obfuscated_res_0x7f0809bf, SkinManager.getColor(R.color.CAM_X0107), null);
                case 6:
                    if (r18.u(R.string.obfuscated_res_0x7f0f104a, new Object[0]).equals(rv4Var.g())) {
                        return WebPManager.getPureDrawable(R.drawable.obfuscated_res_0x7f0809c1, SkinManager.getColor(R.color.CAM_X0107), null);
                    }
                    if (!r18.u(R.string.obfuscated_res_0x7f0f04bb, new Object[0]).equals(rv4Var.g())) {
                        return null;
                    }
                    return WebPManager.getPureDrawable(R.drawable.obfuscated_res_0x7f0809b0, SkinManager.getColor(R.color.CAM_X0107), null);
                case 7:
                    return WebPManager.getPureDrawable(R.drawable.obfuscated_res_0x7f0809a6, SkinManager.getColor(R.color.CAM_X0107), null);
                case 8:
                    return WebPManager.getPureDrawable(R.drawable.obfuscated_res_0x7f0809b6, SkinManager.getColor(R.color.CAM_X0107), null);
                case 9:
                    return WebPManager.getPureDrawable(R.drawable.obfuscated_res_0x7f080999, SkinManager.getColor(R.color.CAM_X0107), null);
                case 10:
                    if (r18.u(R.string.obfuscated_res_0x7f0f04c6, new Object[0]).equals(rv4Var.g())) {
                        return WebPManager.getPureDrawable(R.drawable.obfuscated_res_0x7f0809b0, SkinManager.getColor(R.color.CAM_X0107), null);
                    }
                    if (!r18.u(R.string.obfuscated_res_0x7f0f04bb, new Object[0]).equals(rv4Var.g())) {
                        return null;
                    }
                    return WebPManager.getPureDrawable(R.drawable.obfuscated_res_0x7f0809b0, SkinManager.getColor(R.color.CAM_X0107), null);
                case 11:
                    return WebPManager.getPureDrawable(R.drawable.obfuscated_res_0x7f0809aa, SkinManager.getColor(R.color.CAM_X0107), null);
                case 12:
                    if (r18.u(R.string.obfuscated_res_0x7f0f0b66, new Object[0]).equals(rv4Var.g())) {
                        return WebPManager.getPureDrawable(R.drawable.obfuscated_res_0x7f0809bd, SkinManager.getColor(R.color.CAM_X0107), null);
                    }
                    if (!r18.u(R.string.obfuscated_res_0x7f0f14fb, new Object[0]).equals(rv4Var.g())) {
                        return null;
                    }
                    return WebPManager.getPureDrawable(R.drawable.obfuscated_res_0x7f0809be, SkinManager.getColor(R.color.CAM_X0107), null);
                case 13:
                    return WebPManager.getPureDrawable(R.drawable.obfuscated_res_0x7f080998, SkinManager.getColor(R.color.CAM_X0107), null);
            }
        }
        return (Drawable) invokeL.objValue;
    }

    public static boolean l(PostData postData) {
        InterceptResult invokeL;
        Interceptable interceptable = $ic;
        if (interceptable == null || (invokeL = interceptable.invokeL(65547, null, postData)) == null) {
            if (postData != null && postData.s() != null && !StringUtils.isNull(postData.s().getUserId()) && postData.s().getUserId().equals(TbadkCoreApplication.getCurrentAccount())) {
                return true;
            }
            return false;
        }
        return invokeL.booleanValue;
    }

    public static List<rv4> m(List<rv4> list, boolean z) {
        InterceptResult invokeLZ;
        Interceptable interceptable = $ic;
        if (interceptable == null || (invokeLZ = interceptable.invokeLZ(65548, null, list, z)) == null) {
            if (list != null && !z) {
                Iterator<rv4> it = list.iterator();
                while (it.hasNext()) {
                    rv4 next = it.next();
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
