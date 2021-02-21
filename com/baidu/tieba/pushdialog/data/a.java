package com.baidu.tieba.pushdialog.data;

import com.baidu.tbadk.core.TbadkCoreApplication;
import com.baidu.tbadk.core.data.MetaData;
import tbclient.GetLockWindowMsg.DataRes;
/* loaded from: classes8.dex */
public class a {
    private String dialogTitle;
    private String mOe;
    private b mOf;
    private MetaData mOg;

    public String dCl() {
        return this.dialogTitle;
    }

    public String dCm() {
        return this.mOe;
    }

    public b dCn() {
        return this.mOf;
    }

    public MetaData dCo() {
        return this.mOg;
    }

    public void a(DataRes dataRes) {
        if (dataRes != null) {
            this.dialogTitle = dataRes.publish_user;
            this.mOe = dataRes.publish_pic;
            this.mOg = new MetaData();
            this.mOg.parserProtobuf(dataRes.author);
            this.mOg.setPendantData(null);
            this.mOf = new b();
            this.mOf.a(TbadkCoreApplication.getInst(), dataRes.thread_info);
        }
    }
}
