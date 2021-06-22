package com.baidu.wallet.personal.datamodel;

import com.baidu.wallet.core.NoProguard;
import com.baidu.wallet.paysdk.ui.widget.tablayout.callback.ICustomTabEntity;
/* loaded from: classes5.dex */
public class BankCardTabEntity implements NoProguard, ICustomTabEntity {

    /* renamed from: a  reason: collision with root package name */
    public int f26433a;

    /* renamed from: b  reason: collision with root package name */
    public String f26434b;

    public BankCardTabEntity(int i2, String str) {
        this.f26433a = i2;
        this.f26434b = str;
    }

    @Override // com.baidu.wallet.paysdk.ui.widget.tablayout.callback.ICustomTabEntity
    public int getIndex() {
        return this.f26433a;
    }

    @Override // com.baidu.wallet.paysdk.ui.widget.tablayout.callback.ICustomTabEntity
    public String getTabTitle() {
        return this.f26434b;
    }

    public void setIndex(int i2) {
        this.f26433a = i2;
    }

    public void setTitle(String str) {
        this.f26434b = str;
    }
}
