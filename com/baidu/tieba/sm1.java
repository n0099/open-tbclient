package com.baidu.tieba;

import android.os.Bundle;
import android.text.TextUtils;
import androidx.annotation.NonNull;
import com.baidu.android.imsdk.internal.Constants;
import com.baidu.swan.game.ad.downloader.model.DownloadParams;
import com.baidu.swan.game.ad.downloader.model.DownloadState;
import com.baidu.titan.sdk.runtime.FieldHolder;
import com.baidu.titan.sdk.runtime.InitContext;
import com.baidu.titan.sdk.runtime.InterceptResult;
import com.baidu.titan.sdk.runtime.Interceptable;
import com.baidu.titan.sdk.runtime.TitanRuntime;
/* loaded from: classes8.dex */
public class sm1 extends w13 {
    public static /* synthetic */ Interceptable $ic;
    public transient /* synthetic */ FieldHolder $fh;
    public qt3 c;
    public DownloadParams.SwanAppDownloadType d;

    @Override // com.baidu.tieba.u13
    public long a() {
        InterceptResult invokeV;
        Interceptable interceptable = $ic;
        if (interceptable == null || (invokeV = interceptable.invokeV(1048576, this)) == null) {
            return 0L;
        }
        return invokeV.longValue;
    }

    @Override // com.baidu.tieba.u13
    public boolean c() {
        InterceptResult invokeV;
        Interceptable interceptable = $ic;
        if (interceptable == null || (invokeV = interceptable.invokeV(Constants.METHOD_GET_CONTACTER_INFO_FOR_SESSION, this)) == null) {
            return false;
        }
        return invokeV.booleanValue;
    }

    public sm1(qt3 qt3Var, @NonNull DownloadParams.SwanAppDownloadType swanAppDownloadType) {
        Interceptable interceptable = $ic;
        if (interceptable != null) {
            InitContext newInitContext = TitanRuntime.newInitContext();
            newInitContext.initArgs = r2;
            Object[] objArr = {qt3Var, swanAppDownloadType};
            interceptable.invokeUnInit(65536, newInitContext);
            int i = newInitContext.flag;
            if ((i & 1) != 0) {
                int i2 = i & 2;
                newInitContext.thisArg = this;
                interceptable.invokeInitBody(65536, newInitContext);
                return;
            }
        }
        this.c = qt3Var;
        this.d = swanAppDownloadType;
    }

    /* JADX DEBUG: Method merged with bridge method */
    @Override // com.baidu.tieba.w13, com.baidu.tieba.u13
    public void onEvent(@NonNull s13 s13Var) {
        Bundle a;
        Interceptable interceptable = $ic;
        if ((interceptable == null || interceptable.invokeL(Constants.METHOD_SEND_USER_MSG, this, s13Var) == null) && (a = s13Var.a()) != null && this.c != null) {
            int i = a.getInt("state", DownloadState.NOT_START.value());
            int i2 = a.getInt("progress", 0);
            this.c.c(DownloadState.convert(i), i2);
            this.c.a(i2);
            String string = a.getString("packageName", "");
            if (!TextUtils.isEmpty(string)) {
                this.c.d(string);
            }
            if (this.d == DownloadParams.SwanAppDownloadType.TYPE_START_DOWNLOAD) {
                this.c.f(true);
            }
        }
    }
}
