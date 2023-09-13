package com.baidu.tieba;

import androidx.annotation.NonNull;
import com.baidu.pyramid.runtime.service.ServiceReference;
import com.baidu.titan.sdk.runtime.FieldHolder;
import com.baidu.titan.sdk.runtime.InitContext;
import com.baidu.titan.sdk.runtime.Interceptable;
import com.baidu.titan.sdk.runtime.TitanRuntime;
/* loaded from: classes7.dex */
public interface mp0 {
    public static final ServiceReference a = new ServiceReference("nad.business", "rewardVideoLpTaskCenter");
    public static final mp0 b = new a();

    /* loaded from: classes7.dex */
    public interface b {
        void a(cp0 cp0Var);

        void onFail(Exception exc);
    }

    void a(@NonNull tr0 tr0Var, @NonNull ms0 ms0Var, @NonNull b bVar);

    /* loaded from: classes7.dex */
    public class a implements mp0 {
        public static /* synthetic */ Interceptable $ic;
        public transient /* synthetic */ FieldHolder $fh;

        @Override // com.baidu.tieba.mp0
        public void a(@NonNull tr0 tr0Var, @NonNull ms0 ms0Var, @NonNull b bVar) {
            Interceptable interceptable = $ic;
            if (interceptable == null || interceptable.invokeLLL(1048576, this, tr0Var, ms0Var, bVar) == null) {
            }
        }

        public a() {
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
