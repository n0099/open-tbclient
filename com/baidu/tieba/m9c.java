package com.baidu.tieba;

import android.app.Activity;
import android.text.TextUtils;
import android.widget.Toast;
import androidx.core.view.InputDeviceCompat;
import com.baidu.android.imsdk.internal.Constants;
import com.baidu.tbadk.core.data.SmallTailInfo;
import com.baidu.tieba.kbc;
import com.baidu.titan.sdk.runtime.FieldHolder;
import com.baidu.titan.sdk.runtime.InitContext;
import com.baidu.titan.sdk.runtime.InterceptResult;
import com.baidu.titan.sdk.runtime.Interceptable;
import com.baidu.titan.sdk.runtime.TitanRuntime;
import com.yy.mobile.framework.revenuesdk.baseapi.PayCallBackBean;
import com.yy.mobile.framework.revenuesdk.baseapi.PurchaseStatus;
import com.yy.mobile.framework.revenuesdk.baseapi.log.RLog;
import com.yy.mobile.framework.revenuesdk.baseapi.utils.PackageInstallUtil;
import com.yy.mobile.framework.revenuesdk.payapi.IAppPayService;
import com.yy.mobile.framework.revenuesdk.payapi.IPayCallback;
import com.yy.mobile.framework.revenuesdk.payapi.IPaySignCallback;
import com.yy.mobile.framework.revenuesdk.payapi.PayType;
import com.yy.mobile.framework.revenuesdk.payapi.bean.BannerConfigItem;
import com.yy.mobile.framework.revenuesdk.payapi.bean.CurrencyChargeMessage;
import com.yy.mobile.framework.revenuesdk.payapi.bean.FeedbackInfo;
import com.yy.mobile.framework.revenuesdk.payapi.bean.PaySignInfo;
import com.yy.mobile.framework.revenuesdk.payapi.bean.ProductInfo;
import com.yy.mobile.framework.revenuesdk.payapi.bean.SplitMinAmountInfo;
import com.yy.mobile.framework.revenuesdk.payapi.payproxy.IFeedbackServiceProxy;
import java.util.ArrayList;
import java.util.List;
import org.json.JSONArray;
import org.json.JSONObject;
import tv.athena.revenue.api.MiddleRevenueConfig;
import tv.athena.revenue.api.pay.params.PayFlowType;
import tv.athena.revenue.payui.YYPayUIKit;
import tv.athena.revenue.payui.model.NativeOperationParams;
import tv.athena.revenue.payui.model.PayFlowModel;
import tv.athena.revenue.payui.model.PayUIKitConfig;
import tv.athena.revenue.payui.view.AbsViewEventHandler;
import tv.athena.revenue.payui.view.IYYPayAmountView;
import tv.athena.revenue.payui.view.impl.YYPayWebView;
/* loaded from: classes6.dex */
public class m9c {
    public static /* synthetic */ Interceptable $ic;
    public transient /* synthetic */ FieldHolder $fh;

    /* loaded from: classes6.dex */
    public static class a implements IPayCallback<CurrencyChargeMessage> {
        public static /* synthetic */ Interceptable $ic;
        public transient /* synthetic */ FieldHolder $fh;
        public final /* synthetic */ IPayCallback a;

        public a(IPayCallback iPayCallback) {
            Interceptable interceptable = $ic;
            if (interceptable != null) {
                InitContext newInitContext = TitanRuntime.newInitContext();
                newInitContext.initArgs = r2;
                Object[] objArr = {iPayCallback};
                interceptable.invokeUnInit(65536, newInitContext);
                int i = newInitContext.flag;
                if ((i & 1) != 0) {
                    int i2 = i & 2;
                    newInitContext.thisArg = this;
                    interceptable.invokeInitBody(65536, newInitContext);
                    return;
                }
            }
            this.a = iPayCallback;
        }

