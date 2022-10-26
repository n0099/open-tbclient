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
/* loaded from: classes6.dex */
public class v18 {
    public static /* synthetic */ Interceptable $ic;
    public transient /* synthetic */ FieldHolder $fh;

    /* loaded from: classes6.dex */
    public final class a implements qk5 {
        public static /* synthetic */ Interceptable $ic;
        public transient /* synthetic */ FieldHolder $fh;
        public final /* synthetic */ c28 a;
        public final /* synthetic */ SubPbModel b;

        public a(c28 c28Var, SubPbModel subPbModel) {
            Interceptable interceptable = $ic;
            if (interceptable != null) {
                InitContext newInitContext = TitanRuntime.newInitContext();
                newInitContext.initArgs = r2;
                Object[] objArr = {c28Var, subPbModel};
                interceptable.invokeUnInit(65536, newInitContext);
                int i = newInitContext.flag;
                if ((i & 1) != 0) {
                    int i2 = i & 2;
                    newInitContext.thisArg = this;
                    interceptable.invokeInitBody(65536, newInitContext);
                    return;
                }
            }
            this.a = c28Var;
            this.b = subPbModel;
        }

        @Override // com.baidu.tieba.qk5
        public void a() {
            Interceptable interceptable = $ic;
            if (interceptable == null || interceptable.invokeV(1048576, this) == null) {
                this.a.E0(false);
            }
        }

        @Override // com.baidu.tieba.qk5
        public void b(List list) {
            int i;
            Interceptable interceptable = $ic;
            if ((interceptable != null && interceptable.invokeL(Constants.METHOD_GET_CONTACTER_INFO_FOR_SESSION, this, list) != null) || !(this.a.B() instanceof BdTypeListView)) {
                return;
            }
            List data = ((BdTypeListView) this.a.B()).getData();
            if (!ListUtils.isEmpty(data) && !ListUtils.isEmpty(list)) {
                Iterator it = data.iterator();
                while (true) {
                    i = 0;
                    if (!it.hasNext()) {
                        break;
                    }
                    eo eoVar = (eo) it.next();
                    if (eoVar instanceof PostData) {
                        while (true) {
                            if (i >= list.size()) {
                                break;
                            } else if (TextUtils.equals((CharSequence) list.get(i), ((PostData) eoVar).M())) {
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
                    if (data.get(i) instanceof l28) {
                        ((l28) data.get(i)).b(this.b.m0().m());
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
            pk5.b().a();
        }
    }

    public static sk5 b(SubPbModel subPbModel, c28 c28Var) {
        InterceptResult invokeLL;
        Interceptable interceptable = $ic;
        if (interceptable == null || (invokeLL = interceptable.invokeLL(65537, null, subPbModel, c28Var)) == null) {
            if (subPbModel != null && c28Var != null) {
                sk5 sk5Var = new sk5();
                sk5Var.p(subPbModel.o0());
                sk5Var.o(subPbModel.n0());
                sk5Var.n(subPbModel.r0());
                if (subPbModel.m0() != null && subPbModel.m0().d() != null) {
                    sk5Var.l(subPbModel.m0().d().getId());
                    sk5Var.m(subPbModel.m0().d().getName());
                    sk5Var.k(subPbModel.m0().d().getImage_url());
                    sk5Var.t(subPbModel.m0().d().getUser_level());
                }
                UserData userData = new UserData();
                userData.setIsManager(subPbModel.t0());
                sk5Var.s(userData);
                sk5Var.q(new a(c28Var, subPbModel));
                AntiData k0 = subPbModel.k0();
                SparseArray sparseArray = new SparseArray();
                if (k0 != null && k0.getDelThreadInfoList() != null) {
                    List<DeleteThreadInfo> delThreadInfoList = k0.getDelThreadInfoList();
                    for (int i = 0; i < delThreadInfoList.size(); i++) {
                        if (delThreadInfoList.get(i) != null && !TextUtils.isEmpty(delThreadInfoList.get(i).text_info)) {
                            sparseArray.put(delThreadInfoList.get(i).text_id, delThreadInfoList.get(i).text_info);
                        }
                    }
                }
                sk5Var.r(sparseArray);
                return sk5Var;
            }
            return null;
        }
        return (sk5) invokeLL.objValue;
    }

    public static boolean c(kw7 kw7Var, PostData postData) {
        InterceptResult invokeLL;
        Interceptable interceptable = $ic;
        if (interceptable == null || (invokeLL = interceptable.invokeLL(65538, null, kw7Var, postData)) == null) {
            if (kw7Var != null && postData != null && kw7Var.d() != null && kw7Var.l() != null) {
                uk5 uk5Var = new uk5();
                uk5Var.d(kw7Var.d().getId());
                uk5Var.f(kw7Var.l().getId());
                uk5Var.e(postData.M());
                return pk5.b().c(uk5Var);
            }
            return false;
        }
        return invokeLL.booleanValue;
    }

    public static void d(TbPageContext tbPageContext, SubPbModel subPbModel, c28 c28Var) {
        Interceptable interceptable = $ic;
        if ((interceptable == null || interceptable.invokeLLL(65539, null, tbPageContext, subPbModel, c28Var) == null) && tbPageContext != null && c28Var != null && c28Var.u() != null && subPbModel != null) {
            pk5.b().e(tbPageContext, (ViewGroup) c28Var.u(), b(subPbModel, c28Var));
            pk5.b().d(3);
        }
    }

    public static boolean e(PostData postData) {
        InterceptResult invokeL;
        Interceptable interceptable = $ic;
        if (interceptable == null || (invokeL = interceptable.invokeL(InputDeviceCompat.SOURCE_TRACKBALL, null, postData)) == null) {
            if (postData == null) {
                return false;
            }
            return pk5.b().f(postData.M());
        }
        return invokeL.booleanValue;
    }
}
