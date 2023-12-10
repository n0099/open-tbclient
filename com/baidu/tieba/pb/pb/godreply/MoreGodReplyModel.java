package com.baidu.tieba.pb.pb.godreply;

import android.util.Log;
import com.baidu.adp.base.BdBaseModel;
import com.baidu.adp.base.BdPageContext;
import com.baidu.android.imsdk.internal.Constants;
import com.baidu.tbadk.core.util.ListUtils;
import com.baidu.tieba.aw9;
import com.baidu.tieba.bw9;
import com.baidu.tieba.nwa;
import com.baidu.tieba.pb.pb.main.PbModel;
import com.baidu.tieba.pi;
import com.baidu.tieba.tw9;
import com.baidu.tieba.v0a;
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
    public v0a.b e;
    public final v0a.b f;

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
    public class a implements v0a.b {
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

        @Override // com.baidu.tieba.v0a.b
        public void a(int i, String str, String str2) {
            Interceptable interceptable = $ic;
            if (interceptable == null || interceptable.invokeILL(1048576, this, i, str, str2) == null) {
                this.a.b = false;
                if (this.a.e != null) {
                    this.a.e.a(i, str, str2);
                }
            }
        }

        @Override // com.baidu.tieba.v0a.b
        public void onSuccess(List<nwa> list) {
            tw9 W;
            Interceptable interceptable = $ic;
            if (interceptable == null || interceptable.invokeL(Constants.METHOD_GET_CONTACTER_INFO_FOR_SESSION, this, list) == null) {
                this.a.b = false;
                if (this.a.a != null && this.a.a.s1() != null && (W = this.a.a.s1().W()) != null) {
                    List<nwa> list2 = W.a;
                    int size = list2.size();
                    if (!ListUtils.isEmpty(list)) {
                        for (nwa nwaVar : list) {
                            if (nwaVar != null && !MoreGodReplyModel.U(list2, nwaVar)) {
                                list2.add(nwaVar);
                            }
                        }
                    }
                    bw9.i(this.a.a.s1(), size);
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
        v0a o1 = pbModel.o1();
        if (o1 != null) {
            o1.f(this.f);
        }
    }

    public static boolean U(List<nwa> list, nwa nwaVar) {
        InterceptResult invokeLL;
        Interceptable interceptable = $ic;
        if (interceptable == null || (invokeLL = interceptable.invokeLL(65543, null, list, nwaVar)) == null) {
            if (list != null && nwaVar != null) {
                for (nwa nwaVar2 : list) {
                    if (nwaVar2 != null) {
                        if (nwaVar2 == nwaVar) {
                            return true;
                        }
                        if (nwaVar2.U() != null && nwaVar.U() != null && nwaVar2.U().equals(nwaVar.U())) {
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

    public void a0(v0a.b bVar) {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeL(1048581, this, bVar) == null) {
            this.e = bVar;
        }
    }

    public List<pi> V() {
        InterceptResult invokeV;
        boolean z;
        Interceptable interceptable = $ic;
        if (interceptable == null || (invokeV = interceptable.invokeV(1048576, this)) == null) {
            PbModel pbModel = this.a;
            ArrayList arrayList = null;
            if (pbModel == null) {
                return null;
            }
            aw9 s1 = pbModel.s1();
            if (s1 != null && s1.W() != null && !ListUtils.isEmpty(s1.W().a)) {
                tw9 W = s1.W();
                arrayList = new ArrayList();
                List<nwa> list = W.a;
                int size = list.size();
                for (int i = 0; i < size; i++) {
                    nwa nwaVar = list.get(i);
                    if (nwaVar != null) {
                        arrayList.add(nwaVar);
                        if (i < size - 1) {
                            z = true;
                        } else {
                            z = false;
                        }
                        nwaVar.P = z;
                    }
                }
            }
            return arrayList;
        }
        return (List) invokeV.objValue;
    }

    public PbModel W() {
        InterceptResult invokeV;
        Interceptable interceptable = $ic;
        if (interceptable == null || (invokeV = interceptable.invokeV(Constants.METHOD_GET_CONTACTER_INFO_FOR_SESSION, this)) == null) {
            return this.a;
        }
        return (PbModel) invokeV.objValue;
    }

    public boolean Y() {
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

    public boolean X() {
        InterceptResult invokeV;
        aw9 s1;
        tw9 W;
        Interceptable interceptable = $ic;
        if (interceptable == null || (invokeV = interceptable.invokeV(Constants.METHOD_SEND_USER_MSG, this)) == null) {
            PbModel pbModel = this.a;
            if (pbModel == null || (s1 = pbModel.s1()) == null || (W = s1.W()) == null) {
                return false;
            }
            if (this.d < 0) {
                this.d = W.a();
            }
            if (W.b.size() <= this.d || W.a.size() >= 100) {
                return false;
            }
            return true;
        }
        return invokeV.booleanValue;
    }

    public boolean Z() {
        InterceptResult invokeV;
        tw9 W;
        Interceptable interceptable = $ic;
        if (interceptable == null || (invokeV = interceptable.invokeV(1048580, this)) == null) {
            aw9 s1 = this.a.s1();
            if (s1 == null || (W = s1.W()) == null) {
                return false;
            }
            if (this.d < 0) {
                this.d = W.a();
            }
            List<Long> list = W.b;
            int size = list.size();
            int i = this.d;
            if (size <= i || W.a.size() >= 100) {
                return false;
            }
            int min = Math.min(100, Math.min(i + 20, size));
            this.c = min;
            this.b = true;
            this.a.o1().c(list.subList(i, min));
            Log.d("more_god_reply", "load from " + i + " to " + min);
            return true;
        }
        return invokeV.booleanValue;
    }
}
