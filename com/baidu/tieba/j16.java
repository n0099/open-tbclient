package com.baidu.tieba;

import android.text.TextUtils;
import android.util.SparseArray;
import androidx.core.view.InputDeviceCompat;
import com.baidu.adp.lib.util.BdNetTypeUtil;
import com.baidu.adp.lib.util.BdUtilHelper;
import com.baidu.tbadk.TbPageContext;
import com.baidu.tbadk.core.TbadkCoreApplication;
import com.baidu.tbadk.core.data.AntiData;
import com.baidu.tbadk.core.data.DeleteThreadInfo;
import com.baidu.tbadk.core.data.NegativeFeedBackData;
import com.baidu.tbadk.core.data.ThreadData;
import com.baidu.tbadk.core.data.UserData;
import com.baidu.tbadk.core.util.StringHelper;
import com.baidu.tbadk.core.util.UtilHelper;
import com.baidu.tieba.l16;
import com.baidu.tieba.o16;
import com.baidu.tieba.tbadkCore.model.ForumManageModel;
import com.baidu.titan.sdk.runtime.FieldHolder;
import com.baidu.titan.sdk.runtime.InitContext;
import com.baidu.titan.sdk.runtime.Interceptable;
import com.baidu.titan.sdk.runtime.TitanRuntime;
import java.util.List;
import org.json.JSONArray;
/* loaded from: classes6.dex */
public class j16 {
    public static /* synthetic */ Interceptable $ic;
    public transient /* synthetic */ FieldHolder $fh;

    /* loaded from: classes6.dex */
    public class a implements o16.i {
        public static /* synthetic */ Interceptable $ic;
        public transient /* synthetic */ FieldHolder $fh;
        public final /* synthetic */ TbPageContext a;
        public final /* synthetic */ m16 b;
        public final /* synthetic */ boolean c;

        public a(TbPageContext tbPageContext, m16 m16Var, boolean z) {
            Interceptable interceptable = $ic;
            if (interceptable != null) {
                InitContext newInitContext = TitanRuntime.newInitContext();
                newInitContext.initArgs = r2;
                Object[] objArr = {tbPageContext, m16Var, Boolean.valueOf(z)};
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
            this.b = m16Var;
            this.c = z;
        }

        @Override // com.baidu.tieba.o16.i
        public void a(JSONArray jSONArray) {
            Interceptable interceptable = $ic;
            if (interceptable == null || interceptable.invokeL(1048576, this, jSONArray) == null) {
                if (BdNetTypeUtil.isNetworkAvailableForImmediately()) {
                    j16.e(jSONArray, this.b.b(), this.b.c(), this.c);
                } else {
                    BdUtilHelper.showToast(this.a.getContext(), (int) R.string.obfuscated_res_0x7f0f0e70);
                }
            }
        }
    }

    /* loaded from: classes6.dex */
    public class b implements l16.h {
        public static /* synthetic */ Interceptable $ic;
        public transient /* synthetic */ FieldHolder $fh;
        public final /* synthetic */ TbPageContext a;
        public final /* synthetic */ m16 b;
        public final /* synthetic */ boolean c;

        public b(TbPageContext tbPageContext, m16 m16Var, boolean z) {
            Interceptable interceptable = $ic;
            if (interceptable != null) {
                InitContext newInitContext = TitanRuntime.newInitContext();
                newInitContext.initArgs = r2;
                Object[] objArr = {tbPageContext, m16Var, Boolean.valueOf(z)};
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
            this.b = m16Var;
            this.c = z;
        }

        @Override // com.baidu.tieba.l16.h
        public void a(JSONArray jSONArray) {
            Interceptable interceptable = $ic;
            if (interceptable == null || interceptable.invokeL(1048576, this, jSONArray) == null) {
                if (BdNetTypeUtil.isNetworkAvailableForImmediately()) {
                    j16.e(jSONArray, this.b.b(), this.b.c(), this.c);
                } else {
                    BdUtilHelper.showToast(this.a.getContext(), (int) R.string.obfuscated_res_0x7f0f0e70);
                }
            }
        }
    }

