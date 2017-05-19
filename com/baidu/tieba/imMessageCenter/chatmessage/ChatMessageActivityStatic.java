package com.baidu.tieba.imMessageCenter.chatmessage;

import com.baidu.tbadk.core.TbadkCoreApplication;
import com.baidu.tbadk.core.atomData.ChatMessageActivityConfig;
import com.baidu.tbadk.core.util.bb;
/* loaded from: classes2.dex */
public class ChatMessageActivityStatic {
    static {
        TbadkCoreApplication.m9getInst().RegisterIntent(ChatMessageActivityConfig.class, ChatMessageActivity.class);
        Jy();
    }

    private static void Jy() {
        bb.vB().a(new b());
    }
}
