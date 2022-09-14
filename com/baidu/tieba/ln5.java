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
import com.baidu.tieba.nn5;
import com.baidu.tieba.qn5;
import com.baidu.tieba.tbadkCore.model.ForumManageModel;
import com.baidu.titan.sdk.runtime.FieldHolder;
import com.baidu.titan.sdk.runtime.InitContext;
import com.baidu.titan.sdk.runtime.Interceptable;
import com.baidu.titan.sdk.runtime.TitanRuntime;
import java.util.List;
import org.json.JSONArray;
/* loaded from: classes4.dex */
public class ln5 {
    public static /* synthetic */ Interceptable $ic;
    public transient /* synthetic */ FieldHolder $fh;

    /* loaded from: classes4.dex */
    public static class a implements qn5.h {
        public static /* synthetic */ Interceptable $ic;
        public transient /* synthetic */ FieldHolder $fh;
        public final /* synthetic */ TbPageContext a;
        public final /* synthetic */ on5 b;
        public final /* synthetic */ boolean c;

        public a(TbPageContext tbPageContext, on5 on5Var, boolean z) {
            Interceptable interceptable = $ic;
            if (interceptable != null) {
                InitContext newInitContext = TitanRuntime.newInitContext();
                newInitContext.initArgs = r2;
                Object[] objArr = {tbPageContext, on5Var, Boolean.valueOf(z)};
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
            this.b = on5Var;
            this.c = z;
        }

        @Override // com.baidu.tieba.qn5.h
        public void a(JSONArray jSONArray) {
            Interceptable interceptable = $ic;
            if (interceptable == null || interceptable.invokeL(1048576, this, jSONArray) == null) {
                if (BdNetTypeUtil.isNetworkAvailableForImmediately()) {
                    ln5.e(jSONArray, this.b.a(), this.b.b(), this.c);
                } else {
                    ej.M(this.a.getContext(), R.string.obfuscated_res_0x7f0f0c59);
                }
            }
        }
    }

    /* loaded from: classes4.dex */
    public static class b implements nn5.g {
        public static /* synthetic */ Interceptable $ic;
        public transient /* synthetic */ FieldHolder $fh;
        public final /* synthetic */ TbPageContext a;
        public final /* synthetic */ on5 b;
        public final /* synthetic */ boolean c;

        public b(TbPageContext tbPageContext, on5 on5Var, boolean z) {
            Interceptable interceptable = $ic;
            if (interceptable != null) {
                InitContext newInitContext = TitanRuntime.newInitContext();
                newInitContext.initArgs = r2;
                Object[] objArr = {tbPageContext, on5Var, Boolean.valueOf(z)};
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
            this.b = on5Var;
            this.c = z;
        }

        @Override // com.baidu.tieba.nn5.g
        public void a(JSONArray jSONArray) {
            Interceptable interceptable = $ic;
            if (interceptable == null || interceptable.invokeL(1048576, this, jSONArray) == null) {
                if (BdNetTypeUtil.isNetworkAvailableForImmediately()) {
                    ln5.e(jSONArray, this.b.a(), this.b.b(), this.c);
                } else {
                    ej.M(this.a.getContext(), R.string.obfuscated_res_0x7f0f0c59);
                }
            }
        }
    }

