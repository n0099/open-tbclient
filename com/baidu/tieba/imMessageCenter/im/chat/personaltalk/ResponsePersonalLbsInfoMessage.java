package com.baidu.tieba.imMessageCenter.im.chat.personaltalk;

import com.baidu.tbadk.message.websockt.TbSocketReponsedMessage;
import com.squareup.wire.Wire;
import d.a.i0.s.f.b;
import protobuf.SetLocation.DataRes;
import protobuf.SetLocation.LbsInfo;
import protobuf.SetLocation.SetLocationResIdl;
/* loaded from: classes4.dex */
public class ResponsePersonalLbsInfoMessage extends TbSocketReponsedMessage {
    public b lbsInfo;

    public ResponsePersonalLbsInfoMessage() {
        super(205101);
    }

    public b getLbsInfo() {
        return this.lbsInfo;
    }

    public void setLbsInfo(b bVar) {
        this.lbsInfo = bVar;
    }

    /* JADX DEBUG: Method merged with bridge method */
    @Override // com.baidu.tbadk.message.websockt.TbSocketReponsedMessage, com.baidu.adp.framework.message.SocketResponsedMessage, com.baidu.adp.framework.message.ResponsedMessage
    public void decodeInBackGround(int i2, byte[] bArr) throws Exception {
        DataRes dataRes;
        String str;
        SetLocationResIdl setLocationResIdl = (SetLocationResIdl) new Wire(new Class[0]).parseFrom(bArr, SetLocationResIdl.class);
        if (setLocationResIdl == null || (dataRes = setLocationResIdl.data) == null) {
            return;
        }
        LbsInfo lbsInfo = dataRes.location;
        long j = 0;
        int i3 = -1;
        if (lbsInfo != null) {
            str = lbsInfo.distance;
            Long l = lbsInfo.time;
            if (l != null && l.longValue() > 0) {
                j = setLocationResIdl.data.location.time.longValue();
            }
            Integer num = setLocationResIdl.data.location.isHide;
            if (num != null && num.intValue() >= 0) {
                i3 = setLocationResIdl.data.location.isHide.intValue();
            }
        } else {
            str = "";
        }
        this.lbsInfo = new b(str, j, i3);
    }
}
