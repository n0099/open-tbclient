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
public class ql9 {
    public static /* synthetic */ Interceptable $ic;
    public transient /* synthetic */ FieldHolder $fh;

    /* loaded from: classes7.dex */
    public static class a implements g26 {
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

        @Override // com.baidu.tieba.g26
        public void a() {
            Interceptable interceptable = $ic;
            if (interceptable == null || interceptable.invokeV(1048576, this) == null) {
                this.b.v2(false);
            }
        }

        @Override // com.baidu.tieba.g26
        public void b(List<String> list) {
            Interceptable interceptable = $ic;
            if ((interceptable != null && interceptable.invokeL(Constants.METHOD_GET_CONTACTER_INFO_FOR_SESSION, this, list) != null) || this.a.z1() == null) {
                return;
            }
            ArrayList<yca> F = this.a.z1().F();
            if (!ListUtils.isEmpty(F) && !ListUtils.isEmpty(list)) {
                Iterator<yca> it = F.iterator();
                while (it.hasNext()) {
                    yca next = it.next();
                    int i = 0;
                    while (true) {
                        if (i >= list.size()) {
                            break;
                        } else if (TextUtils.equals(list.get(i), next.S())) {
                            it.remove();
                            if (this.a.z1().N() != null) {
                                this.a.z1().N().setReply_num(this.a.z1().N().getReply_num() - 1);
                            }
                        } else {
                            i++;
                        }
                    }
                }
                this.b.h2();
            }
        }
    }

    public static void a() {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeV(65536, null) == null) {
            f26.b().a();
        }
    }

    public static i26 b(PbModel pbModel, DetailInfoAndReplyFragment detailInfoAndReplyFragment) {
        InterceptResult invokeLL;
        Interceptable interceptable = $ic;
        if (interceptable == null || (invokeLL = interceptable.invokeLL(65537, null, pbModel, detailInfoAndReplyFragment)) == null) {
            if (detailInfoAndReplyFragment != null && pbModel != null) {
                i26 i26Var = new i26();
                if (pbModel.z1() != null && pbModel.z1().k() != null) {
                    if (pbModel.z1().k().getDeletedReasonInfo() != null) {
                        i26Var.p(pbModel.z1().k().getDeletedReasonInfo().is_grays_cale_forum.intValue());
                        i26Var.o(pbModel.z1().k().getDeletedReasonInfo().is_boomgrow.intValue());
                    }
                    i26Var.l(pbModel.z1().k().getId());
                    i26Var.m(pbModel.z1().k().getName());
                    i26Var.k(pbModel.z1().k().getImage_url());
                    i26Var.t(pbModel.z1().k().getUser_level());
                }
                if (pbModel.z1() != null && pbModel.z1().n() != null) {
                    i26Var.n(pbModel.z1().n().has_forum_rule.intValue());
                }
                if (pbModel.z1() != null && pbModel.z1().U() != null) {
                    i26Var.s(pbModel.z1().U());
                }
                i26Var.q(new a(pbModel, detailInfoAndReplyFragment));
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
                    i26Var.r(sparseArray);
                }
                return i26Var;
            }
            return null;
        }
        return (i26) invokeLL.objValue;
    }

    public static boolean c(ze9 ze9Var, yca ycaVar) {
        InterceptResult invokeLL;
        Interceptable interceptable = $ic;
        if (interceptable == null || (invokeLL = interceptable.invokeLL(65538, null, ze9Var, ycaVar)) == null) {
            if (ze9Var != null && ycaVar != null) {
                k26 k26Var = new k26();
                k26Var.d(ycaVar.N() + "");
                if (ze9Var.N() != null) {
                    k26Var.f(ze9Var.N().getId());
                }
                k26Var.e(ycaVar.S());
                return f26.b().c(k26Var);
            }
            return false;
        }
        return invokeLL.booleanValue;
    }

    public static void d(TbPageContext<BaseFragmentActivity> tbPageContext, PbModel pbModel, DetailInfoAndReplyFragment detailInfoAndReplyFragment, View view2) {
        Interceptable interceptable = $ic;
        if ((interceptable == null || interceptable.invokeLLLL(65539, null, tbPageContext, pbModel, detailInfoAndReplyFragment, view2) == null) && tbPageContext != null && pbModel != null && detailInfoAndReplyFragment != null && detailInfoAndReplyFragment.getView() != null) {
            f26.b().e(tbPageContext, (ViewGroup) view2, b(pbModel, detailInfoAndReplyFragment));
            f26.b().d(2);
        }
    }

    public static boolean e(yca ycaVar) {
        InterceptResult invokeL;
        Interceptable interceptable = $ic;
        if (interceptable == null || (invokeL = interceptable.invokeL(InputDeviceCompat.SOURCE_TRACKBALL, null, ycaVar)) == null) {
            if (ycaVar == null) {
                return false;
            }
            return f26.b().f(ycaVar.S());
        }
        return invokeL.booleanValue;
    }
}
