package com.baidu.tieba;

import com.baidu.android.imsdk.internal.Constants;
import com.baidu.titan.sdk.runtime.FieldHolder;
import com.baidu.titan.sdk.runtime.InitContext;
import com.baidu.titan.sdk.runtime.InterceptResult;
import com.baidu.titan.sdk.runtime.Interceptable;
import com.baidu.titan.sdk.runtime.TitanRuntime;
import java.util.ArrayList;
import java.util.Iterator;
import org.json.JSONArray;
import org.json.JSONException;
import org.json.JSONObject;
/* loaded from: classes7.dex */
public class qc4 {
    public static /* synthetic */ Interceptable $ic;
    public static volatile qc4 c;
    public transient /* synthetic */ FieldHolder $fh;
    public int a;
    public volatile ArrayList<pc4> b;

    public qc4() {
        Interceptable interceptable = $ic;
        if (interceptable != null) {
            InitContext newInitContext = TitanRuntime.newInitContext();
            interceptable.invokeUnInit(65536, newInitContext);
            int i = newInitContext.flag;
            if ((i & 1) != 0) {
                int i2 = i & 2;
                newInitContext.thisArg = this;
                interceptable.invokeInitBody(65536, newInitContext);
                return;
            }
        }
        this.b = new ArrayList<>(20);
    }

    public static qc4 c() {
        InterceptResult invokeV;
        Interceptable interceptable = $ic;
        if (interceptable == null || (invokeV = interceptable.invokeV(65537, null)) == null) {
            if (c == null) {
                synchronized (qc4.class) {
                    if (c == null) {
                        c = new qc4();
                    }
                }
            }
            return c;
        }
        return (qc4) invokeV.objValue;
    }

    public synchronized void b() {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeV(Constants.METHOD_GET_CONTACTER_INFO_FOR_SESSION, this) == null) {
            synchronized (this) {
                this.b.clear();
                this.a = 0;
            }
        }
    }

    public synchronized void a(pc4 pc4Var) {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeL(1048576, this, pc4Var) == null) {
            synchronized (this) {
                if (pc4Var == null) {
                    return;
                }
                if (this.b.size() < 20) {
                    this.b.add(pc4Var);
                } else {
                    this.a++;
                }
            }
        }
    }

    public synchronized JSONObject d() {
        InterceptResult invokeV;
        Interceptable interceptable = $ic;
        if (interceptable == null || (invokeV = interceptable.invokeV(Constants.METHOD_SEND_USER_MSG, this)) == null) {
            synchronized (this) {
                int size = this.b.size();
                if (size == 0) {
                    return null;
                }
                JSONObject jSONObject = new JSONObject();
                try {
                    jSONObject.put("dropcnt", this.a);
                    jSONObject.put("errorcnt", size);
                    JSONArray jSONArray = new JSONArray();
                    jSONObject.put("errors", jSONArray);
                    Iterator<pc4> it = this.b.iterator();
                    while (it.hasNext()) {
                        jSONArray.put(it.next().a());
                    }
                } catch (JSONException unused) {
                }
                this.b.clear();
                return jSONObject;
            }
        }
        return (JSONObject) invokeV.objValue;
    }
}
