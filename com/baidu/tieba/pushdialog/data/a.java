package com.baidu.tieba.pushdialog.data;

import com.baidu.tbadk.core.TbadkCoreApplication;
import com.baidu.tbadk.core.data.MetaData;
import tbclient.GetLockWindowMsg.DataRes;
/* loaded from: classes8.dex */
public class a {
    private String dialogTitle;
    private String jCv;
    private b jCw;
    private MetaData jCx;

    public String cBq() {
        return this.dialogTitle;
    }

    public String cBr() {
        return this.jCv;
    }

    public b cBs() {
        return this.jCw;
    }

    public MetaData cBt() {
        return this.jCx;
    }

    public void a(DataRes dataRes) {
        if (dataRes != null) {
            this.dialogTitle = dataRes.publish_user;
            this.jCv = dataRes.publish_pic;
            this.jCx = new MetaData();
            this.jCx.parserProtobuf(dataRes.author);
            this.jCx.setPendantData(null);
            this.jCw = new b();
            this.jCw.a(TbadkCoreApplication.getInst(), dataRes.thread_info);
        }
    }
}
