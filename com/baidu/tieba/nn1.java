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
/* loaded from: classes7.dex */
public class nn1 extends r23 {
    public static /* synthetic */ Interceptable $ic;
    public transient /* synthetic */ FieldHolder $fh;
    public lu3 c;
    public DownloadParams.SwanAppDownloadType d;

    @Override // com.baidu.tieba.p23
    public long a() {
        InterceptResult invokeV;
        Interceptable interceptable = $ic;
        if (interceptable == null || (invokeV = interceptable.invokeV(1048576, this)) == null) {
            return 0L;
        }
        return invokeV.longValue;
    }

    @Override // com.baidu.tieba.p23
    public boolean c() {
        InterceptResult invokeV;
        Interceptable interceptable = $ic;
        if (interceptable == null || (invokeV = interceptable.invokeV(Constants.METHOD_GET_CONTACTER_INFO_FOR_SESSION, this)) == null) {
            return false;
        }
        return invokeV.booleanValue;
    }

    public nn1(lu3 lu3Var, @NonNull DownloadParams.SwanAppDownloadType swanAppDownloadType) {
        Interceptable interceptable = $ic;
        if (interceptable != null) {
            InitContext newInitContext = TitanRuntime.newInitContext();
            newInitContext.initArgs = r2;
            Object[] objArr = {lu3Var, swanAppDownloadType};
            interceptable.invokeUnInit(65536, newInitContext);
            int i = newInitContext.flag;
            if ((i & 1) != 0) {
                int i2 = i & 2;
                newInitContext.thisArg = this;
                interceptable.invokeInitBody(65536, newInitContext);
                return;
            }
        }
        this.c = lu3Var;
        this.d = swanAppDownloadType;
    }

    /* JADX DEBUG: Method merged with bridge method */
    @Override // com.baidu.tieba.r23, com.baidu.tieba.p23
    public void onEvent(@NonNull n23 n23Var) {
        Bundle a;
        Interceptable interceptable = $ic;
        if ((interceptable == null || interceptable.invokeL(Constants.METHOD_SEND_USER_MSG, this, n23Var) == null) && (a = n23Var.a()) != null && this.c != null) {
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
