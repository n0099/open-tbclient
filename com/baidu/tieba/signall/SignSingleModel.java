package com.baidu.tieba.signall;

import com.baidu.adp.base.BdBaseModel;
import com.baidu.adp.base.BdPageContext;
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
/* loaded from: classes8.dex */
public class SignSingleModel extends BdBaseModel<SignAllForumActivity> {
    public static /* synthetic */ Interceptable $ic;
    public transient /* synthetic */ FieldHolder $fh;
    public String a;
    public String b;
    public c c;
    public b d;
    public String e;

    /* loaded from: classes8.dex */
    public static /* synthetic */ class a {
        public static /* synthetic */ Interceptable $ic;
        public transient /* synthetic */ FieldHolder $fh;
    }

    /* loaded from: classes8.dex */
    public interface b {
        void a(SignData signData);

        void onError(String str, String str2);
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

    /* loaded from: classes8.dex */
    public class c extends BdAsyncTask<Object, Integer, SignData> {
        public static /* synthetic */ Interceptable $ic;
        public transient /* synthetic */ FieldHolder $fh;
        public volatile NetWork a;
        public final /* synthetic */ SignSingleModel b;

        @Override // com.baidu.adp.lib.asyncTask.BdAsyncTask
        public void onPreExecute() {
            Interceptable interceptable = $ic;
            if (interceptable == null || interceptable.invokeV(1048581, this) == null) {
            }
        }

        public c(SignSingleModel signSingleModel) {
            Interceptable interceptable = $ic;
            if (interceptable != null) {
                InitContext newInitContext = TitanRuntime.newInitContext();
                newInitContext.initArgs = r2;
                Object[] objArr = {signSingleModel};
                interceptable.invokeUnInit(65536, newInitContext);
                int i = newInitContext.flag;
                if ((i & 1) != 0) {
                    int i2 = i & 2;
                    newInitContext.thisArg = this;
                    interceptable.invokeInitBody(65536, newInitContext);
                    return;
                }
            }
            this.b = signSingleModel;
            this.a = null;
        }

        public /* synthetic */ c(SignSingleModel signSingleModel, a aVar) {
            this(signSingleModel);
        }

        /* JADX DEBUG: Method merged with bridge method */
        @Override // com.baidu.adp.lib.asyncTask.BdAsyncTask
        /* renamed from: b */
        public SignData doInBackground(Object... objArr) {
            InterceptResult invokeL;
            SignData signData;
            Exception e;
            Interceptable interceptable = $ic;
            if (interceptable == null || (invokeL = interceptable.invokeL(1048576, this, objArr)) == null) {
                SignData signData2 = null;
                try {
                    this.a = new NetWork(TbConfig.SERVER_ADDRESS + TbConfig.SIGN_ADDRESS);
                    this.a.addPostData(TiebaStatic.Params.H5_FORUM_NAME, this.b.a);
                    this.a.addPostData("fid", this.b.b);
                    this.a.addPostData("authsid", this.b.e);
                    this.a.getNetContext().getRequest().mIsNeedTbs = true;
                    this.a.setNeedSig(true);
                    String postNetData = this.a.postNetData();
                    if (this.a.isNetSuccess() && this.a.getNetContext().getResponse().isRequestSuccess()) {
                        signData = new SignData();
                        try {
                            signData.parserJson(postNetData);
                            signData.forumId = this.b.b;
                            signData.forumName = this.b.a;
                            signData2 = signData;
                        } catch (Exception e2) {
                            e = e2;
                            BdLog.e(e.getMessage());
                            return signData;
                        }
                    }
                    AuthTokenData.parse(postNetData);
                    return signData2;
                } catch (Exception e3) {
                    signData = signData2;
                    e = e3;
                }
            } else {
                return (SignData) invokeL.objValue;
            }
        }

        /* JADX DEBUG: Method merged with bridge method */
        @Override // com.baidu.adp.lib.asyncTask.BdAsyncTask
        /* renamed from: c */
        public void onPostExecute(SignData signData) {
            Interceptable interceptable = $ic;
            if (interceptable == null || interceptable.invokeL(Constants.METHOD_GET_CONTACTER_INFO_FOR_SESSION, this, signData) == null) {
                this.b.c = null;
                if (signData == null && this.a != null) {
                    this.b.mErrorCode = this.a.getServerErrorCode();
                    this.b.mErrorString = this.a.getErrorString();
                    this.b.d.onError(this.b.b, this.b.mErrorString);
                    return;
                }
                this.b.d.a(signData);
            }
        }

        @Override // com.baidu.adp.lib.asyncTask.BdAsyncTask
        public void cancel() {
            Interceptable interceptable = $ic;
            if (interceptable == null || interceptable.invokeV(Constants.METHOD_SEND_USER_MSG, this) == null) {
                if (this.a != null) {
                    this.a.cancelNetConnect();
                }
                this.b.c = null;
                super.cancel(true);
                this.b.d.onError(this.b.b, null);
            }
        }
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
            int i = newInitContext.flag;
            if ((i & 1) != 0) {
                int i2 = i & 2;
                super((BdPageContext) newInitContext.callArgs[0]);
                newInitContext.thisArg = this;
                interceptable.invokeInitBody(65536, newInitContext);
                return;
            }
        }
        this.a = null;
        this.b = null;
        this.c = null;
    }

    public void W(b bVar) {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeL(Constants.METHOD_GET_CONTACTER_INFO_FOR_SESSION, this, bVar) == null) {
            this.d = bVar;
        }
    }

    public void V() {
        c cVar;
        Interceptable interceptable = $ic;
        if ((interceptable == null || interceptable.invokeV(1048576, this) == null) && (cVar = this.c) != null) {
            cVar.cancel();
            this.c = null;
        }
    }

    public void X(String str, String str2) {
        Interceptable interceptable = $ic;
        if ((interceptable == null || interceptable.invokeLL(Constants.METHOD_SEND_USER_MSG, this, str, str2) == null) && str != null && str.length() > 0 && str2 != null && str2.length() > 0 && this.c == null) {
            this.a = str;
            this.b = str2;
            c cVar = new c(this, null);
            this.c = cVar;
            cVar.setPriority(2);
            this.c.execute(new Object[0]);
        }
    }
}
