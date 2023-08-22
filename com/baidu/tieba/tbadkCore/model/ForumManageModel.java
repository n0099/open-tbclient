package com.baidu.tieba.tbadkCore.model;

import androidx.annotation.NonNull;
import androidx.core.view.InputDeviceCompat;
import com.baidu.adp.BdUniqueId;
import com.baidu.adp.base.BdBaseModel;
import com.baidu.adp.base.BdPageContext;
import com.baidu.adp.lib.asyncTask.BdAsyncTask;
import com.baidu.adp.lib.util.BdLog;
import com.baidu.android.imsdk.internal.Constants;
import com.baidu.searchbox.download.constants.DownloadStatisticConstants;
import com.baidu.tbadk.TbConfig;
import com.baidu.tbadk.TbPageContext;
import com.baidu.tbadk.core.BaseFragmentActivity;
import com.baidu.tbadk.core.TbadkCoreApplication;
import com.baidu.tbadk.core.data.BaijiahaoData;
import com.baidu.tbadk.core.data.ThreadData;
import com.baidu.tbadk.core.util.NetWork;
import com.baidu.tbadk.core.util.TiebaStatic;
import com.baidu.tbadk.module.pb.BarManageResultListener;
import com.baidu.tieba.m25;
import com.baidu.titan.sdk.runtime.ClassClinitInterceptable;
import com.baidu.titan.sdk.runtime.ClassClinitInterceptorStorage;
import com.baidu.titan.sdk.runtime.FieldHolder;
import com.baidu.titan.sdk.runtime.InitContext;
import com.baidu.titan.sdk.runtime.InterceptResult;
import com.baidu.titan.sdk.runtime.Interceptable;
import com.baidu.titan.sdk.runtime.TitanRuntime;
import java.util.ArrayList;
import org.json.JSONArray;
import org.json.JSONObject;
/* loaded from: classes8.dex */
public class ForumManageModel extends BdBaseModel {
    public static /* synthetic */ Interceptable $ic = null;
    public static final int CANCEL_GOOD = 3;
    public static final int CANCEL_TOP = 5;
    public static final int COMMIT_GOOD = 2;
    public static final int COMMIT_TOP = 4;
    public static final int DEL_POST = 0;
    public static final int DEL_TYPE_FLOOR = 2;
    public static final int DEL_TYPE_POST = 1;
    public static final int DEL_TYPE_STORY = 3;
    public static final int DEL_TYPE_THREAD = 0;
    public static final int ERROR_CODE_PHOTO_LIVE_FORUM_LOCK = 224014;
    public static final int FORBID_USER = 1;
    public static final int GET_GOOD_LIST = 6;
    public static final int INTENT_TYPE_NONE = -1;
    public static final BdUniqueId UNIQUE_ID_DEL_POST_TASK;
    public transient /* synthetic */ FieldHolder $fh;
    public a a;
    public c b;
    public f c;
    public String d;
    public boolean e;
    public String f;
    public int g;
    public int h;
    public String i;
    public String j;
    public int k;

    /* loaded from: classes8.dex */
    public class c extends BdAsyncTask<String, Integer, String> {
        public static /* synthetic */ Interceptable $ic;
        public transient /* synthetic */ FieldHolder $fh;
    }

    /* loaded from: classes8.dex */
    public class d {
        public static /* synthetic */ Interceptable $ic;
        public transient /* synthetic */ FieldHolder $fh;
        public boolean a;
        public String b;
    }

    @Override // com.baidu.adp.base.BdBaseModel
    public boolean loadData() {
        InterceptResult invokeV;
        Interceptable interceptable = $ic;
        if (interceptable == null || (invokeV = interceptable.invokeV(1048585, this)) == null) {
            return false;
        }
        return invokeV.booleanValue;
    }

    /* loaded from: classes8.dex */
    public class a extends BdAsyncTask<String, Integer, Boolean> {
        public static /* synthetic */ Interceptable $ic;
        public transient /* synthetic */ FieldHolder $fh;
        public NetWork a;
        public String b;
        public String c;
        public String d;
        public String e;
        public int f;
        public int g;
        public boolean h;
        public String i;
        public BaijiahaoData j;
        public boolean k;
        public final /* synthetic */ ForumManageModel l;

