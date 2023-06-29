package com.baidu.tieba.nearby.model;

import android.content.Intent;
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
import com.baidu.tieba.x39;
import com.baidu.tieba.xn;
import com.baidu.tieba.xt9;
import com.baidu.tieba.y39;
import com.baidu.tieba.z39;
import com.baidu.titan.sdk.runtime.FieldHolder;
import com.baidu.titan.sdk.runtime.InitContext;
import com.baidu.titan.sdk.runtime.InterceptResult;
import com.baidu.titan.sdk.runtime.Interceptable;
import com.baidu.titan.sdk.runtime.TitanRuntime;
import java.util.ArrayList;
import java.util.List;
/* loaded from: classes7.dex */
public class NearbyFriendsModel extends BdBaseModel<NearbyFriendsModel> implements y39 {
    public static /* synthetic */ Interceptable $ic;
    public transient /* synthetic */ FieldHolder $fh;
    public z39 a;
    public int b;
    public List<xn> c;
    public boolean d;
    public boolean e;
    public final HttpMessageListener f;

    @Override // com.baidu.adp.base.BdBaseModel
    public boolean cancelLoadData() {
        InterceptResult invokeV;
        Interceptable interceptable = $ic;
        if (interceptable == null || (invokeV = interceptable.invokeV(Constants.METHOD_SEND_USER_MSG, this)) == null) {
            return false;
        }
        return invokeV.booleanValue;
    }

    /* loaded from: classes7.dex */
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
            if ((interceptable != null && interceptable.invokeL(1048576, this, httpResponsedMessage) != null) || httpResponsedMessage == null || httpResponsedMessage.getCmd() != 1003520 || !(httpResponsedMessage instanceof NearbyFriendsHttpResponseMessage) || this.a.a == null) {
                return;
            }
            this.a.a.hideLoadingView();
            if (httpResponsedMessage.getError() != 0) {
                if (this.a.b == 1) {
                    if (this.a.a != null) {
                        this.a.a.p(httpResponsedMessage.getErrorString());
                        return;
                    }
                    return;
                } else if (this.a.a != null) {
                    this.a.a.h(httpResponsedMessage.getErrorString());
                    return;
                } else {
                    return;
                }
            }
            if (this.a.c == null) {
                this.a.c = new ArrayList();
            }
            if (this.a.b == 1) {
                this.a.c.clear();
            }
            x39 nearbyFriendData = ((NearbyFriendsHttpResponseMessage) httpResponsedMessage).getNearbyFriendData();
            if (!ListUtils.isEmpty(nearbyFriendData.a)) {
                this.a.c.addAll(nearbyFriendData.a);
            }
            this.a.d = nearbyFriendData.b;
            this.a.a.hideLoadingView();
            this.a.a.c(false);
            this.a.a.l(0);
            this.a.a.e(this.a.e, this.a.c);
            this.a.a.m(this.a.d);
            if (this.a.d) {
                NearbyFriendsModel.W(this.a);
            }
        }
    }

    public NearbyFriendsModel(z39 z39Var, BdUniqueId bdUniqueId) {
        Interceptable interceptable = $ic;
        if (interceptable != null) {
            InitContext newInitContext = TitanRuntime.newInitContext();
            newInitContext.initArgs = r2;
            Object[] objArr = {z39Var, bdUniqueId};
            interceptable.invokeUnInit(65536, newInitContext);
            int i = newInitContext.flag;
            if ((i & 1) != 0) {
                int i2 = i & 2;
                newInitContext.thisArg = this;
                interceptable.invokeInitBody(65536, newInitContext);
                return;
            }
        }
        this.b = 1;
        a aVar = new a(this, CmdConfigHttp.CMD_GET_NEARBY_FRIENDS);
        this.f = aVar;
        this.a = z39Var;
        aVar.setTag(bdUniqueId);
        registerListener(this.f);
    }

    public static /* synthetic */ int W(NearbyFriendsModel nearbyFriendsModel) {
        int i = nearbyFriendsModel.b;
        nearbyFriendsModel.b = i + 1;
        return i;
    }

    public void c0(Intent intent) {
        Interceptable interceptable = $ic;
        if ((interceptable == null || interceptable.invokeL(Constants.METHOD_GET_CONTACTER_INFO_FOR_SESSION, this, intent) == null) && intent != null) {
            this.e = intent.getBooleanExtra(NearbyFriendsActivityConfig.KEY_NEED_COMPLETE_PROFILE, false);
        }
    }

    @Override // com.baidu.tieba.y39
    public void b() {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeV(1048576, this) == null) {
            loadData();
        }
    }

    @Override // com.baidu.tieba.y39
    public boolean hasMore() {
        InterceptResult invokeV;
        Interceptable interceptable = $ic;
        if (interceptable == null || (invokeV = interceptable.invokeV(1048579, this)) == null) {
            return this.d;
        }
        return invokeV.booleanValue;
    }

    public void onDestroy() {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeV(1048581, this) == null) {
            this.a = null;
        }
    }

    @Override // com.baidu.tieba.y39
    public void refresh() {
        z39 z39Var;
        Interceptable interceptable = $ic;
        if ((interceptable != null && interceptable.invokeV(1048582, this) != null) || (z39Var = this.a) == null) {
            return;
        }
        z39Var.o();
        this.a.hideLoadingView();
        this.b = 1;
        loadData();
    }

    @Override // com.baidu.tieba.y39
    public void reload() {
        z39 z39Var;
        Interceptable interceptable = $ic;
        if ((interceptable != null && interceptable.invokeV(1048583, this) != null) || (z39Var = this.a) == null) {
            return;
        }
        z39Var.o();
        this.a.a();
        this.b = 1;
        loadData();
    }

    @Override // com.baidu.adp.base.BdBaseModel
    public boolean loadData() {
        InterceptResult invokeV;
        Interceptable interceptable = $ic;
        if (interceptable == null || (invokeV = interceptable.invokeV(1048580, this)) == null) {
            HttpMessage httpMessage = new HttpMessage(CmdConfigHttp.CMD_GET_NEARBY_FRIENDS);
            httpMessage.addParam("pn", this.b);
            httpMessage.addParam("rn", 20);
            httpMessage.addParam("app_pos", xt9.e().b());
            MessageManager.getInstance().sendMessage(httpMessage);
            return false;
        }
        return invokeV.booleanValue;
    }
}
