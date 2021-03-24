package com.baidu.tieba.ueg;

import com.baidu.tbadk.core.data.BlockPopInfoData;
import com.baidu.tbadk.core.frameworkData.CmdConfigHttp;
import com.baidu.tbadk.message.http.TbHttpResponsedMessage;
import com.squareup.wire.Wire;
import tbclient.Error;
import tbclient.QueryBlockAndAppealInfo.DataRes;
import tbclient.QueryBlockAndAppealInfo.QueryBlockAndAppealInfoResIdl;
/* loaded from: classes5.dex */
public class UEGCancelResponsedMessage extends TbHttpResponsedMessage {
    public BlockPopInfoData info;

    public UEGCancelResponsedMessage() {
        super(CmdConfigHttp.CMD_UEG_CANCEL);
    }

    public BlockPopInfoData getData() {
        return this.info;
    }

    public void setData(BlockPopInfoData blockPopInfoData) {
        this.info = blockPopInfoData;
    }

    /* JADX DEBUG: Method merged with bridge method */
    @Override // com.baidu.tbadk.message.http.TbHttpResponsedMessage, com.baidu.adp.framework.message.HttpResponsedMessage, com.baidu.adp.framework.message.ResponsedMessage
    public void decodeInBackGround(int i, byte[] bArr) throws Exception {
        QueryBlockAndAppealInfoResIdl queryBlockAndAppealInfoResIdl;
        String str;
        Integer num;
        if (bArr == null || (queryBlockAndAppealInfoResIdl = (QueryBlockAndAppealInfoResIdl) new Wire(new Class[0]).parseFrom(bArr, QueryBlockAndAppealInfoResIdl.class)) == null) {
            return;
        }
        Error error = queryBlockAndAppealInfoResIdl.error;
        if (error != null && (num = error.errorno) != null) {
            setError(num.intValue());
        }
        Error error2 = queryBlockAndAppealInfoResIdl.error;
        if (error2 != null && (str = error2.usermsg) != null && str.length() > 0) {
            setErrorString(queryBlockAndAppealInfoResIdl.error.usermsg);
        }
        if (queryBlockAndAppealInfoResIdl.data == null) {
            return;
        }
        BlockPopInfoData blockPopInfoData = new BlockPopInfoData();
        DataRes dataRes = queryBlockAndAppealInfoResIdl.data;
        blockPopInfoData.block_info = dataRes.block_info;
        blockPopInfoData.ahead_info = dataRes.ahead_info;
        blockPopInfoData.ahead_url = dataRes.ahead_url;
        blockPopInfoData.ok_info = dataRes.ok_info;
        blockPopInfoData.win_type = dataRes.win_type.intValue();
        blockPopInfoData.block_id_code = queryBlockAndAppealInfoResIdl.data.block_id_code;
        setData(blockPopInfoData);
    }
}
