package com.baidu.tieba.wallet;

import android.app.Activity;
import android.content.Context;
import android.text.TextUtils;
import androidx.core.view.InputDeviceCompat;
import c.a.p0.n0.d;
import c.a.p0.n0.e;
import c.a.p0.n0.f;
import com.alipay.sdk.app.PayTask;
import com.alipay.sdk.util.i;
import com.baidu.adp.BdUniqueId;
import com.baidu.adp.framework.MessageManager;
import com.baidu.adp.framework.message.CustomResponsedMessage;
import com.baidu.adp.lib.asyncTask.BdAsyncTask;
import com.baidu.adp.lib.util.StringUtils;
import com.baidu.android.imsdk.internal.Constants;
import com.baidu.android.lbspay.BaiduLBSPay;
import com.baidu.android.lbspay.LBSPayBack;
import com.baidu.android.lbspay.LBSPayInner;
import com.baidu.android.lbspay.network.INetwork;
import com.baidu.android.pay.BindBack;
import com.baidu.android.pay.PayCallBack;
import com.baidu.tbadk.TbadkApplication;
import com.baidu.tbadk.core.atomData.PayWalletActivityConfig;
import com.baidu.tbadk.core.atomData.WalletPayResultActivityConfig;
import com.baidu.tieba.wallet.pay.PayActivityStatic;
import com.baidu.tieba.wallet.pay.WalletPayActivity;
import com.baidu.tieba.wallet.pay.WalletPayResultActivity;
import com.baidu.titan.sdk.runtime.FieldHolder;
import com.baidu.titan.sdk.runtime.InitContext;
import com.baidu.titan.sdk.runtime.InterceptResult;
import com.baidu.titan.sdk.runtime.Interceptable;
import com.baidu.titan.sdk.runtime.TitanRuntime;
import com.baidu.wallet.api.BaiduWallet;
import java.util.HashMap;
import java.util.Map;
import org.json.JSONException;
import org.json.JSONObject;
/* loaded from: classes7.dex */
public class WalletPluginImpl implements IWalletPlugin {
    public static /* synthetic */ Interceptable $ic = null;
    public static final String NPS_MODE = "Wallet";
    public transient /* synthetic */ FieldHolder $fh;

    public WalletPluginImpl() {
        Interceptable interceptable = $ic;
        if (interceptable != null) {
            InitContext newInitContext = TitanRuntime.newInitContext();
            interceptable.invokeUnInit(65536, newInitContext);
            int i2 = newInitContext.flag;
            if ((i2 & 1) != 0) {
                int i3 = i2 & 2;
                newInitContext.thisArg = this;
                interceptable.invokeInitBody(65536, newInitContext);
            }
        }
    }