        /* JADX DEBUG: Method merged with bridge method */
        @Override // com.yy.mobile.framework.revenuesdk.baseapi.IResult
        /* renamed from: a */
        public void onSuccess(CurrencyChargeMessage currencyChargeMessage, PayCallBackBean payCallBackBean) {
            Interceptable interceptable = $ic;
            if (interceptable == null || interceptable.invokeLL(1048576, this, currencyChargeMessage, payCallBackBean) == null) {
                RLog.debug("PayWebViewCallHelper", "onSuccess");
                IPayCallback iPayCallback = this.a;
                if (iPayCallback != null) {
                    iPayCallback.onSuccess(currencyChargeMessage, payCallBackBean);
                }
            }
        }

        @Override // com.yy.mobile.framework.revenuesdk.payapi.IPayCallback
        public void onPayStatus(PurchaseStatus purchaseStatus, PayCallBackBean payCallBackBean) {
            Interceptable interceptable = $ic;
            if (interceptable == null || interceptable.invokeLL(1048579, this, purchaseStatus, payCallBackBean) == null) {
                RLog.debug("PayWebViewCallHelper", "onPayStatus");
            }
        }

        @Override // com.yy.mobile.framework.revenuesdk.baseapi.IResult
        public void onFail(int i, String str, PayCallBackBean payCallBackBean) {
            Interceptable interceptable = $ic;
            if (interceptable == null || interceptable.invokeILL(Constants.METHOD_GET_CONTACTER_INFO_FOR_SESSION, this, i, str, payCallBackBean) == null) {
                RLog.debug("PayWebViewCallHelper", "onFail code:" + i + " failReason:" + str);
            }
        }

        @Override // com.yy.mobile.framework.revenuesdk.payapi.IPayCallback
        public void onPayStart() {
            Interceptable interceptable = $ic;
            if (interceptable == null || interceptable.invokeV(Constants.METHOD_SEND_USER_MSG, this) == null) {
                RLog.debug("PayWebViewCallHelper", "onPayStart");
            }
        }
    }

    /* loaded from: classes6.dex */
    public static class b implements Runnable {
        public static /* synthetic */ Interceptable $ic;
        public transient /* synthetic */ FieldHolder $fh;
        public final /* synthetic */ Activity a;

        public b(Activity activity) {
            Interceptable interceptable = $ic;
            if (interceptable != null) {
                InitContext newInitContext = TitanRuntime.newInitContext();
                newInitContext.initArgs = r2;
                Object[] objArr = {activity};
                interceptable.invokeUnInit(65536, newInitContext);
                int i = newInitContext.flag;
                if ((i & 1) != 0) {
                    int i2 = i & 2;
                    newInitContext.thisArg = this;
                    interceptable.invokeInitBody(65536, newInitContext);
                    return;
                }
            }
            this.a = activity;
        }

        @Override // java.lang.Runnable
        public void run() {
            Interceptable interceptable = $ic;
            if (interceptable == null || interceptable.invokeV(1048576, this) == null) {
                Toast.makeText(this.a.getApplication(), "未安装支付宝", 1).show();
            }
        }
    }

    /* loaded from: classes6.dex */
    public static class c implements IPayCallback {
        public static /* synthetic */ Interceptable $ic;
        public transient /* synthetic */ FieldHolder $fh;
        public final /* synthetic */ Activity a;
        public final /* synthetic */ YYPayWebView b;
        public final /* synthetic */ String c;

        public c(Activity activity, YYPayWebView yYPayWebView, String str) {
            Interceptable interceptable = $ic;
            if (interceptable != null) {
                InitContext newInitContext = TitanRuntime.newInitContext();
                newInitContext.initArgs = r2;
                Object[] objArr = {activity, yYPayWebView, str};
                interceptable.invokeUnInit(65536, newInitContext);
                int i = newInitContext.flag;
                if ((i & 1) != 0) {
                    int i2 = i & 2;
                    newInitContext.thisArg = this;
                    interceptable.invokeInitBody(65536, newInitContext);
                    return;
                }
            }
            this.a = activity;
            this.b = yYPayWebView;
            this.c = str;
        }

