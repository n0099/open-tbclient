package com.baidu.tieba.pushdialog.data;

import com.baidu.tbadk.core.TbadkCoreApplication;
import com.baidu.tbadk.core.data.MetaData;
import tbclient.GetLockWindowMsg.DataRes;
/* loaded from: classes8.dex */
public class a {
    private String dialogTitle;
    private String mJv;
    private b mJw;
    private MetaData mJx;

    public String dDL() {
        return this.dialogTitle;
    }

    public String dDM() {
        return this.mJv;
    }

    public b dDN() {
        return this.mJw;
    }

    public MetaData dDO() {
        return this.mJx;
    }

    public void a(DataRes dataRes) {
        if (dataRes != null) {
            this.dialogTitle = dataRes.publish_user;
            this.mJv = dataRes.publish_pic;
            this.mJx = new MetaData();
            this.mJx.parserProtobuf(dataRes.author);
            this.mJx.setPendantData(null);
            this.mJw = new b();
            this.mJw.a(TbadkCoreApplication.getInst(), dataRes.thread_info);
        }
    }
}
