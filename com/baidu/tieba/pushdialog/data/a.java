package com.baidu.tieba.pushdialog.data;

import com.baidu.tbadk.core.TbadkCoreApplication;
import com.baidu.tbadk.core.data.MetaData;
import tbclient.GetLockWindowMsg.DataRes;
/* loaded from: classes3.dex */
public class a {
    private String dialogTitle;
    private String iEs;
    private b iEt;
    private MetaData iEu;

    public String ceG() {
        return this.dialogTitle;
    }

    public String ceH() {
        return this.iEs;
    }

    public b ceI() {
        return this.iEt;
    }

    public MetaData ceJ() {
        return this.iEu;
    }

    public void a(DataRes dataRes) {
        if (dataRes != null) {
            this.dialogTitle = dataRes.publish_user;
            this.iEs = dataRes.publish_pic;
            this.iEu = new MetaData();
            this.iEu.parserProtobuf(dataRes.author);
            this.iEu.setPendantData(null);
            this.iEt = new b();
            this.iEt.a(TbadkCoreApplication.getInst(), dataRes.thread_info);
        }
    }
}