        public a(ForumManageModel forumManageModel, String str, String str2, String str3, String str4, int i, int i2, boolean z, BaijiahaoData baijiahaoData, boolean z2) {
            Interceptable interceptable = $ic;
            if (interceptable != null) {
                InitContext newInitContext = TitanRuntime.newInitContext();
                newInitContext.initArgs = r2;
                Object[] objArr = {forumManageModel, str, str2, str3, str4, Integer.valueOf(i), Integer.valueOf(i2), Boolean.valueOf(z), baijiahaoData, Boolean.valueOf(z2)};
                interceptable.invokeUnInit(65536, newInitContext);
                int i3 = newInitContext.flag;
                if ((i3 & 1) != 0) {
                    int i4 = i3 & 2;
                    newInitContext.thisArg = this;
                    interceptable.invokeInitBody(65536, newInitContext);
                    return;
                }
            }
            this.l = forumManageModel;
            this.a = null;
            this.b = str;
            this.c = str2;
            this.d = str3;
            this.e = str4;
            this.f = i;
            this.g = i2;
            this.h = z;
            this.i = forumManageModel.f0();
            this.j = baijiahaoData;
            this.k = z2;
        }

        /* JADX DEBUG: Method merged with bridge method */
        @Override // com.baidu.adp.lib.asyncTask.BdAsyncTask
        /* renamed from: b */
        public Boolean doInBackground(String... strArr) {
            InterceptResult invokeL;
            String str;
            Interceptable interceptable = $ic;
            if (interceptable == null || (invokeL = interceptable.invokeL(1048576, this, strArr)) == null) {
                String str2 = TbConfig.SERVER_ADDRESS;
                int i = this.f;
                if (i != 0 && i != 3) {
                    str = str2 + TbConfig.DEL_POST_ADDRESS;
                } else {
                    str = str2 + TbConfig.DEL_THREAD_ADDRESS;
                }
                NetWork netWork = new NetWork(str);
                this.a = netWork;
                netWork.addPostData("fid", this.b);
                this.a.addPostData(DownloadStatisticConstants.UBC_VALUE_WORD, this.c);
                this.a.addPostData("z", this.d);
                String str3 = this.i;
                if (str3 != null) {
                    this.a.addPostData("reason", str3);
                }
                int i2 = this.f;
                if (i2 == 0) {
                    if (this.g == 0) {
                        this.a.addPostData("delete_my_thread", "1");
                    }
                } else if (i2 == 1) {
                    this.a.addPostData("pid", this.e);
                    this.a.addPostData("isfloor", "0");
                    this.a.addPostData("src", "1");
                    if (this.g == 0 && this.h) {
                        this.a.addPostData("delete_my_post", "1");
                    }
                } else if (i2 == 2) {
                    this.a.addPostData("pid", this.e);
                    this.a.addPostData("isfloor", "1");
                    this.a.addPostData("src", "3");
                    if (this.g == 0 && this.h) {
                        this.a.addPostData("delete_my_post", "1");
                    }
                } else if (i2 == 3) {
                    this.a.addPostData("delete_my_thread", "1");
                    this.a.addPostData("is_story", "1");
                }
                if (this.g == 0 && !this.h) {
                    this.a.addPostData("is_vipdel", "1");
                } else {
                    this.a.addPostData("is_vipdel", "0");
                }
                if (this.f != 0 || !this.l.e) {
                    BaijiahaoData baijiahaoData = this.j;
                    if (baijiahaoData != null) {
                        this.a.addPostData("ori_ugc_nid", baijiahaoData.oriUgcNid);
                        this.a.addPostData("ori_ugc_tid", this.j.oriUgcTid);
                        this.a.addPostData(TiebaStatic.Params.UGC_TYPE, String.valueOf(this.j.oriUgcType));
                        this.a.addPostData("ori_ugc_vid", this.j.oriUgcVid);
                        this.a.addPostData("owner_uid", TbadkCoreApplication.getCurrentAccount());
                    }
                } else {
                    this.l.e = false;
                    this.a.addPostData("ori_ugc_nid", this.l.f);
                    this.a.addPostData("thread_type", String.valueOf(this.l.g));
                    this.a.addPostData(TiebaStatic.Params.UGC_TYPE, String.valueOf(this.l.h));
                    this.a.addPostData("owner_uid", this.l.i);
                    this.a.addPostData("ori_ugc_vid", this.l.j);
                    this.a.addPostData("video_type", String.valueOf(this.l.k));
                }
                if (this.k) {
                    this.a.addPostData("is_frs_mask", "1");
                }
                this.a.getNetContext().getRequest().mIsNeedTbs = true;
                this.a.postNetData();
                if (this.a.getNetContext().getResponse().isRequestSuccess()) {
                    return Boolean.TRUE;
                }
                return Boolean.FALSE;
            }
            return (Boolean) invokeL.objValue;
        }

