package com.baidu.tts;

import android.content.SharedPreferences;
import com.baidu.titan.sdk.runtime.FieldHolder;
import com.baidu.titan.sdk.runtime.InitContext;
import com.baidu.titan.sdk.runtime.Interceptable;
import com.baidu.titan.sdk.runtime.TitanRuntime;
import com.baidu.tts.f0;
/* loaded from: classes9.dex */
public class e0 implements f0.b {
    public static /* synthetic */ Interceptable $ic;
    public transient /* synthetic */ FieldHolder $fh;
    public final /* synthetic */ f0.a a;

    public e0(f0.a aVar) {
        Interceptable interceptable = $ic;
        if (interceptable != null) {
            InitContext newInitContext = TitanRuntime.newInitContext();
            newInitContext.initArgs = r2;
            Object[] objArr = {aVar};
            interceptable.invokeUnInit(65536, newInitContext);
            int i = newInitContext.flag;
            if ((i & 1) != 0) {
                int i2 = i & 2;
                newInitContext.thisArg = this;
                interceptable.invokeInitBody(65536, newInitContext);
                return;
            }
        }
        this.a = aVar;
    }

    public void a(boolean z) throws Exception {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeZ(1048576, this, z) == null) {
            SharedPreferences.Editor edit = b1.d().b().getSharedPreferences(this.a.b, 0).edit();
            edit.putBoolean("get_log_switch_status", z);
            edit.commit();
        }
    }
}
