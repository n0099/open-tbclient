package com.baidu.tieba.pushdialog.data;

import com.baidu.tbadk.core.TbadkCoreApplication;
import com.baidu.tbadk.core.data.MetaData;
import tbclient.GetLockWindowMsg.DataRes;
/* loaded from: classes20.dex */
public class a {
    private String dialogTitle;
    private String mpT;
    private b mpU;
    private MetaData mpV;

    public String dyE() {
        return this.dialogTitle;
    }

    public String dyF() {
        return this.mpT;
    }

    public b dyG() {
        return this.mpU;
    }

    public MetaData dyH() {
        return this.mpV;
    }

    public void a(DataRes dataRes) {
        if (dataRes != null) {
            this.dialogTitle = dataRes.publish_user;
            this.mpT = dataRes.publish_pic;
            this.mpV = new MetaData();
            this.mpV.parserProtobuf(dataRes.author);
            this.mpV.setPendantData(null);
            this.mpU = new b();
            this.mpU.a(TbadkCoreApplication.getInst(), dataRes.thread_info);
        }
    }
}
