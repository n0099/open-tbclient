package com.baidu.wallet.paysdk.datamodel;

import android.content.Context;
import com.baidu.apollon.beans.IBeanResponse;
import com.baidu.wallet.core.NoProguard;
import java.io.Serializable;
import org.json.JSONObject;
/* loaded from: classes5.dex */
public class WalletInterfaceResponse implements IBeanResponse {
    public JSONObject login_data;
    public JSONObject unlogin_data;

    /* loaded from: classes5.dex */
    public static class WalletModuleData implements NoProguard, Serializable {
        public static final String NO_ANIM = "0";
        public String anim;
        public String link_addr;
        public String logo;
        public String name;
        public int type = -1;
        public String value;

        public boolean needAnim() {
            return !"0".equals(this.anim);
        }
    }

    @Override // com.baidu.apollon.beans.IBeanResponse
    public boolean checkResponseValidity() {
        return true;
    }

    @Override // com.baidu.apollon.beans.IBeanResponse
    public void storeResponse(Context context) {
    }
}
