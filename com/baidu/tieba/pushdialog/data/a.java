package com.baidu.tieba.pushdialog.data;

import com.baidu.tbadk.core.TbadkCoreApplication;
import com.baidu.tbadk.core.data.MetaData;
import tbclient.GetLockWindowMsg.DataRes;
/* loaded from: classes3.dex */
public class a {
    private String iDE;
    private String iDF;
    private b iDG;
    private MetaData iDH;

    public String cgT() {
        return this.iDE;
    }

    public String cgU() {
        return this.iDF;
    }

    public b cgV() {
        return this.iDG;
    }

    public MetaData cgW() {
        return this.iDH;
    }

    public void a(DataRes dataRes) {
        if (dataRes != null) {
            this.iDE = dataRes.publish_user;
            this.iDF = dataRes.publish_pic;
            this.iDH = new MetaData();
            this.iDH.parserProtobuf(dataRes.author);
            this.iDH.setPendantData(null);
            this.iDG = new b();
            this.iDG.a(TbadkCoreApplication.getInst(), dataRes.thread_info);
        }
    }
}
