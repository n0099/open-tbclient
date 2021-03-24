package com.baidu.wallet.paysdk.contract;

import android.content.Context;
import com.baidu.wallet.paysdk.presenter.CouponListPresenter;
import com.baidu.wallet.paysdk.presenter.NetWorkPresenter;
/* loaded from: classes5.dex */
public interface CouponListContract {

    /* loaded from: classes5.dex */
    public static abstract class Presenter extends NetWorkPresenter {
        public Presenter(Context context) {
            super(context);
        }

        public abstract void calcPayamount(CouponListPresenter.a aVar);
    }
}
