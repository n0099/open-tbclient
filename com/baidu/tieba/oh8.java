package com.baidu.tieba;

import android.text.SpannableString;
import android.text.SpannableStringBuilder;
import android.text.TextUtils;
import android.text.style.ForegroundColorSpan;
import androidx.core.view.InputDeviceCompat;
import com.baidu.tbadk.core.TbadkCoreApplication;
import com.baidu.tbadk.core.dialog.BdToast;
import com.baidu.titan.sdk.runtime.FieldHolder;
import com.baidu.titan.sdk.runtime.InterceptResult;
import com.baidu.titan.sdk.runtime.Interceptable;
/* loaded from: classes5.dex */
public class oh8 {
    public static /* synthetic */ Interceptable $ic;
    public transient /* synthetic */ FieldHolder $fh;

    public static SpannableString a(String str, int i) {
        InterceptResult invokeLI;
        Interceptable interceptable = $ic;
        if (interceptable == null || (invokeLI = interceptable.invokeLI(65536, null, str, i)) == null) {
            SpannableString spannableString = new SpannableString(str);
            if (i <= 0) {
                i = R.color.CAM_X0101;
            }
            spannableString.setSpan(new ForegroundColorSpan(TbadkCoreApplication.getInst().getResources().getColor(i)), 0, str.length(), 17);
            return spannableString;
        }
        return (SpannableString) invokeLI.objValue;
    }

    public static void b(String str, int i) {
        Interceptable interceptable = $ic;
        if ((interceptable != null && interceptable.invokeLI(65537, null, str, i) != null) || TextUtils.isEmpty(str)) {
            return;
        }
        SpannableStringBuilder spannableStringBuilder = new SpannableStringBuilder();
        spannableStringBuilder.append((CharSequence) a(str, i));
        BdToast.b(TbadkCoreApplication.getInst().getContext(), spannableStringBuilder).k();
    }

    public static void c(String str, int i, String str2, int i2) {
        Interceptable interceptable = $ic;
        if ((interceptable != null && interceptable.invokeCommon(65538, null, new Object[]{str, Integer.valueOf(i), str2, Integer.valueOf(i2)}) != null) || TextUtils.isEmpty(str)) {
            return;
        }
        SpannableStringBuilder spannableStringBuilder = new SpannableStringBuilder();
        spannableStringBuilder.append((CharSequence) a(str, i));
        if (!TextUtils.isEmpty(str2)) {
            spannableStringBuilder.append((CharSequence) a(str2, i2));
        }
        BdToast.b(TbadkCoreApplication.getInst().getContext(), spannableStringBuilder).k();
    }

    public static void d(String str, int i, String str2, int i2, String str3, int i3, String str4, int i4) {
        Interceptable interceptable = $ic;
        if ((interceptable != null && interceptable.invokeCommon(65539, null, new Object[]{str, Integer.valueOf(i), str2, Integer.valueOf(i2), str3, Integer.valueOf(i3), str4, Integer.valueOf(i4)}) != null) || TextUtils.isEmpty(str)) {
            return;
        }
        SpannableStringBuilder spannableStringBuilder = new SpannableStringBuilder();
        spannableStringBuilder.append((CharSequence) a(str, i));
        if (!TextUtils.isEmpty(str2)) {
            spannableStringBuilder.append((CharSequence) a(str2, i2));
        }
        if (!TextUtils.isEmpty(str3)) {
            spannableStringBuilder.append((CharSequence) "\n");
            spannableStringBuilder.append((CharSequence) a(str3, i3));
            if (!TextUtils.isEmpty(str4)) {
                spannableStringBuilder.append((CharSequence) a(str4, i4));
            }
        }
        BdToast.b(TbadkCoreApplication.getInst().getContext(), spannableStringBuilder).k();
    }

    public static void e(String str) {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeL(InputDeviceCompat.SOURCE_TRACKBALL, null, str) == null) {
            b(str, R.color.CAM_X0101);
        }
    }

    public static void f(String str, String str2) {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeLL(65541, null, str, str2) == null) {
            c(str, R.color.CAM_X0101, str2, R.color.CAM_X0305);
        }
    }

    public static void g(String str, String str2, String str3, String str4) {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeLLLL(65542, null, str, str2, str3, str4) == null) {
            d(str, R.color.CAM_X0101, str2, R.color.CAM_X0305, str3, R.color.CAM_X0109, str4, R.color.CAM_X0305);
        }
    }
}
