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
public class lp4 {
    public static /* synthetic */ Interceptable $ic;
    public transient /* synthetic */ FieldHolder $fh;
    public kp4 a;
    public g05 b;

    public lp4() {
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
        g05 g05Var;
        Interceptable interceptable = $ic;
        if ((interceptable == null || interceptable.invokeV(1048576, this) == null) && (g05Var = this.b) != null) {
            g05Var.f();
            this.b = null;
        }
    }

    public final void b(String str) {
        Activity currentActivity;
        Interceptable interceptable = $ic;
        if ((interceptable == null || interceptable.invokeL(Constants.METHOD_GET_CONTACTER_INFO_FOR_SESSION, this, str) == null) && !qd.isEmpty(str) && (currentActivity = TbadkCoreApplication.getInst().getCurrentActivity()) != null && !StringUtils.isNull(str)) {
            BrowserHelper.startWebActivity((Context) currentActivity, "", str, true);
        }
    }

    public void c(kp4 kp4Var) {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeL(Constants.METHOD_SEND_USER_MSG, this, kp4Var) == null) {
            this.a = kp4Var;
        }
    }

    public void d() {
        kp4 kp4Var;
        Interceptable interceptable = $ic;
        if ((interceptable != null && interceptable.invokeV(1048579, this) != null) || (kp4Var = this.a) == null) {
            return;
        }
        int i = kp4Var.c;
        if (i == kp4.y) {
            g05 h = g05.h(TbadkCoreApplication.getInst().getCurrentActivity(), this.a);
            h.k();
            this.b = h;
        } else if (i == kp4.z) {
            Activity currentActivity = TbadkCoreApplication.getInst().getCurrentActivity();
            xv4 xv4Var = new xv4(currentActivity);
            xv4Var.d(currentActivity, this.a);
            xv4Var.i();
            String currentAccount = TbadkCoreApplication.getCurrentAccount();
            wv4 b = wv4.b();
            wv4 b2 = wv4.b();
            b2.i("business_count_hint" + currentAccount + this.a.a, b.c("business_count_hint" + currentAccount + this.a.a) - 1);
        } else if (i == kp4.A) {
            int i2 = kp4Var.d;
            if (i2 == kp4.C) {
                if (!UtilHelper.dealOneScheme(TbadkCoreApplication.getInst().getCurrentActivity(), this.a.l) && !qd.isEmpty(this.a.k)) {
                    b(this.a.k + TbWebViewActivityConfig.JUMP_PARAMS_PAGE_TYPE);
                }
            } else if (i2 == kp4.D && !qd.isEmpty(kp4Var.k)) {
                b(this.a.k + TbWebViewActivityConfig.JUMP_PARAMS_PAGE_TYPE);
            }
        } else if (i == kp4.B && !TextUtils.isEmpty(kp4Var.e)) {
            CompleteTaskToastData completeTaskToastData = new CompleteTaskToastData();
            kp4 kp4Var2 = this.a;
            completeTaskToastData.activityId = kp4Var2.a;
            completeTaskToastData.missionId = kp4Var2.b;
            completeTaskToastData.duration = kp4Var2.i;
            completeTaskToastData.message = kp4Var2.e;
            completeTaskToastData.url = kp4Var2.k;
            completeTaskToastData.pageId = lo4.w().v();
            CompeteTaskEvent competeTaskEvent = new CompeteTaskEvent();
            competeTaskEvent.taskToastData = completeTaskToastData;
            MutiProcessManager.publishEvent(competeTaskEvent);
            kp4 kp4Var3 = this.a;
            mp4.c(kp4Var3.a, kp4Var3.b);
        }
    }
}
