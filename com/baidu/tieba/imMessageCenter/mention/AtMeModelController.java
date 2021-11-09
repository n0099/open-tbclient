package com.baidu.tieba.imMessageCenter.mention;

import android.os.Bundle;
import androidx.core.view.InputDeviceCompat;
import b.a.e.a.f;
import b.a.e.a.j;
import b.a.r0.m1.b.b;
import b.a.r0.m1.b.c;
import b.a.r0.m1.b.g;
import com.baidu.adp.base.BdBaseModel;
import com.baidu.adp.framework.listener.CustomMessageListener;
import com.baidu.adp.framework.message.CustomResponsedMessage;
import com.baidu.adp.lib.util.NetWorkChangedMessage;
import com.baidu.android.imsdk.internal.Constants;
import com.baidu.tbadk.TbPageContext;
import com.baidu.tbadk.core.TbadkCoreApplication;
import com.baidu.tbadk.core.data.ErrorData;
import com.baidu.tbadk.mvc.message.MvcHttpMessage;
import com.baidu.tbadk.mvc.message.MvcHttpResponsedMessage;
import com.baidu.tbadk.mvc.message.MvcNetMessage;
import com.baidu.tbadk.mvc.message.MvcSocketMessage;
import com.baidu.tbadk.mvc.message.MvcSocketResponsedMessage;
import com.baidu.tbadk.mvc.message.ReadCacheMessage;
import com.baidu.tbadk.mvc.message.ReadCacheRespMsg;
import com.baidu.tbadk.mvc.message.WriteCacheMessage;
import com.baidu.tbadk.mvc.message.WriteCacheRespMsg;
import com.baidu.tbadk.mvc.model.CacheModel;
import com.baidu.tbadk.mvc.model.NetModel;
import com.baidu.titan.sdk.runtime.FieldHolder;
import com.baidu.titan.sdk.runtime.InitContext;
import com.baidu.titan.sdk.runtime.InterceptResult;
import com.baidu.titan.sdk.runtime.Interceptable;
import com.baidu.titan.sdk.runtime.TitanRuntime;
import java.util.ArrayList;
import java.util.List;
/* loaded from: classes9.dex */
public class AtMeModelController extends BdBaseModel<AtMessageActivity> implements CacheModel.c<c>, NetModel.k<b, c> {
    public static /* synthetic */ Interceptable $ic;
    public transient /* synthetic */ FieldHolder $fh;

    /* renamed from: e  reason: collision with root package name */
    public AtMessageActivity f50782e;

    /* renamed from: f  reason: collision with root package name */
    public b f50783f;

    /* renamed from: g  reason: collision with root package name */
    public AtMeNetModel f50784g;

    /* renamed from: h  reason: collision with root package name */
    public AtMeCacheModel f50785h;

    /* renamed from: i  reason: collision with root package name */
    public b.a.q0.k0.d.a f50786i;
    public FeedData j;
    public g k;
    public final CustomMessageListener l;

    /* loaded from: classes9.dex */
    public class a extends CustomMessageListener {
        public static /* synthetic */ Interceptable $ic;
        public transient /* synthetic */ FieldHolder $fh;

        /* renamed from: a  reason: collision with root package name */
        public final /* synthetic */ AtMeModelController f50787a;

        /* JADX WARN: 'super' call moved to the top of the method (can break code semantics) */
        public a(AtMeModelController atMeModelController, int i2) {
            super(i2);
            Interceptable interceptable = $ic;
            if (interceptable != null) {
                InitContext newInitContext = TitanRuntime.newInitContext();
                newInitContext.initArgs = r2;
                Object[] objArr = {atMeModelController, Integer.valueOf(i2)};
                interceptable.invokeUnInit(65536, newInitContext);
                int i3 = newInitContext.flag;
                if ((i3 & 1) != 0) {
                    int i4 = i3 & 2;
                    super(((Integer) newInitContext.callArgs[0]).intValue());
                    newInitContext.thisArg = this;
                    interceptable.invokeInitBody(65536, newInitContext);
                    return;
                }
            }
            this.f50787a = atMeModelController;
        }

        /* JADX DEBUG: Method merged with bridge method */
        @Override // com.baidu.adp.framework.listener.MessageListener
        public void onMessage(CustomResponsedMessage<?> customResponsedMessage) {
            Interceptable interceptable = $ic;
            if ((interceptable == null || interceptable.invokeL(1048576, this, customResponsedMessage) == null) && customResponsedMessage.getCmd() == 2000994 && (customResponsedMessage instanceof NetWorkChangedMessage) && !customResponsedMessage.hasError()) {
                this.f50787a.f50782e.dismissPullRefresh();
            }
        }
    }

