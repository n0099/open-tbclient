package com.baidu.wallet.paysdk.datamodel;

import android.text.TextUtils;
import com.baidu.wallet.core.beans.BeanRequestBase;
import com.baidu.wallet.paysdk.beans.BeanConstants;
/* loaded from: classes5.dex */
public class d extends BeanRequestBase {

    /* renamed from: a  reason: collision with root package name */
    public String f25275a;

    /* renamed from: b  reason: collision with root package name */
    public String f25276b;

    /* renamed from: c  reason: collision with root package name */
    public String f25277c;

    /* renamed from: d  reason: collision with root package name */
    public String f25278d;

    public d(String str, String str2, String str3, String str4) {
        this.f25275a = str;
        this.f25276b = str2;
        this.f25277c = str3;
        this.f25278d = str4;
    }

    @Override // com.baidu.wallet.core.beans.BeanRequestBase
    public boolean checkRequestValidity() {
        return (TextUtils.isEmpty(this.f25275a) || TextUtils.isEmpty(this.f25276b) || TextUtils.isEmpty(this.f25277c) || TextUtils.isEmpty(this.f25278d)) ? false : true;
    }

    @Override // com.baidu.wallet.core.beans.BeanRequestBase
    public String getRequestId() {
        return BeanConstants.REQUEST_ID_VERIFY_CODE;
    }
}
