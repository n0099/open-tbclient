package com.baidu.tieba;

import android.text.TextUtils;
import android.util.SparseArray;
import androidx.core.view.InputDeviceCompat;
import com.baidu.adp.lib.util.BdNetTypeUtil;
import com.baidu.tbadk.TbPageContext;
import com.baidu.tbadk.core.TbadkCoreApplication;
import com.baidu.tbadk.core.data.AntiData;
import com.baidu.tbadk.core.data.DeleteThreadInfo;
import com.baidu.tbadk.core.data.ThreadData;
import com.baidu.tbadk.core.data.UserData;
import com.baidu.tbadk.core.util.StringHelper;
import com.baidu.tbadk.core.util.UtilHelper;
import com.baidu.tieba.a66;
import com.baidu.tieba.d66;
import com.baidu.tieba.tbadkCore.model.ForumManageModel;
import com.baidu.titan.sdk.runtime.FieldHolder;
import com.baidu.titan.sdk.runtime.InitContext;
import com.baidu.titan.sdk.runtime.Interceptable;
import com.baidu.titan.sdk.runtime.TitanRuntime;
import java.util.List;
import org.json.JSONArray;
/* loaded from: classes8.dex */
public class y56 {
    public static /* synthetic */ Interceptable $ic;
    public transient /* synthetic */ FieldHolder $fh;

    /* loaded from: classes8.dex */
    public static class a implements d66.i {
        public static /* synthetic */ Interceptable $ic;
        public transient /* synthetic */ FieldHolder $fh;
        public final /* synthetic */ TbPageContext a;
        public final /* synthetic */ b66 b;
        public final /* synthetic */ boolean c;

        public a(TbPageContext tbPageContext, b66 b66Var, boolean z) {
            Interceptable interceptable = $ic;
            if (interceptable != null) {
                InitContext newInitContext = TitanRuntime.newInitContext();
                newInitContext.initArgs = r2;
                Object[] objArr = {tbPageContext, b66Var, Boolean.valueOf(z)};
                interceptable.invokeUnInit(65536, newInitContext);
                int i = newInitContext.flag;
                if ((i & 1) != 0) {
                    int i2 = i & 2;
                    newInitContext.thisArg = this;
                    interceptable.invokeInitBody(65536, newInitContext);
                    return;
                }
            }
            this.a = tbPageContext;
            this.b = b66Var;
            this.c = z;
        }

        @Override // com.baidu.tieba.d66.i
        public void a(JSONArray jSONArray) {
            Interceptable interceptable = $ic;
            if (interceptable == null || interceptable.invokeL(1048576, this, jSONArray) == null) {
                if (BdNetTypeUtil.isNetworkAvailableForImmediately()) {
                    y56.e(jSONArray, this.b.a(), this.b.b(), this.c);
                } else {
                    yi.Q(this.a.getContext(), R.string.obfuscated_res_0x7f0f0e1f);
                }
            }
        }
    }

    /* loaded from: classes8.dex */
    public static class b implements a66.h {
        public static /* synthetic */ Interceptable $ic;
        public transient /* synthetic */ FieldHolder $fh;
        public final /* synthetic */ TbPageContext a;
        public final /* synthetic */ b66 b;
        public final /* synthetic */ boolean c;

        public b(TbPageContext tbPageContext, b66 b66Var, boolean z) {
            Interceptable interceptable = $ic;
            if (interceptable != null) {
                InitContext newInitContext = TitanRuntime.newInitContext();
                newInitContext.initArgs = r2;
                Object[] objArr = {tbPageContext, b66Var, Boolean.valueOf(z)};
                interceptable.invokeUnInit(65536, newInitContext);
                int i = newInitContext.flag;
                if ((i & 1) != 0) {
                    int i2 = i & 2;
                    newInitContext.thisArg = this;
                    interceptable.invokeInitBody(65536, newInitContext);
                    return;
                }
            }
            this.a = tbPageContext;
            this.b = b66Var;
            this.c = z;
        }

        @Override // com.baidu.tieba.a66.h
        public void a(JSONArray jSONArray) {
            Interceptable interceptable = $ic;
            if (interceptable == null || interceptable.invokeL(1048576, this, jSONArray) == null) {
                if (BdNetTypeUtil.isNetworkAvailableForImmediately()) {
                    y56.e(jSONArray, this.b.a(), this.b.b(), this.c);
                } else {
                    yi.Q(this.a.getContext(), R.string.obfuscated_res_0x7f0f0e1f);
                }
            }
        }
    }

