package com.baidu.tts;

import android.util.Log;
import com.baidu.titan.sdk.runtime.FieldHolder;
import com.baidu.titan.sdk.runtime.InitContext;
import com.baidu.titan.sdk.runtime.Interceptable;
import com.baidu.titan.sdk.runtime.TitanRuntime;
import java.io.File;
/* loaded from: classes9.dex */
public class a0 implements v {
    public static /* synthetic */ Interceptable $ic;
    public transient /* synthetic */ FieldHolder $fh;
    public File a;
    public u b;
    public z c;
    public b0 d;

    public a0() {
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
        this.c = new z(this);
        this.d = new b0(this);
        this.b = this.c;
    }

    @Override // com.baidu.tts.v
    public void a(Object obj, Object obj2, Object obj3) {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeLLL(1048576, this, obj, obj2, obj3) == null) {
            int a = this.b.a((w) obj);
            if (a < 0) {
                Log.e("StorageLoggerHandler", "write log failed! ret=" + a);
            }
        }
    }
}
