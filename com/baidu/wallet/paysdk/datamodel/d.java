package com.baidu.wallet.paysdk.datamodel;

import android.text.TextUtils;
import com.baidu.wallet.core.beans.BeanRequestBase;
import com.baidu.wallet.paysdk.beans.BeanConstants;
/* loaded from: classes5.dex */
public class d extends BeanRequestBase {

    /* renamed from: a  reason: collision with root package name */
    public String f25291a;

    /* renamed from: b  reason: collision with root package name */
    public String f25292b;

    /* renamed from: c  reason: collision with root package name */
    public String f25293c;

    /* renamed from: d  reason: collision with root package name */
    public String f25294d;

    public d(String str, String str2, String str3, String str4) {
        this.f25291a = str;
        this.f25292b = str2;
        this.f25293c = str3;
        this.f25294d = str4;
    }

    @Override // com.baidu.wallet.core.beans.BeanRequestBase
    public boolean checkRequestValidity() {
        return (TextUtils.isEmpty(this.f25291a) || TextUtils.isEmpty(this.f25292b) || TextUtils.isEmpty(this.f25293c) || TextUtils.isEmpty(this.f25294d)) ? false : true;
    }

    @Override // com.baidu.wallet.core.beans.BeanRequestBase
    public String getRequestId() {
        return BeanConstants.REQUEST_ID_VERIFY_CODE;
    }
}
