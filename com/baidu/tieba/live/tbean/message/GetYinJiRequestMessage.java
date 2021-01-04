package com.baidu.tieba.live.tbean.message;

import com.baidu.live.adp.framework.message.HttpMessage;
import com.baidu.live.tbadk.extraparams.ExtraParamsManager;
/* loaded from: classes11.dex */
public class GetYinJiRequestMessage extends HttpMessage {
    private String st_type;

    public GetYinJiRequestMessage() {
        super(1001533);
    }

    public String getSt_type() {
        this.st_type = "st_type";
        return this.st_type;
    }

    public void setSt_type(String str) {
        this.st_type = str;
    }

    public void setParams() {
        addParam("st_type", getSt_type());
        String baiduzid = ExtraParamsManager.getBaiduzid();
        if (baiduzid != null) {
            addParam("zid", baiduzid);
        }
    }
}
