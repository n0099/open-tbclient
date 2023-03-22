package com.baidu.tieba.pb.pb.godreply;

import android.util.Log;
import com.baidu.adp.base.BdBaseModel;
import com.baidu.android.imsdk.internal.Constants;
import com.baidu.tbadk.core.util.ListUtils;
import com.baidu.tieba.a9;
import com.baidu.tieba.bc9;
import com.baidu.tieba.dj8;
import com.baidu.tieba.gn;
import com.baidu.tieba.ki8;
import com.baidu.tieba.pb.pb.main.PbModel;
import com.baidu.tieba.ul8;
import com.baidu.titan.sdk.runtime.FieldHolder;
import com.baidu.titan.sdk.runtime.InitContext;
import com.baidu.titan.sdk.runtime.InterceptResult;
import com.baidu.titan.sdk.runtime.Interceptable;
import com.baidu.titan.sdk.runtime.TitanRuntime;
import java.util.ArrayList;
import java.util.List;
/* loaded from: classes5.dex */
public class MoreGodReplyModel extends BdBaseModel<a9> {
    public static /* synthetic */ Interceptable $ic;
    public transient /* synthetic */ FieldHolder $fh;
    public PbModel a;
    public boolean b;
    public int c;
    public int d;
    public ul8.b e;
    public final ul8.b f;

    @Override // com.baidu.adp.base.BdBaseModel
    public boolean loadData() {
        InterceptResult invokeV;
        Interceptable interceptable = $ic;
        if (interceptable == null || (invokeV = interceptable.invokeV(1048583, this)) == null) {
            return false;
        }
        return invokeV.booleanValue;
    }

    /* loaded from: classes5.dex */
    public class a implements ul8.b {
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

        @Override // com.baidu.tieba.ul8.b
        public void a(int i, String str, String str2) {
            Interceptable interceptable = $ic;
            if (interceptable == null || interceptable.invokeILL(1048576, this, i, str, str2) == null) {
                this.a.b = false;
                if (this.a.e != null) {
                    this.a.e.a(i, str, str2);
                }
            }
        }

        @Override // com.baidu.tieba.ul8.b
        public void onSuccess(List<bc9> list) {
            dj8 V;
            Interceptable interceptable = $ic;
            if (interceptable == null || interceptable.invokeL(Constants.METHOD_GET_CONTACTER_INFO_FOR_SESSION, this, list) == null) {
                this.a.b = false;
                if (this.a.a != null && this.a.a.w1() != null && (V = this.a.a.w1().V()) != null) {
                    List<bc9> list2 = V.a;
                    int size = list2.size();
                    if (!ListUtils.isEmpty(list)) {
                        for (bc9 bc9Var : list) {
                            if (bc9Var != null && !MoreGodReplyModel.X(list2, bc9Var)) {
                                list2.add(bc9Var);
                            }
                        }
                    }
                    this.a.a.P2(this.a.a.w1(), size);
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
    public MoreGodReplyModel(a9 a9Var, PbModel pbModel) {
        super(a9Var);
        Interceptable interceptable = $ic;
        if (interceptable != null) {
            InitContext newInitContext = TitanRuntime.newInitContext();
            newInitContext.initArgs = r2;
            Object[] objArr = {a9Var, pbModel};
            interceptable.invokeUnInit(65536, newInitContext);
            int i = newInitContext.flag;
            if ((i & 1) != 0) {
                int i2 = i & 2;
                super((a9) newInitContext.callArgs[0]);
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
        ul8 s1 = pbModel.s1();
        if (s1 != null) {
            s1.f(this.f);
        }
    }

    public static boolean X(List<bc9> list, bc9 bc9Var) {
        InterceptResult invokeLL;
        Interceptable interceptable = $ic;
        if (interceptable == null || (invokeLL = interceptable.invokeLL(65543, null, list, bc9Var)) == null) {
            if (list != null && bc9Var != null) {
                for (bc9 bc9Var2 : list) {
                    if (bc9Var2 != null) {
                        if (bc9Var2 == bc9Var) {
                            return true;
                        }
                        if (bc9Var2.O() != null && bc9Var.O() != null && bc9Var2.O().equals(bc9Var.O())) {
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

    public void d0(ul8.b bVar) {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeL(1048582, this, bVar) == null) {
            this.e = bVar;
        }
    }

    public List<gn> Y() {
        InterceptResult invokeV;
        boolean z;
        Interceptable interceptable = $ic;
        if (interceptable == null || (invokeV = interceptable.invokeV(1048576, this)) == null) {
            PbModel pbModel = this.a;
            ArrayList arrayList = null;
            if (pbModel == null) {
                return null;
            }
            ki8 w1 = pbModel.w1();
            if (w1 != null && w1.V() != null && !ListUtils.isEmpty(w1.V().a)) {
                dj8 V = w1.V();
                arrayList = new ArrayList();
                List<bc9> list = V.a;
                int size = list.size();
                for (int i = 0; i < size; i++) {
                    bc9 bc9Var = list.get(i);
                    if (bc9Var != null) {
                        arrayList.add(bc9Var);
                        if (i < size - 1) {
                            z = true;
                        } else {
                            z = false;
                        }
                        bc9Var.P = z;
                    }
                }
            }
            return arrayList;
        }
        return (List) invokeV.objValue;
    }

    public PbModel Z() {
        InterceptResult invokeV;
        Interceptable interceptable = $ic;
        if (interceptable == null || (invokeV = interceptable.invokeV(Constants.METHOD_GET_CONTACTER_INFO_FOR_SESSION, this)) == null) {
            return this.a;
        }
        return (PbModel) invokeV.objValue;
    }

    public boolean b0() {
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
        if (interceptable == null || (invokeV = interceptable.invokeV(1048581, this)) == null) {
            this.b = false;
            return false;
        }
        return invokeV.booleanValue;
    }

    public boolean a0() {
        InterceptResult invokeV;
        ki8 w1;
        dj8 V;
        Interceptable interceptable = $ic;
        if (interceptable == null || (invokeV = interceptable.invokeV(Constants.METHOD_SEND_USER_MSG, this)) == null) {
            PbModel pbModel = this.a;
            if (pbModel == null || (w1 = pbModel.w1()) == null || (V = w1.V()) == null) {
                return false;
            }
            if (this.d < 0) {
                this.d = V.a();
            }
            if (V.b.size() <= this.d || V.a.size() >= 100) {
                return false;
            }
            return true;
        }
        return invokeV.booleanValue;
    }

    public boolean c0() {
        InterceptResult invokeV;
        dj8 V;
        Interceptable interceptable = $ic;
        if (interceptable == null || (invokeV = interceptable.invokeV(1048580, this)) == null) {
            ki8 w1 = this.a.w1();
            if (w1 == null || (V = w1.V()) == null) {
                return false;
            }
            if (this.d < 0) {
                this.d = V.a();
            }
            List<Long> list = V.b;
            int size = list.size();
            int i = this.d;
            if (size <= i || V.a.size() >= 100) {
                return false;
            }
            int min = Math.min(100, Math.min(i + 20, size));
            this.c = min;
            this.b = true;
            this.a.s1().c(list.subList(i, min));
            Log.d("more_god_reply", "load from " + i + " to " + min);
            return true;
        }
        return invokeV.booleanValue;
    }
}
