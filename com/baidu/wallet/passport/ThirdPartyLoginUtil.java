package com.baidu.wallet.passport;

import android.app.Activity;
import android.content.Context;
import android.view.View;
import com.baidu.apollon.utils.ResUtils;
import com.baidu.wallet.api.ILoginBackListener;
import com.baidu.wallet.api.WalletApiExtListener;
import com.baidu.wallet.api.WalletLoginHelper;
import com.baidu.wallet.base.widget.dialog.PromptDialog;
import com.baidu.wallet.core.NoProguard;
import com.baidu.wallet.core.StatusCode;
/* loaded from: classes5.dex */
public class ThirdPartyLoginUtil implements NoProguard {
    public static final int THIRD_PARTH_BINDPHONE = 2;
    public static final int THIRD_PARTH_LOGIN = 0;
    public static final int THIRD_PARTH_NORMALIZE = 1;
    public static final int THIRD_PARTH_NOT = -1;
    public static final int THIRD_PARTH_PASSAUTH = 3;
    public LoginBackListenerProxy loginBackListener;
    public WalletApiExtListener.ThirdPartyLoginInterface mTPLImpl;
    public static final String[] POSITIVE_STRS = {"bd_wallet_base_third_login_positive", "bd_wallet_base_third_login_normalize", "bd_wallet_base_third_login_bindphone", "bd_wallet_base_third_login_passauth"};
    public static final String[] NEGATIVE_STRS = {"bd_wallet_base_third_login_negative", "bd_wallet_base_third_login_giveup", "bd_wallet_base_third_login_giveup", "bd_wallet_base_third_login_giveup"};

    /* loaded from: classes5.dex */
    public static class a {

        /* renamed from: a  reason: collision with root package name */
        public static ThirdPartyLoginUtil f24989a = new ThirdPartyLoginUtil();
    }

    public static ThirdPartyLoginUtil getInstance() {
        return a.f24989a;
    }

    public boolean checkThirdPartyLogin(final Activity activity, int i2, String str, final WalletApiExtListener.ThirdPartyLoginListener thirdPartyLoginListener) {
        int i3;
        switch (i2) {
            case StatusCode.ERROR_TURIST_LOGIN_NEED_AUTH /* 5093 */:
            case StatusCode.ERROR_THIRD_LOGIN_NEED_AUTH /* 5095 */:
                i3 = 3;
                break;
            case StatusCode.ERROR_TURIST_LOGIN_NEED_BIND /* 5094 */:
            case StatusCode.ERROR_THIRD_LOGIN_NEED_BIND /* 5096 */:
                i3 = 2;
                break;
            case StatusCode.ERROR_TURIST_LOGIN /* 5097 */:
                i3 = 1;
                break;
            case 5098:
            default:
                i3 = -1;
                break;
            case StatusCode.ERROR_NOT_PASS_LOGIN /* 5099 */:
                i3 = 0;
                break;
        }
        if (i3 == -1) {
            return false;
        }
        final PromptDialog promptDialog = new PromptDialog(activity);
        if (i3 == 0) {
            promptDialog.setTitleText(ResUtils.getString(activity, "bd_wallet_base_third_login_title"));
        } else {
            promptDialog.hideTitle();
        }
        promptDialog.setMessage(str);
        final int i4 = i3;
        promptDialog.setPositiveBtn(ResUtils.getString(activity, POSITIVE_STRS[i3]), new View.OnClickListener() { // from class: com.baidu.wallet.passport.ThirdPartyLoginUtil.2
            @Override // android.view.View.OnClickListener
            public void onClick(View view) {
                int i5 = i4;
                if (i5 == 0) {
                    ThirdPartyLoginUtil.this.startLogin(activity, thirdPartyLoginListener);
                } else if (i5 == 1) {
                    ThirdPartyLoginUtil.this.startTuristNormalize(activity, thirdPartyLoginListener);
                } else if (i5 == 2) {
                    ThirdPartyLoginUtil.this.startBindPhone(activity, thirdPartyLoginListener);
                } else if (i5 == 3) {
                    ThirdPartyLoginUtil.this.startPassSMSAuth(activity, thirdPartyLoginListener);
                }
                try {
                    promptDialog.dismiss();
                } catch (Throwable unused) {
                }
            }
        });
        promptDialog.setNegativeBtn(ResUtils.getString(activity, NEGATIVE_STRS[i3]), new View.OnClickListener() { // from class: com.baidu.wallet.passport.ThirdPartyLoginUtil.3
            @Override // android.view.View.OnClickListener
            public void onClick(View view) {
                try {
                    promptDialog.dismiss();
                } catch (Throwable unused) {
                }
                WalletApiExtListener.ThirdPartyLoginListener thirdPartyLoginListener2 = thirdPartyLoginListener;
                if (thirdPartyLoginListener2 != null) {
                    thirdPartyLoginListener2.onCallFail(0, null);
                }
                activity.finish();
            }
        });
        try {
            promptDialog.show();
        } catch (Throwable unused) {
        }
        return true;
    }

