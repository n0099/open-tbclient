package com.baidu.tieba.pushdialog.data;

import com.baidu.tbadk.core.TbadkCoreApplication;
import com.baidu.tbadk.core.data.MetaData;
import tbclient.GetLockWindowMsg.DataRes;
/* loaded from: classes3.dex */
public class a {
    private String idW;
    private String idX;
    private b idY;
    private MetaData idZ;

    public String bVH() {
        return this.idW;
    }

    public String bVI() {
        return this.idX;
    }

    public b bVJ() {
        return this.idY;
    }

    public MetaData bVK() {
        return this.idZ;
    }

    public void a(DataRes dataRes) {
        if (dataRes != null) {
            this.idW = dataRes.publish_user;
            this.idX = dataRes.publish_pic;
            this.idZ = new MetaData();
            this.idZ.parserProtobuf(dataRes.author);
            this.idZ.setPendantData(null);
            this.idY = new b();
            this.idY.a(TbadkCoreApplication.getInst(), dataRes.thread_info);
        }
    }
}
