package com.baidu.tieba.pushdialog.data;

import com.baidu.tbadk.core.TbadkCoreApplication;
import com.baidu.tbadk.core.data.MetaData;
import tbclient.GetLockWindowMsg.DataRes;
/* loaded from: classes21.dex */
public class a {
    private String dialogTitle;
    private String lXb;
    private b lXc;
    private MetaData lXd;

    public String dtv() {
        return this.dialogTitle;
    }

    public String dtw() {
        return this.lXb;
    }

    public b dtx() {
        return this.lXc;
    }

    public MetaData dty() {
        return this.lXd;
    }

    public void a(DataRes dataRes) {
        if (dataRes != null) {
            this.dialogTitle = dataRes.publish_user;
            this.lXb = dataRes.publish_pic;
            this.lXd = new MetaData();
            this.lXd.parserProtobuf(dataRes.author);
            this.lXd.setPendantData(null);
            this.lXc = new b();
            this.lXc.a(TbadkCoreApplication.getInst(), dataRes.thread_info);
        }
    }
}