    public void setThirdPartyLoginImpl(WalletApiExtListener.ThirdPartyLoginInterface thirdPartyLoginInterface) {
        this.mTPLImpl = thirdPartyLoginInterface;
    }

    public void startBindPhone(Activity activity, WalletApiExtListener.ThirdPartyLoginListener thirdPartyLoginListener) {
        WalletApiExtListener.ThirdPartyLoginInterface thirdPartyLoginInterface = this.mTPLImpl;
        if (thirdPartyLoginInterface != null) {
            thirdPartyLoginInterface.callBindPhone(activity, thirdPartyLoginListener);
        } else {
            thirdPartyLoginListener.onCallFail(0, null);
        }
    }

    public void startLogin(Context context, final WalletApiExtListener.ThirdPartyLoginListener thirdPartyLoginListener) {
        this.loginBackListener = new LoginBackListenerProxy(context, new ILoginBackListener() { // from class: com.baidu.wallet.passport.ThirdPartyLoginUtil.1
            @Override // com.baidu.wallet.api.ILoginBackListener
            public void onFail(int i2, String str) {
                if (i2 == 603) {
                    WalletLoginHelper.getInstance().onlyLogin(ThirdPartyLoginUtil.this.loginBackListener);
                    return;
                }
                WalletApiExtListener.ThirdPartyLoginListener thirdPartyLoginListener2 = thirdPartyLoginListener;
                if (thirdPartyLoginListener2 != null) {
                    thirdPartyLoginListener2.onCallFail(0, null);
                }
            }

            @Override // com.baidu.wallet.api.ILoginBackListener
            public void onSuccess(int i2, String str) {
                WalletApiExtListener.ThirdPartyLoginListener thirdPartyLoginListener2 = thirdPartyLoginListener;
                if (thirdPartyLoginListener2 != null) {
                    thirdPartyLoginListener2.onCallSuccess(0, null);
                }
            }
        });
        WalletLoginHelper.getInstance().login(this.loginBackListener);
    }

    public void startPassSMSAuth(Activity activity, WalletApiExtListener.ThirdPartyLoginListener thirdPartyLoginListener) {
        PassSMSAuthProxyActivity.startPassSMSAuth(activity, thirdPartyLoginListener);
    }

    public void startTuristNormalize(Activity activity, WalletApiExtListener.ThirdPartyLoginListener thirdPartyLoginListener) {
        WalletApiExtListener.ThirdPartyLoginInterface thirdPartyLoginInterface = this.mTPLImpl;
        if (thirdPartyLoginInterface != null) {
            thirdPartyLoginInterface.callTuristNormalize(activity, thirdPartyLoginListener);
        } else {
            thirdPartyLoginListener.onCallFail(0, null);
        }
    }
}
