package com.baidu.tieba.lc;

import android.content.Intent;
import android.os.IBinder;
import androidx.annotation.Nullable;
import com.baidu.adp.base.BdBaseService;
import com.baidu.android.imsdk.internal.Constants;
import com.baidu.clientupdate.appinfo.ClientUpdateInfo;
import com.baidu.tbadk.core.atomData.LcUpdateDialogActivityConfig;
import com.baidu.titan.sdk.runtime.FieldHolder;
import com.baidu.titan.sdk.runtime.InitContext;
import com.baidu.titan.sdk.runtime.InterceptResult;
import com.baidu.titan.sdk.runtime.Interceptable;
import com.baidu.titan.sdk.runtime.TitanRuntime;
import com.repackage.bc7;
import java.io.Serializable;
/* loaded from: classes3.dex */
public class TiebaLcUpdateService extends BdBaseService {
    public static /* synthetic */ Interceptable $ic;
    public transient /* synthetic */ FieldHolder $fh;
    public bc7 mLcUpdateAsyncTask;

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

    private void startUpdate(ClientUpdateInfo clientUpdateInfo) {
        Interceptable interceptable = $ic;
        if (!(interceptable == null || interceptable.invokeL(65537, this, clientUpdateInfo) == null) || clientUpdateInfo == null) {
            return;
        }
        bc7 bc7Var = this.mLcUpdateAsyncTask;
        if (bc7Var != null) {
            bc7Var.cancel();
            this.mLcUpdateAsyncTask = null;
        }
        bc7 bc7Var2 = new bc7(clientUpdateInfo);
        this.mLcUpdateAsyncTask = bc7Var2;
        bc7Var2.execute(new String[0]);
    }

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
            bc7 bc7Var = this.mLcUpdateAsyncTask;
            if (bc7Var != null) {
                bc7Var.cancel();
                this.mLcUpdateAsyncTask = null;
            }
            super.onDestroy();
        }
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
