package com.baidu.tieba.pushdialog.data;

import com.baidu.tbadk.core.TbadkCoreApplication;
import com.baidu.tbadk.core.data.MetaData;
import tbclient.GetLockWindowMsg.DataRes;
/* loaded from: classes3.dex */
public class a {
    private String gsD;
    private String gsE;
    private b gsF;
    private MetaData gsG;

    public String boW() {
        return this.gsD;
    }

    public String boX() {
        return this.gsE;
    }

    public b boY() {
        return this.gsF;
    }

    public MetaData boZ() {
        return this.gsG;
    }

    public void a(DataRes dataRes) {
        if (dataRes != null) {
            this.gsD = dataRes.publish_user;
            this.gsE = dataRes.publish_pic;
            this.gsG = new MetaData();
            this.gsG.parserProtobuf(dataRes.author);
            this.gsG.setPendantData(null);
            this.gsF = new b();
            this.gsF.a(TbadkCoreApplication.getInst(), dataRes.thread_info);
        }
    }
}
