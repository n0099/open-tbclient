package com.baidu.wallet.base.iddetect.statistics;

import com.baidu.titan.sdk.runtime.FieldHolder;
import com.baidu.titan.sdk.runtime.InitContext;
import com.baidu.titan.sdk.runtime.Interceptable;
import com.baidu.titan.sdk.runtime.TitanRuntime;
import com.baidu.wallet.core.NoProguard;
/* loaded from: classes10.dex */
public class IdCardDetectStatistics implements NoProguard {
    public static /* synthetic */ Interceptable $ic = null;
    public static final String IDCARD_PHOTO_COMPLETE = "#IDPhotoComplete";
    public static final String IDCARD_PHOTO_RESET = "#IDPhotoReset";
    public static final String IDCARD_PHOTO_SHUTTER = "#IDPhotoShutter";
    public transient /* synthetic */ FieldHolder $fh;

    public IdCardDetectStatistics() {
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
}
