package com.baidu.tieba.tbadkCore;

import android.content.Context;
import android.text.TextUtils;
import androidx.core.view.InputDeviceCompat;
import c.a.e.a.f;
import c.a.o0.b1.f;
import c.a.p0.i3.q0.k;
import c.a.p0.i3.w;
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
/* loaded from: classes7.dex */
public class LikeModel extends BdBaseModel {
    public static /* synthetic */ Interceptable $ic;
    public transient /* synthetic */ FieldHolder $fh;

    /* renamed from: e  reason: collision with root package name */
    public String f56730e;

    /* renamed from: f  reason: collision with root package name */
    public String f56731f;

    /* renamed from: g  reason: collision with root package name */
    public String f56732g;

    /* renamed from: h  reason: collision with root package name */
    public String f56733h;

    /* renamed from: i  reason: collision with root package name */
    public String f56734i;

    /* renamed from: j  reason: collision with root package name */
    public String f56735j;
    public TbPageContext k;
    public b l;
    public BlockPopInfoData m;

    /* loaded from: classes7.dex */
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
        this.f56730e = null;
        this.f56731f = null;
        this.f56732g = null;
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
        this.f56730e = str;
        this.f56731f = str2;
        b bVar = new b(this, null);
        this.l = bVar;
        bVar.setPriority(2);
        this.l.execute(new Object[0]);
    }

    @Override // com.baidu.adp.base.BdBaseModel
    public boolean LoadData() {
        InterceptResult invokeV;
        Interceptable interceptable = $ic;
        if (interceptable == null || (invokeV = interceptable.invokeV(1048580, this)) == null) {
            return false;
        }
        return invokeV.booleanValue;
    }

    public void M(String str, String str2, String str3) {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeLLL(1048581, this, str, str2, str3) == null) {
            L(str, str2);
            this.f56732g = str3;
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
            TbPageContext tbPageContext = this.k;
            if (tbPageContext != null) {
                return tbPageContext.getPageActivity();
            }
            return null;
        }
        return (Context) invokeV.objValue;
    }

    public void setFrom(String str) {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeL(InputDeviceCompat.SOURCE_TOUCHPAD, this, str) == null) {
            this.f56733h = str;
        }
    }

    /* loaded from: classes7.dex */
    public class b extends BdAsyncTask<Object, Integer, w> {
        public static /* synthetic */ Interceptable $ic;
        public transient /* synthetic */ FieldHolder $fh;

        /* renamed from: a  reason: collision with root package name */
        public volatile NetWork f56736a;

        /* renamed from: b  reason: collision with root package name */
        public final /* synthetic */ LikeModel f56737b;

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
            this.f56737b = likeModel;
            this.f56736a = null;
        }

        /* JADX DEBUG: Method merged with bridge method */
        @Override // com.baidu.adp.lib.asyncTask.BdAsyncTask
        /* renamed from: b */
        public w doInBackground(Object... objArr) {
            InterceptResult invokeL;
            Interceptable interceptable = $ic;
            if (interceptable == null || (invokeL = interceptable.invokeL(1048576, this, objArr)) == null) {
                try {
                    this.f56736a = new NetWork(TbConfig.SERVER_ADDRESS + TbConfig.LIKE_ADDRESS);
                    this.f56736a.addPostData(TiebaStatic.Params.H5_FORUM_NAME, this.f56737b.f56730e);
                    this.f56736a.addPostData("fid", this.f56737b.f56731f);
                    this.f56736a.addPostData("st_type", this.f56737b.f56733h);
                    this.f56736a.addPostData("authsid", this.f56737b.f56734i);
                    if (!StringUtils.isNull(this.f56737b.f56735j)) {
                        this.f56736a.addPostData("dev_id", this.f56737b.f56735j);
                    }
                    if (!TextUtils.isEmpty(this.f56737b.f56732g)) {
                        this.f56736a.addPostData("pagefrom", this.f56737b.f56732g);
                    }
                    this.f56736a.addPostData("user_name", TbadkCoreApplication.getCurrentAccountName());
                    this.f56736a.addPostData("user_id", TbadkCoreApplication.getCurrentAccount());
                    this.f56736a.addPostData("forum_name", this.f56737b.f56730e);
                    this.f56736a.getNetContext().getRequest().mIsNeedTbs = true;
                    this.f56736a.setNeedSig(true);
                    String postNetData = this.f56736a.postNetData();
                    int serverErrorCode = this.f56736a.getServerErrorCode();
                    String errorString = this.f56736a.getErrorString();
                    this.f56737b.setErrorCode(serverErrorCode);
                    this.f56737b.setErrorString(errorString);
                    AuthTokenData.parse(postNetData);
                    if (postNetData != null) {
                        w wVar = new w();
                        wVar.o(postNetData);
                        if (this.f56736a.getNetContext().getResponse().isRequestSuccess()) {
                            wVar.q(null);
                        }
                        this.f56737b.m = wVar.a();
                        wVar.s(this.f56737b.f56731f);
                        return wVar;
                    }
                } catch (Exception e2) {
                    BdLog.e(e2.getMessage());
                }
                w wVar2 = new w();
                wVar2.v(0);
                wVar2.s(this.f56737b.f56731f);
                return wVar2;
            }
            return (w) invokeL.objValue;
        }

        /* JADX DEBUG: Method merged with bridge method */
        @Override // com.baidu.adp.lib.asyncTask.BdAsyncTask
        /* renamed from: c */
        public void onPostExecute(w wVar) {
            Interceptable interceptable = $ic;
            if (interceptable == null || interceptable.invokeL(Constants.METHOD_GET_CONTACTER_INFO_FOR_SESSION, this, wVar) == null) {
                this.f56737b.l = null;
                if (this.f56736a == null || wVar == null || AntiHelper.a(this.f56737b.getContext(), this.f56737b.getErrorCode(), wVar.b())) {
                    return;
                }
                k kVar = new k();
                kVar.f20217a = c.a.e.e.m.b.f(wVar.g(), 0L);
                wVar.j();
                if (wVar != null && this.f56736a.getNetContext().getResponse().isRequestSuccess()) {
                    MessageManager.getInstance().dispatchResponsedMessage(new CustomResponsedMessage(2001335, Long.valueOf(c.a.e.e.m.b.f(wVar.g(), 0L))));
                    MessageManager.getInstance().dispatchResponsedMessage(new CustomResponsedMessage(2001610, new f.a(this.f56737b.f56730e, wVar.k())));
                    TbadkCoreApplication.getInst().addLikeForum(this.f56737b.f56730e);
                    kVar.f20218b = true;
                    kVar.f20219c = this.f56737b.getErrorString();
                } else {
                    kVar.f20218b = false;
                    kVar.f20219c = this.f56737b.getErrorString();
                }
                if (this.f56737b.mLoadDataCallBack != null) {
                    this.f56737b.mLoadDataCallBack.c(wVar);
                }
                MessageManager.getInstance().dispatchResponsedMessage(new CustomResponsedMessage(2001437, kVar));
            }
        }

        @Override // com.baidu.adp.lib.asyncTask.BdAsyncTask
        public void cancel() {
            Interceptable interceptable = $ic;
            if (interceptable == null || interceptable.invokeV(Constants.METHOD_SEND_USER_MSG, this) == null) {
                if (this.f56736a != null) {
                    this.f56736a.cancelNetConnect();
                    this.f56736a = null;
                }
                this.f56737b.l = null;
                super.cancel(true);
                if (this.f56737b.mLoadDataCallBack != null) {
                    this.f56737b.mLoadDataCallBack.c(null);
                }
            }
        }

        public /* synthetic */ b(LikeModel likeModel, a aVar) {
            this(likeModel);
        }
    }
}
