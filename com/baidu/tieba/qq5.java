package com.baidu.tieba;

import android.content.Intent;
import com.baidu.adp.lib.util.StringUtils;
import com.baidu.tbadk.core.sharedPref.SharedPrefHelper;
import com.baidu.titan.sdk.runtime.FieldHolder;
import com.baidu.titan.sdk.runtime.InitContext;
import com.baidu.titan.sdk.runtime.InterceptResult;
import com.baidu.titan.sdk.runtime.Interceptable;
import com.baidu.titan.sdk.runtime.TitanRuntime;
/* loaded from: classes7.dex */
public class qq5 {
    public static /* synthetic */ Interceptable $ic;
    public static volatile qq5 a;
    public transient /* synthetic */ FieldHolder $fh;

    public qq5() {
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

    public static qq5 a() {
        InterceptResult invokeV;
        Interceptable interceptable = $ic;
        if (interceptable == null || (invokeV = interceptable.invokeV(65537, null)) == null) {
            if (a == null) {
                synchronized (qq5.class) {
                    if (a == null) {
                        a = new qq5();
                    }
                }
            }
            return a;
        }
        return (qq5) invokeV.objValue;
    }

    public void b(Intent intent) {
        Interceptable interceptable = $ic;
        if ((interceptable == null || interceptable.invokeL(1048576, this, intent) == null) && intent != null && intent.getData() != null && !StringUtils.isNull(intent.getData().getSchemeSpecificPart())) {
            SharedPrefHelper.getInstance().remove("key_ad_retarget_tips_app_count_" + intent.getData().getSchemeSpecificPart());
        }
    }
}
