package com.baidu.tieba.tbadkCore.model;

import androidx.annotation.NonNull;
import androidx.core.view.InputDeviceCompat;
import c.a.q0.s.q.d2;
import c.a.q0.s.q.m0;
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
import com.baidu.tbadk.module.pb.BarManageResultListener;
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
    public a f57226e;

    /* renamed from: f  reason: collision with root package name */
    public c f57227f;

    /* renamed from: g  reason: collision with root package name */
    public f f57228g;

    /* renamed from: h  reason: collision with root package name */
    public String f57229h;

    /* renamed from: i  reason: collision with root package name */
    public boolean f57230i;

    /* renamed from: j  reason: collision with root package name */
    public String f57231j;
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
        public NetWork f57232a;

        /* renamed from: b  reason: collision with root package name */
        public String f57233b;

        /* renamed from: c  reason: collision with root package name */
        public String f57234c;

        /* renamed from: d  reason: collision with root package name */
        public String f57235d;

        /* renamed from: e  reason: collision with root package name */
        public String f57236e;

        /* renamed from: f  reason: collision with root package name */
        public int f57237f;

        /* renamed from: g  reason: collision with root package name */
        public int f57238g;

        /* renamed from: h  reason: collision with root package name */
        public boolean f57239h;

        /* renamed from: i  reason: collision with root package name */
        public String f57240i;

        /* renamed from: j  reason: collision with root package name */
        public BaijiahaoData f57241j;
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
            this.f57232a = null;
            this.f57233b = str;
            this.f57234c = str2;
            this.f57235d = str3;
            this.f57236e = str4;
            this.f57237f = i2;
            this.f57238g = i3;
            this.f57239h = z;
            this.f57240i = forumManageModel.O();
            this.f57241j = baijiahaoData;
            this.k = z2;
        }

        @Override // com.baidu.adp.lib.asyncTask.BdAsyncTask
        public void cancel() {
            Interceptable interceptable = $ic;
            if (interceptable == null || interceptable.invokeV(1048576, this) == null) {
                NetWork netWork = this.f57232a;
                if (netWork != null) {
                    netWork.cancelNetConnect();
                }
                this.l.f57226e = null;
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
                int i2 = this.f57237f;
                if (i2 != 0 && i2 != 3) {
                    str = str2 + TbConfig.DEL_POST_ADDRESS;
                } else {
                    str = str2 + TbConfig.DEL_THREAD_ADDRESS;
                }
                NetWork netWork = new NetWork(str);
                this.f57232a = netWork;
                netWork.addPostData("fid", this.f57233b);
                this.f57232a.addPostData("word", this.f57234c);
                this.f57232a.addPostData("z", this.f57235d);
                String str3 = this.f57240i;
                if (str3 != null) {
                    this.f57232a.addPostData("reason", str3);
                }
                int i3 = this.f57237f;
                if (i3 == 0) {
                    if (this.f57238g == 0) {
                        this.f57232a.addPostData("delete_my_thread", "1");
                    }
                } else if (i3 == 1) {
                    this.f57232a.addPostData("pid", this.f57236e);
                    this.f57232a.addPostData("isfloor", "0");
                    this.f57232a.addPostData("src", "1");
                    if (this.f57238g == 0 && this.f57239h) {
                        this.f57232a.addPostData("delete_my_post", "1");
                    }
                } else if (i3 == 2) {
                    this.f57232a.addPostData("pid", this.f57236e);
                    this.f57232a.addPostData("isfloor", "1");
                    this.f57232a.addPostData("src", "3");
                    if (this.f57238g == 0 && this.f57239h) {
                        this.f57232a.addPostData("delete_my_post", "1");
                    }
                } else if (i3 == 3) {
                    this.f57232a.addPostData("delete_my_thread", "1");
                    this.f57232a.addPostData("is_story", "1");
                }
                if (this.f57238g == 0 && !this.f57239h) {
                    this.f57232a.addPostData("is_vipdel", "1");
                } else {
                    this.f57232a.addPostData("is_vipdel", "0");
                }
                if (this.f57237f == 0 && this.l.f57230i) {
                    this.l.f57230i = false;
                    this.f57232a.addPostData("ori_ugc_nid", this.l.f57231j);
                    this.f57232a.addPostData("thread_type", String.valueOf(this.l.k));
                    this.f57232a.addPostData(TiebaStatic.Params.UGC_TYPE, String.valueOf(this.l.l));
                    this.f57232a.addPostData("owner_uid", this.l.m);
                    this.f57232a.addPostData("ori_ugc_vid", this.l.n);
                    this.f57232a.addPostData("video_type", String.valueOf(this.l.o));
                } else {
                    BaijiahaoData baijiahaoData = this.f57241j;
                    if (baijiahaoData != null) {
                        this.f57232a.addPostData("ori_ugc_nid", baijiahaoData.oriUgcNid);
                        this.f57232a.addPostData("ori_ugc_tid", this.f57241j.oriUgcTid);
                        this.f57232a.addPostData(TiebaStatic.Params.UGC_TYPE, String.valueOf(this.f57241j.oriUgcType));
                        this.f57232a.addPostData("ori_ugc_vid", this.f57241j.oriUgcVid);
                        this.f57232a.addPostData("owner_uid", TbadkCoreApplication.getCurrentAccount());
                    }
                }
                if (this.k) {
                    this.f57232a.addPostData("is_frs_mask", "1");
                }
                this.f57232a.getNetContext().getRequest().mIsNeedTbs = true;
                this.f57232a.postNetData();
                if (this.f57232a.getNetContext().getResponse().isRequestSuccess()) {
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
                this.l.f57226e = null;
                if (this.f57232a == null || bool == null) {
                    this.l.mLoadDataCallBack.c(null);
                    return;
                }
                b bVar = new b(this.l);
                bVar.f57245d = this.f57237f;
                bVar.f57248g = this.f57236e;
                bVar.f57247f = this.f57239h;
                bVar.f57246e = this.f57238g;
                bVar.f57243b = this.f57232a.getErrorString();
                bVar.f57244c = this.f57232a.getServerErrorCode();
                bVar.f57242a = bool.booleanValue();
                bVar.f57249h = this.k;
                this.l.mLoadDataCallBack.c(bVar);
            }
        }
    }

    /* loaded from: classes7.dex */
    public class b {
        public static /* synthetic */ Interceptable $ic;
        public transient /* synthetic */ FieldHolder $fh;

        /* renamed from: a  reason: collision with root package name */
        public boolean f57242a;

        /* renamed from: b  reason: collision with root package name */
        public String f57243b;

        /* renamed from: c  reason: collision with root package name */
        public int f57244c;

        /* renamed from: d  reason: collision with root package name */
        public int f57245d;

        /* renamed from: e  reason: collision with root package name */
        public int f57246e;

        /* renamed from: f  reason: collision with root package name */
        public boolean f57247f;

        /* renamed from: g  reason: collision with root package name */
        public String f57248g;

        /* renamed from: h  reason: collision with root package name */
        public boolean f57249h;

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
        public boolean f57250a;

        /* renamed from: b  reason: collision with root package name */
        public String f57251b;
    }

    /* loaded from: classes7.dex */
    public static class e {
        public static /* synthetic */ Interceptable $ic;
        public transient /* synthetic */ FieldHolder $fh;

        /* renamed from: a  reason: collision with root package name */
        public String f57252a;

        /* renamed from: b  reason: collision with root package name */
        public String f57253b;

        /* renamed from: c  reason: collision with root package name */
        public String f57254c;

        /* renamed from: d  reason: collision with root package name */
        public int f57255d;

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
        public NetWork f57256a;

        /* renamed from: b  reason: collision with root package name */
        public String f57257b;

        /* renamed from: c  reason: collision with root package name */
        public String f57258c;

        /* renamed from: d  reason: collision with root package name */
        public String f57259d;

        /* renamed from: e  reason: collision with root package name */
        public int f57260e;

        /* renamed from: f  reason: collision with root package name */
        public ArrayList<m0> f57261f;

        /* renamed from: g  reason: collision with root package name */
        public String f57262g;

        /* renamed from: h  reason: collision with root package name */
        public final /* synthetic */ ForumManageModel f57263h;

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
            this.f57263h = forumManageModel;
            this.f57256a = null;
            this.f57261f = null;
            this.f57262g = null;
            this.f57257b = str;
            this.f57258c = str2;
            this.f57259d = str3;
            this.f57260e = i2;
            this.f57262g = str4;
            this.f57261f = new ArrayList<>();
        }

        @Override // com.baidu.adp.lib.asyncTask.BdAsyncTask
        public void cancel() {
            Interceptable interceptable = $ic;
            if (interceptable == null || interceptable.invokeV(1048576, this) == null) {
                NetWork netWork = this.f57256a;
                if (netWork != null) {
                    netWork.cancelNetConnect();
                }
                this.f57263h.f57228g = null;
                super.cancel(true);
                this.f57263h.mLoadDataCallBack.c(null);
            }
        }

        /* JADX DEBUG: Method merged with bridge method */
        @Override // com.baidu.adp.lib.asyncTask.BdAsyncTask
        public Boolean doInBackground(String... strArr) {
            InterceptResult invokeL;
            Interceptable interceptable = $ic;
            if (interceptable == null || (invokeL = interceptable.invokeL(Constants.METHOD_GET_CONTACTER_INFO_FOR_SESSION, this, strArr)) == null) {
                NetWork netWork = new NetWork(strArr[0]);
                this.f57256a = netWork;
                netWork.addPostData("word", this.f57258c);
                if (this.f57260e != 6) {
                    this.f57256a.addPostData("fid", this.f57257b);
                    this.f57256a.addPostData("z", this.f57259d);
                    int i2 = this.f57260e;
                    if (i2 == 4) {
                        this.f57256a.addPostData("ntn", "set");
                    } else if (i2 == 5) {
                        this.f57256a.addPostData("ntn", "");
                    } else if (i2 == 2) {
                        this.f57256a.addPostData("ntn", "set");
                        this.f57256a.addPostData(IAdRequestParam.CELL_ID, this.f57262g);
                    } else {
                        this.f57256a.addPostData("ntn", "");
                    }
                    this.f57256a.addPostData("name_show", TbadkCoreApplication.getCurrentAccountNameShow());
                }
                this.f57256a.getNetContext().getRequest().mIsNeedTbs = true;
                String postNetData = this.f57256a.postNetData();
                if (this.f57256a.getNetContext().getResponse().isRequestSuccess()) {
                    if (this.f57260e == 6) {
                        try {
                            JSONArray optJSONArray = new JSONObject(postNetData).optJSONArray("cates");
                            for (int i3 = 0; i3 < optJSONArray.length(); i3++) {
                                m0 m0Var = new m0();
                                m0Var.c(optJSONArray.optJSONObject(i3));
                                this.f57261f.add(m0Var);
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
                this.f57263h.f57228g = null;
                if (this.f57256a == null) {
                    this.f57263h.mLoadDataCallBack.c(null);
                    return;
                }
                g gVar = new g(this.f57263h);
                gVar.f57264a = bool.booleanValue();
                if (bool.booleanValue()) {
                    if (this.f57260e == 6) {
                        gVar.f57266c = this.f57261f;
                    }
                } else {
                    gVar.f57265b = this.f57256a.getErrorString();
                }
                this.f57263h.mLoadDataCallBack.c(gVar);
            }
        }
    }

    /* loaded from: classes7.dex */
    public class g {
        public static /* synthetic */ Interceptable $ic;
        public transient /* synthetic */ FieldHolder $fh;

        /* renamed from: a  reason: collision with root package name */
        public boolean f57264a;

        /* renamed from: b  reason: collision with root package name */
        public String f57265b;

        /* renamed from: c  reason: collision with root package name */
        public ArrayList<m0> f57266c;

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
        this.f57226e = null;
        this.f57227f = null;
        this.f57228g = null;
        this.f57230i = false;
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
            a aVar = this.f57226e;
            if (aVar != null) {
                aVar.cancel();
                this.f57226e = null;
            }
            c cVar = this.f57227f;
            if (cVar != null) {
                cVar.cancel();
                this.f57227f = null;
            }
            f fVar = this.f57228g;
            if (fVar != null) {
                fVar.cancel();
                this.f57228g = null;
            }
        }
    }

    @NonNull
    public BarManageResultListener.a N(int i2, g gVar) {
        InterceptResult invokeIL;
        BarManageResultListener.OptType optType;
        Interceptable interceptable = $ic;
        if (interceptable == null || (invokeIL = interceptable.invokeIL(Constants.METHOD_SEND_USER_MSG, this, i2, gVar)) == null) {
            if (i2 == 2) {
                optType = BarManageResultListener.OptType.ADD_GOOD;
            } else if (i2 == 3) {
                optType = BarManageResultListener.OptType.CANCEL_GOOD;
            } else if (i2 == 4) {
                optType = BarManageResultListener.OptType.MAKE_TOP;
            } else if (i2 == 5) {
                optType = BarManageResultListener.OptType.CANCEL_TOP;
            } else {
                throw new IllegalStateException();
            }
            return BarManageResultListener.a.a(optType, gVar.f57264a, gVar.f57265b);
        }
        return (BarManageResultListener.a) invokeIL.objValue;
    }

    public String O() {
        InterceptResult invokeV;
        Interceptable interceptable = $ic;
        return (interceptable == null || (invokeV = interceptable.invokeV(1048579, this)) == null) ? this.f57229h : (String) invokeV.objValue;
    }

    public boolean P() {
        InterceptResult invokeV;
        Interceptable interceptable = $ic;
        return (interceptable == null || (invokeV = interceptable.invokeV(1048580, this)) == null) ? (this.f57226e == null && this.f57227f == null && this.f57228g == null) ? false : true : invokeV.booleanValue;
    }

    public void Q(d2 d2Var) {
        Interceptable interceptable = $ic;
        if (!(interceptable == null || interceptable.invokeL(1048581, this, d2Var) == null) || d2Var == null || d2Var.L() == null) {
            return;
        }
        this.f57230i = true;
        this.f57231j = d2Var.L().oriUgcNid;
        this.l = d2Var.L().oriUgcType;
        this.n = d2Var.L().oriUgcVid;
        this.k = d2Var.i0;
        this.m = TbadkCoreApplication.getCurrentAccount();
        this.o = d2Var.q1() != null ? d2Var.q1().video_type.intValue() : 0;
    }

    public void R(String str) {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeL(1048582, this, str) == null) {
            this.f57229h = str;
        }
    }

    public void S(String str, String str2, String str3, String str4, int i2, int i3, boolean z, BaijiahaoData baijiahaoData, boolean z2) {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeCommon(1048583, this, new Object[]{str, str2, str3, str4, Integer.valueOf(i2), Integer.valueOf(i3), Boolean.valueOf(z), baijiahaoData, Boolean.valueOf(z2)}) == null) {
            a aVar = this.f57226e;
            if (aVar != null) {
                aVar.cancel();
                this.f57226e = null;
            }
            this.mLoadDataMode = 0;
            a aVar2 = new a(this, str, str2, str3, str4, i2, i3, z, baijiahaoData, z2);
            this.f57226e = aVar2;
            aVar2.setTag(UNIQUE_ID_DEL_POST_TASK);
            this.f57226e.setPriority(2);
            this.f57226e.execute(new String[0]);
        }
    }

    public void T(String str, String str2, String str3, int i2, String str4) {
        String str5;
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeCommon(InputDeviceCompat.SOURCE_TOUCHPAD, this, new Object[]{str, str2, str3, Integer.valueOf(i2), str4}) == null) {
            f fVar = this.f57228g;
            if (fVar != null) {
                fVar.cancel();
                this.f57228g = null;
            }
            this.mLoadDataMode = i2;
            f fVar2 = new f(this, str, str2, str3, i2, str4);
            this.f57228g = fVar2;
            fVar2.setPriority(2);
            String str6 = TbConfig.SERVER_ADDRESS;
            if (i2 == 6) {
                str5 = str6 + TbConfig.GOOD_LIST_ADDRESS;
            } else if (i2 != 2 && i2 != 3) {
                str5 = str6 + TbConfig.COMMIT_TOP_ADDRESS;
            } else {
                str5 = str6 + TbConfig.COMMIT_GOOD_ADDRESS;
            }
            this.f57228g.execute(str5);
        }
    }

    @Override // com.baidu.adp.base.BdBaseModel
    public boolean cancelLoadData() {
        InterceptResult invokeV;
        Interceptable interceptable = $ic;
        if (interceptable == null || (invokeV = interceptable.invokeV(1048585, this)) == null) {
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
        this.f57226e = null;
        this.f57227f = null;
        this.f57228g = null;
        this.f57230i = false;
    }
}
