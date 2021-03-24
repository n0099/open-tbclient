package com.baidu.wallet.home.datamodel;

import android.content.Context;
import android.text.TextUtils;
import com.baidu.apollon.beans.IBeanResponse;
/* loaded from: classes5.dex */
public class CheckNewResponse implements IBeanResponse {
    public String lastest_time;

    @Override // com.baidu.apollon.beans.IBeanResponse
    public boolean checkResponseValidity() {
        return !TextUtils.isEmpty(this.lastest_time);
    }

    @Override // com.baidu.apollon.beans.IBeanResponse
    public void storeResponse(Context context) {
    }
}
