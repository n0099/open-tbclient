package com.baidu.tieba.tbadkCore;

import android.content.Context;
import android.text.TextUtils;
import androidx.core.view.InputDeviceCompat;
import c.a.d.a.f;
import c.a.t0.b.d;
import c.a.t0.d1.k;
import c.a.u0.z3.y;
import com.baidu.adp.base.BdBaseModel;
import com.baidu.adp.framework.MessageManager;
import com.baidu.adp.framework.message.CustomResponsedMessage;
import com.baidu.adp.lib.asyncTask.BdAsyncTask;
import com.baidu.adp.lib.util.BdLog;
import com.baidu.adp.lib.util.StringUtils;
import com.baidu.android.imsdk.internal.Constants;
import com.baidu.tbadk.TbConfig;
import com.baidu.tbadk.TbPageContext;
import com.baidu.tbadk.TbSingleton;
import com.baidu.tbadk.core.TbadkCoreApplication;
import com.baidu.tbadk.core.data.BlockPopInfoData;
import com.baidu.tbadk.core.util.NetWork;
import com.baidu.tbadk.core.util.TiebaStatic;
import com.baidu.tbadk.coreExtra.data.AuthTokenData;
import com.baidu.tieba.stampmission.mission.StampMission;
import com.baidu.tieba.tbadkCore.util.AntiHelper;
import com.baidu.titan.sdk.runtime.FieldHolder;
import com.baidu.titan.sdk.runtime.InitContext;
import com.baidu.titan.sdk.runtime.InterceptResult;
import com.baidu.titan.sdk.runtime.Interceptable;
import com.baidu.titan.sdk.runtime.TitanRuntime;
/* loaded from: classes13.dex */
public class LikeModel extends BdBaseModel {
    public static /* synthetic */ Interceptable $ic;
    public transient /* synthetic */ FieldHolder $fh;

    /* renamed from: e  reason: collision with root package name */
    public String f48303e;

    /* renamed from: f  reason: collision with root package name */
    public String f48304f;

    /* renamed from: g  reason: collision with root package name */
    public String f48305g;

    /* renamed from: h  reason: collision with root package name */
    public String f48306h;

    /* renamed from: i  reason: collision with root package name */
    public String f48307i;

    /* renamed from: j  reason: collision with root package name */
    public int f48308j;
    public String k;
    public TbPageContext l;
    public b m;
    public BlockPopInfoData n;

