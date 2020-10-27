package com.baidu.tieba.pushdialog.data;

import com.baidu.tbadk.core.TbadkCoreApplication;
import com.baidu.tbadk.core.data.MetaData;
import tbclient.GetLockWindowMsg.DataRes;
/* loaded from: classes21.dex */
public class a {
    private String dialogTitle;
    private String mjC;
    private b mjD;
    private MetaData mjE;

    public String dwC() {
        return this.dialogTitle;
    }

    public String dwD() {
        return this.mjC;
    }

    public b dwE() {
        return this.mjD;
    }

    public MetaData dwF() {
        return this.mjE;
    }

    public void a(DataRes dataRes) {
        if (dataRes != null) {
            this.dialogTitle = dataRes.publish_user;
            this.mjC = dataRes.publish_pic;
            this.mjE = new MetaData();
            this.mjE.parserProtobuf(dataRes.author);
            this.mjE.setPendantData(null);
            this.mjD = new b();
            this.mjD.a(TbadkCoreApplication.getInst(), dataRes.thread_info);
        }
    }
}
