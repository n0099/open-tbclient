package com.baidu.tieba.pushdialog.data;

import com.baidu.tbadk.core.TbadkCoreApplication;
import com.baidu.tbadk.core.data.MetaData;
import tbclient.GetLockWindowMsg.DataRes;
/* loaded from: classes8.dex */
public class a {
    private String dialogTitle;
    private String kFY;
    private b kFZ;
    private MetaData kGa;

    public String cTi() {
        return this.dialogTitle;
    }

    public String cTj() {
        return this.kFY;
    }

    public b cTk() {
        return this.kFZ;
    }

    public MetaData cTl() {
        return this.kGa;
    }

    public void a(DataRes dataRes) {
        if (dataRes != null) {
            this.dialogTitle = dataRes.publish_user;
            this.kFY = dataRes.publish_pic;
            this.kGa = new MetaData();
            this.kGa.parserProtobuf(dataRes.author);
            this.kGa.setPendantData(null);
            this.kFZ = new b();
            this.kFZ.a(TbadkCoreApplication.getInst(), dataRes.thread_info);
        }
    }
}
