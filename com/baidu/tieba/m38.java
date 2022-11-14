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
import com.baidu.tieba.jv4;
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
public class m38 {
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

    public static boolean a(List<qv4> list, uv4 uv4Var, PostData postData, ey7 ey7Var, boolean z) {
        InterceptResult invokeCommon;
        Interceptable interceptable = $ic;
        if (interceptable == null || (invokeCommon = interceptable.invokeCommon(65536, null, new Object[]{list, uv4Var, postData, ey7Var, Boolean.valueOf(z)})) == null) {
            if (list == null || postData == null || ey7Var == null || !z || !ey7Var.q() || !TbadkCoreApplication.isLogin() || l(postData) || ey7Var.p()) {
                return false;
            }
            qv4 qv4Var = new qv4(9, TbadkCoreApplication.getInst().getString(R.string.obfuscated_res_0x7f0f0325), uv4Var);
            list.add(qv4Var);
            lw8.f(qv4Var.d, postData);
            return true;
        }
        return invokeCommon.booleanValue;
    }

    public static boolean b(List<qv4> list, uv4 uv4Var, PostData postData, PbModel pbModel) {
        InterceptResult invokeLLLL;
        Interceptable interceptable = $ic;
        if (interceptable == null || (invokeLLLL = interceptable.invokeLLLL(65537, null, list, uv4Var, postData, pbModel)) == null) {
            if (list != null && postData != null && pbModel != null && pbModel.S1() != null) {
                ox7 S1 = pbModel.S1();
                if (S1.m0() && TbadkCoreApplication.isLogin() && !l(postData) && !S1.l0()) {
                    qv4 qv4Var = new qv4(9, TbadkCoreApplication.getInst().getString(R.string.obfuscated_res_0x7f0f0325), uv4Var);
                    list.add(qv4Var);
                    lw8.f(qv4Var.d, postData);
                    return true;
                }
            }
            return false;
        }
        return invokeLLLL.booleanValue;
    }

    public static List<qv4> c(List<qv4> list, AgreeData agreeData, SparseArray<?> sparseArray, uv4 uv4Var) {
        InterceptResult invokeLLLL;
        Interceptable interceptable = $ic;
        if (interceptable == null || (invokeLLLL = interceptable.invokeLLLL(65538, null, list, agreeData, sparseArray, uv4Var)) == null) {
            if (list == null) {
                list = new ArrayList<>();
            }
            ArrayList arrayList = new ArrayList();
            if (agreeData.hasAgree) {
                if (agreeData.agreeType == 2) {
                    qv4 qv4Var = new qv4(-1, q18.u(R.string.obfuscated_res_0x7f0f0363, new Object[0]), uv4Var);
                    qv4Var.d.setTag(sparseArray);
                    arrayList.add(qv4Var);
                    if (!g(sparseArray, R.id.obfuscated_res_0x7f091826)) {
                        qv4 qv4Var2 = new qv4(-2, q18.u(R.string.obfuscated_res_0x7f0f0364, new Object[0]), uv4Var);
                        qv4Var2.d.setTag(sparseArray);
                        arrayList.add(qv4Var2);
                    }
                } else {
                    qv4 qv4Var3 = new qv4(-1, q18.u(R.string.obfuscated_res_0x7f0f0362, new Object[0]), uv4Var);
                    qv4Var3.d.setTag(sparseArray);
                    arrayList.add(qv4Var3);
                    if (!g(sparseArray, R.id.obfuscated_res_0x7f091826)) {
                        qv4 qv4Var4 = new qv4(-2, q18.u(R.string.obfuscated_res_0x7f0f0365, new Object[0]), uv4Var);
                        qv4Var4.d.setTag(sparseArray);
                        arrayList.add(qv4Var4);
                    }
                }
            } else {
                qv4 qv4Var5 = new qv4(-1, q18.u(R.string.obfuscated_res_0x7f0f0362, new Object[0]), uv4Var);
                qv4Var5.d.setTag(sparseArray);
                arrayList.add(qv4Var5);
                if (!g(sparseArray, R.id.obfuscated_res_0x7f091826)) {
                    qv4 qv4Var6 = new qv4(-2, q18.u(R.string.obfuscated_res_0x7f0f0364, new Object[0]), uv4Var);
                    qv4Var6.d.setTag(sparseArray);
                    arrayList.add(qv4Var6);
                }
            }
            qv4 qv4Var7 = new qv4(-3, q18.u(R.string.obfuscated_res_0x7f0f1031, new Object[0]), uv4Var);
            qv4Var7.d.setTag(sparseArray);
            arrayList.add(qv4Var7);
            qv4 qv4Var8 = new qv4(-4, q18.u(R.string.obfuscated_res_0x7f0f117f, new Object[0]), uv4Var);
            qv4Var8.d.setTag(sparseArray);
            arrayList.add(qv4Var8);
            list.addAll(0, arrayList);
            return list;
        }
        return (List) invokeLLLL.objValue;
    }

