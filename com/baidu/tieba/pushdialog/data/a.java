package com.baidu.tieba.pushdialog.data;

import com.baidu.tbadk.core.TbadkCoreApplication;
import com.baidu.tbadk.core.data.MetaData;
import tbclient.GetLockWindowMsg.DataRes;
/* loaded from: classes8.dex */
public class a {
    private String dialogTitle;
    private String jCt;
    private b jCu;
    private MetaData jCv;

    public String cBo() {
        return this.dialogTitle;
    }

    public String cBp() {
        return this.jCt;
    }

    public b cBq() {
        return this.jCu;
    }

    public MetaData cBr() {
        return this.jCv;
    }

    public void a(DataRes dataRes) {
        if (dataRes != null) {
            this.dialogTitle = dataRes.publish_user;
            this.jCt = dataRes.publish_pic;
            this.jCv = new MetaData();
            this.jCv.parserProtobuf(dataRes.author);
            this.jCv.setPendantData(null);
            this.jCu = new b();
            this.jCu.a(TbadkCoreApplication.getInst(), dataRes.thread_info);
        }
    }
}