    public static void b(TbPageContext tbPageContext, on5 on5Var) {
        Interceptable interceptable = $ic;
        if (!(interceptable == null || interceptable.invokeLL(65537, null, tbPageContext, on5Var) == null) || tbPageContext == null || tbPageContext.getPageActivity() == null || tbPageContext.getPageActivity().getWindow() == null) {
            return;
        }
        boolean z = on5Var.getType() == 3;
        nn5 nn5Var = new nn5(tbPageContext, tbPageContext.getPageActivity().getWindow().getDecorView());
        if (on5Var != null) {
            nn5Var.w(z);
        }
        AntiData c = hg6.f().c();
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
        List<ThreadData> g = hg6.f().g();
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
        is4 is4Var = new is4();
        is4Var.j(sparseArray);
        if (on5Var != null) {
            is4Var.i(on5Var.getType());
        }
        is4Var.p(jSONArray);
        is4Var.m(jSONArray2);
        is4Var.l(hg6.f().d());
        nn5Var.x(is4Var);
        nn5Var.y(new String[]{TbadkCoreApplication.getInst().getString(R.string.obfuscated_res_0x7f0f04c4), TbadkCoreApplication.getInst().getString(R.string.obfuscated_res_0x7f0f04c5), TbadkCoreApplication.getInst().getString(R.string.obfuscated_res_0x7f0f04c6), TbadkCoreApplication.getInst().getString(R.string.obfuscated_res_0x7f0f04c7), TbadkCoreApplication.getInst().getString(R.string.obfuscated_res_0x7f0f04c8)});
        nn5Var.A("1");
        nn5Var.z(new b(tbPageContext, on5Var, z));
    }

    public static void c(TbPageContext tbPageContext, on5 on5Var, pn5 pn5Var, UserData userData) {
        Interceptable interceptable = $ic;
        if (!(interceptable == null || interceptable.invokeLLLL(65538, null, tbPageContext, on5Var, pn5Var, userData) == null) || tbPageContext == null || tbPageContext.getPageActivity() == null || tbPageContext.getPageActivity().getWindow() == null) {
            return;
        }
        boolean z = on5Var.getType() == 3;
        qn5 qn5Var = new qn5(tbPageContext, tbPageContext.getPageActivity().getWindow().getDecorView(), pn5Var, userData);
        if (on5Var != null) {
            qn5Var.C(z);
        }
        AntiData c = hg6.f().c();
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
        List<ThreadData> g = hg6.f().g();
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
        is4 is4Var = new is4();
        is4Var.j(sparseArray);
        if (on5Var != null) {
            is4Var.i(on5Var.getType());
        }
        is4Var.p(jSONArray);
        is4Var.m(jSONArray2);
        is4Var.l(hg6.f().d());
        qn5Var.D(is4Var);
        qn5Var.E(new String[]{TbadkCoreApplication.getInst().getString(R.string.obfuscated_res_0x7f0f04bf), TbadkCoreApplication.getInst().getString(R.string.obfuscated_res_0x7f0f04c0), TbadkCoreApplication.getInst().getString(R.string.obfuscated_res_0x7f0f04c1), TbadkCoreApplication.getInst().getString(R.string.obfuscated_res_0x7f0f04c2), TbadkCoreApplication.getInst().getString(R.string.obfuscated_res_0x7f0f04c3)});
        qn5Var.G("1");
        qn5Var.F(new a(tbPageContext, on5Var, z));
    }

    public static void d(int i, TbPageContext tbPageContext, on5 on5Var, pn5 pn5Var, UserData userData) {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeCommon(65539, null, new Object[]{Integer.valueOf(i), tbPageContext, on5Var, pn5Var, userData}) == null) {
            if (1 == i) {
                c(tbPageContext, on5Var, pn5Var, userData);
            } else {
                b(tbPageContext, on5Var);
            }
        }
    }

    public static void e(JSONArray jSONArray, ForumManageModel forumManageModel, ThreadData threadData, boolean z) {
        Interceptable interceptable = $ic;
        if (!(interceptable == null || interceptable.invokeCommon(InputDeviceCompat.SOURCE_TRACKBALL, null, new Object[]{jSONArray, forumManageModel, threadData, Boolean.valueOf(z)}) == null) || forumManageModel == null || threadData == null || threadData.getAuthor() == null) {
            return;
        }
        String userId = threadData.getAuthor().getUserId();
        String id = threadData.getId();
        String forum_name = threadData.getForum_name();
        String valueOf = String.valueOf(threadData.getFid());
        boolean isCurrentAccount = UtilHelper.isCurrentAccount(userId);
        if (jSONArray != null) {
            forumManageModel.U(StringHelper.JsonArrayToString(jSONArray));
        }
        forumManageModel.V(valueOf, forum_name, id, null, 0, 1, isCurrentAccount, threadData.getBaijiahaoData(), z);
    }
}
