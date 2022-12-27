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
public class k68 {
    public static /* synthetic */ Interceptable $ic;
    public transient /* synthetic */ FieldHolder $fh;

    /* loaded from: classes5.dex */
    public static class a implements um5 {
        public static /* synthetic */ Interceptable $ic;
        public transient /* synthetic */ FieldHolder $fh;
        public final /* synthetic */ r68 a;
        public final /* synthetic */ SubPbModel b;

        public a(r68 r68Var, SubPbModel subPbModel) {
            Interceptable interceptable = $ic;
            if (interceptable != null) {
                InitContext newInitContext = TitanRuntime.newInitContext();
                newInitContext.initArgs = r2;
                Object[] objArr = {r68Var, subPbModel};
                interceptable.invokeUnInit(65536, newInitContext);
                int i = newInitContext.flag;
                if ((i & 1) != 0) {
                    int i2 = i & 2;
                    newInitContext.thisArg = this;
                    interceptable.invokeInitBody(65536, newInitContext);
                    return;
                }
            }
            this.a = r68Var;
            this.b = subPbModel;
        }

        @Override // com.baidu.tieba.um5
        public void a() {
            Interceptable interceptable = $ic;
            if (interceptable == null || interceptable.invokeV(1048576, this) == null) {
                this.a.E0(false);
            }
        }

        @Override // com.baidu.tieba.um5
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
                    if (data.get(i) instanceof a78) {
                        ((a78) data.get(i)).b(this.b.t0().m());
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
            tm5.b().a();
        }
    }

    public static wm5 b(SubPbModel subPbModel, r68 r68Var) {
        InterceptResult invokeLL;
        Interceptable interceptable = $ic;
        if (interceptable == null || (invokeLL = interceptable.invokeLL(65537, null, subPbModel, r68Var)) == null) {
            if (subPbModel != null && r68Var != null) {
                wm5 wm5Var = new wm5();
                wm5Var.p(subPbModel.v0());
                wm5Var.o(subPbModel.u0());
                wm5Var.n(subPbModel.y0());
                if (subPbModel.t0() != null && subPbModel.t0().d() != null) {
                    wm5Var.l(subPbModel.t0().d().getId());
                    wm5Var.m(subPbModel.t0().d().getName());
                    wm5Var.k(subPbModel.t0().d().getImage_url());
                    wm5Var.t(subPbModel.t0().d().getUser_level());
                }
                UserData userData = new UserData();
                userData.setIsManager(subPbModel.A0());
                wm5Var.s(userData);
                wm5Var.q(new a(r68Var, subPbModel));
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
                wm5Var.r(sparseArray);
                return wm5Var;
            }
            return null;
        }
        return (wm5) invokeLL.objValue;
    }

    public static boolean c(y08 y08Var, PostData postData) {
        InterceptResult invokeLL;
        Interceptable interceptable = $ic;
        if (interceptable == null || (invokeLL = interceptable.invokeLL(65538, null, y08Var, postData)) == null) {
            if (y08Var != null && postData != null && y08Var.d() != null && y08Var.l() != null) {
                ym5 ym5Var = new ym5();
                ym5Var.d(y08Var.d().getId());
                ym5Var.f(y08Var.l().getId());
                ym5Var.e(postData.M());
                return tm5.b().c(ym5Var);
            }
            return false;
        }
        return invokeLL.booleanValue;
    }

    public static void d(TbPageContext tbPageContext, SubPbModel subPbModel, r68 r68Var) {
        Interceptable interceptable = $ic;
        if ((interceptable == null || interceptable.invokeLLL(65539, null, tbPageContext, subPbModel, r68Var) == null) && tbPageContext != null && r68Var != null && r68Var.u() != null && subPbModel != null) {
            tm5.b().e(tbPageContext, (ViewGroup) r68Var.u(), b(subPbModel, r68Var));
            tm5.b().d(3);
        }
    }

    public static boolean e(PostData postData) {
        InterceptResult invokeL;
        Interceptable interceptable = $ic;
        if (interceptable == null || (invokeL = interceptable.invokeL(InputDeviceCompat.SOURCE_TRACKBALL, null, postData)) == null) {
            if (postData == null) {
                return false;
            }
            return tm5.b().f(postData.M());
        }
        return invokeL.booleanValue;
    }
}
