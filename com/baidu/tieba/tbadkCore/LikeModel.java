package com.baidu.tieba.tbadkCore;

import android.content.Context;
import android.text.TextUtils;
import androidx.core.view.InputDeviceCompat;
import com.baidu.adp.base.BdBaseModel;
import com.baidu.adp.framework.MessageManager;
import com.baidu.adp.framework.message.CustomResponsedMessage;
import com.baidu.adp.lib.asyncTask.BdAsyncTask;
import com.baidu.adp.lib.util.BdLog;
import com.baidu.adp.lib.util.StringUtils;
import com.baidu.android.imsdk.internal.Constants;
import com.baidu.tbadk.TbConfig;
import com.baidu.tbadk.TbPageContext;
import com.baidu.tbadk.core.TbadkCoreApplication;
import com.baidu.tbadk.core.data.BdToastData;
import com.baidu.tbadk.core.data.BlockPopInfoData;
import com.baidu.tbadk.core.util.NetWork;
import com.baidu.tbadk.core.util.TiebaStatic;
import com.baidu.tbadk.coreExtra.data.AuthTokenData;
import com.baidu.tieba.e0a;
import com.baidu.tieba.ex9;
import com.baidu.tieba.k9;
import com.baidu.tieba.tbadkCore.util.AntiHelper;
import com.baidu.tieba.tg;
import com.baidu.tieba.xv5;
import com.baidu.titan.sdk.runtime.FieldHolder;
import com.baidu.titan.sdk.runtime.InitContext;
import com.baidu.titan.sdk.runtime.InterceptResult;
import com.baidu.titan.sdk.runtime.Interceptable;
import com.baidu.titan.sdk.runtime.TitanRuntime;
/* loaded from: classes7.dex */
public class LikeModel extends BdBaseModel {
    public static /* synthetic */ Interceptable $ic;
    public transient /* synthetic */ FieldHolder $fh;
    public String a;
    public String b;
    public String c;
    public String d;
    public String e;
    public int f;
    public String g;
    public TbPageContext h;
    public b i;
    public BlockPopInfoData j;

    /* loaded from: classes7.dex */
    public static /* synthetic */ class a {
        public static /* synthetic */ Interceptable $ic;
        public transient /* synthetic */ FieldHolder $fh;
    }

    @Override // com.baidu.adp.base.BdBaseModel
    public boolean cancelLoadData() {
        InterceptResult invokeV;
        Interceptable interceptable = $ic;
        if (interceptable == null || (invokeV = interceptable.invokeV(1048576, this)) == null) {
            return false;
        }
        return invokeV.booleanValue;
    }

    @Override // com.baidu.adp.base.BdBaseModel
    public boolean loadData() {
        InterceptResult invokeV;
        Interceptable interceptable = $ic;
        if (interceptable == null || (invokeV = interceptable.invokeV(1048582, this)) == null) {
            return false;
        }
        return invokeV.booleanValue;
    }

    /* loaded from: classes7.dex */
    public class b extends BdAsyncTask<Object, Integer, ex9> {
        public static /* synthetic */ Interceptable $ic;
        public transient /* synthetic */ FieldHolder $fh;
        public volatile NetWork a;
        public final /* synthetic */ LikeModel b;

        public b(LikeModel likeModel) {
            Interceptable interceptable = $ic;
            if (interceptable != null) {
                InitContext newInitContext = TitanRuntime.newInitContext();
                newInitContext.initArgs = r2;
                Object[] objArr = {likeModel};
                interceptable.invokeUnInit(65536, newInitContext);
                int i = newInitContext.flag;
                if ((i & 1) != 0) {
                    int i2 = i & 2;
                    newInitContext.thisArg = this;
                    interceptable.invokeInitBody(65536, newInitContext);
                    return;
                }
            }
            this.b = likeModel;
            this.a = null;
        }

        public /* synthetic */ b(LikeModel likeModel, a aVar) {
            this(likeModel);
        }

