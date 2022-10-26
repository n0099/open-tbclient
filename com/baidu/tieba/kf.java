package com.baidu.tieba;

import com.baidu.titan.sdk.runtime.FieldHolder;
import com.baidu.titan.sdk.runtime.InitContext;
import com.baidu.titan.sdk.runtime.Interceptable;
import com.baidu.titan.sdk.runtime.TitanRuntime;
/* loaded from: classes4.dex */
public interface kf {

    /* loaded from: classes4.dex */
    public interface a {
        void a(String str, Object obj);
    }

    /* loaded from: classes4.dex */
    public interface c extends kf {
        void b();

        jf c();

        String j();
    }

    void a(String str, Object obj);

    void d(String str);

    void e(String str, Object obj, long j);

    void f(String str, a aVar);

    void g(String str, Object obj);

    Object get(String str);

    b h(String str);

    void i(String str, Object obj, long j);

    void remove(String str);

    /* loaded from: classes4.dex */
    public class b {
        public static /* synthetic */ Interceptable $ic;
        public transient /* synthetic */ FieldHolder $fh;
        public String a;
        public Object b;
        public long c;

        public b() {
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
    }
}
