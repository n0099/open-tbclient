package com.baidu.tieba.mainentrance;

import com.baidu.adp.framework.message.CustomResponsedMessage;
import com.baidu.live.tbadk.core.frameworkdata.CmdConfigCustom;
/* loaded from: classes23.dex */
public class ResponseSearchPersonHistoryWriteMessage extends CustomResponsedMessage<Object> {
    public ResponseSearchPersonHistoryWriteMessage() {
        super(CmdConfigCustom.CMD_WRITE_SEARCHPERSON_HISTORY);
    }
}
