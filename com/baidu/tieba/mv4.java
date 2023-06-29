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
public class mv4 {
    public static /* synthetic */ Interceptable $ic;
    public transient /* synthetic */ FieldHolder $fh;
    public lv4 a;
    public o55 b;

    public mv4() {
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
        o55 o55Var;
        Interceptable interceptable = $ic;
        if ((interceptable == null || interceptable.invokeV(1048576, this) == null) && (o55Var = this.b) != null) {
            o55Var.f();
            this.b = null;
        }
    }

    public final void b(String str) {
        Activity currentActivity;
        Interceptable interceptable = $ic;
        if ((interceptable == null || interceptable.invokeL(Constants.METHOD_GET_CONTACTER_INFO_FOR_SESSION, this, str) == null) && !wi.isEmpty(str) && (currentActivity = TbadkCoreApplication.getInst().getCurrentActivity()) != null && !StringUtils.isNull(str)) {
            ux4.v(currentActivity, "", str, true);
        }
    }

    public void c(lv4 lv4Var) {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeL(Constants.METHOD_SEND_USER_MSG, this, lv4Var) == null) {
            this.a = lv4Var;
        }
    }

    public void d() {
        lv4 lv4Var;
        Interceptable interceptable = $ic;
        if ((interceptable != null && interceptable.invokeV(1048579, this) != null) || (lv4Var = this.a) == null) {
            return;
        }
        int i = lv4Var.c;
        if (i == lv4.y) {
            o55 h = o55.h(TbadkCoreApplication.getInst().getCurrentActivity(), this.a);
            h.j();
            this.b = h;
        } else if (i == lv4.z) {
            Activity currentActivity = TbadkCoreApplication.getInst().getCurrentActivity();
            h15 h15Var = new h15(currentActivity);
            h15Var.d(currentActivity, this.a);
            h15Var.i();
            String currentAccount = TbadkCoreApplication.getCurrentAccount();
            g15 b = g15.b();
            g15 b2 = g15.b();
            b2.i("business_count_hint" + currentAccount + this.a.a, b.c("business_count_hint" + currentAccount + this.a.a) - 1);
        } else if (i == lv4.A) {
            int i2 = lv4Var.d;
            if (i2 == lv4.E) {
                if (!UtilHelper.dealOneScheme(TbadkCoreApplication.getInst().getCurrentActivity(), this.a.l) && !wi.isEmpty(this.a.k)) {
                    b(this.a.k + TbWebViewActivityConfig.JUMP_PARAMS_PAGE_TYPE);
                }
            } else if (i2 == lv4.F && !wi.isEmpty(lv4Var.k)) {
                b(this.a.k + TbWebViewActivityConfig.JUMP_PARAMS_PAGE_TYPE);
            }
        } else if (i == lv4.B && !TextUtils.isEmpty(lv4Var.e)) {
            CompleteTaskToastData completeTaskToastData = new CompleteTaskToastData();
            lv4 lv4Var2 = this.a;
            completeTaskToastData.activityId = lv4Var2.a;
            completeTaskToastData.missionId = lv4Var2.b;
            completeTaskToastData.duration = lv4Var2.i;
            completeTaskToastData.message = lv4Var2.e;
            completeTaskToastData.url = lv4Var2.k;
            completeTaskToastData.pageId = iu4.w().v();
            CompeteTaskEvent competeTaskEvent = new CompeteTaskEvent();
            competeTaskEvent.taskToastData = completeTaskToastData;
            sp5.i(competeTaskEvent);
            lv4 lv4Var3 = this.a;
            nv4.c(lv4Var3.a, lv4Var3.b);
        }
    }
}
