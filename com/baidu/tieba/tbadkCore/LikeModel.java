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
import com.baidu.tieba.tbadkCore.util.AntiHelper;
import com.baidu.titan.sdk.runtime.FieldHolder;
import com.baidu.titan.sdk.runtime.InitContext;
import com.baidu.titan.sdk.runtime.InterceptResult;
import com.baidu.titan.sdk.runtime.Interceptable;
import com.baidu.titan.sdk.runtime.TitanRuntime;
import com.repackage.ad5;
import com.repackage.d9;
import com.repackage.ng;
import com.repackage.oh8;
import com.repackage.ok8;
/* loaded from: classes4.dex */
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

    /* loaded from: classes4.dex */
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

    public void N() {
        b bVar;
        Interceptable interceptable = $ic;
        if (!(interceptable == null || interceptable.invokeV(1048576, this) == null) || (bVar = this.i) == null) {
            return;
        }
        bVar.cancel();
        this.i = null;
    }

    public BlockPopInfoData O() {
        InterceptResult invokeV;
        Interceptable interceptable = $ic;
        return (interceptable == null || (invokeV = interceptable.invokeV(Constants.METHOD_GET_CONTACTER_INFO_FOR_SESSION, this)) == null) ? this.j : (BlockPopInfoData) invokeV.objValue;
    }

    public boolean P() {
        InterceptResult invokeV;
        Interceptable interceptable = $ic;
        return (interceptable == null || (invokeV = interceptable.invokeV(Constants.METHOD_SEND_USER_MSG, this)) == null) ? this.i != null : invokeV.booleanValue;
    }

    public void Q(int i) {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeI(1048579, this, i) == null) {
            this.f = i;
        }
    }

    public void R(String str, String str2) {
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

    public void S(String str, String str2, String str3) {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeLLL(1048581, this, str, str2, str3) == null) {
            R(str, str2);
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

    /* loaded from: classes4.dex */
    public class b extends BdAsyncTask<Object, Integer, oh8> {
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
        public oh8 doInBackground(Object... objArr) {
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
                        oh8 oh8Var = new oh8();
                        oh8Var.r(postNetData);
                        if (this.a.getNetContext().getResponse().isRequestSuccess()) {
                            oh8Var.t(null);
                        }
                        this.b.j = oh8Var.a();
                        oh8Var.v(this.b.b);
                        return oh8Var;
                    }
                } catch (Exception e) {
                    BdLog.e(e.getMessage());
                }
                oh8 oh8Var2 = new oh8();
                oh8Var2.y(0);
                oh8Var2.v(this.b.b);
                return oh8Var2;
            }
            return (oh8) invokeL.objValue;
        }

        /* JADX DEBUG: Method merged with bridge method */
        @Override // com.baidu.adp.lib.asyncTask.BdAsyncTask
        /* renamed from: c */
        public void onPostExecute(oh8 oh8Var) {
            Interceptable interceptable = $ic;
            if (interceptable == null || interceptable.invokeL(Constants.METHOD_GET_CONTACTER_INFO_FOR_SESSION, this, oh8Var) == null) {
                this.b.i = null;
                if (this.a == null || oh8Var == null || AntiHelper.a(this.b.getContext(), this.b.getErrorCode(), oh8Var.b())) {
                    return;
                }
                ok8 ok8Var = new ok8();
                ok8Var.a = ng.g(oh8Var.g(), 0L);
                oh8Var.j();
                if (oh8Var != null && this.a.getNetContext().getResponse().isRequestSuccess()) {
                    MessageManager.getInstance().dispatchResponsedMessage(new CustomResponsedMessage(2001335, Long.valueOf(ng.g(oh8Var.g(), 0L))));
                    MessageManager.getInstance().dispatchResponsedMessage(new CustomResponsedMessage(2001610, new ad5.a(this.b.a, oh8Var.m())));
                    TbadkCoreApplication.getInst().addLikeForum(this.b.a);
                    ok8Var.b = true;
                    ok8Var.c = this.b.getErrorString();
                } else {
                    ok8Var.b = false;
                    ok8Var.c = this.b.getErrorString();
                }
                if (this.b.mLoadDataCallBack != null) {
                    this.b.mLoadDataCallBack.c(oh8Var);
                }
                MessageManager.getInstance().dispatchResponsedMessage(new CustomResponsedMessage(2001437, ok8Var));
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
