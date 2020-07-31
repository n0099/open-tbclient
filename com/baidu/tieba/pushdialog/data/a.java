package com.baidu.tieba.pushdialog.data;

import com.baidu.tbadk.core.TbadkCoreApplication;
import com.baidu.tbadk.core.data.MetaData;
import tbclient.GetLockWindowMsg.DataRes;
/* loaded from: classes15.dex */
public class a {
    private String dialogTitle;
    private String lir;
    private b lis;
    private MetaData lit;

    public String daW() {
        return this.dialogTitle;
    }

    public String daX() {
        return this.lir;
    }

    public b daY() {
        return this.lis;
    }

    public MetaData daZ() {
        return this.lit;
    }

    public void a(DataRes dataRes) {
        if (dataRes != null) {
            this.dialogTitle = dataRes.publish_user;
            this.lir = dataRes.publish_pic;
            this.lit = new MetaData();
            this.lit.parserProtobuf(dataRes.author);
            this.lit.setPendantData(null);
            this.lis = new b();
            this.lis.a(TbadkCoreApplication.getInst(), dataRes.thread_info);
        }
    }
}
