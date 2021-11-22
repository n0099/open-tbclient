package com.baidu.wallet.paysdk.ui;

import android.os.Build;
import android.os.Bundle;
import android.text.TextUtils;
import android.view.View;
import android.widget.ImageView;
import android.widget.LinearLayout;
import android.widget.RelativeLayout;
import android.widget.TextView;
import androidx.core.view.InputDeviceCompat;
import com.baidu.android.imsdk.internal.Constants;
import com.baidu.titan.sdk.runtime.FieldHolder;
import com.baidu.titan.sdk.runtime.InitContext;
import com.baidu.titan.sdk.runtime.InterceptResult;
import com.baidu.titan.sdk.runtime.Interceptable;
import com.baidu.titan.sdk.runtime.TitanRuntime;
import com.baidu.wallet.paysdk.beans.BeanConstants;
import com.baidu.wallet.paysdk.datamodel.PwdRequest;
import com.baidu.wallet.paysdk.storage.PayRequestCache;
import com.dxmpay.apollon.utils.ResUtils;
import com.dxmpay.wallet.base.widget.SafeKeyBoardEditText;
import com.dxmpay.wallet.base.widget.SafeScrollView;
import com.dxmpay.wallet.base.widget.SixNumberPwdView;
import com.dxmpay.wallet.core.utils.NFCUtil;
import org.json.JSONException;
import org.json.JSONObject;
/* loaded from: classes10.dex */
public abstract class PwdBaseActivity extends PayBaseActivity implements SixNumberPwdView.OnPwdChangedListener {
    public static /* synthetic */ Interceptable $ic;
    public transient /* synthetic */ FieldHolder $fh;

    /* renamed from: a  reason: collision with root package name */
    public SixNumberPwdView f61157a;
    public String extraFromH5;
    public boolean isOpenHalfScreenPwdVerify;
    public TextView mErrorTip;
    public View mForgetPasswd;
    public ImageView mLeftImageGoback;
    public PwdRequest mPwdRequest;
    public RelativeLayout mRootView;
    public SafeKeyBoardEditText mSafeEditText;
    public SafeScrollView mScrollView;
    public TextView mSubTip;
    public LinearLayout mSubTipWrap;
    public TextView mTip;

    public PwdBaseActivity() {
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
        this.isOpenHalfScreenPwdVerify = false;
    }

    private boolean a(String str) {
        InterceptResult invokeL;
        String optString;
        Interceptable interceptable = $ic;
        if (interceptable != null && (invokeL = interceptable.invokeL(65537, this, str)) != null) {
            return invokeL.booleanValue;
        }
        if (!TextUtils.isEmpty(str)) {
            try {
                optString = new JSONObject(str).optString("half_screen_pwd_verify");
            } catch (JSONException e2) {
                e2.printStackTrace();
            }
            return !TextUtils.isEmpty(optString) && TextUtils.equals(optString, "true");
        }
        optString = "false";
        if (TextUtils.isEmpty(optString)) {
            return false;
        }
    }

    public int getMobilePwdBeanId() {
        InterceptResult invokeV;
        Interceptable interceptable = $ic;
        if (interceptable == null || (invokeV = interceptable.invokeV(1048576, this)) == null) {
            PwdRequest pwdRequest = this.mPwdRequest;
            if (pwdRequest == null || pwdRequest.mRequestType != 2) {
                PwdRequest pwdRequest2 = this.mPwdRequest;
                return (pwdRequest2 == null || pwdRequest2.mRequestType != 3) ? 258 : 259;
            }
            return 257;
        }
        return invokeV.intValue;
    }

    public String getPwd() {
        InterceptResult invokeV;
        Interceptable interceptable = $ic;
        return (interceptable == null || (invokeV = interceptable.invokeV(Constants.METHOD_GET_CONTACTER_INFO_FOR_SESSION, this)) == null) ? this.f61157a.getPwd() : (String) invokeV.objValue;
    }

