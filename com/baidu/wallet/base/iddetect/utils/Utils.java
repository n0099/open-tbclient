package com.baidu.wallet.base.iddetect.utils;

import android.content.Context;
import android.content.pm.ApplicationInfo;
import android.content.pm.PackageManager;
import android.graphics.Matrix;
import android.os.Bundle;
import android.text.TextUtils;
import androidx.core.view.InputDeviceCompat;
import com.baidu.mobads.container.util.AdIconUtil;
import com.baidu.titan.sdk.runtime.FieldHolder;
import com.baidu.titan.sdk.runtime.InitContext;
import com.baidu.titan.sdk.runtime.InterceptResult;
import com.baidu.titan.sdk.runtime.Interceptable;
import com.baidu.titan.sdk.runtime.TitanRuntime;
import java.util.regex.Pattern;
/* loaded from: classes10.dex */
public final class Utils {
    public static /* synthetic */ Interceptable $ic;
    public transient /* synthetic */ FieldHolder $fh;

    public Utils() {
        Interceptable interceptable = $ic;
        if (interceptable != null) {
            InitContext newInitContext = TitanRuntime.newInitContext();
            interceptable.invokeUnInit(65536, newInitContext);
            int i2 = newInitContext.flag;
            if ((i2 & 1) != 0) {
                int i3 = i2 & 2;
                newInitContext.thisArg = this;
                interceptable.invokeInitBody(65536, newInitContext);
            }
        }
    }

    public static int dip2px(Context context, float f2) {
        InterceptResult invokeLF;
        Interceptable interceptable = $ic;
        return (interceptable == null || (invokeLF = interceptable.invokeLF(65537, null, context, f2)) == null) ? (int) ((f2 * context.getResources().getDisplayMetrics().density) + 0.5f) : invokeLF.intValue;
    }

    public static String formatDate(String str) {
        InterceptResult invokeL;
        Interceptable interceptable = $ic;
        if (interceptable == null || (invokeL = interceptable.invokeL(65538, null, str)) == null) {
            if (TextUtils.isEmpty(str) || str.length() != 8) {
                return "";
            }
            StringBuilder sb = new StringBuilder(str);
            sb.insert(4, "-");
            sb.insert(7, "-");
            return sb.toString();
        }
        return (String) invokeL.objValue;
    }

    public static String getMetaValue(Context context, String str) {
        InterceptResult invokeLL;
        Bundle bundle;
        Interceptable interceptable = $ic;
        if (interceptable == null || (invokeLL = interceptable.invokeLL(65539, null, context, str)) == null) {
            if (context != null) {
                if (str != null) {
                    try {
                        ApplicationInfo applicationInfo = context.getPackageManager().getApplicationInfo(context.getPackageName(), 128);
                        bundle = applicationInfo != null ? applicationInfo.metaData : null;
                        if (bundle == null) {
                            return null;
                        }
                    } catch (PackageManager.NameNotFoundException unused) {
                        return null;
                    }
                }
                return bundle.getString(str);
            }
            return null;
        }
        return (String) invokeLL.objValue;
    }

    public static int getScreenHeight(Context context) {
        InterceptResult invokeL;
        Interceptable interceptable = $ic;
        return (interceptable == null || (invokeL = interceptable.invokeL(InputDeviceCompat.SOURCE_TRACKBALL, null, context)) == null) ? context.getResources().getDisplayMetrics().heightPixels : invokeL.intValue;
    }

    public static int getScreenWidth(Context context) {
        InterceptResult invokeL;
        Interceptable interceptable = $ic;
        return (interceptable == null || (invokeL = interceptable.invokeL(AdIconUtil.AD_TEXT_ID, null, context)) == null) ? context.getResources().getDisplayMetrics().widthPixels : invokeL.intValue;
    }

    public static String getVersionCode(Context context) {
        InterceptResult invokeL;
        Interceptable interceptable = $ic;
        if (interceptable == null || (invokeL = interceptable.invokeL(AdIconUtil.BAIDU_LOGO_ID, null, context)) == null) {
            try {
                return String.valueOf(context.getPackageManager().getPackageInfo(context.getPackageName(), 0).versionCode);
            } catch (Exception e2) {
                e2.printStackTrace();
                return null;
            }
        }
        return (String) invokeL.objValue;
    }

    public static String getVersionName(Context context) {
        InterceptResult invokeL;
        Interceptable interceptable = $ic;
        if (interceptable == null || (invokeL = interceptable.invokeL(65543, null, context)) == null) {
            try {
                return String.valueOf(context.getPackageManager().getPackageInfo(context.getPackageName(), 0).versionName);
            } catch (Exception e2) {
                e2.printStackTrace();
                return null;
            }
        }
        return (String) invokeL.objValue;
    }