        @Override // com.yy.mobile.framework.revenuesdk.baseapi.IResult
        public void onFail(int i, String str, PayCallBackBean payCallBackBean) {
            Interceptable interceptable = $ic;
            if (interceptable == null || interceptable.invokeILL(1048576, this, i, str, payCallBackBean) == null) {
                RLog.info("PayWebViewCallHelper", "onFail code:" + i + " failReason:" + str);
                m9c.i(this.a, this.b, this.c, i, str);
            }
        }

        @Override // com.yy.mobile.framework.revenuesdk.payapi.IPayCallback
        public void onPayStart() {
            Interceptable interceptable = $ic;
            if (interceptable == null || interceptable.invokeV(Constants.METHOD_GET_CONTACTER_INFO_FOR_SESSION, this) == null) {
                RLog.info("PayWebViewCallHelper", "onPayStart");
            }
        }

        @Override // com.yy.mobile.framework.revenuesdk.payapi.IPayCallback
        public void onPayStatus(PurchaseStatus purchaseStatus, PayCallBackBean payCallBackBean) {
            Interceptable interceptable = $ic;
            if (interceptable == null || interceptable.invokeLL(Constants.METHOD_SEND_USER_MSG, this, purchaseStatus, payCallBackBean) == null) {
                RLog.info("PayWebViewCallHelper", "onPayStatus status:" + purchaseStatus);
            }
        }

        @Override // com.yy.mobile.framework.revenuesdk.baseapi.IResult
        public void onSuccess(Object obj, PayCallBackBean payCallBackBean) {
            Interceptable interceptable = $ic;
            if (interceptable == null || interceptable.invokeLL(1048579, this, obj, payCallBackBean) == null) {
                RLog.info("PayWebViewCallHelper", "onSuccess payCallBackBean:" + payCallBackBean);
                m9c.j(this.a, this.b, this.c);
            }
        }
    }

    /* loaded from: classes6.dex */
    public static class d implements Runnable {
        public static /* synthetic */ Interceptable $ic;
        public transient /* synthetic */ FieldHolder $fh;
        public final /* synthetic */ YYPayWebView a;
        public final /* synthetic */ String b;

        public d(YYPayWebView yYPayWebView, String str) {
            Interceptable interceptable = $ic;
            if (interceptable != null) {
                InitContext newInitContext = TitanRuntime.newInitContext();
                newInitContext.initArgs = r2;
                Object[] objArr = {yYPayWebView, str};
                interceptable.invokeUnInit(65536, newInitContext);
                int i = newInitContext.flag;
                if ((i & 1) != 0) {
                    int i2 = i & 2;
                    newInitContext.thisArg = this;
                    interceptable.invokeInitBody(65536, newInitContext);
                    return;
                }
            }
            this.a = yYPayWebView;
            this.b = str;
        }

        @Override // java.lang.Runnable
        public void run() {
            Interceptable interceptable = $ic;
            if (interceptable == null || interceptable.invokeV(1048576, this) == null) {
                this.a.k(this.b);
            }
        }
    }

    /* loaded from: classes6.dex */
    public static class e implements Runnable {
        public static /* synthetic */ Interceptable $ic;
        public transient /* synthetic */ FieldHolder $fh;
        public final /* synthetic */ YYPayWebView a;
        public final /* synthetic */ String b;

        public e(YYPayWebView yYPayWebView, String str) {
            Interceptable interceptable = $ic;
            if (interceptable != null) {
                InitContext newInitContext = TitanRuntime.newInitContext();
                newInitContext.initArgs = r2;
                Object[] objArr = {yYPayWebView, str};
                interceptable.invokeUnInit(65536, newInitContext);
                int i = newInitContext.flag;
                if ((i & 1) != 0) {
                    int i2 = i & 2;
                    newInitContext.thisArg = this;
                    interceptable.invokeInitBody(65536, newInitContext);
                    return;
                }
            }
            this.a = yYPayWebView;
            this.b = str;
        }

        @Override // java.lang.Runnable
        public void run() {
            Interceptable interceptable = $ic;
            if (interceptable == null || interceptable.invokeV(1048576, this) == null) {
                this.a.k(this.b);
            }
        }
    }

