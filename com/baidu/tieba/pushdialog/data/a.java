package com.baidu.tieba.pushdialog.data;

import com.baidu.tbadk.core.TbadkCoreApplication;
import com.baidu.tbadk.core.data.MetaData;
import tbclient.GetLockWindowMsg.DataRes;
/* loaded from: classes3.dex */
public class a {
    private String idD;
    private String idE;
    private b idF;
    private MetaData idG;

    public String bVF() {
        return this.idD;
    }

    public String bVG() {
        return this.idE;
    }

    public b bVH() {
        return this.idF;
    }

    public MetaData bVI() {
        return this.idG;
    }

    public void a(DataRes dataRes) {
        if (dataRes != null) {
            this.idD = dataRes.publish_user;
            this.idE = dataRes.publish_pic;
            this.idG = new MetaData();
            this.idG.parserProtobuf(dataRes.author);
            this.idG.setPendantData(null);
            this.idF = new b();
            this.idF.a(TbadkCoreApplication.getInst(), dataRes.thread_info);
        }
    }
}