        @Override // com.baidu.adp.lib.asyncTask.BdAsyncTask
        public void cancel() {
            Interceptable interceptable = $ic;
            if (interceptable == null || interceptable.invokeV(Constants.METHOD_GET_CONTACTER_INFO_FOR_SESSION, this) == null) {
                NetWork netWork = this.a;
                if (netWork != null) {
                    netWork.cancelNetConnect();
                }
                this.l.a = null;
                super.cancel(true);
                this.l.mLoadDataCallBack.c(null);
            }
        }

        /* JADX DEBUG: Method merged with bridge method */
        @Override // com.baidu.adp.lib.asyncTask.BdAsyncTask
        public void onPostExecute(Boolean bool) {
            Interceptable interceptable = $ic;
            if (interceptable == null || interceptable.invokeL(1048579, this, bool) == null) {
                super.onPostExecute((a) bool);
                this.l.a = null;
                if (this.a != null && bool != null) {
                    b bVar = new b(this.l);
                    bVar.d = this.f;
                    bVar.g = this.e;
                    bVar.f = this.h;
                    bVar.e = this.g;
                    bVar.b = this.a.getErrorString();
                    bVar.c = this.a.getServerErrorCode();
                    bVar.a = bool.booleanValue();
                    bVar.h = this.k;
                    this.l.mLoadDataCallBack.c(bVar);
                    return;
                }
                this.l.mLoadDataCallBack.c(null);
            }
        }
    }

    /* loaded from: classes8.dex */
    public class b {
        public static /* synthetic */ Interceptable $ic;
        public transient /* synthetic */ FieldHolder $fh;
        public boolean a;
        public String b;
        public int c;
        public int d;
        public int e;
        public boolean f;
        public String g;
        public boolean h;

        public b(ForumManageModel forumManageModel) {
            Interceptable interceptable = $ic;
            if (interceptable != null) {
                InitContext newInitContext = TitanRuntime.newInitContext();
                newInitContext.initArgs = r2;
                Object[] objArr = {forumManageModel};
                interceptable.invokeUnInit(65536, newInitContext);
                int i = newInitContext.flag;
                if ((i & 1) != 0) {
                    int i2 = i & 2;
                    newInitContext.thisArg = this;
                    interceptable.invokeInitBody(65536, newInitContext);
                }
            }
        }
    }

    /* loaded from: classes8.dex */
    public static class e {
        public static /* synthetic */ Interceptable $ic;
        public transient /* synthetic */ FieldHolder $fh;
        public String a;
        public String b;
        public String c;
        public int d;

        public e() {
            Interceptable interceptable = $ic;
            if (interceptable != null) {
                InitContext newInitContext = TitanRuntime.newInitContext();
                interceptable.invokeUnInit(65536, newInitContext);
                int i = newInitContext.flag;
                if ((i & 1) != 0) {
                    int i2 = i & 2;
                    newInitContext.thisArg = this;
                    interceptable.invokeInitBody(65536, newInitContext);
                }
            }
        }
    }

    /* loaded from: classes8.dex */
    public class f extends BdAsyncTask<String, String, Boolean> {
        public static /* synthetic */ Interceptable $ic;
        public transient /* synthetic */ FieldHolder $fh;
        public NetWork a;
        public String b;
        public String c;
        public String d;
        public int e;
        public ArrayList<m25> f;
        public String g;
        public final /* synthetic */ ForumManageModel h;

