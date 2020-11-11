package com.baidu.tieba.pushdialog.data;

import com.baidu.tbadk.core.TbadkCoreApplication;
import com.baidu.tbadk.core.data.MetaData;
import tbclient.GetLockWindowMsg.DataRes;
/* loaded from: classes21.dex */
public class a {
    private String dialogTitle;
    private b mpA;
    private MetaData mpB;
    private String mpz;

    public String dze() {
        return this.dialogTitle;
    }

    public String dzf() {
        return this.mpz;
    }

    public b dzg() {
        return this.mpA;
    }

    public MetaData dzh() {
        return this.mpB;
    }

    public void a(DataRes dataRes) {
        if (dataRes != null) {
            this.dialogTitle = dataRes.publish_user;
            this.mpz = dataRes.publish_pic;
            this.mpB = new MetaData();
            this.mpB.parserProtobuf(dataRes.author);
            this.mpB.setPendantData(null);
            this.mpA = new b();
            this.mpA.a(TbadkCoreApplication.getInst(), dataRes.thread_info);
        }
    }
}
