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
public class kj8 {
    public static /* synthetic */ Interceptable $ic;
    public transient /* synthetic */ FieldHolder $fh;

    /* loaded from: classes5.dex */
    public static class a implements qt5 {
        public static /* synthetic */ Interceptable $ic;
        public transient /* synthetic */ FieldHolder $fh;
        public final /* synthetic */ rj8 a;
        public final /* synthetic */ SubPbModel b;

        public a(rj8 rj8Var, SubPbModel subPbModel) {
            Interceptable interceptable = $ic;
            if (interceptable != null) {
                InitContext newInitContext = TitanRuntime.newInitContext();
                newInitContext.initArgs = r2;
                Object[] objArr = {rj8Var, subPbModel};
                interceptable.invokeUnInit(65536, newInitContext);
                int i = newInitContext.flag;
                if ((i & 1) != 0) {
                    int i2 = i & 2;
                    newInitContext.thisArg = this;
                    interceptable.invokeInitBody(65536, newInitContext);
                    return;
                }
            }
            this.a = rj8Var;
            this.b = subPbModel;
        }

        @Override // com.baidu.tieba.qt5
        public void a() {
            Interceptable interceptable = $ic;
            if (interceptable == null || interceptable.invokeV(1048576, this) == null) {
                this.a.E0(false);
            }
        }

        @Override // com.baidu.tieba.qt5
        public void b(List<String> list) {
            int i;
            Interceptable interceptable = $ic;
            if ((interceptable != null && interceptable.invokeL(Constants.METHOD_GET_CONTACTER_INFO_FOR_SESSION, this, list) != null) || !(this.a.B() instanceof BdTypeListView)) {
                return;
            }
            List<Cdo> data = ((BdTypeListView) this.a.B()).getData();
            if (!ListUtils.isEmpty(data) && !ListUtils.isEmpty(list)) {
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
                            } else if (TextUtils.equals(list.get(i), ((PostData) next).O())) {
                                it.remove();
                                if (this.b.A0() != null) {
                                    this.b.A0().F(this.b.A0().m() - 1);
                                }
                            } else {
                                i++;
                            }
                        }
                    }
                }
                while (i < data.size()) {
                    if (data.get(i) instanceof ak8) {
                        ((ak8) data.get(i)).b(this.b.A0().m());
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
            pt5.b().a();
        }
    }

    public static st5 b(SubPbModel subPbModel, rj8 rj8Var) {
        InterceptResult invokeLL;
        Interceptable interceptable = $ic;
        if (interceptable == null || (invokeLL = interceptable.invokeLL(65537, null, subPbModel, rj8Var)) == null) {
            if (subPbModel != null && rj8Var != null) {
                st5 st5Var = new st5();
                st5Var.p(subPbModel.C0());
                st5Var.o(subPbModel.B0());
                st5Var.n(subPbModel.F0());
                if (subPbModel.A0() != null && subPbModel.A0().d() != null) {
                    st5Var.l(subPbModel.A0().d().getId());
                    st5Var.m(subPbModel.A0().d().getName());
                    st5Var.k(subPbModel.A0().d().getImage_url());
                    st5Var.t(subPbModel.A0().d().getUser_level());
                }
                UserData userData = new UserData();
                userData.setIsManager(subPbModel.H0());
                st5Var.s(userData);
                st5Var.q(new a(rj8Var, subPbModel));
                AntiData y0 = subPbModel.y0();
                SparseArray<String> sparseArray = new SparseArray<>();
                if (y0 != null && y0.getDelThreadInfoList() != null) {
                    List<DeleteThreadInfo> delThreadInfoList = y0.getDelThreadInfoList();
                    for (int i = 0; i < delThreadInfoList.size(); i++) {
                        if (delThreadInfoList.get(i) != null && !TextUtils.isEmpty(delThreadInfoList.get(i).text_info)) {
                            sparseArray.put(delThreadInfoList.get(i).text_id, delThreadInfoList.get(i).text_info);
                        }
                    }
                }
                st5Var.r(sparseArray);
                return st5Var;
            }
            return null;
        }
        return (st5) invokeLL.objValue;
    }

    public static boolean c(xd8 xd8Var, PostData postData) {
        InterceptResult invokeLL;
        Interceptable interceptable = $ic;
        if (interceptable == null || (invokeLL = interceptable.invokeLL(65538, null, xd8Var, postData)) == null) {
            if (xd8Var != null && postData != null && xd8Var.d() != null && xd8Var.l() != null) {
                ut5 ut5Var = new ut5();
                ut5Var.d(xd8Var.d().getId());
                ut5Var.f(xd8Var.l().getId());
                ut5Var.e(postData.O());
                return pt5.b().c(ut5Var);
            }
            return false;
        }
        return invokeLL.booleanValue;
    }

    public static void d(TbPageContext tbPageContext, SubPbModel subPbModel, rj8 rj8Var) {
        Interceptable interceptable = $ic;
        if ((interceptable == null || interceptable.invokeLLL(65539, null, tbPageContext, subPbModel, rj8Var) == null) && tbPageContext != null && rj8Var != null && rj8Var.u() != null && subPbModel != null) {
            pt5.b().e(tbPageContext, (ViewGroup) rj8Var.u(), b(subPbModel, rj8Var));
            pt5.b().d(3);
        }
    }

    public static boolean e(PostData postData) {
        InterceptResult invokeL;
        Interceptable interceptable = $ic;
        if (interceptable == null || (invokeL = interceptable.invokeL(InputDeviceCompat.SOURCE_TRACKBALL, null, postData)) == null) {
            if (postData == null) {
                return false;
            }
            return pt5.b().f(postData.O());
        }
        return invokeL.booleanValue;
    }
}
