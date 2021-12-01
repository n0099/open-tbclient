package com.baidu.tieba.signall;

import c.a.d.a.f;
import com.baidu.adp.base.BdBaseModel;
import com.baidu.adp.lib.asyncTask.BdAsyncTask;
import com.baidu.adp.lib.util.BdLog;
import com.baidu.android.imsdk.internal.Constants;
import com.baidu.tbadk.TbConfig;
import com.baidu.tbadk.core.data.SignData;
import com.baidu.tbadk.core.util.NetWork;
import com.baidu.tbadk.core.util.TiebaStatic;
import com.baidu.tbadk.coreExtra.data.AuthTokenData;
import com.baidu.titan.sdk.runtime.FieldHolder;
import com.baidu.titan.sdk.runtime.InitContext;
import com.baidu.titan.sdk.runtime.InterceptResult;
import com.baidu.titan.sdk.runtime.Interceptable;
import com.baidu.titan.sdk.runtime.TitanRuntime;
/* loaded from: classes11.dex */
public class SignSingleModel extends BdBaseModel<SignAllForumActivity> {
    public static /* synthetic */ Interceptable $ic;
    public transient /* synthetic */ FieldHolder $fh;

    /* renamed from: e  reason: collision with root package name */
    public String f49067e;

    /* renamed from: f  reason: collision with root package name */
    public String f49068f;

    /* renamed from: g  reason: collision with root package name */
    public c f49069g;

    /* renamed from: h  reason: collision with root package name */
    public b f49070h;

    /* renamed from: i  reason: collision with root package name */
    public String f49071i;

    /* loaded from: classes11.dex */
    public static /* synthetic */ class a {
        public static /* synthetic */ Interceptable $ic;
        public transient /* synthetic */ FieldHolder $fh;
    }

    /* loaded from: classes11.dex */
    public interface b {
        void a(SignData signData);

        void onError(String str, String str2);
    }

    /* JADX WARN: 'super' call moved to the top of the method (can break code semantics) */
    public SignSingleModel(SignAllForumActivity signAllForumActivity) {
        super(signAllForumActivity.getPageContext());
        Interceptable interceptable = $ic;
        if (interceptable != null) {
            InitContext newInitContext = TitanRuntime.newInitContext();
            newInitContext.initArgs = r2;
            Object[] objArr = {signAllForumActivity};
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
        this.f49067e = null;
        this.f49068f = null;
        this.f49069g = null;
    }

    public void E() {
        c cVar;
        Interceptable interceptable = $ic;
        if (!(interceptable == null || interceptable.invokeV(1048576, this) == null) || (cVar = this.f49069g) == null) {
            return;
        }
        cVar.cancel();
        this.f49069g = null;
    }

    public void F(b bVar) {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeL(Constants.METHOD_GET_CONTACTER_INFO_FOR_SESSION, this, bVar) == null) {
            this.f49070h = bVar;
        }
    }

    public void G(String str, String str2) {
        Interceptable interceptable = $ic;
        if (!(interceptable == null || interceptable.invokeLL(Constants.METHOD_SEND_USER_MSG, this, str, str2) == null) || str == null || str.length() <= 0 || str2 == null || str2.length() <= 0 || this.f49069g != null) {
            return;
        }
        this.f49067e = str;
        this.f49068f = str2;
        c cVar = new c(this, null);
        this.f49069g = cVar;
        cVar.setPriority(2);
        this.f49069g.execute(new Object[0]);
    }

    @Override // com.baidu.adp.base.BdBaseModel
    public boolean cancelLoadData() {
        InterceptResult invokeV;
        Interceptable interceptable = $ic;
        if (interceptable == null || (invokeV = interceptable.invokeV(1048579, this)) == null) {
            return false;
        }
        return invokeV.booleanValue;
    }

    @Override // com.baidu.adp.base.BdBaseModel
    public boolean loadData() {
        InterceptResult invokeV;
        Interceptable interceptable = $ic;
        if (interceptable == null || (invokeV = interceptable.invokeV(1048580, this)) == null) {
            return false;
        }
        return invokeV.booleanValue;
    }

    /* loaded from: classes11.dex */
    public class c extends BdAsyncTask<Object, Integer, SignData> {
        public static /* synthetic */ Interceptable $ic;
        public transient /* synthetic */ FieldHolder $fh;
        public volatile NetWork a;

