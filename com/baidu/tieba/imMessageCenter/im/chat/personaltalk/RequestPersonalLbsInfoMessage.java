package com.baidu.tieba.imMessageCenter.im.chat.personaltalk;

import com.baidu.tbadk.message.websockt.TbSocketMessage;
import protobuf.SetLocation.DataReq;
import protobuf.SetLocation.SetLocationReqIdl;
/* loaded from: classes4.dex */
public class RequestPersonalLbsInfoMessage extends TbSocketMessage {
    public String lat;
    public String lng;
    public long touid;

    public RequestPersonalLbsInfoMessage(int i2, long j, String str, String str2) {
        super(i2);
        this.touid = j;
        this.lat = str;
        this.lng = str2;
    }

    @Override // com.baidu.tbadk.message.websockt.TbSocketMessage
    public Object encode() {
        DataReq.Builder builder = new DataReq.Builder();
        builder.toUid = Long.valueOf(this.touid);
        builder.lat = this.lat;
        builder.lng = this.lng;
        SetLocationReqIdl.Builder builder2 = new SetLocationReqIdl.Builder();
        builder2.data = builder.build(false);
        return builder2.build(false);
    }
}
