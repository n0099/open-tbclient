package com.baidu.tieba;

import android.annotation.SuppressLint;
import androidx.annotation.NonNull;
import com.baidu.android.imsdk.internal.Constants;
import com.baidu.searchbox.v8engine.net.NetInfo;
import com.baidu.searchbox.v8engine.net.NetRequestResult;
import com.baidu.titan.sdk.runtime.FieldHolder;
import com.baidu.titan.sdk.runtime.InitContext;
import com.baidu.titan.sdk.runtime.InterceptResult;
import com.baidu.titan.sdk.runtime.Interceptable;
import com.baidu.titan.sdk.runtime.TitanRuntime;
import java.util.Observable;
import java.util.Observer;
/* loaded from: classes7.dex */
public class r02 implements Observer {
    public static /* synthetic */ Interceptable $ic;
    public transient /* synthetic */ FieldHolder $fh;

    public r02() {
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

    public final String a(@NonNull NetInfo netInfo, @NonNull NetRequestResult netRequestResult, int i) {
        InterceptResult invokeLLI;
        Integer num;
        Interceptable interceptable = $ic;
        if (interceptable == null || (invokeLLI = interceptable.invokeLLI(1048576, this, netInfo, netRequestResult, i)) == null) {
            Object obj = "";
            if (i == 200) {
                return "";
            }
            String statusMsg = netRequestResult.getStatusMsg();
            NetInfo.Response response = netInfo.getResponse();
            NetInfo.Base base = netInfo.getBase();
            StringBuilder sb = new StringBuilder();
            sb.append(statusMsg);
            sb.append("; code=");
            if (response == null) {
                num = "";
            } else {
                num = Integer.valueOf(response.mCode);
            }
            sb.append(num);
            String sb2 = sb.toString();
            StringBuilder sb3 = new StringBuilder();
            sb3.append(sb2);
            sb3.append("; status=");
            if (base != null) {
                obj = Integer.valueOf(base.mStatus);
            }
            sb3.append(obj);
            return sb3.toString();
        }
        return (String) invokeLLI.objValue;
    }

    @Override // java.util.Observer
    @SuppressLint({"BDThrowableCheck"})
    public void update(Observable observable, Object obj) {
        Interceptable interceptable = $ic;
        if ((interceptable != null && interceptable.invokeLL(Constants.METHOD_GET_CONTACTER_INFO_FOR_SESSION, this, observable, obj) != null) || !(obj instanceof NetRequestResult)) {
            return;
        }
        NetRequestResult netRequestResult = (NetRequestResult) obj;
        String url = netRequestResult.getUrl();
        String valueOf = String.valueOf(netRequestResult.getId());
        int statusCode = netRequestResult.getStatusCode();
        if (statusCode != 3) {
            if (statusCode != 4) {
                if (statusCode != 5) {
                    if (statusCode == 6) {
                        qg2.D(valueOf, netRequestResult.getCreatedTime(), 0L, 0L);
                    }
                } else {
                    qg2.D(valueOf, 0L, 0L, netRequestResult.getCreatedTime());
                }
            } else if (url != null) {
                qg2.k().q(valueOf, url);
            }
        } else {
            qg2.D(valueOf, 0L, netRequestResult.getCreatedTime(), 0L);
        }
        NetInfo netInfo = netRequestResult.getNetInfo();
        int statusCode2 = netRequestResult.getStatusCode();
        if (netRequestResult.getFromType() == 1 && url != null && netInfo != null) {
            qg2.k().B(valueOf, url, netInfo);
            long l = qg2.k().l(valueOf);
            long currentTimeMillis = System.currentTimeMillis();
            String e = ap3.n().e();
            zh3.Q(statusCode2, netRequestResult.getUrl(), 0, a(netInfo, netRequestResult, statusCode2), zh3.l(), e, l, currentTimeMillis, valueOf);
        } else if (netInfo != null) {
            if (statusCode2 < 0 || statusCode2 >= 400) {
                zh3.P(statusCode2, netRequestResult.getUrl(), 0, a(netInfo, netRequestResult, statusCode2), 0L, 0L, valueOf);
            }
        }
    }
}
