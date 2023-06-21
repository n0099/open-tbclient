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
/* loaded from: classes7.dex */
public class sa9 {
    public static /* synthetic */ Interceptable $ic;
    public transient /* synthetic */ FieldHolder $fh;

    /* loaded from: classes7.dex */
    public static class a implements x06 {
        public static /* synthetic */ Interceptable $ic;
        public transient /* synthetic */ FieldHolder $fh;
        public final /* synthetic */ PbModel a;
        public final /* synthetic */ r89 b;

        public a(PbModel pbModel, r89 r89Var) {
            Interceptable interceptable = $ic;
            if (interceptable != null) {
                InitContext newInitContext = TitanRuntime.newInitContext();
                newInitContext.initArgs = r2;
                Object[] objArr = {pbModel, r89Var};
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
            this.b = r89Var;
        }

        @Override // com.baidu.tieba.x06
        public void a() {
            Interceptable interceptable = $ic;
            if (interceptable == null || interceptable.invokeV(1048576, this) == null) {
                this.b.u4(false);
            }
        }

        @Override // com.baidu.tieba.x06
        public void b(List<String> list) {
            Interceptable interceptable = $ic;
            if ((interceptable != null && interceptable.invokeL(Constants.METHOD_GET_CONTACTER_INFO_FOR_SESSION, this, list) != null) || this.a.y1() == null) {
                return;
            }
            ArrayList<b0a> F = this.a.y1().F();
            if (!ListUtils.isEmpty(F) && !ListUtils.isEmpty(list)) {
                Iterator<b0a> it = F.iterator();
                while (it.hasNext()) {
                    b0a next = it.next();
                    int i = 0;
                    while (true) {
                        if (i >= list.size()) {
                            break;
                        } else if (TextUtils.equals(list.get(i), next.S())) {
                            it.remove();
                            if (this.a.y1().N() != null) {
                                this.a.y1().N().setReply_num(this.a.y1().N().getReply_num() - 1);
                            }
                        } else {
                            i++;
                        }
                    }
                }
                this.b.N1(this.a.y1());
            }
        }
    }

    public static void a() {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeV(65536, null) == null) {
            w06.b().a();
        }
    }

    public static z06 b(PbModel pbModel, r89 r89Var) {
        InterceptResult invokeLL;
        Interceptable interceptable = $ic;
        if (interceptable == null || (invokeLL = interceptable.invokeLL(65537, null, pbModel, r89Var)) == null) {
            if (pbModel != null && r89Var != null) {
                z06 z06Var = new z06();
                if (pbModel.y1() != null && pbModel.y1().k() != null) {
                    if (pbModel.y1().k().getDeletedReasonInfo() != null) {
                        z06Var.p(pbModel.y1().k().getDeletedReasonInfo().is_grays_cale_forum.intValue());
                        z06Var.o(pbModel.y1().k().getDeletedReasonInfo().is_boomgrow.intValue());
                    }
                    z06Var.l(pbModel.y1().k().getId());
                    z06Var.m(pbModel.y1().k().getName());
                    z06Var.k(pbModel.y1().k().getImage_url());
                    z06Var.t(pbModel.y1().k().getUser_level());
                }
                if (pbModel.y1() != null && pbModel.y1().n() != null) {
                    z06Var.n(pbModel.y1().n().has_forum_rule.intValue());
                }
                if (pbModel.y1() != null && pbModel.y1().U() != null) {
                    z06Var.s(pbModel.y1().U());
                }
                z06Var.q(new a(pbModel, r89Var));
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
                    z06Var.r(sparseArray);
                }
                return z06Var;
            }
            return null;
        }
        return (z06) invokeLL.objValue;
    }

    public static boolean c(j49 j49Var, b0a b0aVar) {
        InterceptResult invokeLL;
        Interceptable interceptable = $ic;
        if (interceptable == null || (invokeLL = interceptable.invokeLL(65538, null, j49Var, b0aVar)) == null) {
            if (j49Var != null && b0aVar != null) {
                b16 b16Var = new b16();
                b16Var.d(b0aVar.O() + "");
                if (j49Var.N() != null) {
                    b16Var.f(j49Var.N().getId());
                }
                b16Var.e(b0aVar.S());
                return w06.b().c(b16Var);
            }
            return false;
        }
        return invokeLL.booleanValue;
    }

    public static void d(TbPageContext<BaseFragmentActivity> tbPageContext, PbModel pbModel, r89 r89Var) {
        Interceptable interceptable = $ic;
        if ((interceptable == null || interceptable.invokeLLL(65539, null, tbPageContext, pbModel, r89Var) == null) && tbPageContext != null && pbModel != null && r89Var != null) {
            w06.b().e(tbPageContext, r89Var.p1(), b(pbModel, r89Var));
            w06.b().d(1);
        }
    }

    public static boolean e(b0a b0aVar) {
        InterceptResult invokeL;
        Interceptable interceptable = $ic;
        if (interceptable == null || (invokeL = interceptable.invokeL(InputDeviceCompat.SOURCE_TRACKBALL, null, b0aVar)) == null) {
            if (b0aVar == null) {
                return false;
            }
            return w06.b().f(b0aVar.S());
        }
        return invokeL.booleanValue;
    }
}
