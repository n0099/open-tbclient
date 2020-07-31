package com.baidu.tieba.setting.im.more;

import com.baidu.adp.framework.message.HttpMessage;
import com.baidu.searchbox.ugc.model.UgcConstant;
/* loaded from: classes20.dex */
public class PrivacySettingMessage extends HttpMessage {
    private String opt;
    private int val;

    public PrivacySettingMessage(String str, int i) {
        super(1001506);
        this.opt = str;
        this.val = i;
        addParam(UgcConstant.UGC_TAG_OPTION, str);
        addParam("val", String.valueOf(i));
    }

    public String getOperation() {
        return this.opt;
    }

    public int getType() {
        return this.val;
    }
}
