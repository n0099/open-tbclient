package com.baidu.wallet.paysdk.datamodel;

import android.text.TextUtils;
import com.baidu.wallet.core.beans.BeanRequestBase;
import com.baidu.wallet.paysdk.beans.BeanConstants;
/* loaded from: classes5.dex */
public class d extends BeanRequestBase {

    /* renamed from: a  reason: collision with root package name */
    public String f26046a;

    /* renamed from: b  reason: collision with root package name */
    public String f26047b;

    /* renamed from: c  reason: collision with root package name */
    public String f26048c;

    /* renamed from: d  reason: collision with root package name */
    public String f26049d;

    public d(String str, String str2, String str3, String str4) {
        this.f26046a = str;
        this.f26047b = str2;
        this.f26048c = str3;
        this.f26049d = str4;
    }

    @Override // com.baidu.wallet.core.beans.BeanRequestBase
    public boolean checkRequestValidity() {
        return (TextUtils.isEmpty(this.f26046a) || TextUtils.isEmpty(this.f26047b) || TextUtils.isEmpty(this.f26048c) || TextUtils.isEmpty(this.f26049d)) ? false : true;
    }

    @Override // com.baidu.wallet.core.beans.BeanRequestBase
    public String getRequestId() {
        return BeanConstants.REQUEST_ID_VERIFY_CODE;
    }
}
