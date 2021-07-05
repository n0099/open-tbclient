package com.baidu.webkit.sdk;

import android.content.Context;
import android.os.Looper;
import android.os.Process;
import androidx.core.view.InputDeviceCompat;
import com.baidu.android.imsdk.internal.Constants;
import com.baidu.mobads.container.util.AdIconUtil;
import com.baidu.titan.sdk.runtime.ClassClinitInterceptable;
import com.baidu.titan.sdk.runtime.ClassClinitInterceptorStorage;
import com.baidu.titan.sdk.runtime.FieldHolder;
import com.baidu.titan.sdk.runtime.InitContext;
import com.baidu.titan.sdk.runtime.InterceptResult;
import com.baidu.titan.sdk.runtime.Interceptable;
import com.baidu.titan.sdk.runtime.TitanRuntime;
/* loaded from: classes6.dex */
public final class ZeusSDK {
    public static final /* synthetic */ boolean $assertionsDisabled = false;
    public static /* synthetic */ Interceptable $ic = null;
    public static final String TAG = "ZeusSDK";
    public static Client mClient;
    public static Configuration mConfig;
    public static volatile boolean mHasInited;
    public static long mTimeInit;
    public transient /* synthetic */ FieldHolder $fh;

    /* loaded from: classes6.dex */
    public static class Client {
        public static /* synthetic */ Interceptable $ic;
        public transient /* synthetic */ FieldHolder $fh;

        public Client() {
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

        public void onInitFinished(boolean z) {
            Interceptable interceptable = $ic;
            if (interceptable == null || interceptable.invokeZ(1048576, this, z) == null) {
            }
        }

        public void onInstallFinished(boolean z, int i2) {
            Interceptable interceptable = $ic;
            if (interceptable == null || interceptable.invokeCommon(Constants.METHOD_GET_CONTACTER_INFO_FOR_SESSION, this, new Object[]{Boolean.valueOf(z), Integer.valueOf(i2)}) == null) {
            }
        }

        public String requestZeusEngine(String str) {
            InterceptResult invokeL;
            Interceptable interceptable = $ic;
            if (interceptable == null || (invokeL = interceptable.invokeL(Constants.METHOD_SEND_USER_MSG, this, str)) == null) {
                return null;
            }
            return (String) invokeL.objValue;
        }
    }

    /* loaded from: classes6.dex */
    public static final class Configuration {
        public static /* synthetic */ Interceptable $ic;
        public transient /* synthetic */ FieldHolder $fh;
        public String mAPPIDString;
        public String mCUIDString;
        public volatile boolean mEnableBrandPromotion;
        public volatile boolean mEnablePullToRefresh;
        public boolean mForceUsingSystemWebView;
        public boolean mThreadingInitialization;

        public Configuration() {
            Interceptable interceptable = $ic;
            if (interceptable != null) {
                InitContext newInitContext = TitanRuntime.newInitContext();
                interceptable.invokeUnInit(65536, newInitContext);
                int i2 = newInitContext.flag;
                if ((i2 & 1) != 0) {
                    int i3 = i2 & 2;
                    newInitContext.thisArg = this;
                    interceptable.invokeInitBody(65536, newInitContext);
                    return;
                }
            }
            this.mEnableBrandPromotion = true;
        }

        public final boolean forceUsingSystemWebView() {
            InterceptResult invokeV;
            Interceptable interceptable = $ic;
            return (interceptable == null || (invokeV = interceptable.invokeV(1048576, this)) == null) ? this.mForceUsingSystemWebView : invokeV.booleanValue;
        }

        public final String getAppID() {
            InterceptResult invokeV;
            Interceptable interceptable = $ic;
            return (interceptable == null || (invokeV = interceptable.invokeV(Constants.METHOD_GET_CONTACTER_INFO_FOR_SESSION, this)) == null) ? this.mAPPIDString : (String) invokeV.objValue;
        }

        public final String getCUID() {
            InterceptResult invokeV;
            Interceptable interceptable = $ic;
            return (interceptable == null || (invokeV = interceptable.invokeV(Constants.METHOD_SEND_USER_MSG, this)) == null) ? this.mCUIDString : (String) invokeV.objValue;
        }

        public final boolean getEnableBrandPromotion() {
            InterceptResult invokeV;
            Interceptable interceptable = $ic;
            return (interceptable == null || (invokeV = interceptable.invokeV(1048579, this)) == null) ? this.mEnableBrandPromotion : invokeV.booleanValue;
        }

