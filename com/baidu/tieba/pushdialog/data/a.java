package com.baidu.tieba.pushdialog.data;

import com.baidu.tbadk.core.TbadkCoreApplication;
import com.baidu.tbadk.core.data.MetaData;
import tbclient.GetLockWindowMsg.DataRes;
/* loaded from: classes3.dex */
public class a {
    private String iCA;
    private String iCB;
    private b iCC;
    private MetaData iCD;

    public String cgB() {
        return this.iCA;
    }

    public String cgC() {
        return this.iCB;
    }

    public b cgD() {
        return this.iCC;
    }

    public MetaData cgE() {
        return this.iCD;
    }

    public void a(DataRes dataRes) {
        if (dataRes != null) {
            this.iCA = dataRes.publish_user;
            this.iCB = dataRes.publish_pic;
            this.iCD = new MetaData();
            this.iCD.parserProtobuf(dataRes.author);
            this.iCD.setPendantData(null);
            this.iCC = new b();
            this.iCC.a(TbadkCoreApplication.getInst(), dataRes.thread_info);
        }
    }
}
