package com.baidu.tieba;

import com.baidu.android.imsdk.internal.Constants;
import com.baidu.tbadk.abtest.group.AbsGroupUbsABTest;
import com.baidu.tbadk.core.data.ErrorData;
import com.baidu.tbadk.core.data.ThreadData;
import com.baidu.tbadk.mvc.message.MvcHttpMessage;
import com.baidu.tbadk.mvc.message.MvcHttpResponsedMessage;
import com.baidu.tbadk.mvc.message.MvcNetMessage;
import com.baidu.tbadk.mvc.message.MvcSocketMessage;
import com.baidu.tbadk.mvc.message.MvcSocketResponsedMessage;
import com.baidu.tbadk.mvc.model.NetModel;
import com.baidu.tieba.card.data.BaseCardInfo;
import com.baidu.tieba.frs.itemtab.FrsItemTabFragment;
import com.baidu.tieba.frs.itemtab.FrsItemTabHttpResponseMessage;
import com.baidu.tieba.frs.itemtab.FrsItemTabNetModel;
import com.baidu.tieba.frs.itemtab.FrsItemTabRequestData;
import com.baidu.tieba.frs.itemtab.FrsItemTabSocketResponseMessage;
import com.baidu.titan.sdk.runtime.FieldHolder;
import com.baidu.titan.sdk.runtime.InitContext;
import com.baidu.titan.sdk.runtime.InterceptResult;
import com.baidu.titan.sdk.runtime.Interceptable;
import com.baidu.titan.sdk.runtime.TitanRuntime;
import java.util.ArrayList;
import java.util.Iterator;
/* loaded from: classes8.dex */
public class r08 implements NetModel.k {
    public static /* synthetic */ Interceptable $ic;
    public transient /* synthetic */ FieldHolder $fh;
    public FrsItemTabFragment a;
    public s08 b;
    public FrsItemTabNetModel c;
    public int d;
    public String e;

    public r08(FrsItemTabFragment frsItemTabFragment, int i) {
        Interceptable interceptable = $ic;
        if (interceptable != null) {
            InitContext newInitContext = TitanRuntime.newInitContext();
            newInitContext.initArgs = r2;
            Object[] objArr = {frsItemTabFragment, Integer.valueOf(i)};
            interceptable.invokeUnInit(65536, newInitContext);
            int i2 = newInitContext.flag;
            if ((i2 & 1) != 0) {
                int i3 = i2 & 2;
                newInitContext.thisArg = this;
                interceptable.invokeInitBody(65536, newInitContext);
                return;
            }
        }
        if (frsItemTabFragment == null) {
            return;
        }
        this.a = frsItemTabFragment;
        FrsItemTabRequestData frsItemTabRequestData = new FrsItemTabRequestData();
        frsItemTabRequestData.itemId = i;
        FrsItemTabNetModel frsItemTabNetModel = new FrsItemTabNetModel(frsItemTabFragment.getPageContext(), frsItemTabRequestData);
        this.c = frsItemTabNetModel;
        frsItemTabNetModel.q0(this);
        this.c.setUniqueId(frsItemTabFragment.getUniqueId());
    }

    @Override // com.baidu.tbadk.mvc.model.NetModel.l
    public void I(MvcHttpResponsedMessage mvcHttpResponsedMessage, MvcHttpMessage mvcHttpMessage, MvcNetMessage mvcNetMessage) {
        Interceptable interceptable = $ic;
        if ((interceptable != null && interceptable.invokeLLL(1048576, this, mvcHttpResponsedMessage, mvcHttpMessage, mvcNetMessage) != null) || mvcHttpResponsedMessage == null) {
            return;
        }
        s08 s08Var = null;
        if (!mvcHttpResponsedMessage.hasError() && (mvcHttpResponsedMessage instanceof FrsItemTabHttpResponseMessage)) {
            s08Var = (s08) ((FrsItemTabHttpResponseMessage) mvcHttpResponsedMessage).getData();
        }
        if (s08Var != null && c(s08Var)) {
            return;
        }
        this.d = mvcHttpResponsedMessage.getError();
        this.e = mvcHttpResponsedMessage.getErrorString();
        b();
    }

