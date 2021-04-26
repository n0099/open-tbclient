package com.baidu.tieba.pb.pb.sub;

import android.content.Context;
import com.baidu.adp.lib.util.BdLog;
import com.baidu.tbadk.core.frameworkData.CmdConfigHttp;
import com.baidu.tbadk.message.http.TbHttpResponsedMessage;
import com.squareup.wire.Wire;
import d.a.j0.d2.h.q;
import tbclient.PbFloor.PbFloorResIdl;
/* loaded from: classes3.dex */
public class SubPbHttpResponseMessage extends TbHttpResponsedMessage {
    public q pbFloorData;
    public boolean treatDelPage;

    public SubPbHttpResponseMessage(int i2) {
        super(CmdConfigHttp.SubPb_HTTP_CMD);
        this.pbFloorData = null;
        this.treatDelPage = false;
    }

    public boolean isTreatDelPage() {
        return this.treatDelPage;
    }

    /* JADX DEBUG: Method merged with bridge method */
    @Override // com.baidu.tbadk.message.http.TbHttpResponsedMessage, com.baidu.adp.framework.message.HttpResponsedMessage, com.baidu.adp.framework.message.ResponsedMessage
    public void decodeInBackGround(int i2, byte[] bArr) throws Exception {
        Context context;
        super.decodeInBackGround(i2, bArr);
        Object extra = getOrginalMessage().getExtra();
        q qVar = null;
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
                qVar = q.w(pbFloorResIdl.data, context);
                if (qVar != null) {
                    qVar.m = pbFloorResIdl.error;
                } else if (pbFloorResIdl.error != null) {
                    if (pbFloorResIdl.error.errorno != null) {
                        setError(pbFloorResIdl.error.errorno.intValue());
                    }
                    setErrorString(pbFloorResIdl.error.errmsg);
                }
            }
        } catch (Exception e2) {
            BdLog.detailException(e2);
        }
        this.pbFloorData = qVar;
    }
}
