package com.baidu.tieba;

import com.baidu.adp.BdUniqueId;
import com.baidu.adp.framework.MessageManager;
import com.baidu.adp.framework.listener.HttpMessageListener;
import com.baidu.adp.framework.message.HttpMessage;
import com.baidu.adp.framework.message.HttpResponsedMessage;
import com.baidu.android.imsdk.internal.Constants;
import com.baidu.tbadk.TbConfig;
import com.baidu.tbadk.core.frameworkData.CmdConfigHttp;
import com.baidu.tbadk.coreExtra.share.ShareItem;
import com.baidu.tbadk.task.TbHttpMessageTask;
import com.baidu.tieba.model.ForbidShareRespondedMessage;
import com.baidu.titan.sdk.runtime.ClassClinitInterceptable;
import com.baidu.titan.sdk.runtime.ClassClinitInterceptorStorage;
import com.baidu.titan.sdk.runtime.FieldHolder;
import com.baidu.titan.sdk.runtime.InitContext;
import com.baidu.titan.sdk.runtime.InterceptResult;
import com.baidu.titan.sdk.runtime.Interceptable;
import com.baidu.titan.sdk.runtime.TitanRuntime;
import java.util.HashMap;
import java.util.Map;
import kotlin.jvm.internal.Intrinsics;
/* loaded from: classes9.dex */
public class zk9 {
    public static /* synthetic */ Interceptable $ic;
    public transient /* synthetic */ FieldHolder $fh;
    public BdUniqueId a;
    public boolean b;
    public a c;
    public final b d;

    /* loaded from: classes9.dex */
    public interface a {
        void a(yk9 yk9Var);

        void onFail();
    }

    static {
        InterceptResult invokeClinit;
        ClassClinitInterceptable classClinitInterceptable = ClassClinitInterceptorStorage.$ic;
        if (classClinitInterceptable == null || (invokeClinit = classClinitInterceptable.invokeClinit(1948362977, "Lcom/baidu/tieba/zk9;")) == null) {
            return;
        }
        Interceptable interceptable = invokeClinit.interceptor;
        if (interceptable != null) {
            $ic = interceptable;
        }
        if ((invokeClinit.flags & 1) != 0) {
            classClinitInterceptable.invokePostClinit(1948362977, "Lcom/baidu/tieba/zk9;");
        }
    }

    /* loaded from: classes9.dex */
    public static final class b extends HttpMessageListener {
        public static /* synthetic */ Interceptable $ic;
        public transient /* synthetic */ FieldHolder $fh;
        public final /* synthetic */ zk9 a;

        /* JADX WARN: 'super' call moved to the top of the method (can break code semantics) */
        public b(zk9 zk9Var) {
            super(CmdConfigHttp.CMD_HTTP_FORBID_SHARE_UTL_TO_TOKEN);
            Interceptable interceptable = $ic;
            if (interceptable != null) {
                InitContext newInitContext = TitanRuntime.newInitContext();
                newInitContext.initArgs = r2;
                Object[] objArr = {zk9Var};
                interceptable.invokeUnInit(65536, newInitContext);
                int i = newInitContext.flag;
                if ((i & 1) != 0) {
                    int i2 = i & 2;
                    super(((Integer) newInitContext.callArgs[0]).intValue());
                    newInitContext.thisArg = this;
                    interceptable.invokeInitBody(65536, newInitContext);
                    return;
                }
            }
            this.a = zk9Var;
        }

        /* JADX DEBUG: Method merged with bridge method */
        @Override // com.baidu.adp.framework.listener.MessageListener
        public void onMessage(HttpResponsedMessage httpResponsedMessage) {
            a b;
            Interceptable interceptable = $ic;
            if (interceptable == null || interceptable.invokeL(1048576, this, httpResponsedMessage) == null) {
                this.a.h(false);
                if (httpResponsedMessage instanceof ForbidShareRespondedMessage) {
                    ForbidShareRespondedMessage forbidShareRespondedMessage = (ForbidShareRespondedMessage) httpResponsedMessage;
                    if (forbidShareRespondedMessage.getError() == 0) {
                        yk9 data = forbidShareRespondedMessage.getData();
                        if (data != null && (b = this.a.b()) != null) {
                            b.a(data);
                            return;
                        }
                        return;
                    }
                }
                a b2 = this.a.b();
                if (b2 != null) {
                    b2.onFail();
                }
            }
        }
    }

