package com.baidu.wallet.home.datamodel;

import android.content.Context;
import com.baidu.apollon.beans.IBeanResponse;
import org.json.JSONObject;
/* loaded from: classes5.dex */
public class HomeTabResponse implements IBeanResponse {
    public String android_prefix;
    public String changedSign;
    public String is_login = "0";
    public JSONObject pd_message;
    public JSONObject tabconf;
    public JSONObject tabtitle;

    @Override // com.baidu.apollon.beans.IBeanResponse
    public boolean checkResponseValidity() {
        return true;
    }

    @Override // com.baidu.apollon.beans.IBeanResponse
    public void storeResponse(Context context) {
    }
}
