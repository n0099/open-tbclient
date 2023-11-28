package com.baidu.tieba;

import android.text.TextUtils;
import android.util.SparseArray;
import androidx.core.view.InputDeviceCompat;
import com.baidu.android.imsdk.internal.Constants;
import com.baidu.tbadk.TbPageContext;
import com.baidu.tbadk.core.BaseFragmentActivity;
import com.baidu.tbadk.core.data.AntiData;
import com.baidu.tbadk.core.data.DeleteThreadInfo;
import com.baidu.tbadk.core.util.ListUtils;
import com.baidu.tieba.pb.pb.main.PbModel;
import com.baidu.titan.sdk.runtime.FieldHolder;
import com.baidu.titan.sdk.runtime.InitContext;
import com.baidu.titan.sdk.runtime.InterceptResult;
import com.baidu.titan.sdk.runtime.Interceptable;
import com.baidu.titan.sdk.runtime.TitanRuntime;
import java.util.ArrayList;
import java.util.Iterator;
import java.util.List;
/* loaded from: classes7.dex */
public class l4a {
    public static /* synthetic */ Interceptable $ic;
    public transient /* synthetic */ FieldHolder $fh;

    /* loaded from: classes7.dex */
    public class a implements qx5 {
        public static /* synthetic */ Interceptable $ic;
        public transient /* synthetic */ FieldHolder $fh;
        public final /* synthetic */ PbModel a;
        public final /* synthetic */ j1a b;

        public a(PbModel pbModel, j1a j1aVar) {
            Interceptable interceptable = $ic;
            if (interceptable != null) {
                InitContext newInitContext = TitanRuntime.newInitContext();
                newInitContext.initArgs = r2;
                Object[] objArr = {pbModel, j1aVar};
                interceptable.invokeUnInit(65536, newInitContext);
                int i = newInitContext.flag;
                if ((i & 1) != 0) {
                    int i2 = i & 2;
                    newInitContext.thisArg = this;
                    interceptable.invokeInitBody(65536, newInitContext);
                    return;
                }
            }
            this.a = pbModel;
            this.b = j1aVar;
        }

        @Override // com.baidu.tieba.qx5
        public void a() {
            Interceptable interceptable = $ic;
            if (interceptable == null || interceptable.invokeV(1048576, this) == null) {
                this.b.H4(false);
            }
        }

        @Override // com.baidu.tieba.qx5
        public void b(List<String> list) {
            Interceptable interceptable = $ic;
            if ((interceptable != null && interceptable.invokeL(Constants.METHOD_GET_CONTACTER_INFO_FOR_SESSION, this, list) != null) || this.a.s1() == null) {
                return;
            }
            ArrayList<nwa> I = this.a.s1().I();
            if (!ListUtils.isEmpty(I) && !ListUtils.isEmpty(list)) {
                Iterator<nwa> it = I.iterator();
                while (it.hasNext()) {
                    nwa next = it.next();
                    int i = 0;
                    while (true) {
                        if (i >= list.size()) {
                            break;
                        } else if (TextUtils.equals(list.get(i), next.U())) {
                            it.remove();
                            if (this.a.s1().R() != null) {
                                this.a.s1().R().setReply_num(this.a.s1().R().getReply_num() - 1);
                            }
                        } else {
                            i++;
                        }
                    }
                }
                this.b.Y1(this.a.s1());
            }
        }
    }

    public static void a() {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeV(65536, null) == null) {
            px5.b().a();
        }
    }

    public static sx5 b(PbModel pbModel, j1a j1aVar) {
        InterceptResult invokeLL;
        Interceptable interceptable = $ic;
        if (interceptable == null || (invokeLL = interceptable.invokeLL(65537, null, pbModel, j1aVar)) == null) {
            if (pbModel != null && j1aVar != null) {
                sx5 sx5Var = new sx5();
                if (pbModel.s1() != null && pbModel.s1().n() != null) {
                    if (pbModel.s1().n().getDeletedReasonInfo() != null) {
                        sx5Var.p(pbModel.s1().n().getDeletedReasonInfo().is_grays_cale_forum.intValue());
                        sx5Var.o(pbModel.s1().n().getDeletedReasonInfo().is_boomgrow.intValue());
                    }
                    sx5Var.l(pbModel.s1().n().getId());
                    sx5Var.m(pbModel.s1().n().getName());
                    sx5Var.k(pbModel.s1().n().getImage_url());
                    sx5Var.t(pbModel.s1().n().getUser_level());
                }
                if (pbModel.s1() != null && pbModel.s1().q() != null) {
                    sx5Var.n(pbModel.s1().q().has_forum_rule.intValue());
                }
                if (pbModel.s1() != null && pbModel.s1().Y() != null) {
                    sx5Var.s(pbModel.s1().Y());
                }
                sx5Var.q(new a(pbModel, j1aVar));
                if (pbModel.s1() != null) {
                    AntiData f = pbModel.s1().f();
                    SparseArray<String> sparseArray = new SparseArray<>();
                    if (f != null && f.getDelThreadInfoList() != null) {
                        List<DeleteThreadInfo> delThreadInfoList = f.getDelThreadInfoList();
                        for (int i = 0; i < delThreadInfoList.size(); i++) {
                            if (delThreadInfoList.get(i) != null && !TextUtils.isEmpty(delThreadInfoList.get(i).text_info)) {
                                sparseArray.put(delThreadInfoList.get(i).text_id, delThreadInfoList.get(i).text_info);
                            }
                        }
                    }
                    sx5Var.r(sparseArray);
                }
                return sx5Var;
            }
            return null;
        }
        return (sx5) invokeLL.objValue;
    }

    public static boolean c(vv9 vv9Var, nwa nwaVar) {
        InterceptResult invokeLL;
        Interceptable interceptable = $ic;
        if (interceptable == null || (invokeLL = interceptable.invokeLL(65538, null, vv9Var, nwaVar)) == null) {
            if (vv9Var != null && nwaVar != null) {
                ux5 ux5Var = new ux5();
                ux5Var.d(nwaVar.Q() + "");
                if (vv9Var.R() != null) {
                    ux5Var.f(vv9Var.R().getId());
                }
                ux5Var.e(nwaVar.U());
                return px5.b().c(ux5Var);
            }
            return false;
        }
        return invokeLL.booleanValue;
    }

    public static void d(TbPageContext<BaseFragmentActivity> tbPageContext, PbModel pbModel, j1a j1aVar) {
        Interceptable interceptable = $ic;
        if ((interceptable == null || interceptable.invokeLLL(65539, null, tbPageContext, pbModel, j1aVar) == null) && tbPageContext != null && pbModel != null && j1aVar != null) {
            px5.b().e(tbPageContext, j1aVar.u1(), b(pbModel, j1aVar));
            px5.b().d(1);
        }
    }

    public static boolean e(nwa nwaVar) {
        InterceptResult invokeL;
        Interceptable interceptable = $ic;
        if (interceptable == null || (invokeL = interceptable.invokeL(InputDeviceCompat.SOURCE_TRACKBALL, null, nwaVar)) == null) {
            if (nwaVar == null) {
                return false;
            }
            return px5.b().f(nwaVar.U());
        }
        return invokeL.booleanValue;
    }
}
