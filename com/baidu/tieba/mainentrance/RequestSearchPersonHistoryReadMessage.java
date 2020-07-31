package com.baidu.tieba.mainentrance;

import com.baidu.adp.framework.message.CustomMessage;
import com.baidu.live.tbadk.core.frameworkdata.CmdConfigCustom;
/* loaded from: classes18.dex */
public class RequestSearchPersonHistoryReadMessage extends CustomMessage<Object> {
    public RequestSearchPersonHistoryReadMessage() {
        super(CmdConfigCustom.CMD_READ_SEARCHPERSON_HISTORY);
    }
}
