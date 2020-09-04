package com.baidu.tieba.ueg;

import com.baidu.adp.framework.message.SocketResponsedMessage;
import com.baidu.tbadk.core.data.BlockPopInfoData;
import com.squareup.wire.Wire;
import tbclient.QueryBlockAndAppealInfo.QueryBlockAndAppealInfoResIdl;
/* loaded from: classes.dex */
public class UEGCancelSocketResponseMessage extends SocketResponsedMessage {
    private BlockPopInfoData info;

    public UEGCancelSocketResponseMessage() {
        super(309615);
    }

    /* JADX DEBUG: Method merged with bridge method */
    @Override // com.baidu.adp.framework.message.a
    public void decodeInBackGround(int i, byte[] bArr) throws Exception {
        QueryBlockAndAppealInfoResIdl queryBlockAndAppealInfoResIdl;
        if (bArr != null && (queryBlockAndAppealInfoResIdl = (QueryBlockAndAppealInfoResIdl) new Wire(new Class[0]).parseFrom(bArr, QueryBlockAndAppealInfoResIdl.class)) != null) {
            if (queryBlockAndAppealInfoResIdl.error != null && queryBlockAndAppealInfoResIdl.error.errorno != null) {
                setError(queryBlockAndAppealInfoResIdl.error.errorno.intValue());
            }
            if (queryBlockAndAppealInfoResIdl.error != null && queryBlockAndAppealInfoResIdl.error.usermsg != null && queryBlockAndAppealInfoResIdl.error.usermsg.length() > 0) {
                setErrorString(queryBlockAndAppealInfoResIdl.error.usermsg);
            }
            BlockPopInfoData blockPopInfoData = new BlockPopInfoData();
            blockPopInfoData.block_info = queryBlockAndAppealInfoResIdl.data.block_info;
            blockPopInfoData.ahead_info = queryBlockAndAppealInfoResIdl.data.ahead_info;
            blockPopInfoData.ahead_url = queryBlockAndAppealInfoResIdl.data.ahead_url;
            blockPopInfoData.ok_info = queryBlockAndAppealInfoResIdl.data.ok_info;
            blockPopInfoData.win_type = queryBlockAndAppealInfoResIdl.data.win_type.intValue();
            blockPopInfoData.block_id_code = queryBlockAndAppealInfoResIdl.data.block_id_code;
            setData(blockPopInfoData);
        }
    }

    public BlockPopInfoData getData() {
        return this.info;
    }

    public void setData(BlockPopInfoData blockPopInfoData) {
        this.info = blockPopInfoData;
    }
}
