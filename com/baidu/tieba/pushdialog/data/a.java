package com.baidu.tieba.pushdialog.data;

import com.baidu.tbadk.core.TbadkCoreApplication;
import com.baidu.tbadk.core.data.MetaData;
import tbclient.GetLockWindowMsg.DataRes;
/* loaded from: classes3.dex */
public class a {
    private String gIv;
    private String gIw;
    private b gIx;
    private MetaData gIy;

    public String btz() {
        return this.gIv;
    }

    public String btA() {
        return this.gIw;
    }

    public b btB() {
        return this.gIx;
    }

    public MetaData btC() {
        return this.gIy;
    }

    public void a(DataRes dataRes) {
        if (dataRes != null) {
            this.gIv = dataRes.publish_user;
            this.gIw = dataRes.publish_pic;
            this.gIy = new MetaData();
            this.gIy.parserProtobuf(dataRes.author);
            this.gIy.setPendantData(null);
            this.gIx = new b();
            this.gIx.a(TbadkCoreApplication.getInst(), dataRes.thread_info);
        }
    }
}
