package com.baidu.tieba.pushdialog.data;

import com.baidu.tbadk.core.TbadkCoreApplication;
import com.baidu.tbadk.core.data.MetaData;
import tbclient.GetLockWindowMsg.DataRes;
/* loaded from: classes3.dex */
public class a {
    private String iwj;
    private String iwk;
    private b iwl;
    private MetaData iwm;

    public String cdK() {
        return this.iwj;
    }

    public String cdL() {
        return this.iwk;
    }

    public b cdM() {
        return this.iwl;
    }

    public MetaData cdN() {
        return this.iwm;
    }

    public void a(DataRes dataRes) {
        if (dataRes != null) {
            this.iwj = dataRes.publish_user;
            this.iwk = dataRes.publish_pic;
            this.iwm = new MetaData();
            this.iwm.parserProtobuf(dataRes.author);
            this.iwm.setPendantData(null);
            this.iwl = new b();
            this.iwl.a(TbadkCoreApplication.getInst(), dataRes.thread_info);
        }
    }
}
