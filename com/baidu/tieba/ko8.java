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
public class ko8 {
    public static /* synthetic */ Interceptable $ic;
    public transient /* synthetic */ FieldHolder $fh;

    /* loaded from: classes5.dex */
    public static class a implements ws5 {
        public static /* synthetic */ Interceptable $ic;
        public transient /* synthetic */ FieldHolder $fh;
        public final /* synthetic */ PbModel a;
        public final /* synthetic */ om8 b;

        public a(PbModel pbModel, om8 om8Var) {
            Interceptable interceptable = $ic;
            if (interceptable != null) {
                InitContext newInitContext = TitanRuntime.newInitContext();
                newInitContext.initArgs = r2;
                Object[] objArr = {pbModel, om8Var};
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
            this.b = om8Var;
        }

        @Override // com.baidu.tieba.ws5
        public void a() {
            Interceptable interceptable = $ic;
            if (interceptable == null || interceptable.invokeV(1048576, this) == null) {
                this.b.z4(false);
            }
        }

        @Override // com.baidu.tieba.ws5
        public void b(List<String> list) {
            Interceptable interceptable = $ic;
            if ((interceptable != null && interceptable.invokeL(Constants.METHOD_GET_CONTACTER_INFO_FOR_SESSION, this, list) != null) || this.a.w1() == null) {
                return;
            }
            ArrayList<bc9> H = this.a.w1().H();
            if (!ListUtils.isEmpty(H) && !ListUtils.isEmpty(list)) {
                Iterator<bc9> it = H.iterator();
                while (it.hasNext()) {
                    bc9 next = it.next();
                    int i = 0;
                    while (true) {
                        if (i >= list.size()) {
                            break;
                        } else if (TextUtils.equals(list.get(i), next.O())) {
                            it.remove();
                            if (this.a.w1().Q() != null) {
                                this.a.w1().Q().setReply_num(this.a.w1().Q().getReply_num() - 1);
                            }
                        } else {
                            i++;
                        }
                    }
                }
                this.b.N1(this.a.w1());
            }
        }
    }

    public static void a() {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeV(65536, null) == null) {
            vs5.b().a();
        }
    }

    public static ys5 b(PbModel pbModel, om8 om8Var) {
        InterceptResult invokeLL;
        Interceptable interceptable = $ic;
        if (interceptable == null || (invokeLL = interceptable.invokeLL(65537, null, pbModel, om8Var)) == null) {
            if (pbModel != null && om8Var != null) {
                ys5 ys5Var = new ys5();
                if (pbModel.w1() != null && pbModel.w1().l() != null) {
                    if (pbModel.w1().l().getDeletedReasonInfo() != null) {
                        ys5Var.p(pbModel.w1().l().getDeletedReasonInfo().is_grays_cale_forum.intValue());
                        ys5Var.o(pbModel.w1().l().getDeletedReasonInfo().is_boomgrow.intValue());
                    }
                    ys5Var.l(pbModel.w1().l().getId());
                    ys5Var.m(pbModel.w1().l().getName());
                    ys5Var.k(pbModel.w1().l().getImage_url());
                    ys5Var.t(pbModel.w1().l().getUser_level());
                }
                if (pbModel.w1() != null && pbModel.w1().o() != null) {
                    ys5Var.n(pbModel.w1().o().has_forum_rule.intValue());
                }
                if (pbModel.w1() != null && pbModel.w1().X() != null) {
                    ys5Var.s(pbModel.w1().X());
                }
                ys5Var.q(new a(pbModel, om8Var));
                if (pbModel.w1() != null) {
                    AntiData d = pbModel.w1().d();
                    SparseArray<String> sparseArray = new SparseArray<>();
                    if (d != null && d.getDelThreadInfoList() != null) {
                        List<DeleteThreadInfo> delThreadInfoList = d.getDelThreadInfoList();
                        for (int i = 0; i < delThreadInfoList.size(); i++) {
                            if (delThreadInfoList.get(i) != null && !TextUtils.isEmpty(delThreadInfoList.get(i).text_info)) {
                                sparseArray.put(delThreadInfoList.get(i).text_id, delThreadInfoList.get(i).text_info);
                            }
                        }
                    }
                    ys5Var.r(sparseArray);
                }
                return ys5Var;
            }
            return null;
        }
        return (ys5) invokeLL.objValue;
    }

    public static boolean c(ki8 ki8Var, bc9 bc9Var) {
        InterceptResult invokeLL;
        Interceptable interceptable = $ic;
        if (interceptable == null || (invokeLL = interceptable.invokeLL(65538, null, ki8Var, bc9Var)) == null) {
            if (ki8Var != null && bc9Var != null) {
                at5 at5Var = new at5();
                at5Var.d(bc9Var.K() + "");
                if (ki8Var.Q() != null) {
                    at5Var.f(ki8Var.Q().getId());
                }
                at5Var.e(bc9Var.O());
                return vs5.b().c(at5Var);
            }
            return false;
        }
        return invokeLL.booleanValue;
    }

    public static void d(TbPageContext<BaseFragmentActivity> tbPageContext, PbModel pbModel, om8 om8Var) {
        Interceptable interceptable = $ic;
        if ((interceptable == null || interceptable.invokeLLL(65539, null, tbPageContext, pbModel, om8Var) == null) && tbPageContext != null && pbModel != null && om8Var != null) {
            vs5.b().e(tbPageContext, om8Var.t1(), b(pbModel, om8Var));
            vs5.b().d(1);
        }
    }

    public static boolean e(bc9 bc9Var) {
        InterceptResult invokeL;
        Interceptable interceptable = $ic;
        if (interceptable == null || (invokeL = interceptable.invokeL(InputDeviceCompat.SOURCE_TRACKBALL, null, bc9Var)) == null) {
            if (bc9Var == null) {
                return false;
            }
            return vs5.b().f(bc9Var.O());
        }
        return invokeL.booleanValue;
    }
}
