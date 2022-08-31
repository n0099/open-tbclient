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
public class oz7 {
    public static /* synthetic */ Interceptable $ic;
    public transient /* synthetic */ FieldHolder $fh;

    /* loaded from: classes5.dex */
    public static class a implements mh5 {
        public static /* synthetic */ Interceptable $ic;
        public transient /* synthetic */ FieldHolder $fh;
        public final /* synthetic */ vz7 a;
        public final /* synthetic */ SubPbModel b;

        public a(vz7 vz7Var, SubPbModel subPbModel) {
            Interceptable interceptable = $ic;
            if (interceptable != null) {
                InitContext newInitContext = TitanRuntime.newInitContext();
                newInitContext.initArgs = r2;
                Object[] objArr = {vz7Var, subPbModel};
                interceptable.invokeUnInit(65536, newInitContext);
                int i = newInitContext.flag;
                if ((i & 1) != 0) {
                    int i2 = i & 2;
                    newInitContext.thisArg = this;
                    interceptable.invokeInitBody(65536, newInitContext);
                    return;
                }
            }
            this.a = vz7Var;
            this.b = subPbModel;
        }

        @Override // com.baidu.tieba.mh5
        public void a() {
            Interceptable interceptable = $ic;
            if (interceptable == null || interceptable.invokeV(1048576, this) == null) {
                this.a.E0(false);
            }
        }

        @Override // com.baidu.tieba.mh5
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
                    if (data.get(i) instanceof e08) {
                        ((e08) data.get(i)).b(this.b.m0().m());
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
            lh5.b().a();
        }
    }

    public static oh5 b(SubPbModel subPbModel, vz7 vz7Var) {
        InterceptResult invokeLL;
        Interceptable interceptable = $ic;
        if (interceptable == null || (invokeLL = interceptable.invokeLL(65537, null, subPbModel, vz7Var)) == null) {
            if (subPbModel == null || vz7Var == null) {
                return null;
            }
            oh5 oh5Var = new oh5();
            oh5Var.p(subPbModel.o0());
            oh5Var.o(subPbModel.n0());
            oh5Var.n(subPbModel.r0());
            if (subPbModel.m0() != null && subPbModel.m0().d() != null) {
                oh5Var.l(subPbModel.m0().d().getId());
                oh5Var.m(subPbModel.m0().d().getName());
                oh5Var.k(subPbModel.m0().d().getImage_url());
                oh5Var.t(subPbModel.m0().d().getUser_level());
            }
            UserData userData = new UserData();
            userData.setIsManager(subPbModel.t0());
            oh5Var.s(userData);
            oh5Var.q(new a(vz7Var, subPbModel));
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
            oh5Var.r(sparseArray);
            return oh5Var;
        }
        return (oh5) invokeLL.objValue;
    }

    public static boolean c(au7 au7Var, PostData postData) {
        InterceptResult invokeLL;
        Interceptable interceptable = $ic;
        if (interceptable == null || (invokeLL = interceptable.invokeLL(65538, null, au7Var, postData)) == null) {
            if (au7Var == null || postData == null || au7Var.d() == null || au7Var.l() == null) {
                return false;
            }
            qh5 qh5Var = new qh5();
            qh5Var.d(au7Var.d().getId());
            qh5Var.f(au7Var.l().getId());
            qh5Var.e(postData.K());
            return lh5.b().c(qh5Var);
        }
        return invokeLL.booleanValue;
    }

    public static void d(TbPageContext tbPageContext, SubPbModel subPbModel, vz7 vz7Var) {
        Interceptable interceptable = $ic;
        if (!(interceptable == null || interceptable.invokeLLL(65539, null, tbPageContext, subPbModel, vz7Var) == null) || tbPageContext == null || vz7Var == null || vz7Var.u() == null || subPbModel == null) {
            return;
        }
        lh5.b().e(tbPageContext, (ViewGroup) vz7Var.u(), b(subPbModel, vz7Var));
        lh5.b().d(3);
    }

    public static boolean e(PostData postData) {
        InterceptResult invokeL;
        Interceptable interceptable = $ic;
        if (interceptable == null || (invokeL = interceptable.invokeL(InputDeviceCompat.SOURCE_TRACKBALL, null, postData)) == null) {
            if (postData == null) {
                return false;
            }
            return lh5.b().f(postData.K());
        }
        return invokeL.booleanValue;
    }
}
