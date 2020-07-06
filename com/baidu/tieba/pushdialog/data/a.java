package com.baidu.tieba.pushdialog.data;

import com.baidu.tbadk.core.TbadkCoreApplication;
import com.baidu.tbadk.core.data.MetaData;
import tbclient.GetLockWindowMsg.DataRes;
/* loaded from: classes8.dex */
public class a {
    private String dialogTitle;
    private String lbc;
    private b lbd;
    private MetaData lbe;

    public String cXP() {
        return this.dialogTitle;
    }

    public String cXQ() {
        return this.lbc;
    }

    public b cXR() {
        return this.lbd;
    }

    public MetaData cXS() {
        return this.lbe;
    }

    public void a(DataRes dataRes) {
        if (dataRes != null) {
            this.dialogTitle = dataRes.publish_user;
            this.lbc = dataRes.publish_pic;
            this.lbe = new MetaData();
            this.lbe.parserProtobuf(dataRes.author);
            this.lbe.setPendantData(null);
            this.lbd = new b();
            this.lbd.a(TbadkCoreApplication.getInst(), dataRes.thread_info);
        }
    }
}
