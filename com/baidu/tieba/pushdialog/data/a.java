package com.baidu.tieba.pushdialog.data;

import com.baidu.tbadk.core.TbadkCoreApplication;
import com.baidu.tbadk.core.data.MetaData;
import tbclient.GetLockWindowMsg.DataRes;
/* loaded from: classes6.dex */
public class a {
    private String dialogTitle;
    private String jBC;
    private b jBD;
    private MetaData jBE;

    public String czT() {
        return this.dialogTitle;
    }

    public String czU() {
        return this.jBC;
    }

    public b czV() {
        return this.jBD;
    }

    public MetaData czW() {
        return this.jBE;
    }

    public void a(DataRes dataRes) {
        if (dataRes != null) {
            this.dialogTitle = dataRes.publish_user;
            this.jBC = dataRes.publish_pic;
            this.jBE = new MetaData();
            this.jBE.parserProtobuf(dataRes.author);
            this.jBE.setPendantData(null);
            this.jBD = new b();
            this.jBD.a(TbadkCoreApplication.getInst(), dataRes.thread_info);
        }
    }
}
