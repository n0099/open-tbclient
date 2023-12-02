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
public class pp4 {
    public static /* synthetic */ Interceptable $ic;
    public transient /* synthetic */ FieldHolder $fh;
    public op4 a;
    public m05 b;

    public pp4() {
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
        m05 m05Var;
        Interceptable interceptable = $ic;
        if ((interceptable == null || interceptable.invokeV(1048576, this) == null) && (m05Var = this.b) != null) {
            m05Var.f();
            this.b = null;
        }
    }

    public final void b(String str) {
        Activity currentActivity;
        Interceptable interceptable = $ic;
        if ((interceptable == null || interceptable.invokeL(Constants.METHOD_GET_CONTACTER_INFO_FOR_SESSION, this, str) == null) && !rd.isEmpty(str) && (currentActivity = TbadkCoreApplication.getInst().getCurrentActivity()) != null && !StringUtils.isNull(str)) {
            BrowserHelper.startWebActivity((Context) currentActivity, "", str, true);
        }
    }

    public void c(op4 op4Var) {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeL(Constants.METHOD_SEND_USER_MSG, this, op4Var) == null) {
            this.a = op4Var;
        }
    }

    public void d() {
        op4 op4Var;
        Interceptable interceptable = $ic;
        if ((interceptable != null && interceptable.invokeV(1048579, this) != null) || (op4Var = this.a) == null) {
            return;
        }
        int i = op4Var.c;
        if (i == op4.y) {
            m05 h = m05.h(TbadkCoreApplication.getInst().getCurrentActivity(), this.a);
            h.j();
            this.b = h;
        } else if (i == op4.z) {
            Activity currentActivity = TbadkCoreApplication.getInst().getCurrentActivity();
            bw4 bw4Var = new bw4(currentActivity);
            bw4Var.d(currentActivity, this.a);
            bw4Var.i();
            String currentAccount = TbadkCoreApplication.getCurrentAccount();
            aw4 b = aw4.b();
            aw4 b2 = aw4.b();
            b2.i("business_count_hint" + currentAccount + this.a.a, b.c("business_count_hint" + currentAccount + this.a.a) - 1);
        } else if (i == op4.A) {
            int i2 = op4Var.d;
            if (i2 == op4.C) {
                if (!UtilHelper.dealOneScheme(TbadkCoreApplication.getInst().getCurrentActivity(), this.a.l) && !rd.isEmpty(this.a.k)) {
                    b(this.a.k + TbWebViewActivityConfig.JUMP_PARAMS_PAGE_TYPE);
                }
            } else if (i2 == op4.D && !rd.isEmpty(op4Var.k)) {
                b(this.a.k + TbWebViewActivityConfig.JUMP_PARAMS_PAGE_TYPE);
            }
        } else if (i == op4.B && !TextUtils.isEmpty(op4Var.e)) {
            CompleteTaskToastData completeTaskToastData = new CompleteTaskToastData();
            op4 op4Var2 = this.a;
            completeTaskToastData.activityId = op4Var2.a;
            completeTaskToastData.missionId = op4Var2.b;
            completeTaskToastData.duration = op4Var2.i;
            completeTaskToastData.message = op4Var2.e;
            completeTaskToastData.url = op4Var2.k;
            completeTaskToastData.pageId = po4.w().v();
            CompeteTaskEvent competeTaskEvent = new CompeteTaskEvent();
            competeTaskEvent.taskToastData = completeTaskToastData;
            MutiProcessManager.publishEvent(competeTaskEvent);
            op4 op4Var3 = this.a;
            qp4.c(op4Var3.a, op4Var3.b);
        }
    }
}