        public f(ForumManageModel forumManageModel, String str, String str2, String str3, int i, String str4) {
            Interceptable interceptable = $ic;
            if (interceptable != null) {
                InitContext newInitContext = TitanRuntime.newInitContext();
                newInitContext.initArgs = r2;
                Object[] objArr = {forumManageModel, str, str2, str3, Integer.valueOf(i), str4};
                interceptable.invokeUnInit(65536, newInitContext);
                int i2 = newInitContext.flag;
                if ((i2 & 1) != 0) {
                    int i3 = i2 & 2;
                    newInitContext.thisArg = this;
                    interceptable.invokeInitBody(65536, newInitContext);
                    return;
                }
            }
            this.h = forumManageModel;
            this.a = null;
            this.f = null;
            this.g = null;
            this.b = str;
            this.c = str2;
            this.d = str3;
            this.e = i;
            this.g = str4;
            this.f = new ArrayList<>();
        }

        /* JADX DEBUG: Method merged with bridge method */
        @Override // com.baidu.adp.lib.asyncTask.BdAsyncTask
        /* renamed from: b */
        public Boolean doInBackground(String... strArr) {
            InterceptResult invokeL;
            Interceptable interceptable = $ic;
            if (interceptable == null || (invokeL = interceptable.invokeL(1048576, this, strArr)) == null) {
                NetWork netWork = new NetWork(strArr[0]);
                this.a = netWork;
                netWork.addPostData(DownloadStatisticConstants.UBC_VALUE_WORD, this.c);
                if (this.e != 6) {
                    this.a.addPostData("fid", this.b);
                    this.a.addPostData("z", this.d);
                    int i = this.e;
                    if (i == 4) {
                        this.a.addPostData("ntn", "set");
                    } else if (i == 5) {
                        this.a.addPostData("ntn", "");
                    } else if (i == 2) {
                        this.a.addPostData("ntn", "set");
                        this.a.addPostData("cid", this.g);
                    } else {
                        this.a.addPostData("ntn", "");
                    }
                    this.a.addPostData("name_show", TbadkCoreApplication.getCurrentAccountNameShow());
                }
                this.a.getNetContext().getRequest().mIsNeedTbs = true;
                String postNetData = this.a.postNetData();
                if (this.a.getNetContext().getResponse().isRequestSuccess()) {
                    if (this.e == 6) {
                        try {
                            JSONArray optJSONArray = new JSONObject(postNetData).optJSONArray("cates");
                            for (int i2 = 0; i2 < optJSONArray.length(); i2++) {
                                m25 m25Var = new m25();
                                m25Var.c(optJSONArray.optJSONObject(i2));
                                this.f.add(m25Var);
                            }
                        } catch (Exception e) {
                            BdLog.e(e.getMessage());
                            return Boolean.FALSE;
                        }
                    }
                    return Boolean.TRUE;
                }
                return Boolean.FALSE;
            }
            return (Boolean) invokeL.objValue;
        }

        @Override // com.baidu.adp.lib.asyncTask.BdAsyncTask
        public void cancel() {
            Interceptable interceptable = $ic;
            if (interceptable == null || interceptable.invokeV(Constants.METHOD_GET_CONTACTER_INFO_FOR_SESSION, this) == null) {
                NetWork netWork = this.a;
                if (netWork != null) {
                    netWork.cancelNetConnect();
                }
                this.h.c = null;
                super.cancel(true);
                this.h.mLoadDataCallBack.c(null);
            }
        }

        /* JADX DEBUG: Method merged with bridge method */
        @Override // com.baidu.adp.lib.asyncTask.BdAsyncTask
        public void onPostExecute(Boolean bool) {
            Interceptable interceptable = $ic;
            if (interceptable == null || interceptable.invokeL(1048579, this, bool) == null) {
                super.onPostExecute((f) bool);
                this.h.c = null;
                if (this.a == null) {
                    this.h.mLoadDataCallBack.c(null);
                    return;
                }
                g gVar = new g(this.h);
                gVar.a = bool.booleanValue();
                if (bool.booleanValue()) {
                    if (this.e == 6) {
                        gVar.c = this.f;
                    }
                } else {
                    gVar.b = this.a.getErrorString();
                }
                this.h.mLoadDataCallBack.c(gVar);
            }
        }
    }

