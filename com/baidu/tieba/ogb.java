package com.baidu.tieba;

import android.content.Context;
import android.content.SharedPreferences;
import com.baidu.android.imsdk.internal.Constants;
import com.baidu.titan.sdk.runtime.FieldHolder;
import com.baidu.titan.sdk.runtime.InitContext;
import com.baidu.titan.sdk.runtime.InterceptResult;
import com.baidu.titan.sdk.runtime.Interceptable;
import com.baidu.titan.sdk.runtime.TitanRuntime;
import com.yy.sdk.crashreportbaidu.ReportInfo;
import java.io.IOException;
import java.util.ArrayList;
import java.util.List;
import java.util.Map;
/* loaded from: classes7.dex */
public class ogb<T extends ReportInfo> {
    public static /* synthetic */ Interceptable $ic;
    public transient /* synthetic */ FieldHolder $fh;
    public final SharedPreferences a;

    public ogb(Context context, String str) {
        Interceptable interceptable = $ic;
        if (interceptable != null) {
            InitContext newInitContext = TitanRuntime.newInitContext();
            newInitContext.initArgs = r2;
            Object[] objArr = {context, str};
            interceptable.invokeUnInit(65536, newInitContext);
            int i = newInitContext.flag;
            if ((i & 1) != 0) {
                int i2 = i & 2;
                newInitContext.thisArg = this;
                interceptable.invokeInitBody(65536, newInitContext);
                return;
            }
        }
        this.a = context.getSharedPreferences(str, 0);
    }

    public String a(T t) {
        InterceptResult invokeL;
        Interceptable interceptable = $ic;
        if (interceptable == null || (invokeL = interceptable.invokeL(1048576, this, t)) == null) {
            if (t == null) {
                return "anr info is null";
            }
            ngb.d("ReportDB", "add info: " + t.crashId);
            try {
                List<T> c = c();
                int size = c.size();
                SharedPreferences.Editor edit = this.a.edit();
                for (int i = 0; i <= size - 30; i++) {
                    T t2 = c.get(i);
                    t2.clearFiles(t2.fileList);
                    edit.remove(t2.crashId);
                }
                edit.putString(t.crashId, t.serialize()).commit();
                return null;
            } catch (IOException e) {
                String C = qgb.C(e);
                ngb.c("ReportDB", C, e);
                return C;
            }
        }
        return (String) invokeL.objValue;
    }

    public void b() {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeV(Constants.METHOD_GET_CONTACTER_INFO_FOR_SESSION, this) == null) {
            this.a.edit().clear().commit();
        }
    }

    public List<T> c() {
        InterceptResult invokeV;
        Interceptable interceptable = $ic;
        if (interceptable == null || (invokeV = interceptable.invokeV(Constants.METHOD_SEND_USER_MSG, this)) == null) {
            ArrayList arrayList = new ArrayList();
            Map<String, ?> all = this.a.getAll();
            if (all != null && !all.isEmpty()) {
                for (Map.Entry<String, ?> entry : all.entrySet()) {
                    try {
                        arrayList.add((ReportInfo) ReportInfo.deserialize((String) entry.getValue()));
                        ngb.d("ReportDB", String.format("read info:%s", entry.getKey()));
                    } catch (Exception e) {
                        delete(entry.getKey());
                        ngb.b("ReportDB", String.format("read info error:[%s] %s", entry.getKey(), qgb.C(e)));
                    }
                }
                ngb.d("ReportDB", "get all size: " + arrayList.size());
            }
            return arrayList;
        }
        return (List) invokeV.objValue;
    }

    public void delete(String str) {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeL(1048579, this, str) == null) {
            ngb.d("ReportDB", "delete info: " + str);
            if (this.a.contains(str)) {
                this.a.edit().remove(str).commit();
            }
        }
    }
}
