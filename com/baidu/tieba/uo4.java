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
/* loaded from: classes8.dex */
public class uo4 {
    public static /* synthetic */ Interceptable $ic;
    public transient /* synthetic */ FieldHolder $fh;
    public to4 a;
    public oz4 b;

    public uo4() {
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
        oz4 oz4Var;
        Interceptable interceptable = $ic;
        if ((interceptable == null || interceptable.invokeV(1048576, this) == null) && (oz4Var = this.b) != null) {
            oz4Var.f();
            this.b = null;
        }
    }

    public final void b(String str) {
        Activity currentActivity;
        Interceptable interceptable = $ic;
        if ((interceptable == null || interceptable.invokeL(Constants.METHOD_GET_CONTACTER_INFO_FOR_SESSION, this, str) == null) && !ad.isEmpty(str) && (currentActivity = TbadkCoreApplication.getInst().getCurrentActivity()) != null && !StringUtils.isNull(str)) {
            BrowserHelper.startWebActivity((Context) currentActivity, "", str, true);
        }
    }

    public void c(to4 to4Var) {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeL(Constants.METHOD_SEND_USER_MSG, this, to4Var) == null) {
            this.a = to4Var;
        }
    }

    public void d() {
        to4 to4Var;
        Interceptable interceptable = $ic;
        if ((interceptable != null && interceptable.invokeV(1048579, this) != null) || (to4Var = this.a) == null) {
            return;
        }
        int i = to4Var.c;
        if (i == to4.y) {
            oz4 h = oz4.h(TbadkCoreApplication.getInst().getCurrentActivity(), this.a);
            h.j();
            this.b = h;
        } else if (i == to4.z) {
            Activity currentActivity = TbadkCoreApplication.getInst().getCurrentActivity();
            fv4 fv4Var = new fv4(currentActivity);
            fv4Var.d(currentActivity, this.a);
            fv4Var.i();
            String currentAccount = TbadkCoreApplication.getCurrentAccount();
            ev4 b = ev4.b();
            ev4 b2 = ev4.b();
            b2.i("business_count_hint" + currentAccount + this.a.a, b.c("business_count_hint" + currentAccount + this.a.a) - 1);
        } else if (i == to4.A) {
            int i2 = to4Var.d;
            if (i2 == to4.C) {
                if (!UtilHelper.dealOneScheme(TbadkCoreApplication.getInst().getCurrentActivity(), this.a.l) && !ad.isEmpty(this.a.k)) {
                    b(this.a.k + TbWebViewActivityConfig.JUMP_PARAMS_PAGE_TYPE);
                }
            } else if (i2 == to4.D && !ad.isEmpty(to4Var.k)) {
                b(this.a.k + TbWebViewActivityConfig.JUMP_PARAMS_PAGE_TYPE);
            }
        } else if (i == to4.B && !TextUtils.isEmpty(to4Var.e)) {
            CompleteTaskToastData completeTaskToastData = new CompleteTaskToastData();
            to4 to4Var2 = this.a;
            completeTaskToastData.activityId = to4Var2.a;
            completeTaskToastData.missionId = to4Var2.b;
            completeTaskToastData.duration = to4Var2.i;
            completeTaskToastData.message = to4Var2.e;
            completeTaskToastData.url = to4Var2.k;
            completeTaskToastData.pageId = un4.w().v();
            CompeteTaskEvent competeTaskEvent = new CompeteTaskEvent();
            competeTaskEvent.taskToastData = completeTaskToastData;
            MutiProcessManager.publishEvent(competeTaskEvent);
            to4 to4Var3 = this.a;
            vo4.c(to4Var3.a, to4Var3.b);
        }
    }
}
