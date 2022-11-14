package com.baidu.tieba;

import com.baidu.titan.sdk.runtime.FieldHolder;
import com.baidu.titan.sdk.runtime.InitContext;
import com.baidu.titan.sdk.runtime.Interceptable;
import com.baidu.titan.sdk.runtime.TitanRuntime;
/* loaded from: classes5.dex */
public interface nw2 {
    public static final nw2 a = new a();

    <T extends ip2<T>> void a(T t);

    /* loaded from: classes5.dex */
    public static class a implements nw2 {
        public static /* synthetic */ Interceptable $ic;
        public transient /* synthetic */ FieldHolder $fh;

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

        @Override // com.baidu.tieba.nw2
        public <T extends ip2<T>> void a(T t) {
            Interceptable interceptable = $ic;
            if (interceptable == null || interceptable.invokeL(1048576, this, t) == null) {
                t.x("rescue_refractory_period", 0L);
                t.x("suspend_delay_time", -1L);
                t.t("should_suspend_master_timer", false);
                t.t("should_suspend_all", false);
                t.t("should_suspend_slave_timer", false);
                t.t("should_suspend_web_view_timer", false);
                t.t("should_suspend_v8_timer", false);
            }
        }
    }
}
