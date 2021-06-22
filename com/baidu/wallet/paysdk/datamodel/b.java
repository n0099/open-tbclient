package com.baidu.wallet.paysdk.datamodel;

import android.text.TextUtils;
import com.baidu.wallet.core.beans.BeanRequestBase;
import com.baidu.wallet.paysdk.beans.BeanConstants;
/* loaded from: classes5.dex */
public class b extends BeanRequestBase {

    /* renamed from: a  reason: collision with root package name */
    public String f25403a;

    /* renamed from: b  reason: collision with root package name */
    public String f25404b;

    @Override // com.baidu.wallet.core.beans.BeanRequestBase
    public boolean checkRequestValidity() {
        return (TextUtils.isEmpty(this.f25403a) || TextUtils.isEmpty(this.f25404b)) ? false : true;
    }

    @Override // com.baidu.wallet.core.beans.BeanRequestBase
    public String getRequestId() {
        return BeanConstants.REQUEST_ID_GET_SMS;
    }
}
