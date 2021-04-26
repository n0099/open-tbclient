package com.baidu.tieba.pb.pb.main.relatelist;

import com.baidu.tbadk.core.frameworkData.CmdConfigHttp;
import com.baidu.tbadk.message.http.TbHttpResponsedMessage;
import com.squareup.wire.Wire;
import tbclient.RelateRecThread.DataRes;
import tbclient.RelateRecThread.RelateRecThreadResIdl;
/* loaded from: classes3.dex */
public class RelateRecThreadHttpResponseMessage extends TbHttpResponsedMessage {
    public DataRes mData;

    public RelateRecThreadHttpResponseMessage() {
        super(CmdConfigHttp.CMD_RELATE_REC_THREAD);
    }

    public DataRes getData() {
        return this.mData;
    }

    /* JADX DEBUG: Method merged with bridge method */
    @Override // com.baidu.tbadk.message.http.TbHttpResponsedMessage, com.baidu.adp.framework.message.HttpResponsedMessage, com.baidu.adp.framework.message.ResponsedMessage
    public void decodeInBackGround(int i2, byte[] bArr) throws Exception {
        try {
            RelateRecThreadResIdl relateRecThreadResIdl = (RelateRecThreadResIdl) new Wire(new Class[0]).parseFrom(bArr, RelateRecThreadResIdl.class);
            if (relateRecThreadResIdl != null && relateRecThreadResIdl.error != null) {
                setError(relateRecThreadResIdl.error.errorno.intValue());
                setErrorString(relateRecThreadResIdl.error.usermsg);
            }
            if (relateRecThreadResIdl != null) {
                this.mData = relateRecThreadResIdl.data;
            }
        } catch (Exception e2) {
            e2.printStackTrace();
            setError(-2);
        }
    }
}
