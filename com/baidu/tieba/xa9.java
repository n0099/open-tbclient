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
public class xa9 {
    public static /* synthetic */ Interceptable $ic;
    public transient /* synthetic */ FieldHolder $fh;

    /* loaded from: classes8.dex */
    public static class a implements x06 {
        public static /* synthetic */ Interceptable $ic;
        public transient /* synthetic */ FieldHolder $fh;
        public final /* synthetic */ nb9 a;
        public final /* synthetic */ SubPbModel b;

        public a(nb9 nb9Var, SubPbModel subPbModel) {
            Interceptable interceptable = $ic;
            if (interceptable != null) {
                InitContext newInitContext = TitanRuntime.newInitContext();
                newInitContext.initArgs = r2;
                Object[] objArr = {nb9Var, subPbModel};
                interceptable.invokeUnInit(65536, newInitContext);
                int i = newInitContext.flag;
                if ((i & 1) != 0) {
                    int i2 = i & 2;
                    newInitContext.thisArg = this;
                    interceptable.invokeInitBody(65536, newInitContext);
                    return;
                }
            }
            this.a = nb9Var;
            this.b = subPbModel;
        }

        @Override // com.baidu.tieba.x06
        public void a() {
            Interceptable interceptable = $ic;
            if (interceptable == null || interceptable.invokeV(1048576, this) == null) {
                this.a.E0(false);
            }
        }

        @Override // com.baidu.tieba.x06
        public void b(List<String> list) {
            int i;
            Interceptable interceptable = $ic;
            if ((interceptable != null && interceptable.invokeL(Constants.METHOD_GET_CONTACTER_INFO_FOR_SESSION, this, list) != null) || !(this.a.B() instanceof BdTypeListView)) {
                return;
            }
            List<wn> data = ((BdTypeListView) this.a.B()).getData();
            if (!ListUtils.isEmpty(data) && !ListUtils.isEmpty(list)) {
                Iterator<wn> it = data.iterator();
                while (true) {
                    i = 0;
                    if (!it.hasNext()) {
                        break;
                    }
                    wn next = it.next();
                    if (next instanceof b0a) {
                        while (true) {
                            if (i >= list.size()) {
                                break;
                            } else if (TextUtils.equals(list.get(i), ((b0a) next).S())) {
                                it.remove();
                                if (this.b.F0() != null) {
                                    this.b.F0().A(this.b.F0().k() - 1);
                                }
                            } else {
                                i++;
                            }
                        }
                    }
                }
                while (i < data.size()) {
                    if (data.get(i) instanceof wb9) {
                        ((wb9) data.get(i)).b(this.b.F0().k());
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
            w06.b().a();
        }
    }

    public static z06 b(SubPbModel subPbModel, nb9 nb9Var) {
        InterceptResult invokeLL;
        Interceptable interceptable = $ic;
        if (interceptable == null || (invokeLL = interceptable.invokeLL(65537, null, subPbModel, nb9Var)) == null) {
            if (subPbModel != null && nb9Var != null) {
                z06 z06Var = new z06();
                z06Var.p(subPbModel.H0());
                z06Var.o(subPbModel.G0());
                z06Var.n(subPbModel.K0());
                if (subPbModel.F0() != null && subPbModel.F0().d() != null) {
                    z06Var.l(subPbModel.F0().d().getId());
                    z06Var.m(subPbModel.F0().d().getName());
                    z06Var.k(subPbModel.F0().d().getImage_url());
                    z06Var.t(subPbModel.F0().d().getUser_level());
                }
                UserData userData = new UserData();
                userData.setIsManager(subPbModel.M0());
                z06Var.s(userData);
                z06Var.q(new a(nb9Var, subPbModel));
                AntiData D0 = subPbModel.D0();
                SparseArray<String> sparseArray = new SparseArray<>();
                if (D0 != null && D0.getDelThreadInfoList() != null) {
                    List<DeleteThreadInfo> delThreadInfoList = D0.getDelThreadInfoList();
                    for (int i = 0; i < delThreadInfoList.size(); i++) {
                        if (delThreadInfoList.get(i) != null && !TextUtils.isEmpty(delThreadInfoList.get(i).text_info)) {
                            sparseArray.put(delThreadInfoList.get(i).text_id, delThreadInfoList.get(i).text_info);
                        }
                    }
                }
                z06Var.r(sparseArray);
                return z06Var;
            }
            return null;
        }
        return (z06) invokeLL.objValue;
    }

    public static boolean c(a59 a59Var, b0a b0aVar) {
        InterceptResult invokeLL;
        Interceptable interceptable = $ic;
        if (interceptable == null || (invokeLL = interceptable.invokeLL(65538, null, a59Var, b0aVar)) == null) {
            if (a59Var != null && b0aVar != null && a59Var.d() != null && a59Var.j() != null) {
                b16 b16Var = new b16();
                b16Var.d(a59Var.d().getId());
                b16Var.f(a59Var.j().getId());
                b16Var.e(b0aVar.S());
                return w06.b().c(b16Var);
            }
            return false;
        }
        return invokeLL.booleanValue;
    }

    public static void d(TbPageContext tbPageContext, SubPbModel subPbModel, nb9 nb9Var) {
        Interceptable interceptable = $ic;
        if ((interceptable == null || interceptable.invokeLLL(65539, null, tbPageContext, subPbModel, nb9Var) == null) && tbPageContext != null && nb9Var != null && nb9Var.u() != null && subPbModel != null) {
            w06.b().e(tbPageContext, (ViewGroup) nb9Var.u(), b(subPbModel, nb9Var));
            w06.b().d(3);
        }
    }

    public static boolean e(b0a b0aVar) {
        InterceptResult invokeL;
        Interceptable interceptable = $ic;
        if (interceptable == null || (invokeL = interceptable.invokeL(InputDeviceCompat.SOURCE_TRACKBALL, null, b0aVar)) == null) {
            if (b0aVar == null) {
                return false;
            }
            return w06.b().f(b0aVar.S());
        }
        return invokeL.booleanValue;
    }
}
