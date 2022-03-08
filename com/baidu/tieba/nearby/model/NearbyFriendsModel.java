package com.baidu.tieba.nearby.model;

import android.content.Intent;
import c.a.d.o.e.n;
import c.a.r0.n2.b.b;
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
/* loaded from: classes6.dex */
public class NearbyFriendsModel extends BdBaseModel<NearbyFriendsModel> implements c.a.r0.n2.c.a {
    public static /* synthetic */ Interceptable $ic;
    public transient /* synthetic */ FieldHolder $fh;

    /* renamed from: e  reason: collision with root package name */
    public c.a.r0.n2.d.a f44636e;

    /* renamed from: f  reason: collision with root package name */
    public int f44637f;

    /* renamed from: g  reason: collision with root package name */
    public List<n> f44638g;

    /* renamed from: h  reason: collision with root package name */
    public boolean f44639h;

    /* renamed from: i  reason: collision with root package name */
    public boolean f44640i;

    /* renamed from: j  reason: collision with root package name */
    public final HttpMessageListener f44641j;

    /* loaded from: classes6.dex */
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
            if ((interceptable == null || interceptable.invokeL(1048576, this, httpResponsedMessage) == null) && httpResponsedMessage != null && httpResponsedMessage.getCmd() == 1003520 && (httpResponsedMessage instanceof NearbyFriendsHttpResponseMessage) && this.a.f44636e != null) {
                this.a.f44636e.hideLoadingView();
                if (httpResponsedMessage.getError() != 0) {
                    if (this.a.f44637f == 1) {
                        if (this.a.f44636e != null) {
                            this.a.f44636e.l(httpResponsedMessage.getErrorString());
                            return;
                        }
                        return;
                    } else if (this.a.f44636e != null) {
                        this.a.f44636e.e(httpResponsedMessage.getErrorString());
                        return;
                    } else {
                        return;
                    }
                }
                if (this.a.f44638g == null) {
                    this.a.f44638g = new ArrayList();
                }
                if (this.a.f44637f == 1) {
                    this.a.f44638g.clear();
                }
                b nearbyFriendData = ((NearbyFriendsHttpResponseMessage) httpResponsedMessage).getNearbyFriendData();
                if (!ListUtils.isEmpty(nearbyFriendData.a)) {
                    this.a.f44638g.addAll(nearbyFriendData.a);
                }
                this.a.f44639h = nearbyFriendData.f19372b;
                this.a.f44636e.hideLoadingView();
                this.a.f44636e.b(false);
                this.a.f44636e.h(0);
                this.a.f44636e.d(this.a.f44640i, this.a.f44638g);
                this.a.f44636e.i(this.a.f44639h);
                if (this.a.f44639h) {
                    NearbyFriendsModel.y(this.a);
                }
            }
        }
    }

    public NearbyFriendsModel(c.a.r0.n2.d.a aVar, BdUniqueId bdUniqueId) {
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
        this.f44637f = 1;
        a aVar2 = new a(this, CmdConfigHttp.CMD_GET_NEARBY_FRIENDS);
        this.f44641j = aVar2;
        this.f44636e = aVar;
        aVar2.setTag(bdUniqueId);
        registerListener(this.f44641j);
    }

    public static /* synthetic */ int y(NearbyFriendsModel nearbyFriendsModel) {
        int i2 = nearbyFriendsModel.f44637f;
        nearbyFriendsModel.f44637f = i2 + 1;
        return i2;
    }

    public void E(Intent intent) {
        Interceptable interceptable = $ic;
        if (!(interceptable == null || interceptable.invokeL(1048576, this, intent) == null) || intent == null) {
            return;
        }
        this.f44640i = intent.getBooleanExtra(NearbyFriendsActivityConfig.KEY_NEED_COMPLETE_PROFILE, false);
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

    @Override // c.a.r0.n2.c.a
    public boolean hasMore() {
        InterceptResult invokeV;
        Interceptable interceptable = $ic;
        return (interceptable == null || (invokeV = interceptable.invokeV(Constants.METHOD_SEND_USER_MSG, this)) == null) ? this.f44639h : invokeV.booleanValue;
    }

    @Override // com.baidu.adp.base.BdBaseModel
    public boolean loadData() {
        InterceptResult invokeV;
        Interceptable interceptable = $ic;
        if (interceptable == null || (invokeV = interceptable.invokeV(1048579, this)) == null) {
            HttpMessage httpMessage = new HttpMessage(CmdConfigHttp.CMD_GET_NEARBY_FRIENDS);
            httpMessage.addParam("pn", this.f44637f);
            httpMessage.addParam("rn", 20);
            httpMessage.addParam("app_pos", c.a.r0.j3.k0.a.e().b());
            MessageManager.getInstance().sendMessage(httpMessage);
            return false;
        }
        return invokeV.booleanValue;
    }

    @Override // c.a.r0.n2.c.a
    public void loadMore() {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeV(1048580, this) == null) {
            loadData();
        }
    }

    public void onDestroy() {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeV(1048581, this) == null) {
            this.f44636e = null;
        }
    }

    @Override // c.a.r0.n2.c.a
    public void refresh() {
        c.a.r0.n2.d.a aVar;
        Interceptable interceptable = $ic;
        if (!(interceptable == null || interceptable.invokeV(1048582, this) == null) || (aVar = this.f44636e) == null) {
            return;
        }
        aVar.k();
        this.f44636e.hideLoadingView();
        this.f44637f = 1;
        loadData();
    }

    @Override // c.a.r0.n2.c.a
    public void reload() {
        c.a.r0.n2.d.a aVar;
        Interceptable interceptable = $ic;
        if (!(interceptable == null || interceptable.invokeV(1048583, this) == null) || (aVar = this.f44636e) == null) {
            return;
        }
        aVar.k();
        this.f44636e.a();
        this.f44637f = 1;
        loadData();
    }
}
