package com.baidu.tieba.imMessageCenter;

import com.baidu.live.tbadk.core.frameworkdata.CmdConfigCustom;
import com.baidu.tieba.im.message.SaveDraftMessage;
/* loaded from: classes2.dex */
public class PersonalSaveDraftMessage extends SaveDraftMessage {
    public PersonalSaveDraftMessage(SaveDraftMessage.a aVar) {
        super(CmdConfigCustom.CMD_SAVE_DRAFT_PERSONAL, aVar);
    }
}
