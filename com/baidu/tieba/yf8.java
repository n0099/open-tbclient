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
/* loaded from: classes7.dex */
public class yf8 {
    public static /* synthetic */ Interceptable $ic;
    public transient /* synthetic */ FieldHolder $fh;

    /* loaded from: classes7.dex */
    public static class a implements zr5 {
        public static /* synthetic */ Interceptable $ic;
        public transient /* synthetic */ FieldHolder $fh;
        public final /* synthetic */ fg8 a;
        public final /* synthetic */ SubPbModel b;

        public a(fg8 fg8Var, SubPbModel subPbModel) {
            Interceptable interceptable = $ic;
            if (interceptable != null) {
                InitContext newInitContext = TitanRuntime.newInitContext();
                newInitContext.initArgs = r2;
                Object[] objArr = {fg8Var, subPbModel};
                interceptable.invokeUnInit(65536, newInitContext);
                int i = newInitContext.flag;
                if ((i & 1) != 0) {
                    int i2 = i & 2;
                    newInitContext.thisArg = this;
                    interceptable.invokeInitBody(65536, newInitContext);
                    return;
                }
            }
            this.a = fg8Var;
            this.b = subPbModel;
        }

        @Override // com.baidu.tieba.zr5
        public void a() {
            Interceptable interceptable = $ic;
            if (interceptable == null || interceptable.invokeV(1048576, this) == null) {
                this.a.E0(false);
            }
        }

        @Override // com.baidu.tieba.zr5
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
                                if (this.b.t0() != null) {
                                    this.b.t0().F(this.b.t0().m() - 1);
                                }
                            } else {
                                i++;
                            }
                        }
                    }
                }
                while (i < data.size()) {
                    if (data.get(i) instanceof og8) {
                        ((og8) data.get(i)).b(this.b.t0().m());
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
            yr5.b().a();
        }
    }

    public static bs5 b(SubPbModel subPbModel, fg8 fg8Var) {
        InterceptResult invokeLL;
        Interceptable interceptable = $ic;
        if (interceptable == null || (invokeLL = interceptable.invokeLL(65537, null, subPbModel, fg8Var)) == null) {
            if (subPbModel != null && fg8Var != null) {
                bs5 bs5Var = new bs5();
                bs5Var.p(subPbModel.v0());
                bs5Var.o(subPbModel.u0());
                bs5Var.n(subPbModel.y0());
                if (subPbModel.t0() != null && subPbModel.t0().d() != null) {
                    bs5Var.l(subPbModel.t0().d().getId());
                    bs5Var.m(subPbModel.t0().d().getName());
                    bs5Var.k(subPbModel.t0().d().getImage_url());
                    bs5Var.t(subPbModel.t0().d().getUser_level());
                }
                UserData userData = new UserData();
                userData.setIsManager(subPbModel.A0());
                bs5Var.s(userData);
                bs5Var.q(new a(fg8Var, subPbModel));
                AntiData r0 = subPbModel.r0();
                SparseArray<String> sparseArray = new SparseArray<>();
                if (r0 != null && r0.getDelThreadInfoList() != null) {
                    List<DeleteThreadInfo> delThreadInfoList = r0.getDelThreadInfoList();
                    for (int i = 0; i < delThreadInfoList.size(); i++) {
                        if (delThreadInfoList.get(i) != null && !TextUtils.isEmpty(delThreadInfoList.get(i).text_info)) {
                            sparseArray.put(delThreadInfoList.get(i).text_id, delThreadInfoList.get(i).text_info);
                        }
                    }
                }
                bs5Var.r(sparseArray);
                return bs5Var;
            }
            return null;
        }
        return (bs5) invokeLL.objValue;
    }

    public static boolean c(la8 la8Var, PostData postData) {
        InterceptResult invokeLL;
        Interceptable interceptable = $ic;
        if (interceptable == null || (invokeLL = interceptable.invokeLL(65538, null, la8Var, postData)) == null) {
            if (la8Var != null && postData != null && la8Var.d() != null && la8Var.l() != null) {
                ds5 ds5Var = new ds5();
                ds5Var.d(la8Var.d().getId());
                ds5Var.f(la8Var.l().getId());
                ds5Var.e(postData.O());
                return yr5.b().c(ds5Var);
            }
            return false;
        }
        return invokeLL.booleanValue;
    }

    public static void d(TbPageContext tbPageContext, SubPbModel subPbModel, fg8 fg8Var) {
        Interceptable interceptable = $ic;
        if ((interceptable == null || interceptable.invokeLLL(65539, null, tbPageContext, subPbModel, fg8Var) == null) && tbPageContext != null && fg8Var != null && fg8Var.u() != null && subPbModel != null) {
            yr5.b().e(tbPageContext, (ViewGroup) fg8Var.u(), b(subPbModel, fg8Var));
            yr5.b().d(3);
        }
    }

    public static boolean e(PostData postData) {
        InterceptResult invokeL;
        Interceptable interceptable = $ic;
        if (interceptable == null || (invokeL = interceptable.invokeL(InputDeviceCompat.SOURCE_TRACKBALL, null, postData)) == null) {
            if (postData == null) {
                return false;
            }
            return yr5.b().f(postData.O());
        }
        return invokeL.booleanValue;
    }
}
