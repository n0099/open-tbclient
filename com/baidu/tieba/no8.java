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
/* loaded from: classes5.dex */
public class no8 {
    public static /* synthetic */ Interceptable $ic;
    public transient /* synthetic */ FieldHolder $fh;

    /* loaded from: classes5.dex */
    public static class a implements ws5 {
        public static /* synthetic */ Interceptable $ic;
        public transient /* synthetic */ FieldHolder $fh;
        public final /* synthetic */ uo8 a;
        public final /* synthetic */ SubPbModel b;

        public a(uo8 uo8Var, SubPbModel subPbModel) {
            Interceptable interceptable = $ic;
            if (interceptable != null) {
                InitContext newInitContext = TitanRuntime.newInitContext();
                newInitContext.initArgs = r2;
                Object[] objArr = {uo8Var, subPbModel};
                interceptable.invokeUnInit(65536, newInitContext);
                int i = newInitContext.flag;
                if ((i & 1) != 0) {
                    int i2 = i & 2;
                    newInitContext.thisArg = this;
                    interceptable.invokeInitBody(65536, newInitContext);
                    return;
                }
            }
            this.a = uo8Var;
            this.b = subPbModel;
        }

        @Override // com.baidu.tieba.ws5
        public void a() {
            Interceptable interceptable = $ic;
            if (interceptable == null || interceptable.invokeV(1048576, this) == null) {
                this.a.E0(false);
            }
        }

        @Override // com.baidu.tieba.ws5
        public void b(List<String> list) {
            int i;
            Interceptable interceptable = $ic;
            if ((interceptable != null && interceptable.invokeL(Constants.METHOD_GET_CONTACTER_INFO_FOR_SESSION, this, list) != null) || !(this.a.B() instanceof BdTypeListView)) {
                return;
            }
            List<gn> data = ((BdTypeListView) this.a.B()).getData();
            if (!ListUtils.isEmpty(data) && !ListUtils.isEmpty(list)) {
                Iterator<gn> it = data.iterator();
                while (true) {
                    i = 0;
                    if (!it.hasNext()) {
                        break;
                    }
                    gn next = it.next();
                    if (next instanceof bc9) {
                        while (true) {
                            if (i >= list.size()) {
                                break;
                            } else if (TextUtils.equals(list.get(i), ((bc9) next).O())) {
                                it.remove();
                                if (this.b.E0() != null) {
                                    this.b.E0().F(this.b.E0().m() - 1);
                                }
                            } else {
                                i++;
                            }
                        }
                    }
                }
                while (i < data.size()) {
                    if (data.get(i) instanceof dp8) {
                        ((dp8) data.get(i)).b(this.b.E0().m());
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
            vs5.b().a();
        }
    }

    public static ys5 b(SubPbModel subPbModel, uo8 uo8Var) {
        InterceptResult invokeLL;
        Interceptable interceptable = $ic;
        if (interceptable == null || (invokeLL = interceptable.invokeLL(65537, null, subPbModel, uo8Var)) == null) {
            if (subPbModel != null && uo8Var != null) {
                ys5 ys5Var = new ys5();
                ys5Var.p(subPbModel.G0());
                ys5Var.o(subPbModel.F0());
                ys5Var.n(subPbModel.J0());
                if (subPbModel.E0() != null && subPbModel.E0().d() != null) {
                    ys5Var.l(subPbModel.E0().d().getId());
                    ys5Var.m(subPbModel.E0().d().getName());
                    ys5Var.k(subPbModel.E0().d().getImage_url());
                    ys5Var.t(subPbModel.E0().d().getUser_level());
                }
                UserData userData = new UserData();
                userData.setIsManager(subPbModel.L0());
                ys5Var.s(userData);
                ys5Var.q(new a(uo8Var, subPbModel));
                AntiData C0 = subPbModel.C0();
                SparseArray<String> sparseArray = new SparseArray<>();
                if (C0 != null && C0.getDelThreadInfoList() != null) {
                    List<DeleteThreadInfo> delThreadInfoList = C0.getDelThreadInfoList();
                    for (int i = 0; i < delThreadInfoList.size(); i++) {
                        if (delThreadInfoList.get(i) != null && !TextUtils.isEmpty(delThreadInfoList.get(i).text_info)) {
                            sparseArray.put(delThreadInfoList.get(i).text_id, delThreadInfoList.get(i).text_info);
                        }
                    }
                }
                ys5Var.r(sparseArray);
                return ys5Var;
            }
            return null;
        }
        return (ys5) invokeLL.objValue;
    }

    public static boolean c(aj8 aj8Var, bc9 bc9Var) {
        InterceptResult invokeLL;
        Interceptable interceptable = $ic;
        if (interceptable == null || (invokeLL = interceptable.invokeLL(65538, null, aj8Var, bc9Var)) == null) {
            if (aj8Var != null && bc9Var != null && aj8Var.d() != null && aj8Var.l() != null) {
                at5 at5Var = new at5();
                at5Var.d(aj8Var.d().getId());
                at5Var.f(aj8Var.l().getId());
                at5Var.e(bc9Var.O());
                return vs5.b().c(at5Var);
            }
            return false;
        }
        return invokeLL.booleanValue;
    }

    public static void d(TbPageContext tbPageContext, SubPbModel subPbModel, uo8 uo8Var) {
        Interceptable interceptable = $ic;
        if ((interceptable == null || interceptable.invokeLLL(65539, null, tbPageContext, subPbModel, uo8Var) == null) && tbPageContext != null && uo8Var != null && uo8Var.u() != null && subPbModel != null) {
            vs5.b().e(tbPageContext, (ViewGroup) uo8Var.u(), b(subPbModel, uo8Var));
            vs5.b().d(3);
        }
    }

    public static boolean e(bc9 bc9Var) {
        InterceptResult invokeL;
        Interceptable interceptable = $ic;
        if (interceptable == null || (invokeL = interceptable.invokeL(InputDeviceCompat.SOURCE_TRACKBALL, null, bc9Var)) == null) {
            if (bc9Var == null) {
                return false;
            }
            return vs5.b().f(bc9Var.O());
        }
        return invokeL.booleanValue;
    }
}
