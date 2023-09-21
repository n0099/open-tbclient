package com.baidu.tieba;

import android.content.ContentResolver;
import android.content.ContentValues;
import android.content.Context;
import android.database.Cursor;
import android.net.Uri;
import android.text.TextUtils;
import androidx.core.view.InputDeviceCompat;
import com.baidu.searchbox.downloads.DownloadConstants;
import com.baidu.titan.sdk.runtime.FieldHolder;
import com.baidu.titan.sdk.runtime.InterceptResult;
import com.baidu.titan.sdk.runtime.Interceptable;
/* loaded from: classes8.dex */
public class tnb {
    public static /* synthetic */ Interceptable $ic;
    public transient /* synthetic */ FieldHolder $fh;

    public static synchronized int a(Context context, String str, ContentValues contentValues, String str2, String[] strArr) {
        InterceptResult invokeLLLLL;
        Interceptable interceptable = $ic;
        if (interceptable == null || (invokeLLLLL = interceptable.invokeLLLLL(65536, null, context, str, contentValues, str2, strArr)) == null) {
            synchronized (tnb.class) {
                if (contentValues != null) {
                    if (!TextUtils.isEmpty(str)) {
                        try {
                            ContentResolver e = e(context);
                            if (e != null) {
                                return e.update(Uri.parse(c(context.getPackageName()) + str), contentValues, str2, strArr);
                            }
                        } catch (Throwable unused) {
                        }
                        return 0;
                    }
                }
                return 0;
            }
        }
        return invokeLLLLL.intValue;
    }

    public static synchronized Cursor b(Context context, String str, String[] strArr, String str2, String[] strArr2, String str3, String str4, String str5) {
        InterceptResult invokeCommon;
        Interceptable interceptable = $ic;
        if (interceptable == null || (invokeCommon = interceptable.invokeCommon(65537, null, new Object[]{context, str, strArr, str2, strArr2, str3, str4, str5})) == null) {
            synchronized (tnb.class) {
                if (TextUtils.isEmpty(str)) {
                    return null;
                }
                try {
                    ContentResolver e = e(context);
                    if (e != null) {
                        return e.query(Uri.parse(c(context.getPackageName()) + str), strArr, str2, strArr2, str5);
                    }
                } catch (Throwable unused) {
                }
                return null;
            }
        }
        return (Cursor) invokeCommon.objValue;
    }

    public static String c(String str) {
        InterceptResult invokeL;
        Interceptable interceptable = $ic;
        if (interceptable == null || (invokeL = interceptable.invokeL(65538, null, str)) == null) {
            return DownloadConstants.LOCAL_DATA_URI_PREFIX + str + ".TTMultiProvider/t_db/ttopensdk.db/";
        }
        return (String) invokeL.objValue;
    }

    /* JADX DEBUG: Another duplicated slice has different insns count: {[IF]}, finally: {[IF, INVOKE] complete} */
    public static boolean d(Context context) {
        InterceptResult invokeL;
        Interceptable interceptable = $ic;
        if (interceptable == null || (invokeL = interceptable.invokeL(65539, null, context)) == null) {
            Cursor cursor = null;
            try {
                cursor = b(context, "setting_base_info", new String[]{"_id"}, null, null, null, null, null);
                if (cursor != null) {
                    if (cursor.moveToNext()) {
                        if (cursor != null) {
                            cursor.close();
                            return true;
                        }
                        return true;
                    }
                }
                if (cursor != null) {
                    cursor.close();
                }
                return false;
            } catch (Exception unused) {
                if (cursor != null) {
                    cursor.close();
                }
                return false;
            } catch (Throwable th) {
                if (cursor != null) {
                    cursor.close();
                }
                throw th;
            }
        }
        return invokeL.booleanValue;
    }

    public static ContentResolver e(Context context) {
        InterceptResult invokeL;
        Interceptable interceptable = $ic;
        if (interceptable == null || (invokeL = interceptable.invokeL(InputDeviceCompat.SOURCE_TRACKBALL, null, context)) == null) {
            try {
                return context.getContentResolver();
            } catch (Throwable unused) {
                return null;
            }
        }
        return (ContentResolver) invokeL.objValue;
    }
}
