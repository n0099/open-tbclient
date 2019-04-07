package com.baidu.tieba.pushdialog.data;

import com.baidu.tbadk.core.TbadkCoreApplication;
import com.baidu.tbadk.core.data.MetaData;
import tbclient.GetLockWindowMsg.DataRes;
/* loaded from: classes3.dex */
public class a {
    private String idC;
    private String idD;
    private b idE;
    private MetaData idF;

    public String bVF() {
        return this.idC;
    }

    public String bVG() {
        return this.idD;
    }

    public b bVH() {
        return this.idE;
    }

    public MetaData bVI() {
        return this.idF;
    }

    public void a(DataRes dataRes) {
        if (dataRes != null) {
            this.idC = dataRes.publish_user;
            this.idD = dataRes.publish_pic;
            this.idF = new MetaData();
            this.idF.parserProtobuf(dataRes.author);
            this.idF.setPendantData(null);
            this.idE = new b();
            this.idE.a(TbadkCoreApplication.getInst(), dataRes.thread_info);
        }
    }
}
