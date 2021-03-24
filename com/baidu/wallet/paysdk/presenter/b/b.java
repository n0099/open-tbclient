package com.baidu.wallet.paysdk.presenter.b;

import android.content.Context;
import android.text.TextUtils;
import com.baidu.wallet.api.ILoginBackListener;
import com.baidu.wallet.api.WalletLoginHelper;
/* loaded from: classes5.dex */
public class b implements com.baidu.wallet.paysdk.presenter.b.a {

    /* loaded from: classes5.dex */
    public static class a implements ILoginBackListener {

        /* renamed from: a  reason: collision with root package name */
        public ILoginBackListener f25752a;

        /* renamed from: b  reason: collision with root package name */
        public Context f25753b;

        public a(Context context, ILoginBackListener iLoginBackListener) {
            this.f25753b = context;
            this.f25752a = iLoginBackListener;
        }

        @Override // com.baidu.wallet.api.ILoginBackListener
        public void onFail(int i, String str) {
            ILoginBackListener iLoginBackListener = this.f25752a;
            if (iLoginBackListener != null) {
                iLoginBackListener.onFail(i, str);
            }
        }

        @Override // com.baidu.wallet.api.ILoginBackListener
        public void onSuccess(int i, String str) {
            if (this.f25752a != null) {
                if (TextUtils.isEmpty(str)) {
                    this.f25752a.onSuccess(i, str);
                } else {
                    this.f25752a.onSuccess(i, str);
                }
            }
        }
    }

    @Override // com.baidu.wallet.paysdk.presenter.b.a
    public void a(Context context, ILoginBackListener iLoginBackListener) {
        WalletLoginHelper.getInstance().login(new a(context, iLoginBackListener));
    }
}
