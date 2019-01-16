package com.baidu.tieba.pushdialog.data;

import com.baidu.tbadk.core.TbadkCoreApplication;
import com.baidu.tbadk.core.data.MetaData;
import tbclient.GetLockWindowMsg.DataRes;
/* loaded from: classes3.dex */
public class a {
    private String gMq;
    private String gMr;
    private b gMs;
    private MetaData gMt;

    public String buU() {
        return this.gMq;
    }

    public String buV() {
        return this.gMr;
    }

    public b buW() {
        return this.gMs;
    }

    public MetaData buX() {
        return this.gMt;
    }

    public void a(DataRes dataRes) {
        if (dataRes != null) {
            this.gMq = dataRes.publish_user;
            this.gMr = dataRes.publish_pic;
            this.gMt = new MetaData();
            this.gMt.parserProtobuf(dataRes.author);
            this.gMt.setPendantData(null);
            this.gMs = new b();
            this.gMs.a(TbadkCoreApplication.getInst(), dataRes.thread_info);
        }
    }
}
