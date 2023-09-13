package com.baidu.tieba;

import com.baidu.titan.sdk.runtime.FieldHolder;
import com.baidu.titan.sdk.runtime.InitContext;
import com.baidu.titan.sdk.runtime.InterceptResult;
import com.baidu.titan.sdk.runtime.Interceptable;
import com.baidu.titan.sdk.runtime.TitanRuntime;
import com.yy.mobile.framework.revenuesdk.payapi.bean.PayWayInfo;
import java.util.List;
import java.util.Map;
import tv.athena.revenue.api.pay.params.AppCustomExpand;
import tv.athena.revenue.api.pay.params.PayFlowType;
import tv.athena.revenue.payui.view.AbsViewEventHandler;
import tv.athena.revenue.payui.view.WindowParams;
/* loaded from: classes6.dex */
public interface jkc extends dkc, ckc {

    /* loaded from: classes6.dex */
    public interface a {
        void a(wic wicVar, sic sicVar, AppCustomExpand appCustomExpand);

        void b(wic wicVar, sic sicVar, AppCustomExpand appCustomExpand);

        void c(vic vicVar);

        void onRefreshViewFail(int i, String str);

        void toHelpCenterPage();
    }

    void a();

    boolean d();

    void setCallback(a aVar);

    /* loaded from: classes6.dex */
    public static class b {
        public static /* synthetic */ Interceptable $ic;
        public transient /* synthetic */ FieldHolder $fh;
        public List<PayWayInfo> a;
        public String b;
        public sic c;
        public AppCustomExpand d;
        public Map<String, String> e;
        public AbsViewEventHandler f;
        public PayFlowType g;
        public WindowParams h;
        public boolean i;
        public String j;

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
                    return;
                }
            }
            this.i = false;
        }

        public String toString() {
            InterceptResult invokeV;
            Interceptable interceptable = $ic;
            if (interceptable == null || (invokeV = interceptable.invokeV(1048576, this)) == null) {
                return "ViewParams{payAmount=" + this.c + ", payFlowType=" + this.g + ", showFaqPage=" + this.i + ", appCustomExpand=" + this.d + ", clientInfoExpand='" + this.e + "', windowParams='" + this.h + "', viewEventListener='" + this.f + "', bubbleActMsg='" + this.b + "', splitOrderScene='" + this.j + "'}";
            }
            return (String) invokeV.objValue;
        }
    }
}
