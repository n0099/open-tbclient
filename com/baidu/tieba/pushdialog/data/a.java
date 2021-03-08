package com.baidu.tieba.pushdialog.data;

import com.baidu.tbadk.core.TbadkCoreApplication;
import com.baidu.tbadk.core.data.MetaData;
import tbclient.GetLockWindowMsg.DataRes;
/* loaded from: classes7.dex */
public class a {
    private String dialogTitle;
    private String mQi;
    private b mQj;
    private MetaData mQl;

    public String dCt() {
        return this.dialogTitle;
    }

    public String dCu() {
        return this.mQi;
    }

    public b dCv() {
        return this.mQj;
    }

    public MetaData dCw() {
        return this.mQl;
    }

    public void a(DataRes dataRes) {
        if (dataRes != null) {
            this.dialogTitle = dataRes.publish_user;
            this.mQi = dataRes.publish_pic;
            this.mQl = new MetaData();
            this.mQl.parserProtobuf(dataRes.author);
            this.mQl.setPendantData(null);
            this.mQj = new b();
            this.mQj.a(TbadkCoreApplication.getInst(), dataRes.thread_info);
        }
    }
}