    public static void b(TbPageContext tbPageContext, m16 m16Var) {
        boolean z;
        Interceptable interceptable = $ic;
        if ((interceptable == null || interceptable.invokeLL(65537, null, tbPageContext, m16Var) == null) && tbPageContext != null && tbPageContext.getPageActivity() != null && tbPageContext.getPageActivity().getWindow() != null) {
            if (m16Var.a() == 3) {
                z = true;
            } else {
                z = false;
            }
            l16 l16Var = new l16(tbPageContext, tbPageContext.getPageActivity().getWindow().getDecorView());
            if (m16Var != null) {
                l16Var.z(z);
            }
            AntiData c = xr7.f().c();
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
            List<ThreadData> g = xr7.f().g();
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
            NegativeFeedBackData negativeFeedBackData = new NegativeFeedBackData();
            negativeFeedBackData.setFeedBackReasonMap(sparseArray);
            if (m16Var != null) {
                negativeFeedBackData.setDeleteType(m16Var.a());
            }
            negativeFeedBackData.setTidArray(jSONArray);
            negativeFeedBackData.setMaskTidArray(jSONArray2);
            negativeFeedBackData.setFid(xr7.f().d());
            l16Var.A(negativeFeedBackData);
            l16Var.B(new String[]{TbadkCoreApplication.getInst().getString(R.string.delete_thread_reason_1), TbadkCoreApplication.getInst().getString(R.string.delete_thread_reason_2), TbadkCoreApplication.getInst().getString(R.string.delete_thread_reason_3), TbadkCoreApplication.getInst().getString(R.string.delete_thread_reason_4), TbadkCoreApplication.getInst().getString(R.string.delete_thread_reason_5)});
            l16Var.D("1");
            l16Var.C(new b(tbPageContext, m16Var, z));
        }
    }

    public static void c(TbPageContext tbPageContext, m16 m16Var, n16 n16Var, UserData userData) {
        boolean z;
        Interceptable interceptable = $ic;
        if ((interceptable == null || interceptable.invokeLLLL(65538, null, tbPageContext, m16Var, n16Var, userData) == null) && tbPageContext != null && tbPageContext.getPageActivity() != null && tbPageContext.getPageActivity().getWindow() != null) {
            if (m16Var.a() == 3) {
                z = true;
            } else {
                z = false;
            }
            o16 o16Var = new o16(tbPageContext, tbPageContext.getPageActivity().getWindow().getDecorView(), n16Var, userData);
            if (m16Var != null) {
                o16Var.G(z);
            }
            AntiData c = xr7.f().c();
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
            List<ThreadData> g = xr7.f().g();
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
            NegativeFeedBackData negativeFeedBackData = new NegativeFeedBackData();
            negativeFeedBackData.setFeedBackReasonMap(sparseArray);
            if (m16Var != null) {
                negativeFeedBackData.setDeleteType(m16Var.a());
            }
            negativeFeedBackData.setTidArray(jSONArray);
            negativeFeedBackData.setMaskTidArray(jSONArray2);
            negativeFeedBackData.setFid(xr7.f().d());
            o16Var.H(negativeFeedBackData);
            o16Var.I(new String[]{TbadkCoreApplication.getInst().getString(R.string.delete_thread_new_reason_1), TbadkCoreApplication.getInst().getString(R.string.delete_thread_new_reason_2), TbadkCoreApplication.getInst().getString(R.string.delete_thread_new_reason_3), TbadkCoreApplication.getInst().getString(R.string.delete_thread_new_reason_4), TbadkCoreApplication.getInst().getString(R.string.delete_thread_new_reason_5)});
            o16Var.K("1");
            o16Var.J(new a(tbPageContext, m16Var, z));
        }
    }

    public static void d(int i, TbPageContext tbPageContext, m16 m16Var, n16 n16Var, UserData userData) {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeCommon(65539, null, new Object[]{Integer.valueOf(i), tbPageContext, m16Var, n16Var, userData}) == null) {
            if (1 == i) {
                c(tbPageContext, m16Var, n16Var, userData);
            } else {
                b(tbPageContext, m16Var);
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
                forumManageModel.j0(StringHelper.JsonArrayToString(jSONArray));
            }
            forumManageModel.k0(valueOf, forum_name, id, null, 0, 1, isCurrentAccount, threadData.getBaijiahaoData(), z);
        }
    }
}
