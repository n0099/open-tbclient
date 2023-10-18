package com.baidu.tieba;

import androidx.annotation.Nullable;
import com.baidu.titan.sdk.runtime.FieldHolder;
import com.baidu.titan.sdk.runtime.InitContext;
import com.baidu.titan.sdk.runtime.Interceptable;
import com.baidu.titan.sdk.runtime.TitanRuntime;
import com.baidu.turbonet.net.CronetException;
import com.baidu.turbonet.net.RequestFinishedInfo;
import com.baidu.turbonet.net.UrlResponseInfo;
import java.util.Collection;
/* loaded from: classes6.dex */
public class j6b extends RequestFinishedInfo {
    public static /* synthetic */ Interceptable $ic;
    public transient /* synthetic */ FieldHolder $fh;

    public j6b(String str, Collection<Object> collection, RequestFinishedInfo.Metrics metrics, int i, @Nullable UrlResponseInfo urlResponseInfo, @Nullable CronetException cronetException) {
        Interceptable interceptable = $ic;
        if (interceptable != null) {
            InitContext newInitContext = TitanRuntime.newInitContext();
            newInitContext.initArgs = r2;
            Object[] objArr = {str, collection, metrics, Integer.valueOf(i), urlResponseInfo, cronetException};
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
