package com.baidu.tieba;

import androidx.annotation.NonNull;
import com.baidu.pyramid.runtime.service.ServiceReference;
import com.baidu.titan.sdk.runtime.FieldHolder;
import com.baidu.titan.sdk.runtime.InitContext;
import com.baidu.titan.sdk.runtime.Interceptable;
import com.baidu.titan.sdk.runtime.TitanRuntime;
/* loaded from: classes8.dex */
public interface xp0 {
    public static final ServiceReference a = new ServiceReference("nad.business", "rewardVideoLpTaskCenter");
    public static final xp0 b = new a();

    /* loaded from: classes8.dex */
    public interface b {
        void a(qp0 qp0Var);

        void onFail(Exception exc);
    }

    void a(@NonNull yr0 yr0Var, @NonNull os0 os0Var, @NonNull b bVar);

    /* loaded from: classes8.dex */
    public static class a implements xp0 {
        public static /* synthetic */ Interceptable $ic;
        public transient /* synthetic */ FieldHolder $fh;

        @Override // com.baidu.tieba.xp0
        public void a(@NonNull yr0 yr0Var, @NonNull os0 os0Var, @NonNull b bVar) {
            Interceptable interceptable = $ic;
            if (interceptable == null || interceptable.invokeLLL(1048576, this, yr0Var, os0Var, bVar) == null) {
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
