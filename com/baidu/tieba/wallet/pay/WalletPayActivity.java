package com.baidu.tieba.wallet.pay;

import android.content.DialogInterface;
import android.content.Intent;
import android.graphics.drawable.Drawable;
import android.net.Uri;
import android.os.Bundle;
import android.os.Handler;
import android.os.Message;
import android.view.KeyEvent;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.TextView;
import androidx.core.view.InputDeviceCompat;
import c.a.d.c.g.a;
import c.a.d.f.m.e;
import c.a.d.f.p.m;
import c.a.d.f.p.n;
import c.a.q0.r.j0.b;
import c.a.q0.r.t.a;
import c.a.q0.v.c;
import com.baidu.adp.framework.MessageManager;
import com.baidu.adp.framework.listener.HttpMessageListener;
import com.baidu.adp.framework.message.CustomMessage;
import com.baidu.adp.framework.message.CustomResponsedMessage;
import com.baidu.adp.framework.message.HttpMessage;
import com.baidu.adp.framework.message.HttpResponsedMessage;
import com.baidu.adp.framework.message.ResponsedMessage;
import com.baidu.adp.lib.stats.BdStatisticsManager;
import com.baidu.adp.lib.util.StringUtils;
import com.baidu.android.imsdk.internal.Constants;
import com.baidu.android.lbspay.BaiduLBSPay;
import com.baidu.android.lbspay.LBSPayBack;
import com.baidu.android.lbspay.network.INetwork;
import com.baidu.android.lbspay.view.PayChannelController;
import com.baidu.android.pay.PayCallBack;
import com.baidu.nadcore.exp.ADConfigError;
import com.baidu.tbadk.BaseActivity;
import com.baidu.tbadk.TbConfig;
import com.baidu.tbadk.TbPageContext;
import com.baidu.tbadk.core.TbadkCoreApplication;
import com.baidu.tbadk.core.atomData.MemberPayResultActivityConfig;
import com.baidu.tbadk.core.atomData.PayWalletActivityConfig;
import com.baidu.tbadk.core.atomData.WalletPayResultActivityConfig;
import com.baidu.tbadk.core.dialog.BdToast;
import com.baidu.tbadk.core.frameworkData.CmdConfigHttp;
import com.baidu.tbadk.core.util.SkinManager;
import com.baidu.tbadk.core.util.TiebaStatic;
import com.baidu.tbadk.core.util.UrlManager;
import com.baidu.tbadk.pay.PayConfig;
import com.baidu.tbadk.pay.ResponseGetPayinfoMessage;
import com.baidu.tbadk.task.TbHttpMessageTask;
import com.baidu.tieba.R;
import com.baidu.tieba.frs.itemtab.gamecode.GameCodeGetResponseMsg;
import com.baidu.tieba.wallet.WalletParamsFactory;
import com.baidu.tieba.wallet.WalletStatisticKey;
import com.baidu.tieba.wallet.pay.WalletPayViewController;
import com.baidu.titan.sdk.runtime.FieldHolder;
import com.baidu.titan.sdk.runtime.InitContext;
import com.baidu.titan.sdk.runtime.InterceptResult;
import com.baidu.titan.sdk.runtime.Interceptable;
import com.baidu.titan.sdk.runtime.TitanRuntime;
import com.baidu.wallet.api.BaiduWallet;
import com.baidu.wallet.core.beans.BeanManager;
import com.yy.mobile.framework.revenuesdk.baseapi.reporter.EventAlias;
import java.util.Date;
import java.util.HashMap;
import org.json.JSONException;
import org.json.JSONObject;
import tbclient.GetOrder.DataRes;
import tbclient.GetOrder.NotifyPopup;
/* loaded from: classes6.dex */
public class WalletPayActivity extends BaseActivity<WalletPayActivity> {
    public static /* synthetic */ Interceptable $ic = null;
    public static final int PAY_STATUS_FAIL = 1;
    public static final int PAY_STATUS_NO_ORDER = 3;
    public static final int PAY_STATUS_NO_SUC = 2;
    public static final int PAY_STATUS_SUC = 0;
    public static final String PAY_TYPE_SDK = "sdk";
    public static final String PAY_TYPE_URL = "url";
    public transient /* synthetic */ FieldHolder $fh;
    public final String PAY_DIALOG_ERROR_KEY;
    public final int PAY_DIALOG_ERROR_NO;
    public final int RESEND_INTERVAL;
    public final int SEND_GETINFO_MSG;
    public int checkViewWidth;
    public boolean hasResendGetMsg;
    public int isFromDecreaseGiftStepStrategy;
    public boolean isPayDialog;
    public WalletPayViewController.ClickCallback mCallback;
    public DataRes mDataRes;
    public TextView mDescView;
    public View mDialogRootView;
    public HttpMessageListener mGetPayinfoListener;
    public Handler mHandler;
    public boolean mIsPaying;
    public a mNetMessagelistener;
    public String mOrderId;
    public GetOrderModel mOrderModel;
    public boolean mOtherApkSelected;
    public TextView mOtherApkView;
    public LBSPayBack mPayCallback;
    public PayConfig mPayConfig;
    public TextView mTitleView;
    public TextView mUpdateTipView;
    public TextView mVersionView;
    public WalletPayViewController mViewController;

