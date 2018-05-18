package com.baidu.tieba.imMessageCenter.mention.agree.message;

import com.baidu.adp.framework.message.NetMessage;
import com.baidu.adp.lib.util.l;
import com.baidu.tbadk.core.TbadkCoreApplication;
import com.baidu.tbadk.core.frameworkData.CmdConfigHttp;
import com.baidu.tbadk.core.i;
import com.baidu.tbadk.util.o;
import tbclient.AgreeMe.AgreeMeReqIdl;
import tbclient.AgreeMe.DataReq;
/* loaded from: classes2.dex */
public class AgreeMeRequestMessage extends NetMessage {
    public long id;

    public AgreeMeRequestMessage() {
        super(CmdConfigHttp.AGREE_ME_HTTP_CMD, 309593);
    }

    @Override // com.baidu.adp.framework.message.NetMessage
    protected Object encode(boolean z) {
        try {
            DataReq.Builder builder = new DataReq.Builder();
            builder.id = Long.valueOf(this.id);
            builder.q_type = Integer.valueOf(i.pX().getViewImageQuality());
            builder.rn = 20;
            builder.scr_dip = Integer.valueOf((int) TbadkCoreApplication.getInst().getApp().getResources().getDisplayMetrics().density);
            builder.scr_h = Integer.valueOf(l.ah(TbadkCoreApplication.getInst().getApp()));
            builder.scr_w = Integer.valueOf(l.af(TbadkCoreApplication.getInst().getApp()));
            if (z) {
                o.bindCommonParamsToProtobufData(builder, true);
            }
            AgreeMeReqIdl.Builder builder2 = new AgreeMeReqIdl.Builder();
            builder2.data = builder.build(false);
            return builder2.build(false);
        } catch (Exception e) {
            return null;
        }
    }
}
