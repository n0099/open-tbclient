package com.baidu.tieba.pb.sub;

import android.content.Context;
import com.baidu.adp.framework.message.SocketResponsedMessage;
import com.baidu.adp.lib.util.BdLog;
import com.baidu.tieba.data.au;
import com.squareup.wire.Wire;
import tbclient.PbFloor.PbFloorResIdl;
/* loaded from: classes.dex */
public class SubPbSocketResponseMessage extends SocketResponsedMessage {
    public au pbFloorData;
    private boolean treatDelPage;

    public boolean isTreatDelPage() {
        return this.treatDelPage;
    }

    public SubPbSocketResponseMessage() {
        super(302002);
        this.pbFloorData = null;
        this.treatDelPage = false;
    }

    /* JADX DEBUG: Method merged with bridge method */
    @Override // com.baidu.adp.framework.message.b
    public void decodeInBackGround(int i, byte[] bArr) {
        Context context;
        au auVar = null;
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
