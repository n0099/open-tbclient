package com.baidu.tieba.pushdialog.data;

import com.baidu.tbadk.core.TbadkCoreApplication;
import com.baidu.tbadk.core.data.MetaData;
import tbclient.GetLockWindowMsg.DataRes;
/* loaded from: classes15.dex */
public class a {
    private String dialogTitle;
    private String lyX;
    private b lyY;
    private MetaData lyZ;

    public String dmd() {
        return this.dialogTitle;
    }

    public String dme() {
        return this.lyX;
    }

    public b dmf() {
        return this.lyY;
    }

    public MetaData dmg() {
        return this.lyZ;
    }

    public void a(DataRes dataRes) {
        if (dataRes != null) {
            this.dialogTitle = dataRes.publish_user;
            this.lyX = dataRes.publish_pic;
            this.lyZ = new MetaData();
            this.lyZ.parserProtobuf(dataRes.author);
            this.lyZ.setPendantData(null);
            this.lyY = new b();
            this.lyY.a(TbadkCoreApplication.getInst(), dataRes.thread_info);
        }
    }
}