    /* loaded from: classes6.dex */
    public static class f implements IPayCallback<CurrencyChargeMessage> {
        public static /* synthetic */ Interceptable $ic;
        public transient /* synthetic */ FieldHolder $fh;
        public final /* synthetic */ IPayCallback a;

        public f(IPayCallback iPayCallback) {
            Interceptable interceptable = $ic;
            if (interceptable != null) {
                InitContext newInitContext = TitanRuntime.newInitContext();
                newInitContext.initArgs = r2;
                Object[] objArr = {iPayCallback};
                interceptable.invokeUnInit(65536, newInitContext);
                int i = newInitContext.flag;
                if ((i & 1) != 0) {
                    int i2 = i & 2;
                    newInitContext.thisArg = this;
                    interceptable.invokeInitBody(65536, newInitContext);
                    return;
                }
            }
            this.a = iPayCallback;
        }

        /* JADX DEBUG: Method merged with bridge method */
        @Override // com.yy.mobile.framework.revenuesdk.baseapi.IResult
        /* renamed from: a */
        public void onSuccess(CurrencyChargeMessage currencyChargeMessage, PayCallBackBean payCallBackBean) {
            Interceptable interceptable = $ic;
            if (interceptable == null || interceptable.invokeLL(1048576, this, currencyChargeMessage, payCallBackBean) == null) {
                RLog.debug("PayWebViewCallHelper", "onSuccess");
                IPayCallback iPayCallback = this.a;
                if (iPayCallback != null) {
                    iPayCallback.onSuccess(currencyChargeMessage, payCallBackBean);
                }
            }
        }

        @Override // com.yy.mobile.framework.revenuesdk.payapi.IPayCallback
        public void onPayStatus(PurchaseStatus purchaseStatus, PayCallBackBean payCallBackBean) {
            Interceptable interceptable = $ic;
            if (interceptable == null || interceptable.invokeLL(1048579, this, purchaseStatus, payCallBackBean) == null) {
                RLog.debug("PayWebViewCallHelper", "onPayStatus");
            }
        }

        @Override // com.yy.mobile.framework.revenuesdk.baseapi.IResult
        public void onFail(int i, String str, PayCallBackBean payCallBackBean) {
            Interceptable interceptable = $ic;
            if (interceptable == null || interceptable.invokeILL(Constants.METHOD_GET_CONTACTER_INFO_FOR_SESSION, this, i, str, payCallBackBean) == null) {
                RLog.debug("PayWebViewCallHelper", "onFail code:" + i + " failReason:" + str);
            }
        }

        @Override // com.yy.mobile.framework.revenuesdk.payapi.IPayCallback
        public void onPayStart() {
            Interceptable interceptable = $ic;
            if (interceptable == null || interceptable.invokeV(Constants.METHOD_SEND_USER_MSG, this) == null) {
                RLog.debug("PayWebViewCallHelper", "onPayStart");
            }
        }
    }

