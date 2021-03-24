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

    public abstract void handleFailure(int i, int i2, String str);

    public abstract void handleResponse(int i, Object obj, String str);

    @Override // com.baidu.apollon.beans.IBeanResponseCallback
    public void onBeanExecFailure(final int i, final int i2, final String str) {
        getHandler().post(new Runnable() { // from class: com.baidu.wallet.paysdk.presenter.NetWorkPresenter.2
            @Override // java.lang.Runnable
            public void run() {
                NetWorkPresenter.this.handleFailure(i, i2, str);
            }
        });
    }

    @Override // com.baidu.apollon.beans.IBeanResponseCallback
    public void onBeanExecSuccess(final int i, final Object obj, final String str) {
        getHandler().post(new Runnable() { // from class: com.baidu.wallet.paysdk.presenter.NetWorkPresenter.1
            @Override // java.lang.Runnable
            public void run() {
                NetWorkPresenter.this.handleResponse(i, obj, str);
            }
        });
    }
}
