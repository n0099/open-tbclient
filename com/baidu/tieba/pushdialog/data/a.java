package com.baidu.tieba.pushdialog.data;

import com.baidu.tbadk.core.TbadkCoreApplication;
import com.baidu.tbadk.core.data.MetaData;
import tbclient.GetLockWindowMsg.DataRes;
/* loaded from: classes3.dex */
public class a {
    private String iwf;
    private String iwg;
    private b iwh;
    private MetaData iwi;

    public String cdG() {
        return this.iwf;
    }

    public String cdH() {
        return this.iwg;
    }

    public b cdI() {
        return this.iwh;
    }

    public MetaData cdJ() {
        return this.iwi;
    }

    public void a(DataRes dataRes) {
        if (dataRes != null) {
            this.iwf = dataRes.publish_user;
            this.iwg = dataRes.publish_pic;
            this.iwi = new MetaData();
            this.iwi.parserProtobuf(dataRes.author);
            this.iwi.setPendantData(null);
            this.iwh = new b();
            this.iwh.a(TbadkCoreApplication.getInst(), dataRes.thread_info);
        }
    }
}
