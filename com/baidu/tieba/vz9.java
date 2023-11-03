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
/* loaded from: classes8.dex */
public class vz9 {
    public static /* synthetic */ Interceptable $ic;
    public transient /* synthetic */ FieldHolder $fh;

    /* loaded from: classes8.dex */
    public class a implements ix5 {
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

        @Override // com.baidu.tieba.ix5
        public void a() {
            Interceptable interceptable = $ic;
            if (interceptable == null || interceptable.invokeV(1048576, this) == null) {
                this.b.i3(false);
            }
        }

        @Override // com.baidu.tieba.ix5
        public void b(List<String> list) {
            Interceptable interceptable = $ic;
            if ((interceptable != null && interceptable.invokeL(Constants.METHOD_GET_CONTACTER_INFO_FOR_SESSION, this, list) != null) || this.a.t1() == null) {
                return;
            }
            ArrayList<ura> F = this.a.t1().F();
            if (!ListUtils.isEmpty(F) && !ListUtils.isEmpty(list)) {
                Iterator<ura> it = F.iterator();
                while (it.hasNext()) {
                    ura next = it.next();
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
                this.b.U2();
            }
        }
    }

    public static void a() {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeV(65536, null) == null) {
            hx5.b().a();
        }
    }

    public static kx5 b(PbModel pbModel, DetailInfoAndReplyFragment detailInfoAndReplyFragment) {
        InterceptResult invokeLL;
        Interceptable interceptable = $ic;
        if (interceptable == null || (invokeLL = interceptable.invokeLL(65537, null, pbModel, detailInfoAndReplyFragment)) == null) {
            if (detailInfoAndReplyFragment != null && pbModel != null) {
                kx5 kx5Var = new kx5();
                if (pbModel.t1() != null && pbModel.t1().k() != null) {
                    if (pbModel.t1().k().getDeletedReasonInfo() != null) {
                        kx5Var.p(pbModel.t1().k().getDeletedReasonInfo().is_grays_cale_forum.intValue());
                        kx5Var.o(pbModel.t1().k().getDeletedReasonInfo().is_boomgrow.intValue());
                    }
                    kx5Var.l(pbModel.t1().k().getId());
                    kx5Var.m(pbModel.t1().k().getName());
                    kx5Var.k(pbModel.t1().k().getImage_url());
                    kx5Var.t(pbModel.t1().k().getUser_level());
                }
                if (pbModel.t1() != null && pbModel.t1().n() != null) {
                    kx5Var.n(pbModel.t1().n().has_forum_rule.intValue());
                }
                if (pbModel.t1() != null && pbModel.t1().V() != null) {
                    kx5Var.s(pbModel.t1().V());
                }
                kx5Var.q(new a(pbModel, detailInfoAndReplyFragment));
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
                    kx5Var.r(sparseArray);
                }
                return kx5Var;
            }
            return null;
        }
        return (kx5) invokeLL.objValue;
    }

    public static boolean c(ds9 ds9Var, ura uraVar) {
        InterceptResult invokeLL;
        Interceptable interceptable = $ic;
        if (interceptable == null || (invokeLL = interceptable.invokeLL(65538, null, ds9Var, uraVar)) == null) {
            if (ds9Var != null && uraVar != null) {
                mx5 mx5Var = new mx5();
                mx5Var.d(uraVar.P() + "");
                if (ds9Var.O() != null) {
                    mx5Var.f(ds9Var.O().getId());
                }
                mx5Var.e(uraVar.T());
                return hx5.b().c(mx5Var);
            }
            return false;
        }
        return invokeLL.booleanValue;
    }

    public static void d(TbPageContext<BaseFragmentActivity> tbPageContext, PbModel pbModel, DetailInfoAndReplyFragment detailInfoAndReplyFragment, View view2) {
        Interceptable interceptable = $ic;
        if ((interceptable == null || interceptable.invokeLLLL(65539, null, tbPageContext, pbModel, detailInfoAndReplyFragment, view2) == null) && tbPageContext != null && pbModel != null && detailInfoAndReplyFragment != null && detailInfoAndReplyFragment.getView() != null) {
            hx5.b().e(tbPageContext, (ViewGroup) view2, b(pbModel, detailInfoAndReplyFragment));
            hx5.b().d(2);
        }
    }

    public static boolean e(ura uraVar) {
        InterceptResult invokeL;
        Interceptable interceptable = $ic;
        if (interceptable == null || (invokeL = interceptable.invokeL(InputDeviceCompat.SOURCE_TRACKBALL, null, uraVar)) == null) {
            if (uraVar == null) {
                return false;
            }
            return hx5.b().f(uraVar.T());
        }
        return invokeL.booleanValue;
    }
}
