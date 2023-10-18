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
/* loaded from: classes7.dex */
public class pm9 {
    public static /* synthetic */ Interceptable $ic;
    public transient /* synthetic */ FieldHolder $fh;

    /* loaded from: classes7.dex */
    public class a implements ov5 {
        public static /* synthetic */ Interceptable $ic;
        public transient /* synthetic */ FieldHolder $fh;
        public final /* synthetic */ fn9 a;
        public final /* synthetic */ SubPbModel b;

        public a(fn9 fn9Var, SubPbModel subPbModel) {
            Interceptable interceptable = $ic;
            if (interceptable != null) {
                InitContext newInitContext = TitanRuntime.newInitContext();
                newInitContext.initArgs = r2;
                Object[] objArr = {fn9Var, subPbModel};
                interceptable.invokeUnInit(65536, newInitContext);
                int i = newInitContext.flag;
                if ((i & 1) != 0) {
                    int i2 = i & 2;
                    newInitContext.thisArg = this;
                    interceptable.invokeInitBody(65536, newInitContext);
                    return;
                }
            }
            this.a = fn9Var;
            this.b = subPbModel;
        }

        @Override // com.baidu.tieba.ov5
        public void a() {
            Interceptable interceptable = $ic;
            if (interceptable == null || interceptable.invokeV(1048576, this) == null) {
                this.a.E0(false);
            }
        }

        @Override // com.baidu.tieba.ov5
        public void b(List<String> list) {
            int i;
            Interceptable interceptable = $ic;
            if ((interceptable != null && interceptable.invokeL(Constants.METHOD_GET_CONTACTER_INFO_FOR_SESSION, this, list) != null) || !(this.a.B() instanceof BdTypeListView)) {
                return;
            }
            List<yh> data = ((BdTypeListView) this.a.B()).getData();
            if (!ListUtils.isEmpty(data) && !ListUtils.isEmpty(list)) {
                Iterator<yh> it = data.iterator();
                while (true) {
                    i = 0;
                    if (!it.hasNext()) {
                        break;
                    }
                    yh next = it.next();
                    if (next instanceof pea) {
                        while (true) {
                            if (i >= list.size()) {
                                break;
                            } else if (TextUtils.equals(list.get(i), ((pea) next).U())) {
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
                    if (data.get(i) instanceof on9) {
                        ((on9) data.get(i)).b(this.b.y0().k());
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
            nv5.b().a();
        }
    }

    public static qv5 b(SubPbModel subPbModel, fn9 fn9Var) {
        InterceptResult invokeLL;
        Interceptable interceptable = $ic;
        if (interceptable == null || (invokeLL = interceptable.invokeLL(65537, null, subPbModel, fn9Var)) == null) {
            if (subPbModel != null && fn9Var != null) {
                qv5 qv5Var = new qv5();
                qv5Var.p(subPbModel.A0());
                qv5Var.o(subPbModel.z0());
                qv5Var.n(subPbModel.D0());
                if (subPbModel.y0() != null && subPbModel.y0().d() != null) {
                    qv5Var.l(subPbModel.y0().d().getId());
                    qv5Var.m(subPbModel.y0().d().getName());
                    qv5Var.k(subPbModel.y0().d().getImage_url());
                    qv5Var.t(subPbModel.y0().d().getUser_level());
                }
                UserData userData = new UserData();
                userData.setIsManager(subPbModel.F0());
                qv5Var.s(userData);
                qv5Var.q(new a(fn9Var, subPbModel));
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
                qv5Var.r(sparseArray);
                return qv5Var;
            }
            return null;
        }
        return (qv5) invokeLL.objValue;
    }

    public static boolean c(pf9 pf9Var, pea peaVar) {
        InterceptResult invokeLL;
        Interceptable interceptable = $ic;
        if (interceptable == null || (invokeLL = interceptable.invokeLL(65538, null, pf9Var, peaVar)) == null) {
            if (pf9Var != null && peaVar != null && pf9Var.d() != null && pf9Var.j() != null) {
                sv5 sv5Var = new sv5();
                sv5Var.d(pf9Var.d().getId());
                sv5Var.f(pf9Var.j().getId());
                sv5Var.e(peaVar.U());
                return nv5.b().c(sv5Var);
            }
            return false;
        }
        return invokeLL.booleanValue;
    }

    public static void d(TbPageContext tbPageContext, SubPbModel subPbModel, fn9 fn9Var) {
        Interceptable interceptable = $ic;
        if ((interceptable == null || interceptable.invokeLLL(65539, null, tbPageContext, subPbModel, fn9Var) == null) && tbPageContext != null && fn9Var != null && fn9Var.u() != null && subPbModel != null) {
            nv5.b().e(tbPageContext, (ViewGroup) fn9Var.u(), b(subPbModel, fn9Var));
            nv5.b().d(3);
        }
    }

    public static boolean e(pea peaVar) {
        InterceptResult invokeL;
        Interceptable interceptable = $ic;
        if (interceptable == null || (invokeL = interceptable.invokeL(InputDeviceCompat.SOURCE_TRACKBALL, null, peaVar)) == null) {
            if (peaVar == null) {
                return false;
            }
            return nv5.b().f(peaVar.U());
        }
        return invokeL.booleanValue;
    }
}
