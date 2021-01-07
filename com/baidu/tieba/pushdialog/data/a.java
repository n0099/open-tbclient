package com.baidu.tieba.pushdialog.data;

import com.baidu.tbadk.core.TbadkCoreApplication;
import com.baidu.tbadk.core.data.MetaData;
import tbclient.GetLockWindowMsg.DataRes;
/* loaded from: classes8.dex */
public class a {
    private String dialogTitle;
    private String mJu;
    private b mJv;
    private MetaData mJw;

    public String dDM() {
        return this.dialogTitle;
    }

    public String dDN() {
        return this.mJu;
    }

    public b dDO() {
        return this.mJv;
    }

    public MetaData dDP() {
        return this.mJw;
    }

    public void a(DataRes dataRes) {
        if (dataRes != null) {
            this.dialogTitle = dataRes.publish_user;
            this.mJu = dataRes.publish_pic;
            this.mJw = new MetaData();
            this.mJw.parserProtobuf(dataRes.author);
            this.mJw.setPendantData(null);
            this.mJv = new b();
            this.mJv.a(TbadkCoreApplication.getInst(), dataRes.thread_info);
        }
    }
}
