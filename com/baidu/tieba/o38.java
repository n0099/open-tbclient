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
/* loaded from: classes5.dex */
public class o38 {
    public static /* synthetic */ Interceptable $ic;
    public transient /* synthetic */ FieldHolder $fh;

    /* loaded from: classes5.dex */
    public static class a implements zl5 {
        public static /* synthetic */ Interceptable $ic;
        public transient /* synthetic */ FieldHolder $fh;
        public final /* synthetic */ PbModel a;
        public final /* synthetic */ t18 b;

        public a(PbModel pbModel, t18 t18Var) {
            Interceptable interceptable = $ic;
            if (interceptable != null) {
                InitContext newInitContext = TitanRuntime.newInitContext();
                newInitContext.initArgs = r2;
                Object[] objArr = {pbModel, t18Var};
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
            this.b = t18Var;
        }

        @Override // com.baidu.tieba.zl5
        public void a() {
            Interceptable interceptable = $ic;
            if (interceptable == null || interceptable.invokeV(1048576, this) == null) {
                this.b.r4(false);
            }
        }

        @Override // com.baidu.tieba.zl5
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
                this.b.G1(this.a.S1());
            }
        }
    }

    public static void a() {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeV(65536, null) == null) {
            yl5.b().a();
        }
    }

    public static bm5 b(PbModel pbModel, t18 t18Var) {
        InterceptResult invokeLL;
        Interceptable interceptable = $ic;
        if (interceptable == null || (invokeLL = interceptable.invokeLL(65537, null, pbModel, t18Var)) == null) {
            if (pbModel != null && t18Var != null) {
                bm5 bm5Var = new bm5();
                if (pbModel.S1() != null && pbModel.S1().l() != null) {
                    if (pbModel.S1().l().getDeletedReasonInfo() != null) {
                        bm5Var.p(pbModel.S1().l().getDeletedReasonInfo().is_grays_cale_forum.intValue());
                        bm5Var.o(pbModel.S1().l().getDeletedReasonInfo().is_boomgrow.intValue());
                    }
                    bm5Var.l(pbModel.S1().l().getId());
                    bm5Var.m(pbModel.S1().l().getName());
                    bm5Var.k(pbModel.S1().l().getImage_url());
                    bm5Var.t(pbModel.S1().l().getUser_level());
                }
                if (pbModel.S1() != null && pbModel.S1().o() != null) {
                    bm5Var.n(pbModel.S1().o().has_forum_rule.intValue());
                }
                if (pbModel.S1() != null && pbModel.S1().X() != null) {
                    bm5Var.s(pbModel.S1().X());
                }
                bm5Var.q(new a(pbModel, t18Var));
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
                    bm5Var.r(sparseArray);
                }
                return bm5Var;
            }
            return null;
        }
        return (bm5) invokeLL.objValue;
    }

    public static boolean c(px7 px7Var, PostData postData) {
        InterceptResult invokeLL;
        Interceptable interceptable = $ic;
        if (interceptable == null || (invokeLL = interceptable.invokeLL(65538, null, px7Var, postData)) == null) {
            if (px7Var != null && postData != null) {
                dm5 dm5Var = new dm5();
                dm5Var.d(postData.I() + "");
                if (px7Var.Q() != null) {
                    dm5Var.f(px7Var.Q().getId());
                }
                dm5Var.e(postData.M());
                return yl5.b().c(dm5Var);
            }
            return false;
        }
        return invokeLL.booleanValue;
    }

    public static void d(TbPageContext<BaseFragmentActivity> tbPageContext, PbModel pbModel, t18 t18Var) {
        Interceptable interceptable = $ic;
        if ((interceptable == null || interceptable.invokeLLL(65539, null, tbPageContext, pbModel, t18Var) == null) && tbPageContext != null && pbModel != null && t18Var != null) {
            yl5.b().e(tbPageContext, t18Var.n1(), b(pbModel, t18Var));
            yl5.b().d(1);
        }
    }

    public static boolean e(PostData postData) {
        InterceptResult invokeL;
        Interceptable interceptable = $ic;
        if (interceptable == null || (invokeL = interceptable.invokeL(InputDeviceCompat.SOURCE_TRACKBALL, null, postData)) == null) {
            if (postData == null) {
                return false;
            }
            return yl5.b().f(postData.M());
        }
        return invokeL.booleanValue;
    }
}