    public WalletPayActivity() {
        Interceptable interceptable = $ic;
        if (interceptable != null) {
            InitContext newInitContext = TitanRuntime.newInitContext();
            interceptable.invokeUnInit(65536, newInitContext);
            int i2 = newInitContext.flag;
            if ((i2 & 1) != 0) {
                int i3 = i2 & 2;
                newInitContext.thisArg = this;
                interceptable.invokeInitBody(65536, newInitContext);
                return;
            }
        }
        this.SEND_GETINFO_MSG = 1;
        this.RESEND_INTERVAL = 5000;
        this.PAY_DIALOG_ERROR_NO = 210009;
        this.PAY_DIALOG_ERROR_KEY = "pay_dialog_error_key";
        this.mIsPaying = false;
        this.hasResendGetMsg = false;
        this.isPayDialog = false;
        this.mOtherApkSelected = true;
        this.checkViewWidth = 0;
        this.isFromDecreaseGiftStepStrategy = 0;
        this.mHandler = new Handler(this) { // from class: com.baidu.tieba.wallet.pay.WalletPayActivity.1
            public static /* synthetic */ Interceptable $ic;
            public transient /* synthetic */ FieldHolder $fh;
            public final /* synthetic */ WalletPayActivity this$0;

            {
                Interceptable interceptable2 = $ic;
                if (interceptable2 != null) {
                    InitContext newInitContext2 = TitanRuntime.newInitContext();
                    newInitContext2.initArgs = r2;
                    Object[] objArr = {this};
                    interceptable2.invokeUnInit(65536, newInitContext2);
                    int i4 = newInitContext2.flag;
                    if ((i4 & 1) != 0) {
                        int i5 = i4 & 2;
                        newInitContext2.thisArg = this;
                        interceptable2.invokeInitBody(65536, newInitContext2);
                        return;
                    }
                }
                this.this$0 = this;
            }

            @Override // android.os.Handler
            public void handleMessage(Message message) {
                Interceptable interceptable2 = $ic;
                if (interceptable2 == null || interceptable2.invokeL(1048576, this, message) == null) {
                    super.handleMessage(message);
                    if (message.what != 1) {
                        return;
                    }
                    this.this$0.sendGetPayinfoMessage();
                }
            }
        };
        this.mCallback = new WalletPayViewController.ClickCallback(this) { // from class: com.baidu.tieba.wallet.pay.WalletPayActivity.2
            public static /* synthetic */ Interceptable $ic;
            public transient /* synthetic */ FieldHolder $fh;
            public final /* synthetic */ WalletPayActivity this$0;

            {
                Interceptable interceptable2 = $ic;
                if (interceptable2 != null) {
                    InitContext newInitContext2 = TitanRuntime.newInitContext();
                    newInitContext2.initArgs = r2;
                    Object[] objArr = {this};
                    interceptable2.invokeUnInit(65536, newInitContext2);
                    int i4 = newInitContext2.flag;
                    if ((i4 & 1) != 0) {
                        int i5 = i4 & 2;
                        newInitContext2.thisArg = this;
                        interceptable2.invokeInitBody(65536, newInitContext2);
                        return;
                    }
                }
                this.this$0 = this;
            }

            @Override // com.baidu.tieba.wallet.pay.WalletPayViewController.ClickCallback
            public void doFinish() {
                Interceptable interceptable2 = $ic;
                if (interceptable2 == null || interceptable2.invokeV(1048576, this) == null) {
                    this.this$0.finishSelf();
                }
            }

            @Override // com.baidu.tieba.wallet.pay.WalletPayViewController.ClickCallback
            public void doPay(String str) {
                Interceptable interceptable2 = $ic;
                if (interceptable2 == null || interceptable2.invokeL(Constants.METHOD_GET_CONTACTER_INFO_FOR_SESSION, this, str) == null) {
                    this.this$0.doPayWithChannel(str);
                }
            }
        };
        this.mGetPayinfoListener = new HttpMessageListener(this, CmdConfigHttp.GETPAYINFO_CMD) { // from class: com.baidu.tieba.wallet.pay.WalletPayActivity.4
            public static /* synthetic */ Interceptable $ic;
            public transient /* synthetic */ FieldHolder $fh;
            public final /* synthetic */ WalletPayActivity this$0;

            /* JADX WARN: 'super' call moved to the top of the method (can break code semantics) */
            {
                super(r8);
                Interceptable interceptable2 = $ic;
                if (interceptable2 != null) {
                    InitContext newInitContext2 = TitanRuntime.newInitContext();
                    newInitContext2.initArgs = r2;
                    Object[] objArr = {this, Integer.valueOf(r8)};
                    interceptable2.invokeUnInit(65536, newInitContext2);
                    int i4 = newInitContext2.flag;
                    if ((i4 & 1) != 0) {
                        int i5 = i4 & 2;
                        super(((Integer) newInitContext2.callArgs[0]).intValue());
                        newInitContext2.thisArg = this;
                        interceptable2.invokeInitBody(65536, newInitContext2);
                        return;
                    }
                }
                this.this$0 = this;
            }

            /* JADX DEBUG: Method merged with bridge method */
            @Override // com.baidu.adp.framework.listener.MessageListener
            public void onMessage(HttpResponsedMessage httpResponsedMessage) {
                Interceptable interceptable2 = $ic;
                if (interceptable2 == null || interceptable2.invokeL(1048576, this, httpResponsedMessage) == null) {
                    if (httpResponsedMessage == null || httpResponsedMessage.getCmd() != 1001505) {
                        this.this$0.finishSelf();
                        return;
                    }
                    int statusCode = httpResponsedMessage.getStatusCode();
                    int error = httpResponsedMessage.getError();
                    ResponseGetPayinfoMessage responseGetPayinfoMessage = (ResponseGetPayinfoMessage) httpResponsedMessage;
                    if (statusCode == 200 && error == 0) {
                        if (responseGetPayinfoMessage.getPayInfoResultData() != null) {
                            if (this.this$0.mPayConfig != null) {
                                this.this$0.mPayConfig.orderCompleteTime = responseGetPayinfoMessage.getPayInfoResultData().getCreateTime();
                            }
                            if (responseGetPayinfoMessage.getPayInfoResultData().getPay_status() == 2) {
                                if (!this.this$0.hasResendGetMsg) {
                                    this.this$0.hasResendGetMsg = true;
                                    this.this$0.mHandler.sendMessageDelayed(this.this$0.mHandler.obtainMessage(1), 5000L);
                                    return;
                                }
                                this.this$0.showResult(Boolean.TRUE);
                                return;
                            } else if (responseGetPayinfoMessage.getPayInfoResultData().getPay_status() == 0) {
                                this.this$0.showResult(Boolean.TRUE);
                                return;
                            } else if (responseGetPayinfoMessage.getPayInfoResultData().getPay_status() == 1) {
                                WalletPayActivity walletPayActivity = this.this$0;
                                walletPayActivity.createPayDebugLog("getpayinfo", statusCode, EventAlias.PayEventAlias.PAY_FAIL, error, "logid = " + responseGetPayinfoMessage.logid);
                                this.this$0.showResult(Boolean.FALSE);
                                return;
                            } else if (responseGetPayinfoMessage.getPayInfoResultData().getPay_status() == 3) {
                                WalletPayActivity walletPayActivity2 = this.this$0;
                                walletPayActivity2.createPayDebugLog("getpayinfo", statusCode, "没有订单", error, "logid = " + responseGetPayinfoMessage.logid);
                                this.this$0.showResult(Boolean.FALSE);
                                return;
                            } else {
                                WalletPayActivity walletPayActivity3 = this.this$0;
                                walletPayActivity3.createPayDebugLog("getpayinfo", statusCode, "", error, "logid = " + responseGetPayinfoMessage.logid);
                                this.this$0.showResult(Boolean.FALSE);
                                return;
                            }
                        }
                        return;
                    }
                    WalletPayActivity walletPayActivity4 = this.this$0;
                    String errorString = httpResponsedMessage.getErrorString();
                    walletPayActivity4.createPayDebugLog("getpayinfo", statusCode, errorString, error, "logid = " + responseGetPayinfoMessage.logid);
                    this.this$0.showResult(Boolean.FALSE);
                }
            }
        };
        this.mNetMessagelistener = new a(this, CmdConfigHttp.CMD_GET_ORDER, 303043) { // from class: com.baidu.tieba.wallet.pay.WalletPayActivity.5
            public static /* synthetic */ Interceptable $ic;
            public transient /* synthetic */ FieldHolder $fh;
            public final /* synthetic */ WalletPayActivity this$0;

            /* JADX WARN: 'super' call moved to the top of the method (can break code semantics) */
            {
                super(r9, r10);
                Interceptable interceptable2 = $ic;
                if (interceptable2 != null) {
                    InitContext newInitContext2 = TitanRuntime.newInitContext();
                    newInitContext2.initArgs = r2;
                    Object[] objArr = {this, Integer.valueOf(r9), Integer.valueOf(r10)};
                    interceptable2.invokeUnInit(65536, newInitContext2);
                    int i4 = newInitContext2.flag;
                    if ((i4 & 1) != 0) {
                        int i5 = i4 & 2;
                        Object[] objArr2 = newInitContext2.callArgs;
                        super(((Integer) objArr2[0]).intValue(), ((Integer) objArr2[1]).intValue());
                        newInitContext2.thisArg = this;
                        interceptable2.invokeInitBody(65536, newInitContext2);
                        return;
                    }
                }
                this.this$0 = this;
            }

            @Override // c.a.d.c.g.a
            public void onMessage(ResponsedMessage<?> responsedMessage) {
                DataRes data;
                Interceptable interceptable2 = $ic;
                if (interceptable2 == null || interceptable2.invokeL(1048576, this, responsedMessage) == null) {
                    this.this$0.mIsPaying = false;
                    if (responsedMessage == null) {
                        this.this$0.showToast(R.string.pay_fail);
                        this.this$0.createPayDebugLog("getOrder", -1, "ResponsedMessage is null", -1, "");
                        this.this$0.finishSelf();
                        return;
                    }
                    if (!responsedMessage.hasError() && responsedMessage.getError() == 0) {
                        data = responsedMessage instanceof ResponsedGetOrderHttpMessage ? ((ResponsedGetOrderHttpMessage) responsedMessage).getData() : null;
                        if (responsedMessage instanceof ResponsedGetOrderSocketMessage) {
                            data = ((ResponsedGetOrderSocketMessage) responsedMessage).getData();
                        }
                        if (data != null) {
                            this.this$0.mOrderId = data.orderId;
                            this.this$0.mDataRes = data;
                            if (this.this$0.mDataRes != null) {
                                if (!this.this$0.mViewController.isValidData(this.this$0.mDataRes.pay_channel) || "url".equalsIgnoreCase(this.this$0.mDataRes.call_type)) {
                                    this.this$0.mViewController.showPayingStatus();
                                    this.this$0.payByWallet();
                                    this.this$0.finish();
                                    return;
                                }
                                this.this$0.mViewController.hideLoadingView();
                                this.this$0.mViewController.setData(this.this$0.mDataRes);
                                return;
                            }
                            this.this$0.showToast(R.string.pay_fail);
                            this.this$0.finishSelf();
                            return;
                        }
                        this.this$0.showToast(R.string.pay_fail);
                        this.this$0.createPayDebugLog("getOrder", -1, ADConfigError.REASON_NULL_DATA, responsedMessage.getError(), "");
                        this.this$0.finishSelf();
                        return;
                    }
                    if (responsedMessage.getError() == 210009) {
                        data = responsedMessage instanceof ResponsedGetOrderHttpMessage ? ((ResponsedGetOrderHttpMessage) responsedMessage).getData() : null;
                        if (responsedMessage instanceof ResponsedGetOrderSocketMessage) {
                            data = ((ResponsedGetOrderSocketMessage) responsedMessage).getData();
                        }
                        if (data != null) {
                            this.this$0.showPayErrorDialog(data.popup);
                        }
                    } else {
                        this.this$0.showToast(StringUtils.isNull(responsedMessage.getErrorString()) ? this.this$0.getResources().getString(R.string.neterror) : responsedMessage.getErrorString());
                        this.this$0.finishSelf();
                    }
                    this.this$0.createPayDebugLog("getOrder", responsedMessage instanceof ResponsedGetOrderHttpMessage ? ((ResponsedGetOrderHttpMessage) responsedMessage).getStatusCode() : -1, responsedMessage.getErrorString(), responsedMessage.getError(), "");
                }
            }
        };
        this.mPayCallback = new LBSPayBack(this) { // from class: com.baidu.tieba.wallet.pay.WalletPayActivity.14
            public static /* synthetic */ Interceptable $ic;
            public transient /* synthetic */ FieldHolder $fh;
            public final /* synthetic */ WalletPayActivity this$0;

            {
                Interceptable interceptable2 = $ic;
                if (interceptable2 != null) {
                    InitContext newInitContext2 = TitanRuntime.newInitContext();
                    newInitContext2.initArgs = r2;
                    Object[] objArr = {this};
                    interceptable2.invokeUnInit(65536, newInitContext2);
                    int i4 = newInitContext2.flag;
                    if ((i4 & 1) != 0) {
                        int i5 = i4 & 2;
                        newInitContext2.thisArg = this;
                        interceptable2.invokeInitBody(65536, newInitContext2);
                        return;
                    }
                }
                this.this$0 = this;
            }

            @Override // com.baidu.android.lbspay.LBSPayBack
            public void onPayResult(int i4, String str) {
                Interceptable interceptable2 = $ic;
                if (interceptable2 == null || interceptable2.invokeIL(1048576, this, i4, str) == null) {
                    if (i4 == 0) {
                        this.this$0.sendGetPayinfoMessage();
                        TiebaStatic.log("c10123");
                    } else if (i4 == 2) {
                        e.a().post(new Runnable(this) { // from class: com.baidu.tieba.wallet.pay.WalletPayActivity.14.1
                            public static /* synthetic */ Interceptable $ic;
                            public transient /* synthetic */ FieldHolder $fh;
                            public final /* synthetic */ AnonymousClass14 this$1;

                            {
                                Interceptable interceptable3 = $ic;
                                if (interceptable3 != null) {
                                    InitContext newInitContext2 = TitanRuntime.newInitContext();
                                    newInitContext2.initArgs = r2;
                                    Object[] objArr = {this};
                                    interceptable3.invokeUnInit(65536, newInitContext2);
                                    int i5 = newInitContext2.flag;
                                    if ((i5 & 1) != 0) {
                                        int i6 = i5 & 2;
                                        newInitContext2.thisArg = this;
                                        interceptable3.invokeInitBody(65536, newInitContext2);
                                        return;
                                    }
                                }
                                this.this$1 = this;
                            }

                            @Override // java.lang.Runnable
                            public void run() {
                                Interceptable interceptable3 = $ic;
                                if (interceptable3 == null || interceptable3.invokeV(1048576, this) == null) {
                                    WalletPayActivity walletPayActivity = this.this$1.this$0;
                                    walletPayActivity.showToast(walletPayActivity.getResources().getString(R.string.pay_cancel));
                                }
                            }
                        });
                        this.this$0.finishSelf();
                    } else if (i4 != 3) {
                    } else {
                        WalletPayActivity walletPayActivity = this.this$0;
                        walletPayActivity.showToast(walletPayActivity.getResources().getString(R.string.pay_fail));
                        this.this$0.createPayDebugLog("", -1, "fail_code LBSPayInner.STATE_CODE_FAILD", 3, "钱包SDK返回支付失败");
                        this.this$0.finishSelf();
                    }
                }
            }
        };
    }

