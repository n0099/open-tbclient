package com.baidu.tieba.pushdialog.data;

import com.baidu.tbadk.core.TbadkCoreApplication;
import com.baidu.tbadk.core.data.MetaData;
import tbclient.GetLockWindowMsg.DataRes;
/* loaded from: classes3.dex */
public class a {
    private String iwi;
    private String iwj;
    private b iwk;
    private MetaData iwl;

    public String cdJ() {
        return this.iwi;
    }

    public String cdK() {
        return this.iwj;
    }

    public b cdL() {
        return this.iwk;
    }

    public MetaData cdM() {
        return this.iwl;
    }

    public void a(DataRes dataRes) {
        if (dataRes != null) {
            this.iwi = dataRes.publish_user;
            this.iwj = dataRes.publish_pic;
            this.iwl = new MetaData();
            this.iwl.parserProtobuf(dataRes.author);
            this.iwl.setPendantData(null);
            this.iwk = new b();
            this.iwk.a(TbadkCoreApplication.getInst(), dataRes.thread_info);
        }
    }
}
