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
import com.baidu.tieba.tbadkCore.data.PostData;
import com.baidu.titan.sdk.runtime.FieldHolder;
import com.baidu.titan.sdk.runtime.InitContext;
import com.baidu.titan.sdk.runtime.InterceptResult;
import com.baidu.titan.sdk.runtime.Interceptable;
import com.baidu.titan.sdk.runtime.TitanRuntime;
import java.util.Iterator;
import java.util.List;
/* loaded from: classes5.dex */
public class qz7 {
    public static /* synthetic */ Interceptable $ic;
    public transient /* synthetic */ FieldHolder $fh;

    /* loaded from: classes5.dex */
    public static class a implements oh5 {
        public static /* synthetic */ Interceptable $ic;
        public transient /* synthetic */ FieldHolder $fh;
        public final /* synthetic */ xz7 a;
        public final /* synthetic */ SubPbModel b;

        public a(xz7 xz7Var, SubPbModel subPbModel) {
            Interceptable interceptable = $ic;
            if (interceptable != null) {
                InitContext newInitContext = TitanRuntime.newInitContext();
                newInitContext.initArgs = r2;
                Object[] objArr = {xz7Var, subPbModel};
                interceptable.invokeUnInit(65536, newInitContext);
                int i = newInitContext.flag;
                if ((i & 1) != 0) {
                    int i2 = i & 2;
                    newInitContext.thisArg = this;
                    interceptable.invokeInitBody(65536, newInitContext);
                    return;
                }
            }
            this.a = xz7Var;
            this.b = subPbModel;
        }

        @Override // com.baidu.tieba.oh5
        public void a() {
            Interceptable interceptable = $ic;
            if (interceptable == null || interceptable.invokeV(1048576, this) == null) {
                this.a.E0(false);
            }
        }

        @Override // com.baidu.tieba.oh5
        public void b(List<String> list) {
            int i;
            Interceptable interceptable = $ic;
            if ((interceptable == null || interceptable.invokeL(Constants.METHOD_GET_CONTACTER_INFO_FOR_SESSION, this, list) == null) && (this.a.B() instanceof BdTypeListView)) {
                List<pn> data = ((BdTypeListView) this.a.B()).getData();
                if (ListUtils.isEmpty(data) || ListUtils.isEmpty(list)) {
                    return;
                }
                Iterator<pn> it = data.iterator();
                while (true) {
                    i = 0;
                    if (!it.hasNext()) {
                        break;
                    }
                    pn next = it.next();
                    if (next instanceof PostData) {
                        while (true) {
                            if (i >= list.size()) {
                                break;
                            } else if (TextUtils.equals(list.get(i), ((PostData) next).K())) {
                                it.remove();
                                if (this.b.m0() != null) {
                                    this.b.m0().F(this.b.m0().m() - 1);
                                }
                            } else {
                                i++;
                            }
                        }
                    }
                }
                while (i < data.size()) {
                    if (data.get(i) instanceof g08) {
                        ((g08) data.get(i)).b(this.b.m0().m());
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
            nh5.b().a();
        }
    }

    public static qh5 b(SubPbModel subPbModel, xz7 xz7Var) {
        InterceptResult invokeLL;
        Interceptable interceptable = $ic;
        if (interceptable == null || (invokeLL = interceptable.invokeLL(65537, null, subPbModel, xz7Var)) == null) {
            if (subPbModel == null || xz7Var == null) {
                return null;
            }
            qh5 qh5Var = new qh5();
            qh5Var.p(subPbModel.o0());
            qh5Var.o(subPbModel.n0());
            qh5Var.n(subPbModel.r0());
            if (subPbModel.m0() != null && subPbModel.m0().d() != null) {
                qh5Var.l(subPbModel.m0().d().getId());
                qh5Var.m(subPbModel.m0().d().getName());
                qh5Var.k(subPbModel.m0().d().getImage_url());
                qh5Var.t(subPbModel.m0().d().getUser_level());
            }
            UserData userData = new UserData();
            userData.setIsManager(subPbModel.t0());
            qh5Var.s(userData);
            qh5Var.q(new a(xz7Var, subPbModel));
            AntiData k0 = subPbModel.k0();
            SparseArray<String> sparseArray = new SparseArray<>();
            if (k0 != null && k0.getDelThreadInfoList() != null) {
                List<DeleteThreadInfo> delThreadInfoList = k0.getDelThreadInfoList();
                for (int i = 0; i < delThreadInfoList.size(); i++) {
                    if (delThreadInfoList.get(i) != null && !TextUtils.isEmpty(delThreadInfoList.get(i).text_info)) {
                        sparseArray.put(delThreadInfoList.get(i).text_id, delThreadInfoList.get(i).text_info);
                    }
                }
            }
            qh5Var.r(sparseArray);
            return qh5Var;
        }
        return (qh5) invokeLL.objValue;
    }

    public static boolean c(cu7 cu7Var, PostData postData) {
        InterceptResult invokeLL;
        Interceptable interceptable = $ic;
        if (interceptable == null || (invokeLL = interceptable.invokeLL(65538, null, cu7Var, postData)) == null) {
            if (cu7Var == null || postData == null || cu7Var.d() == null || cu7Var.l() == null) {
                return false;
            }
            sh5 sh5Var = new sh5();
            sh5Var.d(cu7Var.d().getId());
            sh5Var.f(cu7Var.l().getId());
            sh5Var.e(postData.K());
            return nh5.b().c(sh5Var);
        }
        return invokeLL.booleanValue;
    }

    public static void d(TbPageContext tbPageContext, SubPbModel subPbModel, xz7 xz7Var) {
        Interceptable interceptable = $ic;
        if (!(interceptable == null || interceptable.invokeLLL(65539, null, tbPageContext, subPbModel, xz7Var) == null) || tbPageContext == null || xz7Var == null || xz7Var.u() == null || subPbModel == null) {
            return;
        }
        nh5.b().e(tbPageContext, (ViewGroup) xz7Var.u(), b(subPbModel, xz7Var));
        nh5.b().d(3);
    }

    public static boolean e(PostData postData) {
        InterceptResult invokeL;
        Interceptable interceptable = $ic;
        if (interceptable == null || (invokeL = interceptable.invokeL(InputDeviceCompat.SOURCE_TRACKBALL, null, postData)) == null) {
            if (postData == null) {
                return false;
            }
            return nh5.b().f(postData.K());
        }
        return invokeL.booleanValue;
    }
}
