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
public class jv4 {
    public static /* synthetic */ Interceptable $ic;
    public transient /* synthetic */ FieldHolder $fh;
    public iv4 a;
    public l55 b;

    public jv4() {
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
        l55 l55Var;
        Interceptable interceptable = $ic;
        if ((interceptable == null || interceptable.invokeV(1048576, this) == null) && (l55Var = this.b) != null) {
            l55Var.f();
            this.b = null;
        }
    }

    public final void b(String str) {
        Activity currentActivity;
        Interceptable interceptable = $ic;
        if ((interceptable == null || interceptable.invokeL(Constants.METHOD_GET_CONTACTER_INFO_FOR_SESSION, this, str) == null) && !vi.isEmpty(str) && (currentActivity = TbadkCoreApplication.getInst().getCurrentActivity()) != null && !StringUtils.isNull(str)) {
            rx4.v(currentActivity, "", str, true);
        }
    }

    public void c(iv4 iv4Var) {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeL(Constants.METHOD_SEND_USER_MSG, this, iv4Var) == null) {
            this.a = iv4Var;
        }
    }

    public void d() {
        iv4 iv4Var;
        Interceptable interceptable = $ic;
        if ((interceptable != null && interceptable.invokeV(1048579, this) != null) || (iv4Var = this.a) == null) {
            return;
        }
        int i = iv4Var.c;
        if (i == iv4.y) {
            l55 h = l55.h(TbadkCoreApplication.getInst().getCurrentActivity(), this.a);
            h.j();
            this.b = h;
        } else if (i == iv4.z) {
            Activity currentActivity = TbadkCoreApplication.getInst().getCurrentActivity();
            e15 e15Var = new e15(currentActivity);
            e15Var.d(currentActivity, this.a);
            e15Var.i();
            String currentAccount = TbadkCoreApplication.getCurrentAccount();
            d15 b = d15.b();
            d15 b2 = d15.b();
            b2.i("business_count_hint" + currentAccount + this.a.a, b.c("business_count_hint" + currentAccount + this.a.a) - 1);
        } else if (i == iv4.A) {
            int i2 = iv4Var.d;
            if (i2 == iv4.E) {
                if (!UtilHelper.dealOneScheme(TbadkCoreApplication.getInst().getCurrentActivity(), this.a.l) && !vi.isEmpty(this.a.k)) {
                    b(this.a.k + TbWebViewActivityConfig.JUMP_PARAMS_PAGE_TYPE);
                }
            } else if (i2 == iv4.F && !vi.isEmpty(iv4Var.k)) {
                b(this.a.k + TbWebViewActivityConfig.JUMP_PARAMS_PAGE_TYPE);
            }
        } else if (i == iv4.B && !TextUtils.isEmpty(iv4Var.e)) {
            CompleteTaskToastData completeTaskToastData = new CompleteTaskToastData();
            iv4 iv4Var2 = this.a;
            completeTaskToastData.activityId = iv4Var2.a;
            completeTaskToastData.missionId = iv4Var2.b;
            completeTaskToastData.duration = iv4Var2.i;
            completeTaskToastData.message = iv4Var2.e;
            completeTaskToastData.url = iv4Var2.k;
            completeTaskToastData.pageId = fu4.w().v();
            CompeteTaskEvent competeTaskEvent = new CompeteTaskEvent();
            competeTaskEvent.taskToastData = completeTaskToastData;
            np5.i(competeTaskEvent);
            iv4 iv4Var3 = this.a;
            kv4.c(iv4Var3.a, iv4Var3.b);
        }
    }
}
