package com.baidu.webkit.internal.daemon;

import androidx.core.view.InputDeviceCompat;
import com.baidu.titan.sdk.runtime.FieldHolder;
import com.baidu.titan.sdk.runtime.InitContext;
import com.baidu.titan.sdk.runtime.InterceptResult;
import com.baidu.titan.sdk.runtime.Interceptable;
import com.baidu.titan.sdk.runtime.TitanRuntime;
import com.baidu.webkit.internal.INoProGuard;
/* loaded from: classes4.dex */
public final class Statistics implements INoProGuard {
    public static /* synthetic */ Interceptable $ic;
    public static boolean mIsInited;
    public transient /* synthetic */ FieldHolder $fh;

    public Statistics() {
        Interceptable interceptable = $ic;
        if (interceptable != null) {
            InitContext newInitContext = TitanRuntime.newInitContext();
            interceptable.invokeUnInit(65536, newInitContext);
            int i = newInitContext.flag;
            if ((i & 1) != 0) {
                int i2 = i & 2;
                newInitContext.thisArg = this;
                interceptable.invokeInitBody(65536, newInitContext);
            }
        }
    }

    public static synchronized void close() {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeV(65537, null) == null) {
            synchronized (Statistics.class) {
                try {
                    if (mIsInited) {
                        nativeClose();
                        mIsInited = false;
                    }
                } catch (Throwable th) {
                    th.printStackTrace();
                }
            }
        }
    }

    public static String getPhoenixString() {
        InterceptResult invokeV;
        Interceptable interceptable = $ic;
        if (interceptable == null || (invokeV = interceptable.invokeV(65538, null)) == null) {
            try {
                return mIsInited ? nativeGetPhoenixString() : "";
            } catch (Throwable th) {
                th.printStackTrace();
                return "";
            }
        }
        return (String) invokeV.objValue;
    }

    public static String getString() {
        InterceptResult invokeV;
        Interceptable interceptable = $ic;
        if (interceptable == null || (invokeV = interceptable.invokeV(65539, null)) == null) {
            try {
                return mIsInited ? nativeGetString() : "";
            } catch (Throwable th) {
                th.printStackTrace();
                return "";
            }
        }
        return (String) invokeV.objValue;
    }

    public static synchronized boolean init(String str, String str2, String str3) {
        InterceptResult invokeLLL;
        boolean z;
        Interceptable interceptable = $ic;
        if (interceptable == null || (invokeLLL = interceptable.invokeLLL(InputDeviceCompat.SOURCE_TRACKBALL, null, str, str2, str3)) == null) {
            synchronized (Statistics.class) {
                try {
                    if (!mIsInited) {
                        mIsInited = nativeInit(str, str2, str3);
                    }
                    z = mIsInited;
                }
            }
            return z;
        }
        return invokeLLL.booleanValue;
    }

    public static native void nativeClose();

    public static native String nativeGetPhoenixString();

    public static native String nativeGetString();

    public static native boolean nativeInit(String str, String str2, String str3);

    public static native void nativeRecord(int i, String str);

    public static native void nativeUpdatePhoenixConfig(String str);

    public static native void nativeUploadSuccessfully();

    public static void record(int i, String str) {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeIL(65548, null, i, str) == null) {
            if (str == null) {
                str = "";
            }
            try {
                if (mIsInited) {
                    nativeRecord(i, str);
                }
            } catch (Throwable th) {
                th.printStackTrace();
            }
        }
    }

    public static void updatePhoenixConfig(String str) {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeL(65549, null, str) == null) {
            try {
                if (mIsInited) {
                    nativeUpdatePhoenixConfig(str);
                }
            } catch (Throwable th) {
                th.printStackTrace();
            }
        }
    }

    public static void uploadSuccessfully() {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeV(65550, null) == null) {
            try {
                if (mIsInited) {
                    nativeUploadSuccessfully();
                }
            } catch (Throwable th) {
                th.printStackTrace();
            }
        }
    }
}
