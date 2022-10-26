package com.baidu.yunjiasu.tornadosdk;

import android.net.ConnectivityManager;
import com.baidu.titan.sdk.runtime.FieldHolder;
import com.baidu.titan.sdk.runtime.InitContext;
import com.baidu.titan.sdk.runtime.InterceptResult;
import com.baidu.titan.sdk.runtime.Interceptable;
import com.baidu.titan.sdk.runtime.TitanRuntime;
import kotlin.Metadata;
import kotlin.jvm.functions.Function0;
import kotlin.jvm.internal.Lambda;
@Metadata(d1 = {"\u0000\u0006\n\u0000\n\u0002\u0018\u0002\u0010\u0000\u001a\u00020\u0001H\n"}, d2 = {"<anonymous>", "Landroid/net/ConnectivityManager;"}, k = 3, mv = {1, 5, 1}, xi = 48)
/* loaded from: classes7.dex */
public final class TrdVpnService$connectivityManager$2 extends Lambda implements Function0<ConnectivityManager> {
    public static /* synthetic */ Interceptable $ic;
    public transient /* synthetic */ FieldHolder $fh;
    public final /* synthetic */ TrdVpnService this$0;

    /* JADX WARN: 'super' call moved to the top of the method (can break code semantics) */
    public TrdVpnService$connectivityManager$2(TrdVpnService trdVpnService) {
        super(0);
        Interceptable interceptable = $ic;
        if (interceptable != null) {
            InitContext newInitContext = TitanRuntime.newInitContext();
            newInitContext.initArgs = r2;
            Object[] objArr = {trdVpnService};
            interceptable.invokeUnInit(65536, newInitContext);
            int i = newInitContext.flag;
            if ((i & 1) != 0) {
                int i2 = i & 2;
                super(((Integer) newInitContext.callArgs[0]).intValue());
                newInitContext.thisArg = this;
                interceptable.invokeInitBody(65536, newInitContext);
                return;
            }
        }
        this.this$0 = trdVpnService;
    }

    /* JADX DEBUG: Method merged with bridge method */
    @Override // kotlin.jvm.functions.Function0
    public final ConnectivityManager invoke() {
        InterceptResult invokeV;
        Interceptable interceptable = $ic;
        if (interceptable == null || (invokeV = interceptable.invokeV(1048576, this)) == null) {
            Object systemService = this.this$0.getSystemService("connectivity");
            if (systemService != null) {
                return (ConnectivityManager) systemService;
            }
            throw new NullPointerException("null cannot be cast to non-null type android.net.ConnectivityManager");
        }
        return (ConnectivityManager) invokeV.objValue;
    }
}