    /* loaded from: classes8.dex */
    public class g {
        public static /* synthetic */ Interceptable $ic;
        public transient /* synthetic */ FieldHolder $fh;
        public boolean a;
        public String b;
        public ArrayList<m25> c;

        public g(ForumManageModel forumManageModel) {
            Interceptable interceptable = $ic;
            if (interceptable != null) {
                InitContext newInitContext = TitanRuntime.newInitContext();
                newInitContext.initArgs = r2;
                Object[] objArr = {forumManageModel};
                interceptable.invokeUnInit(65536, newInitContext);
                int i = newInitContext.flag;
                if ((i & 1) != 0) {
                    int i2 = i & 2;
                    newInitContext.thisArg = this;
                    interceptable.invokeInitBody(65536, newInitContext);
                }
            }
        }
    }

    static {
        InterceptResult invokeClinit;
        ClassClinitInterceptable classClinitInterceptable = ClassClinitInterceptorStorage.$ic;
        if (classClinitInterceptable != null && (invokeClinit = classClinitInterceptable.invokeClinit(-333179826, "Lcom/baidu/tieba/tbadkCore/model/ForumManageModel;")) != null) {
            Interceptable interceptable = invokeClinit.interceptor;
            if (interceptable != null) {
                $ic = interceptable;
            }
            if ((invokeClinit.flags & 1) != 0) {
                classClinitInterceptable.invokePostClinit(-333179826, "Lcom/baidu/tieba/tbadkCore/model/ForumManageModel;");
                return;
            }
        }
        UNIQUE_ID_DEL_POST_TASK = BdUniqueId.gen();
    }

    @Override // com.baidu.adp.base.BdBaseModel
    public boolean cancelLoadData() {
        InterceptResult invokeV;
        Interceptable interceptable = $ic;
        if (interceptable == null || (invokeV = interceptable.invokeV(1048576, this)) == null) {
            d0();
            return false;
        }
        return invokeV.booleanValue;
    }