    @Override // com.baidu.tieba.wallet.IWalletPlugin
    public void accessWalletEntry(Context context, String str) {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeLL(1048576, this, context, str) == null) {
            PayActivityStatic.initBaiduWallet();
            BaiduWallet.getInstance().accessWalletEntry(context, str);
        }
    }

    @Override // com.baidu.tieba.wallet.IWalletPlugin
    public String doAliPay(Activity activity, String str, boolean z) {
        InterceptResult invokeLLZ;
        Interceptable interceptable = $ic;
        return (interceptable == null || (invokeLLZ = interceptable.invokeLLZ(Constants.METHOD_GET_CONTACTER_INFO_FOR_SESSION, this, activity, str, z)) == null) ? new PayTask(activity).pay(str, z) : (String) invokeLLZ.objValue;
    }

    @Override // com.baidu.tieba.wallet.IWalletPlugin
    public void doBaiduLBSPay(Activity activity, Map<String, String> map, String str, BdUniqueId bdUniqueId) {
        Interceptable interceptable = $ic;
        if (!(interceptable == null || interceptable.invokeLLLL(1048579, this, activity, map, str, bdUniqueId) == null) || map == null || StringUtils.isNull(str)) {
            return;
        }
        PayActivityStatic.initBaiduWallet();
        BaiduLBSPay.getInstance().doCallFrontCashierPay(activity, null, new LBSPayBack(this, bdUniqueId) { // from class: com.baidu.tieba.wallet.WalletPluginImpl.4
            public static /* synthetic */ Interceptable $ic;
            public transient /* synthetic */ FieldHolder $fh;
            public final /* synthetic */ WalletPluginImpl this$0;
            public final /* synthetic */ BdUniqueId val$tag;

            {
                Interceptable interceptable2 = $ic;
                if (interceptable2 != null) {
                    InitContext newInitContext = TitanRuntime.newInitContext();
                    newInitContext.initArgs = r2;
                    Object[] objArr = {this, bdUniqueId};
                    interceptable2.invokeUnInit(65536, newInitContext);
                    int i2 = newInitContext.flag;
                    if ((i2 & 1) != 0) {
                        int i3 = i2 & 2;
                        newInitContext.thisArg = this;
                        interceptable2.invokeInitBody(65536, newInitContext);
                        return;
                    }
                }
                this.this$0 = this;
                this.val$tag = bdUniqueId;
            }

            @Override // com.baidu.android.lbspay.LBSPayBack
            public void onPayResult(int i2, String str2) {
                String str3;
                Interceptable interceptable2 = $ic;
                if (interceptable2 == null || interceptable2.invokeIL(1048576, this, i2, str2) == null) {
                    try {
                        JSONObject jSONObject = new JSONObject();
                        jSONObject.put("statusCode", i2);
                        jSONObject.put("responseData", str2);
                        str3 = jSONObject.toString();
                    } catch (JSONException e2) {
                        e2.printStackTrace();
                        str3 = null;
                    }
                    e eVar = new e();
                    eVar.f13643a = this.val$tag;
                    eVar.f13644b = i2;
                    eVar.f13645c = str3;
                    MessageManager.getInstance().dispatchResponsedMessage(new CustomResponsedMessage(2921393, eVar));
                }
            }
        }, map, str);
    }

    @Override // com.baidu.tieba.wallet.IWalletPlugin
    public void doBaiduNovelPay(Context context, String str) {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeLL(1048580, this, context, str) == null) {
            PayActivityStatic.initBaiduWallet();
            BaiduWallet.getInstance().doPay(context, str, new PayCallBack(this) { // from class: com.baidu.tieba.wallet.WalletPluginImpl.1
                public static /* synthetic */ Interceptable $ic;
                public transient /* synthetic */ FieldHolder $fh;
                public final /* synthetic */ WalletPluginImpl this$0;

                {
                    Interceptable interceptable2 = $ic;
                    if (interceptable2 != null) {
                        InitContext newInitContext = TitanRuntime.newInitContext();
                        newInitContext.initArgs = r2;
                        Object[] objArr = {this};
                        interceptable2.invokeUnInit(65536, newInitContext);
                        int i2 = newInitContext.flag;
                        if ((i2 & 1) != 0) {
                            int i3 = i2 & 2;
                            newInitContext.thisArg = this;
                            interceptable2.invokeInitBody(65536, newInitContext);
                            return;
                        }
                    }
                    this.this$0 = this;
                }

                @Override // com.baidu.android.pay.PayCallBack
                public boolean isHideLoadingDialog() {
                    InterceptResult invokeV;
                    Interceptable interceptable2 = $ic;
                    if (interceptable2 == null || (invokeV = interceptable2.invokeV(1048576, this)) == null) {
                        return false;
                    }
                    return invokeV.booleanValue;
                }

                @Override // com.baidu.android.pay.PayCallBack
                public void onPayResult(int i2, String str2) {
                    Interceptable interceptable2 = $ic;
                    if (interceptable2 == null || interceptable2.invokeIL(Constants.METHOD_GET_CONTACTER_INFO_FOR_SESSION, this, i2, str2) == null) {
                        e eVar = new e();
                        eVar.f13644b = i2;
                        eVar.f13645c = str2;
                        MessageManager.getInstance().dispatchResponsedMessage(new CustomResponsedMessage(2921335, eVar));
                    }
                }
            });
        }
    }

    @Override // com.baidu.tieba.wallet.IWalletPlugin
    public void doBaiduPay(Context context, String str, BdUniqueId bdUniqueId) {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeLLL(1048581, this, context, str, bdUniqueId) == null) {
            PayActivityStatic.initBaiduWallet();
            BaiduWallet.getInstance().doPay(context, str, new PayCallBack(this, bdUniqueId) { // from class: com.baidu.tieba.wallet.WalletPluginImpl.2
                public static /* synthetic */ Interceptable $ic;
                public transient /* synthetic */ FieldHolder $fh;
                public final /* synthetic */ WalletPluginImpl this$0;
                public final /* synthetic */ BdUniqueId val$tag;

                {
                    Interceptable interceptable2 = $ic;
                    if (interceptable2 != null) {
                        InitContext newInitContext = TitanRuntime.newInitContext();
                        newInitContext.initArgs = r2;
                        Object[] objArr = {this, bdUniqueId};
                        interceptable2.invokeUnInit(65536, newInitContext);
                        int i2 = newInitContext.flag;
                        if ((i2 & 1) != 0) {
                            int i3 = i2 & 2;
                            newInitContext.thisArg = this;
                            interceptable2.invokeInitBody(65536, newInitContext);
                            return;
                        }
                    }
                    this.this$0 = this;
                    this.val$tag = bdUniqueId;
                }

                @Override // com.baidu.android.pay.PayCallBack
                public boolean isHideLoadingDialog() {
                    InterceptResult invokeV;
                    Interceptable interceptable2 = $ic;
                    if (interceptable2 == null || (invokeV = interceptable2.invokeV(1048576, this)) == null) {
                        return false;
                    }
                    return invokeV.booleanValue;
                }

                @Override // com.baidu.android.pay.PayCallBack
                public void onPayResult(int i2, String str2) {
                    Interceptable interceptable2 = $ic;
                    if (interceptable2 == null || interceptable2.invokeIL(Constants.METHOD_GET_CONTACTER_INFO_FOR_SESSION, this, i2, str2) == null) {
                        e eVar = new e();
                        eVar.f13643a = this.val$tag;
                        eVar.f13644b = i2;
                        eVar.f13645c = str2;
                        MessageManager.getInstance().dispatchResponsedMessage(new CustomResponsedMessage(2921393, eVar));
                    }
                }
            });
        }
    }

    @Override // com.baidu.tieba.wallet.IWalletPlugin
    public void doBindCard(Context context, Map<String, String> map) {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeLL(1048582, this, context, map) == null) {
            LBSPayInner.getInstance().doBindCard(context, new BindBack(this) { // from class: com.baidu.tieba.wallet.WalletPluginImpl.6
                public static /* synthetic */ Interceptable $ic;
                public transient /* synthetic */ FieldHolder $fh;
                public final /* synthetic */ WalletPluginImpl this$0;

                {
                    Interceptable interceptable2 = $ic;
                    if (interceptable2 != null) {
                        InitContext newInitContext = TitanRuntime.newInitContext();
                        newInitContext.initArgs = r2;
                        Object[] objArr = {this};
                        interceptable2.invokeUnInit(65536, newInitContext);
                        int i2 = newInitContext.flag;
                        if ((i2 & 1) != 0) {
                            int i3 = i2 & 2;
                            newInitContext.thisArg = this;
                            interceptable2.invokeInitBody(65536, newInitContext);
                            return;
                        }
                    }
                    this.this$0 = this;
                }

                @Override // com.baidu.android.pay.BindBack
                public boolean isHideLoadingDialog() {
                    InterceptResult invokeV;
                    Interceptable interceptable2 = $ic;
                    if (interceptable2 == null || (invokeV = interceptable2.invokeV(1048576, this)) == null) {
                        return false;
                    }
                    return invokeV.booleanValue;
                }

                @Override // com.baidu.android.pay.BindBack
                public void onBindResult(int i2, String str) {
                    Interceptable interceptable2 = $ic;
                    if ((interceptable2 == null || interceptable2.invokeIL(Constants.METHOD_GET_CONTACTER_INFO_FOR_SESSION, this, i2, str) == null) && i2 == 0) {
                        MessageManager.getInstance().dispatchResponsedMessage(new CustomResponsedMessage(2016458));
                    }
                }
            }, map);
        }
    }

    @Override // com.baidu.tieba.wallet.IWalletPlugin
    public ITiebaPay doTiebaPay(Activity activity) {
        InterceptResult invokeL;
        Interceptable interceptable = $ic;
        return (interceptable == null || (invokeL = interceptable.invokeL(1048583, this, activity)) == null) ? new ITiebaPay(this, activity) { // from class: com.baidu.tieba.wallet.WalletPluginImpl.5
            public static /* synthetic */ Interceptable $ic;
            public transient /* synthetic */ FieldHolder $fh;
            public final /* synthetic */ WalletPluginImpl this$0;
            public final /* synthetic */ Activity val$context;

            {
                Interceptable interceptable2 = $ic;
                if (interceptable2 != null) {
                    InitContext newInitContext = TitanRuntime.newInitContext();
                    newInitContext.initArgs = r2;
                    Object[] objArr = {this, activity};
                    interceptable2.invokeUnInit(65536, newInitContext);
                    int i2 = newInitContext.flag;
                    if ((i2 & 1) != 0) {
                        int i3 = i2 & 2;
                        newInitContext.thisArg = this;
                        interceptable2.invokeInitBody(65536, newInitContext);
                        return;
                    }
                }
                this.this$0 = this;
                this.val$context = activity;
            }

            @Override // com.baidu.tieba.wallet.ITiebaPay
            public String getWalletUa() {
                InterceptResult invokeV;
                Interceptable interceptable2 = $ic;
                if (interceptable2 == null || (invokeV = interceptable2.invokeV(1048576, this)) == null) {
                    PayActivityStatic.initBaiduWallet();
                    String reqData = BaiduLBSPay.getInstance().getReqData(this.val$context);
                    if (!StringUtils.isNull(reqData)) {
                        try {
                            return new JSONObject(reqData).optString("ua");
                        } catch (JSONException e2) {
                            e2.printStackTrace();
                        }
                    }
                    return "";
                }
                return (String) invokeV.objValue;
            }

            @Override // com.baidu.tieba.wallet.ITiebaPay
            public void onPayResult(String str, String str2, Context context, boolean z) {
                Interceptable interceptable2 = $ic;
                if (interceptable2 == null || interceptable2.invokeCommon(Constants.METHOD_GET_CONTACTER_INFO_FOR_SESSION, this, new Object[]{str, str2, context, Boolean.valueOf(z)}) == null) {
                }
            }

            @Override // com.baidu.tieba.wallet.ITiebaPay
            public void pay(String str, HashMap<String, String> hashMap, ITiebaPayCallback iTiebaPayCallback) {
                Interceptable interceptable2 = $ic;
                if (interceptable2 == null || interceptable2.invokeLLL(Constants.METHOD_SEND_USER_MSG, this, str, hashMap, iTiebaPayCallback) == null) {
                    LBSPayBack lBSPayBack = new LBSPayBack(this, iTiebaPayCallback) { // from class: com.baidu.tieba.wallet.WalletPluginImpl.5.1
                        public static /* synthetic */ Interceptable $ic;
                        public transient /* synthetic */ FieldHolder $fh;
                        public final /* synthetic */ AnonymousClass5 this$1;
                        public final /* synthetic */ ITiebaPayCallback val$callback;

                        {
                            Interceptable interceptable3 = $ic;
                            if (interceptable3 != null) {
                                InitContext newInitContext = TitanRuntime.newInitContext();
                                newInitContext.initArgs = r2;
                                Object[] objArr = {this, iTiebaPayCallback};
                                interceptable3.invokeUnInit(65536, newInitContext);
                                int i2 = newInitContext.flag;
                                if ((i2 & 1) != 0) {
                                    int i3 = i2 & 2;
                                    newInitContext.thisArg = this;
                                    interceptable3.invokeInitBody(65536, newInitContext);
                                    return;
                                }
                            }
                            this.this$1 = this;
                            this.val$callback = iTiebaPayCallback;
                        }

                        @Override // com.baidu.android.lbspay.LBSPayBack
                        public void onPayResult(int i2, String str2) {
                            ITiebaPayCallback iTiebaPayCallback2;
                            Interceptable interceptable3 = $ic;
                            if (!(interceptable3 == null || interceptable3.invokeIL(1048576, this, i2, str2) == null) || (iTiebaPayCallback2 = this.val$callback) == null) {
                                return;
                            }
                            iTiebaPayCallback2.onPayResult(i2, str2);
                        }
                    };
                    PayActivityStatic.initBaiduWallet();
                    if (!StringUtils.isNull(str)) {
                        try {
                            JSONObject jSONObject = new JSONObject(BaiduLBSPay.getInstance().getReqData(this.val$context));
                            jSONObject.put("token", INetwork.LBS_HOST);
                            jSONObject.put("payChannel", str);
                            BaiduLBSPay.getInstance().doCallFrontCashierPay(this.val$context, null, lBSPayBack, hashMap, jSONObject.toString());
                            return;
                        } catch (JSONException e2) {
                            e2.printStackTrace();
                            return;
                        }
                    }
                    BaiduLBSPay.getInstance().doPolymerPay(this.val$context, lBSPayBack, hashMap);
                }
            }

            @Override // com.baidu.tieba.wallet.ITiebaPay
            public void release() {
                Interceptable interceptable2 = $ic;
                if (interceptable2 == null || interceptable2.invokeV(1048579, this) == null) {
                }
            }
        } : (ITiebaPay) invokeL.objValue;
    }

    @Override // com.baidu.tieba.wallet.IWalletPlugin
    public void doYYPay(f fVar) {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeL(InputDeviceCompat.SOURCE_TOUCHPAD, this, fVar) == null) {
            PayActivityStatic.doYYPayTask(fVar);
        }
    }

    @Override // com.baidu.tieba.wallet.IWalletPlugin
    public void gotoWalletService(Context context, String str) {
        Interceptable interceptable = $ic;
        if ((interceptable == null || interceptable.invokeLL(1048585, this, context, str) == null) && d.c().f()) {
            PayActivityStatic.initBaiduWallet();
            BaiduWallet.getInstance().gotoWalletService(context, str, "");
        }
    }

    @Override // com.baidu.tieba.wallet.IWalletPlugin
    public void init() {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeV(1048586, this) == null) {
        }
    }

    @Override // com.baidu.tieba.wallet.IWalletPlugin
    public void openH5Module(Context context, String str) {
        Interceptable interceptable = $ic;
        if ((interceptable == null || interceptable.invokeLL(1048587, this, context, str) == null) && d.c().e()) {
            PayActivityStatic.initBaiduWallet();
            BaiduWallet.getInstance().openH5Module(context, str, true);
        }
    }

    @Override // com.baidu.tieba.wallet.IWalletPlugin
    public void registerIntent() {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeV(1048588, this) == null) {
            TbadkApplication.getInst().RegisterIntent(PayWalletActivityConfig.class, WalletPayActivity.class);
            TbadkApplication.getInst().RegisterIntent(WalletPayResultActivityConfig.class, WalletPayResultActivity.class);
        }
    }

    @Override // com.baidu.tieba.wallet.IWalletPlugin
    public void startWallet(Context context) {
        Interceptable interceptable = $ic;
        if ((interceptable == null || interceptable.invokeL(1048589, this, context) == null) && d.c().d()) {
            PayActivityStatic.initBaiduWallet();
            BaiduWallet.getInstance().startWallet(context);
        }
    }

    @Override // com.baidu.tieba.wallet.IWalletPlugin
    public void doAliPay(Activity activity, String str, BdUniqueId bdUniqueId) {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeLLL(Constants.METHOD_SEND_USER_MSG, this, activity, str, bdUniqueId) == null) {
            new BdAsyncTask<String, Integer, Map<String, String>>(this, activity, bdUniqueId) { // from class: com.baidu.tieba.wallet.WalletPluginImpl.3
                public static /* synthetic */ Interceptable $ic;
                public transient /* synthetic */ FieldHolder $fh;
                public final /* synthetic */ WalletPluginImpl this$0;
                public final /* synthetic */ Activity val$context;
                public final /* synthetic */ BdUniqueId val$tag;

                {
                    Interceptable interceptable2 = $ic;
                    if (interceptable2 != null) {
                        InitContext newInitContext = TitanRuntime.newInitContext();
                        newInitContext.initArgs = r2;
                        Object[] objArr = {this, activity, bdUniqueId};
                        interceptable2.invokeUnInit(65536, newInitContext);
                        int i2 = newInitContext.flag;
                        if ((i2 & 1) != 0) {
                            int i3 = i2 & 2;
                            newInitContext.thisArg = this;
                            interceptable2.invokeInitBody(65536, newInitContext);
                            return;
                        }
                    }
                    this.this$0 = this;
                    this.val$context = activity;
                    this.val$tag = bdUniqueId;
                }

                /* JADX DEBUG: Method merged with bridge method */
                @Override // com.baidu.adp.lib.asyncTask.BdAsyncTask
                public Map<String, String> doInBackground(String... strArr) {
                    InterceptResult invokeL;
                    Interceptable interceptable2 = $ic;
                    return (interceptable2 == null || (invokeL = interceptable2.invokeL(Constants.METHOD_GET_CONTACTER_INFO_FOR_SESSION, this, strArr)) == null) ? new PayTask(this.val$context).payV2(strArr[0], true) : (Map) invokeL.objValue;
                }

                /* JADX DEBUG: Method merged with bridge method */
                @Override // com.baidu.adp.lib.asyncTask.BdAsyncTask
                public void onPostExecute(Map<String, String> map) {
                    Interceptable interceptable2 = $ic;
                    if (interceptable2 == null || interceptable2.invokeL(1048579, this, map) == null) {
                        int i2 = -1;
                        String str2 = null;
                        for (String str3 : map.keySet()) {
                            if (TextUtils.equals(str3, i.f35985a)) {
                                i2 = Integer.parseInt(map.get(str3));
                            } else if (TextUtils.equals(str3, "result")) {
                                str2 = map.get(str3);
                            }
                        }
                        int i3 = i2 == 9000 ? 0 : i2 == 8000 ? 1 : i2 == 6001 ? 2 : 6;
                        e eVar = new e();
                        eVar.f13643a = this.val$tag;
                        eVar.f13644b = i3;
                        eVar.f13645c = str2;
                        MessageManager.getInstance().dispatchResponsedMessage(new CustomResponsedMessage(2921393, eVar));
                    }
                }
            }.execute(str);
        }
    }
}
