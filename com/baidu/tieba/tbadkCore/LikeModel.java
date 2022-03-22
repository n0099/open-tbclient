package com.baidu.tieba.tbadkCore;

import android.content.Context;
import android.text.TextUtils;
import androidx.core.view.InputDeviceCompat;
import c.a.d.a.f;
import c.a.o0.c1.k;
import c.a.p0.a4.y;
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
import com.baidu.tbadk.abtest.UbsABTestHelper;
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
/* loaded from: classes6.dex */
public class LikeModel extends BdBaseModel {
    public static /* synthetic */ Interceptable $ic;
    public transient /* synthetic */ FieldHolder $fh;
    public String a;

    /* renamed from: b  reason: collision with root package name */
    public String f36100b;

    /* renamed from: c  reason: collision with root package name */
    public String f36101c;

    /* renamed from: d  reason: collision with root package name */
    public String f36102d;

    /* renamed from: e  reason: collision with root package name */
    public String f36103e;

    /* renamed from: f  reason: collision with root package name */
    public int f36104f;

    /* renamed from: g  reason: collision with root package name */
    public String f36105g;

    /* renamed from: h  reason: collision with root package name */
    public TbPageContext f36106h;
    public b i;
    public BlockPopInfoData j;

    /* loaded from: classes6.dex */
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
                super((f) newInitContext.callArgs[0]);
                newInitContext.thisArg = this;
                interceptable.invokeInitBody(65536, newInitContext);
                return;
            }
        }
        this.a = null;
        this.f36100b = null;
        this.f36101c = null;
        this.f36104f = 0;
        this.i = null;
        this.f36106h = tbPageContext;
    }

    public void L() {
        b bVar;
        Interceptable interceptable = $ic;
        if (!(interceptable == null || interceptable.invokeV(1048576, this) == null) || (bVar = this.i) == null) {
            return;
        }
        bVar.cancel();
        this.i = null;
    }

    public BlockPopInfoData M() {
        InterceptResult invokeV;
        Interceptable interceptable = $ic;
        return (interceptable == null || (invokeV = interceptable.invokeV(Constants.METHOD_GET_CONTACTER_INFO_FOR_SESSION, this)) == null) ? this.j : (BlockPopInfoData) invokeV.objValue;
    }

    public boolean N() {
        InterceptResult invokeV;
        Interceptable interceptable = $ic;
        return (interceptable == null || (invokeV = interceptable.invokeV(Constants.METHOD_SEND_USER_MSG, this)) == null) ? this.i != null : invokeV.booleanValue;
    }

    public void O(int i) {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeI(1048579, this, i) == null) {
            this.f36104f = i;
        }
    }

    public void P(String str, String str2) {
        Interceptable interceptable = $ic;
        if (!(interceptable == null || interceptable.invokeLL(1048580, this, str, str2) == null) || str == null || str.length() <= 0 || str2 == null || str2.length() <= 0 || this.i != null) {
            return;
        }
        this.a = str;
        this.f36100b = str2;
        b bVar = new b(this, null);
        this.i = bVar;
        bVar.setPriority(2);
        this.i.execute(new Object[0]);
    }

    public void Q(String str, String str2, String str3) {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeLLL(1048581, this, str, str2, str3) == null) {
            P(str, str2);
            this.f36101c = str3;
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
            TbPageContext tbPageContext = this.f36106h;
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
            this.f36102d = str;
        }
    }

    /* loaded from: classes6.dex */
    public class b extends BdAsyncTask<Object, Integer, y> {
        public static /* synthetic */ Interceptable $ic;
        public transient /* synthetic */ FieldHolder $fh;
        public volatile NetWork a;

        /* renamed from: b  reason: collision with root package name */
        public final /* synthetic */ LikeModel f36107b;

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
            this.f36107b = likeModel;
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
                    this.a.addPostData(TiebaStatic.Params.H5_FORUM_NAME, this.f36107b.a);
                    this.a.addPostData("fid", this.f36107b.f36100b);
                    this.a.addPostData("st_type", this.f36107b.f36102d);
                    this.a.addPostData("authsid", this.f36107b.f36103e);
                    if (!StringUtils.isNull(this.f36107b.f36105g)) {
                        this.a.addPostData("dev_id", this.f36107b.f36105g);
                    }
                    if (!TextUtils.isEmpty(this.f36107b.f36101c)) {
                        this.a.addPostData("pagefrom", this.f36107b.f36101c);
                    }
                    this.a.addPostData("user_name", TbadkCoreApplication.getCurrentAccountName());
                    this.a.addPostData("user_id", TbadkCoreApplication.getCurrentAccount());
                    this.a.addPostData("forum_name", this.f36107b.a);
                    this.a.addPostData("has_head", String.valueOf(this.f36107b.f36104f));
                    this.a.getNetContext().getRequest().mIsNeedTbs = true;
                    this.a.setNeedSig(true);
                    String postNetData = this.a.postNetData();
                    int serverErrorCode = this.a.getServerErrorCode();
                    String errorString = this.a.getErrorString();
                    this.f36107b.setErrorCode(serverErrorCode);
                    this.f36107b.setErrorString(errorString);
                    AuthTokenData.parse(postNetData);
                    if (postNetData != null) {
                        y yVar = new y();
                        yVar.r(postNetData);
                        if (this.a.getNetContext().getResponse().isRequestSuccess()) {
                            yVar.t(null);
                        }
                        this.f36107b.j = yVar.a();
                        yVar.v(this.f36107b.f36100b);
                        return yVar;
                    }
                } catch (Exception e2) {
                    BdLog.e(e2.getMessage());
                }
                y yVar2 = new y();
                yVar2.y(0);
                yVar2.v(this.f36107b.f36100b);
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
                this.f36107b.i = null;
                if (this.a == null || yVar == null || AntiHelper.a(this.f36107b.getContext(), this.f36107b.getErrorCode(), yVar.b())) {
                    return;
                }
                c.a.p0.a4.t0.f fVar = new c.a.p0.a4.t0.f();
                fVar.a = c.a.d.f.m.b.g(yVar.g(), 0L);
                yVar.j();
                if (yVar != null && this.a.getNetContext().getResponse().isRequestSuccess()) {
                    MessageManager.getInstance().dispatchResponsedMessage(new CustomResponsedMessage(2001335, Long.valueOf(c.a.d.f.m.b.g(yVar.g(), 0L))));
                    MessageManager.getInstance().dispatchResponsedMessage(new CustomResponsedMessage(2001610, new k.a(this.f36107b.a, yVar.m())));
                    TbadkCoreApplication.getInst().addLikeForum(this.f36107b.a);
                    fVar.f12402b = true;
                    fVar.f12403c = this.f36107b.getErrorString();
                    if (TbadkCoreApplication.isLogin()) {
                        if (TbSingleton.getInstance().showStampMissionDialog && UbsABTestHelper.isStampMissionDialogABTestB()) {
                            c.a.p0.x3.b.r().A(0, 3);
                            c.a.p0.x3.b.r().G();
                        }
                        c.a.p0.x3.b.r().z(StampMission.Type.FOLLOW_FORUM);
                    }
                } else {
                    fVar.f12402b = false;
                    fVar.f12403c = this.f36107b.getErrorString();
                }
                if (this.f36107b.mLoadDataCallBack != null) {
                    this.f36107b.mLoadDataCallBack.c(yVar);
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
                this.f36107b.i = null;
                super.cancel(true);
                if (this.f36107b.mLoadDataCallBack != null) {
                    this.f36107b.mLoadDataCallBack.c(null);
                }
            }
        }

        public /* synthetic */ b(LikeModel likeModel, a aVar) {
            this(likeModel);
        }
    }
}
