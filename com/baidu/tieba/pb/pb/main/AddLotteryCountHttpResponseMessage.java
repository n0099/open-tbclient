package com.baidu.tieba.pb.pb.main;

import com.baidu.tbadk.message.http.TbHttpResponsedMessage;
import com.squareup.wire.Wire;
import tbclient.AddLotteryCount.AddLotteryCountResIdl;
/* loaded from: classes.dex */
public class AddLotteryCountHttpResponseMessage extends TbHttpResponsedMessage {
    private int mEnableGetChance;

    public int getEnableGetChance() {
        return this.mEnableGetChance;
    }

    public AddLotteryCountHttpResponseMessage(int i) {
        super(i);
    }

    @Override // com.baidu.tbadk.message.http.TbHttpResponsedMessage
    public void decodeInBackGround(int i, byte[] bArr) {
        AddLotteryCountResIdl addLotteryCountResIdl = (AddLotteryCountResIdl) new Wire(new Class[0]).parseFrom(bArr, AddLotteryCountResIdl.class);
        if (addLotteryCountResIdl != null) {
            if (addLotteryCountResIdl.error != null) {
                setError(addLotteryCountResIdl.error.errorno.intValue());
                setErrorString(addLotteryCountResIdl.error.errmsg);
            }
            if (addLotteryCountResIdl.data != null) {
                this.mEnableGetChance = addLotteryCountResIdl.data.enable_get_chance.intValue();
            }
        }
    }
}
