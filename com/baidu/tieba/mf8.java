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
public class mf8 {
    public static /* synthetic */ Interceptable $ic;
    public transient /* synthetic */ FieldHolder $fh;

    /* loaded from: classes5.dex */
    public static class a implements zr5 {
        public static /* synthetic */ Interceptable $ic;
        public transient /* synthetic */ FieldHolder $fh;
        public final /* synthetic */ tf8 a;
        public final /* synthetic */ SubPbModel b;

        public a(tf8 tf8Var, SubPbModel subPbModel) {
            Interceptable interceptable = $ic;
            if (interceptable != null) {
                InitContext newInitContext = TitanRuntime.newInitContext();
                newInitContext.initArgs = r2;
                Object[] objArr = {tf8Var, subPbModel};
                interceptable.invokeUnInit(65536, newInitContext);
                int i = newInitContext.flag;
                if ((i & 1) != 0) {
                    int i2 = i & 2;
                    newInitContext.thisArg = this;
                    interceptable.invokeInitBody(65536, newInitContext);
                    return;
                }
            }
            this.a = tf8Var;
            this.b = subPbModel;
        }

        @Override // com.baidu.tieba.zr5
        public void a() {
            Interceptable interceptable = $ic;
            if (interceptable == null || interceptable.invokeV(1048576, this) == null) {
                this.a.B0(false);
            }
        }

        @Override // com.baidu.tieba.zr5
        public void b(List<String> list) {
            int i;
            Interceptable interceptable = $ic;
            if ((interceptable != null && interceptable.invokeL(Constants.METHOD_GET_CONTACTER_INFO_FOR_SESSION, this, list) != null) || !(this.a.A() instanceof BdTypeListView)) {
                return;
            }
            List<Cdo> data = ((BdTypeListView) this.a.A()).getData();
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
                                if (this.b.r0() != null) {
                                    this.b.r0().C(this.b.r0().m() - 1);
                                }
                            } else {
                                i++;
                            }
                        }
                    }
                }
                while (i < data.size()) {
                    if (data.get(i) instanceof cg8) {
                        ((cg8) data.get(i)).b(this.b.r0().m());
                    }
                    i++;
                }
                ((BdTypeListView) this.a.A()).setData(data);
                this.a.S();
            }
        }
    }

    public static void a() {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeV(65536, null) == null) {
            yr5.b().a();
        }
    }

    public static bs5 b(SubPbModel subPbModel, tf8 tf8Var) {
        InterceptResult invokeLL;
        Interceptable interceptable = $ic;
        if (interceptable == null || (invokeLL = interceptable.invokeLL(65537, null, subPbModel, tf8Var)) == null) {
            if (subPbModel != null && tf8Var != null) {
                bs5 bs5Var = new bs5();
                bs5Var.p(subPbModel.t0());
                bs5Var.o(subPbModel.s0());
                bs5Var.n(subPbModel.w0());
                if (subPbModel.r0() != null && subPbModel.r0().d() != null) {
                    bs5Var.l(subPbModel.r0().d().getId());
                    bs5Var.m(subPbModel.r0().d().getName());
                    bs5Var.k(subPbModel.r0().d().getImage_url());
                    bs5Var.t(subPbModel.r0().d().getUser_level());
                }
                UserData userData = new UserData();
                userData.setIsManager(subPbModel.y0());
                bs5Var.s(userData);
                bs5Var.q(new a(tf8Var, subPbModel));
                AntiData p0 = subPbModel.p0();
                SparseArray<String> sparseArray = new SparseArray<>();
                if (p0 != null && p0.getDelThreadInfoList() != null) {
                    List<DeleteThreadInfo> delThreadInfoList = p0.getDelThreadInfoList();
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

    public static boolean c(ja8 ja8Var, PostData postData) {
        InterceptResult invokeLL;
        Interceptable interceptable = $ic;
        if (interceptable == null || (invokeLL = interceptable.invokeLL(65538, null, ja8Var, postData)) == null) {
            if (ja8Var != null && postData != null && ja8Var.d() != null && ja8Var.l() != null) {
                ds5 ds5Var = new ds5();
                ds5Var.d(ja8Var.d().getId());
                ds5Var.f(ja8Var.l().getId());
                ds5Var.e(postData.O());
                return yr5.b().c(ds5Var);
            }
            return false;
        }
        return invokeLL.booleanValue;
    }

    public static void d(TbPageContext tbPageContext, SubPbModel subPbModel, tf8 tf8Var) {
        Interceptable interceptable = $ic;
        if ((interceptable == null || interceptable.invokeLLL(65539, null, tbPageContext, subPbModel, tf8Var) == null) && tbPageContext != null && tf8Var != null && tf8Var.t() != null && subPbModel != null) {
            yr5.b().e(tbPageContext, (ViewGroup) tf8Var.t(), b(subPbModel, tf8Var));
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