        public final boolean getEnablePullToRefresh() {
            InterceptResult invokeV;
            Interceptable interceptable = $ic;
            return (interceptable == null || (invokeV = interceptable.invokeV(1048580, this)) == null) ? this.mEnablePullToRefresh : invokeV.booleanValue;
        }

        public final Configuration setAppID(String str) {
            InterceptResult invokeL;
            Interceptable interceptable = $ic;
            if (interceptable == null || (invokeL = interceptable.invokeL(1048581, this, str)) == null) {
                this.mAPPIDString = str;
                return this;
            }
            return (Configuration) invokeL.objValue;
        }

        public final Configuration setCUID(String str) {
            InterceptResult invokeL;
            Interceptable interceptable = $ic;
            if (interceptable == null || (invokeL = interceptable.invokeL(1048582, this, str)) == null) {
                this.mCUIDString = str;
                return this;
            }
            return (Configuration) invokeL.objValue;
        }

        public final Configuration setEnableBrandPromotion(boolean z) {
            InterceptResult invokeZ;
            Interceptable interceptable = $ic;
            if (interceptable == null || (invokeZ = interceptable.invokeZ(1048583, this, z)) == null) {
                this.mEnableBrandPromotion = z;
                if (z) {
                    this.mEnablePullToRefresh = false;
                }
                return this;
            }
            return (Configuration) invokeZ.objValue;
        }

        public final Configuration setEnablePullToRefresh(boolean z) {
            InterceptResult invokeZ;
            Interceptable interceptable = $ic;
            if (interceptable == null || (invokeZ = interceptable.invokeZ(InputDeviceCompat.SOURCE_TOUCHPAD, this, z)) == null) {
                this.mEnablePullToRefresh = z;
                if (z) {
                    this.mEnableBrandPromotion = false;
                }
                return this;
            }
            return (Configuration) invokeZ.objValue;
        }

        public final Configuration setForceUsingSystemWebView(boolean z) {
            InterceptResult invokeZ;
            Interceptable interceptable = $ic;
            if (interceptable == null || (invokeZ = interceptable.invokeZ(1048585, this, z)) == null) {
                this.mForceUsingSystemWebView = z;
                return this;
            }
            return (Configuration) invokeZ.objValue;
        }

        public final Configuration setThreadingInitialization(boolean z) {
            InterceptResult invokeZ;
            Interceptable interceptable = $ic;
            if (interceptable == null || (invokeZ = interceptable.invokeZ(1048586, this, z)) == null) {
                this.mThreadingInitialization = z;
                return this;
            }
            return (Configuration) invokeZ.objValue;
        }

        public final boolean threadingInitialization() {
            InterceptResult invokeV;
            Interceptable interceptable = $ic;
            return (interceptable == null || (invokeV = interceptable.invokeV(1048587, this)) == null) ? this.mThreadingInitialization : invokeV.booleanValue;
        }
    }

    static {
        InterceptResult invokeClinit;
        ClassClinitInterceptable classClinitInterceptable = ClassClinitInterceptorStorage.$ic;
        if (classClinitInterceptable != null && (invokeClinit = classClinitInterceptable.invokeClinit(575707230, "Lcom/baidu/webkit/sdk/ZeusSDK;")) != null) {
            Interceptable interceptable = invokeClinit.interceptor;
            if (interceptable != null) {
                $ic = interceptable;
            }
            if ((invokeClinit.flags & 1) != 0) {
                classClinitInterceptable.invokePostClinit(575707230, "Lcom/baidu/webkit/sdk/ZeusSDK;");
                return;
            }
        }
        mClient = new Client();
        mConfig = new Configuration();
    }

    public ZeusSDK() {
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

    public static void crashNow() {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeV(65540, null) == null) {
        }
    }

    public static void destroy() {
        Interceptable interceptable = $ic;
        if ((interceptable == null || interceptable.invokeV(AdIconUtil.AD_TEXT_ID, null) == null) && mHasInited) {
            WebKitFactory.destroy();
            mHasInited = false;
            mClient = null;
            mConfig = null;
        }
    }

    public static Context getAppContext() {
        InterceptResult invokeV;
        Interceptable interceptable = $ic;
        if (interceptable == null || (invokeV = interceptable.invokeV(AdIconUtil.BAIDU_LOGO_ID, null)) == null) {
            if (mHasInited) {
                return WebViewFactory.getContext();
            }
            return null;
        }
        return (Context) invokeV.objValue;
    }

    public static Client getClient() {
        InterceptResult invokeV;
        Interceptable interceptable = $ic;
        return (interceptable == null || (invokeV = interceptable.invokeV(65543, null)) == null) ? mClient : (Client) invokeV.objValue;
    }

