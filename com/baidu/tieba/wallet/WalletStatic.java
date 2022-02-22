package com.baidu.tieba.wallet;

import android.app.Activity;
import android.content.Context;
import android.text.TextUtils;
import androidx.core.view.InputDeviceCompat;
import c.a.d.a.b;
import c.a.d.f.p.m;
import c.a.d.f.p.n;
import c.a.t0.e.a;
import c.a.t0.r0.e;
import c.a.t0.r0.f;
import c.a.t0.r0.g;
import com.baidu.adp.BdUniqueId;
import com.baidu.adp.framework.MessageManager;
import com.baidu.adp.framework.listener.CustomMessageListener;
import com.baidu.adp.framework.message.CustomMessage;
import com.baidu.adp.framework.message.CustomResponsedMessage;
import com.baidu.adp.framework.task.CustomMessageTask;
import com.baidu.adp.lib.stats.BdStatisticsManager;
import com.baidu.adp.lib.util.StringUtils;
import com.baidu.sapi2.PassportSDK;
import com.baidu.sapi2.SapiAccountManager;
import com.baidu.sapi2.callback.AccountRealNameCallback;
import com.baidu.sapi2.dto.FaceBaseDTO;
import com.baidu.sapi2.dto.RealNameDTO;
import com.baidu.sapi2.result.AccountRealNameResult;
import com.baidu.tbadk.TbConfig;
import com.baidu.tbadk.TbPageContext;
import com.baidu.tbadk.TbadkApplication;
import com.baidu.tbadk.core.TbadkCoreApplication;
import com.baidu.tbadk.core.data.ExceptionData;
import com.baidu.tbadk.core.frameworkData.CmdConfigHttp;
import com.baidu.tbadk.core.frameworkData.IntentConfig;
import com.baidu.tbadk.core.util.UrlManager;
import com.baidu.tbadk.core.util.UrlSchemaHelper;
import com.baidu.tbadk.task.TbHttpMessageTask;
import com.baidu.tieba.wallet.ICertification;
import com.baidu.tieba.wallet.pay.ResponsedGetOrderHttpMessage;
import com.baidu.tieba.wallet.pay.ResponsedGetOrderSocketMessage;
import com.baidu.titan.sdk.runtime.ClassClinitInterceptable;
import com.baidu.titan.sdk.runtime.ClassClinitInterceptorStorage;
import com.baidu.titan.sdk.runtime.FieldHolder;
import com.baidu.titan.sdk.runtime.InitContext;
import com.baidu.titan.sdk.runtime.InterceptResult;
import com.baidu.titan.sdk.runtime.Interceptable;
import com.baidu.titan.sdk.runtime.TitanRuntime;
import com.tencent.mm.opensdk.modelpay.PayReq;
import com.tencent.mm.opensdk.openapi.IWXAPI;
import com.tencent.mm.opensdk.openapi.WXAPIFactory;
import java.util.HashMap;
import java.util.Map;
import tbclient.UserBfbInfo;
/* loaded from: classes13.dex */
public class WalletStatic {
    public static /* synthetic */ Interceptable $ic;
    public transient /* synthetic */ FieldHolder $fh;

    static {
        InterceptResult invokeClinit;
        ClassClinitInterceptable classClinitInterceptable = ClassClinitInterceptorStorage.$ic;
        if (classClinitInterceptable != null && (invokeClinit = classClinitInterceptable.invokeClinit(-732993428, "Lcom/baidu/tieba/wallet/WalletStatic;")) != null) {
            Interceptable interceptable = invokeClinit.interceptor;
            if (interceptable != null) {
                $ic = interceptable;
            }
            if ((invokeClinit.flags & 1) != 0) {
                classClinitInterceptable.invokePostClinit(-732993428, "Lcom/baidu/tieba/wallet/WalletStatic;");
                return;
            }
        }
        registerHttpAndSocketTask();
        registerMyWalletTask();
        registerPersonWalletMessage();
        registerOpenWalletICashPageTask();
        registerOpenWallteHomePageTask();
        registerFinancialFrsSDKTabSchemaListener();
        registerOpenWalletICashPageJump();
        registerBaiduNovelPayTask();
        registerAiAppPayTask();
        registerAliPayTask();
        registerTiebaPay();
        registerTiebaCertification();
        registerYYPayTask();
        registerOpenWallteBalanceTask();
        registerBindCardListener();
        registerIntentListener();
    }

    public WalletStatic() {
        Interceptable interceptable = $ic;
        if (interceptable != null) {
            InitContext newInitContext = TitanRuntime.newInitContext();
            interceptable.invokeUnInit(65537, newInitContext);
            int i2 = newInitContext.flag;
            if ((i2 & 1) != 0) {
                int i3 = i2 & 2;
                newInitContext.thisArg = this;
                interceptable.invokeInitBody(65537, newInitContext);
            }
        }
    }

