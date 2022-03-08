package com.baidu.wallet.paysdk.ui;

import android.app.Dialog;
import android.os.Bundle;
import android.text.TextUtils;
import android.view.View;
import androidx.core.view.InputDeviceCompat;
import com.baidu.android.imsdk.internal.Constants;
import com.baidu.pass.main.facesdk.utils.PreferencesUtil;
import com.baidu.titan.sdk.runtime.FieldHolder;
import com.baidu.titan.sdk.runtime.InitContext;
import com.baidu.titan.sdk.runtime.InterceptResult;
import com.baidu.titan.sdk.runtime.Interceptable;
import com.baidu.titan.sdk.runtime.TitanRuntime;
import com.baidu.wallet.base.statistics.PayStatServiceEvent;
import com.baidu.wallet.paysdk.PayCallBackManager;
import com.baidu.wallet.paysdk.beans.BeanConstants;
import com.baidu.wallet.paysdk.contract.PwdPayContract;
import com.baidu.wallet.paysdk.datamodel.BindFastRequest;
import com.baidu.wallet.paysdk.datamodel.DirectPayContentResponse;
import com.baidu.wallet.paysdk.datamodel.PayRequest;
import com.baidu.wallet.paysdk.presenter.f;
import com.baidu.wallet.paysdk.storage.PayDataCache;
import com.baidu.wallet.paysdk.storage.PayRequestCache;
import com.baidu.wallet.paysdk.ui.widget.IdentifyCodeGetFailDialog;
import com.dxmpay.apollon.utils.ResUtils;
import com.dxmpay.wallet.base.widget.dialog.PromptDialog;
import com.dxmpay.wallet.base.widget.dialog.PromptMultiBtnDialog;
import com.dxmpay.wallet.base.widget.dialog.PromptTipDialog;
import com.dxmpay.wallet.core.BaseActivity;
import com.dxmpay.wallet.core.beans.BeanActivity;
import com.dxmpay.wallet.core.utils.LogUtil;
import com.dxmpay.wallet.core.utils.WalletGlobalUtils;
import com.dxmpay.wallet.utils.StatHelper;
import java.io.Serializable;
import java.util.ArrayList;
import java.util.Iterator;
import java.util.LinkedList;
/* loaded from: classes6.dex */
public abstract class PayBaseBeanActivity extends BeanActivity {
    public static /* synthetic */ Interceptable $ic = null;
    public static final int DIALOG_ABANDON_CONFIM = 18;
    public static final int DIALOG_ACCOUNT_LOCKED = 17;
    public static final int DIALOG_AUTH_INFO_UNUSUAL_FOR_FINANCE = 55;
    public static final int DIALOG_CANNOT_DISCOUNT = 35;
    public static final int DIALOG_CARDBALANCE_NOT_ENOUGH = 37;
    public static final int DIALOG_CARD_INFO_NEED_FILL_IN = 40;
    public static final int DIALOG_CARD_INFO_UPDATE_TIP = 34;
    public static final int DIALOG_CARD_NUMBER_MAYBE_ERROR = 33;
    public static final int DIALOG_DATE_PICKER_DIALOG = 39;
    public static final int DIALOG_EXIT_CLIENT = 4;
    public static final int DIALOG_ITP_SMS = 23;
    public static final int DIALOG_LIVING_RETRY = 54;
    public static final int DIALOG_PUBLIC_SECURITY_AUTH_NOT_EXIST = 38;
    public static final int DIALOG_RNAUTH_AGE_BYOND_CERT_ALREADY_BONDED = 41;
    public static final int DIALOG_RNAUTH_NOT_EXIST_LICAI = 49;
    public static final int DIALOG_TIP_CARD_DATE = 56;
    public static final int DIALOG_TIP_CLOSE = 12;
    public static final int DIALOG_TIP_MOBILE = 13;
    public static final int DIALOG_TIP_NAME = 14;
    public static final int DIALOG_USE_OTHER_PAY_METHOND = 36;
    public static final int ERROR_RISK_DIALOG = 53;
    public static final int FLAG_ACTIVE_BIND_CARD = 2;
    public static final int FLAG_AUTH_FLOW = 4;
    public static final int FLAG_PAY_SKD = 1;
    public transient /* synthetic */ FieldHolder $fh;
    public f a;

