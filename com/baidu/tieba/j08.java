package com.baidu.tieba;

import com.baidu.titan.sdk.runtime.FieldHolder;
import com.baidu.titan.sdk.runtime.InitContext;
import com.baidu.titan.sdk.runtime.InterceptResult;
import com.baidu.titan.sdk.runtime.Interceptable;
import com.baidu.titan.sdk.runtime.TitanRuntime;
import java.util.Map;
import kotlin.jvm.internal.Intrinsics;
import org.json.JSONObject;
/* loaded from: classes6.dex */
public final class j08 {
    public static /* synthetic */ Interceptable $ic;
    public transient /* synthetic */ FieldHolder $fh;
    public final Map<String, a> a;

    /* loaded from: classes6.dex */
    public static final class a {
        public static /* synthetic */ Interceptable $ic;
        public transient /* synthetic */ FieldHolder $fh;
        public final String a;
        public final long b;

        public a(String frsCustomCounts, long j) {
            Interceptable interceptable = $ic;
            if (interceptable != null) {
                InitContext newInitContext = TitanRuntime.newInitContext();
                newInitContext.initArgs = r2;
                Object[] objArr = {frsCustomCounts, Long.valueOf(j)};
                interceptable.invokeUnInit(65536, newInitContext);
                int i = newInitContext.flag;
                if ((i & 1) != 0) {
                    int i2 = i & 2;
                    newInitContext.thisArg = this;
                    interceptable.invokeInitBody(65536, newInitContext);
                    return;
                }
            }
            Intrinsics.checkNotNullParameter(frsCustomCounts, "frsCustomCounts");
            this.a = frsCustomCounts;
            this.b = j;
        }

        public final JSONObject a() {
            InterceptResult invokeV;
            Interceptable interceptable = $ic;
            if (interceptable == null || (invokeV = interceptable.invokeV(1048576, this)) == null) {
                JSONObject jSONObject = new JSONObject();
                jSONObject.putOpt("frs_csm", this.a);
                jSONObject.putOpt("last_time", Long.valueOf(this.b));
                return jSONObject;
            }
            return (JSONObject) invokeV.objValue;
        }
    }

    public j08(Map<String, a> frsVisitedDataMap) {
        Interceptable interceptable = $ic;
        if (interceptable != null) {
            InitContext newInitContext = TitanRuntime.newInitContext();
            newInitContext.initArgs = r2;
            Object[] objArr = {frsVisitedDataMap};
            interceptable.invokeUnInit(65536, newInitContext);
            int i = newInitContext.flag;
            if ((i & 1) != 0) {
                int i2 = i & 2;
                newInitContext.thisArg = this;
                interceptable.invokeInitBody(65536, newInitContext);
                return;
            }
        }
        Intrinsics.checkNotNullParameter(frsVisitedDataMap, "frsVisitedDataMap");
        this.a = frsVisitedDataMap;
    }

    public final JSONObject a() {
        InterceptResult invokeV;
        JSONObject jSONObject;
        Interceptable interceptable = $ic;
        if (interceptable == null || (invokeV = interceptable.invokeV(1048576, this)) == null) {
            JSONObject jSONObject2 = new JSONObject();
            for (String str : this.a.keySet()) {
                a aVar = this.a.get(str);
                if (aVar != null) {
                    jSONObject = aVar.a();
                } else {
                    jSONObject = null;
                }
                jSONObject2.put(str, jSONObject);
            }
            return jSONObject2;
        }
        return (JSONObject) invokeV.objValue;
    }
}
