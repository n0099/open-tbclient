package com.baidu.tieba.tbadkCore.model;

import androidx.core.view.InputDeviceCompat;
import c.a.o0.s.q.c2;
import c.a.o0.s.q.m0;
import com.baidu.adp.BdUniqueId;
import com.baidu.adp.base.BdBaseModel;
import com.baidu.adp.lib.asyncTask.BdAsyncTask;
import com.baidu.adp.lib.util.BdLog;
import com.baidu.android.imsdk.internal.Constants;
import com.baidu.mobads.container.adrequest.IAdRequestParam;
import com.baidu.tbadk.TbConfig;
import com.baidu.tbadk.TbPageContext;
import com.baidu.tbadk.core.BaseFragmentActivity;
import com.baidu.tbadk.core.TbadkCoreApplication;
import com.baidu.tbadk.core.data.BaijiahaoData;
import com.baidu.tbadk.core.util.NetWork;
import com.baidu.tbadk.core.util.TiebaStatic;
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
/* loaded from: classes7.dex */
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

    /* renamed from: e  reason: collision with root package name */
    public a f56784e;

    /* renamed from: f  reason: collision with root package name */
    public c f56785f;

    /* renamed from: g  reason: collision with root package name */
    public f f56786g;

    /* renamed from: h  reason: collision with root package name */
    public String f56787h;

    /* renamed from: i  reason: collision with root package name */
    public boolean f56788i;

    /* renamed from: j  reason: collision with root package name */
    public String f56789j;
    public int k;
    public int l;
    public String m;
    public String n;
    public int o;

    /* loaded from: classes7.dex */
    public class a extends BdAsyncTask<String, Integer, Boolean> {
        public static /* synthetic */ Interceptable $ic;
        public transient /* synthetic */ FieldHolder $fh;

        /* renamed from: a  reason: collision with root package name */
        public NetWork f56790a;

        /* renamed from: b  reason: collision with root package name */
        public String f56791b;

        /* renamed from: c  reason: collision with root package name */
        public String f56792c;

        /* renamed from: d  reason: collision with root package name */
        public String f56793d;

        /* renamed from: e  reason: collision with root package name */
        public String f56794e;

        /* renamed from: f  reason: collision with root package name */
        public int f56795f;

        /* renamed from: g  reason: collision with root package name */
        public int f56796g;

        /* renamed from: h  reason: collision with root package name */
        public boolean f56797h;

        /* renamed from: i  reason: collision with root package name */
        public String f56798i;

        /* renamed from: j  reason: collision with root package name */
        public BaijiahaoData f56799j;
        public boolean k;
        public final /* synthetic */ ForumManageModel l;

        public a(ForumManageModel forumManageModel, String str, String str2, String str3, String str4, int i2, int i3, boolean z, BaijiahaoData baijiahaoData, boolean z2) {
            Interceptable interceptable = $ic;
            if (interceptable != null) {
                InitContext newInitContext = TitanRuntime.newInitContext();
                newInitContext.initArgs = r2;
                Object[] objArr = {forumManageModel, str, str2, str3, str4, Integer.valueOf(i2), Integer.valueOf(i3), Boolean.valueOf(z), baijiahaoData, Boolean.valueOf(z2)};
                interceptable.invokeUnInit(65536, newInitContext);
                int i4 = newInitContext.flag;
                if ((i4 & 1) != 0) {
                    int i5 = i4 & 2;
                    newInitContext.thisArg = this;
                    interceptable.invokeInitBody(65536, newInitContext);
                    return;
                }
            }
            this.l = forumManageModel;
            this.f56790a = null;
            this.f56791b = str;
            this.f56792c = str2;
            this.f56793d = str3;
            this.f56794e = str4;
            this.f56795f = i2;
            this.f56796g = i3;
            this.f56797h = z;
            this.f56798i = forumManageModel.N();
            this.f56799j = baijiahaoData;
            this.k = z2;
        }

        @Override // com.baidu.adp.lib.asyncTask.BdAsyncTask
        public void cancel() {
            Interceptable interceptable = $ic;
            if (interceptable == null || interceptable.invokeV(1048576, this) == null) {
                NetWork netWork = this.f56790a;
                if (netWork != null) {
                    netWork.cancelNetConnect();
                }
                this.l.f56784e = null;
                super.cancel(true);
                this.l.mLoadDataCallBack.c(null);
            }
        }

        /* JADX DEBUG: Method merged with bridge method */
        @Override // com.baidu.adp.lib.asyncTask.BdAsyncTask
        public Boolean doInBackground(String... strArr) {
            InterceptResult invokeL;
            String str;
            Interceptable interceptable = $ic;
            if (interceptable == null || (invokeL = interceptable.invokeL(Constants.METHOD_GET_CONTACTER_INFO_FOR_SESSION, this, strArr)) == null) {
                String str2 = TbConfig.SERVER_ADDRESS;
                int i2 = this.f56795f;
                if (i2 != 0 && i2 != 3) {
                    str = str2 + TbConfig.DEL_POST_ADDRESS;
                } else {
                    str = str2 + TbConfig.DEL_THREAD_ADDRESS;
                }
                NetWork netWork = new NetWork(str);
                this.f56790a = netWork;
                netWork.addPostData("fid", this.f56791b);
                this.f56790a.addPostData("word", this.f56792c);
                this.f56790a.addPostData("z", this.f56793d);
                String str3 = this.f56798i;
                if (str3 != null) {
                    this.f56790a.addPostData("reason", str3);
                }
                int i3 = this.f56795f;
                if (i3 == 0) {
                    if (this.f56796g == 0) {
                        this.f56790a.addPostData("delete_my_thread", "1");
                    }
                } else if (i3 == 1) {
                    this.f56790a.addPostData("pid", this.f56794e);
                    this.f56790a.addPostData("isfloor", "0");
                    this.f56790a.addPostData("src", "1");
                    if (this.f56796g == 0 && this.f56797h) {
                        this.f56790a.addPostData("delete_my_post", "1");
                    }
                } else if (i3 == 2) {
                    this.f56790a.addPostData("pid", this.f56794e);
                    this.f56790a.addPostData("isfloor", "1");
                    this.f56790a.addPostData("src", "3");
                    if (this.f56796g == 0 && this.f56797h) {
                        this.f56790a.addPostData("delete_my_post", "1");
                    }
                } else if (i3 == 3) {
                    this.f56790a.addPostData("delete_my_thread", "1");
                    this.f56790a.addPostData("is_story", "1");
                }
                if (this.f56796g == 0 && !this.f56797h) {
                    this.f56790a.addPostData("is_vipdel", "1");
                } else {
                    this.f56790a.addPostData("is_vipdel", "0");
                }
                if (this.f56795f == 0 && this.l.f56788i) {
                    this.l.f56788i = false;
                    this.f56790a.addPostData("ori_ugc_nid", this.l.f56789j);
                    this.f56790a.addPostData("thread_type", String.valueOf(this.l.k));
                    this.f56790a.addPostData(TiebaStatic.Params.UGC_TYPE, String.valueOf(this.l.l));
                    this.f56790a.addPostData("owner_uid", this.l.m);
                    this.f56790a.addPostData("ori_ugc_vid", this.l.n);
                    this.f56790a.addPostData("video_type", String.valueOf(this.l.o));
                } else {
                    BaijiahaoData baijiahaoData = this.f56799j;
                    if (baijiahaoData != null) {
                        this.f56790a.addPostData("ori_ugc_nid", baijiahaoData.oriUgcNid);
                        this.f56790a.addPostData("ori_ugc_tid", this.f56799j.oriUgcTid);
                        this.f56790a.addPostData(TiebaStatic.Params.UGC_TYPE, String.valueOf(this.f56799j.oriUgcType));
                        this.f56790a.addPostData("ori_ugc_vid", this.f56799j.oriUgcVid);
                        this.f56790a.addPostData("owner_uid", TbadkCoreApplication.getCurrentAccount());
                    }
                }
                if (this.k) {
                    this.f56790a.addPostData("is_frs_mask", "1");
                }
                this.f56790a.getNetContext().getRequest().mIsNeedTbs = true;
                this.f56790a.postNetData();
                if (this.f56790a.getNetContext().getResponse().isRequestSuccess()) {
                    return Boolean.TRUE;
                }
                return Boolean.FALSE;
            }
            return (Boolean) invokeL.objValue;
        }

        /* JADX DEBUG: Method merged with bridge method */
        @Override // com.baidu.adp.lib.asyncTask.BdAsyncTask
        public void onPostExecute(Boolean bool) {
            Interceptable interceptable = $ic;
            if (interceptable == null || interceptable.invokeL(1048579, this, bool) == null) {
                super.onPostExecute((a) bool);
                this.l.f56784e = null;
                if (this.f56790a == null || bool == null) {
                    this.l.mLoadDataCallBack.c(null);
                    return;
                }
                b bVar = new b(this.l);
                bVar.f56803d = this.f56795f;
                bVar.f56806g = this.f56794e;
                bVar.f56805f = this.f56797h;
                bVar.f56804e = this.f56796g;
                bVar.f56801b = this.f56790a.getErrorString();
                bVar.f56802c = this.f56790a.getServerErrorCode();
                bVar.f56800a = bool.booleanValue();
                bVar.f56807h = this.k;
                this.l.mLoadDataCallBack.c(bVar);
            }
        }
    }

    /* loaded from: classes7.dex */
    public class b {
        public static /* synthetic */ Interceptable $ic;
        public transient /* synthetic */ FieldHolder $fh;

        /* renamed from: a  reason: collision with root package name */
        public boolean f56800a;

        /* renamed from: b  reason: collision with root package name */
        public String f56801b;

        /* renamed from: c  reason: collision with root package name */
        public int f56802c;

        /* renamed from: d  reason: collision with root package name */
        public int f56803d;

        /* renamed from: e  reason: collision with root package name */
        public int f56804e;

        /* renamed from: f  reason: collision with root package name */
        public boolean f56805f;

        /* renamed from: g  reason: collision with root package name */
        public String f56806g;

        /* renamed from: h  reason: collision with root package name */
        public boolean f56807h;

        public b(ForumManageModel forumManageModel) {
            Interceptable interceptable = $ic;
            if (interceptable != null) {
                InitContext newInitContext = TitanRuntime.newInitContext();
                newInitContext.initArgs = r2;
                Object[] objArr = {forumManageModel};
                interceptable.invokeUnInit(65536, newInitContext);
                int i2 = newInitContext.flag;
                if ((i2 & 1) != 0) {
                    int i3 = i2 & 2;
                    newInitContext.thisArg = this;
                    interceptable.invokeInitBody(65536, newInitContext);
                }
            }
        }
    }

    /* loaded from: classes7.dex */
    public class c extends BdAsyncTask<String, Integer, String> {
        public static /* synthetic */ Interceptable $ic;
        public transient /* synthetic */ FieldHolder $fh;
    }

    /* loaded from: classes7.dex */
    public class d {
        public static /* synthetic */ Interceptable $ic;
        public transient /* synthetic */ FieldHolder $fh;

        /* renamed from: a  reason: collision with root package name */
        public boolean f56808a;

        /* renamed from: b  reason: collision with root package name */
        public String f56809b;
    }

    /* loaded from: classes7.dex */
    public static class e {
        public static /* synthetic */ Interceptable $ic;
        public transient /* synthetic */ FieldHolder $fh;

        /* renamed from: a  reason: collision with root package name */
        public String f56810a;

        /* renamed from: b  reason: collision with root package name */
        public String f56811b;

        /* renamed from: c  reason: collision with root package name */
        public String f56812c;

        /* renamed from: d  reason: collision with root package name */
        public int f56813d;

        public e() {
            Interceptable interceptable = $ic;
            if (interceptable != null) {
                InitContext newInitContext = TitanRuntime.newInitContext();
                interceptable.invokeUnInit(65536, newInitContext);
                int i2 = newInitContext.flag;
                if ((i2 & 1) != 0) {
                    int i3 = i2 & 2;
                    newInitContext.thisArg = this;
                    interceptable.invokeInitBody(65536, newInitContext);
                }
            }
        }
    }

    /* loaded from: classes7.dex */
    public class f extends BdAsyncTask<String, String, Boolean> {
        public static /* synthetic */ Interceptable $ic;
        public transient /* synthetic */ FieldHolder $fh;

        /* renamed from: a  reason: collision with root package name */
        public NetWork f56814a;

        /* renamed from: b  reason: collision with root package name */
        public String f56815b;

        /* renamed from: c  reason: collision with root package name */
        public String f56816c;

        /* renamed from: d  reason: collision with root package name */
        public String f56817d;

        /* renamed from: e  reason: collision with root package name */
        public int f56818e;

        /* renamed from: f  reason: collision with root package name */
        public ArrayList<m0> f56819f;

        /* renamed from: g  reason: collision with root package name */
        public String f56820g;

        /* renamed from: h  reason: collision with root package name */
        public final /* synthetic */ ForumManageModel f56821h;

        public f(ForumManageModel forumManageModel, String str, String str2, String str3, int i2, String str4) {
            Interceptable interceptable = $ic;
            if (interceptable != null) {
                InitContext newInitContext = TitanRuntime.newInitContext();
                newInitContext.initArgs = r2;
                Object[] objArr = {forumManageModel, str, str2, str3, Integer.valueOf(i2), str4};
                interceptable.invokeUnInit(65536, newInitContext);
                int i3 = newInitContext.flag;
                if ((i3 & 1) != 0) {
                    int i4 = i3 & 2;
                    newInitContext.thisArg = this;
                    interceptable.invokeInitBody(65536, newInitContext);
                    return;
                }
            }
            this.f56821h = forumManageModel;
            this.f56814a = null;
            this.f56819f = null;
            this.f56820g = null;
            this.f56815b = str;
            this.f56816c = str2;
            this.f56817d = str3;
            this.f56818e = i2;
            this.f56820g = str4;
            this.f56819f = new ArrayList<>();
        }

        @Override // com.baidu.adp.lib.asyncTask.BdAsyncTask
        public void cancel() {
            Interceptable interceptable = $ic;
            if (interceptable == null || interceptable.invokeV(1048576, this) == null) {
                NetWork netWork = this.f56814a;
                if (netWork != null) {
                    netWork.cancelNetConnect();
                }
                this.f56821h.f56786g = null;
                super.cancel(true);
                this.f56821h.mLoadDataCallBack.c(null);
            }
        }

        /* JADX DEBUG: Method merged with bridge method */
        @Override // com.baidu.adp.lib.asyncTask.BdAsyncTask
        public Boolean doInBackground(String... strArr) {
            InterceptResult invokeL;
            Interceptable interceptable = $ic;
            if (interceptable == null || (invokeL = interceptable.invokeL(Constants.METHOD_GET_CONTACTER_INFO_FOR_SESSION, this, strArr)) == null) {
                NetWork netWork = new NetWork(strArr[0]);
                this.f56814a = netWork;
                netWork.addPostData("word", this.f56816c);
                if (this.f56818e != 6) {
                    this.f56814a.addPostData("fid", this.f56815b);
                    this.f56814a.addPostData("z", this.f56817d);
                    int i2 = this.f56818e;
                    if (i2 == 4) {
                        this.f56814a.addPostData("ntn", "set");
                    } else if (i2 == 5) {
                        this.f56814a.addPostData("ntn", "");
                    } else if (i2 == 2) {
                        this.f56814a.addPostData("ntn", "set");
                        this.f56814a.addPostData(IAdRequestParam.CELL_ID, this.f56820g);
                    } else {
                        this.f56814a.addPostData("ntn", "");
                    }
                    this.f56814a.addPostData("name_show", TbadkCoreApplication.getCurrentAccountNameShow());
                }
                this.f56814a.getNetContext().getRequest().mIsNeedTbs = true;
                String postNetData = this.f56814a.postNetData();
                if (this.f56814a.getNetContext().getResponse().isRequestSuccess()) {
                    if (this.f56818e == 6) {
                        try {
                            JSONArray optJSONArray = new JSONObject(postNetData).optJSONArray("cates");
                            for (int i3 = 0; i3 < optJSONArray.length(); i3++) {
                                m0 m0Var = new m0();
                                m0Var.c(optJSONArray.optJSONObject(i3));
                                this.f56819f.add(m0Var);
                            }
                        } catch (Exception e2) {
                            BdLog.e(e2.getMessage());
                            return Boolean.FALSE;
                        }
                    }
                    return Boolean.TRUE;
                }
                return Boolean.FALSE;
            }
            return (Boolean) invokeL.objValue;
        }

        /* JADX DEBUG: Method merged with bridge method */
        @Override // com.baidu.adp.lib.asyncTask.BdAsyncTask
        public void onPostExecute(Boolean bool) {
            Interceptable interceptable = $ic;
            if (interceptable == null || interceptable.invokeL(1048579, this, bool) == null) {
                super.onPostExecute((f) bool);
                this.f56821h.f56786g = null;
                if (this.f56814a == null) {
                    this.f56821h.mLoadDataCallBack.c(null);
                    return;
                }
                g gVar = new g(this.f56821h);
                gVar.f56822a = bool.booleanValue();
                if (bool.booleanValue()) {
                    if (this.f56818e == 6) {
                        gVar.f56824c = this.f56819f;
                    }
                } else {
                    gVar.f56823b = this.f56814a.getErrorString();
                }
                this.f56821h.mLoadDataCallBack.c(gVar);
            }
        }
    }

    /* loaded from: classes7.dex */
    public class g {
        public static /* synthetic */ Interceptable $ic;
        public transient /* synthetic */ FieldHolder $fh;

        /* renamed from: a  reason: collision with root package name */
        public boolean f56822a;

        /* renamed from: b  reason: collision with root package name */
        public String f56823b;

        /* renamed from: c  reason: collision with root package name */
        public ArrayList<m0> f56824c;

        public g(ForumManageModel forumManageModel) {
            Interceptable interceptable = $ic;
            if (interceptable != null) {
                InitContext newInitContext = TitanRuntime.newInitContext();
                newInitContext.initArgs = r2;
                Object[] objArr = {forumManageModel};
                interceptable.invokeUnInit(65536, newInitContext);
                int i2 = newInitContext.flag;
                if ((i2 & 1) != 0) {
                    int i3 = i2 & 2;
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

    /* JADX WARN: 'super' call moved to the top of the method (can break code semantics) */
    public ForumManageModel(TbPageContext tbPageContext) {
        super(tbPageContext);
        Interceptable interceptable = $ic;
        if (interceptable != null) {
            InitContext newInitContext = TitanRuntime.newInitContext();
            newInitContext.initArgs = r2;
            Object[] objArr = {tbPageContext};
            interceptable.invokeUnInit(65537, newInitContext);
            int i2 = newInitContext.flag;
            if ((i2 & 1) != 0) {
                int i3 = i2 & 2;
                super((c.a.e.a.f) newInitContext.callArgs[0]);
                newInitContext.thisArg = this;
                interceptable.invokeInitBody(65537, newInitContext);
                return;
            }
        }
        this.f56784e = null;
        this.f56785f = null;
        this.f56786g = null;
        this.f56788i = false;
    }

    @Override // com.baidu.adp.base.BdBaseModel
    public boolean LoadData() {
        InterceptResult invokeV;
        Interceptable interceptable = $ic;
        if (interceptable == null || (invokeV = interceptable.invokeV(1048576, this)) == null) {
            return false;
        }
        return invokeV.booleanValue;
    }

    public void M() {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeV(Constants.METHOD_GET_CONTACTER_INFO_FOR_SESSION, this) == null) {
            a aVar = this.f56784e;
            if (aVar != null) {
                aVar.cancel();
                this.f56784e = null;
            }
            c cVar = this.f56785f;
            if (cVar != null) {
                cVar.cancel();
                this.f56785f = null;
            }
            f fVar = this.f56786g;
            if (fVar != null) {
                fVar.cancel();
                this.f56786g = null;
            }
        }
    }

    public String N() {
        InterceptResult invokeV;
        Interceptable interceptable = $ic;
        return (interceptable == null || (invokeV = interceptable.invokeV(Constants.METHOD_SEND_USER_MSG, this)) == null) ? this.f56787h : (String) invokeV.objValue;
    }

    public boolean O() {
        InterceptResult invokeV;
        Interceptable interceptable = $ic;
        return (interceptable == null || (invokeV = interceptable.invokeV(1048579, this)) == null) ? (this.f56784e == null && this.f56785f == null && this.f56786g == null) ? false : true : invokeV.booleanValue;
    }

    public void P(c2 c2Var) {
        Interceptable interceptable = $ic;
        if (!(interceptable == null || interceptable.invokeL(1048580, this, c2Var) == null) || c2Var == null || c2Var.L() == null) {
            return;
        }
        this.f56788i = true;
        this.f56789j = c2Var.L().oriUgcNid;
        this.l = c2Var.L().oriUgcType;
        this.n = c2Var.L().oriUgcVid;
        this.k = c2Var.a0;
        this.m = TbadkCoreApplication.getCurrentAccount();
        this.o = c2Var.o1() != null ? c2Var.o1().video_type.intValue() : 0;
    }

    public void Q(String str) {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeL(1048581, this, str) == null) {
            this.f56787h = str;
        }
    }

    public void R(String str, String str2, String str3, String str4, int i2, int i3, boolean z, BaijiahaoData baijiahaoData, boolean z2) {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeCommon(1048582, this, new Object[]{str, str2, str3, str4, Integer.valueOf(i2), Integer.valueOf(i3), Boolean.valueOf(z), baijiahaoData, Boolean.valueOf(z2)}) == null) {
            a aVar = this.f56784e;
            if (aVar != null) {
                aVar.cancel();
                this.f56784e = null;
            }
            this.mLoadDataMode = 0;
            a aVar2 = new a(this, str, str2, str3, str4, i2, i3, z, baijiahaoData, z2);
            this.f56784e = aVar2;
            aVar2.setTag(UNIQUE_ID_DEL_POST_TASK);
            this.f56784e.setPriority(2);
            this.f56784e.execute(new String[0]);
        }
    }

    public void S(String str, String str2, String str3, int i2, String str4) {
        String str5;
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeCommon(1048583, this, new Object[]{str, str2, str3, Integer.valueOf(i2), str4}) == null) {
            f fVar = this.f56786g;
            if (fVar != null) {
                fVar.cancel();
                this.f56786g = null;
            }
            this.mLoadDataMode = i2;
            f fVar2 = new f(this, str, str2, str3, i2, str4);
            this.f56786g = fVar2;
            fVar2.setPriority(2);
            String str6 = TbConfig.SERVER_ADDRESS;
            if (i2 == 6) {
                str5 = str6 + TbConfig.GOOD_LIST_ADDRESS;
            } else if (i2 != 2 && i2 != 3) {
                str5 = str6 + TbConfig.COMMIT_TOP_ADDRESS;
            } else {
                str5 = str6 + TbConfig.COMMIT_GOOD_ADDRESS;
            }
            this.f56786g.execute(str5);
        }
    }

    @Override // com.baidu.adp.base.BdBaseModel
    public boolean cancelLoadData() {
        InterceptResult invokeV;
        Interceptable interceptable = $ic;
        if (interceptable == null || (invokeV = interceptable.invokeV(InputDeviceCompat.SOURCE_TOUCHPAD, this)) == null) {
            M();
            return false;
        }
        return invokeV.booleanValue;
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
            int i2 = newInitContext.flag;
            if ((i2 & 1) != 0) {
                int i3 = i2 & 2;
                super((c.a.e.a.f) newInitContext.callArgs[0]);
                newInitContext.thisArg = this;
                interceptable.invokeInitBody(65538, newInitContext);
                return;
            }
        }
        this.f56784e = null;
        this.f56785f = null;
        this.f56786g = null;
        this.f56788i = false;
    }
}