    public static List<qv4> d(List<qv4> list, AgreeData agreeData, SparseArray<?> sparseArray, uv4 uv4Var) {
        InterceptResult invokeLLLL;
        Interceptable interceptable = $ic;
        if (interceptable == null || (invokeLLLL = interceptable.invokeLLLL(65539, null, list, agreeData, sparseArray, uv4Var)) == null) {
            if (list == null) {
                list = new ArrayList<>();
            }
            ArrayList arrayList = new ArrayList();
            if (agreeData.hasAgree) {
                if (agreeData.agreeType == 2) {
                    if (!g(sparseArray, R.id.obfuscated_res_0x7f091826)) {
                        qv4 qv4Var = new qv4(-2, q18.u(R.string.obfuscated_res_0x7f0f0087, new Object[0]), uv4Var);
                        qv4Var.d.setTag(sparseArray);
                        arrayList.add(qv4Var);
                    }
                } else if (!g(sparseArray, R.id.obfuscated_res_0x7f091826)) {
                    qv4 qv4Var2 = new qv4(-2, q18.u(R.string.obfuscated_res_0x7f0f0365, new Object[0]), uv4Var);
                    qv4Var2.d.setTag(sparseArray);
                    arrayList.add(qv4Var2);
                }
            } else if (!g(sparseArray, R.id.obfuscated_res_0x7f091826)) {
                qv4 qv4Var3 = new qv4(-2, q18.u(R.string.obfuscated_res_0x7f0f0087, new Object[0]), uv4Var);
                qv4Var3.d.setTag(sparseArray);
                arrayList.add(qv4Var3);
            }
            qv4 qv4Var4 = new qv4(-3, q18.u(R.string.obfuscated_res_0x7f0f1031, new Object[0]), uv4Var);
            qv4Var4.d.setTag(sparseArray);
            arrayList.add(0, qv4Var4);
            qv4 qv4Var5 = new qv4(-4, q18.u(R.string.obfuscated_res_0x7f0f117f, new Object[0]), uv4Var);
            qv4Var5.d.setTag(sparseArray);
            arrayList.add(1, qv4Var5);
            list.addAll(0, arrayList);
            return list;
        }
        return (List) invokeLLLL.objValue;
    }

