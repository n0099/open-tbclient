package com.baidu.tieba.tbadkCore.model;

import androidx.annotation.NonNull;
import androidx.core.view.InputDeviceCompat;
import b.a.q0.s.q.d2;
import b.a.q0.s.q.m0;
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
/* loaded from: classes9.dex */
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
    public a f55153e;

    /* renamed from: f  reason: collision with root package name */
    public c f55154f;

    /* renamed from: g  reason: collision with root package name */
    public f f55155g;

    /* renamed from: h  reason: collision with root package name */
    public String f55156h;

    /* renamed from: i  reason: collision with root package name */
    public boolean f55157i;
    public String j;
    public int k;
    public int l;
    public String m;
    public String n;
    public int o;

    /* loaded from: classes9.dex */
    public class a extends BdAsyncTask<String, Integer, Boolean> {
        public static /* synthetic */ Interceptable $ic;
        public transient /* synthetic */ FieldHolder $fh;

        /* renamed from: a  reason: collision with root package name */
        public NetWork f55158a;

        /* renamed from: b  reason: collision with root package name */
        public String f55159b;

        /* renamed from: c  reason: collision with root package name */
        public String f55160c;

        /* renamed from: d  reason: collision with root package name */
        public String f55161d;

        /* renamed from: e  reason: collision with root package name */
        public String f55162e;

        /* renamed from: f  reason: collision with root package name */
        public int f55163f;

        /* renamed from: g  reason: collision with root package name */
        public int f55164g;

        /* renamed from: h  reason: collision with root package name */
        public boolean f55165h;

        /* renamed from: i  reason: collision with root package name */
        public String f55166i;
        public BaijiahaoData j;
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
            this.f55158a = null;
            this.f55159b = str;
            this.f55160c = str2;
            this.f55161d = str3;
            this.f55162e = str4;
            this.f55163f = i2;
            this.f55164g = i3;
            this.f55165h = z;
            this.f55166i = forumManageModel.O();
            this.j = baijiahaoData;
            this.k = z2;
        }

        @Override // com.baidu.adp.lib.asyncTask.BdAsyncTask
        public void cancel() {
            Interceptable interceptable = $ic;
            if (interceptable == null || interceptable.invokeV(1048576, this) == null) {
                NetWork netWork = this.f55158a;
                if (netWork != null) {
                    netWork.cancelNetConnect();
                }
                this.l.f55153e = null;
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
                int i2 = this.f55163f;
                if (i2 != 0 && i2 != 3) {
                    str = str2 + TbConfig.DEL_POST_ADDRESS;
                } else {
                    str = str2 + TbConfig.DEL_THREAD_ADDRESS;
                }
                NetWork netWork = new NetWork(str);
                this.f55158a = netWork;
                netWork.addPostData("fid", this.f55159b);
                this.f55158a.addPostData("word", this.f55160c);
                this.f55158a.addPostData("z", this.f55161d);
                String str3 = this.f55166i;
                if (str3 != null) {
                    this.f55158a.addPostData("reason", str3);
                }
                int i3 = this.f55163f;
                if (i3 == 0) {
                    if (this.f55164g == 0) {
                        this.f55158a.addPostData("delete_my_thread", "1");
                    }
                } else if (i3 == 1) {
                    this.f55158a.addPostData("pid", this.f55162e);
                    this.f55158a.addPostData("isfloor", "0");
                    this.f55158a.addPostData("src", "1");
                    if (this.f55164g == 0 && this.f55165h) {
                        this.f55158a.addPostData("delete_my_post", "1");
                    }
                } else if (i3 == 2) {
                    this.f55158a.addPostData("pid", this.f55162e);
                    this.f55158a.addPostData("isfloor", "1");
                    this.f55158a.addPostData("src", "3");
                    if (this.f55164g == 0 && this.f55165h) {
                        this.f55158a.addPostData("delete_my_post", "1");
                    }
                } else if (i3 == 3) {
                    this.f55158a.addPostData("delete_my_thread", "1");
                    this.f55158a.addPostData("is_story", "1");
                }
                if (this.f55164g == 0 && !this.f55165h) {
                    this.f55158a.addPostData("is_vipdel", "1");
                } else {
                    this.f55158a.addPostData("is_vipdel", "0");
                }
                if (this.f55163f == 0 && this.l.f55157i) {
                    this.l.f55157i = false;
                    this.f55158a.addPostData("ori_ugc_nid", this.l.j);
                    this.f55158a.addPostData("thread_type", String.valueOf(this.l.k));
                    this.f55158a.addPostData(TiebaStatic.Params.UGC_TYPE, String.valueOf(this.l.l));
                    this.f55158a.addPostData("owner_uid", this.l.m);
                    this.f55158a.addPostData("ori_ugc_vid", this.l.n);
                    this.f55158a.addPostData("video_type", String.valueOf(this.l.o));
                } else {
                    BaijiahaoData baijiahaoData = this.j;
                    if (baijiahaoData != null) {
                        this.f55158a.addPostData("ori_ugc_nid", baijiahaoData.oriUgcNid);
                        this.f55158a.addPostData("ori_ugc_tid", this.j.oriUgcTid);
                        this.f55158a.addPostData(TiebaStatic.Params.UGC_TYPE, String.valueOf(this.j.oriUgcType));
                        this.f55158a.addPostData("ori_ugc_vid", this.j.oriUgcVid);
                        this.f55158a.addPostData("owner_uid", TbadkCoreApplication.getCurrentAccount());
                    }
                }
                if (this.k) {
                    this.f55158a.addPostData("is_frs_mask", "1");
                }
                this.f55158a.getNetContext().getRequest().mIsNeedTbs = true;
                this.f55158a.postNetData();
                if (this.f55158a.getNetContext().getResponse().isRequestSuccess()) {
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
                this.l.f55153e = null;
                if (this.f55158a == null || bool == null) {
                    this.l.mLoadDataCallBack.c(null);
                    return;
                }
                b bVar = new b(this.l);
                bVar.f55170d = this.f55163f;
                bVar.f55173g = this.f55162e;
                bVar.f55172f = this.f55165h;
                bVar.f55171e = this.f55164g;
                bVar.f55168b = this.f55158a.getErrorString();
                bVar.f55169c = this.f55158a.getServerErrorCode();
                bVar.f55167a = bool.booleanValue();
                bVar.f55174h = this.k;
                this.l.mLoadDataCallBack.c(bVar);
            }
        }
    }

    /* loaded from: classes9.dex */
    public class b {
        public static /* synthetic */ Interceptable $ic;
        public transient /* synthetic */ FieldHolder $fh;

        /* renamed from: a  reason: collision with root package name */
        public boolean f55167a;

        /* renamed from: b  reason: collision with root package name */
        public String f55168b;

        /* renamed from: c  reason: collision with root package name */
        public int f55169c;

        /* renamed from: d  reason: collision with root package name */
        public int f55170d;

        /* renamed from: e  reason: collision with root package name */
        public int f55171e;

        /* renamed from: f  reason: collision with root package name */
        public boolean f55172f;

        /* renamed from: g  reason: collision with root package name */
        public String f55173g;

        /* renamed from: h  reason: collision with root package name */
        public boolean f55174h;

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

    /* loaded from: classes9.dex */
    public class c extends BdAsyncTask<String, Integer, String> {
        public static /* synthetic */ Interceptable $ic;
        public transient /* synthetic */ FieldHolder $fh;
    }

    /* loaded from: classes9.dex */
    public class d {
        public static /* synthetic */ Interceptable $ic;
        public transient /* synthetic */ FieldHolder $fh;

        /* renamed from: a  reason: collision with root package name */
        public boolean f55175a;

        /* renamed from: b  reason: collision with root package name */
        public String f55176b;
    }

    /* loaded from: classes9.dex */
    public static class e {
        public static /* synthetic */ Interceptable $ic;
        public transient /* synthetic */ FieldHolder $fh;

        /* renamed from: a  reason: collision with root package name */
        public String f55177a;

        /* renamed from: b  reason: collision with root package name */
        public String f55178b;

        /* renamed from: c  reason: collision with root package name */
        public String f55179c;

        /* renamed from: d  reason: collision with root package name */
        public int f55180d;

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

    /* loaded from: classes9.dex */
    public class f extends BdAsyncTask<String, String, Boolean> {
        public static /* synthetic */ Interceptable $ic;
        public transient /* synthetic */ FieldHolder $fh;

        /* renamed from: a  reason: collision with root package name */
        public NetWork f55181a;

        /* renamed from: b  reason: collision with root package name */
        public String f55182b;

        /* renamed from: c  reason: collision with root package name */
        public String f55183c;

        /* renamed from: d  reason: collision with root package name */
        public String f55184d;

        /* renamed from: e  reason: collision with root package name */
        public int f55185e;

        /* renamed from: f  reason: collision with root package name */
        public ArrayList<m0> f55186f;

        /* renamed from: g  reason: collision with root package name */
        public String f55187g;

        /* renamed from: h  reason: collision with root package name */
        public final /* synthetic */ ForumManageModel f55188h;

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
            this.f55188h = forumManageModel;
            this.f55181a = null;
            this.f55186f = null;
            this.f55187g = null;
            this.f55182b = str;
            this.f55183c = str2;
            this.f55184d = str3;
            this.f55185e = i2;
            this.f55187g = str4;
            this.f55186f = new ArrayList<>();
        }

        @Override // com.baidu.adp.lib.asyncTask.BdAsyncTask
        public void cancel() {
            Interceptable interceptable = $ic;
            if (interceptable == null || interceptable.invokeV(1048576, this) == null) {
                NetWork netWork = this.f55181a;
                if (netWork != null) {
                    netWork.cancelNetConnect();
                }
                this.f55188h.f55155g = null;
                super.cancel(true);
                this.f55188h.mLoadDataCallBack.c(null);
            }
        }

        /* JADX DEBUG: Method merged with bridge method */
        @Override // com.baidu.adp.lib.asyncTask.BdAsyncTask
        public Boolean doInBackground(String... strArr) {
            InterceptResult invokeL;
            Interceptable interceptable = $ic;
            if (interceptable == null || (invokeL = interceptable.invokeL(Constants.METHOD_GET_CONTACTER_INFO_FOR_SESSION, this, strArr)) == null) {
                NetWork netWork = new NetWork(strArr[0]);
                this.f55181a = netWork;
                netWork.addPostData("word", this.f55183c);
                if (this.f55185e != 6) {
                    this.f55181a.addPostData("fid", this.f55182b);
                    this.f55181a.addPostData("z", this.f55184d);
                    int i2 = this.f55185e;
                    if (i2 == 4) {
                        this.f55181a.addPostData("ntn", "set");
                    } else if (i2 == 5) {
                        this.f55181a.addPostData("ntn", "");
                    } else if (i2 == 2) {
                        this.f55181a.addPostData("ntn", "set");
                        this.f55181a.addPostData(IAdRequestParam.CELL_ID, this.f55187g);
                    } else {
                        this.f55181a.addPostData("ntn", "");
                    }
                    this.f55181a.addPostData("name_show", TbadkCoreApplication.getCurrentAccountNameShow());
                }
                this.f55181a.getNetContext().getRequest().mIsNeedTbs = true;
                String postNetData = this.f55181a.postNetData();
                if (this.f55181a.getNetContext().getResponse().isRequestSuccess()) {
                    if (this.f55185e == 6) {
                        try {
                            JSONArray optJSONArray = new JSONObject(postNetData).optJSONArray("cates");
                            for (int i3 = 0; i3 < optJSONArray.length(); i3++) {
                                m0 m0Var = new m0();
                                m0Var.c(optJSONArray.optJSONObject(i3));
                                this.f55186f.add(m0Var);
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
                this.f55188h.f55155g = null;
                if (this.f55181a == null) {
                    this.f55188h.mLoadDataCallBack.c(null);
                    return;
                }
                g gVar = new g(this.f55188h);
                gVar.f55189a = bool.booleanValue();
                if (bool.booleanValue()) {
                    if (this.f55185e == 6) {
                        gVar.f55191c = this.f55186f;
                    }
                } else {
                    gVar.f55190b = this.f55181a.getErrorString();
                }
                this.f55188h.mLoadDataCallBack.c(gVar);
            }
        }
    }

    /* loaded from: classes9.dex */
    public class g {
        public static /* synthetic */ Interceptable $ic;
        public transient /* synthetic */ FieldHolder $fh;

        /* renamed from: a  reason: collision with root package name */
        public boolean f55189a;

        /* renamed from: b  reason: collision with root package name */
        public String f55190b;

        /* renamed from: c  reason: collision with root package name */
        public ArrayList<m0> f55191c;

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
                super((b.a.e.a.f) newInitContext.callArgs[0]);
                newInitContext.thisArg = this;
                interceptable.invokeInitBody(65537, newInitContext);
                return;
            }
        }
        this.f55153e = null;
        this.f55154f = null;
        this.f55155g = null;
        this.f55157i = false;
    }

    public void M() {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeV(1048576, this) == null) {
            a aVar = this.f55153e;
            if (aVar != null) {
                aVar.cancel();
                this.f55153e = null;
            }
            c cVar = this.f55154f;
            if (cVar != null) {
                cVar.cancel();
                this.f55154f = null;
            }
            f fVar = this.f55155g;
            if (fVar != null) {
                fVar.cancel();
                this.f55155g = null;
            }
        }
    }

    @NonNull
    public BarManageResultListener.a N(int i2, g gVar) {
        InterceptResult invokeIL;
        BarManageResultListener.OptType optType;
        Interceptable interceptable = $ic;
        if (interceptable == null || (invokeIL = interceptable.invokeIL(Constants.METHOD_GET_CONTACTER_INFO_FOR_SESSION, this, i2, gVar)) == null) {
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
            return BarManageResultListener.a.a(optType, gVar.f55189a, gVar.f55190b);
        }
        return (BarManageResultListener.a) invokeIL.objValue;
    }

    public String O() {
        InterceptResult invokeV;
        Interceptable interceptable = $ic;
        return (interceptable == null || (invokeV = interceptable.invokeV(Constants.METHOD_SEND_USER_MSG, this)) == null) ? this.f55156h : (String) invokeV.objValue;
    }

    public boolean P() {
        InterceptResult invokeV;
        Interceptable interceptable = $ic;
        return (interceptable == null || (invokeV = interceptable.invokeV(1048579, this)) == null) ? (this.f55153e == null && this.f55154f == null && this.f55155g == null) ? false : true : invokeV.booleanValue;
    }

    public void Q(d2 d2Var) {
        Interceptable interceptable = $ic;
        if (!(interceptable == null || interceptable.invokeL(1048580, this, d2Var) == null) || d2Var == null || d2Var.L() == null) {
            return;
        }
        this.f55157i = true;
        this.j = d2Var.L().oriUgcNid;
        this.l = d2Var.L().oriUgcType;
        this.n = d2Var.L().oriUgcVid;
        this.k = d2Var.i0;
        this.m = TbadkCoreApplication.getCurrentAccount();
        this.o = d2Var.r1() != null ? d2Var.r1().video_type.intValue() : 0;
    }

    public void R(String str) {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeL(1048581, this, str) == null) {
            this.f55156h = str;
        }
    }

    public void S(String str, String str2, String str3, String str4, int i2, int i3, boolean z, BaijiahaoData baijiahaoData, boolean z2) {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeCommon(1048582, this, new Object[]{str, str2, str3, str4, Integer.valueOf(i2), Integer.valueOf(i3), Boolean.valueOf(z), baijiahaoData, Boolean.valueOf(z2)}) == null) {
            a aVar = this.f55153e;
            if (aVar != null) {
                aVar.cancel();
                this.f55153e = null;
            }
            this.mLoadDataMode = 0;
            a aVar2 = new a(this, str, str2, str3, str4, i2, i3, z, baijiahaoData, z2);
            this.f55153e = aVar2;
            aVar2.setTag(UNIQUE_ID_DEL_POST_TASK);
            this.f55153e.setPriority(2);
            this.f55153e.execute(new String[0]);
        }
    }

    public void T(String str, String str2, String str3, int i2, String str4) {
        String str5;
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeCommon(1048583, this, new Object[]{str, str2, str3, Integer.valueOf(i2), str4}) == null) {
            f fVar = this.f55155g;
            if (fVar != null) {
                fVar.cancel();
                this.f55155g = null;
            }
            this.mLoadDataMode = i2;
            f fVar2 = new f(this, str, str2, str3, i2, str4);
            this.f55155g = fVar2;
            fVar2.setPriority(2);
            String str6 = TbConfig.SERVER_ADDRESS;
            if (i2 == 6) {
                str5 = str6 + TbConfig.GOOD_LIST_ADDRESS;
            } else if (i2 != 2 && i2 != 3) {
                str5 = str6 + TbConfig.COMMIT_TOP_ADDRESS;
            } else {
                str5 = str6 + TbConfig.COMMIT_GOOD_ADDRESS;
            }
            this.f55155g.execute(str5);
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

    @Override // com.baidu.adp.base.BdBaseModel
    public boolean loadData() {
        InterceptResult invokeV;
        Interceptable interceptable = $ic;
        if (interceptable == null || (invokeV = interceptable.invokeV(1048585, this)) == null) {
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
                super((b.a.e.a.f) newInitContext.callArgs[0]);
                newInitContext.thisArg = this;
                interceptable.invokeInitBody(65538, newInitContext);
                return;
            }
        }
        this.f55153e = null;
        this.f55154f = null;
        this.f55155g = null;
        this.f55157i = false;
    }
}
