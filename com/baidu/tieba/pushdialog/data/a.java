package com.baidu.tieba.pushdialog.data;

import com.baidu.tbadk.core.TbadkCoreApplication;
import com.baidu.tbadk.core.data.MetaData;
import tbclient.GetLockWindowMsg.DataRes;
/* loaded from: classes8.dex */
public class a {
    private String dialogTitle;
    private String jCH;
    private b jCI;
    private MetaData jCJ;

    public String cBr() {
        return this.dialogTitle;
    }

    public String cBs() {
        return this.jCH;
    }

    public b cBt() {
        return this.jCI;
    }

    public MetaData cBu() {
        return this.jCJ;
    }

    public void a(DataRes dataRes) {
        if (dataRes != null) {
            this.dialogTitle = dataRes.publish_user;
            this.jCH = dataRes.publish_pic;
            this.jCJ = new MetaData();
            this.jCJ.parserProtobuf(dataRes.author);
            this.jCJ.setPendantData(null);
            this.jCI = new b();
            this.jCI.a(TbadkCoreApplication.getInst(), dataRes.thread_info);
        }
    }
}