    @Override // com.baidu.tbadk.mvc.model.NetModel.m
    public void u(MvcSocketResponsedMessage mvcSocketResponsedMessage, MvcSocketMessage mvcSocketMessage, MvcNetMessage mvcNetMessage) {
        Interceptable interceptable = $ic;
        if ((interceptable != null && interceptable.invokeLLL(1048582, this, mvcSocketResponsedMessage, mvcSocketMessage, mvcNetMessage) != null) || mvcSocketResponsedMessage == null) {
            return;
        }
        s08 s08Var = null;
        if (!mvcSocketResponsedMessage.hasError() && (mvcSocketResponsedMessage instanceof FrsItemTabSocketResponseMessage)) {
            s08Var = ((FrsItemTabSocketResponseMessage) mvcSocketResponsedMessage).getData();
        }
        if (s08Var != null && c(s08Var)) {
            return;
        }
        this.d = mvcSocketResponsedMessage.getError();
        this.e = mvcSocketResponsedMessage.getErrorString();
        b();
    }

    public boolean a() {
        InterceptResult invokeV;
        Interceptable interceptable = $ic;
        if (interceptable == null || (invokeV = interceptable.invokeV(Constants.METHOD_GET_CONTACTER_INFO_FOR_SESSION, this)) == null) {
            s08 s08Var = this.b;
            if (s08Var != null && s08Var.a != null) {
                return true;
            }
            return false;
        }
        return invokeV.booleanValue;
    }

    public final void b() {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeV(Constants.METHOD_SEND_USER_MSG, this) == null) {
            ErrorData errorData = new ErrorData();
            errorData.setError_code(this.d);
            errorData.setError_msg(this.e);
            if (this.d != 0) {
                this.a.i(errorData);
            }
        }
    }

    public void d() {
        Interceptable interceptable = $ic;
        if ((interceptable != null && interceptable.invokeV(1048580, this) != null) || this.c.i0()) {
            return;
        }
        this.c.loadData();
        s88.a();
    }

    public final boolean c(s08 s08Var) {
        InterceptResult invokeL;
        Interceptable interceptable = $ic;
        if (interceptable == null || (invokeL = interceptable.invokeL(1048579, this, s08Var)) == null) {
            if (s08Var == null) {
                return false;
            }
            this.b = s08Var;
            s08Var.c = e(s08Var.c);
            this.a.K2(this.b);
            return true;
        }
        return invokeL.booleanValue;
    }

    public final ArrayList<pi> e(ArrayList<pi> arrayList) {
        InterceptResult invokeL;
        Interceptable interceptable = $ic;
        if (interceptable == null || (invokeL = interceptable.invokeL(1048581, this, arrayList)) == null) {
            ArrayList<pi> arrayList2 = new ArrayList<>();
            Iterator<pi> it = arrayList.iterator();
            int i = 0;
            while (it.hasNext()) {
                pi next = it.next();
                if (next instanceof ThreadData) {
                    ThreadData threadData = (ThreadData) next;
                    AbsGroupUbsABTest.setCardInfoUbsABTest(threadData);
                    int[] imageWidthAndHeight = threadData.getImageWidthAndHeight();
                    if (threadData.getType() == ThreadData.TYPE_NORMAL && !threadData.isTop()) {
                        mz4 mz4Var = new mz4();
                        mz4Var.t = threadData;
                        mz4Var.position = i;
                        mz4Var.a = true;
                        mz4Var.setSupportType(BaseCardInfo.SupportType.CONTENT);
                        arrayList2.add(mz4Var);
                        mz4 mz4Var2 = new mz4();
                        mz4Var2.t = threadData;
                        mz4Var2.position = i;
                        if (threadData.picCount() == 1) {
                            mz4Var2.d = true;
                            mz4Var2.u = imageWidthAndHeight[0];
                            mz4Var2.v = imageWidthAndHeight[1];
                        } else if (threadData.picCount() >= 2) {
                            mz4Var2.e = true;
                        } else {
                            mz4Var2.b = true;
                        }
                        mz4Var2.setSupportType(BaseCardInfo.SupportType.CONTENT);
                        arrayList2.add(mz4Var2);
                        mz4 mz4Var3 = new mz4();
                        mz4Var3.g = true;
                        mz4Var3.t = threadData;
                        mz4Var3.position = i;
                        mz4Var3.setSupportType(BaseCardInfo.SupportType.CONTENT);
                        arrayList2.add(mz4Var3);
                        i++;
                    }
                    threadData.setSupportType(BaseCardInfo.SupportType.CONTENT);
                } else {
                    if (next instanceof BaseCardInfo) {
                        ((BaseCardInfo) next).position = i;
                    }
                    arrayList2.add(next);
                    i++;
                }
            }
            AbsGroupUbsABTest.setCardInfoUbsABTest(arrayList2);
            return arrayList2;
        }
        return (ArrayList) invokeL.objValue;
    }
}