        /* JADX DEBUG: Method merged with bridge method */
        @Override // com.baidu.adp.lib.asyncTask.BdAsyncTask
        /* renamed from: b */
        public ex9 doInBackground(Object... objArr) {
            InterceptResult invokeL;
            Interceptable interceptable = $ic;
            if (interceptable == null || (invokeL = interceptable.invokeL(1048576, this, objArr)) == null) {
                try {
                    this.a = new NetWork(TbConfig.SERVER_ADDRESS + TbConfig.LIKE_ADDRESS);
                    this.a.addPostData(TiebaStatic.Params.H5_FORUM_NAME, this.b.a);
                    this.a.addPostData("fid", this.b.b);
                    this.a.addPostData("st_type", this.b.d);
                    this.a.addPostData("authsid", this.b.e);
                    if (!StringUtils.isNull(this.b.g)) {
                        this.a.addPostData("dev_id", this.b.g);
                    }
                    if (!TextUtils.isEmpty(this.b.c)) {
                        this.a.addPostData("pagefrom", this.b.c);
                    }
                    this.a.addPostData("user_name", TbadkCoreApplication.getCurrentAccountName());
                    this.a.addPostData("user_id", TbadkCoreApplication.getCurrentAccount());
                    this.a.addPostData("forum_name", this.b.a);
                    this.a.addPostData("has_head", String.valueOf(this.b.f));
                    this.a.getNetContext().getRequest().mIsNeedTbs = true;
                    this.a.setNeedSig(true);
                    this.a.setNeedShowSeverToast(this.b.mNeedShowSeverToast);
                    String postNetData = this.a.postNetData();
                    int serverErrorCode = this.a.getServerErrorCode();
                    String errorString = this.a.getErrorString();
                    this.b.setErrorCode(serverErrorCode);
                    this.b.setErrorString(errorString);
                    AuthTokenData.parse(postNetData);
                    if (postNetData != null) {
                        ex9 ex9Var = new ex9();
                        ex9Var.r(postNetData);
                        BdToastData bdToastData = new BdToastData();
                        bdToastData.parserJson(postNetData);
                        ex9Var.z(bdToastData);
                        if (this.a.getNetContext().getResponse().isRequestSuccess()) {
                            ex9Var.t(null);
                        }
                        this.b.j = ex9Var.a();
                        ex9Var.v(this.b.b);
                        return ex9Var;
                    }
                } catch (Exception e) {
                    BdLog.e(e.getMessage());
                }
                ex9 ex9Var2 = new ex9();
                ex9Var2.y(0);
                ex9Var2.v(this.b.b);
                return ex9Var2;
            }
            return (ex9) invokeL.objValue;
        }

        /* JADX DEBUG: Method merged with bridge method */
        @Override // com.baidu.adp.lib.asyncTask.BdAsyncTask
        /* renamed from: c */
        public void onPostExecute(ex9 ex9Var) {
            Interceptable interceptable = $ic;
            if (interceptable == null || interceptable.invokeL(Constants.METHOD_GET_CONTACTER_INFO_FOR_SESSION, this, ex9Var) == null) {
                this.b.i = null;
                this.b.setNeedShowSeverToast(true);
                if (this.a == null || ex9Var == null || AntiHelper.a(this.b.getContext(), this.b.getErrorCode(), ex9Var.b())) {
                    return;
                }
                e0a e0aVar = new e0a();
                e0aVar.a = tg.g(ex9Var.g(), 0L);
                ex9Var.j();
                if (ex9Var != null && this.a.getNetContext().getResponse().isRequestSuccess()) {
                    MessageManager.getInstance().dispatchResponsedMessage(new CustomResponsedMessage(2001335, Long.valueOf(tg.g(ex9Var.g(), 0L))));
                    MessageManager.getInstance().dispatchResponsedMessage(new CustomResponsedMessage(2001610, new xv5.a(this.b.a, ex9Var.m())));
                    TbadkCoreApplication.getInst().addLikeForum(this.b.a);
                    e0aVar.b = true;
                    e0aVar.c = this.b.getErrorString();
                } else {
                    e0aVar.b = false;
                    e0aVar.c = this.b.getErrorString();
                }
                if (this.b.mLoadDataCallBack != null) {
                    this.b.mLoadDataCallBack.c(ex9Var);
                }
                MessageManager.getInstance().dispatchResponsedMessage(new CustomResponsedMessage(2001437, e0aVar));
            }
        }

