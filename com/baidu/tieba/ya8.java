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
import com.baidu.tieba.tbadkCore.data.PostData;
import com.baidu.titan.sdk.runtime.FieldHolder;
import com.baidu.titan.sdk.runtime.InitContext;
import com.baidu.titan.sdk.runtime.InterceptResult;
import com.baidu.titan.sdk.runtime.Interceptable;
import com.baidu.titan.sdk.runtime.TitanRuntime;
import java.util.ArrayList;
import java.util.Iterator;
import java.util.List;
/* loaded from: classes7.dex */
public class ya8 {
    public static /* synthetic */ Interceptable $ic;
    public transient /* synthetic */ FieldHolder $fh;

    /* loaded from: classes7.dex */
    public static class a implements on5 {
        public static /* synthetic */ Interceptable $ic;
        public transient /* synthetic */ FieldHolder $fh;
        public final /* synthetic */ PbModel a;
        public final /* synthetic */ c98 b;

        public a(PbModel pbModel, c98 c98Var) {
            Interceptable interceptable = $ic;
            if (interceptable != null) {
                InitContext newInitContext = TitanRuntime.newInitContext();
                newInitContext.initArgs = r2;
                Object[] objArr = {pbModel, c98Var};
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
            this.b = c98Var;
        }

        @Override // com.baidu.tieba.on5
        public void a() {
            Interceptable interceptable = $ic;
            if (interceptable == null || interceptable.invokeV(1048576, this) == null) {
                this.b.A4(false);
            }
        }

        @Override // com.baidu.tieba.on5
        public void b(List<String> list) {
            Interceptable interceptable = $ic;
            if ((interceptable != null && interceptable.invokeL(Constants.METHOD_GET_CONTACTER_INFO_FOR_SESSION, this, list) != null) || this.a.l1() == null) {
                return;
            }
            ArrayList<PostData> H = this.a.l1().H();
            if (!ListUtils.isEmpty(H) && !ListUtils.isEmpty(list)) {
                Iterator<PostData> it = H.iterator();
                while (it.hasNext()) {
                    PostData next = it.next();
                    int i = 0;
                    while (true) {
                        if (i >= list.size()) {
                            break;
                        } else if (TextUtils.equals(list.get(i), next.O())) {
                            it.remove();
                            if (this.a.l1().Q() != null) {
                                this.a.l1().Q().setReply_num(this.a.l1().Q().getReply_num() - 1);
                            }
                        } else {
                            i++;
                        }
                    }
                }
                this.b.N1(this.a.l1());
            }
        }
    }

    public static void a() {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeV(65536, null) == null) {
            nn5.b().a();
        }
    }

    public static qn5 b(PbModel pbModel, c98 c98Var) {
        InterceptResult invokeLL;
        Interceptable interceptable = $ic;
        if (interceptable == null || (invokeLL = interceptable.invokeLL(65537, null, pbModel, c98Var)) == null) {
            if (pbModel != null && c98Var != null) {
                qn5 qn5Var = new qn5();
                if (pbModel.l1() != null && pbModel.l1().l() != null) {
                    if (pbModel.l1().l().getDeletedReasonInfo() != null) {
                        qn5Var.p(pbModel.l1().l().getDeletedReasonInfo().is_grays_cale_forum.intValue());
                        qn5Var.o(pbModel.l1().l().getDeletedReasonInfo().is_boomgrow.intValue());
                    }
                    qn5Var.l(pbModel.l1().l().getId());
                    qn5Var.m(pbModel.l1().l().getName());
                    qn5Var.k(pbModel.l1().l().getImage_url());
                    qn5Var.t(pbModel.l1().l().getUser_level());
                }
                if (pbModel.l1() != null && pbModel.l1().o() != null) {
                    qn5Var.n(pbModel.l1().o().has_forum_rule.intValue());
                }
                if (pbModel.l1() != null && pbModel.l1().X() != null) {
                    qn5Var.s(pbModel.l1().X());
                }
                qn5Var.q(new a(pbModel, c98Var));
                if (pbModel.l1() != null) {
                    AntiData d = pbModel.l1().d();
                    SparseArray<String> sparseArray = new SparseArray<>();
                    if (d != null && d.getDelThreadInfoList() != null) {
                        List<DeleteThreadInfo> delThreadInfoList = d.getDelThreadInfoList();
                        for (int i = 0; i < delThreadInfoList.size(); i++) {
                            if (delThreadInfoList.get(i) != null && !TextUtils.isEmpty(delThreadInfoList.get(i).text_info)) {
                                sparseArray.put(delThreadInfoList.get(i).text_id, delThreadInfoList.get(i).text_info);
                            }
                        }
                    }
                    qn5Var.r(sparseArray);
                }
                return qn5Var;
            }
            return null;
        }
        return (qn5) invokeLL.objValue;
    }

    public static boolean c(y48 y48Var, PostData postData) {
        InterceptResult invokeLL;
        Interceptable interceptable = $ic;
        if (interceptable == null || (invokeLL = interceptable.invokeLL(65538, null, y48Var, postData)) == null) {
            if (y48Var != null && postData != null) {
                sn5 sn5Var = new sn5();
                sn5Var.d(postData.K() + "");
                if (y48Var.Q() != null) {
                    sn5Var.f(y48Var.Q().getId());
                }
                sn5Var.e(postData.O());
                return nn5.b().c(sn5Var);
            }
            return false;
        }
        return invokeLL.booleanValue;
    }

    public static void d(TbPageContext<BaseFragmentActivity> tbPageContext, PbModel pbModel, c98 c98Var) {
        Interceptable interceptable = $ic;
        if ((interceptable == null || interceptable.invokeLLL(65539, null, tbPageContext, pbModel, c98Var) == null) && tbPageContext != null && pbModel != null && c98Var != null) {
            nn5.b().e(tbPageContext, c98Var.t1(), b(pbModel, c98Var));
            nn5.b().d(1);
        }
    }

    public static boolean e(PostData postData) {
        InterceptResult invokeL;
        Interceptable interceptable = $ic;
        if (interceptable == null || (invokeL = interceptable.invokeL(InputDeviceCompat.SOURCE_TRACKBALL, null, postData)) == null) {
            if (postData == null) {
                return false;
            }
            return nn5.b().f(postData.O());
        }
        return invokeL.booleanValue;
    }
}
