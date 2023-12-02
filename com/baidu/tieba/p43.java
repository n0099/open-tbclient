package com.baidu.tieba;

import android.os.Bundle;
import com.baidu.sapi2.activity.BaseActivity;
import com.baidu.searchbox.process.ipc.util.ProcessUtils;
import com.baidu.tieba.q43;
import com.baidu.titan.sdk.runtime.FieldHolder;
import com.baidu.titan.sdk.runtime.InitContext;
import com.baidu.titan.sdk.runtime.Interceptable;
import com.baidu.titan.sdk.runtime.TitanRuntime;
import kotlin.jvm.internal.Intrinsics;
/* loaded from: classes7.dex */
public final class p43 extends k23 {
    public static /* synthetic */ Interceptable $ic;
    public transient /* synthetic */ FieldHolder $fh;

    public p43() {
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

    @Override // com.baidu.tieba.k23
    public void b(Bundle params) {
        q43.a b;
        q43.a b2;
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeL(1048576, this, params) == null) {
            Intrinsics.checkNotNullParameter(params, "params");
            String string = params.getString(BaseActivity.EXTRA_PARAM_THIRD_VERIFY_OPEN_ID);
            String string2 = params.getString("swanId");
            String string3 = params.getString(BaseActivity.EXTRA_PARAM_THIRD_VERIFY_APP_ID);
            String string4 = params.getString("hostName");
            if (ProcessUtils.isMainProcess()) {
                if (string != null && (b2 = q43.c.b()) != null) {
                    b2.a(string, string3, string4);
                }
                if (string2 != null && (b = q43.c.b()) != null) {
                    b.b(string2, string3, string4);
                }
            }
        }
    }
}