        /* renamed from: b  reason: collision with root package name */
        public final /* synthetic */ SignSingleModel f49072b;

        public c(SignSingleModel signSingleModel) {
            Interceptable interceptable = $ic;
            if (interceptable != null) {
                InitContext newInitContext = TitanRuntime.newInitContext();
                newInitContext.initArgs = r2;
                Object[] objArr = {signSingleModel};
                interceptable.invokeUnInit(65536, newInitContext);
                int i2 = newInitContext.flag;
                if ((i2 & 1) != 0) {
                    int i3 = i2 & 2;
                    newInitContext.thisArg = this;
                    interceptable.invokeInitBody(65536, newInitContext);
                    return;
                }
            }
            this.f49072b = signSingleModel;
            this.a = null;
        }

        /* JADX DEBUG: Method merged with bridge method */
        @Override // com.baidu.adp.lib.asyncTask.BdAsyncTask
        /* renamed from: b */
        public SignData doInBackground(Object... objArr) {
            InterceptResult invokeL;
            SignData signData;
            Exception e2;
            Interceptable interceptable = $ic;
            if (interceptable != null && (invokeL = interceptable.invokeL(1048576, this, objArr)) != null) {
                return (SignData) invokeL.objValue;
            }
            SignData signData2 = null;
            try {
                this.a = new NetWork(TbConfig.SERVER_ADDRESS + TbConfig.SIGN_ADDRESS);
                this.a.addPostData(TiebaStatic.Params.H5_FORUM_NAME, this.f49072b.f49067e);
                this.a.addPostData("fid", this.f49072b.f49068f);
                this.a.addPostData("authsid", this.f49072b.f49071i);
                this.a.getNetContext().getRequest().mIsNeedTbs = true;
                this.a.setNeedSig(true);
                String postNetData = this.a.postNetData();
                if (this.a.isNetSuccess() && this.a.getNetContext().getResponse().isRequestSuccess()) {
                    signData = new SignData();
                    try {
                        signData.parserJson(postNetData);
                        signData.forumId = this.f49072b.f49068f;
                        signData.forumName = this.f49072b.f49067e;
                        signData2 = signData;
                    } catch (Exception e3) {
                        e2 = e3;
                        BdLog.e(e2.getMessage());
                        return signData;
                    }
                }
                AuthTokenData.parse(postNetData);
                return signData2;
            } catch (Exception e4) {
                signData = signData2;
                e2 = e4;
            }
        }

        /* JADX DEBUG: Method merged with bridge method */
        @Override // com.baidu.adp.lib.asyncTask.BdAsyncTask
        /* renamed from: c */
        public void onPostExecute(SignData signData) {
            Interceptable interceptable = $ic;
            if (interceptable == null || interceptable.invokeL(Constants.METHOD_GET_CONTACTER_INFO_FOR_SESSION, this, signData) == null) {
                this.f49072b.f49069g = null;
                if (signData != null || this.a == null) {
                    this.f49072b.f49070h.a(signData);
                    return;
                }
                this.f49072b.mErrorCode = this.a.getServerErrorCode();
                this.f49072b.mErrorString = this.a.getErrorString();
                this.f49072b.f49070h.onError(this.f49072b.f49068f, this.f49072b.mErrorString);
            }
        }

        @Override // com.baidu.adp.lib.asyncTask.BdAsyncTask
        public void cancel() {
            Interceptable interceptable = $ic;
            if (interceptable == null || interceptable.invokeV(Constants.METHOD_SEND_USER_MSG, this) == null) {
                if (this.a != null) {
                    this.a.cancelNetConnect();
                }
                this.f49072b.f49069g = null;
                super.cancel(true);
                this.f49072b.f49070h.onError(this.f49072b.f49068f, null);
            }
        }

        @Override // com.baidu.adp.lib.asyncTask.BdAsyncTask
        public void onPreExecute() {
            Interceptable interceptable = $ic;
            if (interceptable == null || interceptable.invokeV(1048581, this) == null) {
            }
        }

        public /* synthetic */ c(SignSingleModel signSingleModel, a aVar) {
            this(signSingleModel);
        }
    }
}
