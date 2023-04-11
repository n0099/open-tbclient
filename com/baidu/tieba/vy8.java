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
/* loaded from: classes6.dex */
public class vy8 {
    public static /* synthetic */ Interceptable $ic;
    public transient /* synthetic */ FieldHolder $fh;

    /* loaded from: classes6.dex */
    public static class a implements cu5 {
        public static /* synthetic */ Interceptable $ic;
        public transient /* synthetic */ FieldHolder $fh;
        public final /* synthetic */ cz8 a;
        public final /* synthetic */ SubPbModel b;

        public a(cz8 cz8Var, SubPbModel subPbModel) {
            Interceptable interceptable = $ic;
            if (interceptable != null) {
                InitContext newInitContext = TitanRuntime.newInitContext();
                newInitContext.initArgs = r2;
                Object[] objArr = {cz8Var, subPbModel};
                interceptable.invokeUnInit(65536, newInitContext);
                int i = newInitContext.flag;
                if ((i & 1) != 0) {
                    int i2 = i & 2;
                    newInitContext.thisArg = this;
                    interceptable.invokeInitBody(65536, newInitContext);
                    return;
                }
            }
            this.a = cz8Var;
            this.b = subPbModel;
        }

        @Override // com.baidu.tieba.cu5
        public void a() {
            Interceptable interceptable = $ic;
            if (interceptable == null || interceptable.invokeV(1048576, this) == null) {
                this.a.E0(false);
            }
        }

        @Override // com.baidu.tieba.cu5
        public void b(List<String> list) {
            int i;
            Interceptable interceptable = $ic;
            if ((interceptable != null && interceptable.invokeL(Constants.METHOD_GET_CONTACTER_INFO_FOR_SESSION, this, list) != null) || !(this.a.B() instanceof BdTypeListView)) {
                return;
            }
            List<hn> data = ((BdTypeListView) this.a.B()).getData();
            if (!ListUtils.isEmpty(data) && !ListUtils.isEmpty(list)) {
                Iterator<hn> it = data.iterator();
                while (true) {
                    i = 0;
                    if (!it.hasNext()) {
                        break;
                    }
                    hn next = it.next();
                    if (next instanceof sl9) {
                        while (true) {
                            if (i >= list.size()) {
                                break;
                            } else if (TextUtils.equals(list.get(i), ((sl9) next).O())) {
                                it.remove();
                                if (this.b.B0() != null) {
                                    this.b.B0().A(this.b.B0().k() - 1);
                                }
                            } else {
                                i++;
                            }
                        }
                    }
                }
                while (i < data.size()) {
                    if (data.get(i) instanceof lz8) {
                        ((lz8) data.get(i)).b(this.b.B0().k());
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
            bu5.b().a();
        }
    }

    public static eu5 b(SubPbModel subPbModel, cz8 cz8Var) {
        InterceptResult invokeLL;
        Interceptable interceptable = $ic;
        if (interceptable == null || (invokeLL = interceptable.invokeLL(65537, null, subPbModel, cz8Var)) == null) {
            if (subPbModel != null && cz8Var != null) {
                eu5 eu5Var = new eu5();
                eu5Var.p(subPbModel.D0());
                eu5Var.o(subPbModel.C0());
                eu5Var.n(subPbModel.G0());
                if (subPbModel.B0() != null && subPbModel.B0().d() != null) {
                    eu5Var.l(subPbModel.B0().d().getId());
                    eu5Var.m(subPbModel.B0().d().getName());
                    eu5Var.k(subPbModel.B0().d().getImage_url());
                    eu5Var.t(subPbModel.B0().d().getUser_level());
                }
                UserData userData = new UserData();
                userData.setIsManager(subPbModel.I0());
                eu5Var.s(userData);
                eu5Var.q(new a(cz8Var, subPbModel));
                AntiData z0 = subPbModel.z0();
                SparseArray<String> sparseArray = new SparseArray<>();
                if (z0 != null && z0.getDelThreadInfoList() != null) {
                    List<DeleteThreadInfo> delThreadInfoList = z0.getDelThreadInfoList();
                    for (int i = 0; i < delThreadInfoList.size(); i++) {
                        if (delThreadInfoList.get(i) != null && !TextUtils.isEmpty(delThreadInfoList.get(i).text_info)) {
                            sparseArray.put(delThreadInfoList.get(i).text_id, delThreadInfoList.get(i).text_info);
                        }
                    }
                }
                eu5Var.r(sparseArray);
                return eu5Var;
            }
            return null;
        }
        return (eu5) invokeLL.objValue;
    }

    public static boolean c(ot8 ot8Var, sl9 sl9Var) {
        InterceptResult invokeLL;
        Interceptable interceptable = $ic;
        if (interceptable == null || (invokeLL = interceptable.invokeLL(65538, null, ot8Var, sl9Var)) == null) {
            if (ot8Var != null && sl9Var != null && ot8Var.d() != null && ot8Var.j() != null) {
                gu5 gu5Var = new gu5();
                gu5Var.d(ot8Var.d().getId());
                gu5Var.f(ot8Var.j().getId());
                gu5Var.e(sl9Var.O());
                return bu5.b().c(gu5Var);
            }
            return false;
        }
        return invokeLL.booleanValue;
    }

    public static void d(TbPageContext tbPageContext, SubPbModel subPbModel, cz8 cz8Var) {
        Interceptable interceptable = $ic;
        if ((interceptable == null || interceptable.invokeLLL(65539, null, tbPageContext, subPbModel, cz8Var) == null) && tbPageContext != null && cz8Var != null && cz8Var.u() != null && subPbModel != null) {
            bu5.b().e(tbPageContext, (ViewGroup) cz8Var.u(), b(subPbModel, cz8Var));
            bu5.b().d(3);
        }
    }

    public static boolean e(sl9 sl9Var) {
        InterceptResult invokeL;
        Interceptable interceptable = $ic;
        if (interceptable == null || (invokeL = interceptable.invokeL(InputDeviceCompat.SOURCE_TRACKBALL, null, sl9Var)) == null) {
            if (sl9Var == null) {
                return false;
            }
            return bu5.b().f(sl9Var.O());
        }
        return invokeL.booleanValue;
    }
}
