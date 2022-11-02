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
/* loaded from: classes4.dex */
public class kq6 implements NetModel.k {
    public static /* synthetic */ Interceptable $ic;
    public transient /* synthetic */ FieldHolder $fh;
    public FrsItemTabFragment a;
    public lq6 b;
    public FrsItemTabNetModel c;
    public int d;
    public String e;

    public kq6(FrsItemTabFragment frsItemTabFragment, int i) {
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
        frsItemTabNetModel.b0(this);
        this.c.setUniqueId(frsItemTabFragment.getUniqueId());
    }

    public boolean a() {
        InterceptResult invokeV;
        Interceptable interceptable = $ic;
        if (interceptable == null || (invokeV = interceptable.invokeV(1048576, this)) == null) {
            lq6 lq6Var = this.b;
            if (lq6Var != null && lq6Var.a != null) {
                return true;
            }
            return false;
        }
        return invokeV.booleanValue;
    }

    public final void b() {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeV(Constants.METHOD_GET_CONTACTER_INFO_FOR_SESSION, this) == null) {
            ErrorData errorData = new ErrorData();
            errorData.setError_code(this.d);
            errorData.setError_msg(this.e);
            if (this.d != 0) {
                this.a.f(errorData);
            }
        }
    }

    public void d() {
        Interceptable interceptable = $ic;
        if ((interceptable != null && interceptable.invokeV(1048579, this) != null) || this.c.T()) {
            return;
        }
        this.c.loadData();
        ow6.a();
    }

    public final boolean c(lq6 lq6Var) {
        InterceptResult invokeL;
        Interceptable interceptable = $ic;
        if (interceptable == null || (invokeL = interceptable.invokeL(Constants.METHOD_SEND_USER_MSG, this, lq6Var)) == null) {
            if (lq6Var == null) {
                return false;
            }
            this.b = lq6Var;
            lq6Var.c = e(lq6Var.c);
            this.a.t1(this.b);
            return true;
        }
        return invokeL.booleanValue;
    }

    public final ArrayList<wn> e(ArrayList<wn> arrayList) {
        InterceptResult invokeL;
        Interceptable interceptable = $ic;
        if (interceptable == null || (invokeL = interceptable.invokeL(1048580, this, arrayList)) == null) {
            ArrayList<wn> arrayList2 = new ArrayList<>();
            Iterator<wn> it = arrayList.iterator();
            int i = 0;
            while (it.hasNext()) {
                wn next = it.next();
                if (next instanceof ThreadData) {
                    ThreadData threadData = (ThreadData) next;
                    AbsGroupUbsABTest.setCardInfoUbsABTest(threadData);
                    int[] imageWidthAndHeight = threadData.getImageWidthAndHeight();
                    if (threadData.getType() == ThreadData.TYPE_NORMAL && !threadData.isTop()) {
                        vu4 vu4Var = new vu4();
                        vu4Var.t = threadData;
                        vu4Var.position = i;
                        vu4Var.a = true;
                        vu4Var.setSupportType(BaseCardInfo.SupportType.CONTENT);
                        arrayList2.add(vu4Var);
                        vu4 vu4Var2 = new vu4();
                        vu4Var2.t = threadData;
                        vu4Var2.position = i;
                        if (threadData.picCount() == 1) {
                            vu4Var2.d = true;
                            vu4Var2.u = imageWidthAndHeight[0];
                            vu4Var2.v = imageWidthAndHeight[1];
                        } else if (threadData.picCount() >= 2) {
                            vu4Var2.e = true;
                        } else {
                            vu4Var2.b = true;
                        }
                        vu4Var2.setSupportType(BaseCardInfo.SupportType.CONTENT);
                        arrayList2.add(vu4Var2);
                        vu4 vu4Var3 = new vu4();
                        vu4Var3.g = true;
                        vu4Var3.t = threadData;
                        vu4Var3.position = i;
                        vu4Var3.setSupportType(BaseCardInfo.SupportType.CONTENT);
                        arrayList2.add(vu4Var3);
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

    @Override // com.baidu.tbadk.mvc.model.NetModel.m
    public void n(MvcSocketResponsedMessage mvcSocketResponsedMessage, MvcSocketMessage mvcSocketMessage, MvcNetMessage mvcNetMessage) {
        Interceptable interceptable = $ic;
        if ((interceptable != null && interceptable.invokeLLL(1048581, this, mvcSocketResponsedMessage, mvcSocketMessage, mvcNetMessage) != null) || mvcSocketResponsedMessage == null) {
            return;
        }
        lq6 lq6Var = null;
        if (!mvcSocketResponsedMessage.hasError() && (mvcSocketResponsedMessage instanceof FrsItemTabSocketResponseMessage)) {
            lq6Var = ((FrsItemTabSocketResponseMessage) mvcSocketResponsedMessage).getData();
        }
        if (lq6Var != null && c(lq6Var)) {
            return;
        }
        this.d = mvcSocketResponsedMessage.getError();
        this.e = mvcSocketResponsedMessage.getErrorString();
        b();
    }

    @Override // com.baidu.tbadk.mvc.model.NetModel.l
    public void s(MvcHttpResponsedMessage mvcHttpResponsedMessage, MvcHttpMessage mvcHttpMessage, MvcNetMessage mvcNetMessage) {
        Interceptable interceptable = $ic;
        if ((interceptable != null && interceptable.invokeLLL(1048582, this, mvcHttpResponsedMessage, mvcHttpMessage, mvcNetMessage) != null) || mvcHttpResponsedMessage == null) {
            return;
        }
        lq6 lq6Var = null;
        if (!mvcHttpResponsedMessage.hasError() && (mvcHttpResponsedMessage instanceof FrsItemTabHttpResponseMessage)) {
            lq6Var = (lq6) ((FrsItemTabHttpResponseMessage) mvcHttpResponsedMessage).getData();
        }
        if (lq6Var != null && c(lq6Var)) {
            return;
        }
        this.d = mvcHttpResponsedMessage.getError();
        this.e = mvcHttpResponsedMessage.getErrorString();
        b();
    }
}
