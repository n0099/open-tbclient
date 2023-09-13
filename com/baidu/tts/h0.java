package com.baidu.tts;

import com.baidu.searchbox.ui.animview.praise.ComboPraiseManager;
import com.baidu.titan.sdk.runtime.FieldHolder;
import com.baidu.titan.sdk.runtime.InitContext;
import com.baidu.titan.sdk.runtime.InterceptResult;
import com.baidu.titan.sdk.runtime.Interceptable;
import com.baidu.titan.sdk.runtime.TitanRuntime;
import java.util.LinkedHashMap;
import java.util.Map;
import org.json.JSONArray;
/* loaded from: classes9.dex */
public class h0 {
    public static /* synthetic */ Interceptable $ic;
    public transient /* synthetic */ FieldHolder $fh;
    public int a;
    public int b;
    public String c;
    public int d;
    public String e;
    public long f;
    public long g;
    public JSONArray h;

    public h0() {
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

    public Map<String, Object> a() {
        InterceptResult invokeV;
        Interceptable interceptable = $ic;
        if (interceptable == null || (invokeV = interceptable.invokeV(1048576, this)) == null) {
            LinkedHashMap linkedHashMap = new LinkedHashMap();
            linkedHashMap.put("index", Integer.valueOf(this.b));
            String str = this.e;
            if (str == null) {
                str = "";
            }
            linkedHashMap.put(ComboPraiseManager.PRAISE_SOURCE_PREFIX_HN_SN, str);
            linkedHashMap.put("error_code", Integer.valueOf(this.d));
            linkedHashMap.put("sub_error_code", Integer.valueOf(this.a));
            linkedHashMap.put("error_des", this.c);
            linkedHashMap.put("time_online", Long.valueOf(this.f));
            linkedHashMap.put("time_offline", Long.valueOf(this.g));
            Object obj = this.h;
            if (obj == null) {
                obj = "{}";
            }
            linkedHashMap.put("speak_caton", obj);
            return linkedHashMap;
        }
        return (Map) invokeV.objValue;
    }
}
