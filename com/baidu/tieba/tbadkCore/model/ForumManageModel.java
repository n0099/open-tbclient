package com.baidu.tieba.tbadkCore.model;

import androidx.annotation.NonNull;
import androidx.core.view.InputDeviceCompat;
import c.a.s0.s.q.d2;
import c.a.s0.s.q.m0;
import com.baidu.adp.BdUniqueId;
import com.baidu.adp.base.BdBaseModel;
import com.baidu.adp.lib.asyncTask.BdAsyncTask;
import com.baidu.adp.lib.util.BdLog;
import com.baidu.android.imsdk.internal.Constants;
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
/* loaded from: classes12.dex */
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
    public a f50049e;

    /* renamed from: f  reason: collision with root package name */
    public c f50050f;

    /* renamed from: g  reason: collision with root package name */
    public f f50051g;

    /* renamed from: h  reason: collision with root package name */
    public String f50052h;

    /* renamed from: i  reason: collision with root package name */
    public boolean f50053i;

    /* renamed from: j  reason: collision with root package name */
    public String f50054j;

    /* renamed from: k  reason: collision with root package name */
    public int f50055k;
    public int l;
    public String m;
    public String n;
    public int o;

    /* loaded from: classes12.dex */
    public class a extends BdAsyncTask<String, Integer, Boolean> {
        public static /* synthetic */ Interceptable $ic;
        public transient /* synthetic */ FieldHolder $fh;
        public NetWork a;

        /* renamed from: b  reason: collision with root package name */
        public String f50056b;

        /* renamed from: c  reason: collision with root package name */
        public String f50057c;

        /* renamed from: d  reason: collision with root package name */
        public String f50058d;

        /* renamed from: e  reason: collision with root package name */
        public String f50059e;

        /* renamed from: f  reason: collision with root package name */
        public int f50060f;

        /* renamed from: g  reason: collision with root package name */
        public int f50061g;

        /* renamed from: h  reason: collision with root package name */
        public boolean f50062h;

        /* renamed from: i  reason: collision with root package name */
        public String f50063i;

        /* renamed from: j  reason: collision with root package name */
        public BaijiahaoData f50064j;

        /* renamed from: k  reason: collision with root package name */
        public boolean f50065k;
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
            this.a = null;
            this.f50056b = str;
            this.f50057c = str2;
            this.f50058d = str3;
            this.f50059e = str4;
            this.f50060f = i2;
            this.f50061g = i3;
            this.f50062h = z;
            this.f50063i = forumManageModel.O();
            this.f50064j = baijiahaoData;
            this.f50065k = z2;
        }

        @Override // com.baidu.adp.lib.asyncTask.BdAsyncTask
        public void cancel() {
            Interceptable interceptable = $ic;
            if (interceptable == null || interceptable.invokeV(1048576, this) == null) {
                NetWork netWork = this.a;
                if (netWork != null) {
                    netWork.cancelNetConnect();
                }
                this.l.f50049e = null;
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
                int i2 = this.f50060f;
                if (i2 != 0 && i2 != 3) {
                    str = str2 + TbConfig.DEL_POST_ADDRESS;
                } else {
                    str = str2 + TbConfig.DEL_THREAD_ADDRESS;
                }
                NetWork netWork = new NetWork(str);
                this.a = netWork;
                netWork.addPostData("fid", this.f50056b);
                this.a.addPostData("word", this.f50057c);
                this.a.addPostData("z", this.f50058d);
                String str3 = this.f50063i;
                if (str3 != null) {
                    this.a.addPostData("reason", str3);
                }
                int i3 = this.f50060f;
                if (i3 == 0) {
                    if (this.f50061g == 0) {
                        this.a.addPostData("delete_my_thread", "1");
                    }
                } else if (i3 == 1) {
                    this.a.addPostData("pid", this.f50059e);
                    this.a.addPostData("isfloor", "0");
                    this.a.addPostData("src", "1");
                    if (this.f50061g == 0 && this.f50062h) {
                        this.a.addPostData("delete_my_post", "1");
                    }
                } else if (i3 == 2) {
                    this.a.addPostData("pid", this.f50059e);
                    this.a.addPostData("isfloor", "1");
                    this.a.addPostData("src", "3");
                    if (this.f50061g == 0 && this.f50062h) {
                        this.a.addPostData("delete_my_post", "1");
                    }
                } else if (i3 == 3) {
                    this.a.addPostData("delete_my_thread", "1");
                    this.a.addPostData("is_story", "1");
                }
                if (this.f50061g == 0 && !this.f50062h) {
                    this.a.addPostData("is_vipdel", "1");
                } else {
                    this.a.addPostData("is_vipdel", "0");
                }
                if (this.f50060f == 0 && this.l.f50053i) {
                    this.l.f50053i = false;
                    this.a.addPostData("ori_ugc_nid", this.l.f50054j);
                    this.a.addPostData("thread_type", String.valueOf(this.l.f50055k));
                    this.a.addPostData(TiebaStatic.Params.UGC_TYPE, String.valueOf(this.l.l));
                    this.a.addPostData("owner_uid", this.l.m);
                    this.a.addPostData("ori_ugc_vid", this.l.n);
                    this.a.addPostData("video_type", String.valueOf(this.l.o));
                } else {
                    BaijiahaoData baijiahaoData = this.f50064j;
                    if (baijiahaoData != null) {
                        this.a.addPostData("ori_ugc_nid", baijiahaoData.oriUgcNid);
                        this.a.addPostData("ori_ugc_tid", this.f50064j.oriUgcTid);
                        this.a.addPostData(TiebaStatic.Params.UGC_TYPE, String.valueOf(this.f50064j.oriUgcType));
                        this.a.addPostData("ori_ugc_vid", this.f50064j.oriUgcVid);
                        this.a.addPostData("owner_uid", TbadkCoreApplication.getCurrentAccount());
                    }
                }
                if (this.f50065k) {
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

        /* JADX DEBUG: Method merged with bridge method */
        @Override // com.baidu.adp.lib.asyncTask.BdAsyncTask
        public void onPostExecute(Boolean bool) {
            Interceptable interceptable = $ic;
            if (interceptable == null || interceptable.invokeL(1048579, this, bool) == null) {
                super.onPostExecute((a) bool);
                this.l.f50049e = null;
                if (this.a == null || bool == null) {
                    this.l.mLoadDataCallBack.c(null);
                    return;
                }
                b bVar = new b(this.l);
                bVar.f50068d = this.f50060f;
                bVar.f50071g = this.f50059e;
                bVar.f50070f = this.f50062h;
                bVar.f50069e = this.f50061g;
                bVar.f50066b = this.a.getErrorString();
                bVar.f50067c = this.a.getServerErrorCode();
                bVar.a = bool.booleanValue();
                bVar.f50072h = this.f50065k;
                this.l.mLoadDataCallBack.c(bVar);
            }
        }
    }

    /* loaded from: classes12.dex */
    public class b {
        public static /* synthetic */ Interceptable $ic;
        public transient /* synthetic */ FieldHolder $fh;
        public boolean a;

        /* renamed from: b  reason: collision with root package name */
        public String f50066b;

        /* renamed from: c  reason: collision with root package name */
        public int f50067c;

        /* renamed from: d  reason: collision with root package name */
        public int f50068d;

        /* renamed from: e  reason: collision with root package name */
        public int f50069e;

        /* renamed from: f  reason: collision with root package name */
        public boolean f50070f;

        /* renamed from: g  reason: collision with root package name */
        public String f50071g;

        /* renamed from: h  reason: collision with root package name */
        public boolean f50072h;

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

    /* loaded from: classes12.dex */
    public class c extends BdAsyncTask<String, Integer, String> {
        public static /* synthetic */ Interceptable $ic;
        public transient /* synthetic */ FieldHolder $fh;
    }

    /* loaded from: classes12.dex */
    public class d {
        public static /* synthetic */ Interceptable $ic;
        public transient /* synthetic */ FieldHolder $fh;
        public boolean a;

        /* renamed from: b  reason: collision with root package name */
        public String f50073b;
    }

    /* loaded from: classes12.dex */
    public static class e {
        public static /* synthetic */ Interceptable $ic;
        public transient /* synthetic */ FieldHolder $fh;
        public String a;

        /* renamed from: b  reason: collision with root package name */
        public String f50074b;

        /* renamed from: c  reason: collision with root package name */
        public String f50075c;

        /* renamed from: d  reason: collision with root package name */
        public int f50076d;

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

    /* loaded from: classes12.dex */
    public class f extends BdAsyncTask<String, String, Boolean> {
        public static /* synthetic */ Interceptable $ic;
        public transient /* synthetic */ FieldHolder $fh;
        public NetWork a;

        /* renamed from: b  reason: collision with root package name */
        public String f50077b;

        /* renamed from: c  reason: collision with root package name */
        public String f50078c;

        /* renamed from: d  reason: collision with root package name */
        public String f50079d;

        /* renamed from: e  reason: collision with root package name */
        public int f50080e;

        /* renamed from: f  reason: collision with root package name */
        public ArrayList<m0> f50081f;

        /* renamed from: g  reason: collision with root package name */
        public String f50082g;

        /* renamed from: h  reason: collision with root package name */
        public final /* synthetic */ ForumManageModel f50083h;

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
            this.f50083h = forumManageModel;
            this.a = null;
            this.f50081f = null;
            this.f50082g = null;
            this.f50077b = str;
            this.f50078c = str2;
            this.f50079d = str3;
            this.f50080e = i2;
            this.f50082g = str4;
            this.f50081f = new ArrayList<>();
        }

        @Override // com.baidu.adp.lib.asyncTask.BdAsyncTask
        public void cancel() {
            Interceptable interceptable = $ic;
            if (interceptable == null || interceptable.invokeV(1048576, this) == null) {
                NetWork netWork = this.a;
                if (netWork != null) {
                    netWork.cancelNetConnect();
                }
                this.f50083h.f50051g = null;
                super.cancel(true);
                this.f50083h.mLoadDataCallBack.c(null);
            }
        }

        /* JADX DEBUG: Method merged with bridge method */
        @Override // com.baidu.adp.lib.asyncTask.BdAsyncTask
        public Boolean doInBackground(String... strArr) {
            InterceptResult invokeL;
            Interceptable interceptable = $ic;
            if (interceptable == null || (invokeL = interceptable.invokeL(Constants.METHOD_GET_CONTACTER_INFO_FOR_SESSION, this, strArr)) == null) {
                NetWork netWork = new NetWork(strArr[0]);
                this.a = netWork;
                netWork.addPostData("word", this.f50078c);
                if (this.f50080e != 6) {
                    this.a.addPostData("fid", this.f50077b);
                    this.a.addPostData("z", this.f50079d);
                    int i2 = this.f50080e;
                    if (i2 == 4) {
                        this.a.addPostData("ntn", "set");
                    } else if (i2 == 5) {
                        this.a.addPostData("ntn", "");
                    } else if (i2 == 2) {
                        this.a.addPostData("ntn", "set");
                        this.a.addPostData("cid", this.f50082g);
                    } else {
                        this.a.addPostData("ntn", "");
                    }
                    this.a.addPostData("name_show", TbadkCoreApplication.getCurrentAccountNameShow());
                }
                this.a.getNetContext().getRequest().mIsNeedTbs = true;
                String postNetData = this.a.postNetData();
                if (this.a.getNetContext().getResponse().isRequestSuccess()) {
                    if (this.f50080e == 6) {
                        try {
                            JSONArray optJSONArray = new JSONObject(postNetData).optJSONArray("cates");
                            for (int i3 = 0; i3 < optJSONArray.length(); i3++) {
                                m0 m0Var = new m0();
                                m0Var.c(optJSONArray.optJSONObject(i3));
                                this.f50081f.add(m0Var);
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
                this.f50083h.f50051g = null;
                if (this.a == null) {
                    this.f50083h.mLoadDataCallBack.c(null);
                    return;
                }
                g gVar = new g(this.f50083h);
                gVar.a = bool.booleanValue();
                if (bool.booleanValue()) {
                    if (this.f50080e == 6) {
                        gVar.f50085c = this.f50081f;
                    }
                } else {
                    gVar.f50084b = this.a.getErrorString();
                }
                this.f50083h.mLoadDataCallBack.c(gVar);
            }
        }
    }

    /* loaded from: classes12.dex */
    public class g {
        public static /* synthetic */ Interceptable $ic;
        public transient /* synthetic */ FieldHolder $fh;
        public boolean a;

        /* renamed from: b  reason: collision with root package name */
        public String f50084b;

        /* renamed from: c  reason: collision with root package name */
        public ArrayList<m0> f50085c;

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
                super((c.a.d.a.f) newInitContext.callArgs[0]);
                newInitContext.thisArg = this;
                interceptable.invokeInitBody(65537, newInitContext);
                return;
            }
        }
        this.f50049e = null;
        this.f50050f = null;
        this.f50051g = null;
        this.f50053i = false;
    }

    public void M() {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeV(1048576, this) == null) {
            a aVar = this.f50049e;
            if (aVar != null) {
                aVar.cancel();
                this.f50049e = null;
            }
            c cVar = this.f50050f;
            if (cVar != null) {
                cVar.cancel();
                this.f50050f = null;
            }
            f fVar = this.f50051g;
            if (fVar != null) {
                fVar.cancel();
                this.f50051g = null;
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
            return BarManageResultListener.a.a(optType, gVar.a, gVar.f50084b);
        }
        return (BarManageResultListener.a) invokeIL.objValue;
    }

    public String O() {
        InterceptResult invokeV;
        Interceptable interceptable = $ic;
        return (interceptable == null || (invokeV = interceptable.invokeV(Constants.METHOD_SEND_USER_MSG, this)) == null) ? this.f50052h : (String) invokeV.objValue;
    }

    public boolean P() {
        InterceptResult invokeV;
        Interceptable interceptable = $ic;
        return (interceptable == null || (invokeV = interceptable.invokeV(1048579, this)) == null) ? (this.f50049e == null && this.f50050f == null && this.f50051g == null) ? false : true : invokeV.booleanValue;
    }

    public void Q(d2 d2Var) {
        Interceptable interceptable = $ic;
        if (!(interceptable == null || interceptable.invokeL(1048580, this, d2Var) == null) || d2Var == null || d2Var.L() == null) {
            return;
        }
        this.f50053i = true;
        this.f50054j = d2Var.L().oriUgcNid;
        this.l = d2Var.L().oriUgcType;
        this.n = d2Var.L().oriUgcVid;
        this.f50055k = d2Var.d0;
        this.m = TbadkCoreApplication.getCurrentAccount();
        this.o = d2Var.t1() != null ? d2Var.t1().video_type.intValue() : 0;
    }

    public void R(String str) {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeL(1048581, this, str) == null) {
            this.f50052h = str;
        }
    }

    public void S(String str, String str2, String str3, String str4, int i2, int i3, boolean z, BaijiahaoData baijiahaoData, boolean z2) {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeCommon(1048582, this, new Object[]{str, str2, str3, str4, Integer.valueOf(i2), Integer.valueOf(i3), Boolean.valueOf(z), baijiahaoData, Boolean.valueOf(z2)}) == null) {
            a aVar = this.f50049e;
            if (aVar != null) {
                aVar.cancel();
                this.f50049e = null;
            }
            this.mLoadDataMode = 0;
            a aVar2 = new a(this, str, str2, str3, str4, i2, i3, z, baijiahaoData, z2);
            this.f50049e = aVar2;
            aVar2.setTag(UNIQUE_ID_DEL_POST_TASK);
            this.f50049e.setPriority(2);
            this.f50049e.execute(new String[0]);
        }
    }

    public void T(String str, String str2, String str3, int i2, String str4) {
        String str5;
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeCommon(1048583, this, new Object[]{str, str2, str3, Integer.valueOf(i2), str4}) == null) {
            f fVar = this.f50051g;
            if (fVar != null) {
                fVar.cancel();
                this.f50051g = null;
            }
            this.mLoadDataMode = i2;
            f fVar2 = new f(this, str, str2, str3, i2, str4);
            this.f50051g = fVar2;
            fVar2.setPriority(2);
            String str6 = TbConfig.SERVER_ADDRESS;
            if (i2 == 6) {
                str5 = str6 + TbConfig.GOOD_LIST_ADDRESS;
            } else if (i2 != 2 && i2 != 3) {
                str5 = str6 + TbConfig.COMMIT_TOP_ADDRESS;
            } else {
                str5 = str6 + TbConfig.COMMIT_GOOD_ADDRESS;
            }
            this.f50051g.execute(str5);
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
                super((c.a.d.a.f) newInitContext.callArgs[0]);
                newInitContext.thisArg = this;
                interceptable.invokeInitBody(65538, newInitContext);
                return;
            }
        }
        this.f50049e = null;
        this.f50050f = null;
        this.f50051g = null;
        this.f50053i = false;
    }
}
