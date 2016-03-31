package com.baidu.tieba.pb.pb.main;

import com.baidu.tbadk.core.util.TbErrInfo;
import com.baidu.tbadk.message.http.TbHttpResponsedMessage;
import com.squareup.wire.Wire;
import tbclient.Lottery.LotteryResIdl;
/* loaded from: classes.dex */
public class PbLotteryHttpResponseMessage extends TbHttpResponsedMessage {
    public static final int LOTTERY_TYPE_INVLIDATE = 5;
    public static final int LOTTERY_TYPE_NO_PRIZE_HAS_CHANCE = 1;
    public static final int LOTTERY_TYPE_NO_PRIZE_NO_CHANCE_CANNOT_GET_CHANCE = 3;
    public static final int LOTTERY_TYPE_NO_PRIZE_NO_CHANCE_CAN_GET_CHANCE = 4;
    public static final int LOTTERY_TYPE_UNLIKE = 2;
    public static final int LOTTERY_TYPE_WIN_PRIZE = 0;
    private com.baidu.tieba.pb.data.b mLotteryInfo;

    public PbLotteryHttpResponseMessage(int i) {
        super(i);
    }

    @Override // com.baidu.tbadk.message.http.TbHttpResponsedMessage
    public void decodeInBackGround(int i, byte[] bArr) {
        LotteryResIdl lotteryResIdl = (LotteryResIdl) new Wire(new Class[0]).parseFrom(bArr, LotteryResIdl.class);
        if (lotteryResIdl.error != null) {
            setError(lotteryResIdl.error.errorno.intValue());
            setErrorString(lotteryResIdl.error.errmsg);
        }
        if (lotteryResIdl.data != null) {
            this.mLotteryInfo = com.baidu.tieba.pb.data.b.a(lotteryResIdl.data);
        }
    }

    public com.baidu.tieba.pb.data.b getLotteryInfo() {
        return this.mLotteryInfo;
    }

    public int getType() {
        if (getError() != 0 || getLotteryInfo() == null) {
            return 5;
        }
        switch (getLotteryInfo().getStatus()) {
            case 0:
                return (this.mLotteryInfo.avp() == null || !(this.mLotteryInfo.avp().avm() == 1 || this.mLotteryInfo.avp().avm() == 2)) ? 1 : 0;
            case TbErrInfo.ERR_NO_LOTTERY_CHANCE /* 2390003 */:
                if (this.mLotteryInfo.avq() != null && this.mLotteryInfo.avq().getEnableGetChance() > 0) {
                    return 4;
                }
                return 3;
            case TbErrInfo.ERR_LOTTERY_UNLIKE_FORUM /* 3110004 */:
                return 2;
            default:
                return 5;
        }
    }
}
