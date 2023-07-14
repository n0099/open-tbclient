package com.baidu.tieba.pb.pb.godreply;

import android.util.Log;
import com.baidu.adp.base.BdBaseModel;
import com.baidu.android.imsdk.internal.Constants;
import com.baidu.tbadk.core.util.ListUtils;
import com.baidu.tieba.l9;
import com.baidu.tieba.pb.pb.main.PbModel;
import com.baidu.tieba.pi9;
import com.baidu.tieba.tf9;
import com.baidu.tieba.yca;
import com.baidu.tieba.yn;
import com.baidu.tieba.ze9;
import com.baidu.titan.sdk.runtime.FieldHolder;
import com.baidu.titan.sdk.runtime.InitContext;
import com.baidu.titan.sdk.runtime.InterceptResult;
import com.baidu.titan.sdk.runtime.Interceptable;
import com.baidu.titan.sdk.runtime.TitanRuntime;
import java.util.ArrayList;
import java.util.List;
/* loaded from: classes7.dex */
public class MoreGodReplyModel extends BdBaseModel<l9> {
    public static /* synthetic */ Interceptable $ic;
    public transient /* synthetic */ FieldHolder $fh;
    public PbModel a;
    public boolean b;
    public int c;
    public int d;
    public pi9.b e;
    public final pi9.b f;

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
    public class a implements pi9.b {
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

        @Override // com.baidu.tieba.pi9.b
        public void a(int i, String str, String str2) {
            Interceptable interceptable = $ic;
            if (interceptable == null || interceptable.invokeILL(1048576, this, i, str, str2) == null) {
                this.a.b = false;
                if (this.a.e != null) {
                    this.a.e.a(i, str, str2);
                }
            }
        }

        @Override // com.baidu.tieba.pi9.b
        public void onSuccess(List<yca> list) {
            tf9 S;
            Interceptable interceptable = $ic;
            if (interceptable == null || interceptable.invokeL(Constants.METHOD_GET_CONTACTER_INFO_FOR_SESSION, this, list) == null) {
                this.a.b = false;
                if (this.a.a != null && this.a.a.z1() != null && (S = this.a.a.z1().S()) != null) {
                    List<yca> list2 = S.a;
                    int size = list2.size();
                    if (!ListUtils.isEmpty(list)) {
                        for (yca ycaVar : list) {
                            if (ycaVar != null && !MoreGodReplyModel.b0(list2, ycaVar)) {
                                list2.add(ycaVar);
                            }
                        }
                    }
                    this.a.a.M2(this.a.a.z1(), size);
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
    public MoreGodReplyModel(l9 l9Var, PbModel pbModel) {
        super(l9Var);
        Interceptable interceptable = $ic;
        if (interceptable != null) {
            InitContext newInitContext = TitanRuntime.newInitContext();
            newInitContext.initArgs = r2;
            Object[] objArr = {l9Var, pbModel};
            interceptable.invokeUnInit(65536, newInitContext);
            int i = newInitContext.flag;
            if ((i & 1) != 0) {
                int i2 = i & 2;
                super((l9) newInitContext.callArgs[0]);
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
        pi9 v1 = pbModel.v1();
        if (v1 != null) {
            v1.f(this.f);
        }
    }

    public static boolean b0(List<yca> list, yca ycaVar) {
        InterceptResult invokeLL;
        Interceptable interceptable = $ic;
        if (interceptable == null || (invokeLL = interceptable.invokeLL(65543, null, list, ycaVar)) == null) {
            if (list != null && ycaVar != null) {
                for (yca ycaVar2 : list) {
                    if (ycaVar2 != null) {
                        if (ycaVar2 == ycaVar) {
                            return true;
                        }
                        if (ycaVar2.S() != null && ycaVar.S() != null && ycaVar2.S().equals(ycaVar.S())) {
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

    public void h0(pi9.b bVar) {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeL(1048582, this, bVar) == null) {
            this.e = bVar;
        }
    }

    public List<yn> c0() {
        InterceptResult invokeV;
        boolean z;
        Interceptable interceptable = $ic;
        if (interceptable == null || (invokeV = interceptable.invokeV(1048576, this)) == null) {
            PbModel pbModel = this.a;
            ArrayList arrayList = null;
            if (pbModel == null) {
                return null;
            }
            ze9 z1 = pbModel.z1();
            if (z1 != null && z1.S() != null && !ListUtils.isEmpty(z1.S().a)) {
                tf9 S = z1.S();
                arrayList = new ArrayList();
                List<yca> list = S.a;
                int size = list.size();
                for (int i = 0; i < size; i++) {
                    yca ycaVar = list.get(i);
                    if (ycaVar != null) {
                        arrayList.add(ycaVar);
                        if (i < size - 1) {
                            z = true;
                        } else {
                            z = false;
                        }
                        ycaVar.P = z;
                    }
                }
            }
            return arrayList;
        }
        return (List) invokeV.objValue;
    }

    @Override // com.baidu.adp.base.BdBaseModel
    public boolean cancelLoadData() {
        InterceptResult invokeV;
        Interceptable interceptable = $ic;
        if (interceptable == null || (invokeV = interceptable.invokeV(Constants.METHOD_GET_CONTACTER_INFO_FOR_SESSION, this)) == null) {
            this.b = false;
            return false;
        }
        return invokeV.booleanValue;
    }

    public PbModel d0() {
        InterceptResult invokeV;
        Interceptable interceptable = $ic;
        if (interceptable == null || (invokeV = interceptable.invokeV(Constants.METHOD_SEND_USER_MSG, this)) == null) {
            return this.a;
        }
        return (PbModel) invokeV.objValue;
    }

    public boolean f0() {
        InterceptResult invokeV;
        Interceptable interceptable = $ic;
        if (interceptable == null || (invokeV = interceptable.invokeV(1048580, this)) == null) {
            return this.b;
        }
        return invokeV.booleanValue;
    }

    public boolean e0() {
        InterceptResult invokeV;
        ze9 z1;
        tf9 S;
        Interceptable interceptable = $ic;
        if (interceptable == null || (invokeV = interceptable.invokeV(1048579, this)) == null) {
            PbModel pbModel = this.a;
            if (pbModel == null || (z1 = pbModel.z1()) == null || (S = z1.S()) == null) {
                return false;
            }
            if (this.d < 0) {
                this.d = S.a();
            }
            if (S.b.size() <= this.d || S.a.size() >= 100) {
                return false;
            }
            return true;
        }
        return invokeV.booleanValue;
    }

    public boolean g0() {
        InterceptResult invokeV;
        tf9 S;
        Interceptable interceptable = $ic;
        if (interceptable == null || (invokeV = interceptable.invokeV(1048581, this)) == null) {
            ze9 z1 = this.a.z1();
            if (z1 == null || (S = z1.S()) == null) {
                return false;
            }
            if (this.d < 0) {
                this.d = S.a();
            }
            List<Long> list = S.b;
            int size = list.size();
            int i = this.d;
            if (size <= i || S.a.size() >= 100) {
                return false;
            }
            int min = Math.min(100, Math.min(i + 20, size));
            this.c = min;
            this.b = true;
            this.a.v1().c(list.subList(i, min));
            Log.d("more_god_reply", "load from " + i + " to " + min);
            return true;
        }
        return invokeV.booleanValue;
    }
}
