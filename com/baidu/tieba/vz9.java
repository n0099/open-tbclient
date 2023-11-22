package com.baidu.tieba;

import android.text.TextUtils;
import android.util.SparseArray;
import android.view.ViewGroup;
import androidx.core.view.InputDeviceCompat;
import com.baidu.adp.widget.ListView.BdTypeListView;
import com.baidu.android.imsdk.internal.Constants;
import com.baidu.tbadk.TbPageContext;
import com.baidu.tbadk.core.data.AntiData;
import com.baidu.tbadk.core.data.DeleteThreadInfo;
import com.baidu.tbadk.core.data.UserData;
import com.baidu.tbadk.core.util.ListUtils;
import com.baidu.tieba.pb.pb.sub.SubPbModel;
import com.baidu.titan.sdk.runtime.FieldHolder;
import com.baidu.titan.sdk.runtime.InitContext;
import com.baidu.titan.sdk.runtime.InterceptResult;
import com.baidu.titan.sdk.runtime.Interceptable;
import com.baidu.titan.sdk.runtime.TitanRuntime;
import java.util.Iterator;
import java.util.List;
/* loaded from: classes8.dex */
public class vz9 {
    public static /* synthetic */ Interceptable $ic;
    public transient /* synthetic */ FieldHolder $fh;

    /* loaded from: classes8.dex */
    public class a implements jx5 {
        public static /* synthetic */ Interceptable $ic;
        public transient /* synthetic */ FieldHolder $fh;
        public final /* synthetic */ l0a a;
        public final /* synthetic */ SubPbModel b;

        public a(l0a l0aVar, SubPbModel subPbModel) {
            Interceptable interceptable = $ic;
            if (interceptable != null) {
                InitContext newInitContext = TitanRuntime.newInitContext();
                newInitContext.initArgs = r2;
                Object[] objArr = {l0aVar, subPbModel};
                interceptable.invokeUnInit(65536, newInitContext);
                int i = newInitContext.flag;
                if ((i & 1) != 0) {
                    int i2 = i & 2;
                    newInitContext.thisArg = this;
                    interceptable.invokeInitBody(65536, newInitContext);
                    return;
                }
            }
            this.a = l0aVar;
            this.b = subPbModel;
        }

        @Override // com.baidu.tieba.jx5
        public void a() {
            Interceptable interceptable = $ic;
            if (interceptable == null || interceptable.invokeV(1048576, this) == null) {
                this.a.E0(false);
            }
        }

        @Override // com.baidu.tieba.jx5
        public void b(List<String> list) {
            int i;
            Interceptable interceptable = $ic;
            if ((interceptable != null && interceptable.invokeL(Constants.METHOD_GET_CONTACTER_INFO_FOR_SESSION, this, list) != null) || !(this.a.B() instanceof BdTypeListView)) {
                return;
            }
            List<oi> data = ((BdTypeListView) this.a.B()).getData();
            if (!ListUtils.isEmpty(data) && !ListUtils.isEmpty(list)) {
                Iterator<oi> it = data.iterator();
                while (true) {
                    i = 0;
                    if (!it.hasNext()) {
                        break;
                    }
                    oi next = it.next();
                    if (next instanceof vra) {
                        while (true) {
                            if (i >= list.size()) {
                                break;
                            } else if (TextUtils.equals(list.get(i), ((vra) next).T())) {
                                it.remove();
                                if (this.b.z0() != null) {
                                    this.b.z0().A(this.b.z0().k() - 1);
                                }
                            } else {
                                i++;
                            }
                        }
                    }
                }
                while (i < data.size()) {
                    if (data.get(i) instanceof u0a) {
                        ((u0a) data.get(i)).b(this.b.z0().k());
                    }
                    i++;
                }
                ((BdTypeListView) this.a.B()).setData(data);
                this.a.T();
            }
        }
    }

    public static void a() {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeV(65536, null) == null) {
            ix5.b().a();
        }
    }

    public static lx5 b(SubPbModel subPbModel, l0a l0aVar) {
        InterceptResult invokeLL;
        Interceptable interceptable = $ic;
        if (interceptable == null || (invokeLL = interceptable.invokeLL(65537, null, subPbModel, l0aVar)) == null) {
            if (subPbModel != null && l0aVar != null) {
                lx5 lx5Var = new lx5();
                lx5Var.p(subPbModel.B0());
                lx5Var.o(subPbModel.A0());
                lx5Var.n(subPbModel.E0());
                if (subPbModel.z0() != null && subPbModel.z0().d() != null) {
                    lx5Var.l(subPbModel.z0().d().getId());
                    lx5Var.m(subPbModel.z0().d().getName());
                    lx5Var.k(subPbModel.z0().d().getImage_url());
                    lx5Var.t(subPbModel.z0().d().getUser_level());
                }
                UserData userData = new UserData();
                userData.setIsManager(subPbModel.G0());
                lx5Var.s(userData);
                lx5Var.q(new a(l0aVar, subPbModel));
                AntiData x0 = subPbModel.x0();
                SparseArray<String> sparseArray = new SparseArray<>();
                if (x0 != null && x0.getDelThreadInfoList() != null) {
                    List<DeleteThreadInfo> delThreadInfoList = x0.getDelThreadInfoList();
                    for (int i = 0; i < delThreadInfoList.size(); i++) {
                        if (delThreadInfoList.get(i) != null && !TextUtils.isEmpty(delThreadInfoList.get(i).text_info)) {
                            sparseArray.put(delThreadInfoList.get(i).text_id, delThreadInfoList.get(i).text_info);
                        }
                    }
                }
                lx5Var.r(sparseArray);
                return lx5Var;
            }
            return null;
        }
        return (lx5) invokeLL.objValue;
    }

    public static boolean c(vs9 vs9Var, vra vraVar) {
        InterceptResult invokeLL;
        Interceptable interceptable = $ic;
        if (interceptable == null || (invokeLL = interceptable.invokeLL(65538, null, vs9Var, vraVar)) == null) {
            if (vs9Var != null && vraVar != null && vs9Var.d() != null && vs9Var.j() != null) {
                nx5 nx5Var = new nx5();
                nx5Var.d(vs9Var.d().getId());
                nx5Var.f(vs9Var.j().getId());
                nx5Var.e(vraVar.T());
                return ix5.b().c(nx5Var);
            }
            return false;
        }
        return invokeLL.booleanValue;
    }

    public static void d(TbPageContext tbPageContext, SubPbModel subPbModel, l0a l0aVar) {
        Interceptable interceptable = $ic;
        if ((interceptable == null || interceptable.invokeLLL(65539, null, tbPageContext, subPbModel, l0aVar) == null) && tbPageContext != null && l0aVar != null && l0aVar.u() != null && subPbModel != null) {
            ix5.b().e(tbPageContext, (ViewGroup) l0aVar.u(), b(subPbModel, l0aVar));
            ix5.b().d(3);
        }
    }

    public static boolean e(vra vraVar) {
        InterceptResult invokeL;
        Interceptable interceptable = $ic;
        if (interceptable == null || (invokeL = interceptable.invokeL(InputDeviceCompat.SOURCE_TRACKBALL, null, vraVar)) == null) {
            if (vraVar == null) {
                return false;
            }
            return ix5.b().f(vraVar.T());
        }
        return invokeL.booleanValue;
    }
}
