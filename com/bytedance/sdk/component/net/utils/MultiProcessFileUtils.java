package com.bytedance.sdk.component.net.utils;

import android.content.Context;
import com.baidu.titan.sdk.runtime.FieldHolder;
import com.baidu.titan.sdk.runtime.InitContext;
import com.baidu.titan.sdk.runtime.InterceptResult;
import com.baidu.titan.sdk.runtime.Interceptable;
import com.baidu.titan.sdk.runtime.TitanRuntime;
import com.bytedance.sdk.component.net.tnc.TNCManager;
import java.util.LinkedHashMap;
/* loaded from: classes5.dex */
public class MultiProcessFileUtils {
    public static /* synthetic */ Interceptable $ic = null;
    public static final String KEY_TNC_CONFIG = "tnc_config";
    public static final String TAG = "MultiProcessFileUtils";
    public static final int TYPE_TNC_CONFIG = 1;
    public transient /* synthetic */ FieldHolder $fh;

    public MultiProcessFileUtils() {
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

    public static String getData(Context context, int i2) {
        InterceptResult invokeLI;
        Interceptable interceptable = $ic;
        if (interceptable == null || (invokeLI = interceptable.invokeLI(65537, null, context, i2)) == null) {
            if (i2 == 1) {
                try {
                    if (TNCManager.getInstance().getITTAdNetDepend() != null) {
                        TNCManager.getInstance().getITTAdNetDepend().getProviderString(context, KEY_TNC_CONFIG, "");
                    }
                } catch (Exception unused) {
                }
            }
            return "";
        }
        return (String) invokeLI.objValue;
    }

    public static void saveData(Context context, int i2, String str) {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeLIL(65538, null, context, i2, str) == null) {
            try {
                LinkedHashMap linkedHashMap = new LinkedHashMap();
                if (i2 == 1) {
                    linkedHashMap.put(KEY_TNC_CONFIG, str);
                }
                Logger.debug(TAG, "saveData = " + str);
                if (TNCManager.getInstance().getITTAdNetDepend() != null) {
                    TNCManager.getInstance().getITTAdNetDepend().saveMapToProvider(context, linkedHashMap);
                }
            } catch (Exception unused) {
            }
        }
    }
}
