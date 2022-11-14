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
public class q38 {
    public static /* synthetic */ Interceptable $ic;
    public transient /* synthetic */ FieldHolder $fh;

    /* loaded from: classes5.dex */
    public static class a implements yl5 {
        public static /* synthetic */ Interceptable $ic;
        public transient /* synthetic */ FieldHolder $fh;
        public final /* synthetic */ x38 a;
        public final /* synthetic */ SubPbModel b;

        public a(x38 x38Var, SubPbModel subPbModel) {
            Interceptable interceptable = $ic;
            if (interceptable != null) {
                InitContext newInitContext = TitanRuntime.newInitContext();
                newInitContext.initArgs = r2;
                Object[] objArr = {x38Var, subPbModel};
                interceptable.invokeUnInit(65536, newInitContext);
                int i = newInitContext.flag;
                if ((i & 1) != 0) {
                    int i2 = i & 2;
                    newInitContext.thisArg = this;
                    interceptable.invokeInitBody(65536, newInitContext);
                    return;
                }
            }
            this.a = x38Var;
            this.b = subPbModel;
        }

        @Override // com.baidu.tieba.yl5
        public void a() {
            Interceptable interceptable = $ic;
            if (interceptable == null || interceptable.invokeV(1048576, this) == null) {
                this.a.E0(false);
            }
        }

        @Override // com.baidu.tieba.yl5
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
                    if (data.get(i) instanceof g48) {
                        ((g48) data.get(i)).b(this.b.m0().m());
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
            xl5.b().a();
        }
    }

    public static am5 b(SubPbModel subPbModel, x38 x38Var) {
        InterceptResult invokeLL;
        Interceptable interceptable = $ic;
        if (interceptable == null || (invokeLL = interceptable.invokeLL(65537, null, subPbModel, x38Var)) == null) {
            if (subPbModel != null && x38Var != null) {
                am5 am5Var = new am5();
                am5Var.p(subPbModel.o0());
                am5Var.o(subPbModel.n0());
                am5Var.n(subPbModel.r0());
                if (subPbModel.m0() != null && subPbModel.m0().d() != null) {
                    am5Var.l(subPbModel.m0().d().getId());
                    am5Var.m(subPbModel.m0().d().getName());
                    am5Var.k(subPbModel.m0().d().getImage_url());
                    am5Var.t(subPbModel.m0().d().getUser_level());
                }
                UserData userData = new UserData();
                userData.setIsManager(subPbModel.t0());
                am5Var.s(userData);
                am5Var.q(new a(x38Var, subPbModel));
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
                am5Var.r(sparseArray);
                return am5Var;
            }
            return null;
        }
        return (am5) invokeLL.objValue;
    }

    public static boolean c(ey7 ey7Var, PostData postData) {
        InterceptResult invokeLL;
        Interceptable interceptable = $ic;
        if (interceptable == null || (invokeLL = interceptable.invokeLL(65538, null, ey7Var, postData)) == null) {
            if (ey7Var != null && postData != null && ey7Var.d() != null && ey7Var.l() != null) {
                cm5 cm5Var = new cm5();
                cm5Var.d(ey7Var.d().getId());
                cm5Var.f(ey7Var.l().getId());
                cm5Var.e(postData.M());
                return xl5.b().c(cm5Var);
            }
            return false;
        }
        return invokeLL.booleanValue;
    }

    public static void d(TbPageContext tbPageContext, SubPbModel subPbModel, x38 x38Var) {
        Interceptable interceptable = $ic;
        if ((interceptable == null || interceptable.invokeLLL(65539, null, tbPageContext, subPbModel, x38Var) == null) && tbPageContext != null && x38Var != null && x38Var.u() != null && subPbModel != null) {
            xl5.b().e(tbPageContext, (ViewGroup) x38Var.u(), b(subPbModel, x38Var));
            xl5.b().d(3);
        }
    }

    public static boolean e(PostData postData) {
        InterceptResult invokeL;
        Interceptable interceptable = $ic;
        if (interceptable == null || (invokeL = interceptable.invokeL(InputDeviceCompat.SOURCE_TRACKBALL, null, postData)) == null) {
            if (postData == null) {
                return false;
            }
            return xl5.b().f(postData.M());
        }
        return invokeL.booleanValue;
    }
}
