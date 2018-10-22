package com.baidu.tieba.pushdialog.data;

import com.baidu.tbadk.core.TbadkCoreApplication;
import com.baidu.tbadk.core.data.MetaData;
import tbclient.GetLockWindowMsg.DataRes;
/* loaded from: classes3.dex */
public class a {
    private String gAe;
    private String gAf;
    private b gAg;
    private MetaData gAh;

    public String bsl() {
        return this.gAe;
    }

    public String bsm() {
        return this.gAf;
    }

    public b bsn() {
        return this.gAg;
    }

    public MetaData bso() {
        return this.gAh;
    }

    public void a(DataRes dataRes) {
        if (dataRes != null) {
            this.gAe = dataRes.publish_user;
            this.gAf = dataRes.publish_pic;
            this.gAh = new MetaData();
            this.gAh.parserProtobuf(dataRes.author);
            this.gAh.setPendantData(null);
            this.gAg = new b();
            this.gAg.a(TbadkCoreApplication.getInst(), dataRes.thread_info);
        }
    }
}
