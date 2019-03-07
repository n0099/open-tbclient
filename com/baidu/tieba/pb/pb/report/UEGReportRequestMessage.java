package com.baidu.tieba.pb.pb.report;

import com.baidu.adp.framework.message.HttpMessage;
import com.baidu.appsearchlib.Info;
import com.baidu.tbadk.core.frameworkData.CmdConfigHttp;
/* loaded from: classes4.dex */
public class UEGReportRequestMessage extends HttpMessage {
    private String mPid;
    private String mTUid;

    public UEGReportRequestMessage() {
        super(CmdConfigHttp.CMD_UEG_REPORT);
    }

    public String getPid() {
        return this.mPid;
    }

    public void setPid(String str) {
        addParam("category", 1);
        addParam(Info.kBaiduPIDKey, str);
        this.mPid = str;
    }

    public String getTUid() {
        return this.mTUid;
    }

    public void setTUid(String str) {
        addParam("category", 3);
        addParam("tuid", str);
        this.mTUid = str;
    }
}
