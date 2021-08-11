package com.bigkoo.svprogresshud;

import com.baidu.titan.sdk.runtime.FieldHolder;
import com.baidu.titan.sdk.runtime.InitContext;
import com.baidu.titan.sdk.runtime.InterceptResult;
import com.baidu.titan.sdk.runtime.Interceptable;
import com.baidu.titan.sdk.runtime.TitanRuntime;
/* loaded from: classes9.dex */
public class SVProgressHUDAnimateUtil {
    public static /* synthetic */ Interceptable $ic = null;
    public static final int INVALID = -1;
    public transient /* synthetic */ FieldHolder $fh;

    public SVProgressHUDAnimateUtil() {
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

    public static int getAnimationResource(int i2, boolean z) {
        InterceptResult invokeCommon;
        Interceptable interceptable = $ic;
        if (interceptable == null || (invokeCommon = interceptable.invokeCommon(65537, null, new Object[]{Integer.valueOf(i2), Boolean.valueOf(z)})) == null) {
            if (i2 == 17) {
                return z ? R.anim.svfade_in_center : R.anim.svfade_out_center;
            } else if (i2 == 48) {
                return z ? R.anim.svslide_in_top : R.anim.svslide_out_top;
            } else if (i2 != 80) {
                return -1;
            } else {
                return z ? R.anim.svslide_in_bottom : R.anim.svslide_out_bottom;
            }
        }
        return invokeCommon.intValue;
    }
}
