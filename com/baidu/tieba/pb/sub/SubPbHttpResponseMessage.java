package com.baidu.tieba.pb.sub;

import android.content.Context;
import com.baidu.adp.lib.util.BdLog;
import com.baidu.tbadk.message.http.TbHttpResponsedMessage;
import com.baidu.tieba.data.au;
import com.squareup.wire.Wire;
import tbclient.PbFloor.PbFloorResIdl;
/* loaded from: classes.dex */
public class SubPbHttpResponseMessage extends TbHttpResponsedMessage {
    public au pbFloorData;
    private boolean treatDelPage;

    public boolean isTreatDelPage() {
        return this.treatDelPage;
    }

    public SubPbHttpResponseMessage(int i) {
        super(1002100);
        this.pbFloorData = null;
        this.treatDelPage = false;
    }

    @Override // com.baidu.tbadk.message.http.TbHttpResponsedMessage
    public void decodeInBackGround(int i, byte[] bArr) {
        Context context;
        au auVar = null;
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
                auVar = au.a(pbFloorResIdl.data, context);
                auVar.a = pbFloorResIdl.error;
            }
        } catch (Exception e) {
            BdLog.detailException(e);
        }
        this.pbFloorData = auVar;
    }
}
