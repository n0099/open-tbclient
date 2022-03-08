package com.baidu.tieba.tbadkCore.model;

import androidx.annotation.NonNull;
import androidx.core.view.InputDeviceCompat;
import c.a.q0.r.r.e2;
import c.a.q0.r.r.m0;
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
/* loaded from: classes6.dex */
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
    public a f46763e;

    /* renamed from: f  reason: collision with root package name */
    public c f46764f;

    /* renamed from: g  reason: collision with root package name */
    public f f46765g;

    /* renamed from: h  reason: collision with root package name */
    public String f46766h;

    /* renamed from: i  reason: collision with root package name */
    public boolean f46767i;

    /* renamed from: j  reason: collision with root package name */
    public String f46768j;
    public int k;
    public int l;
    public String m;
    public String n;
    public int o;

    /* loaded from: classes6.dex */
    public class a extends BdAsyncTask<String, Integer, Boolean> {
        public static /* synthetic */ Interceptable $ic;
        public transient /* synthetic */ FieldHolder $fh;
        public NetWork a;

        /* renamed from: b  reason: collision with root package name */
        public String f46769b;

        /* renamed from: c  reason: collision with root package name */
        public String f46770c;

        /* renamed from: d  reason: collision with root package name */
        public String f46771d;

        /* renamed from: e  reason: collision with root package name */
        public String f46772e;

        /* renamed from: f  reason: collision with root package name */
        public int f46773f;

        /* renamed from: g  reason: collision with root package name */
        public int f46774g;

        /* renamed from: h  reason: collision with root package name */
        public boolean f46775h;

        /* renamed from: i  reason: collision with root package name */
        public String f46776i;

        /* renamed from: j  reason: collision with root package name */
        public BaijiahaoData f46777j;
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
            this.a = null;
            this.f46769b = str;
            this.f46770c = str2;
            this.f46771d = str3;
            this.f46772e = str4;
            this.f46773f = i2;
            this.f46774g = i3;
            this.f46775h = z;
            this.f46776i = forumManageModel.O();
            this.f46777j = baijiahaoData;
            this.k = z2;
        }

        @Override // com.baidu.adp.lib.asyncTask.BdAsyncTask
        public void cancel() {
            Interceptable interceptable = $ic;
            if (interceptable == null || interceptable.invokeV(1048576, this) == null) {
                NetWork netWork = this.a;
                if (netWork != null) {
                    netWork.cancelNetConnect();
                }
                this.l.f46763e = null;
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
                int i2 = this.f46773f;
                if (i2 != 0 && i2 != 3) {
                    str = str2 + TbConfig.DEL_POST_ADDRESS;
                } else {
                    str = str2 + TbConfig.DEL_THREAD_ADDRESS;
                }
                NetWork netWork = new NetWork(str);
                this.a = netWork;
                netWork.addPostData("fid", this.f46769b);
                this.a.addPostData("word", this.f46770c);
                this.a.addPostData("z", this.f46771d);
                String str3 = this.f46776i;
                if (str3 != null) {
                    this.a.addPostData("reason", str3);
                }
                int i3 = this.f46773f;
                if (i3 == 0) {
                    if (this.f46774g == 0) {
                        this.a.addPostData("delete_my_thread", "1");
                    }
                } else if (i3 == 1) {
                    this.a.addPostData("pid", this.f46772e);
                    this.a.addPostData("isfloor", "0");
                    this.a.addPostData("src", "1");
                    if (this.f46774g == 0 && this.f46775h) {
                        this.a.addPostData("delete_my_post", "1");
                    }
                } else if (i3 == 2) {
                    this.a.addPostData("pid", this.f46772e);
                    this.a.addPostData("isfloor", "1");
                    this.a.addPostData("src", "3");
                    if (this.f46774g == 0 && this.f46775h) {
                        this.a.addPostData("delete_my_post", "1");
                    }
                } else if (i3 == 3) {
                    this.a.addPostData("delete_my_thread", "1");
                    this.a.addPostData("is_story", "1");
                }
                if (this.f46774g == 0 && !this.f46775h) {
                    this.a.addPostData("is_vipdel", "1");
                } else {
                    this.a.addPostData("is_vipdel", "0");
                }
                if (this.f46773f == 0 && this.l.f46767i) {
                    this.l.f46767i = false;
                    this.a.addPostData("ori_ugc_nid", this.l.f46768j);
                    this.a.addPostData("thread_type", String.valueOf(this.l.k));
                    this.a.addPostData(TiebaStatic.Params.UGC_TYPE, String.valueOf(this.l.l));
                    this.a.addPostData("owner_uid", this.l.m);
                    this.a.addPostData("ori_ugc_vid", this.l.n);
                    this.a.addPostData("video_type", String.valueOf(this.l.o));
                } else {
                    BaijiahaoData baijiahaoData = this.f46777j;
                    if (baijiahaoData != null) {
                        this.a.addPostData("ori_ugc_nid", baijiahaoData.oriUgcNid);
                        this.a.addPostData("ori_ugc_tid", this.f46777j.oriUgcTid);
                        this.a.addPostData(TiebaStatic.Params.UGC_TYPE, String.valueOf(this.f46777j.oriUgcType));
                        this.a.addPostData("ori_ugc_vid", this.f46777j.oriUgcVid);
                        this.a.addPostData("owner_uid", TbadkCoreApplication.getCurrentAccount());
                    }
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

        /* JADX DEBUG: Method merged with bridge method */
        @Override // com.baidu.adp.lib.asyncTask.BdAsyncTask
        public void onPostExecute(Boolean bool) {
            Interceptable interceptable = $ic;
            if (interceptable == null || interceptable.invokeL(1048579, this, bool) == null) {
                super.onPostExecute((a) bool);
                this.l.f46763e = null;
                if (this.a == null || bool == null) {
                    this.l.mLoadDataCallBack.c(null);
                    return;
                }
                b bVar = new b(this.l);
                bVar.f46780d = this.f46773f;
                bVar.f46783g = this.f46772e;
                bVar.f46782f = this.f46775h;
                bVar.f46781e = this.f46774g;
                bVar.f46778b = this.a.getErrorString();
                bVar.f46779c = this.a.getServerErrorCode();
                bVar.a = bool.booleanValue();
                bVar.f46784h = this.k;
                this.l.mLoadDataCallBack.c(bVar);
            }
        }
    }

    /* loaded from: classes6.dex */
    public class b {
        public static /* synthetic */ Interceptable $ic;
        public transient /* synthetic */ FieldHolder $fh;
        public boolean a;

        /* renamed from: b  reason: collision with root package name */
        public String f46778b;

        /* renamed from: c  reason: collision with root package name */
        public int f46779c;

        /* renamed from: d  reason: collision with root package name */
        public int f46780d;

        /* renamed from: e  reason: collision with root package name */
        public int f46781e;

        /* renamed from: f  reason: collision with root package name */
        public boolean f46782f;

        /* renamed from: g  reason: collision with root package name */
        public String f46783g;

        /* renamed from: h  reason: collision with root package name */
        public boolean f46784h;

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

    /* loaded from: classes6.dex */
    public class c extends BdAsyncTask<String, Integer, String> {
        public static /* synthetic */ Interceptable $ic;
        public transient /* synthetic */ FieldHolder $fh;
    }

    /* loaded from: classes6.dex */
    public class d {
        public static /* synthetic */ Interceptable $ic;
        public transient /* synthetic */ FieldHolder $fh;
        public boolean a;

        /* renamed from: b  reason: collision with root package name */
        public String f46785b;
    }

    /* loaded from: classes6.dex */
    public static class e {
        public static /* synthetic */ Interceptable $ic;
        public transient /* synthetic */ FieldHolder $fh;
        public String a;

        /* renamed from: b  reason: collision with root package name */
        public String f46786b;

        /* renamed from: c  reason: collision with root package name */
        public String f46787c;

        /* renamed from: d  reason: collision with root package name */
        public int f46788d;

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

    /* loaded from: classes6.dex */
    public class f extends BdAsyncTask<String, String, Boolean> {
        public static /* synthetic */ Interceptable $ic;
        public transient /* synthetic */ FieldHolder $fh;
        public NetWork a;

        /* renamed from: b  reason: collision with root package name */
        public String f46789b;

        /* renamed from: c  reason: collision with root package name */
        public String f46790c;

        /* renamed from: d  reason: collision with root package name */
        public String f46791d;

        /* renamed from: e  reason: collision with root package name */
        public int f46792e;

        /* renamed from: f  reason: collision with root package name */
        public ArrayList<m0> f46793f;

        /* renamed from: g  reason: collision with root package name */
        public String f46794g;

        /* renamed from: h  reason: collision with root package name */
        public final /* synthetic */ ForumManageModel f46795h;

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
            this.f46795h = forumManageModel;
            this.a = null;
            this.f46793f = null;
            this.f46794g = null;
            this.f46789b = str;
            this.f46790c = str2;
            this.f46791d = str3;
            this.f46792e = i2;
            this.f46794g = str4;
            this.f46793f = new ArrayList<>();
        }

        @Override // com.baidu.adp.lib.asyncTask.BdAsyncTask
        public void cancel() {
            Interceptable interceptable = $ic;
            if (interceptable == null || interceptable.invokeV(1048576, this) == null) {
                NetWork netWork = this.a;
                if (netWork != null) {
                    netWork.cancelNetConnect();
                }
                this.f46795h.f46765g = null;
                super.cancel(true);
                this.f46795h.mLoadDataCallBack.c(null);
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
                netWork.addPostData("word", this.f46790c);
                if (this.f46792e != 6) {
                    this.a.addPostData("fid", this.f46789b);
                    this.a.addPostData("z", this.f46791d);
                    int i2 = this.f46792e;
                    if (i2 == 4) {
                        this.a.addPostData("ntn", "set");
                    } else if (i2 == 5) {
                        this.a.addPostData("ntn", "");
                    } else if (i2 == 2) {
                        this.a.addPostData("ntn", "set");
                        this.a.addPostData("cid", this.f46794g);
                    } else {
                        this.a.addPostData("ntn", "");
                    }
                    this.a.addPostData("name_show", TbadkCoreApplication.getCurrentAccountNameShow());
                }
                this.a.getNetContext().getRequest().mIsNeedTbs = true;
                String postNetData = this.a.postNetData();
                if (this.a.getNetContext().getResponse().isRequestSuccess()) {
                    if (this.f46792e == 6) {
                        try {
                            JSONArray optJSONArray = new JSONObject(postNetData).optJSONArray("cates");
                            for (int i3 = 0; i3 < optJSONArray.length(); i3++) {
                                m0 m0Var = new m0();
                                m0Var.c(optJSONArray.optJSONObject(i3));
                                this.f46793f.add(m0Var);
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
                this.f46795h.f46765g = null;
                if (this.a == null) {
                    this.f46795h.mLoadDataCallBack.c(null);
                    return;
                }
                g gVar = new g(this.f46795h);
                gVar.a = bool.booleanValue();
                if (bool.booleanValue()) {
                    if (this.f46792e == 6) {
                        gVar.f46797c = this.f46793f;
                    }
                } else {
                    gVar.f46796b = this.a.getErrorString();
                }
                this.f46795h.mLoadDataCallBack.c(gVar);
            }
        }
    }

    /* loaded from: classes6.dex */
    public class g {
        public static /* synthetic */ Interceptable $ic;
        public transient /* synthetic */ FieldHolder $fh;
        public boolean a;

        /* renamed from: b  reason: collision with root package name */
        public String f46796b;

        /* renamed from: c  reason: collision with root package name */
        public ArrayList<m0> f46797c;

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
        this.f46763e = null;
        this.f46764f = null;
        this.f46765g = null;
        this.f46767i = false;
    }

    public void M() {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeV(1048576, this) == null) {
            a aVar = this.f46763e;
            if (aVar != null) {
                aVar.cancel();
                this.f46763e = null;
            }
            c cVar = this.f46764f;
            if (cVar != null) {
                cVar.cancel();
                this.f46764f = null;
            }
            f fVar = this.f46765g;
            if (fVar != null) {
                fVar.cancel();
                this.f46765g = null;
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
            return BarManageResultListener.a.a(optType, gVar.a, gVar.f46796b);
        }
        return (BarManageResultListener.a) invokeIL.objValue;
    }

    public String O() {
        InterceptResult invokeV;
        Interceptable interceptable = $ic;
        return (interceptable == null || (invokeV = interceptable.invokeV(Constants.METHOD_SEND_USER_MSG, this)) == null) ? this.f46766h : (String) invokeV.objValue;
    }

    public boolean P() {
        InterceptResult invokeV;
        Interceptable interceptable = $ic;
        return (interceptable == null || (invokeV = interceptable.invokeV(1048579, this)) == null) ? (this.f46763e == null && this.f46764f == null && this.f46765g == null) ? false : true : invokeV.booleanValue;
    }

    public void Q(e2 e2Var) {
        Interceptable interceptable = $ic;
        if (!(interceptable == null || interceptable.invokeL(1048580, this, e2Var) == null) || e2Var == null || e2Var.L() == null) {
            return;
        }
        this.f46767i = true;
        this.f46768j = e2Var.L().oriUgcNid;
        this.l = e2Var.L().oriUgcType;
        this.n = e2Var.L().oriUgcVid;
        this.k = e2Var.d0;
        this.m = TbadkCoreApplication.getCurrentAccount();
        this.o = e2Var.u1() != null ? e2Var.u1().video_type.intValue() : 0;
    }

    public void R(String str) {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeL(1048581, this, str) == null) {
            this.f46766h = str;
        }
    }

    public void S(String str, String str2, String str3, String str4, int i2, int i3, boolean z, BaijiahaoData baijiahaoData, boolean z2) {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeCommon(1048582, this, new Object[]{str, str2, str3, str4, Integer.valueOf(i2), Integer.valueOf(i3), Boolean.valueOf(z), baijiahaoData, Boolean.valueOf(z2)}) == null) {
            a aVar = this.f46763e;
            if (aVar != null) {
                aVar.cancel();
                this.f46763e = null;
            }
            this.mLoadDataMode = 0;
            a aVar2 = new a(this, str, str2, str3, str4, i2, i3, z, baijiahaoData, z2);
            this.f46763e = aVar2;
            aVar2.setTag(UNIQUE_ID_DEL_POST_TASK);
            this.f46763e.setPriority(2);
            this.f46763e.execute(new String[0]);
        }
    }

    public void T(String str, String str2, String str3, int i2, String str4) {
        String str5;
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeCommon(1048583, this, new Object[]{str, str2, str3, Integer.valueOf(i2), str4}) == null) {
            f fVar = this.f46765g;
            if (fVar != null) {
                fVar.cancel();
                this.f46765g = null;
            }
            this.mLoadDataMode = i2;
            f fVar2 = new f(this, str, str2, str3, i2, str4);
            this.f46765g = fVar2;
            fVar2.setPriority(2);
            String str6 = TbConfig.SERVER_ADDRESS;
            if (i2 == 6) {
                str5 = str6 + TbConfig.GOOD_LIST_ADDRESS;
            } else if (i2 != 2 && i2 != 3) {
                str5 = str6 + TbConfig.COMMIT_TOP_ADDRESS;
            } else {
                str5 = str6 + TbConfig.COMMIT_GOOD_ADDRESS;
            }
            this.f46765g.execute(str5);
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
        this.f46763e = null;
        this.f46764f = null;
        this.f46765g = null;
        this.f46767i = false;
    }
}
