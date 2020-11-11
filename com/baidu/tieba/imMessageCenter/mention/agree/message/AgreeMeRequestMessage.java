package com.baidu.tieba.imMessageCenter.mention.agree.message;

import com.baidu.adp.framework.message.NetMessage;
import com.baidu.adp.lib.util.l;
import com.baidu.live.tbadk.core.frameworkdata.CmdConfigSocket;
import com.baidu.tbadk.core.TbadkCoreApplication;
import com.baidu.tbadk.core.k;
import com.baidu.tbadk.util.u;
import tbclient.AgreeMe.AgreeMeReqIdl;
import tbclient.AgreeMe.DataReq;
/* loaded from: classes22.dex */
public class AgreeMeRequestMessage extends NetMessage {
    public long id;

    public AgreeMeRequestMessage() {
        super(1002211, CmdConfigSocket.CMD_AGREE_ME);
    }

    @Override // com.baidu.adp.framework.message.NetMessage
    protected Object encode(boolean z) {
        try {
            DataReq.Builder builder = new DataReq.Builder();
            builder.id = Long.valueOf(this.id);
            builder.q_type = Integer.valueOf(k.bjH().getViewImageQuality());
            builder.rn = 20;
            builder.scr_dip = Integer.valueOf((int) TbadkCoreApplication.getInst().getApp().getResources().getDisplayMetrics().density);
            builder.scr_h = Integer.valueOf(l.getEquipmentHeight(TbadkCoreApplication.getInst().getApp()));
            builder.scr_w = Integer.valueOf(l.getEquipmentWidth(TbadkCoreApplication.getInst().getApp()));
            if (z) {
                u.a(builder, true);
            }
            AgreeMeReqIdl.Builder builder2 = new AgreeMeReqIdl.Builder();
            builder2.data = builder.build(false);
            return builder2.build(false);
        } catch (Exception e) {
            return null;
        }
    }
}
