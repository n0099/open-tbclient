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
public class z99 {
    public static /* synthetic */ Interceptable $ic;
    public transient /* synthetic */ FieldHolder $fh;

    /* loaded from: classes8.dex */
    public static class a implements s06 {
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

        @Override // com.baidu.tieba.s06
        public void a() {
            Interceptable interceptable = $ic;
            if (interceptable == null || interceptable.invokeV(1048576, this) == null) {
                this.b.t2(false);
            }
        }

        @Override // com.baidu.tieba.s06
        public void b(List<String> list) {
            Interceptable interceptable = $ic;
            if ((interceptable != null && interceptable.invokeL(Constants.METHOD_GET_CONTACTER_INFO_FOR_SESSION, this, list) != null) || this.a.y1() == null) {
                return;
            }
            ArrayList<jy9> F = this.a.y1().F();
            if (!ListUtils.isEmpty(F) && !ListUtils.isEmpty(list)) {
                Iterator<jy9> it = F.iterator();
                while (it.hasNext()) {
                    jy9 next = it.next();
                    int i = 0;
                    while (true) {
                        if (i >= list.size()) {
                            break;
                        } else if (TextUtils.equals(list.get(i), next.O())) {
                            it.remove();
                            if (this.a.y1().N() != null) {
                                this.a.y1().N().setReply_num(this.a.y1().N().getReply_num() - 1);
                            }
                        } else {
                            i++;
                        }
                    }
                }
                this.b.f2();
            }
        }
    }

    public static void a() {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeV(65536, null) == null) {
            r06.b().a();
        }
    }

    public static u06 b(PbModel pbModel, DetailInfoAndReplyFragment detailInfoAndReplyFragment) {
        InterceptResult invokeLL;
        Interceptable interceptable = $ic;
        if (interceptable == null || (invokeLL = interceptable.invokeLL(65537, null, pbModel, detailInfoAndReplyFragment)) == null) {
            if (detailInfoAndReplyFragment != null && pbModel != null) {
                u06 u06Var = new u06();
                if (pbModel.y1() != null && pbModel.y1().k() != null) {
                    if (pbModel.y1().k().getDeletedReasonInfo() != null) {
                        u06Var.p(pbModel.y1().k().getDeletedReasonInfo().is_grays_cale_forum.intValue());
                        u06Var.o(pbModel.y1().k().getDeletedReasonInfo().is_boomgrow.intValue());
                    }
                    u06Var.l(pbModel.y1().k().getId());
                    u06Var.m(pbModel.y1().k().getName());
                    u06Var.k(pbModel.y1().k().getImage_url());
                    u06Var.t(pbModel.y1().k().getUser_level());
                }
                if (pbModel.y1() != null && pbModel.y1().n() != null) {
                    u06Var.n(pbModel.y1().n().has_forum_rule.intValue());
                }
                if (pbModel.y1() != null && pbModel.y1().U() != null) {
                    u06Var.s(pbModel.y1().U());
                }
                u06Var.q(new a(pbModel, detailInfoAndReplyFragment));
                if (pbModel.y1() != null) {
                    AntiData c = pbModel.y1().c();
                    SparseArray<String> sparseArray = new SparseArray<>();
                    if (c != null && c.getDelThreadInfoList() != null) {
                        List<DeleteThreadInfo> delThreadInfoList = c.getDelThreadInfoList();
                        for (int i = 0; i < delThreadInfoList.size(); i++) {
                            if (delThreadInfoList.get(i) != null && !TextUtils.isEmpty(delThreadInfoList.get(i).text_info)) {
                                sparseArray.put(delThreadInfoList.get(i).text_id, delThreadInfoList.get(i).text_info);
                            }
                        }
                    }
                    u06Var.r(sparseArray);
                }
                return u06Var;
            }
            return null;
        }
        return (u06) invokeLL.objValue;
    }

    public static boolean c(m39 m39Var, jy9 jy9Var) {
        InterceptResult invokeLL;
        Interceptable interceptable = $ic;
        if (interceptable == null || (invokeLL = interceptable.invokeLL(65538, null, m39Var, jy9Var)) == null) {
            if (m39Var != null && jy9Var != null) {
                w06 w06Var = new w06();
                w06Var.d(jy9Var.J() + "");
                if (m39Var.N() != null) {
                    w06Var.f(m39Var.N().getId());
                }
                w06Var.e(jy9Var.O());
                return r06.b().c(w06Var);
            }
            return false;
        }
        return invokeLL.booleanValue;
    }

    public static void d(TbPageContext<BaseFragmentActivity> tbPageContext, PbModel pbModel, DetailInfoAndReplyFragment detailInfoAndReplyFragment, View view2) {
        Interceptable interceptable = $ic;
        if ((interceptable == null || interceptable.invokeLLLL(65539, null, tbPageContext, pbModel, detailInfoAndReplyFragment, view2) == null) && tbPageContext != null && pbModel != null && detailInfoAndReplyFragment != null && detailInfoAndReplyFragment.getView() != null) {
            r06.b().e(tbPageContext, (ViewGroup) view2, b(pbModel, detailInfoAndReplyFragment));
            r06.b().d(2);
        }
    }

    public static boolean e(jy9 jy9Var) {
        InterceptResult invokeL;
        Interceptable interceptable = $ic;
        if (interceptable == null || (invokeL = interceptable.invokeL(InputDeviceCompat.SOURCE_TRACKBALL, null, jy9Var)) == null) {
            if (jy9Var == null) {
                return false;
            }
            return r06.b().f(jy9Var.O());
        }
        return invokeL.booleanValue;
    }
}
