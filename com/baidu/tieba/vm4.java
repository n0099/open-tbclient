package com.baidu.tieba;

import android.app.Activity;
import android.text.TextUtils;
import com.baidu.adp.framework.message.CustomMessage;
import com.baidu.adp.lib.util.StringUtils;
import com.baidu.android.imsdk.internal.Constants;
import com.baidu.tbadk.BaseActivity;
import com.baidu.tbadk.BdToken.completeTask.CompleteTaskToastData;
import com.baidu.tbadk.TbPageContext;
import com.baidu.tbadk.core.BaseFragmentActivity;
import com.baidu.tbadk.core.TbadkCoreApplication;
import com.baidu.tbadk.core.atomData.TbWebViewActivityConfig;
import com.baidu.tbadk.core.util.UtilHelper;
import com.baidu.tbadk.mutiprocess.competetask.CompeteTaskEvent;
import com.baidu.titan.sdk.runtime.FieldHolder;
import com.baidu.titan.sdk.runtime.InitContext;
import com.baidu.titan.sdk.runtime.InterceptResult;
import com.baidu.titan.sdk.runtime.Interceptable;
import com.baidu.titan.sdk.runtime.TitanRuntime;
/* loaded from: classes6.dex */
public class vm4 {
    public static /* synthetic */ Interceptable $ic;
    public transient /* synthetic */ FieldHolder $fh;
    public um4 a;
    public vu4 b;

    public vm4() {
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
        vu4 vu4Var;
        Interceptable interceptable = $ic;
        if (!(interceptable == null || interceptable.invokeV(1048576, this) == null) || (vu4Var = this.b) == null) {
            return;
        }
        vu4Var.f();
        this.b = null;
    }

    public final void b(String str) {
        Activity currentActivity;
        TbPageContext c;
        Interceptable interceptable = $ic;
        if (!(interceptable == null || interceptable.invokeL(Constants.METHOD_GET_CONTACTER_INFO_FOR_SESSION, this, str) == null) || dj.isEmpty(str) || (currentActivity = TbadkCoreApplication.getInst().getCurrentActivity()) == null || (c = c(currentActivity)) == null || StringUtils.isNull(str)) {
            return;
        }
        c.sendMessage(new CustomMessage(2002001, new TbWebViewActivityConfig(currentActivity, "", str, true)));
    }

    public final TbPageContext c(Activity activity) {
        InterceptResult invokeL;
        Interceptable interceptable = $ic;
        if (interceptable == null || (invokeL = interceptable.invokeL(Constants.METHOD_SEND_USER_MSG, this, activity)) == null) {
            if (activity instanceof BaseActivity) {
                return ((BaseActivity) activity).getPageContext();
            }
            if (activity instanceof BaseFragmentActivity) {
                return ((BaseFragmentActivity) activity).getPageContext();
            }
            return null;
        }
        return (TbPageContext) invokeL.objValue;
    }

    public void d(um4 um4Var) {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeL(1048579, this, um4Var) == null) {
            this.a = um4Var;
        }
    }

    public void e() {
        um4 um4Var;
        Interceptable interceptable = $ic;
        if (!(interceptable == null || interceptable.invokeV(1048580, this) == null) || (um4Var = this.a) == null) {
            return;
        }
        int i = um4Var.c;
        if (i == um4.y) {
            vu4 h = vu4.h(TbadkCoreApplication.getInst().getCurrentActivity(), this.a);
            h.j();
            this.b = h;
        } else if (i == um4.z) {
            Activity currentActivity = TbadkCoreApplication.getInst().getCurrentActivity();
            uq4 uq4Var = new uq4(currentActivity);
            uq4Var.d(currentActivity, this.a);
            uq4Var.i();
            String currentAccount = TbadkCoreApplication.getCurrentAccount();
            tq4 b = tq4.b();
            tq4 b2 = tq4.b();
            b2.i("business_count_hint" + currentAccount + this.a.a, b.c("business_count_hint" + currentAccount + this.a.a) - 1);
        } else if (i == um4.A) {
            int i2 = um4Var.d;
            if (i2 == um4.D) {
                if (UtilHelper.dealOneScheme(TbadkCoreApplication.getInst().getCurrentActivity(), this.a.l) || dj.isEmpty(this.a.k)) {
                    return;
                }
                b(this.a.k + TbWebViewActivityConfig.JUMP_PARAMS_PAGE_TYPE);
            } else if (i2 != um4.E || dj.isEmpty(um4Var.k)) {
            } else {
                b(this.a.k + TbWebViewActivityConfig.JUMP_PARAMS_PAGE_TYPE);
            }
        } else if (i != um4.B || TextUtils.isEmpty(um4Var.e)) {
        } else {
            CompleteTaskToastData completeTaskToastData = new CompleteTaskToastData();
            um4 um4Var2 = this.a;
            completeTaskToastData.activityId = um4Var2.a;
            completeTaskToastData.missionId = um4Var2.b;
            completeTaskToastData.duration = um4Var2.i;
            completeTaskToastData.message = um4Var2.e;
            completeTaskToastData.url = um4Var2.k;
            completeTaskToastData.pageId = rl4.w().v();
            CompeteTaskEvent competeTaskEvent = new CompeteTaskEvent();
            competeTaskEvent.taskToastData = completeTaskToastData;
            na5.i(competeTaskEvent);
            um4 um4Var3 = this.a;
            wm4.c(um4Var3.a, um4Var3.b);
        }
    }
}
