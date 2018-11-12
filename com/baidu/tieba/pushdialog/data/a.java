package com.baidu.tieba.pushdialog.data;

import com.baidu.tbadk.core.TbadkCoreApplication;
import com.baidu.tbadk.core.data.MetaData;
import tbclient.GetLockWindowMsg.DataRes;
/* loaded from: classes3.dex */
public class a {
    private String gBF;
    private String gBG;
    private b gBH;
    private MetaData gBI;

    public String brH() {
        return this.gBF;
    }

    public String brI() {
        return this.gBG;
    }

    public b brJ() {
        return this.gBH;
    }

    public MetaData brK() {
        return this.gBI;
    }

    public void a(DataRes dataRes) {
        if (dataRes != null) {
            this.gBF = dataRes.publish_user;
            this.gBG = dataRes.publish_pic;
            this.gBI = new MetaData();
            this.gBI.parserProtobuf(dataRes.author);
            this.gBI.setPendantData(null);
            this.gBH = new b();
            this.gBH.a(TbadkCoreApplication.getInst(), dataRes.thread_info);
        }
    }
}