    public void d0() {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeV(Constants.METHOD_GET_CONTACTER_INFO_FOR_SESSION, this) == null) {
            a aVar = this.a;
            if (aVar != null) {
                aVar.cancel();
                this.a = null;
            }
            c cVar = this.b;
            if (cVar != null) {
                cVar.cancel();
                this.b = null;
            }
            f fVar = this.c;
            if (fVar != null) {
                fVar.cancel();
                this.c = null;
            }
        }
    }

    public String f0() {
        InterceptResult invokeV;
        Interceptable interceptable = $ic;
        if (interceptable == null || (invokeV = interceptable.invokeV(1048579, this)) == null) {
            return this.d;
        }
        return (String) invokeV.objValue;
    }

    public boolean g0() {
        InterceptResult invokeV;
        Interceptable interceptable = $ic;
        if (interceptable == null || (invokeV = interceptable.invokeV(1048580, this)) == null) {
            if (this.a == null && this.b == null && this.c == null) {
                return false;
            }
            return true;
        }
        return invokeV.booleanValue;
    }

    /* JADX WARN: 'super' call moved to the top of the method (can break code semantics) */
    public ForumManageModel(TbPageContext tbPageContext) {
        super(tbPageContext);
        Interceptable interceptable = $ic;
        if (interceptable != null) {
            InitContext newInitContext = TitanRuntime.newInitContext();
            newInitContext.initArgs = r2;
            Object[] objArr = {tbPageContext};
            interceptable.invokeUnInit(65537, newInitContext);
            int i = newInitContext.flag;
            if ((i & 1) != 0) {
                int i2 = i & 2;
                super((BdPageContext) newInitContext.callArgs[0]);
                newInitContext.thisArg = this;
                interceptable.invokeInitBody(65537, newInitContext);
                return;
            }
        }
        this.a = null;
        this.b = null;
        this.c = null;
        this.e = false;
    }

    /* JADX WARN: 'super' call moved to the top of the method (can break code semantics) */
    public ForumManageModel(BaseFragmentActivity baseFragmentActivity) {
        super(baseFragmentActivity.getPageContext());
        Interceptable interceptable = $ic;
        if (interceptable != null) {
            InitContext newInitContext = TitanRuntime.newInitContext();
            newInitContext.initArgs = r2;
            Object[] objArr = {baseFragmentActivity};
            interceptable.invokeUnInit(65538, newInitContext);
            int i = newInitContext.flag;
            if ((i & 1) != 0) {
                int i2 = i & 2;
                super((BdPageContext) newInitContext.callArgs[0]);
                newInitContext.thisArg = this;
                interceptable.invokeInitBody(65538, newInitContext);
                return;
            }
        }
        this.a = null;
        this.b = null;
        this.c = null;
        this.e = false;
    }

    public void i0(String str) {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeL(1048582, this, str) == null) {
            this.d = str;
        }
    }

    @NonNull
    public BarManageResultListener.a e0(int i, g gVar) {
        InterceptResult invokeIL;
        BarManageResultListener.OptType optType;
        Interceptable interceptable = $ic;
        if (interceptable == null || (invokeIL = interceptable.invokeIL(Constants.METHOD_SEND_USER_MSG, this, i, gVar)) == null) {
            if (i != 2) {
                if (i != 3) {
                    if (i != 4) {
                        if (i == 5) {
                            optType = BarManageResultListener.OptType.CANCEL_TOP;
                        } else {
                            throw new IllegalStateException();
                        }
                    } else {
                        optType = BarManageResultListener.OptType.MAKE_TOP;
                    }
                } else {
                    optType = BarManageResultListener.OptType.CANCEL_GOOD;
                }
            } else {
                optType = BarManageResultListener.OptType.ADD_GOOD;
            }
            return BarManageResultListener.a.a(optType, gVar.a, gVar.b);
        }
        return (BarManageResultListener.a) invokeIL.objValue;
    }

    public void h0(ThreadData threadData) {
        int i;
        Interceptable interceptable = $ic;
        if ((interceptable == null || interceptable.invokeL(1048581, this, threadData) == null) && threadData != null && threadData.getBaijiahaoData() != null) {
            this.e = true;
            this.f = threadData.getBaijiahaoData().oriUgcNid;
            this.h = threadData.getBaijiahaoData().oriUgcType;
            this.j = threadData.getBaijiahaoData().oriUgcVid;
            this.g = threadData.threadType;
            this.i = TbadkCoreApplication.getCurrentAccount();
            if (threadData.getThreadVideoInfo() != null) {
                i = threadData.getThreadVideoInfo().video_type.intValue();
            } else {
                i = 0;
            }
            this.k = i;
        }
    }

    public void j0(String str, String str2, String str3, String str4, int i, int i2, boolean z, BaijiahaoData baijiahaoData, boolean z2) {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeCommon(1048583, this, new Object[]{str, str2, str3, str4, Integer.valueOf(i), Integer.valueOf(i2), Boolean.valueOf(z), baijiahaoData, Boolean.valueOf(z2)}) == null) {
            a aVar = this.a;
            if (aVar != null) {
                aVar.cancel();
                this.a = null;
            }
            this.mLoadDataMode = 0;
            a aVar2 = new a(this, str, str2, str3, str4, i, i2, z, baijiahaoData, z2);
            this.a = aVar2;
            aVar2.setTag(UNIQUE_ID_DEL_POST_TASK);
            this.a.setPriority(2);
            this.a.execute(new String[0]);
        }
    }

    public void k0(String str, String str2, String str3, int i, String str4) {
        String str5;
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeCommon(InputDeviceCompat.SOURCE_TOUCHPAD, this, new Object[]{str, str2, str3, Integer.valueOf(i), str4}) == null) {
            f fVar = this.c;
            if (fVar != null) {
                fVar.cancel();
                this.c = null;
            }
            this.mLoadDataMode = i;
            f fVar2 = new f(this, str, str2, str3, i, str4);
            this.c = fVar2;
            fVar2.setPriority(2);
            String str6 = TbConfig.SERVER_ADDRESS;
            if (i == 6) {
                str5 = str6 + TbConfig.GOOD_LIST_ADDRESS;
            } else if (i != 2 && i != 3) {
                str5 = str6 + TbConfig.COMMIT_TOP_ADDRESS;
            } else {
                str5 = str6 + TbConfig.COMMIT_GOOD_ADDRESS;
            }
            this.c.execute(str5);
        }
    }
}
