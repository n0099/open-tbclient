package com.baidu.wallet.paysdk.datamodel;

import android.text.TextUtils;
import com.baidu.wallet.core.beans.BeanRequestBase;
import com.baidu.wallet.paysdk.beans.BeanConstants;
/* loaded from: classes5.dex */
public class d extends BeanRequestBase {

    /* renamed from: a  reason: collision with root package name */
    public String f25582a;

    /* renamed from: b  reason: collision with root package name */
    public String f25583b;

    /* renamed from: c  reason: collision with root package name */
    public String f25584c;

    /* renamed from: d  reason: collision with root package name */
    public String f25585d;

    public d(String str, String str2, String str3, String str4) {
        this.f25582a = str;
        this.f25583b = str2;
        this.f25584c = str3;
        this.f25585d = str4;
    }

    @Override // com.baidu.wallet.core.beans.BeanRequestBase
    public boolean checkRequestValidity() {
        return (TextUtils.isEmpty(this.f25582a) || TextUtils.isEmpty(this.f25583b) || TextUtils.isEmpty(this.f25584c) || TextUtils.isEmpty(this.f25585d)) ? false : true;
    }

    @Override // com.baidu.wallet.core.beans.BeanRequestBase
    public String getRequestId() {
        return BeanConstants.REQUEST_ID_VERIFY_CODE;
    }
}
