package com.baidu.tieba;

import com.baidu.android.imsdk.internal.Constants;
import com.baidu.mobads.sdk.api.IBasicCPUData;
import com.baidu.titan.sdk.runtime.FieldHolder;
import com.baidu.titan.sdk.runtime.InitContext;
import com.baidu.titan.sdk.runtime.Interceptable;
import com.baidu.titan.sdk.runtime.TitanRuntime;
import com.fun.ad.sdk.internal.api.utils.LogPrinter;
/* loaded from: classes8.dex */
public class r3c implements IBasicCPUData.CpuNativeStatusCB {
    public static /* synthetic */ Interceptable $ic;
    public transient /* synthetic */ FieldHolder $fh;
    public final /* synthetic */ IBasicCPUData a;
    public final /* synthetic */ q3c b;

    public r3c(q3c q3cVar, IBasicCPUData iBasicCPUData) {
        Interceptable interceptable = $ic;
        if (interceptable != null) {
            InitContext newInitContext = TitanRuntime.newInitContext();
            newInitContext.initArgs = r2;
            Object[] objArr = {q3cVar, iBasicCPUData};
            interceptable.invokeUnInit(65536, newInitContext);
            int i = newInitContext.flag;
            if ((i & 1) != 0) {
                int i2 = i & 2;
                newInitContext.thisArg = this;
                interceptable.invokeInitBody(65536, newInitContext);
                return;
            }
        }
        this.b = q3cVar;
        this.a = iBasicCPUData;
    }

    @Override // com.baidu.mobads.sdk.api.IBasicCPUData.CpuNativeStatusCB
    public void onAdDownloadWindowShow() {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeV(1048576, this) == null) {
        }
    }

    @Override // com.baidu.mobads.sdk.api.IBasicCPUData.CpuNativeStatusCB
    public void onAdStatusChanged(String str, int i) {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeLI(Constants.METHOD_GET_CONTACTER_INFO_FOR_SESSION, this, str, i) == null) {
        }
    }

    @Override // com.baidu.mobads.sdk.api.IBasicCPUData.CpuNativeStatusCB
    public void onPermissionClose() {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeV(1048579, this) == null) {
        }
    }

    @Override // com.baidu.mobads.sdk.api.IBasicCPUData.CpuNativeStatusCB
    public void onPermissionShow() {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeV(1048580, this) == null) {
        }
    }

    @Override // com.baidu.mobads.sdk.api.IBasicCPUData.CpuNativeStatusCB
    public void onPrivacyClick() {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeV(1048581, this) == null) {
        }
    }

    @Override // com.baidu.mobads.sdk.api.IBasicCPUData.CpuNativeStatusCB
    public void onPrivacyLpClose() {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeV(1048582, this) == null) {
        }
    }

    @Override // com.baidu.mobads.sdk.api.IBasicCPUData.CpuNativeStatusCB
    public void onNotifyPerformance(String str) {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeL(Constants.METHOD_SEND_USER_MSG, this, str) == null) {
            LogPrinter.d();
            if ("CLICK".equals(str)) {
                this.b.e.onAdClick(this.a);
            } else if ("IMPRESSION".equals(str)) {
                this.b.e.onAdShow(this.a);
            }
        }
    }
}
