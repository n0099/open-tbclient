package com.baidu.wallet.paysdk.presenter;

import com.baidu.wallet.paysdk.datamodel.BindFastRequest;
import com.baidu.wallet.paysdk.storage.PayRequestCache;
import com.baidu.wallet.paysdk.ui.PayBaseBeanActivity;
/* loaded from: classes5.dex */
public class f {

    /* renamed from: a  reason: collision with root package name */
    public PayBaseBeanActivity f25756a;

    public f(PayBaseBeanActivity payBaseBeanActivity) {
        this.f25756a = payBaseBeanActivity;
    }

    public void a(BindFastRequest bindFastRequest) {
        if (this.f25756a == null || bindFastRequest == null) {
            return;
        }
        PayRequestCache.BindCategory category = BindFastRequest.getCategory(bindFastRequest.getmBindFrom());
        if (PayRequestCache.BindCategory.Initiative != category && PayRequestCache.BindCategory.Pwd != category) {
            if (PayRequestCache.BindCategory.Other == category) {
                this.f25756a.setFlagPaySdk();
                return;
            }
            return;
        }
        this.f25756a.setFlagActiveBindCard();
    }
}
