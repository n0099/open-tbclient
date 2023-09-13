package com.baidu.tieba.pb.pb.godreply;

import android.util.Log;
import com.baidu.adp.base.BdBaseModel;
import com.baidu.adp.base.BdPageContext;
import com.baidu.android.imsdk.internal.Constants;
import com.baidu.tbadk.core.util.ListUtils;
import com.baidu.tieba.aj9;
import com.baidu.tieba.cn;
import com.baidu.tieba.fn9;
import com.baidu.tieba.pb.pb.main.PbModel;
import com.baidu.tieba.tha;
import com.baidu.tieba.uj9;
import com.baidu.titan.sdk.runtime.FieldHolder;
import com.baidu.titan.sdk.runtime.InitContext;
import com.baidu.titan.sdk.runtime.InterceptResult;
import com.baidu.titan.sdk.runtime.Interceptable;
import com.baidu.titan.sdk.runtime.TitanRuntime;
import java.util.ArrayList;
import java.util.List;
/* loaded from: classes7.dex */
public class MoreGodReplyModel extends BdBaseModel<BdPageContext> {
    public static /* synthetic */ Interceptable $ic;
    public transient /* synthetic */ FieldHolder $fh;
    public PbModel a;
    public boolean b;
    public int c;
    public int d;
    public fn9.b e;
    public final fn9.b f;

    @Override // com.baidu.adp.base.BdBaseModel
    public boolean loadData() {
        InterceptResult invokeV;
        Interceptable interceptable = $ic;
        if (interceptable == null || (invokeV = interceptable.invokeV(1048583, this)) == null) {
            return false;
        }
        return invokeV.booleanValue;
    }

    /* loaded from: classes7.dex */
    public class a implements fn9.b {
        public static /* synthetic */ Interceptable $ic;
        public transient /* synthetic */ FieldHolder $fh;
        public final /* synthetic */ MoreGodReplyModel a;

        public a(MoreGodReplyModel moreGodReplyModel) {
            Interceptable interceptable = $ic;
            if (interceptable != null) {
                InitContext newInitContext = TitanRuntime.newInitContext();
                newInitContext.initArgs = r2;
                Object[] objArr = {moreGodReplyModel};
                interceptable.invokeUnInit(65536, newInitContext);
                int i = newInitContext.flag;
                if ((i & 1) != 0) {
                    int i2 = i & 2;
                    newInitContext.thisArg = this;
                    interceptable.invokeInitBody(65536, newInitContext);
                    return;
                }
            }
            this.a = moreGodReplyModel;
        }

        @Override // com.baidu.tieba.fn9.b
        public void a(int i, String str, String str2) {
            Interceptable interceptable = $ic;
            if (interceptable == null || interceptable.invokeILL(1048576, this, i, str, str2) == null) {
                this.a.b = false;
                if (this.a.e != null) {
                    this.a.e.a(i, str, str2);
                }
            }
        }

        @Override // com.baidu.tieba.fn9.b
        public void onSuccess(List<tha> list) {
            uj9 T2;
            Interceptable interceptable = $ic;
            if (interceptable == null || interceptable.invokeL(Constants.METHOD_GET_CONTACTER_INFO_FOR_SESSION, this, list) == null) {
                this.a.b = false;
                if (this.a.a != null && this.a.a.r1() != null && (T2 = this.a.a.r1().T()) != null) {
                    List<tha> list2 = T2.a;
                    int size = list2.size();
                    if (!ListUtils.isEmpty(list)) {
                        for (tha thaVar : list) {
                            if (thaVar != null && !MoreGodReplyModel.S(list2, thaVar)) {
                                list2.add(thaVar);
                            }
                        }
                    }
                    this.a.a.G2(this.a.a.r1(), size);
                }
                if (this.a.c > 0) {
                    MoreGodReplyModel moreGodReplyModel = this.a;
                    moreGodReplyModel.d = moreGodReplyModel.c;
                }
                if (this.a.e != null) {
                    this.a.e.onSuccess(list);
                }
            }
        }
    }

    /* JADX WARN: 'super' call moved to the top of the method (can break code semantics) */
    public MoreGodReplyModel(BdPageContext bdPageContext, PbModel pbModel) {
        super(bdPageContext);
        Interceptable interceptable = $ic;
        if (interceptable != null) {
            InitContext newInitContext = TitanRuntime.newInitContext();
            newInitContext.initArgs = r2;
            Object[] objArr = {bdPageContext, pbModel};
            interceptable.invokeUnInit(65536, newInitContext);
            int i = newInitContext.flag;
            if ((i & 1) != 0) {
                int i2 = i & 2;
                super((BdPageContext) newInitContext.callArgs[0]);
                newInitContext.thisArg = this;
                interceptable.invokeInitBody(65536, newInitContext);
                return;
            }
        }
        this.b = false;
        this.c = -1;
        this.d = -1;
        this.f = new a(this);
        if (pbModel == null) {
            return;
        }
        this.a = pbModel;
        fn9 n1 = pbModel.n1();
        if (n1 != null) {
            n1.f(this.f);
        }
    }

