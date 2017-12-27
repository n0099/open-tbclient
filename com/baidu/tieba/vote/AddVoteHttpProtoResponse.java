package com.baidu.tieba.vote;

import com.baidu.adp.framework.message.HttpResponsedMessage;
import com.baidu.tbadk.core.frameworkData.CmdConfigHttp;
import com.squareup.wire.Wire;
import tbclient.AddPollPost.AddPollPostResIdl;
import tbclient.AddPollPost.DataRes;
/* loaded from: classes2.dex */
public class AddVoteHttpProtoResponse extends HttpResponsedMessage {
    private DataRes mData;

    public AddVoteHttpProtoResponse() {
        super(CmdConfigHttp.CMD_ADD_VOTE);
    }

    public AddVoteHttpProtoResponse(int i) {
        super(CmdConfigHttp.CMD_ADD_VOTE);
    }

    public DataRes getData() {
        return this.mData;
    }

    /* JADX DEBUG: Method merged with bridge method */
    @Override // com.baidu.adp.framework.message.a
    public void decodeInBackGround(int i, byte[] bArr) throws Exception {
        AddPollPostResIdl addPollPostResIdl = (AddPollPostResIdl) new Wire(new Class[0]).parseFrom(bArr, AddPollPostResIdl.class);
        if (addPollPostResIdl != null) {
            if (addPollPostResIdl.error != null) {
                setError(addPollPostResIdl.error.errorno.intValue());
                setErrorString(addPollPostResIdl.error.errmsg);
            }
            if (addPollPostResIdl.data != null) {
                this.mData = addPollPostResIdl.data;
            }
        }
    }
}
