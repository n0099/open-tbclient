package com.baidu.tieba.pb.pb.report;

import com.baidu.adp.framework.message.HttpMessage;
import com.baidu.tbadk.core.frameworkData.CmdConfigHttp;
/* loaded from: classes3.dex */
public class UEGReportRequestMessage extends HttpMessage {
    public String mPid;
    public String mTUid;

    public UEGReportRequestMessage() {
        super(CmdConfigHttp.CMD_UEG_REPORT);
    }

    public String getPid() {
        return this.mPid;
    }

    public String getTUid() {
        return this.mTUid;
    }

    public void setPid(String str) {
        addParam("category", 1);
        addParam("pid", str);
        this.mPid = str;
    }

    public void setTUid(String str) {
        addParam("category", 3);
        addParam("tuid", str);
        this.mTUid = str;
    }
}
