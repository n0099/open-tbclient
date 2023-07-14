package com.baidu.vi;

import android.net.NetworkInfo;
import com.baidu.titan.sdk.runtime.FieldHolder;
import com.baidu.titan.sdk.runtime.InitContext;
import com.baidu.titan.sdk.runtime.Interceptable;
import com.baidu.titan.sdk.runtime.TitanRuntime;
/* loaded from: classes9.dex */
public class VNetworkInfo {
    public static /* synthetic */ Interceptable $ic;
    public transient /* synthetic */ FieldHolder $fh;
    public int state;
    public int type;
    public String typename;

    public VNetworkInfo(NetworkInfo networkInfo) {
        Interceptable interceptable = $ic;
        if (interceptable != null) {
            InitContext newInitContext = TitanRuntime.newInitContext();
            newInitContext.initArgs = r2;
            Object[] objArr = {networkInfo};
            interceptable.invokeUnInit(65536, newInitContext);
            int i = newInitContext.flag;
            if ((i & 1) != 0) {
                int i2 = i & 2;
                newInitContext.thisArg = this;
                interceptable.invokeInitBody(65536, newInitContext);
                return;
            }
        }
        this.typename = networkInfo.getTypeName();
        this.type = networkInfo.getType();
        int i3 = i.a[networkInfo.getState().ordinal()];
        if (i3 != 1) {
            if (i3 != 2) {
                this.state = 0;
                return;
            } else {
                this.state = 1;
                return;
            }
        }
        this.state = 2;
    }
}
