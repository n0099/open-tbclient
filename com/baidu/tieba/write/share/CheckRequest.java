package com.baidu.tieba.write.share;

import com.baidu.adp.framework.message.HttpMessage;
import com.baidu.adp.lib.util.StringUtils;
import com.baidu.tbadk.core.frameworkData.CmdConfigHttp;
/* loaded from: classes8.dex */
public class CheckRequest extends HttpMessage {
    public CheckRequest() {
        super(CmdConfigHttp.CMD_CHECK_SHARE_SDK);
    }

    public void setAppkey(String str) {
        if (!StringUtils.isNull(str)) {
            addParam("tbopen_app_key", str);
        }
    }

    public void setAppletsKey(String str) {
        if (!StringUtils.isNull(str)) {
            addParam("swan_app_key", str);
        }
    }
}
