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
import com.baidu.tbadk.core.data.BlockPopInfoData;
import com.baidu.tbadk.core.util.NetWork;
import com.baidu.tbadk.core.util.TiebaStatic;
import com.baidu.tbadk.coreExtra.data.AuthTokenData;
import com.baidu.tieba.d9;
import com.baidu.tieba.fe5;
import com.baidu.tieba.fn8;
import com.baidu.tieba.hk8;
import com.baidu.tieba.pg;
import com.baidu.tieba.tbadkCore.util.AntiHelper;
import com.baidu.titan.sdk.runtime.FieldHolder;
import com.baidu.titan.sdk.runtime.InitContext;
import com.baidu.titan.sdk.runtime.InterceptResult;
import com.baidu.titan.sdk.runtime.Interceptable;
import com.baidu.titan.sdk.runtime.TitanRuntime;
/* loaded from: classes5.dex */
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

    /* loaded from: classes5.dex */
    public static /* synthetic */ class a {
        public static /* synthetic */ Interceptable $ic;
        public transient /* synthetic */ FieldHolder $fh;
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
                super((d9) newInitContext.callArgs[0]);
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

    public void M() {
        b bVar;
        Interceptable interceptable = $ic;
        if (!(interceptable == null || interceptable.invokeV(1048576, this) == null) || (bVar = this.i) == null) {
            return;
        }
        bVar.cancel();
        this.i = null;
    }

    public BlockPopInfoData N() {
        InterceptResult invokeV;
        Interceptable interceptable = $ic;
        return (interceptable == null || (invokeV = interceptable.invokeV(Constants.METHOD_GET_CONTACTER_INFO_FOR_SESSION, this)) == null) ? this.j : (BlockPopInfoData) invokeV.objValue;
    }

    public boolean O() {
        InterceptResult invokeV;
        Interceptable interceptable = $ic;
        return (interceptable == null || (invokeV = interceptable.invokeV(Constants.METHOD_SEND_USER_MSG, this)) == null) ? this.i != null : invokeV.booleanValue;
    }

    public void P(int i) {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeI(1048579, this, i) == null) {
            this.f = i;
        }
    }

    public void Q(String str, String str2) {
        Interceptable interceptable = $ic;
        if (!(interceptable == null || interceptable.invokeLL(1048580, this, str, str2) == null) || str == null || str.length() <= 0 || str2 == null || str2.length() <= 0 || this.i != null) {
            return;
        }
        this.a = str;
        this.b = str2;
        b bVar = new b(this, null);
        this.i = bVar;
        bVar.setPriority(2);
        this.i.execute(new Object[0]);
    }

    public void R(String str, String str2, String str3) {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeLLL(1048581, this, str, str2, str3) == null) {
            Q(str, str2);
            this.c = str3;
        }
    }

    @Override // com.baidu.adp.base.BdBaseModel
    public boolean cancelLoadData() {
        InterceptResult invokeV;
        Interceptable interceptable = $ic;
        if (interceptable == null || (invokeV = interceptable.invokeV(1048582, this)) == null) {
            return false;
        }
        return invokeV.booleanValue;
    }

    public Context getContext() {
        InterceptResult invokeV;
        Interceptable interceptable = $ic;
        if (interceptable == null || (invokeV = interceptable.invokeV(1048583, this)) == null) {
            TbPageContext tbPageContext = this.h;
            if (tbPageContext != null) {
                return tbPageContext.getPageActivity();
            }
            return null;
        }
        return (Context) invokeV.objValue;
    }

    @Override // com.baidu.adp.base.BdBaseModel
    public boolean loadData() {
        InterceptResult invokeV;
        Interceptable interceptable = $ic;
        if (interceptable == null || (invokeV = interceptable.invokeV(InputDeviceCompat.SOURCE_TOUCHPAD, this)) == null) {
            return false;
        }
        return invokeV.booleanValue;
    }

    public void setFrom(String str) {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeL(1048585, this, str) == null) {
            this.d = str;
        }
    }

    /* loaded from: classes5.dex */
    public class b extends BdAsyncTask<Object, Integer, hk8> {
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

        /* JADX DEBUG: Method merged with bridge method */
        @Override // com.baidu.adp.lib.asyncTask.BdAsyncTask
        /* renamed from: b */
        public hk8 doInBackground(Object... objArr) {
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
                    String postNetData = this.a.postNetData();
                    int serverErrorCode = this.a.getServerErrorCode();
                    String errorString = this.a.getErrorString();
                    this.b.setErrorCode(serverErrorCode);
                    this.b.setErrorString(errorString);
                    AuthTokenData.parse(postNetData);
                    if (postNetData != null) {
                        hk8 hk8Var = new hk8();
                        hk8Var.q(postNetData);
                        if (this.a.getNetContext().getResponse().isRequestSuccess()) {
                            hk8Var.s(null);
                        }
                        this.b.j = hk8Var.a();
                        hk8Var.u(this.b.b);
                        return hk8Var;
                    }
                } catch (Exception e) {
                    BdLog.e(e.getMessage());
                }
                hk8 hk8Var2 = new hk8();
                hk8Var2.x(0);
                hk8Var2.u(this.b.b);
                return hk8Var2;
            }
            return (hk8) invokeL.objValue;
        }

        /* JADX DEBUG: Method merged with bridge method */
        @Override // com.baidu.adp.lib.asyncTask.BdAsyncTask
        /* renamed from: c */
        public void onPostExecute(hk8 hk8Var) {
            Interceptable interceptable = $ic;
            if (interceptable == null || interceptable.invokeL(Constants.METHOD_GET_CONTACTER_INFO_FOR_SESSION, this, hk8Var) == null) {
                this.b.i = null;
                if (this.a == null || hk8Var == null || AntiHelper.a(this.b.getContext(), this.b.getErrorCode(), hk8Var.b())) {
                    return;
                }
                fn8 fn8Var = new fn8();
                fn8Var.a = pg.g(hk8Var.g(), 0L);
                hk8Var.j();
                if (hk8Var != null && this.a.getNetContext().getResponse().isRequestSuccess()) {
                    MessageManager.getInstance().dispatchResponsedMessage(new CustomResponsedMessage(2001335, Long.valueOf(pg.g(hk8Var.g(), 0L))));
                    MessageManager.getInstance().dispatchResponsedMessage(new CustomResponsedMessage(2001610, new fe5.a(this.b.a, hk8Var.l())));
                    TbadkCoreApplication.getInst().addLikeForum(this.b.a);
                    fn8Var.b = true;
                    fn8Var.c = this.b.getErrorString();
                } else {
                    fn8Var.b = false;
                    fn8Var.c = this.b.getErrorString();
                }
                if (this.b.mLoadDataCallBack != null) {
                    this.b.mLoadDataCallBack.c(hk8Var);
                }
                MessageManager.getInstance().dispatchResponsedMessage(new CustomResponsedMessage(2001437, fn8Var));
            }
        }

        @Override // com.baidu.adp.lib.asyncTask.BdAsyncTask
        public void cancel() {
            Interceptable interceptable = $ic;
            if (interceptable == null || interceptable.invokeV(Constants.METHOD_SEND_USER_MSG, this) == null) {
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

        public /* synthetic */ b(LikeModel likeModel, a aVar) {
            this(likeModel);
        }
    }
}
