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
/* loaded from: classes5.dex */
public class r38 {
    public static /* synthetic */ Interceptable $ic;
    public transient /* synthetic */ FieldHolder $fh;

    /* loaded from: classes5.dex */
    public static class a implements yl5 {
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

        @Override // com.baidu.tieba.yl5
        public void a() {
            Interceptable interceptable = $ic;
            if (interceptable == null || interceptable.invokeV(1048576, this) == null) {
                this.b.l2(false);
            }
        }

        @Override // com.baidu.tieba.yl5
        public void b(List<String> list) {
            Interceptable interceptable = $ic;
            if ((interceptable != null && interceptable.invokeL(Constants.METHOD_GET_CONTACTER_INFO_FOR_SESSION, this, list) != null) || this.a.S1() == null) {
                return;
            }
            ArrayList<PostData> H = this.a.S1().H();
            if (!ListUtils.isEmpty(H) && !ListUtils.isEmpty(list)) {
                Iterator<PostData> it = H.iterator();
                while (it.hasNext()) {
                    PostData next = it.next();
                    int i = 0;
                    while (true) {
                        if (i >= list.size()) {
                            break;
                        } else if (TextUtils.equals(list.get(i), next.M())) {
                            it.remove();
                            if (this.a.S1().Q() != null) {
                                this.a.S1().Q().setReply_num(this.a.S1().Q().getReply_num() - 1);
                            }
                        } else {
                            i++;
                        }
                    }
                }
                this.b.T1();
            }
        }
    }

    public static void a() {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeV(65536, null) == null) {
            xl5.b().a();
        }
    }

    public static am5 b(PbModel pbModel, DetailInfoAndReplyFragment detailInfoAndReplyFragment) {
        InterceptResult invokeLL;
        Interceptable interceptable = $ic;
        if (interceptable == null || (invokeLL = interceptable.invokeLL(65537, null, pbModel, detailInfoAndReplyFragment)) == null) {
            if (detailInfoAndReplyFragment != null && pbModel != null) {
                am5 am5Var = new am5();
                if (pbModel.S1() != null && pbModel.S1().l() != null) {
                    if (pbModel.S1().l().getDeletedReasonInfo() != null) {
                        am5Var.p(pbModel.S1().l().getDeletedReasonInfo().is_grays_cale_forum.intValue());
                        am5Var.o(pbModel.S1().l().getDeletedReasonInfo().is_boomgrow.intValue());
                    }
                    am5Var.l(pbModel.S1().l().getId());
                    am5Var.m(pbModel.S1().l().getName());
                    am5Var.k(pbModel.S1().l().getImage_url());
                    am5Var.t(pbModel.S1().l().getUser_level());
                }
                if (pbModel.S1() != null && pbModel.S1().o() != null) {
                    am5Var.n(pbModel.S1().o().has_forum_rule.intValue());
                }
                if (pbModel.S1() != null && pbModel.S1().X() != null) {
                    am5Var.s(pbModel.S1().X());
                }
                am5Var.q(new a(pbModel, detailInfoAndReplyFragment));
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
                    am5Var.r(sparseArray);
                }
                return am5Var;
            }
            return null;
        }
        return (am5) invokeLL.objValue;
    }

    public static boolean c(ox7 ox7Var, PostData postData) {
        InterceptResult invokeLL;
        Interceptable interceptable = $ic;
        if (interceptable == null || (invokeLL = interceptable.invokeLL(65538, null, ox7Var, postData)) == null) {
            if (ox7Var != null && postData != null) {
                cm5 cm5Var = new cm5();
                cm5Var.d(postData.I() + "");
                if (ox7Var.Q() != null) {
                    cm5Var.f(ox7Var.Q().getId());
                }
                cm5Var.e(postData.M());
                return xl5.b().c(cm5Var);
            }
            return false;
        }
        return invokeLL.booleanValue;
    }

    public static void d(TbPageContext<BaseFragmentActivity> tbPageContext, PbModel pbModel, DetailInfoAndReplyFragment detailInfoAndReplyFragment, View view2) {
        Interceptable interceptable = $ic;
        if ((interceptable == null || interceptable.invokeLLLL(65539, null, tbPageContext, pbModel, detailInfoAndReplyFragment, view2) == null) && tbPageContext != null && pbModel != null && detailInfoAndReplyFragment != null && detailInfoAndReplyFragment.getView() != null) {
            xl5.b().e(tbPageContext, (ViewGroup) view2, b(pbModel, detailInfoAndReplyFragment));
            xl5.b().d(2);
        }
    }

    public static boolean e(PostData postData) {
        InterceptResult invokeL;
        Interceptable interceptable = $ic;
        if (interceptable == null || (invokeL = interceptable.invokeL(InputDeviceCompat.SOURCE_TRACKBALL, null, postData)) == null) {
            if (postData == null) {
                return false;
            }
            return xl5.b().f(postData.M());
        }
        return invokeL.booleanValue;
    }
}
