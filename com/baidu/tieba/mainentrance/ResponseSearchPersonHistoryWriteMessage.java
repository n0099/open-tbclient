package com.baidu.tieba.mainentrance;

import com.baidu.adp.framework.message.CustomResponsedMessage;
import com.baidu.tbadk.core.frameworkData.CmdConfigCustom;
/* loaded from: classes.dex */
public class ResponseSearchPersonHistoryWriteMessage extends CustomResponsedMessage<Object> {
    public ResponseSearchPersonHistoryWriteMessage() {
        super(CmdConfigCustom.CMD_WRITE_SEARCHPERSON_HISTORY);
    }
}
