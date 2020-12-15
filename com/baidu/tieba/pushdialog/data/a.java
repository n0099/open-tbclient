package com.baidu.tieba.pushdialog.data;

import com.baidu.tbadk.core.TbadkCoreApplication;
import com.baidu.tbadk.core.data.MetaData;
import tbclient.GetLockWindowMsg.DataRes;
/* loaded from: classes21.dex */
public class a {
    private String dialogTitle;
    private String mEc;
    private b mEd;
    private MetaData mEe;

    public String dDW() {
        return this.dialogTitle;
    }

    public String dDX() {
        return this.mEc;
    }

    public b dDY() {
        return this.mEd;
    }

    public MetaData dDZ() {
        return this.mEe;
    }

    public void a(DataRes dataRes) {
        if (dataRes != null) {
            this.dialogTitle = dataRes.publish_user;
            this.mEc = dataRes.publish_pic;
            this.mEe = new MetaData();
            this.mEe.parserProtobuf(dataRes.author);
            this.mEe.setPendantData(null);
            this.mEd = new b();
            this.mEd.a(TbadkCoreApplication.getInst(), dataRes.thread_info);
        }
    }
}
