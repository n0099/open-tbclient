package com.baidu.tieba.personPolymeric.mode.message;

import com.baidu.adp.framework.message.NetMessage;
import com.baidu.adp.lib.util.l;
import com.baidu.live.tbadk.core.frameworkdata.CmdConfigSocket;
import com.baidu.tbadk.core.TbadkCoreApplication;
import com.baidu.tbadk.core.k;
import com.baidu.tbadk.util.t;
import com.baidu.tieba.person.b;
import tbclient.Personal.DataReq;
import tbclient.Personal.PersonalReqIdl;
/* loaded from: classes18.dex */
public class PersonPolymericReqMsg extends NetMessage {
    private int pn;
    private long uid;

    public PersonPolymericReqMsg() {
        super(1003181, CmdConfigSocket.CMD_PERSON_POLYMERIC);
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

    public b getPersonCenterData() {
        return null;
    }

    @Override // com.baidu.adp.framework.message.NetMessage
    protected Object encode(boolean z) {
        DataReq.Builder builder = new DataReq.Builder();
        builder.uid = Long.valueOf(this.uid);
        builder.pn = Integer.valueOf(this.pn);
        builder.scr_w = Integer.valueOf(l.getEquipmentWidth(TbadkCoreApplication.getInst().getApp()));
        builder.scr_h = Integer.valueOf(l.getEquipmentHeight(TbadkCoreApplication.getInst().getApp()));
        builder.q_type = Integer.valueOf(k.bbM().getViewImageQuality());
        builder.scr_dip = Double.valueOf(l.getEquipmentDensity(TbadkCoreApplication.getInst().getApp()));
        if (z) {
            t.a(builder, true);
        }
        PersonalReqIdl.Builder builder2 = new PersonalReqIdl.Builder();
        builder2.data = builder.build(false);
        return builder2.build(false);
    }
}