    public static void c(int i, int i2, PayFlowType payFlowType, NativeOperationParams nativeOperationParams) {
        AbsViewEventHandler absViewEventHandler;
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeCommon(65538, null, new Object[]{Integer.valueOf(i), Integer.valueOf(i2), payFlowType, nativeOperationParams}) == null) {
            YYPayUIKit uIKit = YYPayUIKit.getUIKit(i, i2);
            if (uIKit == null) {
                RLog.error("PayWebViewCallHelper", "onNativeOperation null yyPayUIKit", new Object[0]);
            } else if (nativeOperationParams.params == null) {
                RLog.error("PayWebViewCallHelper", "onNativeOperation error h5 params null", new Object[0]);
            } else {
                BannerConfigItem.BannerInfo bannerInfo = new BannerConfigItem.BannerInfo();
                try {
                    JSONObject jSONObject = new JSONObject(nativeOperationParams.params);
                    bannerInfo.id = jSONObject.optString("id");
                    bannerInfo.jumpType = jSONObject.optInt("jumpType");
                    bannerInfo.jumpData = jSONObject.optString("jumpData", "");
                    bannerInfo.imageUrl = jSONObject.optString("imageUrl", "");
                    PayFlowModel payFlowModel = uIKit.getPayFlowModel(payFlowType);
                    if (payFlowModel != null && (absViewEventHandler = payFlowModel.viewEventListener) != null) {
                        absViewEventHandler.onBannerClick(bannerInfo);
                    } else {
                        RLog.error("PayWebViewCallHelper", "onNativeOperation error h5PayFlowModel null", new Object[0]);
                    }
                } catch (Exception e2) {
                    RLog.error("PayWebViewCallHelper", "get bannerInfo error:", e2.getLocalizedMessage());
                }
            }
        }
    }

    public static void d(int i, int i2) {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeII(65539, null, i, i2) == null) {
            YYPayUIKit uIKit = YYPayUIKit.getUIKit(i, i2);
            if (uIKit == null) {
                RLog.error("PayWebViewCallHelper", "onOpenFeedbackPage null yyPayUIKit", new Object[0]);
                return;
            }
            IFeedbackServiceProxy feedbackServiceProxy = uIKit.getFeedbackServiceProxy();
            if (feedbackServiceProxy == null) {
                RLog.error("PayWebViewCallHelper", "onOpenFeedbackPage error proxy null", new Object[0]);
                return;
            }
            FeedbackInfo feedbackInfo = new FeedbackInfo();
            feedbackInfo.appId = i;
            feedbackInfo.userchannel = i2;
            feedbackServiceProxy.openFeedbackPage(feedbackInfo);
        }
    }

    public static void e(int i, int i2, Activity activity, NativeOperationParams nativeOperationParams, IPayCallback<CurrencyChargeMessage> iPayCallback) {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeCommon(InputDeviceCompat.SOURCE_TRACKBALL, null, new Object[]{Integer.valueOf(i), Integer.valueOf(i2), activity, nativeOperationParams, iPayCallback}) == null) {
            YYPayUIKit uIKit = YYPayUIKit.getUIKit(i, i2);
            if (uIKit == null) {
                RLog.error("PayWebViewCallHelper", "onNativeOperation null yyPayUIKit", new Object[0]);
                return;
            }
            RLog.info("PayWebViewCallHelper", "onOpenPayAmountPage params:" + nativeOperationParams);
            uIKit.innerPayAmountDialogForWeb(activity, new IYYPayAmountView.ViewParams(), new f(iPayCallback));
        }
    }

    public static void f(int i, int i2, Activity activity, NativeOperationParams nativeOperationParams, IPayCallback<CurrencyChargeMessage> iPayCallback) {
        MiddleRevenueConfig middleRevenueConfig;
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeCommon(65541, null, new Object[]{Integer.valueOf(i), Integer.valueOf(i2), activity, nativeOperationParams, iPayCallback}) == null) {
            YYPayUIKit uIKit = YYPayUIKit.getUIKit(i, i2);
            if (uIKit == null) {
                RLog.error("PayWebViewCallHelper", "onNativeOperation null yyPayUIKit", new Object[0]);
            } else if (nativeOperationParams.params == null) {
                RLog.error("PayWebViewCallHelper", "onNativeOperation error h5 params null", new Object[0]);
            } else {
                ProductInfo productInfo = new ProductInfo();
                try {
                    JSONObject jSONObject = new JSONObject(nativeOperationParams.params);
                    productInfo.cid = jSONObject.optInt("cid");
                    productInfo.productId = jSONObject.optString("productId", "");
                    productInfo.srcCurrencySymbol = jSONObject.optString("srcCurrencySymbol", "");
                    productInfo.destAmount = jSONObject.optInt("destAmount");
                    productInfo.srcAmount = jSONObject.optDouble("srcAmount", 0.0d);
                    List<SplitMinAmountInfo> l = l(jSONObject.optJSONArray("splitMinAmountConfigs"));
                    int optInt = jSONObject.optInt("customAmount");
                    kbc.b bVar = new kbc.b();
                    PayUIKitConfig payUIKitConfig = uIKit.getPayUIKitConfig();
                    if (payUIKitConfig != null) {
                        middleRevenueConfig = payUIKitConfig.revenueConfig;
                    } else {
                        middleRevenueConfig = null;
                    }
                    if (middleRevenueConfig != null) {
                        bVar.c = new t9c(productInfo, middleRevenueConfig.getCurrencyType());
                    } else {
                        bVar.c = new t9c(productInfo);
                    }
                    s9c s9cVar = new s9c();
                    s9cVar.b = l;
                    s9cVar.a = optInt;
                    RLog.info("PayWebViewCallHelper", "startPayChannelDialog: payAmount:%s", bVar.c + " h5OpenPayParams:" + s9cVar);
                    uIKit.innerPayWayDialogForWeb(activity, s9cVar, bVar, new a(iPayCallback));
                } catch (Exception e2) {
                    RLog.error("PayWebViewCallHelper", "get productInfo error:", e2.getLocalizedMessage());
                }
            }
        }
    }

    public static void k(int i, int i2, Activity activity, NativeOperationParams nativeOperationParams, YYPayWebView yYPayWebView) {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeCommon(65546, null, new Object[]{Integer.valueOf(i), Integer.valueOf(i2), activity, nativeOperationParams, yYPayWebView}) == null) {
            IAppPayService b2 = gac.b(i, i2);
            try {
                JSONObject jSONObject = new JSONObject(nativeOperationParams.params);
                String optString = jSONObject.optString("seq");
                String optString2 = jSONObject.optString("payload");
                String optString3 = jSONObject.optString("payChannel");
                String optString4 = jSONObject.optString("payMethod");
                RLog.info("PayWebViewCallHelper", "openThirdPartPayApp seq:" + optString + " payChannel:" + optString3 + " payMethod:" + optString4 + " payload:" + optString2);
                if (!TextUtils.isEmpty(optString) && !TextUtils.isEmpty(optString2) && !TextUtils.isEmpty(optString3) && !TextUtils.isEmpty(optString4)) {
                    if (b2 == null) {
                        RLog.error("PayWebViewCallHelper", "openThirdPartPayApp error payService is null", new Object[0]);
                        i(activity, yYPayWebView, optString, -1, "payService error");
                        return;
                    }
                    c cVar = new c(activity, yYPayWebView, optString);
                    PayType a2 = uac.a(optString3, optString4);
                    if (a2 == null) {
                        i(activity, yYPayWebView, optString, -1, "h5 payType error");
                        return;
                    } else {
                        b2.requestPay(activity, a2, "", optString2, cVar);
                        return;
                    }
                }
                i(activity, yYPayWebView, optString, -1, "h5 params error");
            } catch (Exception e2) {
                RLog.error("PayWebViewCallHelper", "openThirdPartPayApp error:", e2.getLocalizedMessage());
            }
        }
    }

    public static void g(Activity activity, int i, int i2, NativeOperationParams nativeOperationParams, IPaySignCallback iPaySignCallback) {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeCommon(65542, null, new Object[]{activity, Integer.valueOf(i), Integer.valueOf(i2), nativeOperationParams, iPaySignCallback}) == null) {
            YYPayUIKit uIKit = YYPayUIKit.getUIKit(i, i2);
            if (uIKit == null) {
                RLog.error("PayWebViewCallHelper", "onOpenSignPay null yyPayUIKit", new Object[0]);
            } else if (nativeOperationParams.params == null) {
                RLog.error("PayWebViewCallHelper", "onOpenSignPay error h5 params null", new Object[0]);
            } else if (!PackageInstallUtil.isInstallAlipay(activity.getApplication())) {
                activity.runOnUiThread(new b(activity));
            } else {
                PaySignInfo paySignInfo = new PaySignInfo();
                try {
                    JSONObject jSONObject = new JSONObject(nativeOperationParams.params);
                    paySignInfo.signParams = jSONObject.optString("signParams");
                    paySignInfo.scheme = jSONObject.optString("scheme");
                    uIKit.signPay(activity, paySignInfo, iPaySignCallback);
                } catch (Exception e2) {
                    RLog.error("PayWebViewCallHelper", "onOpenSignPay error:", e2.getLocalizedMessage());
                }
            }
        }
    }

    public static void h(int i, int i2, PayFlowType payFlowType, NativeOperationParams nativeOperationParams) {
        AbsViewEventHandler absViewEventHandler;
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeCommon(65543, null, new Object[]{Integer.valueOf(i), Integer.valueOf(i2), payFlowType, nativeOperationParams}) == null) {
            YYPayUIKit uIKit = YYPayUIKit.getUIKit(i, i2);
            if (uIKit == null) {
                RLog.error("PayWebViewCallHelper", "onNativeOperation null yyPayUIKit", new Object[0]);
                return;
            }
            PayFlowModel payFlowModel = uIKit.getPayFlowModel(payFlowType);
            if (payFlowModel != null && (absViewEventHandler = payFlowModel.viewEventListener) != null) {
                absViewEventHandler.onHandleUrl(nativeOperationParams.params);
            } else {
                RLog.error("PayWebViewCallHelper", "onNativeOperation error h5PayFlowModel null", new Object[0]);
            }
        }
    }

    public static void i(Activity activity, YYPayWebView yYPayWebView, String str, int i, String str2) {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeCommon(65544, null, new Object[]{activity, yYPayWebView, str, Integer.valueOf(i), str2}) == null) {
            if (yYPayWebView == null) {
                RLog.error("PayWebViewCallHelper", "onThirdPartPayFail error yyPayWebView null", new Object[0]);
                return;
            }
            JSONObject jSONObject = new JSONObject();
            try {
                jSONObject.put("state", 0);
                jSONObject.put("seq", str);
                jSONObject.put("code", i);
                jSONObject.put("failReason", str2);
            } catch (Throwable th) {
                RLog.error("PayWebViewCallHelper", th.toString(), new Object[0]);
            }
            String jSONObject2 = jSONObject.toString();
            String str3 = "javascript:onPayResult(" + jSONObject2 + SmallTailInfo.EMOTION_SUFFIX;
            RLog.info("PayWebViewCallHelper", "onThirdPartPayFail jsonMsg:" + jSONObject2 + " jsMethod:" + str3);
            activity.runOnUiThread(new d(yYPayWebView, str3));
        }
    }

    public static void j(Activity activity, YYPayWebView yYPayWebView, String str) {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeLLL(65545, null, activity, yYPayWebView, str) == null) {
            if (yYPayWebView == null) {
                RLog.error("PayWebViewCallHelper", "onThirdPartPaySuccess error yyPayWebView null", new Object[0]);
                return;
            }
            JSONObject jSONObject = new JSONObject();
            try {
                jSONObject.put("state", 1);
                jSONObject.put("seq", str);
            } catch (Throwable th) {
                RLog.error("PayWebViewCallHelper", th.toString(), new Object[0]);
            }
            String jSONObject2 = jSONObject.toString();
            String str2 = "javascript:onPayResult(" + jSONObject2 + SmallTailInfo.EMOTION_SUFFIX;
            RLog.info("PayWebViewCallHelper", "onThirdPartPayFail jsonMsg:" + jSONObject2 + " jsMethod:" + str2);
            activity.runOnUiThread(new e(yYPayWebView, str2));
        }
    }

    public static List<SplitMinAmountInfo> l(JSONArray jSONArray) {
        InterceptResult invokeL;
        Interceptable interceptable = $ic;
        if (interceptable == null || (invokeL = interceptable.invokeL(65547, null, jSONArray)) == null) {
            ArrayList arrayList = new ArrayList();
            if (jSONArray == null) {
                return arrayList;
            }
            int length = jSONArray.length();
            for (int i = 0; i < length; i++) {
                JSONObject optJSONObject = jSONArray.optJSONObject(i);
                if (optJSONObject != null) {
                    SplitMinAmountInfo splitMinAmountInfo = new SplitMinAmountInfo();
                    splitMinAmountInfo.minAmount = optJSONObject.optInt("minAmount");
                    splitMinAmountInfo.splitType = optJSONObject.optInt("type");
                    arrayList.add(splitMinAmountInfo);
                }
            }
            return arrayList;
        }
        return (List) invokeL.objValue;
    }
}