    /* JADX WARN: 'super' call moved to the top of the method (can break code semantics) */
    public AtMeModelController(AtMessageActivity atMessageActivity) {
        super(j.a(atMessageActivity.getPageContext().getPageActivity()));
        Interceptable interceptable = $ic;
        if (interceptable != null) {
            InitContext newInitContext = TitanRuntime.newInitContext();
            newInitContext.initArgs = r2;
            Object[] objArr = {atMessageActivity};
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
        this.l = new a(this, 2000994);
        this.f50782e = atMessageActivity;
    }

    public boolean A() {
        InterceptResult invokeV;
        Interceptable interceptable = $ic;
        if (interceptable == null || (invokeV = interceptable.invokeV(1048576, this)) == null) {
            if (!this.f50784g.Q() && this.f50786i.a() && x()) {
                this.f50786i.f(true);
                this.f50786i.h(true);
                this.f50783f.c(this.j);
                this.f50784g.setNeedCache(false);
                this.f50784g.loadData();
                this.f50782e.onViewStateChanged(this.f50786i);
                return true;
            }
            return false;
        }
        return invokeV.booleanValue;
    }

    public boolean B(b bVar, c cVar) {
        InterceptResult invokeLL;
        Interceptable interceptable = $ic;
        if (interceptable == null || (invokeLL = interceptable.invokeLL(Constants.METHOD_GET_CONTACTER_INFO_FOR_SESSION, this, bVar, cVar)) == null) {
            this.f50782e.hideNetRefreshView();
            if (bVar.a() != 4) {
                this.k.a().clear();
            }
            this.k.c(cVar);
            if (cVar != null && cVar.a() != null && cVar.a().size() > 0) {
                this.j = cVar.a().get(cVar.a().size() - 1);
                if (this.k.b() != null) {
                    this.f50786i.e(this.k.b().b() == 1);
                } else {
                    this.f50786i.e(true);
                }
                if (bVar != null) {
                    bVar.d();
                }
                this.f50786i.h(true);
            } else {
                this.j = null;
                this.f50786i.e(false);
                this.f50786i.h(false);
            }
            this.f50786i.f(false);
            this.f50786i.g(false);
            b.a.q0.t.d.b.g0().k();
            if (!TbadkCoreApplication.isLogin()) {
                this.k.a().clear();
            } else {
                this.f50782e.onViewStateChanged(this.f50786i);
            }
            this.f50782e.onViewDataChanged(this.k);
            return false;
        }
        return invokeLL.booleanValue;
    }

    public boolean C() {
        InterceptResult invokeV;
        Interceptable interceptable = $ic;
        if (interceptable == null || (invokeV = interceptable.invokeV(Constants.METHOD_SEND_USER_MSG, this)) == null) {
            if (this.f50784g.Q() || !x()) {
                return false;
            }
            this.j = null;
            this.f50783f.b();
            this.f50784g.setNeedCache(true);
            this.f50784g.loadData();
            return true;
        }
        return invokeV.booleanValue;
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

    @Override // com.baidu.tbadk.mvc.model.NetModel.m
    public void k(MvcSocketResponsedMessage<c, ?> mvcSocketResponsedMessage, MvcSocketMessage<b, c> mvcSocketMessage, MvcNetMessage<b, c> mvcNetMessage) {
        c cVar;
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeLLL(1048580, this, mvcSocketResponsedMessage, mvcSocketMessage, mvcNetMessage) == null) {
            this.f50782e.dismissPullRefresh();
            if (mvcSocketResponsedMessage != null && !mvcSocketResponsedMessage.hasError()) {
                cVar = mvcSocketResponsedMessage.getData();
                r0 = mvcSocketMessage != null ? mvcSocketMessage.getRequestData() : null;
                if (mvcNetMessage != null) {
                    r0 = mvcNetMessage.getRequestData();
                }
            } else {
                b.a.q0.t.d.b.g0().Z(0);
                cVar = null;
            }
            if (r0 == null || cVar == null || !B(r0, cVar)) {
                if (mvcSocketResponsedMessage != null) {
                    this.mErrorCode = mvcSocketResponsedMessage.getError();
                    this.mErrorString = mvcSocketResponsedMessage.getErrorString();
                }
                ErrorData errorData = new ErrorData();
                errorData.setError_code(this.mErrorCode);
                errorData.setError_msg(this.mErrorString);
                this.f50782e.onServerError(errorData);
            }
        }
    }

    @Override // com.baidu.adp.base.BdBaseModel
    public boolean loadData() {
        InterceptResult invokeV;
        Interceptable interceptable = $ic;
        if (interceptable == null || (invokeV = interceptable.invokeV(1048581, this)) == null) {
            return false;
        }
        return invokeV.booleanValue;
    }

    @Override // com.baidu.tbadk.mvc.model.CacheModel.c
    public void onCacheDataGet(ReadCacheRespMsg<List<c>> readCacheRespMsg, ReadCacheMessage<c> readCacheMessage) {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeLL(1048582, this, readCacheRespMsg, readCacheMessage) == null) {
            if (readCacheRespMsg != null && readCacheRespMsg.getData() != null && readCacheRespMsg.getData().size() > 0) {
                B(this.f50783f, readCacheRespMsg.getData().get(0));
            }
            this.j = null;
            this.f50783f.b();
            this.f50784g.setNeedCache(true);
            this.f50784g.loadData();
        }
    }