    public PayBaseBeanActivity() {
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

    public static String a(LinkedList<BaseActivity> linkedList) {
        InterceptResult invokeL;
        Interceptable interceptable = $ic;
        if (interceptable == null || (invokeL = interceptable.invokeL(65537, null, linkedList)) == null) {
            StringBuilder sb = new StringBuilder();
            sb.append(PreferencesUtil.LEFT_MOUNT);
            Iterator<BaseActivity> it = linkedList.iterator();
            while (it.hasNext()) {
                sb.append(it.next().getClass().getSimpleName());
                sb.append(" ");
            }
            sb.append(PreferencesUtil.RIGHT_MOUNT);
            return sb.toString();
        }
        return (String) invokeL.objValue;
    }

    public static synchronized void exitActiveBindCard() {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeV(65538, null) == null) {
            synchronized (PayBaseBeanActivity.class) {
                try {
                    BaseActivity.getTopActivity().getApplicationContext();
                    String str = "exitActiveBindCard. stack size = " + BaseActivity.mActivityStack.size();
                    LogUtil.methodTrace("PayBaseBeanActivity");
                    BaseActivity.clearTasksWithFlag(2);
                    HalfScreenBaseActivity.resetInstanceCount();
                    HalfProtocolScreenBaseActivity.resetInstanceCount();
                }
            }
        }
    }

