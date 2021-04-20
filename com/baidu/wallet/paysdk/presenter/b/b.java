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
        public ILoginBackListener f25438a;

        /* renamed from: b  reason: collision with root package name */
        public Context f25439b;

        public a(Context context, ILoginBackListener iLoginBackListener) {
            this.f25439b = context;
            this.f25438a = iLoginBackListener;
        }

        @Override // com.baidu.wallet.api.ILoginBackListener
        public void onFail(int i, String str) {
            ILoginBackListener iLoginBackListener = this.f25438a;
            if (iLoginBackListener != null) {
                iLoginBackListener.onFail(i, str);
            }
        }

        @Override // com.baidu.wallet.api.ILoginBackListener
        public void onSuccess(int i, String str) {
            if (this.f25438a != null) {
                if (TextUtils.isEmpty(str)) {
                    this.f25438a.onSuccess(i, str);
                } else {
                    this.f25438a.onSuccess(i, str);
                }
            }
        }
    }

    @Override // com.baidu.wallet.paysdk.presenter.b.a
    public void a(Context context, ILoginBackListener iLoginBackListener) {
        WalletLoginHelper.getInstance().login(new a(context, iLoginBackListener));
    }
}
