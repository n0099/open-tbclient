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
public class vs4 {
    public static /* synthetic */ Interceptable $ic;
    public transient /* synthetic */ FieldHolder $fh;
    public us4 a;
    public y15 b;

    public vs4() {
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
        y15 y15Var;
        Interceptable interceptable = $ic;
        if ((interceptable == null || interceptable.invokeV(1048576, this) == null) && (y15Var = this.b) != null) {
            y15Var.f();
            this.b = null;
        }
    }

    public final void b(String str) {
        Activity currentActivity;
        Interceptable interceptable = $ic;
        if ((interceptable == null || interceptable.invokeL(Constants.METHOD_GET_CONTACTER_INFO_FOR_SESSION, this, str) == null) && !dj.isEmpty(str) && (currentActivity = TbadkCoreApplication.getInst().getCurrentActivity()) != null && !StringUtils.isNull(str)) {
            zu4.v(currentActivity, "", str, true);
        }
    }

    public void c(us4 us4Var) {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeL(Constants.METHOD_SEND_USER_MSG, this, us4Var) == null) {
            this.a = us4Var;
        }
    }

    public void d() {
        us4 us4Var;
        Interceptable interceptable = $ic;
        if ((interceptable != null && interceptable.invokeV(1048579, this) != null) || (us4Var = this.a) == null) {
            return;
        }
        int i = us4Var.c;
        if (i == us4.y) {
            y15 h = y15.h(TbadkCoreApplication.getInst().getCurrentActivity(), this.a);
            h.j();
            this.b = h;
        } else if (i == us4.z) {
            Activity currentActivity = TbadkCoreApplication.getInst().getCurrentActivity();
            vx4 vx4Var = new vx4(currentActivity);
            vx4Var.d(currentActivity, this.a);
            vx4Var.i();
            String currentAccount = TbadkCoreApplication.getCurrentAccount();
            ux4 b = ux4.b();
            ux4 b2 = ux4.b();
            b2.i("business_count_hint" + currentAccount + this.a.a, b.c("business_count_hint" + currentAccount + this.a.a) - 1);
        } else if (i == us4.A) {
            int i2 = us4Var.d;
            if (i2 == us4.E) {
                if (!UtilHelper.dealOneScheme(TbadkCoreApplication.getInst().getCurrentActivity(), this.a.l) && !dj.isEmpty(this.a.k)) {
                    b(this.a.k + TbWebViewActivityConfig.JUMP_PARAMS_PAGE_TYPE);
                }
            } else if (i2 == us4.F && !dj.isEmpty(us4Var.k)) {
                b(this.a.k + TbWebViewActivityConfig.JUMP_PARAMS_PAGE_TYPE);
            }
        } else if (i == us4.B && !TextUtils.isEmpty(us4Var.e)) {
            CompleteTaskToastData completeTaskToastData = new CompleteTaskToastData();
            us4 us4Var2 = this.a;
            completeTaskToastData.activityId = us4Var2.a;
            completeTaskToastData.missionId = us4Var2.b;
            completeTaskToastData.duration = us4Var2.i;
            completeTaskToastData.message = us4Var2.e;
            completeTaskToastData.url = us4Var2.k;
            completeTaskToastData.pageId = sr4.w().v();
            CompeteTaskEvent competeTaskEvent = new CompeteTaskEvent();
            competeTaskEvent.taskToastData = completeTaskToastData;
            yi5.i(competeTaskEvent);
            us4 us4Var3 = this.a;
            ws4.c(us4Var3.a, us4Var3.b);
        }
    }
}
