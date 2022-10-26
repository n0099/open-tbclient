package com.baidu.tieba;

import android.text.TextUtils;
import android.util.SparseArray;
import android.view.ViewGroup;
import androidx.core.view.InputDeviceCompat;
import com.baidu.android.imsdk.internal.Constants;
import com.baidu.tbadk.TbPageContext;
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
public class s18 {
    public static /* synthetic */ Interceptable $ic;
    public transient /* synthetic */ FieldHolder $fh;

    /* loaded from: classes5.dex */
    public final class a implements qk5 {
        public static /* synthetic */ Interceptable $ic;
        public transient /* synthetic */ FieldHolder $fh;
        public final /* synthetic */ PbModel a;
        public final /* synthetic */ yz7 b;

        public a(PbModel pbModel, yz7 yz7Var) {
            Interceptable interceptable = $ic;
            if (interceptable != null) {
                InitContext newInitContext = TitanRuntime.newInitContext();
                newInitContext.initArgs = r2;
                Object[] objArr = {pbModel, yz7Var};
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
            this.b = yz7Var;
        }

        @Override // com.baidu.tieba.qk5
        public void a() {
            Interceptable interceptable = $ic;
            if (interceptable == null || interceptable.invokeV(1048576, this) == null) {
                this.b.q4(false);
            }
        }

        @Override // com.baidu.tieba.qk5
        public void b(List list) {
            Interceptable interceptable = $ic;
            if ((interceptable != null && interceptable.invokeL(Constants.METHOD_GET_CONTACTER_INFO_FOR_SESSION, this, list) != null) || this.a.S1() == null) {
                return;
            }
            ArrayList G = this.a.S1().G();
            if (!ListUtils.isEmpty(G) && !ListUtils.isEmpty(list)) {
                Iterator it = G.iterator();
                while (it.hasNext()) {
                    PostData postData = (PostData) it.next();
                    int i = 0;
                    while (true) {
                        if (i >= list.size()) {
                            break;
                        } else if (TextUtils.equals((CharSequence) list.get(i), postData.M())) {
                            it.remove();
                            if (this.a.S1().P() != null) {
                                this.a.S1().P().setReply_num(this.a.S1().P().getReply_num() - 1);
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
            pk5.b().a();
        }
    }

    public static sk5 b(PbModel pbModel, yz7 yz7Var) {
        InterceptResult invokeLL;
        Interceptable interceptable = $ic;
        if (interceptable == null || (invokeLL = interceptable.invokeLL(65537, null, pbModel, yz7Var)) == null) {
            if (pbModel != null && yz7Var != null) {
                sk5 sk5Var = new sk5();
                if (pbModel.S1() != null && pbModel.S1().l() != null) {
                    if (pbModel.S1().l().getDeletedReasonInfo() != null) {
                        sk5Var.p(pbModel.S1().l().getDeletedReasonInfo().is_grays_cale_forum.intValue());
                        sk5Var.o(pbModel.S1().l().getDeletedReasonInfo().is_boomgrow.intValue());
                    }
                    sk5Var.l(pbModel.S1().l().getId());
                    sk5Var.m(pbModel.S1().l().getName());
                    sk5Var.k(pbModel.S1().l().getImage_url());
                    sk5Var.t(pbModel.S1().l().getUser_level());
                }
                if (pbModel.S1() != null && pbModel.S1().o() != null) {
                    sk5Var.n(pbModel.S1().o().has_forum_rule.intValue());
                }
                if (pbModel.S1() != null && pbModel.S1().W() != null) {
                    sk5Var.s(pbModel.S1().W());
                }
                sk5Var.q(new a(pbModel, yz7Var));
                if (pbModel.S1() != null) {
                    AntiData d = pbModel.S1().d();
                    SparseArray sparseArray = new SparseArray();
                    if (d != null && d.getDelThreadInfoList() != null) {
                        List<DeleteThreadInfo> delThreadInfoList = d.getDelThreadInfoList();
                        for (int i = 0; i < delThreadInfoList.size(); i++) {
                            if (delThreadInfoList.get(i) != null && !TextUtils.isEmpty(delThreadInfoList.get(i).text_info)) {
                                sparseArray.put(delThreadInfoList.get(i).text_id, delThreadInfoList.get(i).text_info);
                            }
                        }
                    }
                    sk5Var.r(sparseArray);
                }
                return sk5Var;
            }
            return null;
        }
        return (sk5) invokeLL.objValue;
    }

    public static boolean c(uv7 uv7Var, PostData postData) {
        InterceptResult invokeLL;
        Interceptable interceptable = $ic;
        if (interceptable == null || (invokeLL = interceptable.invokeLL(65538, null, uv7Var, postData)) == null) {
            if (uv7Var != null && postData != null) {
                uk5 uk5Var = new uk5();
                uk5Var.d(postData.I() + "");
                if (uv7Var.P() != null) {
                    uk5Var.f(uv7Var.P().getId());
                }
                uk5Var.e(postData.M());
                return pk5.b().c(uk5Var);
            }
            return false;
        }
        return invokeLL.booleanValue;
    }

    public static void d(TbPageContext tbPageContext, PbModel pbModel, yz7 yz7Var) {
        Interceptable interceptable = $ic;
        if ((interceptable == null || interceptable.invokeLLL(65539, null, tbPageContext, pbModel, yz7Var) == null) && tbPageContext != null && pbModel != null && yz7Var != null) {
            pk5.b().e(tbPageContext, (ViewGroup) yz7Var.n1(), b(pbModel, yz7Var));
            pk5.b().d(1);
        }
    }

    public static boolean e(PostData postData) {
        InterceptResult invokeL;
        Interceptable interceptable = $ic;
        if (interceptable == null || (invokeL = interceptable.invokeL(InputDeviceCompat.SOURCE_TRACKBALL, null, postData)) == null) {
            if (postData == null) {
                return false;
            }
            return pk5.b().f(postData.M());
        }
        return invokeL.booleanValue;
    }
}
