package com.baidu.wallet.paysdk.datamodel;

import android.content.Context;
import com.baidu.apollon.beans.IBeanResponse;
import java.io.Serializable;
/* loaded from: classes5.dex */
public class VerifyPayPasswordResponse implements IBeanResponse, Serializable {
    public static final int HAS_PWD_DEFAULT = 0;
    public int has_pwd = 0;

    @Override // com.baidu.apollon.beans.IBeanResponse
    public boolean checkResponseValidity() {
        return true;
    }

    @Override // com.baidu.apollon.beans.IBeanResponse
    public void storeResponse(Context context) {
    }
}
