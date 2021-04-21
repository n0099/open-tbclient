package com.baidu.wallet.personal.datamodel;

import com.baidu.wallet.core.NoProguard;
import com.baidu.wallet.paysdk.ui.widget.tablayout.callback.ICustomTabEntity;
/* loaded from: classes5.dex */
public class BankCardTabEntity implements NoProguard, ICustomTabEntity {

    /* renamed from: a  reason: collision with root package name */
    public int f26270a;

    /* renamed from: b  reason: collision with root package name */
    public String f26271b;

    public BankCardTabEntity(int i, String str) {
        this.f26270a = i;
        this.f26271b = str;
    }

    @Override // com.baidu.wallet.paysdk.ui.widget.tablayout.callback.ICustomTabEntity
    public int getIndex() {
        return this.f26270a;
    }

    @Override // com.baidu.wallet.paysdk.ui.widget.tablayout.callback.ICustomTabEntity
    public String getTabTitle() {
        return this.f26271b;
    }

    public void setIndex(int i) {
        this.f26270a = i;
    }

    public void setTitle(String str) {
        this.f26271b = str;
    }
}
