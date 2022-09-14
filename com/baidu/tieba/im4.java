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
/* loaded from: classes4.dex */
public class im4 {
    public static /* synthetic */ Interceptable $ic;
    public transient /* synthetic */ FieldHolder $fh;
    public hm4 a;
    public iu4 b;

    public im4() {
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
        iu4 iu4Var;
        Interceptable interceptable = $ic;
        if (!(interceptable == null || interceptable.invokeV(1048576, this) == null) || (iu4Var = this.b) == null) {
            return;
        }
        iu4Var.f();
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

    public void d(hm4 hm4Var) {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeL(1048579, this, hm4Var) == null) {
            this.a = hm4Var;
        }
    }

    public void e() {
        hm4 hm4Var;
        Interceptable interceptable = $ic;
        if (!(interceptable == null || interceptable.invokeV(1048580, this) == null) || (hm4Var = this.a) == null) {
            return;
        }
        int i = hm4Var.c;
        if (i == hm4.y) {
            iu4 h = iu4.h(TbadkCoreApplication.getInst().getCurrentActivity(), this.a);
            h.j();
            this.b = h;
        } else if (i == hm4.z) {
            Activity currentActivity = TbadkCoreApplication.getInst().getCurrentActivity();
            hq4 hq4Var = new hq4(currentActivity);
            hq4Var.d(currentActivity, this.a);
            hq4Var.i();
            String currentAccount = TbadkCoreApplication.getCurrentAccount();
            gq4 b = gq4.b();
            gq4 b2 = gq4.b();
            b2.i("business_count_hint" + currentAccount + this.a.a, b.c("business_count_hint" + currentAccount + this.a.a) - 1);
        } else if (i == hm4.A) {
            int i2 = hm4Var.d;
            if (i2 == hm4.D) {
                if (UtilHelper.dealOneScheme(TbadkCoreApplication.getInst().getCurrentActivity(), this.a.l) || dj.isEmpty(this.a.k)) {
                    return;
                }
                b(this.a.k + TbWebViewActivityConfig.JUMP_PARAMS_PAGE_TYPE);
            } else if (i2 != hm4.E || dj.isEmpty(hm4Var.k)) {
            } else {
                b(this.a.k + TbWebViewActivityConfig.JUMP_PARAMS_PAGE_TYPE);
            }
        } else if (i != hm4.B || TextUtils.isEmpty(hm4Var.e)) {
        } else {
            CompleteTaskToastData completeTaskToastData = new CompleteTaskToastData();
            hm4 hm4Var2 = this.a;
            completeTaskToastData.activityId = hm4Var2.a;
            completeTaskToastData.missionId = hm4Var2.b;
            completeTaskToastData.duration = hm4Var2.i;
            completeTaskToastData.message = hm4Var2.e;
            completeTaskToastData.url = hm4Var2.k;
            completeTaskToastData.pageId = el4.w().v();
            CompeteTaskEvent competeTaskEvent = new CompeteTaskEvent();
            competeTaskEvent.taskToastData = completeTaskToastData;
            aa5.i(competeTaskEvent);
            hm4 hm4Var3 = this.a;
            jm4.c(hm4Var3.a, hm4Var3.b);
        }
    }
}
