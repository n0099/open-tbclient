package com.baidu.tieba.tbadkCore.model;

import androidx.core.view.InputDeviceCompat;
import c.a.p0.s.q.c2;
import c.a.p0.s.q.m0;
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
    public a f56949e;

    /* renamed from: f  reason: collision with root package name */
    public c f56950f;

    /* renamed from: g  reason: collision with root package name */
    public f f56951g;

    /* renamed from: h  reason: collision with root package name */
    public String f56952h;

    /* renamed from: i  reason: collision with root package name */
    public boolean f56953i;

    /* renamed from: j  reason: collision with root package name */
    public String f56954j;
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
        public NetWork f56955a;

        /* renamed from: b  reason: collision with root package name */
        public String f56956b;

        /* renamed from: c  reason: collision with root package name */
        public String f56957c;

        /* renamed from: d  reason: collision with root package name */
        public String f56958d;

        /* renamed from: e  reason: collision with root package name */
        public String f56959e;

        /* renamed from: f  reason: collision with root package name */
        public int f56960f;

        /* renamed from: g  reason: collision with root package name */
        public int f56961g;

        /* renamed from: h  reason: collision with root package name */
        public boolean f56962h;

        /* renamed from: i  reason: collision with root package name */
        public String f56963i;

        /* renamed from: j  reason: collision with root package name */
        public BaijiahaoData f56964j;
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
            this.f56955a = null;
            this.f56956b = str;
            this.f56957c = str2;
            this.f56958d = str3;
            this.f56959e = str4;
            this.f56960f = i2;
            this.f56961g = i3;
            this.f56962h = z;
            this.f56963i = forumManageModel.N();
            this.f56964j = baijiahaoData;
            this.k = z2;
        }

        @Override // com.baidu.adp.lib.asyncTask.BdAsyncTask
        public void cancel() {
            Interceptable interceptable = $ic;
            if (interceptable == null || interceptable.invokeV(1048576, this) == null) {
                NetWork netWork = this.f56955a;
                if (netWork != null) {
                    netWork.cancelNetConnect();
                }
                this.l.f56949e = null;
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
                int i2 = this.f56960f;
                if (i2 != 0 && i2 != 3) {
                    str = str2 + TbConfig.DEL_POST_ADDRESS;
                } else {
                    str = str2 + TbConfig.DEL_THREAD_ADDRESS;
                }
                NetWork netWork = new NetWork(str);
                this.f56955a = netWork;
                netWork.addPostData("fid", this.f56956b);
                this.f56955a.addPostData("word", this.f56957c);
                this.f56955a.addPostData("z", this.f56958d);
                String str3 = this.f56963i;
                if (str3 != null) {
                    this.f56955a.addPostData("reason", str3);
                }
                int i3 = this.f56960f;
                if (i3 == 0) {
                    if (this.f56961g == 0) {
                        this.f56955a.addPostData("delete_my_thread", "1");
                    }
                } else if (i3 == 1) {
                    this.f56955a.addPostData("pid", this.f56959e);
                    this.f56955a.addPostData("isfloor", "0");
                    this.f56955a.addPostData("src", "1");
                    if (this.f56961g == 0 && this.f56962h) {
                        this.f56955a.addPostData("delete_my_post", "1");
                    }
                } else if (i3 == 2) {
                    this.f56955a.addPostData("pid", this.f56959e);
                    this.f56955a.addPostData("isfloor", "1");
                    this.f56955a.addPostData("src", "3");
                    if (this.f56961g == 0 && this.f56962h) {
                        this.f56955a.addPostData("delete_my_post", "1");
                    }
                } else if (i3 == 3) {
                    this.f56955a.addPostData("delete_my_thread", "1");
                    this.f56955a.addPostData("is_story", "1");
                }
                if (this.f56961g == 0 && !this.f56962h) {
                    this.f56955a.addPostData("is_vipdel", "1");
                } else {
                    this.f56955a.addPostData("is_vipdel", "0");
                }
                if (this.f56960f == 0 && this.l.f56953i) {
                    this.l.f56953i = false;
                    this.f56955a.addPostData("ori_ugc_nid", this.l.f56954j);
                    this.f56955a.addPostData("thread_type", String.valueOf(this.l.k));
                    this.f56955a.addPostData(TiebaStatic.Params.UGC_TYPE, String.valueOf(this.l.l));
                    this.f56955a.addPostData("owner_uid", this.l.m);
                    this.f56955a.addPostData("ori_ugc_vid", this.l.n);
                    this.f56955a.addPostData("video_type", String.valueOf(this.l.o));
                } else {
                    BaijiahaoData baijiahaoData = this.f56964j;
                    if (baijiahaoData != null) {
                        this.f56955a.addPostData("ori_ugc_nid", baijiahaoData.oriUgcNid);
                        this.f56955a.addPostData("ori_ugc_tid", this.f56964j.oriUgcTid);
                        this.f56955a.addPostData(TiebaStatic.Params.UGC_TYPE, String.valueOf(this.f56964j.oriUgcType));
                        this.f56955a.addPostData("ori_ugc_vid", this.f56964j.oriUgcVid);
                        this.f56955a.addPostData("owner_uid", TbadkCoreApplication.getCurrentAccount());
                    }
                }
                if (this.k) {
                    this.f56955a.addPostData("is_frs_mask", "1");
                }
                this.f56955a.getNetContext().getRequest().mIsNeedTbs = true;
                this.f56955a.postNetData();
                if (this.f56955a.getNetContext().getResponse().isRequestSuccess()) {
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
                this.l.f56949e = null;
                if (this.f56955a == null || bool == null) {
                    this.l.mLoadDataCallBack.c(null);
                    return;
                }
                b bVar = new b(this.l);
                bVar.f56968d = this.f56960f;
                bVar.f56971g = this.f56959e;
                bVar.f56970f = this.f56962h;
                bVar.f56969e = this.f56961g;
                bVar.f56966b = this.f56955a.getErrorString();
                bVar.f56967c = this.f56955a.getServerErrorCode();
                bVar.f56965a = bool.booleanValue();
                bVar.f56972h = this.k;
                this.l.mLoadDataCallBack.c(bVar);
            }
        }
    }

    /* loaded from: classes7.dex */
    public class b {
        public static /* synthetic */ Interceptable $ic;
        public transient /* synthetic */ FieldHolder $fh;

        /* renamed from: a  reason: collision with root package name */
        public boolean f56965a;

        /* renamed from: b  reason: collision with root package name */
        public String f56966b;

        /* renamed from: c  reason: collision with root package name */
        public int f56967c;

        /* renamed from: d  reason: collision with root package name */
        public int f56968d;

        /* renamed from: e  reason: collision with root package name */
        public int f56969e;

        /* renamed from: f  reason: collision with root package name */
        public boolean f56970f;

        /* renamed from: g  reason: collision with root package name */
        public String f56971g;

        /* renamed from: h  reason: collision with root package name */
        public boolean f56972h;

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
        public boolean f56973a;

        /* renamed from: b  reason: collision with root package name */
        public String f56974b;
    }

    /* loaded from: classes7.dex */
    public static class e {
        public static /* synthetic */ Interceptable $ic;
        public transient /* synthetic */ FieldHolder $fh;

        /* renamed from: a  reason: collision with root package name */
        public String f56975a;

        /* renamed from: b  reason: collision with root package name */
        public String f56976b;

        /* renamed from: c  reason: collision with root package name */
        public String f56977c;

        /* renamed from: d  reason: collision with root package name */
        public int f56978d;

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
        public NetWork f56979a;

        /* renamed from: b  reason: collision with root package name */
        public String f56980b;

        /* renamed from: c  reason: collision with root package name */
        public String f56981c;

        /* renamed from: d  reason: collision with root package name */
        public String f56982d;

        /* renamed from: e  reason: collision with root package name */
        public int f56983e;

        /* renamed from: f  reason: collision with root package name */
        public ArrayList<m0> f56984f;

        /* renamed from: g  reason: collision with root package name */
        public String f56985g;

        /* renamed from: h  reason: collision with root package name */
        public final /* synthetic */ ForumManageModel f56986h;

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
            this.f56986h = forumManageModel;
            this.f56979a = null;
            this.f56984f = null;
            this.f56985g = null;
            this.f56980b = str;
            this.f56981c = str2;
            this.f56982d = str3;
            this.f56983e = i2;
            this.f56985g = str4;
            this.f56984f = new ArrayList<>();
        }

        @Override // com.baidu.adp.lib.asyncTask.BdAsyncTask
        public void cancel() {
            Interceptable interceptable = $ic;
            if (interceptable == null || interceptable.invokeV(1048576, this) == null) {
                NetWork netWork = this.f56979a;
                if (netWork != null) {
                    netWork.cancelNetConnect();
                }
                this.f56986h.f56951g = null;
                super.cancel(true);
                this.f56986h.mLoadDataCallBack.c(null);
            }
        }

        /* JADX DEBUG: Method merged with bridge method */
        @Override // com.baidu.adp.lib.asyncTask.BdAsyncTask
        public Boolean doInBackground(String... strArr) {
            InterceptResult invokeL;
            Interceptable interceptable = $ic;
            if (interceptable == null || (invokeL = interceptable.invokeL(Constants.METHOD_GET_CONTACTER_INFO_FOR_SESSION, this, strArr)) == null) {
                NetWork netWork = new NetWork(strArr[0]);
                this.f56979a = netWork;
                netWork.addPostData("word", this.f56981c);
                if (this.f56983e != 6) {
                    this.f56979a.addPostData("fid", this.f56980b);
                    this.f56979a.addPostData("z", this.f56982d);
                    int i2 = this.f56983e;
                    if (i2 == 4) {
                        this.f56979a.addPostData("ntn", "set");
                    } else if (i2 == 5) {
                        this.f56979a.addPostData("ntn", "");
                    } else if (i2 == 2) {
                        this.f56979a.addPostData("ntn", "set");
                        this.f56979a.addPostData(IAdRequestParam.CELL_ID, this.f56985g);
                    } else {
                        this.f56979a.addPostData("ntn", "");
                    }
                    this.f56979a.addPostData("name_show", TbadkCoreApplication.getCurrentAccountNameShow());
                }
                this.f56979a.getNetContext().getRequest().mIsNeedTbs = true;
                String postNetData = this.f56979a.postNetData();
                if (this.f56979a.getNetContext().getResponse().isRequestSuccess()) {
                    if (this.f56983e == 6) {
                        try {
                            JSONArray optJSONArray = new JSONObject(postNetData).optJSONArray("cates");
                            for (int i3 = 0; i3 < optJSONArray.length(); i3++) {
                                m0 m0Var = new m0();
                                m0Var.c(optJSONArray.optJSONObject(i3));
                                this.f56984f.add(m0Var);
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
                this.f56986h.f56951g = null;
                if (this.f56979a == null) {
                    this.f56986h.mLoadDataCallBack.c(null);
                    return;
                }
                g gVar = new g(this.f56986h);
                gVar.f56987a = bool.booleanValue();
                if (bool.booleanValue()) {
                    if (this.f56983e == 6) {
                        gVar.f56989c = this.f56984f;
                    }
                } else {
                    gVar.f56988b = this.f56979a.getErrorString();
                }
                this.f56986h.mLoadDataCallBack.c(gVar);
            }
        }
    }

    /* loaded from: classes7.dex */
    public class g {
        public static /* synthetic */ Interceptable $ic;
        public transient /* synthetic */ FieldHolder $fh;

        /* renamed from: a  reason: collision with root package name */
        public boolean f56987a;

        /* renamed from: b  reason: collision with root package name */
        public String f56988b;

        /* renamed from: c  reason: collision with root package name */
        public ArrayList<m0> f56989c;

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
        this.f56949e = null;
        this.f56950f = null;
        this.f56951g = null;
        this.f56953i = false;
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
            a aVar = this.f56949e;
            if (aVar != null) {
                aVar.cancel();
                this.f56949e = null;
            }
            c cVar = this.f56950f;
            if (cVar != null) {
                cVar.cancel();
                this.f56950f = null;
            }
            f fVar = this.f56951g;
            if (fVar != null) {
                fVar.cancel();
                this.f56951g = null;
            }
        }
    }

    public String N() {
        InterceptResult invokeV;
        Interceptable interceptable = $ic;
        return (interceptable == null || (invokeV = interceptable.invokeV(Constants.METHOD_SEND_USER_MSG, this)) == null) ? this.f56952h : (String) invokeV.objValue;
    }

    public boolean O() {
        InterceptResult invokeV;
        Interceptable interceptable = $ic;
        return (interceptable == null || (invokeV = interceptable.invokeV(1048579, this)) == null) ? (this.f56949e == null && this.f56950f == null && this.f56951g == null) ? false : true : invokeV.booleanValue;
    }

    public void P(c2 c2Var) {
        Interceptable interceptable = $ic;
        if (!(interceptable == null || interceptable.invokeL(1048580, this, c2Var) == null) || c2Var == null || c2Var.L() == null) {
            return;
        }
        this.f56953i = true;
        this.f56954j = c2Var.L().oriUgcNid;
        this.l = c2Var.L().oriUgcType;
        this.n = c2Var.L().oriUgcVid;
        this.k = c2Var.a0;
        this.m = TbadkCoreApplication.getCurrentAccount();
        this.o = c2Var.o1() != null ? c2Var.o1().video_type.intValue() : 0;
    }

    public void Q(String str) {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeL(1048581, this, str) == null) {
            this.f56952h = str;
        }
    }

    public void R(String str, String str2, String str3, String str4, int i2, int i3, boolean z, BaijiahaoData baijiahaoData, boolean z2) {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeCommon(1048582, this, new Object[]{str, str2, str3, str4, Integer.valueOf(i2), Integer.valueOf(i3), Boolean.valueOf(z), baijiahaoData, Boolean.valueOf(z2)}) == null) {
            a aVar = this.f56949e;
            if (aVar != null) {
                aVar.cancel();
                this.f56949e = null;
            }
            this.mLoadDataMode = 0;
            a aVar2 = new a(this, str, str2, str3, str4, i2, i3, z, baijiahaoData, z2);
            this.f56949e = aVar2;
            aVar2.setTag(UNIQUE_ID_DEL_POST_TASK);
            this.f56949e.setPriority(2);
            this.f56949e.execute(new String[0]);
        }
    }

    public void S(String str, String str2, String str3, int i2, String str4) {
        String str5;
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeCommon(1048583, this, new Object[]{str, str2, str3, Integer.valueOf(i2), str4}) == null) {
            f fVar = this.f56951g;
            if (fVar != null) {
                fVar.cancel();
                this.f56951g = null;
            }
            this.mLoadDataMode = i2;
            f fVar2 = new f(this, str, str2, str3, i2, str4);
            this.f56951g = fVar2;
            fVar2.setPriority(2);
            String str6 = TbConfig.SERVER_ADDRESS;
            if (i2 == 6) {
                str5 = str6 + TbConfig.GOOD_LIST_ADDRESS;
            } else if (i2 != 2 && i2 != 3) {
                str5 = str6 + TbConfig.COMMIT_TOP_ADDRESS;
            } else {
                str5 = str6 + TbConfig.COMMIT_GOOD_ADDRESS;
            }
            this.f56951g.execute(str5);
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
        this.f56949e = null;
        this.f56950f = null;
        this.f56951g = null;
        this.f56953i = false;
    }
}
