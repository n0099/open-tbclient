package com.baidu.wallet.paysdk.ui;

import android.os.Build;
import android.os.Bundle;
import android.text.TextUtils;
import android.view.View;
import android.widget.ImageView;
import android.widget.LinearLayout;
import android.widget.RelativeLayout;
import android.widget.TextView;
import com.baidu.apollon.utils.ResUtils;
import com.baidu.wallet.api.Constants;
import com.baidu.wallet.base.widget.SafeKeyBoardEditText;
import com.baidu.wallet.base.widget.SafeScrollView;
import com.baidu.wallet.base.widget.SixNumberPwdView;
import com.baidu.wallet.core.utils.NFCUtil;
import com.baidu.wallet.paysdk.beans.BeanConstants;
import com.baidu.wallet.paysdk.datamodel.PwdRequest;
import com.baidu.wallet.paysdk.storage.PayRequestCache;
import org.json.JSONException;
import org.json.JSONObject;
/* loaded from: classes5.dex */
public abstract class PwdBaseActivity extends PayBaseActivity implements SixNumberPwdView.OnPwdChangedListener {

    /* renamed from: a  reason: collision with root package name */
    public SixNumberPwdView f25981a;
    public String extraFromH5;
    public boolean isOpenHalfScreenPwdVerify = false;
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

    private boolean a(String str) {
        String optString;
        if (!TextUtils.isEmpty(str)) {
            try {
                optString = new JSONObject(str).optString(Constants.HALF_SCREEN_PWD_VERIFY);
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
        PwdRequest pwdRequest = this.mPwdRequest;
        if (pwdRequest == null || pwdRequest.mRequestType != 2) {
            PwdRequest pwdRequest2 = this.mPwdRequest;
            return (pwdRequest2 == null || pwdRequest2.mRequestType != 3) ? 258 : 259;
        }
        return 257;
    }

    public String getPwd() {
        return this.f25981a.getPwd();
    }

    @Override // com.baidu.wallet.paysdk.ui.PayBaseActivity, com.baidu.wallet.core.beans.BeanActivity
    public void handleFailure(int i2, int i3, String str) {
        super.handleFailure(i2, i3, str);
    }

    @Override // com.baidu.wallet.paysdk.ui.PayBaseActivity, com.baidu.wallet.core.beans.BeanActivity
    public void handleResponse(int i2, Object obj, String str) {
    }

    public void hideErrorMsg() {
        this.mErrorTip.setVisibility(4);
    }

    @Override // com.baidu.wallet.core.BaseActivity
    public boolean isWindowNightMode() {
        return false;
    }

    @Override // com.baidu.wallet.paysdk.ui.PayBaseActivity, com.baidu.wallet.paysdk.ui.PayBaseBeanActivity, com.baidu.wallet.core.beans.BeanActivity, com.baidu.wallet.core.BaseActivity, androidx.fragment.app.FragmentActivity, androidx.activity.ComponentActivity, androidx.core.app.ComponentActivity, android.app.Activity
    public void onCreate(Bundle bundle) {
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
            String stringExtra = getIntent().getStringExtra(Constants.HALF_SCREEN_PWD_VERIFY);
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
        this.f25981a = (SixNumberPwdView) findViewById(ResUtils.id(getActivity(), "pwd_input_box"));
        this.mErrorTip = (TextView) findViewById(ResUtils.id(getActivity(), "error_tip"));
        this.mForgetPasswd = findViewById(ResUtils.id(getActivity(), "forget_pwd"));
        hideErrorMsg();
        this.mRootView = (RelativeLayout) findViewById(ResUtils.id(getActivity(), "root_view"));
        this.mScrollView = (SafeScrollView) findViewById(ResUtils.id(getActivity(), "scrollview"));
        SafeKeyBoardEditText safeKeyBoardEditText = (SafeKeyBoardEditText) this.f25981a.findViewById(ResUtils.id(getActivity(), "pwd_input"));
        this.mSafeEditText = safeKeyBoardEditText;
        safeKeyBoardEditText.initSafeKeyBoardParams(this.mRootView, this.mScrollView, safeKeyBoardEditText, false);
        this.mSafeEditText.setGap(20);
        this.mSafeEditText.setDisablePast(true);
        this.f25981a.addSixNumberPwdChangedListenter(this);
        setSafeScrollView(this.mScrollView);
        this.mSafeEditText.requestFocus();
    }

    @Override // com.baidu.wallet.paysdk.ui.PayBaseActivity, com.baidu.wallet.paysdk.ui.PayBaseBeanActivity, com.baidu.wallet.core.BaseActivity, androidx.fragment.app.FragmentActivity, android.app.Activity
    public void onPause() {
        super.onPause();
        if (Build.VERSION.SDK_INT >= 10) {
            NFCUtil.getInstance().disableForegroundDispatch(getActivity(), false);
        }
    }

    @Override // com.baidu.wallet.paysdk.ui.PayBaseActivity, com.baidu.wallet.paysdk.ui.PayBaseBeanActivity, com.baidu.wallet.core.beans.BeanActivity, com.baidu.wallet.core.BaseActivity, androidx.fragment.app.FragmentActivity, android.app.Activity
    public void onResume() {
        super.onResume();
        if (Build.VERSION.SDK_INT >= 10) {
            NFCUtil.getInstance().enableForegroundDispatch(getActivity(), false);
        }
    }

    @Override // com.baidu.wallet.paysdk.ui.PayBaseActivity, com.baidu.wallet.paysdk.ui.PayBaseBeanActivity, com.baidu.wallet.core.BaseActivity, androidx.fragment.app.FragmentActivity, androidx.activity.ComponentActivity, androidx.core.app.ComponentActivity, android.app.Activity
    public void onSaveInstanceState(Bundle bundle) {
        super.onSaveInstanceState(bundle);
        bundle.putSerializable("mPwdRequest", this.mPwdRequest);
    }

    public void resetPwd() {
        this.f25981a.resetPwd();
    }

    public void showErrorMsg(String str) {
        this.mErrorTip.setVisibility(0);
        this.mErrorTip.setText(str);
    }
}
