package com.baidu.tieba.pushdialog.data;

import com.baidu.tbadk.core.TbadkCoreApplication;
import com.baidu.tbadk.core.data.MetaData;
import tbclient.GetLockWindowMsg.DataRes;
/* loaded from: classes15.dex */
public class a {
    private String dialogTitle;
    private String lyM;
    private b lyN;
    private MetaData lyO;

    public String dma() {
        return this.dialogTitle;
    }

    public String dmb() {
        return this.lyM;
    }

    public b dmc() {
        return this.lyN;
    }

    public MetaData dmd() {
        return this.lyO;
    }

    public void a(DataRes dataRes) {
        if (dataRes != null) {
            this.dialogTitle = dataRes.publish_user;
            this.lyM = dataRes.publish_pic;
            this.lyO = new MetaData();
            this.lyO.parserProtobuf(dataRes.author);
            this.lyO.setPendantData(null);
            this.lyN = new b();
            this.lyN.a(TbadkCoreApplication.getInst(), dataRes.thread_info);
        }
    }
}
