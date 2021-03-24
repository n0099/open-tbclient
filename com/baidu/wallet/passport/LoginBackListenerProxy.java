package com.baidu.wallet.passport;

import android.content.Context;
import com.baidu.wallet.api.ILoginBackListener;
import com.baidu.wallet.api.WalletLoginHelper;
import com.baidu.wallet.core.NoProguard;
import java.lang.ref.WeakReference;
/* loaded from: classes5.dex */
public class LoginBackListenerProxy implements ILoginBackListener, NoProguard {
    public ILoginBackListener loginBackListener;
    public WeakReference<Context> mContext;

    public LoginBackListenerProxy(Context context, ILoginBackListener iLoginBackListener) {
        this.mContext = new WeakReference<>(context);
        this.loginBackListener = iLoginBackListener;
    }

    public Context getContext() {
        WeakReference<Context> weakReference = this.mContext;
        if (weakReference == null) {
            return null;
        }
        return weakReference.get();
    }

    public ILoginBackListener getLoginBackListener() {
        return this.loginBackListener;
    }

    @Override // com.baidu.wallet.api.ILoginBackListener
    public void onFail(int i, String str) {
        ILoginBackListener iLoginBackListener = this.loginBackListener;
        if (iLoginBackListener != null) {
            iLoginBackListener.onFail(i, str);
        }
    }

    @Override // com.baidu.wallet.api.ILoginBackListener
    public void onSuccess(int i, String str) {
        if (this.loginBackListener != null) {
            WalletLoginHelper.getInstance().getOpenBduss(true, this);
        }
    }
}
