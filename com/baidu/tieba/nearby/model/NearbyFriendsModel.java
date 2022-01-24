package com.baidu.tieba.nearby.model;

import android.content.Intent;
import c.a.d.n.e.n;
import c.a.t0.m2.b.b;
import com.baidu.adp.BdUniqueId;
import com.baidu.adp.base.BdBaseModel;
import com.baidu.adp.framework.MessageManager;
import com.baidu.adp.framework.listener.HttpMessageListener;
import com.baidu.adp.framework.message.HttpMessage;
import com.baidu.adp.framework.message.HttpResponsedMessage;
import com.baidu.android.imsdk.internal.Constants;
import com.baidu.tbadk.core.atomData.NearbyFriendsActivityConfig;
import com.baidu.tbadk.core.frameworkData.CmdConfigHttp;
import com.baidu.tbadk.core.util.ListUtils;
import com.baidu.tieba.nearby.message.NearbyFriendsHttpResponseMessage;
import com.baidu.titan.sdk.runtime.FieldHolder;
import com.baidu.titan.sdk.runtime.InitContext;
import com.baidu.titan.sdk.runtime.InterceptResult;
import com.baidu.titan.sdk.runtime.Interceptable;
import com.baidu.titan.sdk.runtime.TitanRuntime;
import java.util.ArrayList;
import java.util.List;
/* loaded from: classes12.dex */
public class NearbyFriendsModel extends BdBaseModel<NearbyFriendsModel> implements c.a.t0.m2.c.a {
    public static /* synthetic */ Interceptable $ic;
    public transient /* synthetic */ FieldHolder $fh;

    /* renamed from: e  reason: collision with root package name */
    public c.a.t0.m2.d.a f46086e;

    /* renamed from: f  reason: collision with root package name */
    public int f46087f;

    /* renamed from: g  reason: collision with root package name */
    public List<n> f46088g;

    /* renamed from: h  reason: collision with root package name */
    public boolean f46089h;

    /* renamed from: i  reason: collision with root package name */
    public boolean f46090i;

    /* renamed from: j  reason: collision with root package name */
    public final HttpMessageListener f46091j;

    /* loaded from: classes12.dex */
    public class a extends HttpMessageListener {
        public static /* synthetic */ Interceptable $ic;
        public transient /* synthetic */ FieldHolder $fh;
        public final /* synthetic */ NearbyFriendsModel a;

        /* JADX WARN: 'super' call moved to the top of the method (can break code semantics) */
        public a(NearbyFriendsModel nearbyFriendsModel, int i2) {
            super(i2);
            Interceptable interceptable = $ic;
            if (interceptable != null) {
                InitContext newInitContext = TitanRuntime.newInitContext();
                newInitContext.initArgs = r2;
                Object[] objArr = {nearbyFriendsModel, Integer.valueOf(i2)};
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
            this.a = nearbyFriendsModel;
        }

        /* JADX DEBUG: Method merged with bridge method */
        @Override // com.baidu.adp.framework.listener.MessageListener
        public void onMessage(HttpResponsedMessage httpResponsedMessage) {
            Interceptable interceptable = $ic;
            if ((interceptable == null || interceptable.invokeL(1048576, this, httpResponsedMessage) == null) && httpResponsedMessage != null && httpResponsedMessage.getCmd() == 1003520 && (httpResponsedMessage instanceof NearbyFriendsHttpResponseMessage) && this.a.f46086e != null) {
                this.a.f46086e.hideLoadingView();
                if (httpResponsedMessage.getError() != 0) {
                    if (this.a.f46087f == 1) {
                        if (this.a.f46086e != null) {
                            this.a.f46086e.l(httpResponsedMessage.getErrorString());
                            return;
                        }
                        return;
                    } else if (this.a.f46086e != null) {
                        this.a.f46086e.e(httpResponsedMessage.getErrorString());
                        return;
                    } else {
                        return;
                    }
                }
                if (this.a.f46088g == null) {
                    this.a.f46088g = new ArrayList();
                }
                if (this.a.f46087f == 1) {
                    this.a.f46088g.clear();
                }
                b nearbyFriendData = ((NearbyFriendsHttpResponseMessage) httpResponsedMessage).getNearbyFriendData();
                if (!ListUtils.isEmpty(nearbyFriendData.a)) {
                    this.a.f46088g.addAll(nearbyFriendData.a);
                }
                this.a.f46089h = nearbyFriendData.f19574b;
                this.a.f46086e.hideLoadingView();
                this.a.f46086e.b(false);
                this.a.f46086e.h(0);
                this.a.f46086e.d(this.a.f46090i, this.a.f46088g);
                this.a.f46086e.i(this.a.f46089h);
                if (this.a.f46089h) {
                    NearbyFriendsModel.y(this.a);
                }
            }
        }
    }

