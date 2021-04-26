package com.baidu.wallet.paysdk.fingerprint.datamodel;

import android.content.Context;
import com.baidu.wallet.core.utils.LogUtil;
import org.json.JSONException;
import org.json.JSONObject;
/* loaded from: classes5.dex */
public class StatusResponse extends a {

    /* renamed from: a  reason: collision with root package name */
    public static final String f26105a = "StatusResponse";
    public JSONObject fingerprint;
    public JSONObject user_info;

    @Override // com.baidu.wallet.paysdk.fingerprint.datamodel.a, com.baidu.apollon.beans.IBeanResponse
    public /* bridge */ /* synthetic */ boolean checkResponseValidity() {
        return super.checkResponseValidity();
    }

    public void print() {
        String str = "test\n";
        try {
            if (this.fingerprint != null) {
                str = "test\n" + this.fingerprint.toString(2);
            }
            if (this.user_info != null) {
                str = str + this.user_info.toString(2);
            }
        } catch (JSONException e2) {
            e2.printStackTrace();
        }
        LogUtil.d(f26105a, str);
    }

    @Override // com.baidu.wallet.paysdk.fingerprint.datamodel.a, com.baidu.apollon.beans.IBeanResponse
    public /* bridge */ /* synthetic */ void storeResponse(Context context) {
        super.storeResponse(context);
    }
}
