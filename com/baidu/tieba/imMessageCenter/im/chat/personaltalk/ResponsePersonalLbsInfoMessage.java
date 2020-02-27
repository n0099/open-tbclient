package com.baidu.tieba.imMessageCenter.im.chat.personaltalk;

import com.baidu.live.tbadk.core.frameworkdata.CmdConfigSocket;
import com.baidu.tbadk.message.websockt.TbSocketReponsedMessage;
import com.squareup.wire.Wire;
import protobuf.SetLocation.SetLocationResIdl;
/* loaded from: classes9.dex */
public class ResponsePersonalLbsInfoMessage extends TbSocketReponsedMessage {
    private com.baidu.tbadk.coreExtra.relationship.b lbsInfo;

    public ResponsePersonalLbsInfoMessage() {
        super(CmdConfigSocket.CMD_PERSONAL_CHAT_LBS_INFO);
    }

    /* JADX DEBUG: Method merged with bridge method */
    @Override // com.baidu.adp.framework.message.a
    public void decodeInBackGround(int i, byte[] bArr) throws Exception {
        int i2;
        String str;
        long j = 0;
        SetLocationResIdl setLocationResIdl = (SetLocationResIdl) new Wire(new Class[0]).parseFrom(bArr, SetLocationResIdl.class);
        String str2 = "";
        if (setLocationResIdl != null && setLocationResIdl.data != null) {
            if (setLocationResIdl.data.location != null) {
                str2 = setLocationResIdl.data.location.distance;
                if (setLocationResIdl.data.location.time != null && setLocationResIdl.data.location.time.longValue() > 0) {
                    j = setLocationResIdl.data.location.time.longValue();
                }
                if (setLocationResIdl.data.location.isHide != null && setLocationResIdl.data.location.isHide.intValue() >= 0) {
                    i2 = setLocationResIdl.data.location.isHide.intValue();
                    str = str2;
                    this.lbsInfo = new com.baidu.tbadk.coreExtra.relationship.b(str, j, i2);
                }
            }
            i2 = -1;
            str = str2;
            this.lbsInfo = new com.baidu.tbadk.coreExtra.relationship.b(str, j, i2);
        }
    }

    public com.baidu.tbadk.coreExtra.relationship.b getLbsInfo() {
        return this.lbsInfo;
    }

    public void setLbsInfo(com.baidu.tbadk.coreExtra.relationship.b bVar) {
        this.lbsInfo = bVar;
    }
}
