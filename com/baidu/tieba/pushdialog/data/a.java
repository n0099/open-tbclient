package com.baidu.tieba.pushdialog.data;

import com.baidu.tbadk.core.TbadkCoreApplication;
import com.baidu.tbadk.core.data.MetaData;
import tbclient.GetLockWindowMsg.DataRes;
/* loaded from: classes3.dex */
public class a {
    private String idV;
    private String idW;
    private b idX;
    private MetaData idY;

    public String bVG() {
        return this.idV;
    }

    public String bVH() {
        return this.idW;
    }

    public b bVI() {
        return this.idX;
    }

    public MetaData bVJ() {
        return this.idY;
    }

    public void a(DataRes dataRes) {
        if (dataRes != null) {
            this.idV = dataRes.publish_user;
            this.idW = dataRes.publish_pic;
            this.idY = new MetaData();
            this.idY.parserProtobuf(dataRes.author);
            this.idY.setPendantData(null);
            this.idX = new b();
            this.idX.a(TbadkCoreApplication.getInst(), dataRes.thread_info);
        }
    }
}
