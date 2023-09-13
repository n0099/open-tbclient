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
/* loaded from: classes7.dex */
public class nu4 {
    public static /* synthetic */ Interceptable $ic;
    public transient /* synthetic */ FieldHolder $fh;
    public mu4 a;
    public f55 b;

    public nu4() {
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
        f55 f55Var;
        Interceptable interceptable = $ic;
        if ((interceptable == null || interceptable.invokeV(1048576, this) == null) && (f55Var = this.b) != null) {
            f55Var.f();
            this.b = null;
        }
    }

    public final void b(String str) {
        Activity currentActivity;
        Interceptable interceptable = $ic;
        if ((interceptable == null || interceptable.invokeL(Constants.METHOD_GET_CONTACTER_INFO_FOR_SESSION, this, str) == null) && !ei.isEmpty(str) && (currentActivity = TbadkCoreApplication.getInst().getCurrentActivity()) != null && !StringUtils.isNull(str)) {
            BrowserHelper.startWebActivity((Context) currentActivity, "", str, true);
        }
    }

    public void c(mu4 mu4Var) {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeL(Constants.METHOD_SEND_USER_MSG, this, mu4Var) == null) {
            this.a = mu4Var;
        }
    }

    public void d() {
        mu4 mu4Var;
        Interceptable interceptable = $ic;
        if ((interceptable != null && interceptable.invokeV(1048579, this) != null) || (mu4Var = this.a) == null) {
            return;
        }
        int i = mu4Var.c;
        if (i == mu4.y) {
            f55 h = f55.h(TbadkCoreApplication.getInst().getCurrentActivity(), this.a);
            h.j();
            this.b = h;
        } else if (i == mu4.z) {
            Activity currentActivity = TbadkCoreApplication.getInst().getCurrentActivity();
            x05 x05Var = new x05(currentActivity);
            x05Var.d(currentActivity, this.a);
            x05Var.i();
            String currentAccount = TbadkCoreApplication.getCurrentAccount();
            w05 b = w05.b();
            w05 b2 = w05.b();
            b2.i("business_count_hint" + currentAccount + this.a.a, b.c("business_count_hint" + currentAccount + this.a.a) - 1);
        } else if (i == mu4.A) {
            int i2 = mu4Var.d;
            if (i2 == mu4.C) {
                if (!UtilHelper.dealOneScheme(TbadkCoreApplication.getInst().getCurrentActivity(), this.a.l) && !ei.isEmpty(this.a.k)) {
                    b(this.a.k + TbWebViewActivityConfig.JUMP_PARAMS_PAGE_TYPE);
                }
            } else if (i2 == mu4.D && !ei.isEmpty(mu4Var.k)) {
                b(this.a.k + TbWebViewActivityConfig.JUMP_PARAMS_PAGE_TYPE);
            }
        } else if (i == mu4.B && !TextUtils.isEmpty(mu4Var.e)) {
            CompleteTaskToastData completeTaskToastData = new CompleteTaskToastData();
            mu4 mu4Var2 = this.a;
            completeTaskToastData.activityId = mu4Var2.a;
            completeTaskToastData.missionId = mu4Var2.b;
            completeTaskToastData.duration = mu4Var2.i;
            completeTaskToastData.message = mu4Var2.e;
            completeTaskToastData.url = mu4Var2.k;
            completeTaskToastData.pageId = nt4.w().v();
            CompeteTaskEvent competeTaskEvent = new CompeteTaskEvent();
            competeTaskEvent.taskToastData = completeTaskToastData;
            MutiProcessManager.publishEvent(competeTaskEvent);
            mu4 mu4Var3 = this.a;
            ou4.c(mu4Var3.a, mu4Var3.b);
        }
    }
}