    /* loaded from: classes13.dex */
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
        this.f48303e = null;
        this.f48304f = null;
        this.f48305g = null;
        this.f48308j = 0;
        this.m = null;
        this.l = tbPageContext;
    }

    public void J() {
        b bVar;
        Interceptable interceptable = $ic;
        if (!(interceptable == null || interceptable.invokeV(1048576, this) == null) || (bVar = this.m) == null) {
            return;
        }
        bVar.cancel();
        this.m = null;
    }

    public BlockPopInfoData K() {
        InterceptResult invokeV;
        Interceptable interceptable = $ic;
        return (interceptable == null || (invokeV = interceptable.invokeV(Constants.METHOD_GET_CONTACTER_INFO_FOR_SESSION, this)) == null) ? this.n : (BlockPopInfoData) invokeV.objValue;
    }

    public boolean L() {
        InterceptResult invokeV;
        Interceptable interceptable = $ic;
        return (interceptable == null || (invokeV = interceptable.invokeV(Constants.METHOD_SEND_USER_MSG, this)) == null) ? this.m != null : invokeV.booleanValue;
    }

    public void M(int i2) {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeI(1048579, this, i2) == null) {
            this.f48308j = i2;
        }
    }

    public void N(String str, String str2) {
        Interceptable interceptable = $ic;
        if (!(interceptable == null || interceptable.invokeLL(1048580, this, str, str2) == null) || str == null || str.length() <= 0 || str2 == null || str2.length() <= 0 || this.m != null) {
            return;
        }
        this.f48303e = str;
        this.f48304f = str2;
        b bVar = new b(this, null);
        this.m = bVar;
        bVar.setPriority(2);
        this.m.execute(new Object[0]);
    }

    public void O(String str, String str2, String str3) {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeLLL(1048581, this, str, str2, str3) == null) {
            N(str, str2);
            this.f48305g = str3;
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
            TbPageContext tbPageContext = this.l;
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
            this.f48306h = str;
        }
    }

    /* loaded from: classes13.dex */
    public class b extends BdAsyncTask<Object, Integer, y> {
        public static /* synthetic */ Interceptable $ic;
        public transient /* synthetic */ FieldHolder $fh;
        public volatile NetWork a;

        /* renamed from: b  reason: collision with root package name */
        public final /* synthetic */ LikeModel f48309b;

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
            this.f48309b = likeModel;
            this.a = null;
        }

        /* JADX DEBUG: Method merged with bridge method */
        @Override // com.baidu.adp.lib.asyncTask.BdAsyncTask
        /* renamed from: b */
        public y doInBackground(Object... objArr) {
            InterceptResult invokeL;
            Interceptable interceptable = $ic;
            if (interceptable == null || (invokeL = interceptable.invokeL(1048576, this, objArr)) == null) {
                try {
                    this.a = new NetWork(TbConfig.SERVER_ADDRESS + TbConfig.LIKE_ADDRESS);
                    this.a.addPostData(TiebaStatic.Params.H5_FORUM_NAME, this.f48309b.f48303e);
                    this.a.addPostData("fid", this.f48309b.f48304f);
                    this.a.addPostData("st_type", this.f48309b.f48306h);
                    this.a.addPostData("authsid", this.f48309b.f48307i);
                    if (!StringUtils.isNull(this.f48309b.k)) {
                        this.a.addPostData("dev_id", this.f48309b.k);
                    }
                    if (!TextUtils.isEmpty(this.f48309b.f48305g)) {
                        this.a.addPostData("pagefrom", this.f48309b.f48305g);
                    }
                    this.a.addPostData("user_name", TbadkCoreApplication.getCurrentAccountName());
                    this.a.addPostData("user_id", TbadkCoreApplication.getCurrentAccount());
                    this.a.addPostData("forum_name", this.f48309b.f48303e);
                    this.a.addPostData("has_head", String.valueOf(this.f48309b.f48308j));
                    this.a.getNetContext().getRequest().mIsNeedTbs = true;
                    this.a.setNeedSig(true);
                    String postNetData = this.a.postNetData();
                    int serverErrorCode = this.a.getServerErrorCode();
                    String errorString = this.a.getErrorString();
                    this.f48309b.setErrorCode(serverErrorCode);
                    this.f48309b.setErrorString(errorString);
                    AuthTokenData.parse(postNetData);
                    if (postNetData != null) {
                        y yVar = new y();
                        yVar.q(postNetData);
                        if (this.a.getNetContext().getResponse().isRequestSuccess()) {
                            yVar.s(null);
                        }
                        this.f48309b.n = yVar.a();
                        yVar.u(this.f48309b.f48304f);
                        return yVar;
                    }
                } catch (Exception e2) {
                    BdLog.e(e2.getMessage());
                }
                y yVar2 = new y();
                yVar2.x(0);
                yVar2.u(this.f48309b.f48304f);
                return yVar2;
            }
            return (y) invokeL.objValue;
        }

        /* JADX DEBUG: Method merged with bridge method */
        @Override // com.baidu.adp.lib.asyncTask.BdAsyncTask
        /* renamed from: c */
        public void onPostExecute(y yVar) {
            Interceptable interceptable = $ic;
            if (interceptable == null || interceptable.invokeL(Constants.METHOD_GET_CONTACTER_INFO_FOR_SESSION, this, yVar) == null) {
                this.f48309b.m = null;
                if (this.a == null || yVar == null || AntiHelper.a(this.f48309b.getContext(), this.f48309b.getErrorCode(), yVar.b())) {
                    return;
                }
                c.a.u0.z3.t0.f fVar = new c.a.u0.z3.t0.f();
                fVar.a = c.a.d.f.m.b.g(yVar.g(), 0L);
                yVar.j();
                if (yVar != null && this.a.getNetContext().getResponse().isRequestSuccess()) {
                    MessageManager.getInstance().dispatchResponsedMessage(new CustomResponsedMessage(2001335, Long.valueOf(c.a.d.f.m.b.g(yVar.g(), 0L))));
                    MessageManager.getInstance().dispatchResponsedMessage(new CustomResponsedMessage(2001610, new k.a(this.f48309b.f48303e, yVar.l())));
                    TbadkCoreApplication.getInst().addLikeForum(this.f48309b.f48303e);
                    fVar.f26402b = true;
                    fVar.f26403c = this.f48309b.getErrorString();
                    if (TbadkCoreApplication.isLogin()) {
                        if (TbSingleton.getInstance().showStampMissionDialog && d.t0()) {
                            c.a.u0.w3.b.r().A(0, 3);
                            c.a.u0.w3.b.r().G();
                        }
                        c.a.u0.w3.b.r().z(StampMission.Type.FOLLOW_FORUM);
                    }
                } else {
                    fVar.f26402b = false;
                    fVar.f26403c = this.f48309b.getErrorString();
                }
                if (this.f48309b.mLoadDataCallBack != null) {
                    this.f48309b.mLoadDataCallBack.c(yVar);
                }
                MessageManager.getInstance().dispatchResponsedMessage(new CustomResponsedMessage(2001437, fVar));
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
                this.f48309b.m = null;
                super.cancel(true);
                if (this.f48309b.mLoadDataCallBack != null) {
                    this.f48309b.mLoadDataCallBack.c(null);
                }
            }
        }

        public /* synthetic */ b(LikeModel likeModel, a aVar) {
            this(likeModel);
        }
    }
}
