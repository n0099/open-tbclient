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
public class p39 {
    public static /* synthetic */ Interceptable $ic;
    public transient /* synthetic */ FieldHolder $fh;

    /* loaded from: classes6.dex */
    public static class a implements pw5 {
        public static /* synthetic */ Interceptable $ic;
        public transient /* synthetic */ FieldHolder $fh;
        public final /* synthetic */ a49 a;
        public final /* synthetic */ SubPbModel b;

        public a(a49 a49Var, SubPbModel subPbModel) {
            Interceptable interceptable = $ic;
            if (interceptable != null) {
                InitContext newInitContext = TitanRuntime.newInitContext();
                newInitContext.initArgs = r2;
                Object[] objArr = {a49Var, subPbModel};
                interceptable.invokeUnInit(65536, newInitContext);
                int i = newInitContext.flag;
                if ((i & 1) != 0) {
                    int i2 = i & 2;
                    newInitContext.thisArg = this;
                    interceptable.invokeInitBody(65536, newInitContext);
                    return;
                }
            }
            this.a = a49Var;
            this.b = subPbModel;
        }

        @Override // com.baidu.tieba.pw5
        public void a() {
            Interceptable interceptable = $ic;
            if (interceptable == null || interceptable.invokeV(1048576, this) == null) {
                this.a.E0(false);
            }
        }

        @Override // com.baidu.tieba.pw5
        public void b(List<String> list) {
            int i;
            Interceptable interceptable = $ic;
            if ((interceptable != null && interceptable.invokeL(Constants.METHOD_GET_CONTACTER_INFO_FOR_SESSION, this, list) != null) || !(this.a.B() instanceof BdTypeListView)) {
                return;
            }
            List<rn> data = ((BdTypeListView) this.a.B()).getData();
            if (!ListUtils.isEmpty(data) && !ListUtils.isEmpty(list)) {
                Iterator<rn> it = data.iterator();
                while (true) {
                    i = 0;
                    if (!it.hasNext()) {
                        break;
                    }
                    rn next = it.next();
                    if (next instanceof sr9) {
                        while (true) {
                            if (i >= list.size()) {
                                break;
                            } else if (TextUtils.equals(list.get(i), ((sr9) next).O())) {
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
                    if (data.get(i) instanceof j49) {
                        ((j49) data.get(i)).b(this.b.F0().k());
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
            ow5.b().a();
        }
    }

    public static rw5 b(SubPbModel subPbModel, a49 a49Var) {
        InterceptResult invokeLL;
        Interceptable interceptable = $ic;
        if (interceptable == null || (invokeLL = interceptable.invokeLL(65537, null, subPbModel, a49Var)) == null) {
            if (subPbModel != null && a49Var != null) {
                rw5 rw5Var = new rw5();
                rw5Var.p(subPbModel.H0());
                rw5Var.o(subPbModel.G0());
                rw5Var.n(subPbModel.K0());
                if (subPbModel.F0() != null && subPbModel.F0().d() != null) {
                    rw5Var.l(subPbModel.F0().d().getId());
                    rw5Var.m(subPbModel.F0().d().getName());
                    rw5Var.k(subPbModel.F0().d().getImage_url());
                    rw5Var.t(subPbModel.F0().d().getUser_level());
                }
                UserData userData = new UserData();
                userData.setIsManager(subPbModel.M0());
                rw5Var.s(userData);
                rw5Var.q(new a(a49Var, subPbModel));
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
                rw5Var.r(sparseArray);
                return rw5Var;
            }
            return null;
        }
        return (rw5) invokeLL.objValue;
    }

    public static boolean c(cy8 cy8Var, sr9 sr9Var) {
        InterceptResult invokeLL;
        Interceptable interceptable = $ic;
        if (interceptable == null || (invokeLL = interceptable.invokeLL(65538, null, cy8Var, sr9Var)) == null) {
            if (cy8Var != null && sr9Var != null && cy8Var.d() != null && cy8Var.j() != null) {
                tw5 tw5Var = new tw5();
                tw5Var.d(cy8Var.d().getId());
                tw5Var.f(cy8Var.j().getId());
                tw5Var.e(sr9Var.O());
                return ow5.b().c(tw5Var);
            }
            return false;
        }
        return invokeLL.booleanValue;
    }

    public static void d(TbPageContext tbPageContext, SubPbModel subPbModel, a49 a49Var) {
        Interceptable interceptable = $ic;
        if ((interceptable == null || interceptable.invokeLLL(65539, null, tbPageContext, subPbModel, a49Var) == null) && tbPageContext != null && a49Var != null && a49Var.u() != null && subPbModel != null) {
            ow5.b().e(tbPageContext, (ViewGroup) a49Var.u(), b(subPbModel, a49Var));
            ow5.b().d(3);
        }
    }

    public static boolean e(sr9 sr9Var) {
        InterceptResult invokeL;
        Interceptable interceptable = $ic;
        if (interceptable == null || (invokeL = interceptable.invokeL(InputDeviceCompat.SOURCE_TRACKBALL, null, sr9Var)) == null) {
            if (sr9Var == null) {
                return false;
            }
            return ow5.b().f(sr9Var.O());
        }
        return invokeL.booleanValue;
    }
}
