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
    public a f57160e;

    /* renamed from: f  reason: collision with root package name */
    public c f57161f;

    /* renamed from: g  reason: collision with root package name */
    public f f57162g;

    /* renamed from: h  reason: collision with root package name */
    public String f57163h;

    /* renamed from: i  reason: collision with root package name */
    public boolean f57164i;

    /* renamed from: j  reason: collision with root package name */
    public String f57165j;
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
        public NetWork f57166a;

        /* renamed from: b  reason: collision with root package name */
        public String f57167b;

        /* renamed from: c  reason: collision with root package name */
        public String f57168c;

        /* renamed from: d  reason: collision with root package name */
        public String f57169d;

        /* renamed from: e  reason: collision with root package name */
        public String f57170e;

        /* renamed from: f  reason: collision with root package name */
        public int f57171f;

        /* renamed from: g  reason: collision with root package name */
        public int f57172g;

        /* renamed from: h  reason: collision with root package name */
        public boolean f57173h;

        /* renamed from: i  reason: collision with root package name */
        public String f57174i;

        /* renamed from: j  reason: collision with root package name */
        public BaijiahaoData f57175j;
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
            this.f57166a = null;
            this.f57167b = str;
            this.f57168c = str2;
            this.f57169d = str3;
            this.f57170e = str4;
            this.f57171f = i2;
            this.f57172g = i3;
            this.f57173h = z;
            this.f57174i = forumManageModel.O();
            this.f57175j = baijiahaoData;
            this.k = z2;
        }

        @Override // com.baidu.adp.lib.asyncTask.BdAsyncTask
        public void cancel() {
            Interceptable interceptable = $ic;
            if (interceptable == null || interceptable.invokeV(1048576, this) == null) {
                NetWork netWork = this.f57166a;
                if (netWork != null) {
                    netWork.cancelNetConnect();
                }
                this.l.f57160e = null;
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
                int i2 = this.f57171f;
                if (i2 != 0 && i2 != 3) {
                    str = str2 + TbConfig.DEL_POST_ADDRESS;
                } else {
                    str = str2 + TbConfig.DEL_THREAD_ADDRESS;
                }
                NetWork netWork = new NetWork(str);
                this.f57166a = netWork;
                netWork.addPostData("fid", this.f57167b);
                this.f57166a.addPostData("word", this.f57168c);
                this.f57166a.addPostData("z", this.f57169d);
                String str3 = this.f57174i;
                if (str3 != null) {
                    this.f57166a.addPostData("reason", str3);
                }
                int i3 = this.f57171f;
                if (i3 == 0) {
                    if (this.f57172g == 0) {
                        this.f57166a.addPostData("delete_my_thread", "1");
                    }
                } else if (i3 == 1) {
                    this.f57166a.addPostData("pid", this.f57170e);
                    this.f57166a.addPostData("isfloor", "0");
                    this.f57166a.addPostData("src", "1");
                    if (this.f57172g == 0 && this.f57173h) {
                        this.f57166a.addPostData("delete_my_post", "1");
                    }
                } else if (i3 == 2) {
                    this.f57166a.addPostData("pid", this.f57170e);
                    this.f57166a.addPostData("isfloor", "1");
                    this.f57166a.addPostData("src", "3");
                    if (this.f57172g == 0 && this.f57173h) {
                        this.f57166a.addPostData("delete_my_post", "1");
                    }
                } else if (i3 == 3) {
                    this.f57166a.addPostData("delete_my_thread", "1");
                    this.f57166a.addPostData("is_story", "1");
                }
                if (this.f57172g == 0 && !this.f57173h) {
                    this.f57166a.addPostData("is_vipdel", "1");
                } else {
                    this.f57166a.addPostData("is_vipdel", "0");
                }
                if (this.f57171f == 0 && this.l.f57164i) {
                    this.l.f57164i = false;
                    this.f57166a.addPostData("ori_ugc_nid", this.l.f57165j);
                    this.f57166a.addPostData("thread_type", String.valueOf(this.l.k));
                    this.f57166a.addPostData(TiebaStatic.Params.UGC_TYPE, String.valueOf(this.l.l));
                    this.f57166a.addPostData("owner_uid", this.l.m);
                    this.f57166a.addPostData("ori_ugc_vid", this.l.n);
                    this.f57166a.addPostData("video_type", String.valueOf(this.l.o));
                } else {
                    BaijiahaoData baijiahaoData = this.f57175j;
                    if (baijiahaoData != null) {
                        this.f57166a.addPostData("ori_ugc_nid", baijiahaoData.oriUgcNid);
                        this.f57166a.addPostData("ori_ugc_tid", this.f57175j.oriUgcTid);
                        this.f57166a.addPostData(TiebaStatic.Params.UGC_TYPE, String.valueOf(this.f57175j.oriUgcType));
                        this.f57166a.addPostData("ori_ugc_vid", this.f57175j.oriUgcVid);
                        this.f57166a.addPostData("owner_uid", TbadkCoreApplication.getCurrentAccount());
                    }
                }
                if (this.k) {
                    this.f57166a.addPostData("is_frs_mask", "1");
                }
                this.f57166a.getNetContext().getRequest().mIsNeedTbs = true;
                this.f57166a.postNetData();
                if (this.f57166a.getNetContext().getResponse().isRequestSuccess()) {
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
                this.l.f57160e = null;
                if (this.f57166a == null || bool == null) {
                    this.l.mLoadDataCallBack.c(null);
                    return;
                }
                b bVar = new b(this.l);
                bVar.f57179d = this.f57171f;
                bVar.f57182g = this.f57170e;
                bVar.f57181f = this.f57173h;
                bVar.f57180e = this.f57172g;
                bVar.f57177b = this.f57166a.getErrorString();
                bVar.f57178c = this.f57166a.getServerErrorCode();
                bVar.f57176a = bool.booleanValue();
                bVar.f57183h = this.k;
                this.l.mLoadDataCallBack.c(bVar);
            }
        }
    }

    /* loaded from: classes7.dex */
    public class b {
        public static /* synthetic */ Interceptable $ic;
        public transient /* synthetic */ FieldHolder $fh;

        /* renamed from: a  reason: collision with root package name */
        public boolean f57176a;

        /* renamed from: b  reason: collision with root package name */
        public String f57177b;

        /* renamed from: c  reason: collision with root package name */
        public int f57178c;

        /* renamed from: d  reason: collision with root package name */
        public int f57179d;

        /* renamed from: e  reason: collision with root package name */
        public int f57180e;

        /* renamed from: f  reason: collision with root package name */
        public boolean f57181f;

        /* renamed from: g  reason: collision with root package name */
        public String f57182g;

        /* renamed from: h  reason: collision with root package name */
        public boolean f57183h;

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
        public boolean f57184a;

        /* renamed from: b  reason: collision with root package name */
        public String f57185b;
    }

    /* loaded from: classes7.dex */
    public static class e {
        public static /* synthetic */ Interceptable $ic;
        public transient /* synthetic */ FieldHolder $fh;

        /* renamed from: a  reason: collision with root package name */
        public String f57186a;

        /* renamed from: b  reason: collision with root package name */
        public String f57187b;

        /* renamed from: c  reason: collision with root package name */
        public String f57188c;

        /* renamed from: d  reason: collision with root package name */
        public int f57189d;

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
        public NetWork f57190a;

        /* renamed from: b  reason: collision with root package name */
        public String f57191b;

        /* renamed from: c  reason: collision with root package name */
        public String f57192c;

        /* renamed from: d  reason: collision with root package name */
        public String f57193d;

        /* renamed from: e  reason: collision with root package name */
        public int f57194e;

        /* renamed from: f  reason: collision with root package name */
        public ArrayList<m0> f57195f;

        /* renamed from: g  reason: collision with root package name */
        public String f57196g;

        /* renamed from: h  reason: collision with root package name */
        public final /* synthetic */ ForumManageModel f57197h;

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
            this.f57197h = forumManageModel;
            this.f57190a = null;
            this.f57195f = null;
            this.f57196g = null;
            this.f57191b = str;
            this.f57192c = str2;
            this.f57193d = str3;
            this.f57194e = i2;
            this.f57196g = str4;
            this.f57195f = new ArrayList<>();
        }

        @Override // com.baidu.adp.lib.asyncTask.BdAsyncTask
        public void cancel() {
            Interceptable interceptable = $ic;
            if (interceptable == null || interceptable.invokeV(1048576, this) == null) {
                NetWork netWork = this.f57190a;
                if (netWork != null) {
                    netWork.cancelNetConnect();
                }
                this.f57197h.f57162g = null;
                super.cancel(true);
                this.f57197h.mLoadDataCallBack.c(null);
            }
        }

        /* JADX DEBUG: Method merged with bridge method */
        @Override // com.baidu.adp.lib.asyncTask.BdAsyncTask
        public Boolean doInBackground(String... strArr) {
            InterceptResult invokeL;
            Interceptable interceptable = $ic;
            if (interceptable == null || (invokeL = interceptable.invokeL(Constants.METHOD_GET_CONTACTER_INFO_FOR_SESSION, this, strArr)) == null) {
                NetWork netWork = new NetWork(strArr[0]);
                this.f57190a = netWork;
                netWork.addPostData("word", this.f57192c);
                if (this.f57194e != 6) {
                    this.f57190a.addPostData("fid", this.f57191b);
                    this.f57190a.addPostData("z", this.f57193d);
                    int i2 = this.f57194e;
                    if (i2 == 4) {
                        this.f57190a.addPostData("ntn", "set");
                    } else if (i2 == 5) {
                        this.f57190a.addPostData("ntn", "");
                    } else if (i2 == 2) {
                        this.f57190a.addPostData("ntn", "set");
                        this.f57190a.addPostData(IAdRequestParam.CELL_ID, this.f57196g);
                    } else {
                        this.f57190a.addPostData("ntn", "");
                    }
                    this.f57190a.addPostData("name_show", TbadkCoreApplication.getCurrentAccountNameShow());
                }
                this.f57190a.getNetContext().getRequest().mIsNeedTbs = true;
                String postNetData = this.f57190a.postNetData();
                if (this.f57190a.getNetContext().getResponse().isRequestSuccess()) {
                    if (this.f57194e == 6) {
                        try {
                            JSONArray optJSONArray = new JSONObject(postNetData).optJSONArray("cates");
                            for (int i3 = 0; i3 < optJSONArray.length(); i3++) {
                                m0 m0Var = new m0();
                                m0Var.c(optJSONArray.optJSONObject(i3));
                                this.f57195f.add(m0Var);
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
                this.f57197h.f57162g = null;
                if (this.f57190a == null) {
                    this.f57197h.mLoadDataCallBack.c(null);
                    return;
                }
                g gVar = new g(this.f57197h);
                gVar.f57198a = bool.booleanValue();
                if (bool.booleanValue()) {
                    if (this.f57194e == 6) {
                        gVar.f57200c = this.f57195f;
                    }
                } else {
                    gVar.f57199b = this.f57190a.getErrorString();
                }
                this.f57197h.mLoadDataCallBack.c(gVar);
            }
        }
    }

    /* loaded from: classes7.dex */
    public class g {
        public static /* synthetic */ Interceptable $ic;
        public transient /* synthetic */ FieldHolder $fh;

        /* renamed from: a  reason: collision with root package name */
        public boolean f57198a;

        /* renamed from: b  reason: collision with root package name */
        public String f57199b;

        /* renamed from: c  reason: collision with root package name */
        public ArrayList<m0> f57200c;

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
        this.f57160e = null;
        this.f57161f = null;
        this.f57162g = null;
        this.f57164i = false;
    }

    public void M() {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeV(1048576, this) == null) {
            a aVar = this.f57160e;
            if (aVar != null) {
                aVar.cancel();
                this.f57160e = null;
            }
            c cVar = this.f57161f;
            if (cVar != null) {
                cVar.cancel();
                this.f57161f = null;
            }
            f fVar = this.f57162g;
            if (fVar != null) {
                fVar.cancel();
                this.f57162g = null;
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
            return BarManageResultListener.a.a(optType, gVar.f57198a, gVar.f57199b);
        }
        return (BarManageResultListener.a) invokeIL.objValue;
    }

    public String O() {
        InterceptResult invokeV;
        Interceptable interceptable = $ic;
        return (interceptable == null || (invokeV = interceptable.invokeV(Constants.METHOD_SEND_USER_MSG, this)) == null) ? this.f57163h : (String) invokeV.objValue;
    }

    public boolean P() {
        InterceptResult invokeV;
        Interceptable interceptable = $ic;
        return (interceptable == null || (invokeV = interceptable.invokeV(1048579, this)) == null) ? (this.f57160e == null && this.f57161f == null && this.f57162g == null) ? false : true : invokeV.booleanValue;
    }

    public void Q(d2 d2Var) {
        Interceptable interceptable = $ic;
        if (!(interceptable == null || interceptable.invokeL(1048580, this, d2Var) == null) || d2Var == null || d2Var.L() == null) {
            return;
        }
        this.f57164i = true;
        this.f57165j = d2Var.L().oriUgcNid;
        this.l = d2Var.L().oriUgcType;
        this.n = d2Var.L().oriUgcVid;
        this.k = d2Var.i0;
        this.m = TbadkCoreApplication.getCurrentAccount();
        this.o = d2Var.q1() != null ? d2Var.q1().video_type.intValue() : 0;
    }

    public void R(String str) {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeL(1048581, this, str) == null) {
            this.f57163h = str;
        }
    }

    public void S(String str, String str2, String str3, String str4, int i2, int i3, boolean z, BaijiahaoData baijiahaoData, boolean z2) {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeCommon(1048582, this, new Object[]{str, str2, str3, str4, Integer.valueOf(i2), Integer.valueOf(i3), Boolean.valueOf(z), baijiahaoData, Boolean.valueOf(z2)}) == null) {
            a aVar = this.f57160e;
            if (aVar != null) {
                aVar.cancel();
                this.f57160e = null;
            }
            this.mLoadDataMode = 0;
            a aVar2 = new a(this, str, str2, str3, str4, i2, i3, z, baijiahaoData, z2);
            this.f57160e = aVar2;
            aVar2.setTag(UNIQUE_ID_DEL_POST_TASK);
            this.f57160e.setPriority(2);
            this.f57160e.execute(new String[0]);
        }
    }

    public void T(String str, String str2, String str3, int i2, String str4) {
        String str5;
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeCommon(1048583, this, new Object[]{str, str2, str3, Integer.valueOf(i2), str4}) == null) {
            f fVar = this.f57162g;
            if (fVar != null) {
                fVar.cancel();
                this.f57162g = null;
            }
            this.mLoadDataMode = i2;
            f fVar2 = new f(this, str, str2, str3, i2, str4);
            this.f57162g = fVar2;
            fVar2.setPriority(2);
            String str6 = TbConfig.SERVER_ADDRESS;
            if (i2 == 6) {
                str5 = str6 + TbConfig.GOOD_LIST_ADDRESS;
            } else if (i2 != 2 && i2 != 3) {
                str5 = str6 + TbConfig.COMMIT_TOP_ADDRESS;
            } else {
                str5 = str6 + TbConfig.COMMIT_GOOD_ADDRESS;
            }
            this.f57162g.execute(str5);
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
                super((c.a.e.a.f) newInitContext.callArgs[0]);
                newInitContext.thisArg = this;
                interceptable.invokeInitBody(65538, newInitContext);
                return;
            }
        }
        this.f57160e = null;
        this.f57161f = null;
        this.f57162g = null;
        this.f57164i = false;
    }
}
