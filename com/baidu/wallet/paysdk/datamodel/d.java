package com.baidu.wallet.paysdk.datamodel;

import android.text.TextUtils;
import com.baidu.wallet.core.beans.BeanRequestBase;
import com.baidu.wallet.paysdk.beans.BeanConstants;
/* loaded from: classes5.dex */
public class d extends BeanRequestBase {

    /* renamed from: a  reason: collision with root package name */
    public String f25220a;

    /* renamed from: b  reason: collision with root package name */
    public String f25221b;

    /* renamed from: c  reason: collision with root package name */
    public String f25222c;

    /* renamed from: d  reason: collision with root package name */
    public String f25223d;

    public d(String str, String str2, String str3, String str4) {
        this.f25220a = str;
        this.f25221b = str2;
        this.f25222c = str3;
        this.f25223d = str4;
    }

    @Override // com.baidu.wallet.core.beans.BeanRequestBase
    public boolean checkRequestValidity() {
        return (TextUtils.isEmpty(this.f25220a) || TextUtils.isEmpty(this.f25221b) || TextUtils.isEmpty(this.f25222c) || TextUtils.isEmpty(this.f25223d)) ? false : true;
    }

    @Override // com.baidu.wallet.core.beans.BeanRequestBase
    public String getRequestId() {
        return BeanConstants.REQUEST_ID_VERIFY_CODE;
    }
}
