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
public class v99 {
    public static /* synthetic */ Interceptable $ic;
    public transient /* synthetic */ FieldHolder $fh;

    /* loaded from: classes8.dex */
    public static class a implements q06 {
        public static /* synthetic */ Interceptable $ic;
        public transient /* synthetic */ FieldHolder $fh;
        public final /* synthetic */ ga9 a;
        public final /* synthetic */ SubPbModel b;

        public a(ga9 ga9Var, SubPbModel subPbModel) {
            Interceptable interceptable = $ic;
            if (interceptable != null) {
                InitContext newInitContext = TitanRuntime.newInitContext();
                newInitContext.initArgs = r2;
                Object[] objArr = {ga9Var, subPbModel};
                interceptable.invokeUnInit(65536, newInitContext);
                int i = newInitContext.flag;
                if ((i & 1) != 0) {
                    int i2 = i & 2;
                    newInitContext.thisArg = this;
                    interceptable.invokeInitBody(65536, newInitContext);
                    return;
                }
            }
            this.a = ga9Var;
            this.b = subPbModel;
        }

        @Override // com.baidu.tieba.q06
        public void a() {
            Interceptable interceptable = $ic;
            if (interceptable == null || interceptable.invokeV(1048576, this) == null) {
                this.a.E0(false);
            }
        }

        @Override // com.baidu.tieba.q06
        public void b(List<String> list) {
            int i;
            Interceptable interceptable = $ic;
            if ((interceptable != null && interceptable.invokeL(Constants.METHOD_GET_CONTACTER_INFO_FOR_SESSION, this, list) != null) || !(this.a.B() instanceof BdTypeListView)) {
                return;
            }
            List<vn> data = ((BdTypeListView) this.a.B()).getData();
            if (!ListUtils.isEmpty(data) && !ListUtils.isEmpty(list)) {
                Iterator<vn> it = data.iterator();
                while (true) {
                    i = 0;
                    if (!it.hasNext()) {
                        break;
                    }
                    vn next = it.next();
                    if (next instanceof ey9) {
                        while (true) {
                            if (i >= list.size()) {
                                break;
                            } else if (TextUtils.equals(list.get(i), ((ey9) next).O())) {
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
                    if (data.get(i) instanceof pa9) {
                        ((pa9) data.get(i)).b(this.b.F0().k());
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
            p06.b().a();
        }
    }

    public static s06 b(SubPbModel subPbModel, ga9 ga9Var) {
        InterceptResult invokeLL;
        Interceptable interceptable = $ic;
        if (interceptable == null || (invokeLL = interceptable.invokeLL(65537, null, subPbModel, ga9Var)) == null) {
            if (subPbModel != null && ga9Var != null) {
                s06 s06Var = new s06();
                s06Var.p(subPbModel.H0());
                s06Var.o(subPbModel.G0());
                s06Var.n(subPbModel.K0());
                if (subPbModel.F0() != null && subPbModel.F0().d() != null) {
                    s06Var.l(subPbModel.F0().d().getId());
                    s06Var.m(subPbModel.F0().d().getName());
                    s06Var.k(subPbModel.F0().d().getImage_url());
                    s06Var.t(subPbModel.F0().d().getUser_level());
                }
                UserData userData = new UserData();
                userData.setIsManager(subPbModel.M0());
                s06Var.s(userData);
                s06Var.q(new a(ga9Var, subPbModel));
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
                s06Var.r(sparseArray);
                return s06Var;
            }
            return null;
        }
        return (s06) invokeLL.objValue;
    }

    public static boolean c(b49 b49Var, ey9 ey9Var) {
        InterceptResult invokeLL;
        Interceptable interceptable = $ic;
        if (interceptable == null || (invokeLL = interceptable.invokeLL(65538, null, b49Var, ey9Var)) == null) {
            if (b49Var != null && ey9Var != null && b49Var.d() != null && b49Var.j() != null) {
                u06 u06Var = new u06();
                u06Var.d(b49Var.d().getId());
                u06Var.f(b49Var.j().getId());
                u06Var.e(ey9Var.O());
                return p06.b().c(u06Var);
            }
            return false;
        }
        return invokeLL.booleanValue;
    }

    public static void d(TbPageContext tbPageContext, SubPbModel subPbModel, ga9 ga9Var) {
        Interceptable interceptable = $ic;
        if ((interceptable == null || interceptable.invokeLLL(65539, null, tbPageContext, subPbModel, ga9Var) == null) && tbPageContext != null && ga9Var != null && ga9Var.u() != null && subPbModel != null) {
            p06.b().e(tbPageContext, (ViewGroup) ga9Var.u(), b(subPbModel, ga9Var));
            p06.b().d(3);
        }
    }

    public static boolean e(ey9 ey9Var) {
        InterceptResult invokeL;
        Interceptable interceptable = $ic;
        if (interceptable == null || (invokeL = interceptable.invokeL(InputDeviceCompat.SOURCE_TRACKBALL, null, ey9Var)) == null) {
            if (ey9Var == null) {
                return false;
            }
            return p06.b().f(ey9Var.O());
        }
        return invokeL.booleanValue;
    }
}