    public static boolean isCardNo(String str) {
        InterceptResult invokeL;
        Interceptable interceptable = $ic;
        if (interceptable == null || (invokeL = interceptable.invokeL(65544, null, str)) == null) {
            return true;
        }
        return invokeL.booleanValue;
    }

    public static boolean isChinese(String str) {
        InterceptResult invokeL;
        Interceptable interceptable = $ic;
        if (interceptable == null || (invokeL = interceptable.invokeL(65545, null, str)) == null) {
            if (TextUtils.isEmpty(str)) {
                return false;
            }
            return str.matches("^[一-龥]+$");
        }
        return invokeL.booleanValue;
    }

    public static boolean isEmailInvalid(String str) {
        InterceptResult invokeL;
        Interceptable interceptable = $ic;
        if (interceptable == null || (invokeL = interceptable.invokeL(65546, null, str)) == null) {
            if (TextUtils.isEmpty(str)) {
                return false;
            }
            return str.matches("^([a-z0-9A-Z]+[-_|\\.]?)+@[a-z0-9A-Z]+(\\.[a-z0-9A-Z]+)+$");
        }
        return invokeL.booleanValue;
    }

    public static boolean isNameInvalid(String str) {
        InterceptResult invokeL;
        Interceptable interceptable = $ic;
        if (interceptable == null || (invokeL = interceptable.invokeL(65547, null, str)) == null) {
            if (TextUtils.isEmpty(str)) {
                return false;
            }
            return str.matches("^[一-龥a-zA-Z]+$");
        }
        return invokeL.booleanValue;
    }

    public static boolean isSpecialCharInName(String str) {
        InterceptResult invokeL;
        Interceptable interceptable = $ic;
        if (interceptable == null || (invokeL = interceptable.invokeL(65548, null, str)) == null) {
            if (TextUtils.isEmpty(str)) {
                return false;
            }
            return Pattern.compile("[`~!@#$%^&*()+=|{}':;',\\[\\].<>/?~！@#￥%……&*（）——+|{}【】‘；：”“’。，、？]").matcher(str).find();
        }
        return invokeL.booleanValue;
    }

    public static boolean isTelephoneNO(String str) {
        InterceptResult invokeL;
        Interceptable interceptable = $ic;
        return (interceptable == null || (invokeL = interceptable.invokeL(65549, null, str)) == null) ? !TextUtils.isEmpty(str) && str.matches("^[0-9]+$") && str.length() <= 10 : invokeL.booleanValue;
    }

    public static boolean isTuitionCodeInvaild(String str) {
        InterceptResult invokeL;
        Interceptable interceptable = $ic;
        return (interceptable == null || (invokeL = interceptable.invokeL(65550, null, str)) == null) ? !TextUtils.isEmpty(str) && str.matches("^[A-Za-z][0-9A-Za-z]{5}$") : invokeL.booleanValue;
    }

    public static void prepareMatrix(Matrix matrix, boolean z, int i2, int i3, int i4) {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeCommon(65551, null, new Object[]{matrix, Boolean.valueOf(z), Integer.valueOf(i2), Integer.valueOf(i3), Integer.valueOf(i4)}) == null) {
            matrix.setScale(z ? -1.0f : 1.0f, 1.0f);
            matrix.postRotate(i2);
            float f2 = i3;
            float f3 = i4;
            matrix.postScale(f2 / 2000.0f, f3 / 2000.0f);
            matrix.postTranslate(f2 / 2.0f, f3 / 2.0f);
        }
    }

    public static int px2dip(Context context, float f2) {
        InterceptResult invokeLF;
        Interceptable interceptable = $ic;
        return (interceptable == null || (invokeLF = interceptable.invokeLF(65552, null, context, f2)) == null) ? (int) ((f2 / context.getResources().getDisplayMetrics().density) + 0.5f) : invokeLF.intValue;
    }

    public static int rank(int i2, int[] iArr) {
        InterceptResult invokeIL;
        Interceptable interceptable = $ic;
        if (interceptable == null || (invokeIL = interceptable.invokeIL(65553, null, i2, iArr)) == null) {
            if (iArr != null && iArr.length != 0) {
                int i3 = 0;
                if (iArr.length == 1) {
                    return iArr[0] != i2 ? -1 : 0;
                }
                int length = iArr.length - 1;
                while (i3 <= length) {
                    int i4 = ((length - i3) / 2) + i3;
                    if (i2 < iArr[i4]) {
                        length = i4 - 1;
                    } else if (i2 <= iArr[i4]) {
                        return i4;
                    } else {
                        i3 = i4 + 1;
                    }
                }
            }
            return -1;
        }
        return invokeIL.intValue;
    }
}
