package com.baidu.tieba.personInfo;

import com.baidu.adp.framework.message.CustomMessage;
import com.baidu.tbadk.core.frameworkData.CmdConfigCustom;
/* loaded from: classes.dex */
public class RequestPersonInfoMessage extends CustomMessage<Object> {
    public RequestPersonInfoMessage() {
        super(CmdConfigCustom.CMD_CACHE_PERSONINFO);
    }
}
