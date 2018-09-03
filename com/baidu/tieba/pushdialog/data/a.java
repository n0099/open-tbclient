package com.baidu.tieba.pushdialog.data;

import com.baidu.tbadk.core.TbadkCoreApplication;
import com.baidu.tbadk.core.data.MetaData;
import tbclient.GetLockWindowMsg.DataRes;
/* loaded from: classes3.dex */
public class a {
    private String gll;
    private String glm;
    private b gln;
    private MetaData glo;

    public String bmp() {
        return this.gll;
    }

    public String bmq() {
        return this.glm;
    }

    public b bmr() {
        return this.gln;
    }

    public MetaData bms() {
        return this.glo;
    }

    public void a(DataRes dataRes) {
        if (dataRes != null) {
            this.gll = dataRes.publish_user;
            this.glm = dataRes.publish_pic;
            this.glo = new MetaData();
            this.glo.parserProtobuf(dataRes.author);
            this.glo.setPendantData(null);
            this.gln = new b();
            this.gln.a(TbadkCoreApplication.getInst(), dataRes.thread_info);
        }
    }
}
