package com.baidu.tieba.tbadkCore.model;

import androidx.core.view.InputDeviceCompat;
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
import d.a.r0.r.q.b2;
import d.a.r0.r.q.m0;
import java.util.ArrayList;
import org.json.JSONArray;
import org.json.JSONObject;
/* loaded from: classes5.dex */
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
    public a f21119e;

    /* renamed from: f  reason: collision with root package name */
    public c f21120f;

    /* renamed from: g  reason: collision with root package name */
    public f f21121g;

    /* renamed from: h  reason: collision with root package name */
    public String f21122h;

    /* renamed from: i  reason: collision with root package name */
    public boolean f21123i;
    public String j;
    public int k;
    public int l;
    public String m;
    public String n;
    public int o;

    /* loaded from: classes5.dex */
    public class a extends BdAsyncTask<String, Integer, Boolean> {
        public static /* synthetic */ Interceptable $ic;
        public transient /* synthetic */ FieldHolder $fh;

        /* renamed from: a  reason: collision with root package name */
        public NetWork f21124a;

        /* renamed from: b  reason: collision with root package name */
        public String f21125b;

        /* renamed from: c  reason: collision with root package name */
        public String f21126c;

        /* renamed from: d  reason: collision with root package name */
        public String f21127d;

        /* renamed from: e  reason: collision with root package name */
        public String f21128e;

        /* renamed from: f  reason: collision with root package name */
        public int f21129f;

        /* renamed from: g  reason: collision with root package name */
        public int f21130g;

        /* renamed from: h  reason: collision with root package name */
        public boolean f21131h;

        /* renamed from: i  reason: collision with root package name */
        public String f21132i;
        public BaijiahaoData j;
        public final /* synthetic */ ForumManageModel k;

        public a(ForumManageModel forumManageModel, String str, String str2, String str3, String str4, int i2, int i3, boolean z, BaijiahaoData baijiahaoData) {
            Interceptable interceptable = $ic;
            if (interceptable != null) {
                InitContext newInitContext = TitanRuntime.newInitContext();
                newInitContext.initArgs = r2;
                Object[] objArr = {forumManageModel, str, str2, str3, str4, Integer.valueOf(i2), Integer.valueOf(i3), Boolean.valueOf(z), baijiahaoData};
                interceptable.invokeUnInit(65536, newInitContext);
                int i4 = newInitContext.flag;
                if ((i4 & 1) != 0) {
                    int i5 = i4 & 2;
                    newInitContext.thisArg = this;
                    interceptable.invokeInitBody(65536, newInitContext);
                    return;
                }
            }
            this.k = forumManageModel;
            this.f21124a = null;
            this.f21125b = str;
            this.f21126c = str2;
            this.f21127d = str3;
            this.f21128e = str4;
            this.f21129f = i2;
            this.f21130g = i3;
            this.f21131h = z;
            this.f21132i = forumManageModel.N();
            this.j = baijiahaoData;
        }

        @Override // com.baidu.adp.lib.asyncTask.BdAsyncTask
        public void cancel() {
            Interceptable interceptable = $ic;
            if (interceptable == null || interceptable.invokeV(1048576, this) == null) {
                NetWork netWork = this.f21124a;
                if (netWork != null) {
                    netWork.cancelNetConnect();
                }
                this.k.f21119e = null;
                super.cancel(true);
                this.k.mLoadDataCallBack.c(null);
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
                int i2 = this.f21129f;
                if (i2 != 0 && i2 != 3) {
                    str = str2 + TbConfig.DEL_POST_ADDRESS;
                } else {
                    str = str2 + TbConfig.DEL_THREAD_ADDRESS;
                }
                NetWork netWork = new NetWork(str);
                this.f21124a = netWork;
                netWork.addPostData("fid", this.f21125b);
                this.f21124a.addPostData("word", this.f21126c);
                this.f21124a.addPostData("z", this.f21127d);
                String str3 = this.f21132i;
                if (str3 != null) {
                    this.f21124a.addPostData("reason", str3);
                }
                int i3 = this.f21129f;
                if (i3 == 0) {
                    if (this.f21130g == 0) {
                        this.f21124a.addPostData("delete_my_thread", "1");
                    }
                } else if (i3 == 1) {
                    this.f21124a.addPostData("pid", this.f21128e);
                    this.f21124a.addPostData("isfloor", "0");
                    this.f21124a.addPostData("src", "1");
                    if (this.f21130g == 0 && this.f21131h) {
                        this.f21124a.addPostData("delete_my_post", "1");
                    }
                } else if (i3 == 2) {
                    this.f21124a.addPostData("pid", this.f21128e);
                    this.f21124a.addPostData("isfloor", "1");
                    this.f21124a.addPostData("src", "3");
                    if (this.f21130g == 0 && this.f21131h) {
                        this.f21124a.addPostData("delete_my_post", "1");
                    }
                } else if (i3 == 3) {
                    this.f21124a.addPostData("delete_my_thread", "1");
                    this.f21124a.addPostData("is_story", "1");
                }
                if (this.f21130g == 0 && !this.f21131h) {
                    this.f21124a.addPostData("is_vipdel", "1");
                } else {
                    this.f21124a.addPostData("is_vipdel", "0");
                }
                if (this.f21129f == 0 && this.k.f21123i) {
                    this.k.f21123i = false;
                    this.f21124a.addPostData("ori_ugc_nid", this.k.j);
                    this.f21124a.addPostData("thread_type", String.valueOf(this.k.k));
                    this.f21124a.addPostData(TiebaStatic.Params.UGC_TYPE, String.valueOf(this.k.l));
                    this.f21124a.addPostData("owner_uid", this.k.m);
                    this.f21124a.addPostData("ori_ugc_vid", this.k.n);
                    this.f21124a.addPostData("video_type", String.valueOf(this.k.o));
                } else {
                    BaijiahaoData baijiahaoData = this.j;
                    if (baijiahaoData != null) {
                        this.f21124a.addPostData("ori_ugc_nid", baijiahaoData.oriUgcNid);
                        this.f21124a.addPostData("ori_ugc_tid", this.j.oriUgcTid);
                        this.f21124a.addPostData(TiebaStatic.Params.UGC_TYPE, String.valueOf(this.j.oriUgcType));
                        this.f21124a.addPostData("ori_ugc_vid", this.j.oriUgcVid);
                        this.f21124a.addPostData("owner_uid", TbadkCoreApplication.getCurrentAccount());
                    }
                }
                this.f21124a.getNetContext().getRequest().mIsNeedTbs = true;
                this.f21124a.postNetData();
                if (this.f21124a.getNetContext().getResponse().isRequestSuccess()) {
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
                this.k.f21119e = null;
                if (this.f21124a == null || bool == null) {
                    this.k.mLoadDataCallBack.c(null);
                    return;
                }
                b bVar = new b(this.k);
                bVar.f21136d = this.f21129f;
                bVar.f21139g = this.f21128e;
                bVar.f21138f = this.f21131h;
                bVar.f21137e = this.f21130g;
                bVar.f21134b = this.f21124a.getErrorString();
                bVar.f21135c = this.f21124a.getServerErrorCode();
                bVar.f21133a = bool.booleanValue();
                this.k.mLoadDataCallBack.c(bVar);
            }
        }
    }

    /* loaded from: classes5.dex */
    public class b {
        public static /* synthetic */ Interceptable $ic;
        public transient /* synthetic */ FieldHolder $fh;

        /* renamed from: a  reason: collision with root package name */
        public boolean f21133a;

        /* renamed from: b  reason: collision with root package name */
        public String f21134b;

        /* renamed from: c  reason: collision with root package name */
        public int f21135c;

        /* renamed from: d  reason: collision with root package name */
        public int f21136d;

        /* renamed from: e  reason: collision with root package name */
        public int f21137e;

        /* renamed from: f  reason: collision with root package name */
        public boolean f21138f;

        /* renamed from: g  reason: collision with root package name */
        public String f21139g;

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

    /* loaded from: classes5.dex */
    public class c extends BdAsyncTask<String, Integer, String> {
        public static /* synthetic */ Interceptable $ic;
        public transient /* synthetic */ FieldHolder $fh;
    }

    /* loaded from: classes5.dex */
    public class d {
        public static /* synthetic */ Interceptable $ic;
        public transient /* synthetic */ FieldHolder $fh;

        /* renamed from: a  reason: collision with root package name */
        public boolean f21140a;

        /* renamed from: b  reason: collision with root package name */
        public String f21141b;
    }

    /* loaded from: classes5.dex */
    public static class e {
        public static /* synthetic */ Interceptable $ic;
        public transient /* synthetic */ FieldHolder $fh;

        /* renamed from: a  reason: collision with root package name */
        public String f21142a;

        /* renamed from: b  reason: collision with root package name */
        public String f21143b;

        /* renamed from: c  reason: collision with root package name */
        public String f21144c;

        /* renamed from: d  reason: collision with root package name */
        public int f21145d;

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

    /* loaded from: classes5.dex */
    public class f extends BdAsyncTask<String, String, Boolean> {
        public static /* synthetic */ Interceptable $ic;
        public transient /* synthetic */ FieldHolder $fh;

        /* renamed from: a  reason: collision with root package name */
        public NetWork f21146a;

        /* renamed from: b  reason: collision with root package name */
        public String f21147b;

        /* renamed from: c  reason: collision with root package name */
        public String f21148c;

        /* renamed from: d  reason: collision with root package name */
        public String f21149d;

        /* renamed from: e  reason: collision with root package name */
        public int f21150e;

        /* renamed from: f  reason: collision with root package name */
        public ArrayList<m0> f21151f;

        /* renamed from: g  reason: collision with root package name */
        public String f21152g;

        /* renamed from: h  reason: collision with root package name */
        public final /* synthetic */ ForumManageModel f21153h;

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
            this.f21153h = forumManageModel;
            this.f21146a = null;
            this.f21151f = null;
            this.f21152g = null;
            this.f21147b = str;
            this.f21148c = str2;
            this.f21149d = str3;
            this.f21150e = i2;
            this.f21152g = str4;
            this.f21151f = new ArrayList<>();
        }

        @Override // com.baidu.adp.lib.asyncTask.BdAsyncTask
        public void cancel() {
            Interceptable interceptable = $ic;
            if (interceptable == null || interceptable.invokeV(1048576, this) == null) {
                NetWork netWork = this.f21146a;
                if (netWork != null) {
                    netWork.cancelNetConnect();
                }
                this.f21153h.f21121g = null;
                super.cancel(true);
                this.f21153h.mLoadDataCallBack.c(null);
            }
        }

        /* JADX DEBUG: Method merged with bridge method */
        @Override // com.baidu.adp.lib.asyncTask.BdAsyncTask
        public Boolean doInBackground(String... strArr) {
            InterceptResult invokeL;
            Interceptable interceptable = $ic;
            if (interceptable == null || (invokeL = interceptable.invokeL(Constants.METHOD_GET_CONTACTER_INFO_FOR_SESSION, this, strArr)) == null) {
                NetWork netWork = new NetWork(strArr[0]);
                this.f21146a = netWork;
                netWork.addPostData("word", this.f21148c);
                if (this.f21150e != 6) {
                    this.f21146a.addPostData("fid", this.f21147b);
                    this.f21146a.addPostData("z", this.f21149d);
                    int i2 = this.f21150e;
                    if (i2 == 4) {
                        this.f21146a.addPostData("ntn", "set");
                    } else if (i2 == 5) {
                        this.f21146a.addPostData("ntn", "");
                    } else if (i2 == 2) {
                        this.f21146a.addPostData("ntn", "set");
                        this.f21146a.addPostData(IAdRequestParam.CELL_ID, this.f21152g);
                    } else {
                        this.f21146a.addPostData("ntn", "");
                    }
                    this.f21146a.addPostData("name_show", TbadkCoreApplication.getCurrentAccountNameShow());
                }
                this.f21146a.getNetContext().getRequest().mIsNeedTbs = true;
                String postNetData = this.f21146a.postNetData();
                if (this.f21146a.getNetContext().getResponse().isRequestSuccess()) {
                    if (this.f21150e == 6) {
                        try {
                            JSONArray optJSONArray = new JSONObject(postNetData).optJSONArray("cates");
                            for (int i3 = 0; i3 < optJSONArray.length(); i3++) {
                                m0 m0Var = new m0();
                                m0Var.c(optJSONArray.optJSONObject(i3));
                                this.f21151f.add(m0Var);
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
                this.f21153h.f21121g = null;
                if (this.f21146a == null) {
                    this.f21153h.mLoadDataCallBack.c(null);
                    return;
                }
                g gVar = new g(this.f21153h);
                gVar.f21154a = bool.booleanValue();
                if (bool.booleanValue()) {
                    if (this.f21150e == 6) {
                        gVar.f21156c = this.f21151f;
                    }
                } else {
                    gVar.f21155b = this.f21146a.getErrorString();
                }
                this.f21153h.mLoadDataCallBack.c(gVar);
            }
        }
    }

    /* loaded from: classes5.dex */
    public class g {
        public static /* synthetic */ Interceptable $ic;
        public transient /* synthetic */ FieldHolder $fh;

        /* renamed from: a  reason: collision with root package name */
        public boolean f21154a;

        /* renamed from: b  reason: collision with root package name */
        public String f21155b;

        /* renamed from: c  reason: collision with root package name */
        public ArrayList<m0> f21156c;

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
                super((d.a.c.a.f) newInitContext.callArgs[0]);
                newInitContext.thisArg = this;
                interceptable.invokeInitBody(65537, newInitContext);
                return;
            }
        }
        this.f21119e = null;
        this.f21120f = null;
        this.f21121g = null;
        this.f21123i = false;
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
            a aVar = this.f21119e;
            if (aVar != null) {
                aVar.cancel();
                this.f21119e = null;
            }
            c cVar = this.f21120f;
            if (cVar != null) {
                cVar.cancel();
                this.f21120f = null;
            }
            f fVar = this.f21121g;
            if (fVar != null) {
                fVar.cancel();
                this.f21121g = null;
            }
        }
    }

    public String N() {
        InterceptResult invokeV;
        Interceptable interceptable = $ic;
        return (interceptable == null || (invokeV = interceptable.invokeV(Constants.METHOD_SEND_USER_MSG, this)) == null) ? this.f21122h : (String) invokeV.objValue;
    }

    public boolean O() {
        InterceptResult invokeV;
        Interceptable interceptable = $ic;
        return (interceptable == null || (invokeV = interceptable.invokeV(1048579, this)) == null) ? (this.f21119e == null && this.f21120f == null && this.f21121g == null) ? false : true : invokeV.booleanValue;
    }

    public void P(b2 b2Var) {
        Interceptable interceptable = $ic;
        if (!(interceptable == null || interceptable.invokeL(1048580, this, b2Var) == null) || b2Var == null || b2Var.J() == null) {
            return;
        }
        this.f21123i = true;
        this.j = b2Var.J().oriUgcNid;
        this.l = b2Var.J().oriUgcType;
        this.n = b2Var.J().oriUgcVid;
        this.k = b2Var.Z;
        this.m = TbadkCoreApplication.getCurrentAccount();
        this.o = b2Var.l1() != null ? b2Var.l1().video_type.intValue() : 0;
    }

    public void Q(String str) {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeL(1048581, this, str) == null) {
            this.f21122h = str;
        }
    }

    public void R(String str, String str2, String str3, String str4, int i2, int i3, boolean z, BaijiahaoData baijiahaoData) {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeCommon(1048582, this, new Object[]{str, str2, str3, str4, Integer.valueOf(i2), Integer.valueOf(i3), Boolean.valueOf(z), baijiahaoData}) == null) {
            a aVar = this.f21119e;
            if (aVar != null) {
                aVar.cancel();
                this.f21119e = null;
            }
            this.mLoadDataMode = 0;
            a aVar2 = new a(this, str, str2, str3, str4, i2, i3, z, baijiahaoData);
            this.f21119e = aVar2;
            aVar2.setTag(UNIQUE_ID_DEL_POST_TASK);
            this.f21119e.setPriority(2);
            this.f21119e.execute(new String[0]);
        }
    }

    public void S(String str, String str2, String str3, int i2, String str4) {
        String str5;
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeCommon(1048583, this, new Object[]{str, str2, str3, Integer.valueOf(i2), str4}) == null) {
            f fVar = this.f21121g;
            if (fVar != null) {
                fVar.cancel();
                this.f21121g = null;
            }
            this.mLoadDataMode = i2;
            f fVar2 = new f(this, str, str2, str3, i2, str4);
            this.f21121g = fVar2;
            fVar2.setPriority(2);
            String str6 = TbConfig.SERVER_ADDRESS;
            if (i2 == 6) {
                str5 = str6 + TbConfig.GOOD_LIST_ADDRESS;
            } else if (i2 != 2 && i2 != 3) {
                str5 = str6 + TbConfig.COMMIT_TOP_ADDRESS;
            } else {
                str5 = str6 + TbConfig.COMMIT_GOOD_ADDRESS;
            }
            this.f21121g.execute(str5);
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
                super((d.a.c.a.f) newInitContext.callArgs[0]);
                newInitContext.thisArg = this;
                interceptable.invokeInitBody(65538, newInitContext);
                return;
            }
        }
        this.f21119e = null;
        this.f21120f = null;
        this.f21121g = null;
        this.f21123i = false;
    }
}
