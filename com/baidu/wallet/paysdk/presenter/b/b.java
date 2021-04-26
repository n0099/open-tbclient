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
        public ILoginBackListener f26220a;

        /* renamed from: b  reason: collision with root package name */
        public Context f26221b;

        public a(Context context, ILoginBackListener iLoginBackListener) {
            this.f26221b = context;
            this.f26220a = iLoginBackListener;
        }

        @Override // com.baidu.wallet.api.ILoginBackListener
        public void onFail(int i2, String str) {
            ILoginBackListener iLoginBackListener = this.f26220a;
            if (iLoginBackListener != null) {
                iLoginBackListener.onFail(i2, str);
            }
        }

        @Override // com.baidu.wallet.api.ILoginBackListener
        public void onSuccess(int i2, String str) {
            if (this.f26220a != null) {
                if (TextUtils.isEmpty(str)) {
                    this.f26220a.onSuccess(i2, str);
                } else {
                    this.f26220a.onSuccess(i2, str);
                }
            }
        }
    }

    @Override // com.baidu.wallet.paysdk.presenter.b.a
    public void a(Context context, ILoginBackListener iLoginBackListener) {
        WalletLoginHelper.getInstance().login(new a(context, iLoginBackListener));
    }
}
