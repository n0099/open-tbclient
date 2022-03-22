package com.baidu.tieba.nearby.model;

import android.content.Intent;
import c.a.d.o.e.n;
import c.a.p0.p2.b.b;
import com.baidu.adp.BdUniqueId;
import com.baidu.adp.base.BdBaseModel;
import com.baidu.adp.framework.MessageManager;
import com.baidu.adp.framework.listener.HttpMessageListener;
import com.baidu.adp.framework.message.HttpMessage;
import com.baidu.adp.framework.message.HttpResponsedMessage;
import com.baidu.android.imsdk.internal.Constants;
import com.baidu.mobstat.Config;
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
/* loaded from: classes5.dex */
public class NearbyFriendsModel extends BdBaseModel<NearbyFriendsModel> implements c.a.p0.p2.c.a {
    public static /* synthetic */ Interceptable $ic;
    public transient /* synthetic */ FieldHolder $fh;
    public c.a.p0.p2.d.a a;

    /* renamed from: b  reason: collision with root package name */
    public int f34582b;

    /* renamed from: c  reason: collision with root package name */
    public List<n> f34583c;

    /* renamed from: d  reason: collision with root package name */
    public boolean f34584d;

    /* renamed from: e  reason: collision with root package name */
    public boolean f34585e;

    /* renamed from: f  reason: collision with root package name */
    public final HttpMessageListener f34586f;

    /* loaded from: classes5.dex */
    public class a extends HttpMessageListener {
        public static /* synthetic */ Interceptable $ic;
        public transient /* synthetic */ FieldHolder $fh;
        public final /* synthetic */ NearbyFriendsModel a;

        /* JADX WARN: 'super' call moved to the top of the method (can break code semantics) */
        public a(NearbyFriendsModel nearbyFriendsModel, int i) {
            super(i);
            Interceptable interceptable = $ic;
            if (interceptable != null) {
                InitContext newInitContext = TitanRuntime.newInitContext();
                newInitContext.initArgs = r2;
                Object[] objArr = {nearbyFriendsModel, Integer.valueOf(i)};
                interceptable.invokeUnInit(65536, newInitContext);
                int i2 = newInitContext.flag;
                if ((i2 & 1) != 0) {
                    int i3 = i2 & 2;
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
            if ((interceptable == null || interceptable.invokeL(1048576, this, httpResponsedMessage) == null) && httpResponsedMessage != null && httpResponsedMessage.getCmd() == 1003520 && (httpResponsedMessage instanceof NearbyFriendsHttpResponseMessage) && this.a.a != null) {
                this.a.a.d();
                if (httpResponsedMessage.getError() != 0) {
                    if (this.a.f34582b == 1) {
                        if (this.a.a != null) {
                            this.a.a.n(httpResponsedMessage.getErrorString());
                            return;
                        }
                        return;
                    } else if (this.a.a != null) {
                        this.a.a.g(httpResponsedMessage.getErrorString());
                        return;
                    } else {
                        return;
                    }
                }
                if (this.a.f34583c == null) {
                    this.a.f34583c = new ArrayList();
                }
                if (this.a.f34582b == 1) {
                    this.a.f34583c.clear();
                }
                b nearbyFriendData = ((NearbyFriendsHttpResponseMessage) httpResponsedMessage).getNearbyFriendData();
                if (!ListUtils.isEmpty(nearbyFriendData.a)) {
                    this.a.f34583c.addAll(nearbyFriendData.a);
                }
                this.a.f34584d = nearbyFriendData.f16908b;
                this.a.a.d();
                this.a.a.b(false);
                this.a.a.j(0);
                this.a.a.f(this.a.f34585e, this.a.f34583c);
                this.a.a.k(this.a.f34584d);
                if (this.a.f34584d) {
                    NearbyFriendsModel.A(this.a);
                }
            }
        }
    }

    public NearbyFriendsModel(c.a.p0.p2.d.a aVar, BdUniqueId bdUniqueId) {
        Interceptable interceptable = $ic;
        if (interceptable != null) {
            InitContext newInitContext = TitanRuntime.newInitContext();
            newInitContext.initArgs = r2;
            Object[] objArr = {aVar, bdUniqueId};
            interceptable.invokeUnInit(65536, newInitContext);
            int i = newInitContext.flag;
            if ((i & 1) != 0) {
                int i2 = i & 2;
                newInitContext.thisArg = this;
                interceptable.invokeInitBody(65536, newInitContext);
                return;
            }
        }
        this.f34582b = 1;
        a aVar2 = new a(this, CmdConfigHttp.CMD_GET_NEARBY_FRIENDS);
        this.f34586f = aVar2;
        this.a = aVar;
        aVar2.setTag(bdUniqueId);
        registerListener(this.f34586f);
    }

    public static /* synthetic */ int A(NearbyFriendsModel nearbyFriendsModel) {
        int i = nearbyFriendsModel.f34582b;
        nearbyFriendsModel.f34582b = i + 1;
        return i;
    }

    public void G(Intent intent) {
        Interceptable interceptable = $ic;
        if (!(interceptable == null || interceptable.invokeL(1048576, this, intent) == null) || intent == null) {
            return;
        }
        this.f34585e = intent.getBooleanExtra(NearbyFriendsActivityConfig.KEY_NEED_COMPLETE_PROFILE, false);
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

    @Override // c.a.p0.p2.c.a
    public boolean hasMore() {
        InterceptResult invokeV;
        Interceptable interceptable = $ic;
        return (interceptable == null || (invokeV = interceptable.invokeV(Constants.METHOD_SEND_USER_MSG, this)) == null) ? this.f34584d : invokeV.booleanValue;
    }

    @Override // com.baidu.adp.base.BdBaseModel
    public boolean loadData() {
        InterceptResult invokeV;
        Interceptable interceptable = $ic;
        if (interceptable == null || (invokeV = interceptable.invokeV(1048579, this)) == null) {
            HttpMessage httpMessage = new HttpMessage(CmdConfigHttp.CMD_GET_NEARBY_FRIENDS);
            httpMessage.addParam(Config.PACKAGE_NAME, this.f34582b);
            httpMessage.addParam("rn", 20);
            httpMessage.addParam("app_pos", c.a.p0.l3.k0.a.e().b());
            MessageManager.getInstance().sendMessage(httpMessage);
            return false;
        }
        return invokeV.booleanValue;
    }

    @Override // c.a.p0.p2.c.a
    public void loadMore() {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeV(1048580, this) == null) {
            loadData();
        }
    }

    public void onDestroy() {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeV(1048581, this) == null) {
            this.a = null;
        }
    }

    @Override // c.a.p0.p2.c.a
    public void refresh() {
        c.a.p0.p2.d.a aVar;
        Interceptable interceptable = $ic;
        if (!(interceptable == null || interceptable.invokeV(1048582, this) == null) || (aVar = this.a) == null) {
            return;
        }
        aVar.m();
        this.a.d();
        this.f34582b = 1;
        loadData();
    }

    @Override // c.a.p0.p2.c.a
    public void reload() {
        c.a.p0.p2.d.a aVar;
        Interceptable interceptable = $ic;
        if (!(interceptable == null || interceptable.invokeV(1048583, this) == null) || (aVar = this.a) == null) {
            return;
        }
        aVar.m();
        this.a.a();
        this.f34582b = 1;
        loadData();
    }
}
