package com.baidu.tieba.imMessageCenter;

import com.baidu.live.tbadk.core.frameworkdata.CmdConfigCustom;
import com.baidu.tieba.im.message.LoadHistoryMessage;
/* loaded from: classes6.dex */
public class LoadPersonalHistoryMessage extends LoadHistoryMessage {
    public LoadPersonalHistoryMessage(LoadHistoryMessage.a aVar) {
        super(CmdConfigCustom.CMD_LOAD_HISTORY_PERSONAL, aVar);
    }
}
