package com.baidu.tieba;

import android.app.Activity;
import androidx.annotation.NonNull;
import androidx.annotation.Nullable;
import com.baidu.adp.framework.MessageManager;
import com.baidu.adp.framework.message.CustomResponsedMessage;
import com.baidu.android.imsdk.internal.Constants;
import com.baidu.searchbox.live.interfaces.service.yy.ThirdPartAliRechargeService;
import com.baidu.titan.sdk.runtime.FieldHolder;
import com.baidu.titan.sdk.runtime.InitContext;
import com.baidu.titan.sdk.runtime.InterceptResult;
import com.baidu.titan.sdk.runtime.Interceptable;
import com.baidu.titan.sdk.runtime.TitanRuntime;
/* loaded from: classes8.dex */
public class tl9 implements ThirdPartAliRechargeService {
    public static /* synthetic */ Interceptable $ic;
    public transient /* synthetic */ FieldHolder $fh;

    @Override // com.baidu.searchbox.live.interfaces.service.yy.ThirdPartAliRechargeService
    public void aliSign(@NonNull Activity activity, @NonNull String str, @Nullable ThirdPartAliRechargeService.ThirdPartAliSignCallback thirdPartAliSignCallback) {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeLLL(Constants.METHOD_GET_CONTACTER_INFO_FOR_SESSION, this, activity, str, thirdPartAliSignCallback) == null) {
        }
    }

    public tl9() {
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

    @Override // com.baidu.searchbox.live.interfaces.service.yy.ThirdPartAliRechargeService
    public String aliRecharge(Activity activity, String str, boolean z) {
        InterceptResult invokeLLZ;
        Interceptable interceptable = $ic;
        if (interceptable == null || (invokeLLZ = interceptable.invokeLLZ(1048576, this, activity, str, z)) == null) {
            tq4 tq4Var = new tq4();
            tq4Var.a = activity;
            tq4Var.b = str;
            tq4Var.c = z;
            CustomResponsedMessage runTask = MessageManager.getInstance().runTask(2921539, String.class, tq4Var);
            if (runTask == null) {
                return "";
            }
            return (String) runTask.getData();
        }
        return (String) invokeLLZ.objValue;
    }
}
