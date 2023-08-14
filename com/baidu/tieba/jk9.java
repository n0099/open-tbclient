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
/* loaded from: classes6.dex */
public class jk9 {
    public static /* synthetic */ Interceptable $ic;
    public transient /* synthetic */ FieldHolder $fh;

    /* loaded from: classes6.dex */
    public static class a implements qz5 {
        public static /* synthetic */ Interceptable $ic;
        public transient /* synthetic */ FieldHolder $fh;
        public final /* synthetic */ zk9 a;
        public final /* synthetic */ SubPbModel b;

        public a(zk9 zk9Var, SubPbModel subPbModel) {
            Interceptable interceptable = $ic;
            if (interceptable != null) {
                InitContext newInitContext = TitanRuntime.newInitContext();
                newInitContext.initArgs = r2;
                Object[] objArr = {zk9Var, subPbModel};
                interceptable.invokeUnInit(65536, newInitContext);
                int i = newInitContext.flag;
                if ((i & 1) != 0) {
                    int i2 = i & 2;
                    newInitContext.thisArg = this;
                    interceptable.invokeInitBody(65536, newInitContext);
                    return;
                }
            }
            this.a = zk9Var;
            this.b = subPbModel;
        }

        @Override // com.baidu.tieba.qz5
        public void a() {
            Interceptable interceptable = $ic;
            if (interceptable == null || interceptable.invokeV(1048576, this) == null) {
                this.a.E0(false);
            }
        }

        @Override // com.baidu.tieba.qz5
        public void b(List<String> list) {
            int i;
            Interceptable interceptable = $ic;
            if ((interceptable != null && interceptable.invokeL(Constants.METHOD_GET_CONTACTER_INFO_FOR_SESSION, this, list) != null) || !(this.a.B() instanceof BdTypeListView)) {
                return;
            }
            List<ym> data = ((BdTypeListView) this.a.B()).getData();
            if (!ListUtils.isEmpty(data) && !ListUtils.isEmpty(list)) {
                Iterator<ym> it = data.iterator();
                while (true) {
                    i = 0;
                    if (!it.hasNext()) {
                        break;
                    }
                    ym next = it.next();
                    if (next instanceof rba) {
                        while (true) {
                            if (i >= list.size()) {
                                break;
                            } else if (TextUtils.equals(list.get(i), ((rba) next).S())) {
                                it.remove();
                                if (this.b.y0() != null) {
                                    this.b.y0().A(this.b.y0().k() - 1);
                                }
                            } else {
                                i++;
                            }
                        }
                    }
                }
                while (i < data.size()) {
                    if (data.get(i) instanceof il9) {
                        ((il9) data.get(i)).b(this.b.y0().k());
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
            pz5.b().a();
        }
    }

    public static sz5 b(SubPbModel subPbModel, zk9 zk9Var) {
        InterceptResult invokeLL;
        Interceptable interceptable = $ic;
        if (interceptable == null || (invokeLL = interceptable.invokeLL(65537, null, subPbModel, zk9Var)) == null) {
            if (subPbModel != null && zk9Var != null) {
                sz5 sz5Var = new sz5();
                sz5Var.p(subPbModel.A0());
                sz5Var.o(subPbModel.z0());
                sz5Var.n(subPbModel.D0());
                if (subPbModel.y0() != null && subPbModel.y0().d() != null) {
                    sz5Var.l(subPbModel.y0().d().getId());
                    sz5Var.m(subPbModel.y0().d().getName());
                    sz5Var.k(subPbModel.y0().d().getImage_url());
                    sz5Var.t(subPbModel.y0().d().getUser_level());
                }
                UserData userData = new UserData();
                userData.setIsManager(subPbModel.F0());
                sz5Var.s(userData);
                sz5Var.q(new a(zk9Var, subPbModel));
                AntiData w0 = subPbModel.w0();
                SparseArray<String> sparseArray = new SparseArray<>();
                if (w0 != null && w0.getDelThreadInfoList() != null) {
                    List<DeleteThreadInfo> delThreadInfoList = w0.getDelThreadInfoList();
                    for (int i = 0; i < delThreadInfoList.size(); i++) {
                        if (delThreadInfoList.get(i) != null && !TextUtils.isEmpty(delThreadInfoList.get(i).text_info)) {
                            sparseArray.put(delThreadInfoList.get(i).text_id, delThreadInfoList.get(i).text_info);
                        }
                    }
                }
                sz5Var.r(sparseArray);
                return sz5Var;
            }
            return null;
        }
        return (sz5) invokeLL.objValue;
    }

    public static boolean c(ke9 ke9Var, rba rbaVar) {
        InterceptResult invokeLL;
        Interceptable interceptable = $ic;
        if (interceptable == null || (invokeLL = interceptable.invokeLL(65538, null, ke9Var, rbaVar)) == null) {
            if (ke9Var != null && rbaVar != null && ke9Var.d() != null && ke9Var.j() != null) {
                uz5 uz5Var = new uz5();
                uz5Var.d(ke9Var.d().getId());
                uz5Var.f(ke9Var.j().getId());
                uz5Var.e(rbaVar.S());
                return pz5.b().c(uz5Var);
            }
            return false;
        }
        return invokeLL.booleanValue;
    }

    public static void d(TbPageContext tbPageContext, SubPbModel subPbModel, zk9 zk9Var) {
        Interceptable interceptable = $ic;
        if ((interceptable == null || interceptable.invokeLLL(65539, null, tbPageContext, subPbModel, zk9Var) == null) && tbPageContext != null && zk9Var != null && zk9Var.u() != null && subPbModel != null) {
            pz5.b().e(tbPageContext, (ViewGroup) zk9Var.u(), b(subPbModel, zk9Var));
            pz5.b().d(3);
        }
    }

    public static boolean e(rba rbaVar) {
        InterceptResult invokeL;
        Interceptable interceptable = $ic;
        if (interceptable == null || (invokeL = interceptable.invokeL(InputDeviceCompat.SOURCE_TRACKBALL, null, rbaVar)) == null) {
            if (rbaVar == null) {
                return false;
            }
            return pz5.b().f(rbaVar.S());
        }
        return invokeL.booleanValue;
    }
}
