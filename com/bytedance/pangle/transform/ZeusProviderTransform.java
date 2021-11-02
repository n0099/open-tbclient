package com.bytedance.pangle.transform;

import android.content.ContentResolver;
import android.content.ContentValues;
import android.database.Cursor;
import android.net.Uri;
import android.os.Bundle;
import android.os.CancellationSignal;
import androidx.annotation.Keep;
import androidx.annotation.RequiresApi;
import androidx.core.app.NotificationCompat;
import androidx.core.view.InputDeviceCompat;
import com.baidu.mobads.container.util.AdIconUtil;
import com.baidu.titan.sdk.runtime.FieldHolder;
import com.baidu.titan.sdk.runtime.InitContext;
import com.baidu.titan.sdk.runtime.InterceptResult;
import com.baidu.titan.sdk.runtime.Interceptable;
import com.baidu.titan.sdk.runtime.TitanRuntime;
import com.bytedance.pangle.provider.ContentProviderManager;
import com.bytedance.pangle.util.MethodUtils;
@Keep
/* loaded from: classes11.dex */
public class ZeusProviderTransform {
    public static /* synthetic */ Interceptable $ic;
    public transient /* synthetic */ FieldHolder $fh;

    public ZeusProviderTransform() {
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

    public static Bundle call(Object obj, Uri uri, String str, String str2, Bundle bundle, String str3) {
        InterceptResult invokeCommon;
        Interceptable interceptable = $ic;
        if (interceptable == null || (invokeCommon = interceptable.invokeCommon(65537, null, new Object[]{obj, uri, str, str2, bundle, str3})) == null) {
            if (obj instanceof ContentResolver) {
                return ContentProviderManager.getInstance().call((ContentResolver) obj, uri, str, str2, bundle, str3);
            }
            try {
                return (Bundle) MethodUtils.invokeMethod(obj, NotificationCompat.CATEGORY_CALL, new Object[]{uri, str, str2, bundle}, new Class[]{Uri.class, String.class, String.class, Bundle.class});
            } catch (Exception e2) {
                throw new RuntimeException(e2);
            }
        }
        return (Bundle) invokeCommon.objValue;
    }

    public static int delete(Object obj, Uri uri, String str, String[] strArr, String str2) {
        InterceptResult invokeLLLLL;
        Interceptable interceptable = $ic;
        if (interceptable == null || (invokeLLLLL = interceptable.invokeLLLLL(InputDeviceCompat.SOURCE_TRACKBALL, null, obj, uri, str, strArr, str2)) == null) {
            if (obj instanceof ContentResolver) {
                return ContentProviderManager.getInstance().delete((ContentResolver) obj, uri, str, strArr, str2);
            }
            try {
                return ((Integer) MethodUtils.invokeMethod(obj, "delete", new Object[]{uri, str, strArr}, new Class[]{Uri.class, String.class, String[].class})).intValue();
            } catch (Exception e2) {
                throw new RuntimeException(e2);
            }
        }
        return invokeLLLLL.intValue;
    }

    public static String getType(Object obj, Uri uri, String str) {
        InterceptResult invokeLLL;
        Interceptable interceptable = $ic;
        if (interceptable == null || (invokeLLL = interceptable.invokeLLL(AdIconUtil.AD_TEXT_ID, null, obj, uri, str)) == null) {
            if (obj instanceof ContentResolver) {
                return ContentProviderManager.getInstance().getType((ContentResolver) obj, uri, str);
            }
            try {
                return (String) MethodUtils.invokeMethod(obj, "getType", new Object[]{uri}, new Class[]{Uri.class});
            } catch (Exception e2) {
                throw new RuntimeException(e2);
            }
        }
        return (String) invokeLLL.objValue;
    }

    public static Uri insert(Object obj, Uri uri, ContentValues contentValues, String str) {
        InterceptResult invokeLLLL;
        Interceptable interceptable = $ic;
        if (interceptable == null || (invokeLLLL = interceptable.invokeLLLL(65543, null, obj, uri, contentValues, str)) == null) {
            if (obj instanceof ContentResolver) {
                return ContentProviderManager.getInstance().insert((ContentResolver) obj, uri, contentValues, str);
            }
            try {
                return (Uri) MethodUtils.invokeMethod(obj, "insert", new Object[]{uri, contentValues}, new Class[]{Uri.class, ContentValues.class});
            } catch (Exception e2) {
                throw new RuntimeException(e2);
            }
        }
        return (Uri) invokeLLLL.objValue;
    }

    public static Cursor query(Object obj, Uri uri, String[] strArr, String str, String[] strArr2, String str2, CancellationSignal cancellationSignal, String str3) {
        InterceptResult invokeCommon;
        Interceptable interceptable = $ic;
        if (interceptable == null || (invokeCommon = interceptable.invokeCommon(65545, null, new Object[]{obj, uri, strArr, str, strArr2, str2, cancellationSignal, str3})) == null) {
            if (obj instanceof ContentResolver) {
                return ContentProviderManager.getInstance().query((ContentResolver) obj, uri, strArr, str, strArr2, str2, cancellationSignal, str3);
            }
            try {
                return (Cursor) MethodUtils.invokeMethod(obj, "query", new Object[]{uri, strArr, str, strArr2, str2, cancellationSignal}, new Class[]{Uri.class, String[].class, String.class, String[].class, String.class, CancellationSignal.class});
            } catch (Exception e2) {
                throw new RuntimeException(e2);
            }
        }
        return (Cursor) invokeCommon.objValue;
    }

    public static int update(Object obj, Uri uri, ContentValues contentValues, String str, String[] strArr, String str2) {
        InterceptResult invokeCommon;
        Interceptable interceptable = $ic;
        if (interceptable == null || (invokeCommon = interceptable.invokeCommon(65548, null, new Object[]{obj, uri, contentValues, str, strArr, str2})) == null) {
            if (obj instanceof ContentResolver) {
                return ContentProviderManager.getInstance().update((ContentResolver) obj, uri, contentValues, str, strArr, str2);
            }
            try {
                return ((Integer) MethodUtils.invokeMethod(obj, "update", new Object[]{uri, contentValues, str, strArr}, new Class[]{Uri.class, ContentValues.class, String.class, String[].class})).intValue();
            } catch (Exception e2) {
                throw new RuntimeException(e2);
            }
        }
        return invokeCommon.intValue;
    }

    public static Bundle call(Object obj, String str, String str2, String str3, Bundle bundle, String str4) {
        InterceptResult invokeCommon;
        Interceptable interceptable = $ic;
        if (interceptable == null || (invokeCommon = interceptable.invokeCommon(65538, null, new Object[]{obj, str, str2, str3, bundle, str4})) == null) {
            if (obj instanceof ContentResolver) {
                return ContentProviderManager.getInstance().call((ContentResolver) obj, str, str2, str3, bundle, str4);
            }
            try {
                return (Bundle) MethodUtils.invokeMethod(obj, NotificationCompat.CATEGORY_CALL, new Object[]{str, str2, str3, bundle}, new Class[]{String.class, String.class, String.class, Bundle.class});
            } catch (Exception e2) {
                throw new RuntimeException(e2);
            }
        }
        return (Bundle) invokeCommon.objValue;
    }

    public static int delete(Object obj, Uri uri, Bundle bundle, String str) {
        InterceptResult invokeLLLL;
        Interceptable interceptable = $ic;
        if (interceptable == null || (invokeLLLL = interceptable.invokeLLLL(65539, null, obj, uri, bundle, str)) == null) {
            if (obj instanceof ContentResolver) {
                return ContentProviderManager.getInstance().delete((ContentResolver) obj, uri, bundle, str);
            }
            try {
                return ((Integer) MethodUtils.invokeMethod(obj, "delete", new Object[]{uri, bundle}, new Class[]{Uri.class, Bundle.class})).intValue();
            } catch (Exception e2) {
                throw new RuntimeException(e2);
            }
        }
        return invokeLLLL.intValue;
    }

    public static Uri insert(Object obj, Uri uri, ContentValues contentValues, Bundle bundle, String str) {
        InterceptResult invokeLLLLL;
        Interceptable interceptable = $ic;
        if (interceptable == null || (invokeLLLLL = interceptable.invokeLLLLL(AdIconUtil.BAIDU_LOGO_ID, null, obj, uri, contentValues, bundle, str)) == null) {
            if (obj instanceof ContentResolver) {
                return ContentProviderManager.getInstance().insert((ContentResolver) obj, uri, contentValues, bundle, str);
            }
            try {
                return (Uri) MethodUtils.invokeMethod(obj, "insert", new Object[]{uri, contentValues, bundle}, new Class[]{Uri.class, ContentValues.class, Bundle.class});
            } catch (Exception e2) {
                throw new RuntimeException(e2);
            }
        }
        return (Uri) invokeLLLLL.objValue;
    }

    public static Cursor query(Object obj, Uri uri, String[] strArr, String str, String[] strArr2, String str2, String str3) {
        InterceptResult invokeCommon;
        Interceptable interceptable = $ic;
        if (interceptable == null || (invokeCommon = interceptable.invokeCommon(65546, null, new Object[]{obj, uri, strArr, str, strArr2, str2, str3})) == null) {
            if (obj instanceof ContentResolver) {
                return ContentProviderManager.getInstance().query((ContentResolver) obj, uri, strArr, str, strArr2, str2, str3);
            }
            try {
                return (Cursor) MethodUtils.invokeMethod(obj, "query", new Object[]{uri, strArr, str, strArr2, str2}, new Class[]{Uri.class, String[].class, String.class, String[].class, String.class});
            } catch (Exception e2) {
                throw new RuntimeException(e2);
            }
        }
        return (Cursor) invokeCommon.objValue;
    }

    public static int update(Object obj, Uri uri, ContentValues contentValues, Bundle bundle, String str) {
        InterceptResult invokeLLLLL;
        Interceptable interceptable = $ic;
        if (interceptable == null || (invokeLLLLL = interceptable.invokeLLLLL(65547, null, obj, uri, contentValues, bundle, str)) == null) {
            if (obj instanceof ContentResolver) {
                return ContentProviderManager.getInstance().update((ContentResolver) obj, uri, contentValues, bundle, str);
            }
            try {
                return ((Integer) MethodUtils.invokeMethod(obj, "update", new Object[]{uri, contentValues, bundle}, new Class[]{Uri.class, ContentValues.class, Bundle.class})).intValue();
            } catch (Exception e2) {
                throw new RuntimeException(e2);
            }
        }
        return invokeLLLLL.intValue;
    }

    @RequiresApi(api = 26)
    public static Cursor query(Object obj, Uri uri, String[] strArr, Bundle bundle, CancellationSignal cancellationSignal, String str) {
        InterceptResult invokeCommon;
        Interceptable interceptable = $ic;
        if (interceptable == null || (invokeCommon = interceptable.invokeCommon(65544, null, new Object[]{obj, uri, strArr, bundle, cancellationSignal, str})) == null) {
            if (obj instanceof ContentResolver) {
                return ContentProviderManager.getInstance().query((ContentResolver) obj, uri, strArr, bundle, cancellationSignal, str);
            }
            try {
                return (Cursor) MethodUtils.invokeMethod(obj, "query", new Object[]{uri, strArr, bundle, cancellationSignal}, new Class[]{Uri.class, String[].class, Bundle.class, CancellationSignal.class});
            } catch (Exception e2) {
                throw new RuntimeException(e2);
            }
        }
        return (Cursor) invokeCommon.objValue;
    }
}
