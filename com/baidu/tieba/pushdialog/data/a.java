package com.baidu.tieba.pushdialog.data;

import com.baidu.tbadk.core.TbadkCoreApplication;
import com.baidu.tbadk.core.data.MetaData;
import tbclient.GetLockWindowMsg.DataRes;
/* loaded from: classes7.dex */
public class a {
    private String dialogTitle;
    private String mEK;
    private b mEL;
    private MetaData mEM;

    public String dzU() {
        return this.dialogTitle;
    }

    public String dzV() {
        return this.mEK;
    }

    public b dzW() {
        return this.mEL;
    }

    public MetaData dzX() {
        return this.mEM;
    }

    public void a(DataRes dataRes) {
        if (dataRes != null) {
            this.dialogTitle = dataRes.publish_user;
            this.mEK = dataRes.publish_pic;
            this.mEM = new MetaData();
            this.mEM.parserProtobuf(dataRes.author);
            this.mEM.setPendantData(null);
            this.mEL = new b();
            this.mEL.a(TbadkCoreApplication.getInst(), dataRes.thread_info);
        }
    }
}
