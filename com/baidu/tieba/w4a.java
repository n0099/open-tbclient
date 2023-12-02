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
public class w4a {
    public static /* synthetic */ Interceptable $ic;
    public transient /* synthetic */ FieldHolder $fh;

    /* loaded from: classes8.dex */
    public class a implements ux5 {
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

        @Override // com.baidu.tieba.ux5
        public void a() {
            Interceptable interceptable = $ic;
            if (interceptable == null || interceptable.invokeV(1048576, this) == null) {
                this.b.u3(false);
            }
        }

        @Override // com.baidu.tieba.ux5
        public void b(List<String> list) {
            Interceptable interceptable = $ic;
            if ((interceptable != null && interceptable.invokeL(Constants.METHOD_GET_CONTACTER_INFO_FOR_SESSION, this, list) != null) || this.a.s1() == null) {
                return;
            }
            ArrayList<mwa> I = this.a.s1().I();
            if (!ListUtils.isEmpty(I) && !ListUtils.isEmpty(list)) {
                Iterator<mwa> it = I.iterator();
                while (it.hasNext()) {
                    mwa next = it.next();
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
                this.b.g3();
            }
        }
    }

    public static void a() {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeV(65536, null) == null) {
            tx5.b().a();
        }
    }

    public static wx5 b(PbModel pbModel, DetailInfoAndReplyFragment detailInfoAndReplyFragment) {
        InterceptResult invokeLL;
        Interceptable interceptable = $ic;
        if (interceptable == null || (invokeLL = interceptable.invokeLL(65537, null, pbModel, detailInfoAndReplyFragment)) == null) {
            if (detailInfoAndReplyFragment != null && pbModel != null) {
                wx5 wx5Var = new wx5();
                if (pbModel.s1() != null && pbModel.s1().n() != null) {
                    if (pbModel.s1().n().getDeletedReasonInfo() != null) {
                        wx5Var.p(pbModel.s1().n().getDeletedReasonInfo().is_grays_cale_forum.intValue());
                        wx5Var.o(pbModel.s1().n().getDeletedReasonInfo().is_boomgrow.intValue());
                    }
                    wx5Var.l(pbModel.s1().n().getId());
                    wx5Var.m(pbModel.s1().n().getName());
                    wx5Var.k(pbModel.s1().n().getImage_url());
                    wx5Var.t(pbModel.s1().n().getUser_level());
                }
                if (pbModel.s1() != null && pbModel.s1().q() != null) {
                    wx5Var.n(pbModel.s1().q().has_forum_rule.intValue());
                }
                if (pbModel.s1() != null && pbModel.s1().Y() != null) {
                    wx5Var.s(pbModel.s1().Y());
                }
                wx5Var.q(new a(pbModel, detailInfoAndReplyFragment));
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
                    wx5Var.r(sparseArray);
                }
                return wx5Var;
            }
            return null;
        }
        return (wx5) invokeLL.objValue;
    }

    public static boolean c(zv9 zv9Var, mwa mwaVar) {
        InterceptResult invokeLL;
        Interceptable interceptable = $ic;
        if (interceptable == null || (invokeLL = interceptable.invokeLL(65538, null, zv9Var, mwaVar)) == null) {
            if (zv9Var != null && mwaVar != null) {
                yx5 yx5Var = new yx5();
                yx5Var.d(mwaVar.Q() + "");
                if (zv9Var.R() != null) {
                    yx5Var.f(zv9Var.R().getId());
                }
                yx5Var.e(mwaVar.U());
                return tx5.b().c(yx5Var);
            }
            return false;
        }
        return invokeLL.booleanValue;
    }

    public static void d(TbPageContext<BaseFragmentActivity> tbPageContext, PbModel pbModel, DetailInfoAndReplyFragment detailInfoAndReplyFragment, View view2) {
        Interceptable interceptable = $ic;
        if ((interceptable == null || interceptable.invokeLLLL(65539, null, tbPageContext, pbModel, detailInfoAndReplyFragment, view2) == null) && tbPageContext != null && pbModel != null && detailInfoAndReplyFragment != null && detailInfoAndReplyFragment.getView() != null) {
            tx5.b().e(tbPageContext, (ViewGroup) view2, b(pbModel, detailInfoAndReplyFragment));
            tx5.b().d(2);
        }
    }

    public static boolean e(mwa mwaVar) {
        InterceptResult invokeL;
        Interceptable interceptable = $ic;
        if (interceptable == null || (invokeL = interceptable.invokeL(InputDeviceCompat.SOURCE_TRACKBALL, null, mwaVar)) == null) {
            if (mwaVar == null) {
                return false;
            }
            return tx5.b().f(mwaVar.U());
        }
        return invokeL.booleanValue;
    }
}