        @Override // com.baidu.adp.lib.asyncTask.BdAsyncTask
        public void cancel() {
            Interceptable interceptable = $ic;
            if (interceptable == null || interceptable.invokeV(Constants.METHOD_SEND_USER_MSG, this) == null) {
                this.b.setNeedShowSeverToast(true);
                if (this.a != null) {
                    this.a.cancelNetConnect();
                    this.a = null;
                }
                this.b.i = null;
                super.cancel(true);
                if (this.b.mLoadDataCallBack != null) {
                    this.b.mLoadDataCallBack.c(null);
                }
            }
        }
    }

    /* JADX WARN: 'super' call moved to the top of the method (can break code semantics) */
    public LikeModel(TbPageContext tbPageContext) {
        super(tbPageContext);
        Interceptable interceptable = $ic;
        if (interceptable != null) {
            InitContext newInitContext = TitanRuntime.newInitContext();
            newInitContext.initArgs = r2;
            Object[] objArr = {tbPageContext};
            interceptable.invokeUnInit(65536, newInitContext);
            int i = newInitContext.flag;
            if ((i & 1) != 0) {
                int i2 = i & 2;
                super((k9) newInitContext.callArgs[0]);
                newInitContext.thisArg = this;
                interceptable.invokeInitBody(65536, newInitContext);
                return;
            }
        }
        this.a = null;
        this.b = null;
        this.c = null;
        this.f = 0;
        this.i = null;
        this.h = tbPageContext;
    }

    public void l0(int i) {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeI(1048581, this, i) == null) {
            this.f = i;
        }
    }

    public void setFrom(String str) {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeL(1048586, this, str) == null) {
            this.d = str;
        }
    }

    public Context getContext() {
        InterceptResult invokeV;
        Interceptable interceptable = $ic;
        if (interceptable == null || (invokeV = interceptable.invokeV(Constants.METHOD_GET_CONTACTER_INFO_FOR_SESSION, this)) == null) {
            TbPageContext tbPageContext = this.h;
            if (tbPageContext != null) {
                return tbPageContext.getPageActivity();
            }
            return null;
        }
        return (Context) invokeV.objValue;
    }

    public void i0() {
        b bVar;
        Interceptable interceptable = $ic;
        if ((interceptable == null || interceptable.invokeV(Constants.METHOD_SEND_USER_MSG, this) == null) && (bVar = this.i) != null) {
            bVar.cancel();
            this.i = null;
        }
    }

    public BlockPopInfoData j0() {
        InterceptResult invokeV;
        Interceptable interceptable = $ic;
        if (interceptable == null || (invokeV = interceptable.invokeV(1048579, this)) == null) {
            return this.j;
        }
        return (BlockPopInfoData) invokeV.objValue;
    }

    public boolean k0() {
        InterceptResult invokeV;
        Interceptable interceptable = $ic;
        if (interceptable == null || (invokeV = interceptable.invokeV(1048580, this)) == null) {
            if (this.i != null) {
                return true;
            }
            return false;
        }
        return invokeV.booleanValue;
    }

    public void onDestroy() {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeV(1048585, this) == null) {
            i0();
            this.h = null;
        }
    }

    public void m0(String str, String str2) {
        Interceptable interceptable = $ic;
        if ((interceptable == null || interceptable.invokeLL(1048583, this, str, str2) == null) && str != null && str.length() > 0 && str2 != null && str2.length() > 0 && this.i == null) {
            this.a = str;
            this.b = str2;
            b bVar = new b(this, null);
            this.i = bVar;
            bVar.setPriority(2);
            this.i.execute(new Object[0]);
        }
    }

    public void n0(String str, String str2, String str3) {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeLLL(InputDeviceCompat.SOURCE_TOUCHPAD, this, str, str2, str3) == null) {
            m0(str, str2);
            this.c = str3;
        }
    }
}
