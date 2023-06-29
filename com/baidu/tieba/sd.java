package com.baidu.tieba;

import android.util.SparseArray;
import com.baidu.adp.lib.OrmObject.toolsystem.orm.object.OrmObject;
import com.baidu.titan.sdk.runtime.FieldHolder;
import com.baidu.titan.sdk.runtime.InitContext;
import com.baidu.titan.sdk.runtime.InterceptResult;
import com.baidu.titan.sdk.runtime.Interceptable;
import com.baidu.titan.sdk.runtime.TitanRuntime;
import java.lang.reflect.Type;
import java.util.Iterator;
import java.util.Map;
import org.json.JSONObject;
/* loaded from: classes7.dex */
public class sd implements pd {
    public static /* synthetic */ Interceptable $ic;
    public transient /* synthetic */ FieldHolder $fh;
    public JSONObject a;

    public sd(JSONObject jSONObject) {
        Interceptable interceptable = $ic;
        if (interceptable != null) {
            InitContext newInitContext = TitanRuntime.newInitContext();
            newInitContext.initArgs = r2;
            Object[] objArr = {jSONObject};
            interceptable.invokeUnInit(65536, newInitContext);
            int i = newInitContext.flag;
            if ((i & 1) != 0) {
                int i2 = i & 2;
                newInitContext.thisArg = this;
                interceptable.invokeInitBody(65536, newInitContext);
                return;
            }
        }
        this.a = jSONObject;
    }

    @Override // com.baidu.tieba.pd
    public Object a(fe feVar) {
        InterceptResult invokeL;
        Interceptable interceptable = $ic;
        if (interceptable == null || (invokeL = interceptable.invokeL(1048576, this, feVar)) == null) {
            Class<?> a = feVar.a();
            Type[] b = feVar.b();
            if (mc.e(a, Map.class)) {
                Map<String, Object> b2 = de.b(feVar, this.a.length());
                if (b2 != null) {
                    Iterator<String> keys = this.a.keys();
                    while (keys.hasNext()) {
                        String next = keys.next();
                        if (next instanceof String) {
                            String str = next;
                            Object a2 = je.a(this.a.opt(str)).a(new fe(b[1]));
                            if (a2 != null) {
                                b2.put(str, a2);
                            }
                        }
                    }
                }
                return b2;
            } else if (a == SparseArray.class) {
                SparseArray sparseArray = new SparseArray(this.a.length());
                Iterator<String> keys2 = this.a.keys();
                while (keys2.hasNext()) {
                    String next2 = keys2.next();
                    if (next2 instanceof String) {
                        String str2 = next2;
                        try {
                            int parseInt = Integer.parseInt(str2);
                            Object a3 = je.a(this.a.opt(String.valueOf(str2))).a(new fe(b[0]));
                            if (a3 != null) {
                                sparseArray.put(parseInt, a3);
                            }
                        } catch (NumberFormatException e) {
                            e.printStackTrace();
                        }
                    }
                }
                return sparseArray;
            } else if (mc.e(a, nc.class)) {
                return OrmObject.objectWithJson(this.a, a);
            } else {
                return null;
            }
        }
        return invokeL.objValue;
    }
}