    public static void e(Activity activity, @Nullable r9<?> r9Var, jv4.e eVar, jv4.e eVar2) {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeLLLL(InputDeviceCompat.SOURCE_TRACKBALL, null, activity, r9Var, eVar, eVar2) == null) {
            jv4 jv4Var = new jv4(activity);
            jv4Var.setMessageId(R.string.obfuscated_res_0x7f0f04b7);
            jv4Var.setPositiveButton(R.string.dialog_ok, eVar);
            jv4Var.setNegativeButton(R.string.dialog_cancel, eVar2);
            jv4Var.setCancelable(true);
            jv4Var.create(r9Var);
            jv4Var.show();
        }
    }

    public static List<qv4> f(List<qv4> list) {
        InterceptResult invokeL;
        Interceptable interceptable = $ic;
        if (interceptable == null || (invokeL = interceptable.invokeL(65541, null, list)) == null) {
            if (list == null) {
                return list;
            }
            for (qv4 qv4Var : list) {
                qv4Var.l(i(qv4Var));
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

    public static boolean k(ey7 ey7Var) {
        InterceptResult invokeL;
        Interceptable interceptable = $ic;
        if (interceptable == null || (invokeL = interceptable.invokeL(65546, null, ey7Var)) == null) {
            if (ey7Var != null && ey7Var.q()) {
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

    public static Drawable i(qv4 qv4Var) {
        InterceptResult invokeL;
        Interceptable interceptable = $ic;
        if (interceptable == null || (invokeL = interceptable.invokeL(65544, null, qv4Var)) == null) {
            switch (qv4Var.f()) {
                case -4:
                    return WebPManager.getPureDrawable(R.drawable.obfuscated_res_0x7f0809c3, SkinManager.getColor(R.color.CAM_X0107), null);
                case -3:
                    return WebPManager.getPureDrawable(R.drawable.obfuscated_res_0x7f0809ad, SkinManager.getColor(R.color.CAM_X0107), null);
                case -2:
                    if (q18.u(R.string.obfuscated_res_0x7f0f0364, new Object[0]).equals(qv4Var.g())) {
                        return WebPManager.getPureDrawable(R.drawable.obfuscated_res_0x7f0809b1, SkinManager.getColor(R.color.CAM_X0107), null);
                    }
                    return WebPManager.getPureDrawable(R.drawable.obfuscated_res_0x7f0809b2, SkinManager.getColor(R.color.CAM_X0107), null);
                case -1:
                    if (q18.u(R.string.obfuscated_res_0x7f0f0362, new Object[0]).equals(qv4Var.g())) {
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
                    if (q18.u(R.string.obfuscated_res_0x7f0f0ac6, new Object[0]).equals(qv4Var.g())) {
                        return WebPManager.getPureDrawable(R.drawable.obfuscated_res_0x7f0809ab, SkinManager.getColor(R.color.CAM_X0107), null);
                    }
                    return WebPManager.getPureDrawable(R.drawable.obfuscated_res_0x7f0809ac, SkinManager.getColor(R.color.CAM_X0305), null);
                case 5:
                    if (q18.u(R.string.obfuscated_res_0x7f0f104a, new Object[0]).equals(qv4Var.g())) {
                        return WebPManager.getPureDrawable(R.drawable.obfuscated_res_0x7f0809c1, SkinManager.getColor(R.color.CAM_X0107), null);
                    }
                    if (!q18.u(R.string.obfuscated_res_0x7f0f0b6a, new Object[0]).equals(qv4Var.g())) {
                        return null;
                    }
                    return WebPManager.getPureDrawable(R.drawable.obfuscated_res_0x7f0809bf, SkinManager.getColor(R.color.CAM_X0107), null);
                case 6:
                    if (q18.u(R.string.obfuscated_res_0x7f0f104a, new Object[0]).equals(qv4Var.g())) {
                        return WebPManager.getPureDrawable(R.drawable.obfuscated_res_0x7f0809c1, SkinManager.getColor(R.color.CAM_X0107), null);
                    }
                    if (!q18.u(R.string.obfuscated_res_0x7f0f04bb, new Object[0]).equals(qv4Var.g())) {
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
                    if (q18.u(R.string.obfuscated_res_0x7f0f04c6, new Object[0]).equals(qv4Var.g())) {
                        return WebPManager.getPureDrawable(R.drawable.obfuscated_res_0x7f0809b0, SkinManager.getColor(R.color.CAM_X0107), null);
                    }
                    if (!q18.u(R.string.obfuscated_res_0x7f0f04bb, new Object[0]).equals(qv4Var.g())) {
                        return null;
                    }
                    return WebPManager.getPureDrawable(R.drawable.obfuscated_res_0x7f0809b0, SkinManager.getColor(R.color.CAM_X0107), null);
                case 11:
                    return WebPManager.getPureDrawable(R.drawable.obfuscated_res_0x7f0809aa, SkinManager.getColor(R.color.CAM_X0107), null);
                case 12:
                    if (q18.u(R.string.obfuscated_res_0x7f0f0b66, new Object[0]).equals(qv4Var.g())) {
                        return WebPManager.getPureDrawable(R.drawable.obfuscated_res_0x7f0809bd, SkinManager.getColor(R.color.CAM_X0107), null);
                    }
                    if (!q18.u(R.string.obfuscated_res_0x7f0f14fb, new Object[0]).equals(qv4Var.g())) {
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

    public static List<qv4> m(List<qv4> list, boolean z) {
        InterceptResult invokeLZ;
        Interceptable interceptable = $ic;
        if (interceptable == null || (invokeLZ = interceptable.invokeLZ(65548, null, list, z)) == null) {
            if (list != null && !z) {
                Iterator<qv4> it = list.iterator();
                while (it.hasNext()) {
                    qv4 next = it.next();
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
