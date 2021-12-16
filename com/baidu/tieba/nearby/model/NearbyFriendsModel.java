package com.baidu.tieba.nearby.model;

import android.content.Intent;
import c.a.d.m.e.n;
import c.a.s0.l2.b.b;
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
public class NearbyFriendsModel extends BdBaseModel<NearbyFriendsModel> implements c.a.s0.l2.d.a {
    public static /* synthetic */ Interceptable $ic;
    public transient /* synthetic */ FieldHolder $fh;

    /* renamed from: e  reason: collision with root package name */
    public c.a.s0.l2.e.a f47618e;

    /* renamed from: f  reason: collision with root package name */
    public int f47619f;

    /* renamed from: g  reason: collision with root package name */
    public List<n> f47620g;

    /* renamed from: h  reason: collision with root package name */
    public boolean f47621h;

    /* renamed from: i  reason: collision with root package name */
    public boolean f47622i;

    /* renamed from: j  reason: collision with root package name */
    public final HttpMessageListener f47623j;

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
            if ((interceptable == null || interceptable.invokeL(1048576, this, httpResponsedMessage) == null) && httpResponsedMessage != null && httpResponsedMessage.getCmd() == 1003520 && (httpResponsedMessage instanceof NearbyFriendsHttpResponseMessage) && this.a.f47618e != null) {
                this.a.f47618e.hideLoadingView();
                if (httpResponsedMessage.getError() != 0) {
                    if (this.a.f47619f == 1) {
                        if (this.a.f47618e != null) {
                            this.a.f47618e.l(httpResponsedMessage.getErrorString());
                            return;
                        }
                        return;
                    } else if (this.a.f47618e != null) {
                        this.a.f47618e.e(httpResponsedMessage.getErrorString());
                        return;
                    } else {
                        return;
                    }
                }
                if (this.a.f47620g == null) {
                    this.a.f47620g = new ArrayList();
                }
                if (this.a.f47619f == 1) {
                    this.a.f47620g.clear();
                }
                b nearbyFriendData = ((NearbyFriendsHttpResponseMessage) httpResponsedMessage).getNearbyFriendData();
                if (!ListUtils.isEmpty(nearbyFriendData.a)) {
                    this.a.f47620g.addAll(nearbyFriendData.a);
                }
                this.a.f47621h = nearbyFriendData.f19135b;
                this.a.f47618e.hideLoadingView();
                this.a.f47618e.b(false);
                this.a.f47618e.h(0);
                this.a.f47618e.d(this.a.f47622i, this.a.f47620g);
                this.a.f47618e.i(this.a.f47621h);
                if (this.a.f47621h) {
                    NearbyFriendsModel.y(this.a);
                }
            }
        }
    }

    public NearbyFriendsModel(c.a.s0.l2.e.a aVar, BdUniqueId bdUniqueId) {
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
        this.f47619f = 1;
        a aVar2 = new a(this, CmdConfigHttp.CMD_GET_NEARBY_FRIENDS);
        this.f47623j = aVar2;
        this.f47618e = aVar;
        aVar2.setTag(bdUniqueId);
        registerListener(this.f47623j);
    }

    public static /* synthetic */ int y(NearbyFriendsModel nearbyFriendsModel) {
        int i2 = nearbyFriendsModel.f47619f;
        nearbyFriendsModel.f47619f = i2 + 1;
        return i2;
    }

    public void E(Intent intent) {
        Interceptable interceptable = $ic;
        if (!(interceptable == null || interceptable.invokeL(1048576, this, intent) == null) || intent == null) {
            return;
        }
        this.f47622i = intent.getBooleanExtra(NearbyFriendsActivityConfig.KEY_NEED_COMPLETE_PROFILE, false);
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

    @Override // c.a.s0.l2.d.a
    public boolean hasMore() {
        InterceptResult invokeV;
        Interceptable interceptable = $ic;
        return (interceptable == null || (invokeV = interceptable.invokeV(Constants.METHOD_SEND_USER_MSG, this)) == null) ? this.f47621h : invokeV.booleanValue;
    }

    @Override // com.baidu.adp.base.BdBaseModel
    public boolean loadData() {
        InterceptResult invokeV;
        Interceptable interceptable = $ic;
        if (interceptable == null || (invokeV = interceptable.invokeV(1048579, this)) == null) {
            HttpMessage httpMessage = new HttpMessage(CmdConfigHttp.CMD_GET_NEARBY_FRIENDS);
            httpMessage.addParam("pn", this.f47619f);
            httpMessage.addParam("rn", 20);
            httpMessage.addParam("app_pos", c.a.s0.j3.j0.a.e().b());
            MessageManager.getInstance().sendMessage(httpMessage);
            return false;
        }
        return invokeV.booleanValue;
    }

    @Override // c.a.s0.l2.d.a
    public void loadMore() {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeV(1048580, this) == null) {
            loadData();
        }
    }

    public void onDestroy() {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeV(1048581, this) == null) {
            this.f47618e = null;
        }
    }

    @Override // c.a.s0.l2.d.a
    public void refresh() {
        c.a.s0.l2.e.a aVar;
        Interceptable interceptable = $ic;
        if (!(interceptable == null || interceptable.invokeV(1048582, this) == null) || (aVar = this.f47618e) == null) {
            return;
        }
        aVar.k();
        this.f47618e.hideLoadingView();
        this.f47619f = 1;
        loadData();
    }

    @Override // c.a.s0.l2.d.a
    public void reload() {
        c.a.s0.l2.e.a aVar;
        Interceptable interceptable = $ic;
        if (!(interceptable == null || interceptable.invokeV(1048583, this) == null) || (aVar = this.f47618e) == null) {
            return;
        }
        aVar.k();
        this.f47618e.a();
        this.f47619f = 1;
        loadData();
    }
}
