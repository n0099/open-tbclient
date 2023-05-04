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
public class s19 {
    public static /* synthetic */ Interceptable $ic;
    public transient /* synthetic */ FieldHolder $fh;

    /* loaded from: classes6.dex */
    public static class a implements dv5 {
        public static /* synthetic */ Interceptable $ic;
        public transient /* synthetic */ FieldHolder $fh;
        public final /* synthetic */ d29 a;
        public final /* synthetic */ SubPbModel b;

        public a(d29 d29Var, SubPbModel subPbModel) {
            Interceptable interceptable = $ic;
            if (interceptable != null) {
                InitContext newInitContext = TitanRuntime.newInitContext();
                newInitContext.initArgs = r2;
                Object[] objArr = {d29Var, subPbModel};
                interceptable.invokeUnInit(65536, newInitContext);
                int i = newInitContext.flag;
                if ((i & 1) != 0) {
                    int i2 = i & 2;
                    newInitContext.thisArg = this;
                    interceptable.invokeInitBody(65536, newInitContext);
                    return;
                }
            }
            this.a = d29Var;
            this.b = subPbModel;
        }

        @Override // com.baidu.tieba.dv5
        public void a() {
            Interceptable interceptable = $ic;
            if (interceptable == null || interceptable.invokeV(1048576, this) == null) {
                this.a.E0(false);
            }
        }

        @Override // com.baidu.tieba.dv5
        public void b(List<String> list) {
            int i;
            Interceptable interceptable = $ic;
            if ((interceptable != null && interceptable.invokeL(Constants.METHOD_GET_CONTACTER_INFO_FOR_SESSION, this, list) != null) || !(this.a.B() instanceof BdTypeListView)) {
                return;
            }
            List<in> data = ((BdTypeListView) this.a.B()).getData();
            if (!ListUtils.isEmpty(data) && !ListUtils.isEmpty(list)) {
                Iterator<in> it = data.iterator();
                while (true) {
                    i = 0;
                    if (!it.hasNext()) {
                        break;
                    }
                    in next = it.next();
                    if (next instanceof pp9) {
                        while (true) {
                            if (i >= list.size()) {
                                break;
                            } else if (TextUtils.equals(list.get(i), ((pp9) next).N())) {
                                it.remove();
                                if (this.b.G0() != null) {
                                    this.b.G0().A(this.b.G0().k() - 1);
                                }
                            } else {
                                i++;
                            }
                        }
                    }
                }
                while (i < data.size()) {
                    if (data.get(i) instanceof m29) {
                        ((m29) data.get(i)).b(this.b.G0().k());
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
            cv5.b().a();
        }
    }

    public static fv5 b(SubPbModel subPbModel, d29 d29Var) {
        InterceptResult invokeLL;
        Interceptable interceptable = $ic;
        if (interceptable == null || (invokeLL = interceptable.invokeLL(65537, null, subPbModel, d29Var)) == null) {
            if (subPbModel != null && d29Var != null) {
                fv5 fv5Var = new fv5();
                fv5Var.p(subPbModel.I0());
                fv5Var.o(subPbModel.H0());
                fv5Var.n(subPbModel.L0());
                if (subPbModel.G0() != null && subPbModel.G0().d() != null) {
                    fv5Var.l(subPbModel.G0().d().getId());
                    fv5Var.m(subPbModel.G0().d().getName());
                    fv5Var.k(subPbModel.G0().d().getImage_url());
                    fv5Var.t(subPbModel.G0().d().getUser_level());
                }
                UserData userData = new UserData();
                userData.setIsManager(subPbModel.N0());
                fv5Var.s(userData);
                fv5Var.q(new a(d29Var, subPbModel));
                AntiData E0 = subPbModel.E0();
                SparseArray<String> sparseArray = new SparseArray<>();
                if (E0 != null && E0.getDelThreadInfoList() != null) {
                    List<DeleteThreadInfo> delThreadInfoList = E0.getDelThreadInfoList();
                    for (int i = 0; i < delThreadInfoList.size(); i++) {
                        if (delThreadInfoList.get(i) != null && !TextUtils.isEmpty(delThreadInfoList.get(i).text_info)) {
                            sparseArray.put(delThreadInfoList.get(i).text_id, delThreadInfoList.get(i).text_info);
                        }
                    }
                }
                fv5Var.r(sparseArray);
                return fv5Var;
            }
            return null;
        }
        return (fv5) invokeLL.objValue;
    }

    public static boolean c(gw8 gw8Var, pp9 pp9Var) {
        InterceptResult invokeLL;
        Interceptable interceptable = $ic;
        if (interceptable == null || (invokeLL = interceptable.invokeLL(65538, null, gw8Var, pp9Var)) == null) {
            if (gw8Var != null && pp9Var != null && gw8Var.d() != null && gw8Var.j() != null) {
                hv5 hv5Var = new hv5();
                hv5Var.d(gw8Var.d().getId());
                hv5Var.f(gw8Var.j().getId());
                hv5Var.e(pp9Var.N());
                return cv5.b().c(hv5Var);
            }
            return false;
        }
        return invokeLL.booleanValue;
    }

    public static void d(TbPageContext tbPageContext, SubPbModel subPbModel, d29 d29Var) {
        Interceptable interceptable = $ic;
        if ((interceptable == null || interceptable.invokeLLL(65539, null, tbPageContext, subPbModel, d29Var) == null) && tbPageContext != null && d29Var != null && d29Var.u() != null && subPbModel != null) {
            cv5.b().e(tbPageContext, (ViewGroup) d29Var.u(), b(subPbModel, d29Var));
            cv5.b().d(3);
        }
    }

    public static boolean e(pp9 pp9Var) {
        InterceptResult invokeL;
        Interceptable interceptable = $ic;
        if (interceptable == null || (invokeL = interceptable.invokeL(InputDeviceCompat.SOURCE_TRACKBALL, null, pp9Var)) == null) {
            if (pp9Var == null) {
                return false;
            }
            return cv5.b().f(pp9Var.N());
        }
        return invokeL.booleanValue;
    }
}
