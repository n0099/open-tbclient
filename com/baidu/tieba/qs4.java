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
/* loaded from: classes7.dex */
public class qs4 {
    public static /* synthetic */ Interceptable $ic;
    public transient /* synthetic */ FieldHolder $fh;
    public ps4 a;
    public l25 b;

    public qs4() {
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
        l25 l25Var;
        Interceptable interceptable = $ic;
        if ((interceptable == null || interceptable.invokeV(1048576, this) == null) && (l25Var = this.b) != null) {
            l25Var.f();
            this.b = null;
        }
    }

    public final void b(String str) {
        Activity currentActivity;
        Interceptable interceptable = $ic;
        if ((interceptable == null || interceptable.invokeL(Constants.METHOD_GET_CONTACTER_INFO_FOR_SESSION, this, str) == null) && !qi.isEmpty(str) && (currentActivity = TbadkCoreApplication.getInst().getCurrentActivity()) != null && !StringUtils.isNull(str)) {
            yu4.v(currentActivity, "", str, true);
        }
    }

    public void c(ps4 ps4Var) {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeL(Constants.METHOD_SEND_USER_MSG, this, ps4Var) == null) {
            this.a = ps4Var;
        }
    }

    public void d() {
        ps4 ps4Var;
        Interceptable interceptable = $ic;
        if ((interceptable != null && interceptable.invokeV(1048579, this) != null) || (ps4Var = this.a) == null) {
            return;
        }
        int i = ps4Var.c;
        if (i == ps4.y) {
            l25 h = l25.h(TbadkCoreApplication.getInst().getCurrentActivity(), this.a);
            h.j();
            this.b = h;
        } else if (i == ps4.z) {
            Activity currentActivity = TbadkCoreApplication.getInst().getCurrentActivity();
            fy4 fy4Var = new fy4(currentActivity);
            fy4Var.d(currentActivity, this.a);
            fy4Var.i();
            String currentAccount = TbadkCoreApplication.getCurrentAccount();
            ey4 b = ey4.b();
            ey4 b2 = ey4.b();
            b2.i("business_count_hint" + currentAccount + this.a.a, b.c("business_count_hint" + currentAccount + this.a.a) - 1);
        } else if (i == ps4.A) {
            int i2 = ps4Var.d;
            if (i2 == ps4.E) {
                if (!UtilHelper.dealOneScheme(TbadkCoreApplication.getInst().getCurrentActivity(), this.a.l) && !qi.isEmpty(this.a.k)) {
                    b(this.a.k + TbWebViewActivityConfig.JUMP_PARAMS_PAGE_TYPE);
                }
            } else if (i2 == ps4.F && !qi.isEmpty(ps4Var.k)) {
                b(this.a.k + TbWebViewActivityConfig.JUMP_PARAMS_PAGE_TYPE);
            }
        } else if (i == ps4.B && !TextUtils.isEmpty(ps4Var.e)) {
            CompleteTaskToastData completeTaskToastData = new CompleteTaskToastData();
            ps4 ps4Var2 = this.a;
            completeTaskToastData.activityId = ps4Var2.a;
            completeTaskToastData.missionId = ps4Var2.b;
            completeTaskToastData.duration = ps4Var2.i;
            completeTaskToastData.message = ps4Var2.e;
            completeTaskToastData.url = ps4Var2.k;
            completeTaskToastData.pageId = mr4.w().v();
            CompeteTaskEvent competeTaskEvent = new CompeteTaskEvent();
            competeTaskEvent.taskToastData = completeTaskToastData;
            el5.i(competeTaskEvent);
            ps4 ps4Var3 = this.a;
            rs4.c(ps4Var3.a, ps4Var3.b);
        }
    }
}
