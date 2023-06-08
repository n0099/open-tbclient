package com.baidu.tieba;

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
/* loaded from: classes8.dex */
public class vd5 {
    public static /* synthetic */ Interceptable $ic;
    public static final Map<ShareDialogConfig.From, Integer> f;
    public transient /* synthetic */ FieldHolder $fh;
    public int a;
    public int b;
    public String c;
    public int d;
    public List<Integer> e;

    static {
        InterceptResult invokeClinit;
        ClassClinitInterceptable classClinitInterceptable = ClassClinitInterceptorStorage.$ic;
        if (classClinitInterceptable != null && (invokeClinit = classClinitInterceptable.invokeClinit(1948236962, "Lcom/baidu/tieba/vd5;")) != null) {
            Interceptable interceptable = invokeClinit.interceptor;
            if (interceptable != null) {
                $ic = interceptable;
            }
            if ((invokeClinit.flags & 1) != 0) {
                classClinitInterceptable.invokePostClinit(1948236962, "Lcom/baidu/tieba/vd5;");
                return;
            }
        }
        HashMap hashMap = new HashMap();
        f = hashMap;
        hashMap.put(ShareDialogConfig.From.Recommend, 1);
        f.put(ShareDialogConfig.From.Concern, 2);
        f.put(ShareDialogConfig.From.PB, 3);
        f.put(ShareDialogConfig.From.FRS, 4);
        f.put(ShareDialogConfig.From.PersonPolymeric, 5);
        f.put(ShareDialogConfig.From.VideoMiddlePageHorizontal, 6);
        f.put(ShareDialogConfig.From.VideoMiddlePageVertical, 7);
        f.put(ShareDialogConfig.From.HomeVideoTab, 8);
        f.put(ShareDialogConfig.From.HomeGameTab, 9);
    }

    public vd5() {
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

    public int a() {
        InterceptResult invokeV;
        Interceptable interceptable = $ic;
        if (interceptable == null || (invokeV = interceptable.invokeV(1048576, this)) == null) {
            return this.d;
        }
        return invokeV.intValue;
    }

    public String b() {
        InterceptResult invokeV;
        Interceptable interceptable = $ic;
        if (interceptable == null || (invokeV = interceptable.invokeV(Constants.METHOD_GET_CONTACTER_INFO_FOR_SESSION, this)) == null) {
            return this.c;
        }
        return (String) invokeV.objValue;
    }

    public boolean c() {
        InterceptResult invokeV;
        Interceptable interceptable = $ic;
        if (interceptable == null || (invokeV = interceptable.invokeV(Constants.METHOD_SEND_USER_MSG, this)) == null) {
            if (System.currentTimeMillis() / 1000 >= this.a && System.currentTimeMillis() / 1000 <= this.b) {
                return true;
            }
            return false;
        }
        return invokeV.booleanValue;
    }

    public boolean d(ShareDialogConfig.From from) {
        InterceptResult invokeL;
        Integer num;
        Interceptable interceptable = $ic;
        if (interceptable == null || (invokeL = interceptable.invokeL(1048579, this, from)) == null) {
            if (this.e == null || (num = f.get(from)) == null || !this.e.contains(num)) {
                return false;
            }
            return true;
        }
        return invokeL.booleanValue;
    }

    public void e(JSONObject jSONObject) {
        Interceptable interceptable = $ic;
        if ((interceptable != null && interceptable.invokeL(1048580, this, jSONObject) != null) || jSONObject == null) {
            return;
        }
        this.a = jSONObject.optInt(DiskUpdateListener.BEGIN_TIME);
        this.b = jSONObject.optInt("end_time");
        this.c = jSONObject.optString("text");
        this.d = jSONObject.optInt("icon_exp");
        f(jSONObject.optString("page_list"));
    }

    public final void f(String str) {
        String[] split;
        Interceptable interceptable = $ic;
        if ((interceptable != null && interceptable.invokeL(1048581, this, str) != null) || ui.isEmpty(str) || (split = str.split(",")) == null) {
            return;
        }
        for (String str2 : split) {
            int e = tg.e(str2, -1);
            if (e != -1) {
                if (this.e == null) {
                    this.e = new ArrayList();
                }
                this.e.add(Integer.valueOf(e));
            }
        }
    }
}