    /* JADX INFO: Access modifiers changed from: private */
    public void createPayDebugLog(String str, int i2, String str2, int i3, String str3) {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeCommon(65554, this, new Object[]{str, Integer.valueOf(i2), str2, Integer.valueOf(i3), str3}) == null) {
            c.a.d.f.n.a statsItem = BdStatisticsManager.getInstance().getStatsItem("dbg");
            statsItem.b("requestMethod", str);
            statsItem.b("eventType", "requestfail");
            statsItem.c("response_code", Integer.valueOf(i2));
            statsItem.b(GameCodeGetResponseMsg.PARAM_ERROR_MSG, str2);
            statsItem.c("error_code", Integer.valueOf(i3));
            statsItem.b("extra_msg", str3);
            statsItem.b("uid", TbadkCoreApplication.getCurrentAccount());
            BdStatisticsManager.getInstance().debug("TiebaPayFail", statsItem);
        }
    }

    /* JADX INFO: Access modifiers changed from: private */
    public void doPayWithChannel(String str) {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeL(65555, this, str) == null) {
            try {
                JSONObject jSONObject = new JSONObject(BaiduLBSPay.getInstance().getReqData(this));
                jSONObject.put("token", INetwork.LBS_HOST);
                jSONObject.put("payChannel", str);
                BaiduLBSPay.getInstance().doCallFrontCashierPay(getPageContext().getPageActivity(), null, this.mPayCallback, WalletParamsFactory.buildWalletParams(this.mDataRes), jSONObject.toString());
            } catch (JSONException e2) {
                e2.printStackTrace();
            }
        }
    }

    /* JADX INFO: Access modifiers changed from: private */
    public void finishSelf() {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeV(65556, this) == null) {
            finish();
        }
    }

    private void initBundle(Bundle bundle) {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeL(65557, this, bundle) == null) {
            if (bundle != null) {
                this.mPayConfig = (PayConfig) bundle.getSerializable(PayWalletActivityConfig.PAY_CONFIG);
            } else {
                Intent intent = getPageContext().getPageActivity().getIntent();
                if (intent != null) {
                    this.mPayConfig = (PayConfig) intent.getSerializableExtra(PayWalletActivityConfig.PAY_CONFIG);
                }
            }
            PayConfig payConfig = this.mPayConfig;
            if (payConfig == null) {
                showToast(R.string.pay_fail);
                finishSelf();
                return;
            }
            this.isFromDecreaseGiftStepStrategy = payConfig.isFromDecreaseGiftStepStrategy();
        }
    }

    private void loadPayChannelView(HashMap<String, String> hashMap) {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeL(65558, this, hashMap) == null) {
            BaiduLBSPay.getInstance().doPolymerPay(getPageContext().getPageActivity(), this.mPayCallback, hashMap);
        }
    }

    /* JADX INFO: Access modifiers changed from: private */
    public void payByWallet() {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeV(65559, this) == null) {
            if ("url".equalsIgnoreCase(this.mDataRes.call_type)) {
                if (!StringUtils.isNull(this.mDataRes.pay_url)) {
                    try {
                        Uri parse = Uri.parse(this.mDataRes.pay_url);
                        if (StringUtils.isNull(parse.getQueryParameter("titlebar"))) {
                            parse = parse.buildUpon().appendQueryParameter("titlebar", "0").build();
                        }
                        UrlManager.getInstance().dealOneLink((TbPageContext<?>) getPageContext(), new String[]{parse.toString()}, true);
                    } catch (Exception unused) {
                        createPayDebugLog("", -1, "mDataRes.pay_url parse error", -1, "h5方式打开钱包");
                    }
                } else {
                    showToast(R.string.pay_fail);
                    createPayDebugLog("", -1, "mDataRes.pay_url is null", -1, "h5方式打开钱包");
                }
                finishSelf();
                return;
            }
            loadPayChannelView(WalletParamsFactory.buildWalletParams(this.mDataRes));
        }
    }

    /* JADX INFO: Access modifiers changed from: private */
    public void refreshOtherApkViewState() {
        Drawable drawable;
        Interceptable interceptable = $ic;
        if (!(interceptable == null || interceptable.invokeV(65560, this) == null) || this.mOtherApkView == null) {
            return;
        }
        if (this.mOtherApkSelected) {
            this.mOtherApkSelected = false;
            drawable = SkinManager.getDrawable(R.drawable.btn_dailog_choose_d);
        } else {
            this.mOtherApkSelected = true;
            drawable = SkinManager.getDrawable(R.drawable.btn_dailog_choose_s);
        }
        if (drawable != null) {
            int i2 = this.checkViewWidth;
            drawable.setBounds(0, 0, i2, i2);
        }
        this.mOtherApkView.setCompoundDrawables(drawable, null, null, null);
    }

    private void registerGetPayinfoListener() {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeV(65561, this) == null) {
            TbHttpMessageTask tbHttpMessageTask = new TbHttpMessageTask(CmdConfigHttp.GETPAYINFO_CMD, TbConfig.SERVER_ADDRESS + TbConfig.URL_GETPAYINFO);
            tbHttpMessageTask.setResponsedClass(ResponseGetPayinfoMessage.class);
            MessageManager.getInstance().registerTask(tbHttpMessageTask);
            registerListener(this.mGetPayinfoListener);
        }
    }

    /* JADX WARN: Removed duplicated region for block: B:20:0x0040  */
    /* JADX WARN: Removed duplicated region for block: B:21:0x0049  */
    /*
        Code decompiled incorrectly, please refer to instructions dump.
    */
    private void sendGetOrderMessage() {
        String optString;
        Interceptable interceptable = $ic;
        if (!(interceptable == null || interceptable.invokeV(65562, this) == null) || this.mOrderModel == null || this.mPayConfig == null || this.mIsPaying) {
            return;
        }
        String reqData = BaiduLBSPay.getInstance().getReqData(this);
        if (!StringUtils.isNull(reqData)) {
            try {
                optString = new JSONObject(reqData).optString("ua");
            } catch (JSONException e2) {
                e2.printStackTrace();
            }
            this.mOrderModel.setWalletSdkUa(optString);
            if (!this.mOrderModel.sendMessage(this.mPayConfig)) {
                this.mIsPaying = true;
                this.mViewController.showLoadingView();
                return;
            }
            showToast(R.string.pay_fail);
            finishSelf();
            return;
        }
        optString = "";
        this.mOrderModel.setWalletSdkUa(optString);
        if (!this.mOrderModel.sendMessage(this.mPayConfig)) {
        }
    }

    /* JADX INFO: Access modifiers changed from: private */
    public void sendGetPayinfoMessage() {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeV(65563, this) == null) {
            String str = this.mOrderId;
            HttpMessage httpMessage = new HttpMessage(CmdConfigHttp.GETPAYINFO_CMD);
            httpMessage.setTag(getUniqueId());
            httpMessage.addParam("pay_id", str);
            httpMessage.setExtra(String.valueOf(this.mPayConfig.getTBeanNum()));
            sendMessage(httpMessage);
        }
    }

    /* JADX INFO: Access modifiers changed from: private */
    public void showPayErrorDialog(NotifyPopup notifyPopup) {
        Interceptable interceptable = $ic;
        if (!(interceptable == null || interceptable.invokeL(65564, this, notifyPopup) == null) || notifyPopup == null) {
            return;
        }
        if (notifyPopup.popup_times.intValue() == 0) {
            if (notifyPopup.popup_type.intValue() == 1) {
                showSimplePayErrorDialog(notifyPopup);
                return;
            } else if (notifyPopup.popup_type.intValue() == 2) {
                showFullPayErrorDialog(notifyPopup);
                return;
            } else {
                finishSelf();
                return;
            }
        }
        b k = b.k();
        int l = k.l("pay_dialog_error_key" + notifyPopup.popup_id, 0);
        if (l < notifyPopup.popup_times.intValue()) {
            b k2 = b.k();
            k2.w("pay_dialog_error_key" + notifyPopup.popup_id, l + 1);
            if (notifyPopup.popup_type.intValue() == 1) {
                showSimplePayErrorDialog(notifyPopup);
                return;
            } else if (notifyPopup.popup_type.intValue() == 2) {
                showFullPayErrorDialog(notifyPopup);
                return;
            } else {
                finishSelf();
                return;
            }
        }
        finishSelf();
    }

    private String toChineseNumber(String str) {
        InterceptResult invokeL;
        String str2;
        Interceptable interceptable = $ic;
        if (interceptable == null || (invokeL = interceptable.invokeL(65565, this, str)) == null) {
            try {
                switch (Integer.parseInt(str)) {
                    case 1:
                        str2 = "一";
                        break;
                    case 2:
                        str2 = "二";
                        break;
                    case 3:
                        str2 = "三";
                        break;
                    case 4:
                        str2 = "四";
                        break;
                    case 5:
                        str2 = "五";
                        break;
                    case 6:
                        str2 = "六";
                        break;
                    case 7:
                        str2 = "七";
                        break;
                    case 8:
                        str2 = "八";
                        break;
                    case 9:
                        str2 = "九";
                        break;
                    case 10:
                        str2 = "十";
                        break;
                    case 11:
                        str2 = "十一";
                        break;
                    case 12:
                        str2 = "十二";
                        break;
                    default:
                        return "";
                }
                return str2;
            } catch (NumberFormatException e2) {
                e2.printStackTrace();
                return "";
            }
        }
        return (String) invokeL.objValue;
    }

    private void walletDoPay(String str) {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeL(65566, this, str) == null) {
            if (StringUtils.isNull(str)) {
                showToast(R.string.pay_fail);
                finishSelf();
                return;
            }
            BaiduWallet.getInstance().doPay(getPageContext().getPageActivity(), str, new PayCallBack(this) { // from class: com.baidu.tieba.wallet.pay.WalletPayActivity.3
                public static /* synthetic */ Interceptable $ic;
                public transient /* synthetic */ FieldHolder $fh;
                public final /* synthetic */ WalletPayActivity this$0;

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
                        if (i2 == 0) {
                            this.this$0.showPaySuccessDialog();
                        } else if (i2 != 1) {
                            this.this$0.finishSelf();
                        } else {
                            this.this$0.showToast(R.string.pay_fail);
                            this.this$0.finishSelf();
                        }
                    }
                }
            });
        }
    }

    @Override // com.baidu.tbadk.BaseActivity, android.app.Activity
    public void onActivityResult(int i2, int i3, Intent intent) {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeIIL(1048576, this, i2, i3, intent) == null) {
            super.onActivityResult(i2, i3, intent);
            if (intent != null) {
                if (intent.getBooleanExtra("rebuy", false)) {
                    finish();
                    return;
                }
                Intent intent2 = new Intent();
                intent2.putExtra("success", true);
                setResult(-1, intent2);
                finish();
            }
        }
    }

    @Override // com.baidu.tbadk.BaseActivity
    public void onChangeSkinType(int i2) {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeI(Constants.METHOD_GET_CONTACTER_INFO_FOR_SESSION, this, i2) == null) {
            super.onChangeSkinType(i2);
            WalletPayViewController walletPayViewController = this.mViewController;
            if (walletPayViewController != null) {
                walletPayViewController.onChangeSkinType();
            }
            TextView textView = this.mTitleView;
            if (textView != null) {
                SkinManager.setViewTextColor(textView, (int) R.color.CAM_X0105);
            }
            TextView textView2 = this.mVersionView;
            if (textView2 != null) {
                SkinManager.setViewTextColor(textView2, (int) R.color.CAM_X0105);
            }
            TextView textView3 = this.mUpdateTipView;
            if (textView3 != null) {
                SkinManager.setViewTextColor(textView3, (int) R.color.CAM_X0105);
            }
            TextView textView4 = this.mDescView;
            if (textView4 != null) {
                SkinManager.setViewTextColor(textView4, (int) R.color.CAM_X0105);
            }
            TextView textView5 = this.mOtherApkView;
            if (textView5 != null) {
                SkinManager.setViewTextColor(textView5, (int) R.color.CAM_X0108);
            }
        }
    }

    @Override // com.baidu.adp.base.BdBaseActivity, android.view.View.OnClickListener
    public void onClick(View view) {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeL(Constants.METHOD_SEND_USER_MSG, this, view) == null) {
            super.onClick(view);
        }
    }

    @Override // com.baidu.tbadk.BaseActivity, com.baidu.adp.base.BdBaseActivity, android.app.Activity
    public void onCreate(Bundle bundle) {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeL(1048579, this, bundle) == null) {
            this.mPayConfig = (PayConfig) getIntent().getSerializableExtra(PayWalletActivityConfig.PAY_CONFIG);
            setIsAddSwipeBackLayout(false);
            setUseStyleImmersiveSticky(false);
            super.onCreate(bundle);
            initBundle(bundle);
            registerListener(this.mNetMessagelistener);
            registerGetPayinfoListener();
            PayActivityStatic.initBaiduWallet();
            if (this.mPayConfig.getPayType() == 3) {
                walletDoPay(this.mPayConfig.mOrderInfo);
            } else {
                this.mViewController = new WalletPayViewController(this, this.mCallback, this.mPayConfig);
                this.mOrderModel = new GetOrderModel(this);
                sendGetOrderMessage();
            }
            TiebaStatic.log("c10119");
            if (this.mPayConfig.getPayType() == 1) {
                TiebaStatic.log(WalletStatisticKey.KEY_PURCHASE_MEMBER_VISIT);
            } else if (this.mPayConfig.getPayType() == 2) {
                TiebaStatic.log(WalletStatisticKey.KEY_PURCHASE_TDOU_VISIT);
            }
        }
    }

    @Override // com.baidu.tbadk.BaseActivity, com.baidu.adp.base.BdBaseActivity, android.app.Activity
    public void onDestroy() {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeV(1048580, this) == null) {
            super.onDestroy();
            BeanManager.getInstance().removeAllBeans(PayChannelController.BEAN_TAG);
            this.mHandler.removeMessages(1);
            this.mDialogRootView = null;
            WalletPayViewController walletPayViewController = this.mViewController;
            if (walletPayViewController != null) {
                walletPayViewController.destroy();
            }
        }
    }

    @Override // com.baidu.tbadk.BaseActivity, android.app.Activity, android.view.KeyEvent.Callback
    public boolean onKeyDown(int i2, KeyEvent keyEvent) {
        InterceptResult invokeIL;
        Interceptable interceptable = $ic;
        if (interceptable == null || (invokeIL = interceptable.invokeIL(1048581, this, i2, keyEvent)) == null) {
            if (4 == i2) {
                finishSelf();
            }
            return super.onKeyDown(i2, keyEvent);
        }
        return invokeIL.booleanValue;
    }

    @Override // com.baidu.tbadk.BaseActivity, com.baidu.adp.base.BdBaseActivity, android.app.Activity
    public void onResume() {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeV(1048582, this) == null) {
            super.onResume();
            WalletPayViewController walletPayViewController = this.mViewController;
            if (walletPayViewController == null || !walletPayViewController.isPaying()) {
                return;
            }
            this.mViewController.resetPayStatus();
        }
    }

    @Override // android.app.Activity
    public void onSaveInstanceState(Bundle bundle) {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeL(1048583, this, bundle) == null) {
            if (bundle == null) {
                bundle = new Bundle();
            }
            bundle.putSerializable(PayWalletActivityConfig.PAY_CONFIG, this.mPayConfig);
            super.onSaveInstanceState(bundle);
        }
    }

    @Override // android.app.Activity
    public void overridePendingTransition(int i2, int i3) {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeII(InputDeviceCompat.SOURCE_TOUCHPAD, this, i2, i3) == null) {
            super.overridePendingTransition(R.anim.wallet_fade_in, R.anim.wallet_fade_out);
        }
    }

    public void showFullPayErrorDialog(NotifyPopup notifyPopup) {
        String str;
        String str2;
        Interceptable interceptable = $ic;
        if (!(interceptable == null || interceptable.invokeL(1048585, this, notifyPopup) == null) || notifyPopup == null) {
            return;
        }
        if (this.mDialogRootView == null) {
            this.checkViewWidth = n.f(getActivity(), R.dimen.ds40);
            View inflate = LayoutInflater.from(getActivity()).inflate(R.layout.pay_error_dialog_view, (ViewGroup) null);
            this.mDialogRootView = inflate;
            this.mTitleView = (TextView) inflate.findViewById(R.id.error_pay_dialog_title);
            this.mVersionView = (TextView) this.mDialogRootView.findViewById(R.id.error_pay_dialog_size);
            this.mUpdateTipView = (TextView) this.mDialogRootView.findViewById(R.id.error_pay_dialog_hint);
            this.mDescView = (TextView) this.mDialogRootView.findViewById(R.id.error_pay_dialog_log);
            TextView textView = (TextView) this.mDialogRootView.findViewById(R.id.need_extra_app_wrapper);
            this.mOtherApkView = textView;
            textView.setOnClickListener(new View.OnClickListener(this) { // from class: com.baidu.tieba.wallet.pay.WalletPayActivity.10
                public static /* synthetic */ Interceptable $ic;
                public transient /* synthetic */ FieldHolder $fh;
                public final /* synthetic */ WalletPayActivity this$0;

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

                @Override // android.view.View.OnClickListener
                public void onClick(View view) {
                    Interceptable interceptable2 = $ic;
                    if (!(interceptable2 == null || interceptable2.invokeL(1048576, this, view) == null) || view == null) {
                        return;
                    }
                    this.this$0.refreshOtherApkViewState();
                }
            });
        }
        String str3 = notifyPopup.app_version + "/" + ((notifyPopup.app_size.intValue() / 1024) / 1024) + "M";
        this.mUpdateTipView.setText(notifyPopup.hint);
        this.mDescView.setText(notifyPopup.changelogs);
        if (!m.isEmpty(notifyPopup.appendix_text) && !m.isEmpty(notifyPopup.appendix_link)) {
            this.mOtherApkView.setVisibility(0);
            this.mOtherApkView.setText(notifyPopup.appendix_text);
            if (notifyPopup.appendix_optional.intValue() == 0) {
                this.mOtherApkSelected = false;
            } else {
                this.mOtherApkSelected = true;
            }
            refreshOtherApkViewState();
        } else {
            this.mOtherApkView.setVisibility(8);
        }
        if (StringUtils.isNull(notifyPopup.n_btn_text)) {
            str = getResources().getString(R.string.cancel);
        } else {
            str = notifyPopup.n_btn_text;
        }
        if (StringUtils.isNull(notifyPopup.y_btn_text)) {
            str2 = getResources().getString(R.string.update_right_now);
        } else {
            str2 = notifyPopup.y_btn_text;
        }
        c.a.q0.r.t.a aVar = new c.a.q0.r.t.a(getActivity());
        aVar.setContentViewSize(1);
        aVar.setCanceledOnTouchOutside(false);
        aVar.setContentView(this.mDialogRootView);
        aVar.setOnKeyListener(new DialogInterface.OnKeyListener(this) { // from class: com.baidu.tieba.wallet.pay.WalletPayActivity.11
            public static /* synthetic */ Interceptable $ic;
            public transient /* synthetic */ FieldHolder $fh;
            public final /* synthetic */ WalletPayActivity this$0;

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

            @Override // android.content.DialogInterface.OnKeyListener
            public boolean onKey(DialogInterface dialogInterface, int i2, KeyEvent keyEvent) {
                InterceptResult invokeLIL;
                Interceptable interceptable2 = $ic;
                if (interceptable2 == null || (invokeLIL = interceptable2.invokeLIL(1048576, this, dialogInterface, i2, keyEvent)) == null) {
                    if (4 == i2) {
                        dialogInterface.dismiss();
                        this.this$0.finishSelf();
                        return false;
                    }
                    return false;
                }
                return invokeLIL.booleanValue;
            }
        });
        aVar.setNegativeButton(str, new a.e(this) { // from class: com.baidu.tieba.wallet.pay.WalletPayActivity.12
            public static /* synthetic */ Interceptable $ic;
            public transient /* synthetic */ FieldHolder $fh;
            public final /* synthetic */ WalletPayActivity this$0;

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

            @Override // c.a.q0.r.t.a.e
            public void onClick(c.a.q0.r.t.a aVar2) {
                Interceptable interceptable2 = $ic;
                if (interceptable2 == null || interceptable2.invokeL(1048576, this, aVar2) == null) {
                    aVar2.dismiss();
                    this.this$0.finishSelf();
                }
            }
        });
        aVar.setPositiveButton(str2, new a.e(this, notifyPopup) { // from class: com.baidu.tieba.wallet.pay.WalletPayActivity.13
            public static /* synthetic */ Interceptable $ic;
            public transient /* synthetic */ FieldHolder $fh;
            public final /* synthetic */ WalletPayActivity this$0;
            public final /* synthetic */ NotifyPopup val$data;

            {
                Interceptable interceptable2 = $ic;
                if (interceptable2 != null) {
                    InitContext newInitContext = TitanRuntime.newInitContext();
                    newInitContext.initArgs = r2;
                    Object[] objArr = {this, notifyPopup};
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
                this.val$data = notifyPopup;
            }

            @Override // c.a.q0.r.t.a.e
            public void onClick(c.a.q0.r.t.a aVar2) {
                Interceptable interceptable2 = $ic;
                if (interceptable2 == null || interceptable2.invokeL(1048576, this, aVar2) == null) {
                    if (!m.isEmpty(this.val$data.y_btn_link)) {
                        c.q().B("app_update" + new Date().getTime(), this.val$data.y_btn_link, "tieba" + new Date().getTime(), null);
                    }
                    if (!m.isEmpty(this.val$data.appendix_text) && this.this$0.mOtherApkSelected && !m.isEmpty(this.val$data.appendix_link)) {
                        c.q().B("app_update_extra" + new Date().getTime(), this.val$data.appendix_link, "tiebaextra" + new Date().getTime(), null);
                    }
                    aVar2.dismiss();
                    this.this$0.finishSelf();
                }
            }
        });
        aVar.create(getPageContext());
        aVar.show();
    }

    public c.a.q0.r.t.a showPaySuccessDialog() {
        InterceptResult invokeV;
        Interceptable interceptable = $ic;
        if (interceptable == null || (invokeV = interceptable.invokeV(1048586, this)) == null) {
            c.a.q0.r.t.a aVar = new c.a.q0.r.t.a(getPageContext().getPageActivity());
            aVar.setCanceledOnTouchOutside(false);
            aVar.setOnKeyListener(new DialogInterface.OnKeyListener(this) { // from class: com.baidu.tieba.wallet.pay.WalletPayActivity.6
                public static /* synthetic */ Interceptable $ic;
                public transient /* synthetic */ FieldHolder $fh;
                public final /* synthetic */ WalletPayActivity this$0;

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

                @Override // android.content.DialogInterface.OnKeyListener
                public boolean onKey(DialogInterface dialogInterface, int i2, KeyEvent keyEvent) {
                    InterceptResult invokeLIL;
                    Interceptable interceptable2 = $ic;
                    if (interceptable2 == null || (invokeLIL = interceptable2.invokeLIL(1048576, this, dialogInterface, i2, keyEvent)) == null) {
                        if (i2 == 4) {
                            dialogInterface.dismiss();
                            this.this$0.finishSelf();
                            return false;
                        }
                        return false;
                    }
                    return invokeLIL.booleanValue;
                }
            });
            aVar.setOnCalcelListener(new DialogInterface.OnCancelListener(this) { // from class: com.baidu.tieba.wallet.pay.WalletPayActivity.7
                public static /* synthetic */ Interceptable $ic;
                public transient /* synthetic */ FieldHolder $fh;
                public final /* synthetic */ WalletPayActivity this$0;

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

                @Override // android.content.DialogInterface.OnCancelListener
                public void onCancel(DialogInterface dialogInterface) {
                    Interceptable interceptable2 = $ic;
                    if (interceptable2 == null || interceptable2.invokeL(1048576, this, dialogInterface) == null) {
                        this.this$0.finishSelf();
                    }
                }
            });
            aVar.create(getPageContext());
            aVar.show();
            return aVar;
        }
        return (c.a.q0.r.t.a) invokeV.objValue;
    }

    public void showResult(Boolean bool) {
        PayConfig payConfig;
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeL(1048587, this, bool) == null) {
            WalletPayViewController walletPayViewController = this.mViewController;
            if (walletPayViewController != null) {
                walletPayViewController.payResult(bool.booleanValue());
            }
            if (this.mPayConfig.getFrom() == 4) {
                if (bool.booleanValue()) {
                    MessageManager.getInstance().sendMessage(new CustomMessage(2002001, new MemberPayResultActivityConfig(getPageContext().getPageActivity(), toChineseNumber(this.mPayConfig.getPropsMon()))));
                    MessageManager.getInstance().dispatchResponsedMessage(new CustomResponsedMessage(2016526, null));
                    finish();
                    return;
                }
                BdToast.c(getActivity(), getResources().getString(R.string.pay_fail)).q();
                finish();
            } else if (this.isFromDecreaseGiftStepStrategy != 0) {
                finish();
            } else {
                DataRes dataRes = this.mDataRes;
                if (dataRes != null && (payConfig = this.mPayConfig) != null) {
                    payConfig.mOrderInfo = dataRes.orderId;
                }
                MessageManager.getInstance().sendMessage(new CustomMessage(2002001, new WalletPayResultActivityConfig(getPageContext().getPageActivity(), bool.booleanValue(), this.isPayDialog, this.mPayConfig)));
                finishSelf();
            }
        }
    }

    public void showSimplePayErrorDialog(NotifyPopup notifyPopup) {
        String str;
        String str2;
        Interceptable interceptable = $ic;
        if (!(interceptable == null || interceptable.invokeL(1048588, this, notifyPopup) == null) || notifyPopup == null) {
            return;
        }
        c.a.q0.r.t.a aVar = new c.a.q0.r.t.a(getActivity());
        aVar.setMessage(notifyPopup.hint);
        aVar.setCanceledOnTouchOutside(false);
        if (StringUtils.isNull(notifyPopup.n_btn_text)) {
            str = getResources().getString(R.string.cancel);
        } else {
            str = notifyPopup.n_btn_text;
        }
        if (StringUtils.isNull(notifyPopup.y_btn_text)) {
            str2 = getResources().getString(R.string.update_right_now);
        } else {
            str2 = notifyPopup.y_btn_text;
        }
        aVar.setNegativeButton(str, new a.e(this) { // from class: com.baidu.tieba.wallet.pay.WalletPayActivity.8
            public static /* synthetic */ Interceptable $ic;
            public transient /* synthetic */ FieldHolder $fh;
            public final /* synthetic */ WalletPayActivity this$0;

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

            @Override // c.a.q0.r.t.a.e
            public void onClick(c.a.q0.r.t.a aVar2) {
                Interceptable interceptable2 = $ic;
                if (interceptable2 == null || interceptable2.invokeL(1048576, this, aVar2) == null) {
                    aVar2.dismiss();
                    this.this$0.finishSelf();
                }
            }
        });
        aVar.setPositiveButton(str2, new a.e(this, notifyPopup) { // from class: com.baidu.tieba.wallet.pay.WalletPayActivity.9
            public static /* synthetic */ Interceptable $ic;
            public transient /* synthetic */ FieldHolder $fh;
            public final /* synthetic */ WalletPayActivity this$0;
            public final /* synthetic */ NotifyPopup val$data;

            {
                Interceptable interceptable2 = $ic;
                if (interceptable2 != null) {
                    InitContext newInitContext = TitanRuntime.newInitContext();
                    newInitContext.initArgs = r2;
                    Object[] objArr = {this, notifyPopup};
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
                this.val$data = notifyPopup;
            }

            @Override // c.a.q0.r.t.a.e
            public void onClick(c.a.q0.r.t.a aVar2) {
                Interceptable interceptable2 = $ic;
                if (interceptable2 == null || interceptable2.invokeL(1048576, this, aVar2) == null) {
                    if (!m.isEmpty(this.val$data.y_btn_link)) {
                        c.q().B("app_update", this.val$data.y_btn_link, "tieba", null);
                    }
                    aVar2.dismiss();
                    this.this$0.finishSelf();
                }
            }
        });
        aVar.create(getPageContext());
        aVar.show();
    }
}