    public static void b(TbPageContext tbPageContext, b66 b66Var) {
        boolean z;
        Interceptable interceptable = $ic;
        if ((interceptable == null || interceptable.invokeLL(65537, null, tbPageContext, b66Var) == null) && tbPageContext != null && tbPageContext.getPageActivity() != null && tbPageContext.getPageActivity().getWindow() != null) {
            if (b66Var.getType() == 3) {
                z = true;
            } else {
                z = false;
            }
            a66 a66Var = new a66(tbPageContext, tbPageContext.getPageActivity().getWindow().getDecorView());
            if (b66Var != null) {
                a66Var.z(z);
            }
            AntiData c = ph7.f().c();
            SparseArray<String> sparseArray = new SparseArray<>();
            if (c != null && c.getDelThreadInfoList() != null) {
                List<DeleteThreadInfo> delThreadInfoList = c.getDelThreadInfoList();
                for (int i = 0; i < delThreadInfoList.size(); i++) {
                    if (!TextUtils.isEmpty(delThreadInfoList.get(i).text_info)) {
                        sparseArray.put(delThreadInfoList.get(i).text_id, delThreadInfoList.get(i).text_info);
                    }
                }
            }
            JSONArray jSONArray = new JSONArray();
            JSONArray jSONArray2 = new JSONArray();
            List<ThreadData> g = ph7.f().g();
            for (int i2 = 0; i2 < g.size(); i2++) {
                if (g.get(i2) != null) {
                    jSONArray.put(g.get(i2).getTid());
                    if (z) {
                        jSONArray2.put("1");
                    } else if (!g.get(i2).isScoreThread() && !g.get(i2).isWorksInfo()) {
                        jSONArray2.put("0");
                    } else {
                        jSONArray2.put("1");
                    }
                }
            }
            s35 s35Var = new s35();
            s35Var.j(sparseArray);
            if (b66Var != null) {
                s35Var.i(b66Var.getType());
            }
            s35Var.p(jSONArray);
            s35Var.m(jSONArray2);
            s35Var.l(ph7.f().d());
            a66Var.A(s35Var);
            a66Var.B(new String[]{TbadkCoreApplication.getInst().getString(R.string.delete_thread_reason_1), TbadkCoreApplication.getInst().getString(R.string.delete_thread_reason_2), TbadkCoreApplication.getInst().getString(R.string.delete_thread_reason_3), TbadkCoreApplication.getInst().getString(R.string.delete_thread_reason_4), TbadkCoreApplication.getInst().getString(R.string.delete_thread_reason_5)});
            a66Var.D("1");
            a66Var.C(new b(tbPageContext, b66Var, z));
        }
    }

    public static void c(TbPageContext tbPageContext, b66 b66Var, c66 c66Var, UserData userData) {
        boolean z;
        Interceptable interceptable = $ic;
        if ((interceptable == null || interceptable.invokeLLLL(65538, null, tbPageContext, b66Var, c66Var, userData) == null) && tbPageContext != null && tbPageContext.getPageActivity() != null && tbPageContext.getPageActivity().getWindow() != null) {
            if (b66Var.getType() == 3) {
                z = true;
            } else {
                z = false;
            }
            d66 d66Var = new d66(tbPageContext, tbPageContext.getPageActivity().getWindow().getDecorView(), c66Var, userData);
            if (b66Var != null) {
                d66Var.F(z);
            }
            AntiData c = ph7.f().c();
            SparseArray<String> sparseArray = new SparseArray<>();
            if (c != null && c.getDelThreadInfoList() != null) {
                List<DeleteThreadInfo> delThreadInfoList = c.getDelThreadInfoList();
                for (int i = 0; i < delThreadInfoList.size(); i++) {
                    if (!TextUtils.isEmpty(delThreadInfoList.get(i).text_info)) {
                        sparseArray.put(delThreadInfoList.get(i).text_id, delThreadInfoList.get(i).text_info);
                    }
                }
            }
            JSONArray jSONArray = new JSONArray();
            JSONArray jSONArray2 = new JSONArray();
            List<ThreadData> g = ph7.f().g();
            for (int i2 = 0; i2 < g.size(); i2++) {
                if (g.get(i2) != null) {
                    jSONArray.put(g.get(i2).getTid());
                    if (z) {
                        jSONArray2.put("1");
                    } else if (!g.get(i2).isScoreThread() && !g.get(i2).isWorksInfo()) {
                        jSONArray2.put("0");
                    } else {
                        jSONArray2.put("1");
                    }
                }
            }
            s35 s35Var = new s35();
            s35Var.j(sparseArray);
            if (b66Var != null) {
                s35Var.i(b66Var.getType());
            }
            s35Var.p(jSONArray);
            s35Var.m(jSONArray2);
            s35Var.l(ph7.f().d());
            d66Var.G(s35Var);
            d66Var.H(new String[]{TbadkCoreApplication.getInst().getString(R.string.delete_thread_new_reason_1), TbadkCoreApplication.getInst().getString(R.string.delete_thread_new_reason_2), TbadkCoreApplication.getInst().getString(R.string.delete_thread_new_reason_3), TbadkCoreApplication.getInst().getString(R.string.delete_thread_new_reason_4), TbadkCoreApplication.getInst().getString(R.string.delete_thread_new_reason_5)});
            d66Var.J("1");
            d66Var.I(new a(tbPageContext, b66Var, z));
        }
    }

    public static void d(int i, TbPageContext tbPageContext, b66 b66Var, c66 c66Var, UserData userData) {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeCommon(65539, null, new Object[]{Integer.valueOf(i), tbPageContext, b66Var, c66Var, userData}) == null) {
            if (1 == i) {
                c(tbPageContext, b66Var, c66Var, userData);
            } else {
                b(tbPageContext, b66Var);
            }
        }
    }

    public static void e(JSONArray jSONArray, ForumManageModel forumManageModel, ThreadData threadData, boolean z) {
        Interceptable interceptable = $ic;
        if ((interceptable == null || interceptable.invokeCommon(InputDeviceCompat.SOURCE_TRACKBALL, null, new Object[]{jSONArray, forumManageModel, threadData, Boolean.valueOf(z)}) == null) && forumManageModel != null && threadData != null && threadData.getAuthor() != null) {
            String userId = threadData.getAuthor().getUserId();
            String id = threadData.getId();
            String forum_name = threadData.getForum_name();
            String valueOf = String.valueOf(threadData.getFid());
            boolean isCurrentAccount = UtilHelper.isCurrentAccount(userId);
            if (jSONArray != null) {
                forumManageModel.q0(StringHelper.JsonArrayToString(jSONArray));
            }
            forumManageModel.r0(valueOf, forum_name, id, null, 0, 1, isCurrentAccount, threadData.getBaijiahaoData(), z);
        }
    }
}
