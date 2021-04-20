package com.baidu.tieba.setting.im.more;

import android.text.TextUtils;
import com.baidu.adp.framework.message.HttpMessage;
import com.baidu.tbadk.core.frameworkData.CmdConfigHttp;
/* loaded from: classes4.dex */
public class PrivacySettingMessage extends HttpMessage {
    public String opt;
    public int val;

    public PrivacySettingMessage(String str, int i) {
        super(CmdConfigHttp.SET_PRIVATE_CMD);
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

    public void setTid(String str) {
        if (TextUtils.isEmpty(str)) {
            return;
        }
        addParam("tid", str);
    }
}
