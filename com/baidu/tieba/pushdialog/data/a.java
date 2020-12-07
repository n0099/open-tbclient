package com.baidu.tieba.pushdialog.data;

import com.baidu.tbadk.core.TbadkCoreApplication;
import com.baidu.tbadk.core.data.MetaData;
import tbclient.GetLockWindowMsg.DataRes;
/* loaded from: classes21.dex */
public class a {
    private String dialogTitle;
    private String mEa;
    private b mEb;
    private MetaData mEc;

    public String dDV() {
        return this.dialogTitle;
    }

    public String dDW() {
        return this.mEa;
    }

    public b dDX() {
        return this.mEb;
    }

    public MetaData dDY() {
        return this.mEc;
    }

    public void a(DataRes dataRes) {
        if (dataRes != null) {
            this.dialogTitle = dataRes.publish_user;
            this.mEa = dataRes.publish_pic;
            this.mEc = new MetaData();
            this.mEc.parserProtobuf(dataRes.author);
            this.mEc.setPendantData(null);
            this.mEb = new b();
            this.mEb.a(TbadkCoreApplication.getInst(), dataRes.thread_info);
        }
    }
}
