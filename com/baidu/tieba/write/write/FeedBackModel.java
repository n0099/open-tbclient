package com.baidu.tieba.write.write;

import c.a.e.a.f;
import c.a.p0.s.q.c2;
import com.baidu.adp.base.BdBaseModel;
import com.baidu.adp.lib.asyncTask.BdAsyncTask;
import com.baidu.adp.lib.util.BdLog;
import com.baidu.android.imsdk.internal.Constants;
import com.baidu.tbadk.TbConfig;
import com.baidu.tbadk.TbPageContext;
import com.baidu.tbadk.core.util.NetWork;
import com.baidu.tbadk.core.util.TiebaStatic;
import com.baidu.titan.sdk.runtime.FieldHolder;
import com.baidu.titan.sdk.runtime.InitContext;
import com.baidu.titan.sdk.runtime.InterceptResult;
import com.baidu.titan.sdk.runtime.Interceptable;
import com.baidu.titan.sdk.runtime.TitanRuntime;
import java.util.ArrayList;
import org.json.JSONArray;
import org.json.JSONObject;
/* loaded from: classes7.dex */
public class FeedBackModel extends BdBaseModel<TbPageContext> {
    public static /* synthetic */ Interceptable $ic;
    public transient /* synthetic */ FieldHolder $fh;

    /* renamed from: e  reason: collision with root package name */
    public b f58754e;

    /* renamed from: f  reason: collision with root package name */
    public ArrayList<c2> f58755f;

    /* renamed from: g  reason: collision with root package name */
    public int f58756g;

    /* renamed from: h  reason: collision with root package name */
    public TbPageContext f58757h;

    /* loaded from: classes7.dex */
    public static /* synthetic */ class a {
        public static /* synthetic */ Interceptable $ic;
        public transient /* synthetic */ FieldHolder $fh;
    }

    /* loaded from: classes7.dex */
    public class b extends BdAsyncTask<Object, FeedBackModel, FeedBackModel> {
        public static /* synthetic */ Interceptable $ic;
        public transient /* synthetic */ FieldHolder $fh;

        /* renamed from: a  reason: collision with root package name */
        public NetWork f58758a;

        /* renamed from: b  reason: collision with root package name */
        public final /* synthetic */ FeedBackModel f58759b;

        public b(FeedBackModel feedBackModel) {
            Interceptable interceptable = $ic;
            if (interceptable != null) {
                InitContext newInitContext = TitanRuntime.newInitContext();
                newInitContext.initArgs = r2;
                Object[] objArr = {feedBackModel};
                interceptable.invokeUnInit(65536, newInitContext);
                int i2 = newInitContext.flag;
                if ((i2 & 1) != 0) {
                    int i3 = i2 & 2;
                    newInitContext.thisArg = this;
                    interceptable.invokeInitBody(65536, newInitContext);
                    return;
                }
            }
            this.f58759b = feedBackModel;
        }

        /* JADX DEBUG: Method merged with bridge method */
        @Override // com.baidu.adp.lib.asyncTask.BdAsyncTask
        /* renamed from: b */
        public FeedBackModel doInBackground(Object... objArr) {
            InterceptResult invokeL;
            Interceptable interceptable = $ic;
            if (interceptable == null || (invokeL = interceptable.invokeL(1048576, this, objArr)) == null) {
                String obj = objArr[0].toString();
                NetWork netWork = new NetWork(TbConfig.SERVER_ADDRESS + "c/f/frs/toplist");
                this.f58758a = netWork;
                netWork.addPostData(TiebaStatic.Params.H5_FORUM_NAME, obj);
                String postNetData = this.f58758a.postNetData();
                if (this.f58758a.getNetContext().getResponse().isRequestSuccess()) {
                    FeedBackModel feedBackModel = new FeedBackModel(this.f58759b.f58757h);
                    feedBackModel.parserJson(postNetData);
                    return feedBackModel;
                }
                return null;
            }
            return (FeedBackModel) invokeL.objValue;
        }

        /* JADX DEBUG: Method merged with bridge method */
        @Override // com.baidu.adp.lib.asyncTask.BdAsyncTask
        /* renamed from: c */
        public void onPostExecute(FeedBackModel feedBackModel) {
            Interceptable interceptable = $ic;
            if (interceptable == null || interceptable.invokeL(Constants.METHOD_GET_CONTACTER_INFO_FOR_SESSION, this, feedBackModel) == null) {
                super.onPostExecute(feedBackModel);
                this.f58759b.f58754e = null;
                this.f58759b.mLoadDataCallBack.c(feedBackModel);
            }
        }

