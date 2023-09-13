package com.baidu.tts;

import com.baidu.titan.sdk.runtime.FieldHolder;
import com.baidu.titan.sdk.runtime.InitContext;
import com.baidu.titan.sdk.runtime.InterceptResult;
import com.baidu.titan.sdk.runtime.Interceptable;
import com.baidu.titan.sdk.runtime.TitanRuntime;
import com.baidu.tts.chainofresponsibility.logger.LoggerProxy;
/* loaded from: classes9.dex */
public class t1 extends s1<t1> {
    public static /* synthetic */ Interceptable $ic;
    public transient /* synthetic */ FieldHolder $fh;
    public String h;
    public String i;
    public String j;
    public String k;
    public String l;
    public String m;
    public String n;
    public String o;
    public String p;
    public String q;
    public String r;
    public String s;
    public float t;
    public String u;
    public String v;
    public boolean w;
    public String x;
    public final String y;
    public float z;

    public t1(String str) {
        Interceptable interceptable = $ic;
        if (interceptable != null) {
            InitContext newInitContext = TitanRuntime.newInitContext();
            newInitContext.initArgs = r2;
            Object[] objArr = {str};
            interceptable.invokeUnInit(65536, newInitContext);
            int i = newInitContext.flag;
            if ((i & 1) != 0) {
                int i2 = i & 2;
                newInitContext.thisArg = this;
                interceptable.invokeInitBody(65536, newInitContext);
                return;
            }
        }
        this.h = "1";
        this.t = 5.0f;
        this.u = "1";
        this.v = "0";
        this.z = 0.2f;
        this.y = w0.a("OfflineSynthesizerParams", str);
    }

    public long b() {
        InterceptResult invokeV;
        Interceptable interceptable = $ic;
        if (interceptable == null || (invokeV = interceptable.invokeV(1048576, this)) == null) {
            try {
                return Long.parseLong(this.v);
            } catch (Exception e) {
                String str = this.y;
                LoggerProxy.d(str, "parseLong exception = " + e.getMessage());
                return 0L;
            }
        }
        return invokeV.longValue;
    }
}
