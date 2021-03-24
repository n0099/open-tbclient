package com.baidu.wallet.personal.datamodel;

import android.content.Context;
import com.baidu.apollon.beans.IBeanResponse;
import java.io.Serializable;
/* loaded from: classes5.dex */
public class CardRedEemMasResp implements IBeanResponse, Serializable {
    public String msgCode;
    public String notice_msg;

    @Override // com.baidu.apollon.beans.IBeanResponse
    public boolean checkResponseValidity() {
        return true;
    }

    @Override // com.baidu.apollon.beans.IBeanResponse
    public void storeResponse(Context context) {
    }
}