    public static Configuration getConfig() {
        InterceptResult invokeV;
        Interceptable interceptable = $ic;
        return (interceptable == null || (invokeV = interceptable.invokeV(65544, null)) == null) ? mConfig : (Configuration) invokeV.objValue;
    }

    public static String getSDKVersionName() {
        InterceptResult invokeV;
        Interceptable interceptable = $ic;
        return (interceptable == null || (invokeV = interceptable.invokeV(65545, null)) == null) ? WebKitFactory.getSdkVersionCode() : (String) invokeV.objValue;
    }

    public static String getZeusVersionName() {
        InterceptResult invokeV;
        Interceptable interceptable = $ic;
        return (interceptable == null || (invokeV = interceptable.invokeV(65546, null)) == null) ? mHasInited ? WebKitFactory.getZeusVersionName() : "0.0.0.0" : (String) invokeV.objValue;
    }

    public static void initSDKEnvironment(Context context, Client client, Configuration configuration) {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeLLL(65547, null, context, client, configuration) == null) {
            Context applicationContext = context.getApplicationContext();
            if (mHasInited) {
                return;
            }
            mHasInited = true;
            if (client != null) {
                mClient = client;
            }
            if (configuration != null) {
                mConfig = configuration;
            }
            if ((Looper.getMainLooper() == Looper.myLooper()) && mConfig.threadingInitialization()) {
                new Thread(new Runnable(applicationContext) { // from class: com.baidu.webkit.sdk.ZeusSDK.1
                    public static /* synthetic */ Interceptable $ic;
                    public transient /* synthetic */ FieldHolder $fh;
                    public final /* synthetic */ Context val$appContext;

                    {
                        Interceptable interceptable2 = $ic;
                        if (interceptable2 != null) {
                            InitContext newInitContext = TitanRuntime.newInitContext();
                            newInitContext.initArgs = r2;
                            Object[] objArr = {applicationContext};
                            interceptable2.invokeUnInit(65536, newInitContext);
                            int i2 = newInitContext.flag;
                            if ((i2 & 1) != 0) {
                                int i3 = i2 & 2;
                                newInitContext.thisArg = this;
                                interceptable2.invokeInitBody(65536, newInitContext);
                                return;
                            }
                        }
                        this.val$appContext = applicationContext;
                    }

                    @Override // java.lang.Runnable
                    public void run() {
                        Interceptable interceptable2 = $ic;
                        if (interceptable2 == null || interceptable2.invokeV(1048576, this) == null) {
                            Process.setThreadPriority(0);
                            long currentTimeMillis = System.currentTimeMillis();
                            long unused = ZeusSDK.mTimeInit = currentTimeMillis;
                            ZeusSDK.initZeusEngine(this.val$appContext);
                            Log.e(ZeusSDK.TAG, "initZeusEngine finished, time=" + (System.currentTimeMillis() - currentTimeMillis));
                        }
                    }
                }, "T7@initZeusThread").start();
                return;
            }
            long currentTimeMillis = System.currentTimeMillis();
            mTimeInit = currentTimeMillis;
            initZeusEngine(applicationContext);
            Log.e(TAG, "initZeusEngine finished, time=" + (System.currentTimeMillis() - currentTimeMillis));
        }
    }

    public static boolean initZeusEngine(Context context) {
        InterceptResult invokeL;
        Interceptable interceptable = $ic;
        if (interceptable == null || (invokeL = interceptable.invokeL(65548, null, context)) == null) {
            WebViewFactory.initOnAppStart(context, false, getConfig().forceUsingSystemWebView());
            WebKitFactory.setEngine(!getConfig().forceUsingSystemWebView());
            WebKitFactory.init(context, getConfig().getAppID(), getConfig().getCUID());
            getClient().onInitFinished(WebViewFactory.hasProvider());
            return WebViewFactory.hasProvider();
        }
        return invokeL.booleanValue;
    }

    public static boolean usingZeusEngine() {
        InterceptResult invokeV;
        Interceptable interceptable = $ic;
        return (interceptable == null || (invokeV = interceptable.invokeV(65549, null)) == null) ? mHasInited ? WebViewFactory.isZeusProvider() : mHasInited : invokeV.booleanValue;
    }

    public static boolean usingZeusSDK() {
        InterceptResult invokeV;
        Interceptable interceptable = $ic;
        return (interceptable == null || (invokeV = interceptable.invokeV(65550, null)) == null) ? mHasInited : invokeV.booleanValue;
    }
}
