package com.baidu.tieba;

import android.app.Activity;
import android.content.Context;
import android.text.TextUtils;
import com.baidu.adp.lib.util.StringUtils;
import com.baidu.android.imsdk.internal.Constants;
import com.baidu.tbadk.BdToken.completeTask.CompleteTaskToastData;
import com.baidu.tbadk.browser.BrowserHelper;
import com.baidu.tbadk.core.TbadkCoreApplication;
import com.baidu.tbadk.core.atomData.TbWebViewActivityConfig;
import com.baidu.tbadk.core.util.UtilHelper;
import com.baidu.tbadk.mutiprocess.MutiProcessManager;
import com.baidu.tbadk.mutiprocess.competetask.CompeteTaskEvent;
import com.baidu.titan.sdk.runtime.FieldHolder;
import com.baidu.titan.sdk.runtime.InitContext;
import com.baidu.titan.sdk.runtime.Interceptable;
import com.baidu.titan.sdk.runtime.TitanRuntime;
/* loaded from: classes6.dex */
public class ju4 {
    public static /* synthetic */ Interceptable $ic;
    public transient /* synthetic */ FieldHolder $fh;
    public iu4 a;
    public z45 b;

    public ju4() {
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

    public void a() {
        z45 z45Var;
        Interceptable interceptable = $ic;
        if ((interceptable == null || interceptable.invokeV(1048576, this) == null) && (z45Var = this.b) != null) {
            z45Var.f();
            this.b = null;
        }
    }

    public final void b(String str) {
        Activity currentActivity;
        Interceptable interceptable = $ic;
        if ((interceptable == null || interceptable.invokeL(Constants.METHOD_GET_CONTACTER_INFO_FOR_SESSION, this, str) == null) && !di.isEmpty(str) && (currentActivity = TbadkCoreApplication.getInst().getCurrentActivity()) != null && !StringUtils.isNull(str)) {
            BrowserHelper.startWebActivity((Context) currentActivity, "", str, true);
        }
    }

    public void c(iu4 iu4Var) {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeL(Constants.METHOD_SEND_USER_MSG, this, iu4Var) == null) {
            this.a = iu4Var;
        }
    }

    public void d() {
        iu4 iu4Var;
        Interceptable interceptable = $ic;
        if ((interceptable != null && interceptable.invokeV(1048579, this) != null) || (iu4Var = this.a) == null) {
            return;
        }
        int i = iu4Var.c;
        if (i == iu4.y) {
            z45 h = z45.h(TbadkCoreApplication.getInst().getCurrentActivity(), this.a);
            h.j();
            this.b = h;
        } else if (i == iu4.z) {
            Activity currentActivity = TbadkCoreApplication.getInst().getCurrentActivity();
            s05 s05Var = new s05(currentActivity);
            s05Var.d(currentActivity, this.a);
            s05Var.i();
            String currentAccount = TbadkCoreApplication.getCurrentAccount();
            r05 b = r05.b();
            r05 b2 = r05.b();
            b2.i("business_count_hint" + currentAccount + this.a.a, b.c("business_count_hint" + currentAccount + this.a.a) - 1);
        } else if (i == iu4.A) {
            int i2 = iu4Var.d;
            if (i2 == iu4.C) {
                if (!UtilHelper.dealOneScheme(TbadkCoreApplication.getInst().getCurrentActivity(), this.a.l) && !di.isEmpty(this.a.k)) {
                    b(this.a.k + TbWebViewActivityConfig.JUMP_PARAMS_PAGE_TYPE);
                }
            } else if (i2 == iu4.D && !di.isEmpty(iu4Var.k)) {
                b(this.a.k + TbWebViewActivityConfig.JUMP_PARAMS_PAGE_TYPE);
            }
        } else if (i == iu4.B && !TextUtils.isEmpty(iu4Var.e)) {
            CompleteTaskToastData completeTaskToastData = new CompleteTaskToastData();
            iu4 iu4Var2 = this.a;
            completeTaskToastData.activityId = iu4Var2.a;
            completeTaskToastData.missionId = iu4Var2.b;
            completeTaskToastData.duration = iu4Var2.i;
            completeTaskToastData.message = iu4Var2.e;
            completeTaskToastData.url = iu4Var2.k;
            completeTaskToastData.pageId = jt4.w().v();
            CompeteTaskEvent competeTaskEvent = new CompeteTaskEvent();
            competeTaskEvent.taskToastData = completeTaskToastData;
            MutiProcessManager.publishEvent(competeTaskEvent);
            iu4 iu4Var3 = this.a;
            ku4.c(iu4Var3.a, iu4Var3.b);
        }
    }
}
