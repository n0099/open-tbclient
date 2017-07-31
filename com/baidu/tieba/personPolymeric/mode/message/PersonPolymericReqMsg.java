package com.baidu.tieba.personPolymeric.mode.message;

import com.baidu.adp.framework.message.NetMessage;
import com.baidu.adp.lib.util.k;
import com.baidu.tbadk.core.TbadkCoreApplication;
import com.baidu.tbadk.core.frameworkData.CmdConfigHttp;
import com.baidu.tbadk.core.h;
import com.baidu.tbadk.util.n;
import com.baidu.tieba.personPolymeric.c.o;
import tbclient.Personal.DataReq;
import tbclient.Personal.PersonalReqIdl;
/* loaded from: classes.dex */
public class PersonPolymericReqMsg extends NetMessage {
    private o mPersonPolymericData;
    private int pn;
    private long uid;

    public PersonPolymericReqMsg() {
        super(CmdConfigHttp.CMD_PERSON_POLYMERIC, 309408);
    }

    public void setUid(long j) {
        this.uid = j;
    }

    public long getUid() {
        return this.uid;
    }

    public void setPn(int i) {
        this.pn = i;
    }

    public int getPn() {
        return this.pn;
    }

    public void setPersonPolymericData(o oVar) {
        this.mPersonPolymericData = oVar;
    }

    public o getPersonPolymericData() {
        return this.mPersonPolymericData;
    }

    @Override // com.baidu.adp.framework.message.NetMessage
    protected Object encode(boolean z) {
        DataReq.Builder builder = new DataReq.Builder();
        builder.uid = Long.valueOf(this.uid);
        builder.pn = Integer.valueOf(this.pn);
        builder.scr_w = Integer.valueOf(k.ag(TbadkCoreApplication.getInst().getApp()));
        builder.scr_h = Integer.valueOf(k.ah(TbadkCoreApplication.getInst().getApp()));
        builder.q_type = Integer.valueOf(h.oX().getViewImageQuality());
        builder.scr_dip = Double.valueOf(k.ai(TbadkCoreApplication.getInst().getApp()));
        if (z) {
            n.bindCommonParamsToProtobufData(builder, true);
        }
        PersonalReqIdl.Builder builder2 = new PersonalReqIdl.Builder();
        builder2.data = builder.build(false);
        return builder2.build(false);
    }
}
