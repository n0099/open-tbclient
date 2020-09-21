package com.baidu.tieba.pushdialog.data;

import com.baidu.tbadk.core.TbadkCoreApplication;
import com.baidu.tbadk.core.data.MetaData;
import tbclient.GetLockWindowMsg.DataRes;
/* loaded from: classes20.dex */
public class a {
    private String dialogTitle;
    private String lHN;
    private b lHO;
    private MetaData lHP;

    public String dpK() {
        return this.dialogTitle;
    }

    public String dpL() {
        return this.lHN;
    }

    public b dpM() {
        return this.lHO;
    }

    public MetaData dpN() {
        return this.lHP;
    }

    public void a(DataRes dataRes) {
        if (dataRes != null) {
            this.dialogTitle = dataRes.publish_user;
            this.lHN = dataRes.publish_pic;
            this.lHP = new MetaData();
            this.lHP.parserProtobuf(dataRes.author);
            this.lHP.setPendantData(null);
            this.lHO = new b();
            this.lHO.a(TbadkCoreApplication.getInst(), dataRes.thread_info);
        }
    }
}
