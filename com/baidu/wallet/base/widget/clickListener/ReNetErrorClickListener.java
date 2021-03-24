package com.baidu.wallet.base.widget.clickListener;

import android.view.View;
import com.baidu.apollon.utils.GlobalUtils;
import com.baidu.apollon.utils.NetworkUtils;
import com.baidu.apollon.utils.ResUtils;
/* loaded from: classes5.dex */
public abstract class ReNetErrorClickListener implements View.OnClickListener {
    public abstract void doClick(View view);

    @Override // android.view.View.OnClickListener
    public void onClick(View view) {
        if (!NetworkUtils.isNetworkAvailable(view.getContext())) {
            GlobalUtils.toast(view.getContext(), ResUtils.getString(view.getContext(), "ebpay_no_network"));
        } else {
            doClick(view);
        }
    }
}
