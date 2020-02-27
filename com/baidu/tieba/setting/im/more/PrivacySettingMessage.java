package com.baidu.tieba.setting.im.more;

import com.baidu.adp.framework.message.HttpMessage;
/* loaded from: classes13.dex */
public class PrivacySettingMessage extends HttpMessage {
    private String opt;
    private int val;

    public PrivacySettingMessage(String str, int i) {
        super(1001506);
        this.opt = str;
        this.val = i;
        addParam("opt", str);
        addParam("val", String.valueOf(i));
    }

    public String getOperation() {
        return this.opt;
    }

    public int getType() {
        return this.val;
    }
}
