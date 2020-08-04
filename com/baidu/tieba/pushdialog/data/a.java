package com.baidu.tieba.pushdialog.data;

import com.baidu.tbadk.core.TbadkCoreApplication;
import com.baidu.tbadk.core.data.MetaData;
import tbclient.GetLockWindowMsg.DataRes;
/* loaded from: classes15.dex */
public class a {
    private String dialogTitle;
    private String lit;
    private b liu;
    private MetaData liv;

    public String daW() {
        return this.dialogTitle;
    }

    public String daX() {
        return this.lit;
    }

    public b daY() {
        return this.liu;
    }

    public MetaData daZ() {
        return this.liv;
    }

    public void a(DataRes dataRes) {
        if (dataRes != null) {
            this.dialogTitle = dataRes.publish_user;
            this.lit = dataRes.publish_pic;
            this.liv = new MetaData();
            this.liv.parserProtobuf(dataRes.author);
            this.liv.setPendantData(null);
            this.liu = new b();
            this.liu.a(TbadkCoreApplication.getInst(), dataRes.thread_info);
        }
    }
}
