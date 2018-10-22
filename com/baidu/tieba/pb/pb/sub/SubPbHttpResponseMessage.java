package com.baidu.tieba.pb.pb.sub;

import android.content.Context;
import com.baidu.adp.lib.util.BdLog;
import com.baidu.tbadk.core.frameworkData.CmdConfigHttp;
import com.baidu.tbadk.message.http.TbHttpResponsedMessage;
import com.baidu.tieba.pb.data.j;
import com.squareup.wire.Wire;
import tbclient.PbFloor.PbFloorResIdl;
/* loaded from: classes6.dex */
public class SubPbHttpResponseMessage extends TbHttpResponsedMessage {
    public j pbFloorData;
    private boolean treatDelPage;

    public boolean isTreatDelPage() {
        return this.treatDelPage;
    }

    public SubPbHttpResponseMessage(int i) {
        super(CmdConfigHttp.SubPb_HTTP_CMD);
        this.pbFloorData = null;
        this.treatDelPage = false;
    }

    /* JADX DEBUG: Method merged with bridge method */
    @Override // com.baidu.tbadk.message.http.TbHttpResponsedMessage, com.baidu.adp.framework.message.a
    public void decodeInBackGround(int i, byte[] bArr) throws Exception {
        Context context;
        j jVar = null;
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
                jVar = j.a(pbFloorResIdl.data, context);
                if (jVar != null) {
                    jVar.fIF = pbFloorResIdl.error;
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
        this.pbFloorData = jVar;
    }
}
