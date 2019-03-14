package com.baidu.tieba.pushdialog.data;

import com.baidu.tbadk.core.TbadkCoreApplication;
import com.baidu.tbadk.core.data.MetaData;
import tbclient.GetLockWindowMsg.DataRes;
/* loaded from: classes3.dex */
public class a {
    private String idQ;
    private String idR;
    private b idS;
    private MetaData idT;

    public String bVJ() {
        return this.idQ;
    }

    public String bVK() {
        return this.idR;
    }

    public b bVL() {
        return this.idS;
    }

    public MetaData bVM() {
        return this.idT;
    }

    public void a(DataRes dataRes) {
        if (dataRes != null) {
            this.idQ = dataRes.publish_user;
            this.idR = dataRes.publish_pic;
            this.idT = new MetaData();
            this.idT.parserProtobuf(dataRes.author);
            this.idT.setPendantData(null);
            this.idS = new b();
            this.idS.a(TbadkCoreApplication.getInst(), dataRes.thread_info);
        }
    }
}
