package com.baidu.wallet.personal.storage;

import android.content.Context;
import com.baidu.apollon.utils.SharedPreferencesUtils;
import com.baidu.titan.sdk.runtime.FieldHolder;
import com.baidu.titan.sdk.runtime.InitContext;
import com.baidu.titan.sdk.runtime.InterceptResult;
import com.baidu.titan.sdk.runtime.Interceptable;
import com.baidu.titan.sdk.runtime.TitanRuntime;
import com.baidu.wallet.core.beans.BeanConstants;
/* loaded from: classes5.dex */
public final class PersonalPreferenceManager {
    public static /* synthetic */ Interceptable $ic;
    public transient /* synthetic */ FieldHolder $fh;

    public PersonalPreferenceManager() {
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

    public static boolean isPersonalBannerFirst(Context context) {
        InterceptResult invokeL;
        Interceptable interceptable = $ic;
        return (interceptable == null || (invokeL = interceptable.invokeL(65537, null, context)) == null) ? ((Boolean) SharedPreferencesUtils.getParam(context, BeanConstants.PREFERENCES_NAME, "key_personal_banner_first_", Boolean.TRUE)).booleanValue() : invokeL.booleanValue;
    }

    public static void setPersonalBannerFirst(Context context, boolean z) {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeLZ(65538, null, context, z) == null) {
            SharedPreferencesUtils.setParam(context, BeanConstants.PREFERENCES_NAME, "key_personal_banner_first_", Boolean.valueOf(z));
        }
    }
}