    public static boolean S(List<tha> list, tha thaVar) {
        InterceptResult invokeLL;
        Interceptable interceptable = $ic;
        if (interceptable == null || (invokeLL = interceptable.invokeLL(65543, null, list, thaVar)) == null) {
            if (list != null && thaVar != null) {
                for (tha thaVar2 : list) {
                    if (thaVar2 != null) {
                        if (thaVar2 == thaVar) {
                            return true;
                        }
                        if (thaVar2.U() != null && thaVar.U() != null && thaVar2.U().equals(thaVar.U())) {
                            return true;
                        }
                    }
                }
                return false;
            }
            return false;
        }
        return invokeLL.booleanValue;
    }

    public void Y(fn9.b bVar) {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeL(1048581, this, bVar) == null) {
            this.e = bVar;
        }
    }

    public List<cn> T() {
        InterceptResult invokeV;
        boolean z;
        Interceptable interceptable = $ic;
        if (interceptable == null || (invokeV = interceptable.invokeV(1048576, this)) == null) {
            PbModel pbModel = this.a;
            ArrayList arrayList = null;
            if (pbModel == null) {
                return null;
            }
            aj9 r1 = pbModel.r1();
            if (r1 != null && r1.T() != null && !ListUtils.isEmpty(r1.T().a)) {
                uj9 T2 = r1.T();
                arrayList = new ArrayList();
                List<tha> list = T2.a;
                int size = list.size();
                for (int i = 0; i < size; i++) {
                    tha thaVar = list.get(i);
                    if (thaVar != null) {
                        arrayList.add(thaVar);
                        if (i < size - 1) {
                            z = true;
                        } else {
                            z = false;
                        }
                        thaVar.P = z;
                    }
                }
            }
            return arrayList;
        }
        return (List) invokeV.objValue;
    }

    public PbModel U() {
        InterceptResult invokeV;
        Interceptable interceptable = $ic;
        if (interceptable == null || (invokeV = interceptable.invokeV(Constants.METHOD_GET_CONTACTER_INFO_FOR_SESSION, this)) == null) {
            return this.a;
        }
        return (PbModel) invokeV.objValue;
    }

    public boolean W() {
        InterceptResult invokeV;
        Interceptable interceptable = $ic;
        if (interceptable == null || (invokeV = interceptable.invokeV(1048579, this)) == null) {
            return this.b;
        }
        return invokeV.booleanValue;
    }

    @Override // com.baidu.adp.base.BdBaseModel
    public boolean cancelLoadData() {
        InterceptResult invokeV;
        Interceptable interceptable = $ic;
        if (interceptable == null || (invokeV = interceptable.invokeV(1048582, this)) == null) {
            this.b = false;
            return false;
        }
        return invokeV.booleanValue;
    }

    public boolean V() {
        InterceptResult invokeV;
        aj9 r1;
        uj9 T2;
        Interceptable interceptable = $ic;
        if (interceptable == null || (invokeV = interceptable.invokeV(Constants.METHOD_SEND_USER_MSG, this)) == null) {
            PbModel pbModel = this.a;
            if (pbModel == null || (r1 = pbModel.r1()) == null || (T2 = r1.T()) == null) {
                return false;
            }
            if (this.d < 0) {
                this.d = T2.a();
            }
            if (T2.b.size() <= this.d || T2.a.size() >= 100) {
                return false;
            }
            return true;
        }
        return invokeV.booleanValue;
    }

    public boolean X() {
        InterceptResult invokeV;
        uj9 T2;
        Interceptable interceptable = $ic;
        if (interceptable == null || (invokeV = interceptable.invokeV(1048580, this)) == null) {
            aj9 r1 = this.a.r1();
            if (r1 == null || (T2 = r1.T()) == null) {
                return false;
            }
            if (this.d < 0) {
                this.d = T2.a();
            }
            List<Long> list = T2.b;
            int size = list.size();
            int i = this.d;
            if (size <= i || T2.a.size() >= 100) {
                return false;
            }
            int min = Math.min(100, Math.min(i + 20, size));
            this.c = min;
            this.b = true;
            this.a.n1().c(list.subList(i, min));
            Log.d("more_god_reply", "load from " + i + " to " + min);
            return true;
        }
        return invokeV.booleanValue;
    }
}
