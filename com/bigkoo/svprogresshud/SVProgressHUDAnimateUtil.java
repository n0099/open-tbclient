package com.bigkoo.svprogresshud;

import com.baidu.tieba.R;
import com.baidu.titan.sdk.runtime.FieldHolder;
import com.baidu.titan.sdk.runtime.InitContext;
import com.baidu.titan.sdk.runtime.InterceptResult;
import com.baidu.titan.sdk.runtime.Interceptable;
import com.baidu.titan.sdk.runtime.TitanRuntime;
/* loaded from: classes6.dex */
public class SVProgressHUDAnimateUtil {
    public static /* synthetic */ Interceptable $ic = null;
    public static final int INVALID = -1;
    public transient /* synthetic */ FieldHolder $fh;

    public SVProgressHUDAnimateUtil() {
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

    public static int getAnimationResource(int i, boolean z) {
        InterceptResult invokeCommon;
        Interceptable interceptable = $ic;
        if (interceptable == null || (invokeCommon = interceptable.invokeCommon(65537, null, new Object[]{Integer.valueOf(i), Boolean.valueOf(z)})) == null) {
            if (i == 17) {
                return z ? R.anim.obfuscated_res_0x7f010120 : R.anim.obfuscated_res_0x7f010121;
            } else if (i == 48) {
                return z ? R.anim.obfuscated_res_0x7f010123 : R.anim.obfuscated_res_0x7f010125;
            } else if (i != 80) {
                return -1;
            } else {
                return z ? R.anim.obfuscated_res_0x7f010122 : R.anim.obfuscated_res_0x7f010124;
            }
        }
        return invokeCommon.intValue;
    }
}
