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
public class r38 {
    public static /* synthetic */ Interceptable $ic;
    public transient /* synthetic */ FieldHolder $fh;

    /* loaded from: classes5.dex */
    public static class a implements zl5 {
        public static /* synthetic */ Interceptable $ic;
        public transient /* synthetic */ FieldHolder $fh;
        public final /* synthetic */ y38 a;
        public final /* synthetic */ SubPbModel b;

        public a(y38 y38Var, SubPbModel subPbModel) {
            Interceptable interceptable = $ic;
            if (interceptable != null) {
                InitContext newInitContext = TitanRuntime.newInitContext();
                newInitContext.initArgs = r2;
                Object[] objArr = {y38Var, subPbModel};
                interceptable.invokeUnInit(65536, newInitContext);
                int i = newInitContext.flag;
                if ((i & 1) != 0) {
                    int i2 = i & 2;
                    newInitContext.thisArg = this;
                    interceptable.invokeInitBody(65536, newInitContext);
                    return;
                }
            }
            this.a = y38Var;
            this.b = subPbModel;
        }

        @Override // com.baidu.tieba.zl5
        public void a() {
            Interceptable interceptable = $ic;
            if (interceptable == null || interceptable.invokeV(1048576, this) == null) {
                this.a.E0(false);
            }
        }

        @Override // com.baidu.tieba.zl5
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
                    if (next instanceof PostData) {
                        while (true) {
                            if (i >= list.size()) {
                                break;
                            } else if (TextUtils.equals(list.get(i), ((PostData) next).M())) {
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
                    if (data.get(i) instanceof h48) {
                        ((h48) data.get(i)).b(this.b.m0().m());
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
            yl5.b().a();
        }
    }

    public static bm5 b(SubPbModel subPbModel, y38 y38Var) {
        InterceptResult invokeLL;
        Interceptable interceptable = $ic;
        if (interceptable == null || (invokeLL = interceptable.invokeLL(65537, null, subPbModel, y38Var)) == null) {
            if (subPbModel != null && y38Var != null) {
                bm5 bm5Var = new bm5();
                bm5Var.p(subPbModel.o0());
                bm5Var.o(subPbModel.n0());
                bm5Var.n(subPbModel.r0());
                if (subPbModel.m0() != null && subPbModel.m0().d() != null) {
                    bm5Var.l(subPbModel.m0().d().getId());
                    bm5Var.m(subPbModel.m0().d().getName());
                    bm5Var.k(subPbModel.m0().d().getImage_url());
                    bm5Var.t(subPbModel.m0().d().getUser_level());
                }
                UserData userData = new UserData();
                userData.setIsManager(subPbModel.t0());
                bm5Var.s(userData);
                bm5Var.q(new a(y38Var, subPbModel));
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
                bm5Var.r(sparseArray);
                return bm5Var;
            }
            return null;
        }
        return (bm5) invokeLL.objValue;
    }

    public static boolean c(fy7 fy7Var, PostData postData) {
        InterceptResult invokeLL;
        Interceptable interceptable = $ic;
        if (interceptable == null || (invokeLL = interceptable.invokeLL(65538, null, fy7Var, postData)) == null) {
            if (fy7Var != null && postData != null && fy7Var.d() != null && fy7Var.l() != null) {
                dm5 dm5Var = new dm5();
                dm5Var.d(fy7Var.d().getId());
                dm5Var.f(fy7Var.l().getId());
                dm5Var.e(postData.M());
                return yl5.b().c(dm5Var);
            }
            return false;
        }
        return invokeLL.booleanValue;
    }

    public static void d(TbPageContext tbPageContext, SubPbModel subPbModel, y38 y38Var) {
        Interceptable interceptable = $ic;
        if ((interceptable == null || interceptable.invokeLLL(65539, null, tbPageContext, subPbModel, y38Var) == null) && tbPageContext != null && y38Var != null && y38Var.u() != null && subPbModel != null) {
            yl5.b().e(tbPageContext, (ViewGroup) y38Var.u(), b(subPbModel, y38Var));
            yl5.b().d(3);
        }
    }

    public static boolean e(PostData postData) {
        InterceptResult invokeL;
        Interceptable interceptable = $ic;
        if (interceptable == null || (invokeL = interceptable.invokeL(InputDeviceCompat.SOURCE_TRACKBALL, null, postData)) == null) {
            if (postData == null) {
                return false;
            }
            return yl5.b().f(postData.M());
        }
        return invokeL.booleanValue;
    }
}
