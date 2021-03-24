package com.baidu.wallet.paysdk.presenter;

import com.baidu.wallet.base.datamodel.Authorize;
import com.baidu.wallet.paysdk.datamodel.DirectPayContentResponse;
import com.baidu.wallet.paysdk.ui.AuthorizeSignActivity;
import com.baidu.wallet.paysdk.ui.widget.AuthorizeInfoView;
/* loaded from: classes5.dex */
public class c extends a {
    public c(AuthorizeSignActivity authorizeSignActivity) {
        super(authorizeSignActivity);
        this.f25741b = 3;
    }

    @Override // com.baidu.wallet.paysdk.presenter.a, com.baidu.wallet.paysdk.presenter.e
    public void a(boolean z) {
        super.a(z);
        if (z) {
            this.f25741b = 3;
        } else {
            this.f25741b = 4;
        }
    }

    @Override // com.baidu.wallet.paysdk.presenter.a, com.baidu.wallet.paysdk.presenter.e
    public void b() {
        super.b();
        AuthorizeSignActivity authorizeSignActivity = this.f25740a;
        if (authorizeSignActivity == null) {
            return;
        }
        AuthorizeInfoView.b authInfoViewAdapter = authorizeSignActivity.getAuthInfoViewAdapter(1);
        DirectPayContentResponse payResponse = this.f25740a.getPayResponse();
        if (payResponse != null) {
            authInfoViewAdapter.a(payResponse.authorize);
            authInfoViewAdapter.a(payResponse.user);
            Authorize authorize = payResponse.authorize;
            if (authorize != null) {
                this.f25740a.initActionBarByString(authorize.top_title);
            }
        }
    }

    @Override // com.baidu.wallet.paysdk.presenter.a, com.baidu.wallet.paysdk.presenter.e
    public boolean c() {
        return true;
    }

    @Override // com.baidu.wallet.paysdk.presenter.a, com.baidu.wallet.paysdk.presenter.e
    public boolean d() {
        return true;
    }
}
