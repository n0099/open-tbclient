package com.baidu.tts;

import com.baidu.searchbox.ui.animview.praise.ComboPraiseManager;
import com.baidu.titan.sdk.runtime.FieldHolder;
import com.baidu.titan.sdk.runtime.InitContext;
import com.baidu.titan.sdk.runtime.InterceptResult;
import com.baidu.titan.sdk.runtime.Interceptable;
import com.baidu.titan.sdk.runtime.TitanRuntime;
import com.baidu.webkit.internal.ETAG;
import java.util.LinkedHashMap;
import java.util.Map;
/* loaded from: classes9.dex */
public class g0 {
    public static /* synthetic */ Interceptable $ic;
    public transient /* synthetic */ FieldHolder $fh;
    public int a;
    public String b;
    public int c;
    public int d;
    public int e;
    public String f;
    public String g;
    public long h;
    public String i;
    public String j;
    public int k;
    public String l;
    public int m;
    public String n;
    public long o;
    public String p;

    public g0() {
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
        this.a = 0;
        this.e = -1;
        this.h = 0L;
        this.j = "";
        this.k = 0;
        this.m = 0;
        this.p = "{}";
    }

    public Map<String, Object> a() {
        InterceptResult invokeV;
        Interceptable interceptable = $ic;
        if (interceptable == null || (invokeV = interceptable.invokeV(1048576, this)) == null) {
            LinkedHashMap linkedHashMap = new LinkedHashMap();
            linkedHashMap.put("index", Integer.valueOf(this.c));
            linkedHashMap.put(ComboPraiseManager.PRAISE_SOURCE_PREFIX_HN_SN, this.n);
            linkedHashMap.put("error_code", Integer.valueOf(this.m));
            linkedHashMap.put("sub_error_code", Integer.valueOf(this.a));
            linkedHashMap.put("error_des", this.j);
            linkedHashMap.put("tts_mode", Integer.valueOf(this.d));
            linkedHashMap.put("speaker", this.l);
            linkedHashMap.put("timestamp", Long.valueOf(this.o));
            linkedHashMap.put("time_interval", Long.valueOf(this.h));
            linkedHashMap.put("net_type", this.b);
            linkedHashMap.put("pid", Integer.valueOf(this.e));
            linkedHashMap.put("ttsresult", Integer.valueOf(this.k));
            linkedHashMap.put("speech_info", this.f);
            linkedHashMap.put("phone_model", this.i);
            linkedHashMap.put("cityid", this.g);
            linkedHashMap.put(ETAG.KEY_EXTENSION, this.p);
            return linkedHashMap;
        }
        return (Map) invokeV.objValue;
    }
}
