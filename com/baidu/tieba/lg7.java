package com.baidu.tieba;

import android.view.View;
import com.baidu.android.imsdk.internal.Constants;
import com.baidu.tbadk.core.data.ThreadData;
import com.baidu.tbadk.core.util.ListUtils;
import com.baidu.tieba.tbadkCore.FrsRequestData;
import com.baidu.tieba.tbadkCore.FrsViewData;
import com.baidu.titan.sdk.runtime.FieldHolder;
import com.baidu.titan.sdk.runtime.InitContext;
import com.baidu.titan.sdk.runtime.InterceptResult;
import com.baidu.titan.sdk.runtime.Interceptable;
import com.baidu.titan.sdk.runtime.TitanRuntime;
import java.util.ArrayList;
import java.util.Iterator;
/* loaded from: classes7.dex */
public class lg7 implements zh7 {
    public static /* synthetic */ Interceptable $ic;
    public transient /* synthetic */ FieldHolder $fh;

    @Override // com.baidu.tieba.zh7
    public boolean e(int i) {
        InterceptResult invokeI;
        Interceptable interceptable = $ic;
        if (interceptable == null || (invokeI = interceptable.invokeI(1048580, this, i)) == null) {
            return false;
        }
        return invokeI.booleanValue;
    }

    public lg7() {
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

    @Override // com.baidu.tieba.zh7
    public void a(rr7 rr7Var, FrsViewData frsViewData) {
        Interceptable interceptable = $ic;
        if ((interceptable == null || interceptable.invokeLL(1048576, this, rr7Var, frsViewData) == null) && rr7Var != null && frsViewData != null) {
            ArrayList<yh> threadList = frsViewData.getThreadList();
            if (ListUtils.isEmpty(threadList)) {
                return;
            }
            ArrayList arrayList = new ArrayList();
            Iterator<yh> it = threadList.iterator();
            while (it.hasNext()) {
                yh next = it.next();
                if (next.getType() == ThreadData.TYPE_TOP) {
                    arrayList.add(next);
                }
            }
            frsViewData.setTopThreadList(arrayList);
        }
    }

    @Override // com.baidu.tieba.zh7
    public void b(View view2) {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeL(Constants.METHOD_GET_CONTACTER_INFO_FOR_SESSION, this, view2) == null) {
            view2.setVisibility(8);
        }
    }

    @Override // com.baidu.tieba.zh7
    public void c(rr7 rr7Var, ed7 ed7Var, FrsViewData frsViewData) {
        Interceptable interceptable = $ic;
        if ((interceptable == null || interceptable.invokeLLL(Constants.METHOD_SEND_USER_MSG, this, rr7Var, ed7Var, frsViewData) == null) && rr7Var != null && ed7Var != null && frsViewData != null) {
            rr7Var.J();
            if (frsViewData != null && frsViewData.getForum() != null) {
                ed7Var.i1(frsViewData.getForum().getFrsBannerData());
            }
        }
    }

    @Override // com.baidu.tieba.zh7
    public int d(int i, FrsRequestData frsRequestData) {
        InterceptResult invokeIL;
        Interceptable interceptable = $ic;
        if (interceptable == null || (invokeIL = interceptable.invokeIL(1048579, this, i, frsRequestData)) == null) {
            return er7.e(i, frsRequestData);
        }
        return invokeIL.intValue;
    }
}
