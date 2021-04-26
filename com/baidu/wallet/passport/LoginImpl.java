package com.baidu.wallet.passport;

import android.content.Context;
import android.text.TextUtils;
import com.baidu.sapi2.PassportSDK;
import com.baidu.sapi2.SapiAccount;
import com.baidu.sapi2.dto.WebLoginDTO;
import com.baidu.sapi2.shell.listener.WebAuthListener;
import com.baidu.sapi2.shell.result.WebAuthResult;
import com.baidu.wallet.api.BaiduWalletDelegate;
import com.baidu.wallet.api.ILoginBackListener;
import com.baidu.wallet.api.IWalletLoginListener;
import com.baidu.wallet.base.datamodel.AccountManager;
import com.baidu.wallet.core.NoProguard;
import com.baidu.wallet.utils.JsonUtil;
import java.util.Map;
/* loaded from: classes5.dex */
public class LoginImpl implements IWalletLoginListener, NoProguard {
    public static String TAG = "LoginImpl";
    public Context mContext;

    public LoginImpl(Context context) {
        if (context == null) {
            return;
        }
        this.mContext = context.getApplicationContext();
    }

    private void loginBaidu(final ILoginBackListener iLoginBackListener, String str) {
        PassportSDK passportSDK = PassportSDK.getInstance();
        WebLoginDTO webLoginDTO = new WebLoginDTO();
        webLoginDTO.loginType = WebLoginDTO.EXTRA_LOGIN_WITH_SMS;
        if (!TextUtils.isEmpty(str)) {
            JsonUtil.jsonStringToNameValuePairList(str, webLoginDTO.extraParams);
        }
        passportSDK.startLogin(this.mContext, new WebAuthListener() { // from class: com.baidu.wallet.passport.LoginImpl.1
            /* JADX DEBUG: Method merged with bridge method */
            @Override // com.baidu.sapi2.callback.SapiCallback
            /* renamed from: a */
            public void onSuccess(WebAuthResult webAuthResult) {
                ILoginBackListener iLoginBackListener2 = iLoginBackListener;
                if (iLoginBackListener2 != null) {
                    iLoginBackListener2.onSuccess(0, "");
                }
            }

            /* JADX DEBUG: Method merged with bridge method */
            @Override // com.baidu.sapi2.callback.SapiCallback
            /* renamed from: b */
            public void onFailure(WebAuthResult webAuthResult) {
                ILoginBackListener iLoginBackListener2 = iLoginBackListener;
                if (iLoginBackListener2 != null) {
                    iLoginBackListener2.onFail(webAuthResult.getResultCode(), webAuthResult.getResultMsg());
                }
            }

            @Override // com.baidu.sapi2.shell.listener.WebAuthListener
            public void beforeSuccess(SapiAccount sapiAccount) {
            }
        }, webLoginDTO);
    }

    @Override // com.baidu.wallet.api.IWalletLoginListener
    public Map<String, String> getLoginData(String str) {
        return PassLoginUtil.getInstance().getLoginData(this.mContext, str);
    }

    @Override // com.baidu.wallet.api.IWalletLoginListener
    public String getLoginStoken(String str) {
        return PassLoginUtil.getInstance().getLoginStoken(str);
    }

    @Override // com.baidu.wallet.api.IWalletLoginListener
    public String getLoginToken() {
        return PassLoginUtil.getInstance().getLoginToken();
    }

    @Override // com.baidu.wallet.api.IWalletLoginListener
    public int getLoginType() {
        return 0;
    }

    @Override // com.baidu.wallet.api.IWalletLoginListener
    public void getOpenBduss(boolean z, ILoginBackListener iLoginBackListener) {
        PassLoginUtil.getInstance().getOpenBduss(z, iLoginBackListener);
    }

    @Override // com.baidu.wallet.api.IWalletLoginListener
    public String getOpenLoginToken() {
        return PassLoginUtil.getInstance().getLoginOpenToken();
    }

    @Override // com.baidu.wallet.api.IWalletLoginListener
    public void handlerWalletError(int i2) {
        if (i2 == 5003) {
            PassLoginUtil.getInstance().logout();
            AccountManager.getInstance(this.mContext).logout();
        }
    }

    @Override // com.baidu.wallet.api.IWalletLoginListener
    public boolean isLogin() {
        return PassLoginUtil.getInstance().isLogin();
    }

    @Override // com.baidu.wallet.api.IWalletLoginListener
    public boolean isPassLogin() {
        return PassLoginUtil.getInstance().isPassLogin();
    }

    @Override // com.baidu.wallet.api.IWalletHostListener
    public void login(ILoginBackListener iLoginBackListener) {
        loginBaidu(iLoginBackListener, null);
    }

    @Override // com.baidu.wallet.api.IWalletLoginListener
    public void onLoginChanaged(Context context, Map map) {
        if (map == null) {
            PassLoginUtil.getInstance().logout();
            AccountManager.getInstance(this.mContext).logout();
        }
    }

    @Override // com.baidu.wallet.api.IWalletHostListener
    public boolean startPage(String str) {
        BaiduWalletDelegate.getInstance().openH5Module(this.mContext, str, true);
        return true;
    }

    @Override // com.baidu.wallet.api.IWalletHostListener2
    public void login(ILoginBackListener iLoginBackListener, String str) {
        loginBaidu(iLoginBackListener, str);
    }
}
