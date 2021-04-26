package com.baidu.wallet.paysdk.presenter;

import android.content.Context;
import android.os.Handler;
import com.baidu.apollon.beans.IBeanResponseCallback;
/* loaded from: classes5.dex */
public abstract class NetWorkPresenter implements IBeanResponseCallback, BasePresenter {
    public Context mContext;
    public Handler mHandler = null;

    public NetWorkPresenter(Context context) {
        this.mContext = context.getApplicationContext();
    }

    private Handler getHandler() {
        if (this.mHandler == null) {
            this.mHandler = new Handler(this.mContext.getMainLooper());
        }
        return this.mHandler;
    }

    public abstract void handleFailure(int i2, int i3, String str);

    public abstract void handleResponse(int i2, Object obj, String str);

    @Override // com.baidu.apollon.beans.IBeanResponseCallback
    public void onBeanExecFailure(final int i2, final int i3, final String str) {
        getHandler().post(new Runnable() { // from class: com.baidu.wallet.paysdk.presenter.NetWorkPresenter.2
            @Override // java.lang.Runnable
            public void run() {
                NetWorkPresenter.this.handleFailure(i2, i3, str);
            }
        });
    }

    @Override // com.baidu.apollon.beans.IBeanResponseCallback
    public void onBeanExecSuccess(final int i2, final Object obj, final String str) {
        getHandler().post(new Runnable() { // from class: com.baidu.wallet.paysdk.presenter.NetWorkPresenter.1
            @Override // java.lang.Runnable
            public void run() {
                NetWorkPresenter.this.handleResponse(i2, obj, str);
            }
        });
    }
}
