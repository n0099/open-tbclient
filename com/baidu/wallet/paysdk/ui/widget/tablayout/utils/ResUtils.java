package com.baidu.wallet.paysdk.ui.widget.tablayout.utils;

import android.content.Context;
import com.baidu.apollon.utils.ChannelUtils;
import com.baidu.titan.sdk.runtime.FieldHolder;
import com.baidu.titan.sdk.runtime.InitContext;
import com.baidu.titan.sdk.runtime.InterceptResult;
import com.baidu.titan.sdk.runtime.Interceptable;
import com.baidu.titan.sdk.runtime.TitanRuntime;
import com.baidu.wallet.core.beans.BeanConstants;
import java.lang.reflect.Field;
/* loaded from: classes6.dex */
public final class ResUtils {
    public static /* synthetic */ Interceptable $ic;
    public transient /* synthetic */ FieldHolder $fh;

    public ResUtils() {
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

    public static int[] getStyleableIntArray(Context context, String str) {
        InterceptResult invokeLL;
        Field[] fields;
        Interceptable interceptable = $ic;
        if (interceptable == null || (invokeLL = interceptable.invokeLL(65537, null, context, str)) == null) {
            try {
                String packageName = context.getPackageName();
                if (ChannelUtils.isSpecailPackage()) {
                    packageName = "com.baidu.wallet";
                }
                if (BeanConstants.CHANNEL_ID_IQIYI.equals(BeanConstants.CHANNEL_ID)) {
                    packageName = "com.qiyi.plugin.wallet";
                }
                for (Field field : Class.forName(packageName + ".R$styleable").getFields()) {
                    if (field.getName().equals(str)) {
                        return (int[]) field.get(null);
                    }
                }
            } catch (Throwable unused) {
            }
            return null;
        }
        return (int[]) invokeLL.objValue;
    }

    public static int styleable(Context context, String str, String str2) {
        Field[] fields;
        InterceptResult invokeLLL;
        Interceptable interceptable = $ic;
        if (interceptable == null || (invokeLLL = interceptable.invokeLLL(65538, null, context, str, str2)) == null) {
            try {
                String packageName = context.getPackageName();
                if (ChannelUtils.isSpecailPackage()) {
                    packageName = "com.baidu.wallet";
                }
                if (BeanConstants.CHANNEL_ID_IQIYI.equals(BeanConstants.CHANNEL_ID)) {
                    packageName = "com.qiyi.plugin.wallet";
                }
                for (Field field : Class.forName(packageName + ".R$styleable").getFields()) {
                    if (field.getName().equals(str + "_" + str2)) {
                        return ((Integer) field.get(null)).intValue();
                    }
                }
                return -1;
            } catch (Throwable unused) {
                return -1;
            }
        }
        return invokeLLL.intValue;
    }
}
