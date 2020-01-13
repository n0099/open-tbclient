package com.baidu.tieba.pushdialog.data;

import com.baidu.tbadk.core.TbadkCoreApplication;
import com.baidu.tbadk.core.data.MetaData;
import tbclient.GetLockWindowMsg.DataRes;
/* loaded from: classes6.dex */
public class a {
    private String dialogTitle;
    private String jBx;
    private b jBy;
    private MetaData jBz;

    public String czR() {
        return this.dialogTitle;
    }

    public String czS() {
        return this.jBx;
    }

    public b czT() {
        return this.jBy;
    }

    public MetaData czU() {
        return this.jBz;
    }

    public void a(DataRes dataRes) {
        if (dataRes != null) {
            this.dialogTitle = dataRes.publish_user;
            this.jBx = dataRes.publish_pic;
            this.jBz = new MetaData();
            this.jBz.parserProtobuf(dataRes.author);
            this.jBz.setPendantData(null);
            this.jBy = new b();
            this.jBy.a(TbadkCoreApplication.getInst(), dataRes.thread_info);
        }
    }
}
