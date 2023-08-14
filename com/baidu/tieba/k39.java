package com.baidu.tieba;

import android.content.Context;
import androidx.annotation.NonNull;
import androidx.annotation.Nullable;
import com.baidu.android.imsdk.internal.Constants;
import com.baidu.searchbox.live.interfaces.service.bd.LiveYYRtcLoadService;
import com.baidu.searchbox.live.interfaces.yy.IYYLiveNPSPlugin;
import com.baidu.searchbox.live.interfaces.yy.YYEnvResultCallback;
import com.baidu.searchbox.live.nps.LiveYYPluginManager;
import com.baidu.titan.sdk.runtime.FieldHolder;
import com.baidu.titan.sdk.runtime.InitContext;
import com.baidu.titan.sdk.runtime.InterceptResult;
import com.baidu.titan.sdk.runtime.Interceptable;
import com.baidu.titan.sdk.runtime.TitanRuntime;
/* loaded from: classes6.dex */
public class k39 implements LiveYYRtcLoadService {
    public static /* synthetic */ Interceptable $ic;
    public transient /* synthetic */ FieldHolder $fh;

    /* loaded from: classes6.dex */
    public class a implements YYEnvResultCallback {
        public static /* synthetic */ Interceptable $ic;
        public transient /* synthetic */ FieldHolder $fh;
        public final /* synthetic */ LiveYYRtcLoadService.ILiveThunderLibDownloadStatusCallBack a;

        public a(k39 k39Var, LiveYYRtcLoadService.ILiveThunderLibDownloadStatusCallBack iLiveThunderLibDownloadStatusCallBack) {
            Interceptable interceptable = $ic;
            if (interceptable != null) {
                InitContext newInitContext = TitanRuntime.newInitContext();
                newInitContext.initArgs = r2;
                Object[] objArr = {k39Var, iLiveThunderLibDownloadStatusCallBack};
                interceptable.invokeUnInit(65536, newInitContext);
                int i = newInitContext.flag;
                if ((i & 1) != 0) {
                    int i2 = i & 2;
                    newInitContext.thisArg = this;
                    interceptable.invokeInitBody(65536, newInitContext);
                    return;
                }
            }
            this.a = iLiveThunderLibDownloadStatusCallBack;
        }

        @Override // com.baidu.searchbox.live.interfaces.yy.YYEnvResultCallback
        public void onFail(int i, String str) {
            LiveYYRtcLoadService.ILiveThunderLibDownloadStatusCallBack iLiveThunderLibDownloadStatusCallBack;
            Interceptable interceptable = $ic;
            if ((interceptable == null || interceptable.invokeIL(1048576, this, i, str) == null) && (iLiveThunderLibDownloadStatusCallBack = this.a) != null) {
                iLiveThunderLibDownloadStatusCallBack.onLibDownloadFailed();
            }
        }

        @Override // com.baidu.searchbox.live.interfaces.yy.YYEnvResultCallback
        public void onSuccess() {
            LiveYYRtcLoadService.ILiveThunderLibDownloadStatusCallBack iLiveThunderLibDownloadStatusCallBack;
            Interceptable interceptable = $ic;
            if ((interceptable == null || interceptable.invokeV(Constants.METHOD_GET_CONTACTER_INFO_FOR_SESSION, this) == null) && (iLiveThunderLibDownloadStatusCallBack = this.a) != null) {
                iLiveThunderLibDownloadStatusCallBack.onLibDownloadSuccess();
            }
        }
    }

    public k39() {
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

    @Override // com.baidu.searchbox.live.interfaces.service.bd.LiveYYRtcLoadService
    public boolean isLibReady(@NonNull Context context, @Nullable String str, @Nullable LiveYYRtcLoadService.ILiveThunderLibDownloadStatusCallBack iLiveThunderLibDownloadStatusCallBack) {
        InterceptResult invokeLLL;
        Interceptable interceptable = $ic;
        if (interceptable == null || (invokeLLL = interceptable.invokeLLL(1048576, this, context, str, iLiveThunderLibDownloadStatusCallBack)) == null) {
            LiveYYPluginManager.getInstance().prepareYYEnv(context, IYYLiveNPSPlugin.YY_ENV_CREATE_LIVE, new a(this, iLiveThunderLibDownloadStatusCallBack));
            return true;
        }
        return invokeLLL.booleanValue;
    }
}
