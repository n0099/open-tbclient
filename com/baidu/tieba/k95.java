package com.baidu.tieba;

import com.baidu.adp.lib.safe.JavaTypesHelper;
import com.baidu.android.imsdk.internal.Constants;
import com.baidu.searchbox.download.center.clearcache.DiskUpdateListener;
import com.baidu.tbadk.core.atomData.ShareDialogConfig;
import com.baidu.titan.sdk.runtime.ClassClinitInterceptable;
import com.baidu.titan.sdk.runtime.ClassClinitInterceptorStorage;
import com.baidu.titan.sdk.runtime.FieldHolder;
import com.baidu.titan.sdk.runtime.InitContext;
import com.baidu.titan.sdk.runtime.InterceptResult;
import com.baidu.titan.sdk.runtime.Interceptable;
import com.baidu.titan.sdk.runtime.TitanRuntime;
import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map;
import org.json.JSONObject;
/* loaded from: classes7.dex */
public class k95 {
    public static /* synthetic */ Interceptable $ic;
    public static final Map<ShareDialogConfig.From, Integer> e;
    public transient /* synthetic */ FieldHolder $fh;
    public int a;
    public int b;
    public String c;
    public List<Integer> d;

    static {
        InterceptResult invokeClinit;
        ClassClinitInterceptable classClinitInterceptable = ClassClinitInterceptorStorage.$ic;
        if (classClinitInterceptable != null && (invokeClinit = classClinitInterceptable.invokeClinit(1947867938, "Lcom/baidu/tieba/k95;")) != null) {
            Interceptable interceptable = invokeClinit.interceptor;
            if (interceptable != null) {
                $ic = interceptable;
            }
            if ((invokeClinit.flags & 1) != 0) {
                classClinitInterceptable.invokePostClinit(1947867938, "Lcom/baidu/tieba/k95;");
                return;
            }
        }
        HashMap hashMap = new HashMap();
        e = hashMap;
        hashMap.put(ShareDialogConfig.From.Recommend, 1);
        e.put(ShareDialogConfig.From.Concern, 2);
        e.put(ShareDialogConfig.From.PB, 3);
        e.put(ShareDialogConfig.From.FRS, 4);
        e.put(ShareDialogConfig.From.PersonPolymeric, 5);
        e.put(ShareDialogConfig.From.VideoMiddlePageHorizontal, 6);
        e.put(ShareDialogConfig.From.VideoMiddlePageVertical, 7);
        e.put(ShareDialogConfig.From.HomeVideoTab, 8);
        e.put(ShareDialogConfig.From.HomeGameTab, 9);
    }

    public k95() {
        Interceptable interceptable = $ic;
        if (interceptable != null) {
            InitContext newInitContext = TitanRuntime.newInitContext();
            interceptable.invokeUnInit(65537, newInitContext);
            int i = newInitContext.flag;
            if ((i & 1) != 0) {
                int i2 = i & 2;
                newInitContext.thisArg = this;
                interceptable.invokeInitBody(65537, newInitContext);
            }
        }
    }

    public String a() {
        InterceptResult invokeV;
        Interceptable interceptable = $ic;
        if (interceptable == null || (invokeV = interceptable.invokeV(1048576, this)) == null) {
            return this.c;
        }
        return (String) invokeV.objValue;
    }

    public boolean b() {
        InterceptResult invokeV;
        Interceptable interceptable = $ic;
        if (interceptable == null || (invokeV = interceptable.invokeV(Constants.METHOD_GET_CONTACTER_INFO_FOR_SESSION, this)) == null) {
            if (System.currentTimeMillis() / 1000 >= this.a && System.currentTimeMillis() / 1000 <= this.b) {
                return true;
            }
            return false;
        }
        return invokeV.booleanValue;
    }

    public boolean c(ShareDialogConfig.From from) {
        InterceptResult invokeL;
        Integer num;
        Interceptable interceptable = $ic;
        if (interceptable == null || (invokeL = interceptable.invokeL(Constants.METHOD_SEND_USER_MSG, this, from)) == null) {
            if (this.d == null || (num = e.get(from)) == null || !this.d.contains(num)) {
                return false;
            }
            return true;
        }
        return invokeL.booleanValue;
    }

    public void d(JSONObject jSONObject) {
        Interceptable interceptable = $ic;
        if ((interceptable != null && interceptable.invokeL(1048579, this, jSONObject) != null) || jSONObject == null) {
            return;
        }
        this.a = jSONObject.optInt(DiskUpdateListener.BEGIN_TIME);
        this.b = jSONObject.optInt("end_time");
        this.c = jSONObject.optString("text");
        e(jSONObject.optString("page_list"));
    }

    public final void e(String str) {
        String[] split;
        Interceptable interceptable = $ic;
        if ((interceptable != null && interceptable.invokeL(1048580, this, str) != null) || rd.isEmpty(str) || (split = str.split(",")) == null) {
            return;
        }
        for (String str2 : split) {
            int i = JavaTypesHelper.toInt(str2, -1);
            if (i != -1) {
                if (this.d == null) {
                    this.d = new ArrayList();
                }
                this.d.add(Integer.valueOf(i));
            }
        }
    }
}
