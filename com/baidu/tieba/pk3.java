package com.baidu.tieba;

import android.os.Bundle;
import androidx.annotation.NonNull;
import com.baidu.searchbox.process.ipc.util.ProcessUtils;
import com.baidu.storage.swankv.AshmemFileDescriptor;
import com.baidu.titan.sdk.runtime.FieldHolder;
import com.baidu.titan.sdk.runtime.InitContext;
import com.baidu.titan.sdk.runtime.Interceptable;
import com.baidu.titan.sdk.runtime.TitanRuntime;
/* loaded from: classes7.dex */
public class pk3 extends z73 {
    public static /* synthetic */ Interceptable $ic;
    public transient /* synthetic */ FieldHolder $fh;

    public pk3() {
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

    public static void e(@NonNull AshmemFileDescriptor ashmemFileDescriptor) {
        Interceptable interceptable = $ic;
        if ((interceptable != null && interceptable.invokeL(65537, null, ashmemFileDescriptor) != null) || !ProcessUtils.isMainProcess()) {
            return;
        }
        Bundle bundle = new Bundle();
        bundle.setClassLoader(AshmemFileDescriptor.class.getClassLoader());
        bundle.putParcelable("result", ashmemFileDescriptor);
        t83.a(bundle, pk3.class);
    }

    @Override // com.baidu.tieba.z73
    public void b(@NonNull Bundle bundle) {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeL(1048576, this, bundle) == null) {
            bundle.setClassLoader(AshmemFileDescriptor.class.getClassLoader());
            AshmemFileDescriptor ashmemFileDescriptor = (AshmemFileDescriptor) bundle.getParcelable("result");
            if (ashmemFileDescriptor != null) {
                tk3.b(ashmemFileDescriptor);
            }
        }
    }
}
