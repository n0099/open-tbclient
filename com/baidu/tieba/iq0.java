package com.baidu.tieba;

import androidx.annotation.NonNull;
import com.baidu.pyramid.runtime.service.ServiceReference;
import com.baidu.titan.sdk.runtime.FieldHolder;
import com.baidu.titan.sdk.runtime.InitContext;
import com.baidu.titan.sdk.runtime.Interceptable;
import com.baidu.titan.sdk.runtime.TitanRuntime;
/* loaded from: classes6.dex */
public interface iq0 {
    public static final ServiceReference a = new ServiceReference("nad.business", "rewardVideoLpTaskCenter");
    public static final iq0 b = new a();

    /* loaded from: classes6.dex */
    public interface b {
        void a(aq0 aq0Var);

        void onFail(Exception exc);
    }

    void a(@NonNull js0 js0Var, @NonNull ct0 ct0Var, @NonNull b bVar);

    /* loaded from: classes6.dex */
    public class a implements iq0 {
        public static /* synthetic */ Interceptable $ic;
        public transient /* synthetic */ FieldHolder $fh;

        @Override // com.baidu.tieba.iq0
        public void a(@NonNull js0 js0Var, @NonNull ct0 ct0Var, @NonNull b bVar) {
            Interceptable interceptable = $ic;
            if (interceptable == null || interceptable.invokeLLL(1048576, this, js0Var, ct0Var, bVar) == null) {
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
