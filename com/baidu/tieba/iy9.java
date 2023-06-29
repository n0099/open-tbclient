package com.baidu.tieba;

import android.util.Log;
import com.baidu.android.imsdk.internal.Constants;
import com.baidu.searchbox.http.statistics.NetworkInfoRecord;
import com.baidu.searchbox.http.statistics.NetworkStatRecord;
import com.baidu.titan.sdk.runtime.FieldHolder;
import com.baidu.titan.sdk.runtime.InitContext;
import com.baidu.titan.sdk.runtime.InterceptResult;
import com.baidu.titan.sdk.runtime.Interceptable;
import com.baidu.titan.sdk.runtime.TitanRuntime;
import com.baidu.ubc.UBC;
import org.json.JSONObject;
/* loaded from: classes6.dex */
public class iy9 implements NetworkInfoRecord {
    public static /* synthetic */ Interceptable $ic;
    public transient /* synthetic */ FieldHolder $fh;
    public ly9 a;
    public ly9 b;

    public String a() {
        InterceptResult invokeV;
        Interceptable interceptable = $ic;
        return (interceptable == null || (invokeV = interceptable.invokeV(1048576, this)) == null) ? "850" : (String) invokeV.objValue;
    }

    public String b() {
        InterceptResult invokeV;
        Interceptable interceptable = $ic;
        return (interceptable == null || (invokeV = interceptable.invokeV(Constants.METHOD_GET_CONTACTER_INFO_FOR_SESSION, this)) == null) ? "94" : (String) invokeV.objValue;
    }

    @Override // com.baidu.searchbox.http.statistics.NetworkInfoRecord
    public boolean shouldRecord() {
        InterceptResult invokeV;
        Interceptable interceptable = $ic;
        if (interceptable == null || (invokeV = interceptable.invokeV(1048579, this)) == null) {
            return true;
        }
        return invokeV.booleanValue;
    }

    /* JADX WARN: 'this' call moved to the top of the method (can break code semantics) */
    public iy9() {
        this(new jy9(10, 100));
        Interceptable interceptable = $ic;
        if (interceptable != null) {
            InitContext newInitContext = TitanRuntime.newInitContext();
            interceptable.invokeUnInit(65536, newInitContext);
            int i = newInitContext.flag;
            if ((i & 1) != 0) {
                int i2 = i & 2;
                this((ly9) newInitContext.callArgs[0]);
                newInitContext.thisArg = this;
                interceptable.invokeInitBody(65536, newInitContext);
                return;
            }
        }
    }

    public iy9(ly9 ly9Var) {
        Interceptable interceptable = $ic;
        if (interceptable != null) {
            InitContext newInitContext = TitanRuntime.newInitContext();
            newInitContext.initArgs = r2;
            Object[] objArr = {ly9Var};
            interceptable.invokeUnInit(65537, newInitContext);
            int i = newInitContext.flag;
            if ((i & 1) != 0) {
                int i2 = i & 2;
                newInitContext.thisArg = this;
                interceptable.invokeInitBody(65537, newInitContext);
                return;
            }
        }
        this.a = ly9Var;
        this.b = new ky9();
    }

    @Override // com.baidu.searchbox.http.statistics.NetworkInfoRecord
    public void doRecord(NetworkStatRecord networkStatRecord) {
        JSONObject uBCJson;
        Interceptable interceptable = $ic;
        if ((interceptable == null || interceptable.invokeL(Constants.METHOD_SEND_USER_MSG, this, networkStatRecord) == null) && networkStatRecord != null && (uBCJson = networkStatRecord.toUBCJson()) != null) {
            String jSONObject = uBCJson.toString();
            hy9 a = hy9.a();
            if (a.g()) {
                a.c(jSONObject);
            }
            if (a.f(networkStatRecord)) {
                a.b(jSONObject);
            }
            ly9 ly9Var = this.a;
            if (ly9Var != null && ly9Var.a(networkStatRecord)) {
                int i = 0;
                if (wx9.a) {
                    i = 64;
                }
                UBC.onEvent(b(), jSONObject, i);
            }
            if (wx9.a && networkStatRecord.from != 3 && networkStatRecord.netEngine < 0) {
                Log.i("SearchBoxNetRecord", "baidu_networkSearchBoxNetRecord onFinishRecord UBC.onEvent!UbcEventId:" + b() + "，ubcJson:" + uBCJson);
            }
            ly9 ly9Var2 = this.b;
            if (ly9Var2 != null && ly9Var2.a(networkStatRecord)) {
                UBC.onEvent(a(), jSONObject);
            }
        }
    }
}
