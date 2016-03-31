package com.baidu.tieba.pb.pb.praise.grffitiList;

import com.baidu.tbadk.core.frameworkData.CmdConfigHttp;
import com.baidu.tbadk.core.util.y;
import com.baidu.tbadk.message.http.TbHttpResponsedMessage;
import com.baidu.tieba.pb.pb.praise.a;
import com.squareup.wire.Wire;
import java.util.ArrayList;
import java.util.List;
import tbclient.GetConsentList.ConsentUser;
import tbclient.GetConsentList.GetConsentListResIdl;
/* loaded from: classes.dex */
public class ResponseHttpGraffitiMessage extends TbHttpResponsedMessage {
    private List<a> itemDataList;
    private int mTotalNum;

    public ResponseHttpGraffitiMessage() {
        super(CmdConfigHttp.CMD_GRAFFITI_LIST);
        this.itemDataList = null;
        this.mTotalNum = 0;
    }

    public List<a> getItemDataList() {
        return this.itemDataList;
    }

    public int getmTotalNum() {
        return this.mTotalNum;
    }

    @Override // com.baidu.tbadk.message.http.TbHttpResponsedMessage
    public void decodeInBackGround(int i, byte[] bArr) {
        GetConsentListResIdl getConsentListResIdl = (GetConsentListResIdl) new Wire(new Class[0]).parseFrom(bArr, GetConsentListResIdl.class);
        if (getConsentListResIdl != null) {
            if (getConsentListResIdl.error != null) {
                setError(getConsentListResIdl.error.errorno.intValue());
                setErrorString(getConsentListResIdl.error.usermsg);
            }
            if (getError() == 0 && getConsentListResIdl.data != null && getConsentListResIdl.data.page != null && getConsentListResIdl.data.consent != null) {
                this.mTotalNum = getConsentListResIdl.data.page.total_count.intValue();
                List<ConsentUser> list = getConsentListResIdl.data.consent;
                if (y.p(list) > 0) {
                    this.itemDataList = new ArrayList();
                    for (ConsentUser consentUser : list) {
                        if (consentUser != null) {
                            this.itemDataList.add(new a(String.valueOf(consentUser.user_id), consentUser.user_name, consentUser.portrait, consentUser.user_name_show, consentUser.create_time.intValue() * 1000));
                        }
                    }
                }
            }
        }
    }
}
