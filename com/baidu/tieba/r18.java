package com.baidu.tieba;

import android.app.Activity;
import android.graphics.drawable.Drawable;
import android.text.SpannableString;
import android.text.SpannableStringBuilder;
import android.text.style.ForegroundColorSpan;
import android.util.SparseArray;
import androidx.core.view.InputDeviceCompat;
import com.baidu.adp.lib.util.StringUtils;
import com.baidu.tbadk.core.TbadkCoreApplication;
import com.baidu.tbadk.core.util.SkinManager;
import com.baidu.tbadk.core.util.WebPManager;
import com.baidu.tieba.pb.pb.main.PbModel;
import com.baidu.tieba.pu4;
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
public class r18 {
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

    public static boolean a(List list, av4 av4Var, PostData postData, kw7 kw7Var, boolean z) {
        InterceptResult invokeCommon;
        Interceptable interceptable = $ic;
        if (interceptable == null || (invokeCommon = interceptable.invokeCommon(65536, null, new Object[]{list, av4Var, postData, kw7Var, Boolean.valueOf(z)})) == null) {
            if (list == null || postData == null || kw7Var == null || !z || !kw7Var.q() || !TbadkCoreApplication.isLogin() || k(postData) || kw7Var.p()) {
                return false;
            }
            wu4 wu4Var = new wu4(9, TbadkCoreApplication.getInst().getString(R.string.obfuscated_res_0x7f0f0324), av4Var);
            list.add(wu4Var);
            ru8.f(wu4Var.d, postData);
            return true;
        }
        return invokeCommon.booleanValue;
    }

    public static boolean b(List list, av4 av4Var, PostData postData, PbModel pbModel) {
        InterceptResult invokeLLLL;
        Interceptable interceptable = $ic;
        if (interceptable == null || (invokeLLLL = interceptable.invokeLLLL(65537, null, list, av4Var, postData, pbModel)) == null) {
            if (list != null && postData != null && pbModel != null && pbModel.S1() != null) {
                uv7 S1 = pbModel.S1();
                if (S1.l0() && TbadkCoreApplication.isLogin() && !k(postData) && !S1.k0()) {
                    wu4 wu4Var = new wu4(9, TbadkCoreApplication.getInst().getString(R.string.obfuscated_res_0x7f0f0324), av4Var);
                    list.add(wu4Var);
                    ru8.f(wu4Var.d, postData);
                    return true;
                }
            }
            return false;
        }
        return invokeLLLL.booleanValue;
    }

    public static List c(List list, AgreeData agreeData, SparseArray sparseArray, av4 av4Var) {
        InterceptResult invokeLLLL;
        Interceptable interceptable = $ic;
        if (interceptable == null || (invokeLLLL = interceptable.invokeLLLL(65538, null, list, agreeData, sparseArray, av4Var)) == null) {
            if (list == null) {
                list = new ArrayList();
            }
            ArrayList arrayList = new ArrayList();
            if (agreeData.hasAgree) {
                if (agreeData.agreeType == 2) {
                    wu4 wu4Var = new wu4(-1, wz7.j(R.string.obfuscated_res_0x7f0f0362, new Object[0]), av4Var);
                    wu4Var.d.setTag(sparseArray);
                    arrayList.add(wu4Var);
                    if (sparseArray == null || sparseArray.get(R.id.obfuscated_res_0x7f0917de) == null || ((Boolean) sparseArray.get(R.id.obfuscated_res_0x7f0917de)).booleanValue()) {
                        wu4 wu4Var2 = new wu4(-2, wz7.j(R.string.obfuscated_res_0x7f0f0363, new Object[0]), av4Var);
                        wu4Var2.d.setTag(sparseArray);
                        arrayList.add(wu4Var2);
                    }
                } else {
                    wu4 wu4Var3 = new wu4(-1, wz7.j(R.string.obfuscated_res_0x7f0f0361, new Object[0]), av4Var);
                    wu4Var3.d.setTag(sparseArray);
                    arrayList.add(wu4Var3);
                    if (sparseArray == null || sparseArray.get(R.id.obfuscated_res_0x7f0917de) == null || ((Boolean) sparseArray.get(R.id.obfuscated_res_0x7f0917de)).booleanValue()) {
                        wu4 wu4Var4 = new wu4(-2, wz7.j(R.string.obfuscated_res_0x7f0f0364, new Object[0]), av4Var);
                        wu4Var4.d.setTag(sparseArray);
                        arrayList.add(wu4Var4);
                    }
                }
            } else {
                wu4 wu4Var5 = new wu4(-1, wz7.j(R.string.obfuscated_res_0x7f0f0361, new Object[0]), av4Var);
                wu4Var5.d.setTag(sparseArray);
                arrayList.add(wu4Var5);
                if (sparseArray == null || sparseArray.get(R.id.obfuscated_res_0x7f0917de) == null || !((Boolean) sparseArray.get(R.id.obfuscated_res_0x7f0917de)).booleanValue()) {
                    wu4 wu4Var6 = new wu4(-2, wz7.j(R.string.obfuscated_res_0x7f0f0363, new Object[0]), av4Var);
                    wu4Var6.d.setTag(sparseArray);
                    arrayList.add(wu4Var6);
                }
            }
            wu4 wu4Var7 = new wu4(-3, wz7.j(R.string.obfuscated_res_0x7f0f1010, new Object[0]), av4Var);
            wu4Var7.d.setTag(sparseArray);
            arrayList.add(wu4Var7);
            wu4 wu4Var8 = new wu4(-4, wz7.j(R.string.obfuscated_res_0x7f0f115b, new Object[0]), av4Var);
            wu4Var8.d.setTag(sparseArray);
            arrayList.add(wu4Var8);
            list.addAll(0, arrayList);
            return list;
        }
        return (List) invokeLLLL.objValue;
    }

