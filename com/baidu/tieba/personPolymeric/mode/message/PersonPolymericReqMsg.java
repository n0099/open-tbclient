package com.baidu.tieba.personPolymeric.mode.message;

import com.baidu.adp.framework.message.NetMessage;
import com.baidu.tbadk.core.TbadkCoreApplication;
import com.baidu.tbadk.core.frameworkData.CmdConfigHttp;
import d.a.c.e.p.l;
import d.a.i0.r.k;
import d.a.i0.z0.w;
import d.a.j0.f2.b;
import tbclient.Personal.DataReq;
import tbclient.Personal.PersonalReqIdl;
/* loaded from: classes4.dex */
public class PersonPolymericReqMsg extends NetMessage {
    public int pn;
    public long uid;

    public PersonPolymericReqMsg() {
        super(CmdConfigHttp.CMD_PERSON_POLYMERIC, 309408);
    }

    @Override // com.baidu.adp.framework.message.NetMessage
    public Object encode(boolean z) {
        DataReq.Builder builder = new DataReq.Builder();
        builder.uid = Long.valueOf(this.uid);
        builder.pn = Integer.valueOf(this.pn);
        builder.scr_w = Integer.valueOf(l.k(TbadkCoreApplication.getInst().getApp()));
        builder.scr_h = Integer.valueOf(l.i(TbadkCoreApplication.getInst().getApp()));
        builder.q_type = Integer.valueOf(k.c().e());
        builder.scr_dip = Double.valueOf(l.h(TbadkCoreApplication.getInst().getApp()));
        if (z) {
            w.a(builder, true);
        }
        PersonalReqIdl.Builder builder2 = new PersonalReqIdl.Builder();
        builder2.data = builder.build(false);
        return builder2.build(false);
    }

    public b getPersonCenterData() {
        return null;
    }

    public int getPn() {
        return this.pn;
    }

    public long getUid() {
        return this.uid;
    }

    public void setPn(int i2) {
        this.pn = i2;
    }

    public void setUid(long j) {
        this.uid = j;
    }
}
