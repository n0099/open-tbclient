package com.baidu.tieba.mainentrance;

import com.baidu.adp.framework.message.CustomMessage;
import com.baidu.tbadk.core.frameworkData.CmdConfigCustom;
/* loaded from: classes.dex */
public class RequestSearchPersonHistoryWriteMessage extends CustomMessage<Object> {
    private boolean isclear;

    public RequestSearchPersonHistoryWriteMessage() {
        super(CmdConfigCustom.CMD_WRITE_SEARCHPERSON_HISTORY);
        this.isclear = false;
    }

    public boolean isClear() {
        return this.isclear;
    }

    public void setClear(boolean z) {
        this.isclear = z;
    }
}
