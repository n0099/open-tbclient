package com.baidu.wallet.base.iddetect.datamodel;

import android.content.Context;
import com.baidu.apollon.beans.IBeanResponse;
import com.baidu.wallet.base.iddetect.IdCardActivity;
/* loaded from: classes5.dex */
public class IDDetectResponse implements IBeanResponse {
    public String address;
    public String birth;
    public String id_card;
    public String name;
    public String nation;
    public String sex;

    @Override // com.baidu.apollon.beans.IBeanResponse
    public boolean checkResponseValidity() {
        return true;
    }

    @Override // com.baidu.apollon.beans.IBeanResponse
    public void storeResponse(Context context) {
    }

    public String toString() {
        return "name:" + this.name + IdCardActivity.KEY_NUMBER + this.id_card;
    }
}
