package com.baidu.tieba.pushdialog.data;

import com.baidu.tbadk.core.TbadkCoreApplication;
import com.baidu.tbadk.core.data.MetaData;
import tbclient.GetLockWindowMsg.DataRes;
/* loaded from: classes8.dex */
public class a {
    private String dialogTitle;
    private String kHg;
    private b kHh;
    private MetaData kHi;

    public String cTy() {
        return this.dialogTitle;
    }

    public String cTz() {
        return this.kHg;
    }

    public b cTA() {
        return this.kHh;
    }

    public MetaData cTB() {
        return this.kHi;
    }

    public void a(DataRes dataRes) {
        if (dataRes != null) {
            this.dialogTitle = dataRes.publish_user;
            this.kHg = dataRes.publish_pic;
            this.kHi = new MetaData();
            this.kHi.parserProtobuf(dataRes.author);
            this.kHi.setPendantData(null);
            this.kHh = new b();
            this.kHh.a(TbadkCoreApplication.getInst(), dataRes.thread_info);
        }
    }
}