    public static List d(List list, AgreeData agreeData, SparseArray sparseArray, av4 av4Var) {
        InterceptResult invokeLLLL;
        Interceptable interceptable = $ic;
        if (interceptable == null || (invokeLLLL = interceptable.invokeLLLL(65539, null, list, agreeData, sparseArray, av4Var)) == null) {
            if (list == null) {
                list = new ArrayList();
            }
            ArrayList arrayList = new ArrayList();
            if (agreeData.hasAgree) {
                if (agreeData.agreeType == 2) {
                    if (sparseArray == null || sparseArray.get(R.id.obfuscated_res_0x7f0917de) == null || ((Boolean) sparseArray.get(R.id.obfuscated_res_0x7f0917de)).booleanValue()) {
                        wu4 wu4Var = new wu4(-2, wz7.j(R.string.obfuscated_res_0x7f0f0087, new Object[0]), av4Var);
                        wu4Var.d.setTag(sparseArray);
                        arrayList.add(wu4Var);
                    }
                } else if (sparseArray == null || sparseArray.get(R.id.obfuscated_res_0x7f0917de) == null || ((Boolean) sparseArray.get(R.id.obfuscated_res_0x7f0917de)).booleanValue()) {
                    wu4 wu4Var2 = new wu4(-2, wz7.j(R.string.obfuscated_res_0x7f0f0364, new Object[0]), av4Var);
                    wu4Var2.d.setTag(sparseArray);
                    arrayList.add(wu4Var2);
                }
            } else if (sparseArray == null || sparseArray.get(R.id.obfuscated_res_0x7f0917de) == null || ((Boolean) sparseArray.get(R.id.obfuscated_res_0x7f0917de)).booleanValue()) {
                wu4 wu4Var3 = new wu4(-2, wz7.j(R.string.obfuscated_res_0x7f0f0087, new Object[0]), av4Var);
                wu4Var3.d.setTag(sparseArray);
                arrayList.add(wu4Var3);
            }
            wu4 wu4Var4 = new wu4(-3, wz7.j(R.string.obfuscated_res_0x7f0f1010, new Object[0]), av4Var);
            wu4Var4.d.setTag(sparseArray);
            arrayList.add(0, wu4Var4);
            wu4 wu4Var5 = new wu4(-4, wz7.j(R.string.obfuscated_res_0x7f0f115b, new Object[0]), av4Var);
            wu4Var5.d.setTag(sparseArray);
            arrayList.add(1, wu4Var5);
            list.addAll(0, arrayList);
            return list;
        }
        return (List) invokeLLLL.objValue;
    }

