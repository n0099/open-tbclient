package com.baidu.tieba.pushdialog.data;

import com.baidu.tbadk.core.TbadkCoreApplication;
import com.baidu.tbadk.core.data.MetaData;
import tbclient.GetLockWindowMsg.DataRes;
/* loaded from: classes3.dex */
public class a {
    private String gLm;
    private String gLn;
    private b gLo;
    private MetaData gLp;

    public String bul() {
        return this.gLm;
    }

    public String bum() {
        return this.gLn;
    }

    public b bun() {
        return this.gLo;
    }

    public MetaData buo() {
        return this.gLp;
    }

    public void a(DataRes dataRes) {
        if (dataRes != null) {
            this.gLm = dataRes.publish_user;
            this.gLn = dataRes.publish_pic;
            this.gLp = new MetaData();
            this.gLp.parserProtobuf(dataRes.author);
            this.gLp.setPendantData(null);
            this.gLo = new b();
            this.gLo.a(TbadkCoreApplication.getInst(), dataRes.thread_info);
        }
    }
}
