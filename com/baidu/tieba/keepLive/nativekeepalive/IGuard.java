package com.baidu.tieba.keepLive.nativekeepalive;

import android.content.Context;
import android.os.Build;
import com.baidu.tieba.keepLive.nativekeepalive.GuardProxy;
import com.baidu.titan.sdk.runtime.FieldHolder;
import com.baidu.titan.sdk.runtime.InitContext;
import com.baidu.titan.sdk.runtime.InterceptResult;
import com.baidu.titan.sdk.runtime.Interceptable;
import com.baidu.titan.sdk.runtime.TitanRuntime;
/* loaded from: classes4.dex */
public interface IGuard {

    /* loaded from: classes4.dex */
    public static class Fetcher {
        public static /* synthetic */ Interceptable $ic;
        public static IGuard mDaemonStrategy;
        public transient /* synthetic */ FieldHolder $fh;

        public Fetcher() {
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

        public static IGuard fetchGuard() {
            InterceptResult invokeV;
            Interceptable interceptable = $ic;
            if (interceptable == null || (invokeV = interceptable.invokeV(65537, null)) == null) {
                IGuard iGuard = mDaemonStrategy;
                if (iGuard != null) {
                    return iGuard;
                }
                int i2 = Build.VERSION.SDK_INT;
                if (i2 != 21) {
                    if (i2 != 22) {
                        if (Build.MODEL != null && isXiaomiModel()) {
                            GuardProxy guardProxy = new GuardProxy();
                            guardProxy.getClass();
                            mDaemonStrategy = new GuardProxy.d(guardProxy);
                        } else {
                            String str = Build.MODEL;
                            if (str != null && str.toLowerCase().startsWith("a31")) {
                                GuardProxy guardProxy2 = new GuardProxy();
                                guardProxy2.getClass();
                                mDaemonStrategy = new GuardProxy.b(guardProxy2);
                            } else {
                                GuardProxy guardProxy3 = new GuardProxy();
                                guardProxy3.getClass();
                                mDaemonStrategy = new GuardProxy.a(guardProxy3);
                            }
                        }
                    } else {
                        GuardProxy guardProxy4 = new GuardProxy();
                        guardProxy4.getClass();
                        mDaemonStrategy = new GuardProxy.c(guardProxy4);
                    }
                } else if ("MX4 Pro".equalsIgnoreCase(Build.MODEL)) {
                    GuardProxy guardProxy5 = new GuardProxy();
                    guardProxy5.getClass();
                    mDaemonStrategy = new GuardProxy.a(guardProxy5);
                } else {
                    GuardProxy guardProxy6 = new GuardProxy();
                    guardProxy6.getClass();
                    mDaemonStrategy = new GuardProxy.b(guardProxy6);
                }
                return mDaemonStrategy;
            }
            return (IGuard) invokeV.objValue;
        }

        public static boolean isXiaomiModel() {
            InterceptResult invokeV;
            Interceptable interceptable = $ic;
            if (interceptable == null || (invokeV = interceptable.invokeV(65538, null)) == null) {
                String lowerCase = Build.MODEL.toLowerCase();
                return lowerCase.startsWith("mi") || lowerCase.startsWith("hm") || lowerCase.startsWith("redmi");
            }
            return invokeV.booleanValue;
        }
    }

    void onDaemonAssistantCreate(Context context, GuardConfigurations guardConfigurations);

    void onDaemonDead();

    boolean onInitialization(Context context);

    void onPersistentCreate(Context context, GuardConfigurations guardConfigurations);
}
