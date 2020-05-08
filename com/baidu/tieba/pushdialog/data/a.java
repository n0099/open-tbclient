package com.baidu.tieba.pushdialog.data;

import com.baidu.tbadk.core.TbadkCoreApplication;
import com.baidu.tbadk.core.data.MetaData;
import tbclient.GetLockWindowMsg.DataRes;
/* loaded from: classes8.dex */
public class a {
    private String dialogTitle;
    private String kod;
    private b koe;
    private MetaData kof;

    public String cMh() {
        return this.dialogTitle;
    }

    public String cMi() {
        return this.kod;
    }

    public b cMj() {
        return this.koe;
    }

    public MetaData cMk() {
        return this.kof;
    }

    public void a(DataRes dataRes) {
        if (dataRes != null) {
            this.dialogTitle = dataRes.publish_user;
            this.kod = dataRes.publish_pic;
            this.kof = new MetaData();
            this.kof.parserProtobuf(dataRes.author);
            this.kof.setPendantData(null);
            this.koe = new b();
            this.koe.a(TbadkCoreApplication.getInst(), dataRes.thread_info);
        }
    }
}
