package com.baidu.tieba;

import com.baidu.titan.sdk.runtime.FieldHolder;
import com.baidu.titan.sdk.runtime.InitContext;
import com.baidu.titan.sdk.runtime.Interceptable;
import com.baidu.titan.sdk.runtime.TitanRuntime;
/* loaded from: classes6.dex */
public interface uv2 {
    public static final uv2 a = new a();

    void a(po2 po2Var);

    /* loaded from: classes6.dex */
    public final class a implements uv2 {
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

        @Override // com.baidu.tieba.uv2
        public void a(po2 po2Var) {
            Interceptable interceptable = $ic;
            if (interceptable == null || interceptable.invokeL(1048576, this, po2Var) == null) {
                po2Var.x("rescue_refractory_period", 0L);
                po2Var.x("suspend_delay_time", -1L);
                po2Var.t("should_suspend_master_timer", false);
                po2Var.t("should_suspend_all", false);
                po2Var.t("should_suspend_slave_timer", false);
                po2Var.t("should_suspend_web_view_timer", false);
                po2Var.t("should_suspend_v8_timer", false);
            }
        }
    }
}
