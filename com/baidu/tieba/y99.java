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
public class y99 {
    public static /* synthetic */ Interceptable $ic;
    public transient /* synthetic */ FieldHolder $fh;

    /* loaded from: classes8.dex */
    public static class a implements s06 {
        public static /* synthetic */ Interceptable $ic;
        public transient /* synthetic */ FieldHolder $fh;
        public final /* synthetic */ ja9 a;
        public final /* synthetic */ SubPbModel b;

        public a(ja9 ja9Var, SubPbModel subPbModel) {
            Interceptable interceptable = $ic;
            if (interceptable != null) {
                InitContext newInitContext = TitanRuntime.newInitContext();
                newInitContext.initArgs = r2;
                Object[] objArr = {ja9Var, subPbModel};
                interceptable.invokeUnInit(65536, newInitContext);
                int i = newInitContext.flag;
                if ((i & 1) != 0) {
                    int i2 = i & 2;
                    newInitContext.thisArg = this;
                    interceptable.invokeInitBody(65536, newInitContext);
                    return;
                }
            }
            this.a = ja9Var;
            this.b = subPbModel;
        }

        @Override // com.baidu.tieba.s06
        public void a() {
            Interceptable interceptable = $ic;
            if (interceptable == null || interceptable.invokeV(1048576, this) == null) {
                this.a.E0(false);
            }
        }

        @Override // com.baidu.tieba.s06
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
                    if (next instanceof jy9) {
                        while (true) {
                            if (i >= list.size()) {
                                break;
                            } else if (TextUtils.equals(list.get(i), ((jy9) next).O())) {
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
                    if (data.get(i) instanceof sa9) {
                        ((sa9) data.get(i)).b(this.b.F0().k());
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
            r06.b().a();
        }
    }

    public static u06 b(SubPbModel subPbModel, ja9 ja9Var) {
        InterceptResult invokeLL;
        Interceptable interceptable = $ic;
        if (interceptable == null || (invokeLL = interceptable.invokeLL(65537, null, subPbModel, ja9Var)) == null) {
            if (subPbModel != null && ja9Var != null) {
                u06 u06Var = new u06();
                u06Var.p(subPbModel.H0());
                u06Var.o(subPbModel.G0());
                u06Var.n(subPbModel.K0());
                if (subPbModel.F0() != null && subPbModel.F0().d() != null) {
                    u06Var.l(subPbModel.F0().d().getId());
                    u06Var.m(subPbModel.F0().d().getName());
                    u06Var.k(subPbModel.F0().d().getImage_url());
                    u06Var.t(subPbModel.F0().d().getUser_level());
                }
                UserData userData = new UserData();
                userData.setIsManager(subPbModel.M0());
                u06Var.s(userData);
                u06Var.q(new a(ja9Var, subPbModel));
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
                u06Var.r(sparseArray);
                return u06Var;
            }
            return null;
        }
        return (u06) invokeLL.objValue;
    }

    public static boolean c(e49 e49Var, jy9 jy9Var) {
        InterceptResult invokeLL;
        Interceptable interceptable = $ic;
        if (interceptable == null || (invokeLL = interceptable.invokeLL(65538, null, e49Var, jy9Var)) == null) {
            if (e49Var != null && jy9Var != null && e49Var.d() != null && e49Var.j() != null) {
                w06 w06Var = new w06();
                w06Var.d(e49Var.d().getId());
                w06Var.f(e49Var.j().getId());
                w06Var.e(jy9Var.O());
                return r06.b().c(w06Var);
            }
            return false;
        }
        return invokeLL.booleanValue;
    }

    public static void d(TbPageContext tbPageContext, SubPbModel subPbModel, ja9 ja9Var) {
        Interceptable interceptable = $ic;
        if ((interceptable == null || interceptable.invokeLLL(65539, null, tbPageContext, subPbModel, ja9Var) == null) && tbPageContext != null && ja9Var != null && ja9Var.u() != null && subPbModel != null) {
            r06.b().e(tbPageContext, (ViewGroup) ja9Var.u(), b(subPbModel, ja9Var));
            r06.b().d(3);
        }
    }

    public static boolean e(jy9 jy9Var) {
        InterceptResult invokeL;
        Interceptable interceptable = $ic;
        if (interceptable == null || (invokeL = interceptable.invokeL(InputDeviceCompat.SOURCE_TRACKBALL, null, jy9Var)) == null) {
            if (jy9Var == null) {
                return false;
            }
            return r06.b().f(jy9Var.O());
        }
        return invokeL.booleanValue;
    }
}
