package com.baidu.wallet.paysdk.datamodel;

import com.baidu.wallet.core.beans.BeanRequestBase;
import com.baidu.wallet.paysdk.beans.BeanConstants;
/* loaded from: classes5.dex */
public class e extends BeanRequestBase {
    @Override // com.baidu.wallet.core.beans.BeanRequestBase
    public boolean checkRequestValidity() {
        return true;
    }

    @Override // com.baidu.wallet.core.beans.BeanRequestBase
    public String getRequestId() {
        return BeanConstants.REQUEST_ID_VERIFY_CODE_FOR_NO_PWD;
    }
}
