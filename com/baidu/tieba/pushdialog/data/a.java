package com.baidu.tieba.pushdialog.data;

import com.baidu.tbadk.core.TbadkCoreApplication;
import com.baidu.tbadk.core.data.MetaData;
import tbclient.GetLockWindowMsg.DataRes;
/* loaded from: classes8.dex */
public class a {
    private String dialogTitle;
    private String jEg;
    private b jEh;
    private MetaData jEi;

    public String cBL() {
        return this.dialogTitle;
    }

    public String cBM() {
        return this.jEg;
    }

    public b cBN() {
        return this.jEh;
    }

    public MetaData cBO() {
        return this.jEi;
    }

    public void a(DataRes dataRes) {
        if (dataRes != null) {
            this.dialogTitle = dataRes.publish_user;
            this.jEg = dataRes.publish_pic;
            this.jEi = new MetaData();
            this.jEi.parserProtobuf(dataRes.author);
            this.jEi.setPendantData(null);
            this.jEh = new b();
            this.jEh.a(TbadkCoreApplication.getInst(), dataRes.thread_info);
        }
    }
}
