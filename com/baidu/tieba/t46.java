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
import com.baidu.tieba.tbadkCore.model.ForumManageModel;
import com.baidu.tieba.v46;
import com.baidu.tieba.y46;
import com.baidu.titan.sdk.runtime.FieldHolder;
import com.baidu.titan.sdk.runtime.InitContext;
import com.baidu.titan.sdk.runtime.Interceptable;
import com.baidu.titan.sdk.runtime.TitanRuntime;
import java.util.List;
import org.json.JSONArray;
/* loaded from: classes8.dex */
public class t46 {
    public static /* synthetic */ Interceptable $ic;
    public transient /* synthetic */ FieldHolder $fh;

    /* loaded from: classes8.dex */
    public class a implements y46.i {
        public static /* synthetic */ Interceptable $ic;
        public transient /* synthetic */ FieldHolder $fh;
        public final /* synthetic */ TbPageContext a;
        public final /* synthetic */ w46 b;
        public final /* synthetic */ boolean c;

        public a(TbPageContext tbPageContext, w46 w46Var, boolean z) {
            Interceptable interceptable = $ic;
            if (interceptable != null) {
                InitContext newInitContext = TitanRuntime.newInitContext();
                newInitContext.initArgs = r2;
                Object[] objArr = {tbPageContext, w46Var, Boolean.valueOf(z)};
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
            this.b = w46Var;
            this.c = z;
        }

        @Override // com.baidu.tieba.y46.i
        public void a(JSONArray jSONArray) {
            Interceptable interceptable = $ic;
            if (interceptable == null || interceptable.invokeL(1048576, this, jSONArray) == null) {
                if (BdNetTypeUtil.isNetworkAvailableForImmediately()) {
                    t46.e(jSONArray, this.b.a(), this.b.b(), this.c);
                } else {
                    BdUtilHelper.showToast(this.a.getContext(), (int) R.string.obfuscated_res_0x7f0f0e40);
                }
            }
        }
    }

    /* loaded from: classes8.dex */
    public class b implements v46.h {
        public static /* synthetic */ Interceptable $ic;
        public transient /* synthetic */ FieldHolder $fh;
        public final /* synthetic */ TbPageContext a;
        public final /* synthetic */ w46 b;
        public final /* synthetic */ boolean c;

        public b(TbPageContext tbPageContext, w46 w46Var, boolean z) {
            Interceptable interceptable = $ic;
            if (interceptable != null) {
                InitContext newInitContext = TitanRuntime.newInitContext();
                newInitContext.initArgs = r2;
                Object[] objArr = {tbPageContext, w46Var, Boolean.valueOf(z)};
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
            this.b = w46Var;
            this.c = z;
        }

        @Override // com.baidu.tieba.v46.h
        public void a(JSONArray jSONArray) {
            Interceptable interceptable = $ic;
            if (interceptable == null || interceptable.invokeL(1048576, this, jSONArray) == null) {
                if (BdNetTypeUtil.isNetworkAvailableForImmediately()) {
                    t46.e(jSONArray, this.b.a(), this.b.b(), this.c);
                } else {
                    BdUtilHelper.showToast(this.a.getContext(), (int) R.string.obfuscated_res_0x7f0f0e40);
                }
            }
        }
    }

    public static void b(TbPageContext tbPageContext, w46 w46Var) {
        boolean z;
        Interceptable interceptable = $ic;
        if ((interceptable == null || interceptable.invokeLL(65537, null, tbPageContext, w46Var) == null) && tbPageContext != null && tbPageContext.getPageActivity() != null && tbPageContext.getPageActivity().getWindow() != null) {
            if (w46Var.getType() == 3) {
                z = true;
            } else {
                z = false;
            }
            v46 v46Var = new v46(tbPageContext, tbPageContext.getPageActivity().getWindow().getDecorView());
            if (w46Var != null) {
                v46Var.z(z);
            }
            AntiData c = wh7.f().c();
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
            List<ThreadData> g = wh7.f().g();
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
            if (w46Var != null) {
                negativeFeedBackData.setDeleteType(w46Var.getType());
            }
            negativeFeedBackData.setTidArray(jSONArray);
            negativeFeedBackData.setMaskTidArray(jSONArray2);
            negativeFeedBackData.setFid(wh7.f().d());
            v46Var.A(negativeFeedBackData);
            v46Var.B(new String[]{TbadkCoreApplication.getInst().getString(R.string.delete_thread_reason_1), TbadkCoreApplication.getInst().getString(R.string.delete_thread_reason_2), TbadkCoreApplication.getInst().getString(R.string.delete_thread_reason_3), TbadkCoreApplication.getInst().getString(R.string.delete_thread_reason_4), TbadkCoreApplication.getInst().getString(R.string.delete_thread_reason_5)});
            v46Var.D("1");
            v46Var.C(new b(tbPageContext, w46Var, z));
        }
    }

    public static void c(TbPageContext tbPageContext, w46 w46Var, x46 x46Var, UserData userData) {
        boolean z;
        Interceptable interceptable = $ic;
        if ((interceptable == null || interceptable.invokeLLLL(65538, null, tbPageContext, w46Var, x46Var, userData) == null) && tbPageContext != null && tbPageContext.getPageActivity() != null && tbPageContext.getPageActivity().getWindow() != null) {
            if (w46Var.getType() == 3) {
                z = true;
            } else {
                z = false;
            }
            y46 y46Var = new y46(tbPageContext, tbPageContext.getPageActivity().getWindow().getDecorView(), x46Var, userData);
            if (w46Var != null) {
                y46Var.F(z);
            }
            AntiData c = wh7.f().c();
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
            List<ThreadData> g = wh7.f().g();
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
            if (w46Var != null) {
                negativeFeedBackData.setDeleteType(w46Var.getType());
            }
            negativeFeedBackData.setTidArray(jSONArray);
            negativeFeedBackData.setMaskTidArray(jSONArray2);
            negativeFeedBackData.setFid(wh7.f().d());
            y46Var.G(negativeFeedBackData);
            y46Var.H(new String[]{TbadkCoreApplication.getInst().getString(R.string.delete_thread_new_reason_1), TbadkCoreApplication.getInst().getString(R.string.delete_thread_new_reason_2), TbadkCoreApplication.getInst().getString(R.string.delete_thread_new_reason_3), TbadkCoreApplication.getInst().getString(R.string.delete_thread_new_reason_4), TbadkCoreApplication.getInst().getString(R.string.delete_thread_new_reason_5)});
            y46Var.J("1");
            y46Var.I(new a(tbPageContext, w46Var, z));
        }
    }

    public static void d(int i, TbPageContext tbPageContext, w46 w46Var, x46 x46Var, UserData userData) {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeCommon(65539, null, new Object[]{Integer.valueOf(i), tbPageContext, w46Var, x46Var, userData}) == null) {
            if (1 == i) {
                c(tbPageContext, w46Var, x46Var, userData);
            } else {
                b(tbPageContext, w46Var);
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
                forumManageModel.h0(StringHelper.JsonArrayToString(jSONArray));
            }
            forumManageModel.i0(valueOf, forum_name, id, null, 0, 1, isCurrentAccount, threadData.getBaijiahaoData(), z);
        }
    }
}
