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
/* loaded from: classes6.dex */
public class io9 {
    public static /* synthetic */ Interceptable $ic;
    public transient /* synthetic */ FieldHolder $fh;

    /* loaded from: classes6.dex */
    public static class a implements i06 {
        public static /* synthetic */ Interceptable $ic;
        public transient /* synthetic */ FieldHolder $fh;
        public final /* synthetic */ PbModel a;
        public final /* synthetic */ hm9 b;

        public a(PbModel pbModel, hm9 hm9Var) {
            Interceptable interceptable = $ic;
            if (interceptable != null) {
                InitContext newInitContext = TitanRuntime.newInitContext();
                newInitContext.initArgs = r2;
                Object[] objArr = {pbModel, hm9Var};
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
            this.b = hm9Var;
        }

        @Override // com.baidu.tieba.i06
        public void a() {
            Interceptable interceptable = $ic;
            if (interceptable == null || interceptable.invokeV(1048576, this) == null) {
                this.b.S4(false);
            }
        }

        @Override // com.baidu.tieba.i06
        public void b(List<String> list) {
            Interceptable interceptable = $ic;
            if ((interceptable != null && interceptable.invokeL(Constants.METHOD_GET_CONTACTER_INFO_FOR_SESSION, this, list) != null) || this.a.s1() == null) {
                return;
            }
            ArrayList<zfa> F = this.a.s1().F();
            if (!ListUtils.isEmpty(F) && !ListUtils.isEmpty(list)) {
                Iterator<zfa> it = F.iterator();
                while (it.hasNext()) {
                    zfa next = it.next();
                    int i = 0;
                    while (true) {
                        if (i >= list.size()) {
                            break;
                        } else if (TextUtils.equals(list.get(i), next.S())) {
                            it.remove();
                            if (this.a.s1().O() != null) {
                                this.a.s1().O().setReply_num(this.a.s1().O().getReply_num() - 1);
                            }
                        } else {
                            i++;
                        }
                    }
                }
                this.b.d2(this.a.s1());
            }
        }
    }

    public static void a() {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeV(65536, null) == null) {
            h06.b().a();
        }
    }

    public static k06 b(PbModel pbModel, hm9 hm9Var) {
        InterceptResult invokeLL;
        Interceptable interceptable = $ic;
        if (interceptable == null || (invokeLL = interceptable.invokeLL(65537, null, pbModel, hm9Var)) == null) {
            if (pbModel != null && hm9Var != null) {
                k06 k06Var = new k06();
                if (pbModel.s1() != null && pbModel.s1().k() != null) {
                    if (pbModel.s1().k().getDeletedReasonInfo() != null) {
                        k06Var.p(pbModel.s1().k().getDeletedReasonInfo().is_grays_cale_forum.intValue());
                        k06Var.o(pbModel.s1().k().getDeletedReasonInfo().is_boomgrow.intValue());
                    }
                    k06Var.l(pbModel.s1().k().getId());
                    k06Var.m(pbModel.s1().k().getName());
                    k06Var.k(pbModel.s1().k().getImage_url());
                    k06Var.t(pbModel.s1().k().getUser_level());
                }
                if (pbModel.s1() != null && pbModel.s1().n() != null) {
                    k06Var.n(pbModel.s1().n().has_forum_rule.intValue());
                }
                if (pbModel.s1() != null && pbModel.s1().V() != null) {
                    k06Var.s(pbModel.s1().V());
                }
                k06Var.q(new a(pbModel, hm9Var));
                if (pbModel.s1() != null) {
                    AntiData c = pbModel.s1().c();
                    SparseArray<String> sparseArray = new SparseArray<>();
                    if (c != null && c.getDelThreadInfoList() != null) {
                        List<DeleteThreadInfo> delThreadInfoList = c.getDelThreadInfoList();
                        for (int i = 0; i < delThreadInfoList.size(); i++) {
                            if (delThreadInfoList.get(i) != null && !TextUtils.isEmpty(delThreadInfoList.get(i).text_info)) {
                                sparseArray.put(delThreadInfoList.get(i).text_id, delThreadInfoList.get(i).text_info);
                            }
                        }
                    }
                    k06Var.r(sparseArray);
                }
                return k06Var;
            }
            return null;
        }
        return (k06) invokeLL.objValue;
    }

    public static boolean c(yh9 yh9Var, zfa zfaVar) {
        InterceptResult invokeLL;
        Interceptable interceptable = $ic;
        if (interceptable == null || (invokeLL = interceptable.invokeLL(65538, null, yh9Var, zfaVar)) == null) {
            if (yh9Var != null && zfaVar != null) {
                m06 m06Var = new m06();
                m06Var.d(zfaVar.O() + "");
                if (yh9Var.O() != null) {
                    m06Var.f(yh9Var.O().getId());
                }
                m06Var.e(zfaVar.S());
                return h06.b().c(m06Var);
            }
            return false;
        }
        return invokeLL.booleanValue;
    }

    public static void d(TbPageContext<BaseFragmentActivity> tbPageContext, PbModel pbModel, hm9 hm9Var) {
        Interceptable interceptable = $ic;
        if ((interceptable == null || interceptable.invokeLLL(65539, null, tbPageContext, pbModel, hm9Var) == null) && tbPageContext != null && pbModel != null && hm9Var != null) {
            h06.b().e(tbPageContext, hm9Var.E1(), b(pbModel, hm9Var));
            h06.b().d(1);
        }
    }

    public static boolean e(zfa zfaVar) {
        InterceptResult invokeL;
        Interceptable interceptable = $ic;
        if (interceptable == null || (invokeL = interceptable.invokeL(InputDeviceCompat.SOURCE_TRACKBALL, null, zfaVar)) == null) {
            if (zfaVar == null) {
                return false;
            }
            return h06.b().f(zfaVar.S());
        }
        return invokeL.booleanValue;
    }
}
