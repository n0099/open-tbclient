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
import com.baidu.tieba.tbadkCore.model.ForumManageModel;
import com.baidu.tieba.tp5;
import com.baidu.tieba.wp5;
import com.baidu.titan.sdk.runtime.FieldHolder;
import com.baidu.titan.sdk.runtime.InitContext;
import com.baidu.titan.sdk.runtime.Interceptable;
import com.baidu.titan.sdk.runtime.TitanRuntime;
import java.util.List;
import org.json.JSONArray;
/* loaded from: classes5.dex */
public class rp5 {
    public static /* synthetic */ Interceptable $ic;
    public transient /* synthetic */ FieldHolder $fh;

    /* loaded from: classes5.dex */
    public static class a implements wp5.i {
        public static /* synthetic */ Interceptable $ic;
        public transient /* synthetic */ FieldHolder $fh;
        public final /* synthetic */ TbPageContext a;
        public final /* synthetic */ up5 b;
        public final /* synthetic */ boolean c;

        public a(TbPageContext tbPageContext, up5 up5Var, boolean z) {
            Interceptable interceptable = $ic;
            if (interceptable != null) {
                InitContext newInitContext = TitanRuntime.newInitContext();
                newInitContext.initArgs = r2;
                Object[] objArr = {tbPageContext, up5Var, Boolean.valueOf(z)};
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
            this.b = up5Var;
            this.c = z;
        }

        @Override // com.baidu.tieba.wp5.i
        public void a(JSONArray jSONArray) {
            Interceptable interceptable = $ic;
            if (interceptable == null || interceptable.invokeL(1048576, this, jSONArray) == null) {
                if (BdNetTypeUtil.isNetworkAvailableForImmediately()) {
                    rp5.e(jSONArray, this.b.a(), this.b.b(), this.c);
                } else {
                    yi.O(this.a.getContext(), R.string.obfuscated_res_0x7f0f0c81);
                }
            }
        }
    }

    /* loaded from: classes5.dex */
    public static class b implements tp5.h {
        public static /* synthetic */ Interceptable $ic;
        public transient /* synthetic */ FieldHolder $fh;
        public final /* synthetic */ TbPageContext a;
        public final /* synthetic */ up5 b;
        public final /* synthetic */ boolean c;

        public b(TbPageContext tbPageContext, up5 up5Var, boolean z) {
            Interceptable interceptable = $ic;
            if (interceptable != null) {
                InitContext newInitContext = TitanRuntime.newInitContext();
                newInitContext.initArgs = r2;
                Object[] objArr = {tbPageContext, up5Var, Boolean.valueOf(z)};
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
            this.b = up5Var;
            this.c = z;
        }

        @Override // com.baidu.tieba.tp5.h
        public void a(JSONArray jSONArray) {
            Interceptable interceptable = $ic;
            if (interceptable == null || interceptable.invokeL(1048576, this, jSONArray) == null) {
                if (BdNetTypeUtil.isNetworkAvailableForImmediately()) {
                    rp5.e(jSONArray, this.b.a(), this.b.b(), this.c);
                } else {
                    yi.O(this.a.getContext(), R.string.obfuscated_res_0x7f0f0c81);
                }
            }
        }
    }

    public static void b(TbPageContext tbPageContext, up5 up5Var) {
        boolean z;
        Interceptable interceptable = $ic;
        if ((interceptable == null || interceptable.invokeLL(65537, null, tbPageContext, up5Var) == null) && tbPageContext != null && tbPageContext.getPageActivity() != null && tbPageContext.getPageActivity().getWindow() != null) {
            if (up5Var.getType() == 3) {
                z = true;
            } else {
                z = false;
            }
            tp5 tp5Var = new tp5(tbPageContext, tbPageContext.getPageActivity().getWindow().getDecorView());
            if (up5Var != null) {
                tp5Var.z(z);
            }
            AntiData c = yi6.f().c();
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
            List<ThreadData> g = yi6.f().g();
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
            qt4 qt4Var = new qt4();
            qt4Var.j(sparseArray);
            if (up5Var != null) {
                qt4Var.i(up5Var.getType());
            }
            qt4Var.p(jSONArray);
            qt4Var.m(jSONArray2);
            qt4Var.l(yi6.f().d());
            tp5Var.A(qt4Var);
            tp5Var.B(new String[]{TbadkCoreApplication.getInst().getString(R.string.obfuscated_res_0x7f0f04cf), TbadkCoreApplication.getInst().getString(R.string.obfuscated_res_0x7f0f04d0), TbadkCoreApplication.getInst().getString(R.string.obfuscated_res_0x7f0f04d1), TbadkCoreApplication.getInst().getString(R.string.obfuscated_res_0x7f0f04d2), TbadkCoreApplication.getInst().getString(R.string.obfuscated_res_0x7f0f04d3)});
            tp5Var.D("1");
            tp5Var.C(new b(tbPageContext, up5Var, z));
        }
    }

    public static void c(TbPageContext tbPageContext, up5 up5Var, vp5 vp5Var, UserData userData) {
        boolean z;
        Interceptable interceptable = $ic;
        if ((interceptable == null || interceptable.invokeLLLL(65538, null, tbPageContext, up5Var, vp5Var, userData) == null) && tbPageContext != null && tbPageContext.getPageActivity() != null && tbPageContext.getPageActivity().getWindow() != null) {
            if (up5Var.getType() == 3) {
                z = true;
            } else {
                z = false;
            }
            wp5 wp5Var = new wp5(tbPageContext, tbPageContext.getPageActivity().getWindow().getDecorView(), vp5Var, userData);
            if (up5Var != null) {
                wp5Var.F(z);
            }
            AntiData c = yi6.f().c();
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
            List<ThreadData> g = yi6.f().g();
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
            qt4 qt4Var = new qt4();
            qt4Var.j(sparseArray);
            if (up5Var != null) {
                qt4Var.i(up5Var.getType());
            }
            qt4Var.p(jSONArray);
            qt4Var.m(jSONArray2);
            qt4Var.l(yi6.f().d());
            wp5Var.G(qt4Var);
            wp5Var.H(new String[]{TbadkCoreApplication.getInst().getString(R.string.obfuscated_res_0x7f0f04ca), TbadkCoreApplication.getInst().getString(R.string.obfuscated_res_0x7f0f04cb), TbadkCoreApplication.getInst().getString(R.string.obfuscated_res_0x7f0f04cc), TbadkCoreApplication.getInst().getString(R.string.obfuscated_res_0x7f0f04cd), TbadkCoreApplication.getInst().getString(R.string.obfuscated_res_0x7f0f04ce)});
            wp5Var.J("1");
            wp5Var.I(new a(tbPageContext, up5Var, z));
        }
    }

    public static void d(int i, TbPageContext tbPageContext, up5 up5Var, vp5 vp5Var, UserData userData) {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeCommon(65539, null, new Object[]{Integer.valueOf(i), tbPageContext, up5Var, vp5Var, userData}) == null) {
            if (1 == i) {
                c(tbPageContext, up5Var, vp5Var, userData);
            } else {
                b(tbPageContext, up5Var);
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
                forumManageModel.U(StringHelper.JsonArrayToString(jSONArray));
            }
            forumManageModel.V(valueOf, forum_name, id, null, 0, 1, isCurrentAccount, threadData.getBaijiahaoData(), z);
        }
    }
}
