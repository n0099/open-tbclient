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
import com.baidu.tieba.ao5;
import com.baidu.tieba.do5;
import com.baidu.tieba.tbadkCore.model.ForumManageModel;
import com.baidu.titan.sdk.runtime.FieldHolder;
import com.baidu.titan.sdk.runtime.InitContext;
import com.baidu.titan.sdk.runtime.Interceptable;
import com.baidu.titan.sdk.runtime.TitanRuntime;
import java.util.List;
import org.json.JSONArray;
/* loaded from: classes6.dex */
public class yn5 {
    public static /* synthetic */ Interceptable $ic;
    public transient /* synthetic */ FieldHolder $fh;

    /* loaded from: classes6.dex */
    public static class a implements do5.h {
        public static /* synthetic */ Interceptable $ic;
        public transient /* synthetic */ FieldHolder $fh;
        public final /* synthetic */ TbPageContext a;
        public final /* synthetic */ bo5 b;
        public final /* synthetic */ boolean c;

        public a(TbPageContext tbPageContext, bo5 bo5Var, boolean z) {
            Interceptable interceptable = $ic;
            if (interceptable != null) {
                InitContext newInitContext = TitanRuntime.newInitContext();
                newInitContext.initArgs = r2;
                Object[] objArr = {tbPageContext, bo5Var, Boolean.valueOf(z)};
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
            this.b = bo5Var;
            this.c = z;
        }

        @Override // com.baidu.tieba.do5.h
        public void a(JSONArray jSONArray) {
            Interceptable interceptable = $ic;
            if (interceptable == null || interceptable.invokeL(1048576, this, jSONArray) == null) {
                if (BdNetTypeUtil.isNetworkAvailableForImmediately()) {
                    yn5.e(jSONArray, this.b.a(), this.b.b(), this.c);
                } else {
                    ej.M(this.a.getContext(), R.string.obfuscated_res_0x7f0f0c59);
                }
            }
        }
    }

    /* loaded from: classes6.dex */
    public static class b implements ao5.g {
        public static /* synthetic */ Interceptable $ic;
        public transient /* synthetic */ FieldHolder $fh;
        public final /* synthetic */ TbPageContext a;
        public final /* synthetic */ bo5 b;
        public final /* synthetic */ boolean c;

        public b(TbPageContext tbPageContext, bo5 bo5Var, boolean z) {
            Interceptable interceptable = $ic;
            if (interceptable != null) {
                InitContext newInitContext = TitanRuntime.newInitContext();
                newInitContext.initArgs = r2;
                Object[] objArr = {tbPageContext, bo5Var, Boolean.valueOf(z)};
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
            this.b = bo5Var;
            this.c = z;
        }

        @Override // com.baidu.tieba.ao5.g
        public void a(JSONArray jSONArray) {
            Interceptable interceptable = $ic;
            if (interceptable == null || interceptable.invokeL(1048576, this, jSONArray) == null) {
                if (BdNetTypeUtil.isNetworkAvailableForImmediately()) {
                    yn5.e(jSONArray, this.b.a(), this.b.b(), this.c);
                } else {
                    ej.M(this.a.getContext(), R.string.obfuscated_res_0x7f0f0c59);
                }
            }
        }
    }

    public static void b(TbPageContext tbPageContext, bo5 bo5Var) {
        Interceptable interceptable = $ic;
        if (!(interceptable == null || interceptable.invokeLL(65537, null, tbPageContext, bo5Var) == null) || tbPageContext == null || tbPageContext.getPageActivity() == null || tbPageContext.getPageActivity().getWindow() == null) {
            return;
        }
        boolean z = bo5Var.getType() == 3;
        ao5 ao5Var = new ao5(tbPageContext, tbPageContext.getPageActivity().getWindow().getDecorView());
        if (bo5Var != null) {
            ao5Var.w(z);
        }
        AntiData c = ug6.f().c();
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
        List<ThreadData> g = ug6.f().g();
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
        vs4 vs4Var = new vs4();
        vs4Var.j(sparseArray);
        if (bo5Var != null) {
            vs4Var.i(bo5Var.getType());
        }
        vs4Var.p(jSONArray);
        vs4Var.m(jSONArray2);
        vs4Var.l(ug6.f().d());
        ao5Var.x(vs4Var);
        ao5Var.y(new String[]{TbadkCoreApplication.getInst().getString(R.string.obfuscated_res_0x7f0f04c4), TbadkCoreApplication.getInst().getString(R.string.obfuscated_res_0x7f0f04c5), TbadkCoreApplication.getInst().getString(R.string.obfuscated_res_0x7f0f04c6), TbadkCoreApplication.getInst().getString(R.string.obfuscated_res_0x7f0f04c7), TbadkCoreApplication.getInst().getString(R.string.obfuscated_res_0x7f0f04c8)});
        ao5Var.A("1");
        ao5Var.z(new b(tbPageContext, bo5Var, z));
    }

    public static void c(TbPageContext tbPageContext, bo5 bo5Var, co5 co5Var, UserData userData) {
        Interceptable interceptable = $ic;
        if (!(interceptable == null || interceptable.invokeLLLL(65538, null, tbPageContext, bo5Var, co5Var, userData) == null) || tbPageContext == null || tbPageContext.getPageActivity() == null || tbPageContext.getPageActivity().getWindow() == null) {
            return;
        }
        boolean z = bo5Var.getType() == 3;
        do5 do5Var = new do5(tbPageContext, tbPageContext.getPageActivity().getWindow().getDecorView(), co5Var, userData);
        if (bo5Var != null) {
            do5Var.C(z);
        }
        AntiData c = ug6.f().c();
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
        List<ThreadData> g = ug6.f().g();
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
        vs4 vs4Var = new vs4();
        vs4Var.j(sparseArray);
        if (bo5Var != null) {
            vs4Var.i(bo5Var.getType());
        }
        vs4Var.p(jSONArray);
        vs4Var.m(jSONArray2);
        vs4Var.l(ug6.f().d());
        do5Var.D(vs4Var);
        do5Var.E(new String[]{TbadkCoreApplication.getInst().getString(R.string.obfuscated_res_0x7f0f04bf), TbadkCoreApplication.getInst().getString(R.string.obfuscated_res_0x7f0f04c0), TbadkCoreApplication.getInst().getString(R.string.obfuscated_res_0x7f0f04c1), TbadkCoreApplication.getInst().getString(R.string.obfuscated_res_0x7f0f04c2), TbadkCoreApplication.getInst().getString(R.string.obfuscated_res_0x7f0f04c3)});
        do5Var.G("1");
        do5Var.F(new a(tbPageContext, bo5Var, z));
    }

    public static void d(int i, TbPageContext tbPageContext, bo5 bo5Var, co5 co5Var, UserData userData) {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeCommon(65539, null, new Object[]{Integer.valueOf(i), tbPageContext, bo5Var, co5Var, userData}) == null) {
            if (1 == i) {
                c(tbPageContext, bo5Var, co5Var, userData);
            } else {
                b(tbPageContext, bo5Var);
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
