package com.baidu.webkit.sdk;

import android.content.Context;
import android.os.Looper;
import com.baidu.android.imsdk.internal.Constants;
import com.baidu.mobads.container.util.AdIconUtil;
import com.baidu.titan.sdk.runtime.ClassClinitInterceptable;
import com.baidu.titan.sdk.runtime.ClassClinitInterceptorStorage;
import com.baidu.titan.sdk.runtime.FieldHolder;
import com.baidu.titan.sdk.runtime.InitContext;
import com.baidu.titan.sdk.runtime.InterceptResult;
import com.baidu.titan.sdk.runtime.Interceptable;
import com.baidu.titan.sdk.runtime.TitanRuntime;
@Deprecated
/* loaded from: classes6.dex */
public class CookieSyncManager implements Runnable {
    public static /* synthetic */ Interceptable $ic = null;
    public static String TAG = "CookieSyncManager";
    public static final CookieSyncManager mInstance;
    public static boolean sGetInstanceAllowed;
    public static final Object sLockObject;
    public transient /* synthetic */ FieldHolder $fh;

    static {
        InterceptResult invokeClinit;
        ClassClinitInterceptable classClinitInterceptable = ClassClinitInterceptorStorage.$ic;
        if (classClinitInterceptable != null && (invokeClinit = classClinitInterceptable.invokeClinit(667517921, "Lcom/baidu/webkit/sdk/CookieSyncManager;")) != null) {
            Interceptable interceptable = invokeClinit.interceptor;
            if (interceptable != null) {
                $ic = interceptable;
            }
            if ((invokeClinit.flags & 1) != 0) {
                classClinitInterceptable.invokePostClinit(667517921, "Lcom/baidu/webkit/sdk/CookieSyncManager;");
                return;
            }
        }
        mInstance = new CookieSyncManager();
        sLockObject = new Object();
    }

    public CookieSyncManager() {
        Interceptable interceptable = $ic;
        if (interceptable != null) {
            InitContext newInitContext = TitanRuntime.newInitContext();
            interceptable.invokeUnInit(65537, newInitContext);
            int i2 = newInitContext.flag;
            if ((i2 & 1) != 0) {
                int i3 = i2 & 2;
                newInitContext.thisArg = this;
                interceptable.invokeInitBody(65537, newInitContext);
            }
        }
    }

    public static void checkInstanceIsAllowed() {
        Interceptable interceptable = $ic;
        if ((interceptable == null || interceptable.invokeV(65538, null) == null) && !sGetInstanceAllowed) {
            throw new IllegalStateException("CookieSyncManager::createInstance() needs to be called before CookieSyncManager::getInstance()");
        }
    }

    public static CookieSyncManager createInstance(Context context) {
        InterceptResult invokeL;
        Interceptable interceptable = $ic;
        if (interceptable == null || (invokeL = interceptable.invokeL(65539, null, context)) == null) {
            if (context != null) {
                if (Looper.getMainLooper() != Looper.myLooper()) {
                    Log.e(TAG, "CookieSyncManager.createInstance() must be called on the main thread.");
                }
                synchronized (sLockObject) {
                    setGetInstanceIsAllowed();
                }
                return getInstance();
            }
            throw new IllegalArgumentException("Invalid context argument");
        }
        return (CookieSyncManager) invokeL.objValue;
    }

    public static CookieSyncManager getInstance() {
        InterceptResult invokeV;
        Interceptable interceptable = $ic;
        if (interceptable == null || (invokeV = interceptable.invokeV(65540, null)) == null) {
            synchronized (sLockObject) {
                checkInstanceIsAllowed();
            }
            return mInstance;
        }
        return (CookieSyncManager) invokeV.objValue;
    }

    public static void setGetInstanceIsAllowed() {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeV(AdIconUtil.AD_TEXT_ID, null) == null) {
            sGetInstanceAllowed = true;
        }
    }

    @Deprecated
    public void resetSync() {
        Interceptable interceptable = $ic;
        if ((interceptable == null || interceptable.invokeV(1048576, this) == null) && WebViewFactory.hasProvider()) {
            WebViewFactory.getProvider().getCookieSyncManager().resetSync();
        }
    }

    @Override // java.lang.Runnable
    public void run() {
        Interceptable interceptable = $ic;
        if ((interceptable == null || interceptable.invokeV(Constants.METHOD_GET_CONTACTER_INFO_FOR_SESSION, this) == null) && WebViewFactory.hasProvider()) {
            WebViewFactory.getProvider().getCookieSyncManager().run();
        }
    }

    @Deprecated
    public void startSync() {
        Interceptable interceptable = $ic;
        if ((interceptable == null || interceptable.invokeV(Constants.METHOD_SEND_USER_MSG, this) == null) && WebViewFactory.hasProvider()) {
            WebViewFactory.getProvider().getCookieSyncManager().startSync();
        }
    }

    @Deprecated
    public void stopSync() {
        Interceptable interceptable = $ic;
        if ((interceptable == null || interceptable.invokeV(1048579, this) == null) && WebViewFactory.hasProvider()) {
            WebViewFactory.getProvider().getCookieSyncManager().stopSync();
        }
    }

    @Deprecated
    public void sync() {
        Interceptable interceptable = $ic;
        if ((interceptable == null || interceptable.invokeV(1048580, this) == null) && WebViewFactory.hasProvider()) {
            WebViewFactory.getProvider().getCookieSyncManager().sync();
        }
    }
}
