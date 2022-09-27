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
/* loaded from: classes4.dex */
public class k18 {
    public static /* synthetic */ Interceptable $ic;
    public transient /* synthetic */ FieldHolder $fh;

    /* loaded from: classes4.dex */
    public static class a implements jk5 {
        public static /* synthetic */ Interceptable $ic;
        public transient /* synthetic */ FieldHolder $fh;
        public final /* synthetic */ r18 a;
        public final /* synthetic */ SubPbModel b;

        public a(r18 r18Var, SubPbModel subPbModel) {
            Interceptable interceptable = $ic;
            if (interceptable != null) {
                InitContext newInitContext = TitanRuntime.newInitContext();
                newInitContext.initArgs = r2;
                Object[] objArr = {r18Var, subPbModel};
                interceptable.invokeUnInit(65536, newInitContext);
                int i = newInitContext.flag;
                if ((i & 1) != 0) {
                    int i2 = i & 2;
                    newInitContext.thisArg = this;
                    interceptable.invokeInitBody(65536, newInitContext);
                    return;
                }
            }
            this.a = r18Var;
            this.b = subPbModel;
        }

        @Override // com.baidu.tieba.jk5
        public void a() {
            Interceptable interceptable = $ic;
            if (interceptable == null || interceptable.invokeV(1048576, this) == null) {
                this.a.E0(false);
            }
        }

        @Override // com.baidu.tieba.jk5
        public void b(List<String> list) {
            int i;
            Interceptable interceptable = $ic;
            if ((interceptable == null || interceptable.invokeL(Constants.METHOD_GET_CONTACTER_INFO_FOR_SESSION, this, list) == null) && (this.a.B() instanceof BdTypeListView)) {
                List<Cdo> data = ((BdTypeListView) this.a.B()).getData();
                if (ListUtils.isEmpty(data) || ListUtils.isEmpty(list)) {
                    return;
                }
                Iterator<Cdo> it = data.iterator();
                while (true) {
                    i = 0;
                    if (!it.hasNext()) {
                        break;
                    }
                    Cdo next = it.next();
                    if (next instanceof PostData) {
                        while (true) {
                            if (i >= list.size()) {
                                break;
                            } else if (TextUtils.equals(list.get(i), ((PostData) next).L())) {
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
                    if (data.get(i) instanceof a28) {
                        ((a28) data.get(i)).b(this.b.m0().m());
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
            ik5.b().a();
        }
    }

    public static lk5 b(SubPbModel subPbModel, r18 r18Var) {
        InterceptResult invokeLL;
        Interceptable interceptable = $ic;
        if (interceptable == null || (invokeLL = interceptable.invokeLL(65537, null, subPbModel, r18Var)) == null) {
            if (subPbModel == null || r18Var == null) {
                return null;
            }
            lk5 lk5Var = new lk5();
            lk5Var.p(subPbModel.o0());
            lk5Var.o(subPbModel.n0());
            lk5Var.n(subPbModel.r0());
            if (subPbModel.m0() != null && subPbModel.m0().d() != null) {
                lk5Var.l(subPbModel.m0().d().getId());
                lk5Var.m(subPbModel.m0().d().getName());
                lk5Var.k(subPbModel.m0().d().getImage_url());
                lk5Var.t(subPbModel.m0().d().getUser_level());
            }
            UserData userData = new UserData();
            userData.setIsManager(subPbModel.t0());
            lk5Var.s(userData);
            lk5Var.q(new a(r18Var, subPbModel));
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
            lk5Var.r(sparseArray);
            return lk5Var;
        }
        return (lk5) invokeLL.objValue;
    }

    public static boolean c(zv7 zv7Var, PostData postData) {
        InterceptResult invokeLL;
        Interceptable interceptable = $ic;
        if (interceptable == null || (invokeLL = interceptable.invokeLL(65538, null, zv7Var, postData)) == null) {
            if (zv7Var == null || postData == null || zv7Var.d() == null || zv7Var.l() == null) {
                return false;
            }
            nk5 nk5Var = new nk5();
            nk5Var.d(zv7Var.d().getId());
            nk5Var.f(zv7Var.l().getId());
            nk5Var.e(postData.L());
            return ik5.b().c(nk5Var);
        }
        return invokeLL.booleanValue;
    }

    public static void d(TbPageContext tbPageContext, SubPbModel subPbModel, r18 r18Var) {
        Interceptable interceptable = $ic;
        if (!(interceptable == null || interceptable.invokeLLL(65539, null, tbPageContext, subPbModel, r18Var) == null) || tbPageContext == null || r18Var == null || r18Var.u() == null || subPbModel == null) {
            return;
        }
        ik5.b().e(tbPageContext, (ViewGroup) r18Var.u(), b(subPbModel, r18Var));
        ik5.b().d(3);
    }

    public static boolean e(PostData postData) {
        InterceptResult invokeL;
        Interceptable interceptable = $ic;
        if (interceptable == null || (invokeL = interceptable.invokeL(InputDeviceCompat.SOURCE_TRACKBALL, null, postData)) == null) {
            if (postData == null) {
                return false;
            }
            return ik5.b().f(postData.L());
        }
        return invokeL.booleanValue;
    }
}
