package com.baidu.tieba.lc;

import android.content.Intent;
import android.os.IBinder;
import androidx.annotation.Nullable;
import com.baidu.adp.base.BdBaseService;
import com.baidu.android.imsdk.internal.Constants;
import com.baidu.clientupdate.appinfo.ClientUpdateInfo;
import com.baidu.tbadk.core.atomData.LcUpdateDialogActivityConfig;
import com.baidu.tieba.b29;
import com.baidu.titan.sdk.runtime.FieldHolder;
import com.baidu.titan.sdk.runtime.InitContext;
import com.baidu.titan.sdk.runtime.InterceptResult;
import com.baidu.titan.sdk.runtime.Interceptable;
import com.baidu.titan.sdk.runtime.TitanRuntime;
import java.io.Serializable;
/* loaded from: classes6.dex */
public class TiebaLcUpdateService extends BdBaseService {
    public static /* synthetic */ Interceptable $ic;
    public transient /* synthetic */ FieldHolder $fh;
    public b29 mLcUpdateAsyncTask;

    @Override // android.app.Service
    @Nullable
    public IBinder onBind(Intent intent) {
        InterceptResult invokeL;
        Interceptable interceptable = $ic;
        if (interceptable == null || (invokeL = interceptable.invokeL(1048576, this, intent)) == null) {
            return null;
        }
        return (IBinder) invokeL.objValue;
    }

    public TiebaLcUpdateService() {
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

    @Override // com.baidu.adp.base.BdBaseService, android.app.Service
    public void onCreate() {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeV(Constants.METHOD_GET_CONTACTER_INFO_FOR_SESSION, this) == null) {
            super.onCreate();
        }
    }

    @Override // android.app.Service
    public void onDestroy() {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeV(Constants.METHOD_SEND_USER_MSG, this) == null) {
            b29 b29Var = this.mLcUpdateAsyncTask;
            if (b29Var != null) {
                b29Var.cancel();
                this.mLcUpdateAsyncTask = null;
            }
            super.onDestroy();
        }
    }

    private void startUpdate(ClientUpdateInfo clientUpdateInfo) {
        Interceptable interceptable = $ic;
        if ((interceptable != null && interceptable.invokeL(65537, this, clientUpdateInfo) != null) || clientUpdateInfo == null) {
            return;
        }
        b29 b29Var = this.mLcUpdateAsyncTask;
        if (b29Var != null) {
            b29Var.cancel();
            this.mLcUpdateAsyncTask = null;
        }
        b29 b29Var2 = new b29(clientUpdateInfo);
        this.mLcUpdateAsyncTask = b29Var2;
        b29Var2.execute(new String[0]);
    }

    @Override // com.baidu.adp.base.BdBaseService, android.app.Service
    public int onStartCommand(Intent intent, int i, int i2) {
        InterceptResult invokeLII;
        Interceptable interceptable = $ic;
        if (interceptable == null || (invokeLII = interceptable.invokeLII(1048579, this, intent, i, i2)) == null) {
            if (intent == null) {
                return super.onStartCommand(intent, i, i2);
            }
            Serializable serializableExtra = intent.getSerializableExtra(LcUpdateDialogActivityConfig.KEY_LC_UPDATE_DATA);
            if (!(serializableExtra instanceof ClientUpdateInfo)) {
                return super.onStartCommand(intent, i, i2);
            }
            startUpdate((ClientUpdateInfo) serializableExtra);
            return 3;
        }
        return invokeLII.intValue;
    }
}
