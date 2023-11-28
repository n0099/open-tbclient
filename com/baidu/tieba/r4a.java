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
public class r4a {
    public static /* synthetic */ Interceptable $ic;
    public transient /* synthetic */ FieldHolder $fh;

    /* loaded from: classes8.dex */
    public class a implements qx5 {
        public static /* synthetic */ Interceptable $ic;
        public transient /* synthetic */ FieldHolder $fh;
        public final /* synthetic */ f5a a;
        public final /* synthetic */ SubPbModel b;

        public a(f5a f5aVar, SubPbModel subPbModel) {
            Interceptable interceptable = $ic;
            if (interceptable != null) {
                InitContext newInitContext = TitanRuntime.newInitContext();
                newInitContext.initArgs = r2;
                Object[] objArr = {f5aVar, subPbModel};
                interceptable.invokeUnInit(65536, newInitContext);
                int i = newInitContext.flag;
                if ((i & 1) != 0) {
                    int i2 = i & 2;
                    newInitContext.thisArg = this;
                    interceptable.invokeInitBody(65536, newInitContext);
                    return;
                }
            }
            this.a = f5aVar;
            this.b = subPbModel;
        }

        @Override // com.baidu.tieba.qx5
        public void a() {
            Interceptable interceptable = $ic;
            if (interceptable == null || interceptable.invokeV(1048576, this) == null) {
                this.a.z0(false);
            }
        }

        @Override // com.baidu.tieba.qx5
        public void b(List<String> list) {
            int i;
            Interceptable interceptable = $ic;
            if ((interceptable != null && interceptable.invokeL(Constants.METHOD_GET_CONTACTER_INFO_FOR_SESSION, this, list) != null) || !(this.a.A() instanceof BdTypeListView)) {
                return;
            }
            List<pi> data = ((BdTypeListView) this.a.A()).getData();
            if (!ListUtils.isEmpty(data) && !ListUtils.isEmpty(list)) {
                Iterator<pi> it = data.iterator();
                while (true) {
                    i = 0;
                    if (!it.hasNext()) {
                        break;
                    }
                    pi next = it.next();
                    if (next instanceof nwa) {
                        while (true) {
                            if (i >= list.size()) {
                                break;
                            } else if (TextUtils.equals(list.get(i), ((nwa) next).U())) {
                                it.remove();
                                if (this.b.z0() != null) {
                                    this.b.z0().A(this.b.z0().m() - 1);
                                }
                            } else {
                                i++;
                            }
                        }
                    }
                }
                while (i < data.size()) {
                    if (data.get(i) instanceof o5a) {
                        ((o5a) data.get(i)).b(this.b.z0().m());
                    }
                    i++;
                }
                ((BdTypeListView) this.a.A()).setData(data);
                this.a.R();
            }
        }
    }

    public static void a() {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeV(65536, null) == null) {
            px5.b().a();
        }
    }

    public static sx5 b(SubPbModel subPbModel, f5a f5aVar) {
        InterceptResult invokeLL;
        Interceptable interceptable = $ic;
        if (interceptable == null || (invokeLL = interceptable.invokeLL(65537, null, subPbModel, f5aVar)) == null) {
            if (subPbModel != null && f5aVar != null) {
                sx5 sx5Var = new sx5();
                sx5Var.p(subPbModel.B0());
                sx5Var.o(subPbModel.A0());
                sx5Var.n(subPbModel.E0());
                if (subPbModel.z0() != null && subPbModel.z0().f() != null) {
                    sx5Var.l(subPbModel.z0().f().getId());
                    sx5Var.m(subPbModel.z0().f().getName());
                    sx5Var.k(subPbModel.z0().f().getImage_url());
                    sx5Var.t(subPbModel.z0().f().getUser_level());
                }
                UserData userData = new UserData();
                userData.setIsManager(subPbModel.G0());
                sx5Var.s(userData);
                sx5Var.q(new a(f5aVar, subPbModel));
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
                sx5Var.r(sparseArray);
                return sx5Var;
            }
            return null;
        }
        return (sx5) invokeLL.objValue;
    }

    public static boolean c(lw9 lw9Var, nwa nwaVar) {
        InterceptResult invokeLL;
        Interceptable interceptable = $ic;
        if (interceptable == null || (invokeLL = interceptable.invokeLL(65538, null, lw9Var, nwaVar)) == null) {
            if (lw9Var != null && nwaVar != null && lw9Var.f() != null && lw9Var.l() != null) {
                ux5 ux5Var = new ux5();
                ux5Var.d(lw9Var.f().getId());
                ux5Var.f(lw9Var.l().getId());
                ux5Var.e(nwaVar.U());
                return px5.b().c(ux5Var);
            }
            return false;
        }
        return invokeLL.booleanValue;
    }

    public static void d(TbPageContext tbPageContext, SubPbModel subPbModel, f5a f5aVar) {
        Interceptable interceptable = $ic;
        if ((interceptable == null || interceptable.invokeLLL(65539, null, tbPageContext, subPbModel, f5aVar) == null) && tbPageContext != null && f5aVar != null && f5aVar.t() != null && subPbModel != null) {
            px5.b().e(tbPageContext, (ViewGroup) f5aVar.t(), b(subPbModel, f5aVar));
            px5.b().d(3);
        }
    }

    public static boolean e(nwa nwaVar) {
        InterceptResult invokeL;
        Interceptable interceptable = $ic;
        if (interceptable == null || (invokeL = interceptable.invokeL(InputDeviceCompat.SOURCE_TRACKBALL, null, nwaVar)) == null) {
            if (nwaVar == null) {
                return false;
            }
            return px5.b().f(nwaVar.U());
        }
        return invokeL.booleanValue;
    }
}
