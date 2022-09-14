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
import com.baidu.tieba.tbadkCore.data.PostData;
import com.baidu.titan.sdk.runtime.FieldHolder;
import com.baidu.titan.sdk.runtime.InitContext;
import com.baidu.titan.sdk.runtime.InterceptResult;
import com.baidu.titan.sdk.runtime.Interceptable;
import com.baidu.titan.sdk.runtime.TitanRuntime;
import java.util.ArrayList;
import java.util.Iterator;
import java.util.List;
/* loaded from: classes6.dex */
public class x08 {
    public static /* synthetic */ Interceptable $ic;
    public transient /* synthetic */ FieldHolder $fh;

    /* loaded from: classes6.dex */
    public static class a implements wj5 {
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

        @Override // com.baidu.tieba.wj5
        public void a() {
            Interceptable interceptable = $ic;
            if (interceptable == null || interceptable.invokeV(1048576, this) == null) {
                this.b.l2(false);
            }
        }

        @Override // com.baidu.tieba.wj5
        public void b(List<String> list) {
            Interceptable interceptable = $ic;
            if (!(interceptable == null || interceptable.invokeL(Constants.METHOD_GET_CONTACTER_INFO_FOR_SESSION, this, list) == null) || this.a.S1() == null) {
                return;
            }
            ArrayList<PostData> F = this.a.S1().F();
            if (ListUtils.isEmpty(F) || ListUtils.isEmpty(list)) {
                return;
            }
            Iterator<PostData> it = F.iterator();
            while (it.hasNext()) {
                PostData next = it.next();
                int i = 0;
                while (true) {
                    if (i >= list.size()) {
                        break;
                    } else if (TextUtils.equals(list.get(i), next.L())) {
                        it.remove();
                        if (this.a.S1().O() != null) {
                            this.a.S1().O().setReply_num(this.a.S1().O().getReply_num() - 1);
                        }
                    } else {
                        i++;
                    }
                }
            }
            this.b.T1();
        }
    }

    public static void a() {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeV(65536, null) == null) {
            vj5.b().a();
        }
    }

    public static yj5 b(PbModel pbModel, DetailInfoAndReplyFragment detailInfoAndReplyFragment) {
        InterceptResult invokeLL;
        Interceptable interceptable = $ic;
        if (interceptable == null || (invokeLL = interceptable.invokeLL(65537, null, pbModel, detailInfoAndReplyFragment)) == null) {
            if (detailInfoAndReplyFragment == null || pbModel == null) {
                return null;
            }
            yj5 yj5Var = new yj5();
            if (pbModel.S1() != null && pbModel.S1().l() != null) {
                if (pbModel.S1().l().getDeletedReasonInfo() != null) {
                    yj5Var.p(pbModel.S1().l().getDeletedReasonInfo().is_grays_cale_forum.intValue());
                    yj5Var.o(pbModel.S1().l().getDeletedReasonInfo().is_boomgrow.intValue());
                }
                yj5Var.l(pbModel.S1().l().getId());
                yj5Var.m(pbModel.S1().l().getName());
                yj5Var.k(pbModel.S1().l().getImage_url());
                yj5Var.t(pbModel.S1().l().getUser_level());
            }
            if (pbModel.S1() != null && pbModel.S1().o() != null) {
                yj5Var.n(pbModel.S1().o().has_forum_rule.intValue());
            }
            if (pbModel.S1() != null && pbModel.S1().V() != null) {
                yj5Var.s(pbModel.S1().V());
            }
            yj5Var.q(new a(pbModel, detailInfoAndReplyFragment));
            if (pbModel.S1() != null) {
                AntiData d = pbModel.S1().d();
                SparseArray<String> sparseArray = new SparseArray<>();
                if (d != null && d.getDelThreadInfoList() != null) {
                    List<DeleteThreadInfo> delThreadInfoList = d.getDelThreadInfoList();
                    for (int i = 0; i < delThreadInfoList.size(); i++) {
                        if (delThreadInfoList.get(i) != null && !TextUtils.isEmpty(delThreadInfoList.get(i).text_info)) {
                            sparseArray.put(delThreadInfoList.get(i).text_id, delThreadInfoList.get(i).text_info);
                        }
                    }
                }
                yj5Var.r(sparseArray);
            }
            return yj5Var;
        }
        return (yj5) invokeLL.objValue;
    }

    public static boolean c(vu7 vu7Var, PostData postData) {
        InterceptResult invokeLL;
        Interceptable interceptable = $ic;
        if (interceptable == null || (invokeLL = interceptable.invokeLL(65538, null, vu7Var, postData)) == null) {
            if (vu7Var == null || postData == null) {
                return false;
            }
            ak5 ak5Var = new ak5();
            ak5Var.d(postData.H() + "");
            if (vu7Var.O() != null) {
                ak5Var.f(vu7Var.O().getId());
            }
            ak5Var.e(postData.L());
            return vj5.b().c(ak5Var);
        }
        return invokeLL.booleanValue;
    }

    public static void d(TbPageContext<BaseFragmentActivity> tbPageContext, PbModel pbModel, DetailInfoAndReplyFragment detailInfoAndReplyFragment, View view2) {
        Interceptable interceptable = $ic;
        if (!(interceptable == null || interceptable.invokeLLLL(65539, null, tbPageContext, pbModel, detailInfoAndReplyFragment, view2) == null) || tbPageContext == null || pbModel == null || detailInfoAndReplyFragment == null || detailInfoAndReplyFragment.getView() == null) {
            return;
        }
        vj5.b().e(tbPageContext, (ViewGroup) view2, b(pbModel, detailInfoAndReplyFragment));
        vj5.b().d(2);
    }

    public static boolean e(PostData postData) {
        InterceptResult invokeL;
        Interceptable interceptable = $ic;
        if (interceptable == null || (invokeL = interceptable.invokeL(InputDeviceCompat.SOURCE_TRACKBALL, null, postData)) == null) {
            if (postData == null) {
                return false;
            }
            return vj5.b().f(postData.L());
        }
        return invokeL.booleanValue;
    }
}
