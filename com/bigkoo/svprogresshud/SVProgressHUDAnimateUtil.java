package com.bigkoo.svprogresshud;

import com.baidu.titan.sdk.runtime.FieldHolder;
import com.baidu.titan.sdk.runtime.InitContext;
import com.baidu.titan.sdk.runtime.InterceptResult;
import com.baidu.titan.sdk.runtime.Interceptable;
import com.baidu.titan.sdk.runtime.TitanRuntime;
/* loaded from: classes8.dex */
public class SVProgressHUDAnimateUtil {
    public static /* synthetic */ Interceptable $ic = null;
    public static final int INVALID = -1;
    public transient /* synthetic */ FieldHolder $fh;

    public static int getAnimationResource(int i, boolean z) {
        InterceptResult invokeCommon;
        Interceptable interceptable = $ic;
        if (interceptable == null || (invokeCommon = interceptable.invokeCommon(65537, null, new Object[]{Integer.valueOf(i), Boolean.valueOf(z)})) == null) {
            if (i == 17) {
                return z ? com.baidu.tieba.R.anim.obfuscated_res_0x7f010164 : com.baidu.tieba.R.anim.obfuscated_res_0x7f010165;
            } else if (i == 48) {
                return z ? com.baidu.tieba.R.anim.obfuscated_res_0x7f010167 : com.baidu.tieba.R.anim.obfuscated_res_0x7f010169;
            } else if (i != 80) {
                return -1;
            } else {
                return z ? com.baidu.tieba.R.anim.obfuscated_res_0x7f010166 : com.baidu.tieba.R.anim.obfuscated_res_0x7f010168;
            }
        }
        return invokeCommon.intValue;
    }

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
}
