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
import com.baidu.tieba.hz8;
import com.baidu.tieba.iw8;
import com.baidu.tieba.qj5;
import com.baidu.tieba.s9;
import com.baidu.tieba.tbadkCore.util.AntiHelper;
import com.baidu.tieba.yg;
import com.baidu.titan.sdk.runtime.FieldHolder;
import com.baidu.titan.sdk.runtime.InitContext;
import com.baidu.titan.sdk.runtime.InterceptResult;
import com.baidu.titan.sdk.runtime.Interceptable;
import com.baidu.titan.sdk.runtime.TitanRuntime;
/* loaded from: classes6.dex */
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

    /* loaded from: classes6.dex */
    public static /* synthetic */ class a {
        public static /* synthetic */ Interceptable $ic;
        public transient /* synthetic */ FieldHolder $fh;
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

    @Override // com.baidu.adp.base.BdBaseModel
    public boolean loadData() {
        InterceptResult invokeV;
        Interceptable interceptable = $ic;
        if (interceptable == null || (invokeV = interceptable.invokeV(InputDeviceCompat.SOURCE_TOUCHPAD, this)) == null) {
            return false;
        }
        return invokeV.booleanValue;
    }

    /* loaded from: classes6.dex */
    public class b extends BdAsyncTask<Object, Integer, iw8> {
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
        public iw8 doInBackground(Object... objArr) {
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
                        iw8 iw8Var = new iw8();
                        iw8Var.r(postNetData);
                        BdToastData bdToastData = new BdToastData();
                        bdToastData.parserJson(postNetData);
                        iw8Var.z(bdToastData);
                        if (this.a.getNetContext().getResponse().isRequestSuccess()) {
                            iw8Var.t(null);
                        }
                        this.b.j = iw8Var.a();
                        iw8Var.v(this.b.b);
                        return iw8Var;
                    }
                } catch (Exception e) {
                    BdLog.e(e.getMessage());
                }
                iw8 iw8Var2 = new iw8();
                iw8Var2.y(0);
                iw8Var2.v(this.b.b);
                return iw8Var2;
            }
            return (iw8) invokeL.objValue;
        }

        /* JADX DEBUG: Method merged with bridge method */
        @Override // com.baidu.adp.lib.asyncTask.BdAsyncTask
        /* renamed from: c */
        public void onPostExecute(iw8 iw8Var) {
            Interceptable interceptable = $ic;
            if (interceptable == null || interceptable.invokeL(Constants.METHOD_GET_CONTACTER_INFO_FOR_SESSION, this, iw8Var) == null) {
                this.b.i = null;
                this.b.setNeedShowSeverToast(true);
                if (this.a == null || iw8Var == null || AntiHelper.a(this.b.getContext(), this.b.getErrorCode(), iw8Var.b())) {
                    return;
                }
                hz8 hz8Var = new hz8();
                hz8Var.a = yg.g(iw8Var.g(), 0L);
                iw8Var.j();
                if (iw8Var != null && this.a.getNetContext().getResponse().isRequestSuccess()) {
                    MessageManager.getInstance().dispatchResponsedMessage(new CustomResponsedMessage(2001335, Long.valueOf(yg.g(iw8Var.g(), 0L))));
                    MessageManager.getInstance().dispatchResponsedMessage(new CustomResponsedMessage(2001610, new qj5.a(this.b.a, iw8Var.m())));
                    TbadkCoreApplication.getInst().addLikeForum(this.b.a);
                    hz8Var.b = true;
                    hz8Var.c = this.b.getErrorString();
                } else {
                    hz8Var.b = false;
                    hz8Var.c = this.b.getErrorString();
                }
                if (this.b.mLoadDataCallBack != null) {
                    this.b.mLoadDataCallBack.c(iw8Var);
                }
                MessageManager.getInstance().dispatchResponsedMessage(new CustomResponsedMessage(2001437, hz8Var));
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
                super((s9) newInitContext.callArgs[0]);
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

    public void X(int i) {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeI(1048579, this, i) == null) {
            this.f = i;
        }
    }

    public void setFrom(String str) {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeL(1048586, this, str) == null) {
            this.d = str;
        }
    }

    public void U() {
        b bVar;
        Interceptable interceptable = $ic;
        if ((interceptable == null || interceptable.invokeV(1048576, this) == null) && (bVar = this.i) != null) {
            bVar.cancel();
            this.i = null;
        }
    }

    public BlockPopInfoData V() {
        InterceptResult invokeV;
        Interceptable interceptable = $ic;
        if (interceptable == null || (invokeV = interceptable.invokeV(Constants.METHOD_GET_CONTACTER_INFO_FOR_SESSION, this)) == null) {
            return this.j;
        }
        return (BlockPopInfoData) invokeV.objValue;
    }

    public boolean W() {
        InterceptResult invokeV;
        Interceptable interceptable = $ic;
        if (interceptable == null || (invokeV = interceptable.invokeV(Constants.METHOD_SEND_USER_MSG, this)) == null) {
            if (this.i != null) {
                return true;
            }
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

    public void onDestroy() {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeV(1048585, this) == null) {
            U();
            this.h = null;
        }
    }

    public void Y(String str, String str2) {
        Interceptable interceptable = $ic;
        if ((interceptable == null || interceptable.invokeLL(1048580, this, str, str2) == null) && str != null && str.length() > 0 && str2 != null && str2.length() > 0 && this.i == null) {
            this.a = str;
            this.b = str2;
            b bVar = new b(this, null);
            this.i = bVar;
            bVar.setPriority(2);
            this.i.execute(new Object[0]);
        }
    }

    public void Z(String str, String str2, String str3) {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeLLL(1048581, this, str, str2, str3) == null) {
            Y(str, str2);
            this.c = str3;
        }
    }
}
