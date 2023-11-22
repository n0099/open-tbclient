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
public class pz9 {
    public static /* synthetic */ Interceptable $ic;
    public transient /* synthetic */ FieldHolder $fh;

    /* loaded from: classes7.dex */
    public class a implements jx5 {
        public static /* synthetic */ Interceptable $ic;
        public transient /* synthetic */ FieldHolder $fh;
        public final /* synthetic */ PbModel a;
        public final /* synthetic */ jx9 b;

        public a(PbModel pbModel, jx9 jx9Var) {
            Interceptable interceptable = $ic;
            if (interceptable != null) {
                InitContext newInitContext = TitanRuntime.newInitContext();
                newInitContext.initArgs = r2;
                Object[] objArr = {pbModel, jx9Var};
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
            this.b = jx9Var;
        }

        @Override // com.baidu.tieba.jx5
        public void a() {
            Interceptable interceptable = $ic;
            if (interceptable == null || interceptable.invokeV(1048576, this) == null) {
                this.b.c5(false);
            }
        }

        @Override // com.baidu.tieba.jx5
        public void b(List<String> list) {
            Interceptable interceptable = $ic;
            if ((interceptable != null && interceptable.invokeL(Constants.METHOD_GET_CONTACTER_INFO_FOR_SESSION, this, list) != null) || this.a.t1() == null) {
                return;
            }
            ArrayList<vra> F = this.a.t1().F();
            if (!ListUtils.isEmpty(F) && !ListUtils.isEmpty(list)) {
                Iterator<vra> it = F.iterator();
                while (it.hasNext()) {
                    vra next = it.next();
                    int i = 0;
                    while (true) {
                        if (i >= list.size()) {
                            break;
                        } else if (TextUtils.equals(list.get(i), next.T())) {
                            it.remove();
                            if (this.a.t1().O() != null) {
                                this.a.t1().O().setReply_num(this.a.t1().O().getReply_num() - 1);
                            }
                        } else {
                            i++;
                        }
                    }
                }
                this.b.h2(this.a.t1());
            }
        }
    }

    public static void a() {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeV(65536, null) == null) {
            ix5.b().a();
        }
    }

    public static lx5 b(PbModel pbModel, jx9 jx9Var) {
        InterceptResult invokeLL;
        Interceptable interceptable = $ic;
        if (interceptable == null || (invokeLL = interceptable.invokeLL(65537, null, pbModel, jx9Var)) == null) {
            if (pbModel != null && jx9Var != null) {
                lx5 lx5Var = new lx5();
                if (pbModel.t1() != null && pbModel.t1().k() != null) {
                    if (pbModel.t1().k().getDeletedReasonInfo() != null) {
                        lx5Var.p(pbModel.t1().k().getDeletedReasonInfo().is_grays_cale_forum.intValue());
                        lx5Var.o(pbModel.t1().k().getDeletedReasonInfo().is_boomgrow.intValue());
                    }
                    lx5Var.l(pbModel.t1().k().getId());
                    lx5Var.m(pbModel.t1().k().getName());
                    lx5Var.k(pbModel.t1().k().getImage_url());
                    lx5Var.t(pbModel.t1().k().getUser_level());
                }
                if (pbModel.t1() != null && pbModel.t1().n() != null) {
                    lx5Var.n(pbModel.t1().n().has_forum_rule.intValue());
                }
                if (pbModel.t1() != null && pbModel.t1().V() != null) {
                    lx5Var.s(pbModel.t1().V());
                }
                lx5Var.q(new a(pbModel, jx9Var));
                if (pbModel.t1() != null) {
                    AntiData c = pbModel.t1().c();
                    SparseArray<String> sparseArray = new SparseArray<>();
                    if (c != null && c.getDelThreadInfoList() != null) {
                        List<DeleteThreadInfo> delThreadInfoList = c.getDelThreadInfoList();
                        for (int i = 0; i < delThreadInfoList.size(); i++) {
                            if (delThreadInfoList.get(i) != null && !TextUtils.isEmpty(delThreadInfoList.get(i).text_info)) {
                                sparseArray.put(delThreadInfoList.get(i).text_id, delThreadInfoList.get(i).text_info);
                            }
                        }
                    }
                    lx5Var.r(sparseArray);
                }
                return lx5Var;
            }
            return null;
        }
        return (lx5) invokeLL.objValue;
    }

    public static boolean c(es9 es9Var, vra vraVar) {
        InterceptResult invokeLL;
        Interceptable interceptable = $ic;
        if (interceptable == null || (invokeLL = interceptable.invokeLL(65538, null, es9Var, vraVar)) == null) {
            if (es9Var != null && vraVar != null) {
                nx5 nx5Var = new nx5();
                nx5Var.d(vraVar.P() + "");
                if (es9Var.O() != null) {
                    nx5Var.f(es9Var.O().getId());
                }
                nx5Var.e(vraVar.T());
                return ix5.b().c(nx5Var);
            }
            return false;
        }
        return invokeLL.booleanValue;
    }

    public static void d(TbPageContext<BaseFragmentActivity> tbPageContext, PbModel pbModel, jx9 jx9Var) {
        Interceptable interceptable = $ic;
        if ((interceptable == null || interceptable.invokeLLL(65539, null, tbPageContext, pbModel, jx9Var) == null) && tbPageContext != null && pbModel != null && jx9Var != null) {
            ix5.b().e(tbPageContext, jx9Var.G1(), b(pbModel, jx9Var));
            ix5.b().d(1);
        }
    }

    public static boolean e(vra vraVar) {
        InterceptResult invokeL;
        Interceptable interceptable = $ic;
        if (interceptable == null || (invokeL = interceptable.invokeL(InputDeviceCompat.SOURCE_TRACKBALL, null, vraVar)) == null) {
            if (vraVar == null) {
                return false;
            }
            return ix5.b().f(vraVar.T());
        }
        return invokeL.booleanValue;
    }
}