    public static void registerAiAppPayTask() {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeV(65538, null) == null) {
            CustomMessageTask customMessageTask = new CustomMessageTask(2921393, new CustomMessageTask.CustomRunnable<f>() { // from class: com.baidu.tieba.wallet.WalletStatic.8
                public static /* synthetic */ Interceptable $ic;
                public transient /* synthetic */ FieldHolder $fh;

                {
                    Interceptable interceptable2 = $ic;
                    if (interceptable2 != null) {
                        InitContext newInitContext = TitanRuntime.newInitContext();
                        interceptable2.invokeUnInit(65536, newInitContext);
                        int i2 = newInitContext.flag;
                        if ((i2 & 1) != 0) {
                            int i3 = i2 & 2;
                            newInitContext.thisArg = this;
                            interceptable2.invokeInitBody(65536, newInitContext);
                        }
                    }
                }

                @Override // com.baidu.adp.framework.task.CustomMessageTask.CustomRunnable
                public CustomResponsedMessage<?> run(CustomMessage<f> customMessage) {
                    InterceptResult invokeL;
                    f data;
                    Activity activity;
                    Interceptable interceptable2 = $ic;
                    if (interceptable2 == null || (invokeL = interceptable2.invokeL(1048576, this, customMessage)) == null) {
                        if (customMessage == null || (data = customMessage.getData()) == null || (activity = data.f13379d) == null) {
                            return null;
                        }
                        BdUniqueId bdUniqueId = data.a;
                        String str = data.f13378c;
                        int i2 = data.f13377b;
                        if (i2 == 1) {
                            WalletPluginManager.getInstance().doBaiduPay(data.f13379d, str, bdUniqueId);
                        } else if (i2 == 2) {
                            WalletPluginManager.getInstance().doAliPay(data.f13379d, str, bdUniqueId);
                        } else if (i2 == 3) {
                            WalletPluginManager.getInstance().doBaiduLBSPay(data.f13379d, data.f13380e, data.f13378c, bdUniqueId);
                        } else if (i2 == 4 && data.f13381f != null) {
                            IWXAPI createWXAPI = WXAPIFactory.createWXAPI(activity, TbConfig.WEIXIN_SHARE_APP_ID);
                            PayReq payReq = new PayReq();
                            payReq.appId = data.f13381f.get("appid");
                            payReq.partnerId = data.f13381f.get("partnerid");
                            payReq.prepayId = data.f13381f.get("prepayid");
                            payReq.packageValue = data.f13381f.get("packagealias");
                            payReq.nonceStr = data.f13381f.get("noncestr");
                            payReq.timeStamp = data.f13381f.get("timestamp");
                            payReq.sign = data.f13381f.get("sign");
                            createWXAPI.registerApp(payReq.appId);
                            createWXAPI.sendReq(payReq);
                        }
                        return null;
                    }
                    return (CustomResponsedMessage) invokeL.objValue;
                }
            });
            customMessageTask.setType(CustomMessageTask.TASK_TYPE.SYNCHRONIZED);
            MessageManager.getInstance().registerTask(customMessageTask);
        }
    }

    public static void registerAliPayTask() {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeV(65539, null) == null) {
            CustomMessageTask customMessageTask = new CustomMessageTask(2921539, new CustomMessageTask.CustomRunnable<a>() { // from class: com.baidu.tieba.wallet.WalletStatic.9
                public static /* synthetic */ Interceptable $ic;
                public transient /* synthetic */ FieldHolder $fh;

                {
                    Interceptable interceptable2 = $ic;
                    if (interceptable2 != null) {
                        InitContext newInitContext = TitanRuntime.newInitContext();
                        interceptable2.invokeUnInit(65536, newInitContext);
                        int i2 = newInitContext.flag;
                        if ((i2 & 1) != 0) {
                            int i3 = i2 & 2;
                            newInitContext.thisArg = this;
                            interceptable2.invokeInitBody(65536, newInitContext);
                        }
                    }
                }

                @Override // com.baidu.adp.framework.task.CustomMessageTask.CustomRunnable
                public CustomResponsedMessage<String> run(CustomMessage<a> customMessage) {
                    InterceptResult invokeL;
                    Interceptable interceptable2 = $ic;
                    if (interceptable2 == null || (invokeL = interceptable2.invokeL(1048576, this, customMessage)) == null) {
                        if (customMessage.getData() == null) {
                            return null;
                        }
                        WalletPluginManager.getInstance().invokePlugin(null);
                        return new CustomResponsedMessage<>(2921539, WalletPluginManager.getInstance().doAliPay(customMessage.getData().a, customMessage.getData().f12840b, customMessage.getData().f12841c));
                    }
                    return (CustomResponsedMessage) invokeL.objValue;
                }
            });
            customMessageTask.setType(CustomMessageTask.TASK_TYPE.SYNCHRONIZED);
            MessageManager.getInstance().registerTask(customMessageTask);
        }
    }

    public static void registerBaiduNovelPayTask() {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeV(InputDeviceCompat.SOURCE_TRACKBALL, null) == null) {
            CustomMessageTask customMessageTask = new CustomMessageTask(2921335, new CustomMessageTask.CustomRunnable<String>() { // from class: com.baidu.tieba.wallet.WalletStatic.7
                public static /* synthetic */ Interceptable $ic;
                public transient /* synthetic */ FieldHolder $fh;

                {
                    Interceptable interceptable2 = $ic;
                    if (interceptable2 != null) {
                        InitContext newInitContext = TitanRuntime.newInitContext();
                        interceptable2.invokeUnInit(65536, newInitContext);
                        int i2 = newInitContext.flag;
                        if ((i2 & 1) != 0) {
                            int i3 = i2 & 2;
                            newInitContext.thisArg = this;
                            interceptable2.invokeInitBody(65536, newInitContext);
                        }
                    }
                }

                @Override // com.baidu.adp.framework.task.CustomMessageTask.CustomRunnable
                public CustomResponsedMessage<?> run(CustomMessage<String> customMessage) {
                    InterceptResult invokeL;
                    Interceptable interceptable2 = $ic;
                    if (interceptable2 == null || (invokeL = interceptable2.invokeL(1048576, this, customMessage)) == null) {
                        if (customMessage != null && customMessage.getData() != null) {
                            WalletPluginManager.getInstance().doBaiduNovelPay(TbadkCoreApplication.getInst(), customMessage.getData());
                        }
                        return null;
                    }
                    return (CustomResponsedMessage) invokeL.objValue;
                }
            });
            customMessageTask.setType(CustomMessageTask.TASK_TYPE.SYNCHRONIZED);
            MessageManager.getInstance().registerTask(customMessageTask);
        }
    }

    public static void registerBindCardListener() {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeV(65541, null) == null) {
            MessageManager.getInstance().registerListener(new CustomMessageListener(2016457) { // from class: com.baidu.tieba.wallet.WalletStatic.14
                public static /* synthetic */ Interceptable $ic;
                public transient /* synthetic */ FieldHolder $fh;

                /* JADX WARN: 'super' call moved to the top of the method (can break code semantics) */
                {
                    super(r7);
                    Interceptable interceptable2 = $ic;
                    if (interceptable2 != null) {
                        InitContext newInitContext = TitanRuntime.newInitContext();
                        newInitContext.initArgs = r2;
                        Object[] objArr = {Integer.valueOf(r7)};
                        interceptable2.invokeUnInit(65536, newInitContext);
                        int i2 = newInitContext.flag;
                        if ((i2 & 1) != 0) {
                            int i3 = i2 & 2;
                            super(((Integer) newInitContext.callArgs[0]).intValue());
                            newInitContext.thisArg = this;
                            interceptable2.invokeInitBody(65536, newInitContext);
                            return;
                        }
                    }
                }

                /* JADX DEBUG: Method merged with bridge method */
                @Override // com.baidu.adp.framework.listener.MessageListener
                public void onMessage(CustomResponsedMessage<?> customResponsedMessage) {
                    Interceptable interceptable2 = $ic;
                    if (!(interceptable2 == null || interceptable2.invokeL(1048576, this, customResponsedMessage) == null) || customResponsedMessage == null || customResponsedMessage.getData() == null || (customResponsedMessage.getData() instanceof ExceptionData)) {
                        return;
                    }
                    UserBfbInfo userBfbInfo = (UserBfbInfo) customResponsedMessage.getData();
                    HashMap hashMap = new HashMap();
                    hashMap.put("sp_no", userBfbInfo.android_bfb_sdk.sp_no.toString());
                    hashMap.put("version", userBfbInfo.android_bfb_sdk.version);
                    hashMap.put("activity_no", userBfbInfo.android_bfb_sdk.activity_no);
                    hashMap.put("order_no", userBfbInfo.android_bfb_sdk.order_no);
                    hashMap.put("return_url", userBfbInfo.android_bfb_sdk.return_url);
                    hashMap.put("sign", userBfbInfo.android_bfb_sdk.sign);
                    hashMap.put("sign_method", userBfbInfo.android_bfb_sdk.sign_method.toString());
                    WalletPluginManager.getInstance().doBindCard(TbadkApplication.getInst().getContext(), hashMap);
                }
            });
        }
    }

    public static void registerFinancialFrsSDKTabSchemaListener() {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeV(65542, null) == null) {
            UrlManager.getInstance().addListener(new UrlManager.UrlDealListener() { // from class: com.baidu.tieba.wallet.WalletStatic.5
                public static /* synthetic */ Interceptable $ic;
                public transient /* synthetic */ FieldHolder $fh;

                {
                    Interceptable interceptable2 = $ic;
                    if (interceptable2 != null) {
                        InitContext newInitContext = TitanRuntime.newInitContext();
                        interceptable2.invokeUnInit(65536, newInitContext);
                        int i2 = newInitContext.flag;
                        if ((i2 & 1) != 0) {
                            int i3 = i2 & 2;
                            newInitContext.thisArg = this;
                            interceptable2.invokeInitBody(65536, newInitContext);
                        }
                    }
                }

                @Override // com.baidu.tbadk.core.util.UrlManager.UrlDealListener
                public int deal(TbPageContext<?> tbPageContext, String[] strArr) {
                    InterceptResult invokeLL;
                    int indexOf;
                    int i2;
                    String substring;
                    int indexOf2;
                    int i3;
                    Interceptable interceptable2 = $ic;
                    if (interceptable2 == null || (invokeLL = interceptable2.invokeLL(1048576, this, tbPageContext, strArr)) == null) {
                        if (strArr != null && strArr.length > 0) {
                            String str = strArr[0];
                            if (!StringUtils.isNull(str) && str.startsWith(UrlSchemaHelper.SCHEMA_TYPE_FINANCIAL_FRS_SDK_TAB) && (indexOf = str.indexOf("://")) >= 0 && (i2 = indexOf + 3) <= str.length() && (indexOf2 = (substring = str.substring(i2)).indexOf("url=")) >= 0 && (i3 = indexOf2 + 4) <= substring.length() && e.c().e()) {
                                WalletPluginManager.getInstance().openH5Module(TbadkApplication.getInst().getContext(), substring.substring(i3));
                                return 0;
                            }
                        }
                        return 3;
                    }
                    return invokeLL.intValue;
                }
            });
        }
    }

    public static void registerHttpAndSocketTask() {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeV(65543, null) == null) {
            c.a.u0.z3.g0.a.f(303043, ResponsedGetOrderSocketMessage.class, false);
            TbHttpMessageTask tbHttpMessageTask = new TbHttpMessageTask(CmdConfigHttp.CMD_GET_ORDER, c.a.u0.z3.g0.a.a(TbConfig.GET_ORDER, 303043));
            tbHttpMessageTask.setResponsedClass(ResponsedGetOrderHttpMessage.class);
            MessageManager.getInstance().registerTask(tbHttpMessageTask);
        }
    }

    public static void registerIntentListener() {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeV(65544, null) == null) {
            MessageManager.getInstance().registerListener(new CustomMessageListener(2921565) { // from class: com.baidu.tieba.wallet.WalletStatic.15
                public static /* synthetic */ Interceptable $ic;
                public transient /* synthetic */ FieldHolder $fh;

                /* JADX WARN: 'super' call moved to the top of the method (can break code semantics) */
                {
                    super(r7);
                    Interceptable interceptable2 = $ic;
                    if (interceptable2 != null) {
                        InitContext newInitContext = TitanRuntime.newInitContext();
                        newInitContext.initArgs = r2;
                        Object[] objArr = {Integer.valueOf(r7)};
                        interceptable2.invokeUnInit(65536, newInitContext);
                        int i2 = newInitContext.flag;
                        if ((i2 & 1) != 0) {
                            int i3 = i2 & 2;
                            super(((Integer) newInitContext.callArgs[0]).intValue());
                            newInitContext.thisArg = this;
                            interceptable2.invokeInitBody(65536, newInitContext);
                            return;
                        }
                    }
                }

                /* JADX DEBUG: Method merged with bridge method */
                @Override // com.baidu.adp.framework.listener.MessageListener
                public void onMessage(CustomResponsedMessage<?> customResponsedMessage) {
                    Interceptable interceptable2 = $ic;
                    if (interceptable2 == null || interceptable2.invokeL(1048576, this, customResponsedMessage) == null) {
                        WalletPluginManager.getInstance().registerIntent();
                    }
                }
            });
        }
    }

    public static void registerMyWalletTask() {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeV(65545, null) == null) {
            CustomMessageTask customMessageTask = new CustomMessageTask(2001351, new CustomMessageTask.CustomRunnable<IntentConfig>() { // from class: com.baidu.tieba.wallet.WalletStatic.1
                public static /* synthetic */ Interceptable $ic;
                public transient /* synthetic */ FieldHolder $fh;

                {
                    Interceptable interceptable2 = $ic;
                    if (interceptable2 != null) {
                        InitContext newInitContext = TitanRuntime.newInitContext();
                        interceptable2.invokeUnInit(65536, newInitContext);
                        int i2 = newInitContext.flag;
                        if ((i2 & 1) != 0) {
                            int i3 = i2 & 2;
                            newInitContext.thisArg = this;
                            interceptable2.invokeInitBody(65536, newInitContext);
                        }
                    }
                }

                @Override // com.baidu.adp.framework.task.CustomMessageTask.CustomRunnable
                public CustomResponsedMessage<?> run(CustomMessage<IntentConfig> customMessage) {
                    InterceptResult invokeL;
                    Interceptable interceptable2 = $ic;
                    if (interceptable2 == null || (invokeL = interceptable2.invokeL(1048576, this, customMessage)) == null) {
                        if (customMessage == null || customMessage.getData() == null || customMessage.getData().getContext() == null) {
                            return null;
                        }
                        WalletPluginManager.getInstance().startWallet(customMessage.getData().getContext());
                        return null;
                    }
                    return (CustomResponsedMessage) invokeL.objValue;
                }
            });
            customMessageTask.setType(CustomMessageTask.TASK_TYPE.SYNCHRONIZED);
            MessageManager.getInstance().registerTask(customMessageTask);
        }
    }

    public static void registerOpenWalletICashPageJump() {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeV(65546, null) == null) {
            UrlManager.getInstance().addListener(new UrlManager.UrlDealListener() { // from class: com.baidu.tieba.wallet.WalletStatic.6
                public static /* synthetic */ Interceptable $ic;
                public transient /* synthetic */ FieldHolder $fh;

                {
                    Interceptable interceptable2 = $ic;
                    if (interceptable2 != null) {
                        InitContext newInitContext = TitanRuntime.newInitContext();
                        interceptable2.invokeUnInit(65536, newInitContext);
                        int i2 = newInitContext.flag;
                        if ((i2 & 1) != 0) {
                            int i3 = i2 & 2;
                            newInitContext.thisArg = this;
                            interceptable2.invokeInitBody(65536, newInitContext);
                        }
                    }
                }

                @Override // com.baidu.tbadk.core.util.UrlManager.UrlDealListener
                public int deal(TbPageContext<?> tbPageContext, String[] strArr) {
                    InterceptResult invokeLL;
                    Interceptable interceptable2 = $ic;
                    if (interceptable2 == null || (invokeLL = interceptable2.invokeLL(1048576, this, tbPageContext, strArr)) == null) {
                        if (strArr == null || strArr.length == 0) {
                            return 3;
                        }
                        String str = strArr[0];
                        if (str.contains(UrlSchemaHelper.SCHEMA_TYPE_GOTO_WALLET_SDK_ICACH) || str.contains(UrlSchemaHelper.SCHEMA_TYPE_GOTO_WALLET_SDK_DUXIAOMAN)) {
                            if (n.B() && e.c().e()) {
                                WalletPluginManager.getInstance().openH5Module(TbadkApplication.getInst().getContext(), str);
                            } else {
                                BdStatisticsManager bdStatisticsManager = BdStatisticsManager.getInstance();
                                bdStatisticsManager.newDebug("wallet_debug", 0L, null, "type", "scheme_start_wallet_sub_thread", "link", "" + str);
                                c.a.d.f.m.e.a().post(new Runnable(this, str) { // from class: com.baidu.tieba.wallet.WalletStatic.6.1
                                    public static /* synthetic */ Interceptable $ic;
                                    public transient /* synthetic */ FieldHolder $fh;
                                    public final /* synthetic */ AnonymousClass6 this$0;
                                    public final /* synthetic */ String val$link;

                                    {
                                        Interceptable interceptable3 = $ic;
                                        if (interceptable3 != null) {
                                            InitContext newInitContext = TitanRuntime.newInitContext();
                                            newInitContext.initArgs = r2;
                                            Object[] objArr = {this, str};
                                            interceptable3.invokeUnInit(65536, newInitContext);
                                            int i2 = newInitContext.flag;
                                            if ((i2 & 1) != 0) {
                                                int i3 = i2 & 2;
                                                newInitContext.thisArg = this;
                                                interceptable3.invokeInitBody(65536, newInitContext);
                                                return;
                                            }
                                        }
                                        this.this$0 = this;
                                        this.val$link = str;
                                    }

                                    @Override // java.lang.Runnable
                                    public void run() {
                                        Interceptable interceptable3 = $ic;
                                        if ((interceptable3 == null || interceptable3.invokeV(1048576, this) == null) && e.c().e()) {
                                            WalletPluginManager.getInstance().openH5Module(TbadkApplication.getInst().getContext(), this.val$link);
                                        }
                                    }
                                });
                            }
                            return 0;
                        }
                        return 3;
                    }
                    return invokeLL.intValue;
                }
            });
        }
    }

    public static void registerOpenWalletICashPageTask() {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeV(65547, null) == null) {
            CustomMessageTask customMessageTask = new CustomMessageTask(2001447, new CustomMessageTask.CustomRunnable<String>() { // from class: com.baidu.tieba.wallet.WalletStatic.3
                public static /* synthetic */ Interceptable $ic;
                public transient /* synthetic */ FieldHolder $fh;

                {
                    Interceptable interceptable2 = $ic;
                    if (interceptable2 != null) {
                        InitContext newInitContext = TitanRuntime.newInitContext();
                        interceptable2.invokeUnInit(65536, newInitContext);
                        int i2 = newInitContext.flag;
                        if ((i2 & 1) != 0) {
                            int i3 = i2 & 2;
                            newInitContext.thisArg = this;
                            interceptable2.invokeInitBody(65536, newInitContext);
                        }
                    }
                }

                @Override // com.baidu.adp.framework.task.CustomMessageTask.CustomRunnable
                public CustomResponsedMessage<?> run(CustomMessage<String> customMessage) {
                    InterceptResult invokeL;
                    Interceptable interceptable2 = $ic;
                    if (interceptable2 == null || (invokeL = interceptable2.invokeL(1048576, this, customMessage)) == null) {
                        if (customMessage != null && !m.isEmpty(customMessage.getData())) {
                            WalletPluginManager.getInstance().openH5Module(TbadkApplication.getInst().getContext(), customMessage.getData());
                        }
                        return null;
                    }
                    return (CustomResponsedMessage) invokeL.objValue;
                }
            });
            customMessageTask.setType(CustomMessageTask.TASK_TYPE.SYNCHRONIZED);
            MessageManager.getInstance().registerTask(customMessageTask);
        }
    }

    public static void registerOpenWallteBalanceTask() {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeV(65548, null) == null) {
            CustomMessageTask customMessageTask = new CustomMessageTask(2001452, new CustomMessageTask.CustomRunnable<String>() { // from class: com.baidu.tieba.wallet.WalletStatic.13
                public static /* synthetic */ Interceptable $ic;
                public transient /* synthetic */ FieldHolder $fh;

                {
                    Interceptable interceptable2 = $ic;
                    if (interceptable2 != null) {
                        InitContext newInitContext = TitanRuntime.newInitContext();
                        interceptable2.invokeUnInit(65536, newInitContext);
                        int i2 = newInitContext.flag;
                        if ((i2 & 1) != 0) {
                            int i3 = i2 & 2;
                            newInitContext.thisArg = this;
                            interceptable2.invokeInitBody(65536, newInitContext);
                        }
                    }
                }

                @Override // com.baidu.adp.framework.task.CustomMessageTask.CustomRunnable
                public CustomResponsedMessage<?> run(CustomMessage<String> customMessage) {
                    InterceptResult invokeL;
                    Interceptable interceptable2 = $ic;
                    if (interceptable2 == null || (invokeL = interceptable2.invokeL(1048576, this, customMessage)) == null) {
                        WalletPluginManager.getInstance().gotoWalletService(TbadkApplication.getInst().getContext(), "16384");
                        return null;
                    }
                    return (CustomResponsedMessage) invokeL.objValue;
                }
            });
            customMessageTask.setType(CustomMessageTask.TASK_TYPE.SYNCHRONIZED);
            MessageManager.getInstance().registerTask(customMessageTask);
        }
    }

    public static void registerOpenWallteHomePageTask() {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeV(65549, null) == null) {
            CustomMessageTask customMessageTask = new CustomMessageTask(2001451, new CustomMessageTask.CustomRunnable<String>() { // from class: com.baidu.tieba.wallet.WalletStatic.4
                public static /* synthetic */ Interceptable $ic;
                public transient /* synthetic */ FieldHolder $fh;

                {
                    Interceptable interceptable2 = $ic;
                    if (interceptable2 != null) {
                        InitContext newInitContext = TitanRuntime.newInitContext();
                        interceptable2.invokeUnInit(65536, newInitContext);
                        int i2 = newInitContext.flag;
                        if ((i2 & 1) != 0) {
                            int i3 = i2 & 2;
                            newInitContext.thisArg = this;
                            interceptable2.invokeInitBody(65536, newInitContext);
                        }
                    }
                }

                @Override // com.baidu.adp.framework.task.CustomMessageTask.CustomRunnable
                public CustomResponsedMessage<?> run(CustomMessage<String> customMessage) {
                    InterceptResult invokeL;
                    Interceptable interceptable2 = $ic;
                    if (interceptable2 == null || (invokeL = interceptable2.invokeL(1048576, this, customMessage)) == null) {
                        WalletPluginManager.getInstance().gotoWalletService(TbadkApplication.getInst().getContext(), "16384");
                        return null;
                    }
                    return (CustomResponsedMessage) invokeL.objValue;
                }
            });
            customMessageTask.setType(CustomMessageTask.TASK_TYPE.SYNCHRONIZED);
            MessageManager.getInstance().registerTask(customMessageTask);
        }
    }

    public static void registerPersonWalletMessage() {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeV(65550, null) == null) {
            MessageManager.getInstance().registerListener(new CustomMessageListener(2001387) { // from class: com.baidu.tieba.wallet.WalletStatic.2
                public static /* synthetic */ Interceptable $ic;
                public transient /* synthetic */ FieldHolder $fh;

                /* JADX WARN: 'super' call moved to the top of the method (can break code semantics) */
                {
                    super(r7);
                    Interceptable interceptable2 = $ic;
                    if (interceptable2 != null) {
                        InitContext newInitContext = TitanRuntime.newInitContext();
                        newInitContext.initArgs = r2;
                        Object[] objArr = {Integer.valueOf(r7)};
                        interceptable2.invokeUnInit(65536, newInitContext);
                        int i2 = newInitContext.flag;
                        if ((i2 & 1) != 0) {
                            int i3 = i2 & 2;
                            super(((Integer) newInitContext.callArgs[0]).intValue());
                            newInitContext.thisArg = this;
                            interceptable2.invokeInitBody(65536, newInitContext);
                            return;
                        }
                    }
                }

                /* JADX DEBUG: Method merged with bridge method */
                @Override // com.baidu.adp.framework.listener.MessageListener
                public void onMessage(CustomResponsedMessage<?> customResponsedMessage) {
                    Interceptable interceptable2 = $ic;
                    if ((interceptable2 == null || interceptable2.invokeL(1048576, this, customResponsedMessage) == null) && customResponsedMessage != null && (customResponsedMessage.getData() instanceof String)) {
                        WalletPluginManager.getInstance().accessWalletEntry(TbadkApplication.getInst().getContext(), (String) customResponsedMessage.getData());
                    }
                }
            });
        }
    }

    public static void registerTiebaCertification() {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeV(65551, null) == null) {
            CustomMessageTask customMessageTask = new CustomMessageTask(2921433, new CustomMessageTask.CustomRunnable() { // from class: com.baidu.tieba.wallet.WalletStatic.11
                public static /* synthetic */ Interceptable $ic;
                public transient /* synthetic */ FieldHolder $fh;

                {
                    Interceptable interceptable2 = $ic;
                    if (interceptable2 != null) {
                        InitContext newInitContext = TitanRuntime.newInitContext();
                        interceptable2.invokeUnInit(65536, newInitContext);
                        int i2 = newInitContext.flag;
                        if ((i2 & 1) != 0) {
                            int i3 = i2 & 2;
                            newInitContext.thisArg = this;
                            interceptable2.invokeInitBody(65536, newInitContext);
                        }
                    }
                }

                @Override // com.baidu.adp.framework.task.CustomMessageTask.CustomRunnable
                public CustomResponsedMessage<?> run(CustomMessage customMessage) {
                    InterceptResult invokeL;
                    Interceptable interceptable2 = $ic;
                    return (interceptable2 == null || (invokeL = interceptable2.invokeL(1048576, this, customMessage)) == null) ? new CustomResponsedMessage<>(2921433, new ICertification(this) { // from class: com.baidu.tieba.wallet.WalletStatic.11.1
                        public static /* synthetic */ Interceptable $ic;
                        public transient /* synthetic */ FieldHolder $fh;
                        public final /* synthetic */ AnonymousClass11 this$0;

                        {
                            Interceptable interceptable3 = $ic;
                            if (interceptable3 != null) {
                                InitContext newInitContext = TitanRuntime.newInitContext();
                                newInitContext.initArgs = r2;
                                Object[] objArr = {this};
                                interceptable3.invokeUnInit(65536, newInitContext);
                                int i2 = newInitContext.flag;
                                if ((i2 & 1) != 0) {
                                    int i3 = i2 & 2;
                                    newInitContext.thisArg = this;
                                    interceptable3.invokeInitBody(65536, newInitContext);
                                    return;
                                }
                            }
                            this.this$0 = this;
                        }

                        @Override // com.baidu.tieba.wallet.ICertification
                        public void certification(Context context, Map<String, Object> map, ICertification.CertificationCallback certificationCallback) {
                            Interceptable interceptable3 = $ic;
                            if (interceptable3 == null || interceptable3.invokeLLL(1048576, this, context, map, certificationCallback) == null) {
                                String str = SapiAccountManager.getInstance().getSession().bduss;
                                RealNameDTO realNameDTO = new RealNameDTO();
                                realNameDTO.bduss = str;
                                realNameDTO.scene = FaceBaseDTO.BUSINESS_SENCE_REALNAME_FACE;
                                realNameDTO.needCbKey = false;
                                if (map != null) {
                                    realNameDTO.customRealNameUrl = map.containsKey("certify_url") ? map.get("certify_url").toString() : "";
                                }
                                PassportSDK.getInstance().loadAccountRealName(context, new AccountRealNameCallback(this, certificationCallback) { // from class: com.baidu.tieba.wallet.WalletStatic.11.1.1
                                    public static /* synthetic */ Interceptable $ic;
                                    public transient /* synthetic */ FieldHolder $fh;
                                    public final /* synthetic */ AnonymousClass1 this$1;
                                    public final /* synthetic */ ICertification.CertificationCallback val$callback;

                                    {
                                        Interceptable interceptable4 = $ic;
                                        if (interceptable4 != null) {
                                            InitContext newInitContext = TitanRuntime.newInitContext();
                                            newInitContext.initArgs = r2;
                                            Object[] objArr = {this, certificationCallback};
                                            interceptable4.invokeUnInit(65536, newInitContext);
                                            int i2 = newInitContext.flag;
                                            if ((i2 & 1) != 0) {
                                                int i3 = i2 & 2;
                                                newInitContext.thisArg = this;
                                                interceptable4.invokeInitBody(65536, newInitContext);
                                                return;
                                            }
                                        }
                                        this.this$1 = this;
                                        this.val$callback = certificationCallback;
                                    }

                                    @Override // com.baidu.sapi2.callback.AccountRealNameCallback
                                    public void onFinish(AccountRealNameResult accountRealNameResult) {
                                        Interceptable interceptable4 = $ic;
                                        if (interceptable4 == null || interceptable4.invokeL(1048576, this, accountRealNameResult) == null) {
                                            super.onFinish(accountRealNameResult);
                                            if (this.val$callback != null) {
                                                HashMap hashMap = new HashMap();
                                                int resultCode = accountRealNameResult.getResultCode();
                                                String resultMsg = accountRealNameResult.getResultMsg();
                                                boolean z = accountRealNameResult.juniorRealNameSuc;
                                                boolean z2 = accountRealNameResult.seniorRealNameSuc;
                                                String str2 = accountRealNameResult.callbackkey;
                                                if (TextUtils.isEmpty(resultMsg)) {
                                                    resultMsg = "";
                                                }
                                                if (TextUtils.isEmpty(str2)) {
                                                    str2 = "";
                                                }
                                                hashMap.put("resultMsg", resultMsg);
                                                hashMap.put("callbackkey", str2);
                                                hashMap.put("juniorRealNameSuc", z ? "1" : "0");
                                                hashMap.put("seniorRealNameSuc", z2 ? "1" : "0");
                                                this.val$callback.onResult(resultCode, hashMap);
                                            }
                                        }
                                    }
                                }, realNameDTO);
                            }
                        }
                    }) : (CustomResponsedMessage) invokeL.objValue;
                }
            });
            customMessageTask.setType(CustomMessageTask.TASK_TYPE.SYNCHRONIZED);
            MessageManager.getInstance().registerTask(customMessageTask);
        }
    }

    public static void registerTiebaPay() {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeV(65552, null) == null) {
            CustomMessageTask customMessageTask = new CustomMessageTask(2921432, new CustomMessageTask.CustomRunnable<Void>() { // from class: com.baidu.tieba.wallet.WalletStatic.10
                public static /* synthetic */ Interceptable $ic;
                public transient /* synthetic */ FieldHolder $fh;

                {
                    Interceptable interceptable2 = $ic;
                    if (interceptable2 != null) {
                        InitContext newInitContext = TitanRuntime.newInitContext();
                        interceptable2.invokeUnInit(65536, newInitContext);
                        int i2 = newInitContext.flag;
                        if ((i2 & 1) != 0) {
                            int i3 = i2 & 2;
                            newInitContext.thisArg = this;
                            interceptable2.invokeInitBody(65536, newInitContext);
                        }
                    }
                }

                @Override // com.baidu.adp.framework.task.CustomMessageTask.CustomRunnable
                public CustomResponsedMessage<?> run(CustomMessage<Void> customMessage) {
                    InterceptResult invokeL;
                    Interceptable interceptable2 = $ic;
                    if (interceptable2 == null || (invokeL = interceptable2.invokeL(1048576, this, customMessage)) == null) {
                        WalletPluginManager.getInstance().invokePlugin(null);
                        return new CustomResponsedMessage<>(2921432, WalletPluginManager.getInstance().doTiebaPay(b.f().b()));
                    }
                    return (CustomResponsedMessage) invokeL.objValue;
                }
            });
            customMessageTask.setType(CustomMessageTask.TASK_TYPE.SYNCHRONIZED);
            MessageManager.getInstance().registerTask(customMessageTask);
        }
    }

    public static void registerYYPayTask() {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeV(65553, null) == null) {
            CustomMessageTask customMessageTask = new CustomMessageTask(2921546, new CustomMessageTask.CustomRunnable<g>() { // from class: com.baidu.tieba.wallet.WalletStatic.12
                public static /* synthetic */ Interceptable $ic;
                public transient /* synthetic */ FieldHolder $fh;

                {
                    Interceptable interceptable2 = $ic;
                    if (interceptable2 != null) {
                        InitContext newInitContext = TitanRuntime.newInitContext();
                        interceptable2.invokeUnInit(65536, newInitContext);
                        int i2 = newInitContext.flag;
                        if ((i2 & 1) != 0) {
                            int i3 = i2 & 2;
                            newInitContext.thisArg = this;
                            interceptable2.invokeInitBody(65536, newInitContext);
                        }
                    }
                }

                @Override // com.baidu.adp.framework.task.CustomMessageTask.CustomRunnable
                public CustomResponsedMessage<String> run(CustomMessage<g> customMessage) {
                    InterceptResult invokeL;
                    Interceptable interceptable2 = $ic;
                    if (interceptable2 == null || (invokeL = interceptable2.invokeL(1048576, this, customMessage)) == null) {
                        if (customMessage.getData() == null) {
                            return null;
                        }
                        WalletPluginManager.getInstance().doYYPay(customMessage.getData());
                        return null;
                    }
                    return (CustomResponsedMessage) invokeL.objValue;
                }
            });
            customMessageTask.setType(CustomMessageTask.TASK_TYPE.SYNCHRONIZED);
            MessageManager.getInstance().registerTask(customMessageTask);
        }
    }
}
