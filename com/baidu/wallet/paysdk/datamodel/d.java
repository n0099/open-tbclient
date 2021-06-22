package com.baidu.wallet.paysdk.datamodel;

import android.text.TextUtils;
import com.baidu.wallet.core.beans.BeanRequestBase;
import com.baidu.wallet.paysdk.beans.BeanConstants;
/* loaded from: classes5.dex */
public class d extends BeanRequestBase {

    /* renamed from: a  reason: collision with root package name */
    public String f25405a;

    /* renamed from: b  reason: collision with root package name */
    public String f25406b;

    /* renamed from: c  reason: collision with root package name */
    public String f25407c;

    /* renamed from: d  reason: collision with root package name */
    public String f25408d;

    public d(String str, String str2, String str3, String str4) {
        this.f25405a = str;
        this.f25406b = str2;
        this.f25407c = str3;
        this.f25408d = str4;
    }

    @Override // com.baidu.wallet.core.beans.BeanRequestBase
    public boolean checkRequestValidity() {
        return (TextUtils.isEmpty(this.f25405a) || TextUtils.isEmpty(this.f25406b) || TextUtils.isEmpty(this.f25407c) || TextUtils.isEmpty(this.f25408d)) ? false : true;
    }

    @Override // com.baidu.wallet.core.beans.BeanRequestBase
    public String getRequestId() {
        return BeanConstants.REQUEST_ID_VERIFY_CODE;
    }
}
