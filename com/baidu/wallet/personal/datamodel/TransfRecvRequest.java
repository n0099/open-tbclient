package com.baidu.wallet.personal.datamodel;

import com.baidu.wallet.core.beans.BeanRequestBase;
import com.baidu.wallet.paysdk.beans.BeanConstants;
import java.io.Serializable;
/* loaded from: classes5.dex */
public class TransfRecvRequest extends BeanRequestBase implements Serializable {
    public String errMsg;
    public String idt;
    public boolean isGatheringSuccess;
    public String phone;
    public String recvAmount;
    public String recv_card_num;
    public String sms_code;

    @Override // com.baidu.wallet.core.beans.BeanRequestBase
    public boolean checkRequestValidity() {
        return true;
    }

    @Override // com.baidu.wallet.core.beans.BeanRequestBase
    public String getRequestId() {
        setBelongPaySdk();
        return BeanConstants.REQUEST_ID_TRANSFER_RECV;
    }
}