    public NearbyFriendsModel(c.a.t0.m2.d.a aVar, BdUniqueId bdUniqueId) {
        Interceptable interceptable = $ic;
        if (interceptable != null) {
            InitContext newInitContext = TitanRuntime.newInitContext();
            newInitContext.initArgs = r2;
            Object[] objArr = {aVar, bdUniqueId};
            interceptable.invokeUnInit(65536, newInitContext);
            int i2 = newInitContext.flag;
            if ((i2 & 1) != 0) {
                int i3 = i2 & 2;
                newInitContext.thisArg = this;
                interceptable.invokeInitBody(65536, newInitContext);
                return;
            }
        }
        this.f46087f = 1;
        a aVar2 = new a(this, CmdConfigHttp.CMD_GET_NEARBY_FRIENDS);
        this.f46091j = aVar2;
        this.f46086e = aVar;
        aVar2.setTag(bdUniqueId);
        registerListener(this.f46091j);
    }

    public static /* synthetic */ int y(NearbyFriendsModel nearbyFriendsModel) {
        int i2 = nearbyFriendsModel.f46087f;
        nearbyFriendsModel.f46087f = i2 + 1;
        return i2;
    }

    public void E(Intent intent) {
        Interceptable interceptable = $ic;
        if (!(interceptable == null || interceptable.invokeL(1048576, this, intent) == null) || intent == null) {
            return;
        }
        this.f46090i = intent.getBooleanExtra(NearbyFriendsActivityConfig.KEY_NEED_COMPLETE_PROFILE, false);
    }

    @Override // com.baidu.adp.base.BdBaseModel
    public boolean cancelLoadData() {
        InterceptResult invokeV;
        Interceptable interceptable = $ic;
        if (interceptable == null || (invokeV = interceptable.invokeV(Constants.METHOD_GET_CONTACTER_INFO_FOR_SESSION, this)) == null) {
            return false;
        }
        return invokeV.booleanValue;
    }

    @Override // c.a.t0.m2.c.a
    public boolean hasMore() {
        InterceptResult invokeV;
        Interceptable interceptable = $ic;
        return (interceptable == null || (invokeV = interceptable.invokeV(Constants.METHOD_SEND_USER_MSG, this)) == null) ? this.f46089h : invokeV.booleanValue;
    }

    @Override // com.baidu.adp.base.BdBaseModel
    public boolean loadData() {
        InterceptResult invokeV;
        Interceptable interceptable = $ic;
        if (interceptable == null || (invokeV = interceptable.invokeV(1048579, this)) == null) {
            HttpMessage httpMessage = new HttpMessage(CmdConfigHttp.CMD_GET_NEARBY_FRIENDS);
            httpMessage.addParam("pn", this.f46087f);
            httpMessage.addParam("rn", 20);
            httpMessage.addParam("app_pos", c.a.t0.k3.j0.a.e().b());
            MessageManager.getInstance().sendMessage(httpMessage);
            return false;
        }
        return invokeV.booleanValue;
    }

    @Override // c.a.t0.m2.c.a
    public void loadMore() {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeV(1048580, this) == null) {
            loadData();
        }
    }

    public void onDestroy() {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeV(1048581, this) == null) {
            this.f46086e = null;
        }
    }

    @Override // c.a.t0.m2.c.a
    public void refresh() {
        c.a.t0.m2.d.a aVar;
        Interceptable interceptable = $ic;
        if (!(interceptable == null || interceptable.invokeV(1048582, this) == null) || (aVar = this.f46086e) == null) {
            return;
        }
        aVar.k();
        this.f46086e.hideLoadingView();
        this.f46087f = 1;
        loadData();
    }

    @Override // c.a.t0.m2.c.a
    public void reload() {
        c.a.t0.m2.d.a aVar;
        Interceptable interceptable = $ic;
        if (!(interceptable == null || interceptable.invokeV(1048583, this) == null) || (aVar = this.f46086e) == null) {
            return;
        }
        aVar.k();
        this.f46086e.a();
        this.f46087f = 1;
        loadData();
    }
}
