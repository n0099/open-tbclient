package com.baidu.tieba;

import com.baidu.adp.framework.MessageManager;
import com.baidu.adp.framework.listener.HttpMessageListener;
import com.baidu.adp.framework.message.CustomResponsedMessage;
import com.baidu.adp.framework.message.HttpMessage;
import com.baidu.adp.framework.message.HttpResponsedMessage;
import com.baidu.android.imsdk.internal.Constants;
import com.baidu.tbadk.core.frameworkData.CmdConfigHttp;
import com.baidu.tbadk.coreExtra.data.ChannelIconConfigFinalData;
import com.baidu.tbadk.coreExtra.message.ChannelConfigResponseMessage;
import com.baidu.titan.sdk.runtime.FieldHolder;
import com.baidu.titan.sdk.runtime.InitContext;
import com.baidu.titan.sdk.runtime.InterceptResult;
import com.baidu.titan.sdk.runtime.Interceptable;
import com.baidu.titan.sdk.runtime.TitanRuntime;
/* loaded from: classes7.dex */
public class re5 {
    public static /* synthetic */ Interceptable $ic;
    public transient /* synthetic */ FieldHolder $fh;
    public uc5 a;
    public b b;
    public int c;
    public int d;
    public ChannelIconConfigFinalData e;
    public HttpMessageListener f;

    /* loaded from: classes7.dex */
    public interface b {
        void a(boolean z, uc5 uc5Var);
    }

    /* loaded from: classes7.dex */
    public class a extends HttpMessageListener {
        public static /* synthetic */ Interceptable $ic;
        public transient /* synthetic */ FieldHolder $fh;
        public final /* synthetic */ re5 a;

        /* JADX WARN: 'super' call moved to the top of the method (can break code semantics) */
        public a(re5 re5Var, int i) {
            super(i);
            Interceptable interceptable = $ic;
            if (interceptable != null) {
                InitContext newInitContext = TitanRuntime.newInitContext();
                newInitContext.initArgs = r2;
                Object[] objArr = {re5Var, Integer.valueOf(i)};
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
            this.a = re5Var;
        }

        /* JADX DEBUG: Method merged with bridge method */
        @Override // com.baidu.adp.framework.listener.MessageListener
        public void onMessage(HttpResponsedMessage httpResponsedMessage) {
            Interceptable interceptable = $ic;
            if ((interceptable == null || interceptable.invokeL(1048576, this, httpResponsedMessage) == null) && (httpResponsedMessage instanceof ChannelConfigResponseMessage)) {
                ChannelConfigResponseMessage channelConfigResponseMessage = (ChannelConfigResponseMessage) httpResponsedMessage;
                this.a.a = channelConfigResponseMessage.getData();
                if (this.a.b != null) {
                    this.a.b.a(channelConfigResponseMessage.isSuccess(), channelConfigResponseMessage.getData());
                }
                if (channelConfigResponseMessage.isSuccess()) {
                    MessageManager.getInstance().dispatchResponsedMessage(new CustomResponsedMessage(2921493, null));
                }
            }
        }
    }

    public re5() {
        Interceptable interceptable = $ic;
        if (interceptable != null) {
            InitContext newInitContext = TitanRuntime.newInitContext();
            interceptable.invokeUnInit(65536, newInitContext);
            int i = newInitContext.flag;
            if ((i & 1) != 0) {
                int i2 = i & 2;
                newInitContext.thisArg = this;
                interceptable.invokeInitBody(65536, newInitContext);
                return;
            }
        }
        this.f = new a(this, CmdConfigHttp.CMD_GET_CHANNEL_CONFIG);
        MessageManager.getInstance().registerListener(this.f);
        this.c = n95.m().n("key_common_category_version", 0);
        this.d = n95.m().n("key_special_category_version", 0);
    }

    public ChannelIconConfigFinalData c() {
        InterceptResult invokeV;
        Interceptable interceptable = $ic;
        if (interceptable == null || (invokeV = interceptable.invokeV(1048576, this)) == null) {
            ChannelIconConfigFinalData channelIconConfigFinalData = this.e;
            if (channelIconConfigFinalData != null) {
                return channelIconConfigFinalData;
            }
            if (this.a == null) {
                return null;
            }
            ChannelIconConfigFinalData channelIconConfigFinalData2 = new ChannelIconConfigFinalData();
            uc5 uc5Var = this.a;
            if (uc5Var != null && uc5Var.b() != null && this.d < this.a.b().e()) {
                channelIconConfigFinalData2.setIcon(this.a.b().a());
                channelIconConfigFinalData2.setPopText(this.a.b().b());
                channelIconConfigFinalData2.setTabCode(this.a.b().c());
                channelIconConfigFinalData2.setTid(this.a.b().d());
                channelIconConfigFinalData2.setChannelConfigDataType(ChannelIconConfigFinalData.FRAG_TIP_SPECIAL);
            } else {
                uc5 uc5Var2 = this.a;
                if (uc5Var2 != null && uc5Var2.a() > 0 && this.c < this.a.a()) {
                    channelIconConfigFinalData2.setChannelConfigDataType(ChannelIconConfigFinalData.FRAG_TIP_COMMON);
                } else {
                    channelIconConfigFinalData2.setChannelConfigDataType(ChannelIconConfigFinalData.FRAG_TIP_NONE);
                }
            }
            this.e = channelIconConfigFinalData2;
            return channelIconConfigFinalData2;
        }
        return (ChannelIconConfigFinalData) invokeV.objValue;
    }

    public void d() {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeV(Constants.METHOD_GET_CONTACTER_INFO_FOR_SESSION, this) == null) {
            MessageManager.getInstance().sendMessage(new HttpMessage(CmdConfigHttp.CMD_GET_CHANNEL_CONFIG));
        }
    }
}
