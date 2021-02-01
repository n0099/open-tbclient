package com.baidu.tieba.pushdialog.data;

import com.baidu.tbadk.core.TbadkCoreApplication;
import com.baidu.tbadk.core.data.MetaData;
import tbclient.GetLockWindowMsg.DataRes;
/* loaded from: classes8.dex */
public class a {
    private String dialogTitle;
    private String mNP;
    private b mNQ;
    private MetaData mNR;

    public String dCe() {
        return this.dialogTitle;
    }

    public String dCf() {
        return this.mNP;
    }

    public b dCg() {
        return this.mNQ;
    }

    public MetaData dCh() {
        return this.mNR;
    }

    public void a(DataRes dataRes) {
        if (dataRes != null) {
            this.dialogTitle = dataRes.publish_user;
            this.mNP = dataRes.publish_pic;
            this.mNR = new MetaData();
            this.mNR.parserProtobuf(dataRes.author);
            this.mNR.setPendantData(null);
            this.mNQ = new b();
            this.mNQ.a(TbadkCoreApplication.getInst(), dataRes.thread_info);
        }
    }
}
