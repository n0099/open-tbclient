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
public class w4a {
    public static /* synthetic */ Interceptable $ic;
    public transient /* synthetic */ FieldHolder $fh;

    /* loaded from: classes8.dex */
    public class a implements ux5 {
        public static /* synthetic */ Interceptable $ic;
        public transient /* synthetic */ FieldHolder $fh;
        public final /* synthetic */ k5a a;
        public final /* synthetic */ SubPbModel b;

        public a(k5a k5aVar, SubPbModel subPbModel) {
            Interceptable interceptable = $ic;
            if (interceptable != null) {
                InitContext newInitContext = TitanRuntime.newInitContext();
                newInitContext.initArgs = r2;
                Object[] objArr = {k5aVar, subPbModel};
                interceptable.invokeUnInit(65536, newInitContext);
                int i = newInitContext.flag;
                if ((i & 1) != 0) {
                    int i2 = i & 2;
                    newInitContext.thisArg = this;
                    interceptable.invokeInitBody(65536, newInitContext);
                    return;
                }
            }
            this.a = k5aVar;
            this.b = subPbModel;
        }

        @Override // com.baidu.tieba.ux5
        public void a() {
            Interceptable interceptable = $ic;
            if (interceptable == null || interceptable.invokeV(1048576, this) == null) {
                this.a.z0(false);
            }
        }

        @Override // com.baidu.tieba.ux5
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
                    if (data.get(i) instanceof t5a) {
                        ((t5a) data.get(i)).b(this.b.z0().m());
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
            tx5.b().a();
        }
    }

    public static wx5 b(SubPbModel subPbModel, k5a k5aVar) {
        InterceptResult invokeLL;
        Interceptable interceptable = $ic;
        if (interceptable == null || (invokeLL = interceptable.invokeLL(65537, null, subPbModel, k5aVar)) == null) {
            if (subPbModel != null && k5aVar != null) {
                wx5 wx5Var = new wx5();
                wx5Var.p(subPbModel.B0());
                wx5Var.o(subPbModel.A0());
                wx5Var.n(subPbModel.E0());
                if (subPbModel.z0() != null && subPbModel.z0().f() != null) {
                    wx5Var.l(subPbModel.z0().f().getId());
                    wx5Var.m(subPbModel.z0().f().getName());
                    wx5Var.k(subPbModel.z0().f().getImage_url());
                    wx5Var.t(subPbModel.z0().f().getUser_level());
                }
                UserData userData = new UserData();
                userData.setIsManager(subPbModel.G0());
                wx5Var.s(userData);
                wx5Var.q(new a(k5aVar, subPbModel));
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
                wx5Var.r(sparseArray);
                return wx5Var;
            }
            return null;
        }
        return (wx5) invokeLL.objValue;
    }

    public static boolean c(qw9 qw9Var, nwa nwaVar) {
        InterceptResult invokeLL;
        Interceptable interceptable = $ic;
        if (interceptable == null || (invokeLL = interceptable.invokeLL(65538, null, qw9Var, nwaVar)) == null) {
            if (qw9Var != null && nwaVar != null && qw9Var.f() != null && qw9Var.l() != null) {
                yx5 yx5Var = new yx5();
                yx5Var.d(qw9Var.f().getId());
                yx5Var.f(qw9Var.l().getId());
                yx5Var.e(nwaVar.U());
                return tx5.b().c(yx5Var);
            }
            return false;
        }
        return invokeLL.booleanValue;
    }

    public static void d(TbPageContext tbPageContext, SubPbModel subPbModel, k5a k5aVar) {
        Interceptable interceptable = $ic;
        if ((interceptable == null || interceptable.invokeLLL(65539, null, tbPageContext, subPbModel, k5aVar) == null) && tbPageContext != null && k5aVar != null && k5aVar.t() != null && subPbModel != null) {
            tx5.b().e(tbPageContext, (ViewGroup) k5aVar.t(), b(subPbModel, k5aVar));
            tx5.b().d(3);
        }
    }

    public static boolean e(nwa nwaVar) {
        InterceptResult invokeL;
        Interceptable interceptable = $ic;
        if (interceptable == null || (invokeL = interceptable.invokeL(InputDeviceCompat.SOURCE_TRACKBALL, null, nwaVar)) == null) {
            if (nwaVar == null) {
                return false;
            }
            return tx5.b().f(nwaVar.U());
        }
        return invokeL.booleanValue;
    }
}
