package com.baidu.tieba;

import com.baidu.adp.BdUniqueId;
import com.baidu.adp.framework.MessageManager;
import com.baidu.adp.framework.message.ResponsedMessage;
import com.baidu.adp.lib.util.BdNetTypeUtil;
import com.baidu.adp.lib.util.StringUtils;
import com.baidu.android.imsdk.internal.Constants;
import com.baidu.tbadk.core.frameworkData.CmdConfigHttp;
import com.baidu.tieba.homepage.lowFlows.message.MoreTreasureTroveReqMsg;
import com.baidu.titan.sdk.runtime.FieldHolder;
import com.baidu.titan.sdk.runtime.InitContext;
import com.baidu.titan.sdk.runtime.InterceptResult;
import com.baidu.titan.sdk.runtime.Interceptable;
import com.baidu.titan.sdk.runtime.TitanRuntime;
import java.util.HashMap;
import java.util.List;
/* loaded from: classes6.dex */
public class lt7 implements ys7 {
    public static /* synthetic */ Interceptable $ic;
    public transient /* synthetic */ FieldHolder $fh;
    public String a;
    public BdUniqueId b;
    public fb c;
    public boolean d;
    public zs7 e;
    public final HashMap<String, List<rn>> f;

    public void h(String str) {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeL(Constants.METHOD_SEND_USER_MSG, this, str) == null) {
        }
    }

    public void j(String str) {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeL(1048580, this, str) == null) {
        }
    }

    /* loaded from: classes6.dex */
    public class a extends fb {
        public static /* synthetic */ Interceptable $ic;
        public transient /* synthetic */ FieldHolder $fh;
        public final /* synthetic */ lt7 a;

        /* JADX WARN: 'super' call moved to the top of the method (can break code semantics) */
        public a(lt7 lt7Var, int i, int i2) {
            super(i, i2);
            Interceptable interceptable = $ic;
            if (interceptable != null) {
                InitContext newInitContext = TitanRuntime.newInitContext();
                newInitContext.initArgs = r2;
                Object[] objArr = {lt7Var, Integer.valueOf(i), Integer.valueOf(i2)};
                interceptable.invokeUnInit(65536, newInitContext);
                int i3 = newInitContext.flag;
                if ((i3 & 1) != 0) {
                    int i4 = i3 & 2;
                    Object[] objArr2 = newInitContext.callArgs;
                    super(((Integer) objArr2[0]).intValue(), ((Integer) objArr2[1]).intValue());
                    newInitContext.thisArg = this;
                    interceptable.invokeInitBody(65536, newInitContext);
                    return;
                }
            }
            this.a = lt7Var;
        }

        @Override // com.baidu.tieba.fb
        public void onMessage(ResponsedMessage<?> responsedMessage) {
            Interceptable interceptable = $ic;
            if (interceptable == null || interceptable.invokeL(1048576, this, responsedMessage) == null) {
                this.a.d = false;
                if (this.a.e == null) {
                    return;
                }
                if (!(responsedMessage instanceof kt7)) {
                    this.a.e.c(-1);
                } else if (responsedMessage.getOrginalMessage() != null && this.a.b == responsedMessage.getOrginalMessage().getTag()) {
                    if (responsedMessage.hasError() && responsedMessage.getError() == 0) {
                        this.a.e.c(responsedMessage.getError());
                        return;
                    }
                    kt7 kt7Var = (kt7) responsedMessage;
                    if (kt7Var.getDataList() != null && kt7Var.getDataList().size() > 0) {
                        if (!StringUtils.isNull(this.a.a)) {
                            this.a.f.put(this.a.a, kt7Var.getDataList());
                        }
                        this.a.e.b(responsedMessage.getError(), kt7Var);
                        return;
                    }
                    this.a.e.c(-1);
                } else {
                    this.a.e.c(-1);
                }
            }
        }
    }

    public lt7(zs7 zs7Var) {
        Interceptable interceptable = $ic;
        if (interceptable != null) {
            InitContext newInitContext = TitanRuntime.newInitContext();
            newInitContext.initArgs = r2;
            Object[] objArr = {zs7Var};
            interceptable.invokeUnInit(65536, newInitContext);
            int i = newInitContext.flag;
            if ((i & 1) != 0) {
                int i2 = i & 2;
                newInitContext.thisArg = this;
                interceptable.invokeInitBody(65536, newInitContext);
                return;
            }
        }
        this.b = null;
        this.f = new HashMap<>();
        this.e = zs7Var;
        g();
    }

    public void i(String str) {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeL(1048579, this, str) == null) {
            this.a = str;
        }
    }

    public void k(BdUniqueId bdUniqueId) {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeL(1048581, this, bdUniqueId) == null) {
            this.b = bdUniqueId;
        }
    }

    @Override // com.baidu.tieba.ys7
    public boolean a(BdUniqueId bdUniqueId, String str, String str2, String str3) {
        InterceptResult invokeLLLL;
        Interceptable interceptable = $ic;
        if (interceptable == null || (invokeLLLL = interceptable.invokeLLLL(1048576, this, bdUniqueId, str, str2, str3)) == null) {
            if (BdNetTypeUtil.isNetworkAvailableForImmediately() && bdUniqueId != null && !StringUtils.isNull(str) && !StringUtils.isNull(str2)) {
                if (this.d) {
                    return false;
                }
                String str4 = this.a;
                if (str4 != null && str4.equals(str) && this.f.size() > 0) {
                    this.e.setData(this.f.get(str));
                    return true;
                }
                k(bdUniqueId);
                i(str);
                h(str2);
                j(str3);
                MoreTreasureTroveReqMsg moreTreasureTroveReqMsg = new MoreTreasureTroveReqMsg();
                moreTreasureTroveReqMsg.setTag(bdUniqueId);
                moreTreasureTroveReqMsg.setTabCode(str);
                moreTreasureTroveReqMsg.setLfUser(str2);
                moreTreasureTroveReqMsg.setTaskId(str3);
                boolean sendMessage = MessageManager.getInstance().sendMessage(moreTreasureTroveReqMsg);
                this.d = sendMessage;
                return sendMessage;
            }
            zs7 zs7Var = this.e;
            if (zs7Var != null) {
                zs7Var.c(-1);
            }
            return false;
        }
        return invokeLLLL.booleanValue;
    }

    public final void g() {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeV(Constants.METHOD_GET_CONTACTER_INFO_FOR_SESSION, this) == null) {
            this.c = new a(this, CmdConfigHttp.CMD_LOW_FLOWS_PAGE, 309691);
            MessageManager.getInstance().registerListener(this.c);
        }
    }
}
