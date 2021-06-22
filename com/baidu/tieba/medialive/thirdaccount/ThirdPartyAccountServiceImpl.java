package com.baidu.tieba.medialive.thirdaccount;

import android.content.Context;
import android.text.TextUtils;
import com.baidu.sapi2.SapiAccountManager;
import com.baidu.sapi2.callback.SapiCallback;
import com.baidu.sapi2.result.OAuthResult;
import com.baidu.searchbox.live.interfaces.service.ThirdPartAccountService;
import com.baidu.tbadk.TbConfig;
import com.baidu.tbadk.ala.ILoginListener;
import com.baidu.tbadk.core.TbadkCoreApplication;
import com.baidu.tbadk.core.util.DialogLoginHelper;
import d.a.n0.r.q.r0;
/* loaded from: classes4.dex */
public class ThirdPartyAccountServiceImpl implements ThirdPartAccountService {

    /* renamed from: a  reason: collision with root package name */
    public static ThirdPartAccountService.LoginResultCallback f18332a;

    /* renamed from: b  reason: collision with root package name */
    public static final ILoginListener f18333b = new ILoginListener() { // from class: com.baidu.tieba.medialive.thirdaccount.ThirdPartyAccountServiceImpl.1
        @Override // com.baidu.tbadk.ala.ILoginListener
        public void onCancel() {
            ThirdPartyAccountServiceImpl.f18332a.onResult(-2);
        }

        @Override // com.baidu.tbadk.ala.ILoginListener
        public void onFail() {
            ThirdPartyAccountServiceImpl.f18332a.onResult(-1);
        }

        @Override // com.baidu.tbadk.ala.ILoginListener
        public void onSuccess() {
            ThirdPartyAccountServiceImpl.f18332a.onResult(0);
        }
    };

    /* loaded from: classes4.dex */
    public class a implements SapiCallback<OAuthResult> {

        /* renamed from: e  reason: collision with root package name */
        public final /* synthetic */ ThirdPartAccountService.OpenAccessTokenCallback f18334e;

        public a(ThirdPartyAccountServiceImpl thirdPartyAccountServiceImpl, ThirdPartAccountService.OpenAccessTokenCallback openAccessTokenCallback) {
            this.f18334e = openAccessTokenCallback;
        }

        /* JADX DEBUG: Method merged with bridge method */
        @Override // com.baidu.sapi2.callback.SapiCallback
        /* renamed from: a */
        public void onFailure(OAuthResult oAuthResult) {
            this.f18334e.onFailed("accessToken is null");
        }

        /* JADX DEBUG: Method merged with bridge method */
        @Override // com.baidu.sapi2.callback.SapiCallback
        /* renamed from: b */
        public void onSuccess(OAuthResult oAuthResult) {
            if (oAuthResult != null) {
                try {
                    this.f18334e.onResult(oAuthResult.accessToken);
                } catch (Exception e2) {
                    e2.printStackTrace();
                }
            }
        }

        @Override // com.baidu.sapi2.callback.SapiCallback
        public void onFinish() {
        }

        @Override // com.baidu.sapi2.callback.SapiCallback
        public void onStart() {
        }
    }

    @Override // com.baidu.searchbox.live.interfaces.service.ThirdPartAccountService
    public void bindPhone(Context context, ThirdPartAccountService.BindPhoneCallback bindPhoneCallback) {
    }

    @Override // com.baidu.searchbox.live.interfaces.service.ThirdPartAccountService
    public void getOpenAccessToken(ThirdPartAccountService.OpenAccessTokenCallback openAccessTokenCallback, boolean z) {
        String bduss = TbadkCoreApplication.getCurrentAccountInfo().getBDUSS();
        if (TextUtils.isEmpty(bduss)) {
            openAccessTokenCallback.onFailed("bduss is null");
        } else {
            SapiAccountManager.getInstance().getAccountService().oauthAccessToken(new a(this, openAccessTokenCallback), bduss, TbConfig.PassConfig.OAUTH_OPEN_PLATFORM_ID, z);
        }
    }

    @Override // com.baidu.searchbox.live.interfaces.service.ThirdPartAccountService
    public void showLoginDialog(Context context, ThirdPartAccountService.LoginResultCallback loginResultCallback) {
        r0 r0Var = new r0(context, "");
        r0Var.e(f18333b);
        DialogLoginHelper.checkUpIsLogin(r0Var);
        f18332a = loginResultCallback;
    }
}
