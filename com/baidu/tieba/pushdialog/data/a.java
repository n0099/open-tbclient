package com.baidu.tieba.pushdialog.data;

import com.baidu.tbadk.core.TbadkCoreApplication;
import com.baidu.tbadk.core.data.MetaData;
import tbclient.GetLockWindowMsg.DataRes;
/* loaded from: classes8.dex */
public class a {
    private String dialogTitle;
    private String knZ;
    private b koa;
    private MetaData kob;

    public String cMk() {
        return this.dialogTitle;
    }

    public String cMl() {
        return this.knZ;
    }

    public b cMm() {
        return this.koa;
    }

    public MetaData cMn() {
        return this.kob;
    }

    public void a(DataRes dataRes) {
        if (dataRes != null) {
            this.dialogTitle = dataRes.publish_user;
            this.knZ = dataRes.publish_pic;
            this.kob = new MetaData();
            this.kob.parserProtobuf(dataRes.author);
            this.kob.setPendantData(null);
            this.koa = new b();
            this.koa.a(TbadkCoreApplication.getInst(), dataRes.thread_info);
        }
    }
}
