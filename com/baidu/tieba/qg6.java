package com.baidu.tieba;

import androidx.core.app.NotificationManagerCompat;
import com.baidu.android.imsdk.internal.Constants;
import com.baidu.tbadk.abtest.UbsABTestHelper;
import com.baidu.tbadk.core.TbadkCoreApplication;
import com.baidu.tieba.frs.FrsActivity;
import com.baidu.titan.sdk.runtime.FieldHolder;
import com.baidu.titan.sdk.runtime.InitContext;
import com.baidu.titan.sdk.runtime.Interceptable;
import com.baidu.titan.sdk.runtime.TitanRuntime;
import java.util.HashMap;
/* loaded from: classes5.dex */
public class qg6 {
    public static /* synthetic */ Interceptable $ic;
    public transient /* synthetic */ FieldHolder $fh;
    public m05 a;
    public FrsActivity b;

    public qg6(FrsActivity frsActivity) {
        Interceptable interceptable = $ic;
        if (interceptable != null) {
            InitContext newInitContext = TitanRuntime.newInitContext();
            newInitContext.initArgs = r2;
            Object[] objArr = {frsActivity};
            interceptable.invokeUnInit(65536, newInitContext);
            int i = newInitContext.flag;
            if ((i & 1) != 0) {
                int i2 = i & 2;
                newInitContext.thisArg = this;
                interceptable.invokeInitBody(65536, newInitContext);
                return;
            }
        }
        this.b = frsActivity;
    }

    public void a() {
        m05 m05Var;
        Interceptable interceptable = $ic;
        if (!(interceptable == null || interceptable.invokeV(1048576, this) == null) || (m05Var = this.a) == null) {
            return;
        }
        m05Var.q();
    }

    public void b() {
        FrsActivity frsActivity;
        Interceptable interceptable = $ic;
        if (!(interceptable == null || interceptable.invokeV(Constants.METHOD_GET_CONTACTER_INFO_FOR_SESSION, this) == null) || (frsActivity = this.b) == null || frsActivity.getPageContext() == null) {
            return;
        }
        boolean z = false;
        if (UbsABTestHelper.isPushOpenNewStyle()) {
            if (NotificationManagerCompat.from(TbadkCoreApplication.getInst()).areNotificationsEnabled() || !n05.g(TbadkCoreApplication.getInst(), 0)) {
                return;
            }
            FrsActivity frsActivity2 = this.b;
            if (frsActivity2 != null && frsActivity2.K0() != null) {
                z = this.b.K0().F;
            }
            HashMap hashMap = new HashMap();
            if (z) {
                hashMap.put("view_params_key_style", "short");
            }
            m05 m05Var = this.a;
            if (m05Var != null) {
                m05Var.q();
            }
            this.a = n05.j(this.b.getPageContext(), "forum_follow", 2000L, hashMap);
        } else if (j05.g(this.b, 0)) {
            j05.i(this.b.getPageContext(), 4, 2000L);
        }
    }
}
