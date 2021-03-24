package com.baidu.wallet.paysdk.datamodel;

import android.text.TextUtils;
import com.baidu.wallet.core.beans.BeanRequestBase;
import com.baidu.wallet.paysdk.beans.BeanConstants;
/* loaded from: classes5.dex */
public class d extends BeanRequestBase {

    /* renamed from: a  reason: collision with root package name */
    public String f25581a;

    /* renamed from: b  reason: collision with root package name */
    public String f25582b;

    /* renamed from: c  reason: collision with root package name */
    public String f25583c;

    /* renamed from: d  reason: collision with root package name */
    public String f25584d;

    public d(String str, String str2, String str3, String str4) {
        this.f25581a = str;
        this.f25582b = str2;
        this.f25583c = str3;
        this.f25584d = str4;
    }

    @Override // com.baidu.wallet.core.beans.BeanRequestBase
    public boolean checkRequestValidity() {
        return (TextUtils.isEmpty(this.f25581a) || TextUtils.isEmpty(this.f25582b) || TextUtils.isEmpty(this.f25583c) || TextUtils.isEmpty(this.f25584d)) ? false : true;
    }

    @Override // com.baidu.wallet.core.beans.BeanRequestBase
    public String getRequestId() {
        return BeanConstants.REQUEST_ID_VERIFY_CODE;
    }
}
