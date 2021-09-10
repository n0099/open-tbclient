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
    public a f57109e;

    /* renamed from: f  reason: collision with root package name */
    public c f57110f;

    /* renamed from: g  reason: collision with root package name */
    public f f57111g;

    /* renamed from: h  reason: collision with root package name */
    public String f57112h;

    /* renamed from: i  reason: collision with root package name */
    public boolean f57113i;

    /* renamed from: j  reason: collision with root package name */
    public String f57114j;
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
        public NetWork f57115a;

        /* renamed from: b  reason: collision with root package name */
        public String f57116b;

        /* renamed from: c  reason: collision with root package name */
        public String f57117c;

        /* renamed from: d  reason: collision with root package name */
        public String f57118d;

        /* renamed from: e  reason: collision with root package name */
        public String f57119e;

        /* renamed from: f  reason: collision with root package name */
        public int f57120f;

        /* renamed from: g  reason: collision with root package name */
        public int f57121g;

        /* renamed from: h  reason: collision with root package name */
        public boolean f57122h;

        /* renamed from: i  reason: collision with root package name */
        public String f57123i;

        /* renamed from: j  reason: collision with root package name */
        public BaijiahaoData f57124j;
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
            this.f57115a = null;
            this.f57116b = str;
            this.f57117c = str2;
            this.f57118d = str3;
            this.f57119e = str4;
            this.f57120f = i2;
            this.f57121g = i3;
            this.f57122h = z;
            this.f57123i = forumManageModel.O();
            this.f57124j = baijiahaoData;
            this.k = z2;
        }

        @Override // com.baidu.adp.lib.asyncTask.BdAsyncTask
        public void cancel() {
            Interceptable interceptable = $ic;
            if (interceptable == null || interceptable.invokeV(1048576, this) == null) {
                NetWork netWork = this.f57115a;
                if (netWork != null) {
                    netWork.cancelNetConnect();
                }
                this.l.f57109e = null;
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
                int i2 = this.f57120f;
                if (i2 != 0 && i2 != 3) {
                    str = str2 + TbConfig.DEL_POST_ADDRESS;
                } else {
                    str = str2 + TbConfig.DEL_THREAD_ADDRESS;
                }
                NetWork netWork = new NetWork(str);
                this.f57115a = netWork;
                netWork.addPostData("fid", this.f57116b);
                this.f57115a.addPostData("word", this.f57117c);
                this.f57115a.addPostData("z", this.f57118d);
                String str3 = this.f57123i;
                if (str3 != null) {
                    this.f57115a.addPostData("reason", str3);
                }
                int i3 = this.f57120f;
                if (i3 == 0) {
                    if (this.f57121g == 0) {
                        this.f57115a.addPostData("delete_my_thread", "1");
                    }
                } else if (i3 == 1) {
                    this.f57115a.addPostData("pid", this.f57119e);
                    this.f57115a.addPostData("isfloor", "0");
                    this.f57115a.addPostData("src", "1");
                    if (this.f57121g == 0 && this.f57122h) {
                        this.f57115a.addPostData("delete_my_post", "1");
                    }
                } else if (i3 == 2) {
                    this.f57115a.addPostData("pid", this.f57119e);
                    this.f57115a.addPostData("isfloor", "1");
                    this.f57115a.addPostData("src", "3");
                    if (this.f57121g == 0 && this.f57122h) {
                        this.f57115a.addPostData("delete_my_post", "1");
                    }
                } else if (i3 == 3) {
                    this.f57115a.addPostData("delete_my_thread", "1");
                    this.f57115a.addPostData("is_story", "1");
                }
                if (this.f57121g == 0 && !this.f57122h) {
                    this.f57115a.addPostData("is_vipdel", "1");
                } else {
                    this.f57115a.addPostData("is_vipdel", "0");
                }
                if (this.f57120f == 0 && this.l.f57113i) {
                    this.l.f57113i = false;
                    this.f57115a.addPostData("ori_ugc_nid", this.l.f57114j);
                    this.f57115a.addPostData("thread_type", String.valueOf(this.l.k));
                    this.f57115a.addPostData(TiebaStatic.Params.UGC_TYPE, String.valueOf(this.l.l));
                    this.f57115a.addPostData("owner_uid", this.l.m);
                    this.f57115a.addPostData("ori_ugc_vid", this.l.n);
                    this.f57115a.addPostData("video_type", String.valueOf(this.l.o));
                } else {
                    BaijiahaoData baijiahaoData = this.f57124j;
                    if (baijiahaoData != null) {
                        this.f57115a.addPostData("ori_ugc_nid", baijiahaoData.oriUgcNid);
                        this.f57115a.addPostData("ori_ugc_tid", this.f57124j.oriUgcTid);
                        this.f57115a.addPostData(TiebaStatic.Params.UGC_TYPE, String.valueOf(this.f57124j.oriUgcType));
                        this.f57115a.addPostData("ori_ugc_vid", this.f57124j.oriUgcVid);
                        this.f57115a.addPostData("owner_uid", TbadkCoreApplication.getCurrentAccount());
                    }
                }
                if (this.k) {
                    this.f57115a.addPostData("is_frs_mask", "1");
                }
                this.f57115a.getNetContext().getRequest().mIsNeedTbs = true;
                this.f57115a.postNetData();
                if (this.f57115a.getNetContext().getResponse().isRequestSuccess()) {
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
                this.l.f57109e = null;
                if (this.f57115a == null || bool == null) {
                    this.l.mLoadDataCallBack.c(null);
                    return;
                }
                b bVar = new b(this.l);
                bVar.f57128d = this.f57120f;
                bVar.f57131g = this.f57119e;
                bVar.f57130f = this.f57122h;
                bVar.f57129e = this.f57121g;
                bVar.f57126b = this.f57115a.getErrorString();
                bVar.f57127c = this.f57115a.getServerErrorCode();
                bVar.f57125a = bool.booleanValue();
                bVar.f57132h = this.k;
                this.l.mLoadDataCallBack.c(bVar);
            }
        }
    }

    /* loaded from: classes7.dex */
    public class b {
        public static /* synthetic */ Interceptable $ic;
        public transient /* synthetic */ FieldHolder $fh;

        /* renamed from: a  reason: collision with root package name */
        public boolean f57125a;

        /* renamed from: b  reason: collision with root package name */
        public String f57126b;

        /* renamed from: c  reason: collision with root package name */
        public int f57127c;

        /* renamed from: d  reason: collision with root package name */
        public int f57128d;

        /* renamed from: e  reason: collision with root package name */
        public int f57129e;

        /* renamed from: f  reason: collision with root package name */
        public boolean f57130f;

        /* renamed from: g  reason: collision with root package name */
        public String f57131g;

        /* renamed from: h  reason: collision with root package name */
        public boolean f57132h;

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
        public boolean f57133a;

        /* renamed from: b  reason: collision with root package name */
        public String f57134b;
    }

    /* loaded from: classes7.dex */
    public static class e {
        public static /* synthetic */ Interceptable $ic;
        public transient /* synthetic */ FieldHolder $fh;

        /* renamed from: a  reason: collision with root package name */
        public String f57135a;

        /* renamed from: b  reason: collision with root package name */
        public String f57136b;

        /* renamed from: c  reason: collision with root package name */
        public String f57137c;

        /* renamed from: d  reason: collision with root package name */
        public int f57138d;

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
        public NetWork f57139a;

        /* renamed from: b  reason: collision with root package name */
        public String f57140b;

        /* renamed from: c  reason: collision with root package name */
        public String f57141c;

        /* renamed from: d  reason: collision with root package name */
        public String f57142d;

        /* renamed from: e  reason: collision with root package name */
        public int f57143e;

        /* renamed from: f  reason: collision with root package name */
        public ArrayList<m0> f57144f;

        /* renamed from: g  reason: collision with root package name */
        public String f57145g;

        /* renamed from: h  reason: collision with root package name */
        public final /* synthetic */ ForumManageModel f57146h;

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
            this.f57146h = forumManageModel;
            this.f57139a = null;
            this.f57144f = null;
            this.f57145g = null;
            this.f57140b = str;
            this.f57141c = str2;
            this.f57142d = str3;
            this.f57143e = i2;
            this.f57145g = str4;
            this.f57144f = new ArrayList<>();
        }

        @Override // com.baidu.adp.lib.asyncTask.BdAsyncTask
        public void cancel() {
            Interceptable interceptable = $ic;
            if (interceptable == null || interceptable.invokeV(1048576, this) == null) {
                NetWork netWork = this.f57139a;
                if (netWork != null) {
                    netWork.cancelNetConnect();
                }
                this.f57146h.f57111g = null;
                super.cancel(true);
                this.f57146h.mLoadDataCallBack.c(null);
            }
        }

        /* JADX DEBUG: Method merged with bridge method */
        @Override // com.baidu.adp.lib.asyncTask.BdAsyncTask
        public Boolean doInBackground(String... strArr) {
            InterceptResult invokeL;
            Interceptable interceptable = $ic;
            if (interceptable == null || (invokeL = interceptable.invokeL(Constants.METHOD_GET_CONTACTER_INFO_FOR_SESSION, this, strArr)) == null) {
                NetWork netWork = new NetWork(strArr[0]);
                this.f57139a = netWork;
                netWork.addPostData("word", this.f57141c);
                if (this.f57143e != 6) {
                    this.f57139a.addPostData("fid", this.f57140b);
                    this.f57139a.addPostData("z", this.f57142d);
                    int i2 = this.f57143e;
                    if (i2 == 4) {
                        this.f57139a.addPostData("ntn", "set");
                    } else if (i2 == 5) {
                        this.f57139a.addPostData("ntn", "");
                    } else if (i2 == 2) {
                        this.f57139a.addPostData("ntn", "set");
                        this.f57139a.addPostData(IAdRequestParam.CELL_ID, this.f57145g);
                    } else {
                        this.f57139a.addPostData("ntn", "");
                    }
                    this.f57139a.addPostData("name_show", TbadkCoreApplication.getCurrentAccountNameShow());
                }
                this.f57139a.getNetContext().getRequest().mIsNeedTbs = true;
                String postNetData = this.f57139a.postNetData();
                if (this.f57139a.getNetContext().getResponse().isRequestSuccess()) {
                    if (this.f57143e == 6) {
                        try {
                            JSONArray optJSONArray = new JSONObject(postNetData).optJSONArray("cates");
                            for (int i3 = 0; i3 < optJSONArray.length(); i3++) {
                                m0 m0Var = new m0();
                                m0Var.c(optJSONArray.optJSONObject(i3));
                                this.f57144f.add(m0Var);
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
                this.f57146h.f57111g = null;
                if (this.f57139a == null) {
                    this.f57146h.mLoadDataCallBack.c(null);
                    return;
                }
                g gVar = new g(this.f57146h);
                gVar.f57147a = bool.booleanValue();
                if (bool.booleanValue()) {
                    if (this.f57143e == 6) {
                        gVar.f57149c = this.f57144f;
                    }
                } else {
                    gVar.f57148b = this.f57139a.getErrorString();
                }
                this.f57146h.mLoadDataCallBack.c(gVar);
            }
        }
    }

    /* loaded from: classes7.dex */
    public class g {
        public static /* synthetic */ Interceptable $ic;
        public transient /* synthetic */ FieldHolder $fh;

        /* renamed from: a  reason: collision with root package name */
        public boolean f57147a;

        /* renamed from: b  reason: collision with root package name */
        public String f57148b;

        /* renamed from: c  reason: collision with root package name */
        public ArrayList<m0> f57149c;

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
        this.f57109e = null;
        this.f57110f = null;
        this.f57111g = null;
        this.f57113i = false;
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
            a aVar = this.f57109e;
            if (aVar != null) {
                aVar.cancel();
                this.f57109e = null;
            }
            c cVar = this.f57110f;
            if (cVar != null) {
                cVar.cancel();
                this.f57110f = null;
            }
            f fVar = this.f57111g;
            if (fVar != null) {
                fVar.cancel();
                this.f57111g = null;
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
            return BarManageResultListener.a.a(optType, gVar.f57147a, gVar.f57148b);
        }
        return (BarManageResultListener.a) invokeIL.objValue;
    }

    public String O() {
        InterceptResult invokeV;
        Interceptable interceptable = $ic;
        return (interceptable == null || (invokeV = interceptable.invokeV(1048579, this)) == null) ? this.f57112h : (String) invokeV.objValue;
    }

    public boolean P() {
        InterceptResult invokeV;
        Interceptable interceptable = $ic;
        return (interceptable == null || (invokeV = interceptable.invokeV(1048580, this)) == null) ? (this.f57109e == null && this.f57110f == null && this.f57111g == null) ? false : true : invokeV.booleanValue;
    }

    public void Q(d2 d2Var) {
        Interceptable interceptable = $ic;
        if (!(interceptable == null || interceptable.invokeL(1048581, this, d2Var) == null) || d2Var == null || d2Var.L() == null) {
            return;
        }
        this.f57113i = true;
        this.f57114j = d2Var.L().oriUgcNid;
        this.l = d2Var.L().oriUgcType;
        this.n = d2Var.L().oriUgcVid;
        this.k = d2Var.c0;
        this.m = TbadkCoreApplication.getCurrentAccount();
        this.o = d2Var.q1() != null ? d2Var.q1().video_type.intValue() : 0;
    }

    public void R(String str) {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeL(1048582, this, str) == null) {
            this.f57112h = str;
        }
    }

    public void S(String str, String str2, String str3, String str4, int i2, int i3, boolean z, BaijiahaoData baijiahaoData, boolean z2) {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeCommon(1048583, this, new Object[]{str, str2, str3, str4, Integer.valueOf(i2), Integer.valueOf(i3), Boolean.valueOf(z), baijiahaoData, Boolean.valueOf(z2)}) == null) {
            a aVar = this.f57109e;
            if (aVar != null) {
                aVar.cancel();
                this.f57109e = null;
            }
            this.mLoadDataMode = 0;
            a aVar2 = new a(this, str, str2, str3, str4, i2, i3, z, baijiahaoData, z2);
            this.f57109e = aVar2;
            aVar2.setTag(UNIQUE_ID_DEL_POST_TASK);
            this.f57109e.setPriority(2);
            this.f57109e.execute(new String[0]);
        }
    }

    public void T(String str, String str2, String str3, int i2, String str4) {
        String str5;
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeCommon(InputDeviceCompat.SOURCE_TOUCHPAD, this, new Object[]{str, str2, str3, Integer.valueOf(i2), str4}) == null) {
            f fVar = this.f57111g;
            if (fVar != null) {
                fVar.cancel();
                this.f57111g = null;
            }
            this.mLoadDataMode = i2;
            f fVar2 = new f(this, str, str2, str3, i2, str4);
            this.f57111g = fVar2;
            fVar2.setPriority(2);
            String str6 = TbConfig.SERVER_ADDRESS;
            if (i2 == 6) {
                str5 = str6 + TbConfig.GOOD_LIST_ADDRESS;
            } else if (i2 != 2 && i2 != 3) {
                str5 = str6 + TbConfig.COMMIT_TOP_ADDRESS;
            } else {
                str5 = str6 + TbConfig.COMMIT_GOOD_ADDRESS;
            }
            this.f57111g.execute(str5);
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
        this.f57109e = null;
        this.f57110f = null;
        this.f57111g = null;
        this.f57113i = false;
    }
}
