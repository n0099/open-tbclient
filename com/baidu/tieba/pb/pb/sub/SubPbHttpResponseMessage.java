package com.baidu.tieba.pb.pb.sub;

import android.content.Context;
import com.baidu.adp.lib.util.BdLog;
import com.baidu.tbadk.message.http.TbHttpResponsedMessage;
import com.baidu.tieba.pb.data.p;
import com.squareup.wire.Wire;
import tbclient.PbFloor.PbFloorResIdl;
/* loaded from: classes22.dex */
public class SubPbHttpResponseMessage extends TbHttpResponsedMessage {
    public p pbFloorData;
    private boolean treatDelPage;

    public boolean isTreatDelPage() {
        return this.treatDelPage;
    }

    public SubPbHttpResponseMessage(int i) {
        super(1002100);
        this.pbFloorData = null;
        this.treatDelPage = false;
    }

    /* JADX DEBUG: Method merged with bridge method */
    @Override // com.baidu.tbadk.message.http.TbHttpResponsedMessage, com.baidu.adp.framework.message.a
    public void decodeInBackGround(int i, byte[] bArr) throws Exception {
        Context context;
        p pVar = null;
        super.decodeInBackGround(i, bArr);
        Object extra = getOrginalMessage().getExtra();
        if (extra == null || !(extra instanceof SubPbRequestMessage)) {
            context = null;
        } else {
            SubPbRequestMessage subPbRequestMessage = (SubPbRequestMessage) extra;
            context = subPbRequestMessage.getRichTextClickListener();
            this.treatDelPage = subPbRequestMessage.isTreatDelPage();
        }
        try {
            PbFloorResIdl pbFloorResIdl = (PbFloorResIdl) new Wire(new Class[0]).parseFrom(bArr, PbFloorResIdl.class);
            if (pbFloorResIdl != null && pbFloorResIdl.data != null) {
                pVar = p.a(pbFloorResIdl.data, context);
                if (pVar != null) {
                    pVar.lCr = pbFloorResIdl.error;
                } else if (pbFloorResIdl.error != null) {
                    if (pbFloorResIdl.error.errorno != null) {
                        setError(pbFloorResIdl.error.errorno.intValue());
                    }
                    setErrorString(pbFloorResIdl.error.errmsg);
                }
            }
        } catch (Exception e) {
            BdLog.detailException(e);
        }
        this.pbFloorData = pVar;
    }
}