    public static synchronized void exitAuthFlow() {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeV(65539, null) == null) {
            synchronized (PayBaseBeanActivity.class) {
                BaseActivity.clearTasksWithFlag(4);
                HalfScreenBaseActivity.resetInstanceCount();
            }
        }
    }

    public static synchronized void exitEbpay() {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeV(InputDeviceCompat.SOURCE_TRACKBALL, null) == null) {
            synchronized (PayBaseBeanActivity.class) {
                try {
                    BaseActivity.getTopActivity().getApplicationContext();
                    String str = "method->exitEbpay\n mActivityStack size->" + BaseActivity.mActivityStack.size() + "\nname->" + a(BaseActivity.mActivityStack);
                    LogUtil.methodTrace("PayBaseBeanActivity");
                    BaseActivity.clearTasksWithFlag(1);
                    HalfScreenBaseActivity.resetInstanceCount();
                }
            }
        }
    }

    public f getBindCardFlagDelegate() {
        InterceptResult invokeV;
        Interceptable interceptable = $ic;
        if (interceptable == null || (invokeV = interceptable.invokeV(1048576, this)) == null) {
            if (this.a == null) {
                this.a = new f(this);
            }
            return this.a;
        }
        return (f) invokeV.objValue;
    }

    public ArrayList<String> getCancelPayEventValue(String str) {
        InterceptResult invokeL;
        Interceptable interceptable = $ic;
        if (interceptable == null || (invokeL = interceptable.invokeL(Constants.METHOD_GET_CONTACTER_INFO_FOR_SESSION, this, str)) == null) {
            ArrayList<String> arrayList = new ArrayList<>();
            arrayList.add(str);
            arrayList.add(PayDataCache.getInstance().getInsideTransOrder());
            return arrayList;
        }
        return (ArrayList) invokeL.objValue;
    }

    public void initActionBarExt(String str) {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeL(Constants.METHOD_SEND_USER_MSG, this, str) == null) {
            initActionBar(str);
        }
    }

    @Override // com.dxmpay.wallet.core.beans.BeanActivity
    public void onBeanExecFailureWithErrContent(int i2, int i3, String str, Object obj) {
        PwdPayContract.Presenter presenter;
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeCommon(1048579, this, new Object[]{Integer.valueOf(i2), Integer.valueOf(i3), str, obj}) == null) {
            if ((this instanceof PwdPayActivity) && (presenter = ((PwdPayActivity) this).mPresenter) != null) {
                presenter.handleFailure(i2, i3, str);
            } else {
                super.onBeanExecFailureWithErrContent(i2, i3, str, obj);
            }
        }
    }

    @Override // com.dxmpay.wallet.core.beans.BeanActivity, com.dxmpay.wallet.core.BaseActivity, com.dxmpay.wallet.core.SDKBaseActivity, androidx.fragment.app.FragmentActivity, androidx.activity.ComponentActivity, androidx.core.app.ComponentActivity, android.app.Activity
    public void onCreate(Bundle bundle) {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeL(1048580, this, bundle) == null) {
            super.onCreate(bundle);
            this.mAct = this;
            if (bundle != null) {
                Serializable serializable = bundle.getSerializable("direct_or_userinfo_data");
                if (serializable != null && (serializable instanceof DirectPayContentResponse)) {
                    ((DirectPayContentResponse) serializable).storeResponse(this);
                }
                Serializable serializable2 = bundle.getSerializable("payrequest");
                if (serializable2 != null && (serializable2 instanceof PayRequest)) {
                    PayRequest payRequest = (PayRequest) serializable2;
                    PayRequestCache.getInstance().addBeanRequestToCache(payRequest.getRequestId(), payRequest);
                }
                Serializable serializable3 = bundle.getSerializable("bindfastrequest");
                if (serializable3 == null || !(serializable3 instanceof BindFastRequest)) {
                    return;
                }
                BindFastRequest bindFastRequest = (BindFastRequest) serializable3;
                PayRequestCache.getInstance().addBeanRequestToCache(bindFastRequest.getRequestId(), bindFastRequest);
            }
        }
    }

    @Override // com.dxmpay.wallet.core.BaseActivity, android.app.Activity
    public Dialog onCreateDialog(int i2) {
        InterceptResult invokeI;
        Interceptable interceptable = $ic;
        if (interceptable == null || (invokeI = interceptable.invokeI(1048581, this, i2)) == null) {
            String str = "onCreateDialog. id = " + i2;
            if (i2 != 13) {
                if (i2 != 23) {
                    if (i2 != 34 && i2 != 35) {
                        return super.onCreateDialog(i2);
                    }
                    return new PromptMultiBtnDialog(this);
                }
                return new IdentifyCodeGetFailDialog(getActivity());
            }
            return new PromptTipDialog(getActivity());
        }
        return (Dialog) invokeI.objValue;
    }

    @Override // com.dxmpay.wallet.core.BaseActivity, androidx.fragment.app.FragmentActivity, android.app.Activity
    public void onDestroy() {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeV(1048582, this) == null) {
            super.onDestroy();
        }
    }

    @Override // com.dxmpay.wallet.core.BaseActivity, androidx.fragment.app.FragmentActivity, android.app.Activity
    public void onPause() {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeV(1048583, this) == null) {
            super.onPause();
        }
    }

    @Override // com.dxmpay.wallet.core.BaseActivity, android.app.Activity
    public void onPrepareDialog(int i2, Dialog dialog) {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeIL(InputDeviceCompat.SOURCE_TOUCHPAD, this, i2, dialog) == null) {
            String str = "onPrepareDialog. id = " + i2;
            if (i2 != 4) {
                if (i2 != 12) {
                    super.onPrepareDialog(i2, dialog);
                    return;
                }
                PromptDialog promptDialog = (PromptDialog) dialog;
                promptDialog.setMessage(this.mDialogMsg);
                promptDialog.setCanceledOnTouchOutside(false);
                promptDialog.setPositiveBtn(ResUtils.string(getActivity(), "dxm_ebpay_know"), new View.OnClickListener(this) { // from class: com.baidu.wallet.paysdk.ui.PayBaseBeanActivity.3
                    public static /* synthetic */ Interceptable $ic;
                    public transient /* synthetic */ FieldHolder $fh;
                    public final /* synthetic */ PayBaseBeanActivity a;

                    {
                        Interceptable interceptable2 = $ic;
                        if (interceptable2 != null) {
                            InitContext newInitContext = TitanRuntime.newInitContext();
                            newInitContext.initArgs = r2;
                            Object[] objArr = {this};
                            interceptable2.invokeUnInit(65536, newInitContext);
                            int i3 = newInitContext.flag;
                            if ((i3 & 1) != 0) {
                                int i4 = i3 & 2;
                                newInitContext.thisArg = this;
                                interceptable2.invokeInitBody(65536, newInitContext);
                                return;
                            }
                        }
                        this.a = this;
                    }

                    @Override // android.view.View.OnClickListener
                    public void onClick(View view) {
                        Interceptable interceptable2 = $ic;
                        if (interceptable2 == null || interceptable2.invokeL(1048576, this, view) == null) {
                            WalletGlobalUtils.safeDismissDialog(this.a, 12);
                        }
                    }
                });
                promptDialog.hideNegativeButton();
                return;
            }
            PromptDialog promptDialog2 = (PromptDialog) dialog;
            promptDialog2.setCanceledOnTouchOutside(false);
            String detainmentDesc = PayDataCache.getInstance().getDetainmentDesc();
            if (TextUtils.isEmpty(detainmentDesc)) {
                detainmentDesc = ResUtils.getString(getActivity(), "ebpay_confirm_abandon_pay");
            }
            promptDialog2.setMessage(detainmentDesc);
            StatHelper.statServiceEvent("cancelDoPayAlert", null, detainmentDesc, PayDataCache.getInstance().getInsideTransOrder());
            promptDialog2.setNegativeBtn(ResUtils.string(getActivity(), "dxm_ebpay_cancel"), new View.OnClickListener(this) { // from class: com.baidu.wallet.paysdk.ui.PayBaseBeanActivity.1
                public static /* synthetic */ Interceptable $ic;
                public transient /* synthetic */ FieldHolder $fh;
                public final /* synthetic */ PayBaseBeanActivity a;

                {
                    Interceptable interceptable2 = $ic;
                    if (interceptable2 != null) {
                        InitContext newInitContext = TitanRuntime.newInitContext();
                        newInitContext.initArgs = r2;
                        Object[] objArr = {this};
                        interceptable2.invokeUnInit(65536, newInitContext);
                        int i3 = newInitContext.flag;
                        if ((i3 & 1) != 0) {
                            int i4 = i3 & 2;
                            newInitContext.thisArg = this;
                            interceptable2.invokeInitBody(65536, newInitContext);
                            return;
                        }
                    }
                    this.a = this;
                }

                @Override // android.view.View.OnClickListener
                public void onClick(View view) {
                    Interceptable interceptable2 = $ic;
                    if (interceptable2 == null || interceptable2.invokeL(1048576, this, view) == null) {
                        WalletGlobalUtils.safeDismissDialog(this.a, 4);
                    }
                }
            });
            promptDialog2.setPositiveBtn(ResUtils.string(getActivity(), "ebpay_abandon_pay"), new View.OnClickListener(this) { // from class: com.baidu.wallet.paysdk.ui.PayBaseBeanActivity.2
                public static /* synthetic */ Interceptable $ic;
                public transient /* synthetic */ FieldHolder $fh;
                public final /* synthetic */ PayBaseBeanActivity a;

                {
                    Interceptable interceptable2 = $ic;
                    if (interceptable2 != null) {
                        InitContext newInitContext = TitanRuntime.newInitContext();
                        newInitContext.initArgs = r2;
                        Object[] objArr = {this};
                        interceptable2.invokeUnInit(65536, newInitContext);
                        int i3 = newInitContext.flag;
                        if ((i3 & 1) != 0) {
                            int i4 = i3 & 2;
                            newInitContext.thisArg = this;
                            interceptable2.invokeInitBody(65536, newInitContext);
                            return;
                        }
                    }
                    this.a = this;
                }

                @Override // android.view.View.OnClickListener
                public void onClick(View view) {
                    Interceptable interceptable2 = $ic;
                    if (interceptable2 == null || interceptable2.invokeL(1048576, this, view) == null) {
                        WalletGlobalUtils.safeDismissDialog(this.a, 4);
                        BindFastRequest bindFastRequest = (BindFastRequest) PayRequestCache.getInstance().getRequest(PayRequestCache.BindCategory.Other);
                        if (bindFastRequest != null && bindFastRequest.mBindFrom == 0) {
                            StatHelper.statServiceEvent(PayStatServiceEvent.PAY_BIND_CARD_FAILED, null, StatHelper.SENSOR_ERR_2, "payBindCardCancel");
                            StatHelper.cacheCodeAndMsg(StatHelper.SENSOR_ERR_2, "payBindCardCancel");
                            StatHelper.payEventEndWithValues(PayStatServiceEvent.PAY_BIND_CARD_DURATION, null, new String[0]);
                        }
                        if (!PayDataCache.getInstance().isFromPreCashier()) {
                            StatHelper.statServiceEvent(PayStatServiceEvent.STD_PAY_CANCEL);
                        }
                        PayCallBackManager.callBackClientCancel(this.a, "PayBaseBeanActivity.onPrepareDialog().1");
                    }
                }
            });
        }
    }

    @Override // com.dxmpay.wallet.core.beans.BeanActivity, com.dxmpay.wallet.core.BaseActivity, androidx.fragment.app.FragmentActivity, android.app.Activity
    public void onResume() {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeV(1048585, this) == null) {
            super.onResume();
        }
    }

    @Override // com.dxmpay.wallet.core.BaseActivity, androidx.fragment.app.FragmentActivity, androidx.activity.ComponentActivity, androidx.core.app.ComponentActivity, android.app.Activity
    public void onSaveInstanceState(Bundle bundle) {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeL(1048586, this, bundle) == null) {
            DirectPayContentResponse payResponse = PayDataCache.getInstance().getPayResponse();
            if (payResponse != null) {
                bundle.putSerializable("direct_or_userinfo_data", payResponse);
            }
            PayRequest payRequest = (PayRequest) PayRequestCache.getInstance().getBeanRequestFromCache(BeanConstants.REQUEST_ID_PAY);
            if (payRequest != null) {
                bundle.putSerializable("payrequest", payRequest);
            }
            BindFastRequest bindFastRequest = (BindFastRequest) PayRequestCache.getInstance().getBeanRequestFromCache(PayRequestCache.BindCategory.Other.name());
            if (bindFastRequest != null) {
                bundle.putSerializable("bindfastrequest", bindFastRequest);
            }
            super.onSaveInstanceState(bundle);
        }
    }

    public void setFlagActiveBindCard() {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeV(1048587, this) == null) {
            this.mFlag |= 2;
        }
    }

    public void setFlagAuthFlow() {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeV(1048588, this) == null) {
            this.mFlag |= 4;
        }
    }

    public void setFlagPaySdk() {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeV(1048589, this) == null) {
            this.mFlag |= 1;
        }
    }
}
