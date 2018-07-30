package com.baidu.tieba.pushdialog.data;

import com.baidu.tbadk.core.TbadkCoreApplication;
import com.baidu.tbadk.core.data.MetaData;
import tbclient.GetLockWindowMsg.DataRes;
/* loaded from: classes3.dex */
public class a {
    private String gli;
    private String glj;
    private b glk;
    private MetaData gll;

    public String bmp() {
        return this.gli;
    }

    public String bmq() {
        return this.glj;
    }

    public b bmr() {
        return this.glk;
    }

    public MetaData bms() {
        return this.gll;
    }

    public void a(DataRes dataRes) {
        if (dataRes != null) {
            this.gli = dataRes.publish_user;
            this.glj = dataRes.publish_pic;
            this.gll = new MetaData();
            this.gll.parserProtobuf(dataRes.author);
            this.gll.setPendantData(null);
            this.glk = new b();
            this.glk.a(TbadkCoreApplication.getInst(), dataRes.thread_info);
        }
    }
}
