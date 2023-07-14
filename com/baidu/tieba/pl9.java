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
public class pl9 {
    public static /* synthetic */ Interceptable $ic;
    public transient /* synthetic */ FieldHolder $fh;

    /* loaded from: classes7.dex */
    public static class a implements g26 {
        public static /* synthetic */ Interceptable $ic;
        public transient /* synthetic */ FieldHolder $fh;
        public final /* synthetic */ fm9 a;
        public final /* synthetic */ SubPbModel b;

        public a(fm9 fm9Var, SubPbModel subPbModel) {
            Interceptable interceptable = $ic;
            if (interceptable != null) {
                InitContext newInitContext = TitanRuntime.newInitContext();
                newInitContext.initArgs = r2;
                Object[] objArr = {fm9Var, subPbModel};
                interceptable.invokeUnInit(65536, newInitContext);
                int i = newInitContext.flag;
                if ((i & 1) != 0) {
                    int i2 = i & 2;
                    newInitContext.thisArg = this;
                    interceptable.invokeInitBody(65536, newInitContext);
                    return;
                }
            }
            this.a = fm9Var;
            this.b = subPbModel;
        }

        @Override // com.baidu.tieba.g26
        public void a() {
            Interceptable interceptable = $ic;
            if (interceptable == null || interceptable.invokeV(1048576, this) == null) {
                this.a.E0(false);
            }
        }

        @Override // com.baidu.tieba.g26
        public void b(List<String> list) {
            int i;
            Interceptable interceptable = $ic;
            if ((interceptable != null && interceptable.invokeL(Constants.METHOD_GET_CONTACTER_INFO_FOR_SESSION, this, list) != null) || !(this.a.B() instanceof BdTypeListView)) {
                return;
            }
            List<yn> data = ((BdTypeListView) this.a.B()).getData();
            if (!ListUtils.isEmpty(data) && !ListUtils.isEmpty(list)) {
                Iterator<yn> it = data.iterator();
                while (true) {
                    i = 0;
                    if (!it.hasNext()) {
                        break;
                    }
                    yn next = it.next();
                    if (next instanceof yca) {
                        while (true) {
                            if (i >= list.size()) {
                                break;
                            } else if (TextUtils.equals(list.get(i), ((yca) next).S())) {
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
                    if (data.get(i) instanceof om9) {
                        ((om9) data.get(i)).b(this.b.G0().k());
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
            f26.b().a();
        }
    }

    public static i26 b(SubPbModel subPbModel, fm9 fm9Var) {
        InterceptResult invokeLL;
        Interceptable interceptable = $ic;
        if (interceptable == null || (invokeLL = interceptable.invokeLL(65537, null, subPbModel, fm9Var)) == null) {
            if (subPbModel != null && fm9Var != null) {
                i26 i26Var = new i26();
                i26Var.p(subPbModel.I0());
                i26Var.o(subPbModel.H0());
                i26Var.n(subPbModel.L0());
                if (subPbModel.G0() != null && subPbModel.G0().d() != null) {
                    i26Var.l(subPbModel.G0().d().getId());
                    i26Var.m(subPbModel.G0().d().getName());
                    i26Var.k(subPbModel.G0().d().getImage_url());
                    i26Var.t(subPbModel.G0().d().getUser_level());
                }
                UserData userData = new UserData();
                userData.setIsManager(subPbModel.N0());
                i26Var.s(userData);
                i26Var.q(new a(fm9Var, subPbModel));
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
                i26Var.r(sparseArray);
                return i26Var;
            }
            return null;
        }
        return (i26) invokeLL.objValue;
    }

    public static boolean c(qf9 qf9Var, yca ycaVar) {
        InterceptResult invokeLL;
        Interceptable interceptable = $ic;
        if (interceptable == null || (invokeLL = interceptable.invokeLL(65538, null, qf9Var, ycaVar)) == null) {
            if (qf9Var != null && ycaVar != null && qf9Var.d() != null && qf9Var.j() != null) {
                k26 k26Var = new k26();
                k26Var.d(qf9Var.d().getId());
                k26Var.f(qf9Var.j().getId());
                k26Var.e(ycaVar.S());
                return f26.b().c(k26Var);
            }
            return false;
        }
        return invokeLL.booleanValue;
    }

    public static void d(TbPageContext tbPageContext, SubPbModel subPbModel, fm9 fm9Var) {
        Interceptable interceptable = $ic;
        if ((interceptable == null || interceptable.invokeLLL(65539, null, tbPageContext, subPbModel, fm9Var) == null) && tbPageContext != null && fm9Var != null && fm9Var.u() != null && subPbModel != null) {
            f26.b().e(tbPageContext, (ViewGroup) fm9Var.u(), b(subPbModel, fm9Var));
            f26.b().d(3);
        }
    }

    public static boolean e(yca ycaVar) {
        InterceptResult invokeL;
        Interceptable interceptable = $ic;
        if (interceptable == null || (invokeL = interceptable.invokeL(InputDeviceCompat.SOURCE_TRACKBALL, null, ycaVar)) == null) {
            if (ycaVar == null) {
                return false;
            }
            return f26.b().f(ycaVar.S());
        }
        return invokeL.booleanValue;
    }
}