        @Override // com.baidu.adp.lib.asyncTask.BdAsyncTask
        public void cancel() {
            Interceptable interceptable = $ic;
            if (interceptable == null || interceptable.invokeV(Constants.METHOD_SEND_USER_MSG, this) == null) {
                super.cancel(true);
                this.f58759b.f58754e = null;
                NetWork netWork = this.f58758a;
                if (netWork != null) {
                    netWork.cancelNetConnect();
                }
            }
        }

        public /* synthetic */ b(FeedBackModel feedBackModel, a aVar) {
            this(feedBackModel);
        }
    }

    /* JADX WARN: 'super' call moved to the top of the method (can break code semantics) */
    public FeedBackModel(TbPageContext tbPageContext) {
        super(tbPageContext);
        Interceptable interceptable = $ic;
        if (interceptable != null) {
            InitContext newInitContext = TitanRuntime.newInitContext();
            newInitContext.initArgs = r2;
            Object[] objArr = {tbPageContext};
            interceptable.invokeUnInit(65536, newInitContext);
            int i2 = newInitContext.flag;
            if ((i2 & 1) != 0) {
                int i3 = i2 & 2;
                super((f) newInitContext.callArgs[0]);
                newInitContext.thisArg = this;
                interceptable.invokeInitBody(65536, newInitContext);
                return;
            }
        }
        this.f58754e = null;
        this.f58755f = null;
        this.f58756g = 0;
        this.f58757h = tbPageContext;
        this.f58755f = new ArrayList<>();
    }

    public int A() {
        InterceptResult invokeV;
        Interceptable interceptable = $ic;
        return (interceptable == null || (invokeV = interceptable.invokeV(1048576, this)) == null) ? this.f58756g : invokeV.intValue;
    }

    public ArrayList<c2> B() {
        InterceptResult invokeV;
        Interceptable interceptable = $ic;
        return (interceptable == null || (invokeV = interceptable.invokeV(Constants.METHOD_GET_CONTACTER_INFO_FOR_SESSION, this)) == null) ? this.f58755f : (ArrayList) invokeV.objValue;
    }

    @Override // com.baidu.adp.base.BdBaseModel
    public boolean LoadData() {
        InterceptResult invokeV;
        Interceptable interceptable = $ic;
        if (interceptable == null || (invokeV = interceptable.invokeV(Constants.METHOD_SEND_USER_MSG, this)) == null) {
            return false;
        }
        return invokeV.booleanValue;
    }

    @Override // com.baidu.adp.base.BdBaseModel
    public boolean cancelLoadData() {
        InterceptResult invokeV;
        Interceptable interceptable = $ic;
        if (interceptable == null || (invokeV = interceptable.invokeV(1048579, this)) == null) {
            b bVar = this.f58754e;
            if (bVar != null) {
                bVar.cancel();
                return true;
            }
            return true;
        }
        return invokeV.booleanValue;
    }

    public void parserJson(String str) {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeL(1048580, this, str) == null) {
            try {
                parserJson(new JSONObject(str));
            } catch (Exception e2) {
                BdLog.e(e2.getMessage());
            }
        }
    }

    public void z(String str) {
        Interceptable interceptable = $ic;
        if ((interceptable == null || interceptable.invokeL(1048582, this, str) == null) && this.f58754e == null) {
            b bVar = new b(this, null);
            this.f58754e = bVar;
            bVar.setPriority(3);
            this.f58754e.execute(str);
        }
    }

    public void parserJson(JSONObject jSONObject) {
        Interceptable interceptable = $ic;
        if (!(interceptable == null || interceptable.invokeL(1048581, this, jSONObject) == null) || jSONObject == null) {
            return;
        }
        try {
            this.f58756g = jSONObject.optInt("error_code", 0);
            JSONArray optJSONArray = jSONObject.optJSONArray("thread_list");
            if (optJSONArray != null) {
                for (int i2 = 0; i2 < optJSONArray.length(); i2++) {
                    JSONObject jSONObject2 = optJSONArray.getJSONObject(i2);
                    if (jSONObject2 != null) {
                        c2 c2Var = new c2();
                        c2Var.R2(jSONObject2);
                        this.f58755f.add(c2Var);
                    }
                }
            }
        } catch (Exception e2) {
            BdLog.e(e2.getMessage());
        }
    }
}
