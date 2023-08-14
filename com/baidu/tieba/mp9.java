package com.baidu.tieba;

import com.baidu.adp.BdUniqueId;
import com.baidu.adp.framework.MessageManager;
import com.baidu.adp.framework.listener.CustomMessageListener;
import com.baidu.adp.framework.listener.HttpMessageListener;
import com.baidu.adp.framework.message.CustomResponsedMessage;
import com.baidu.adp.framework.message.HttpMessage;
import com.baidu.adp.framework.message.HttpResponsedMessage;
import com.baidu.adp.lib.util.BdNetTypeUtil;
import com.baidu.adp.lib.util.StringUtils;
import com.baidu.searchbox.wordscommand.util.CommandUBCHelper;
import com.baidu.tbadk.TbPageContext;
import com.baidu.tbadk.core.frameworkData.CmdConfigHttp;
import com.baidu.tbadk.core.util.StatisticItem;
import com.baidu.tbadk.core.util.TiebaStatic;
import com.baidu.titan.sdk.runtime.FieldHolder;
import com.baidu.titan.sdk.runtime.InitContext;
import com.baidu.titan.sdk.runtime.Interceptable;
import com.baidu.titan.sdk.runtime.TitanRuntime;
/* loaded from: classes7.dex */
public class mp9 implements uq9 {
    public static /* synthetic */ Interceptable $ic;
    public transient /* synthetic */ FieldHolder $fh;
    public uu9 a;
    public TbPageContext b;
    public BdUniqueId c;
    public HttpMessageListener d;
    public int e;

    /* loaded from: classes7.dex */
    public class a extends HttpMessageListener {
        public static /* synthetic */ Interceptable $ic;
        public transient /* synthetic */ FieldHolder $fh;
        public final /* synthetic */ mp9 a;

        /* JADX WARN: 'super' call moved to the top of the method (can break code semantics) */
        public a(mp9 mp9Var, int i) {
            super(i);
            Interceptable interceptable = $ic;
            if (interceptable != null) {
                InitContext newInitContext = TitanRuntime.newInitContext();
                newInitContext.initArgs = r2;
                Object[] objArr = {mp9Var, Integer.valueOf(i)};
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
            this.a = mp9Var;
        }

        /* JADX DEBUG: Method merged with bridge method */
        @Override // com.baidu.adp.framework.listener.MessageListener
        public void onMessage(HttpResponsedMessage httpResponsedMessage) {
            Interceptable interceptable = $ic;
            if ((interceptable == null || interceptable.invokeL(1048576, this, httpResponsedMessage) == null) && httpResponsedMessage != null && httpResponsedMessage.getOrginalMessage().getTag() == this.a.c) {
                if (httpResponsedMessage.isSuccess() && httpResponsedMessage.getError() == 0) {
                    if (this.a.b != null) {
                        this.a.b.showToast(R.string.obfuscated_res_0x7f0f1147);
                    }
                    this.a.e = 1;
                    this.a.a.e();
                } else if (this.a.b != null && !StringUtils.isNull(httpResponsedMessage.getErrorString())) {
                    this.a.b.showToast(httpResponsedMessage.getErrorString());
                }
            }
        }
    }

    /* loaded from: classes7.dex */
    public class b extends CustomMessageListener {
        public static /* synthetic */ Interceptable $ic;
        public transient /* synthetic */ FieldHolder $fh;
        public final /* synthetic */ mp9 a;

        /* JADX WARN: 'super' call moved to the top of the method (can break code semantics) */
        public b(mp9 mp9Var, int i) {
            super(i);
            Interceptable interceptable = $ic;
            if (interceptable != null) {
                InitContext newInitContext = TitanRuntime.newInitContext();
                newInitContext.initArgs = r2;
                Object[] objArr = {mp9Var, Integer.valueOf(i)};
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
            this.a = mp9Var;
        }

        /* JADX DEBUG: Method merged with bridge method */
        @Override // com.baidu.adp.framework.listener.MessageListener
        public void onMessage(CustomResponsedMessage<?> customResponsedMessage) {
            int intValue;
            Interceptable interceptable = $ic;
            if ((interceptable != null && interceptable.invokeL(1048576, this, customResponsedMessage) != null) || customResponsedMessage == null || customResponsedMessage.getCmd() != 2921065 || customResponsedMessage.getData() == null || this.a.e == (intValue = ((Integer) customResponsedMessage.getData()).intValue())) {
                return;
            }
            this.a.e = intValue;
            if (intValue == 1) {
                this.a.a.e();
            }
        }
    }

    public mp9(TbPageContext tbPageContext, uu9 uu9Var, BdUniqueId bdUniqueId) {
        Interceptable interceptable = $ic;
        if (interceptable != null) {
            InitContext newInitContext = TitanRuntime.newInitContext();
            newInitContext.initArgs = r2;
            Object[] objArr = {tbPageContext, uu9Var, bdUniqueId};
            interceptable.invokeUnInit(65536, newInitContext);
            int i = newInitContext.flag;
            if ((i & 1) != 0) {
                int i2 = i & 2;
                newInitContext.thisArg = this;
                interceptable.invokeInitBody(65536, newInitContext);
                return;
            }
        }
        this.e = 0;
        this.b = tbPageContext;
        this.a = uu9Var;
        this.c = bdUniqueId;
        this.d = new a(this, CmdConfigHttp.SET_PRIVATE_CMD);
        b bVar = new b(this, 2921065);
        this.d.setTag(this.c);
        bVar.setTag(this.c);
        MessageManager.getInstance().registerListener(this.d);
        MessageManager.getInstance().registerListener(bVar);
    }

    @Override // com.baidu.tieba.uq9
    public void a() {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeV(1048576, this) == null) {
            if (!BdNetTypeUtil.isNetWorkAvailable()) {
                TbPageContext tbPageContext = this.b;
                if (tbPageContext != null) {
                    tbPageContext.showToast(R.string.obfuscated_res_0x7f0f0e21);
                    return;
                }
                return;
            }
            HttpMessage httpMessage = new HttpMessage(CmdConfigHttp.SET_PRIVATE_CMD);
            httpMessage.addParam("opt", CommandUBCHelper.COMMAND_UBC_SOURCE_SEND);
            httpMessage.addParam("val", String.valueOf(1));
            httpMessage.setTag(this.c);
            MessageManager.getInstance().sendMessage(httpMessage);
            TiebaStatic.log(new StatisticItem("c12515").param("obj_locate", 1));
        }
    }
}
