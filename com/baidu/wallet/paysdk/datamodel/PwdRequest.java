package com.baidu.wallet.paysdk.datamodel;

import android.text.TextUtils;
import com.baidu.wallet.core.beans.BeanRequestBase;
import com.baidu.wallet.paysdk.beans.BeanConstants;
import java.io.Serializable;
import java.util.Map;
/* loaded from: classes5.dex */
public class PwdRequest extends BeanRequestBase implements Serializable {
    public static final int FROM_CHECK = 1;
    public static final int FROM_CREATE = 3;
    public static final int FROM_EDIT = 2;
    public static final int FROM_RNAUTH_SETTING = 4;
    public static final int FROM_SETTING = 0;
    public static final int REQUEST_TYPE_CHECK = 1;
    public static final int REQUEST_TYPE_MODIFY = 3;
    public static final int REQUEST_TYPE_VERIFY = 2;
    public static final long serialVersionUID = 3208920939235207235L;
    public String fromType;
    public String mConfirmPayPass;
    public Map<String, String> mExtData;
    public String mPayPass;
    public String mSessionKey;
    public String serviceType;
    public int mFrom = 1;
    public int mRequestType = 1;

    @Override // com.baidu.wallet.core.beans.BeanRequestBase
    public boolean checkRequestValidity() {
        if (this.mRequestType == 3) {
            return !TextUtils.isEmpty(this.mPayPass);
        }
        return true;
    }

    @Override // com.baidu.wallet.core.beans.BeanRequestBase
    public String getRequestId() {
        setBelongPaySdk();
        return BeanConstants.REQUEST_ID_PWD;
    }
}
