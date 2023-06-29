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
public class jf9 {
    public static /* synthetic */ Interceptable $ic;
    public transient /* synthetic */ FieldHolder $fh;

    /* loaded from: classes6.dex */
    public static class a implements c16 {
        public static /* synthetic */ Interceptable $ic;
        public transient /* synthetic */ FieldHolder $fh;
        public final /* synthetic */ zf9 a;
        public final /* synthetic */ SubPbModel b;

        public a(zf9 zf9Var, SubPbModel subPbModel) {
            Interceptable interceptable = $ic;
            if (interceptable != null) {
                InitContext newInitContext = TitanRuntime.newInitContext();
                newInitContext.initArgs = r2;
                Object[] objArr = {zf9Var, subPbModel};
                interceptable.invokeUnInit(65536, newInitContext);
                int i = newInitContext.flag;
                if ((i & 1) != 0) {
                    int i2 = i & 2;
                    newInitContext.thisArg = this;
                    interceptable.invokeInitBody(65536, newInitContext);
                    return;
                }
            }
            this.a = zf9Var;
            this.b = subPbModel;
        }

        @Override // com.baidu.tieba.c16
        public void a() {
            Interceptable interceptable = $ic;
            if (interceptable == null || interceptable.invokeV(1048576, this) == null) {
                this.a.E0(false);
            }
        }

        @Override // com.baidu.tieba.c16
        public void b(List<String> list) {
            int i;
            Interceptable interceptable = $ic;
            if ((interceptable != null && interceptable.invokeL(Constants.METHOD_GET_CONTACTER_INFO_FOR_SESSION, this, list) != null) || !(this.a.B() instanceof BdTypeListView)) {
                return;
            }
            List<xn> data = ((BdTypeListView) this.a.B()).getData();
            if (!ListUtils.isEmpty(data) && !ListUtils.isEmpty(list)) {
                Iterator<xn> it = data.iterator();
                while (true) {
                    i = 0;
                    if (!it.hasNext()) {
                        break;
                    }
                    xn next = it.next();
                    if (next instanceof n4a) {
                        while (true) {
                            if (i >= list.size()) {
                                break;
                            } else if (TextUtils.equals(list.get(i), ((n4a) next).S())) {
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
                    if (data.get(i) instanceof ig9) {
                        ((ig9) data.get(i)).b(this.b.F0().k());
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
            b16.b().a();
        }
    }

    public static e16 b(SubPbModel subPbModel, zf9 zf9Var) {
        InterceptResult invokeLL;
        Interceptable interceptable = $ic;
        if (interceptable == null || (invokeLL = interceptable.invokeLL(65537, null, subPbModel, zf9Var)) == null) {
            if (subPbModel != null && zf9Var != null) {
                e16 e16Var = new e16();
                e16Var.p(subPbModel.H0());
                e16Var.o(subPbModel.G0());
                e16Var.n(subPbModel.K0());
                if (subPbModel.F0() != null && subPbModel.F0().d() != null) {
                    e16Var.l(subPbModel.F0().d().getId());
                    e16Var.m(subPbModel.F0().d().getName());
                    e16Var.k(subPbModel.F0().d().getImage_url());
                    e16Var.t(subPbModel.F0().d().getUser_level());
                }
                UserData userData = new UserData();
                userData.setIsManager(subPbModel.M0());
                e16Var.s(userData);
                e16Var.q(new a(zf9Var, subPbModel));
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
                e16Var.r(sparseArray);
                return e16Var;
            }
            return null;
        }
        return (e16) invokeLL.objValue;
    }

    public static boolean c(l99 l99Var, n4a n4aVar) {
        InterceptResult invokeLL;
        Interceptable interceptable = $ic;
        if (interceptable == null || (invokeLL = interceptable.invokeLL(65538, null, l99Var, n4aVar)) == null) {
            if (l99Var != null && n4aVar != null && l99Var.d() != null && l99Var.j() != null) {
                g16 g16Var = new g16();
                g16Var.d(l99Var.d().getId());
                g16Var.f(l99Var.j().getId());
                g16Var.e(n4aVar.S());
                return b16.b().c(g16Var);
            }
            return false;
        }
        return invokeLL.booleanValue;
    }

    public static void d(TbPageContext tbPageContext, SubPbModel subPbModel, zf9 zf9Var) {
        Interceptable interceptable = $ic;
        if ((interceptable == null || interceptable.invokeLLL(65539, null, tbPageContext, subPbModel, zf9Var) == null) && tbPageContext != null && zf9Var != null && zf9Var.u() != null && subPbModel != null) {
            b16.b().e(tbPageContext, (ViewGroup) zf9Var.u(), b(subPbModel, zf9Var));
            b16.b().d(3);
        }
    }

    public static boolean e(n4a n4aVar) {
        InterceptResult invokeL;
        Interceptable interceptable = $ic;
        if (interceptable == null || (invokeL = interceptable.invokeL(InputDeviceCompat.SOURCE_TRACKBALL, null, n4aVar)) == null) {
            if (n4aVar == null) {
                return false;
            }
            return b16.b().f(n4aVar.S());
        }
        return invokeL.booleanValue;
    }
}