    public static void e(Activity activity, r9 r9Var, pu4.e eVar, pu4.e eVar2) {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeLLLL(InputDeviceCompat.SOURCE_TRACKBALL, null, activity, r9Var, eVar, eVar2) == null) {
            pu4 pu4Var = new pu4(activity);
            pu4Var.setMessageId(R.string.obfuscated_res_0x7f0f04b4);
            pu4Var.setPositiveButton(R.string.dialog_ok, eVar);
            pu4Var.setNegativeButton(R.string.dialog_cancel, eVar2);
            pu4Var.setCancelable(true);
            pu4Var.create(r9Var);
            pu4Var.show();
        }
    }

    public static List f(List list) {
        InterceptResult invokeL;
        Interceptable interceptable = $ic;
        if (interceptable == null || (invokeL = interceptable.invokeL(65541, null, list)) == null) {
            if (list == null) {
                return list;
            }
            Iterator it = list.iterator();
            while (it.hasNext()) {
                wu4 wu4Var = (wu4) it.next();
                wu4Var.l(h(wu4Var));
            }
            return list;
        }
        return (List) invokeL.objValue;
    }

    public static boolean i(PbModel pbModel) {
        InterceptResult invokeL;
        Interceptable interceptable = $ic;
        if (interceptable == null || (invokeL = interceptable.invokeL(65544, null, pbModel)) == null) {
            if (pbModel != null && pbModel.S1() != null && pbModel.S1().l0()) {
                return true;
            }
            return false;
        }
        return invokeL.booleanValue;
    }

    public static boolean j(kw7 kw7Var) {
        InterceptResult invokeL;
        Interceptable interceptable = $ic;
        if (interceptable == null || (invokeL = interceptable.invokeL(65545, null, kw7Var)) == null) {
            if (kw7Var != null && kw7Var.q()) {
                return true;
            }
            return false;
        }
        return invokeL.booleanValue;
    }

    public static SpannableStringBuilder g(PostData postData) {
        InterceptResult invokeL;
        String str;
        Interceptable interceptable = $ic;
        if (interceptable == null || (invokeL = interceptable.invokeL(65542, null, postData)) == null) {
            if (postData == null) {
                return null;
            }
            if (postData.X() != null) {
                str = postData.X().toString();
            } else {
                str = "";
            }
            SpannableString n = n(postData.s().getName_show() + ZeusCrashHandler.NAME_SEPERATOR, SkinManager.getColor(R.color.CAM_X0109));
            SpannableString n2 = n(str, SkinManager.getColor(R.color.CAM_X0107));
            SpannableStringBuilder spannableStringBuilder = new SpannableStringBuilder();
            spannableStringBuilder.append((CharSequence) n);
            spannableStringBuilder.append((CharSequence) n2);
            return spannableStringBuilder;
        }
        return (SpannableStringBuilder) invokeL.objValue;
    }

    public static Drawable h(wu4 wu4Var) {
        InterceptResult invokeL;
        Interceptable interceptable = $ic;
        if (interceptable == null || (invokeL = interceptable.invokeL(65543, null, wu4Var)) == null) {
            switch (wu4Var.f()) {
                case -4:
                    return WebPManager.getPureDrawable(R.drawable.obfuscated_res_0x7f0809a6, SkinManager.getColor(R.color.CAM_X0107), null);
                case -3:
                    return WebPManager.getPureDrawable(R.drawable.obfuscated_res_0x7f080990, SkinManager.getColor(R.color.CAM_X0107), null);
                case -2:
                    if (wz7.j(R.string.obfuscated_res_0x7f0f0363, new Object[0]).equals(wu4Var.g())) {
                        return WebPManager.getPureDrawable(R.drawable.obfuscated_res_0x7f080994, SkinManager.getColor(R.color.CAM_X0107), null);
                    }
                    return WebPManager.getPureDrawable(R.drawable.obfuscated_res_0x7f080995, SkinManager.getColor(R.color.CAM_X0107), null);
                case -1:
                    if (wz7.j(R.string.obfuscated_res_0x7f0f0361, new Object[0]).equals(wu4Var.g())) {
                        return WebPManager.getPureDrawable(R.drawable.obfuscated_res_0x7f08099d, SkinManager.getColor(R.color.CAM_X0107), null);
                    }
                    return WebPManager.getPureDrawable(R.drawable.obfuscated_res_0x7f08099e, SkinManager.getColor(R.color.CAM_X0301), null);
                case 0:
                default:
                    return null;
                case 1:
                    return WebPManager.getPureDrawable(R.drawable.obfuscated_res_0x7f080996, SkinManager.getColor(R.color.CAM_X0107), null);
                case 2:
                    return WebPManager.getPureDrawable(R.drawable.obfuscated_res_0x7f0809a5, SkinManager.getColor(R.color.CAM_X0107), null);
                case 3:
                    return WebPManager.getPureDrawable(R.drawable.obfuscated_res_0x7f080991, SkinManager.getColor(R.color.CAM_X0107), null);
                case 4:
                    if (wz7.j(R.string.obfuscated_res_0x7f0f0ab8, new Object[0]).equals(wu4Var.g())) {
                        return WebPManager.getPureDrawable(R.drawable.obfuscated_res_0x7f08098e, SkinManager.getColor(R.color.CAM_X0107), null);
                    }
                    return WebPManager.getPureDrawable(R.drawable.obfuscated_res_0x7f08098f, SkinManager.getColor(R.color.CAM_X0305), null);
                case 5:
                    if (wz7.j(R.string.obfuscated_res_0x7f0f1029, new Object[0]).equals(wu4Var.g())) {
                        return WebPManager.getPureDrawable(R.drawable.obfuscated_res_0x7f0809a4, SkinManager.getColor(R.color.CAM_X0107), null);
                    }
                    if (!wz7.j(R.string.obfuscated_res_0x7f0f0b5c, new Object[0]).equals(wu4Var.g())) {
                        return null;
                    }
                    return WebPManager.getPureDrawable(R.drawable.obfuscated_res_0x7f0809a2, SkinManager.getColor(R.color.CAM_X0107), null);
                case 6:
                    if (wz7.j(R.string.obfuscated_res_0x7f0f1029, new Object[0]).equals(wu4Var.g())) {
                        return WebPManager.getPureDrawable(R.drawable.obfuscated_res_0x7f0809a4, SkinManager.getColor(R.color.CAM_X0107), null);
                    }
                    if (!wz7.j(R.string.obfuscated_res_0x7f0f04b8, new Object[0]).equals(wu4Var.g())) {
                        return null;
                    }
                    return WebPManager.getPureDrawable(R.drawable.obfuscated_res_0x7f080993, SkinManager.getColor(R.color.CAM_X0107), null);
                case 7:
                    return WebPManager.getPureDrawable(R.drawable.obfuscated_res_0x7f080989, SkinManager.getColor(R.color.CAM_X0107), null);
                case 8:
                    return WebPManager.getPureDrawable(R.drawable.obfuscated_res_0x7f080999, SkinManager.getColor(R.color.CAM_X0107), null);
                case 9:
                    return WebPManager.getPureDrawable(R.drawable.obfuscated_res_0x7f08097c, SkinManager.getColor(R.color.CAM_X0107), null);
                case 10:
                    if (wz7.j(R.string.obfuscated_res_0x7f0f04c3, new Object[0]).equals(wu4Var.g())) {
                        return WebPManager.getPureDrawable(R.drawable.obfuscated_res_0x7f080993, SkinManager.getColor(R.color.CAM_X0107), null);
                    }
                    if (!wz7.j(R.string.obfuscated_res_0x7f0f04b8, new Object[0]).equals(wu4Var.g())) {
                        return null;
                    }
                    return WebPManager.getPureDrawable(R.drawable.obfuscated_res_0x7f080993, SkinManager.getColor(R.color.CAM_X0107), null);
                case 11:
                    return WebPManager.getPureDrawable(R.drawable.obfuscated_res_0x7f08098d, SkinManager.getColor(R.color.CAM_X0107), null);
                case 12:
                    if (wz7.j(R.string.obfuscated_res_0x7f0f0b58, new Object[0]).equals(wu4Var.g())) {
                        return WebPManager.getPureDrawable(R.drawable.obfuscated_res_0x7f0809a0, SkinManager.getColor(R.color.CAM_X0107), null);
                    }
                    if (!wz7.j(R.string.obfuscated_res_0x7f0f14d6, new Object[0]).equals(wu4Var.g())) {
                        return null;
                    }
                    return WebPManager.getPureDrawable(R.drawable.obfuscated_res_0x7f0809a1, SkinManager.getColor(R.color.CAM_X0107), null);
                case 13:
                    return WebPManager.getPureDrawable(R.drawable.obfuscated_res_0x7f08097b, SkinManager.getColor(R.color.CAM_X0107), null);
            }
        }
        return (Drawable) invokeL.objValue;
    }

    public static boolean k(PostData postData) {
        InterceptResult invokeL;
        Interceptable interceptable = $ic;
        if (interceptable == null || (invokeL = interceptable.invokeL(65546, null, postData)) == null) {
            if (postData != null && postData.s() != null && !StringUtils.isNull(postData.s().getUserId()) && postData.s().getUserId().equals(TbadkCoreApplication.getCurrentAccount())) {
                return true;
            }
            return false;
        }
        return invokeL.booleanValue;
    }

    public static List l(List list, boolean z) {
        InterceptResult invokeLZ;
        Interceptable interceptable = $ic;
        if (interceptable == null || (invokeLZ = interceptable.invokeLZ(65547, null, list, z)) == null) {
            if (list != null && !z) {
                Iterator it = list.iterator();
                while (it.hasNext()) {
                    wu4 wu4Var = (wu4) it.next();
                    if (wu4Var.f() == 2 || wu4Var.f() == 1 || wu4Var.f() == 3) {
                        it.remove();
                    }
                }
            }
            return list;
        }
        return (List) invokeLZ.objValue;
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
