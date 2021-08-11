package com.bytedance.sdk.component.net.utils;

import android.content.Context;
import com.baidu.titan.sdk.runtime.FieldHolder;
import com.baidu.titan.sdk.runtime.InitContext;
import com.baidu.titan.sdk.runtime.InterceptResult;
import com.baidu.titan.sdk.runtime.Interceptable;
import com.baidu.titan.sdk.runtime.TitanRuntime;
import com.bytedance.sdk.component.net.tnc.TncInstanceManager;
import java.util.LinkedHashMap;
/* loaded from: classes9.dex */
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

    /* JADX WARN: Removed duplicated region for block: B:14:0x0032  */
    /* JADX WARN: Removed duplicated region for block: B:23:? A[RETURN, SYNTHETIC] */
    /*
        Code decompiled incorrectly, please refer to instructions dump.
    */
    public static String getData(Context context, int i2, int i3) {
        InterceptResult invokeLII;
        String str;
        Interceptable interceptable = $ic;
        if (interceptable != null && (invokeLII = interceptable.invokeLII(65537, null, context, i2, i3)) != null) {
            return (String) invokeLII.objValue;
        }
        if (i2 == 1) {
            if (TncInstanceManager.getInstance().getTNCManager(i3).getITTAdNetDepend() != null) {
                str = TncInstanceManager.getInstance().getTNCManager(i3).getITTAdNetDepend().getProviderString(context, getTncKey(i3), "");
                return !(str instanceof String) ? String.valueOf(str) : "";
            }
        }
        str = "";
        if (!(str instanceof String)) {
        }
    }

    public static String getTncKey(int i2) {
        InterceptResult invokeI;
        Interceptable interceptable = $ic;
        if (interceptable == null || (invokeI = interceptable.invokeI(65538, null, i2)) == null) {
            return KEY_TNC_CONFIG + i2;
        }
        return (String) invokeI.objValue;
    }

    public static void saveData(Context context, int i2, String str, int i3) {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeCommon(65539, null, new Object[]{context, Integer.valueOf(i2), str, Integer.valueOf(i3)}) == null) {
            try {
                LinkedHashMap linkedHashMap = new LinkedHashMap();
                if (i2 == 1) {
                    linkedHashMap.put(getTncKey(i3), str);
                }
                Logger.debug(TAG, "saveData = " + str);
                if (TncInstanceManager.getInstance().getTNCManager(i3).getITTAdNetDepend() != null) {
                    TncInstanceManager.getInstance().getTNCManager(i3).getITTAdNetDepend().saveMapToProvider(context, linkedHashMap);
                }
            } catch (Exception unused) {
            }
        }
    }
}
