package com.baidu.wallet.paysdk.datamodel;

import android.text.TextUtils;
import com.baidu.wallet.core.beans.BeanRequestBase;
import com.baidu.wallet.paysdk.beans.BeanConstants;
/* loaded from: classes5.dex */
public class d extends BeanRequestBase {

    /* renamed from: a  reason: collision with root package name */
    public String f25267a;

    /* renamed from: b  reason: collision with root package name */
    public String f25268b;

    /* renamed from: c  reason: collision with root package name */
    public String f25269c;

    /* renamed from: d  reason: collision with root package name */
    public String f25270d;

    public d(String str, String str2, String str3, String str4) {
        this.f25267a = str;
        this.f25268b = str2;
        this.f25269c = str3;
        this.f25270d = str4;
    }

    @Override // com.baidu.wallet.core.beans.BeanRequestBase
    public boolean checkRequestValidity() {
        return (TextUtils.isEmpty(this.f25267a) || TextUtils.isEmpty(this.f25268b) || TextUtils.isEmpty(this.f25269c) || TextUtils.isEmpty(this.f25270d)) ? false : true;
    }

    @Override // com.baidu.wallet.core.beans.BeanRequestBase
    public String getRequestId() {
        return BeanConstants.REQUEST_ID_VERIFY_CODE;
    }
}
