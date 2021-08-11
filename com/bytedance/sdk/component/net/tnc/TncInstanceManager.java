package com.bytedance.sdk.component.net.tnc;

import android.content.Context;
import com.baidu.android.imsdk.internal.Constants;
import com.baidu.titan.sdk.runtime.FieldHolder;
import com.baidu.titan.sdk.runtime.InitContext;
import com.baidu.titan.sdk.runtime.InterceptResult;
import com.baidu.titan.sdk.runtime.Interceptable;
import com.baidu.titan.sdk.runtime.TitanRuntime;
import java.util.HashMap;
/* loaded from: classes9.dex */
public class TncInstanceManager {
    public static /* synthetic */ Interceptable $ic;
    public static HashMap<Integer, AppConfig> appConfigHashMap;
    public static volatile TncInstanceManager instanceManager;
    public static HashMap<Integer, TNCManager> tncManagerHashMap;
    public transient /* synthetic */ FieldHolder $fh;

    public TncInstanceManager() {
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
        tncManagerHashMap = new HashMap<>();
        appConfigHashMap = new HashMap<>();
    }

    public static synchronized TncInstanceManager getInstance() {
        InterceptResult invokeV;
        TncInstanceManager tncInstanceManager;
        Interceptable interceptable = $ic;
        if (interceptable == null || (invokeV = interceptable.invokeV(65537, null)) == null) {
            synchronized (TncInstanceManager.class) {
                if (instanceManager == null) {
                    synchronized (TncInstanceManager.class) {
                        if (instanceManager == null) {
                            instanceManager = new TncInstanceManager();
                        }
                    }
                }
                tncInstanceManager = instanceManager;
            }
            return tncInstanceManager;
        }
        return (TncInstanceManager) invokeV.objValue;
    }

    public AppConfig getAppConfig(int i2, Context context) {
        InterceptResult invokeIL;
        Interceptable interceptable = $ic;
        if (interceptable == null || (invokeIL = interceptable.invokeIL(1048576, this, i2, context)) == null) {
            if (appConfigHashMap.get(Integer.valueOf(i2)) == null) {
                appConfigHashMap.put(Integer.valueOf(i2), new AppConfig(context, i2));
            }
            return appConfigHashMap.get(Integer.valueOf(i2));
        }
        return (AppConfig) invokeIL.objValue;
    }

    public TNCManager getTNCManager(int i2) {
        InterceptResult invokeI;
        Interceptable interceptable = $ic;
        if (interceptable == null || (invokeI = interceptable.invokeI(Constants.METHOD_GET_CONTACTER_INFO_FOR_SESSION, this, i2)) == null) {
            if (tncManagerHashMap.get(Integer.valueOf(i2)) == null) {
                tncManagerHashMap.put(Integer.valueOf(i2), new TNCManager(i2));
            }
            return tncManagerHashMap.get(Integer.valueOf(i2));
        }
        return (TNCManager) invokeI.objValue;
    }
}
