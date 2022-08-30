package com.baidu.tieba;

import android.text.TextUtils;
import com.baidu.adp.lib.Disk.ops.DiskFileOperate;
import com.baidu.android.imsdk.internal.Constants;
import com.baidu.titan.sdk.runtime.FieldHolder;
import com.baidu.titan.sdk.runtime.InitContext;
import com.baidu.titan.sdk.runtime.InterceptResult;
import com.baidu.titan.sdk.runtime.Interceptable;
import com.baidu.titan.sdk.runtime.TitanRuntime;
import org.json.JSONException;
import org.json.JSONObject;
/* loaded from: classes5.dex */
public class oh {
    public static /* synthetic */ Interceptable $ic;
    public transient /* synthetic */ FieldHolder $fh;
    public long a;
    public String b;

    public oh() {
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
        this.a = 0L;
        this.b = null;
    }

    public boolean a() {
        InterceptResult invokeV;
        Interceptable interceptable = $ic;
        if (interceptable == null || (invokeV = interceptable.invokeV(1048576, this)) == null) {
            bc bcVar = new bc("statisticConfig", "switchsConfig", DiskFileOperate.Action.READ);
            bcVar.setSdCard(false);
            bcVar.setOperateType(DiskFileOperate.OperateType.MUST_SUCCESS);
            wb.f().call(bcVar);
            String a = bcVar.isSuccess() ? bcVar.a() : null;
            if (TextUtils.isEmpty(a)) {
                return false;
            }
            try {
                JSONObject jSONObject = new JSONObject(a);
                this.a = jSONObject.getLong("time");
                this.b = jSONObject.getString("data");
                return true;
            } catch (JSONException e) {
                e.printStackTrace();
                return true;
            }
        }
        return invokeV.booleanValue;
    }

    public void b(String str) {
        Interceptable interceptable = $ic;
        if (!(interceptable == null || interceptable.invokeL(Constants.METHOD_GET_CONTACTER_INFO_FOR_SESSION, this, str) == null) || TextUtils.isEmpty(str)) {
            return;
        }
        long currentTimeMillis = System.currentTimeMillis();
        try {
            JSONObject jSONObject = new JSONObject();
            jSONObject.put("time", currentTimeMillis);
            jSONObject.put("data", str);
            bc bcVar = new bc("statisticConfig", "switchsConfig", DiskFileOperate.Action.WRITE_FORCE);
            bcVar.setSdCard(false);
            bcVar.b(jSONObject.toString());
            bcVar.setOperateType(DiskFileOperate.OperateType.MUST_SUCCESS);
            wb.f().call(bcVar);
        } catch (JSONException e) {
            e.printStackTrace();
        }
    }
}
