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
public class uz9 {
    public static /* synthetic */ Interceptable $ic;
    public transient /* synthetic */ FieldHolder $fh;

    /* loaded from: classes8.dex */
    public class a implements ix5 {
        public static /* synthetic */ Interceptable $ic;
        public transient /* synthetic */ FieldHolder $fh;
        public final /* synthetic */ k0a a;
        public final /* synthetic */ SubPbModel b;

        public a(k0a k0aVar, SubPbModel subPbModel) {
            Interceptable interceptable = $ic;
            if (interceptable != null) {
                InitContext newInitContext = TitanRuntime.newInitContext();
                newInitContext.initArgs = r2;
                Object[] objArr = {k0aVar, subPbModel};
                interceptable.invokeUnInit(65536, newInitContext);
                int i = newInitContext.flag;
                if ((i & 1) != 0) {
                    int i2 = i & 2;
                    newInitContext.thisArg = this;
                    interceptable.invokeInitBody(65536, newInitContext);
                    return;
                }
            }
            this.a = k0aVar;
            this.b = subPbModel;
        }

        @Override // com.baidu.tieba.ix5
        public void a() {
            Interceptable interceptable = $ic;
            if (interceptable == null || interceptable.invokeV(1048576, this) == null) {
                this.a.E0(false);
            }
        }

        @Override // com.baidu.tieba.ix5
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
                    if (next instanceof ura) {
                        while (true) {
                            if (i >= list.size()) {
                                break;
                            } else if (TextUtils.equals(list.get(i), ((ura) next).T())) {
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
                    if (data.get(i) instanceof t0a) {
                        ((t0a) data.get(i)).b(this.b.z0().k());
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
            hx5.b().a();
        }
    }

    public static kx5 b(SubPbModel subPbModel, k0a k0aVar) {
        InterceptResult invokeLL;
        Interceptable interceptable = $ic;
        if (interceptable == null || (invokeLL = interceptable.invokeLL(65537, null, subPbModel, k0aVar)) == null) {
            if (subPbModel != null && k0aVar != null) {
                kx5 kx5Var = new kx5();
                kx5Var.p(subPbModel.B0());
                kx5Var.o(subPbModel.A0());
                kx5Var.n(subPbModel.E0());
                if (subPbModel.z0() != null && subPbModel.z0().d() != null) {
                    kx5Var.l(subPbModel.z0().d().getId());
                    kx5Var.m(subPbModel.z0().d().getName());
                    kx5Var.k(subPbModel.z0().d().getImage_url());
                    kx5Var.t(subPbModel.z0().d().getUser_level());
                }
                UserData userData = new UserData();
                userData.setIsManager(subPbModel.G0());
                kx5Var.s(userData);
                kx5Var.q(new a(k0aVar, subPbModel));
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
                kx5Var.r(sparseArray);
                return kx5Var;
            }
            return null;
        }
        return (kx5) invokeLL.objValue;
    }

    public static boolean c(us9 us9Var, ura uraVar) {
        InterceptResult invokeLL;
        Interceptable interceptable = $ic;
        if (interceptable == null || (invokeLL = interceptable.invokeLL(65538, null, us9Var, uraVar)) == null) {
            if (us9Var != null && uraVar != null && us9Var.d() != null && us9Var.j() != null) {
                mx5 mx5Var = new mx5();
                mx5Var.d(us9Var.d().getId());
                mx5Var.f(us9Var.j().getId());
                mx5Var.e(uraVar.T());
                return hx5.b().c(mx5Var);
            }
            return false;
        }
        return invokeLL.booleanValue;
    }

    public static void d(TbPageContext tbPageContext, SubPbModel subPbModel, k0a k0aVar) {
        Interceptable interceptable = $ic;
        if ((interceptable == null || interceptable.invokeLLL(65539, null, tbPageContext, subPbModel, k0aVar) == null) && tbPageContext != null && k0aVar != null && k0aVar.u() != null && subPbModel != null) {
            hx5.b().e(tbPageContext, (ViewGroup) k0aVar.u(), b(subPbModel, k0aVar));
            hx5.b().d(3);
        }
    }

    public static boolean e(ura uraVar) {
        InterceptResult invokeL;
        Interceptable interceptable = $ic;
        if (interceptable == null || (invokeL = interceptable.invokeL(InputDeviceCompat.SOURCE_TRACKBALL, null, uraVar)) == null) {
            if (uraVar == null) {
                return false;
            }
            return hx5.b().f(uraVar.T());
        }
        return invokeL.booleanValue;
    }
}
