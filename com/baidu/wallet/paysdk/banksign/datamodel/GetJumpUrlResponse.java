package com.baidu.wallet.paysdk.banksign.datamodel;

import android.content.Context;
import com.baidu.apollon.beans.IBeanResponse;
/* loaded from: classes5.dex */
public class GetJumpUrlResponse implements IBeanResponse {
    public String agreement_trans_id;
    public String form_data;
    public String form_url;
    public int is_signed;
    public String signed_msg;
    public String webview_title;

    @Override // com.baidu.apollon.beans.IBeanResponse
    public boolean checkResponseValidity() {
        return true;
    }

    @Override // com.baidu.apollon.beans.IBeanResponse
    public void storeResponse(Context context) {
    }
}
