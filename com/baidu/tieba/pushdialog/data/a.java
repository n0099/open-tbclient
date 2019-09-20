package com.baidu.tieba.pushdialog.data;

import com.baidu.tbadk.core.TbadkCoreApplication;
import com.baidu.tbadk.core.data.MetaData;
import tbclient.GetLockWindowMsg.DataRes;
/* loaded from: classes3.dex */
public class a {
    private String dialogTitle;
    private String iFW;
    private b iFX;
    private MetaData iFY;

    public String chH() {
        return this.dialogTitle;
    }

    public String chI() {
        return this.iFW;
    }

    public b chJ() {
        return this.iFX;
    }

    public MetaData chK() {
        return this.iFY;
    }

    public void a(DataRes dataRes) {
        if (dataRes != null) {
            this.dialogTitle = dataRes.publish_user;
            this.iFW = dataRes.publish_pic;
            this.iFY = new MetaData();
            this.iFY.parserProtobuf(dataRes.author);
            this.iFY.setPendantData(null);
            this.iFX = new b();
            this.iFX.a(TbadkCoreApplication.getInst(), dataRes.thread_info);
        }
    }
}
