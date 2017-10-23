package com.baidu.tieba.personPolymeric.mode.message;

import com.baidu.adp.framework.message.NetMessage;
import com.baidu.adp.lib.util.l;
import com.baidu.tbadk.core.TbadkCoreApplication;
import com.baidu.tbadk.core.frameworkData.CmdConfigHttp;
import com.baidu.tbadk.core.h;
import com.baidu.tbadk.util.m;
import com.baidu.tieba.person.b;
import tbclient.Personal.DataReq;
import tbclient.Personal.PersonalReqIdl;
/* loaded from: classes.dex */
public class PersonPolymericReqMsg extends NetMessage {
    private b mPersonCenterData;
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

    public void setPersonCenterData(b bVar) {
        this.mPersonCenterData = bVar;
    }

    public b getPersonCenterData() {
        return this.mPersonCenterData;
    }

    @Override // com.baidu.adp.framework.message.NetMessage
    protected Object encode(boolean z) {
        DataReq.Builder builder = new DataReq.Builder();
        builder.uid = Long.valueOf(this.uid);
        builder.pn = Integer.valueOf(this.pn);
        builder.scr_w = Integer.valueOf(l.ad(TbadkCoreApplication.getInst().getApp()));
        builder.scr_h = Integer.valueOf(l.af(TbadkCoreApplication.getInst().getApp()));
        builder.q_type = Integer.valueOf(h.oM().getViewImageQuality());
        builder.scr_dip = Double.valueOf(l.ag(TbadkCoreApplication.getInst().getApp()));
        if (z) {
            m.bindCommonParamsToProtobufData(builder, true);
        }
        PersonalReqIdl.Builder builder2 = new PersonalReqIdl.Builder();
        builder2.data = builder.build(false);
        return builder2.build(false);
    }
}