    @Override // com.baidu.wallet.paysdk.ui.PayBaseActivity, com.dxmpay.wallet.core.beans.BeanActivity
    public void handleFailure(int i2, int i3, String str) {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeIIL(Constants.METHOD_SEND_USER_MSG, this, i2, i3, str) == null) {
            super.handleFailure(i2, i3, str);
        }
    }

    @Override // com.baidu.wallet.paysdk.ui.PayBaseActivity, com.dxmpay.wallet.core.beans.BeanActivity
    public void handleResponse(int i2, Object obj, String str) {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeILL(1048579, this, i2, obj, str) == null) {
        }
    }

    public void hideErrorMsg() {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeV(1048580, this) == null) {
            this.mErrorTip.setVisibility(4);
        }
    }

    @Override // com.dxmpay.wallet.core.BaseActivity
    public boolean isWindowNightMode() {
        InterceptResult invokeV;
        Interceptable interceptable = $ic;
        if (interceptable == null || (invokeV = interceptable.invokeV(1048581, this)) == null) {
            return false;
        }
        return invokeV.booleanValue;
    }

    @Override // com.baidu.wallet.paysdk.ui.PayBaseActivity, com.baidu.wallet.paysdk.ui.PayBaseBeanActivity, com.dxmpay.wallet.core.beans.BeanActivity, com.dxmpay.wallet.core.BaseActivity, com.dxmpay.wallet.core.SDKBaseActivity, androidx.fragment.app.FragmentActivity, androidx.activity.ComponentActivity, androidx.core.app.ComponentActivity, android.app.Activity
    public void onCreate(Bundle bundle) {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeL(1048582, this, bundle) == null) {
            super.onCreate(bundle);
            setIsShowMultiWindowTips(true);
            if (bundle != null) {
                this.mPwdRequest = (PwdRequest) bundle.getSerializable("mPwdRequest");
            } else {
                this.mPwdRequest = (PwdRequest) PayRequestCache.getInstance().getBeanRequestFromCache(BeanConstants.REQUEST_ID_PWD);
            }
            if (this.mPwdRequest != null) {
                PayRequestCache.getInstance().addBeanRequestToCache(this.mPwdRequest.getRequestId(), this.mPwdRequest);
            }
            if (getIntent() != null) {
                String stringExtra = getIntent().getStringExtra("half_screen_pwd_verify");
                this.extraFromH5 = stringExtra;
                this.isOpenHalfScreenPwdVerify = a(stringExtra);
            }
            if (this.isOpenHalfScreenPwdVerify) {
                setContentView(ResUtils.layout(getActivity(), "wallet_cashdesk_set_half_screen_pwd_activity"));
                this.mLeftImageGoback = (ImageView) findViewById(ResUtils.id(getActivity(), "pwd_left_img_goback"));
                this.mSubTipWrap = (LinearLayout) findViewById(ResUtils.id(getActivity(), "pwd_sub_tip_wrap"));
            } else {
                setContentView(ResUtils.layout(getActivity(), "wallet_cashdesk_set_pwd_activity"));
            }
            this.mTip = (TextView) findViewById(ResUtils.id(getActivity(), "pwd_tip"));
            this.mSubTip = (TextView) findViewById(ResUtils.id(getActivity(), "pwd_sub_tip"));
            this.f61157a = (SixNumberPwdView) findViewById(ResUtils.id(getActivity(), "pwd_input_box"));
            this.mErrorTip = (TextView) findViewById(ResUtils.id(getActivity(), "error_tip"));
            this.mForgetPasswd = findViewById(ResUtils.id(getActivity(), "forget_pwd"));
            hideErrorMsg();
            this.mRootView = (RelativeLayout) findViewById(ResUtils.id(getActivity(), "root_view"));
            this.mScrollView = (SafeScrollView) findViewById(ResUtils.id(getActivity(), "scrollview"));
            SafeKeyBoardEditText safeKeyBoardEditText = (SafeKeyBoardEditText) this.f61157a.findViewById(ResUtils.id(getActivity(), "pwd_input"));
            this.mSafeEditText = safeKeyBoardEditText;
            safeKeyBoardEditText.initSafeKeyBoardParams(this.mRootView, this.mScrollView, safeKeyBoardEditText, false);
            this.mSafeEditText.setGap(20);
            this.mSafeEditText.setDisablePast(true);
            this.f61157a.addSixNumberPwdChangedListenter(this);
            setSafeScrollView(this.mScrollView);
            this.mSafeEditText.requestFocus();
        }
    }

    @Override // com.baidu.wallet.paysdk.ui.PayBaseActivity, com.baidu.wallet.paysdk.ui.PayBaseBeanActivity, com.dxmpay.wallet.core.BaseActivity, androidx.fragment.app.FragmentActivity, android.app.Activity
    public void onPause() {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeV(1048583, this) == null) {
            super.onPause();
            if (Build.VERSION.SDK_INT >= 10) {
                NFCUtil.getInstance().disableForegroundDispatch(getActivity(), false);
            }
        }
    }

    @Override // com.baidu.wallet.paysdk.ui.PayBaseActivity, com.baidu.wallet.paysdk.ui.PayBaseBeanActivity, com.dxmpay.wallet.core.beans.BeanActivity, com.dxmpay.wallet.core.BaseActivity, androidx.fragment.app.FragmentActivity, android.app.Activity
    public void onResume() {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeV(InputDeviceCompat.SOURCE_TOUCHPAD, this) == null) {
            super.onResume();
            if (Build.VERSION.SDK_INT >= 10) {
                NFCUtil.getInstance().enableForegroundDispatch(getActivity(), false);
            }
        }
    }

    @Override // com.baidu.wallet.paysdk.ui.PayBaseActivity, com.baidu.wallet.paysdk.ui.PayBaseBeanActivity, com.dxmpay.wallet.core.BaseActivity, androidx.fragment.app.FragmentActivity, androidx.activity.ComponentActivity, androidx.core.app.ComponentActivity, android.app.Activity
    public void onSaveInstanceState(Bundle bundle) {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeL(1048585, this, bundle) == null) {
            super.onSaveInstanceState(bundle);
            bundle.putSerializable("mPwdRequest", this.mPwdRequest);
        }
    }

    public void resetPwd() {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeV(1048586, this) == null) {
            this.f61157a.resetPwd();
        }
    }

    public void showErrorMsg(String str) {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeL(1048587, this, str) == null) {
            this.mErrorTip.setVisibility(0);
            this.mErrorTip.setText(str);
        }
    }
}
