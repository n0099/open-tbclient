package com.baidu.tieba;

import com.baidu.titan.sdk.runtime.FieldHolder;
import com.baidu.titan.sdk.runtime.InitContext;
import com.baidu.titan.sdk.runtime.InterceptResult;
import com.baidu.titan.sdk.runtime.Interceptable;
import com.baidu.titan.sdk.runtime.TitanRuntime;
import com.yy.mobile.framework.revenuesdk.payapi.bean.PayWayInfo;
import java.util.List;
import tv.athena.revenue.api.pay.params.PayFlowType;
import tv.athena.revenue.payui.view.AbsViewEventHandler;
import tv.athena.revenue.payui.view.IYYPayAmountView;
import tv.athena.revenue.payui.view.PaySplitOrderViewSource;
import tv.athena.revenue.payui.view.WindowParams;
/* loaded from: classes7.dex */
public interface mac extends hac {

    /* loaded from: classes7.dex */
    public interface a {
        void a(w8c w8cVar);

        void b();

        void onRefreshViewFail(int i, String str);
    }

    void a();

    void setCallback(a aVar);

    /* loaded from: classes7.dex */
    public static class b {
        public static /* synthetic */ Interceptable $ic;
        public transient /* synthetic */ FieldHolder $fh;
        public w8c a;
        public WindowParams b;
        public PayFlowType c;
        public List<PayWayInfo> d;
        public String e;
        public IYYPayAmountView.ViewParams f;
        public AbsViewEventHandler g;
        public PaySplitOrderViewSource h;

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
                }
            }
        }

        public String toString() {
            InterceptResult invokeV;
            Interceptable interceptable = $ic;
            if (interceptable == null || (invokeV = interceptable.invokeV(1048576, this)) == null) {
                return "ViewParams{  source='" + this.h + "'  amount=" + this.a + ", payFlowType=" + this.c + ", bubbleActMsg=" + this.e + ", payWayInfoList=" + this.d + ", payAmountViewParams='" + this.f + "', windowParams='" + this.b + "', viewEventListener='" + this.g + "'}";
            }
            return (String) invokeV.objValue;
        }
    }
}
