package com.baidu.tieba.pushdialog.data;

import com.baidu.tbadk.core.TbadkCoreApplication;
import com.baidu.tbadk.core.data.MetaData;
import tbclient.GetLockWindowMsg.DataRes;
/* loaded from: classes5.dex */
public class a {
    private String dialogTitle;
    private String jxV;
    private b jxW;
    private MetaData jxX;

    public String cyK() {
        return this.dialogTitle;
    }

    public String cyL() {
        return this.jxV;
    }

    public b cyM() {
        return this.jxW;
    }

    public MetaData cyN() {
        return this.jxX;
    }

    public void a(DataRes dataRes) {
        if (dataRes != null) {
            this.dialogTitle = dataRes.publish_user;
            this.jxV = dataRes.publish_pic;
            this.jxX = new MetaData();
            this.jxX.parserProtobuf(dataRes.author);
            this.jxX.setPendantData(null);
            this.jxW = new b();
            this.jxW.a(TbadkCoreApplication.getInst(), dataRes.thread_info);
        }
    }
}
