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
public class oo9 {
    public static /* synthetic */ Interceptable $ic;
    public transient /* synthetic */ FieldHolder $fh;

    /* loaded from: classes7.dex */
    public static class a implements i06 {
        public static /* synthetic */ Interceptable $ic;
        public transient /* synthetic */ FieldHolder $fh;
        public final /* synthetic */ ep9 a;
        public final /* synthetic */ SubPbModel b;

        public a(ep9 ep9Var, SubPbModel subPbModel) {
            Interceptable interceptable = $ic;
            if (interceptable != null) {
                InitContext newInitContext = TitanRuntime.newInitContext();
                newInitContext.initArgs = r2;
                Object[] objArr = {ep9Var, subPbModel};
                interceptable.invokeUnInit(65536, newInitContext);
                int i = newInitContext.flag;
                if ((i & 1) != 0) {
                    int i2 = i & 2;
                    newInitContext.thisArg = this;
                    interceptable.invokeInitBody(65536, newInitContext);
                    return;
                }
            }
            this.a = ep9Var;
            this.b = subPbModel;
        }

        @Override // com.baidu.tieba.i06
        public void a() {
            Interceptable interceptable = $ic;
            if (interceptable == null || interceptable.invokeV(1048576, this) == null) {
                this.a.E0(false);
            }
        }

        @Override // com.baidu.tieba.i06
        public void b(List<String> list) {
            int i;
            Interceptable interceptable = $ic;
            if ((interceptable != null && interceptable.invokeL(Constants.METHOD_GET_CONTACTER_INFO_FOR_SESSION, this, list) != null) || !(this.a.B() instanceof BdTypeListView)) {
                return;
            }
            List<bn> data = ((BdTypeListView) this.a.B()).getData();
            if (!ListUtils.isEmpty(data) && !ListUtils.isEmpty(list)) {
                Iterator<bn> it = data.iterator();
                while (true) {
                    i = 0;
                    if (!it.hasNext()) {
                        break;
                    }
                    bn next = it.next();
                    if (next instanceof zfa) {
                        while (true) {
                            if (i >= list.size()) {
                                break;
                            } else if (TextUtils.equals(list.get(i), ((zfa) next).S())) {
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
                    if (data.get(i) instanceof np9) {
                        ((np9) data.get(i)).b(this.b.y0().k());
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
            h06.b().a();
        }
    }

    public static k06 b(SubPbModel subPbModel, ep9 ep9Var) {
        InterceptResult invokeLL;
        Interceptable interceptable = $ic;
        if (interceptable == null || (invokeLL = interceptable.invokeLL(65537, null, subPbModel, ep9Var)) == null) {
            if (subPbModel != null && ep9Var != null) {
                k06 k06Var = new k06();
                k06Var.p(subPbModel.A0());
                k06Var.o(subPbModel.z0());
                k06Var.n(subPbModel.D0());
                if (subPbModel.y0() != null && subPbModel.y0().d() != null) {
                    k06Var.l(subPbModel.y0().d().getId());
                    k06Var.m(subPbModel.y0().d().getName());
                    k06Var.k(subPbModel.y0().d().getImage_url());
                    k06Var.t(subPbModel.y0().d().getUser_level());
                }
                UserData userData = new UserData();
                userData.setIsManager(subPbModel.F0());
                k06Var.s(userData);
                k06Var.q(new a(ep9Var, subPbModel));
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
                k06Var.r(sparseArray);
                return k06Var;
            }
            return null;
        }
        return (k06) invokeLL.objValue;
    }

    public static boolean c(pi9 pi9Var, zfa zfaVar) {
        InterceptResult invokeLL;
        Interceptable interceptable = $ic;
        if (interceptable == null || (invokeLL = interceptable.invokeLL(65538, null, pi9Var, zfaVar)) == null) {
            if (pi9Var != null && zfaVar != null && pi9Var.d() != null && pi9Var.j() != null) {
                m06 m06Var = new m06();
                m06Var.d(pi9Var.d().getId());
                m06Var.f(pi9Var.j().getId());
                m06Var.e(zfaVar.S());
                return h06.b().c(m06Var);
            }
            return false;
        }
        return invokeLL.booleanValue;
    }

    public static void d(TbPageContext tbPageContext, SubPbModel subPbModel, ep9 ep9Var) {
        Interceptable interceptable = $ic;
        if ((interceptable == null || interceptable.invokeLLL(65539, null, tbPageContext, subPbModel, ep9Var) == null) && tbPageContext != null && ep9Var != null && ep9Var.u() != null && subPbModel != null) {
            h06.b().e(tbPageContext, (ViewGroup) ep9Var.u(), b(subPbModel, ep9Var));
            h06.b().d(3);
        }
    }

    public static boolean e(zfa zfaVar) {
        InterceptResult invokeL;
        Interceptable interceptable = $ic;
        if (interceptable == null || (invokeL = interceptable.invokeL(InputDeviceCompat.SOURCE_TRACKBALL, null, zfaVar)) == null) {
            if (zfaVar == null) {
                return false;
            }
            return h06.b().f(zfaVar.S());
        }
        return invokeL.booleanValue;
    }
}