    public zk9(BdUniqueId bdUniqueId) {
        Interceptable interceptable = $ic;
        if (interceptable != null) {
            InitContext newInitContext = TitanRuntime.newInitContext();
            newInitContext.initArgs = r2;
            Object[] objArr = {bdUniqueId};
            interceptable.invokeUnInit(65537, newInitContext);
            int i = newInitContext.flag;
            if ((i & 1) != 0) {
                int i2 = i & 2;
                newInitContext.thisArg = this;
                interceptable.invokeInitBody(65537, newInitContext);
                return;
            }
        }
        this.a = bdUniqueId;
        this.d = new b(this);
        e();
    }

    public final boolean f(String str) {
        InterceptResult invokeL;
        String urlEncode;
        Interceptable interceptable = $ic;
        if (interceptable == null || (invokeL = interceptable.invokeL(1048581, this, str)) == null) {
            if (this.b || (urlEncode = qd.getUrlEncode(str)) == null) {
                return false;
            }
            this.b = true;
            HttpMessage httpMessage = new HttpMessage(CmdConfigHttp.CMD_HTTP_FORBID_SHARE_UTL_TO_TOKEN);
            httpMessage.addParam("scheme", urlEncode);
            httpMessage.addParam("scheme_encode", 1);
            httpMessage.setTag(this.a);
            MessageManager.getInstance().sendMessage(httpMessage);
            return true;
        }
        return invokeL.booleanValue;
    }

    public final void a(ShareItem shareItem) {
        boolean z;
        boolean z2;
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeL(1048576, this, shareItem) == null) {
            Intrinsics.checkNotNullParameter(shareItem, "shareItem");
            String str = shareItem.linkUrl;
            boolean z3 = false;
            if (str != null && str.length() != 0) {
                z = false;
            } else {
                z = true;
            }
            if (!z) {
                String forbidShareTplText = shareItem.getForbidShareTplText();
                Intrinsics.checkNotNullExpressionValue(forbidShareTplText, "shareItem.forbidShareTplText");
                if (forbidShareTplText.length() == 0) {
                    z2 = true;
                } else {
                    z2 = false;
                }
                if (!z2) {
                    String forbidShareToast = shareItem.getForbidShareToast();
                    Intrinsics.checkNotNullExpressionValue(forbidShareToast, "shareItem.forbidShareToast");
                    if (forbidShareToast.length() == 0) {
                        z3 = true;
                    }
                    if (!z3 && !shareItem.getOutsideShareDisableMap().isEmpty()) {
                        HashMap<String, Boolean> outsideShareDisableMap = shareItem.getOutsideShareDisableMap();
                        Intrinsics.checkNotNullExpressionValue(outsideShareDisableMap, "shareItem.outsideShareDisableMap");
                        for (Map.Entry<String, Boolean> entry : outsideShareDisableMap.entrySet()) {
                            Boolean value = entry.getValue();
                            Intrinsics.checkNotNullExpressionValue(value, "it.value");
                            if (value.booleanValue()) {
                                String str2 = shareItem.linkUrl;
                                Intrinsics.checkNotNullExpressionValue(str2, "shareItem.linkUrl");
                                f(str2);
                                return;
                            }
                        }
                    }
                }
            }
        }
    }

    public final a b() {
        InterceptResult invokeV;
        Interceptable interceptable = $ic;
        if (interceptable == null || (invokeV = interceptable.invokeV(Constants.METHOD_GET_CONTACTER_INFO_FOR_SESSION, this)) == null) {
            return this.c;
        }
        return (a) invokeV.objValue;
    }

    public final void c() {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeV(Constants.METHOD_SEND_USER_MSG, this) == null) {
            MessageManager.getInstance().unRegisterTask(CmdConfigHttp.CMD_HTTP_FORBID_SHARE_UTL_TO_TOKEN);
            MessageManager.getInstance().unRegisterListener(this.d);
        }
    }

    public final void e() {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeV(1048580, this) == null) {
            d();
            this.d.setSelfListener(true);
            this.d.setTag(this.a);
            MessageManager.getInstance().registerListener(this.d);
        }
    }

    public final void d() {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeV(1048579, this) == null) {
            TbHttpMessageTask tbHttpMessageTask = new TbHttpMessageTask(CmdConfigHttp.CMD_HTTP_FORBID_SHARE_UTL_TO_TOKEN, TbConfig.SERVER_ADDRESS + "c/s/schemeToken");
            tbHttpMessageTask.setResponsedClass(ForbidShareRespondedMessage.class);
            MessageManager.getInstance().registerTask(tbHttpMessageTask);
        }
    }

    public final void g(a aVar) {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeL(1048582, this, aVar) == null) {
            this.c = aVar;
        }
    }

    public final void h(boolean z) {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeZ(1048583, this, z) == null) {
            this.b = z;
        }
    }
}
