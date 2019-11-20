package com.baidu.tieba.pushdialog.data;

import com.baidu.tbadk.core.TbadkCoreApplication;
import com.baidu.tbadk.core.data.MetaData;
import tbclient.GetLockWindowMsg.DataRes;
/* loaded from: classes3.dex */
public class a {
    private String dialogTitle;
    private String iDB;
    private b iDC;
    private MetaData iDD;

    public String ceE() {
        return this.dialogTitle;
    }

    public String ceF() {
        return this.iDB;
    }

    public b ceG() {
        return this.iDC;
    }

    public MetaData ceH() {
        return this.iDD;
    }

    public void a(DataRes dataRes) {
        if (dataRes != null) {
            this.dialogTitle = dataRes.publish_user;
            this.iDB = dataRes.publish_pic;
            this.iDD = new MetaData();
            this.iDD.parserProtobuf(dataRes.author);
            this.iDD.setPendantData(null);
            this.iDC = new b();
            this.iDC.a(TbadkCoreApplication.getInst(), dataRes.thread_info);
        }
    }
}
