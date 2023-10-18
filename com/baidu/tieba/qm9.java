package com.baidu.tieba;

import android.text.TextUtils;
import android.util.SparseArray;
import android.view.View;
import android.view.ViewGroup;
import androidx.core.view.InputDeviceCompat;
import com.baidu.android.imsdk.internal.Constants;
import com.baidu.tbadk.TbPageContext;
import com.baidu.tbadk.core.BaseFragmentActivity;
import com.baidu.tbadk.core.data.AntiData;
import com.baidu.tbadk.core.data.DeleteThreadInfo;
import com.baidu.tbadk.core.util.ListUtils;
import com.baidu.tieba.pb.pb.main.PbModel;
import com.baidu.tieba.pb.videopb.fragment.DetailInfoAndReplyFragment;
import com.baidu.titan.sdk.runtime.FieldHolder;
import com.baidu.titan.sdk.runtime.InitContext;
import com.baidu.titan.sdk.runtime.InterceptResult;
import com.baidu.titan.sdk.runtime.Interceptable;
import com.baidu.titan.sdk.runtime.TitanRuntime;
import java.util.ArrayList;
import java.util.Iterator;
import java.util.List;
/* loaded from: classes7.dex */
public class qm9 {
    public static /* synthetic */ Interceptable $ic;
    public transient /* synthetic */ FieldHolder $fh;

    /* loaded from: classes7.dex */
    public class a implements ov5 {
        public static /* synthetic */ Interceptable $ic;
        public transient /* synthetic */ FieldHolder $fh;
        public final /* synthetic */ PbModel a;
        public final /* synthetic */ DetailInfoAndReplyFragment b;

        public a(PbModel pbModel, DetailInfoAndReplyFragment detailInfoAndReplyFragment) {
            Interceptable interceptable = $ic;
            if (interceptable != null) {
                InitContext newInitContext = TitanRuntime.newInitContext();
                newInitContext.initArgs = r2;
                Object[] objArr = {pbModel, detailInfoAndReplyFragment};
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
            this.b = detailInfoAndReplyFragment;
        }

        @Override // com.baidu.tieba.ov5
        public void a() {
            Interceptable interceptable = $ic;
            if (interceptable == null || interceptable.invokeV(1048576, this) == null) {
                this.b.Q2(false);
            }
        }

        @Override // com.baidu.tieba.ov5
        public void b(List<String> list) {
            Interceptable interceptable = $ic;
            if ((interceptable != null && interceptable.invokeL(Constants.METHOD_GET_CONTACTER_INFO_FOR_SESSION, this, list) != null) || this.a.s1() == null) {
                return;
            }
            ArrayList<pea> F = this.a.s1().F();
            if (!ListUtils.isEmpty(F) && !ListUtils.isEmpty(list)) {
                Iterator<pea> it = F.iterator();
                while (it.hasNext()) {
                    pea next = it.next();
                    int i = 0;
                    while (true) {
                        if (i >= list.size()) {
                            break;
                        } else if (TextUtils.equals(list.get(i), next.U())) {
                            it.remove();
                            if (this.a.s1().O() != null) {
                                this.a.s1().O().setReply_num(this.a.s1().O().getReply_num() - 1);
                            }
                        } else {
                            i++;
                        }
                    }
                }
                this.b.C2();
            }
        }
    }

    public static void a() {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeV(65536, null) == null) {
            nv5.b().a();
        }
    }

    public static qv5 b(PbModel pbModel, DetailInfoAndReplyFragment detailInfoAndReplyFragment) {
        InterceptResult invokeLL;
        Interceptable interceptable = $ic;
        if (interceptable == null || (invokeLL = interceptable.invokeLL(65537, null, pbModel, detailInfoAndReplyFragment)) == null) {
            if (detailInfoAndReplyFragment != null && pbModel != null) {
                qv5 qv5Var = new qv5();
                if (pbModel.s1() != null && pbModel.s1().k() != null) {
                    if (pbModel.s1().k().getDeletedReasonInfo() != null) {
                        qv5Var.p(pbModel.s1().k().getDeletedReasonInfo().is_grays_cale_forum.intValue());
                        qv5Var.o(pbModel.s1().k().getDeletedReasonInfo().is_boomgrow.intValue());
                    }
                    qv5Var.l(pbModel.s1().k().getId());
                    qv5Var.m(pbModel.s1().k().getName());
                    qv5Var.k(pbModel.s1().k().getImage_url());
                    qv5Var.t(pbModel.s1().k().getUser_level());
                }
                if (pbModel.s1() != null && pbModel.s1().n() != null) {
                    qv5Var.n(pbModel.s1().n().has_forum_rule.intValue());
                }
                if (pbModel.s1() != null && pbModel.s1().V() != null) {
                    qv5Var.s(pbModel.s1().V());
                }
                qv5Var.q(new a(pbModel, detailInfoAndReplyFragment));
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
                    qv5Var.r(sparseArray);
                }
                return qv5Var;
            }
            return null;
        }
        return (qv5) invokeLL.objValue;
    }

    public static boolean c(ye9 ye9Var, pea peaVar) {
        InterceptResult invokeLL;
        Interceptable interceptable = $ic;
        if (interceptable == null || (invokeLL = interceptable.invokeLL(65538, null, ye9Var, peaVar)) == null) {
            if (ye9Var != null && peaVar != null) {
                sv5 sv5Var = new sv5();
                sv5Var.d(peaVar.Q() + "");
                if (ye9Var.O() != null) {
                    sv5Var.f(ye9Var.O().getId());
                }
                sv5Var.e(peaVar.U());
                return nv5.b().c(sv5Var);
            }
            return false;
        }
        return invokeLL.booleanValue;
    }

    public static void d(TbPageContext<BaseFragmentActivity> tbPageContext, PbModel pbModel, DetailInfoAndReplyFragment detailInfoAndReplyFragment, View view2) {
        Interceptable interceptable = $ic;
        if ((interceptable == null || interceptable.invokeLLLL(65539, null, tbPageContext, pbModel, detailInfoAndReplyFragment, view2) == null) && tbPageContext != null && pbModel != null && detailInfoAndReplyFragment != null && detailInfoAndReplyFragment.getView() != null) {
            nv5.b().e(tbPageContext, (ViewGroup) view2, b(pbModel, detailInfoAndReplyFragment));
            nv5.b().d(2);
        }
    }

    public static boolean e(pea peaVar) {
        InterceptResult invokeL;
        Interceptable interceptable = $ic;
        if (interceptable == null || (invokeL = interceptable.invokeL(InputDeviceCompat.SOURCE_TRACKBALL, null, peaVar)) == null) {
            if (peaVar == null) {
                return false;
            }
            return nv5.b().f(peaVar.U());
        }
        return invokeL.booleanValue;
    }
}
