package com.baidu.tieba.tbadkCore;

import android.content.Context;
import android.text.TextUtils;
import androidx.core.view.InputDeviceCompat;
import b.a.e.a.f;
import b.a.q0.c1.i;
import b.a.r0.m3.s0.k;
import b.a.r0.m3.x;
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
/* loaded from: classes9.dex */
public class LikeModel extends BdBaseModel {
    public static /* synthetic */ Interceptable $ic;
    public transient /* synthetic */ FieldHolder $fh;

    /* renamed from: e  reason: collision with root package name */
    public String f55103e;

    /* renamed from: f  reason: collision with root package name */
    public String f55104f;

    /* renamed from: g  reason: collision with root package name */
    public String f55105g;

    /* renamed from: h  reason: collision with root package name */
    public String f55106h;

    /* renamed from: i  reason: collision with root package name */
    public String f55107i;
    public String j;
    public TbPageContext k;
    public b l;
    public BlockPopInfoData m;

    /* loaded from: classes9.dex */
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
            int i2 = newInitContext.flag;
            if ((i2 & 1) != 0) {
                int i3 = i2 & 2;
                super((f) newInitContext.callArgs[0]);
                newInitContext.thisArg = this;
                interceptable.invokeInitBody(65536, newInitContext);
                return;
            }
        }
        this.f55103e = null;
        this.f55104f = null;
        this.f55105g = null;
        this.l = null;
        this.k = tbPageContext;
    }

    public void I() {
        b bVar;
        Interceptable interceptable = $ic;
        if (!(interceptable == null || interceptable.invokeV(1048576, this) == null) || (bVar = this.l) == null) {
            return;
        }
        bVar.cancel();
        this.l = null;
    }

    public BlockPopInfoData J() {
        InterceptResult invokeV;
        Interceptable interceptable = $ic;
        return (interceptable == null || (invokeV = interceptable.invokeV(Constants.METHOD_GET_CONTACTER_INFO_FOR_SESSION, this)) == null) ? this.m : (BlockPopInfoData) invokeV.objValue;
    }

    public boolean K() {
        InterceptResult invokeV;
        Interceptable interceptable = $ic;
        return (interceptable == null || (invokeV = interceptable.invokeV(Constants.METHOD_SEND_USER_MSG, this)) == null) ? this.l != null : invokeV.booleanValue;
    }

    public void L(String str, String str2) {
        Interceptable interceptable = $ic;
        if (!(interceptable == null || interceptable.invokeLL(1048579, this, str, str2) == null) || str == null || str.length() <= 0 || str2 == null || str2.length() <= 0 || this.l != null) {
            return;
        }
        this.f55103e = str;
        this.f55104f = str2;
        b bVar = new b(this, null);
        this.l = bVar;
        bVar.setPriority(2);
        this.l.execute(new Object[0]);
    }

    public void M(String str, String str2, String str3) {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeLLL(1048580, this, str, str2, str3) == null) {
            L(str, str2);
            this.f55105g = str3;
        }
    }

    @Override // com.baidu.adp.base.BdBaseModel
    public boolean cancelLoadData() {
        InterceptResult invokeV;
        Interceptable interceptable = $ic;
        if (interceptable == null || (invokeV = interceptable.invokeV(1048581, this)) == null) {
            return false;
        }
        return invokeV.booleanValue;
    }

    public Context getContext() {
        InterceptResult invokeV;
        Interceptable interceptable = $ic;
        if (interceptable == null || (invokeV = interceptable.invokeV(1048582, this)) == null) {
            TbPageContext tbPageContext = this.k;
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
        if (interceptable == null || (invokeV = interceptable.invokeV(1048583, this)) == null) {
            return false;
        }
        return invokeV.booleanValue;
    }

    public void setFrom(String str) {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeL(InputDeviceCompat.SOURCE_TOUCHPAD, this, str) == null) {
            this.f55106h = str;
        }
    }

    /* loaded from: classes9.dex */
    public class b extends BdAsyncTask<Object, Integer, x> {
        public static /* synthetic */ Interceptable $ic;
        public transient /* synthetic */ FieldHolder $fh;

        /* renamed from: a  reason: collision with root package name */
        public volatile NetWork f55108a;

        /* renamed from: b  reason: collision with root package name */
        public final /* synthetic */ LikeModel f55109b;

        public b(LikeModel likeModel) {
            Interceptable interceptable = $ic;
            if (interceptable != null) {
                InitContext newInitContext = TitanRuntime.newInitContext();
                newInitContext.initArgs = r2;
                Object[] objArr = {likeModel};
                interceptable.invokeUnInit(65536, newInitContext);
                int i2 = newInitContext.flag;
                if ((i2 & 1) != 0) {
                    int i3 = i2 & 2;
                    newInitContext.thisArg = this;
                    interceptable.invokeInitBody(65536, newInitContext);
                    return;
                }
            }
            this.f55109b = likeModel;
            this.f55108a = null;
        }

        /* JADX DEBUG: Method merged with bridge method */
        @Override // com.baidu.adp.lib.asyncTask.BdAsyncTask
        /* renamed from: b */
        public x doInBackground(Object... objArr) {
            InterceptResult invokeL;
            Interceptable interceptable = $ic;
            if (interceptable == null || (invokeL = interceptable.invokeL(1048576, this, objArr)) == null) {
                try {
                    this.f55108a = new NetWork(TbConfig.SERVER_ADDRESS + TbConfig.LIKE_ADDRESS);
                    this.f55108a.addPostData(TiebaStatic.Params.H5_FORUM_NAME, this.f55109b.f55103e);
                    this.f55108a.addPostData("fid", this.f55109b.f55104f);
                    this.f55108a.addPostData("st_type", this.f55109b.f55106h);
                    this.f55108a.addPostData("authsid", this.f55109b.f55107i);
                    if (!StringUtils.isNull(this.f55109b.j)) {
                        this.f55108a.addPostData("dev_id", this.f55109b.j);
                    }
                    if (!TextUtils.isEmpty(this.f55109b.f55105g)) {
                        this.f55108a.addPostData("pagefrom", this.f55109b.f55105g);
                    }
                    this.f55108a.addPostData("user_name", TbadkCoreApplication.getCurrentAccountName());
                    this.f55108a.addPostData("user_id", TbadkCoreApplication.getCurrentAccount());
                    this.f55108a.addPostData("forum_name", this.f55109b.f55103e);
                    this.f55108a.getNetContext().getRequest().mIsNeedTbs = true;
                    this.f55108a.setNeedSig(true);
                    String postNetData = this.f55108a.postNetData();
                    int serverErrorCode = this.f55108a.getServerErrorCode();
                    String errorString = this.f55108a.getErrorString();
                    this.f55109b.setErrorCode(serverErrorCode);
                    this.f55109b.setErrorString(errorString);
                    AuthTokenData.parse(postNetData);
                    if (postNetData != null) {
                        x xVar = new x();
                        xVar.o(postNetData);
                        if (this.f55108a.getNetContext().getResponse().isRequestSuccess()) {
                            xVar.q(null);
                        }
                        this.f55109b.m = xVar.a();
                        xVar.s(this.f55109b.f55104f);
                        return xVar;
                    }
                } catch (Exception e2) {
                    BdLog.e(e2.getMessage());
                }
                x xVar2 = new x();
                xVar2.v(0);
                xVar2.s(this.f55109b.f55104f);
                return xVar2;
            }
            return (x) invokeL.objValue;
        }

        /* JADX DEBUG: Method merged with bridge method */
        @Override // com.baidu.adp.lib.asyncTask.BdAsyncTask
        /* renamed from: c */
        public void onPostExecute(x xVar) {
            Interceptable interceptable = $ic;
            if (interceptable == null || interceptable.invokeL(Constants.METHOD_GET_CONTACTER_INFO_FOR_SESSION, this, xVar) == null) {
                this.f55109b.l = null;
                if (this.f55108a == null || xVar == null || AntiHelper.a(this.f55109b.getContext(), this.f55109b.getErrorCode(), xVar.b())) {
                    return;
                }
                k kVar = new k();
                kVar.f22724a = b.a.e.f.m.b.g(xVar.g(), 0L);
                xVar.j();
                if (xVar != null && this.f55108a.getNetContext().getResponse().isRequestSuccess()) {
                    MessageManager.getInstance().dispatchResponsedMessage(new CustomResponsedMessage(2001335, Long.valueOf(b.a.e.f.m.b.g(xVar.g(), 0L))));
                    MessageManager.getInstance().dispatchResponsedMessage(new CustomResponsedMessage(2001610, new i.a(this.f55109b.f55103e, xVar.k())));
                    TbadkCoreApplication.getInst().addLikeForum(this.f55109b.f55103e);
                    kVar.f22725b = true;
                    kVar.f22726c = this.f55109b.getErrorString();
                } else {
                    kVar.f22725b = false;
                    kVar.f22726c = this.f55109b.getErrorString();
                }
                if (this.f55109b.mLoadDataCallBack != null) {
                    this.f55109b.mLoadDataCallBack.c(xVar);
                }
                MessageManager.getInstance().dispatchResponsedMessage(new CustomResponsedMessage(2001437, kVar));
            }
        }

        @Override // com.baidu.adp.lib.asyncTask.BdAsyncTask
        public void cancel() {
            Interceptable interceptable = $ic;
            if (interceptable == null || interceptable.invokeV(Constants.METHOD_SEND_USER_MSG, this) == null) {
                if (this.f55108a != null) {
                    this.f55108a.cancelNetConnect();
                    this.f55108a = null;
                }
                this.f55109b.l = null;
                super.cancel(true);
                if (this.f55109b.mLoadDataCallBack != null) {
                    this.f55109b.mLoadDataCallBack.c(null);
                }
            }
        }

        public /* synthetic */ b(LikeModel likeModel, a aVar) {
            this(likeModel);
        }
    }
}
