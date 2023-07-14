package com.baidu.tieba;

import com.baidu.titan.sdk.runtime.FieldHolder;
import com.baidu.titan.sdk.runtime.InitContext;
import com.baidu.titan.sdk.runtime.Interceptable;
import com.baidu.titan.sdk.runtime.TitanRuntime;
import java.util.Map;
/* loaded from: classes8.dex */
public final class t5b {
    public static /* synthetic */ Interceptable $ic;
    public transient /* synthetic */ FieldHolder $fh;

    /* loaded from: classes8.dex */
    public static class a extends z5b {
        public static /* synthetic */ Interceptable $ic;
        public transient /* synthetic */ FieldHolder $fh;
        public final /* synthetic */ Map a;
        public final /* synthetic */ com.baidu.ubs.analytics.a.a b;
        public final /* synthetic */ String c;
        public final /* synthetic */ String d;

        public a(Map map, com.baidu.ubs.analytics.a.a aVar, String str, String str2) {
            Interceptable interceptable = $ic;
            if (interceptable != null) {
                InitContext newInitContext = TitanRuntime.newInitContext();
                newInitContext.initArgs = r2;
                Object[] objArr = {map, aVar, str, str2};
                interceptable.invokeUnInit(65536, newInitContext);
                int i = newInitContext.flag;
                if ((i & 1) != 0) {
                    int i2 = i & 2;
                    newInitContext.thisArg = this;
                    interceptable.invokeInitBody(65536, newInitContext);
                    return;
                }
            }
            this.a = map;
            this.b = aVar;
            this.c = str;
            this.d = str2;
        }

        @Override // com.baidu.tieba.z5b
        public final void a() {
            String str;
            Interceptable interceptable = $ic;
            if (interceptable == null || interceptable.invokeV(1048576, this) == null) {
                if (this.a != null) {
                    StringBuffer stringBuffer = new StringBuffer();
                    stringBuffer.append("{");
                    for (Map.Entry entry : this.a.entrySet()) {
                        stringBuffer.append("\"");
                        stringBuffer.append(entry.getKey());
                        stringBuffer.append("\":\"");
                        stringBuffer.append(entry.getValue().toString().replace("\"", "\\\""));
                        stringBuffer.append("\",");
                    }
                    StringBuffer stringBuffer2 = new StringBuffer(stringBuffer.subSequence(0, stringBuffer.length() - 1));
                    stringBuffer2.append("}");
                    this.b.w(stringBuffer2.toString());
                }
                try {
                    this.b.x(w5b.e().I());
                    this.b.u(String.valueOf(System.currentTimeMillis()));
                    this.b.t(this.c);
                    com.baidu.ubs.analytics.a.a aVar = this.b;
                    if (this.d == null) {
                        str = "";
                    } else {
                        str = this.d;
                    }
                    aVar.s(str);
                    new x4b().c(this.b);
                } catch (Exception e) {
                    if (e.getMessage() != null) {
                        x5b.b(e.getMessage());
                    }
                }
            }
        }
    }

    public static void a(String str, String str2, String str3, Map<String, String> map) {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeLLLL(65536, null, str, str2, str3, map) == null) {
            com.baidu.ubs.analytics.a.a aVar = new com.baidu.ubs.analytics.a.a();
            aVar.v(str);
            y5b.c(new a(map, aVar, str2, str3));
        }
    }
}
