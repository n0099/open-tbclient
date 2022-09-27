package com.baidu.tieba;

import com.baidu.android.imsdk.internal.Constants;
import com.baidu.tbadk.TbPageContext;
import com.baidu.tbadk.TbSingleton;
import com.baidu.tbadk.core.TbadkCoreApplication;
import com.baidu.tbadk.core.leveiconlivepolling.PollingModel;
import com.baidu.tbadk.data.IconPopData;
import com.baidu.tbadk.util.PriorityOrganizer;
import com.baidu.tieba.tblauncher.MainTabActivity;
import com.baidu.tieba.zk8;
import com.baidu.titan.sdk.runtime.FieldHolder;
import com.baidu.titan.sdk.runtime.InitContext;
import com.baidu.titan.sdk.runtime.InterceptResult;
import com.baidu.titan.sdk.runtime.Interceptable;
import com.baidu.titan.sdk.runtime.TitanRuntime;
/* loaded from: classes4.dex */
public class is8 extends PriorityOrganizer.Task {
    public static /* synthetic */ Interceptable $ic;
    public transient /* synthetic */ FieldHolder $fh;
    public xp8 m;
    public MainTabActivity n;

    /* loaded from: classes4.dex */
    public class a implements zk8.d {
        public static /* synthetic */ Interceptable $ic;
        public transient /* synthetic */ FieldHolder $fh;
        public final /* synthetic */ is8 a;

        public a(is8 is8Var) {
            Interceptable interceptable = $ic;
            if (interceptable != null) {
                InitContext newInitContext = TitanRuntime.newInitContext();
                newInitContext.initArgs = r2;
                Object[] objArr = {is8Var};
                interceptable.invokeUnInit(65536, newInitContext);
                int i = newInitContext.flag;
                if ((i & 1) != 0) {
                    int i2 = i & 2;
                    newInitContext.thisArg = this;
                    interceptable.invokeInitBody(65536, newInitContext);
                    return;
                }
            }
            this.a = is8Var;
        }

        @Override // com.baidu.tieba.zk8.d
        public void a() {
            Interceptable interceptable = $ic;
            if (interceptable == null || interceptable.invokeV(1048576, this) == null) {
                this.a.u();
            }
        }

        @Override // com.baidu.tieba.zk8.d
        public void b() {
            Interceptable interceptable = $ic;
            if (interceptable == null || interceptable.invokeV(Constants.METHOD_GET_CONTACTER_INFO_FOR_SESSION, this) == null) {
                this.a.u();
            }
        }

        @Override // com.baidu.tieba.zk8.d
        public void c() {
            Interceptable interceptable = $ic;
            if (interceptable == null || interceptable.invokeV(Constants.METHOD_SEND_USER_MSG, this) == null) {
                this.a.u();
            }
        }
    }

    public is8(TbPageContext tbPageContext, xp8 xp8Var, MainTabActivity mainTabActivity) {
        Interceptable interceptable = $ic;
        if (interceptable != null) {
            InitContext newInitContext = TitanRuntime.newInitContext();
            newInitContext.initArgs = r2;
            Object[] objArr = {tbPageContext, xp8Var, mainTabActivity};
            interceptable.invokeUnInit(65536, newInitContext);
            int i = newInitContext.flag;
            if ((i & 1) != 0) {
                int i2 = i & 2;
                newInitContext.thisArg = this;
                interceptable.invokeInitBody(65536, newInitContext);
                return;
            }
        }
        this.m = xp8Var;
        this.n = mainTabActivity;
    }

    @Override // com.baidu.tbadk.util.PriorityOrganizer.Task
    public void A() {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeV(1048576, this) == null) {
            if (PollingModel.O()) {
                IconPopData iconPopData = TbSingleton.getInstance().getIconPopData();
                zk8 zk8Var = new zk8();
                zk8Var.i(iconPopData);
                zk8Var.k(new a(this));
                return;
            }
            u();
        }
    }

    @Override // com.baidu.tbadk.util.PriorityOrganizer.Task
    public boolean v() {
        InterceptResult invokeV;
        Interceptable interceptable = $ic;
        if (interceptable == null || (invokeV = interceptable.invokeV(Constants.METHOD_GET_CONTACTER_INFO_FOR_SESSION, this)) == null) {
            xp8 xp8Var = this.m;
            return (xp8Var == null || xp8Var.B() == null || (this.m.B().getCurrentTabType() != 2 && this.m.B().getCurrentTabType() != 1 && this.m.B().getCurrentTabType() != 3)) ? false : true;
        }
        return invokeV.booleanValue;
    }

    @Override // com.baidu.tbadk.util.PriorityOrganizer.Task
    public boolean x() {
        InterceptResult invokeV;
        Interceptable interceptable = $ic;
        if (interceptable == null || (invokeV = interceptable.invokeV(Constants.METHOD_SEND_USER_MSG, this)) == null) {
            IconPopData iconPopData = TbSingleton.getInstance().getIconPopData();
            return PollingModel.O() && iconPopData.getPic160() != null && iconPopData.getTitle() != null && this.n.d1() && this.n.E && iconPopData.getUid().longValue() == TbadkCoreApplication.getCurrentAccountId();
        }
        return invokeV.booleanValue;
    }
}