    @Override // com.baidu.tbadk.mvc.model.CacheModel.c
    public void onCacheDataWrite(WriteCacheRespMsg<List<c>> writeCacheRespMsg, WriteCacheMessage<c> writeCacheMessage) {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeLL(1048583, this, writeCacheRespMsg, writeCacheMessage) == null) {
        }
    }

    @Override // com.baidu.tbadk.mvc.model.NetModel.l
    public void p(MvcHttpResponsedMessage<c> mvcHttpResponsedMessage, MvcHttpMessage<b, c> mvcHttpMessage, MvcNetMessage<b, c> mvcNetMessage) {
        c cVar;
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeLLL(InputDeviceCompat.SOURCE_TOUCHPAD, this, mvcHttpResponsedMessage, mvcHttpMessage, mvcNetMessage) == null) {
            this.f50782e.dismissPullRefresh();
            if (mvcHttpResponsedMessage != null && !mvcHttpResponsedMessage.hasError()) {
                cVar = mvcHttpResponsedMessage.getData();
                r0 = mvcHttpMessage != null ? mvcHttpMessage.getRequestData() : null;
                if (mvcNetMessage != null) {
                    r0 = mvcNetMessage.getRequestData();
                }
            } else {
                b.a.q0.t.d.b.g0().Z(0);
                cVar = null;
            }
            if (r0 == null || cVar == null || !B(r0, cVar)) {
                if (mvcHttpResponsedMessage != null) {
                    this.mErrorCode = mvcHttpResponsedMessage.getError();
                    this.mErrorString = mvcHttpResponsedMessage.getErrorString();
                }
                ErrorData errorData = new ErrorData();
                errorData.setError_code(this.mErrorCode);
                errorData.setError_msg(this.mErrorString);
                this.f50782e.onServerError(errorData);
            }
        }
    }

    public boolean x() {
        InterceptResult invokeV;
        ArrayList<FeedData> arrayList;
        Interceptable interceptable = $ic;
        if (interceptable == null || (invokeV = interceptable.invokeV(1048585, this)) == null) {
            if (TbadkCoreApplication.isLogin()) {
                return true;
            }
            g gVar = this.k;
            if (gVar != null && (arrayList = gVar.f21067e) != null) {
                arrayList.clear();
            }
            this.f50782e.dismissPullRefresh();
            this.f50782e.onViewDataChanged(this.k);
            return false;
        }
        return invokeV.booleanValue;
    }

    public boolean y() {
        InterceptResult invokeV;
        Interceptable interceptable = $ic;
        if (interceptable == null || (invokeV = interceptable.invokeV(1048586, this)) == null) {
            if (x()) {
                AtMessageActivity atMessageActivity = this.f50782e;
                if (atMessageActivity != null) {
                    atMessageActivity.showPullRefresh();
                }
                this.f50785h.M(this.f50783f);
                return true;
            }
            return true;
        }
        return invokeV.booleanValue;
    }

    public void z(Bundle bundle) {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeL(1048587, this, bundle) == null) {
            this.f50783f = new b();
            AtMeNetModel atMeNetModel = new AtMeNetModel((TbPageContext) j.a(this.f50782e.getPageContext().getPageActivity()), this.f50783f);
            this.f50784g = atMeNetModel;
            atMeNetModel.Y(this);
            AtMessageActivity atMessageActivity = this.f50782e;
            if (atMessageActivity != null) {
                this.f50784g.setUniqueId(atMessageActivity.getUniqueId());
            }
            this.f50784g.registerListener(this.l);
            AtMeCacheModel atMeCacheModel = new AtMeCacheModel((TbPageContext) j.a(this.f50782e.getPageContext().getPageActivity()));
            this.f50785h = atMeCacheModel;
            atMeCacheModel.O(this);
            AtMessageActivity atMessageActivity2 = this.f50782e;
            if (atMessageActivity2 != null) {
                this.f50785h.setUniqueId(atMessageActivity2.getUniqueId());
            }
            this.k = new g();
            this.f50786i = new b.a.q0.k0.d.a();
        }
    }
}
