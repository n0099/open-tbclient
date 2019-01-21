package com.baidu.tieba.pushdialog.data;

import com.baidu.tbadk.core.TbadkCoreApplication;
import com.baidu.tbadk.core.data.MetaData;
import tbclient.GetLockWindowMsg.DataRes;
/* loaded from: classes3.dex */
public class a {
    private String gMr;
    private String gMs;
    private b gMt;
    private MetaData gMu;

    public String buU() {
        return this.gMr;
    }

    public String buV() {
        return this.gMs;
    }

    public b buW() {
        return this.gMt;
    }

    public MetaData buX() {
        return this.gMu;
    }

    public void a(DataRes dataRes) {
        if (dataRes != null) {
            this.gMr = dataRes.publish_user;
            this.gMs = dataRes.publish_pic;
            this.gMu = new MetaData();
            this.gMu.parserProtobuf(dataRes.author);
            this.gMu.setPendantData(null);
            this.gMt = new b();
            this.gMt.a(TbadkCoreApplication.getInst(), dataRes.thread_info);
        }
    }
}
