package com.baidu.tieba.pushdialog.data;

import com.baidu.tbadk.core.TbadkCoreApplication;
import com.baidu.tbadk.core.data.MetaData;
import tbclient.GetLockWindowMsg.DataRes;
/* loaded from: classes3.dex */
public class a {
    private String gAd;
    private String gAe;
    private b gAf;
    private MetaData gAg;

    public String bsl() {
        return this.gAd;
    }

    public String bsm() {
        return this.gAe;
    }

    public b bsn() {
        return this.gAf;
    }

    public MetaData bso() {
        return this.gAg;
    }

    public void a(DataRes dataRes) {
        if (dataRes != null) {
            this.gAd = dataRes.publish_user;
            this.gAe = dataRes.publish_pic;
            this.gAg = new MetaData();
            this.gAg.parserProtobuf(dataRes.author);
            this.gAg.setPendantData(null);
            this.gAf = new b();
            this.gAf.a(TbadkCoreApplication.getInst(), dataRes.thread_info);
        }
    }
}
