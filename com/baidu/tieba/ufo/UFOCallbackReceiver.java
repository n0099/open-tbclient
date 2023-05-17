package com.baidu.tieba.ufo;

import android.content.BroadcastReceiver;
import android.content.Context;
import android.content.Intent;
import android.os.Bundle;
import com.baidu.adp.framework.MessageManager;
import com.baidu.ar.pose.PoseAR;
import com.baidu.tbadk.core.TbadkCoreApplication;
import com.baidu.tbadk.core.util.UrlSchemaHelper;
import com.baidu.titan.sdk.runtime.FieldHolder;
import com.baidu.titan.sdk.runtime.InitContext;
import com.baidu.titan.sdk.runtime.Interceptable;
import com.baidu.titan.sdk.runtime.TitanRuntime;
/* loaded from: classes7.dex */
public class UFOCallbackReceiver extends BroadcastReceiver {
    public static /* synthetic */ Interceptable $ic = null;
    public static final int SCHEME_TYPE = 103;
    public transient /* synthetic */ FieldHolder $fh;

    public UFOCallbackReceiver() {
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

    @Override // android.content.BroadcastReceiver
    public void onReceive(Context context, Intent intent) {
        Bundle extras;
        Interceptable interceptable = $ic;
        if ((interceptable == null || interceptable.invokeLL(1048576, this, context, intent) == null) && (extras = intent.getExtras()) != null && extras.getInt(PoseAR.MDL_START_POSE_FUN_EVENT_TYPE_KEY, -1) == 103 && UrlSchemaHelper.UFO_ACCOUNT_MANAGER.equals(extras.getString("bd_scheme"))) {
            MessageManager.getInstance().runTask(2921329, null, TbadkCoreApplication.getInst().getContext());
        }
    }
}
