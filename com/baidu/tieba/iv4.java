package com.baidu.tieba;

import android.app.Activity;
import android.text.TextUtils;
import com.baidu.adp.lib.util.StringUtils;
import com.baidu.android.imsdk.internal.Constants;
import com.baidu.tbadk.BdToken.completeTask.CompleteTaskToastData;
import com.baidu.tbadk.core.TbadkCoreApplication;
import com.baidu.tbadk.core.atomData.TbWebViewActivityConfig;
import com.baidu.tbadk.core.util.UtilHelper;
import com.baidu.tbadk.mutiprocess.competetask.CompeteTaskEvent;
import com.baidu.titan.sdk.runtime.FieldHolder;
import com.baidu.titan.sdk.runtime.InitContext;
import com.baidu.titan.sdk.runtime.Interceptable;
import com.baidu.titan.sdk.runtime.TitanRuntime;
/* loaded from: classes6.dex */
public class iv4 {
    public static /* synthetic */ Interceptable $ic;
    public transient /* synthetic */ FieldHolder $fh;
    public hv4 a;
    public k55 b;

    public iv4() {
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
        k55 k55Var;
        Interceptable interceptable = $ic;
        if ((interceptable == null || interceptable.invokeV(1048576, this) == null) && (k55Var = this.b) != null) {
            k55Var.f();
            this.b = null;
        }
    }

    public final void b(String str) {
        Activity currentActivity;
        Interceptable interceptable = $ic;
        if ((interceptable == null || interceptable.invokeL(Constants.METHOD_GET_CONTACTER_INFO_FOR_SESSION, this, str) == null) && !ui.isEmpty(str) && (currentActivity = TbadkCoreApplication.getInst().getCurrentActivity()) != null && !StringUtils.isNull(str)) {
            qx4.v(currentActivity, "", str, true);
        }
    }

    public void c(hv4 hv4Var) {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeL(Constants.METHOD_SEND_USER_MSG, this, hv4Var) == null) {
            this.a = hv4Var;
        }
    }

    public void d() {
        hv4 hv4Var;
        Interceptable interceptable = $ic;
        if ((interceptable != null && interceptable.invokeV(1048579, this) != null) || (hv4Var = this.a) == null) {
            return;
        }
        int i = hv4Var.c;
        if (i == hv4.y) {
            k55 h = k55.h(TbadkCoreApplication.getInst().getCurrentActivity(), this.a);
            h.j();
            this.b = h;
        } else if (i == hv4.z) {
            Activity currentActivity = TbadkCoreApplication.getInst().getCurrentActivity();
            d15 d15Var = new d15(currentActivity);
            d15Var.d(currentActivity, this.a);
            d15Var.i();
            String currentAccount = TbadkCoreApplication.getCurrentAccount();
            c15 b = c15.b();
            c15 b2 = c15.b();
            b2.i("business_count_hint" + currentAccount + this.a.a, b.c("business_count_hint" + currentAccount + this.a.a) - 1);
        } else if (i == hv4.A) {
            int i2 = hv4Var.d;
            if (i2 == hv4.E) {
                if (!UtilHelper.dealOneScheme(TbadkCoreApplication.getInst().getCurrentActivity(), this.a.l) && !ui.isEmpty(this.a.k)) {
                    b(this.a.k + TbWebViewActivityConfig.JUMP_PARAMS_PAGE_TYPE);
                }
            } else if (i2 == hv4.F && !ui.isEmpty(hv4Var.k)) {
                b(this.a.k + TbWebViewActivityConfig.JUMP_PARAMS_PAGE_TYPE);
            }
        } else if (i == hv4.B && !TextUtils.isEmpty(hv4Var.e)) {
            CompleteTaskToastData completeTaskToastData = new CompleteTaskToastData();
            hv4 hv4Var2 = this.a;
            completeTaskToastData.activityId = hv4Var2.a;
            completeTaskToastData.missionId = hv4Var2.b;
            completeTaskToastData.duration = hv4Var2.i;
            completeTaskToastData.message = hv4Var2.e;
            completeTaskToastData.url = hv4Var2.k;
            completeTaskToastData.pageId = eu4.w().v();
            CompeteTaskEvent competeTaskEvent = new CompeteTaskEvent();
            competeTaskEvent.taskToastData = completeTaskToastData;
            ip5.i(competeTaskEvent);
            hv4 hv4Var3 = this.a;
            jv4.c(hv4Var3.a, hv4Var3.b);
        }
    }
}
