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
/* loaded from: classes5.dex */
public class p19 {
    public static /* synthetic */ Interceptable $ic;
    public transient /* synthetic */ FieldHolder $fh;

    /* loaded from: classes5.dex */
    public static class a implements dv5 {
        public static /* synthetic */ Interceptable $ic;
        public transient /* synthetic */ FieldHolder $fh;
        public final /* synthetic */ PbModel a;
        public final /* synthetic */ tz8 b;

        public a(PbModel pbModel, tz8 tz8Var) {
            Interceptable interceptable = $ic;
            if (interceptable != null) {
                InitContext newInitContext = TitanRuntime.newInitContext();
                newInitContext.initArgs = r2;
                Object[] objArr = {pbModel, tz8Var};
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
            this.b = tz8Var;
        }

        @Override // com.baidu.tieba.dv5
        public void a() {
            Interceptable interceptable = $ic;
            if (interceptable == null || interceptable.invokeV(1048576, this) == null) {
                this.b.o4(false);
            }
        }

        @Override // com.baidu.tieba.dv5
        public void b(List<String> list) {
            Interceptable interceptable = $ic;
            if ((interceptable != null && interceptable.invokeL(Constants.METHOD_GET_CONTACTER_INFO_FOR_SESSION, this, list) != null) || this.a.z1() == null) {
                return;
            }
            ArrayList<pp9> F = this.a.z1().F();
            if (!ListUtils.isEmpty(F) && !ListUtils.isEmpty(list)) {
                Iterator<pp9> it = F.iterator();
                while (it.hasNext()) {
                    pp9 next = it.next();
                    int i = 0;
                    while (true) {
                        if (i >= list.size()) {
                            break;
                        } else if (TextUtils.equals(list.get(i), next.N())) {
                            it.remove();
                            if (this.a.z1().M() != null) {
                                this.a.z1().M().setReply_num(this.a.z1().M().getReply_num() - 1);
                            }
                        } else {
                            i++;
                        }
                    }
                }
                this.b.J1(this.a.z1());
            }
        }
    }

    public static void a() {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeV(65536, null) == null) {
            cv5.b().a();
        }
    }

    public static fv5 b(PbModel pbModel, tz8 tz8Var) {
        InterceptResult invokeLL;
        Interceptable interceptable = $ic;
        if (interceptable == null || (invokeLL = interceptable.invokeLL(65537, null, pbModel, tz8Var)) == null) {
            if (pbModel != null && tz8Var != null) {
                fv5 fv5Var = new fv5();
                if (pbModel.z1() != null && pbModel.z1().k() != null) {
                    if (pbModel.z1().k().getDeletedReasonInfo() != null) {
                        fv5Var.p(pbModel.z1().k().getDeletedReasonInfo().is_grays_cale_forum.intValue());
                        fv5Var.o(pbModel.z1().k().getDeletedReasonInfo().is_boomgrow.intValue());
                    }
                    fv5Var.l(pbModel.z1().k().getId());
                    fv5Var.m(pbModel.z1().k().getName());
                    fv5Var.k(pbModel.z1().k().getImage_url());
                    fv5Var.t(pbModel.z1().k().getUser_level());
                }
                if (pbModel.z1() != null && pbModel.z1().n() != null) {
                    fv5Var.n(pbModel.z1().n().has_forum_rule.intValue());
                }
                if (pbModel.z1() != null && pbModel.z1().T() != null) {
                    fv5Var.s(pbModel.z1().T());
                }
                fv5Var.q(new a(pbModel, tz8Var));
                if (pbModel.z1() != null) {
                    AntiData c = pbModel.z1().c();
                    SparseArray<String> sparseArray = new SparseArray<>();
                    if (c != null && c.getDelThreadInfoList() != null) {
                        List<DeleteThreadInfo> delThreadInfoList = c.getDelThreadInfoList();
                        for (int i = 0; i < delThreadInfoList.size(); i++) {
                            if (delThreadInfoList.get(i) != null && !TextUtils.isEmpty(delThreadInfoList.get(i).text_info)) {
                                sparseArray.put(delThreadInfoList.get(i).text_id, delThreadInfoList.get(i).text_info);
                            }
                        }
                    }
                    fv5Var.r(sparseArray);
                }
                return fv5Var;
            }
            return null;
        }
        return (fv5) invokeLL.objValue;
    }

    public static boolean c(qv8 qv8Var, pp9 pp9Var) {
        InterceptResult invokeLL;
        Interceptable interceptable = $ic;
        if (interceptable == null || (invokeLL = interceptable.invokeLL(65538, null, qv8Var, pp9Var)) == null) {
            if (qv8Var != null && pp9Var != null) {
                hv5 hv5Var = new hv5();
                hv5Var.d(pp9Var.J() + "");
                if (qv8Var.M() != null) {
                    hv5Var.f(qv8Var.M().getId());
                }
                hv5Var.e(pp9Var.N());
                return cv5.b().c(hv5Var);
            }
            return false;
        }
        return invokeLL.booleanValue;
    }

    public static void d(TbPageContext<BaseFragmentActivity> tbPageContext, PbModel pbModel, tz8 tz8Var) {
        Interceptable interceptable = $ic;
        if ((interceptable == null || interceptable.invokeLLL(65539, null, tbPageContext, pbModel, tz8Var) == null) && tbPageContext != null && pbModel != null && tz8Var != null) {
            cv5.b().e(tbPageContext, tz8Var.o1(), b(pbModel, tz8Var));
            cv5.b().d(1);
        }
    }

    public static boolean e(pp9 pp9Var) {
        InterceptResult invokeL;
        Interceptable interceptable = $ic;
        if (interceptable == null || (invokeL = interceptable.invokeL(InputDeviceCompat.SOURCE_TRACKBALL, null, pp9Var)) == null) {
            if (pp9Var == null) {
                return false;
            }
            return cv5.b().f(pp9Var.N());
        }
        return invokeL.booleanValue;
    }
}
